
package Controller;

import br.clinica.entidades.Exames;
import br.clinica.entidades.Pacientes;
import br.clinica.regraNegocio.ExceptionRegraNegocioAgendarExame;
import br.clinica.regraNegocio.ExceptionRegraNegocioDeletarExames;
import br.clinica.regraNegocio.ExceptionRegraNegocioFiltrarExame;
import br.clinica.regraNegocio.ExceptionRegraNegocioPacienteBuscarPaciente;
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


public class ExamesServlets extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if(request.getParameter("marcar_exame")!=null) {
            
        String diaExame = request.getParameter("inputDia");
        String horaExame = request.getParameter("inputHora");
        String tipoExame = request.getParameter("inputTipoExame");
        String cpfPaciente = request.getParameter("inputCpfPaciente");
        Long cpfP = Long.parseLong(cpfPaciente);
        
        Fachada fachada = new FachadaImplementa();        
        Pacientes paciente=null;
        
        try {
            paciente = fachada.buscarPacienteCpf(cpfP);
            } catch (ExceptionRegraNegocioPacienteBuscarPaciente ex) {
                Logger.getLogger(ConsultasServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        Exames exame = new Exames(tipoExame, diaExame, horaExame, paciente);
        
        try {
            fachada.agendarExame(exame);
        } catch (ExceptionRegraNegocioAgendarExame ex) {
            Logger.getLogger(ExamesServlets.class.getName()).log(Level.SEVERE, null, ex);
        }  
        }
        
        
        else if(request.getParameter("deletar_exame")!=null) {
          String cpf = request.getParameter("inputCpf");
        Long cpff = Long.parseLong(cpf);
        
        Fachada fachada = new FachadaImplementa();
        try {
            fachada.deletarExame(cpff);
        } catch (ExceptionRegraNegocioDeletarExames ex) {
            Logger.getLogger(ExamesServlets.class.getName()).log(Level.SEVERE, null, ex);
        }  
        }
        else if(request.getParameter("buscar_exame")!=null) {
          String cpf = request.getParameter("inputCpf");
         Long cpff = Long.parseLong(cpf);
        
        Fachada fachada = new FachadaImplementa();
        Exames exame = new Exames();
        try {
          exame =   fachada.filtrarExameCpfPaciente(cpff);
        } catch (ExceptionRegraNegocioFiltrarExame ex) {
            Logger.getLogger(ExamesServlets.class.getName()).log(Level.SEVERE, null, ex);
        }
        request.setAttribute("buscaExame", exame);
        RequestDispatcher view = request.getRequestDispatcher("ViewExameBusca.jsp");
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
