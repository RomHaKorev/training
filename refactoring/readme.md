
# Crafting unit tests

Exemples en java


## Implementation de test et autres fakes

- Simulateurs
- Spy
- Mock
- Stub


## Définition et présentation théorique

## Pourquoi écrire des tests

## Assertion

## Documenter le code par les tests

## Mettre en pratique


### S'abstraire de l'implementation
=> passer par une couche d'adaptation
liste des defauts:
- passer par des champs privés et introspection
- passer par des mocks trop précis
- faire leaker la structure de donnée
- faire leaker le choix d'implementation (new, methods, ...)
- tester trop (tous les champs)


### Ecrire du code testable

- attention aux effets de bords
- time / random / hashmap / network / io / DB


### Rendre du code testable

- extraction parametres
- extraction de comportement
