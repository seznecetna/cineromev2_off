package fr.demos.cineromev2.metier;

public class DvdCineRomeV2 extends ArticleCineRomeV2 {

	String titre;
	String auteur;
	String editeur;
	String genre;

	
	public DvdCineRomeV2(double prixHt, int stock, String designation, String reference, String titre, String auteur, String editeur, String genre) {
		super(prixHt, stock, designation, reference);
		this.titre = titre;
		this.auteur = auteur;
		this.editeur = editeur;
		this.genre = genre;
	}
	
	
	


	public String getTitre() {
		return titre;
	}





	public void setTitre(String titre) {
		this.titre = titre;
	}





	public String getAuteur() {
		return auteur;
	}





	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}





	public String getEditeur() {
		return editeur;
	}





	public void setEditeur(String editeur) {
		this.editeur = editeur;
	}





	public String getGenre() {
		return genre;
	}





	public void setGenre(String genre) {
		this.genre = genre;
	}





	@Override
	public String toString() {
		return "DvdCineRome [titre=" + titre + ", auteur=" + auteur + ", editeur=" + editeur + ", genre=" + genre
				+ ", getPrixHt()=" + getPrixHt() + ", getStock()=" + getStock() + ", getDesignation()="
				+ getDesignation() + ", getReference()=" + getReference() + "]";
	}
	
	
}
