# Tests du Jalon 2 — Création, états et cas limites

## Objectif

Vérifier la création des tickets, leurs informations, leurs priorités et le respect des transitions d'état, y compris les appels et traitements répétés.

Les scénarios ci-dessous correspondent aux tests 6 à 17 de `Main.java`.

> **Statut de preuve :** les résultats indiqués sont les résultats attendus. Ils ne doivent être marqués comme obtenus qu'après exécution du programme et vérification de la sortie dans la console.

## Scénarios de vérification

| N° | Cas vérifié | Manipulation / condition contrôlée | Résultat attendu | Résultat observé |
|---:|---|---|---|---|
| 6 | Création standard | Instancier `TicketStandard` | Objet créé (référence non nulle) | À renseigner après exécution |
| 7 | Création prioritaire | Instancier `TicketPrioritaire` | Objet créé (référence non nulle) | À renseigner après exécution |
| 8 | Numéros | Lire les numéros des tickets créés | Numéros 8 et 9 | À renseigner après exécution |
| 9 | Opérations | Lire les opérations enregistrées | « Retrait » et « Dépôt » | À renseigner après exécution |
| 10 | État initial | Lire l'état des deux tickets | Les deux états valent EN_ATTENTE | À renseigner après exécution |
| 11 | Priorité standard | Appeler `calculerPriorite()` sur le ticket standard | Valeur 1 | À renseigner après exécution |
| 12 | Priorité prioritaire | Appeler `calculerPriorite()` sur le ticket prioritaire | Valeur 2 | À renseigner après exécution |
| 13 | Appel | Appeler un ticket en attente | État APPELE | À renseigner après exécution |
| 14 | Traitement | Traiter un ticket appelé | Retour `true` et état TRAITE | À renseigner après exécution |
| 15 | Double appel | Appeler deux fois le même ticket | Le second appel ne modifie pas l'état APPELE | À renseigner après exécution |
| 16 | Appel après traitement | Appeler un ticket déjà traité | L'état reste TRAITE | À renseigner après exécution |
| 17 | Double traitement | Traiter une seconde fois un ticket déjà traité | Retour `false` et état toujours TRAITE | À renseigner après exécution |

## Procédure d'exécution

À la racine du projet, sur la branche `jalon-4-finalisation` :

```bash
mvn -DskipTests package
java -cp target/classes Main
```

Le programme exécute également les scénarios des jalons 1 et 3. Repérer dans la console les lignes `[SUCCÈS]` ou `[ÉCHEC]` correspondant aux tests 6 à 17, puis le bilan du Jalon 2.

## Bilan à compléter après exécution

- Tests prévus : 12
- Tests réellement exécutés : à renseigner
- Tests réussis : à renseigner
- Tests échoués : à renseigner
- Date de vérification : à renseigner
- Preuve : conserver une capture de la console montrant les résultats et le bilan du Jalon 2.

Ne pas inscrire 12/12 avant d'avoir exécuté le programme et vérifié la sortie.
