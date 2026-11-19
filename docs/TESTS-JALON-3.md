# Tests du Jalon 3 — Gestionnaire et collections

## Objectif

Vérifier que le gestionnaire peut stocker plusieurs tickets de types différents, maintenir un comptage cohérent, ignorer une référence `null` et afficher le contenu de sa collection.

Les scénarios ci-dessous correspondent aux tests 18 à 23 de `Main.java`.

> **Statut de preuve :** les résultats indiqués sont les résultats attendus. Ils ne doivent être marqués comme obtenus qu'après exécution du programme et vérification de la sortie dans la console.

## Scénarios de vérification

| N° | Cas vérifié | Manipulation / condition contrôlée | Résultat attendu | Résultat observé |
|---:|---|---|---|---|
| 18 | Gestionnaire vide | Créer un `GestionnaireTickets` et lire son compteur | Nombre de tickets = 0 | À renseigner après exécution |
| 19 | Ajout standard | Ajouter un `TicketStandard` | Nombre de tickets = 1 | À renseigner après exécution |
| 20 | Ajout prioritaire | Ajouter un `TicketPrioritaire` | Nombre de tickets = 2 | À renseigner après exécution |
| 21 | Plusieurs tickets | Ajouter un troisième ticket standard | Nombre de tickets = 3 | À renseigner après exécution |
| 22 | Référence nulle | Appeler `ajouterTicket(null)` | L'ajout est ignoré ; nombre toujours égal à 3 | À renseigner après exécution |
| 23 | Contenu réel de la collection | Capturer la sortie de `afficherTickets()` | La sortie contient les numéros 18, 19 et 20 | À renseigner après exécution |

## Vérification visuelle complémentaire

Après les six vérifications, `Main.java` appelle `gestionnaire.afficherTickets()` pour afficher les trois tickets dans la console. Vérifier que chaque ticket présente son numéro, son opération, son état et sa priorité.

Cet affichage supplémentaire est un contrôle visuel ; il n'est pas une septième assertion et ne modifie pas le total de 23 tests.

## Pourquoi utiliser une collection et une interface ?

- `GestionnaireTickets` déclare une `List<Ticket>` et l'instancie avec `ArrayList<Ticket>`. La liste permet de gérer un nombre variable de tickets.
- Le type générique `Ticket` permet de stocker dans une même collection des `TicketStandard` et des `TicketPrioritaire`, grâce à l'héritage et au polymorphisme.
- `GestionTicket` définit le contrat commun `appeler()` et `traiter()`. La classe abstraite `Ticket` implémente ce contrat, dont héritent les deux classes concrètes.
- `ajouterTicket` ignore une référence `null` pour ne pas enregistrer une valeur inutilisable.

## Procédure d'exécution

À la racine du projet, sur la branche `jalon-4-finalisation` :

```bash
mvn -DskipTests package
java -cp target/classes Main
```

Le programme exécute également les scénarios des jalons 1 et 2. Repérer les lignes `[SUCCÈS]` ou `[ÉCHEC]` correspondant aux tests 18 à 23, puis le bilan du Jalon 3. Vérifier aussi l'affichage final des trois tickets.

## Bilan à compléter après exécution

- Tests prévus : 6
- Tests réellement exécutés : à renseigner
- Tests réussis : à renseigner
- Tests échoués : à renseigner
- Date de vérification : à renseigner
- Preuve : conserver une capture de la console montrant les six résultats, le bilan du Jalon 3 et l'affichage des trois tickets.

Ne pas inscrire 6/6 avant d'avoir exécuté le programme et vérifié la sortie.
