# Sistema de Controle de Pedidos para Lanchonete

Este projeto é um sistema de controle de pedidos para uma lanchonete. Ele possui as seguintes funcionalidades:

- Cadastro e gerenciamento de clientes
- Cadastro e gerenciamento de produtos
- Criação, atualização e acompanhamento de pedidos
- Integração com meios de pagamento

## Rotas disponíveis na API
Todas as rotas estão listadas através do Swagger no endereço `http://localhost:8080/swagger-ui/index.html`

## Pré-requisitos

Antes de executar o projeto, verifique se você possui os seguintes requisitos:

- Docker e docker-compose instalados
- Java 17 (caso queira buildar o projeto fora do container)

## Executando o Projeto

Siga as instruções abaixo para executar o projeto:

1. Faça o clone deste repositório: `git clone https://github.com/diego-jo/tech-challenge`
2. Acesse o diretório do projeto: `cd tech-challenge`
3. Execute o comando para iniciar o ambiente Docker: `docker-compose up -d`
4. Aguarde até que os containers estejam prontos e em execução.
5. Acesse a API pelo seu client de escolha pelo seguinte endereço base: `http://localhost:8080`

Obs.: Sugerimos o Insomnia e já disponibilizamos uma collection em `tech-challenge/collections/insomnia` 

Caso queira buildar o projeto fora do container, siga os passos abaixo:

1. Certifique-se de ter o Java 17 instalado em sua máquina.
2. Acesse o diretório do projeto: `cd tech-challenge`
3. Execute o comando para buildar o projeto: `./mvnw clean package`
4. Execute o comando para iniciar o ambiente Docker: `docker-compose -f docker-compose-local.yml up -d`
5. Execute o comando para executar a aplicação: `./mvnw spring-boot:run`


## Contribuidores
- [pedroprj](https://github.com/pedroprj)
- [engmarcosalves](https://github.com/engmarcosalves)
- [Vandrs](https://github.com/Vandrs)
- [coelhos-gabi](https://github.com/coelhos-gabi)
- [diego-jo](https://github.com/diego-jo)