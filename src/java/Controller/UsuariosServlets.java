
package Controller;

import br.clinica.entidades.Usuarios;
import br.clinica.regraNegocio.ExceptionRegraNegocioCadastrarUsuarios;
import br.clinica.regraNegocio.ExceptionRegraNegocioDeletarUsuarios;
import br.clinica.regraNegocio.ExceptionRegraNegociofiltrarUsuarios;
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


public class UsuariosServlets extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        if(request.getParameter("cadastro_usuario")!=null) {
       
        String nome = request.getParameter("inputNome");
        String cpf = request.getParameter("inputCpf");
        String senha = request.getParameter("inputSenha");
        String tipoUsuario = request.getParameter("inputTipoUsuario");
        
        Usuarios usuario = new Usuarios(nome, senha, tipoUsuario, cpf);
        
        Fachada fachada = new FachadaImplementa();
       
        try {
            fachada.cadastrarUsuario(usuario);
            request.setAttribute("alerta", "usuario cadastrado com sucesso");
            RequestDispatcher view = request.getRequestDispatcher("ViewAlerta.jsp");
            view.forward(request, response);

        } catch (ExceptionRegraNegocioCadastrarUsuarios ex) {
            Logger.getLogger(UsuariosServlets.class.getName()).log(Level.SEVERE, null, ex);
            
             request.setAttribute("alerta", "erro ao cadastrar "+ex);
            RequestDispatcher view = request.getRequestDispatcher("ViewAlerta.jsp");
            view.forward(request, response);

        }
  
        }
        
        else if(request.getParameter("deletar_usuario")!=null) {
            String cpf = request.getParameter("inputCpf");
        
        
        Fachada fachada = new FachadaImplementa();
        
        try {
            fachada.deletarUsuario(cpf);
            
            request.setAttribute("alerta", "usuario deletado com sucesso");
            RequestDispatcher view = request.getRequestDispatcher("ViewAlerta.jsp");
            view.forward(request, response);
            
        } catch (ExceptionRegraNegocioDeletarUsuarios ex) {
            Logger.getLogger(UsuariosServlets.class.getName()).log(Level.SEVERE, null, ex);
            
            request.setAttribute("alerta", "erro ao deletar "+ex);
            RequestDispatcher view = request.getRequestDispatcher("ViewAlerta.jsp");
            view.forward(request, response);
        }
        
        }
        else if(request.getParameter("buscar_usuario")!=null) {
            String cpf = request.getParameter("inputCpf");
        
        
        Fachada fachada = new FachadaImplementa();
        Usuarios usuario = new Usuarios();
        
        try {
           usuario = fachada.filtrarUsuarioCpf(cpf);
        } catch (ExceptionRegraNegociofiltrarUsuarios ex) {
            Logger.getLogger(UsuariosServlets.class.getName()).log(Level.SEVERE, null, ex);
            
         request.setAttribute("alerta", "erro ao consultar usuario " +ex);
         RequestDispatcher view = request.getRequestDispatcher("ViewAlerta.jsp");
         view.forward(request, response);

        }
        if(usuario!=null) {
            request.setAttribute("buscaUsuario", usuario);
            RequestDispatcher view = request.getRequestDispatcher("ViewUsuarioBusca.jsp");
            view.forward(request, response);
        }
         else {
         request.setAttribute("alerta", "usuario nao encontrado ");
         RequestDispatcher view = request.getRequestDispatcher("ViewAlerta.jsp");
         view.forward(request, response);
        }
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
