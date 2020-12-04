## Essa Aplicação tem o objetivo de validar que uma senha atenda um padrão mínimo de segurança

Para considerar que uma senha seja válida foram considerados os seguintes pré-requisitos:

- Nove ou mais caracteres
- Ao menos 1 dígito
- Ao menos 1 letra minúscula
- Ao menos 1 letra maiúscula
- Ao menos 1 caractere especial
  - Considere como especial os seguintes caracteres: !@#$%^&*()-+
- Não possuir caracteres repetidos dentro do conjunto
- Espaços em branco não devem ser considerados como caracteres válidos

## Desenho de Arquitetura da Aplicação

![arquitetura](https://github.com/davinogueiradev/password-validator/blob/main/img/password_validator.png?raw=true "Arquitetura macro")


## Para subir a aplicação localmente os seguintes passos são necessários:  

### Pré-requisitos

Nesse momento precisamos do [Git](https://git-scm.com) e [docker-compose](https://docs.docker.com/compose/install).

#### Rodando

```bash
Ex.:

# Clone o repositório
$ git clone https://github.com/davinogueiradev/password-validator.git

# Acesse a pasta do projeto
$ cd password-validator

# Compile a aplicação
$ docker-compose build

# Execute a aplicação
$ docker-compose up

# Acesse a aplicação no endereço: http://localhost:8080
```
### Exemplo de cURL para chamar a API

```bash
Ex.:

curl --location --request POST 'http://localhost:8080/validate' \
--header 'content-type: application/json' \
--data-raw '{
    "password": "AbTp9!fok"
}'

```

## Para o ambiente de desenvolvimento precisamos de mais ferramentas:

- [SDKMan](https://sdkman.io/install) (recomendado)
- [Java](https://sdkman.io/jdks#AdoptOpenJDK) versão mínima 11
- [Gradle](https://sdkman.io/sdks#gradle)
- [Micronaut](https://sdkman.io/sdks#micronaut) (opcional)

> esse projeto foi dividido em dois microsserviços, o server usa GRPC como protocolo de comunicação e o client é uma API REST

```bash
Ex.:

# Clone o repositório
$ git clone git@github.com:davinogueiradev/password-validator.git

# acesse a pasta principal do projeto
$ cd password-validator

# o consul é uma dependência do projeto e ele está configurado no docker-compose
$ docker-compose up -d consul

# Acesse a pasta do projeto server
$ cd password-validator-server/

# Compile a aplicação
$ gradle clean build

# Execute a aplicação
$ gradle run

# Abra um outro terminal e acesse a pasta do projeto client
$ cd .. && cd password-validator-client

# Compile a aplicação
$ gradle clean build

# Execute a aplicação
$ gradle run

# Acesse a aplicação no endereço: http://localhost:8080
```

## Principais tecnologias utilizadas:
 - Linguagem de programação [Kotlin](https://kotlinlang.org/)
 - Framework [Micronaut](https://micronaut.io/) para Server [GRPC](https://grpc.io/) e API REST
 - [Consul](https://www.consul.io/) para Service Discovery e Service Mesh
 - [Docker](https://docs.docker.com/get-docker/) como container para aplicação
 - [Docker Compose](https://docs.docker.com/compose/install/) para juntar todas as partes da aplicação e subir localmente

 ## Microsserviço password-validator-client

 - Uma API REST utilizando o framework Micronaut para expor um endpoint que recebe e responde JSON, a validação da senha é feita no Server se comunicando via GRPC onde esta toda a regra de negócio.
 - Nele temos o teste de integração com o Server


 ## Microsserviço password-validator-server

 - Uma aplicação que utiliza o framework Micronaut para criar um server com GRPC, onde esta toda a regra de negócio de validação da senha.
 - Para melhor organização e manutenção do código, o padrão de projeto Strategy foi utilizado para fazer as validações da Senha, onde é possível criar novos validadores através da implementação da Interface ValidatorStrategy
 
    ```kotlin
    package dev.davinogueira.server.validators

    interface ValidatorStrategy {
        fun isValid(password : String) : Boolean
    }
    ```
- Testes unitários foram escritos para garantir a qualidade

### O porque de cada escolha.
- Kotlin é uma linguagem que gosto bastante por se aproveitar bem do ecossistema Java, ter o suporte de ótima IDE como o Intellij e uma sintaxe mais enxuta com bastante recursos legais
- Micronaut, um framework já pensado para aplicações Cloud Native, com uma ótima documentação, uma comunidade bem ativa, fácil integração com GRPC, Data Access, entre outros e compila para GraalVM
- GRPC, um padrão também pensado para aplicações Cloud Native, muito performático, excelente para comunicação entre serviços e baseado em HTTP/2.





TODO: clean code 