/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package utez.app.web.tables;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import utez.app.daos.DaoArea;
import utez.app.daos.DaoAutor;
import utez.app.daos.DaoEditorial;
import utez.app.daos.DaoLibro;
import utez.app.model.AreaBean;
import utez.app.model.LibroBean;
import utez.app.web.eq4.util.DbConnection;

/**
 *
 * @author ricardo
 */
@WebServlet(name = "ServletTablaLibro", urlPatterns = {"/ServletTablaLibro"})
public class ServletTablaLibro extends HttpServlet {

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
		
		Connection con = DbConnection.getConnection();
		DaoLibro daoL = new DaoLibro(con);
		List<LibroBean> lista = new ArrayList<>();
		
		lista = daoL.getActive();
		List<Integer> ejemplares = new ArrayList<>();
		List<Integer> ejemplaresDisponibles = new ArrayList<>();
		
		for (LibroBean libroBean : lista) {
			libroBean.setArea( 
				new DaoArea(con).get(
					libroBean.getArea().getArea_id()));
			
			libroBean.setEditorial(
				new DaoEditorial(con).get(
					libroBean.getEditorial().getEditorial_id()));
			
			libroBean.setAutores(new DaoAutor(con).findByLibro(libroBean));
			
			ejemplares.add(daoL.countEjemplares(libroBean));
			ejemplaresDisponibles.add(daoL.countEjemplaresDisponibles(libroBean));
		}
		
		request.setAttribute("lista", lista);
		request.setAttribute("ej", ejemplares);
		request.setAttribute("ejDisp", ejemplaresDisponibles);
		
		this.getServletConfig().getServletContext().
                getRequestDispatcher("/tabla_admin_lib.jsp").
                forward(request, response);
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
