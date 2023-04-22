package bibliotheque;

import java.util.InputMismatchException;

public class MenuAbonne {

	int saisieChoix;
	int saisieChoixCritere;
	int saisieCritereISBN;
	String saisieCritereString;
	java.util.Scanner sc = Scanner.getSc();

	public MenuAbonne() {
		super();
	}

	public static void main(String[] args) throws Exception {

		// login
		Login login = new Login();
		login.main(args);

		// menu
		MenuAbonne menu = new MenuAbonne();
		menu.Choix();
	}
	
	public void Choix() throws Exception {
		System.out.println("1 : Consulter la liste des emprunts\n2 : Chercher un livre");

		try {
			int select = sc.nextInt();
			switch (select) {

			case 1:
				System.out.println("Liste des emprunts");
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
			case 3:
				System.out.println("Donnez l'ISBN du livre");
				sc.nextLine();
				saisieCritereISBN = sc.nextInt();
			case 4:
				LivreDao ild = new LivreDaoImpl();
				ild.findAll();
			}
		} catch (InputMismatchException e) {
			System.out.println("Choix 1, 2, 3 ou 4");
			Critere();
		}
	}
}