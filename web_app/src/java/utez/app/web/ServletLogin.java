/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package utez.app.web;

import java.awt.SystemColor;
import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.ServerException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import utez.app.daos.DaoUsuario;
import utez.app.model.UsuarioBean;
import utez.app.web.eq4.util.DbConnection;

/**
 *
 * @author ricardo
 */
public class ServletLogin extends HttpServlet {

	/**
	 * Processes requests for both HTTP <code>GET</code> and
	 * <code>POST</code> methods.
	 *
	 * @param request servlet request
	 * @param response servlet response
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException if an I/O error occurs
	 */
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		
		
        Connection con = DbConnection.getConnection();
	if (con==null){
		throw new ServletException("No hay conexion con la BD");
	}
	
        String forwardUrl = "/index.jsp";
        String correo;
	String contraseña;
	
	correo = request.getParameter("correo");
	contraseña = request.getParameter("password");
        
        DaoUsuario daoUs = new DaoUsuario(con);
        
        boolean existe = daoUs.autenticar(correo, contraseña);
        
        HttpSession sesion = request.getSession();
        sesion.setAttribute("login", existe);
        
	
	String mensaje = "<div class=\"alert alert-info\">  Sesion iniciada </div>";
	
        if(existe){
        UsuarioBean usuario = daoUs.findByCorreo(correo);
        boolean admin = usuario.isEs_admi();
        
        sesion.setAttribute("admin", admin);
        sesion.setAttribute("usuario", usuario);
        }else{
        
	mensaje = "<div class=\"alert alert-danger\">  Usuario o contraseña incorrectos </div>";
		
	}
	
	try (PrintWriter out = response.getWriter()) {
		out.print(mensaje);
	}
	
//	this.getServletConfig().getServletContext().
//                getRequestDispatcher(forwardUrl).
//                forward(request, response);
	
        
	}

	// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
	/**
	 * Handles the HTTP <code>GET</code> method.
	 *
	 * @param request servlet request
	 * @param response servlet response
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException if an I/O error occurs
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * Handles the HTTP <code>POST</code> method.
	 *
	 * @param request servlet request
	 * @param response servlet response
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException if an I/O error occurs
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * Returns a short description of the servlet.
	 *
	 * @return a String containing servlet description
	 */
	@Override
	public String getServletInfo() {
		return "Short description";
	}// </editor-fold>

}
