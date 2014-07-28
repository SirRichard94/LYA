/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package utez.app.web;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import utez.app.daos.DaoArea;
import utez.app.daos.DaoAutor;
import utez.app.daos.DaoEditorial;
import utez.app.daos.DaoLibro;
import utez.app.model.AreaBean;
import utez.app.model.AutorBean;
import utez.app.model.EditorialBean;
import utez.app.model.LibroBean;
import utez.app.utilidades.Biblioteca;
import utez.app.web.eq4.util.DbConnection;

/**
 *
 * @author ricardo
 */
public class ServletBusqueda extends HttpServlet {

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
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		Connection con = DbConnection.getConnection();
		if (con==null){
		throw new ServletException("No hay conexion con la BD");
		}
		
		DaoLibro daoL = new DaoLibro(con);
		List<LibroBean> lista = new ArrayList<>();
		
		String busqueda = request.getParameter("search");
		String categoria = request.getParameter("categoria");
		Biblioteca biblioteca = new Biblioteca(true); //mysql
		
		
		try{
			if (busqueda == null || busqueda.equals("")){
				lista = daoL.getActive();
			}else if (categoria.equals("autor")){
				lista = biblioteca.busquedaLibroPorAutor(busqueda);
			
			}else if (categoria.equals("area")){
				lista = biblioteca.busquedaLibroPorArea(busqueda);
			}else if (categoria.equals("editorial")){
				lista = biblioteca.busquedaLibroPorEditorial(busqueda);
			}else{
				lista = daoL.findByTitulo(busqueda);
			}
		
		}catch(Exception e ){}		
		
		request.setAttribute("lista", lista);
		request.setAttribute("busqueda", busqueda);
		
		this.getServletConfig().getServletContext().
                getRequestDispatcher("/tabla_libros.jsp").
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
