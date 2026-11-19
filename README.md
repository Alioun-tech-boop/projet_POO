# Gestion de tickets d'une banque

## 1. Présentation

Ce projet Java 17 modélise la gestion de tickets dans une agence bancaire : création de tickets, appel, traitement, gestion des états et distinction entre tickets standards et prioritaires.

Il met en œuvre les notions de programmation orientée objet suivantes :

- classe abstraite et héritage ;
- interface ;
- polymorphisme ;
- redéfinition de méthodes ;
- collection générique avec `List<Ticket>` et `ArrayList<Ticket>` ;
- validation des données et gestion de cas limites.

## 2. Fonctionnalités

- Créer des tickets standards et prioritaires.
- Initialiser chaque ticket à l'état `EN_ATTENTE`.
- Appeler un ticket : `EN_ATTENTE` → `APPELE`.
- Traiter un ticket appelé : `APPELE` → `TRAITE`.
- Refuser le traitement avant l'appel.
- Refuser les doubles appels et doubles traitements.
- Attribuer la priorité 1 aux tickets standards et 2 aux tickets prioritaires.
- Enregistrer et afficher plusieurs tickets dans un gestionnaire.

## 3. Architecture du dépôt

```text
projet_POO/
├── GestionTicket.java
├── Ticket.java
├── TicketStandard.java
├── TicketPrioritaire.java
├── GestionnaireTickets.java
├── Main.java
├── diagramme-uml.jpeg
├── pom.xml
├── README.md
├── docs/
│   ├── TESTS-JALON-1.md
│   ├── TESTS-JALON-2.md
│   ├── TESTS-JALON-3.md
│   └── PLAN-DE-VERIFICATION-JALONS-1-2-3.md
└── src/
    └── test/
        └── java/
            ├── TicketTest.java
            └── GestionnaireTicketsTest.java
```

## 4. Tests des jalons

Les scénarios de vérification intégrés à `Main.java` sont numérotés de 1 à 23 :

| Jalon | Scénarios dans Main.java | Nombre |
|---|---:|---:|
| Jalon 1 — comportement fondamental | 1 à 5 | 5 |
| Jalon 2 — création, états et cas limites | 6 à 17 | 12 |
| Jalon 3 — gestionnaire et collections | 18 à 23 | 6 |
| **Total des assertions** | **1 à 23** | **23** |

Le contrôle d'affichage du gestionnaire, numéroté comme test 24 dans les commentaires de `Main.java`, est une vérification visuelle complémentaire : il n'est pas comptabilisé dans les 23 assertions.

**Attention :** ce tableau indique les scénarios présents dans le code, pas des résultats déjà prouvés. Les tests doivent être exécutés localement et les sorties conservées. Chaque jalon dispose maintenant de son propre document Markdown :

- [Tests du Jalon 1 — comportement fondamental](docs/TESTS-JALON-1.md)
- [Tests du Jalon 2 — création, états et cas limites](docs/TESTS-JALON-2.md)
- [Tests du Jalon 3 — gestionnaire et collections](docs/TESTS-JALON-3.md)

Le [plan général de vérification](docs/PLAN-DE-VERIFICATION-JALONS-1-2-3.md) récapitule les trois campagnes et la procédure de preuve.

## 5. Justification de l'interface et de la collection

- `GestionTicket` définit le contrat commun des opérations `appeler()` et `traiter()`.
- `Ticket` implémente ce contrat et centralise les informations et états communs.
- `TicketStandard` et `TicketPrioritaire` spécialisent `Ticket` et définissent leur priorité.
- `GestionnaireTickets` stocke les différents types de tickets dans une `List<Ticket>` concrètement créée avec `ArrayList<Ticket>`. Cela permet de gérer une collection de taille variable et de regrouper les deux types grâce au polymorphisme.
- L'ajout d'une référence `null` est ignoré.

## 6. Maven : rôle et commandes

Maven est l'outil de construction du projet. Il lit le fichier `pom.xml`, gère la dépendance JUnit, compile le code, lance les tests automatisés et prépare le livrable. Maven ne remplace pas Java : le projet reste écrit en Java 17.

Depuis la racine du projet :

```bash
# Nettoyer, compiler et exécuter les tests JUnit
mvn clean test

# Construire le projet sans relancer les tests
mvn -DskipTests package

# Lancer le programme principal après compilation
java -cp target/classes Main
```

Les tests JUnit sont distincts des 23 vérifications exécutées par `Main.java`.

## 7. Jalon 4 — robustesse et tests automatisés

Les tests JUnit 5 sont placés dans `src/test/java` :

- `TicketTest.java` : création, validation, priorités, transitions d'état et cas limites ;
- `GestionnaireTicketsTest.java` : collection vide, ajout de tickets, rejet de `null` et conservation du nombre d'éléments.

Les validations du modèle comprennent notamment un numéro strictement positif, une opération non nulle et non vide, ainsi que des états limités à `EN_ATTENTE`, `APPELE` et `TRAITE`.

## 8. État des vérifications

Les scénarios et les tests automatisés sont présents dans le dépôt. **Leur réussite doit être confirmée par une exécution locale** avec les commandes ci-dessus. Ne renseigner un bilan « réussi » qu'après avoir vérifié les sorties réelles de Maven et de `Main.java`.
