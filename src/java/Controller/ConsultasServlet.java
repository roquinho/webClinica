
package Controller;

import br.clinica.entidades.Consultas;
import br.clinica.entidades.Medicos;
import br.clinica.entidades.Pacientes;
import br.clinica.regraNegocio.ExceptionRegraNegocioAgendarConsultas;
import br.clinica.regraNegocio.ExceptionRegraNegocioBuscarMedicos;
import br.clinica.regraNegocio.ExceptionRegraNegocioDeletarConsultas;
import br.clinica.regraNegocio.ExceptionRegraNegocioFiltrarConsultas;
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


public class ConsultasServlet extends HttpServlet {

        protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
            if(request.getParameter("cadastro_consulta")!=null) {
                 
        String diaConsulta = request.getParameter("inputDia");
        String horaConsulta = request.getParameter("inputHora");
        String cpfMedico = request.getParameter("inputCpfMedico");
        String cpfPaciente = request.getParameter("inputCpfPaciente");
        Long cpfP = Long.parseLong(cpfPaciente);
        Long cpfM = Long.parseLong(cpfMedico);
        
        Fachada fachada = new FachadaImplementa();
        
        Pacientes paciente=null;
        Medicos medico=null;
            try {
             medico = fachada.buscarMedicoCpf(cpfM);
            } catch (ExceptionRegraNegocioBuscarMedicos ex) {
                Logger.getLogger(ConsultasServlet.class.getName()).log(Level.SEVERE, null, ex);
            }           
            try {
            paciente = fachada.buscarPacienteCpf(cpfP);
            } catch (ExceptionRegraNegocioPacienteBuscarPaciente ex) {
                Logger.getLogger(ConsultasServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        Consultas consultas = new Consultas(paciente, diaConsulta, horaConsulta, medico);
        
            try {
                fachada.agendarConsulta(consultas);
            } catch (ExceptionRegraNegocioAgendarConsultas ex) {
                Logger.getLogger(ConsultasServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        
            }
            
            else if(request.getParameter("deletar_consulta")!=null) {
              String cpf = request.getParameter("cpf");
        Long cpff = Long.parseLong(cpf);
        
        Fachada fachada = new FachadaImplementa();
        try {
            fachada.deletarConsulta(cpff);
        } catch (ExceptionRegraNegocioDeletarConsultas ex) {
            Logger.getLogger(ExamesServlets.class.getName()).log(Level.SEVERE, null, ex);
        }  
            }
            
      else if(request.getParameter("buscar_consulta")!=null) {
        String cpf = request.getParameter("cpf");
        Long cpff = Long.parseLong(cpf);
        
        Fachada fachada = new FachadaImplementa();
        Consultas consulta = new Consultas();
         try {
          consulta =   fachada.filtrarConsultaCpfPaciente(cpff);
        } catch (ExceptionRegraNegocioFiltrarConsultas ex) {
            Logger.getLogger(ExamesServlets.class.getName()).log(Level.SEVERE, null, ex);
        }
      
         request.setAttribute("buscaConsulta", consulta);
         RequestDispatcher view = request.getRequestDispatcher("viewConsulta.jsp");
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
