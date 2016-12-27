
package Controller;

import br.clinica.entidades.Pacientes;
import br.clinica.regraNegocio.ExceptionRegraNegocioPacientesCadastrar;
import br.clinica.regraNegocio.Fachada;
import br.clinica.regraNegocio.FachadaImplementa;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class PacientesServlet extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                  
    }
    
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nome = request.getParameter("inputName");
        String endereco = request.getParameter("inputEndereco");
        String telefone = request.getParameter("inputTelefone");
        String cpfString = request.getParameter("inputCpf");
        Long cpf = Long.parseLong(cpfString);
        String sexo = request.getParameter("inputSexo");
        String dataNascimento = request.getParameter("inputDataNascimento");
        
        Pacientes paciente = new Pacientes(cpf, nome, endereco, telefone, sexo, dataNascimento);
        Fachada fachada = new FachadaImplementa();
        System.out.println(cpf);
        System.out.println(paciente.getCpf());
        
        try {
            fachada.cadastrarPaciente(paciente);
        } catch (ExceptionRegraNegocioPacientesCadastrar ex) {
            Logger.getLogger(PacientesServlet.class.getName()).log(Level.SEVERE, null, ex);
        }         

    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
