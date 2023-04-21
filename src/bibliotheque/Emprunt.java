package bibliotheque;

import java.util.Date;

public class Emprunt {
	 public Emprunt(int numAbonne, int isbnLivre, Date dateEmprunt, Date dateRetourPrevue, Date dateRetourEffective) {
		super();
		this.numAbonne = numAbonne;
		this.isbnLivre = isbnLivre;
		this.dateEmprunt = dateEmprunt;
		this.dateRetourPrevue = dateRetourPrevue;
		this.dateRetourEffective = dateRetourEffective;
	}
	public int getNumAbonne() {
		return numAbonne;
	}
	public void setNumAbonne(int numAbonne) {
		this.numAbonne = numAbonne;
	}
	public int getIsbnLivre() {
		return isbnLivre;
	}
	public void setIsbnLivre(int isbnLivre) {
		this.isbnLivre = isbnLivre;
	}
	public Date getDateEmprunt() {
		return dateEmprunt;
	}
	public void setDateEmprunt(Date dateEmprunt) {
		this.dateEmprunt = dateEmprunt;
	}
	public Date getDateRetourPrevue() {
		return dateRetourPrevue;
	}
	public void setDateRetourPrevue(Date dateRetourPrevue) {
		this.dateRetourPrevue = dateRetourPrevue;
	}
	public Date getDateRetourEffective() {
		return dateRetourEffective;
	}
	public void setDateRetourEffective(Date dateRetourEffective) {
		this.dateRetourEffective = dateRetourEffective;
	}
	private int numAbonne;
	    private int isbnLivre;
	    private Date dateEmprunt;
	    private Date dateRetourPrevue;
	    private Date dateRetourEffective;
}
