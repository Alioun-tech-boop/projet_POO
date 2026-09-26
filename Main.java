public class Main {

    public static void main(String[] args) {

        System.out.println("===== GESTION DES TICKETS D'UNE BANQUE =====\n");

        // 1. SCENARIO NORMAL

        System.out.println("----- 1. SCENARIO NORMAL -----");

        TicketStandard ticket1 = new TicketStandard(1, "Retrait");

        ticket1.afficherInformations();

        System.out.println();

        ticket1.appeler();
        ticket1.traiter();

        System.out.println("État final : " + ticket1.getEtat());

        // 2. REFUS
        
        System.out.println("\n----- 2. SCENARIO DE REFUS -----");

        TicketPrioritaire ticket2 =  new TicketPrioritaire(2, "Dépôt");

        ticket2.afficherInformations();

        System.out.println();

        // Tentative de traitement alors que le ticket
        // est encore EN_ATTENTE
        boolean resultat = ticket2.traiter();

        System.out.println("Résultat du traitement : " + resultat);
        System.out.println("État du ticket : " + ticket2.getEtat());

        // 3. CHANGEMENT D'ETAT
        
        System.out.println("\n----- 3. CHANGEMENT D'ETAT -----");

        TicketStandard ticket3 =  new TicketStandard(3, "Consultation");

        System.out.println("État initial : " + ticket3.getEtat());

        ticket3.appeler();

        System.out.println("Après appel : " + ticket3.getEtat());

        ticket3.traiter();

        System.out.println("Après traitement : " + ticket3.getEtat());

        // 4. POLYMORPHISME
        
        System.out.println("\n----- 4. POLYMORPHISME -----");

        Ticket ticket4 = new TicketStandard(4, "Retrait");

        Ticket ticket5 = new TicketPrioritaire(5, "Virement");

        System.out.println("Ticket n°" + ticket4.getNumero()
                + " : priorité = " + ticket4.calculerPriorite());

        System.out.println("Ticket n°" + ticket5.getNumero()
                + " : priorité = " + ticket5.calculerPriorite());

        // 5. UTILISATION DE L'INTERFACE
        
        System.out.println("\n----- 5. UTILISATION DE L'INTERFACE -----");

        GestionTicket gestion1 =  new TicketStandard(6, "Retrait");

        GestionTicket gestion2 =  new TicketPrioritaire(7, "Dépôt");

        gestion1.appeler();
        gestion1.traiter();

        gestion2.appeler();
        gestion2.traiter();


        System.out.println("\n===== FIN DES TESTS =====");
    }
}
