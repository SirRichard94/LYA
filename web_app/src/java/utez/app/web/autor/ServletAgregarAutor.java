/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package utez.app.web.autor;

import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.ServerException;
import java.sql.Connection;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import utez.app.daos.DaoAutor;
import utez.app.model.AutorBean;
import utez.app.utilidades.Biblioteca;
import static utez.app.web.Constants.MYSQL;

/**
 *
 * @author ricardo
 */
public class ServletAgregarAutor extends HttpServlet {

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
		request.setCharacterEncoding("UTF-8");
		
		
//		try{
//		
//		HttpSession sesion = request.getSession();
//		if ((Boolean)sesion.getAttribute("admin") == false || (Boolean) sesion.getAttribute("admin") == null){
//			throw new ServerException("Acceso denegado");
//		}
//		}catch (NullPointerException ex){
//			throw new ServerException("Acceso denegado");
//		}
		Connection con = new Biblioteca(MYSQL).getConection();
		if (con == null){
			throw new ServerException("No hay coneccion con la BD");
		}
		
		
		String nombre = request.getParameter("n");
		String apellido = request.getParameter("a");
		
		AutorBean autor = new AutorBean();
		autor.setNombre(nombre);
		autor.setApellido(apellido);
		
		String mensaje;
		if (new DaoAutor(con).add(autor)){
			//request.setAttribute("info", "Usuario agregado con exito");
			mensaje = "<div class=\"alert alert-info\"> "
				+autor.getNombre()+" "+autor.getApellido()+" agregado con éxito"
				+ "</div>";
		} else{
			//request.setAttribute("warning", "Error al agregar usuario");
			mensaje = "<div class=\"alert alert-danger\"> Error al agregar Autor</div>";
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
