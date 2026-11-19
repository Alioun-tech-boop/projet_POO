# Index général des tests — Jalons 1, 2 et 3

Ce dossier sépare désormais la documentation des tests en trois fichiers Markdown, un par jalon.

## Fiches de tests

1. [Jalon 1 — Fonctionnement fondamental](TESTS-JALON-1.md) : 5 scénarios (tests 1 à 5 de `Main.java`).
2. [Jalon 2 — Création, états et cas limites](TESTS-JALON-2.md) : 12 scénarios (tests 6 à 17).
3. [Jalon 3 — Gestionnaire et collections](TESTS-JALON-3.md) : 6 scénarios (tests 18 à 23).

Total : **23 vérifications comptabilisées dans `Main.java`**. L'affichage visuel complémentaire du gestionnaire n'est pas comptabilisé comme une assertion supplémentaire.

## Exécution et preuves

Depuis la racine du projet, sur la branche `jalon-4-finalisation` :

```bash
mvn -DskipTests package
java -cp target/classes Main
```

Les résultats des trois fiches ont été vérifiés : Jalon 1, 5/5 ; Jalon 2, 12/12 ; Jalon 3, 6/6. Le total est de **23/23 vérifications réussies, 0 échec**. Les captures de console peuvent être conservées comme éléments de preuve.

Les tests JUnit automatisés de `src/test/java` sont une campagne distincte, lancée avec :

```bash
mvn clean test
```

**Bilan de vérification :** les 23 scénarios des Jalons 1 à 3 ainsi que les 15 tests automatisés JUnit 5 du Jalon 4 ont été vérifiés avec succès par l'auteur du projet. Résultat déclaré : **38 tests réussis, 0 échec**.
