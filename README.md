# Gestion des tickets bancaires

## Présentation

Ce projet a été réalisé dans le cadre du travail pratique de Programmation Orientée Objet. Il porte sur la gestion des tickets d'attente d'une agence bancaire : création des tickets, appel au guichet, traitement et suivi de leur état.

L'application distingue deux catégories de tickets — standard et prioritaire — tout en conservant un fonctionnement commun. La conception met en pratique les principaux mécanismes de la programmation orientée objet en Java.

## Fonctionnalités

- Création de tickets standards et prioritaires.
- Attribution d'un numéro et d'une opération à chaque ticket.
- Gestion des états : `EN_ATTENTE`, `APPELE` et `TRAITE`.
- Contrôle de l'ordre des opérations : un ticket doit être appelé avant d'être traité.
- Prévention des doubles appels et des doubles traitements.
- Différenciation des tickets par niveau de priorité.
- Enregistrement et affichage de plusieurs tickets dans un même gestionnaire.

## Conception orientée objet

Le programme est organisé autour des classes suivantes :

| Élément | Responsabilité |
|---|---|
| `GestionTicket` | Définit les opérations communes `appeler()` et `traiter()`. |
| `Ticket` | Regroupe les données, les états et les règles communes aux tickets. |
| `TicketStandard` | Représente un ticket de priorité standard. |
| `TicketPrioritaire` | Représente un ticket prioritaire. |
| `GestionnaireTickets` | Centralise la gestion d'une collection de tickets. |
| `Main` | Lance le programme et présente des vérifications de son comportement. |

La conception utilise l'abstraction, l'héritage, l'encapsulation et le polymorphisme. Le gestionnaire manipule les tickets à travers le type commun `Ticket`, au moyen d'une `List<Ticket>` implémentée par `ArrayList<Ticket>`.

Le diagramme de classes est disponible dans [diagramme-uml.jpeg](diagramme-uml.jpeg).

## Organisation du dépôt

```text
projet_POO/
├── Main.java
├── GestionTicket.java
├── Ticket.java
├── TicketStandard.java
├── TicketPrioritaire.java
├── GestionnaireTickets.java
├── diagramme-uml.jpeg
├── pom.xml
├── README.md
├── docs/
│   ├── PLAN-DE-VERIFICATION-JALONS-1-2-3.md
│   ├── TESTS-JALON-1.md
│   ├── TESTS-JALON-2.md
│   └── TESTS-JALON-3.md
└── src/
    └── test/
        └── java/
            ├── TicketTest.java
            └── GestionnaireTicketsTest.java
```

## Vérification du programme

Le programme principal contient des scénarios de vérification répartis selon les trois premiers jalons :

| Partie | Scénarios | Nombre |
|---|---:|---:|
| Jalon 1 — comportement fondamental | 1 à 5 | 5 |
| Jalon 2 — création, états et cas limites | 6 à 17 | 12 |
| Jalon 3 — gestionnaire et collections | 18 à 23 | 6 |
| **Total** | **1 à 23** | **23** |

Le contrôle d'affichage identifié comme test 24 dans le code constitue une vérification complémentaire et n'entre pas dans ce décompte.

Les scénarios sont détaillés dans les documents suivants :

- [Tests du Jalon 1](docs/TESTS-JALON-1.md)
- [Tests du Jalon 2](docs/TESTS-JALON-2.md)
- [Tests du Jalon 3](docs/TESTS-JALON-3.md)
- [Plan général de vérification](docs/PLAN-DE-VERIFICATION-JALONS-1-2-3.md)

Le projet comprend également des tests automatisés JUnit 5 dans `src/test/java` :

- `TicketTest.java couvre les règles de création, de validation et de changement d'état.
- `GestionnaireTicketsTest.java couvre le comportement de la collection de tickets.

Les documents de vérification permettent de consigner les observations obtenues pendant l'exécution. Les résultats doivent correspondre aux sorties réellement constatées.

## Environnement et outils

- Java 17
- Maven
- JUnit Jupiter 5
- Git et GitHub

Maven est utilisé pour gérer la dépendance de test, compiler les sources et exécuter les tests automatisés. La configuration du projet se trouve dans `pom.xml`.

## Compiler et exécuter

Depuis le répertoire principal du projet :

```bash
# Nettoyer le répertoire de compilation et lancer les tests
mvn clean test

# Construire le projet sans relancer les tests
mvn -DskipTests package

# Exécuter le programme principal après compilation
java -cp target/classes Main
```

Les tests JUnit et les vérifications lancées par `Main.java` sont deux mécanismes distincts.

## Bilan et évolutions possibles

Cette application constitue une base de gestion de tickets bancaires organisée autour de responsabilités clairement séparées. La structure retenue permet de faire évoluer le programme sans concentrer toute la logique dans une seule classe.

Parmi les améliorations envisageables figurent la gestion de plusieurs guichets, la persistance des tickets dans une base de données, ainsi qu'une interface utilisateur permettant de suivre les appels et les traitements.
