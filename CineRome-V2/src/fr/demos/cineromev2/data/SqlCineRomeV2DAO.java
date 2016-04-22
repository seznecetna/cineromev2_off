package fr.demos.cineromev2.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.annotation.WebServlet;
import javax.sql.DataSource;

import fr.demos.cineromev2.metier.ArticleCineRomeV2;
import fr.demos.cineromev2.metier.BluRayCineRomeV2;
import fr.demos.cineromev2.metier.DvdCineRomeV2;
import fr.demos.cineromev2.metier.LivreCineRomeV2;
import fr.demos.cineromev2.metier.PanierCineRomeV2;

/**
 * Servlet implementation class SqlCineRomeV2DAO
 */
@WebServlet("/SqlCineRomeV2DAO")
public class SqlCineRomeV2DAO implements CineRomeV2DAO {

	private DataSource ds = null;

	public SqlCineRomeV2DAO() throws Exception {
		// recherche dans l'annuaire du pool de connecetion (utilisation de la
		// livrairie JNDI)
		Context context = new InitialContext();
		ds = (DataSource) context.lookup("jdbc/appliCineRomeV2");

	}

	@Override
	public void sauve(ArticleCineRomeV2 unArticle) throws Exception {
		// on demande une connexion au pool
		Connection cx = ds.getConnection();
		// On va pouvoir préparer notre requête SQL
		PreparedStatement psmt = null;

		if (unArticle instanceof LivreCineRomeV2) {
			psmt = cx.prepareStatement("insert into livrecineromev2 values (?,?,?,?,?,?,?,?)");
			psmt.setString(5, ((LivreCineRomeV2) unArticle).getTitre());
			psmt.setString(6, ((LivreCineRomeV2) unArticle).getAuteur());
			psmt.setString(7, ((LivreCineRomeV2) unArticle).getEditeur());
			psmt.setString(8, ((LivreCineRomeV2) unArticle).getGenre());
		}

		if (unArticle instanceof DvdCineRomeV2) {
			psmt = cx.prepareStatement("insert into dvdcineromev2 values (?,?,?,?,?,?,?,?)");
			psmt.setString(5, ((DvdCineRomeV2) unArticle).getTitre());
			psmt.setString(6, ((DvdCineRomeV2) unArticle).getAuteur());
			psmt.setString(7, ((DvdCineRomeV2) unArticle).getEditeur());
			psmt.setString(8, ((DvdCineRomeV2) unArticle).getGenre());
		}
		if (unArticle instanceof BluRayCineRomeV2) {
			psmt = cx.prepareStatement("insert into bluray values (?,?,?,?,?,?,?,?,?)");
			psmt.setString(5, ((BluRayCineRomeV2) unArticle).getTitre());
			psmt.setString(6, ((BluRayCineRomeV2) unArticle).getTitre());
			psmt.setString(7, ((BluRayCineRomeV2) unArticle).getAuteur());
			psmt.setString(8, ((BluRayCineRomeV2) unArticle).getEditeur());
			psmt.setString(9, ((BluRayCineRomeV2) unArticle).getGenre());
		}

		// Statement stmt = cx.createStatement(à
		// stmt.executeUpdate("insert into climatisation values
		// ("+cl.getNomAppareil()+","+...
		psmt.setDouble(1, unArticle.getPrixHt());
		psmt.setInt(2, unArticle.getStock());
		psmt.setString(3, unArticle.getDesignation());
		psmt.setString(4, unArticle.getReference());

		psmt.executeUpdate();
		// on rend la connexion au pool
		cx.close();

	}

	@Override
	public List<ArticleCineRomeV2> rechercheTout() throws Exception {
		List<ArticleCineRomeV2> articles, livres, dvds, blurays;
		livres = rechercheTout("livrecineromev2");
		dvds = rechercheTout("dvdcineromev2");
		blurays = rechercheTout("bluray");

		articles = new ArrayList<ArticleCineRomeV2>();
		articles.addAll(livres);
		articles.addAll(dvds);
		articles.addAll(blurays);
		return articles;
		
		

	}

	public List<ArticleCineRomeV2> rechercheTout(String table) throws SQLException {
		Connection cx = ds.getConnection();
		PreparedStatement psmt = cx.prepareStatement("select * from " + table);
		ResultSet rs = psmt.executeQuery();
		ArrayList<ArticleCineRomeV2> liste = new ArrayList<>();
		while (rs.next()) {

			ArticleCineRomeV2 article = null;
			if (table.equals("livrecineromev2")) {
				Double prixHT = rs.getDouble(1);
				int stock = rs.getInt(2);
				String designation = rs.getString(3);
				String reference = rs.getString(4);
				String titre = rs.getString(4);
				String auteur = rs.getString(5);
				String editeur = rs.getString(6);
				String genre = rs.getString(7);

				article = new LivreCineRomeV2(prixHT, stock, designation, reference, titre, auteur, editeur, genre);
			}
			liste.add(article);
			cx.close();
			if (table.equals("dvdcineromev2")) {
				Double prixHT = rs.getDouble(1);
				int stock = rs.getInt(2);
				String designation = rs.getString(3);
				String reference = rs.getString(4);
				String titre = rs.getString(4);
				String auteur = rs.getString(5);
				String editeur = rs.getString(6);
				String genre = rs.getString(7);
				article = new DvdCineRomeV2(prixHT, stock, designation, reference, titre, auteur, editeur, genre);
			}
			liste.add(article);
			cx.close();

			if (table.equals("bluray")) {
				Double prixHT = rs.getDouble(1);
				int stock = rs.getInt(2);
				String designation = rs.getString(3);
				String reference = rs.getString(4);
				String realisateur = rs.getString(5);
				String titre = rs.getString(6);
				String auteur = rs.getString(7);
				String editeur = rs.getString(8);
				String genre = rs.getString(9);
				article = new BluRayCineRomeV2(prixHT, stock, designation, reference, realisateur, titre, auteur,
						editeur, genre);
			}
			liste.add(article);
			cx.close();
		}
		return liste;

	}

	@Override
	public List<ArticleCineRomeV2> recherche(String critere) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public ArticleCineRomeV2 rechercheArticle(String reference) throws Exception {
		List<ArticleCineRomeV2> articles;
		articles = this.rechercheTout();

		for (ArticleCineRomeV2 article : articles) {
			if (article.getReference().equals(reference))
				return article;
		}
		return null;
	}

	@Override
	public int nombre(String critere) {
		int nb = 0;
		try {

			// peu performant : en sql on peut demander directement le nb
			// d'elements
			List<ArticleCineRomeV2> liste = this.rechercheTout();
			nb = liste.size();
		} catch (Exception e) {
		}
		return nb;
	}

	// @Override
	// public void sauvePanier(PanierCineRomeV2 Pa) throws Exception {
	// Connection cx = ds.getConnection();
	// // On va pouvoir préparer notre requête SQL
	// PreparedStatement psmt = null;
	//
	// if (Pa instanceof LivreCineRomeV2) {
	// psmt = cx.prepareStatement("insert into livrecineromev2 values
	// (?,?,?,?,?,?,?,?)");
	// psmt.setString(6, ((LivreCineRomeV2) Pa).getTitre());
	// psmt.setString(7, ((LivreCineRomeV2) Pa).getAuteur());
	// psmt.setString(8, ((LivreCineRomeV2) Pa).getEditeur());
	// psmt.setString(9, ((LivreCineRomeV2) Pa).getGenre());
	// psmt.setString(1, ((BlurayCineRomeV2) Pa)."Livre";
	// }
	//
	// if (Pa instanceof DvdCineRomeV2) {
	// psmt = cx.prepareStatement("insert into dvdcineromev2 values
	// (?,?,?,?,?,?,?,?)");
	// psmt.setString(6, ((DvdCineRomeV2) Pa).getTitre());
	// psmt.setString(7, ((DvdCineRomeV2) Pa).getAuteur());
	// psmt.setString(8, ((DvdCineRomeV2) Pa).getEditeur());
	// psmt.setString(9, ((DvdCineRomeV2) Pa).getGenre());
	// psmt.setString(1, ((BlurayCineRomeV2) Pa)."DVD";
	// }
	// if (Pa instanceof BluRayCineRomeV2) {
	// psmt = cx.prepareStatement("insert into bluray values
	// (?,?,?,?,?,?,?,?,?,?)");
	// psmt.setString(6, ((BluRayCineRomeV2) Pa).getTitre());
	// psmt.setString(7, ((BluRayCineRomeV2) Pa).getTitre());
	// psmt.setString(8, ((BluRayCineRomeV2) Pa).getAuteur());
	// psmt.setString(9, ((BluRayCineRomeV2) Pa).getEditeur());
	// psmt.setString(10, ((BluRayCineRomeV2) Pa).getGenre());
	// psmt.setString(1, ((BlurayCineRomeV2) Pa)."Bluray";
	// }
	//
	// // Statement stmt = cx.createStatement(à
	// // stmt.executeUpdate("insert into climatisation values
	// // ("+cl.getNomAppareil()+","+...
	// psmt.setDouble(2, Pa.getPrixHt());
	// psmt.setInt(3, Pa.getStock());
	// psmt.setString(4, Pa.getDesignation());
	// psmt.setString(5, Pa.getReference());
	//
	// psmt.executeUpdate();
	// // on rend la connexion au pool
	// cx.close();
	//
	// }
	//
	// @Override
	// public void removeItemCart(PanierCineRomeV2 Pa) throws Exception {
	//
	// }

	@Override
	public void updateStock(ArticleCineRomeV2 article, int qte) throws Exception {
		article.actualiseStock(qte);

		Connection cx = ds.getConnection();
		// On va pouvoir préparer notre requête SQL
		PreparedStatement psmt = null;
		String table = "";

		if (article instanceof LivreCineRomeV2)
			table = "livrecineromev2";

		if (article instanceof DvdCineRomeV2)
			table = "dvdcineromev2";

		if (article instanceof BluRayCineRomeV2)
			table = "bluray";

		psmt = cx.prepareStatement("UPDATE " + table + " Set stock = " + 10 + " WHERE reference = "	+ "'"+article.getReference()+"'");
		psmt.executeUpdate();
		cx.close();

	}

	@Override
	public void updateStock(int stock) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void createCart(PanierCineRomeV2 Panier) throws Exception {
		// TODO Auto-generated method stub

	}

}
