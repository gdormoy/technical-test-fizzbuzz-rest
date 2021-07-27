# Test technique FizzBuzz

Ceci est un test technique dont l'objectif est de réaliser une mini API avec un endpoint permettant
d'afficher le resultat du `fizzbuzz`.
De plus ce test technique requiert qu'il soit possible ou non de changer les valeurs du `fizzbuzz`.

## Prérequis

- Java 16
- Maven 3.8.1
- Docker

## Utilisation

Tout d'abord commencer par cloner ce dépot via la commande:
```bash
https://github.com/gdormoy/technical-test-fizzbuzz-rest.git
```

Ensuite déplacer vous vers le projet:
```bash
cd technical-test-fizzbuzz-rest/java
```

Maintenant vous pouvez créer l'image Docker:
```bash
docker build -t fizzbuzz .
```

Vous possédez maintenant une image docker contenant votre code.
Il ne vous reste plus qu'à démarrer le conteneur.
```bash
docker run -d -p 8080:8080 fizzbuzz
```

Maintenant vous pouvez appelez votre API en local