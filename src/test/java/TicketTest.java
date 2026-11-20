import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

class TicketTest {
    @Test
    void ticketStandardEstInitialiseCorrectement() {
        TicketStandard ticket = new TicketStandard(1, "Retrait");
        assertEquals(1, ticket.getNumero());
        assertEquals("Retrait", ticket.getOperation());
        assertEquals(Ticket.EN_ATTENTE, ticket.getEtat());
        assertEquals(1, ticket.calculerPriorite());
    }

    @Test
    void ticketPrioritairePossedePrioriteDeux() {
        TicketPrioritaire ticket = new TicketPrioritaire(2, "Dépôt");
        assertEquals(2, ticket.calculerPriorite());
    }

    @Test
    void numeroNulOuNegatifEstRefuse() {
        assertThrows(IllegalArgumentException.class, () -> new TicketStandard(0, "Retrait"));
        assertThrows(IllegalArgumentException.class, () -> new TicketPrioritaire(-1, "Dépôt"));
    }

    @Test
    void operationNulleOuVideEstRefusee() {
        assertThrows(IllegalArgumentException.class, () -> new TicketStandard(1, null));
        assertThrows(IllegalArgumentException.class, () -> new TicketStandard(1, "  "));
    }

    @Test
    void operationEstNettoyee() {
        TicketStandard ticket = new TicketStandard(1, "  Retrait  ");
        assertEquals("Retrait", ticket.getOperation());
    }

    @Test
    void cycleNormalRespecteLesEtats() {
        TicketStandard ticket = new TicketStandard(1, "Retrait");
        ticket.appeler();
        assertEquals(Ticket.APPELE, ticket.getEtat());
        assertTrue(ticket.traiter());
        assertEquals(Ticket.TRAITE, ticket.getEtat());
    }

    @Test
    void traitementAvantAppelEstRefuse() {
        TicketPrioritaire ticket = new TicketPrioritaire(2, "Dépôt");
        assertFalse(ticket.traiter());
        assertEquals(Ticket.EN_ATTENTE, ticket.getEtat());
    }

    @Test
    void doubleAppelNeChangePasEtat() {
        TicketStandard ticket = new TicketStandard(3, "Virement");
        ticket.appeler();
        ticket.appeler();
        assertEquals(Ticket.APPELE, ticket.getEtat());
    }

    @Test
    void doubleTraitementEstRefuse() {
        TicketPrioritaire ticket = new TicketPrioritaire(4, "Consultation");
        ticket.appeler();
        assertTrue(ticket.traiter());
        assertFalse(ticket.traiter());
        assertEquals(Ticket.TRAITE, ticket.getEtat());
    }

    @Test
    void appelApresTraitementNeChangePasEtat() {
        TicketStandard ticket = new TicketStandard(5, "Retrait");
        ticket.appeler();
        ticket.traiter();
        ticket.appeler();
        assertEquals(Ticket.TRAITE, ticket.getEtat());
    }

    @Test
    void interfaceFonctionneAvecLesDeuxTypes() {
        GestionTicket standard = new TicketStandard(6, "Retrait");
        GestionTicket prioritaire = new TicketPrioritaire(7, "Dépôt");
        standard.appeler();
        prioritaire.appeler();
        assertTrue(standard.traiter());
        assertTrue(prioritaire.traiter());
    }

    @Test
    void afficherInformationsExposeLesDonneesDuTicket() {
        TicketStandard ticket = new TicketStandard(8, "Virement");
        ByteArrayOutputStream sortie = new ByteArrayOutputStream();
        PrintStream sortieOriginale = System.out;

        try {
            System.setOut(new PrintStream(sortie, true, StandardCharsets.UTF_8));
            ticket.afficherInformations();
        } finally {
            System.setOut(sortieOriginale);
        }

        String affichage = sortie.toString(StandardCharsets.UTF_8);
        assertAll(
                () -> assertTrue(affichage.contains("Numéro : 8")),
                () -> assertTrue(affichage.contains("Opération : Virement")),
                () -> assertTrue(affichage.contains("État : EN_ATTENTE")),
                () -> assertTrue(affichage.contains("Priorité : 1"))
        );
    }
}
