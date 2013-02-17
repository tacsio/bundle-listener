bundle-listener
===============

Osgi bundle listener sample

To create a bundle with element definitions (events, agents, etc), just create a folder with xml definitions of the elements and include that option in your **.bnd** file:

Sample tree:

```
.
|-- DSOA-INF
|   |-- agent.xml
|   |-- context-model.xml
|   `-- event.xml
|-- bin
|-- configuration-bundle.bnd
|-- configuration-bundle.jar
`-- src
```

__definition.bnd__
```java
Include-Resource: DSOA-INF=DSOA-INF
```
