# Prompt para Mejorar el Codigo Base

Copia y pega el contenido del bloque de abajo en un asistente de IA (Claude, ChatGPT)
para obtener un ZIP con el proyecto completo y arrancable.

Si preferis trabajar en tu editor con un agente local (Claude Code, Cursor, Copilot), usa `AGENTS.md` en vez de este archivo: dice lo mismo pero para que escriba los archivos en disco.

## Las dos reglas que no se negocian

1. **Completa el boilerplate.** Todo lo que el proyecto necesita para compilar y arrancar: manifiesto de dependencias, punto de entrada, configuracion, capa de interfaz, y las capas del patron arquitectonico declarado. Eso es andamiaje y es tu trabajo.
2. **NO resuelvas el reto.** Los entregables de las fases son el trabajo de la persona. El hueco pedagogico se deja como esta: el proyecto arranca, pero lo que el reto pide implementar NO esta implementado.

Dicho de otra forma: si algo impide compilar, arreglalo. Si algo es logica de negocio incompleta, validaciones ausentes, un secreto hardcodeado o un patron mejorable, dejalo exactamente como esta — es lo que la persona tiene que encontrar.

## Lo que le falta a este proyecto

Esto NO lo tenes que adivinar: salio de comparar el proyecto contra la arquitectura declarada del reto y de un analisis estatico del codigo. Completalo TODO.

### Referencias colgando en el codigo que si esta

Cada una rompe la compilacion:

- `src/main/java/com/pragma/financial/api/model/dto/ClientRequest.java` — `io.swagger.v3`: El import io.swagger.v3.oas.annotations.media.Schema pertenece a io.swagger.v3, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- `src/main/java/com/pragma/financial/api/model/dto/ClientResponse.java` — `io.swagger.v3`: El import io.swagger.v3.oas.annotations.media.Schema pertenece a io.swagger.v3, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- `src/main/java/com/pragma/financial/api/config/OpenApiConfig.java` — `io.swagger.v3`: El import io.swagger.v3.oas.models.OpenAPI pertenece a io.swagger.v3, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- `src/main/java/com/pragma/financial/api/controller/ClientController.java` — `io.swagger.v3`: El import io.swagger.v3.oas.annotations.Operation pertenece a io.swagger.v3, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- `src/main/java/com/pragma/financial/api/service/ClientServiceImpl.java` — `ClientRepository.save`: Se invoca `save` sobre `ClientRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/pragma/financial/api/service/ClientServiceImpl.java` — `ClientRepository.findById`: Se invoca `findById` sobre `ClientRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/pragma/financial/api/service/ClientServiceImpl.java` — `ClientRepository.findAll`: Se invoca `findAll` sobre `ClientRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/pragma/financial/api/service/ClientServiceImpl.java` — `ClientRepository.delete`: Se invoca `delete` sobre `ClientRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/pragma/financial/api/service/ClientServiceTest.java` — `Client.setBalance`: Se invoca `setBalance` sobre `Client`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/pragma/financial/api/service/ClientServiceTest.java` — `ClientRepository.save`: Se invoca `save` sobre `ClientRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.

## Como saber que terminaste

```bash
mvn clean compile
```

Ese comando corriendo sin errores es la definicion de "listo".

---

```
## Briefing del reto (autoridad)
Este bloque manda sobre los archivos adjuntos. El stack y el rol salen de AQUÍ, no de un topic genérico ni de markdown placeholder.

### Contexto técnico original
Crear una API REST con persistencia en H2 y documentación con Swagger

### Reto
- Tema: Creación de API REST
- Seniority: junior-l1
- Tipo: practical
- Título: Desarrollo de una API REST con persistencia en H2 y documentación con Swagger
- Tiempo estimado: 8 horas

### Fases (trabajo del HUMANO — PROHIBIDO completarlas)
No implementes estos entregables. Dejalos como hueco pedagógico. El asistente solo materializa el proyecto arrancable para que el participante pueda trabajar.
- Fase 1: Definición del modelo de datos — objetivo: Crear el modelo de datos para los clientes, incluyendo atributos necesarios como nombre, email y fecha de registro. — entregable (NO resolver): Modelo de datos definido y validado.
- Fase 2: Implementación de la API REST — objetivo: Crear los endpoints para la API REST que permitan la creación, lectura, actualización y eliminación de registros de clientes. — entregable (NO resolver): API REST implementada con los endpoints necesarios.
- Fase 3: Persistencia de datos en H2 — objetivo: Configurar la persistencia de los datos de los clientes en una base de datos H2. — entregable (NO resolver): Configuración y persistencia de datos en H2.
- Fase 4: Documentación con Swagger — objetivo: Documentar la API REST utilizando Swagger para facilitar su comprensión y uso. — entregable (NO resolver): Documentación de la API REST utilizando Swagger.

Eres un asistente experto en análisis, corrección y generación de archivos de cualquier tipo:
código fuente, documentación, hojas de cálculo, documentos Word, configuraciones, entre otros.
Voy a enviarte una cadena de texto que contiene uno o más archivos. Cada archivo está delimitado por un marcador con el siguiente formato:
// === ARCHIVO: ruta/del/archivo.extension ===
o también puede aparecer como:
## === ARCHIVO: ruta/del/archivo.extension ===
Lo que sigue al marcador puede ser:

El contenido real del archivo (código, texto, YAML, etc.)
Una descripción en lenguaje natural de lo que debe contener el archivo


TU TAREA
PASO 0 — ¿Esto es un proyecto o una carcasa?
Antes de extraer archivos, leé el Briefing (si está) y diagnosticá el adjunto.

Es CARCASA si ocurre CUALQUIERA de estas:
- No hay manifiesto de dependencias del stack del briefing (manifest.json de VTEX IO / package.json / pom.xml / build.gradle / requirements.txt / go.mod / *.tf / *.csproj, según corresponda)
- Hay un "binario" que en realidad es un comentario ("no puede ser mostrado como texto plano", placeholder .fig/.docx vacío)
- Los markdowns ya completan entregables de fases posteriores ("se implementó fade-in", lista de áreas ya resuelta)

Si es CARCASA:
- MATERIALIZÁ un proyecto que arranca en el stack del briefing (VTEX IO Store Framework, Angular, Terraform, pytest, Nest, etc.). Incluí manifiesto, punto de entrada y capa de interfaz reales.
- NO copies los markdowns de "solución" como si fueran el producto. Son ruido de generación.
- NO resuelvas las fases del briefing (están marcadas PROHIBIDO). Dejá el hueco pedagógico: el flujo existe, las microinteracciones/calidad/infra que el reto pide NO están hechas.
- Después seguí al PASO 5 (ZIP).

Si es un proyecto REAL (manifiesto + código que compila o arranca):
- Seguí PASO 1 en adelante. 🔴 compilación sí. 🟡 pedagógico no.

PASO 1 — Detección y extracción
Identifica todos los archivos presentes en la cadena. Para cada archivo extrae:

Su ruta completa (ej: src/main/java/com/pragma/Service.java)
Su contenido o descripción

PASO 2 — Clasificación por tipo
Clasifica cada archivo en una de estas categorías:
A) Código fuente (Java, Python, TypeScript, JavaScript, Kotlin, etc.)
B) Configuración / documentación (YAML, properties, Markdown, JSON, txt, etc.)
C) Excel (.xlsx, .xls, .csv)
D) Word (.docx, .doc)
E) Otro tipo de archivo binario o especial
PASO 3 — Clasificación de errores en código fuente

Objetivo prioritario: que el proyecto compile. No corrijas flujo de negocio ni lógica funcional.

Antes de modificar cualquier archivo de código fuente, clasifica cada problema encontrado en una de estas dos categorías:
🔴 ERROR DE COMPILACIÓN — corregir siempre
Son errores que impiden que el proyecto arranque, sin valor pedagógico:

Import faltante o incorrecto
Clase, método o variable referenciada que no existe en ningún archivo del proyecto
Error de sintaxis
Anotación con atributos inválidos
Dependencia ausente en pom.xml, package.json, etc.
Archivo referenciado que no existe y debe ser creado con implementación mínima

→ CORREGIR estos errores.
🟡 PROBLEMA FUNCIONAL O DE CALIDAD — preservar siempre
Son problemas que no impiden compilar. Pueden ser intencionales para el aprendizaje:

Clave secreta hardcodeada ("secret", "password123")
API deprecada que funciona pero tiene reemplazo moderno
Lógica de negocio incorrecta o incompleta
Código redundante o de baja legibilidad
Falta de validaciones en flujo de negocio
Patrones de diseño incorrectos pero funcionales
Concurrencia no segura
Configuración funcional pero no óptima

→ PRESERVAR tal cual. No corregir, no mejorar, no comentar.
PASO 4 — Procesamiento según tipo de archivo
Tipo A — Código fuente
Aplica únicamente las correcciones clasificadas como 🔴 ERROR DE COMPILACIÓN.
No alteres ningún elemento clasificado como 🟡 PROBLEMA FUNCIONAL O DE CALIDAD.
Si falta un archivo referenciado, créalo con la implementación mínima necesaria para compilar.
Tipo B — Configuración / documentación
Extrae el contenido tal cual, sin modificaciones salvo errores evidentes de sintaxis
(ej: YAML mal indentado).
Tipo C — Excel (.xlsx)
Si viene con contenido real, genera el archivo respetando ese contenido.
Si viene con descripción en lenguaje natural, genera un archivo Excel funcional con:

Fila de encabezados en negrita con color de fondo distintivo
Columnas con ancho ajustado al contenido
Tipos de dato correctos por columna
Validaciones si la descripción lo indica
Hojas nombradas descriptivamente si hay más de una
Filas de ejemplo si no hay datos reales

Tipo D — Word (.docx)
Si viene con contenido real, genera el archivo respetando ese contenido.
Si viene con descripción en lenguaje natural, genera un documento Word funcional con:

Estilos de título (Título 1, Título 2) para jerarquía de secciones
Fuente legible (Calibri o equivalente), tamaño 11-12pt para cuerpo
Márgenes estándar
Tabla de contenido si tiene múltiples secciones
Tablas con encabezados en negrita si aplica

Tipo E — Otro
Genera el archivo con el contenido o estructura más apropiada según la descripción.
PASO 5 — Exportación en ZIP
Empaqueta todos los archivos en un único archivo ZIP descargable respetando exactamente
la estructura de rutas indicada por los marcadores.
El ZIP debe incluir:

Archivos de código con únicamente los errores de compilación corregidos
Archivos de configuración y documentación sin cambios
Archivos nuevos creados para resolver dependencias de compilación faltantes
Archivos Excel y Word generados desde descripción

IMPORTANTE: El ZIP debe estar listo para descargar al finalizar. No preguntes si el usuario
quiere generarlo. Simplemente genera el archivo y proporciona el enlace de descarga; No debes desplegar en el chat el resumen de lo que arreglaste al Zip, solo entregalo.

REGLAS IMPORTANTES

No omitas ningún archivo aunque no tenga errores ni modificaciones
Respeta los nombres y rutas exactas indicadas por los marcadores
Si un archivo no tiene marcador claro, infiere el nombre desde su contenido
Si la cadena contiene solo documentación, placeholders o binarios fake, NO la reproduzcas:
aplicá PASO 0 (materializar el proyecto del briefing). Reproducir la carcasa es un fallo.
No agregues texto después del enlace de descarga del ZIP
No preguntes si el usuario quiere el ZIP: simplemente generalo siempre
Si detectas que falta un archivo de configuración necesario para compilar
(pom.xml, package.json, requirements.txt, build.gradle, etc.), créalo e inclúyelo
inferiendo su contenido desde los imports y frameworks detectados en el código
Nunca corrijas problemas 🟡 aunque parezcan obvios o fáciles de mejorar.
El participante que recibirá este proyecto los debe encontrar y resolver él mismo.


INPUT
Aquí está la cadena con los archivos:

// === ARCHIVO: pom.xml ===
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>3.4.0</version>
        <relativePath/>
    </parent>

    <groupId>com.pragma</groupId>
    <artifactId>financial-api</artifactId>
    <version>0.0.1-SNAPSHOT</version>
    <name>financial-api</name>
    <description>API REST para gestión de clientes financieros</description>

    <properties>
        <java.version>21</java.version>
        <spring-boot.version>3.4.0</spring-boot.version>
    </properties>

    <dependencies>
        <!-- Spring Boot Starters -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-jpa</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-validation</artifactId>
        </dependency>

        <!-- H2 Database -->
        <dependency>
            <groupId>com.h2database</groupId>
            <artifactId>h2</artifactId>
            <scope>runtime</scope>
        </dependency>

        <!-- Swagger/OpenAPI -->
        <dependency>
            <groupId>org.springdoc</groupId>
            <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
            <version>2.6.0</version>
        </dependency>

        <!-- Lombok -->
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <scope>provided</scope>
        </dependency>

        <!-- Test -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
    </dependencies>

    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
                <configuration>
                    <excludes>
                        <exclude>
                            <groupId>org.projectlombok</groupId>
                            <artifactId>lombok</artifactId>
                        </exclude>
                    </excludes>
                </configuration>
            </plugin>
        </plugins>
    </build>
</project>

// === ARCHIVO: src/main/java/com/pragma/financial/api/FinancialApiApplication.java ===
package com.pragma.financial.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.time.Clock;

@SpringBootApplication
@EnableConfigurationProperties
public class FinancialApiApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(FinancialApiApplication.class, args);
    }
    
    @Bean
    public Clock clock() {
        return Clock.systemUTC();
    }
    
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("*")
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                        .allowedHeaders("*");
            }
        };
    }
    
    @Bean
    public String appName() {
        return "Financial API";
    }
}

// === ARCHIVO: src/main/resources/application.yml ===
spring:
  application:
    name: financial-api
  
  datasource:
    url: jdbc:h2:mem:financialdb
    driverClassName: org.h2.Driver
    username: sa
    password: ""
    
  h2:
    console:
      enabled: true
      path: /h2-console
      settings:
        web-allow-others: true
        trace: false
  
  jpa:
    database-platform: org.hibernate.dialect.H2Dialect
    hibernate:
      ddl-auto: update
    show-sql: true
    properties:
      hibernate:
        format_sql: true

server:
  port: 8080
  servlet:
    context-path: /api

springdoc:
  api-docs:
    path: /api-docs
  swagger-ui:
    path: /swagger-ui.html
    operationsSorter: alpha
    tagsSorter: alpha
    docExpansion: none
    disable-swagger-default-url: true
"

// === ARCHIVO: src/main/java/com/pragma/financial/api/repository/ClientRepository.java ===
package com.pragma.financial.api.repository;

import com.pragma.financial.api.model.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ClientRepository extends JpaRepository<Client, UUID> {
    Optional<Client> findByEmail(String email);

    boolean existsByEmail(String email);

    boolean existsByIdAndEmailNot(UUID id, String email);
}

// === ARCHIVO: src/main/java/com/pragma/financial/api/model/dto/ClientRequest.java ===
package com.pragma.financial.api.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
@Schema(description = "DTO para la creación y actualización de clientes")
public class ClientRequest {
    @Schema(description = "Nombre completo del cliente", example = "Juan Pérez")
    @NotBlank(message = "El nombre no puede estar vacío")
    @Size(max = 100, message = "El nombre no puede exceder los 100 caracteres")
    private String name;

    @Schema(description = "Correo electrónico del cliente", example = "juan.perez@example.com")
    @NotBlank(message = "El email no puede estar vacío")
    @Email(message = "El email debe ser válido")
    @Size(max = 100, message = "El email no puede exceder los 100 caracteres")
    private String email;

    @Schema(description = "Número de teléfono del cliente", example = "5551234567")
    @Size(max = 20, message = "El teléfono no puede exceder los 20 caracteres")
    private String phone;

    @Schema(description = "Fecha de nacimiento del cliente", example = "1990-01-01")
    private LocalDate birthDate;

    @Schema(description = "Saldo inicial del cliente", example = "1000.00")
    private BigDecimal initialBalance;
}

// === ARCHIVO: src/main/java/com/pragma/financial/api/model/dto/ClientResponse.java ===
package com.pragma.financial.api.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Data
@Builder
@Schema(description = "DTO para la respuesta de clientes")
public class ClientResponse {
    @Schema(description = "Identificador único del cliente", example = "123e4567-e89b-12d3-a456-426614174000")
    private UUID id;

    @Schema(description = "Nombre completo del cliente", example = "Juan Pérez")
    private String name;

    @Schema(description = "Correo electrónico del cliente", example = "juan.perez@example.com")
    private String email;

    @Schema(description = "Número de teléfono del cliente", example = "5551234567")
    private String phone;

    @Schema(description = "Fecha de nacimiento del cliente", example = "1990-01-01")
    private LocalDate birthDate;

    @Schema(description = "Saldo actual del cliente", example = "1500.00")
    private BigDecimal balance;

    @Schema(description = "Fecha de registro del cliente", example = "2023-01-01")
    private LocalDate registrationDate;
}

// === ARCHIVO: src/main/java/com/pragma/financial/api/model/entity/Client.java ===
package com.pragma.financial.api.model.entity;

import com.pragma.financial.api.model.dto.ClientRequest;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "clients")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @NotBlank
    @Size(max = 100)
    private String name;

    @NotBlank
    @Email
    @Size(max = 100)
    private String email;

    @NotBlank
    @Size(max = 15)
    private String phone;

    @NotNull
    private LocalDate birthDate;

    @NotNull
    @DecimalMin("0.00")
    private BigDecimal initialBalance;

    @NotNull
    private LocalDate registrationDate;

    public Client() {}

    public Client(ClientRequest request) {
        this.name = request.getName();
        this.email = request.getEmail();
        this.phone = request.getPhone();
        this.birthDate = request.getBirthDate();
        this.initialBalance = request.getInitialBalance();
        this.registrationDate = LocalDate.now();
    }

    // Getters and setters
    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    public LocalDate getBirthDate() { return birthDate; }
    public void setBirthDate(LocalDate birthDate) { this.birthDate = birthDate; }
    public BigDecimal getInitialBalance() { return initialBalance; }
    public void setInitialBalance(BigDecimal initialBalance) { this.initialBalance = initialBalance; }
    public LocalDate getRegistrationDate() { return registrationDate; }
    public void setRegistrationDate(LocalDate registrationDate) { this.registrationDate = registrationDate; }
}

// === ARCHIVO: src/main/java/com/pragma/financial/api/config/OpenApiConfig.java ===
package com.pragma.financial.api.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
               .info(new Info()
                       .title("Financial API")
                       .description("API REST para gestión de clientes financieros")
                       .version("1.0"));
    }

    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
               .group("public-api")
               .pathsToMatch("/clients/**")
               .build();
    }
}

// === ARCHIVO: src/main/java/com/pragma/financial/api/controller/ClientController.java ===
package com.pragma.financial.api.controller;


import com.pragma.financial.api.model.entity.Client;
import com.pragma.financial.api.model.dto.ClientRequest;
import com.pragma.financial.api.model.dto.ClientResponse;
import com.pragma.financial.api.service.ClientService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/clients")
@Tag(name = "Clients", description = "API for managing clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @PostMapping
    @Operation(summary = "Create a new client")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Client created successfully", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ClientResponse.class))),
        @ApiResponse(responseCode = "400", description = "Invalid input")
    })
    public ResponseEntity<ClientResponse> createClient(@Valid @RequestBody ClientRequest request) {
        ClientResponse response = clientService.createClient(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping
    @Operation(summary = "Get all clients")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "List of clients", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ClientResponse.class, type = "array"))),
        @ApiResponse(responseCode = "404", description = "No clients found")
    })
    public ResponseEntity<List<ClientResponse>> getAllClients() {
        List<ClientResponse> clients = clientService.getAllClients();
        return new ResponseEntity<>(clients, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get client by ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Client found", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ClientResponse.class))),
        @ApiResponse(responseCode = "404", description = "Client not found")
    })
    public ResponseEntity<ClientResponse> getClientById(@PathVariable UUID id) {
        ClientResponse client = clientService.getClientById(id);
        return new ResponseEntity<>(client, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update client by ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Client updated successfully", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ClientResponse.class))),
        @ApiResponse(responseCode = "400", description = "Invalid input"),
        @ApiResponse(responseCode = "404", description = "Client not found")
    })
    public ResponseEntity<ClientResponse> updateClient(@PathVariable UUID id, @Valid @RequestBody ClientRequest request) {
        ClientResponse client = clientService.updateClient(id, request);
        return new ResponseEntity<>(client, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete client by ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "204", description = "Client deleted successfully"),
        @ApiResponse(responseCode = "404", description = "Client not found")
    })
    public ResponseEntity<Void> deleteClient(@PathVariable UUID id) {
        clientService.deleteClient(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

// === ARCHIVO: src/main/java/com/pragma/financial/api/service/ClientService.java ===
package com.pragma.financial.api.service;

import com.pragma.financial.api.model.dto.ClientRequest;
import com.pragma.financial.api.model.dto.ClientResponse;
import java.util.List;
import java.util.UUID;

public interface ClientService {
    ClientResponse createClient(ClientRequest clientRequest);
    ClientResponse getClientById(UUID clientId);
    List<ClientResponse> getAllClients();
    ClientResponse updateClient(UUID clientId, ClientRequest clientRequest);
    void deleteClient(UUID clientId);
}

// === ARCHIVO: src/main/java/com/pragma/financial/api/service/ClientServiceImpl.java ===
package com.pragma.financial.api.service;

import com.pragma.financial.api.model.dto.ClientRequest;
import com.pragma.financial.api.model.dto.ClientResponse;
import com.pragma.financial.api.repository.ClientRepository;
import com.pragma.financial.api.model.entity.Client;
import com.pragma.financial.api.exception.ResourceNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public ClientResponse createClient(ClientRequest clientRequest) {
        Client client = new Client();
        BeanUtils.copyProperties(clientRequest, client);
        client.setRegistrationDate(java.time.LocalDate.now());
        client = clientRepository.save(client);
        return convertToClientResponse(client);
    }

    @Override
    public ClientResponse getClientById(UUID clientId) {
        Client client = clientRepository.findById(clientId)
               .orElseThrow(() -> new ResourceNotFoundException("Client not found with id " + clientId));
        return convertToClientResponse(client);
    }

    @Override
    public List<ClientResponse> getAllClients() {
        List<Client> clients = clientRepository.findAll();
        return clients.stream().map(this::convertToClientResponse).collect(Collectors.toList());
    }

    @Override
    public ClientResponse updateClient(UUID clientId, ClientRequest clientRequest) {
        Client client = clientRepository.findById(clientId)
               .orElseThrow(() -> new ResourceNotFoundException("Client not found with id " + clientId));
        BeanUtils.copyProperties(clientRequest, client, "id", "registrationDate");
        client = clientRepository.save(client);
        return convertToClientResponse(client);
    }

    @Override
    public void deleteClient(UUID clientId) {
        Client client = clientRepository.findById(clientId)
               .orElseThrow(() -> new ResourceNotFoundException("Client not found with id " + clientId));
        clientRepository.delete(client);
    }

    private ClientResponse convertToClientResponse(Client client) {
        ClientResponse clientResponse = new ClientResponse();
        BeanUtils.copyProperties(client, clientResponse);
        return clientResponse;
    }
}

// === ARCHIVO: src/main/java/com/pragma/financial/api/exception/GlobalExceptionHandler.java ===
package com.pragma.financial.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<String> handleResourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGlobalException(Exception ex, WebRequest request) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

// === ARCHIVO: src/main/java/com/pragma/financial/api/exception/ResourceNotFoundException.java ===
package com.pragma.financial.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    private final String resourceName;
    private final String fieldName;
    private final Object fieldValue;

    public ResourceNotFoundException(String resourceName, String fieldName, Object fieldValue) {
        super(String.format("%s not found with %s : '%s'", resourceName, fieldName, fieldValue));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }

    public String getResourceName() {
        return resourceName;
    }

    public String getFieldName() {
        return fieldName;
    }

    public Object getFieldValue() {
        return fieldValue;
    }
}

// === ARCHIVO: src/test/java/com/pragma/financial/api/controller/ClientControllerTest.java ===
package com.pragma.financial.api.controller;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.pragma.financial.api.service.ClientService;
import com.pragma.financial.api.model.dto.ClientResponse;

@WebMvcTest(ClientController.class)
class ClientControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ClientService clientService;

    @InjectMocks
    private ClientController clientController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetClientById() throws Exception {
        ClientResponse clientResponse = new ClientResponse();
        clientResponse.setId(UUID.randomUUID());
        clientResponse.setName("John Doe");
        clientResponse.setEmail("john.doe@example.com");
        clientResponse.setPhone("1234567890");
        clientResponse.setBirthDate(LocalDate.of(1990, 1, 1));
        clientResponse.setBalance(BigDecimal.valueOf(1000));
        clientResponse.setRegistrationDate(LocalDate.now());

        when(clientService.getClientById(clientResponse.getId())).thenReturn(clientResponse);

        mockMvc.perform(get("/api/clients/" + clientResponse.getId()))
               .andExpect(status().isOk())
               .andExpect(content().string(containsString(clientResponse.getName())));
    }
}

// === ARCHIVO: src/test/java/com/pragma/financial/api/service/ClientServiceTest.java ===
package com.pragma.financial.api.service;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.pragma.financial.api.repository.ClientRepository;
import com.pragma.financial.api.model.dto.ClientRequest;
import com.pragma.financial.api.model.dto.ClientResponse;
import com.pragma.financial.api.model.entity.Client;

@SpringBootTest
class ClientServiceTest {
    @Mock
    private ClientRepository clientRepository;

    @InjectMocks
    private ClientServiceImpl clientService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateClient() {
        ClientRequest clientRequest = new ClientRequest();
        clientRequest.setName("John Doe");
        clientRequest.setEmail("john.doe@example.com");
        clientRequest.setPhone("1234567890");
        clientRequest.setBirthDate(LocalDate.of(1990, 1, 1));
        clientRequest.setInitialBalance(BigDecimal.valueOf(1000));

        Client client = new Client();
        client.setName(clientRequest.getName());
        client.setEmail(clientRequest.getEmail());
        client.setPhone(clientRequest.getPhone());
        client.setBirthDate(clientRequest.getBirthDate());
        client.setBalance(clientRequest.getInitialBalance());
        client.setRegistrationDate(LocalDate.now());

        when(clientRepository.save(client)).thenReturn(client);

        ClientResponse clientResponse = clientService.createClient(clientRequest);

        verify(clientRepository).save(client);

        assert clientResponse!= null;
        assert clientResponse.getName().equals(clientRequest.getName());
        assert clientResponse.getEmail().equals(clientRequest.getEmail());
    }
}
```
