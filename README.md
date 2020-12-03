# Objetivo da API

## Essa API tem o objetivo de validar se uma senha atende um padrão mínimo de segurança

Para considerar que uma senha tenha valida foram considerados os seguintes pré-requisitos:

- Nove ou mais caracteres
- Ao menos 1 dígito
- Ao menos 1 letra minúscula
- Ao menos 1 letra maiúscula
- Ao menos 1 caractere especial
  - Considere como especial os seguintes caracteres: !@#$%^&*()-+
- Não possuir caracteres repetidos dentro do conjunto
- Espaços em branco não devem ser considerados como caracteres válidos


Essa API recebe um POST com a senha e retorna um valor Boleano como resultado  

# Para subir o projeto localmente os seguintes passos são necessários:  

### Pré-requisitos

Nesse momento precisamos do [Git](https://git-scm.com) e [Docker-compose](https://docs.docker.com/compose/install).

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

## Para o ambiente de desenvolvimento precisamos de mais ferramentas:

- [SDKMan](https://sdkman.io/install) (recomendado)
- [Java](https://sdkman.io/jdks#AdoptOpenJDK) versão mínima 11
- [Gradle](https://sdkman.io/sdks#gradle)
- [Micronaul](https://sdkman.io/sdks#micronaut) (opcional)

### esse projeto foi dividido em dois projetos, o server é usa GRPC como protocolo de comunicação e o client é o client GRPC e API Web

```bash
Ex.:

# Clone o repositório
$ git clone git@github.com:davinogueiradev/password-validator.git

# acesse a root do projeto
$ cd password-validator

# o consul é uma dependencia do projeto e ele esta configurado no docker-compose
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

### Exemplo de curl para chamar a API

```bash
Ex.:

curl --location --request POST 'http://localhost:8080/validate' \
--header 'content-type: application/json' \
--data-raw '{
    "password": "AbTp9!fok"
}'

```

## Principais tecnologias utilizadas:
 - Linguagem de programação de [Kotlin](https://kotlinlang.org/)
 - Framework [Micronaut](https://micronaut.io/) para Server [GRPC](https://grpc.io/) e Client Web
 - [Consul](https://www.consul.io/) para Service Discovery e Servoce Mesh
 - [Docker](https://docs.docker.com/get-docker/) como container para aplicação
 - [Docker Compose](https://docs.docker.com/compose/install/) para juntar todas as partes da aplicação e subir localmente

 ## Arquitetura do Client Web

 Uma API REST utilizando Micronaut para expor um endpoint que recebe e responde JSON e criar um client para conectar ao server via GRPC.\


 ## Arquitetura do Server

 Uma aplicação que utiliza o Micronaut para criar um server com GRPC, onde esta toda a regra de negócio de validação da senha.



