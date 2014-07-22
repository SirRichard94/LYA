CREATE DATABASE SB_LYA;


USE SB_LYA;


CREATE TABLE AUTOR(
    autor_id int AUTO_INCREMENT,
    nombre varchar(42) not null,
    apellido varchar(42),
    alta varchar(5) not null default 'true',

    CONSTRAINT autor_pk 
    PRIMARY KEY(autor_id),
    CONSTRAINT autor_chk_alta CHECK (alta = 'true' or alta = 'false' )
);


CREATE TABLE EDITORIAL(
	editorial_id int AUTO_INCREMENT,
	nombre varchar(172) not null,
	direccion varchar(172),
	alta varchar(5) not null default 'true',
	
	CONSTRAINT editorial_pk 
	PRIMARY KEY (editorial_id),
	CONSTRAINT editorial_ck_alta CHECK (alta = 'true' or alta = 'false' )
);


CREATE TABLE AREA(
	area_id int AUTO_INCREMENT,
	nombre varchar(42) not null unique,
	alta varchar(5) not null default 'true',
	CONSTRAINT pk_area 
	PRIMARY KEY(area_id),
	CONSTRAINT ck_alta_area CHECK (alta = 'true' or alta = 'false' )
);



CREATE TABLE LIBRO(
    libro_id int AUTO_INCREMENT,
    ISBN bigint not null unique,
    nombre varchar(42) not null,
    area_id int,
    editorial_id int,
	paginas int,
    alta varchar(5) default 'true',

    CONSTRAINT pk_libro 
    PRIMARY KEY(libro_id),

    CONSTRAINT fk_editorial_libro
    FOREIGN KEY (editorial_id)
    REFERENCES EDITORIAL(editorial_id),

    CONSTRAINT fk_area_libro
    FOREIGN KEY (area_id)
    REFERENCES AREA(area_id),

    constraint chk_alta_libro check (alta = 'true' or alta = 'false' )
);


CREATE TABLE AUTOR_DE(
	autor_de_id int AUTO_INCREMENT,
	autor_id int ,
	libro_id int ,
	
	CONSTRAINT pk_autor_de 
	PRIMARY KEY(autor_de_id),
	
	CONSTRAINT fk_autor_autor_de
	FOREIGN KEY (autor_id)
	REFERENCES AUTOR(autor_id),
	
	CONSTRAINT fk_libro_autor_de
	FOREIGN KEY (libro_id)
	REFERENCES LIBRO(libro_id)
);



CREATE TABLE EJEMPLAR(
	ejemplar_id int AUTO_INCREMENT,
	localizacion varchar(172),
	libro_id int,
	
	CONSTRAINT pk_ejemplar
	PRIMARY KEY(ejemplar_id),
	
	CONSTRAINT fk_libro_ejemplar
	FOREIGN KEY(libro_id) 
	REFERENCES LIBRO(libro_id)
);


CREATE TABLE USUARIO(
	usuario_id int AUTO_INCREMENT,
	nombre varchar(172) not null,
	direccion varchar(172),
	telefono varchar(42),
	correo varchar(172) not null unique,
	deuda decimal not null,
	passwd VARCHAR(172) NOT NULL,
	alta varchar(5) not null default 'true',
	es_admi varchar(5) default 'false',

	CONSTRAINT pk_usuario
	PRIMARY KEY(usuario_id),

	CONSTRAINT ck_alta_usuario CHECK(alta='true' or alta='false'),
	CONSTRAINT ck_admi  CHECK(alta='true' or alta='false')
);

CREATE TABLE PRESTAMO(
	prestamo_id int AUTO_INCREMENT,
	ejemplar_id int not null unique,
	usuario_id int not null,
	fecha_salida date not null,
	fecha_entrega date not null,
	
	CONSTRAINT prestamo_pk
	PRIMARY KEY(prestamo_id),
	
	CONSTRAINT fk_ejemplar_prestamo
	FOREIGN KEY(ejemplar_id)
	REFERENCES EJEMPLAR(ejemplar_id),
	
	CONSTRAINT fk_usuario_prestamo
	FOREIGN KEY(usuario_id)
	REFERENCES USUARIO(usuario_id),

	CONSTRAINT chk_dates check (fecha_salida < fecha_entrega)
);


Create table PENALIZACION(
	penalizacion_id int AUTO_INCREMENT,
	limite_inferior int not null,
	limite_superior int,
	costo decimal not null,
	
	CONSTRAINT pk_penalizacion
	PRIMARY KEY(penalizacion_id)
);

insert  AUTOR(nombre, apellido)
VALUES ('Paulo','Cohelo'),
('Jk','Rowling'),
('Arthur','Conan'),
('J.R.R','Tolkien'),
('Julio','Verne');


insert EDITORIAL(nombre,direccion)
values ('Planeta','Av. Presidente Masarik #111, 2do. Piso Col. Chapultepec Morales'),
('Salamandra','Almogàvers, 56, 7º 2ª - 08018 Barcelona - Spain	'),
('Everest','Calzada Ermita Iztapalapa 1681, Barrio San Miguel, Distrito Federal'),
('Minotauro','Barcelona '),
('Terramar',' Avenida de Mayo 1110');

insert AREA(nombre)
values ('Ciencia Ficcion'),
('Fantasia'),
('Motivacional'),
('Misterio'),
('Informática');

insert LIBRO(nombre,ISBN,area_id,editorial_id, paginas)
values ('La quinta montaña',9788408070672, 3, 1, 300),
('El señor de los anillos',8488543070672, 2, 4, 650),
('Viaje al centro de la tierra',1535726546853, 1, 5, 200),
('Sherlock Holmes',4238554564455, 4, 3, 315),
('Harry Potter y la piedra filosofal',682364258745, 2, 2, 412);
			
insert AUTOR_DE(autor_id, libro_id)
values ( 1, 1),
( 2, 5),
( 3, 4),
( 4, 2),
( 5, 3);

insert EJEMPLAR(libro_id,localizacion)
VALUES(1,'Estante 5 fila C'),
(2,'Estante 6 fila H'),
(3,'Estante 7 fila F'),
(4,'Estante 3 fila C'),
(5,'Estante 1 fila C'),
(1,'Estante 5 fila C');

insert USUARIO(nombre, telefono, correo, passwd, direccion, deuda)
VALUES('Ricardo Rodriguez', '311-04-33', 'SirRichard94@gmail.com', 'ola','londres #115 Col Prados de cuernavaca', 0),
('Eliel Rodriguez', '368-61-19', 'elielorgz03@gmail.com','que','prohogar- emiliano zapata', 100),
('Julio Cesar', '7771554585', 'julio3110@gmail.com', 'ase','Copa de Oro', 0),
( 'Chuck Norris', '01-800-PAIN', 'yahoo@chucknorris.com', 'dolor','londres #115 Col Prados de cuernavaca', 80000000000),
( 'Araceli Jacobo', '01-800-INTEGRADORA', 'araceli_jacobo@utez.edu.mx', 'reprobados','Al lado del vecino', 0);

update USUARIO SET es_admi = 'true' where usuario_id = 1;
		
insert PRESTAMO (usuario_id, ejemplar_id, fecha_salida, fecha_entrega)
VALUES(1, 1, '2013-04-12', '2014-05-19'),
	(2, 2, '2014-07-01', '2014-07-09'),
	(3, 3, '2014-02-18', '2014-02-27'),
	(4, 4, '2014-10-31', '2014-11-07'),
	(5, 5, '2014-01-01', '2014-01-08');
		
select nombre from USUARIO;

select * from LIBRO;
select * from USUARIO;
select * from AUTOR;
select * from AUTOR_DE;
select * from EDITORIAL;
select * from EJEMPLAR;
select * from PRESTAMO;
select * from PENALIZACION;

select LIBRO.nombre, AUTOR.nombre, AUTOR.apellido from LIBRO join AUTOR_DE
on LIBRO.libro_id = AUTOR_DE.libro_id join AUTOR on 
AUTOR.autor_id = AUTOR_DE.autor_id;


select AUTOR.nombre, AUTOR.apellido, LIBRO.nombre from LIBRO join AUTOR_DE
on LIBRO.libro_id = AUTOR_DE.libro_id join AUTOR on 
AUTOR.autor_id = AUTOR_DE.autor_id
where AUTOR.nombre = 'Paulo';

Select LIBRO.nombre, AREA.nombre from LIBRO join AREA
on LIBRO.area_id = AREA.area_id
where AREA.nombre = 'Fantasia';

select EDITORIAL.nombre from EDITORIAL
where direccion = 'Barcelona';

Select LIBRO.nombre, EDITORIAL.nombre from EDITORIAL join LIBRO
on LIBRO.editorial_id = EDITORIAL.editorial_id;

select * 
from USUARIO join PRESTAMO
on USUARIO.usuario_id = PRESTAMO.usuario_id join EJEMPLAR
on EJEMPLAR.ejemplar_id = PRESTAMO.ejemplar_id join  LIBRO
on LIBRO.libro_id = EJEMPLAR.libro_id;

select count(*) from LIBRO join AUTOR_DE on LIBRO.libro_id = AUTOR_DE.libro_id
where autor_id in (SELECT autor_id FROM AUTOR where nombre = 'Arthur');

-- shit creo que cambia para sql server --
-- en este caso quiero numeros positivos si faltan dias y negativos si ya paso --
SELECT DATEDIFF('2014-8-5', curdate()); 
-- select datediff(day, curdate(), '2014-7-5');--
SELECT DATEDIFF( (SELECT fecha_entrega FROM PRESTAMO where prestamo_id = 2),  curdate());

select * FROM PRESTAMO WHERE fecha_entrega > fecha_salida;


INSERT INTO PENALIZACION (limite_inferior, limite_superior, costo)
VALUES (1,3,5),
		(4,6,10),
		(7,10,20),
		(11, null ,50);

-- elegir penalizacion con x dias de retraso --
SELECT costo FROM PENALIZACION where limite_inferior IN 
(SELECT MAX(limite_inferior) FROM PENALIZACION WHERE limite_inferior <= 11 );

-- elegir penalizacion de  la diferencia entre hoy y una fecha --
SELECT costo FROM PENALIZACION where limite_inferior IN 
(SELECT MAX(limite_inferior) FROM PENALIZACION WHERE limite_inferior <= datediff(CURDATE(), '2014-7-18') );


INSERT INTO PRESTAMO (usuario_id, ejemplar_id, fecha_salida, fecha_entrega)
VALUES (
	1, 
	2,
	CURDATE(), 
	DATE_ADD(CURDATE(),INTERVAL 3 DAY )
	);
