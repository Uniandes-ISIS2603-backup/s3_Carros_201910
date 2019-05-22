delete from CLIENTEENTITY_PUNTOVENTAENTITY;
delete from MARCAENTITY_PUNTOVENTAENTITY;
delete from QuejasReclamosEntity;
delete from FacturaEntity;
delete from CompraVentaEntity;
delete from ClienteEntity;
delete from EmpleadoEntity;
delete from RegistroCompraEntity;
delete from AUTOMOVILENTITY;
delete from MODELOENTITY;
delete from MARCAENTITY;
delete from PuntoVentaEntity;

insert into PUNTOVENTAENTITY (id, direccion, TELEFONO, latitud, longitud, Nombre) values (1000, '643 Hanover Way', '(326) 3402306', -5.1443118, -38.0850339, 'GOODFELLAS-Calle 26');
insert into PUNTOVENTAENTITY (id, direccion, TELEFONO, latitud, longitud, Nombre) values (2000, '5896 Schurz Terrace', '(291) 3167263', 20.7491091, 106.3699271, 'GOODFELLAS - Av las americas');
insert into PUNTOVENTAENTITY (id, direccion, TELEFONO, latitud, longitud, Nombre) values (3000, '88063 Dawn Trail', '(366) 7081866', 5.586693, -74.2296713, 'GOODFELLAS- Andino');
insert into PUNTOVENTAENTITY (id, direccion, TELEFONO, latitud, longitud, Nombre) values (4000, '2590 Northland Crossing', '(606) 5177758', -14.16568, -72.658867, 'GOODFELLAS- Autonorte Cll. 134');
insert into PUNTOVENTAENTITY (id, direccion, TELEFONO, latitud, longitud, Nombre) values (5000, '2 Anhalt Way', '(182) 4659961', 29.731101, 116.251947, 'GOODFELLAS- Floresta');
insert into PUNTOVENTAENTITY (id, direccion, TELEFONO, latitud, longitud, Nombre) values (6000, '7816 Holy Cross Park', '(423) 5764086', 33.3437146, 130.6838866, 'GOODFELLAS - Iserra 100');
insert into PUNTOVENTAENTITY (id, direccion, TELEFONO, latitud, longitud, Nombre) values (7000, '058 Holmberg Lane', '(581) 9633962', 4.338952, -73.938919, 'GOODFELLAS -Gaymaral');
insert into PUNTOVENTAENTITY (id, direccion, TELEFONO, latitud, longitud, Nombre) values (8000, '452 Milwaukee Hill', '(413) 9735427', -18.0580139, 13.8361177, 'GOODFELLAS- Candelaria');
insert into PUNTOVENTAENTITY (id, direccion, TELEFONO, latitud, longitud, Nombre) values (9000, '452  Hill', '(456) 9735427', -18.0580139, 13.84551177, 'GOODFELLAS- Centro mayor');
insert into PUNTOVENTAENTITY (id, direccion, TELEFONO, latitud, longitud, Nombre) values (10000, '8778 Banding Avenue', '(771) 1211177', 15.187831, 120.057435,  'GOODFELLAS - NQS');


insert into MARCAENTITY (ID, DESCRIPCION, IMAGEN, NOMBREMARCA, LOGO) values (1000, 'Innovation that exites','https://i.ytimg.com/vi/YI7WaagSVE0/maxresdefault.jpg', 'Nissan', 'http://www.car-brand-names.com/wp-content/uploads/2015/08/Nissan-logo.png');
insert into MARCAENTITY (ID, DESCRIPCION, IMAGEN, NOMBREMARCA, logo) values (2000, 'We are professional grade ', 'https://www.gmc.com.mx/content/dam/gmc/na/mx/es/index/current-offers/01-images/gmc-offers-mh-lg.jpg?imwidth=1200', 'GMC', 'https://logos-coches.com/wp-content/uploads/2018/04/GMC-logo.png');
insert into MARCAENTITY (ID, DESCRIPCION, IMAGEN, NOMBREMARCA, LOGO) values (3000, 'Go Further', 'https://www.ford.com/cmslibs/content/dam/brand_ford/en_us/brand/campaigns/2019/bfp/BFP_Billboard_Desktop_Edge_2160x945.jpg/_jcr_content/renditions/cq5dam.web.1440.1440.jpeg', 'Ford', 'http://assets.stickpng.com/thumbs/580b585b2edbce24c47b2c67.png');
insert into MARCAENTITY (ID, DESCRIPCION, IMAGEN, NOMBREMARCA, LOGO) values (4000, 'There is no substitute', 'https://www.diariomotor.com/imagenes/picscache/1920x1600c/porsche-718-boxster-video_1920x1600c.jpg', 'Porsche', 'https://i.pinimg.com/originals/98/88/6b/98886b4f85abb7dff6587bdf424d2d9c.png');
insert into MARCAENTITY (ID, DESCRIPCION, IMAGEN, NOMBREMARCA, LOGO) values (5000, 'Lets Go Places', 'https://e00-marca.uecdn.es/assets/multimedia/imagenes/2017/11/04/15097995704823.jpg', 'Toyota', 'http://propertybeyond.com.au/wp-content/uploads/2015/08/toyota.png');
insert into MARCAENTITY (ID, DESCRIPCION, IMAGEN, NOMBREMARCA, LOGO) values (6000, 'Das Beste oder nichts', '../assets/Images/MERCEDES.jpg', 'Merdeces', 'https://logos-coches.com/wp-content/uploads/2018/04/Mercedes-Benz-logo.png');
insert into MARCAENTITY (ID, DESCRIPCION, IMAGEN, NOMBREMARCA, LOGO) values (7000, 'Excellence Through Passion', 'https://www.diariomotor.com/imagenes/picscache/1920x1600c/maserati_ghibli_ficha_0418_033_1920x1600c.jpg', 'Maserati','http://pngimg.com/uploads/maserati/maserati_PNG1.png');
insert into MARCAENTITY (ID, DESCRIPCION, IMAGEN, NOMBREMARCA, LOGO) values (8000, 'Varsprung durch Technik', '../assets/Images/AUDI.jpg', 'Audi', 'http://www.rentacarfloridacars.com/wp-content/uploads/2016/12/Audi-Logo-2013.png');
insert into MARCAENTITY (ID, DESCRIPCION, IMAGEN, NOMBREMARCA, LOGO) values (9000, 'The Ultimate Driving Machine', '../assets/Images/BMW.jpg', 'BMW', 'https://upload.wikimedia.org/wikipedia/commons/thumb/4/44/BMW.svg/1200px-BMW.svg.png');
insert into MARCAENTITY (ID, DESCRIPCION, IMAGEN, NOMBREMARCA, LOGO) values (10000, 'Jinba Ittai', 'https://cochesnuevos.autofacil.es/img/MAZDA_3_SEDAN_2019.jpg', 'Mazda', 'https://upload.wikimedia.org/wikipedia/nah/thumb/b/b1/Mazda_logo.png/640px-Mazda_logo.png');


insert into MARCAENTITY_PUNTOVENTAENTITY (PUNTOSVENTA_ID, MARCAS_ID) values (1000, 1000);
insert into MARCAENTITY_PUNTOVENTAENTITY (PUNTOSVENTA_ID, MARCAS_ID) values (1000, 8000);
insert into MARCAENTITY_PUNTOVENTAENTITY (PUNTOSVENTA_ID, MARCAS_ID) values (1000, 5000);

insert into MARCAENTITY_PUNTOVENTAENTITY (PUNTOSVENTA_ID, MARCAS_ID) values (2000, 2000);
insert into MARCAENTITY_PUNTOVENTAENTITY (PUNTOSVENTA_ID, MARCAS_ID) values (2000, 5000);
insert into MARCAENTITY_PUNTOVENTAENTITY (PUNTOSVENTA_ID, MARCAS_ID) values (2000, 7000);

insert into MARCAENTITY_PUNTOVENTAENTITY (PUNTOSVENTA_ID, MARCAS_ID) values (3000, 3000);
insert into MARCAENTITY_PUNTOVENTAENTITY (PUNTOSVENTA_ID, MARCAS_ID) values (3000, 10000);
insert into MARCAENTITY_PUNTOVENTAENTITY (PUNTOSVENTA_ID, MARCAS_ID) values (3000, 9000);

insert into MARCAENTITY_PUNTOVENTAENTITY (PUNTOSVENTA_ID, MARCAS_ID) values (4000, 4000);
insert into MARCAENTITY_PUNTOVENTAENTITY (PUNTOSVENTA_ID, MARCAS_ID) values (4000, 2000);
insert into MARCAENTITY_PUNTOVENTAENTITY (PUNTOSVENTA_ID, MARCAS_ID) values (4000, 7000);

insert into MARCAENTITY_PUNTOVENTAENTITY (PUNTOSVENTA_ID, MARCAS_ID) values (5000, 1000);
insert into MARCAENTITY_PUNTOVENTAENTITY (PUNTOSVENTA_ID, MARCAS_ID) values (5000, 5000);
insert into MARCAENTITY_PUNTOVENTAENTITY (PUNTOSVENTA_ID, MARCAS_ID) values (5000, 6000);

insert into MARCAENTITY_PUNTOVENTAENTITY (PUNTOSVENTA_ID, MARCAS_ID) values (6000, 1000);
insert into MARCAENTITY_PUNTOVENTAENTITY (PUNTOSVENTA_ID, MARCAS_ID) values (6000, 4000);
insert into MARCAENTITY_PUNTOVENTAENTITY (PUNTOSVENTA_ID, MARCAS_ID) values (6000, 2000);

insert into MARCAENTITY_PUNTOVENTAENTITY (PUNTOSVENTA_ID, MARCAS_ID) values (7000, 1000);
insert into MARCAENTITY_PUNTOVENTAENTITY (PUNTOSVENTA_ID, MARCAS_ID) values (7000, 6000);
insert into MARCAENTITY_PUNTOVENTAENTITY (PUNTOSVENTA_ID, MARCAS_ID) values (7000, 5000);

insert into MARCAENTITY_PUNTOVENTAENTITY (PUNTOSVENTA_ID, MARCAS_ID) values (8000, 1000);
insert into MARCAENTITY_PUNTOVENTAENTITY (PUNTOSVENTA_ID, MARCAS_ID) values (8000, 4000);
insert into MARCAENTITY_PUNTOVENTAENTITY (PUNTOSVENTA_ID, MARCAS_ID) values (8000, 10000);

insert into MARCAENTITY_PUNTOVENTAENTITY (PUNTOSVENTA_ID, MARCAS_ID) values (9000, 1000);
insert into MARCAENTITY_PUNTOVENTAENTITY (PUNTOSVENTA_ID, MARCAS_ID) values (9000, 2000);
insert into MARCAENTITY_PUNTOVENTAENTITY (PUNTOSVENTA_ID, MARCAS_ID) values (9000, 10000);

insert into MARCAENTITY_PUNTOVENTAENTITY (PUNTOSVENTA_ID, MARCAS_ID) values (10000, 1000);
insert into MARCAENTITY_PUNTOVENTAENTITY (PUNTOSVENTA_ID, MARCAS_ID) values (10000, 9000);
insert into MARCAENTITY_PUNTOVENTAENTITY (PUNTOSVENTA_ID, MARCAS_ID) values (10000, 3000);

INSERT INTO MODELOENTITY (ID,AIRBAG,AIREAC,ASIENTOS,CILINDRAJE,COMBUSTIBLE,DIRECCION,FRENOSABS,IMAGEN,NOMBRE,NUMEROPUERTAS,TRACCION,TRANSMISION,VIDRIOS,MARCA_ID) 
                            VALUES (1000,1,1,'Sintéticos',1600,
                            'Gasolina','Asistida',1, 'https://2.bp.blogspot.com/-crgHLYSfi64/VzxWduE9dzI/AAAAAAAACpQ/MUNeSMw7-aIO1zbKcS6e4Yi0q8j_cyGkACLcB/s1600/Nissan%2BR390%2BGT1.png',
                            'R390 GT1',3,'Total','Automática',
                            'Eléctricos',1000);

insert into MODELOENTITY (ID, NOMBRE, MARCA_ID, IMAGEN) values (2000, 'GT-R R32-R34', 1000, 'https://postmediadriving.files.wordpress.com/2019/04/chrome-image-402046.png?w=800&h=520&crop=1');
insert into MODELOENTITY (ID, NOMBRE, MARCA_ID, IMAGEN)  values (3000, 'Versa', 1000, 'https://st.motortrend.com/uploads/sites/10/2015/11/2010-nissan-versa-1.8-s-hatchback-angular-front.png');
insert into MODELOENTITY (ID, NOMBRE, MARCA_ID, IMAGEN)  values (4000, 'Juke-R', 1000,'https://st.motortrend.com/uploads/sites/10/2017/11/2012-nissan-juke-sv-fwd-cvt-suv-angular-front.png');
insert into MODELOENTITY (ID, NOMBRE, MARCA_ID, IMAGEN)  values (5000, 'Sentra', 1000, 'https://www.cstatic-images.com/car-pictures/xl/usc70nic061f121001.png');
insert into MODELOENTITY (ID, NOMBRE, MARCA_ID, IMAGEN)  values (6000, 'Terrain', 2000, 'https://i.imgur.com/gCXf21p.png');
insert into MODELOENTITY (ID, NOMBRE, MARCA_ID, IMAGEN)  values (7000, 'Terrain x', 2000,'https://s3.amazonaws.com/fzautomotive/dealers/59248987610a5.png');
insert into MODELOENTITY (ID, NOMBRE, MARCA_ID, IMAGEN)  values (8000, 'Acadia', 2000, 'https://di-uploads-pod2.dealerinspire.com/carlblackchevybuickgmckennesaw/uploads/2018/11/2019-GMC-Acadia-Model.png');
insert into MODELOENTITY (ID, NOMBRE, MARCA_ID, IMAGEN)  values (9000, 'Acadia Denali', 2000, 'https://crls.io/s/evox%2Fcolor_2400_032_png%2FMY2018%2F12378%2F12378_cc2400_032_GB8.png/feature/n/gmc-acadia.png');
insert into MODELOENTITY (ID, NOMBRE, MARCA_ID, IMAGEN)  values (10000, 'Canyon Denali', 2000, 'https://static.tcimg.net/vehicles/primary/8dd958ffdda18717/2019-GMC-Canyon-white-full_color-driver_side_front_quarter.png');
insert into MODELOENTITY (ID, NOMBRE, MARCA_ID, IMAGEN)  values (11000, 'Fiesta ST', 3000, 'https://www.ford.com/cmslibs/content/dam/vdm_ford/live/en_us/ford/nameplate/fiesta/2019/collections/adplanner/19_frd_fie_5dr_st_ospc_356x180.png/_jcr_content/renditions/cq5dam.web.1280.1280.png');
insert into MODELOENTITY (ID, NOMBRE, MARCA_ID, IMAGEN)  values (12000, 'Focus', 3000,'https://st.motortrend.ca/uploads/sites/10/2017/05/2017-ford-focus-titanium-sedan-angular-front.png');
insert into MODELOENTITY (ID, NOMBRE, MARCA_ID, IMAGEN)  values (13000, 'Explorer', 3000, 'https://di-uploads-pod14.dealerinspire.com/kingsford/uploads/2018/02/ford_explorer2018_red.png');
insert into MODELOENTITY (ID, NOMBRE, MARCA_ID, IMAGEN)  values (14000, 'Mustang', 3000, 'https://cloudflarestockimages.dealereprocess.com/resrc/images/stockphoto_asset-c_limit,f_auto,fl_lossy,w_700/v1/svp/Colors_PNG1280/2019/19ford/19fordmustangfastbkecocp6fa/ford_19mustangfastbkecocp6fa_angularfront_racered');
insert into MODELOENTITY (ID, NOMBRE, MARCA_ID, IMAGEN)  values (15000, 'Raptor', 3000, 'https://leie-autos.be/wp-content/uploads/2018/04/vehicle-4-2.png');
insert into MODELOENTITY (ID, NOMBRE, MARCA_ID, IMAGEN)  values (16000, '911 Carrera RS', 4000, 'https://postmediadriving.files.wordpress.com/2018/05/chrome-image-394157.png?w=800&h=520&crop=1');
insert into MODELOENTITY (ID, NOMBRE, MARCA_ID, IMAGEN)  values (17000, '718 GTS', 4000, 'https://img-s-msn-com.akamaized.net/tenant/amp/entityid/BBRSMkx.img?w=354&h=236&m=7');
insert into MODELOENTITY (ID, NOMBRE, MARCA_ID, IMAGEN)  values (18000, '911 g3t', 4000, 'https://di-uploads-pod15.dealerinspire.com/rusnakwestlakeporsche/uploads/2018/12/cc_2018PRC010017_01_640_G1-copy-1.png');
insert into MODELOENTITY (ID, NOMBRE, MARCA_ID, IMAGEN)  values (19000, ' 911 Speedster', 4000, 'https://www.cstatic-images.com/car-pictures/xl/usd00prc014a021001.png');
insert into MODELOENTITY (ID, NOMBRE, MARCA_ID, IMAGEN)  values (20000, 'Panamera GTS', 4000, 'https://www.cstatic-images.com/car-pictures/xl/USC30PRC102A021001.png');
insert into MODELOENTITY (ID, NOMBRE, MARCA_ID, IMAGEN)  values (21000, 'Carolla', 5000, 'https://www.cstatic-images.com/car-pictures/xl/usc70toc041g021001.png');
insert into MODELOENTITY (ID, NOMBRE, MARCA_ID, IMAGEN)  values (22000, 'Prius', 5000, 'https://www.howardsgroup.co.uk/assets/brands/toyota/prius/toyota-prius-new-blue%20(1).png');
insert into MODELOENTITY (ID, NOMBRE, MARCA_ID, IMAGEN)  values (23000, 'GT86', 5000, 'https://www.toyota-canarias.es/sites/default/files/2019-01/gt86_27_m7y_p2.png');
insert into MODELOENTITY (ID, NOMBRE, MARCA_ID, IMAGEN)  values (24000, 'Hilux', 5000, 'https://daltontoyota.com.mx/modelos/hilux/colors/01.png');
insert into MODELOENTITY (ID, NOMBRE, MARCA_ID, IMAGEN)  values (25000, 'Prado', 5000, 'https://www.toyota.com.co/wp-content/uploads/2018/03/Prado-Vx.png');
insert into MODELOENTITY (ID, NOMBRE, MARCA_ID, IMAGEN)  values (26000, 'Clase A', 6000, 'https://s3-us-west-2.amazonaws.com/static.izmocars.com/toolkit/commonassets/2019/19mercedesbenz/19mercedesbenzclasea/19mercedesbenzclasea_animations/_mxcolor/_570x380/mercedesbenz_19clasea_azulmardelsur.png');
insert into MODELOENTITY (ID, NOMBRE, MARCA_ID, IMAGEN)  values (27000, 'Clase E', 6000, 'https://s3-eu-west-1.amazonaws.com/maxterauto-assets/gamas/images_colours/color_cabecera-34-286-1746-545-1549369262.png');
insert into MODELOENTITY (ID, NOMBRE, MARCA_ID, IMAGEN)  values (28000, 'Clase CLS', 6000, 'https://www.arval.es/sites/es/files/media/mercedes_15c220bluetecsa_4b_lowaggressive_negro-estandar.png');
insert into MODELOENTITY (ID, NOMBRE, MARCA_ID, IMAGEN)  values (29000, 'AMG GT', 6000, 'https://www.cstatic-images.com/car-pictures/xl/usc80mbcar2b021001.png');
insert into MODELOENTITY (ID, NOMBRE, MARCA_ID, IMAGEN)  values (30000, 'GLE', 6000, 'https://automobile-assets.s3.amazonaws.com/automobile/body/mercedes-g-class-2018-2019-1542112553.86.png');
insert into MODELOENTITY (ID, NOMBRE, MARCA_ID, IMAGEN)  values (31000, 'Ghibli', 7000, 'https://st.motortrend.com/uploads/sites/10/2018/01/2018-maserati-ghibli-sedan-angular-front.png');
insert into MODELOENTITY (ID, NOMBRE, MARCA_ID, IMAGEN)  values (32000, 'Levante', 7000, 'https://www.mirenting.es/wp-content/uploads/2019/01/Levante-S-new-18-1.png.png');
insert into MODELOENTITY (ID, NOMBRE, MARCA_ID, IMAGEN)  values (33000, 'Quattroporte', 7000, 'https://bookluxurycar.com/listing_image/original/Maserati-GRANTURISMO-SPORT-car.png');
insert into MODELOENTITY (ID, NOMBRE, MARCA_ID, IMAGEN)  values (34000, 'GranTurismo', 7000, 'https://st.motortrend.com/uploads/sites/10/2015/11/2015-maserati-granturismo-sport-convertible-angular-front.png');
insert into MODELOENTITY (ID, NOMBRE, MARCA_ID, IMAGEN)  values (35000, 'GranCabrio', 7000, 'https://res.cloudinary.com/carsguide/image/upload/f_auto,fl_lossy,q_auto,t_cg_hero_low/v1/editorial/vhs/Maserati-GranCabrio.png');
insert into MODELOENTITY (ID, NOMBRE, MARCA_ID, IMAGEN)  values (36000, 'A4', 8000, 'https://www.levantewagen.es/uploads/cms/con_contenido/plataforma_2/02/44/61/images/A4.jpg');
insert into MODELOENTITY (ID, NOMBRE, MARCA_ID, IMAGEN)  values (37000, 'A5', 8000, 'https://img.sm360.ca/ir/w640h390c/images/newcar/ca/2019/audi/a5-sportback/komfort/coupe/exteriorColors/12018_cc0640_032_s9.png');
insert into MODELOENTITY (ID, NOMBRE, MARCA_ID, IMAGEN)  values (38000, 'Q8', 8000, 'https://pictures.dealer.com/s/schaumburgaudiaoa/0312/5b40989b3476db148c615c75b0b90590x.jpg');
insert into MODELOENTITY (ID, NOMBRE, MARCA_ID, IMAGEN)  values (39000, 'R8', 8000, 'https://postmediadriving.files.wordpress.com/2019/03/chrome-image-397953.png?w=800&h=520&crop=1');
insert into MODELOENTITY (ID, NOMBRE, MARCA_ID, IMAGEN)  values (40000, 'e-tron GT', 8000, 'https://img1.bitautoimg.com/autoalbum/files/20181206/090/0312150909_6.jpg');
insert into MODELOENTITY (ID, NOMBRE, MARCA_ID, IMAGEN)  values (41000, 'Serie 1', 9000, 'https://www.arval.es/sites/es/files/media/bmw_serie1_delantera.png');
insert into MODELOENTITY (ID, NOMBRE, MARCA_ID, IMAGEN)  values (42000, 'M2401', 9000, 'https://www.cstatic-images.com/car-pictures/xl/usc80bmc803a021001.png');
insert into MODELOENTITY (ID, NOMBRE, MARCA_ID, IMAGEN)  values (43000, 'X6', 9000, 'https://st.motortrend.com/uploads/sites/10/2016/12/2017-bmw-x6-sdrive35i-suv-angular-front.png');
insert into MODELOENTITY (ID, NOMBRE, MARCA_ID, IMAGEN)  values (44000, 'M3', 9000, 'https://st.motortrend.com/uploads/sites/10/2015/11/2015-bmw-m3-sedan-angular-front.png?interpolation=lanczos-none&fit=around|392:261');
insert into MODELOENTITY (ID, NOMBRE, MARCA_ID, IMAGEN)  values (45000, 'i8 Coupe ', 9000, 'https://cache.bmwusa.com/cosy.arox?pov=walkaround&brand=WBBI&vehicle=19IC&client=byo&paint=P0C23&fabric=FNGEK&sa=S027K,S0322,S0508,S0610&date=20180306&angle=330&quality=100&resp=png&BKGND=TRANSPARENT&SHARP=30&HEIGHT=24%25');
insert into MODELOENTITY (ID, NOMBRE, MARCA_ID, IMAGEN)  values (46000, 'Mazda 2', 10000, 'https://s3-ap-southeast-2.amazonaws.com/imotor-cms/images_cms/a2c3ca42-4022-4297-b360-7a55e5f18f3e.png');
insert into MODELOENTITY (ID, NOMBRE, MARCA_ID, IMAGEN)  values (47000, 'Mazda 3', 10000, 'http://www.mazdamonclova.com/img/autos/MZ3H18/versiones/MZMZ3H1801.png');
insert into MODELOENTITY (ID, NOMBRE, MARCA_ID, IMAGEN)  values (48000, 'Mazda 6', 10000, 'https://st.motortrend.com/uploads/sites/10/2018/06/2018-mazda-mazda6-grand-touring-reserve-sedan-angular-front.png');
insert into MODELOENTITY (ID, NOMBRE, MARCA_ID, IMAGEN)  values (49000, 'Mazda mx-5', 10000, 'https://www.mazda.com.au/globalassets/settings/vehicle-assets/mx-5/2018-09---ipm/roadster-gt/maz13777_mx-5_soft-top_2.0l_roadstergt_soulredcrystal_front_980x520_rgb.png');
insert into MODELOENTITY (ID, NOMBRE, MARCA_ID, IMAGEN)  values (50000, 'Mazda cx-5', 10000, 'https://www.mazda.co.nz/sites/default/files/MDZ3994_CX-5_GLX_Deep-Crystal-Blue_Front.png');


insert into AUTOMOVILENTITY (id,ANIO,COLOR,CUIDADMATRICULA,DISPONIBLE,IDCHASIS,MATRICULA,PRECIOVENTA,PUNTOVENTAID,RECORRIDO,REFERENCIA,TIPO,MODELO_ID)
                             VALUES (1000,2015,'Rojo','Bogotá',1,3256,'VGC-265',48000,1000,60,'','Camioneta',2000);
insert into AUTOMOVILENTITY (id,ANIO,COLOR,CUIDADMATRICULA,DISPONIBLE,IDCHASIS,MATRICULA,PRECIOVENTA,PUNTOVENTAID,RECORRIDO,REFERENCIA,TIPO,MODELO_ID)
                             VALUES (2000,2015,'Azul','Bogotá',1,1254,'HBT-236',70000,2000,10,'','Camioneta',3000);
insert into AUTOMOVILENTITY (id,ANIO,COLOR,CUIDADMATRICULA,DISPONIBLE,IDCHASIS,MATRICULA,PRECIOVENTA,PUNTOVENTAID,RECORRIDO,REFERENCIA,TIPO,MODELO_ID)
                             VALUES (3000,2015,'Dorado','Bogotá',1,5236,'CDR-265',30000,1000,16,'','Camioneta',2000);
insert into AUTOMOVILENTITY (id,ANIO,COLOR,CUIDADMATRICULA,DISPONIBLE,IDCHASIS,MATRICULA,PRECIOVENTA,PUNTOVENTAID,RECORRIDO,REFERENCIA,TIPO,MODELO_ID)
                             VALUES (4000,2015,'Gris','Bogotá',1,6594,'VGC-696',36000,2000,35,'','Camioneta',2000);


insert into AUTOMOVILENTITY (ID, ANIO, COLOR, CUIDADMATRICULA, MATRICULA, PUNTOVENTAID, MODELO_ID) values (5000, 2009, 'Goldenrod', 'Drien Rampak', 'MYS-437', 9000, 40000);
insert into AUTOMOVILENTITY (ID, ANIO, COLOR, CUIDADMATRICULA, MATRICULA, PUNTOVENTAID, MODELO_ID) values (6000, 1993, 'Red', 'Dengyue', 'DZU-172', 2000, 28000);
insert into AUTOMOVILENTITY (ID, ANIO, COLOR, CUIDADMATRICULA, MATRICULA, PUNTOVENTAID, MODELO_ID) values (7000, 1991, 'Teal', 'Sanxiang', 'KZQ-909', 3000, 36000);
insert into AUTOMOVILENTITY (ID, ANIO, COLOR, CUIDADMATRICULA, MATRICULA, PUNTOVENTAID, MODELO_ID) values (8000, 1990, 'Green', 'Tangjiapo', 'NVF-463', 3000, 39000);
insert into AUTOMOVILENTITY (ID, ANIO, COLOR, CUIDADMATRICULA, MATRICULA, PUNTOVENTAID, MODELO_ID) values (9000, 2001, 'Indigo', 'Gaula', 'TYW-194', 3000, 50000);
insert into AUTOMOVILENTITY (ID, ANIO, COLOR, CUIDADMATRICULA, MATRICULA, PUNTOVENTAID, MODELO_ID) values (10000, 1997, 'Mauv', 'Peddie', 'PPB-373', 8000, 16000);
insert into AUTOMOVILENTITY (ID, ANIO, COLOR, CUIDADMATRICULA, MATRICULA, PUNTOVENTAID, MODELO_ID) values (11000, 2009, 'Fuscia', 'Rockford', 'GJZ-670', 1000, 34000);
insert into AUTOMOVILENTITY (ID, ANIO, COLOR, CUIDADMATRICULA, MATRICULA, PUNTOVENTAID, MODELO_ID) values (12000, 2002, 'Puce', 'Pankshin', 'HYZ-060', 6000, 8000);
insert into AUTOMOVILENTITY (ID, ANIO, COLOR, CUIDADMATRICULA, MATRICULA, PUNTOVENTAID, MODELO_ID) values (13000, 1995, 'Aquamarine', 'Jianshan', 'XXP-796', 4000, 7000);
insert into AUTOMOVILENTITY (ID, ANIO, COLOR, CUIDADMATRICULA, MATRICULA, PUNTOVENTAID, MODELO_ID) values (14000, 2001, 'Red', 'Hetai', 'CKM-788', 6000, 44000);
insert into AUTOMOVILENTITY (ID, ANIO, COLOR, CUIDADMATRICULA, MATRICULA, PUNTOVENTAID, MODELO_ID) values (15000, 1997, 'Green', 'Syrostan', 'HEX-716', 6000, 3000);
insert into AUTOMOVILENTITY (ID, ANIO, COLOR, CUIDADMATRICULA, MATRICULA, PUNTOVENTAID, MODELO_ID) values (16000, 2012, 'Orange', 'Ash Shaykh ‘Uthmān', 'JLV-605', 6000, 4000);
insert into AUTOMOVILENTITY (ID, ANIO, COLOR, CUIDADMATRICULA, MATRICULA, PUNTOVENTAID, MODELO_ID) values (17000, 2002, 'Puce', 'Welisara', 'DKI-144', 1000, 22000);
insert into AUTOMOVILENTITY (ID, ANIO, COLOR, CUIDADMATRICULA, MATRICULA, PUNTOVENTAID, MODELO_ID) values (18000, 1992, 'Blue', 'Francisco Villa', 'URB-827', 10000, 43000);
insert into AUTOMOVILENTITY (ID, ANIO, COLOR, CUIDADMATRICULA, MATRICULA, PUNTOVENTAID, MODELO_ID) values (19000, 1994, 'Orange', 'Kyperoúnta', 'DBE-183', 1000, 25000);
insert into AUTOMOVILENTITY (ID, ANIO, COLOR, CUIDADMATRICULA, MATRICULA, PUNTOVENTAID, MODELO_ID) values (20000, 1995, 'Aquamarine', 'Abelheira', 'PDB-925', 3000, 19000);
insert into AUTOMOVILENTITY (ID, ANIO, COLOR, CUIDADMATRICULA, MATRICULA, PUNTOVENTAID, MODELO_ID) values (21000, 1996, 'Red', 'Cibatu', 'HDE-943', 10000, 27000);
insert into AUTOMOVILENTITY (ID, ANIO, COLOR, CUIDADMATRICULA, MATRICULA, PUNTOVENTAID, MODELO_ID) values (22000, 1996, 'Indigo', 'Agoo', 'GUH-193', 9000, 7000);
insert into AUTOMOVILENTITY (ID, ANIO, COLOR, CUIDADMATRICULA, MATRICULA, PUNTOVENTAID, MODELO_ID) values (23000, 2008, 'Green', 'Santa Cruz La Laguna', 'WQD-905', 6000, 29000);
insert into AUTOMOVILENTITY (ID, ANIO, COLOR, CUIDADMATRICULA, MATRICULA, PUNTOVENTAID, MODELO_ID) values (24000, 2005, 'Yellow', 'Tonota', 'KYO-932', 9000, 34000);
insert into AUTOMOVILENTITY (ID, ANIO, COLOR, CUIDADMATRICULA, MATRICULA, PUNTOVENTAID, MODELO_ID) values (25000, 2003, 'Goldenrod', 'Amsterdam Noord west', 'EXI-104', 5000, 48000);
insert into AUTOMOVILENTITY (ID, ANIO, COLOR, CUIDADMATRICULA, MATRICULA, PUNTOVENTAID, MODELO_ID) values (26000, 2008, 'Crimson', 'Yongding', 'ZUR-933', 2000, 39000);
insert into AUTOMOVILENTITY (ID, ANIO, COLOR, CUIDADMATRICULA, MATRICULA, PUNTOVENTAID, MODELO_ID) values (27000, 2009, 'Green', 'Várzea', 'UUI-419', 4000, 11000);
insert into AUTOMOVILENTITY (ID, ANIO, COLOR, CUIDADMATRICULA, MATRICULA, PUNTOVENTAID, MODELO_ID) values (28000, 1997, 'Aquamarine', 'Zhaocun', 'OYE-367', 1000, 46000);
insert into AUTOMOVILENTITY (ID, ANIO, COLOR, CUIDADMATRICULA, MATRICULA, PUNTOVENTAID, MODELO_ID) values (29000, 1996, 'Blue', 'Xinsheng', 'HLA-979', 5000, 18000);
insert into AUTOMOVILENTITY (ID, ANIO, COLOR, CUIDADMATRICULA, MATRICULA, PUNTOVENTAID, MODELO_ID) values (30000, 2011, 'Blue', 'Maguan', 'NVG-766', 1000, 1000);
insert into AUTOMOVILENTITY (ID, ANIO, COLOR, CUIDADMATRICULA, MATRICULA, PUNTOVENTAID, MODELO_ID) values (31000, 1992, 'Puce', 'Крушево', 'UXR-540', 6000, 19000);
insert into AUTOMOVILENTITY (ID, ANIO, COLOR, CUIDADMATRICULA, MATRICULA, PUNTOVENTAID, MODELO_ID) values (32000, 2002, 'Turquoise', 'Aviúges', 'ZPB-072', 2000, 1000);
insert into AUTOMOVILENTITY (ID, ANIO, COLOR, CUIDADMATRICULA, MATRICULA, PUNTOVENTAID, MODELO_ID) values (33000, 1994, 'Fuscia', 'Timoulilt', 'FTE-438', 2000, 47000);
insert into AUTOMOVILENTITY (ID, ANIO, COLOR, CUIDADMATRICULA, MATRICULA, PUNTOVENTAID, MODELO_ID) values (34000, 2002, 'Blue', 'Zaragoza', 'JHD-077', 4000, 26000);
insert into AUTOMOVILENTITY (ID, ANIO, COLOR, CUIDADMATRICULA, MATRICULA, PUNTOVENTAID, MODELO_ID) values (35000, 2009, 'Red', 'Ovacik', 'AFM-522', 9000, 29000);
insert into AUTOMOVILENTITY (ID, ANIO, COLOR, CUIDADMATRICULA, MATRICULA, PUNTOVENTAID, MODELO_ID) values (36000, 2013, 'Khaki', 'Taizi', 'IKB-574', 9000, 8000);
insert into AUTOMOVILENTITY (ID, ANIO, COLOR, CUIDADMATRICULA, MATRICULA, PUNTOVENTAID, MODELO_ID) values (37000, 1993, 'Blue', 'Staraya Russa', 'ULX-808', 3000, 22000);
insert into AUTOMOVILENTITY (ID, ANIO, COLOR, CUIDADMATRICULA, MATRICULA, PUNTOVENTAID, MODELO_ID) values (38000, 1989, 'Blue', 'Zhanping', 'KYA-667', 5000, 44000);
insert into AUTOMOVILENTITY (ID, ANIO, COLOR, CUIDADMATRICULA, MATRICULA, PUNTOVENTAID, MODELO_ID) values (39000, 1998, 'Goldenrod', 'Fier-Çifçi', 'HVH-891', 9000, 38000);
insert into AUTOMOVILENTITY (ID, ANIO, COLOR, CUIDADMATRICULA, MATRICULA, PUNTOVENTAID, MODELO_ID) values (40000, 2008, 'Yellow', 'Quebo', 'WPG-287', 10000, 13000);
insert into AUTOMOVILENTITY (ID, ANIO, COLOR, CUIDADMATRICULA, MATRICULA, PUNTOVENTAID, MODELO_ID) values (41000, 1993, 'Blue', 'Nantang', 'QVD-235', 8000, 11000);
insert into AUTOMOVILENTITY (ID, ANIO, COLOR, CUIDADMATRICULA, MATRICULA, PUNTOVENTAID, MODELO_ID) values (42000, 2011, 'Crimson', 'Haikou', 'DQX-755', 1000, 19000);
insert into AUTOMOVILENTITY (ID, ANIO, COLOR, CUIDADMATRICULA, MATRICULA, PUNTOVENTAID, MODELO_ID) values (43000, 2004, 'Crimson', 'Opinogóra Górna', 'NAL-485', 3000, 12000);
insert into AUTOMOVILENTITY (ID, ANIO, COLOR, CUIDADMATRICULA, MATRICULA, PUNTOVENTAID, MODELO_ID) values (44000, 2011, 'Khaki', 'Capitão Poço', 'SYW-482', 7000, 4000);
insert into AUTOMOVILENTITY (ID, ANIO, COLOR, CUIDADMATRICULA, MATRICULA, PUNTOVENTAID, MODELO_ID) values (45000, 1996, 'Goldenrod', 'West Kelowna', 'XMV-555', 5000, 47000);
insert into AUTOMOVILENTITY (ID, ANIO, COLOR, CUIDADMATRICULA, MATRICULA, PUNTOVENTAID, MODELO_ID) values (46000, 1992, 'Aquamarine', 'Drachten', 'EKR-525', 10000, 49000);
insert into AUTOMOVILENTITY (ID, ANIO, COLOR, CUIDADMATRICULA, MATRICULA, PUNTOVENTAID, MODELO_ID) values (47000, 2009, 'Maroon', 'Mikhaylovsk', 'NDL-524', 10000, 34000);
insert into AUTOMOVILENTITY (ID, ANIO, COLOR, CUIDADMATRICULA, MATRICULA, PUNTOVENTAID, MODELO_ID) values (48000, 1985, 'Teal', 'Xibin', 'PMO-426', 4000, 20000);
insert into AUTOMOVILENTITY (ID, ANIO, COLOR, CUIDADMATRICULA, MATRICULA, PUNTOVENTAID, MODELO_ID) values (49000, 2007, 'Mauv', 'Taungoo', 'IFS-976', 4000, 48000);
insert into AUTOMOVILENTITY (ID, ANIO, COLOR, CUIDADMATRICULA, MATRICULA, PUNTOVENTAID, MODELO_ID) values (50000, 2010, 'Yellow', 'Qiziltepa Shahri', 'SMY-754', 7000, 1000);
insert into AUTOMOVILENTITY (ID, ANIO, COLOR, CUIDADMATRICULA, MATRICULA, PUNTOVENTAID, MODELO_ID) values (51000, 2000, 'Pink', 'Pordapor Barat', 'ECY-581', 1000, 7000);
insert into AUTOMOVILENTITY (ID, ANIO, COLOR, CUIDADMATRICULA, MATRICULA, PUNTOVENTAID, MODELO_ID) values (52000, 2002, 'Orange', 'Jiantou', 'WGV-389', 5000, 19000);
insert into AUTOMOVILENTITY (ID, ANIO, COLOR, CUIDADMATRICULA, MATRICULA, PUNTOVENTAID, MODELO_ID) values (53000, 2008, 'Green', 'Al Ghandūrah', 'IBR-677', 9000, 36000);
insert into AUTOMOVILENTITY (ID, ANIO, COLOR, CUIDADMATRICULA, MATRICULA, PUNTOVENTAID, MODELO_ID) values (54000, 2002, 'Aquamarine', 'Poxi', 'IAY-053', 4000, 45000);
insert into AUTOMOVILENTITY (ID, ANIO, COLOR, CUIDADMATRICULA, MATRICULA, PUNTOVENTAID, MODELO_ID) values (55000, 1993, 'Maroon', 'Xinning', 'LVF-460', 4000, 45000);
insert into AUTOMOVILENTITY (ID, ANIO, COLOR, CUIDADMATRICULA, MATRICULA, PUNTOVENTAID, MODELO_ID) values (56000, 1959, 'Purple', 'Aime', 'ESN-382', 10000, 3000);
insert into AUTOMOVILENTITY (ID, ANIO, COLOR, CUIDADMATRICULA, MATRICULA, PUNTOVENTAID, MODELO_ID) values (57000, 1989, 'Goldenrod', 'Siwa Oasis', 'CYD-941', 1000, 15000);
insert into AUTOMOVILENTITY (ID, ANIO, COLOR, CUIDADMATRICULA, MATRICULA, PUNTOVENTAID, MODELO_ID) values (58000, 2004, 'Green', 'Belo Oriente', 'IAC-691', 9000, 21000);
insert into AUTOMOVILENTITY (ID, ANIO, COLOR, CUIDADMATRICULA, MATRICULA, PUNTOVENTAID, MODELO_ID) values (59000, 2000, 'Khaki', 'Mozelos', 'THS-227', 8000, 15000);
insert into AUTOMOVILENTITY (ID, ANIO, COLOR, CUIDADMATRICULA, MATRICULA, PUNTOVENTAID, MODELO_ID) values (60000, 2012, 'Crimson', 'Skomlin', 'GKX-469', 1000, 46000);
insert into AUTOMOVILENTITY (ID, ANIO, COLOR, CUIDADMATRICULA, MATRICULA, PUNTOVENTAID, MODELO_ID) values (61000, 2003, 'Mauv', 'Bairro do Margaça', 'IZG-999', 7000, 20000);
insert into AUTOMOVILENTITY (ID, ANIO, COLOR, CUIDADMATRICULA, MATRICULA, PUNTOVENTAID, MODELO_ID) values (62000, 1982, 'Teal', 'Kendung Timur', 'LLR-216', 7000, 41000);
insert into AUTOMOVILENTITY (ID, ANIO, COLOR, CUIDADMATRICULA, MATRICULA, PUNTOVENTAID, MODELO_ID) values (63000, 1993, 'Yellow', 'Giporlos', 'RTK-271', 2000, 23000);
insert into AUTOMOVILENTITY (ID, ANIO, COLOR, CUIDADMATRICULA, MATRICULA, PUNTOVENTAID, MODELO_ID) values (64000, 2003, 'Puce', 'Dumbéa', 'KBS-714', 2000, 23000);
insert into AUTOMOVILENTITY (ID, ANIO, COLOR, CUIDADMATRICULA, MATRICULA, PUNTOVENTAID, MODELO_ID) values (65000, 2011, 'Mauv', 'Chernivtsi', 'HMT-116', 8000, 16000);
insert into AUTOMOVILENTITY (ID, ANIO, COLOR, CUIDADMATRICULA, MATRICULA, PUNTOVENTAID, MODELO_ID) values (66000, 1998, 'Turquoise', 'Nagbalaye', 'LMP-452', 1000, 46000);
insert into AUTOMOVILENTITY (ID, ANIO, COLOR, CUIDADMATRICULA, MATRICULA, PUNTOVENTAID, MODELO_ID) values (67000, 2000, 'Violet', 'Mangochi', 'SBG-103', 4000, 25000);
insert into AUTOMOVILENTITY (ID, ANIO, COLOR, CUIDADMATRICULA, MATRICULA, PUNTOVENTAID, MODELO_ID) values (68000, 1993, 'Maroon', 'Alabat', 'WRF-862', 2000, 31000);
insert into AUTOMOVILENTITY (ID, ANIO, COLOR, CUIDADMATRICULA, MATRICULA, PUNTOVENTAID, MODELO_ID) values (69000, 2002, 'Puce', 'Donnacona', 'XAU-351', 2000, 9000);
insert into AUTOMOVILENTITY (ID, ANIO, COLOR, CUIDADMATRICULA, MATRICULA, PUNTOVENTAID, MODELO_ID) values (70000, 2009, 'Orange', 'Santa Cruz Muluá', 'YII-809', 8000, 24000);
insert into AUTOMOVILENTITY (ID, ANIO, COLOR, CUIDADMATRICULA, MATRICULA, PUNTOVENTAID, MODELO_ID) values (71000, 2000, 'Violet', 'Bangshipu', 'RAQ-031', 4000, 4000);
insert into AUTOMOVILENTITY (ID, ANIO, COLOR, CUIDADMATRICULA, MATRICULA, PUNTOVENTAID, MODELO_ID) values (72000, 1993, 'Blue', 'Estrada', 'FOU-453', 4000, 48000);
insert into AUTOMOVILENTITY (ID, ANIO, COLOR, CUIDADMATRICULA, MATRICULA, PUNTOVENTAID, MODELO_ID) values (73000, 2006, 'Yellow', 'Fulin', 'CDQ-844', 6000, 2000);
insert into AUTOMOVILENTITY (ID, ANIO, COLOR, CUIDADMATRICULA, MATRICULA, PUNTOVENTAID, MODELO_ID) values (74000, 1997, 'Puce', 'Dampit', 'BEJ-899', 6000, 43000);
insert into AUTOMOVILENTITY (ID, ANIO, COLOR, CUIDADMATRICULA, MATRICULA, PUNTOVENTAID, MODELO_ID) values (75000, 1991, 'Aquamarine', 'Osasco', 'QZD-225', 2000, 40000);
insert into AUTOMOVILENTITY (ID, ANIO, COLOR, CUIDADMATRICULA, MATRICULA, PUNTOVENTAID, MODELO_ID) values (76000, 2011, 'Green', 'Lebak', 'ALP-823', 9000, 34000);
insert into AUTOMOVILENTITY (ID, ANIO, COLOR, CUIDADMATRICULA, MATRICULA, PUNTOVENTAID, MODELO_ID) values (77000, 1992, 'Pink', 'Chełm', 'PPJ-611', 2000, 32000);
insert into AUTOMOVILENTITY (ID, ANIO, COLOR, CUIDADMATRICULA, MATRICULA, PUNTOVENTAID, MODELO_ID) values (78000, 2003, 'Khaki', 'Mboursou Léré', 'FFQ-016', 1000, 24000);
insert into AUTOMOVILENTITY (ID, ANIO, COLOR, CUIDADMATRICULA, MATRICULA, PUNTOVENTAID, MODELO_ID) values (79000, 1997, 'Orange', 'Xin’an', 'QLD-828', 1000, 8000);
insert into AUTOMOVILENTITY (ID, ANIO, COLOR, CUIDADMATRICULA, MATRICULA, PUNTOVENTAID, MODELO_ID) values (80000, 1989, 'Goldenrod', 'Hushan', 'DZS-592', 4000, 11000);
insert into AUTOMOVILENTITY (ID, ANIO, COLOR, CUIDADMATRICULA, MATRICULA, PUNTOVENTAID, MODELO_ID) values (81000, 1992, 'Yellow', 'Čajniče', 'WMH-906', 8000, 46000);
insert into AUTOMOVILENTITY (ID, ANIO, COLOR, CUIDADMATRICULA, MATRICULA, PUNTOVENTAID, MODELO_ID) values (82000, 2008, 'Turquoise', 'Kuala Lumpur', 'ARC-054', 9000, 45000);
insert into AUTOMOVILENTITY (ID, ANIO, COLOR, CUIDADMATRICULA, MATRICULA, PUNTOVENTAID, MODELO_ID) values (83000, 1993, 'Turquoise', 'Lakbok', 'QKJ-944', 7000, 21000);
insert into AUTOMOVILENTITY (ID, ANIO, COLOR, CUIDADMATRICULA, MATRICULA, PUNTOVENTAID, MODELO_ID) values (84000, 2012, 'Crimson', 'Mobile', 'DZY-215', 9000, 31000);
insert into AUTOMOVILENTITY (ID, ANIO, COLOR, CUIDADMATRICULA, MATRICULA, PUNTOVENTAID, MODELO_ID) values (85000, 1985, 'Green', 'Matinha', 'COM-187', 3000, 50000);
insert into AUTOMOVILENTITY (ID, ANIO, COLOR, CUIDADMATRICULA, MATRICULA, PUNTOVENTAID, MODELO_ID) values (86000, 1987, 'Aquamarine', 'Ouagadougou', 'CFI-381', 7000, 2000);
insert into AUTOMOVILENTITY (ID, ANIO, COLOR, CUIDADMATRICULA, MATRICULA, PUNTOVENTAID, MODELO_ID) values (87000, 2006, 'Teal', 'Mirny', 'ZCK-659', 10000, 41000);
insert into AUTOMOVILENTITY (ID, ANIO, COLOR, CUIDADMATRICULA, MATRICULA, PUNTOVENTAID, MODELO_ID) values (88000, 1998, 'Mauv', 'Novhorodka', 'RJF-856', 7000, 28000);
insert into AUTOMOVILENTITY (ID, ANIO, COLOR, CUIDADMATRICULA, MATRICULA, PUNTOVENTAID, MODELO_ID) values (89000, 2009, 'Violet', 'Malitbog', 'WSZ-768', 1000, 38000);
insert into AUTOMOVILENTITY (ID, ANIO, COLOR, CUIDADMATRICULA, MATRICULA, PUNTOVENTAID, MODELO_ID) values (90000, 2009, 'Indigo', 'Acheng', 'PON-698', 4000, 17000);
insert into AUTOMOVILENTITY (ID, ANIO, COLOR, CUIDADMATRICULA, MATRICULA, PUNTOVENTAID, MODELO_ID) values (91000, 2010, 'Blue', 'Verkhnya Rozhanka', 'CYP-476', 7000, 12000);
insert into AUTOMOVILENTITY (ID, ANIO, COLOR, CUIDADMATRICULA, MATRICULA, PUNTOVENTAID, MODELO_ID) values (92000, 2003, 'Red', 'Lubukgadang', 'BEF-728', 8000, 33000);
insert into AUTOMOVILENTITY (ID, ANIO, COLOR, CUIDADMATRICULA, MATRICULA, PUNTOVENTAID, MODELO_ID) values (93000, 1993, 'Puce', 'Ghayl Bā Wazīr', 'FUG-600', 9000, 27000);
insert into AUTOMOVILENTITY (ID, ANIO, COLOR, CUIDADMATRICULA, MATRICULA, PUNTOVENTAID, MODELO_ID) values (94000, 1987, 'Pink', 'Zhigulevsk', 'WUJ-842', 3000, 2000);
insert into AUTOMOVILENTITY (ID, ANIO, COLOR, CUIDADMATRICULA, MATRICULA, PUNTOVENTAID, MODELO_ID) values (95000, 2000, 'Aquamarine', 'Yangtan', 'QFN-267', 10000, 49000);
insert into AUTOMOVILENTITY (ID, ANIO, COLOR, CUIDADMATRICULA, MATRICULA, PUNTOVENTAID, MODELO_ID) values (96000, 2000, 'Fuscia', 'Karlstad', 'MSK-183', 6000, 10000);
insert into AUTOMOVILENTITY (ID, ANIO, COLOR, CUIDADMATRICULA, MATRICULA, PUNTOVENTAID, MODELO_ID) values (97000, 1987, 'Orange', 'Shiye', 'PNA-431', 6000, 13000);
insert into AUTOMOVILENTITY (ID, ANIO, COLOR, CUIDADMATRICULA, MATRICULA, PUNTOVENTAID, MODELO_ID) values (98000, 2008, 'Orange', 'Zapala', 'ICD-898', 5000, 32000);
insert into AUTOMOVILENTITY (ID, ANIO, COLOR, CUIDADMATRICULA, MATRICULA, PUNTOVENTAID, MODELO_ID) values (99000, 2003, 'Crimson', 'Kikinda', 'UAO-356', 7000, 41000);
insert into AUTOMOVILENTITY (ID, ANIO, COLOR, CUIDADMATRICULA, MATRICULA, PUNTOVENTAID, MODELO_ID) values (100000, 1989, 'Yellow', 'Basel', 'HWD-695', 10000, 12000);


insert into REGISTROCOMPRAENTITY (id, AUTOMOVIL_ID, FECHACOMPRA, NOMBREVENDEDOR, PRECIOCOMPRADO, PUNTOVENTA_ID) values (1000,1000, '6/7/2018', 'Ailsun Jencey', 6502, 7000);
insert into REGISTROCOMPRAENTITY (id, AUTOMOVIL_ID, FECHACOMPRA, NOMBREVENDEDOR, PRECIOCOMPRADO, PUNTOVENTA_ID) values (2000,2000, '9/18/2018', 'Hakim O''Kynsillaghe', 8232, 10000);
insert into REGISTROCOMPRAENTITY (id, AUTOMOVIL_ID, FECHACOMPRA, NOMBREVENDEDOR, PRECIOCOMPRADO, PUNTOVENTA_ID) values (3000,3000, '6/4/2018', 'Davida Poulden', 3750, 8000);
insert into REGISTROCOMPRAENTITY (id, AUTOMOVIL_ID, FECHACOMPRA, NOMBREVENDEDOR, PRECIOCOMPRADO, PUNTOVENTA_ID) values (4000,4000, '6/24/2018', 'Maren Pulteneye', 4568, 1000);
insert into REGISTROCOMPRAENTITY (id, AUTOMOVIL_ID, FECHACOMPRA, NOMBREVENDEDOR, PRECIOCOMPRADO, PUNTOVENTA_ID) values (5000,5000, '3/22/2019', 'Elston Pickersail', 2267, 4000);
insert into REGISTROCOMPRAENTITY (id, AUTOMOVIL_ID, FECHACOMPRA, NOMBREVENDEDOR, PRECIOCOMPRADO, PUNTOVENTA_ID) values (6000,6000, '5/8/2018', 'Mallorie Quaife', 2313, 6000);
insert into REGISTROCOMPRAENTITY (id, AUTOMOVIL_ID, FECHACOMPRA, NOMBREVENDEDOR, PRECIOCOMPRADO, PUNTOVENTA_ID) values (7000,7000, '5/2/2019', 'Sibyl Bax', 7432, 10000);
insert into REGISTROCOMPRAENTITY (id, AUTOMOVIL_ID, FECHACOMPRA, NOMBREVENDEDOR, PRECIOCOMPRADO, PUNTOVENTA_ID) values (8000,8000, '9/18/2018', 'Wilmette Spyer', 3549, 10000);
insert into REGISTROCOMPRAENTITY (id, AUTOMOVIL_ID, FECHACOMPRA, NOMBREVENDEDOR, PRECIOCOMPRADO, PUNTOVENTA_ID) values (9000,9000, '12/19/2018', 'Dyna Blandamere', 8571, 3000);
insert into REGISTROCOMPRAENTITY (id, AUTOMOVIL_ID, FECHACOMPRA, NOMBREVENDEDOR, PRECIOCOMPRADO, PUNTOVENTA_ID) values (10000,10000, '4/20/2019', 'Rance Bernardino', 1045, 2000);
insert into REGISTROCOMPRAENTITY (id, AUTOMOVIL_ID, FECHACOMPRA, NOMBREVENDEDOR, PRECIOCOMPRADO, PUNTOVENTA_ID) values (11000,11000, '8/20/2018', 'Syman Heppner', 8323, 10000);
insert into REGISTROCOMPRAENTITY (id, AUTOMOVIL_ID, FECHACOMPRA, NOMBREVENDEDOR, PRECIOCOMPRADO, PUNTOVENTA_ID) values (12000,12000, '5/26/2018', 'Debee Nance', 8568, 5000);
insert into REGISTROCOMPRAENTITY (id, AUTOMOVIL_ID, FECHACOMPRA, NOMBREVENDEDOR, PRECIOCOMPRADO, PUNTOVENTA_ID) values (13000,13000, '7/10/2018', 'Teddie Baltzar', 7983, 5000);
insert into REGISTROCOMPRAENTITY (id, AUTOMOVIL_ID, FECHACOMPRA, NOMBREVENDEDOR, PRECIOCOMPRADO, PUNTOVENTA_ID) values (14000,14000, '7/17/2018', 'Candide McGuane', 3072, 3000);
insert into REGISTROCOMPRAENTITY (id, AUTOMOVIL_ID, FECHACOMPRA, NOMBREVENDEDOR, PRECIOCOMPRADO, PUNTOVENTA_ID) values (15000,15000, '2/10/2019', 'Sharai Gerling', 7956, 1000);
insert into REGISTROCOMPRAENTITY (id, AUTOMOVIL_ID, FECHACOMPRA, NOMBREVENDEDOR, PRECIOCOMPRADO, PUNTOVENTA_ID) values (16000,16000, '10/17/2018', 'Trixie Rotter', 6332, 7000);
insert into REGISTROCOMPRAENTITY (id, AUTOMOVIL_ID, FECHACOMPRA, NOMBREVENDEDOR, PRECIOCOMPRADO, PUNTOVENTA_ID) values (17000,17000, '10/4/2018', 'Rosalind Maddrah', 2315, 8000);
insert into REGISTROCOMPRAENTITY (id, AUTOMOVIL_ID, FECHACOMPRA, NOMBREVENDEDOR, PRECIOCOMPRADO, PUNTOVENTA_ID) values (18000,18000, '1/20/2019', 'Livvyy Vian', 5257, 4000);
insert into REGISTROCOMPRAENTITY (id, AUTOMOVIL_ID, FECHACOMPRA, NOMBREVENDEDOR, PRECIOCOMPRADO, PUNTOVENTA_ID) values (19000,19000, '10/29/2018', 'Viviene Croucher', 3840, 10000);
insert into REGISTROCOMPRAENTITY (id, AUTOMOVIL_ID, FECHACOMPRA, NOMBREVENDEDOR, PRECIOCOMPRADO, PUNTOVENTA_ID) values (20000,20000, '4/19/2019', 'Sarene Dahlbom', 5824, 7000);
insert into REGISTROCOMPRAENTITY (id, AUTOMOVIL_ID, FECHACOMPRA, NOMBREVENDEDOR, PRECIOCOMPRADO, PUNTOVENTA_ID) values (21000,21000, '8/28/2018', 'Kati Tattershall', 5017, 7000);
insert into REGISTROCOMPRAENTITY (id, AUTOMOVIL_ID, FECHACOMPRA, NOMBREVENDEDOR, PRECIOCOMPRADO, PUNTOVENTA_ID) values (22000,22000, '7/23/2018', 'Sanders Hearons', 5696, 5000);
insert into REGISTROCOMPRAENTITY (id, AUTOMOVIL_ID, FECHACOMPRA, NOMBREVENDEDOR, PRECIOCOMPRADO, PUNTOVENTA_ID) values (23000,23000, '1/14/2019', 'Jerri Hasling', 3083, 4000);
insert into REGISTROCOMPRAENTITY (id, AUTOMOVIL_ID, FECHACOMPRA, NOMBREVENDEDOR, PRECIOCOMPRADO, PUNTOVENTA_ID) values (24000,24000, '3/8/2019', 'Addie Muscroft', 5707, 6000);
insert into REGISTROCOMPRAENTITY (id, AUTOMOVIL_ID, FECHACOMPRA, NOMBREVENDEDOR, PRECIOCOMPRADO, PUNTOVENTA_ID) values (25000,25000, '8/9/2018', 'Josepha Poat', 1552, 5000);
insert into REGISTROCOMPRAENTITY (id, AUTOMOVIL_ID, FECHACOMPRA, NOMBREVENDEDOR, PRECIOCOMPRADO, PUNTOVENTA_ID) values (26000,26000, '3/13/2019', 'Angel Jerzak', 8618, 4000);
insert into REGISTROCOMPRAENTITY (id, AUTOMOVIL_ID, FECHACOMPRA, NOMBREVENDEDOR, PRECIOCOMPRADO, PUNTOVENTA_ID) values (27000,27000, '7/8/2018', 'Yule Capaldo', 7755, 9000);
insert into REGISTROCOMPRAENTITY (id, AUTOMOVIL_ID, FECHACOMPRA, NOMBREVENDEDOR, PRECIOCOMPRADO, PUNTOVENTA_ID) values (28000,28000, '6/6/2018', 'Jessika Tuckley', 5248, 7000);
insert into REGISTROCOMPRAENTITY (id, AUTOMOVIL_ID, FECHACOMPRA, NOMBREVENDEDOR, PRECIOCOMPRADO, PUNTOVENTA_ID) values (29000,29000, '6/10/2018', 'Silvia Holleworth', 1274, 9000);
insert into REGISTROCOMPRAENTITY (id, AUTOMOVIL_ID, FECHACOMPRA, NOMBREVENDEDOR, PRECIOCOMPRADO, PUNTOVENTA_ID) values (30000,30000, '3/28/2019', 'Etty Artingstall', 6308, 10000);
insert into REGISTROCOMPRAENTITY (id, AUTOMOVIL_ID, FECHACOMPRA, NOMBREVENDEDOR, PRECIOCOMPRADO, PUNTOVENTA_ID) values (31000,31000, '6/17/2018', 'Alta Dowbakin', 1374, 8000);
insert into REGISTROCOMPRAENTITY (id, AUTOMOVIL_ID, FECHACOMPRA, NOMBREVENDEDOR, PRECIOCOMPRADO, PUNTOVENTA_ID) values (32000,32000, '5/8/2018', 'Poppy Bathowe', 1766, 9000);
insert into REGISTROCOMPRAENTITY (id, AUTOMOVIL_ID, FECHACOMPRA, NOMBREVENDEDOR, PRECIOCOMPRADO, PUNTOVENTA_ID) values (33000,33000, '1/1/2019', 'Yorgo Purkess', 4375, 8000);
insert into REGISTROCOMPRAENTITY (id, AUTOMOVIL_ID, FECHACOMPRA, NOMBREVENDEDOR, PRECIOCOMPRADO, PUNTOVENTA_ID) values (34000,34000, '8/13/2018', 'Corrie Ell', 6067, 8000);
insert into REGISTROCOMPRAENTITY (id, AUTOMOVIL_ID, FECHACOMPRA, NOMBREVENDEDOR, PRECIOCOMPRADO, PUNTOVENTA_ID) values (35000,35000, '7/24/2018', 'Jesse Folker', 8150, 10000);
insert into REGISTROCOMPRAENTITY (id, AUTOMOVIL_ID, FECHACOMPRA, NOMBREVENDEDOR, PRECIOCOMPRADO, PUNTOVENTA_ID) values (36000,36000, '3/2/2019', 'Giraldo Hulcoop', 4199, 1000);
insert into REGISTROCOMPRAENTITY (id, AUTOMOVIL_ID, FECHACOMPRA, NOMBREVENDEDOR, PRECIOCOMPRADO, PUNTOVENTA_ID) values (37000,37000, '8/17/2018', 'Livvyy Ollarenshaw', 8585, 4000);
insert into REGISTROCOMPRAENTITY (id, AUTOMOVIL_ID, FECHACOMPRA, NOMBREVENDEDOR, PRECIOCOMPRADO, PUNTOVENTA_ID) values (38000,38000, '10/25/2018', 'Sarina Lummus', 7626, 4000);
insert into REGISTROCOMPRAENTITY (id, AUTOMOVIL_ID, FECHACOMPRA, NOMBREVENDEDOR, PRECIOCOMPRADO, PUNTOVENTA_ID) values (39000,39000, '8/22/2018', 'Sherwood Jobbings', 3854, 5000);
insert into REGISTROCOMPRAENTITY (id, AUTOMOVIL_ID, FECHACOMPRA, NOMBREVENDEDOR, PRECIOCOMPRADO, PUNTOVENTA_ID) values (40000,40000, '6/7/2018', 'Vikky Hannon', 4171, 7000);
insert into REGISTROCOMPRAENTITY (id, AUTOMOVIL_ID, FECHACOMPRA, NOMBREVENDEDOR, PRECIOCOMPRADO, PUNTOVENTA_ID) values (41000,41000, '4/28/2019', 'Pammie Splevin', 6982, 2000);
insert into REGISTROCOMPRAENTITY (id, AUTOMOVIL_ID, FECHACOMPRA, NOMBREVENDEDOR, PRECIOCOMPRADO, PUNTOVENTA_ID) values (42000,42000, '4/9/2019', 'Wolfie Rumbold', 3244, 6000);
insert into REGISTROCOMPRAENTITY (id, AUTOMOVIL_ID, FECHACOMPRA, NOMBREVENDEDOR, PRECIOCOMPRADO, PUNTOVENTA_ID) values (43000,43000, '4/20/2019', 'Latia Laurenceau', 4794, 7000);
insert into REGISTROCOMPRAENTITY (id, AUTOMOVIL_ID, FECHACOMPRA, NOMBREVENDEDOR, PRECIOCOMPRADO, PUNTOVENTA_ID) values (44000,44000, '7/21/2018', 'Ginnifer Coryndon', 3030, 2000);
insert into REGISTROCOMPRAENTITY (id, AUTOMOVIL_ID, FECHACOMPRA, NOMBREVENDEDOR, PRECIOCOMPRADO, PUNTOVENTA_ID) values (45000,45000, '11/9/2018', 'Lonnard Scollick', 3948, 4000);
insert into REGISTROCOMPRAENTITY (id, AUTOMOVIL_ID, FECHACOMPRA, NOMBREVENDEDOR, PRECIOCOMPRADO, PUNTOVENTA_ID) values (46000,46000, '4/29/2019', 'Sigmund Dumbell', 5526, 3000);
insert into REGISTROCOMPRAENTITY (id, AUTOMOVIL_ID, FECHACOMPRA, NOMBREVENDEDOR, PRECIOCOMPRADO, PUNTOVENTA_ID) values (47000,47000, '7/10/2018', 'Moshe Ebbin', 4927, 7000);
insert into REGISTROCOMPRAENTITY (id, AUTOMOVIL_ID, FECHACOMPRA, NOMBREVENDEDOR, PRECIOCOMPRADO, PUNTOVENTA_ID) values (48000,48000, '8/4/2018', 'Tamra Tebbs', 8706, 8000);
insert into REGISTROCOMPRAENTITY (id, AUTOMOVIL_ID, FECHACOMPRA, NOMBREVENDEDOR, PRECIOCOMPRADO, PUNTOVENTA_ID) values (49000,49000, '6/30/2018', 'Chelsae Knowlden', 5353, 5000);
insert into REGISTROCOMPRAENTITY (id, AUTOMOVIL_ID, FECHACOMPRA, NOMBREVENDEDOR, PRECIOCOMPRADO, PUNTOVENTA_ID) values (50000,50000, '8/27/2018', 'Ervin Redsull', 6201, 10000);
insert into REGISTROCOMPRAENTITY (id, AUTOMOVIL_ID, FECHACOMPRA, NOMBREVENDEDOR, PRECIOCOMPRADO, PUNTOVENTA_ID) values (51000,51000, '6/2/2018', 'Nicolais Royce', 2653, 7000);
insert into REGISTROCOMPRAENTITY (id, AUTOMOVIL_ID, FECHACOMPRA, NOMBREVENDEDOR, PRECIOCOMPRADO, PUNTOVENTA_ID) values (52000,52000, '10/7/2018', 'Luciana Siddon', 2133, 9000);
insert into REGISTROCOMPRAENTITY (id, AUTOMOVIL_ID, FECHACOMPRA, NOMBREVENDEDOR, PRECIOCOMPRADO, PUNTOVENTA_ID) values (53000,53000, '3/2/2019', 'Jervis Anning', 7196, 4000);
insert into REGISTROCOMPRAENTITY (id, AUTOMOVIL_ID, FECHACOMPRA, NOMBREVENDEDOR, PRECIOCOMPRADO, PUNTOVENTA_ID) values (54000,54000, '7/13/2018', 'Chev Roy', 7240, 7000);
insert into REGISTROCOMPRAENTITY (id, AUTOMOVIL_ID, FECHACOMPRA, NOMBREVENDEDOR, PRECIOCOMPRADO, PUNTOVENTA_ID) values (55000,55000, '6/2/2018', 'Jayme Livingston', 8452, 5000);
insert into REGISTROCOMPRAENTITY (id, AUTOMOVIL_ID, FECHACOMPRA, NOMBREVENDEDOR, PRECIOCOMPRADO, PUNTOVENTA_ID) values (56000,56000, '3/30/2019', 'Lonnie Antyukhin', 6881, 10000);
insert into REGISTROCOMPRAENTITY (id, AUTOMOVIL_ID, FECHACOMPRA, NOMBREVENDEDOR, PRECIOCOMPRADO, PUNTOVENTA_ID) values (57000,57000, '2/11/2019', 'Vivyan Ready', 3581, 6000);
insert into REGISTROCOMPRAENTITY (id, AUTOMOVIL_ID, FECHACOMPRA, NOMBREVENDEDOR, PRECIOCOMPRADO, PUNTOVENTA_ID) values (58000,58000, '6/12/2018', 'Anestassia Buttfield', 1507, 7000);
insert into REGISTROCOMPRAENTITY (id, AUTOMOVIL_ID, FECHACOMPRA, NOMBREVENDEDOR, PRECIOCOMPRADO, PUNTOVENTA_ID) values (59000,59000, '9/8/2018', 'Jobyna Klimowski', 7843, 8000);
insert into REGISTROCOMPRAENTITY (id, AUTOMOVIL_ID, FECHACOMPRA, NOMBREVENDEDOR, PRECIOCOMPRADO, PUNTOVENTA_ID) values (60000,60000, '7/27/2018', 'Odelle Brandin', 2043, 2000);
insert into REGISTROCOMPRAENTITY (id, AUTOMOVIL_ID, FECHACOMPRA, NOMBREVENDEDOR, PRECIOCOMPRADO, PUNTOVENTA_ID) values (61000,61000, '8/5/2018', 'Elsbeth Lathleiffure', 3454, 1000);
insert into REGISTROCOMPRAENTITY (id, AUTOMOVIL_ID, FECHACOMPRA, NOMBREVENDEDOR, PRECIOCOMPRADO, PUNTOVENTA_ID) values (62000,62000, '10/15/2018', 'Jaquelyn Wearn', 3233, 6000);
insert into REGISTROCOMPRAENTITY (id, AUTOMOVIL_ID, FECHACOMPRA, NOMBREVENDEDOR, PRECIOCOMPRADO, PUNTOVENTA_ID) values (63000,63000, '5/17/2018', 'Gabriel Bettis', 5647, 5000);
insert into REGISTROCOMPRAENTITY (id, AUTOMOVIL_ID, FECHACOMPRA, NOMBREVENDEDOR, PRECIOCOMPRADO, PUNTOVENTA_ID) values (64000,64000, '3/26/2019', 'Brynn Abercromby', 3684, 6000);
insert into REGISTROCOMPRAENTITY (id, AUTOMOVIL_ID, FECHACOMPRA, NOMBREVENDEDOR, PRECIOCOMPRADO, PUNTOVENTA_ID) values (65000,65000, '11/20/2018', 'Aluino Elgy', 8035, 10000);
insert into REGISTROCOMPRAENTITY (id, AUTOMOVIL_ID, FECHACOMPRA, NOMBREVENDEDOR, PRECIOCOMPRADO, PUNTOVENTA_ID) values (66000,66000, '8/2/2018', 'Dagmar Perry', 1718, 1000);
insert into REGISTROCOMPRAENTITY (id, AUTOMOVIL_ID, FECHACOMPRA, NOMBREVENDEDOR, PRECIOCOMPRADO, PUNTOVENTA_ID) values (67000,67000, '8/20/2018', 'Winny Jacob', 3494, 4000);
insert into REGISTROCOMPRAENTITY (id, AUTOMOVIL_ID, FECHACOMPRA, NOMBREVENDEDOR, PRECIOCOMPRADO, PUNTOVENTA_ID) values (68000,68000, '2/23/2019', 'Caitlin Theyer', 5748, 8000);
insert into REGISTROCOMPRAENTITY (id, AUTOMOVIL_ID, FECHACOMPRA, NOMBREVENDEDOR, PRECIOCOMPRADO, PUNTOVENTA_ID) values (69000,69000, '7/3/2018', 'Nicky Fitton', 2568, 10000);
insert into REGISTROCOMPRAENTITY (id, AUTOMOVIL_ID, FECHACOMPRA, NOMBREVENDEDOR, PRECIOCOMPRADO, PUNTOVENTA_ID) values (70000,70000, '12/6/2018', 'Isidore Brunker', 5766, 6000);
insert into REGISTROCOMPRAENTITY (id, AUTOMOVIL_ID, FECHACOMPRA, NOMBREVENDEDOR, PRECIOCOMPRADO, PUNTOVENTA_ID) values (71000,71000, '7/29/2018', 'Kirsten Gerasch', 7149, 2000);
insert into REGISTROCOMPRAENTITY (id, AUTOMOVIL_ID, FECHACOMPRA, NOMBREVENDEDOR, PRECIOCOMPRADO, PUNTOVENTA_ID) values (72000,72000, '6/3/2018', 'Guglielma Doud', 1128, 5000);
insert into REGISTROCOMPRAENTITY (id, AUTOMOVIL_ID, FECHACOMPRA, NOMBREVENDEDOR, PRECIOCOMPRADO, PUNTOVENTA_ID) values (73000,73000, '9/9/2018', 'Wilbert Grundwater', 6162, 7000);
insert into REGISTROCOMPRAENTITY (id, AUTOMOVIL_ID, FECHACOMPRA, NOMBREVENDEDOR, PRECIOCOMPRADO, PUNTOVENTA_ID) values (74000,74000, '3/3/2019', 'Shelagh Paulisch', 6844, 1000);
insert into REGISTROCOMPRAENTITY (id, AUTOMOVIL_ID, FECHACOMPRA, NOMBREVENDEDOR, PRECIOCOMPRADO, PUNTOVENTA_ID) values (75000,75000, '10/6/2018', 'Emalee Goss', 8490, 7000);
insert into REGISTROCOMPRAENTITY (id, AUTOMOVIL_ID, FECHACOMPRA, NOMBREVENDEDOR, PRECIOCOMPRADO, PUNTOVENTA_ID) values (76000,76000, '11/22/2018', 'Francklin O''Finan', 5009, 9000);
insert into REGISTROCOMPRAENTITY (id, AUTOMOVIL_ID, FECHACOMPRA, NOMBREVENDEDOR, PRECIOCOMPRADO, PUNTOVENTA_ID) values (77000,77000, '5/9/2018', 'Hort Riddett', 8190, 6000);
insert into REGISTROCOMPRAENTITY (id, AUTOMOVIL_ID, FECHACOMPRA, NOMBREVENDEDOR, PRECIOCOMPRADO, PUNTOVENTA_ID) values (78000,78000, '12/26/2018', 'Allsun Crosoer', 6017, 6000);
insert into REGISTROCOMPRAENTITY (id, AUTOMOVIL_ID, FECHACOMPRA, NOMBREVENDEDOR, PRECIOCOMPRADO, PUNTOVENTA_ID) values (79000,79000, '11/25/2018', 'Monro Stonbridge', 8204, 5000);
insert into REGISTROCOMPRAENTITY (id, AUTOMOVIL_ID, FECHACOMPRA, NOMBREVENDEDOR, PRECIOCOMPRADO, PUNTOVENTA_ID) values (80000,80000, '1/1/2019', 'Fleming Rosenfrucht', 4521, 7000);
insert into REGISTROCOMPRAENTITY (id, AUTOMOVIL_ID, FECHACOMPRA, NOMBREVENDEDOR, PRECIOCOMPRADO, PUNTOVENTA_ID) values (81000,81000, '6/15/2018', 'Eleanora Abbis', 7904, 1000);
insert into REGISTROCOMPRAENTITY (id, AUTOMOVIL_ID, FECHACOMPRA, NOMBREVENDEDOR, PRECIOCOMPRADO, PUNTOVENTA_ID) values (82000,82000, '5/27/2018', 'Rufe Pennycuick', 2222, 6000);
insert into REGISTROCOMPRAENTITY (id, AUTOMOVIL_ID, FECHACOMPRA, NOMBREVENDEDOR, PRECIOCOMPRADO, PUNTOVENTA_ID) values (83000,83000, '10/26/2018', 'Gris Ambroz', 4122, 10000);
insert into REGISTROCOMPRAENTITY (id, AUTOMOVIL_ID, FECHACOMPRA, NOMBREVENDEDOR, PRECIOCOMPRADO, PUNTOVENTA_ID) values (84000,84000, '5/28/2018', 'Catharina Jewar', 4519, 3000);
insert into REGISTROCOMPRAENTITY (id, AUTOMOVIL_ID, FECHACOMPRA, NOMBREVENDEDOR, PRECIOCOMPRADO, PUNTOVENTA_ID) values (85000,85000, '5/9/2018', 'Meta Giroldi', 4283, 5000);
insert into REGISTROCOMPRAENTITY (id, AUTOMOVIL_ID, FECHACOMPRA, NOMBREVENDEDOR, PRECIOCOMPRADO, PUNTOVENTA_ID) values (86000,86000, '9/16/2018', 'Tamar Joy', 4473, 4000);
insert into REGISTROCOMPRAENTITY (id, AUTOMOVIL_ID, FECHACOMPRA, NOMBREVENDEDOR, PRECIOCOMPRADO, PUNTOVENTA_ID) values (87000,87000, '8/26/2018', 'Franchot Mangon', 1258, 10000);
insert into REGISTROCOMPRAENTITY (id, AUTOMOVIL_ID, FECHACOMPRA, NOMBREVENDEDOR, PRECIOCOMPRADO, PUNTOVENTA_ID) values (88000,88000, '12/5/2018', 'Nita Brokenbrow', 5794, 3000);
insert into REGISTROCOMPRAENTITY (id, AUTOMOVIL_ID, FECHACOMPRA, NOMBREVENDEDOR, PRECIOCOMPRADO, PUNTOVENTA_ID) values (89000,89000, '3/5/2019', 'Clem Roze', 6757, 6000);
insert into REGISTROCOMPRAENTITY (id, AUTOMOVIL_ID, FECHACOMPRA, NOMBREVENDEDOR, PRECIOCOMPRADO, PUNTOVENTA_ID) values (90000,90000, '8/4/2018', 'Mead Leban', 4810, 7000);
insert into REGISTROCOMPRAENTITY (id, AUTOMOVIL_ID, FECHACOMPRA, NOMBREVENDEDOR, PRECIOCOMPRADO, PUNTOVENTA_ID) values (91000,91000, '6/8/2018', 'Howey Kettlestring', 8532, 7000);
insert into REGISTROCOMPRAENTITY (id, AUTOMOVIL_ID, FECHACOMPRA, NOMBREVENDEDOR, PRECIOCOMPRADO, PUNTOVENTA_ID) values (92000,92000, '3/26/2019', 'Schuyler Kopf', 4815, 5000);
insert into REGISTROCOMPRAENTITY (id, AUTOMOVIL_ID, FECHACOMPRA, NOMBREVENDEDOR, PRECIOCOMPRADO, PUNTOVENTA_ID) values (93000,93000, '7/11/2018', 'Ugo Simison', 7684, 9000);
insert into REGISTROCOMPRAENTITY (id, AUTOMOVIL_ID, FECHACOMPRA, NOMBREVENDEDOR, PRECIOCOMPRADO, PUNTOVENTA_ID) values (94000,94000, '7/30/2018', 'Dimitry Attoc', 3720, 10000);
insert into REGISTROCOMPRAENTITY (id, AUTOMOVIL_ID, FECHACOMPRA, NOMBREVENDEDOR, PRECIOCOMPRADO, PUNTOVENTA_ID) values (95000,95000, '10/15/2018', 'Zelda Foulsham', 6588, 7000);
insert into REGISTROCOMPRAENTITY (id, AUTOMOVIL_ID, FECHACOMPRA, NOMBREVENDEDOR, PRECIOCOMPRADO, PUNTOVENTA_ID) values (96000,96000, '5/15/2018', 'Inness Snar', 3312, 6000);
insert into REGISTROCOMPRAENTITY (id, AUTOMOVIL_ID, FECHACOMPRA, NOMBREVENDEDOR, PRECIOCOMPRADO, PUNTOVENTA_ID) values (97000,97000, '7/18/2018', 'Tarrance Mollitt', 2138, 4000);
insert into REGISTROCOMPRAENTITY (id, AUTOMOVIL_ID, FECHACOMPRA, NOMBREVENDEDOR, PRECIOCOMPRADO, PUNTOVENTA_ID) values (98000,98000, '10/28/2018', 'Shana Choffin', 5950, 2000);
insert into REGISTROCOMPRAENTITY (id, AUTOMOVIL_ID, FECHACOMPRA, NOMBREVENDEDOR, PRECIOCOMPRADO, PUNTOVENTA_ID) values (99000,99000, '3/28/2019', 'Clementine Botcherby', 3296, 6000);
insert into REGISTROCOMPRAENTITY (id, AUTOMOVIL_ID, FECHACOMPRA, NOMBREVENDEDOR, PRECIOCOMPRADO, PUNTOVENTA_ID) values (100000,100000, '5/12/2018', 'Rod McLarens', 6323, 9000);

INSERT INTO CLIENTEENTITY (ID,CORREO,NOMBRE,TELEFONO) VALUES (1000, 'asd@mail.com', 'Camilo Peréz', '3523256232');
INSERT INTO CLIENTEENTITY (ID,CORREO,NOMBRE,TELEFONO) VALUES (2000, 'ino@mail.com', 'Andrés Peréz', '1236544486');
INSERT INTO CLIENTEENTITY (ID,CORREO,NOMBRE,TELEFONO) VALUES (3000, 'dfghj@mail.com', 'Pablo Peréz', '2585236985');

insert into CLIENTEENTITY_PUNTOVENTAENTITY (PUNTOSVENTA_ID, CLIENTES_ID) values (1000, 1000);
insert into CLIENTEENTITY_PUNTOVENTAENTITY (PUNTOSVENTA_ID, CLIENTES_ID) values (2000, 2000);
insert into CLIENTEENTITY_PUNTOVENTAENTITY (PUNTOSVENTA_ID, CLIENTES_ID) values (2000, 3000);

insert into EMPLEADOENTITY (ID,EXTENSION,NOMBRE,CORREO,PUNTOVENTA_ID) values (1000, 318, 'Juan Perez', 'jp@mail.com', 1000);
insert into EMPLEADOENTITY (ID,EXTENSION,NOMBRE,CORREO,PUNTOVENTA_ID) values (2000, 314, 'Juan Rodriguez', 'jr@mail.com', 1000);
insert into EMPLEADOENTITY (ID,EXTENSION,NOMBRE,CORREO,PUNTOVENTA_ID) values (3000, 314, 'Pedro Rodriguez', 'pr@mail.com', 2000);

insert into COMPRAVENTAENTITY (ID,CALIFICACIONCOMPRA,COMENTARIOS,FECHA,PAGADO,CLIENTE_ID,EMPLEADO_ID,PUNTOVENTA_ID,AUTOMOVILFACTURADO_ID) VALUES (1000,4.8,'Buena compra.','2018-06-18',1,1000,1000,1000,1000);
insert into COMPRAVENTAENTITY (ID,CALIFICACIONCOMPRA,COMENTARIOS,FECHA,PAGADO,CLIENTE_ID,EMPLEADO_ID,PUNTOVENTA_ID,AUTOMOVILFACTURADO_ID) VALUES (2000,4.3,'Estoy satisfecho.','2018-06-20',1,2000,2000,2000,2000);
insert into COMPRAVENTAENTITY (ID,CALIFICACIONCOMPRA,COMENTARIOS,FECHA,PAGADO,CLIENTE_ID,EMPLEADO_ID,PUNTOVENTA_ID,AUTOMOVILFACTURADO_ID) VALUES (3000,4.6,'Buena compra.','2018-07-18',1,1000,1000,1000,3000);
insert into COMPRAVENTAENTITY (ID,CALIFICACIONCOMPRA,COMENTARIOS,FECHA,PAGADO,CLIENTE_ID,EMPLEADO_ID,PUNTOVENTA_ID,AUTOMOVILFACTURADO_ID) VALUES (4000,5,'Excelente.','2018-06-24',1,2000,2000,2000,4000);

insert into FACTURAENTITY (ID,CUENTAORIGEN,FECHA,COMPRAVENTA_ID) VALUES (1000,254100046589,'2018-06-18',1000);
insert into FACTURAENTITY (ID,CUENTAORIGEN,FECHA,COMPRAVENTA_ID) VALUES (2000,652300048523,'2018-06-20',2000);
insert into FACTURAENTITY (ID,CUENTAORIGEN,FECHA,COMPRAVENTA_ID) VALUES (3000,978500049511,'2018-07-18',3000);
insert into FACTURAENTITY (ID,CUENTAORIGEN,FECHA,COMPRAVENTA_ID) VALUES (4000,325400043645,'2018-06-24',4000);

select * from PUNTOVENTAENTITY;
