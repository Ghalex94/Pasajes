create database db_venta_pasajes;

use db_venta_pasajes;

create table tb_usuario(
usuario 		varchar(20) not null primary key,
pass			varchar(20),
nombre			varchar(50),
tipo 		 	int
);

create table tb_conductor(
dniconductor	int not null primary key,
licencia		varchar(30),
conductor		varchar(50)
);

create table tb_empresa(
idempresa		int primary key auto_increment,
ruc 			varchar(11),
empresa 		varchar(60),
mtc				varchar(20)
);

create table tb_modelo_vehiculo(
idmodelo		int primary key auto_increment,
modelo 			varchar(50),
casientos		int
);

create table tb_vehiculo(
placa			varchar(7) not null primary key,
idmodelo		int,
detalle			varchar(100),
dniconductor	int,
foreign key (dniconductor) references tb_conductor(dniconductor),
foreign key (idmodelo) references tb_modelo_vehiculo(idmodelo)
);

create table tb_pasajero(
dnipasajero		int not null primary key,
ruc				varchar(11),
fnacimiento		date,
nombre			varchar(50),
razsocial		varchar(80),
nacionalidad	varchar(50)
);

create table tb_destinos(
iddestino		int primary key auto_increment,
destino			varchar(50)
);

create table tb_viaje( 
nviaje			int primary key auto_increment,
origen			varchar(50),
destino			varchar(50),
fhsalida		datetime,
fhllegada		datetime,
placa			varchar(7),
dniconductor	int,
prepasajeuni	float,
totpasajes		float,
totalasientos	int,
asientosven		int
);

create table tb_detalle_viaje(
nviaje			int not null,
dnipasajero		int not null,
asiento			int,
nticket			int,
edad			int,
foreign key (nviaje) references tb_viaje(nviaje),
foreign key (dnipasajero) references tb_pasajero(dnipasajero),
primary key (nviaje, dnipasajero)
);

create table tb_venta_temporal(
id				int not null primary key,
estado			int, -- 0Nuevo 1En creacion
empresa			int,  -- 0NULL 1MERMA 2SIGUEL
dniconductor	int,
placa			varchar(7),
modelovh		int,
origen			varchar(50),
destino			varchar(50),
fpartida		datetime,
fllegada		datetime,
prepasaje		float,
nviaje			int,

standar			int, -- 0NO 1SI
escalacom		int, -- 0NO 1SI	
ciudaddesde		varchar(50),
ciudadhasta		varchar(50),
puntoencuentro	varchar(60),
escalas			varchar(100),
horainicio2		varchar(5),
dniconductor2	int,
licencia2		varchar(30),
horafin1		varchar(5),
horafin2		varchar(5),
comentarios		varchar(200)
);
select  * from tb_venta_temporal;

create table tb_pasajeros_temporal(
asiento 		int not null primary key,
estado			int, -- 0Libre 1Ocupado
nboleto			int,
dnipasajero		int,
edad			int,
prepasaje 		float,
contratante		int, -- 0NO 1SI
foreign key (dnipasajero) references tb_pasajero(dnipasajero)
);

insert into tb_usuario values('alex', 'Aa123', 'Alexander Gamarra', 1);
insert into tb_usuario values('admin', 'admin', 'ADMINISTRADOR', 0);

insert into tb_empresa values(null, '20406468683', 'MERMA HERMANOS S.R.L.', null);
insert into tb_empresa values(null, '20601642124', 'ZIGUEL E.I.R.L.', null);

insert into tb_modelo_vehiculo values(null, 'Mercedes Sprinter 413 19+1', 20); -- 1
insert into tb_modelo_vehiculo values(null, 'Mercedes Sprinter 515 19+1', 20); -- 2
insert into tb_modelo_vehiculo values(null, 'Mercedes Sprinter 515 20+1', 21); -- 3
insert into tb_modelo_vehiculo values(null, 'Renault Master 2012 15', 15);     -- 4
insert into tb_modelo_vehiculo values(null, 'Renault Master Moderna 15', 15);  -- 5
insert into tb_modelo_vehiculo values(null, 'Wolkswagen Crafter 20+1', 21);    -- 6

insert into tb_destinos values(null, 'Arequipa');
insert into tb_destinos values(null, 'Puno');
insert into tb_destinos values(null, 'Juliaca');
insert into tb_destinos values(null, 'Sicuani');

insert into tb_conductor values(48562548, '468FD4F8', 'Pablo Ramirez Valderrama');
insert into tb_conductor values(78561565, '8F4D45E5', 'Carlos Choque Paredes');
insert into tb_conductor values(49581622, '845DFVC8', 'Martin Olivares');
insert into tb_conductor values(84951655, 'SD4S8A4C', 'Joaquin Cardenas');
insert into tb_conductor values(84589125, 'SD84CX52', 'Andres Torres');
insert into tb_conductor values(52048699, 'RYT7843F', 'Marco Villanueva');

insert into tb_vehiculo values('D8G-FV4', 1, 'Blanco', 48562548);
insert into tb_vehiculo values('F8F-8F4', 2, 'Blanco', 78561565);
insert into tb_vehiculo values('D8C-D4F', 3, 'Blanco', 49581622);
insert into tb_vehiculo values('G7V-D5C', 4, 'Blanco', 84951655);
insert into tb_vehiculo values('H8I-G5F', 5, 'Blanco', 84589125);
insert into tb_vehiculo values('F7Q-G4Y', 6, 'Blanco', 52048699);



insert into tb_pasajero values(76784966, '10767849660', '1994-10-30', 'Alexander Gamarra', 'Byte x Byte', 'Peruana');
insert into tb_pasajero values(76784955, '10767849550', '1995-01-28', 'Melany G', 'BxB', 'Peruana');
insert into tb_pasajero values(76784944, '10767849440', '1997-12-31', 'Jean Carlos', 'Sin oficio', 'Venzolana');
insert into tb_pasajero values(76784933, '10767849330', '1995-03-05', 'Andrea Perez', 'Imagenes SRL', 'Peruana');

insert into tb_venta_temporal values(1, 0, null, null, null, null, null, null, null, null, null, null, 1, 0, null, null, null, null, null, 0, null, null, null, null);


-- ELIMINAR TABLAS Y DB -----------------------------------------------------------
drop database db_venta_pasajes; -- ----------------------------------------------
-- drop table tb_usuario;
-- drop table tb_conductor;
-- drop table tb_modelo_vehiculo;
-- drop table tb_vehiculo;
-- drop table tb_pasajero;
-- drop table tb_destinos;
-- drop table tb_viaje;
-- drop table tb_detalle_viaje;
-- drop table tb_venta_temporal;
-- drop table tb_pasajeros_temporal;

-- SELECT TABLAS -----------------------------------------------------------------
use db_venta_pasajes;
select * from tb_usuario;
select * from tb_conductor;
select * from tb_empresa;
select * from tb_modelo_vehiculo;
select * from tb_vehiculo;
select * from tb_pasajero;
select * from tb_destinos;
select * from tb_viaje;
select * from tb_detalle_viaje;
select * from tb_venta_temporal;
select * from tb_pasajeros_temporal;


-- PRUEBAS ------------------------------------------------------------------------

select vh.placa, mvh.modelo, vh.detalle, co.dniconductor, co.conductor
from tb_vehiculo vh
inner join tb_modelo_vehiculo mvh 
inner join tb_conductor co
on vh.idmodelo = mvh.idmodelo and
vh.dniconductor = co.dniconductor;

update tb_vehiculo set detalle = '123', dniconductor = 'sdasd' where placa = '123564';

select vh.placa, vh.idmodelo, vh.detalle, vh.dniconductor, c.conductor
from tb_vehiculo vh
inner join tb_conductor c
on vh.dniconductor = c.dniconductor
order by vh.idmodelo;

update tb_venta_temporal set estado = 0 where id = 1;

delete from  tb_venta_temporal where id = 1;

select * from tb_pasajeros_temporal where dni = 76784968;

select * from tb_pasajeros_temporal where asiento = 6;

delete from tb_pasajeros_temporal where asiento = 11;

select vh.placa, mvh.idmodelo, mvh.modelo, vh.detalle, co.dniconductor, co.conductor from tb_vehiculo vh inner join tb_modelo_vehiculo mvh  inner join tb_conductor co on vh.idmodelo = mvh.idmodelo and vh.dniconductor = co.dniconductor order by mvh.modelo;

-- consulta para manifiesto de pasajeros
select vt.origen, vt.destino, DATE_FORMAT(vt.fpartida, '%d-%m-%Y') Fecha_Viaje,  TIME(vt.fpartida) Hora_Salida, mvh.casientos, 
c.conductor, c.licencia, vh.placa, mvh.modelo, e.mtc, pt.asiento, p.nombre, pt.dnipasajero, pt.edad, pt.nboleto, p.nacionalidad, pt.prepasaje, vt.nviaje
from tb_pasajeros_temporal pt
inner join tb_pasajero p
inner join tb_venta_temporal vt
inner join tb_conductor c
inner join tb_vehiculo vh
inner join tb_modelo_vehiculo mvh
inner join tb_empresa e
on pt.estado = 1 
and  p.dnipasajero = pt.dnipasajero
and vt.id = 1
and c.dniconductor = vt.dniconductor
and vh.placa = vt.placa
and mvh.idmodelo = vh.idmodelo
and e.idempresa = vt.empresa
order by pt.asiento; 

UPDATE tb_venta_temporal SET fpartida = concat(date(fpartida), ' 21:00:00') WHERE id=1;

-- consulta para impresion ed boleto
select p.nombre, pt.dnipasajero, p.razsocial, vt.fpartida, pt.prepasaje, vt.origen, vt.destino, vt.nviaje, pt.nboleto
from tb_pasajeros_temporal pt
inner join tb_venta_temporal vt
inner join tb_pasajero p
on vt.id = 1
and p.dnipasajero = pt.dnipasajero
where pt.asiento = 2;

-- consulta para hoja de ruta


