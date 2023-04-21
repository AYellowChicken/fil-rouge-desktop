package bibliotheque;

public class Livre {
	
	public Livre(int isbnLivre, String titre, int numAuteur, String editeur, int nbrePages) {
		super();
		this.isbnLivre = isbnLivre;
		this.titre = titre;
		this.numAuteur = numAuteur;
		this.editeur = editeur;
		this.nbrePages = nbrePages;
	}
	public int getIsbnLivre() {
		return isbnLivre;
	}
	public void setIsbnLivre(int isbnLivre) {
		this.isbnLivre = isbnLivre;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public int getNumAuteur() {
		return numAuteur;
	}
	public void setNumAuteur(int numAuteur) {
		this.numAuteur = numAuteur;
	}
	public String getEditeur() {
		return editeur;
	}
	public void setEditeur(String editeur) {
		this.editeur = editeur;
	}
	public int getNbrePages() {
		return nbrePages;
	}
	public void setNbrePages(int nbrePages) {
		this.nbrePages = nbrePages;
	}
	
	private int isbnLivre;
    private String titre;
    private int numAuteur;
    private String editeur;
    private int nbrePages;
}
