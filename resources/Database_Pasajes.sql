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
ruc				int,
fnacimiento		date,
edad			int,
nombre			varchar(50),
razsocial		varchar(60)
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
id				int primary key auto_increment,
estado			int, -- 0Nuevo 1En creacion
empresa			int,  -- 1MERMA 2SIGUEL
dniconductor	int,
placa			varchar(7),
origen			varchar(20),
destino			varchar(20),
fpardida		datetime,
fllegada		datetime,
prepasaje		float
);

create table tb_pasajeros_temporal(
asiento 		int,
estado			int, -- 0Libre 1Ocupado
nombre			varchar(50),
dni				int,
edad			int,
precio 			float
);


insert into tb_usuario values('alex', 'Aa123', 'Alexander Gamarra', 1);
insert into tb_usuario values('admin', 'admin', 'ADMINISTRADOR', 0);

insert into tb_conductor values(48562548, 'Pablo Ramirez Valderrama');
insert into tb_conductor values(78561565, 'Carlos Choque Paredes');

insert into tb_modelo_vehiculo values(null, 'Chevrolet N300');
insert into tb_modelo_vehiculo values(null, 'JAC Refine 2017');
insert into tb_modelo_vehiculo values(null, 'Volkswagen Routan');
insert into tb_modelo_vehiculo values(null, 'Hyundai H1 2016');

insert into tb_vehiculo values('A13-F8X', 1, 'Blanco', 48562548);
insert into tb_vehiculo values('H81-D5C', 3, 'Rojo', 78561565);


-- drop database db_venta_pasajes;
drop table tb_vehiculo;
drop table tb_viaje;
drop table tb_detalle_viaje;
-- eliminar

use db_venta_pasajes;
select * from tb_usuario;
select * from tb_conductor;
select * from tb_modelo_vehiculo;
select * from tb_vehiculo;
select * from tb_pasajero;
select * from tb_destinos;
select * from tb_viaje;
select * from tb_detalle_viaje;


select vh.placa, mvh.modelo, vh.detalle, co.dniconductor, co.conductor
from tb_vehiculo vh
inner join tb_modelo_vehiculo mvh 
inner join tb_conductor co
on vh.idmodelo = mvh.idmodelo and
vh.dniconductor = co.dniconductor;

update tb_vehiculo set detalle = '123', dniconductor = 'sdasd' where placa = '123564';

-- prueba
