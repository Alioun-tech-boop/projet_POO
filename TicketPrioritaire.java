public class TicketPrioritaire extends Ticket {

    public TicketPrioritaire(int numero, String operation) {
        super(numero, operation);
    }

    @Override
    public int calculerPriorite() {
        return 2;
    }

    @Override
    public void appeler() {
        if (etat.equals("EN_ATTENTE")) {
            setEtat("APPELE");
            System.out.println("Le ticket prioritaire n°" + numero + " est appelé.");
        } else {
            System.out.println("Impossible d'appeler le ticket n°" + numero
                    + " car son état est : " + etat);
        }
    }

    @Override
    public boolean traiter() {
        if (etat.equals("APPELE")) {
            setEtat("TRAITE");
            System.out.println("Le ticket prioritaire n°" + numero + " est traité.");
            return true;
        }

        System.out.println("Refus : le ticket prioritaire n°" + numero
                + " doit être appelé avant d'être traité.");
        return false;
    }
}
