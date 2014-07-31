/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package utez.app.web.libro;

import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.ServerException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import utez.app.daos.*;
import utez.app.model.*;
import utez.app.web.eq4.util.DbConnection;

/**
 *
 * @author ricardo
 */
public class ServletAgregarLibro extends HttpServlet {

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
		if (con == null){
			throw new ServerException("No hay coneccion con la BD");
		}
		
		
		String nombre = request.getParameter("nombre");
		long isbn = Long.parseLong(request.getParameter("isbn"));
		int paginas = Integer.parseInt(request.getParameter("pags"));
		int area_id = Integer.parseInt(request.getParameter("area"));
		int editorial_id = Integer.parseInt(request.getParameter("editorial"));
		String[] stringAutores_id = request.getParameterValues("autores");
		
		AreaBean area = new DaoArea(con).get(area_id);
		EditorialBean editorial = new DaoEditorial(con).get(editorial_id);
		List<AutorBean> autores = new ArrayList<AutorBean>();
		for (String stringAutorId : stringAutores_id) {
			autores.add(
				new DaoAutor(con).get(
					Integer.parseInt(stringAutorId))
			);
		}
		
		LibroBean nuevoBean = new LibroBean();
		nuevoBean.setNombre(nombre);
		nuevoBean.setIsbn(isbn);
		nuevoBean.setPaginas(paginas);
		nuevoBean.setArea(area);
		nuevoBean.setEditorial(editorial);
		nuevoBean.setAutores(autores);
		
		
		String mensaje;
		if (new DaoLibro(con).add(nuevoBean)){
			
			mensaje = "<div class=\"alert alert-info\"> "
				+nuevoBean.getNombre()+" agregado con exito</div>";
		} else{
			
			mensaje = "<div class=\"alert alert-danger\"> Error al agregar libro</div>";
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
