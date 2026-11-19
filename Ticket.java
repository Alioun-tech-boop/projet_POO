public abstract class Ticket implements GestionTicket {
    public static final String EN_ATTENTE = "EN_ATTENTE";
    public static final String APPELE = "APPELE";
    public static final String TRAITE = "TRAITE";

    protected final int numero;
    protected final String operation;
    protected String etat;

    public Ticket(int numero, String operation) {
        if (numero <= 0) {
            throw new IllegalArgumentException("Le numéro du ticket doit être strictement positif.");
        }
        if (operation == null || operation.isBlank()) {
            throw new IllegalArgumentException("L'opération du ticket ne peut pas être vide.");
        }
        this.numero = numero;
        this.operation = operation.trim();
        this.etat = EN_ATTENTE;
    }

    public abstract int calculerPriorite();

    public int getNumero() { return numero; }
    public String getOperation() { return operation; }
    public String getEtat() { return etat; }

    protected final void setEtat(String etat) {
        if (!EN_ATTENTE.equals(etat) && !APPELE.equals(etat) && !TRAITE.equals(etat)) {
            throw new IllegalArgumentException("État de ticket invalide : " + etat);
        }
        this.etat = etat;
    }

    public void afficherInformations() {
        System.out.println("Numéro : " + numero);
        System.out.println("Opération : " + operation);
        System.out.println("État : " + etat);
        System.out.println("Priorité : " + calculerPriorite());
    }
}
