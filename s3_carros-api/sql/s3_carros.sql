delete from CLIENTEENTITY_PUNTOVENTAENTITY;
delete from MARCAENTITY_PUNTOVENTAENTITY;
delete from ClienteEntity;
delete from CompraVentaEntity;
delete from EmpleadoEntity;
delete from FacturaEntity;
delete from QuejasReclamosEntity;
delete from RegistroCompraEntity;
delete from PuntoVentaEntity;

insert into PuntoVentaEntity (id, direccion, telefono) values (1, 'Calle 10 #26-18', '3508484');
insert into PuntoVentaEntity (id, direccion, telefono) values (2, 'Calle 15 #30-18', '3508686');

insert into ClienteEntity (id, nombre, correo, telefono) values (1, 'Camilo Perez', 'cp@mail.com', '3124548978');
insert into ClienteEntity (id, nombre, correo, telefono) values (2, 'Carla Espitia', 'ce@mail.com', '3124568168');

insert into CLIENTEENTITY_PUNTOVENTAENTITY (PUNTOSVENTA_ID, CLIENTES_ID) values (1, 2);
insert into CLIENTEENTITY_PUNTOVENTAENTITY (PUNTOSVENTA_ID, CLIENTES_ID) values (2, 2);
insert into CLIENTEENTITY_PUNTOVENTAENTITY (PUNTOSVENTA_ID, CLIENTES_ID) values (2, 1);

insert into EMPLEADOENTITY (ID,EXTENSION,NOMBRE,CORREO,PUNTOVENTA_ID) values (1, 318, 'Juan Perez', 'jp@mail.com', 1);
insert into EMPLEADOENTITY (ID,EXTENSION,NOMBRE,CORREO,PUNTOVENTA_ID) values (2, 314, 'Juan Rodriguez', 'jr@mail.com', 1);
insert into EMPLEADOENTITY (ID,EXTENSION,NOMBRE,CORREO,PUNTOVENTA_ID) values (3, 314, 'Pedro Rodriguez', 'pr@mail.com', 2);

insert into REGISTROCOMPRAENTITY(ID,PUNTOVENTA_ID) values (1,1);
insert into REGISTROCOMPRAENTITY(ID,PUNTOVENTA_ID) values (2,1);


