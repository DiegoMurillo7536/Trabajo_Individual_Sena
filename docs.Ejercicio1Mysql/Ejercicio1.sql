create database primera_base;

use primera_base;

create table ciudad
(
cod_ciudad int primary key,
desc_ciudad varchar(35) not null
);
create table usuario
(
id_usuario varchar(20) not null,
primer_nombre varchar(45) not null,
segundo_nombre varchar(45),
primer_apellido varchar(45) not null,
segundo_apellido varchar(45),
telefono bigint not null
);

create table tipo_doc
(
cod_tdoc varchar(4) primary key,
desc_tdcoc varchar(45) not null
);

create table genero
(
id_genero int(1) primary key,
nom_genero varchar(10) not null
);

/* Alterando la tabla usuario para agregarle los campos*/
alter table usuario add cod_ciudad int not null;
alter table usuario add cod_tdoc varchar(4) not null;
alter table usuario add genero int(1) not null;

/* Alterando los campos para agregarles las llaves foraneas y primarias*/
alter table usuario add foreign key (cod_ciudad) references ciudad(cod_ciudad);
alter table usuario add foreign key (cod_tdoc) references tipo_doc(cod_tdoc) ;
alter table usuario add primary key (cod_tdoc,id_usuario);
alter table usuario add foreign key  (genero) references genero(id_genero);
