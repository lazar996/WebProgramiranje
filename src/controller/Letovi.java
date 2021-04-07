package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import dao.LetDAO;
import model.Let;
import model.User;

/**
 * Servlet implementation class Letovi
 */
@WebServlet("/Letovi")
public class Letovi extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Letovi() {
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

		List<model.Let> lets = new ArrayList<>();
		List<model.Let> letovi = new ArrayList<>();

		lets = LetDAO.getAllLet();
		if (loggedInUser == null) {
			int i = 1;
			for (Let let : lets) {

				if (!(let.getId() == i)) {
					letovi.add(let);
					
				}
			}

			lets.removeAll(letovi);
		}

		
		request.setAttribute("lets", lets);
		request.getRequestDispatcher("./LetSingle.jsp").forward(request, response);

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
