# NTT Itau Challenge
Projeto desenvolvido para avaliação técnica

## Recursos utilizados para desenvolvimento do projeto
- Java 11
- Spring Boot 2.7.12
- Docker (Para ambiente local)
- Postgres (container no docker)
- Flyway

## Passos para execução do projeto

### Requisitos de ambiente
- Java 11
- Docker
- Postman/Insomnia

### Maven
Acessar diretório raiz do projeto e executar o comando
```cpp
mvn clean install
```

### Ambiente
Acessar diretório raiz do projeto e executar o comando
```cpp
docker-compose up
```

### Collection Postman/Insomnia
Importar collection disponível na pasta collection, dentro do diretório raiz do projeto

### Documentação (swagger)
Acessar a URL
```cpp
http://localhost:8080/swagger-ui.html
```

### Execução do Projeto
Acessar diretório raiz do projeto e executar o comando
```cpp
mvn spring-boot:run
```