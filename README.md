# POC Redis
Projeto criado para validar o uso do redis para cache de dados e sua paginação.

A linguagem principal é Java com Spring-Boot.

##Spring CACHE Redis
- Redis configuration are in .yml files
- To startup Redis Docker container
```sh
docker-compose -f config/redis/docker-compose.yml up --build
```
- With Redis UP, to access redis-cli inside container run the following command:
```sh
docker exec -it redis_cache redis-cli
```
- Redis-cli: To list all keys stored:
```sh
keys *
```
- Redis-cli: To get a key value:
```sh
GET "key"
```
- Redis-cli: To see the time-to-live of a key:
```sh
TTL "key"
```
- Redis-cli: To clear all keys
```sh
FLUSHALL
```
