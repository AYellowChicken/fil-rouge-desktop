package bibliotheque;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

// import java.util.function.Function;
// Map<String, Function<Object, Void>> requestHandlers = new HashMap<>();
// requestHandlers.put("GET", this:consulteAbonne);
// Without parameters : Map<String, Runnable> requestHandlers = new HashMap<>();

public class MenuEmploye {

    static java.util.Scanner sc = Scanner.getSc();
    static AbonneDao abonneDao = new AbonneDaoImpl();
    static LivreDao livreDao = new LivreDaoImpl();
    static AuteurDao auteurDao = new AuteurDaoImpl();
    static EmpruntDao EmpruntDao = new EmpruntDaoImpl();

    static LinkedHashMap<String, String> ABONNEFIELDS = new LinkedHashMap<>();
    static { 
        ABONNEFIELDS.put("numéro abonné", "numabonne");
        ABONNEFIELDS.put("nom abonné", "nomab");
        ABONNEFIELDS.put("prenom abonné", "prenomab");
        ABONNEFIELDS.put("adresse abonné", "adresseab");
        ABONNEFIELDS.put("téléphone abonné", "telephoneab");
    }

    public static void montrerAccueil() {
        System.out.println("-Consulter / modifier / ajouter / supprimer abonné (1)");
        System.out.println("-Consulter / modifier / ajouter / supprimer auteur (2)");
        System.out.println("-Consulter / modifier / ajouter / supprimer livre (3)");
        System.out.println("-Gérer emprunt (4)");
    }

    public static void montrerCRUD(String objet) {
        System.out.println("-Consulter " + objet + " (1)");
        System.out.println("-Modifier " + objet + " (2)");
        System.out.println("-Ajouter " + objet + " (3)");
        System.out.println("-Supprimer " + objet + " (4)");
    }

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

    public static void modifieAbonne() {

    }
    
    public static void ajouteAbonne() {

    }
    
    public static void supprimeAbonne() {

    }

    public static void consulteAuteur() {

    }
    
    public static void modifieAuteur() {
    
    }
    
    public static void ajouteAuteur() {
    
    }
    
    public static void supprimeAuteur() {
    
    }

    public static void consulteLivre() {

    }
    
    public static void modifieLivre() {
    
    }
    
    public static void ajouteLivre() {
    
    }
    
    public static void supprimeLivre() {
    
    }

    public static void gererEmprunt() {

    }

    // We get the choix int.
    // We can associate it with a string from an enum.
    // We can also use it to call a handler based on a hashmap. Right now, the handler is inside the switch case
    // The current handler does 3 things : Display current state (asking for next choice), take next choice, run corresponding function.
    // We could simplify this code by taking the choix int, getting the handler function that does... but it's really a bother. Let's just go with the classic shit. Java isn't made for this kind of annoying loops anyway.
    
    // 1. Display current state : CRUD Choice
    // 2. Take next choice
    // 3. Run handler/nested handler

    public static void main(String[] args) {
        
        // Choose operation 1
        int choix = 0;
        do {
            montrerAccueil();
            try {
                choix = sc.nextInt();
            } catch (NoSuchElementException e) {
                System.out.println("Saisie de type invalide.");
                sc.nextLine();
                montrerAccueil();
            }
        } while (choix != 1 && choix != 2 && choix != 3 && choix != 4);

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
            

}
