delete from CLIENTEENTITY_PUNTOVENTAENTITY;
delete from MARCAENTITY_PUNTOVENTAENTITY;
delete from QuejasReclamosEntity;
delete from FacturaEntity;
delete from CompraVentaEntity;
delete from ClienteEntity;
delete from EmpleadoEntity;
delete from AUTOMOVILENTITY;
delete from MODELOENTITY;
delete from MARCAENTITY;
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

INSERT INTO MARCAENTITY(nombreMarca, id) values ('Dodge', 1);
INSERT INTO MARCAENTITY(nombreMarca, id) values ('Mazda', 2);
INSERT INTO MARCAENTITY(nombreMarca, id) values ('Chevrolet', 3);

INSERT INTO MODELOENTITY(ID,MARCA_ID) VALUES (1,1);

insert into AUTOMOVILENTITY(ID,MODELO_ID,REGISTROCOMPRA_ID) values (1,1,1);
insert into AUTOMOVILENTITY(ID,MODELO_ID,REGISTROCOMPRA_ID) values (2,1,2);


insert into COMPRAVENTAENTITY(ID,CLIENTE_ID,EMPLEADO_ID,PUNTOVENTA_ID,AUTOMOVILFACTURADO_ID) VALUES (1,1,1,1,1);
insert into COMPRAVENTAENTITY(ID,CLIENTE_ID,EMPLEADO_ID,PUNTOVENTA_ID,AUTOMOVILFACTURADO_ID) VALUES (2,2,2,2,2);

SELECT * FROM PUNTOVENTAENTITY;





