import java.util.ArrayList;
import java.util.List;

public class GestionnaireTickets {
    private final List<Ticket> tickets = new ArrayList<>();

    public void ajouterTicket(Ticket ticket) {
        if (ticket != null) {
            tickets.add(ticket);
        }
    }

    public void afficherTickets() {
        if (tickets.isEmpty()) {
            System.out.println("Aucun ticket enregistré.");
            return;
        }

        for (Ticket ticket : tickets) {
            ticket.afficherInformations();
            System.out.println("--------------------");
        }
    }

    public int nombreTickets() {
        return tickets.size();
    }
}
