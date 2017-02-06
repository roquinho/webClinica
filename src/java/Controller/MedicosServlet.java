
package Controller;

import br.clinica.entidades.Medicos;
import br.clinica.regraNegocio.ExceptionRegraNegocioCadastrarMedicos;
import br.clinica.regraNegocio.ExceptionRegraNegocioDeletarConsultas;
import br.clinica.regraNegocio.ExceptionRegraNegocioDeletarMedicos;
import br.clinica.regraNegocio.Fachada;
import br.clinica.regraNegocio.FachadaImplementa;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class MedicosServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
                }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String cpf = request.getParameter("cpf");
        Long cpff = Long.parseLong(cpf);
        
        Fachada fachada = new FachadaImplementa();
            try {
                fachada.deletarMedico(cpff);
            } catch (ExceptionRegraNegocioDeletarMedicos ex) {
                Logger.getLogger(MedicosServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String nome = request.getParameter("inputName");
        String telefone = request.getParameter("inputTelefone");
        String cpfString = request.getParameter("inputCpf");
        Long cpf = Long.parseLong(cpfString);
        String especialidade = request.getParameter("inputEspecialidade");
        String crmString = request.getParameter("inputCrm");
        Long  crm = Long.parseLong(crmString);
        String endereco = request.getParameter("inputEndereco");
        
        Medicos medico = new Medicos(cpf, nome, endereco, telefone, crm, especialidade);
         System.out.println(cpf);
        System.out.println(medico.getCpf());
        
        Fachada fachada = new FachadaImplementa();
        
        try {
            fachada.cadastrarMedicos(medico);
        } catch (ExceptionRegraNegocioCadastrarMedicos ex) {
            Logger.getLogger(MedicosServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
