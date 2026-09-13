import java.util.LinkedList;
import java.util.Queue;

public class Guichet {

    private final int numero;
    private final Queue<Ticket> fileAttente;
    private Ticket ticketActuel;

    public Guichet(int numero) {
        this.numero = numero;
        this.fileAttente = new LinkedList<>();
        this.ticketActuel = null;
    }

    public void ajouterTicket(Ticket ticket) {

        fileAttente.add(ticket);

        System.out.println(
            "Ticket " + ticket.getNumero() +
            " ajouté à la file d'attente."
        );
    }

    public void appelerProchainClient() {

        if (ticketActuel != null) {
            System.out.println(
                "Le guichet est déjà occupé."
            );
            return;
        }

        if (fileAttente.isEmpty()) {
            System.out.println(
                "La file d'attente est vide."
            );
            return;
        }

        ticketActuel = fileAttente.poll();
        ticketActuel.commencer();

        System.out.println(
            "Guichet " + numero +
            " → Ticket " +
            ticketActuel.getNumero() +
            " appelé."
        );

        ticketActuel.afficherTicket();
    }

    public void terminerOperation() {

        if (ticketActuel == null) {
            System.out.println(
                "Aucune opération en cours."
            );
            return;
        }

        ticketActuel.terminer();

        System.out.println(
            "Ticket " +
            ticketActuel.getNumero() +
            " terminé."
        );

        ticketActuel = null;
    }

    public void afficherFileAttente() {

        if (fileAttente.isEmpty()) {
            System.out.println(
                "La file d'attente est vide."
            );
            return;
        }

        System.out.println("\n FILE D'ATTENTE ");

        for (Ticket ticket : fileAttente) {
            ticket.afficherTicket();
        }
    }

    public void afficherEtat() {

        System.out.println(
            "\n GUICHET " + numero 
        );

        if (ticketActuel == null) {
            System.out.println("Guichet libre.");
        } else {
            System.out.println("Client actuellement servi :");
            ticketActuel.afficherTicket();
        }

        System.out.println(
            "Nombre de clients en attente : " +
            fileAttente.size()
        );
    }
}