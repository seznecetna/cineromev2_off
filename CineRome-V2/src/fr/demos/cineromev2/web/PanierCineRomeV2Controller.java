package fr.demos.cineromev2.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.demos.cineromev2.data.CineRomeV2DAO;
import fr.demos.cineromev2.data.SqlCineRomeV2DAO;
import fr.demos.cineromev2.metier.ArticleCineRomeV2;
import fr.demos.cineromev2.metier.PanierCineRomeV2;

/**
 * Servlet implementation class PanierCineRomeV2
 */
@WebServlet("/PanierCineRomeV2Controller")
public class PanierCineRomeV2Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PanierCineRomeV2Controller() {
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
		RequestDispatcher rd = request.getRequestDispatcher("/listePanier.jsp");
		rd.forward(request, response);
		
		HttpSession session = request.getSession();
		PanierCineRomeV2 panier = (PanierCineRomeV2) session.getAttribute("panier");
		List<ArticleCineRomeV2> listePanier = null;
		CineRomeV2DAO listePanierSql = null;
		try {
			listePanierSql = new SqlCineRomeV2DAO();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			listePanier = panier.getListePanier();
			listePanier = listePanierSql.rechercheTout();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		session.setAttribute("listePanier", listePanier);
		//rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		

		PanierCineRomeV2 newPanier = null;

		// RequestDispatcher rd =
		// request.getRequestDispatcher("/listePanier.jsp");
		String validate = request.getParameter("paniervalide");

		if (validate != null && validate.equals("validation")) {
			 {
				try {
					CineRomeV2DAO dao = new SqlCineRomeV2DAO();
					dao.createCart(newPanier);
					System.out.println("creation ok");
					RequestDispatcher rd = request.getRequestDispatcher("/panierSucces.jsp");
					rd.forward(request, response);
					
				}

				catch (Exception e) {
					e.printStackTrace();
				}

			}
		}
		boolean erreur;
		String rmItem = request.getParameter("rmItem");
		String reference = request.getParameter("reference");
		ArticleCineRomeV2 article;
		
		if (rmItem != null && rmItem.equals("rmItem")) {
			String Qtys = request.getParameter("Qty");
			request.setAttribute("Qte", Qtys);
			erreur = false;
			
			int Qtes = 0;
			try {
				Qtes = Integer.parseInt(Qtys);
			} catch (NumberFormatException ex) {
				erreur = true;
				request.setAttribute("QtyErreur", "erreur de saissie");

			}
			if (!erreur) {

				// RequestDispatcher rd =
				// request.getRequestDispatcher("/PanierCineRomeV2Controller");
				// rd.forward(request, response);
				try {
					// CineRomeV2DAO dao2 = new SqlCineRomeV2DAO();
					// dao.sauvePanier(newAddItem);
					HttpSession session = request.getSession();
					PanierCineRomeV2 panier = (PanierCineRomeV2) session.getAttribute("panier");

					panier.retirerArticleReference(reference, Qtes);
//					RequestDispatcher rd = request.getRequestDispatcher("/PanierCineRomeV2Controller");
//					rd.forward(request, response);
					System.out.println("RMSQL panier");
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		}
	}
}