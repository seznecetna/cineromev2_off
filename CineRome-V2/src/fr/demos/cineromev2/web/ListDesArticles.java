package fr.demos.cineromev2.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.demos.cineromev2.data.CineRomeV2DAO;
import fr.demos.cineromev2.data.FileCineRomeV2DAO;
import fr.demos.cineromev2.data.SqlCineRomeV2DAO;
import fr.demos.cineromev2.metier.ArticleCineRomeV2;
import fr.demos.cineromev2.metier.PanierCineRomeV2;

/**
 * Servlet implementation class ListDesArticles
 */
@WebServlet("/ListDesArticles")
public class ListDesArticles extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ListDesArticles() {
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
		// response.getWriter().append("Served at:
		// ").append(request.getContextPath());
		RequestDispatcher rd = request.getRequestDispatcher("/listeArticle.jsp");
		List<ArticleCineRomeV2> listArticles = null;
		CineRomeV2DAO articleDao;
		articleDao = null;
		try {
			articleDao = new SqlCineRomeV2DAO();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			listArticles = articleDao.rechercheTout();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("listArticles", listArticles);
		rd.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);
		boolean erreur = false;
		String addItem = request.getParameter("addItem");
		String reference = request.getParameter("reference");
		ArticleCineRomeV2 article;

		if (addItem != null && addItem.equals("Ajouter")) {
			System.out.println("je suis sur le bouton");
			String Qty = request.getParameter("Qty");
			request.setAttribute("Qte", Qty);

			int Qte = 0;

			try {
				Qte = Integer.parseInt(Qty);
				System.out.println("quantité ok");
			} catch (NumberFormatException ex) {
				erreur = true;
				request.setAttribute("QtyErreur", "erreur de saissie");

			}
			if (!erreur) {
				// System.out.println(Qte);
				// RequestDispatcher rd =
				// request.getRequestDispatcher("/PanierCineRomeV2Controller");
				// rd.forward(request, response);

				try {
					// CineRomeV2DAO dao2 = new SqlCineRomeV2DAO();
					// dao.sauvePanier(newAddItem);
					CineRomeV2DAO dao = new SqlCineRomeV2DAO();
					article = dao.rechercheArticle(reference);
					HttpSession session = request.getSession();
					PanierCineRomeV2 panier = (PanierCineRomeV2) session.getAttribute("panier");
					if (panier == null) {
						PanierCineRomeV2 newpanier = new PanierCineRomeV2();
						session.setAttribute("panier", newpanier);
					}
					panier = (PanierCineRomeV2) session.getAttribute("panier");
					System.out.println("panier : " + panier);
					panier.ajouterArticle(article, Qte);
					System.out.println("Ajout article dans panier");
//					RequestDispatcher rd = request.getRequestDispatcher("/listeArticle.jsp");
//					rd.forward(request, response);
					System.out.println("sauveSQL panier");
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		}
		
		
		String accesPanier = request.getParameter("action");
		if (accesPanier != null && accesPanier.equals("Voir mon panier")) {
			RequestDispatcher rd = request.getRequestDispatcher("/listePanier.jsp");
			rd.forward(request, response);
		}
	}
}

// doGet(request, response);
// RequestDispatcher rd =
// request.getRequestDispatcher("/listClimatisation.jsp");
// rd.forward(request, response);
