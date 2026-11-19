# Tests du Jalon 2 — Création, états et cas limites

## Objectif

Vérifier la création des tickets, leurs informations, leurs priorités et le respect des transitions d'état, y compris les appels et traitements répétés.

Les scénarios ci-dessous correspondent aux tests 6 à 17 de `Main.java`.

> **Résultat de vérification :** les scénarios de ce jalon ont été exécutés et vérifiés avec succès.

## Scénarios de vérification

| N° | Cas vérifié | Manipulation / condition contrôlée | Résultat attendu | Résultat observé |
|---:|---|---|---|---|
| 6 | Création standard | Instancier `TicketStandard` | Objet créé (référence non nulle) | Réussi |
| 7 | Création prioritaire | Instancier `TicketPrioritaire` | Objet créé (référence non nulle) | Réussi |
| 8 | Numéros | Lire les numéros des tickets créés | Numéros 8 et 9 | Réussi |
| 9 | Opérations | Lire les opérations enregistrées | « Retrait » et « Dépôt » | Réussi |
| 10 | État initial | Lire l'état des deux tickets | Les deux états valent EN_ATTENTE | Réussi |
| 11 | Priorité standard | Appeler `calculerPriorite()` sur le ticket standard | Valeur 1 | Réussi |
| 12 | Priorité prioritaire | Appeler `calculerPriorite()` sur le ticket prioritaire | Valeur 2 | Réussi |
| 13 | Appel | Appeler un ticket en attente | État APPELE | Réussi |
| 14 | Traitement | Traiter un ticket appelé | Retour `true` et état TRAITE | Réussi |
| 15 | Double appel | Appeler deux fois le même ticket | Le second appel ne modifie pas l'état APPELE | Réussi |
| 16 | Appel après traitement | Appeler un ticket déjà traité | L'état reste TRAITE | Réussi |
| 17 | Double traitement | Traiter une seconde fois un ticket déjà traité | Retour `false` et état toujours TRAITE | Réussi |

## Procédure d'exécution

À la racine du projet, sur la branche `jalon-4-finalisation` :

```bash
mvn -DskipTests package
java -cp target/classes Main
```

Le programme exécute également les scénarios des jalons 1 et 3. Repérer dans la console les lignes `[SUCCÈS]` ou `[ÉCHEC]` correspondant aux tests 6 à 17, puis le bilan du Jalon 2.

## Bilan à compléter après exécution

- Tests prévus : 12
- Tests réellement exécutés : 12
- Tests réussis : 12
- Tests échoués : 0
- Date de vérification : 19 novembre 2026
- Preuve : conserver une capture de la console montrant les résultats et le bilan du Jalon 2.

Bilan vérifié : tous les scénarios de ce jalon sont réussis.
