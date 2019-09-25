create database db_venta_pasajes;

use db_venta_pasajes;

create table tb_usuario(
usuario 		varchar(20) not null primary key,
pass			varchar(20),
nombre			varchar(50),
tipo 		 	int
);

create table tb_empresa(
idempresa		int primary key auto_increment,
ruc 			varchar(11),
empresa 		varchar(60)
);

create table tb_conductor(
dniconductor	int not null primary key,
licencia		varchar(30),
conductor		varchar(50)
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
mtc				varchar(20),
foreign key (idmodelo) references tb_modelo_vehiculo(idmodelo)
);

create table tb_socio(
codsocio		int primary key,
idempresa		int,
dnisocio		int,
nombresocio		varchar(70),
dniconductor	int,
placa			varchar(7),
foreign key (dniconductor) references tb_conductor(dniconductor),
foreign key (placa) references tb_vehiculo(placa)
);

create table tb_pasajero(
dnipasajero		int not null primary key,
ruc				varchar(11),
fnacimiento		date,
nombre			varchar(50),
razsocial		varchar(80),
nacionalidad	varchar(50),
direccion		varchar(80)
);

create table tb_sedes(
idsede			int primary key auto_increment,
sede			varchar(50)
);

create table tb_viaje(
nviaje			int primary key auto_increment,
codsocio		int,
nombresocio		varchar(70),
empresa			int,
origen			varchar(50),
destino			varchar(50),
fpartida		datetime,
fllegada		datetime,
placa			varchar(7),
dniconductor	int,
conductor		varchar(50),
prepasaje		float,
totpasajes		float,
totalasientos	int,
asientosven		int
);

create table tb_detalle_viaje(
nviaje			int,
nboleto			int,
dnipasajero		int,
asiento			int,
edad			int,
prepasaje 		float,
contratante		int,
foreign key (nviaje) references tb_viaje(nviaje),
foreign key (dnipasajero) references tb_pasajero(dnipasajero),
primary key (nviaje, nboleto)
);

create table tb_venta_temporal(
id				int not null primary key,
estado			int, -- 0Nuevo 1En creacion
codsocio		int,
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
modalidad		int,
totalmodif		float
);                                 

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

create table tb_configuracion_inicial(
estado			int primary key, -- 0Iniciando por primera vez 
sede			varchar(50),
nserie			varchar(3),
nviajeinicial	int,
nboletoinicial	int
);

insert into tb_usuario values('bxb', 'stand207', 'BYTE X BYTE', 2);
insert into tb_usuario values('alex', 'Aa123', 'Alexander Gamarra', 1);
insert into tb_usuario values('admin', 'admin', 'ADMINISTRADOR', 0);

insert into tb_empresa values(null, '20406468683', 'MERMA HERMANOS S.R.L.');
insert into tb_empresa values(null, '20601642124', 'ZIGUEL E.I.R.L.');

insert into tb_modelo_vehiculo values(null, 'Mercedes Sprinter 413 19+1', 20); -- 1
insert into tb_modelo_vehiculo values(null, 'Mercedes Sprinter 515 19+1', 20); -- 2
insert into tb_modelo_vehiculo values(null, 'Mercedes Sprinter 515 20+1', 21); -- 3	
insert into tb_modelo_vehiculo values(null, 'Renault Master 2012 15',     15); -- 4
insert into tb_modelo_vehiculo values(null, 'Renault Master Moderna 15',  15); -- 5
insert into tb_modelo_vehiculo values(null, 'Wolkswagen Crafter 20+1',    21); -- 6

insert into tb_sedes values(null, 'Arequipa');
insert into tb_sedes values(null, 'Juliaca');
insert into tb_sedes values(null, 'Puno');
insert into tb_sedes values(null, 'Sicuani');

insert into tb_configuracion_inicial values(0, null, null, 1, 1);

insert into tb_venta_temporal values(1, 0, 0, 0, 0, null, 0, null, null, null, null, 0, -1, 1, 0, null, null, null, null, null, 0, null, null, null, 0, -1);

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
select * from tb_empresa;
select * from tb_conductor;
select * from tb_vehiculo;
select * from tb_socio;
select * from tb_modelo_vehiculo;
select * from tb_pasajero;
select * from tb_sedes;
select * from tb_viaje;
select * from tb_detalle_viaje;
select * from tb_venta_temporal;
select * from tb_pasajeros_temporal;
select * from tb_configuracion_inicial;


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
UPDATE tb_venta_temporal SET modalidad = 1 WHERE id=1;
UPDATE tb_venta_temporal SET totalmodif = 54321 WHERE id=1;

-- consulta para impresion ed boleto
select p.nombre, pt.dnipasajero, p.razsocial, vt.fpartida, pt.prepasaje, vt.origen, vt.destino, vt.nviaje, pt.nboleto
from tb_pasajeros_temporal pt
inner join tb_venta_temporal vt
inner join tb_pasajero p
on vt.id = 1
and p.dnipasajero = pt.dnipasajero
where pt.asiento = 2;

-- consulta para hoja de ruta
select vt.placa, DATE_FORMAT(vt.fpartida, '%d-%m-%Y') Fecha_Inicio, DATE_FORMAT(vt.fllegada, '%d-%m-%Y') Fecha_Llegada, vt.standar, vt.escalacom, vt.origen, vt.destino, 
TIME(vt.fpartida) Hora_Salida,  TIME(vt.fllegada) Hora_Llegada, c.conductor, c.licencia, TIME(vt.fpartida) Hora_Inicio_1, 
vt.horainicio2, c2.conductor, c2.licencia l2, vt.horafin1, vt.horafin2, vt.comentarios
from tb_venta_temporal vt
inner join tb_conductor c
on c.dniconductor = vt.dniconductor
left join tb_conductor c2
on c2.dniconductor = vt.dniconductor2
where  vt.id = 1;

-- consulta para itinerario de viaje
select vt.placa, DATE_FORMAT(vt.fpartida, '%d-%m-%Y') Fecha_Inicio, DATE_FORMAT(vt.fllegada, '%d-%m-%Y') Fecha_Llegada, p.dnipasajero, p.nombre,  vt.standar, vt.escalacom, vt.origen, vt.destino, 
TIME(vt.fpartida) Hora_Salida,  TIME(vt.fllegada) Hora_Llegada, c.conductor, c.licencia, TIME(vt.fpartida) Hora_Inicio_1, 
vt.horainicio2, c2.conductor c2, c2.licencia l2, vt.horafin1, vt.horafin2, vt.puntoencuentro, vt.escalas, vt.ciudaddesde, vt.ciudadhasta,  round(sum(pt2.prepasaje)) totpasajes
from tb_venta_temporal vt
inner join tb_conductor c
on c.dniconductor = vt.dniconductor
left join tb_conductor c2
on c2.dniconductor = vt.dniconductor2
left join tb_pasajeros_temporal pt
on pt.contratante = 1
left join tb_pasajeros_temporal pt2
on pt2.estado = 1
left join tb_pasajero p
on pt.dnipasajero = p.dnipasajero
where  vt.id = 1;

-- consulta para contrato
select vt.placa, DATE_FORMAT(vt.fpartida, '%d-%m-%Y') Fecha_Inicio, TIME(vt.fpartida) Hora_Salida, p.dnipasajero, p.nombre, vt.origen, vt.destino, 
vt.puntoencuentro, vt.ciudaddesde, vt.ciudadhasta, mvh.casientos, round(sum(pt2.prepasaje)) totpasajes, round(pt2.totalmodif) totpasajesmodif
from tb_venta_temporal vt
inner join  tb_vehiculo vh
on vh.placa = vt.placa
inner join  tb_modelo_vehiculo mvh
on mvh.idmodelo = vh.idmodelo
inner join tb_conductor c
on c.dniconductor = vt.dniconductor
left join tb_conductor c2
on c2.dniconductor = vt.dniconductor2
left join tb_pasajeros_temporal pt
on pt.contratante = 1
left join tb_pasajeros_temporal pt2
on pt2.estado = 1
left join tb_pasajero p
on pt.dnipasajero = p.dnipasajero
where  vt.id = 1;

-- manifiesto
select vt.origen, vt.destino, DATE_FORMAT(vt.fpartida, '%d-%m-%Y') Fecha_Viaje,  TIME(vt.fpartida) Hora_Salida, mvh.casientos, c.conductor, c.licencia, vh.placa, mvh.modelo, vh.mtc, pt.asiento, p.nombre, pt.dnipasajero, pt.edad, pt.nboleto, p.nacionalidad, pt.prepasaje, vt.nviaje
from  db_venta_pasajes.tb_pasajeros_temporal pt
inner join  db_venta_pasajes.tb_pasajero p
inner join  db_venta_pasajes.tb_venta_temporal vt
inner join  db_venta_pasajes.tb_conductor c
inner join  db_venta_pasajes.tb_vehiculo vh
inner join  db_venta_pasajes.tb_modelo_vehiculo mvh
inner join  db_venta_pasajes.tb_empresa e
on pt.estado = 1 
and  p.dnipasajero = pt.dnipasajero
and vt.id = 1
and c.dniconductor = vt.dniconductor
and vh.placa = vt.placa
and mvh.idmodelo = vh.idmodelo
and e.idempresa = vt.empresa
order by pt.asiento;


-- boleta de venta
select pt.dnipasajero, p.ruc, p.nombre, p.direccion, vt.origen, vt.destino, pt.prepasaje, vt.totalmodif, vt.escalas
from  tb_pasajeros_temporal pt
inner join  tb_pasajero p
inner join  tb_venta_temporal vt
inner join  tb_vehiculo vh
on pt.estado = 1 
and  p.dnipasajero = pt.dnipasajero
and vt.id = 1
and vh.placa = vt.placa
and pt.contratante = 1;


select vt.placa, DATE_FORMAT(vt.fpartida, '%d-%m-%Y') Fecha_Inicio, TIME(vt.fpartida) Hora_Salida, p.dnipasajero, p.nombre, vt.origen, vt.destino, 
vt.puntoencuentro, vt.ciudaddesde, vt.ciudadhasta, mvh.casientos,  round(sum(pt2.prepasaje)) totpasajes, vt.modalidad
from tb_venta_temporal vt
inner join  tb_vehiculo vh
on vh.placa = vt.placa
inner join  tb_modelo_vehiculo mvh
on mvh.idmodelo = vh.idmodelo
inner join tb_conductor c
on c.dniconductor = vt.dniconductor
left join tb_conductor c2
on c2.dniconductor = vt.dniconductor2
left join tb_pasajeros_temporal pt
on pt.contratante = 1
left join tb_pasajeros_temporal pt2
on pt2.estado = 1
left join tb_pasajero p
on pt.dnipasajero = p.dnipasajero
where  vt.id = 1;

SELECT (ELT(WEEKDAY(fpartida) + 1, 'Lunes', 'Martes', 'Miercoles', 'Jueves', 'Viernes', 'Sabado', 'Domingo')) AS DIA_SEMANA
FROM tb_venta_temporal

