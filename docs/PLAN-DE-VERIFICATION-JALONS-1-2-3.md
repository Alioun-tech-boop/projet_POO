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

Pour chaque fiche, renseigner les résultats réellement observés après exécution. Conserver une capture de la console montrant les résultats et le bilan du jalon concerné.

Les tests JUnit automatisés de `src/test/java` sont une campagne distincte, lancée avec :

```bash
mvn clean test
```

**Important :** les fichiers Markdown décrivent les scénarios et les résultats attendus ; ils ne constituent pas, à eux seuls, une preuve d'exécution. Ne déclarer les tests réussis qu'après avoir observé la sortie réelle du programme et de Maven.
