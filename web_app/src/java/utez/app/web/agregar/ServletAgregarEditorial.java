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
import utez.app.daos.DaoAutor;
import utez.app.daos.DaoEditorial;
import utez.app.daos.DaoUsuario;
import utez.app.model.AutorBean;
import utez.app.model.EditorialBean;
import utez.app.model.UsuarioBean;
import utez.app.web.eq4.util.DbConnection;

/**
 *
 * @author ricardo
 */
@WebServlet(name = "AgregarEditorial", urlPatterns = {"/AgregarEditorial"})
public class ServletAgregarEditorial extends HttpServlet {

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
		
//		try{
//		
//		HttpSession sesion = request.getSession();
//		if ((Boolean)sesion.getAttribute("admin") == false || (Boolean) sesion.getAttribute("admin") == null){
//			throw new ServerException("Acceso denegado");
//		}
//		}catch (NullPointerException ex){
//			throw new ServerException("Acceso denegado");
//		}
		Connection con = DbConnection.getConnection();
		if (con == null){
			throw new ServerException("No hay coneccion con la BD");
		}
		
		
		String nombre = request.getParameter("nom");
		String dir = request.getParameter("dir");
		
		EditorialBean nuevaEditorial = new EditorialBean();
		nuevaEditorial.setNombre(nombre);
		nuevaEditorial.setDireccion(dir);
		
		String mensaje;
		if (new DaoEditorial(con).add(nuevaEditorial)){
			
			mensaje = "<div class=\"alert alert-info\"> "
				+nuevaEditorial.getNombre()+" agregada con exito</div>";
		} else{
			
			mensaje = "<div class=\"alert alert-danger\"> Error al agregar editorial</div>";
		}
		
		try (PrintWriter out = response.getWriter()) {
			out.print(mensaje);
		}
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
