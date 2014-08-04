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
import javax.servlet.http.HttpSession;
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
public class ServletModificarLibro extends HttpServlet {

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
		response.setContentType("charset=UTF-8");
		
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
		
		///
		DaoLibro dao = new DaoLibro(con);
		
		String redirect = "modificar_libro.jsp";
		String guardar = request.getParameter("guardar");
		
		int id = Integer.parseInt(request.getParameter("id"));
		LibroBean bean = dao.get(id);
		
		if (guardar == null || !guardar.equals("true")){
			
			request.setAttribute("objetivo", bean);
			this.getServletContext().getRequestDispatcher("/"+redirect).forward(request, response);
			//forward a modificar
			
		} else {
		String nombre = request.getParameter("nombre");
		long isbn = Long.parseLong(request.getParameter("isbn"));
		int paginas = Integer.parseInt(request.getParameter("pags"));
		int area_id = Integer.parseInt(request.getParameter("area"));
		int editorial_id = Integer.parseInt(request.getParameter("editorial"));
		String[] stringAutores_id = request.getParameterValues("autores");
		
		AreaBean area = new DaoArea(con).get(area_id);
		EditorialBean editorial = new DaoEditorial(con).get(editorial_id);
		List<AutorBean> autores = new ArrayList<>();
		
		for (String stringAutorId : stringAutores_id) {
			autores.add(
				new DaoAutor(con).get(
					Integer.parseInt(stringAutorId))
			);
		}
		
		
		bean.setNombre(nombre);
		bean.setIsbn(isbn);
		bean.setPaginas(paginas);
		bean.setArea(area);
		bean.setEditorial(editorial);
		bean.setAutores(autores);
			

			if (dao.update(bean)) {
				request.setAttribute("info", "Ha sido actualizado con exito");

			} else {
				request.setAttribute("warning", "Error al actualizar Autor");

			}
			
			redirect = "Admin?sec=libro";
			String pagina = response.encodeRedirectURL(redirect);
			response.sendRedirect(pagina);				//redirect a admin
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
