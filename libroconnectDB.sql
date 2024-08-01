CREATE DATABASE libroconnect;
use libroconnect;

CREATE TABLE libros (
	Id_Libro INT PRIMARY KEY UNIQUE NOT NULL,
    Nombre_Libro VARCHAR(150) NOT NULL,
    Autor VARCHAR(150)
);

SELECT * FROM libros;