package bibliotheque;

import java.util.Date;
import java.util.InputMismatchException;
import java.util.List;

public class MenuAbonne {

	int saisieChoix;
	int saisieChoixCritere;
	int saisieCritereISBN;
	String saisieCritereString;
	static java.util.Scanner sc = Scanner.getSc();

	public MenuAbonne() {
		super();
	}

	public static void main(String[] args) throws Exception {

		// appel static de la classe login
		Login.main(args);

		// menu
		MenuAbonne menu = new MenuAbonne();
		menu.Choix();
	}

	public void Choix() throws Exception {
		System.out.println("1 : Consulter la liste de vos emprunts\n2 : Chercher un livre");

		try {
			int select = sc.nextInt();
			switch (select) {

			case 1:
				EmpruntDao ed = new EmpruntDaoImpl();
				List<Emprunt> le = ed.findAll();

				for (Emprunt e : le) {

					// afficher la liste de tous ses emprunts et préciser pour chaque ligne si il a
					// violé les règles
					System.out.println(e.getNumAbonne() + " " + e.getIsbnLivre() + " " + e.getDateEmprunt() + " "
							+ e.getDateRetourEffective() + " " + e.getDateRetourPrevue() + " " + violation(e));
				}
				break;
			case 2:
				Critere();
			}

		} catch (InputMismatchException e) {
			System.out.println("Choix 1 ou 2");
			Choix();
		}
	}

	public void Critere() throws Exception {

		System.out.println("1 : Par auteur\n2 : Par titre\n3 Par ISBN\n4 Consultation");

		try {
			int select = sc.nextInt();
			switch (select) {

			case 1:
				System.out.println("Donnez le nom de l'auteur");
				sc.nextLine();
				saisieCritereString = sc.nextLine();
				LivreDao ldi1 = new LivreDaoImpl();
				List<Livre> ll1 = ldi1.findByAuthorName(saisieCritereString);
				if (ll1.isEmpty()) {
					System.out.println("Aucun livre ne correspond à ce nom d'auteur");
					sc.nextLine();
					Critere();
				}

				for (Livre l : ll1) {

					// afficher la liste de tous les livres qui correspondent au nom d'auteur saisi
					// par l'abonné
					// violé les règles
					System.out.println(l.getIsbnLivre() + " " + l.getEditeur() + " " + l.getNbrePages() + " "
							+ l.getNumAuteur() + " " + l.getTitre());
				}
				break;

			case 2:
				System.out.println("Donnez le titre du livre");
				sc.nextLine();
				saisieCritereString = sc.nextLine();
				LivreDao ldi2 = new LivreDaoImpl();
				List<Livre> ll2 = ldi2.findByTitle(saisieCritereString);

				if (ll2.isEmpty()) {
					System.out.println("Aucun livre ne correspond à ce titre");
					sc.nextLine();
					Critere();
				}

				for (Livre l : ll2) {

					// afficher la liste de tous les livres qui correspondent au nom d'auteur saisi
					// par l'abonné
					// violé les règles
					System.out.println(l.getIsbnLivre() + " " + l.getEditeur() + " " + l.getNbrePages() + " "
							+ l.getNumAuteur() + " " + l.getTitre());
				}
				break;
			case 3:
				System.out.println("Donnez l'ISBN du livre");
				sc.nextLine();
				saisieCritereISBN = sc.nextInt();
				LivreDao ldi3 = new LivreDaoImpl();
				List<Livre> ll3 = ldi3.findByIsbn(saisieCritereISBN);

				if (ll3.isEmpty()) {
					System.out.println("Aucun livre ne correspond à cet identifiant ISBN");
					sc.nextLine();
					Critere();
				}

				for (Livre l : ll3) {

					// afficher la liste de tous les livres qui correspondent au nom d'auteur saisi
					// par l'abonné
					// violé les règles
					System.out.println(l.getIsbnLivre() + " " + l.getEditeur() + " " + l.getNbrePages() + " "
							+ l.getNumAuteur() + " " + l.getTitre());
				}
				break;
			case 4:
				LivreDao ldi4 = new LivreDaoImpl();
				ldi4.findAll();
				break;
			}
		} catch (InputMismatchException e) {
			System.out.println("Mauvaise saisie");
			sc.nextLine();
			Critere();
		}
	}

	public String violation(Emprunt e) {

		String violation = "Pas de violation";
		Date today = new Date();

		// Recherche violation de type à retourner
		if (e.getDateRetourEffective() == null && (today.after(e.getDateRetourPrevue()))) {
			violation = "Doit être retourné";
		}

		// Recherche de violation de type retourné avec retard
		if (e.getDateRetourEffective() != null) {
			violation = (e.getDateRetourEffective().after(e.getDateRetourPrevue())) ? "Rendu avec retard"
					: "Pas de violation";
		}

		return violation;
	}
}