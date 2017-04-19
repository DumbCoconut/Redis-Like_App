<h1 align="center"><a href="https://github.com/DumbCoconut/J-REDIS">J-REDIS</a></h1>

## Overview

J-REDIS is a simple redis-like console application. It provides two things:

- A server holding a in-memory data structure store. It supports data structures such as 
strings, integers and lists. 

- A client able to query a given J-REDIS server. 

The connection between the two is made using 
<a href="http://docs.oracle.com/javase/7/docs/technotes/tools/solaris/rmiregistry.html">rmiregistry</a>.

## Features

#### Overview

J-REDIS provides a subset of redis features. Note that unlike redis, negative indexes are not supported. 
The "integer" type has been introduced, e.g "3" will be an integer and not a string. You can't put
quotes inside quotes yet - "my name is" would work but "my "name" is" would produce an error.

#### Client commands 

- ADD_SERVER _host\_ip server\_name_
- HELP _[cmd1, cmd2, ..., cmdN]_
- QUIT
- EXIT

#### String and integers

- DECR _key_
- DECRBY _key integer_
- DEL _key_
- GET _key_
- INCR _key_
- INCRBY _key integer_
- SET _key value_
- TYPE _key_

#### Lists

- LINDEX _key index_
- LLEN _key_
- LPOP _key_
- LPUSH _key value_
- LRANGE _key start end_
- LREM _key count value_
- LSET _key index value_
- LTRIM _key start end_
- RPOP _key_
- RPUSH _key value_


#### Sets

- SADD _key member_
- SCARD _key_
- SISMEMBER _key_ _member_
- SMEMBERS _key_
- SREM _key member_
- SINTER _key1 key2 ... keyN_
- SINTERSTORE _dstkey key1 key2 ... keyN_

For more explanations, use the HELP command directly in the client.

## Getting started

TODO

## What has been tested

- Everything regarding the data structure store

- The server doing operations on the store

- The construction of the requests made by the client to the server

## What has NOT been tested (yet)

Either not tested or in experimental stage:

- The client interface

- The client-server connection

- The "did you mean X" function. It uses the Levenshtein distance to find the closest match, without
any kind of heuristic behind it, so it might be way off sometimes

## Examples

TODO

## Feedback

### Travis

- Trivial à utiliser dans une utilisation "simple", e.g sans cron jobs etc.

- Les erreurs ne sont pas toujours très claires. Par exemple il n'y a aucune indication directe sur 
comment résoudre des erreurs comme : `The command "eval mvn install -DskipTests=true 
-Dmaven.javadoc.skip=true -B -V" failed.` qui ne sont au final que des soucis de compatibilité entre 
les versions utilisées par travis et celles utilisées dans le pom. 

- Le principal intérêt de Travis est découvrir rapidement si un commit a cassé quelque chose, mais ça
ne devrait pas arriver si on vérifie que les tests passent avant de commit. Néanmoins ça devient plus
utile au moment de merge : on sait directement si le pull request peut être validé (en tout cas sur 
le plan "technique") sans avoir à vérifier manuellement que la personne demandant le pull de sa 
branche a bien passé les tests. On peut donc facilement gérer le projet à "grande échelle".
 
- Etant donné la facilité d'utilisation et le fait que ce soit gratuit pour une utilisation open 
source, intégrer travis à tous ses projets ne peut qu'être positif, exception faite du cas où on se
moque de passer les tests (ou qu'il n'y a pas de tests unitaires). 

### Projet

Une amélioration possible (en tout cas d'un point de vue étudiant noté) serait de détailler dans le
sujet la notation. On sait en gros sur quoi nous sommes évalués, mais 

- Pour Github, les commits doivent-ils être pertinents (clareté, description, ...) ? Ne pas utiliser 
de branches est-il pénalisant ?  

- Pour la qualité du code, comment est-elle évaluée ? Uniquement par le fait que les tests soient 
passés (et donc que le logiciel produit est fonctionnel) ou bien d'autres critères sont pris en 
comptes (par exemple : structuration, cohérence, efficacité, documentation, facilité à maintenir,
etc.) ? 

- L'évaluation des fonctionnalités est évalué notamment à partir de la couverture, mais est-ce si 
important ? Typiquement dans le cas de fonctions qui ne font "rien" (par exemple un wrapper d'une 
ligne qui retourne une autre fonction), écrire des tests semble être une perte de temps, mais ne
pas le faire diminuera le taux de couverture de code.

