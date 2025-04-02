# Desafio de Padrões de Projeto Java - DIO

## Sobre o Projeto
Este projeto foi desenvolvido como parte do desafio da Digital Innovation One (DIO) para a implementação de padrões de projeto em Java utilizando Spring Boot. O objetivo é demonstrar o uso de padrões de projeto para melhorar a estrutura e a manutenção do código.

## Tecnologias Utilizadas
- Java 17+
- Spring Boot 3+
- Spring Data JPA
- Spring Web
- OpenFeign
- H2 Database
- Swagger (OpenAPI 3)

## Padrões de Projeto Implementados
1. **Singleton** - Garante que uma instância única de uma classe seja criada e reutilizada.
2. **Strategy** - Define um conjunto de algoritmos intercambiáveis para manipular entidades do sistema.
3. **Facade** - Simplifica a interação com serviços externos, abstraindo a complexidade.

## Estrutura do Projeto
```
├── src
│   ├── main
│   │   ├── java/com/cwcdev/dio
│   │   │   ├── controller
│   │   │   ├── model
│   │   │   ├── repository
│   │   │   ├── service
│   │   │   ├── service/impl
│   │   ├── resources
│   │   │   ├── application.properties
│   ├── test
├── pom.xml
```

## Endpoints da API
| Método | Endpoint      | Descrição                     |
|--------|-------------|--------------------------------|
| GET    | /clientes    | Lista todos os clientes      |
| GET    | /clientes/{id} | Busca cliente por ID       |
| POST   | /clientes    | Adiciona um novo cliente    |
| PUT    | /clientes/{id} | Atualiza um cliente       |
| DELETE | /clientes/{id} | Remove um cliente         |

## Como Executar o Projeto
1. Clone este repositório
   ```sh
   git clone https://github.com/seu-usuario/padroes-projeto-java-dio.git
   ```
2. Acesse o diretório do projeto
   ```sh
   cd padroes-projeto-java-dio
   ```
3. Execute o projeto com Maven
   ```sh
   mvn spring-boot:run
   ```
4. Acesse a documentação da API via Swagger:
   ```
   http://localhost:8080/swagger-ui/index.html
   ```

## Autor
Desenvolvido por Calebe Werneck como parte do desafio DIO.

