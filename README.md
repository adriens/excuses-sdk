[![](https://jitpack.io/v/adriens/excuses-sdk.svg)](https://jitpack.io/#adriens/excuses-sdk)

# Usage

## Prérequis

- [JBang!](https://www.jbang.dev/documentation/guide/latest/installation.html), 
idéalement avec [`sdkman`](https://sdkman.io/).

## JBanb! geeks

Pour une expérience optimale depuis le votre shell qui vous permettra de trouver
des excuses de la manière la plus **efficace et discrète** possible :

```shell
jbang alias add --name excuse https://github.com/adriens/excuses-sdk/blob/main/nope.java
# Check des alias
jbang alias list
# Appel de excuse
jbang excuse -c boulot
```

Pour récupérer une nouvelle version, mettre à jour le cache :

```shell
jbang --fresh run https://github.com/adriens/excuses-sdk/blob/main/nope.java -c boulot
```


Via alias :

```shell
jbang cache clear
jbang excuse -c boulot
```

# Pour les développeurs : `excuses-sdk`

Enfin un SDK pour intéger de bonnes excuses dans tes logiciels :

## Dépendance

```xml
<repositories>
  <repository>
    <id>jitpack.io</id>
    <url>https://jitpack.io</url>
  </repository>
</repositories>
```

```xml
<dependency>
  <groupId>com.github.adriens</groupId>
  <artifactId>excuses-sdk</artifactId>
  <version>Tag</version>
</dependency>
```

## Code

```java
Excuses excuses = new Excuses();
//tes collègue te gonflent avec le sport ?
List<Excuse> exc = excuses.getByCategory("Sport");
```


# TODO

- [x] Implement jbang scripts
- [ ] Create REST API