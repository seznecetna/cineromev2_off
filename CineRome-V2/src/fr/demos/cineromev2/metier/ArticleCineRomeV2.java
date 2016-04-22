package fr.demos.cineromev2.metier;

import java.io.Serializable;

public class ArticleCineRomeV2 implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private double prixHt;
	private int stock;
	private String designation;
	private String reference;
	
	public ArticleCineRomeV2 (double prixHt, int stock, String designation, String reference) {
		this.prixHt = prixHt;
		this.stock = stock;
		this.designation = designation;
		this.reference = reference;
	}

	public double getPrixHt() {
		return prixHt;
	}

	public int getStock() {
		return stock;
	}

	public String getDesignation() {
		return designation;
	}

	public String getReference() {
		return reference;
	}
	
	public void actualiseStock(int qte) {
		this.stock += qte;
	}

	public void decremeter(int qte) {
		this.stock -= qte;  // TODO Auto-generated method stub
		
	}

	public void incrementer(int qte) {
		// TODO Auto-generated method stub
		this.stock += qte;
		
	}

	public boolean existe() {
		if (stock > 0)
			return true;
		return false;		
	}
		
}