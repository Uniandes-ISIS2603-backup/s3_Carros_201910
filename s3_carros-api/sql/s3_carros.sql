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

insert into PUNTOVENTAENTITY (id, direccion, TELEFONO, latitud, longitud, Nombre) values (1, '643 Hanover Way', '(326) 3402306', -5.1443118, -38.0850339, 'GOOFELLAS-Calle 26');
insert into PUNTOVENTAENTITY (id, direccion, TELEFONO, latitud, longitud, Nombre) values (2, '5896 Schurz Terrace', '(291) 3167263', 20.7491091, 106.3699271, 'GOOFELLAS - Av las americas');
insert into PUNTOVENTAENTITY (id, direccion, TELEFONO, latitud, longitud, Nombre) values (3, '88063 Dawn Trail', '(366) 7081866', 5.586693, -74.2296713, 'GOOFELLAS- Andino');
insert into PUNTOVENTAENTITY (id, direccion, TELEFONO, latitud, longitud, Nombre) values (4, '2590 Northland Crossing', '(606) 5177758', -14.16568, -72.658867, 'GOOFELLAS- Autonorte Cll. 134');
insert into PUNTOVENTAENTITY (id, direccion, TELEFONO, latitud, longitud, Nombre) values (5, '2 Anhalt Way', '(182) 4659961', 29.731101, 116.251947, 'GOOFELLAS- Floresta');
insert into PUNTOVENTAENTITY (id, direccion, TELEFONO, latitud, longitud, Nombre) values (6, '7816 Holy Cross Park', '(423) 5764086', 33.3437146, 130.6838866, 'GOOFELLAS - Iserra 100');
insert into PUNTOVENTAENTITY (id, direccion, TELEFONO, latitud, longitud, Nombre) values (7, '058 Holmberg Lane', '(581) 9633962', 4.338952, -73.938919, 'GOOFELLAS -Gaymaral');
insert into PUNTOVENTAENTITY (id, direccion, TELEFONO, latitud, longitud, Nombre) values (8, '452 Milwaukee Hill', '(413) 9735427', -18.0580139, 13.8361177, 'GOOFELLAS- Candelaria');
insert into PUNTOVENTAENTITY (id, direccion, TELEFONO, latitud, longitud, Nombre) values (9, '452  Hill', '(456) 9735427', -18.0580139, 13.84551177, 'GOOFELLAS- Centro mayor');
insert into PUNTOVENTAENTITY (id, direccion, TELEFONO, latitud, longitud, Nombre) values (10, '8778 Banding Avenue', '(771) 1211177', 15.187831, 120.057435,  'GOOFELLAS - NQS');



insert into MARCAENTITY (ID, DESCRIPCION, IMAGEN, NOMBREMARCA, LOGO) values (1, 'Innovation that exites','https://i.ytimg.com/vi/YI7WaagSVE0/maxresdefault.jpg', 'Nissan', 'http://www.car-brand-names.com/wp-content/uploads/2015/08/Nissan-logo.png');
insert into MARCAENTITY (ID, DESCRIPCION, IMAGEN, NOMBREMARCA, logo) values (2, 'We are professional grade ', 'https://www.gmc.com.mx/content/dam/gmc/na/mx/es/index/current-offers/01-images/gmc-offers-mh-lg.jpg?imwidth=1200', 'GMC', 'https://logos-coches.com/wp-content/uploads/2018/04/GMC-logo.png');
insert into MARCAENTITY (ID, DESCRIPCION, IMAGEN, NOMBREMARCA, LOGO) values (3, 'Go Further', 'https://www.ford.com/cmslibs/content/dam/brand_ford/en_us/brand/campaigns/2019/bfp/BFP_Billboard_Desktop_Edge_2160x945.jpg/_jcr_content/renditions/cq5dam.web.1440.1440.jpeg', 'Ford', 'http://assets.stickpng.com/thumbs/580b585b2edbce24c47b2c67.png');
insert into MARCAENTITY (ID, DESCRIPCION, IMAGEN, NOMBREMARCA, LOGO) values (4, 'There is no substitute', 'https://www.diariomotor.com/imagenes/picscache/1920x1600c/porsche-718-boxster-video_1920x1600c.jpg', 'Porsche', 'https://i.pinimg.com/originals/98/88/6b/98886b4f85abb7dff6587bdf424d2d9c.png');
insert into MARCAENTITY (ID, DESCRIPCION, IMAGEN, NOMBREMARCA, LOGO) values (5, 'Lets Go Places', 'https://e00-marca.uecdn.es/assets/multimedia/imagenes/2017/11/04/15097995704823.jpg', 'Toyota', 'http://propertybeyond.com.au/wp-content/uploads/2015/08/toyota.png');
insert into MARCAENTITY (ID, DESCRIPCION, IMAGEN, NOMBREMARCA, LOGO) values (6, 'Das Beste oder nichts', '../assets/Images/MERCEDES.jpg', 'Merdeces', 'https://logos-coches.com/wp-content/uploads/2018/04/Mercedes-Benz-logo.png');
insert into MARCAENTITY (ID, DESCRIPCION, IMAGEN, NOMBREMARCA, LOGO) values (7, 'Excellence Through Passion', 'https://www.diariomotor.com/imagenes/picscache/1920x1600c/maserati_ghibli_ficha_0418_033_1920x1600c.jpg', 'Maserati','http://pngimg.com/uploads/maserati/maserati_PNG1.png');
insert into MARCAENTITY (ID, DESCRIPCION, IMAGEN, NOMBREMARCA, LOGO) values (8, 'Varsprung durch Technik', '../assets/Images/AUDI.jpg', 'Audi', 'http://www.rentacarfloridacars.com/wp-content/uploads/2016/12/Audi-Logo-2013.png');
insert into MARCAENTITY (ID, DESCRIPCION, IMAGEN, NOMBREMARCA, LOGO) values (9, 'The Ultimate Driving Machine', '../assets/Images/BMW.jpg', 'BMW', 'https://upload.wikimedia.org/wikipedia/commons/thumb/4/44/BMW.svg/1200px-BMW.svg.png');
insert into MARCAENTITY (ID, DESCRIPCION, IMAGEN, NOMBREMARCA, LOGO) values (10, 'Jinba Ittai', 'https://cochesnuevos.autofacil.es/img/MAZDA_3_SEDAN_2019.jpg', 'Mazda', 'https://upload.wikimedia.org/wikipedia/nah/thumb/b/b1/Mazda_logo.png/640px-Mazda_logo.png');


insert into MARCAENTITY_PUNTOVENTAENTITY (PUNTOSVENTA_ID, MARCAS_ID) values (1, 1);
insert into MARCAENTITY_PUNTOVENTAENTITY (PUNTOSVENTA_ID, MARCAS_ID) values (1, 8);
insert into MARCAENTITY_PUNTOVENTAENTITY (PUNTOSVENTA_ID, MARCAS_ID) values (1, 5);

insert into MARCAENTITY_PUNTOVENTAENTITY (PUNTOSVENTA_ID, MARCAS_ID) values (2, 1);
insert into MARCAENTITY_PUNTOVENTAENTITY (PUNTOSVENTA_ID, MARCAS_ID) values (2, 5);
insert into MARCAENTITY_PUNTOVENTAENTITY (PUNTOSVENTA_ID, MARCAS_ID) values (2, 7);

insert into MARCAENTITY_PUNTOVENTAENTITY (PUNTOSVENTA_ID, MARCAS_ID) values (3, 1);
insert into MARCAENTITY_PUNTOVENTAENTITY (PUNTOSVENTA_ID, MARCAS_ID) values (3, 10);
insert into MARCAENTITY_PUNTOVENTAENTITY (PUNTOSVENTA_ID, MARCAS_ID) values (3, 9);

insert into MARCAENTITY_PUNTOVENTAENTITY (PUNTOSVENTA_ID, MARCAS_ID) values (4, 1);
insert into MARCAENTITY_PUNTOVENTAENTITY (PUNTOSVENTA_ID, MARCAS_ID) values (4, 2);
insert into MARCAENTITY_PUNTOVENTAENTITY (PUNTOSVENTA_ID, MARCAS_ID) values (4, 7);

insert into MARCAENTITY_PUNTOVENTAENTITY (PUNTOSVENTA_ID, MARCAS_ID) values (5, 1);
insert into MARCAENTITY_PUNTOVENTAENTITY (PUNTOSVENTA_ID, MARCAS_ID) values (5, 5);
insert into MARCAENTITY_PUNTOVENTAENTITY (PUNTOSVENTA_ID, MARCAS_ID) values (5, 6);

insert into MARCAENTITY_PUNTOVENTAENTITY (PUNTOSVENTA_ID, MARCAS_ID) values (6, 1);
insert into MARCAENTITY_PUNTOVENTAENTITY (PUNTOSVENTA_ID, MARCAS_ID) values (6, 4);
insert into MARCAENTITY_PUNTOVENTAENTITY (PUNTOSVENTA_ID, MARCAS_ID) values (6, 2);

insert into MARCAENTITY_PUNTOVENTAENTITY (PUNTOSVENTA_ID, MARCAS_ID) values (7, 1);
insert into MARCAENTITY_PUNTOVENTAENTITY (PUNTOSVENTA_ID, MARCAS_ID) values (7, 6);
insert into MARCAENTITY_PUNTOVENTAENTITY (PUNTOSVENTA_ID, MARCAS_ID) values (7, 5);

insert into MARCAENTITY_PUNTOVENTAENTITY (PUNTOSVENTA_ID, MARCAS_ID) values (8, 1);
insert into MARCAENTITY_PUNTOVENTAENTITY (PUNTOSVENTA_ID, MARCAS_ID) values (8, 4);
insert into MARCAENTITY_PUNTOVENTAENTITY (PUNTOSVENTA_ID, MARCAS_ID) values (8, 10);

insert into MARCAENTITY_PUNTOVENTAENTITY (PUNTOSVENTA_ID, MARCAS_ID) values (9, 1);
insert into MARCAENTITY_PUNTOVENTAENTITY (PUNTOSVENTA_ID, MARCAS_ID) values (9, 2);
insert into MARCAENTITY_PUNTOVENTAENTITY (PUNTOSVENTA_ID, MARCAS_ID) values (9, 10);

insert into MARCAENTITY_PUNTOVENTAENTITY (PUNTOSVENTA_ID, MARCAS_ID) values (10, 1);
insert into MARCAENTITY_PUNTOVENTAENTITY (PUNTOSVENTA_ID, MARCAS_ID) values (10, 9);
insert into MARCAENTITY_PUNTOVENTAENTITY (PUNTOSVENTA_ID, MARCAS_ID) values (10, 3);

INSERT INTO MODELOENTITY (ID,AIRBAG,AIREAC,ASIENTOS,CILINDRAJE,COMBUSTIBLE,DIRECCION,FRENOSABS,IMAGEN,NOMBRE,NUMEROPUERTAS,TRACCION,TRANSMISION,VIDRIOS,MARCA_ID) 
                            VALUES (1,1,1,'Sintéticos',1600,
                            'Gasolina','Asistida',1, 'https://2.bp.blogspot.com/-crgHLYSfi64/VzxWduE9dzI/AAAAAAAACpQ/MUNeSMw7-aIO1zbKcS6e4Yi0q8j_cyGkACLcB/s1600/Nissan%2BR390%2BGT1.png',
                            'R390 GT1',3,'Total','Automática',
                            'Eléctricos',1);

insert into MODELOENTITY (ID, NOMBRE, MARCA_ID, IMAGEN) values (2, 'GT-R R32-R34', 1, 'https://postmediadriving.files.wordpress.com/2019/04/chrome-image-402046.png?w=800&h=520&crop=1');
insert into MODELOENTITY (ID, NOMBRE, MARCA_ID, IMAGEN)  values (3, 'Versa', 1, 'https://st.motortrend.com/uploads/sites/10/2015/11/2010-nissan-versa-1.8-s-hatchback-angular-front.png');
insert into MODELOENTITY (ID, NOMBRE, MARCA_ID, IMAGEN)  values (4, 'Juke-R', 1,'https://st.motortrend.com/uploads/sites/10/2017/11/2012-nissan-juke-sv-fwd-cvt-suv-angular-front.png');
insert into MODELOENTITY (ID, NOMBRE, MARCA_ID, IMAGEN)  values (5, 'Sentra', 1, 'https://www.cstatic-images.com/car-pictures/xl/usc70nic061f121001.png');
insert into MODELOENTITY (ID, NOMBRE, MARCA_ID, IMAGEN)  values (6, 'Terrain', 2, '';
insert into MODELOENTITY (ID, NOMBRE, MARCA_ID, IMAGEN)  values (7, 'Terrain x', 2,'https://s3.amazonaws.com/fzautomotive/dealers/59248987610a5.png');
insert into MODELOENTITY (ID, NOMBRE, MARCA_ID, IMAGEN)  values (8, 'Acadia', 2, 'https://di-uploads-pod2.dealerinspire.com/carlblackchevybuickgmckennesaw/uploads/2018/11/2019-GMC-Acadia-Model.png');
insert into MODELOENTITY (ID, NOMBRE, MARCA_ID, IMAGEN)  values (9, 'Acadia Denali', 2, 'https://crls.io/s/evox%2Fcolor_2400_032_png%2FMY2018%2F12378%2F12378_cc2400_032_GB8.png/feature/n/gmc-acadia.png');
insert into MODELOENTITY (ID, NOMBRE, MARCA_ID, IMAGEN)  values (10, 'Canyon Denali', 2, 'https://static.tcimg.net/vehicles/primary/8dd958ffdda18717/2019-GMC-Canyon-white-full_color-driver_side_front_quarter.png');
insert into MODELOENTITY (ID, NOMBRE, MARCA_ID, IMAGEN)  values (11, 'Fiesta ST', 3, 'https://www.ford.com/cmslibs/content/dam/vdm_ford/live/en_us/ford/nameplate/fiesta/2019/collections/adplanner/19_frd_fie_5dr_st_ospc_356x180.png/_jcr_content/renditions/cq5dam.web.1280.1280.png');
insert into MODELOENTITY (ID, NOMBRE, MARCA_ID, IMAGEN)  values (12, 'Focus', 3,'https://st.motortrend.ca/uploads/sites/10/2017/05/2017-ford-focus-titanium-sedan-angular-front.png');
insert into MODELOENTITY (ID, NOMBRE, MARCA_ID, IMAGEN)  values (13, 'Explorer', 3, 'https://di-uploads-pod14.dealerinspire.com/kingsford/uploads/2018/02/ford_explorer2018_red.png');
insert into MODELOENTITY (ID, NOMBRE, MARCA_ID, IMAGEN)  values (14, 'Mustang', 3, 'https://cloudflarestockimages.dealereprocess.com/resrc/images/stockphoto_asset-c_limit,f_auto,fl_lossy,w_700/v1/svp/Colors_PNG1280/2019/19ford/19fordmustangfastbkecocp6fa/ford_19mustangfastbkecocp6fa_angularfront_racered');
insert into MODELOENTITY (ID, NOMBRE, MARCA_ID, IMAGEN)  values (15, 'Raptor', 3, 'https://leie-autos.be/wp-content/uploads/2018/04/vehicle-4-2.png');
insert into MODELOENTITY (ID, NOMBRE, MARCA_ID, IMAGEN)  values (16, '911 Carrera RS', 4, 'https://postmediadriving.files.wordpress.com/2018/05/chrome-image-394157.png?w=800&h=520&crop=1');
insert into MODELOENTITY (ID, NOMBRE, MARCA_ID, IMAGEN)  values (17, '718 GTS', 4, 'https://img-s-msn-com.akamaized.net/tenant/amp/entityid/BBRSMkx.img?w=354&h=236&m=7');
insert into MODELOENTITY (ID, NOMBRE, MARCA_ID, IMAGEN)  values (18, '911 g3t', 4, 'https://di-uploads-pod15.dealerinspire.com/rusnakwestlakeporsche/uploads/2018/12/cc_2018PRC010017_01_640_G1-copy-1.png');
insert into MODELOENTITY (ID, NOMBRE, MARCA_ID, IMAGEN)  values (19, ' 911 Speedster', 4, 'https://www.cstatic-images.com/car-pictures/xl/usd00prc014a021001.png');
insert into MODELOENTITY (ID, NOMBRE, MARCA_ID, IMAGEN)  values (20, 'Panamera GTS', 4, 'https://www.cstatic-images.com/car-pictures/xl/USC30PRC102A021001.png');
insert into MODELOENTITY (ID, NOMBRE, MARCA_ID, IMAGEN)  values (21, 'Carolla', 5, 'https://www.cstatic-images.com/car-pictures/xl/usc70toc041g021001.png');
insert into MODELOENTITY (ID, NOMBRE, MARCA_ID, IMAGEN)  values (22, 'Prius', 5, 'https://www.howardsgroup.co.uk/assets/brands/toyota/prius/toyota-prius-new-blue%20(1).png');
insert into MODELOENTITY (ID, NOMBRE, MARCA_ID, IMAGEN)  values (23, 'GT86', 5, 'https://www.toyota-canarias.es/sites/default/files/2019-01/gt86_27_m7y_p2.png');
insert into MODELOENTITY (ID, NOMBRE, MARCA_ID, IMAGEN)  values (24, 'Hilux', 5, 'https://daltontoyota.com.mx/modelos/hilux/colors/01.png');
insert into MODELOENTITY (ID, NOMBRE, MARCA_ID, IMAGEN)  values (25, 'Prado', 5, 'https://www.toyota.com.co/wp-content/uploads/2018/03/Prado-Vx.png');
insert into MODELOENTITY (ID, NOMBRE, MARCA_ID, IMAGEN)  values (26, 'Clase A', 6, 'https://s3-us-west-2.amazonaws.com/static.izmocars.com/toolkit/commonassets/2019/19mercedesbenz/19mercedesbenzclasea/19mercedesbenzclasea_animations/_mxcolor/_570x380/mercedesbenz_19clasea_azulmardelsur.png');
insert into MODELOENTITY (ID, NOMBRE, MARCA_ID, IMAGEN)  values (27, 'Clase E', 6, 'https://s3-eu-west-1.amazonaws.com/maxterauto-assets/gamas/images_colours/color_cabecera-34-286-1746-545-1549369262.png');
insert into MODELOENTITY (ID, NOMBRE, MARCA_ID, IMAGEN)  values (28, 'Clase CLS', 6, 'https://www.arval.es/sites/es/files/media/mercedes_15c220bluetecsa_4b_lowaggressive_negro-estandar.png');
insert into MODELOENTITY (ID, NOMBRE, MARCA_ID, IMAGEN)  values (29, 'AMG GT', 6, 'https://www.cstatic-images.com/car-pictures/xl/usc80mbcar2b021001.png');
insert into MODELOENTITY (ID, NOMBRE, MARCA_ID, IMAGEN)  values (30, 'GLE', 6, 'https://automobile-assets.s3.amazonaws.com/automobile/body/mercedes-g-class-2018-2019-1542112553.86.png');
insert into MODELOENTITY (ID, NOMBRE, MARCA_ID, IMAGEN)  values (31, 'Ghibli', 7, 'https://st.motortrend.com/uploads/sites/10/2018/01/2018-maserati-ghibli-sedan-angular-front.png');
insert into MODELOENTITY (ID, NOMBRE, MARCA_ID, IMAGEN)  values (32, 'Levante', 7, 'https://www.mirenting.es/wp-content/uploads/2019/01/Levante-S-new-18-1.png.png');
insert into MODELOENTITY (ID, NOMBRE, MARCA_ID, IMAGEN)  values (33, 'Quattroporte', 7, 'https://bookluxurycar.com/listing_image/original/Maserati-GRANTURISMO-SPORT-car.png');
insert into MODELOENTITY (ID, NOMBRE, MARCA_ID, IMAGEN)  values (34, 'GranTurismo', 7, 'https://st.motortrend.com/uploads/sites/10/2015/11/2015-maserati-granturismo-sport-convertible-angular-front.png');
insert into MODELOENTITY (ID, NOMBRE, MARCA_ID, IMAGEN)  values (35, 'GranCabrio', 7, 'https://res.cloudinary.com/carsguide/image/upload/f_auto,fl_lossy,q_auto,t_cg_hero_low/v1/editorial/vhs/Maserati-GranCabrio.png');
insert into MODELOENTITY (ID, NOMBRE, MARCA_ID, IMAGEN)  values (36, 'A4', 8, 'https://www.levantewagen.es/uploads/cms/con_contenido/plataforma_2/02/44/61/images/A4.jpg');
insert into MODELOENTITY (ID, NOMBRE, MARCA_ID, IMAGEN)  values (37, 'A5', 8, 'https://img.sm360.ca/ir/w640h390c/images/newcar/ca/2019/audi/a5-sportback/komfort/coupe/exteriorColors/12018_cc0640_032_s9.png');
insert into MODELOENTITY (ID, NOMBRE, MARCA_ID, IMAGEN)  values (38, 'Q8', 8, 'https://pictures.dealer.com/s/schaumburgaudiaoa/0312/5b40989b3476db148c615c75b0b90590x.jpg');
insert into MODELOENTITY (ID, NOMBRE, MARCA_ID, IMAGEN)  values (39, 'R8', 8, 'https://postmediadriving.files.wordpress.com/2019/03/chrome-image-397953.png?w=800&h=520&crop=1');
insert into MODELOENTITY (ID, NOMBRE, MARCA_ID, IMAGEN)  values (40, 'e-tron GT', 8, 'https://img1.bitautoimg.com/autoalbum/files/20181206/090/0312150909_6.jpg');
insert into MODELOENTITY (ID, NOMBRE, MARCA_ID, IMAGEN)  values (41, 'Serie 1', 9, 'https://www.arval.es/sites/es/files/media/bmw_serie1_delantera.png');
insert into MODELOENTITY (ID, NOMBRE, MARCA_ID, IMAGEN)  values (42, 'M2401', 9, 'https://www.cstatic-images.com/car-pictures/xl/usc80bmc803a021001.png');
insert into MODELOENTITY (ID, NOMBRE, MARCA_ID, IMAGEN)  values (43, 'X6', 9, 'https://st.motortrend.com/uploads/sites/10/2016/12/2017-bmw-x6-sdrive35i-suv-angular-front.png');
insert into MODELOENTITY (ID, NOMBRE, MARCA_ID, IMAGEN)  values (44, 'M3', 9, 'https://st.motortrend.com/uploads/sites/10/2015/11/2015-bmw-m3-sedan-angular-front.png?interpolation=lanczos-none&fit=around|392:261');
insert into MODELOENTITY (ID, NOMBRE, MARCA_ID, IMAGEN)  values (45, 'i8 Coupe ', 9, 'https://cache.bmwusa.com/cosy.arox?pov=walkaround&brand=WBBI&vehicle=19IC&client=byo&paint=P0C23&fabric=FNGEK&sa=S027K,S0322,S0508,S0610&date=20180306&angle=330&quality=100&resp=png&BKGND=TRANSPARENT&SHARP=30&HEIGHT=24%25');
insert into MODELOENTITY (ID, NOMBRE, MARCA_ID, IMAGEN)  values (46, 'Mazda 2', 10, 'https://s3-ap-southeast-2.amazonaws.com/imotor-cms/images_cms/a2c3ca42-4022-4297-b360-7a55e5f18f3e.png');
insert into MODELOENTITY (ID, NOMBRE, MARCA_ID, IMAGEN)  values (47, 'Mazda 3', 10, 'http://www.mazdamonclova.com/img/autos/MZ3H18/versiones/MZMZ3H1801.png');
insert into MODELOENTITY (ID, NOMBRE, MARCA_ID, IMAGEN)  values (48, 'Mazda 6', 10, 'https://st.motortrend.com/uploads/sites/10/2018/06/2018-mazda-mazda6-grand-touring-reserve-sedan-angular-front.png');
insert into MODELOENTITY (ID, NOMBRE, MARCA_ID, IMAGEN)  values (49, 'Mazda mx-5', 10, 'https://www.mazda.com.au/globalassets/settings/vehicle-assets/mx-5/2018-09---ipm/roadster-gt/maz13777_mx-5_soft-top_2.0l_roadstergt_soulredcrystal_front_980x520_rgb.png');
insert into MODELOENTITY (ID, NOMBRE, MARCA_ID, IMAGEN)  values (50, 'Mazda cx-5', 10, 'https://www.mazda.co.nz/sites/default/files/MDZ3994_CX-5_GLX_Deep-Crystal-Blue_Front.png');








insert into REGISTROCOMPRAENTITY (id, FECHACOMPRA, NOMBREVENDEDOR, PRECIOCOMPRADO, PUNTOVENTA_ID) values (1, '6/7/2018', 'Ailsun Jencey', 6502, 7);
insert into REGISTROCOMPRAENTITY (id, FECHACOMPRA, NOMBREVENDEDOR, PRECIOCOMPRADO, PUNTOVENTA_ID) values (2, '9/18/2018', 'Hakim O''Kynsillaghe', 8232, 10);
insert into REGISTROCOMPRAENTITY (id, FECHACOMPRA, NOMBREVENDEDOR, PRECIOCOMPRADO, PUNTOVENTA_ID) values (3, '6/4/2018', 'Davida Poulden', 3750, 8);
insert into REGISTROCOMPRAENTITY (id, FECHACOMPRA, NOMBREVENDEDOR, PRECIOCOMPRADO, PUNTOVENTA_ID) values (4, '6/24/2018', 'Maren Pulteneye', 4568, 1);
insert into REGISTROCOMPRAENTITY (id, FECHACOMPRA, NOMBREVENDEDOR, PRECIOCOMPRADO, PUNTOVENTA_ID) values (5, '3/22/2019', 'Elston Pickersail', 2267, 4);
insert into REGISTROCOMPRAENTITY (id, FECHACOMPRA, NOMBREVENDEDOR, PRECIOCOMPRADO, PUNTOVENTA_ID) values (6, '5/8/2018', 'Mallorie Quaife', 2313, 6);
insert into REGISTROCOMPRAENTITY (id, FECHACOMPRA, NOMBREVENDEDOR, PRECIOCOMPRADO, PUNTOVENTA_ID) values (7, '5/2/2019', 'Sibyl Bax', 7432, 10);
insert into REGISTROCOMPRAENTITY (id, FECHACOMPRA, NOMBREVENDEDOR, PRECIOCOMPRADO, PUNTOVENTA_ID) values (8, '9/18/2018', 'Wilmette Spyer', 3549, 10);
insert into REGISTROCOMPRAENTITY (id, FECHACOMPRA, NOMBREVENDEDOR, PRECIOCOMPRADO, PUNTOVENTA_ID) values (9, '12/19/2018', 'Dyna Blandamere', 8571, 3);
insert into REGISTROCOMPRAENTITY (id, FECHACOMPRA, NOMBREVENDEDOR, PRECIOCOMPRADO, PUNTOVENTA_ID) values (10, '4/20/2019', 'Rance Bernardino', 1045, 2);
insert into REGISTROCOMPRAENTITY (id, FECHACOMPRA, NOMBREVENDEDOR, PRECIOCOMPRADO, PUNTOVENTA_ID) values (11, '8/20/2018', 'Syman Heppner', 8323, 10);
insert into REGISTROCOMPRAENTITY (id, FECHACOMPRA, NOMBREVENDEDOR, PRECIOCOMPRADO, PUNTOVENTA_ID) values (12, '5/26/2018', 'Debee Nance', 8568, 5);
insert into REGISTROCOMPRAENTITY (id, FECHACOMPRA, NOMBREVENDEDOR, PRECIOCOMPRADO, PUNTOVENTA_ID) values (13, '7/10/2018', 'Teddie Baltzar', 7983, 5);
insert into REGISTROCOMPRAENTITY (id, FECHACOMPRA, NOMBREVENDEDOR, PRECIOCOMPRADO, PUNTOVENTA_ID) values (14, '7/17/2018', 'Candide McGuane', 3072, 3);
insert into REGISTROCOMPRAENTITY (id, FECHACOMPRA, NOMBREVENDEDOR, PRECIOCOMPRADO, PUNTOVENTA_ID) values (15, '2/10/2019', 'Sharai Gerling', 7956, 1);
insert into REGISTROCOMPRAENTITY (id, FECHACOMPRA, NOMBREVENDEDOR, PRECIOCOMPRADO, PUNTOVENTA_ID) values (16, '10/17/2018', 'Trixie Rotter', 6332, 7);
insert into REGISTROCOMPRAENTITY (id, FECHACOMPRA, NOMBREVENDEDOR, PRECIOCOMPRADO, PUNTOVENTA_ID) values (17, '10/4/2018', 'Rosalind Maddrah', 2315, 8);
insert into REGISTROCOMPRAENTITY (id, FECHACOMPRA, NOMBREVENDEDOR, PRECIOCOMPRADO, PUNTOVENTA_ID) values (18, '1/20/2019', 'Livvyy Vian', 5257, 4);
insert into REGISTROCOMPRAENTITY (id, FECHACOMPRA, NOMBREVENDEDOR, PRECIOCOMPRADO, PUNTOVENTA_ID) values (19, '10/29/2018', 'Viviene Croucher', 3840, 10);
insert into REGISTROCOMPRAENTITY (id, FECHACOMPRA, NOMBREVENDEDOR, PRECIOCOMPRADO, PUNTOVENTA_ID) values (20, '4/19/2019', 'Sarene Dahlbom', 5824, 7);
insert into REGISTROCOMPRAENTITY (id, FECHACOMPRA, NOMBREVENDEDOR, PRECIOCOMPRADO, PUNTOVENTA_ID) values (21, '8/28/2018', 'Kati Tattershall', 5017, 7);
insert into REGISTROCOMPRAENTITY (id, FECHACOMPRA, NOMBREVENDEDOR, PRECIOCOMPRADO, PUNTOVENTA_ID) values (22, '7/23/2018', 'Sanders Hearons', 5696, 5);
insert into REGISTROCOMPRAENTITY (id, FECHACOMPRA, NOMBREVENDEDOR, PRECIOCOMPRADO, PUNTOVENTA_ID) values (23, '1/14/2019', 'Jerri Hasling', 3083, 4);
insert into REGISTROCOMPRAENTITY (id, FECHACOMPRA, NOMBREVENDEDOR, PRECIOCOMPRADO, PUNTOVENTA_ID) values (24, '3/8/2019', 'Addie Muscroft', 5707, 6);
insert into REGISTROCOMPRAENTITY (id, FECHACOMPRA, NOMBREVENDEDOR, PRECIOCOMPRADO, PUNTOVENTA_ID) values (25, '8/9/2018', 'Josepha Poat', 1552, 5);
insert into REGISTROCOMPRAENTITY (id, FECHACOMPRA, NOMBREVENDEDOR, PRECIOCOMPRADO, PUNTOVENTA_ID) values (26, '3/13/2019', 'Angel Jerzak', 8618, 4);
insert into REGISTROCOMPRAENTITY (id, FECHACOMPRA, NOMBREVENDEDOR, PRECIOCOMPRADO, PUNTOVENTA_ID) values (27, '7/8/2018', 'Yule Capaldo', 7755, 9);
insert into REGISTROCOMPRAENTITY (id, FECHACOMPRA, NOMBREVENDEDOR, PRECIOCOMPRADO, PUNTOVENTA_ID) values (28, '6/6/2018', 'Jessika Tuckley', 5248, 7);
insert into REGISTROCOMPRAENTITY (id, FECHACOMPRA, NOMBREVENDEDOR, PRECIOCOMPRADO, PUNTOVENTA_ID) values (29, '6/10/2018', 'Silvia Holleworth', 1274, 9);
insert into REGISTROCOMPRAENTITY (id, FECHACOMPRA, NOMBREVENDEDOR, PRECIOCOMPRADO, PUNTOVENTA_ID) values (30, '3/28/2019', 'Etty Artingstall', 6308, 10);
insert into REGISTROCOMPRAENTITY (id, FECHACOMPRA, NOMBREVENDEDOR, PRECIOCOMPRADO, PUNTOVENTA_ID) values (31, '6/17/2018', 'Alta Dowbakin', 1374, 8);
insert into REGISTROCOMPRAENTITY (id, FECHACOMPRA, NOMBREVENDEDOR, PRECIOCOMPRADO, PUNTOVENTA_ID) values (32, '5/8/2018', 'Poppy Bathowe', 1766, 9);
insert into REGISTROCOMPRAENTITY (id, FECHACOMPRA, NOMBREVENDEDOR, PRECIOCOMPRADO, PUNTOVENTA_ID) values (33, '1/1/2019', 'Yorgo Purkess', 4375, 8);
insert into REGISTROCOMPRAENTITY (id, FECHACOMPRA, NOMBREVENDEDOR, PRECIOCOMPRADO, PUNTOVENTA_ID) values (34, '8/13/2018', 'Corrie Ell', 6067, 8);
insert into REGISTROCOMPRAENTITY (id, FECHACOMPRA, NOMBREVENDEDOR, PRECIOCOMPRADO, PUNTOVENTA_ID) values (35, '7/24/2018', 'Jesse Folker', 8150, 10);
insert into REGISTROCOMPRAENTITY (id, FECHACOMPRA, NOMBREVENDEDOR, PRECIOCOMPRADO, PUNTOVENTA_ID) values (36, '3/2/2019', 'Giraldo Hulcoop', 4199, 1);
insert into REGISTROCOMPRAENTITY (id, FECHACOMPRA, NOMBREVENDEDOR, PRECIOCOMPRADO, PUNTOVENTA_ID) values (37, '8/17/2018', 'Livvyy Ollarenshaw', 8585, 4);
insert into REGISTROCOMPRAENTITY (id, FECHACOMPRA, NOMBREVENDEDOR, PRECIOCOMPRADO, PUNTOVENTA_ID) values (38, '10/25/2018', 'Sarina Lummus', 7626, 4);
insert into REGISTROCOMPRAENTITY (id, FECHACOMPRA, NOMBREVENDEDOR, PRECIOCOMPRADO, PUNTOVENTA_ID) values (39, '8/22/2018', 'Sherwood Jobbings', 3854, 5);
insert into REGISTROCOMPRAENTITY (id, FECHACOMPRA, NOMBREVENDEDOR, PRECIOCOMPRADO, PUNTOVENTA_ID) values (40, '6/7/2018', 'Vikky Hannon', 4171, 7);
insert into REGISTROCOMPRAENTITY (id, FECHACOMPRA, NOMBREVENDEDOR, PRECIOCOMPRADO, PUNTOVENTA_ID) values (41, '4/28/2019', 'Pammie Splevin', 6982, 2);
insert into REGISTROCOMPRAENTITY (id, FECHACOMPRA, NOMBREVENDEDOR, PRECIOCOMPRADO, PUNTOVENTA_ID) values (42, '4/9/2019', 'Wolfie Rumbold', 3244, 6);
insert into REGISTROCOMPRAENTITY (id, FECHACOMPRA, NOMBREVENDEDOR, PRECIOCOMPRADO, PUNTOVENTA_ID) values (43, '4/20/2019', 'Latia Laurenceau', 4794, 7);
insert into REGISTROCOMPRAENTITY (id, FECHACOMPRA, NOMBREVENDEDOR, PRECIOCOMPRADO, PUNTOVENTA_ID) values (44, '7/21/2018', 'Ginnifer Coryndon', 3030, 2);
insert into REGISTROCOMPRAENTITY (id, FECHACOMPRA, NOMBREVENDEDOR, PRECIOCOMPRADO, PUNTOVENTA_ID) values (45, '11/9/2018', 'Lonnard Scollick', 3948, 4);
insert into REGISTROCOMPRAENTITY (id, FECHACOMPRA, NOMBREVENDEDOR, PRECIOCOMPRADO, PUNTOVENTA_ID) values (46, '4/29/2019', 'Sigmund Dumbell', 5526, 3);
insert into REGISTROCOMPRAENTITY (id, FECHACOMPRA, NOMBREVENDEDOR, PRECIOCOMPRADO, PUNTOVENTA_ID) values (47, '7/10/2018', 'Moshe Ebbin', 4927, 7);
insert into REGISTROCOMPRAENTITY (id, FECHACOMPRA, NOMBREVENDEDOR, PRECIOCOMPRADO, PUNTOVENTA_ID) values (48, '8/4/2018', 'Tamra Tebbs', 8706, 8);
insert into REGISTROCOMPRAENTITY (id, FECHACOMPRA, NOMBREVENDEDOR, PRECIOCOMPRADO, PUNTOVENTA_ID) values (49, '6/30/2018', 'Chelsae Knowlden', 5353, 5);
insert into REGISTROCOMPRAENTITY (id, FECHACOMPRA, NOMBREVENDEDOR, PRECIOCOMPRADO, PUNTOVENTA_ID) values (50, '8/27/2018', 'Ervin Redsull', 6201, 10);
insert into REGISTROCOMPRAENTITY (id, FECHACOMPRA, NOMBREVENDEDOR, PRECIOCOMPRADO, PUNTOVENTA_ID) values (51, '6/2/2018', 'Nicolais Royce', 2653, 7);
insert into REGISTROCOMPRAENTITY (id, FECHACOMPRA, NOMBREVENDEDOR, PRECIOCOMPRADO, PUNTOVENTA_ID) values (52, '10/7/2018', 'Luciana Siddon', 2133, 9);
insert into REGISTROCOMPRAENTITY (id, FECHACOMPRA, NOMBREVENDEDOR, PRECIOCOMPRADO, PUNTOVENTA_ID) values (53, '3/2/2019', 'Jervis Anning', 7196, 4);
insert into REGISTROCOMPRAENTITY (id, FECHACOMPRA, NOMBREVENDEDOR, PRECIOCOMPRADO, PUNTOVENTA_ID) values (54, '7/13/2018', 'Chev Roy', 7240, 7);
insert into REGISTROCOMPRAENTITY (id, FECHACOMPRA, NOMBREVENDEDOR, PRECIOCOMPRADO, PUNTOVENTA_ID) values (55, '6/2/2018', 'Jayme Livingston', 8452, 5);
insert into REGISTROCOMPRAENTITY (id, FECHACOMPRA, NOMBREVENDEDOR, PRECIOCOMPRADO, PUNTOVENTA_ID) values (56, '3/30/2019', 'Lonnie Antyukhin', 6881, 10);
insert into REGISTROCOMPRAENTITY (id, FECHACOMPRA, NOMBREVENDEDOR, PRECIOCOMPRADO, PUNTOVENTA_ID) values (57, '2/11/2019', 'Vivyan Ready', 3581, 6);
insert into REGISTROCOMPRAENTITY (id, FECHACOMPRA, NOMBREVENDEDOR, PRECIOCOMPRADO, PUNTOVENTA_ID) values (58, '6/12/2018', 'Anestassia Buttfield', 1507, 7);
insert into REGISTROCOMPRAENTITY (id, FECHACOMPRA, NOMBREVENDEDOR, PRECIOCOMPRADO, PUNTOVENTA_ID) values (59, '9/8/2018', 'Jobyna Klimowski', 7843, 8);
insert into REGISTROCOMPRAENTITY (id, FECHACOMPRA, NOMBREVENDEDOR, PRECIOCOMPRADO, PUNTOVENTA_ID) values (60, '7/27/2018', 'Odelle Brandin', 2043, 2);
insert into REGISTROCOMPRAENTITY (id, FECHACOMPRA, NOMBREVENDEDOR, PRECIOCOMPRADO, PUNTOVENTA_ID) values (61, '8/5/2018', 'Elsbeth Lathleiffure', 3454, 1);
insert into REGISTROCOMPRAENTITY (id, FECHACOMPRA, NOMBREVENDEDOR, PRECIOCOMPRADO, PUNTOVENTA_ID) values (62, '10/15/2018', 'Jaquelyn Wearn', 3233, 6);
insert into REGISTROCOMPRAENTITY (id, FECHACOMPRA, NOMBREVENDEDOR, PRECIOCOMPRADO, PUNTOVENTA_ID) values (63, '5/17/2018', 'Gabriel Bettis', 5647, 5);
insert into REGISTROCOMPRAENTITY (id, FECHACOMPRA, NOMBREVENDEDOR, PRECIOCOMPRADO, PUNTOVENTA_ID) values (64, '3/26/2019', 'Brynn Abercromby', 3684, 6);
insert into REGISTROCOMPRAENTITY (id, FECHACOMPRA, NOMBREVENDEDOR, PRECIOCOMPRADO, PUNTOVENTA_ID) values (65, '11/20/2018', 'Aluino Elgy', 8035, 10);
insert into REGISTROCOMPRAENTITY (id, FECHACOMPRA, NOMBREVENDEDOR, PRECIOCOMPRADO, PUNTOVENTA_ID) values (66, '8/2/2018', 'Dagmar Perry', 1718, 1);
insert into REGISTROCOMPRAENTITY (id, FECHACOMPRA, NOMBREVENDEDOR, PRECIOCOMPRADO, PUNTOVENTA_ID) values (67, '8/20/2018', 'Winny Jacob', 3494, 4);
insert into REGISTROCOMPRAENTITY (id, FECHACOMPRA, NOMBREVENDEDOR, PRECIOCOMPRADO, PUNTOVENTA_ID) values (68, '2/23/2019', 'Caitlin Theyer', 5748, 8);
insert into REGISTROCOMPRAENTITY (id, FECHACOMPRA, NOMBREVENDEDOR, PRECIOCOMPRADO, PUNTOVENTA_ID) values (69, '7/3/2018', 'Nicky Fitton', 2568, 10);
insert into REGISTROCOMPRAENTITY (id, FECHACOMPRA, NOMBREVENDEDOR, PRECIOCOMPRADO, PUNTOVENTA_ID) values (70, '12/6/2018', 'Isidore Brunker', 5766, 6);
insert into REGISTROCOMPRAENTITY (id, FECHACOMPRA, NOMBREVENDEDOR, PRECIOCOMPRADO, PUNTOVENTA_ID) values (71, '7/29/2018', 'Kirsten Gerasch', 7149, 2);
insert into REGISTROCOMPRAENTITY (id, FECHACOMPRA, NOMBREVENDEDOR, PRECIOCOMPRADO, PUNTOVENTA_ID) values (72, '6/3/2018', 'Guglielma Doud', 1128, 5);
insert into REGISTROCOMPRAENTITY (id, FECHACOMPRA, NOMBREVENDEDOR, PRECIOCOMPRADO, PUNTOVENTA_ID) values (73, '9/9/2018', 'Wilbert Grundwater', 6162, 7);
insert into REGISTROCOMPRAENTITY (id, FECHACOMPRA, NOMBREVENDEDOR, PRECIOCOMPRADO, PUNTOVENTA_ID) values (74, '3/3/2019', 'Shelagh Paulisch', 6844, 1);
insert into REGISTROCOMPRAENTITY (id, FECHACOMPRA, NOMBREVENDEDOR, PRECIOCOMPRADO, PUNTOVENTA_ID) values (75, '10/6/2018', 'Emalee Goss', 8490, 7);
insert into REGISTROCOMPRAENTITY (id, FECHACOMPRA, NOMBREVENDEDOR, PRECIOCOMPRADO, PUNTOVENTA_ID) values (76, '11/22/2018', 'Francklin O''Finan', 5009, 9);
insert into REGISTROCOMPRAENTITY (id, FECHACOMPRA, NOMBREVENDEDOR, PRECIOCOMPRADO, PUNTOVENTA_ID) values (77, '5/9/2018', 'Hort Riddett', 8190, 6);
insert into REGISTROCOMPRAENTITY (id, FECHACOMPRA, NOMBREVENDEDOR, PRECIOCOMPRADO, PUNTOVENTA_ID) values (78, '12/26/2018', 'Allsun Crosoer', 6017, 6);
insert into REGISTROCOMPRAENTITY (id, FECHACOMPRA, NOMBREVENDEDOR, PRECIOCOMPRADO, PUNTOVENTA_ID) values (79, '11/25/2018', 'Monro Stonbridge', 8204, 5);
insert into REGISTROCOMPRAENTITY (id, FECHACOMPRA, NOMBREVENDEDOR, PRECIOCOMPRADO, PUNTOVENTA_ID) values (80, '1/1/2019', 'Fleming Rosenfrucht', 4521, 7);
insert into REGISTROCOMPRAENTITY (id, FECHACOMPRA, NOMBREVENDEDOR, PRECIOCOMPRADO, PUNTOVENTA_ID) values (81, '6/15/2018', 'Eleanora Abbis', 7904, 1);
insert into REGISTROCOMPRAENTITY (id, FECHACOMPRA, NOMBREVENDEDOR, PRECIOCOMPRADO, PUNTOVENTA_ID) values (82, '5/27/2018', 'Rufe Pennycuick', 2222, 6);
insert into REGISTROCOMPRAENTITY (id, FECHACOMPRA, NOMBREVENDEDOR, PRECIOCOMPRADO, PUNTOVENTA_ID) values (83, '10/26/2018', 'Gris Ambroz', 4122, 10);
insert into REGISTROCOMPRAENTITY (id, FECHACOMPRA, NOMBREVENDEDOR, PRECIOCOMPRADO, PUNTOVENTA_ID) values (84, '5/28/2018', 'Catharina Jewar', 4519, 3);
insert into REGISTROCOMPRAENTITY (id, FECHACOMPRA, NOMBREVENDEDOR, PRECIOCOMPRADO, PUNTOVENTA_ID) values (85, '5/9/2018', 'Meta Giroldi', 4283, 5);
insert into REGISTROCOMPRAENTITY (id, FECHACOMPRA, NOMBREVENDEDOR, PRECIOCOMPRADO, PUNTOVENTA_ID) values (86, '9/16/2018', 'Tamar Joy', 4473, 4);
insert into REGISTROCOMPRAENTITY (id, FECHACOMPRA, NOMBREVENDEDOR, PRECIOCOMPRADO, PUNTOVENTA_ID) values (87, '8/26/2018', 'Franchot Mangon', 1258, 10);
insert into REGISTROCOMPRAENTITY (id, FECHACOMPRA, NOMBREVENDEDOR, PRECIOCOMPRADO, PUNTOVENTA_ID) values (88, '12/5/2018', 'Nita Brokenbrow', 5794, 3);
insert into REGISTROCOMPRAENTITY (id, FECHACOMPRA, NOMBREVENDEDOR, PRECIOCOMPRADO, PUNTOVENTA_ID) values (89, '3/5/2019', 'Clem Roze', 6757, 6);
insert into REGISTROCOMPRAENTITY (id, FECHACOMPRA, NOMBREVENDEDOR, PRECIOCOMPRADO, PUNTOVENTA_ID) values (90, '8/4/2018', 'Mead Leban', 4810, 7);
insert into REGISTROCOMPRAENTITY (id, FECHACOMPRA, NOMBREVENDEDOR, PRECIOCOMPRADO, PUNTOVENTA_ID) values (91, '6/8/2018', 'Howey Kettlestring', 8532, 7);
insert into REGISTROCOMPRAENTITY (id, FECHACOMPRA, NOMBREVENDEDOR, PRECIOCOMPRADO, PUNTOVENTA_ID) values (92, '3/26/2019', 'Schuyler Kopf', 4815, 5);
insert into REGISTROCOMPRAENTITY (id, FECHACOMPRA, NOMBREVENDEDOR, PRECIOCOMPRADO, PUNTOVENTA_ID) values (93, '7/11/2018', 'Ugo Simison', 7684, 9);
insert into REGISTROCOMPRAENTITY (id, FECHACOMPRA, NOMBREVENDEDOR, PRECIOCOMPRADO, PUNTOVENTA_ID) values (94, '7/30/2018', 'Dimitry Attoc', 3720, 10);
insert into REGISTROCOMPRAENTITY (id, FECHACOMPRA, NOMBREVENDEDOR, PRECIOCOMPRADO, PUNTOVENTA_ID) values (95, '10/15/2018', 'Zelda Foulsham', 6588, 7);
insert into REGISTROCOMPRAENTITY (id, FECHACOMPRA, NOMBREVENDEDOR, PRECIOCOMPRADO, PUNTOVENTA_ID) values (96, '5/15/2018', 'Inness Snar', 3312, 6);
insert into REGISTROCOMPRAENTITY (id, FECHACOMPRA, NOMBREVENDEDOR, PRECIOCOMPRADO, PUNTOVENTA_ID) values (97, '7/18/2018', 'Tarrance Mollitt', 2138, 4);
insert into REGISTROCOMPRAENTITY (id, FECHACOMPRA, NOMBREVENDEDOR, PRECIOCOMPRADO, PUNTOVENTA_ID) values (98, '10/28/2018', 'Shana Choffin', 5950, 2);
insert into REGISTROCOMPRAENTITY (id, FECHACOMPRA, NOMBREVENDEDOR, PRECIOCOMPRADO, PUNTOVENTA_ID) values (99, '3/28/2019', 'Clementine Botcherby', 3296, 6);
insert into REGISTROCOMPRAENTITY (id, FECHACOMPRA, NOMBREVENDEDOR, PRECIOCOMPRADO, PUNTOVENTA_ID) values (100, '5/12/2018', 'Rod McLarens', 6323, 9);

insert into AUTOMOVILENTITY (id,ANIO,COLOR,CUIDADMATRICULA,DISPONIBLE,IDCHASIS,MATRICULA,PRECIOVENTA,PUNTOVENTAID,RECORRIDO,REFERENCIA,TIPO,MODELO_ID,REGISTROCOMPRA_ID)
                             VALUES (1,2015,'Rojo','Bogotá',1,3256,'VGC-265',48000,1,60,'','Camioneta',2,1);
insert into AUTOMOVILENTITY (id,ANIO,COLOR,CUIDADMATRICULA,DISPONIBLE,IDCHASIS,MATRICULA,PRECIOVENTA,PUNTOVENTAID,RECORRIDO,REFERENCIA,TIPO,MODELO_ID,REGISTROCOMPRA_ID)
                             VALUES (2,2015,'Azul','Bogotá',1,1254,'HBT-236',70000,2,10,'','Camioneta',3,2);
insert into AUTOMOVILENTITY (id,ANIO,COLOR,CUIDADMATRICULA,DISPONIBLE,IDCHASIS,MATRICULA,PRECIOVENTA,PUNTOVENTAID,RECORRIDO,REFERENCIA,TIPO,MODELO_ID,REGISTROCOMPRA_ID)
                             VALUES (3,2015,'Dorado','Bogotá',1,5236,'CDR-265',30000,1,16,'','Camioneta',2,1);
insert into AUTOMOVILENTITY (id,ANIO,COLOR,CUIDADMATRICULA,DISPONIBLE,IDCHASIS,MATRICULA,PRECIOVENTA,PUNTOVENTAID,RECORRIDO,REFERENCIA,TIPO,MODELO_ID,REGISTROCOMPRA_ID)
                             VALUES (4,2015,'Gris','Bogotá',1,6594,'VGC-696',36000,2,35,'','Camioneta',2,1);


insert into AUTOMOVILENTITY (ID, ANIO, COLOR, CUIDADMATRICULA, MATRICULA, PUNTOVENTAID, MODELO_ID, REGISTROCOMPRA_ID) values (5, 2009, 'Goldenrod', 'Drien Rampak', 'MYS-437', 9, 40, 5);
insert into AUTOMOVILENTITY (ID, ANIO, COLOR, CUIDADMATRICULA, MATRICULA, PUNTOVENTAID, MODELO_ID, REGISTROCOMPRA_ID) values (6, 1993, 'Red', 'Dengyue', 'DZU-172', 2, 28, 6);
insert into AUTOMOVILENTITY (ID, ANIO, COLOR, CUIDADMATRICULA, MATRICULA, PUNTOVENTAID, MODELO_ID, REGISTROCOMPRA_ID) values (7, 1991, 'Teal', 'Sanxiang', 'KZQ-909', 3, 36, 7);
insert into AUTOMOVILENTITY (ID, ANIO, COLOR, CUIDADMATRICULA, MATRICULA, PUNTOVENTAID, MODELO_ID, REGISTROCOMPRA_ID) values (8, 1990, 'Green', 'Tangjiapo', 'NVF-463', 3, 39, 8);
insert into AUTOMOVILENTITY (ID, ANIO, COLOR, CUIDADMATRICULA, MATRICULA, PUNTOVENTAID, MODELO_ID, REGISTROCOMPRA_ID) values (9, 2001, 'Indigo', 'Gaula', 'TYW-194', 3, 50, 9);
insert into AUTOMOVILENTITY (ID, ANIO, COLOR, CUIDADMATRICULA, MATRICULA, PUNTOVENTAID, MODELO_ID, REGISTROCOMPRA_ID) values (10, 1997, 'Mauv', 'Peddie', 'PPB-373', 8, 16, 10);
insert into AUTOMOVILENTITY (ID, ANIO, COLOR, CUIDADMATRICULA, MATRICULA, PUNTOVENTAID, MODELO_ID, REGISTROCOMPRA_ID) values (11, 2009, 'Fuscia', 'Rockford', 'GJZ-670', 1, 34, 11);
insert into AUTOMOVILENTITY (ID, ANIO, COLOR, CUIDADMATRICULA, MATRICULA, PUNTOVENTAID, MODELO_ID, REGISTROCOMPRA_ID) values (12, 2002, 'Puce', 'Pankshin', 'HYZ-060', 6, 8, 12);
insert into AUTOMOVILENTITY (ID, ANIO, COLOR, CUIDADMATRICULA, MATRICULA, PUNTOVENTAID, MODELO_ID, REGISTROCOMPRA_ID) values (13, 1995, 'Aquamarine', 'Jianshan', 'XXP-796', 4, 7, 13);
insert into AUTOMOVILENTITY (ID, ANIO, COLOR, CUIDADMATRICULA, MATRICULA, PUNTOVENTAID, MODELO_ID, REGISTROCOMPRA_ID) values (14, 2001, 'Red', 'Hetai', 'CKM-788', 6, 44, 14);
insert into AUTOMOVILENTITY (ID, ANIO, COLOR, CUIDADMATRICULA, MATRICULA, PUNTOVENTAID, MODELO_ID, REGISTROCOMPRA_ID) values (15, 1997, 'Green', 'Syrostan', 'HEX-716', 6, 3, 15);
insert into AUTOMOVILENTITY (ID, ANIO, COLOR, CUIDADMATRICULA, MATRICULA, PUNTOVENTAID, MODELO_ID, REGISTROCOMPRA_ID) values (16, 2012, 'Orange', 'Ash Shaykh ‘Uthmān', 'JLV-605', 6, 4, 16);
insert into AUTOMOVILENTITY (ID, ANIO, COLOR, CUIDADMATRICULA, MATRICULA, PUNTOVENTAID, MODELO_ID, REGISTROCOMPRA_ID) values (17, 2002, 'Puce', 'Welisara', 'DKI-144', 1, 22, 17);
insert into AUTOMOVILENTITY (ID, ANIO, COLOR, CUIDADMATRICULA, MATRICULA, PUNTOVENTAID, MODELO_ID, REGISTROCOMPRA_ID) values (18, 1992, 'Blue', 'Francisco Villa', 'URB-827', 10, 43, 18);
insert into AUTOMOVILENTITY (ID, ANIO, COLOR, CUIDADMATRICULA, MATRICULA, PUNTOVENTAID, MODELO_ID, REGISTROCOMPRA_ID) values (19, 1994, 'Orange', 'Kyperoúnta', 'DBE-183', 1, 25, 19);
insert into AUTOMOVILENTITY (ID, ANIO, COLOR, CUIDADMATRICULA, MATRICULA, PUNTOVENTAID, MODELO_ID, REGISTROCOMPRA_ID) values (20, 1995, 'Aquamarine', 'Abelheira', 'PDB-925', 3, 19, 20);
insert into AUTOMOVILENTITY (ID, ANIO, COLOR, CUIDADMATRICULA, MATRICULA, PUNTOVENTAID, MODELO_ID, REGISTROCOMPRA_ID) values (21, 1996, 'Red', 'Cibatu', 'HDE-943', 10, 27, 21);
insert into AUTOMOVILENTITY (ID, ANIO, COLOR, CUIDADMATRICULA, MATRICULA, PUNTOVENTAID, MODELO_ID, REGISTROCOMPRA_ID) values (22, 1996, 'Indigo', 'Agoo', 'GUH-193', 9, 7, 22);
insert into AUTOMOVILENTITY (ID, ANIO, COLOR, CUIDADMATRICULA, MATRICULA, PUNTOVENTAID, MODELO_ID, REGISTROCOMPRA_ID) values (23, 2008, 'Green', 'Santa Cruz La Laguna', 'WQD-905', 6, 29, 23);
insert into AUTOMOVILENTITY (ID, ANIO, COLOR, CUIDADMATRICULA, MATRICULA, PUNTOVENTAID, MODELO_ID, REGISTROCOMPRA_ID) values (24, 2005, 'Yellow', 'Tonota', 'KYO-932', 9, 34, 24);
insert into AUTOMOVILENTITY (ID, ANIO, COLOR, CUIDADMATRICULA, MATRICULA, PUNTOVENTAID, MODELO_ID, REGISTROCOMPRA_ID) values (25, 2003, 'Goldenrod', 'Amsterdam Noord west', 'EXI-104', 5, 48, 25);
insert into AUTOMOVILENTITY (ID, ANIO, COLOR, CUIDADMATRICULA, MATRICULA, PUNTOVENTAID, MODELO_ID, REGISTROCOMPRA_ID) values (26, 2008, 'Crimson', 'Yongding', 'ZUR-933', 2, 39, 26);
insert into AUTOMOVILENTITY (ID, ANIO, COLOR, CUIDADMATRICULA, MATRICULA, PUNTOVENTAID, MODELO_ID, REGISTROCOMPRA_ID) values (27, 2009, 'Green', 'Várzea', 'UUI-419', 4, 11, 27);
insert into AUTOMOVILENTITY (ID, ANIO, COLOR, CUIDADMATRICULA, MATRICULA, PUNTOVENTAID, MODELO_ID, REGISTROCOMPRA_ID) values (28, 1997, 'Aquamarine', 'Zhaocun', 'OYE-367', 1, 46, 28);
insert into AUTOMOVILENTITY (ID, ANIO, COLOR, CUIDADMATRICULA, MATRICULA, PUNTOVENTAID, MODELO_ID, REGISTROCOMPRA_ID) values (29, 1996, 'Blue', 'Xinsheng', 'HLA-979', 5, 18, 29);
insert into AUTOMOVILENTITY (ID, ANIO, COLOR, CUIDADMATRICULA, MATRICULA, PUNTOVENTAID, MODELO_ID, REGISTROCOMPRA_ID) values (30, 2011, 'Blue', 'Maguan', 'NVG-766', 1, 1, 30);
insert into AUTOMOVILENTITY (ID, ANIO, COLOR, CUIDADMATRICULA, MATRICULA, PUNTOVENTAID, MODELO_ID, REGISTROCOMPRA_ID) values (31, 1992, 'Puce', 'Крушево', 'UXR-540', 6, 19, 31);
insert into AUTOMOVILENTITY (ID, ANIO, COLOR, CUIDADMATRICULA, MATRICULA, PUNTOVENTAID, MODELO_ID, REGISTROCOMPRA_ID) values (32, 2002, 'Turquoise', 'Aviúges', 'ZPB-072', 2, 1, 32);
insert into AUTOMOVILENTITY (ID, ANIO, COLOR, CUIDADMATRICULA, MATRICULA, PUNTOVENTAID, MODELO_ID, REGISTROCOMPRA_ID) values (33, 1994, 'Fuscia', 'Timoulilt', 'FTE-438', 2, 47, 33);
insert into AUTOMOVILENTITY (ID, ANIO, COLOR, CUIDADMATRICULA, MATRICULA, PUNTOVENTAID, MODELO_ID, REGISTROCOMPRA_ID) values (34, 2002, 'Blue', 'Zaragoza', 'JHD-077', 4, 26, 34);
insert into AUTOMOVILENTITY (ID, ANIO, COLOR, CUIDADMATRICULA, MATRICULA, PUNTOVENTAID, MODELO_ID, REGISTROCOMPRA_ID) values (35, 2009, 'Red', 'Ovacik', 'AFM-522', 9, 29, 35);
insert into AUTOMOVILENTITY (ID, ANIO, COLOR, CUIDADMATRICULA, MATRICULA, PUNTOVENTAID, MODELO_ID, REGISTROCOMPRA_ID) values (36, 2013, 'Khaki', 'Taizi', 'IKB-574', 9, 8, 36);
insert into AUTOMOVILENTITY (ID, ANIO, COLOR, CUIDADMATRICULA, MATRICULA, PUNTOVENTAID, MODELO_ID, REGISTROCOMPRA_ID) values (37, 1993, 'Blue', 'Staraya Russa', 'ULX-808', 3, 22, 37);
insert into AUTOMOVILENTITY (ID, ANIO, COLOR, CUIDADMATRICULA, MATRICULA, PUNTOVENTAID, MODELO_ID, REGISTROCOMPRA_ID) values (38, 1989, 'Blue', 'Zhanping', 'KYA-667', 5, 44, 38);
insert into AUTOMOVILENTITY (ID, ANIO, COLOR, CUIDADMATRICULA, MATRICULA, PUNTOVENTAID, MODELO_ID, REGISTROCOMPRA_ID) values (39, 1998, 'Goldenrod', 'Fier-Çifçi', 'HVH-891', 9, 38, 39);
insert into AUTOMOVILENTITY (ID, ANIO, COLOR, CUIDADMATRICULA, MATRICULA, PUNTOVENTAID, MODELO_ID, REGISTROCOMPRA_ID) values (40, 2008, 'Yellow', 'Quebo', 'WPG-287', 10, 13, 40);
insert into AUTOMOVILENTITY (ID, ANIO, COLOR, CUIDADMATRICULA, MATRICULA, PUNTOVENTAID, MODELO_ID, REGISTROCOMPRA_ID) values (41, 1993, 'Blue', 'Nantang', 'QVD-235', 8, 11, 41);
insert into AUTOMOVILENTITY (ID, ANIO, COLOR, CUIDADMATRICULA, MATRICULA, PUNTOVENTAID, MODELO_ID, REGISTROCOMPRA_ID) values (42, 2011, 'Crimson', 'Haikou', 'DQX-755', 1, 19, 42);
insert into AUTOMOVILENTITY (ID, ANIO, COLOR, CUIDADMATRICULA, MATRICULA, PUNTOVENTAID, MODELO_ID, REGISTROCOMPRA_ID) values (43, 2004, 'Crimson', 'Opinogóra Górna', 'NAL-485', 3, 12, 43);
insert into AUTOMOVILENTITY (ID, ANIO, COLOR, CUIDADMATRICULA, MATRICULA, PUNTOVENTAID, MODELO_ID, REGISTROCOMPRA_ID) values (44, 2011, 'Khaki', 'Capitão Poço', 'SYW-482', 7, 4, 44);
insert into AUTOMOVILENTITY (ID, ANIO, COLOR, CUIDADMATRICULA, MATRICULA, PUNTOVENTAID, MODELO_ID, REGISTROCOMPRA_ID) values (45, 1996, 'Goldenrod', 'West Kelowna', 'XMV-555', 5, 47, 45);
insert into AUTOMOVILENTITY (ID, ANIO, COLOR, CUIDADMATRICULA, MATRICULA, PUNTOVENTAID, MODELO_ID, REGISTROCOMPRA_ID) values (46, 1992, 'Aquamarine', 'Drachten', 'EKR-525', 10, 49, 46);
insert into AUTOMOVILENTITY (ID, ANIO, COLOR, CUIDADMATRICULA, MATRICULA, PUNTOVENTAID, MODELO_ID, REGISTROCOMPRA_ID) values (47, 2009, 'Maroon', 'Mikhaylovsk', 'NDL-524', 10, 34, 47);
insert into AUTOMOVILENTITY (ID, ANIO, COLOR, CUIDADMATRICULA, MATRICULA, PUNTOVENTAID, MODELO_ID, REGISTROCOMPRA_ID) values (48, 1985, 'Teal', 'Xibin', 'PMO-426', 4, 20, 48);
insert into AUTOMOVILENTITY (ID, ANIO, COLOR, CUIDADMATRICULA, MATRICULA, PUNTOVENTAID, MODELO_ID, REGISTROCOMPRA_ID) values (49, 2007, 'Mauv', 'Taungoo', 'IFS-976', 4, 48, 49);
insert into AUTOMOVILENTITY (ID, ANIO, COLOR, CUIDADMATRICULA, MATRICULA, PUNTOVENTAID, MODELO_ID, REGISTROCOMPRA_ID) values (50, 2010, 'Yellow', 'Qiziltepa Shahri', 'SMY-754', 7, 1, 50);
insert into AUTOMOVILENTITY (ID, ANIO, COLOR, CUIDADMATRICULA, MATRICULA, PUNTOVENTAID, MODELO_ID, REGISTROCOMPRA_ID) values (51, 2000, 'Pink', 'Pordapor Barat', 'ECY-581', 1, 7, 51);
insert into AUTOMOVILENTITY (ID, ANIO, COLOR, CUIDADMATRICULA, MATRICULA, PUNTOVENTAID, MODELO_ID, REGISTROCOMPRA_ID) values (52, 2002, 'Orange', 'Jiantou', 'WGV-389', 5, 19, 52);
insert into AUTOMOVILENTITY (ID, ANIO, COLOR, CUIDADMATRICULA, MATRICULA, PUNTOVENTAID, MODELO_ID, REGISTROCOMPRA_ID) values (53, 2008, 'Green', 'Al Ghandūrah', 'IBR-677', 9, 36, 53);
insert into AUTOMOVILENTITY (ID, ANIO, COLOR, CUIDADMATRICULA, MATRICULA, PUNTOVENTAID, MODELO_ID, REGISTROCOMPRA_ID) values (54, 2002, 'Aquamarine', 'Poxi', 'IAY-053', 4, 45, 54);
insert into AUTOMOVILENTITY (ID, ANIO, COLOR, CUIDADMATRICULA, MATRICULA, PUNTOVENTAID, MODELO_ID, REGISTROCOMPRA_ID) values (55, 1993, 'Maroon', 'Xinning', 'LVF-460', 4, 45, 55);
insert into AUTOMOVILENTITY (ID, ANIO, COLOR, CUIDADMATRICULA, MATRICULA, PUNTOVENTAID, MODELO_ID, REGISTROCOMPRA_ID) values (56, 1959, 'Purple', 'Aime', 'ESN-382', 10, 3, 56);
insert into AUTOMOVILENTITY (ID, ANIO, COLOR, CUIDADMATRICULA, MATRICULA, PUNTOVENTAID, MODELO_ID, REGISTROCOMPRA_ID) values (57, 1989, 'Goldenrod', 'Siwa Oasis', 'CYD-941', 1, 15, 57);
insert into AUTOMOVILENTITY (ID, ANIO, COLOR, CUIDADMATRICULA, MATRICULA, PUNTOVENTAID, MODELO_ID, REGISTROCOMPRA_ID) values (58, 2004, 'Green', 'Belo Oriente', 'IAC-691', 9, 21, 58);
insert into AUTOMOVILENTITY (ID, ANIO, COLOR, CUIDADMATRICULA, MATRICULA, PUNTOVENTAID, MODELO_ID, REGISTROCOMPRA_ID) values (59, 2000, 'Khaki', 'Mozelos', 'THS-227', 8, 15, 59);
insert into AUTOMOVILENTITY (ID, ANIO, COLOR, CUIDADMATRICULA, MATRICULA, PUNTOVENTAID, MODELO_ID, REGISTROCOMPRA_ID) values (60, 2012, 'Crimson', 'Skomlin', 'GKX-469', 1, 46, 60);
insert into AUTOMOVILENTITY (ID, ANIO, COLOR, CUIDADMATRICULA, MATRICULA, PUNTOVENTAID, MODELO_ID, REGISTROCOMPRA_ID) values (61, 2003, 'Mauv', 'Bairro do Margaça', 'IZG-999', 7, 20, 61);
insert into AUTOMOVILENTITY (ID, ANIO, COLOR, CUIDADMATRICULA, MATRICULA, PUNTOVENTAID, MODELO_ID, REGISTROCOMPRA_ID) values (62, 1982, 'Teal', 'Kendung Timur', 'LLR-216', 7, 41, 62);
insert into AUTOMOVILENTITY (ID, ANIO, COLOR, CUIDADMATRICULA, MATRICULA, PUNTOVENTAID, MODELO_ID, REGISTROCOMPRA_ID) values (63, 1993, 'Yellow', 'Giporlos', 'RTK-271', 2, 23, 63);
insert into AUTOMOVILENTITY (ID, ANIO, COLOR, CUIDADMATRICULA, MATRICULA, PUNTOVENTAID, MODELO_ID, REGISTROCOMPRA_ID) values (64, 2003, 'Puce', 'Dumbéa', 'KBS-714', 2, 23, 64);
insert into AUTOMOVILENTITY (ID, ANIO, COLOR, CUIDADMATRICULA, MATRICULA, PUNTOVENTAID, MODELO_ID, REGISTROCOMPRA_ID) values (65, 2011, 'Mauv', 'Chernivtsi', 'HMT-116', 8, 16, 65);
insert into AUTOMOVILENTITY (ID, ANIO, COLOR, CUIDADMATRICULA, MATRICULA, PUNTOVENTAID, MODELO_ID, REGISTROCOMPRA_ID) values (66, 1998, 'Turquoise', 'Nagbalaye', 'LMP-452', 1, 46, 66);
insert into AUTOMOVILENTITY (ID, ANIO, COLOR, CUIDADMATRICULA, MATRICULA, PUNTOVENTAID, MODELO_ID, REGISTROCOMPRA_ID) values (67, 2000, 'Violet', 'Mangochi', 'SBG-103', 4, 25, 67);
insert into AUTOMOVILENTITY (ID, ANIO, COLOR, CUIDADMATRICULA, MATRICULA, PUNTOVENTAID, MODELO_ID, REGISTROCOMPRA_ID) values (68, 1993, 'Maroon', 'Alabat', 'WRF-862', 2, 31, 68);
insert into AUTOMOVILENTITY (ID, ANIO, COLOR, CUIDADMATRICULA, MATRICULA, PUNTOVENTAID, MODELO_ID, REGISTROCOMPRA_ID) values (69, 2002, 'Puce', 'Donnacona', 'XAU-351', 2, 9, 69);
insert into AUTOMOVILENTITY (ID, ANIO, COLOR, CUIDADMATRICULA, MATRICULA, PUNTOVENTAID, MODELO_ID, REGISTROCOMPRA_ID) values (70, 2009, 'Orange', 'Santa Cruz Muluá', 'YII-809', 8, 24, 70);
insert into AUTOMOVILENTITY (ID, ANIO, COLOR, CUIDADMATRICULA, MATRICULA, PUNTOVENTAID, MODELO_ID, REGISTROCOMPRA_ID) values (71, 2000, 'Violet', 'Bangshipu', 'RAQ-031', 4, 4, 71);
insert into AUTOMOVILENTITY (ID, ANIO, COLOR, CUIDADMATRICULA, MATRICULA, PUNTOVENTAID, MODELO_ID, REGISTROCOMPRA_ID) values (72, 1993, 'Blue', 'Estrada', 'FOU-453', 4, 48, 72);
insert into AUTOMOVILENTITY (ID, ANIO, COLOR, CUIDADMATRICULA, MATRICULA, PUNTOVENTAID, MODELO_ID, REGISTROCOMPRA_ID) values (73, 2006, 'Yellow', 'Fulin', 'CDQ-844', 6, 2, 73);
insert into AUTOMOVILENTITY (ID, ANIO, COLOR, CUIDADMATRICULA, MATRICULA, PUNTOVENTAID, MODELO_ID, REGISTROCOMPRA_ID) values (74, 1997, 'Puce', 'Dampit', 'BEJ-899', 6, 43, 74);
insert into AUTOMOVILENTITY (ID, ANIO, COLOR, CUIDADMATRICULA, MATRICULA, PUNTOVENTAID, MODELO_ID, REGISTROCOMPRA_ID) values (75, 1991, 'Aquamarine', 'Osasco', 'QZD-225', 2, 40, 75);
insert into AUTOMOVILENTITY (ID, ANIO, COLOR, CUIDADMATRICULA, MATRICULA, PUNTOVENTAID, MODELO_ID, REGISTROCOMPRA_ID) values (76, 2011, 'Green', 'Lebak', 'ALP-823', 9, 34, 76);
insert into AUTOMOVILENTITY (ID, ANIO, COLOR, CUIDADMATRICULA, MATRICULA, PUNTOVENTAID, MODELO_ID, REGISTROCOMPRA_ID) values (77, 1992, 'Pink', 'Chełm', 'PPJ-611', 2, 32, 77);
insert into AUTOMOVILENTITY (ID, ANIO, COLOR, CUIDADMATRICULA, MATRICULA, PUNTOVENTAID, MODELO_ID, REGISTROCOMPRA_ID) values (78, 2003, 'Khaki', 'Mboursou Léré', 'FFQ-016', 1, 24, 78);
insert into AUTOMOVILENTITY (ID, ANIO, COLOR, CUIDADMATRICULA, MATRICULA, PUNTOVENTAID, MODELO_ID, REGISTROCOMPRA_ID) values (79, 1997, 'Orange', 'Xin’an', 'QLD-828', 1, 8, 79);
insert into AUTOMOVILENTITY (ID, ANIO, COLOR, CUIDADMATRICULA, MATRICULA, PUNTOVENTAID, MODELO_ID, REGISTROCOMPRA_ID) values (80, 1989, 'Goldenrod', 'Hushan', 'DZS-592', 4, 11, 80);
insert into AUTOMOVILENTITY (ID, ANIO, COLOR, CUIDADMATRICULA, MATRICULA, PUNTOVENTAID, MODELO_ID, REGISTROCOMPRA_ID) values (81, 1992, 'Yellow', 'Čajniče', 'WMH-906', 8, 46, 81);
insert into AUTOMOVILENTITY (ID, ANIO, COLOR, CUIDADMATRICULA, MATRICULA, PUNTOVENTAID, MODELO_ID, REGISTROCOMPRA_ID) values (82, 2008, 'Turquoise', 'Kuala Lumpur', 'ARC-054', 9, 45, 82);
insert into AUTOMOVILENTITY (ID, ANIO, COLOR, CUIDADMATRICULA, MATRICULA, PUNTOVENTAID, MODELO_ID, REGISTROCOMPRA_ID) values (83, 1993, 'Turquoise', 'Lakbok', 'QKJ-944', 7, 21, 83);
insert into AUTOMOVILENTITY (ID, ANIO, COLOR, CUIDADMATRICULA, MATRICULA, PUNTOVENTAID, MODELO_ID, REGISTROCOMPRA_ID) values (84, 2012, 'Crimson', 'Mobile', 'DZY-215', 9, 31, 84);
insert into AUTOMOVILENTITY (ID, ANIO, COLOR, CUIDADMATRICULA, MATRICULA, PUNTOVENTAID, MODELO_ID, REGISTROCOMPRA_ID) values (85, 1985, 'Green', 'Matinha', 'COM-187', 3, 50, 85);
insert into AUTOMOVILENTITY (ID, ANIO, COLOR, CUIDADMATRICULA, MATRICULA, PUNTOVENTAID, MODELO_ID, REGISTROCOMPRA_ID) values (86, 1987, 'Aquamarine', 'Ouagadougou', 'CFI-381', 7, 2, 86);
insert into AUTOMOVILENTITY (ID, ANIO, COLOR, CUIDADMATRICULA, MATRICULA, PUNTOVENTAID, MODELO_ID, REGISTROCOMPRA_ID) values (87, 2006, 'Teal', 'Mirny', 'ZCK-659', 10, 41, 87);
insert into AUTOMOVILENTITY (ID, ANIO, COLOR, CUIDADMATRICULA, MATRICULA, PUNTOVENTAID, MODELO_ID, REGISTROCOMPRA_ID) values (88, 1998, 'Mauv', 'Novhorodka', 'RJF-856', 7, 28, 88);
insert into AUTOMOVILENTITY (ID, ANIO, COLOR, CUIDADMATRICULA, MATRICULA, PUNTOVENTAID, MODELO_ID, REGISTROCOMPRA_ID) values (89, 2009, 'Violet', 'Malitbog', 'WSZ-768', 1, 38, 89);
insert into AUTOMOVILENTITY (ID, ANIO, COLOR, CUIDADMATRICULA, MATRICULA, PUNTOVENTAID, MODELO_ID, REGISTROCOMPRA_ID) values (90, 2009, 'Indigo', 'Acheng', 'PON-698', 4, 17, 90);
insert into AUTOMOVILENTITY (ID, ANIO, COLOR, CUIDADMATRICULA, MATRICULA, PUNTOVENTAID, MODELO_ID, REGISTROCOMPRA_ID) values (91, 2010, 'Blue', 'Verkhnya Rozhanka', 'CYP-476', 7, 12, 91);
insert into AUTOMOVILENTITY (ID, ANIO, COLOR, CUIDADMATRICULA, MATRICULA, PUNTOVENTAID, MODELO_ID, REGISTROCOMPRA_ID) values (92, 2003, 'Red', 'Lubukgadang', 'BEF-728', 8, 33, 92);
insert into AUTOMOVILENTITY (ID, ANIO, COLOR, CUIDADMATRICULA, MATRICULA, PUNTOVENTAID, MODELO_ID, REGISTROCOMPRA_ID) values (93, 1993, 'Puce', 'Ghayl Bā Wazīr', 'FUG-600', 9, 27, 93);
insert into AUTOMOVILENTITY (ID, ANIO, COLOR, CUIDADMATRICULA, MATRICULA, PUNTOVENTAID, MODELO_ID, REGISTROCOMPRA_ID) values (94, 1987, 'Pink', 'Zhigulevsk', 'WUJ-842', 3, 2, 94);
insert into AUTOMOVILENTITY (ID, ANIO, COLOR, CUIDADMATRICULA, MATRICULA, PUNTOVENTAID, MODELO_ID, REGISTROCOMPRA_ID) values (95, 2000, 'Aquamarine', 'Yangtan', 'QFN-267', 10, 49, 95);
insert into AUTOMOVILENTITY (ID, ANIO, COLOR, CUIDADMATRICULA, MATRICULA, PUNTOVENTAID, MODELO_ID, REGISTROCOMPRA_ID) values (96, 2000, 'Fuscia', 'Karlstad', 'MSK-183', 6, 10, 96);
insert into AUTOMOVILENTITY (ID, ANIO, COLOR, CUIDADMATRICULA, MATRICULA, PUNTOVENTAID, MODELO_ID, REGISTROCOMPRA_ID) values (97, 1987, 'Orange', 'Shiye', 'PNA-431', 6, 13, 97);
insert into AUTOMOVILENTITY (ID, ANIO, COLOR, CUIDADMATRICULA, MATRICULA, PUNTOVENTAID, MODELO_ID, REGISTROCOMPRA_ID) values (98, 2008, 'Orange', 'Zapala', 'ICD-898', 5, 32, 98);
insert into AUTOMOVILENTITY (ID, ANIO, COLOR, CUIDADMATRICULA, MATRICULA, PUNTOVENTAID, MODELO_ID, REGISTROCOMPRA_ID) values (99, 2003, 'Crimson', 'Kikinda', 'UAO-356', 7, 41, 99);
insert into AUTOMOVILENTITY (ID, ANIO, COLOR, CUIDADMATRICULA, MATRICULA, PUNTOVENTAID, MODELO_ID, REGISTROCOMPRA_ID) values (100, 1989, 'Yellow', 'Basel', 'HWD-695', 10, 12, 100);

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
insert into FACTURAENTITY (ID,CUENTAORIGEN,FECHA,COMPRAVENTA_ID) VALUES (2,652300048523,'2018-06-20',2);
insert into FACTURAENTITY (ID,CUENTAORIGEN,FECHA,COMPRAVENTA_ID) VALUES (3,978500049511,'2018-07-18',3);
insert into FACTURAENTITY (ID,CUENTAORIGEN,FECHA,COMPRAVENTA_ID) VALUES (4,325400043645,'2018-06-24',4);
