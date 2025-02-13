# eventdriven
API exemplo responsavel para aplicacao EDA

# Event-Driven Application

![Build Status](https://img.shields.io/badge/build-passing-brightgreen)
![Coverage](https://img.shields.io/badge/coverage-100%25-success)
![Java](https://img.shields.io/badge/java-17-blue)
![License](https://img.shields.io/badge/license-MIT-blue.svg)
![Version](https://img.shields.io/badge/version-1.0.0-brightgreen)

## 📌 Sobre o Projeto
Esta aplicação implementa um modelo de **Event-Driven Architecture (EDA)** utilizando **Java 17, Spring Boot 3 e RabbitMQ**. Ela permite a publicação e consumo de eventos através de uma fila de mensageria.

---

## ⚙️ Tecnologias Utilizadas
- **Java 17**
- **Spring Boot 3.4.2**
- **Spring AMQP (RabbitMQ)**
- **Spring Web**
- **Spring Doc OpenAPI (Swagger UI)**
- **JUnit 5 & Mockito** (para testes)

---

## 🚀 Como Executar o Projeto

### 1️⃣ **Configurar o RabbitMQ**

Antes de rodar a aplicação, você precisa instalar e configurar o **RabbitMQ**.

**Dica/Observação:** Usando o Docker, pode ser uma maneira mais rápida. Executar o seguinte comando no terminal:
```sh
docker run -d --name rabbitmq -p 5672:5672 -p 15672:15672 rabbitmq:3-management
```

### 🔹 **Instalação no Windows**
1. **Baixar e instalar o Erlang** (necessário para o RabbitMQ):
    - [https://erlang.org/downloads](https://erlang.org/downloads)
2. **Baixar e instalar o RabbitMQ**:
    - [https://www.rabbitmq.com/download.html](https://www.rabbitmq.com/download.html)
3. **Habilitar o Painel de Gerenciamento**:
   Abra o **Prompt de Comando** como administrador e execute:
   ```sh
   rabbitmq-plugins enable rabbitmq_management
   ```
4. **Iniciar o RabbitMQ**:
   ```sh
   net start RabbitMQ
   ```
5. **Acessar o painel de gerenciamento**:
    - URL: [http://localhost:15672](http://localhost:15672)
    - **Usuário/Senha:** `guest / guest`

### 🔹 **Instalação no Linux/macOS**
1. **Instalar Erlang e RabbitMQ**:
   ```sh
   sudo apt update && sudo apt install -y erlang rabbitmq-server  # Para Debian/Ubuntu
   brew install rabbitmq  # Para macOS com Homebrew
   ```
2. **Habilitar e iniciar o RabbitMQ**:
   ```sh
   sudo rabbitmq-plugins enable rabbitmq_management
   sudo systemctl start rabbitmq-server  # Linux
   brew services start rabbitmq  # macOS
   ```
3. **Acessar o painel de gerenciamento**:
    - URL: [http://localhost:15672](http://localhost:15672)

### 2️⃣ **Configurar e Rodar a Aplicação**
1. Clone o repositório:
   ```sh
   git clone https://github.com/seu-usuario/event-driven-app.git
   cd event-driven-app
   ```
2. Compile e rode a aplicação:
   ```sh
   mvn clean install
   mvn spring-boot:run
   ```
3. Acesse a API pelo Swagger:
    - [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

---

## 📡 Configuração do RabbitMQ na Aplicação
O RabbitMQ está configurado no arquivo **`application.yml`**:

```yaml
spring:
  rabbitmq:
    host: localhost
    port: 5672
    username: guest
    password: guest

order:
  queue:
    name: order-queue
```

Essa configuração permite que a aplicação se conecte ao RabbitMQ localmente e utilize a fila **`order-queue`**.

---

## ✅ Como Testar a Aplicação

### 📩 **Enviar um Evento para a Fila**
Use o **Postman** ou `cURL` para enviar um pedido:
```sh
curl -X POST http://localhost:8080/api/orders \
     -H "Content-Type: application/json" \
     -d '{"orderId":"123", "customerName":"João Silva", "status":"PENDING"}'
```

### 📥 **Verificar a Mensagem no RabbitMQ**
1. Vá até o painel do RabbitMQ: [http://localhost:15672](http://localhost:15672)
2. Clique na aba **Queues** e selecione `order-queue`
3. Clique em **Get Messages** para visualizar a mensagem enviada.

---

## 🔍 Cobertura de Código e Testes
A aplicação utiliza **JUnit 5 e Mockito** para garantir a qualidade do código.

### 🔹 **Rodar os Testes**
Execute:
```sh
mvn test
```

### 🔹 **Verificar a Cobertura de Código**
Para gerar um relatório de cobertura de testes, adicione o **JaCoCo** no `pom.xml`:
```xml
<plugin>
    <groupId>org.jacoco</groupId>
    <artifactId>jacoco-maven-plugin</artifactId>
    <version>0.8.8</version>
    <executions>
        <execution>
            <goals>
                <goal>prepare-agent</goal>
            </goals>
        </execution>
        <execution>
            <id>report</id>
            <phase>verify</phase>
            <goals>
                <goal>report</goal>
            </goals>
        </execution>
    </executions>
</plugin>
```

Depois, gere o relatório com:
```sh
mvn clean verify
```
O relatório será gerado em:
```
target/site/jacoco/index.html
```
Abra esse arquivo no navegador para visualizar os resultados.

---

## 📌 Conclusão
Agora você tem a aplicação **Event-Driven Architecture (EDA)** configurada com **RabbitMQ** e testes automatizados com **JUnit 5 e Mockito**! 🚀
Se precisar de melhorias ou mais ajustes, fique à vontade para contribuir. 😊

---

### 📧 Contato
Caso tenha dúvidas ou sugestões, entre em contato:
- **Email:** alexandremfreitas@gmail.com
- **GitHub:** [https://github.com/amfreitas1981](https://github.com/amfreitas1981)

---

