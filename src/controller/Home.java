package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

import dao.AerodromDAO;
import dao.LetDAO;
import model.Aerodrom;
import model.Let;

/**
 * Servlet implementation class Home
 */
@WebServlet("/Home")
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Home() {
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

		List<Aerodrom> aerodroms = AerodromDAO.getAllAeordrom();

		List<model.Let> lets = new ArrayList<>();

		lets = LetDAO.getAllLet();

	
		request.setAttribute("aerodroms", aerodroms);
		request.setAttribute("lets", lets);
		request.getRequestDispatcher("./Let.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String action = request.getParameter("action");
		List<Aerodrom> aerodroms = new ArrayList<>();
		
		String cenaKarte = request.getParameter("cenaKarte");
		String brojPolaska= request.getParameter("brojPolaska");
		String PolazniAerodrom= request.getParameter("PolazniAerodrom");
	
		String dolazniAerodrom = request.getParameter("dolazniAerodrom");
		
		String datumPolaska= request.getParameter("datumPolaska");
		String datumDolaska = request.getParameter("datumDolaska");
		List<model.Let> lets = LetDAO.getAllLet();
		aerodroms = AerodromDAO.getAllAeordrom();
		String searchInput = request.getParameter("searchInput");
		String sortBy = request.getParameter("sortBy");
		
		String polazniAerodromTrazi = request.getParameter("polazniAerodromTrazi");

		
		String dolazniAerodromTrazi = request.getParameter("dolazniAerodromTrazi");
		
			System.out.println(polazniAerodromTrazi +"polazni " + dolazniAerodromTrazi +  "dolazni");
		int filterCount = 0;
		
		if (cenaKarte != null) {
			filterCount += 1;
			try {
				double midNumber = Integer.parseInt(searchInput);
				double startRange = midNumber - (midNumber * 0.15);
				double endRange = midNumber + (midNumber * 0.15);
				
				List<Let> toRemove = new ArrayList<>();
				for (Let let : lets) {
					if (let.getCenaKarte() > endRange || let.getCenaKarte() < startRange) {
						toRemove.add(let);
					}
				}
				lets.removeAll(toRemove);
			}
			catch (Exception ex) {
			}
		}
		if (brojPolaska != null) {
			filterCount += 1;
			try {
				double midNumber = Integer.parseInt(searchInput);
				double startRange = midNumber - (midNumber * 0.15);
				double endRange = midNumber + (midNumber * 0.15);
				
				List<Let> toRemove = new ArrayList<>();
				for (Let let : lets) {
					if (let.getBroj() > endRange || let.getBroj() < startRange) {
						toRemove.add(let);
					}
				}
				lets.removeAll(toRemove);
			}
			catch (Exception ex) {
			}
		}
		
		if (action != null) {
			switch (action) {


			case "trazi":
				int polazniAerodromTraziInt = Integer.parseInt(polazniAerodromTrazi);
				int dolazniAerodromTraziInt = Integer.parseInt(dolazniAerodromTrazi);

				List<Let> toRemove = new ArrayList<>();
				if (polazniAerodromTrazi != null && dolazniAerodromTrazi != null) {

					for (Let let : lets) {

						if (!(let.getPolazniAerodrom().getId() == polazniAerodromTraziInt
								&& let.getDolazniAerodrom().getId() == dolazniAerodromTraziInt)) {
							toRemove.add(let);

						}
					}

					lets.removeAll(toRemove);

				}
				break;
			}

		}

		String usernameFilter = request.getParameter("usernameFilter");

		if (usernameFilter != null) {
			List<Let> toRemove = new ArrayList<>();

			for (Let let : lets) {
				if (!(let.getPolazniAerodrom().getNaziv().toLowerCase().contains(searchInput.toLowerCase()))) {
					toRemove.add(let);
				}
			}
			lets.removeAll(toRemove);
		}

		if (usernameFilter == null && searchInput != null) {
			searchInput = searchInput.trim();
			List<Let> toRemove = new ArrayList<>();
			for (Let let : lets) {

				if (!(let.getPolazniAerodrom().getNaziv().toLowerCase().contains(searchInput.toLowerCase()))) {
					toRemove.add(let);

				}
			}
			lets.removeAll(toRemove);

		}
		

		if (cenaKarte != null && filterCount == 1) {
			int swap = 0;
			do {
				swap = 0;
				for (int i = 0; i < lets.size() - 1; i++) {
					Let tmp = lets.get(i);
					int views = lets.get(i).getCenaKarte();
					int viewsPlus = lets.get(i + 1).getCenaKarte();
					
					if ("true".equals(sortBy)) {
						if (views > viewsPlus) {
							lets.set(i, lets.get(i + 1));
							lets.set(i + 1, tmp);
							swap++;
						}
					}
					if ("false".equals(sortBy)) {
						if (views < viewsPlus) {
							lets.set(i, lets.get(i + 1));
							lets.set(i + 1, tmp);
							swap++;
						}
					}
				}
			}
			while (swap > 0);
		}
		if (brojPolaska != null && filterCount == 1) {
			int swap = 0;
			do {
				swap = 0;
				for (int i = 0; i < lets.size() - 1; i++) {
					Let tmp = lets.get(i);
					int views = lets.get(i).getBroj();
					int viewsPlus = lets.get(i + 1).getBroj();
					
					if ("true".equals(sortBy)) {
						if (views > viewsPlus) {
							lets.set(i, lets.get(i + 1));
							lets.set(i + 1, tmp);
							swap++;
						}
					}
					if ("false".equals(sortBy)) {
						if (views < viewsPlus) {
							lets.set(i, lets.get(i + 1));
							lets.set(i + 1, tmp);
							swap++;
						}
					}
				}
			}
			while (swap > 0);
		}

		
		
		
		    if (PolazniAerodrom != null) {

		        if ("true".equals(sortBy)) {
		          Collections.sort(lets, new Comparator<Let>() {
		            @Override
		            public int compare(Let u1, Let u2) {
		              return u1.getPolazniAerodrom().getNaziv().compareTo(u2.getPolazniAerodrom().getNaziv());
		            }
		          });

		        }
		        if ("false".equals(sortBy)) {
		          Collections.sort(lets, new Comparator<Let>() {
		            @Override
		            public int compare(Let u1, Let u2) {
		              return u2.getPolazniAerodrom().getNaziv().compareTo(u1.getPolazniAerodrom().getNaziv());
		            }
		          });
		        

		      }
			

			}
			
		    if (dolazniAerodrom != null) {

		        if ("true".equals(sortBy)) {
		          Collections.sort(lets, new Comparator<Let>() {
		            @Override
		            public int compare(Let u1, Let u2) {
		              return u1.getDolazniAerodrom().getNaziv().compareTo(u2.getDolazniAerodrom().getNaziv());
		            }
		          });

		        }
		        if ("false".equals(sortBy)) {
		          Collections.sort(lets, new Comparator<Let>() {
		            @Override
		            public int compare(Let u1, Let u2) {
		              return u2.getDolazniAerodrom().getNaziv().compareTo(u1.getDolazniAerodrom().getNaziv());
		            }
		          });
		        

		      }
			

			}
			
		    if (datumPolaska != null) {

		        if ("true".equals(sortBy)) {
		          Collections.sort(lets, new Comparator<Let>() {
		            @Override
		            public int compare(Let u1, Let u2) {
		              return u1.getDatumPolaska().compareTo(u2.getDatumPolaska());
		            }
		          });

		        }
		        if ("false".equals(sortBy)) {
		          Collections.sort(lets, new Comparator<Let>() {
		            @Override
		            public int compare(Let u1, Let u2) {
		              return u2.getDatumPolaska().compareTo(u1.getDatumPolaska());
		            }
		          });
		        

		      }
			

			}
		
		    if (datumDolaska != null) {

		        if ("true".equals(sortBy)) {
		          Collections.sort(lets, new Comparator<Let>() {
		            @Override
		            public int compare(Let u1, Let u2) {
		              return u1.getDatumDolaska().compareTo(u2.getDatumDolaska());
		            }
		          });

		        }
		        if ("false".equals(sortBy)) {
		          Collections.sort(lets, new Comparator<Let>() {
		            @Override
		            public int compare(Let u1, Let u2) {
		              return u2.getDatumDolaska().compareTo(u1.getDatumDolaska());
		            }
		          });
		        

		      }
			

			}
		    
		request.setAttribute("aerodroms", aerodroms);
		request.setAttribute("lets", lets);
		request.getRequestDispatcher("./Let.jsp").forward(request, response);
	}

	}
