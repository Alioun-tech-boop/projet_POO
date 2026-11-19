# Plan de vérification — Jalons 1, 2 et 3

Ce document décrit les scénarios présents dans `Main.java`. L'étudiant lance manuellement le programme ; pour les 23 vérifications numérotées, le programme compare les résultats obtenus aux conditions attendues et affiche `[SUCCÈS]` ou `[ÉCHEC]`.

**Important :** les résultats attendus décrits ici ne prouvent pas que les tests ont déjà été exécutés. La colonne « Résultat réellement observé » doit être complétée après une exécution effective, à partir de la console. Les tests JUnit de Maven sont une campagne automatisée distincte.

## 1. Jalon 1 — comportement fondamental

| N° dans Main | Scénario | Résultat attendu | Résultat réellement observé |
|---:|---|---|---|
| 1 | Cycle normal d'un ticket standard | EN_ATTENTE → APPELE → TRAITE ; traitement accepté | À renseigner |
| 2 | Traitement d'un ticket prioritaire sans appel | Refus ; résultat false ; état EN_ATTENTE | À renseigner |
| 3 | Vérification du changement d'état | Après appel et traitement, état TRAITE | À renseigner |
| 4 | Polymorphisme des deux types de tickets | Priorité standard = 1 ; priorité prioritaire = 2 | À renseigner |
| 5 | Utilisation de l'interface GestionTicket | Appel et traitement possibles via les références de type interface | À renseigner |

## 2. Jalon 2 — création, états et cas limites

| N° dans Main | Scénario | Résultat attendu | Résultat réellement observé |
|---:|---|---|---|
| 6 | Création d'un ticket standard | Objet créé | À renseigner |
| 7 | Création d'un ticket prioritaire | Objet créé | À renseigner |
| 8 | Lecture des numéros | Numéros 8 et 9 retrouvés | À renseigner |
| 9 | Lecture des opérations | « Retrait » et « Dépôt » retrouvés | À renseigner |
| 10 | État initial des deux tickets | Les deux états valent EN_ATTENTE | À renseigner |
| 11 | Priorité standard | Valeur 1 | À renseigner |
| 12 | Priorité prioritaire | Valeur 2 | À renseigner |
| 13 | Appel d'un ticket en attente | État APPELE | À renseigner |
| 14 | Traitement d'un ticket appelé | Retour true et état TRAITE | À renseigner |
| 15 | Double appel | Le second appel ne modifie pas l'état APPELE | À renseigner |
| 16 | Nouvel appel après traitement | L'état reste TRAITE | À renseigner |
| 17 | Double traitement | Le second traitement est refusé ; l'état reste TRAITE | À renseigner |

## 3. Jalon 3 — interfaces et gestion des collections

| N° dans Main | Scénario | Résultat attendu | Résultat réellement observé |
|---:|---|---|---|
| 18 | Création du gestionnaire et collection vide | Nombre de tickets = 0 | À renseigner |
| 19 | Ajout d'un ticket standard | Nombre de tickets = 1 | À renseigner |
| 20 | Ajout d'un ticket prioritaire | Nombre de tickets = 2 | À renseigner |
| 21 | Ajout d'un troisième ticket | Nombre de tickets = 3 | À renseigner |
| 22 | Tentative d'ajout de null | L'élément null est ignoré ; nombre toujours égal à 3 | À renseigner |
| 23 | Vérification du contenu par le compteur | Les trois tickets ajoutés sont comptabilisés | À renseigner |

### Vérification visuelle complémentaire (test 24)

Après les assertions 18 à 23, `Main.java` appelle `gestionnaire.afficherTickets()`. Vérifier dans la console que trois tickets sont affichés, avec leur numéro, leur opération, leur état et leur priorité. Ce contrôle visuel est complémentaire : il n'est pas inclus dans le compteur des 23 assertions.

### Justification de la collection et de l'interface

- `GestionnaireTickets` utilise une collection `List<Ticket>`, instanciée avec `ArrayList<Ticket>`, pour stocker un nombre variable de tickets.
- Le type générique `Ticket` permet de stocker ensemble des objets `TicketStandard` et `TicketPrioritaire` grâce à l'héritage et au polymorphisme.
- `GestionTicket` définit un contrat commun avec `appeler()` et `traiter()`. Les deux types concrets implémentent ce contrat par l'intermédiaire de la classe abstraite `Ticket`.
- La méthode `ajouterTicket` ignore une référence `null`, afin d'éviter d'insérer une valeur inutilisable dans la collection.

## 4. Procédure d'exécution et preuve à conserver

Depuis le terminal de Cursor, à la racine du projet et sur la branche `jalon-4-finalisation` :

1. Exécuter `mvn clean test` pour lancer les tests JUnit.
2. Exécuter `mvn -DskipTests package` pour compiler et construire le projet.
3. Exécuter `java -cp target/classes Main` pour lancer les 23 vérifications de `Main.java` et l'affichage complémentaire.
4. Vérifier que le bilan général affiche 23 tests, 23 réussites et 0 échec. Si ce n'est pas le cas, conserver la sortie et corriger avant de conclure.
5. Enregistrer une capture de la console montrant les bilans des jalons et le bilan général. Compléter les colonnes « Résultat réellement observé » à partir de cette sortie.

**État de preuve à la date de rédaction :** les scénarios et résultats attendus sont documentés ; l'exécution locale par l'étudiant et ses preuves restent à confirmer. Ne pas déclarer les tests réussis avant d'avoir observé la sortie.

## 5. Distinction entre les types de tests

- Les 23 vérifications de `Main.java` sont des scénarios déclenchés en lançant manuellement le programme ; les conditions sont contrôlées par le code.
- Les tests de `src/test/java` sont des tests unitaires JUnit automatisés, lancés avec Maven.
- L'affichage du test 24 est un contrôle visuel, pas une assertion comptabilisée.
