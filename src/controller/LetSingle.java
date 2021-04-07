package controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
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
import dao.RezervacijeDAO;
import model.Aerodrom;
import model.Let;
import model.Rezervacije;
import model.User;
import model.User.Role;

/**
 * Servlet implementation class LetSingle
 */
@WebServlet("/LetSingle")
public class LetSingle extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LetSingle() {
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

		String letId;

		List<Aerodrom> aerodroms = new ArrayList<>();
		aerodroms = AerodromDAO.getAllAeordrom();

		List<Rezervacije> rezervacijes = new ArrayList<>();
		rezervacijes = RezervacijeDAO.getAllRezervacije();
		
		if ((letId = request.getParameter("Let")) == null) {
			response.sendRedirect("./Home");
			return;
		}

		Let let = LetDAO.getId(letId);

		if (let == null) {
			response.sendRedirect("./Home");
			return;
		}
		request.setAttribute("aerodroms", aerodroms);
		request.setAttribute("let", let);
		
		request.setAttribute("rezervacijes", rezervacijes);
		request.getRequestDispatcher("LetSingle.jsp").forward(request, response);
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

		User loggedInUser = (User) session.getAttribute("loggedInUser");

		String izmenaLet = request.getParameter("izmenaLet");

		String id = request.getParameter("id");

		int idInt = Integer.parseInt(id);

		Let let = LetDAO.getLetById(idInt);

		String message = "";
		String messageType = "";

		if (loggedInUser.getRole() == Role.admin) {
			switch (izmenaLet) {

			case "izmena":

				String brojLeta = request.getParameter("brojLeta");
				String polazniAerodrom = request.getParameter("polazniAerodrom");
				String dolazniAerodrom = request.getParameter("dolazniAerodrom");
				String cenaKarte = request.getParameter("cenaKarte");

				int aerodromId = Integer.parseInt(polazniAerodrom);
				int aerodromId1 = Integer.parseInt(dolazniAerodrom);

				Aerodrom aerodrom = AerodromDAO.getAerodromById(aerodromId);
				Aerodrom aerodrom1 = AerodromDAO.getAerodromById(aerodromId1);

				let.setPolazniAerodrom(aerodrom);
				let.setDolazniAerodrom(aerodrom1);

				int brojString = Integer.parseInt(brojLeta);
				let.setBroj(brojString);

				String dateString = request.getParameter("date");
				String timeString = request.getParameter("time");
				String datumPolaska = dateString + " " + timeString;

				String dateString1 = request.getParameter("date1");
				String timeString1 = request.getParameter("time1");
				String datumDolaska = dateString1 + " " + timeString1;

			
				Timestamp datetime;
				Timestamp datetime1;

				try {

					datetime = new Timestamp(LetDAO.DATETIME_FORMAT.parse(datumPolaska).getTime());

					let.setDatumPolaska(datetime);
					datetime1 = new Timestamp(LetDAO.DATETIME_FORMAT.parse(datumDolaska).getTime());
					let.setDatumDolaska(datetime1);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				int cenaKarteString = Integer.parseInt(cenaKarte);
				let.setCenaKarte(cenaKarteString);
				LetDAO.update(let, let.getId());
				
				messageType = "messageFailUPanel";
				break;

			}
			message = ".";
			messageType = "";

		}
	
		session.setAttribute(messageType, message);
		response.sendRedirect("./UserSingle?let=" + let.getId());
	}

}
