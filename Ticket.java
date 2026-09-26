public abstract class Ticket implements GestionTicket {

    protected int numero;
    protected String operation;
    protected String etat;

    // Constructeur
    public Ticket(int numero, String operation) {
        this.numero = numero;
        this.operation = operation;
        this.etat = "EN_ATTENTE";
    }

    // Méthode abstraite
    public abstract int calculerPriorite();

    // Getter du numéro
    public int getNumero() {
        return numero;
    }

    // Getter de l'opération
    public String getOperation() {
        return operation;
    }

    // Getter de l'état
    public String getEtat() {
        return etat;
    }

    // Méthode protégée permettant aux classes filles
    // de modifier l'état du ticket
    protected void setEtat(String etat) {
        this.etat = etat;
    }

    // Affichage des informations du ticket
    public void afficherInformations() {
        System.out.println("Numéro : " + numero);
        System.out.println("Opération : " + operation);
        System.out.println("État : " + etat);
        System.out.println("Priorité : " + calculerPriorite());
    }
}
