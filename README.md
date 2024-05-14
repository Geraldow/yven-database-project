# yven-database-project

CREATE DATABASE IF NOT EXISTS yven_crud_project;

SELECT yven_crud_project;

DROP TABLE IF EXISTS persona;
CREATE TABLE persona (
	tipoDocumento VARCHAR(50) NOT NULL,
    numeroDocumento INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    primerApellido VARCHAR(50) NOT NULL,
    segundoApellido VARCHAR(50) NOT NULL,
    nombres VARCHAR(50) NOT NULL,
    fechaNacimiento DATE NOT NULL,
    sexo VARCHAR(1) NOT NULL,
    estadoCivil VARCHAR(1) NOT NULL,
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
    fechaEvento DATE NOT NULL,
    horaInicio DATE NOT NULL,
    horaFinalizacion DATE NOT NULL,
    capacidadEvento INT NOT NULL,
    estadoEvento BIT NOT NULL,
    precioEntrada REAL NOT NULL,
    catering VARCHAR(50) NOT NULL,
    presupuesto REAL NOT NULL,
    organizadorId INT NOT NULL,
    FOREIGN KEY (organizadorId) REFERENCES proveedor (idProveedor)
);

DROP TABLE IF EXISTS tarjeta;
CREATE TABLE tarjeta (
	idTarjeta INT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
    tipoTarjeta VARCHAR(50) NOT NULL,
    nombreTarjeta VARCHAR(50) NOT NULL,
    numeroTarjeta INT NOT NULL,
    tiempoExpiracion DATE NOT NULL,
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
    importe DATE NOT NULL, 
    tarjetaId INT NOT NULL,
    FOREIGN KEY (tarjetaId) REFERENCES tarjeta (idTarjeta)
);

DROP TABLE IF EXISTS detalles_pago;
CREATE TABLE detalles_pago (
	idDetallesPago INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    tipoTransaccion VARCHAR(50) NOT NULL,
    fechaTransaccion DATE NOT NULL,
    estadoTransaccion BIT NOT NULL,
    descripcionTransaccion VARCHAR(50) NOT NULL,
    fechaCreacion DATE NOT NULL,
    fechaModificacion DATE NOT NULL,
    metodoPagoId INT NOT NULL,
    FOREIGN KEY (metodoPagoId) REFERENCES metodo_pago (idMetodoPago)
);

