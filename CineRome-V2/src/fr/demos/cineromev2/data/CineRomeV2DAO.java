package fr.demos.cineromev2.data;

import java.sql.SQLException;
import java.util.List;
import fr.demos.cineromev2.metier.*;

public interface CineRomeV2DAO {

	void sauve(ArticleCineRomeV2 Ar) throws Exception;

//	void sauvePanier(PanierCineRomeV2 Pa) throws Exception;
//	
//	void removeItemCart(PanierCineRomeV2 Pa) throws Exception;

	List<ArticleCineRomeV2> rechercheTout() throws Exception;

	List<ArticleCineRomeV2> recherche(String critere) throws Exception;
	
	ArticleCineRomeV2 rechercheArticle(String reference) throws Exception;

	int nombre(String critere);
	
	void updateStock(int stock) throws Exception;

	void updateStock(ArticleCineRomeV2 article, int stock) throws Exception;
	
	public List<ArticleCineRomeV2> rechercheTout(String table) throws SQLException;
	
		
	void createCart(PanierCineRomeV2 Panier) throws Exception;
}
