public class Ticket {

    private final int numero;
    private final Client client;
    private boolean enCours;

    public Ticket(int numero, Client client) {
        this.numero = numero;
        this.client = client;
        this.enCours = false;
    }

    public int getNumero() {
        return numero;
    }

    public Client getClient() {
        return client;
    }

    public boolean isEnCours() {
        return enCours;
    }

    public void commencer() {
        enCours = true;
    }

    public void terminer() {
        enCours = false;
    }

    // Méthode polymorphe
    public String getTypeOperation() {
        return "Inconnue";
    }

    public void afficherTicket() {
        System.out.println(
            "Ticket : " + numero +
            " Client : " + client.getNom() +
            " Opération : " + getTypeOperation() +
            " En cours : " + enCours
        );
    }
}

class Depot extends Ticket {

    public Depot(int numero, Client client) {
        super(numero, client);
    }

    @Override
    public String getTypeOperation() {
        return "Dépôt";
    }
}

class Virement extends Ticket {

    public Virement(int numero, Client client) {
        super(numero, client);
    }

    @Override
    public String getTypeOperation() {
        return "Virement";
    }
}

class Retrait extends Ticket {

    public Retrait(int numero, Client client) {
        super(numero, client);
    }

    @Override
    public String getTypeOperation() {
        return "Retrait";
    }
}