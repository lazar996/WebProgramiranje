package controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.AerodromDAO;
import dao.LetDAO;
import model.Aerodrom;
import model.Let;
import model.User;

/**
 * Servlet implementation class DodavanjeLet
 */
@WebServlet("/DodavanjeLet")
public class DodavanjeLet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DodavanjeLet() {
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

		HttpSession session = request.getSession();
		User loggedInUser = (User) session.getAttribute("loggedInUser");

		List<Aerodrom> aerodroms = new ArrayList<>();

		if (loggedInUser != null) {
			aerodroms = AerodromDAO.getAllAeordrom();
			
		}

		request.setAttribute("aerodroms", aerodroms);
		request.getRequestDispatcher("./DodavanjeLet.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		HttpSession session = request.getSession();
		session.removeAttribute("messageUPanel");
		session.removeAttribute("messageFailUPanel");

		try {

			String brojLeta = request.getParameter("brojLeta");
			int brojInt = Integer.parseInt(brojLeta);
			
			String dateString = request.getParameter("date");
			String timeString = request.getParameter("time");
			String datumPolaska = dateString + " " + timeString;

			String dateString1 = request.getParameter("date1");
			String timeString1 = request.getParameter("time1");
			String datumDolaska = dateString1 + " " + timeString1;

			
			String dateStringPovratni = request.getParameter("date");
			String timeStringPovratni = request.getParameter("time");
			String datumPolaskaPovratni = dateStringPovratni + " " + timeStringPovratni;

			String datePovratni1 = request.getParameter("date1");
			String timePovratni1 = request.getParameter("time1");
			String datumPovratni1 = datePovratni1 + " " + timePovratni1;
			
			
			String polazniAerodrom = request.getParameter("polazniAerodrom");
			String dolazniAerodrom = request.getParameter("dolazniAerodrom");

			String brojSedista = request.getParameter("brojSedista");
			int brojSedistaInt = Integer.parseInt(brojSedista);

			String cenaKarte = request.getParameter("cenaKarte");
			int cenaKarteInt = Integer.parseInt(cenaKarte);

			Timestamp datetime = new Timestamp(LetDAO.DATETIME_FORMAT.parse(datumPolaska).getTime());

			Timestamp datetime1 = new Timestamp(LetDAO.DATETIME_FORMAT.parse(datumDolaska).getTime());
			
			Timestamp datetime2 = new Timestamp(LetDAO.DATETIME_FORMAT.parse(datumPolaskaPovratni).getTime());
			
			Timestamp datetime3 = new Timestamp(LetDAO.DATETIME_FORMAT.parse(datumPovratni1).getTime());

			
			
			if (datetime1.after(datetime) && datetime.before(datetime1)) {

				int aerodromId = Integer.parseInt(polazniAerodrom);
				int aerodromId1 = Integer.parseInt(dolazniAerodrom);

				Aerodrom aerodrom = AerodromDAO.getAerodromById(aerodromId);
				Aerodrom aerodrom1 = AerodromDAO.getAerodromById(aerodromId1);

				Let novLet = new Let(0, brojInt, datetime, datetime1, aerodrom, aerodrom1, brojSedistaInt, cenaKarteInt,
						false);
				Let povLet = new Let(0, brojInt, datetime2, datetime3, aerodrom1, aerodrom, brojSedistaInt, cenaKarteInt,
						false);
				LetDAO.add(novLet);
				LetDAO.add(povLet);

			}

			String message = "Let uspenso dodat";
			request.setAttribute("let", message);
			request.getRequestDispatcher("./Home").forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();

		}

	}

}
