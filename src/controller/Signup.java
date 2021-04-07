package controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDAO;
import model.User;
import model.User.Role;

/**
 * Servlet implementation class Signup
 */
@WebServlet("/Signup")
public class Signup extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Signup() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.sendRedirect("./Signup.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
				String username = request.getParameter("username");
				String password= request.getParameter("password");
				
				SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
				String datumRegistracije = sdf.format(new Date());
														
				String message = "Uspesno ste registrovani";
				
				
				try {
					if("".equals(username) || "".equals(password))
							throw new Exception("Popunite sva polja");
					
					User existingUser = UserDAO.get(username);
					if (existingUser != null)
							throw new Exception("Korisnicko ime: '"+ username + "  '  postoji u bazi");
					
					User newUser = new User(0, username, password,datumRegistracije,Role.user, false);
					
					UserDAO.add(newUser);
					
				}
				catch (Exception ex) {
					// TODO: handle exception
				
					message = ex.getMessage();
					
				}
				request.setAttribute("message", message);
				request.getRequestDispatcher("./Login.jsp").forward(request, response);
	}

}
