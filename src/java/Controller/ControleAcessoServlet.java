/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import br.clinica.regraNegocio.ExceptionRegraNegocioBuscarMedicos;
import br.clinica.regraNegocio.ExceptionRegraNegocioPacienteBuscarPaciente;
import br.clinica.regraNegocio.ExceptionRegraNegociofiltrarUsuarios;
import br.clinica.regraNegocio.Fachada;
import br.clinica.regraNegocio.FachadaImplementa;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author manoel
 */
@WebServlet(name = "ControleAcessoServlet", urlPatterns = {"/ControleAcessoServlet"})
public class ControleAcessoServlet extends HttpServlet {

    
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
        
        String nome = request.getParameter("inputNome");
        String cpff = request.getParameter("cpf");
        Long cpf = Long.parseLong(cpff);
        
        Fachada fachada = new FachadaImplementa();
        boolean login = false;
        boolean loginUsuario = false;
        boolean loginMedico= false;
        
        try {
             login = fachada.checarLoginPaciente(cpf);
        } catch (ExceptionRegraNegocioPacienteBuscarPaciente ex) {
            Logger.getLogger(ControleAcessoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            loginMedico = fachada.checarLoginMedico(cpf);
        } catch (ExceptionRegraNegocioBuscarMedicos ex) {
            Logger.getLogger(ControleAcessoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
                        
        try {
            fachada.checarLoginUsuario(cpff);
        } catch (ExceptionRegraNegociofiltrarUsuarios ex) {
            Logger.getLogger(ControleAcessoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        ArrayList listaBoolean = new ArrayList();
        listaBoolean.add(login);
        listaBoolean.add(loginMedico);
        listaBoolean.add(loginUsuario);
        
        
        request.setAttribute("styles",listaBoolean);
        RequestDispatcher view = request.getRequestDispatcher("LoginView.jsp");
        view.forward(request, response);
        
        
        
         
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
