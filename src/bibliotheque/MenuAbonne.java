package bibliotheque;

public class MenuAbonne {

	public static void main(String[] args) throws Exception {
		System.out.println("1 : Consulter la liste des emprunts\n2 : Chercher un livre");
		java.util.Scanner sc = Scanner.getSc();

		int saisieChoix;
		int saisieChoixCritere;
		String saisieCritereString;
		int saisieCritereISBN;
		
		do {
			saisieChoix = sc.nextInt();

			if (saisieChoix == 1) {
				System.out.println("consultation");

			} else if (saisieChoix == 2) {

				System.out.println("1 : Par auteur\n2 : Par titre\n3 Par ISBN\n4 Consultation");

				do {
					saisieChoixCritere = sc.nextInt();

					if (saisieChoixCritere == 1) {
						System.out.println("Donnez le nom de l'auteur");
						sc.nextLine();
						saisieCritereString = sc.nextLine();
						
					} else if (saisieChoixCritere == 2) {
						System.out.println("Donnez le titre du livre");
						sc.nextLine();
						saisieCritereString = sc.nextLine();

					} else if (saisieChoixCritere == 3) {
						System.out.println("Donnez l'ISBN du livre");
						sc.nextLine();
						saisieCritereISBN = sc.nextInt();
						System.out.println(saisieCritereISBN);
					} else if (saisieChoixCritere == 4) {
						LivreDao ild = new LivreDaoImpl();
						ild.findAll();
					}

				} while (saisieChoixCritere != 1 && saisieChoixCritere != 2 && saisieChoixCritere != 3 && saisieChoixCritere != 4);

			}

		} while (saisieChoix != 1 && saisieChoix != 2);

	}

}