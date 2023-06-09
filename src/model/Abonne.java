package model;

public class Abonne {

	private int numAbonne;
	private String nomAb;
	private String prenomAb;
	private String addressAb;
	private String telephoneAb;

	public Abonne(int numAbonne, String nomAb, String prenomAb, String addressAb, String telephoneAb) {
		super();
		this.numAbonne = numAbonne;
		this.nomAb = nomAb;
		this.prenomAb = prenomAb;
		this.addressAb = addressAb;
		this.telephoneAb = telephoneAb;
	}

	public int getNumAbonne() {
		return numAbonne;
	}

	public void setNumAbonne(int numAbonne) {
		this.numAbonne = numAbonne;
	}

	public String getNomAb() {
		return nomAb;
	}

	public void setNomAb(String nomAb) {
		this.nomAb = nomAb;
	}

	public String getPrenomAb() {
		return prenomAb;
	}

	public void setPrenomAb(String prenomAb) {
		this.prenomAb = prenomAb;
	}

	public String getAddressAb() {
		return addressAb;
	}

	public void setAddressAb(String addressAb) {
		this.addressAb = addressAb;
	}

	public String getTelephoneAb() {
		return telephoneAb;
	}

	public void setTelephoneAb(String telephoneAb) {
		this.telephoneAb = telephoneAb;
	}

	@Override
	public String toString() {
		return "{" +
			" numAbonne='" + getNumAbonne() + "'" +
			", nomAb='" + getNomAb() + "'" +
			", prenomAb='" + getPrenomAb() + "'" +
			", addressAb='" + getAddressAb() + "'" +
			", telephoneAb='" + getTelephoneAb() + "'" +
			"}";
	}

	public void prettyPrint() {
		System.out.printf("Abonné n°%d - %s %s, habitant à %s - Tel : %s\n", this.getNumAbonne(), this.getPrenomAb(), this.getNomAb(), this.getAddressAb(), this.getTelephoneAb());
	}

}
