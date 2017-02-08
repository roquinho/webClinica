
package Controller;

import br.clinica.entidades.Medicos;
import br.clinica.regraNegocio.ExceptionRegraNegocioBuscarMedicos;
import br.clinica.regraNegocio.ExceptionRegraNegocioCadastrarMedicos;
import br.clinica.regraNegocio.ExceptionRegraNegocioDeletarMedicos;
import br.clinica.regraNegocio.Fachada;
import br.clinica.regraNegocio.FachadaImplementa;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class MedicosServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        if(request.getParameter("cadastro_medico")!=null) {
       
        String nome = request.getParameter("inputNome");
        String telefone = request.getParameter("inputTelefone");
        String cpfString = request.getParameter("inputCpf");
        Long cpf = Long.parseLong(cpfString);
        String especialidade = request.getParameter("inputEspecialidade");
        String crmString = request.getParameter("inputCrm");
        Long  crm = Long.parseLong(crmString);
        String endereco = request.getParameter("inputEndereco");
        
        Medicos medico = new Medicos(cpf, nome, endereco, telefone, crm, especialidade);
       
        Fachada fachada = new FachadaImplementa();
        
        try {
            fachada.cadastrarMedicos(medico); 
            
            request.setAttribute("alerta", "medico cadastrado com sucesso");
            RequestDispatcher view = request.getRequestDispatcher("ViewAlerta.jsp");
            view.forward(request, response);

        } catch (ExceptionRegraNegocioCadastrarMedicos ex) {
            Logger.getLogger(MedicosServlet.class.getName()).log(Level.SEVERE, null, ex);
            
             request.setAttribute("alerta", "erro ao cadastrar "+ex);
            RequestDispatcher view = request.getRequestDispatcher("ViewAlerta.jsp");
            view.forward(request, response);

        }
            }
        
        else if(request.getParameter("deletar_medico")!=null) {
        String cpf = request.getParameter("inputCpf");
        Long cpff = Long.parseLong(cpf);
        
        Fachada fachada = new FachadaImplementa();
            try {
                fachada.deletarMedico(cpff);
                
            request.setAttribute("alerta", "medico deletado com sucesso");
            RequestDispatcher view = request.getRequestDispatcher("ViewAlerta.jsp");
            view.forward(request, response);
            
            } catch (ExceptionRegraNegocioDeletarMedicos ex) {
                Logger.getLogger(MedicosServlet.class.getName()).log(Level.SEVERE, null, ex);
            
            request.setAttribute("alerta", "erro ao deletar "+ex);
            RequestDispatcher view = request.getRequestDispatcher("ViewAlerta.jsp");
            view.forward(request, response);
            }            
        }
        else if(request.getParameter("buscar_medico")!=null) {
            
           String stringCpf = request.getParameter("inputCpf");
           Long cpf = Long.parseLong(stringCpf);
           
           Medicos medico = new Medicos();
           Fachada fachada = new FachadaImplementa();
           
            try {
              medico = fachada.buscarMedicoCpf(cpf);
            } catch (ExceptionRegraNegocioBuscarMedicos ex) {
                Logger.getLogger(MedicosServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            request.setAttribute("buscaMedico", medico);
            RequestDispatcher view = request.getRequestDispatcher("ViewMedicoBusca.jsp");
            view.forward(request, response);

        }
                }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
            }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
