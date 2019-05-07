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

insert into PUNTOVENTAENTITY (id, direccion, telefono, LATITUD, LONGITUD, NOMBRE, RUTAFOTOS) values (1, 'Calle 10 #26-18', '3508484', 4.607709, -74.091664, 'GoodFellasRicaurte');
insert into PUNTOVENTAENTITY (id, direccion, telefono, LATITUD, LONGITUD, NOMBRE, RUTAFOTOS) values (2, 'Cra. 7 #51-4', '3502224', 4.638876, -74.063145, 'GoodFellas7ma');
insert into PUNTOVENTAENTITY (id, direccion, telefono, LATITUD, LONGITUD, NOMBRE, RUTAFOTOS) values (3, 'Caracas #71-33', '3504424', 4.659359, -74.062509, 'GoodFellasChile');

insert into MARCAENTITY (ID, DESCRIPCION, IMAGEN, NOMBREMARCA, IMAGEN_MARCA) values (1, 'Nissan Motor Company, Limited es un fabricante japonés de automóviles, con base en Yokohama. 
                                                                                        Su nombre común, Nissan, es un acrónimo de "Nippon Sangyo". Está entre las principales compañías 
                                                                                        automotrices en términos de producción anual de vehículos', 
                'https://banner2.kisspng.com/20180802/ivx/kisspng-logo-nissan-car-brand-emblem-nissan-maxima-workshop-service-amp-repair-manual-5b63b1ee7124e1.4901775015332602704635.jpg', 
                'Nissan', null);
insert into MARCAENTITY (ID, DESCRIPCION, IMAGEN, NOMBREMARCA, IMAGEN_MARCA) values (2, 'GMC (siglas de General Motors Company o Corporation) es una división del grupo automovilístico 
                                                                                        General Motors idealizada en 1911 por Max Grabowski y fundada por General Motors.',
                                                                                        'https://logos-coches.com/wp-content/uploads/2018/04/GMC-logo.png', 'GMC', null);
insert into MARCAENTITY (ID, DESCRIPCION, IMAGEN, NOMBREMARCA, IMAGEN_MARCA) values (3, 'La Ford Motor Company, mas conocida como Ford, es una empresa multinacional estadounidense 
                                                                                        fabricante de automóviles con sede en Dearborn, fue fundada por Henry Ford y se incorporó el 16 
                                                                                        de junio de 1903.', 'https://logos-coches.com/wp-content/uploads/2018/04/Ford-logo-450x253.png', 
                                                                                        'Ford', null);
insert into MARCAENTITY (ID, DESCRIPCION, IMAGEN, NOMBREMARCA, IMAGEN_MARCA) values (4, 'Porsche es un fabricante de automóviles alemán especializado en automóviles deportivos lujosos, 
                                                                                        de alta gama, SUV y sedanes. Porsche AG es propiedad del Grupo Volkswagen, ​ que a su vez es 
                                                                                        propiedad mayoritaria de Porsche Automovil Holding SE.', 
                                                                                        'https://logos-coches.com/wp-content/uploads/2018/04/Porsche-logo-450x253.png', 'Porsche', null);
insert into MARCAENTITY (ID, DESCRIPCION, IMAGEN, NOMBREMARCA, IMAGEN_MARCA) values (5, 'Toyota Motor Corporation es un fabricante japonés de automóviles con sede en Toyota, Aichi, Japón. 
                                                                                        Toyota fue el mayor fabricante de automóviles en 2015, por delante de Volkswagen y Mercedes-Benz.',
                                                                                        'https://logos-coches.com/wp-content/uploads/2018/04/Toyota-logo-450x253.png', 'Toyota', null);
insert into MARCAENTITY (ID, DESCRIPCION, IMAGEN, NOMBREMARCA, IMAGEN_MARCA) values (6, 'Mercedes-Benz es una empresa alemana fabricante de vehículos de lujo, división de la compañía 
                                                                                        Daimler AG. La marca es reconocida por sus vehículos de lujo, autobuses y camiones. Su eslogan es 
                                                                                        "The best or nothing', 'https://logos-coches.com/wp-content/uploads/2018/04/Mercedes-Benz-logo.png', 
                                                                                        'Mercedes-Benz', null);

INSERT INTO MODELOENTITY (ID,AIRBAG,AIREAC,ASIENTOS,CILINDRAJE,COMBUSTIBLE,DIRECCION,FRENOSABS,NOMBRE,NUMEROPUERTAS,TRACCION,TRANSMISION,VIDRIOS,MARCA_ID,) VALUES (1,1,1,'Sintéticos',1600,
                                                                                                                                                                    'Gasolina','Asistida',1,
                                                                                                                                                                    'Focus',3,'Total','Automática',
                                                                                                                                                                    'Eléctricos',3);
INSERT INTO MODELOENTITY (ID,AIRBAG,AIREAC,ASIENTOS,CILINDRAJE,COMBUSTIBLE,DIRECCION,FRENOSABS,NOMBRE,NUMEROPUERTAS,TRACCION,TRANSMISION,VIDRIOS,MARCA_ID,) VALUES (2,1,1,'Sintéticos',2400,
                                                                                                                                                                    'Diesel','Asistida',1,
                                                                                                                                                                    'Patrol',5,'Total','Automática',
                                                                                                                                                                    'Eléctricos',1);
INSERT INTO MODELOENTITY (ID,AIRBAG,AIREAC,ASIENTOS,CILINDRAJE,COMBUSTIBLE,DIRECCION,FRENOSABS,NOMBRE,NUMEROPUERTAS,TRACCION,TRANSMISION,VIDRIOS,MARCA_ID,) VALUES (3,1,1,'Sintéticos',2000,
                                                                                                                                                                    'Gasolina','Asistida',1,
                                                                                                                                                                    'Cayanne',5,'Total','Automática',
                                                                                                                                                                    'Eléctricos',4);

INSERT INTO REGISTROCOMPRAENTITY (ID,FECHACOMPRA,NOMBREVENDEDOR,PRECIOCOMPRADO,PUNTOVENTA_ID) VALUES (1,'2018-06-18','Camilo Peréz',40000000,1);
INSERT INTO REGISTROCOMPRAENTITY (ID,FECHACOMPRA,NOMBREVENDEDOR,PRECIOCOMPRADO,PUNTOVENTA_ID) VALUES (2,'2018-07-28','David Bernal',60000000,1);
INSERT INTO REGISTROCOMPRAENTITY (ID,FECHACOMPRA,NOMBREVENDEDOR,PRECIOCOMPRADO,PUNTOVENTA_ID) VALUES (3,'2018-09-01','Angela Rodriguez',40000000,1);
INSERT INTO REGISTROCOMPRAENTITY (ID,FECHACOMPRA,NOMBREVENDEDOR,PRECIOCOMPRADO,PUNTOVENTA_ID) VALUES (4,'2018-10-18','Daniel Lopéz',40000000,1);

insert into AUTOMOVILENTITY (id,ANIO,COLOR,CUIDADMATRICULA,DISPONIBLE,IDCHASIS,MATRICULA,PRECIOVENTA,PUNTOVENTAID,RECORRIDO,REFERENCIA,TIPO,MODELO_ID,REGISTROCOMPRA_ID,IMAGEN_AUTO,)
                             VALUES (1,2015,'Rojo','Bogotá',1,325645689852,'VGC-265',48000000,1,60000,'','Camioneta',2,1,'');
insert into AUTOMOVILENTITY (id,ANIO,COLOR,CUIDADMATRICULA,DISPONIBLE,IDCHASIS,MATRICULA,PRECIOVENTA,PUNTOVENTAID,RECORRIDO,REFERENCIA,TIPO,MODELO_ID,REGISTROCOMPRA_ID,IMAGEN_AUTO,)
                             VALUES (2,2015,'Azul','Bogotá',1,125469856325,'HBT-236',70000000,2,100000,'','Camioneta',3,2,'');
insert into AUTOMOVILENTITY (id,ANIO,COLOR,CUIDADMATRICULA,DISPONIBLE,IDCHASIS,MATRICULA,PRECIOVENTA,PUNTOVENTAID,RECORRIDO,REFERENCIA,TIPO,MODELO_ID,REGISTROCOMPRA_ID,IMAGEN_AUTO,)
                             VALUES (3,2015,'Dorado','Bogotá',1,523654785214,'CDR-265',30000000,1,160000,'','Camioneta',2,1,'');
insert into AUTOMOVILENTITY (id,ANIO,COLOR,CUIDADMATRICULA,DISPONIBLE,IDCHASIS,MATRICULA,PRECIOVENTA,PUNTOVENTAID,RECORRIDO,REFERENCIA,TIPO,MODELO_ID,REGISTROCOMPRA_ID,IMAGEN_AUTO,)
                             VALUES (4,2015,'Gris','Bogotá',1,659432643235,'VGC-696',36000000,2,350000,'','Camioneta',2,1,'');

INSERT INTO CLIENTEENTITY (ID,CORREO,NOMBRE,TELEFONO) VALUES (1, 'asd@mail.com', 'Camilo Peréz', 3523256232);
INSERT INTO CLIENTEENTITY (ID,CORREO,NOMBRE,TELEFONO) VALUES (2, 'ino@mail.com', 'Andrés Peréz', 1236544486);
INSERT INTO CLIENTEENTITY (ID,CORREO,NOMBRE,TELEFONO) VALUES (3, 'dfghj@mail.com', 'Pablo Peréz', 2585236985);

insert into CLIENTEENTITY_PUNTOVENTAENTITY (PUNTOSVENTA_ID, CLIENTES_ID) values (1, 1);
insert into CLIENTEENTITY_PUNTOVENTAENTITY (PUNTOSVENTA_ID, CLIENTES_ID) values (2, 2);
insert into CLIENTEENTITY_PUNTOVENTAENTITY (PUNTOSVENTA_ID, CLIENTES_ID) values (2, 3);

insert into EMPLEADOENTITY (ID,EXTENSION,NOMBRE,CORREO,PUNTOVENTA_ID,) values (1, 318, 'Juan Perez', 'jp@mail.com', 1);
insert into EMPLEADOENTITY (ID,EXTENSION,NOMBRE,CORREO,PUNTOVENTA_ID) values (2, 314, 'Juan Rodriguez', 'jr@mail.com', 1);
insert into EMPLEADOENTITY (ID,EXTENSION,NOMBRE,CORREO,PUNTOVENTA_ID) values (3, 314, 'Pedro Rodriguez', 'pr@mail.com', 2);

insert into COMPRAVENTAENTITY (ID,CALIFICACIONCOMPRA,COMENTARIOS,FECHA,PAGADO,CLIENTE_ID,EMPLEADO_ID,PUNTOVENTA_ID,AUTOMOVILFACTURADO_ID,) VALUES (1,4.8,'Buena compra.','2018-06-18',1,1,1,1,1);
insert into COMPRAVENTAENTITY (ID,CALIFICACIONCOMPRA,COMENTARIOS,FECHA,PAGADO,CLIENTE_ID,EMPLEADO_ID,PUNTOVENTA_ID,AUTOMOVILFACTURADO_ID) VALUES (2,4.3,'Estoy satisfecho.','2018-06-20',1,2,2,2,2);
insert into COMPRAVENTAENTITY (ID,CALIFICACIONCOMPRA,COMENTARIOS,FECHA,PAGADO,CLIENTE_ID,EMPLEADO_ID,PUNTOVENTA_ID,AUTOMOVILFACTURADO_ID) VALUES (3,4.6,'Buena compra.','2018-07-18',1,1,1,1,3);
insert into COMPRAVENTAENTITY (ID,CALIFICACIONCOMPRA,COMENTARIOS,FECHA,PAGADO,CLIENTE_ID,EMPLEADO_ID,PUNTOVENTA_ID,AUTOMOVILFACTURADO_ID) VALUES (4,5,'Excelente.','2018-06-24',1,2,2,2,4);

insert into FACTURAENTITY (ID,CUENTAORIGEN,FECHA,COMPRAVENTA_ID) VALUES (1,254100046589,'2018-06-18',1);
insert into FACTURAENTITY (ID,CUENTAORIGEN,FECHA,COMPRAVENTA_ID) VALUES (2,652300048523,'2018-06-20',1);
insert into FACTURAENTITY (ID,CUENTAORIGEN,FECHA,COMPRAVENTA_ID) VALUES (3,978500049511,'2018-07-18',1);
insert into FACTURAENTITY (ID,CUENTAORIGEN,FECHA,COMPRAVENTA_ID) VALUES (4,325400043645,'2018-06-24',1);
