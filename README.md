 Gestion de tickets d'une banque

 1. Présentation du projet

 1.1 Intitulé du projet

Gestion de tickets d'une banque

 1.2 Contexte

Dans une agence bancaire, plusieurs clients peuvent attendre pour effectuer différentes opérations : retrait, dépôt, virement, consultation, etc.

Afin d'organiser l'accueil des clients et de faciliter le traitement des demandes, le projet consiste à concevoir une application Java permettant de représenter et de gérer différents types de tickets bancaires.

Le projet est réalisé en Java en utilisant les principaux concepts de la programmation orientée objet (POO), notamment :

- les classes ;
- l'héritage ;
- l'abstraction ;
- les interfaces ;
- le polymorphisme ;
- la redéfinition des méthodes ;
- la gestion des états d'un objet.



 2. Cahier des charges

 2.1 Objectif général

L'objectif du projet est de développer une petite application permettant de modéliser la gestion des tickets dans une banque.

L'application doit permettre de :

- créer un ticket ;
- identifier le numéro du ticket ;
- préciser l'opération demandée ;
- connaître l'état du ticket ;
- déterminer sa priorité ;
- appeler un ticket ;
- traiter un ticket ;
- empêcher le traitement d'un ticket qui n'a pas encore été appelé ;
- représenter plusieurs types de tickets ;
- démontrer l'utilisation de l'héritage, de l'abstraction, d'une interface et du polymorphisme.



 2.2 Fonctionnalités attendues

Le système doit permettre les opérations suivantes.

 Création d'un ticket

Lorsqu'un ticket est créé, il possède :

- un numéro ;
- une opération ;
- un état initial.

L'état initial d'un nouveau ticket est :

`EN_ATTENTE`



 Appel d'un ticket

Un ticket qui est en attente peut être appelé.

Son état passe alors de :

`EN_ATTENTE`

à :

`APPELE`



 Traitement d'un ticket

Un ticket appelé peut être traité.

Son état passe alors de :

`APPELE`

à :

`TRAITE`*

 Gestion d'un refus
 

Le système doit empêcher le traitement d'un ticket qui est encore en attente.

Par exemple :

`EN_ATTENTE → traitement refusé`

La méthode `traiter()` retourne alors `false`.



 Gestion des priorités

Le système distingue deux types de tickets :

- `TicketStandard` ;
- `TicketPrioritaire`.

Chaque type possède sa propre priorité.

| Type de ticket | Priorité |
|---|---:|
| Ticket standard | 1 |
| Ticket prioritaire | 2 |



 3. Contraintes techniques

Le projet doit respecter les contraintes suivantes :

- langage de programmation : Java ;
- programmation orientée objet ;
- utilisation d'une classe abstraite ;
- utilisation de deux classes concrètes ;
- utilisation d'une interface pertinente ;
- utilisation de l'héritage ;
- utilisation du polymorphisme ;
- présence de tests dans `Main.java` ;
- les noms des fichiers doivent correspondre aux noms des classes ;
- le projet doit pouvoir être compilé après un nouveau clonage ;
- une seule version active du code doit être utilisée ;
- le README et le diagramme UML doivent être cohérents avec le code.



 4. Architecture du projet

Le projet est organisé comme suit :

```text
GestionTicketBanque/
│
├── src/
│   ├── Ticket.java
│   ├── TicketStandard.java
│   ├── TicketPrioritaire.java
│   ├── GestionTicket.java
│   └── Main.java
├──docs/
│   └── diagramme-uml.jpeg
│
└──README.md

## Tests manuels — Jalon 1

### Objectif des tests

Les tests du jalon 1 visent à vérifier le fonctionnement des principales fonctionnalités de l'application de gestion des tickets bancaires, ainsi que l'utilisation des concepts fondamentaux de la programmation orientée objet en Java.

### Tableau des tests

| N° | Test effectué | Résultat attendu | Statut attendu |
|---|---|---|---|
| 1 | Scénario normal : appel et traitement d'un ticket standard | EN_ATTENTE → APPELE → TRAITE | SUCCÈS |
| 2 | Tentative de traitement d'un ticket prioritaire sans appel préalable | Traitement refusé (`false`), état EN_ATTENTE | SUCCÈS |
| 3 | Vérification des changements d'état d'un ticket | État final TRAITE | SUCCÈS |
| 4 | Vérification du polymorphisme avec les deux types de tickets | Priorités 1 et 2 | SUCCÈS |
| 5 | Utilisation de l'interface GestionTicket | Appel et traitement réussis pour les deux types | SUCCÈS |

### Bilan attendu des tests

========================================
        BILAN DES TESTS - JALON 1
========================================
Nombre total de tests : 5
Tests réussis         : 5
Tests échoués         : 0
Taux de réussite      : 100 %

========================================

### Conclusion

Les cinq scénarios de tests du jalon 1 permettent de vérifier :

- La création et l'initialisation des tickets.
- Le passage entre les états EN_ATTENTE, APPELE et TRAITE.
- Le refus du traitement d'un ticket non appelé.
- Le polymorphisme entre TicketStandard et TicketPrioritaire.
- L'utilisation de l'interface GestionTicket.

## Tests manuels — Jalon 2

### Objectif des tests

Les tests ont pour objectif de vérifier le fonctionnement de l'application, le respect des invariants et l'utilisation des concepts de programmation orientée objet : héritage, abstraction, interfaces et polymorphisme.

### Tableau des tests

| N° | Test effectué | Résultat attendu | Statut attendu |
|---|---|---|---|
| 1 | Création d'un ticket standard | Objet créé correctement | SUCCÈS |
| 2 | Création d'un ticket prioritaire | Objet créé correctement | SUCCÈS |
| 3 | Vérification des numéros | Numéros 1 et 2 | SUCCÈS |
| 4 | Vérification des opérations | Retrait et Dépôt | SUCCÈS |
| 5 | Vérification de l'état initial | EN_ATTENTE | SUCCÈS |
| 6 | Priorité du ticket standard | 1 | SUCCÈS |
| 7 | Priorité du ticket prioritaire | 2 | SUCCÈS |
| 8 | Appel d'un ticket en attente | APPELE | SUCCÈS |
| 9 | Traitement d'un ticket appelé | TRAITE et true | SUCCÈS |
| 10 | Traitement sans appel préalable | Refus, false et EN_ATTENTE | SUCCÈS |
| 11 | Double appel d'un ticket | État conservé : APPELE | SUCCÈS |
| 12 | Appel d'un ticket déjà traité | État conservé : TRAITE | SUCCÈS |
| 13 | Double traitement d'un ticket | Refus, false et TRAITE | SUCCÈS |
| 14 | Polymorphisme avec TicketStandard | Priorité 1 | SUCCÈS |
| 15 | Polymorphisme avec TicketPrioritaire | Priorité 2 | SUCCÈS |
| 16 | Utilisation de l'interface avec TicketStandard | Traitement réussi | SUCCÈS |
| 17 | Utilisation de l'interface avec TicketPrioritaire | Traitement réussi | SUCCÈS |

### Bilan attendu

==============================================
              BILAN DES TESTS
==============================================
Nombre total de tests : 17
Tests réussis         : 17
Tests échoués         : 0
Taux de réussite      : 100,00%

TOUS LES TESTS SONT REUSSIS !
==============================================

### Conclusion

La campagne de tests couvre les principales fonctionnalités de l'application : création des tickets, gestion des priorités, transitions d'état, refus des opérations non autorisées, héritage, polymorphisme et utilisation de l'interface.

