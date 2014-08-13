/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package utez.app.web;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
public class ServletPerfil extends HttpServlet {

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
		
		Connection con = new Biblioteca(MYSQL).getConection();
		if (con==null){
		throw new ServletException("No hay conexion con la BD");
		}
		HttpSession session = request.getSession();
		UsuarioBean usuario = (UsuarioBean) session.getAttribute("usuario");
		
		if (usuario==null){
			response.sendRedirect("index.jsp");	//si no hay usuario, redirect a index
		}else{
		
			DaoPrestamo daoP = new DaoPrestamo(con);
			List<PrestamoBean> lista = daoP.findByUsuario(usuario);

			//sumar las penalizaciones que tenga el usuario
			usuario.setDeuda(0);
			for (PrestamoBean prestamoBean : lista) {
				usuario.setDeuda(
					usuario.getDeuda() + daoP.penalizacion(prestamoBean, MYSQL) //mysql
				);
			}

			new DaoUsuario(con).update(usuario);
			
			request.setAttribute("prestamos", lista);
			session.setAttribute("usuario", usuario);

			this.getServletConfig().getServletContext().
				getRequestDispatcher("/perfil.jsp").
				forward(request, response);

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
