package model;

public class Auteur {

	private int numAuteur;
	private String nomAu;
	private String prenomAu;
	private String nationaliteAu;

	public Auteur(int numAuteur, String nomAu, String prenomAu, String nationaliteAu) {
		super();
		this.numAuteur = numAuteur;
		this.nomAu = nomAu;
		this.prenomAu = prenomAu;
		this.nationaliteAu = nationaliteAu;
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

	public String getNationaliteAu() {
		return nationaliteAu;
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

	public void setNationaliteAu(String nationaliteAu) {
		this.nationaliteAu = nationaliteAu;
	}

	@Override
	public String toString() {
		return "{" +
			" numAuteur='" + getNumAuteur() + "'" +
			", nomAu='" + getNomAu() + "'" +
			", prenomAu='" + getPrenomAu() + "'" +
			", nationaliteAu='" + getNationaliteAu() + "'" +
			"}";
	}

	public void prettyPrint() {
		System.out.printf("Auteur n°%d - %s %s, de nationalité %s\n", this.getNumAuteur(), this.getPrenomAu(), this.getNomAu(), this.getNationaliteAu());
	}

}
