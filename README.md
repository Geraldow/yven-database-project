# Yven Project

## Introducción
Dedicado a crear experiencias inolvidables, únicas y significativas a través eventos especiales brindando a los usuarios la facilidad de organizar su propio evento de forma eficaz y eficiente.


## Instalación
### Para descargar el código fuente de Yven, sigue estos pasos:
1. Abre una terminal o línea de comandos en tu sistema.
2. Ubicarse en el escritorio.
3. Crear una carpeta llamada Proyecto.
4. Entrar a la carpeta recientemente creada.
5. Clonar el repositorio del proyecto.
6. Crear una carpeta para la aplicación web.
   
```sh
cd %USERPROFILE%\Desktop || cd %USERPROFILE%\OneDrive\Desktop
mkdir ispw_project
cd ispw_project
git clone https://github.com/Geraldow/yven-database-project
cd yven-database-project
```


## Flujo de trabajo
### Para enviar actualizaciones y creaciones de archivos al repositorio remoto, deben seguir estos pasos:
1. Ejecutar cmd en la barra de navegación desde la carpeta del proyecto.
2. Configurar su nombre y correo electrónico de Git de manera global o no para los registros de auditoría.
4. Ubicarse en la rama 'develop'.
6. Las nuevas ramas serán creadas desde 'develop' dependiendo de las asignaciones de cada desarrollador.
7. Crear archivos para el proyecto.
8. Visualizar los archivos disponibles.
9. Seleccionar las funcionalidades aptas.
10. Comentar los archivos elegidos.
11. Enviar los archivos al repositorio remoto.
12. Visualizar los cambios recientes desde el GitHub.

### Ejemplo

```sh
git config --global user.name "<nombre>"
git config --global user.email "<correo_electrónico>"
git checkout develop
git status
git add index.html
git commit
git push
git log -n 10
```

## Librerías y Frameworks aplicados
Spring Framework
  - Spring Boot Starter Data JPA
  - Spring Boot Starter Thymeleaf
  - Spring Boot Starter Web
  - Spring Boot DevTools
    
MySQL Connector/J

Project Lombok

Spring Boot Starter Test

## Comandos para creación de base de datos - MySQL

CREATE DATABASE IF NOT EXISTS yven_crud_project;


USE yven_crud_project;


DROP TABLE IF EXISTS persona;


CREATE TABLE persona (

    numeroDocumento INT NOT NULL PRIMARY KEY,
    
	tipoDocumento VARCHAR(50) NOT NULL,
 
    primerApellido VARCHAR(50) NOT NULL,
    
    segundoApellido VARCHAR(50) NOT NULL,
    
    nombres VARCHAR(50) NOT NULL,
    
    fechaNacimiento VARCHAR(50) NOT NULL,
    
    sexo VARCHAR(50) NOT NULL,
    
    estadoCivil VARCHAR(50) NOT NULL,
    
    ubigeo INT NOT NULL
    
);


DROP TABLE IF EXISTS usuario;


CREATE TABLE usuario (

	idUsuario INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
 
    nombreUsuario VARCHAR(50) NOT NULL,
    
    correoElectronico VARCHAR(50) NOT NULL,
    
    contrasena VARCHAR(50) NOT NULL,
    
    telefono INT NOT NULL,
    
    estado BIT NOT NULL,
    
    fechaCreacion TIMESTAMP,
    
    fechaModificacion DATETIME NOT NULL,
    
    fechaEliminacion DATETIME NOT NULL    
    
);


DROP TABLE IF EXISTS cliente;


CREATE TABLE cliente (

	idCliente INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
 
    usuarioId INT NOT NULL,
    
    personaId INT NOT NULL,
    
    FOREIGN KEY (usuarioId) REFERENCES usuario (idUsuario),
    
    FOREIGN KEY (personaId) REFERENCES persona (numeroDocumento)
    
);


DROP TABLE IF EXISTS empresa;


CREATE TABLE empresa (

	idEmpresa INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
 
    nombreEmpresa VARCHAR(50) NOT NULL,
    
    correoEmpresa VARCHAR(50) NOT NULL,
    
    telefonoEmpresa INT NOT NULL,
    
    paginaWebEmpresa VARCHAR(50) NOT NULL,
    
    descripcionEmpresa VARCHAR(50) NOT NULL,
    
    industria VARCHAR(50) NOT NULL,
    
    fechaFundacion DATE NOT NULL
    
);



DROP TABLE IF EXISTS proveedor;
CREATE TABLE proveedor (

	idProveedor INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
 
    usuarioProveedorId INT NOT NULL,
    
    personaProveedorId INT NOT NULL,
    
    empresaProveedorId INT NOT NULL,    
    
    FOREIGN KEY (usuarioProveedorId) REFERENCES usuario (idUsuario),
    
    FOREIGN KEY (personaProveedorId) REFERENCES persona (numeroDocumento),
    
    FOREIGN KEY (empresaProveedorId) REFERENCES empresa (idEmpresa)    
    
);


DROP TABLE IF EXISTS evento;


CREATE TABLE evento (

	idEvento INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
 
    tituloEvento VARCHAR(50) NOT NULL,
    
    descripcionEvento VARCHAR(50) NOT NULL,
    
    ubicacionEvento VARCHAR(50) NOT NULL,
    
    tipoEvento VARCHAR(50) NOT NULL,
    
    fechaEvento VARCHAR(50) NOT NULL,
    
    horaInicio VARCHAR(50) NOT NULL,
    
    horaFinalizacion VARCHAR(50) NOT NULL,
    
    capacidadEvento INT NOT NULL,
    
    estadoEvento BIT NOT NULL,
    
    precioEntrada REAL NOT NULL,
    
    catering VARCHAR(50) NOT NULL,
    
    presupuesto REAL NOT NULL
    
);



DROP TABLE IF EXISTS tarjeta;
CREATE TABLE tarjeta (

	idTarjeta INT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
 
    tipoTarjeta VARCHAR(50) NOT NULL,
    
    nombreTarjeta VARCHAR(50) NOT NULL,
    
    numeroTarjeta INT NOT NULL,
    
    tiempoExpiracion VARCHAR(50) NOT NULL,
    
    codigoSeguridad INT NOT NULL,
    
    cvc INT NOT NULL,
    
    cvv INT NOT NULL,
    
    direccion VARCHAR(50) NOT NULL,
    
    ciudad VARCHAR(50) NOT NULL
    
);


DROP TABLE IF EXISTS metodo_pago;
CREATE TABLE metodo_pago (

	idMetodoPago INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
 
    nombreMetodoPago VARCHAR(50) NOT NULL,
    
    tipoMetodoPago VARCHAR(50) NOT NULL,
    
    cuentaDestino INT NOT NULL,
    
    importe VARCHAR(50)  NOT NULL, 
    
    tarjetaId INT NOT NULL,
    
    FOREIGN KEY (tarjetaId) REFERENCES tarjeta (idTarjeta)
    
);


DROP TABLE IF EXISTS detalles_pago;


CREATE TABLE detalles_pago (

	idDetallesPago INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
 
    tipoTransaccion VARCHAR(50) NOT NULL,
    
    fechaTransaccion VARCHAR(50) NOT NULL,
    
    estadoTransaccion BIT NOT NULL,
    
    descripcionTransaccion VARCHAR(50) NOT NULL,
    
    fechaCreacion VARCHAR(50) NOT NULL,
    
    fechaModificacion VARCHAR(50) NOT NULL,
    
    metodoPagoId INT NOT NULL,
    
    FOREIGN KEY (metodoPagoId) REFERENCES metodo_pago (idMetodoPago)
    
);



## Equipo 
- Geraldo Jaramillo Florida [71992956@certus.edu.pe]
- Dayne Fiorella Ruiz Fernandez [73987271@certus.edu.pe]
- Alessandro Miguel Arias Marquina [76287712@certus.edu.pe]

