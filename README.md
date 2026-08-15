# Springboot Data Faker

![GitHub last commit](https://img.shields.io/github/last-commit/letsdevapps/springboot-datafaker)

![Java](https://img.shields.io/badge/java-21+-brightgreen)
![Springboot](https://img.shields.io/badge/springboot-3+-brightgreen)

![Docker](https://img.shields.io/badge/docker-enabled-blue)
![Status](https://img.shields.io/badge/status-active-success)

## Docker

    docker build -t springboot-datafaker .
    
    docker run --rm -it -p 8080:8080 springboot-datafaker

## Database

Expliquei 3 formas para inicializar a imagem com o banco de dados, escolha 1 delas:

1. Iniciar a database diretamente

		docker network create data-faker-network

	    docker run -d \
	    --name data-faker-database \
	    --network data-faker-network \
	    -e POSTGRES_DB=datafaker \
	    -e POSTGRES_USER=postgres \
	    -e POSTGRES_PASSWORD=postgres \
	    -p 5432:5432 \
	    postgres:16

		docker exec -it data-faker-database psql -U postgres -d datafaker

Isso cria e inicia:

Container: data-faker-database
Database:  datafaker
User:      postgres
Password:  postgres
Porta:     5432

2. Iniciar a database pelo arquivo de configuração `Dockerfile-database`

    	docker build -f Dockerfile-database -t data-faker-database .
    
	    docker run -d \
	    --name data-faker-database \
	    -p 5432:5432 \
	    data-faker-database

3. Iniciar a database pelo arquivo de configuração de variaveis de ambiente `env`

	    docker run -d \ 
	    --name data-faker-database \
	    --env-file .env-ex \
	    -p 5432:5432 \
	    postgres:16

## API Endpoints

Home API index

	GET /api
	----- Data Faker | Home Api | Index -----
