[![](https://jitpack.io/v/adriens/excuses-sdk.svg)](https://jitpack.io/#adriens/excuses-sdk)

# excuses-sdk

Enfin un SDK pour des excuses !

```java
Excuses excuses = new Excuses();
//tes collègue te gonflent avec le sport ?
List<Excuse> exc = excuses.getByCategory("Sport");
```

# Dépendance

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


# TODO

- [ ] Implement jbang scripts
- [ ] Create REST API
