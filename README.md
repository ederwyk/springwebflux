# API Sample WebFlux 
Éder de Souza Cardoso

API de exemplo da implementação do Spring Webflux, que permite trabalhar com programação reativa em aplicações Java com Spring.

* Informar url do mongoDB na propriedade **spring.data.mongodb.uri** em [application.properties](/src/main/resources/application.properties)

## Technologies

* Java (>= 11)
* Spring Boot (>= 2.3.0)
* MongoDB
 
Ver mais em [Spring WebFlux](https://docs.spring.io/spring-framework/docs/current/reference/html/web-reactive.html)

## Document

```
dog: {
    id*: string
    name*: string
}
```

### Retorno de uma lista com todos os cachorros.

>>>
`curl GET /dog`
>>>

### Retorno de um cachorro pelo id.

>>>
`curl GET /dog/{id}`
>>>

### Persistir um novo cachorro.

>>>
`curl POST /dog \
--data-raw '{
  "id": "",
  "name": ""
}'`

>>>