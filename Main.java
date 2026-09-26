public class Main {

    // Affiche un résultat de test
    public static void afficherResultat(String test, boolean succes) {
        if (succes) {
            System.out.println(" SUCCÈS : " + test);
        } else {
            System.out.println(" ÉCHEC  : " + test);
        }
    }

    public static void main(String[] args) {

        System.out.println();
        
        System.out.println("       GESTION DE TICKETS D'UNE BANQUE");
       

        // 1. SCENARIO NORMAL
    
        System.out.println();
        System.out.println("[1] SCENARIO NORMAL");
        

        TicketStandard ticket1 =  new TicketStandard(1, "Retrait");

        ticket1.afficherInformations();

        String etatInitial = ticket1.getEtat();

        ticket1.appeler();

        String etatApresAppel = ticket1.getEtat();

        boolean traitement1 = ticket1.traiter();

        String etatFinal = ticket1.getEtat();

        System.out.println("État final : " + etatFinal);

        afficherResultat(
                "Le ticket suit EN_ATTENTE -> APPELE -> TRAITE",
                etatInitial.equals("EN_ATTENTE")
                        && etatApresAppel.equals("APPELE")
                        && traitement1
                        && etatFinal.equals("TRAITE")
        );

        // 2. SCENARIO DE REFUS
        
        System.out.println();
        System.out.println("[2] SCENARIO DE REFUS");
        

        TicketPrioritaire ticket2 = new TicketPrioritaire(2, "Dépôt");

        ticket2.afficherInformations();

        // Tentative de traitement sans appel préalable
        boolean traitement2 = ticket2.traiter();

        System.out.println("Résultat du traitement : " + traitement2);
        System.out.println("État du ticket : " + ticket2.getEtat());

        afficherResultat(
                "Le traitement est refusé si le ticket n'est pas appelé",
                !traitement2
                        && ticket2.getEtat().equals("EN_ATTENTE")
        );

        // 3. CHANGEMENT D'ETAT
        
        System.out.println();
        System.out.println("[3] CHANGEMENT D'ETAT");
       

        TicketStandard ticket3 = new TicketStandard(3, "Consultation");

        System.out.println("État initial : " + ticket3.getEtat());

        ticket3.appeler();

        System.out.println("Après appel : " + ticket3.getEtat());

        ticket3.traiter();

        System.out.println("Après traitement : " + ticket3.getEtat());

        afficherResultat(
                "Les états du ticket changent correctement",
                ticket3.getEtat().equals("TRAITE")
        );

// 4. POLYMORPHISME
        

        System.out.println();
        System.out.println("[4] POLYMORPHISME");
        

        Ticket ticket4 =
                new TicketStandard(4, "Retrait");

        Ticket ticket5 =
                new TicketPrioritaire(5, "Virement");

        int priorite4 = ticket4.calculerPriorite();
        int priorite5 = ticket5.calculerPriorite();

        System.out.println(
                "Ticket n°" + ticket4.getNumero()
                        + " (TicketStandard) : priorité = "
                        + priorite4
        );

        System.out.println(
                "Ticket n°" + ticket5.getNumero()
                        + " (TicketPrioritaire) : priorité = "
                        + priorite5
        );

        afficherResultat(
                "Le polymorphisme fonctionne",
                priorite4 == 1 && priorite5 == 2
        );

        // 5. UTILISATION DE L'INTERFACE
        
        System.out.println();
        System.out.println("[5] UTILISATION DE L'INTERFACE");
        

        GestionTicket gestion1 = new TicketStandard(6, "Retrait");

        GestionTicket gestion2 = new TicketPrioritaire(7, "Dépôt");

        gestion1.appeler();
        boolean resultatGestion1 = gestion1.traiter();

        gestion2.appeler();
        boolean resultatGestion2 = gestion2.traiter();

        afficherResultat(
                "L'interface GestionTicket est correctement utilisée",
                resultatGestion1 && resultatGestion2
        );

        // FIN
    
        System.out.println();
        
        System.out.println("                 TESTS TERMINÉS");
      
    }
}
       
