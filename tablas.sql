CREATE DATABASE asistencias; -- ejecutar solo

create table public.usuario(
    id_usuario serial not null,
    user_name varchar(100) not null UNIQUE,
    password varchar(100) not null,
    nombre varchar(100) not null,
    apellido varchar(100) not null,
    roles varchar(100) default 'ROLE_USER',
    active boolean default TRUE,
    primary key (id_usuario)
);

create table public.tecnico(
    id_tecnico int not null,
    especialidad int not null,
    primary key (id_tecnico),
    foreign key (id_tecnico) references usuario(id_usuario)   
);

create table public.solicitud(
    id_solicitud serial not null,
    id_usuario int not null,
    id_tecnico int,
    monto int default 0,
    direccion varchar(100),
    fecha DATETIME,
    latitud numeric,
    longitud numeric,
    asunto varchar(150),
    categoria varchar(100),
    descripcion varchar(300),
    aceptada_cli boolean default FALSE,
    aceptada_fecha boolean default FALSE,
    aceptada_tec boolean default FALSE,
    aceptada_adm boolean default FALSE,
    primary key (id_solicitud),
    foreign key (id_usuario) references usuario(id_usuario),
    foreign key (id_tecnico) references usuario(id_usuario)
);