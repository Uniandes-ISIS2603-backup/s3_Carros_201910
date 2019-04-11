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
insert into REGISTROCOMPRAENTITY(ID,PUNTOVENTA_ID) values (3,1);
insert into REGISTROCOMPRAENTITY(ID,PUNTOVENTA_ID) values (4,1);

INSERT INTO MARCAENTITY(ID) values (1);

INSERT INTO MODELOENTITY(ID,MARCA_ID) VALUES (1,1);

insert into AUTOMOVILENTITY(ID,MODELO_ID,REGISTROCOMPRA_ID) values (1,1,1);
insert into AUTOMOVILENTITY(ID,MODELO_ID,REGISTROCOMPRA_ID) values (2,1,2);
insert into AUTOMOVILENTITY(ID,MODELO_ID,REGISTROCOMPRA_ID) values (3,1,3);
insert into AUTOMOVILENTITY(ID,MODELO_ID,REGISTROCOMPRA_ID) values (4,1,4);

insert into COMPRAVENTAENTITY(ID,CALIFICACIONCOMPRA,COMENTARIOS,FECHA,PAGADO,CLIENTE_ID,EMPLEADO_ID,PUNTOVENTA_ID,AUTOMOVILFACTURADO_ID) VALUES (1,4.8,'Buena compra.','2018-06-18',1,1,1,1,1);
insert into COMPRAVENTAENTITY(ID,CALIFICACIONCOMPRA,COMENTARIOS,FECHA,PAGADO,CLIENTE_ID,EMPLEADO_ID,PUNTOVENTA_ID,AUTOMOVILFACTURADO_ID) VALUES (2,4.3,'Estoy satisfecho.','2018-06-20',1,2,2,2,2);
insert into COMPRAVENTAENTITY(ID,CALIFICACIONCOMPRA,COMENTARIOS,FECHA,PAGADO,CLIENTE_ID,EMPLEADO_ID,PUNTOVENTA_ID,AUTOMOVILFACTURADO_ID) VALUES (3,4.6,'Buena compra.','2018-07-18',1,1,1,1,3);
insert into COMPRAVENTAENTITY(ID,CALIFICACIONCOMPRA,COMENTARIOS,FECHA,PAGADO,CLIENTE_ID,EMPLEADO_ID,PUNTOVENTA_ID,AUTOMOVILFACTURADO_ID) VALUES (4,5,'Excelente.','2018-06-24',1,2,2,2,4);

SELECT * FROM COMPRAVENTAENTITY;





