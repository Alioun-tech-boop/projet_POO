
public class Main {

    private static int totalTests = 0;
    private static int testsReussis = 0;
    private static int testsEchoues = 0;

    // Affichage du résultat d'un test
    public static void tester(String description, boolean condition) {
        totalTests++;

        if (condition) {
            testsReussis++;
            System.out.println("[SUCCÈS] Test " + totalTests + " : " + description);
        } else {
            testsEchoues++;
            System.out.println("[ÉCHEC] Test " + totalTests + " : " + description);
        }
    }

    // Affichage d'un titre
    public static void titre(String texte) {
        System.out.println();
        System.out.println(texte);
    }

    // Affichage du bilan d'un jalon
    public static void bilanJalon(
            String jalon, int debutTotal, int debutReussis) {

        int nombreTests = totalTests - debutTotal;
        int reussis = testsReussis - debutReussis;
        int echoues = nombreTests - reussis;

        titre("BILAN DU " + jalon);

        System.out.println("Tests effectués : " + nombreTests);
        System.out.println("Tests réussis   : " + reussis);
        System.out.println("Tests échoués   : " + echoues);
    }

    public static void main(String[] args) {

        titre("GESTION DE TICKETS D'UNE BANQUE");

        //                 JALON 1

        titre("JALON 1 - TESTS FONDAMENTAUX");

        int debutJalon1 = totalTests;
        int reussisDebutJalon1 = testsReussis;

        // TEST 1 : SCENARIO NORMAL
        System.out.println("\n[1] SCENARIO NORMAL");

        TicketStandard ticket1 =
                new TicketStandard(1, "Retrait");

        String etatInitial = ticket1.getEtat();

        ticket1.appeler();
        String etatApresAppel = ticket1.getEtat();

        boolean traitement1 = ticket1.traiter();
        String etatFinal = ticket1.getEtat();

        tester("Cycle EN_ATTENTE -> APPELE -> TRAITE",
                etatInitial.equals("EN_ATTENTE")
                && etatApresAppel.equals("APPELE")
                && traitement1
                && etatFinal.equals("TRAITE"));

        // TEST 2 : REFUS DE TRAITEMENT
        System.out.println("\n[2] REFUS DE TRAITEMENT");

        TicketPrioritaire ticket2 =
                new TicketPrioritaire(2, "Dépôt");

        boolean traitement2 = ticket2.traiter();

        tester("Traitement refusé sans appel préalable",
                !traitement2
                && ticket2.getEtat().equals("EN_ATTENTE"));

        // TEST 3 : CHANGEMENT D'ETAT
        System.out.println("\n[3] CHANGEMENT D'ETAT");

        TicketStandard ticket3 =
                new TicketStandard(3, "Consultation");

        ticket3.appeler();
        ticket3.traiter();

        tester("Changement d'état correct",
                ticket3.getEtat().equals("TRAITE"));

        // TEST 4 : POLYMORPHISME
        System.out.println("\n[4] POLYMORPHISME");

        Ticket ticket4 =
                new TicketStandard(4, "Retrait");

        Ticket ticket5 =
                new TicketPrioritaire(5, "Virement");

        tester("Polymorphisme et priorités",
                ticket4.calculerPriorite() == 1
                && ticket5.calculerPriorite() == 2);

        // TEST 5 : INTERFACE
        System.out.println("\n[5] UTILISATION DE L'INTERFACE");

        GestionTicket gestion1 =
                new TicketStandard(6, "Retrait");

        GestionTicket gestion2 =
                new TicketPrioritaire(7, "Dépôt");

        gestion1.appeler();
        gestion2.appeler();

        boolean resultat1 = gestion1.traiter();
        boolean resultat2 = gestion2.traiter();

        tester("Utilisation de l'interface GestionTicket",
                resultat1 && resultat2);

        bilanJalon(
                "JALON 1",
                debutJalon1,
                reussisDebutJalon1
        );

        //                 JALON 2
        
        titre("JALON 2 - TESTS COMPLEMENTAIRES");

        int debutJalon2 = totalTests;
        int reussisDebutJalon2 = testsReussis;

        // TEST 6 : CREATION STANDARD
        TicketStandard standard =
                new TicketStandard(8, "Retrait");

        tester("Création d'un ticket standard",
                standard != null);

        // TEST 7 : CREATION PRIORITAIRE
        TicketPrioritaire prioritaire =
                new TicketPrioritaire(9, "Dépôt");

        tester("Création d'un ticket prioritaire",
                prioritaire != null);

        // TEST 8 : NUMEROS
        tester("Vérification des numéros",
                standard.getNumero() == 8
                && prioritaire.getNumero() == 9);

        // TEST 9 : OPERATIONS
        tester("Vérification des opérations",
                standard.getOperation().equals("Retrait")
                && prioritaire.getOperation().equals("Dépôt"));

        // TEST 10 : ETAT INITIAL
        tester("État initial EN_ATTENTE",
                standard.getEtat().equals("EN_ATTENTE")
                && prioritaire.getEtat().equals("EN_ATTENTE"));

        // TEST 11 : PRIORITE STANDARD
        tester("Priorité standard égale à 1",
                standard.calculerPriorite() == 1);

        // TEST 12 : PRIORITE PRIORITAIRE
        tester("Priorité prioritaire égale à 2",
                prioritaire.calculerPriorite() == 2);

        // TEST 13 : APPEL D'UN TICKET
        standard.appeler();

        tester("Appel d'un ticket en attente",
                standard.getEtat().equals("APPELE"));

        // TEST 14 : TRAITEMENT D'UN TICKET
        boolean traitementStandard = standard.traiter();

        tester("Traitement d'un ticket appelé",
                traitementStandard
                && standard.getEtat().equals("TRAITE"));

        // TEST 15 : DOUBLE APPEL
        TicketStandard ticket10 =
                new TicketStandard(10, "Virement");

        ticket10.appeler();
        ticket10.appeler();

        tester("Refus du double appel",
                ticket10.getEtat().equals("APPELE"));

        // TEST 16 : RAPPEL APRES TRAITEMENT
        TicketPrioritaire ticket11 =
                new TicketPrioritaire(11, "Consultation");

        ticket11.appeler();
        ticket11.traiter();
        ticket11.appeler();

        tester("Refus d'appel après traitement",
                ticket11.getEtat().equals("TRAITE"));

        // TEST 17 : DOUBLE TRAITEMENT
        boolean deuxiemeTraitement = ticket11.traiter();

        tester("Refus du double traitement",
                !deuxiemeTraitement
                && ticket11.getEtat().equals("TRAITE"));

        bilanJalon(
                "JALON 2",
                debutJalon2,
                reussisDebutJalon2
        );

        //              BILAN GENERAL

        titre("BILAN GENERAL DES TESTS");

        System.out.println("Nombre total de tests : " + totalTests);
        System.out.println("Tests réussis         : " + testsReussis);
        System.out.println("Tests échoués         : " + testsEchoues);

        double taux = totalTests == 0
                ? 0
                : (double) testsReussis / totalTests * 100;

        System.out.printf("Taux de réussite      : %.2f%%%n", taux);

        if (testsEchoues == 0) {
            System.out.println("TOUS LES TESTS SONT REUSSIS !");
        } else {
            System.out.println("CERTAINS TESTS ONT ECHOUE.");
        }
    }
}
