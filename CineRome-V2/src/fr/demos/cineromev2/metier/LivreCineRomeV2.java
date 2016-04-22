package fr.demos.cineromev2.metier;



public class LivreCineRomeV2 extends ArticleCineRomeV2 {
	
	private String titre;
	private String auteur;
	private String editeur;
	private String genre;
	
	public LivreCineRomeV2(double prixHt, int stock, String designation, String reference, String titre, String auteur, String editeur, String genre) {
		super(prixHt, stock, designation, reference);
		this.titre = titre;
		this.auteur = auteur;
		this.editeur = editeur;
		this.genre = genre;
	}

	public String getTitre() {
		return titre;
	}

	public String getAuteur() {
		return auteur;
	}

	public String getEditeur() {
		return editeur;
	}

	public String getGenre() {
		return genre;
	}

	@Override
	public String toString() {
		return "Livre [Titre = " + getTitre() + ", Auteur = " + getAuteur() + ", Editeur = " + getEditeur()
				+ ", Genre = " + getGenre() + ", PrixHt = " + getPrixHt() + ", Stock = " + getStock()
				+ ", Designation = " + getDesignation() + ", Reference = " + getReference() + "]";
	}


		
}