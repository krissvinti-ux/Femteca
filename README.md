# FEMTECA 📚✨ — Java 21 + PostgreSQL (MVC + Repository) | Terminal CRUD

**Femteca** es una aplicación de consola desarrollada en **Java 21** que permite a una biblioteca de barrio modernizar su inventario.  
La administradora puede **crear, leer, actualizar, eliminar** libros y realizar **búsquedas por título, autor y género**, con persistencia en **PostgreSQL**.

---

## 🗃 Contexto del proyecto

> La biblioteca de nuestro barrio se quiere modernizar y necesita tener todos sus libros organizados en un programa. Tener un inventario actualizado le facilitará la gestión. La administradora necesita añadir libros, actualizarlos, borrarlos, verlos y buscarlos por ciertos atributos.

---

## ✅ Requisitos funcionales

- Ver una lista de **todos los libros** en la base de datos.
- **Añadir** un libro.
- **Editar** un libro.
- **Eliminar** un libro.
- Buscar un libro por **título**.
- Buscar libros por **autor**.
- Buscar libros por **género literario**.

---

## 🧩 Requisitos no funcionales

- Un libro debe tener mínimo:
  - **Título**
  - **Autor**
  - **Descripción** (máx. 200 caracteres)
  - **ISBN**
  - **Género literario**
- En el listado general se muestran todos los campos **excepto la descripción**.
- En la búsqueda por título o autor se muestran **todos los campos**.
- En la búsqueda por género se muestran todos los campos **excepto la descripción**.
- Base de datos **normalizada**.
- Arquitectura **MVC**.
- Patrón **Repository** para acceso a datos.

---

## 💻 Tecnologías

- Java 21
- PostgreSQL
- Maven
- JDBC

---

## 🛠 Herramientas

- Visual Studio Code
- Trello / Jira
- Git / GitHub

---

## 🧱 Arquitectura del proyecto (MVC + Repository)

- **View** (`com.femteca.view`)
  - Interfaz por terminal: menús, inputs y outputs.
- **Controller** (`com.femteca.controller`)
  - Coordina la lógica de flujo entre Vista y Repositorios.
- **Model** (`com.femteca.model`)
  - Entidades: `Book`, `Author`, `Genre`.
- **Repository** (`com.femteca.repository`)
  - Interfaces + implementaciones JDBC para PostgreSQL.
- **Config** (`com.femteca.config`)
  - Conexión a BD (ej. `DBManager`) leyendo variables desde `.env`.

---

## 🗂 Estructura de carpetas (real)

```txt
src/
└─ main/
   └─ java/
      └─ com/
         └─ femteca/
            ├─ config/
            │  └─ DBManager.java
            ├─ controller/
            │  ├─ AuthorController.java
            │  ├─ BookController.java
            │  └─ GenreController.java
            ├─ model/
            │  ├─ Author.java
            │  ├─ Book.java
            │  ├─ Genre.java
            │  └─ Colors.java
            ├─ repository/
            │  ├─ AuthorRepository.java
            │  ├─ AuthorRepositoryImpl.java
            │  ├─ BookRepository.java
            │  ├─ BookRepositoryImpl.java
            │  ├─ GenreRepository.java
            │  └─ GenreRepositoryImpl.java
            ├─ view/
            │  └─ BookView.java
            └─ App.java

## ⚙️ Configuración

### Variables de entorno (.env)
Este proyecto utiliza `dotenv-java` para cargar las credenciales de la base de datos desde un archivo `.env`.

1. Crea un archivo llamado `.env` en la **raíz del proyecto**.
2. Añade tus datos de conexión:

```env
DB_URL=jdbc:postgresql://localhost:5432/femteca
DB_USER=postgres
DB_PASSWORD=tu_password

🗄 Base de datos (PostgreSQL)

Crea una base de datos llamada femteca.

Crea las tablas necesarias para books, authors y genres (según el modelo del proyecto).

(Opcional) Inserta datos iniciales para poder probar el CRUD desde el primer momento.

▶️ Cómo ejecutar el proyecto
Opción A — VS Code

Abre src/main/java/com/femteca/App.java

Ejecuta el método main() con Run.

Opción B — Maven

Compila el proyecto con Maven y ejecútalo desde terminal (recomendado si trabajas fuera del IDE).

mvn clean compile


Nota: si deseas ejecutar el main directamente con Maven, puedes configurar un plugin de ejecución en el pom.xml.

👥 Equipo

Product Owner: Maria-Eva Martin

Scrum Master: Manon Godfroy

Developers: Maria-Eva Martin, Manon Godfroy, Cristina Viejó, Maria José Ozta