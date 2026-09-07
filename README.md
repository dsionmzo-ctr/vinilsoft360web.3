# Vinilsoft360

Sistema de gestión de pisos vinílicos desarrollado como evidencia de aprendizaje
para el programa de Análisis y Desarrollo de Software - SENA.

**Autor:** Dayson Mazo Villa

## Descripción

Vinilsoft360 es una aplicación web que permite administrar clientes y productos
(pisos vinílicos) de una empresa, incluyendo autenticación de usuarios,
gestión de sesiones y operaciones CRUD completas sobre ambos módulos.

## Tecnologías y frameworks utilizados

| Capa              | Tecnología / Librería           |
|-------------------|----------------------------------|
| Lenguaje          | Java 17                         |
| Servidor web      | Apache Tomcat 10.1               |
| Especificación    | Jakarta Servlet API 6.0 / JSP 3.1|
| Base de datos     | MySQL 8                         |
| Driver JDBC       | MySQL Connector/J 8.3.0          |
| Serialización JSON| Gson 2.13.1                      |
| Pruebas unitarias | JUnit 5 (Jupiter) 5.10.2          |
| Gestor de proyecto| Apache Maven                     |
| IDE               | Visual Studio Code               |
| Control de versiones | Git / GitHub                  |

## Arquitectura y capas

El proyecto sigue el patrón **MVC (Modelo - Vista - Controlador)** combinado
con el patrón **DAO (Data Access Object)** para el acceso a datos:

src/main/java/com/vinilsoft360/
├── model/ → Entidades del dominio (Cliente, Producto)
├── dao/ → Acceso a datos vía JDBC (ClienteDAO, ProductoDAO)
├── conexion/ → Conexión centralizada a la base de datos (Conexion)
├── servlet/ → Controladores (LoginServlet, LogoutServlet, ClienteServlet, ProductoServlet)
└── api/ → Endpoints que exponen datos en formato JSON (ClienteAPI, ProductoAPI)

src/main/webapp/
├── login.jsp, index.jsp, menu.jsp, footer.jsp
├── listarClientes.jsp, registrarCliente.jsp, editarCliente.jsp
├── listarProductos.jsp, registrarProducto.jsp, editarProducto.jsp
└── css/estilos.css

- **Modelo:** clases `Cliente` y `Producto`, representan las entidades de negocio.
- **DAO:** encapsulan las consultas SQL (INSERT, SELECT, UPDATE, DELETE).
- **Controladores (Servlets):** reciben las peticiones HTTP, invocan al DAO
  correspondiente y redirigen a la vista adecuada.
- **Vistas (JSP):** muestran la información y capturan los datos del usuario.

## Patrones de diseño aplicados

- **MVC:** separación entre modelo (entidades), vista (JSP) y controlador (Servlets).
- **DAO:** aísla la lógica de acceso a datos de la lógica de negocio, permitiendo
  cambiar el motor de base de datos sin afectar el resto de la aplicación.
- **Singleton implícito de conexión:** la clase `Conexion` centraliza la creación
  de conexiones JDBC en un único punto de acceso.

## Mecanismos de seguridad

- Autenticación mediante formulario de login (`LoginServlet`).
- Gestión de sesión con `HttpSession`: cada usuario autenticado recibe una sesión
  que almacena su nombre de usuario.
- Protección de rutas: las páginas internas (`index.jsp`) validan la existencia
  de sesión activa al inicio de cada página; si no existe, redirigen al login.
- Cierre de sesión seguro mediante `LogoutServlet`, que invalida la sesión HTTP.

## Mapa de navegación

login.jsp
│
├── (credenciales correctas) → index.jsp
│ ├── listarClientes.jsp
│ │ ├── registrarCliente.jsp
│ │ └── editarCliente.jsp
│ ├── listarProductos.jsp
│ │ ├── registrarProducto.jsp
│ │ └── editarProducto.jsp
│ └── LogoutServlet → login.jsp
│
└── (credenciales incorrectas) → login.jsp (mensaje de error)

## Requisitos previos

- JDK 17
- Apache Maven
- Apache Tomcat 10.1+
- MySQL 8 con la base de datos `vinilsoft360` creada

## Instalación y ejecución

1. Clonar el repositorio:

git clone https://github.com/dsonmzo-ctr/vinilsoft360web.3.git

2. Configurar la conexión a la base de datos en
   `src/main/java/com/vinilsoft360/conexion/Conexion.java` (usuario, contraseña,
   nombre de la base de datos).
3. Compilar el proyecto y ejecutar las pruebas unitarias:

4. Copiar el archivo generado `target/vinilsoft360web.war` a la carpeta
   `webapps` de Apache Tomcat.
5. Iniciar Tomcat (`startup.bat` / `startup.sh`).
6. Acceder a la aplicación en:

http://localhost:8080/vinilsoft360web/login.jsp

## Pruebas unitarias

El proyecto incluye pruebas JUnit 5 para las clases `ClienteDAO` y `ProductoDAO`,
ubicadas en `src/test/java/com/vinilsoft360/dao/`. Validan las operaciones de
inserción, consulta, actualización y eliminación contra la base de datos real.

Para ejecutarlas:
mvn test

## Ambiente de desarrollo

- **Sistema operativo:** Windows 11
- **IDE:** Visual Studio Code con extensiones Java Extension Pack y Tomcat for Java
- **Servidor:** Apache Tomcat 10.1.57, puerto 8080
- **Base de datos:** MySQL 8, gestionada con MySQL Workbench

## Ambiente de pruebas

Las pruebas unitarias se ejecutan contra la misma base de datos de desarrollo
(`vinilsoft360`), insertando y eliminando registros de prueba identificados con
el nombre "Cliente Prueba JUnit" / "Piso Prueba JUnit" para no afectar los
datos reales del sistema.