/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package utez.app.web.agregar;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import utez.app.daos.DaoEjemplar;
import utez.app.daos.DaoLibro;
import utez.app.model.EjemplarBean;
import utez.app.model.LibroBean;
import utez.app.web.eq4.util.DbConnection;

/**
 *
 * @author ricardo
 */
public class ServletAgregarEjemplares extends HttpServlet {

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
		//params i = isbn, l = localizacion, n = numero de ejemplares
		long isbn = Long.parseLong(request.getParameter("i"));
		String localizacion = request.getParameter("l");
		int num = Integer.parseInt(request.getParameter("n"));
		
		List<EjemplarBean> ejemplarList = new ArrayList();
		
		Connection con = DbConnection.getConnection();
		
		DaoEjemplar daoE = new DaoEjemplar(con);
		DaoLibro daoL = new DaoLibro(con);
		LibroBean libroBean = daoL.getByIsbn(isbn);
		
		
		for (int i = 0; i < num; i++) {
			EjemplarBean ejemplar = new EjemplarBean();
			ejemplar.setLibro(libroBean);
			ejemplar.setLocalizacion(localizacion);
			
			ejemplarList.add(ejemplar);
		}
		
		try (PrintWriter out = response.getWriter()) {
			out.print("<div class=\"alert alert-info\"> Ejemplar agregado con exito </div>");
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
