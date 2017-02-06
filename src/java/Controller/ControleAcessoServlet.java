/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import br.clinica.entidades.Pacientes;
import br.clinica.regraNegocio.ExceptionRegraNegocioPacienteBuscarPaciente;
import br.clinica.regraNegocio.Fachada;
import br.clinica.regraNegocio.FachadaImplementa;
import java.io.IOException;
import java.io.PrintWriter;
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
        try {
             login = fachada.checarLoginPaciente(cpf);
        } catch (ExceptionRegraNegocioPacienteBuscarPaciente ex) {
            Logger.getLogger(ControleAcessoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        request.setAttribute("styles",login);
        RequestDispatcher view = request.getRequestDispatcher("LoginView.jsp");
        view.forward(request, response);
        
        
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
