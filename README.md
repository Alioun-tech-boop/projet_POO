Groupe 6

Structure finale du projet

ProjetBanque/

├── Client.java

├── Ticket.java
     ├── Depot
     ├── Retrait
     └── Virement

├── Guichet.java

└── Main.java

Les concepts de POO visibles

Classe	Client, Ticket, Guichet

Objet	new Client(...), new Guichet(...)

Constructeur	Dans chaque classe

Encapsulation	Attributs private

Héritage	Depot extends Ticket
Héritage	Retrait extends Ticket
Héritage	Virement extends Ticket

Polymorphisme	Ticket ticket = new Depot(...)
Redéfinition	@Override getTypeOperation()

Classe abstraite	abstract class Ticket
Composition	Guichet contient des Ticket
Collection	Queue<Ticket>

Résultat

Ali prend un ticket pour un dépôt → ticket 1
Moussa prend un ticket pour un retrait → ticket 2

Affichage de la file :

Ticket : 1 ; Client : Ali ; Opération : Dépôt

Ticket : 2 ; Client : Moussa ; Opération : Retrait

Le guichet appelle le ticket 1
L'opération est terminée

Le guichet appelle automatiquement le ticket 2
L'opération est terminée
