/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package utez.app.web.prestamo;

import java.io.IOException;
import java.sql.Connection;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import utez.app.daos.DaoPrestamo;
import utez.app.daos.DaoUsuario;
import utez.app.model.PrestamoBean;
import utez.app.model.UsuarioBean;
import utez.app.utilidades.Biblioteca;
import static utez.app.web.Constants.MYSQL;

/**
 *
 * @author ricardo
 */
public class ServletPago extends HttpServlet {

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
		
		int usuarioId = Integer.parseInt(request.getParameter("u"));
		int prestamoId = Integer.parseInt(request.getParameter("p"));
		
		Connection con = new Biblioteca(MYSQL).getConection();
		DaoPrestamo daoP = new DaoPrestamo(con);
		PrestamoBean prestamo = daoP.get(prestamoId);
		DaoUsuario daoU = new DaoUsuario(con);
		UsuarioBean usuario = daoU.get(usuarioId);
		
		daoP.delete(prestamo);
		
		new Biblioteca(true).actualizarPenalizaciones(usuario); //mysql
		response.sendRedirect("admin_prestamos.jsp");
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
