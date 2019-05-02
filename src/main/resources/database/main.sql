
create user 'proface.api'@'localhost' IDENTIFIED BY 'proface';
GRANT ALL PRIVILEGES ON *.* TO 'proface.api'@'localhost';

-- Script de creacion de base de datos
CREATE TABLE app_role (
  role_id bigint(20) NOT NULL AUTO_INCREMENT,
  role_name varchar(255) DEFAULT NULL,
  description varchar(255) DEFAULT NULL,  
  PRIMARY KEY (role_id)
);


CREATE TABLE app_user (
  user_id bigint(20) NOT NULL AUTO_INCREMENT,
  first_name varchar(255) NOT NULL,
  last_name varchar(255) NOT NULL,
  password varchar(255) NOT NULL,
  username varchar(255) NOT NULL,
  email varchar(50) not null;
  PRIMARY KEY (user_id)
);

CREATE TABLE app_user_role (
  user_id bigint(20) NOT NULL,
  role_id bigint(20) NOT NULL,
  primary key(user_id, role_id),
  CONSTRAINT fk_user_role_user FOREIGN KEY (user_id) REFERENCES app_user (user_id),
  CONSTRAINT fk_user_role_role FOREIGN KEY (role_id) REFERENCES app_role (role_id)
);


-- Domain

CREATE TABLE tipo_proveedor(
	id_tipo_proveedor INT(1) not null,
	descripcion VARCHAR(25) not null,
    tipo_moneda VARCHAR(3) not null,
    primary key (id_tipo_proveedor)
);

CREATE TABLE proveedor (
	id_proveedor VARCHAR(4) not null,
    nombre VARCHAR(255) not null,
    id_tipo_proveedor INT(1) null,
    primary key (id_proveedor)
);

ALTER TABLE proveedor
	ADD FOREIGN KEY (id_tipo_proveedor)
    REFERENCES tipo_proveedor (id_tipo_proveedor)
    ON DELETE SET NULL
    ON UPDATE CASCADE;

CREATE TABLE contacto (
	id_contacto VARCHAR(4) not null,
    nombre VARCHAR(255) not null,
    apellido VARCHAR(255) not null,    
    telefono VARCHAR(20) not null,
    correo VARCHAR(100) not null,
    primary key (id_contacto)
);
    
ALTER TABLE contacto
	ADD FOREIGN KEY (id_contacto)
    REFERENCES proveedor (id_proveedor)
    ON DELETE CASCADE
    ON UPDATE CASCADE;

CREATE TABLE cuenta (
	nro_cuenta VARCHAR(100) not null,
    id_proveedor VARCHAR(4) not null,
    primary key (nro_cuenta)
);

ALTER TABLE cuenta
	ADD FOREIGN KEY (id_proveedor)
    REFERENCES proveedor (id_proveedor)
    ON DELETE CASCADE
    ON UPDATE CASCADE;

CREATE TABLE direccion (
	id_direccion  VARCHAR(4) not null,
    nombre_calle VARCHAR(300) not null,
    ciudad VARCHAR(100) not null,
    primary key (id_direccion)
);

ALTER TABLE direccion
	ADD FOREIGN KEY (id_direccion)
    REFERENCES proveedor (id_proveedor)
    ON DELETE CASCADE
    ON UPDATE CASCADE;

select * from app_role;
select * from app_user;
select * from app_user_role;

insert into app_role (role_id, role_name, description) 
values (1, 'ADMIN', 'Usuario administrador'),
(2, 'COMPRAS', 'Usuario de compras'), 
(3, 'VENTAS', 'Usuario de ventas'),
(4, 'ALMACEN', 'Usuario de almacen')

insert into app_user_role (user_id,role_id)
values (1, 1), (2, 1), (3, 1)


