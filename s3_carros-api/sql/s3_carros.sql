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

insert into PUNTOVENTAENTITY (id, direccion, telefono, LATITUD, LONGITUD, NOMBRE) values (1, 'Calle 10 #26-18', '3508484', 4.607709, -74.091664, 'GoodFellasRicaurte');
insert into PUNTOVENTAENTITY (id, direccion, telefono, LATITUD, LONGITUD, NOMBRE) values (2, 'Cra. 7 #51-4', '3502224', 4.638876, -74.063145, 'GoodFellas7ma');
insert into PUNTOVENTAENTITY (id, direccion, telefono, LATITUD, LONGITUD, NOMBRE) values (3, 'Caracas #71-33', '3504424', 4.659359, -74.062509, 'GoodFellasChile');


insert into MARCAENTITY (ID, DESCRIPCION, IMAGEN, NOMBREMARCA) values (1, 'Innovation that exites','https://i.ytimg.com/vi/YI7WaagSVE0/maxresdefault.jpg', 'Nissan');
insert into MARCAENTITY (ID, DESCRIPCION, IMAGEN, NOMBREMARCA) values (2, 'We are professional grade ', 'https://www.gmc.com.mx/content/dam/gmc/na/mx/es/index/current-offers/01-images/gmc-offers-mh-lg.jpg?imwidth=1200', 'GMC');
insert into MARCAENTITY (ID, DESCRIPCION, IMAGEN, NOMBREMARCA) values (3, 'Go Further', 'https://www.ford.com/cmslibs/content/dam/brand_ford/en_us/brand/campaigns/2019/bfp/BFP_Billboard_Desktop_Edge_2160x945.jpg/_jcr_content/renditions/cq5dam.web.1440.1440.jpeg', 'Ford');
insert into MARCAENTITY (ID, DESCRIPCION, IMAGEN, NOMBREMARCA) values (4, 'There is no substitute', 'https://www.diariomotor.com/imagenes/picscache/1920x1600c/porsche-718-boxster-video_1920x1600c.jpg', 'Porsche');
insert into MARCAENTITY (ID, DESCRIPCION, IMAGEN, NOMBREMARCA) values (5, 'Lets Go Places', 'https://e00-marca.uecdn.es/assets/multimedia/imagenes/2017/11/04/15097995704823.jpg', 'Toyota');
insert into MARCAENTITY (ID, DESCRIPCION, IMAGEN, NOMBREMARCA) values (6, 'Das Beste oder nichts', '../assets/Images/MERCEDES.jpg', 'Merdeces');
insert into MARCAENTITY (ID, DESCRIPCION, IMAGEN, NOMBREMARCA) values (7, 'Excellence Through Passion', 'https://www.diariomotor.com/imagenes/picscache/1920x1600c/maserati_ghibli_ficha_0418_033_1920x1600c.jpg', 'Maserati');
insert into MARCAENTITY (ID, DESCRIPCION, IMAGEN, NOMBREMARCA) values (8, 'Varsprung durch Technik', '../assets/Images/AUDI.jpg', 'Audi');
insert into MARCAENTITY (ID, DESCRIPCION, IMAGEN, NOMBREMARCA) values (9, 'The Ultimate Driving Machine', '../assets/Images/BMW.jpg', 'BMW');
insert into MARCAENTITY (ID, DESCRIPCION, IMAGEN, NOMBREMARCA) values (10, 'Jinba Ittai', 'https://cochesnuevos.autofacil.es/img/MAZDA_3_SEDAN_2019.jpg', 'Mazda');

INSERT INTO MODELOENTITY (ID,AIRBAG,AIREAC,ASIENTOS,CILINDRAJE,COMBUSTIBLE,DIRECCION,FRENOSABS,NOMBRE,NUMEROPUERTAS,TRACCION,TRANSMISION,VIDRIOS,MARCA_ID) VALUES (1,1,1,'Sintéticos',1600,
                                                                                                                                                                    'Gasolina','Asistida',1,
                                                                                                                                                                    'Focus',3,'Total','Automática',
                                                                                                                                                                    'Eléctricos',3);
INSERT INTO MODELOENTITY (ID,AIRBAG,AIREAC,ASIENTOS,CILINDRAJE,COMBUSTIBLE,DIRECCION,FRENOSABS,NOMBRE,NUMEROPUERTAS,TRACCION,TRANSMISION,VIDRIOS,MARCA_ID) VALUES (2,1,1,'Sintéticos',2400,
                                                                                                                                                                    'Diesel','Asistida',1,
                                                                                                                                                                    'Patrol',5,'Total','Automática',
                                                                                                                                                                    'Eléctricos',1);
INSERT INTO MODELOENTITY (ID,NOMBRE,MARCA_ID) VALUES (3,'Cayanne',4);

INSERT INTO REGISTROCOMPRAENTITY (ID,FECHACOMPRA,NOMBREVENDEDOR,PRECIOCOMPRADO,PUNTOVENTA_ID) VALUES (1,'2018-06-18','Camilo Peréz',40000000,1);
INSERT INTO REGISTROCOMPRAENTITY (ID,FECHACOMPRA,NOMBREVENDEDOR,PRECIOCOMPRADO,PUNTOVENTA_ID) VALUES (2,'2018-07-28','David Bernal',60000000,1);
INSERT INTO REGISTROCOMPRAENTITY (ID,FECHACOMPRA,NOMBREVENDEDOR,PRECIOCOMPRADO,PUNTOVENTA_ID) VALUES (3,'2018-09-01','Angela Rodriguez',40000000,1);
INSERT INTO REGISTROCOMPRAENTITY (ID,FECHACOMPRA,NOMBREVENDEDOR,PRECIOCOMPRADO,PUNTOVENTA_ID) VALUES (4,'2018-10-18','Daniel Lopéz',40000000,1);

insert into AUTOMOVILENTITY (id,ANIO,COLOR,CUIDADMATRICULA,DISPONIBLE,IDCHASIS,MATRICULA,PRECIOVENTA,PUNTOVENTAID,RECORRIDO,REFERENCIA,TIPO,MODELO_ID,REGISTROCOMPRA_ID)
                             VALUES (1,2015,'Rojo','Bogotá',1,3256,'VGC-265',48000,1,60,'','Camioneta',2,1);
insert into AUTOMOVILENTITY (id,ANIO,COLOR,CUIDADMATRICULA,DISPONIBLE,IDCHASIS,MATRICULA,PRECIOVENTA,PUNTOVENTAID,RECORRIDO,REFERENCIA,TIPO,MODELO_ID,REGISTROCOMPRA_ID)
                             VALUES (2,2015,'Azul','Bogotá',1,1254,'HBT-236',70000,2,10,'','Camioneta',3,2);
insert into AUTOMOVILENTITY (id,ANIO,COLOR,CUIDADMATRICULA,DISPONIBLE,IDCHASIS,MATRICULA,PRECIOVENTA,PUNTOVENTAID,RECORRIDO,REFERENCIA,TIPO,MODELO_ID,REGISTROCOMPRA_ID)
                             VALUES (3,2015,'Dorado','Bogotá',1,5236,'CDR-265',30000,1,16,'','Camioneta',2,1);
insert into AUTOMOVILENTITY (id,ANIO,COLOR,CUIDADMATRICULA,DISPONIBLE,IDCHASIS,MATRICULA,PRECIOVENTA,PUNTOVENTAID,RECORRIDO,REFERENCIA,TIPO,MODELO_ID,REGISTROCOMPRA_ID)
                             VALUES (4,2015,'Gris','Bogotá',1,6594,'VGC-696',36000,2,35,'','Camioneta',2,1);

INSERT INTO CLIENTEENTITY (ID,CORREO,NOMBRE,TELEFONO) VALUES (1, 'asd@mail.com', 'Camilo Peréz', '3523256232');
INSERT INTO CLIENTEENTITY (ID,CORREO,NOMBRE,TELEFONO) VALUES (2, 'ino@mail.com', 'Andrés Peréz', '1236544486');
INSERT INTO CLIENTEENTITY (ID,CORREO,NOMBRE,TELEFONO) VALUES (3, 'dfghj@mail.com', 'Pablo Peréz', '2585236985');

insert into CLIENTEENTITY_PUNTOVENTAENTITY (PUNTOSVENTA_ID, CLIENTES_ID) values (1, 1);
insert into CLIENTEENTITY_PUNTOVENTAENTITY (PUNTOSVENTA_ID, CLIENTES_ID) values (2, 2);
insert into CLIENTEENTITY_PUNTOVENTAENTITY (PUNTOSVENTA_ID, CLIENTES_ID) values (2, 3);

insert into EMPLEADOENTITY (ID,EXTENSION,NOMBRE,CORREO,PUNTOVENTA_ID) values (1, 318, 'Juan Perez', 'jp@mail.com', 1);
insert into EMPLEADOENTITY (ID,EXTENSION,NOMBRE,CORREO,PUNTOVENTA_ID) values (2, 314, 'Juan Rodriguez', 'jr@mail.com', 1);
insert into EMPLEADOENTITY (ID,EXTENSION,NOMBRE,CORREO,PUNTOVENTA_ID) values (3, 314, 'Pedro Rodriguez', 'pr@mail.com', 2);

insert into COMPRAVENTAENTITY (ID,CALIFICACIONCOMPRA,COMENTARIOS,FECHA,PAGADO,CLIENTE_ID,EMPLEADO_ID,PUNTOVENTA_ID,AUTOMOVILFACTURADO_ID) VALUES (1,4.8,'Buena compra.','2018-06-18',1,1,1,1,1);
insert into COMPRAVENTAENTITY (ID,CALIFICACIONCOMPRA,COMENTARIOS,FECHA,PAGADO,CLIENTE_ID,EMPLEADO_ID,PUNTOVENTA_ID,AUTOMOVILFACTURADO_ID) VALUES (2,4.3,'Estoy satisfecho.','2018-06-20',1,2,2,2,2);
insert into COMPRAVENTAENTITY (ID,CALIFICACIONCOMPRA,COMENTARIOS,FECHA,PAGADO,CLIENTE_ID,EMPLEADO_ID,PUNTOVENTA_ID,AUTOMOVILFACTURADO_ID) VALUES (3,4.6,'Buena compra.','2018-07-18',1,1,1,1,3);
insert into COMPRAVENTAENTITY (ID,CALIFICACIONCOMPRA,COMENTARIOS,FECHA,PAGADO,CLIENTE_ID,EMPLEADO_ID,PUNTOVENTA_ID,AUTOMOVILFACTURADO_ID) VALUES (4,5,'Excelente.','2018-06-24',1,2,2,2,4);

insert into FACTURAENTITY (ID,CUENTAORIGEN,FECHA,COMPRAVENTA_ID) VALUES (1,254100046589,'2018-06-18',1);
insert into FACTURAENTITY (ID,CUENTAORIGEN,FECHA,COMPRAVENTA_ID) VALUES (2,652300048523,'2018-06-20',1);
insert into FACTURAENTITY (ID,CUENTAORIGEN,FECHA,COMPRAVENTA_ID) VALUES (3,978500049511,'2018-07-18',1);
insert into FACTURAENTITY (ID,CUENTAORIGEN,FECHA,COMPRAVENTA_ID) VALUES (4,325400043645,'2018-06-24',1);
