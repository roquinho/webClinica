
package Controller;

import br.clinica.entidades.Usuarios;
import br.clinica.regraNegocio.ExceptionRegraNegocioCadastrarUsuarios;
import br.clinica.regraNegocio.ExceptionRegraNegocioDeletarUsuarios;
import br.clinica.regraNegocio.Fachada;
import br.clinica.regraNegocio.FachadaImplementa;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class UsuariosServlets extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String cpf = request.getParameter("cpf");
        
        
        Fachada fachada = new FachadaImplementa();
        
        try {
            fachada.deletarUsuario(cpf);
        } catch (ExceptionRegraNegocioDeletarUsuarios ex) {
            Logger.getLogger(UsuariosServlets.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String nome = request.getParameter("inputName");
        String cpf = request.getParameter("inputCpf");
        String senha = request.getParameter("inputSenha");
        String tipoUsuario = request.getParameter("inputTipo");
        
        Usuarios usuario = new Usuarios(nome, senha, tipoUsuario, cpf);
        
        Fachada fachada = new FachadaImplementa();
        System.out.println(cpf);
        System.out.println(usuario.getCpf());
        
        try {
            fachada.cadastrarUsuario(usuario);
        } catch (ExceptionRegraNegocioCadastrarUsuarios ex) {
            Logger.getLogger(UsuariosServlets.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
