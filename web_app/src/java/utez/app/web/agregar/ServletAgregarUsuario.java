/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package utez.app.web.agregar;

import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.ServerException;
import java.sql.Connection;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
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
@WebServlet(name = "AgregarUsuario", urlPatterns = {"/AgregarUsuario"})
public class ServletAgregarUsuario extends HttpServlet {

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
		
		try{
		
		HttpSession sesion = request.getSession();
		if ((Boolean)sesion.getAttribute("admin") == false || (Boolean) sesion.getAttribute("admin") == null){
			throw new ServerException("Acceso denegado");
		}
		}catch (NullPointerException ex){
			throw new ServerException("Acceso denegado");
		}
		Connection con = DbConnection.getConnection();
		if (con == null){
			throw new ServerException("No hay coneccion con la BD");
		}
		
		String nombre = request.getParameter("nombre");
		String email = request.getParameter("email");
		String pass = request.getParameter("pass");
		String tel = request.getParameter("tel");
		String direccion = request.getParameter("dir");
		
		UsuarioBean usuario = new UsuarioBean();
		usuario.setNombre(nombre);
		usuario.setCorreo(email);
		usuario.setPasswd(pass);
		usuario.setTelefono(tel);
		usuario.setDireccion(direccion);
		
		String mensaje;
		if (new DaoUsuario(con).add(usuario)){
			//request.setAttribute("info", "Usuario agregado con exito");
			 mensaje = "<div class=\"alert alert-info\"> Usuario agregado con exito</div>";
		} else{
			//request.setAttribute("warning", "Error al agregar usuario");
			 mensaje = "<div class=\"alert alert-danger\"> Error al agregar usuario</div>";
		}
		
		try (PrintWriter out = response.getWriter()) {
			out.print(mensaje);
		}
		//this.getServletContext().getRequestDispatcher("/admin.jsp").forward(request, response);
		
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
