delete from LineaParadas;
delete from LineaHorarios;
delete from Parada;
delete from Horario;
delete from Linea;
delete from Autobus;


ALTER TABLE Parada AUTO_INCREMENT = 1;
ALTER TABLE Horario AUTO_INCREMENT = 1;
ALTER TABLE Linea AUTO_INCREMENT = 1;
ALTER TABLE Autobus AUTO_INCREMENT = 1;
ALTER TABLE LineaParadas AUTO_INCREMENT = 1;



insert into Parada(nombreParada,coordenadas) values("Calle Valladolid","42.853633,-2.664004");
insert into Parada(nombreParada,coordenadas) values("El Corte Inglés", "42.843619,-2.677219");
insert into Parada(nombreParada,coordenadas) values("UPV/EHU Campus Álava", "42.838459,-2.668689");
insert into Parada(nombreParada,coordenadas) values("Juzgados","42.843595,-2.682519");
insert into Parada(nombreParada,coordenadas) values("Europa", "42.852234,-2.680375");
insert into Parada(nombreParada,coordenadas) values("Lakua", "42.860372,-2.682175");
insert into Parada(nombreParada,coordenadas) values("San Mamés", "43.262793,-2.950555");
insert into Parada(nombreParada,coordenadas) values("Deusto", "43.271020,-2.941757");
insert into Parada(nombreParada,coordenadas) values("Sarriko","43.274391,-2.957911");
insert into Parada(nombreParada,coordenadas) values("Leioa","43.330967,-2.969909");
select * from Parada;

insert into Horario(hora) value("6:20");
insert into Horario(hora) value("7:10");
insert into Horario(hora) value("8:15");
insert into Horario(hora) value("12:10");
insert into Horario(hora) value("12:20");
insert into Horario(hora) value("13:10");
insert into Horario(hora) value("13:20");
insert into Horario(hora) value("14:10");
insert into Horario(hora) value("14:20");
insert into Horario(hora) value("15:10");
insert into Horario(hora) value("17:10");
insert into Horario(hora) value("18:10");
insert into Horario(hora) value("19:10");
insert into Horario(hora) value("20:10");
insert into Horario(hora) value("21:10");
select * from Horario;

insert into Autobus(coordenadas) values ("0.000000,0.000000");
select * from Autobus;


insert into Linea(origenDestino, Autobus_idAutobus) values ("Vitoria-Bilbao", "1");
insert into Linea(origenDestino, Autobus_idAutobus) values ("Vitoria-Leioa", "1");
insert into Linea(origenDestino, Autobus_idAutobus) values ("Bilbao-Vitoria", "1");
insert into Linea(origenDestino, Autobus_idAutobus) values ("Leioa-Vitoria", "1");
select * from Linea;

insert into LineaParadas(Parada_idParada, Linea_idLinea) values("1","1");
insert into LineaParadas(Parada_idParada, Linea_idLinea) values("2","1");
insert into LineaParadas(Parada_idParada, Linea_idLinea) values("3","1");
insert into LineaParadas(Parada_idParada, Linea_idLinea) values("4","1");
insert into LineaParadas(Parada_idParada, Linea_idLinea) values("5","1");
insert into LineaParadas(Parada_idParada, Linea_idLinea) values("6","1");
insert into LineaParadas(Parada_idParada, Linea_idLinea) values("7","1");
insert into LineaParadas(Parada_idParada, Linea_idLinea) values("8","1");
insert into LineaParadas(Parada_idParada, Linea_idLinea) values("9","1");

insert into LineaParadas(Parada_idParada, Linea_idLinea) values("1","3");
insert into LineaParadas(Parada_idParada, Linea_idLinea) values("2","3");
insert into LineaParadas(Parada_idParada, Linea_idLinea) values("3","3");
insert into LineaParadas(Parada_idParada, Linea_idLinea) values("4","3");
insert into LineaParadas(Parada_idParada, Linea_idLinea) values("5","3");
insert into LineaParadas(Parada_idParada, Linea_idLinea) values("6","3");
insert into LineaParadas(Parada_idParada, Linea_idLinea) values("7","3");
insert into LineaParadas(Parada_idParada, Linea_idLinea) values("8","3");
insert into LineaParadas(Parada_idParada, Linea_idLinea) values("9","3");

insert into LineaParadas(Parada_idParada, Linea_idLinea) values("1","2");
insert into LineaParadas(Parada_idParada, Linea_idLinea) values("2","2");
insert into LineaParadas(Parada_idParada, Linea_idLinea) values("3","2");
insert into LineaParadas(Parada_idParada, Linea_idLinea) values("4","2");
insert into LineaParadas(Parada_idParada, Linea_idLinea) values("5","2");
insert into LineaParadas(Parada_idParada, Linea_idLinea) values("6","2");
insert into LineaParadas(Parada_idParada, Linea_idLinea) values("10","2");

insert into LineaParadas(Parada_idParada, Linea_idLinea) values("1","4");
insert into LineaParadas(Parada_idParada, Linea_idLinea) values("2","4");
insert into LineaParadas(Parada_idParada, Linea_idLinea) values("3","4");
insert into LineaParadas(Parada_idParada, Linea_idLinea) values("4","4");
insert into LineaParadas(Parada_idParada, Linea_idLinea) values("5","4");
insert into LineaParadas(Parada_idParada, Linea_idLinea) values("6","4");
insert into LineaParadas(Parada_idParada, Linea_idLinea) values("10","4");
select * from LineaParadas;



insert into LineaHorarios(Horario_idHorario, Linea_idLinea) values("1","1");
insert into LineaHorarios(Horario_idHorario, Linea_idLinea) values("2","1");
insert into LineaHorarios(Horario_idHorario, Linea_idLinea) values("3","1");
insert into LineaHorarios(Horario_idHorario, Linea_idLinea) values("5","1");
insert into LineaHorarios(Horario_idHorario, Linea_idLinea) values("7","1");
insert into LineaHorarios(Horario_idHorario, Linea_idLinea) values("9","1");

insert into LineaHorarios(Horario_idHorario, Linea_idLinea) values("1","2");
insert into LineaHorarios(Horario_idHorario, Linea_idLinea) values("2","2");
insert into LineaHorarios(Horario_idHorario, Linea_idLinea) values("3","2");
insert into LineaHorarios(Horario_idHorario, Linea_idLinea) values("5","2");
insert into LineaHorarios(Horario_idHorario, Linea_idLinea) values("7","2");
insert into LineaHorarios(Horario_idHorario, Linea_idLinea) values("9","2");

insert into LineaHorarios(Horario_idHorario, Linea_idLinea) values("4","3");
insert into LineaHorarios(Horario_idHorario, Linea_idLinea) values("6","3");
insert into LineaHorarios(Horario_idHorario, Linea_idLinea) values("8","3");
insert into LineaHorarios(Horario_idHorario, Linea_idLinea) values("10","3");
insert into LineaHorarios(Horario_idHorario, Linea_idLinea) values("11","3");
insert into LineaHorarios(Horario_idHorario, Linea_idLinea) values("12","3");
insert into LineaHorarios(Horario_idHorario, Linea_idLinea) values("13","3");
insert into LineaHorarios(Horario_idHorario, Linea_idLinea) values("14","3");
insert into LineaHorarios(Horario_idHorario, Linea_idLinea) values("15","3");



insert into LineaHorarios(Horario_idHorario, Linea_idLinea) values("4","4");
insert into LineaHorarios(Horario_idHorario, Linea_idLinea) values("6","4");
insert into LineaHorarios(Horario_idHorario, Linea_idLinea) values("8","4");
insert into LineaHorarios(Horario_idHorario, Linea_idLinea) values("10","4");
insert into LineaHorarios(Horario_idHorario, Linea_idLinea) values("11","4");
insert into LineaHorarios(Horario_idHorario, Linea_idLinea) values("12","4");
insert into LineaHorarios(Horario_idHorario, Linea_idLinea) values("13","4");
insert into LineaHorarios(Horario_idHorario, Linea_idLinea) values("14","4");
insert into LineaHorarios(Horario_idHorario, Linea_idLinea) values("15","4");


