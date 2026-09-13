import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {

        // Création des clients
        Client client1 = new Client(1, "Ali");
        Client client2 = new Client(2, "Moussa");
        Client client3 = new Client(3, "Awa");

        // Création du guichet
        Guichet guichet = new Guichet(1);

        int prochainNumeroTicket = 1;
        int choix;

        do {
            System.out.println("       BANQUE - GUICHET");
            System.out.println("1. Créer un ticket");
            System.out.println("2. Appeler le prochain client");
            System.out.println("3. Terminer l'opération");
            System.out.println("4. Afficher la file d'attente");
            System.out.println("5. Afficher l'état du guichet");
            System.out.println("0. Quitter");

            System.out.print("\nVotre choix : ");
            choix = scanner.nextInt();

            switch (choix) {

                case 1 -> {
                    System.out.println("\n Choisir le client ");
                    System.out.println("1. Ali");
                    System.out.println("2. Moussa");
                    System.out.println("3. Awa");

                    System.out.print("Votre choix : ");
                    int choixClient = scanner.nextInt();

                    Client client = switch (choixClient) {
                        case 1 -> client1;
                        case 2 -> client2;
                        case 3 -> client3;
                        default -> null;
                    };

                    if (client == null) {
                        System.out.println("Client invalide.");
                        break;
                    }
                    System.out.println("\n Type d'opération ");
                    System.out.println("1. Dépôt");
                    System.out.println("2. Retrait");
                    System.out.println("3. Virement");

                    System.out.print("Votre choix : ");
                    int choixOperation = scanner.nextInt();

                    Ticket ticket = switch (choixOperation) {
                        case 1 -> new Depot(
                            prochainNumeroTicket,
                            client
                        );
                        case 2 -> new Retrait(
                            prochainNumeroTicket,
                            client
                        );
                        case 3 -> new Virement(
                            prochainNumeroTicket,
                            client
                        );
                        default -> null;
                    };

                    if (ticket == null) {
                        System.out.println(
                            "Opération invalide."
                        );
                        break;
                    }

                    guichet.ajouterTicket(ticket);

                    System.out.println(
                        "Votre numéro de ticket est : " +
                        prochainNumeroTicket
                    );

                    prochainNumeroTicket++;

                }

                case 2 ->

                    guichet.appelerProchainClient();

                case 3 ->

                    guichet.terminerOperation();

                case 4 ->

                    guichet.afficherFileAttente();

                case 5 ->

                    guichet.afficherEtat();

                case 0 ->

                    System.out.println(
                        "Merci d'avoir utilisé le système."
                    );

                default ->

                    System.out.println(
                        "Choix invalide."
                    );
            }

        } while (choix != 0);

        }
    }
}