package view;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import dao.AbonneDao;
import dao.AbonneDaoImpl;
import dao.AuteurDao;
import dao.AuteurDaoImpl;
import dao.EmpruntDao;
import dao.EmpruntDaoImpl;
import dao.LivreDao;
import dao.LivreDaoImpl;
import model.Abonne;
import model.Auteur;
import model.Livre;
import model.Scanner;

public class MenuEmploye {

	// Instancie DAO
	static java.util.Scanner sc = Scanner.getSc();
	static AbonneDao abonneDao = new AbonneDaoImpl();
	static LivreDao livreDao = new LivreDaoImpl();
	static AuteurDao auteurDao = new AuteurDaoImpl();
	static EmpruntDao EmpruntDao = new EmpruntDaoImpl();

	// Instancie clés de colonnes SQL et noms des colonnes utilisées pour le CRUD
	static LinkedHashMap<String, String> ABONNEFIELDS = new LinkedHashMap<>();
	static {
		ABONNEFIELDS.put("numéro abonné", "numabonne");
		ABONNEFIELDS.put("nom abonné", "nomab");
		ABONNEFIELDS.put("prenom abonné", "prenomab");
		ABONNEFIELDS.put("adresse abonné", "adresseab");
		ABONNEFIELDS.put("téléphone abonné", "telephoneab");
	}

	static LinkedHashMap<String, String> AUTEURFIELDS = new LinkedHashMap<>();
	static {
		AUTEURFIELDS.put("Numéro auteur", "numauteur");
		AUTEURFIELDS.put("nom auteur", "nomau");
		AUTEURFIELDS.put("prenom auteur", "prenomau");
		AUTEURFIELDS.put("nationalité auteur", "nationaliteau");
	}

	static LinkedHashMap<String, String> LIVREFIELDS = new LinkedHashMap<>();
	static {
		LIVREFIELDS.put("ISBN livre", "isbnlivre");
		LIVREFIELDS.put("Titre", "titre");
		LIVREFIELDS.put("Numéro auteur", "numauteur");
		LIVREFIELDS.put("Editeur", "editeur");
		LIVREFIELDS.put("Nombre de pages", "nbrepages");
	}
	
	static final String accueilMessage = "-Consulter / modifier / ajouter / supprimer abonné (1)\n-Consulter / modifier / ajouter / supprimer auteur (2)\n-Consulter / modifier / ajouter / supprimer livre (3)\n-Gérer emprunt (4)";

	public static void main(String[] args) {
        
        // Choose operation 1
        int choix = 0;
        do {
            System.out.println(accueilMessage);
            try {
                choix = sc.nextInt();
            } catch (NoSuchElementException e) {
                System.out.println("Saisie de type invalide.");
                sc.nextLine();
            }
        } while (choix != 1 && choix != 2 && choix != 3 && choix != 4);

        // Choose operation 2
        int choix2 = 0;
        do {
            try {
                switch(choix) {
                    case 1: // Abonné
                        montrerCRUD("abonné");
                        choix2 = sc.nextInt();
                        sc.nextLine(); // clean sc before we get next values
                        switch(choix2) {
                            case 1:
                                consulteAbonne();
                                break;
                            case 2:
                                modifieAbonne();
                                break;
                            case 3:
                                ajouteAbonne();
                                break;
                            case 4:
                                supprimeAbonne();
                                break;
                        }
                        break;
                    case 2: // Auteur
                        montrerCRUD("auteur");
                        choix2 = sc.nextInt(); 
                        sc.nextLine();
                        switch(choix2) {
                            case 1:
                                consulteAuteur();
                                break;
                            case 2:
                                modifieAuteur();
                                break;
                            case 3:
                                ajouteAuteur();
                                break;
                            case 4:
                                supprimeAuteur();
                                break;
                        }
                        break;
                    case 3: // Livre
                        montrerCRUD("livre");
                        choix2 = sc.nextInt();
                        sc.nextLine();
                        switch(choix2) {
                            case 1:
                                consulteLivre();
                                break;
                            case 2:
                                modifieLivre();
                                break;
                            case 3:
                                ajouteLivre();
                                break;
                            case 4:
                                supprimeLivre();
                                break;
                        }
                        break;
                    case 4:
                        gererEmprunt();
                        break;
                    default:
                        System.out.println("Saisie invalide. Choisissez 1, 2, 3, ou 4.");
                        break;
                }
            } catch (NoSuchElementException e) {
                System.out.println("Saisie de type invalide.");
                sc.nextLine();        
            }
        } while (choix2 != 1 && choix2 != 2 && choix2 != 3 && choix2 != 4);
    }

	// Fonction de display pour la loop
	public static void montrerCRUD(String objet) {
		System.out.println("-Consulter " + objet + " (1)");
		System.out.println("-Modifier " + objet + " (2)");
		System.out.println("-Ajouter " + objet + " (3)");
		System.out.println("-Supprimer " + objet + " (4)");
	}

	// Les fonctions CRUD commencent ici et utilisent les HashMap de criteres pour
	// effectuer la recherche SQL à l'aide de l'implémentation. Si pas de critère,
	// on sélectionne tout.
	public static void consulteAbonne() {
		LinkedHashMap<String, String> criteres = new LinkedHashMap<>();
		String critere;
		for (Map.Entry<String, String> entry : ABONNEFIELDS.entrySet()) {
			System.out.println("Critère " + entry.getKey() + " ?");
			critere = sc.nextLine();
			if (!critere.isEmpty()) {
				criteres.put(entry.getValue(), critere); // e.g. "{numabonne, 2}"
			}
		}
		List<Abonne> abonnes = abonneDao.consulte(criteres);
		for (Abonne abonne : abonnes) {
			abonne.prettyPrint();
		}
	}

	// TODO
	public static void modifieAbonne() {

	}

	public static void ajouteAbonne() {

	}

	public static void supprimeAbonne() {

	}

	public static void consulteAuteur() {
		LinkedHashMap<String, String> criteres = new LinkedHashMap<>();
		String critere;
		for (Map.Entry<String, String> entry : AUTEURFIELDS.entrySet()) {
			System.out.println("Critère " + entry.getKey() + " ?");
			critere = sc.nextLine();
			if (!critere.isEmpty()) {
				criteres.put(entry.getValue(), critere);
			}
		}
		List<Auteur> auteurs = auteurDao.consulte(criteres);
		for (Auteur auteur : auteurs) {
			auteur.prettyPrint();
		}
	}

	// TODO
	public static void modifieAuteur() {
		AuteurDaoImpl auteurDaoImpl = new AuteurDaoImpl();
		auteurDaoImpl.update();
	}

	public static void ajouteAuteur() {
		AuteurDaoImpl auteurDaoImpl = new AuteurDaoImpl();
		auteurDaoImpl.save();
	}

	public static void supprimeAuteur() {
		AuteurDaoImpl auteurDaoImpl = new AuteurDaoImpl();
		auteurDaoImpl.delete();
	}

	public static void consulteLivre() {
		LinkedHashMap<String, String> criteres = new LinkedHashMap<>();
		String critere;
		for (Map.Entry<String, String> entry : LIVREFIELDS.entrySet()) {
			System.out.println("Critère " + entry.getKey() + " ?");
			critere = sc.nextLine();
			if (!critere.isEmpty()) {
				criteres.put(entry.getValue(), critere);
			}
		}
		List<Livre> livres = livreDao.consulte(criteres);
		for (Livre livre : livres) {
			livre.prettyPrint();
		}

	}

	// TODO
	public static void modifieLivre() {

	}

	public static void ajouteLivre() {

	}

	public static void supprimeLivre() {

	}

	public static void gererEmprunt() {

	}

}
