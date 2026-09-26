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
│
├── README.md
└── schema.puml
