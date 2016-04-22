package fr.demos.cineromev2.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.demos.cineromev2.data.CineRomeV2DAO;
import fr.demos.cineromev2.data.FileCineRomeV2DAO;
import fr.demos.cineromev2.data.SqlCineRomeV2DAO;
import fr.demos.cineromev2.metier.BluRayCineRomeV2;
import fr.demos.cineromev2.metier.DvdCineRomeV2;
import fr.demos.cineromev2.metier.LivreCineRomeV2;

/**
 * Servlet implementation class CineRomeV2Controller
 */
@WebServlet("/CineRomeV2Controller")
public class CineRomeV2Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CineRomeV2Controller() {
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
		RequestDispatcher rd = request.getRequestDispatcher("/saisieArticle.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("POST - CineRomeV2Controller");
		boolean erreur = false;
		// ArrayList<String> erreurs = new ArrayList<>();
		// request.setAttribute("erreurs", erreurs);
		RequestDispatcher rd = request.getRequestDispatcher("/saisieArticle.jsp");
		String validate = request.getParameter("action");

		if (validate != null && validate.equals("Valider")) {
			String prixHT2 = request.getParameter("prixHT");
			String stock2 = request.getParameter("stock");
			String designation = request.getParameter("designation");
			String reference = request.getParameter("reference");
			String realisateur = request.getParameter("realisateur");
			String titre = request.getParameter("titre");
			String auteur = request.getParameter("auteur");
			String editeur = request.getParameter("editeur");
			String genre = request.getParameter("genre");

			// Garder les valeurs precedement tapées

			request.setAttribute("prixHT", prixHT2);
			request.setAttribute("stock", stock2);
			request.setAttribute("designation", designation);
			request.setAttribute("reference", reference);
			request.setAttribute("realisateur", realisateur);
			request.setAttribute("titre", titre);
			request.setAttribute("auteur", auteur);
			request.setAttribute("editeur", editeur);
			request.setAttribute("genre", genre);

			// conversion

			double prixHT = 0;
			int stock = 0;
			System.out.println("prixHT2 " + prixHT2);
			try {
				prixHT = Double.parseDouble(prixHT2);
				// annee = Long.parseLong(year);
				// temperature = Double.parseDouble(temp);

			} catch (NumberFormatException ex) {
				erreur = true;
				request.setAttribute("prixHTErreur", "erreur de saissie");

			}
			try {

				stock = Integer.parseInt(stock2);

			} catch (NumberFormatException ex) {
				erreur = true;
				request.setAttribute("stockErreur", "erreur de saisie");

			}

			// fin de conversion

			if (titre == null || titre.equals("")) {
				erreur = true;
				request.setAttribute("Appareil Erreur", "titre obligatoire");
			}

			if (prixHT < 0) {
				erreur = true;
				request.setAttribute("prixHTErreur", "Le prix doit être supérieur à 0");
			}

			if (stock < 0) {
				erreur = true;
				request.setAttribute("stockErreur", "Le stock doit être supérieur ou égal à 0");
			}

			if (designation == null || designation.equals("")) {
				erreur = true;
				request.setAttribute("designationErreur", "Veuillez rentrer une désignation");
			}

			if (reference == null || reference.equals("")) {
				erreur = true;
				request.setAttribute("referenceErreur", "Veuillez rentrer la référence");
			}

			if (realisateur == null || realisateur.equals("")) {
				erreur = true;
				request.setAttribute("realisateurErreur", "Veuillez rentrer un réalisateur");
			}

			if (auteur == null || auteur.equals("")) {
				erreur = true;
				request.setAttribute("auteurErreur", "Veuillez rentrer un auteur");
			}

			if (editeur == null || editeur.equals("")) {
				erreur = true;
				request.setAttribute("editeurErreur", "Veuillez rentrer un éditeur");
			}

			if (genre == null || genre.equals("")) {
				erreur = true;
				request.setAttribute("genreErreur", "Veuillez rentrer un genre");
			}

			if (!erreur) {
				String choixType = request.getParameter("typeArticle");

				if (choixType != null && choixType.equals("Livre")) {
					LivreCineRomeV2 livre = new LivreCineRomeV2(prixHT, stock, designation, reference, titre, auteur,
							editeur, genre);
					try {
						CineRomeV2DAO dao = new SqlCineRomeV2DAO();
						dao.sauve(livre);
						System.out.println("sauveSQL");
					} catch (Exception e) {
						e.printStackTrace();
					}

//					try {
//						CineRomeV2DAO dao = new FileCineRomeV2DAO();
//						dao.sauve(livre);
//						System.out.println("sauveFILE");
//					} catch (Exception e) {
//						e.printStackTrace();
//					}
					rd = request.getRequestDispatcher("/succesSaisieArticleCineRomeV2.jsp");
				}

				else if (choixType != null && choixType.equals("DVD")) {
					DvdCineRomeV2 dvd = new DvdCineRomeV2(prixHT, stock, designation, reference, titre, auteur, editeur,
							genre);
					try {
						CineRomeV2DAO dao = new SqlCineRomeV2DAO();
						dao.sauve(dvd);
						System.out.println("sauve");
					} catch (Exception e) {
						e.printStackTrace();
					}

//					try {
//						CineRomeV2DAO dao = new FileCineRomeV2DAO();
//						dao.sauve(dvd);
//						System.out.println("sauve");
//					} catch (Exception e) {
//						e.printStackTrace();
//					}
					rd = request.getRequestDispatcher("/succesSaisieArticleCineRomeV2.jsp");
				} else {
					BluRayCineRomeV2 blr = new BluRayCineRomeV2(prixHT, stock, designation, reference, realisateur,
							titre, auteur, editeur, genre);
					 try {
					 CineRomeV2DAO dao = new SqlCineRomeV2DAO();
					 dao.sauve(blr);
					 System.out.println("sauve");
					 } catch (Exception e) {
					 e.printStackTrace();
					 }
					
//					try {
//						CineRomeV2DAO dao = new FileCineRomeV2DAO();
//						dao.sauve(blr);
//						System.out.println("sauve");
//					} catch (Exception e) {
//						e.printStackTrace();
//					}
					rd = request.getRequestDispatcher("/succesSaisieArticleCineRomeV2.jsp");
				}
			}

			// PrintWriter out = response.getWriter();
			// out.println("<html>");
			// out.println("<body>");
			// out.println("<p>");

		}
		// String check = request.getParameter("checkList");
		// if (check != null && check.equals("Valider")) {
		//
		// }

		// RequestDispatcher rd =
		// request.getRequestDispatcher("/saisieClimatisation.jsp");
		rd.forward(request, response);

	}
}

/**
 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
 *      response)
 */
