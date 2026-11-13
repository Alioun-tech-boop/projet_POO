
import java.util.ArrayList;

public class GestionnaireTickets {

    private ArrayList<Ticket> tickets;

    public GestionnaireTickets() {
        tickets = new ArrayList<>();
    }

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
