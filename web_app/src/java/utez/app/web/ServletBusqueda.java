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
import utez.app.biblioteca.BibliotecaLYA;
import utez.app.daos.DaoArea;
import utez.app.daos.DaoAutor;
import utez.app.daos.DaoEditorial;
import utez.app.daos.DaoLibro;
import utez.app.model.AreaBean;
import utez.app.model.AutorBean;
import utez.app.model.EditorialBean;
import utez.app.model.LibroBean;
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
		request.setCharacterEncoding("UTF-8");
		BibliotecaLYA biblioteca = new BibliotecaLYA(true);
		
		if (biblioteca.getConnection()==null){
		throw new ServletException("No hay conexion con la BD");
		}
		
		
		List<LibroBean> lista = biblioteca.listarLibros();
		List<LibroBean> resultado = new ArrayList<>();
		
		String busqueda = request.getParameter("search").toLowerCase();
		String categoria = request.getParameter("categoria");
		
		
		
		
		if (busqueda == null || busqueda.equals("")){
			resultado = lista;
		}
		else if (categoria.equals("autor")){
			//quitar true para sql
			for (LibroBean libroBean : lista) {
				for (AutorBean autor : libroBean.getAutores()) {
					if((autor.getNombre()+" "+autor.getApellido())
						.toLowerCase()
						.contains(busqueda)){
						
						resultado.add(libroBean);
					}
				}
			}
			
		} else if(categoria.equals("editorial")){
			for (LibroBean libroBean : lista) {
				if (libroBean.getEditorial().getNombre()
					.toLowerCase()
					.contains(busqueda)){
					
					resultado.add(libroBean);
				}
			}
			
			
		} else if(categoria.equals("titulo")){
			for (LibroBean libroBean : lista) {
				if (libroBean.getNombre()
					.toLowerCase()
					.contains(busqueda)){
					resultado.add(libroBean);
				}
			}
			
		} else if(categoria.equals("area")){
			for (LibroBean libroBean : lista) {
				if (libroBean.getArea().getNombre()
					.toLowerCase()
					.contains(busqueda)){
					resultado.add(libroBean);
				}
			}
		}
			
		
		request.setAttribute("lista", resultado);
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
