INSERT INTO socios (nombre, apellido, email) VALUES ('Markus', 'Plamen', 'markus@gmail.com');
INSERT INTO socios (nombre, apellido, email) VALUES ('Andrea', 'Suiza', 'andrea@gmail.com');
INSERT INTO barco (matricula, nombre, amarre, cuota, id_socios) VALUES ('ABC123', 'El Navegante', '5', 150.00,1);
INSERT INTO barco (matricula, nombre, amarre, cuota, id_socios) VALUES ('ABC456', 'BarcoUno', '8', 1000.0,1);
INSERT INTO barco (matricula, nombre, amarre, cuota, id_socios) VALUES ('DFG890', 'BarcoDos', '9', 1000.0,2);
INSERT INTO barco (matricula, nombre, amarre, cuota, id_socios) VALUES ('AIU890', 'BarcoTres', '9', 1000.0,1);
INSERT INTO salida (fecha, destino, datos_patron, id_barco) VALUES ('2024-12-24 23:12:15', 'Bolivia', 'socio',1);
INSERT INTO salida (fecha, destino, datos_patron, id_barco) VALUES ('2024-12-24 23:12:25', 'Peru', 'no socio',3);
INSERT INTO salida (fecha, destino, datos_patron, id_barco) VALUES ('2024-12-24 23:12:45', 'Peru', 'no socio',4);