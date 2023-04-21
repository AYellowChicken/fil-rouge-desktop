package bibliotheque;

public class Auteur {
	
	private int numAuteur;
    private String nomAu;
    private String prenomAu;
    
	public Auteur(int numAuteur, String nomAu, String prenomAu) {
		super();
		this.numAuteur = numAuteur;
		this.nomAu = nomAu;
		this.prenomAu = prenomAu;
	}
    
	public int getNumAuteur() {
		return numAuteur;
	}
	public void setNumAuteur(int numAuteur) {
		this.numAuteur = numAuteur;
	}
	public String getNomAu() {
		return nomAu;
	}
	public void setNomAu(String nomAu) {
		this.nomAu = nomAu;
	}
	public String getPrenomAu() {
		return prenomAu;
	}
	public void setPrenomAu(String prenomAu) {
		this.prenomAu = prenomAu;
	}
}
