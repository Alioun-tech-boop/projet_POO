import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class GestionnaireTicketsTest {
    @Test
    void collectionEstVideAuDepart() {
        assertEquals(0, new GestionnaireTickets().nombreTickets());
    }

    @Test
    void ajouteTicketStandardEtPrioritaire() {
        GestionnaireTickets gestionnaire = new GestionnaireTickets();
        gestionnaire.ajouterTicket(new TicketStandard(1, "Retrait"));
        gestionnaire.ajouterTicket(new TicketPrioritaire(2, "Dépôt"));
        assertEquals(2, gestionnaire.nombreTickets());
    }

    @Test
    void ajoutNullEstIgnore() {
        GestionnaireTickets gestionnaire = new GestionnaireTickets();
        gestionnaire.ajouterTicket(null);
        assertEquals(0, gestionnaire.nombreTickets());
    }

    @Test
    void conservePlusieursTickets() {
        GestionnaireTickets gestionnaire = new GestionnaireTickets();
        for (int i = 1; i <= 5; i++) {
            gestionnaire.ajouterTicket(new TicketStandard(i, "Retrait"));
        }
        assertEquals(5, gestionnaire.nombreTickets());
    }
}
