CREATE DATABASE libroconnect;
use libroconnect;

CREATE TABLE libros (
	Id_Libro INT PRIMARY KEY UNIQUE NOT NULL,
    Nombre_Libro VARCHAR(150) NOT NULL,
    Autor VARCHAR(150)
);

INSERT INTO libros (Id_Libro, Nombre_Libro, Autor) VALUES
(1, 'Cien años de soledad', 'Gabriel García Márquez'),
(2, 'Don Quijote de la Mancha', 'Miguel de Cervantes'),
(3, '1984', 'George Orwell');


SELECT * FROM libros;

CREATE TABLE Usuarios (
	Usuario VARCHAR(50) UNIQUE NOT NULL,
    contraseña VARCHAR(10) NOT NULL,
    tipo VARCHAR(30)
);

SELECT * FROM Usuarios;

INSERT INTO Usuarios (Usuario,contraseña,tipo) VALUES
("Admin","passadmin","administrador"),
("User","passuser","usuario")
;