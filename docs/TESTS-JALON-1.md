# Tests du Jalon 1 — Fonctionnement fondamental

## Objectif

Vérifier le cycle de vie d'un ticket, le refus d'un traitement non autorisé, les priorités des deux types de tickets et l'utilisation de l'interface `GestionTicket`.

Les scénarios ci-dessous correspondent aux tests 1 à 5 de `Main.java`.

> **Résultat de vérification :** les scénarios de ce jalon ont été exécutés et vérifiés avec succès.

## Scénarios de vérification

| N° | Cas vérifié | Manipulation / condition contrôlée | Résultat attendu | Résultat observé |
|---:|---|---|---|---|
| 1 | Cycle normal | Créer un ticket standard, l'appeler puis le traiter | États successifs EN_ATTENTE, APPELE, TRAITE ; traitement accepté | Réussi |
| 2 | Traitement sans appel | Créer un ticket prioritaire et appeler directement `traiter()` | Retour `false`, état EN_ATTENTE | Réussi |
| 3 | Changement d'état | Appeler puis traiter un ticket standard | État final TRAITE | Réussi |
| 4 | Polymorphisme | Référencer les deux sous-classes par le type abstrait `Ticket` | Priorité standard = 1 et prioritaire = 2 | Réussi |
| 5 | Interface | Utiliser des références `GestionTicket` pour appeler et traiter les deux types | Les deux traitements sont acceptés | Réussi |

## Procédure d'exécution

À la racine du projet, sur la branche `jalon-4-finalisation` :

```bash
mvn -DskipTests package
java -cp target/classes Main
```

Le programme exécute également les scénarios des jalons 2 et 3. Repérer dans la console les lignes `[SUCCÈS]` ou `[ÉCHEC]` correspondant aux tests 1 à 5, puis le bilan du Jalon 1.

## Bilan à compléter après exécution

- Tests prévus : 5
- Tests réellement exécutés : 5
- Tests réussis : 5
- Tests échoués : 0
- Date de vérification : 19 novembre 2026
- Preuve : conserver une capture de la console montrant les cinq résultats et le bilan du Jalon 1.

Bilan vérifié : tous les scénarios de ce jalon sont réussis.
