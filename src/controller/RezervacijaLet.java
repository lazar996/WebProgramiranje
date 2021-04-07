package controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import dao.LetDAO;
import dao.RezervacijeDAO;
import model.Let;
import model.Rezervacije;
import model.User;

/**
 * Servlet implementation class RezervacijaLet
 */
@WebServlet("/RezervacijaLet")
public class RezervacijaLet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RezervacijaLet() {
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
		response.getWriter().append("Served at: ").append(request.getContextPath());
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

		String action = request.getParameter("action");
		String letId = request.getParameter("let");
		Let let = LetDAO.getId(letId);
		String povratniDa = request.getParameter("povratni");

		int brojSedista= let.getBrojSedista();
		
		
		List<Integer> list = new ArrayList<Integer>();
		int index=0;
		for (int i = 1; i < brojSedista+1; i++) {
											
			list.add(i);
			

		}
		System.out.println(list+ "ovo je lista sedista");
		
		String message = "";
		String messageType = "";

		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		if (loggedInUser != null) {
			switch (action) {

			case "rezervacija":

				Let letDa = LetDAO.getId(letId);

				System.out.println(letDa);
				List<model.Let> lets = new ArrayList<>();

				lets = LetDAO.getAllLet();
				System.out.println(let);

				if (povratniDa != null) {

					String k = letDa.getPolazniAerodrom().getNaziv();
					String s = letDa.getDolazniAerodrom().getNaziv();

					for (Let leti : lets) {

						String p = leti.getPolazniAerodrom().getNaziv();
						String d = leti.getDolazniAerodrom().getNaziv();
						

						if (s.equals(p) && d.equals(k)) {

							Let lek = leti;
							String imePutnika = request.getParameter("imePutnika");
							String prezimePutnika = request.getParameter("prezimePutnika");
							System.out.println(let.getBrojSedista()+"ovoliko ima sedista u avionu");
						

						
							
							
							
							
							
							int ne=0;
							index= list.get(ne);

							Rezervacije rezervacije = new Rezervacije(0, letDa, lek, index, index, timeStamp, timeStamp,
									loggedInUser, imePutnika, prezimePutnika);
							
							
							RezervacijeDAO.Rezervacije(rezervacije);
							
							break;
						}}
					
					break;

				}
				if (povratniDa == null
						&& letDa.getDolazniAerodrom().getNaziv() != let.getPolazniAerodrom().getNaziv()) {

					String imePutnika = request.getParameter("imePutnika");
					String prezimePutnika = request.getParameter("prezimePutnika");
					String p = "";

					Let letNe = LetDAO.getId(p);
					Rezervacije rezervacije = new Rezervacije(0, let, letNe,1, 1, timeStamp, timeStamp, loggedInUser,
							imePutnika, prezimePutnika);
					RezervacijeDAO.Rezervacije1(rezervacije);

					break;
				}

			case "delete":

				let.setIzbrisan(true);
				LetDAO.update(let, let.getId());

				break;

			}
			message = "";
			messageType = "";

		}

		session.setAttribute(messageType, message);
		response.sendRedirect("./LetSingle?Let=" + let.getId());

	}
}
