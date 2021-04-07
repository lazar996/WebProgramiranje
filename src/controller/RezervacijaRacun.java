package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.RezervacijeDAO;
import model.Rezervacije;

/**
 * Servlet implementation class RezervacijaRacun
 */
@WebServlet("/RezervacijaRacun")
public class RezervacijaRacun extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RezervacijaRacun() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String rezervacijaRacunId;
		rezervacijaRacunId = request.getParameter("Rezervacija");

		System.out.println("nista" + rezervacijaRacunId);

		if (rezervacijaRacunId == null) {
			System.out.println("nema nista");
			response.sendRedirect("/Home");
			return;
		}

		int id = Integer.parseInt(rezervacijaRacunId);

		Rezervacije rezervacije = RezervacijeDAO.getByRezervacijeRacunId(id);
		

		if (rezervacije == null) {

			response.sendRedirect("/Home");

			return;
		}
		request.setAttribute("rezervacije", rezervacije);
		request.getRequestDispatcher("RezervacijaRacun.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
