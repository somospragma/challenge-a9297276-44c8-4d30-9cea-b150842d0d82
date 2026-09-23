# Desarrollo de una API REST con persistencia en H2 y documentación con Swagger

El equipo de desarrollo de una plataforma financiera necesita implementar una API REST para gestionar información de clientes. La API debe permitir la creación, lectura, actualización y eliminación de registros de clientes. Los datos se persistirán en una base de datos H2 y se documentará utilizando Swagger para facilitar la comprensión y uso por parte de los desarrolladores.

## Informacion General

| Campo | Valor |
|-------|-------|
| **Tema** | Creación de API REST |
| **Nivel** | junior-l1 |
| **Tipo** | practical |
| **Tiempo estimado** | 8 horas |

## Fases del Reto

### Fase 0: Configuración del Proyecto

**Objetivo:** Obtener el proyecto base funcional enviando el Código Base a un asistente de IA, que lo analizará, corregirá errores y generará un ZIP listo para usar.

**Tiempo estimado:** 15-30 minutos

**Instrucciones:**

- Asegúrate de tener instalado para ejecutar el proyecto: JDK 17+, Maven 3.9+, IDE con soporte Java.
- Copia todo el contenido del campo **Código Base** de este reto — incluyendo el texto de instrucciones que aparece al inicio.
- Abre un asistente de IA (Claude en claude.ai, ChatGPT o Gemini — se recomienda Claude), pega el contenido copiado en el chat y envíalo.
- El asistente analizará los archivos, corregirá errores y generará un archivo ZIP descargable. Descárgalo y extráelo en la carpeta donde quieras trabajar.
- Ejecuta `mvn compile` en la raíz. Si no hay errores, estás listo.

**Entregable:** El proyecto compila/arranca sin errores.

<details>
<summary>Pistas de conocimiento</summary>

- Copia el Código Base completo incluyendo el texto de instrucciones al inicio — esas instrucciones le indican al asistente exactamente qué hacer con los archivos.
- Si el asistente no genera el ZIP automáticamente al terminar el análisis, escríbele: "genera el ZIP ahora".
- Si el proyecto tiene errores al arrancar, comparte el mensaje de error con el mismo asistente para que lo corrija.

</details>

### Fase 1: Definición del modelo de datos

**Objetivo:** Crear el modelo de datos para los clientes, incluyendo atributos necesarios como nombre, email y fecha de registro.

**Tiempo estimado:** 2 horas

**Instrucciones:**

- Identificar los atributos necesarios para un cliente.
- Definir el modelo de datos utilizando el dominio de la banca.
- Establecer restricciones y validaciones para los atributos (ej. email válido, nombre no vacío).

**Entregable:** Modelo de datos definido y validado.

<details>
<summary>Pistas de conocimiento</summary>

- Considera los requerimientos del dominio para los datos de un cliente.
- Piensa en posibles validaciones y restricciones necesarias.

</details>

### Fase 2: Implementación de la API REST

**Objetivo:** Crear los endpoints para la API REST que permitan la creación, lectura, actualización y eliminación de registros de clientes.

**Tiempo estimado:** 3 horas

**Instrucciones:**

- Implementar los endpoints utilizando el dominio de la banca.
- Asegurar que los endpoints sigan los estándares REST.
- Manejar posibles errores y excepciones de manera adecuada.

**Entregable:** API REST implementada con los endpoints necesarios.

<details>
<summary>Pistas de conocimiento</summary>

- Recuerda los principios del diseño RESTful.
- Considera cómo manejar errores y excepciones en el contexto del dominio.

</details>

### Fase 3: Persistencia de datos en H2

**Objetivo:** Configurar la persistencia de los datos de los clientes en una base de datos H2.

**Tiempo estimado:** 2 horas

**Instrucciones:**

- Configurar la conexión a la base de datos H2.
- Persistir los datos de los clientes en la base de datos.
- Asegurar que los datos se guarden y recuperen correctamente.

**Entregable:** Configuración y persistencia de datos en H2.

<details>
<summary>Pistas de conocimiento</summary>

- Revisa la configuración necesaria para conectarse a una base de datos H2.
- Prueba la persistencia y recuperación de datos para asegurar su correcto funcionamiento.

</details>

### Fase 4: Documentación con Swagger

**Objetivo:** Documentar la API REST utilizando Swagger para facilitar su comprensión y uso.

**Tiempo estimado:** 1 hora

**Instrucciones:**

- Configurar Swagger para documentar la API REST.
- Asegurar que la documentación incluya todos los endpoints y sus descripciones.
- Probar la documentación para asegurar su correcto funcionamiento.

**Entregable:** Documentación de la API REST utilizando Swagger.

<details>
<summary>Pistas de conocimiento</summary>

- Revisa la configuración necesaria para integrar Swagger con tu proyecto.
- Asegúrate de que la documentación sea clara y completa.

</details>

## Dimensiones Evaluadas

- **queEs**: ¿Qué es un modelo de datos y por qué es importante en el desarrollo de una API REST?
- **paraQueSirve**: ¿Para qué sirven los endpoints en una API REST y cómo deben ser diseñados?
- **comoSeUsa**: ¿Cómo se configura la persistencia de datos en una base de datos H2 y cómo se asegura su correcto funcionamiento?
- **erroresComunes**: ¿Cuáles son los errores comunes al implementar una API REST y cómo se pueden evitar?
- **queDecisionesImplica**: ¿Qué decisiones implica el diseño y la implementación de una API REST en el contexto del dominio de la banca?

## Criterios de Evaluacion

- Definición clara y completa del modelo de datos para los clientes.
- Implementación correcta de los endpoints siguiendo los estándares REST.
- Configuración y persistencia de datos en una base de datos H2.
- Documentación clara y completa de la API REST utilizando Swagger.

## Como trabajar con un asistente de IA

Hay dos caminos, elegi uno:

- **AGENTS.md** (recomendado) — instrucciones nativas del repo. Abri esta carpeta con tu agente local (Claude Code, Cursor, Codex, Copilot, Gemini) y las carga solo. Sabe que archivos faltan y con que comando se verifica, y completa el scaffold escribiendo en disco.
- **PROMPT_MEJORA.md** — para copiar y pegar en un chat (claude.ai, ChatGPT). Devuelve un ZIP con el proyecto. Sirve si no tenes un agente en el IDE.

Ninguno de los dos resuelve las fases del reto: eso es tu trabajo.

## Verificacion

El proyecto esta listo para trabajar cuando este comando corre sin errores:

```bash
mvn clean compile
```

---

*Reto generado automaticamente por Challenge Generator - Pragma*
