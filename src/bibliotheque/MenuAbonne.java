package bibliotheque;

import java.time.LocalDate;
import java.util.Calendar;
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
				System.out.println("1 : Par auteur\n2 : Par titre\n3 Par ISBN\n4 Consultation");
				Critere();
			}

		} catch (InputMismatchException e) {
			System.out.println("Choix 1 ou 2");
			Choix();
		}
	}

	public void Critere() throws Exception {

		try {
			int select = sc.nextInt();
			switch (select) {

			case 1:
				System.out.println("Donnez le nom de l'auteur");
				sc.nextLine();
				saisieCritereString = sc.nextLine();
				break;
			case 2:
				System.out.println("Donnez le titre du livre");
				sc.nextLine();
				saisieCritereString = sc.nextLine();
				break;
			case 3:
				System.out.println("Donnez l'ISBN du livre");
				sc.nextLine();
				saisieCritereISBN = sc.nextInt();
				break;
			case 4:
				LivreDao ild = new LivreDaoImpl();
				ild.findAll();
				break;
			}
		} catch (InputMismatchException e) {
			System.out.println("Choix 1, 2, 3 ou 4");
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
		if (e.getDateRetourEffective() != null)
		{
			violation = (e.getDateRetourEffective().after(e.getDateRetourPrevue())) ? "Rendu avec retard" : "Pas de violation";
		}
		
		return violation;
	}
}