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
conductor		varchar(50)
);

create table tb_modelo_vehiculo(
idmodelo		int primary key auto_increment,
modelo 			varchar(30)
);

create table tb_vehiculo(
placa			varchar(7) not null primary key,
idmodelo		int,
detalle			varchar(60),
dniconductor	int,
foreign key (dniconductor) references tb_conductor(dniconductor),
foreign key (idmodelo) references tb_modelo_vehiculo(idmodelo)
);

create table tb_pasajero(
dnipasajero		int not null primary key,
ruc				varchar(11),
fnacimiento		date,
nombre			varchar(50),
razsocial		varchar(80)
);

create table tb_destinos(
iddesdino		int primary key auto_increment,
destino			varchar(20)
);

create table tb_viaje( 
nviaje			int primary key auto_increment,
origen			varchar(20),
destino			varchar(20),
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
origen			varchar(20),
destino			varchar(20),
fpardida		datetime,
fllegada		datetime,
prepasaje		float
);

create table tb_pasajeros_temporal(
asiento 		int not null primary key,
estado			int, -- 0Libre 1Ocupado
dnipasajero		int,
edad			int,
prepasaje 			float,
foreign key (dnipasajero) references tb_pasajero(dnipasajero)
);

insert into tb_usuario values('alex', 'Aa123', 'Alexander Gamarra', 1);
insert into tb_usuario values('admin', 'admin', 'ADMINISTRADOR', 0);

insert into tb_conductor values(48562548, 'Pablo Ramirez Valderrama');
insert into tb_conductor values(78561565, 'Carlos Choque Paredes');
insert into tb_conductor values(49581622, 'Martin Olivares');
insert into tb_conductor values(84951655, 'Joaquin Cardenas');
insert into tb_conductor values(84589125, 'Andres Torres');
insert into tb_conductor values(52048699, 'Marco Villanueva');
insert into tb_conductor values(84566618, 'Carlos Casas');
insert into tb_conductor values(12667848, 'Carlos Ventura');

insert into tb_modelo_vehiculo values(null, 'Chevrolet N300');    -- 1
insert into tb_modelo_vehiculo values(null, 'JAC Refine 2017');   -- 2
insert into tb_modelo_vehiculo values(null, 'Volkswagen R.'); -- 3
insert into tb_modelo_vehiculo values(null, 'Hyundai H1 2016');   -- 4

insert into tb_vehiculo values('A13-F8X', 1, 'Blanco', 			48562548);
insert into tb_vehiculo values('H81-D5C', 2, 'Rojo', 			78561565);
insert into tb_vehiculo values('J7A-1S1', 3, 'Gris ',			49581622);
insert into tb_vehiculo values('GR2-A7G', 4, 'Negro', 			84951655);
insert into tb_vehiculo values('AD8-E4F', 1, 'Blanco c/azul', 	84589125);
insert into tb_vehiculo values('J84-GD4', 2, 'Rojo obscuro', 	52048699);
insert into tb_vehiculo values('B94-C84', 3, 'Plomo',			84566618);
insert into tb_vehiculo values('FP3-SV3', 4, 'Negro mate', 		12667848);

insert into tb_venta_temporal values(1, 0, 0, 0, null, 0, null, null, null, null, null);

insert into tb_pasajero values(76784966, '10767849660', '1994-10-30', 'Alexander Gamarra', 'Byte x Byte');
insert into tb_pasajero values(76784955, '10767849550', '1995-01-28', 'Melany G', 'BxB');
insert into tb_pasajero values(76784944, '10767849440', '1997-12-31', 'Jean Carlos', 'Sin oficio');
insert into tb_pasajero values(76784933, '10767849330', '1995-03-05', 'Andrea Perez', 'Imagenes SRL');
insert into tb_pasajeros_temporal values(1, 1, 76784966, 10767849660, 'Alexander Gamarra', 'BxB', 30, 10, 1994, 24, 19.90);

-- ELIMINAR TABLAS Y DB -----------------------------------------------------------
drop database db_venta_pasajes; -- ----------------------------------------------
drop table tb_usuario;
drop table tb_conductor;
drop table tb_modelo_vehiculo;
drop table tb_vehiculo;
drop table tb_pasajero;
drop table tb_destinos;
drop table tb_viaje;
drop table tb_detalle_viaje;
drop table tb_venta_temporal;
drop table tb_pasajeros_temporal;

-- SELECT TABLAS -----------------------------------------------------------------
use db_venta_pasajes;
select * from tb_usuario;
select * from tb_conductor;
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


