-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost:8889
-- Tiempo de generación: 14-11-2022 a las 14:22:07
-- Versión del servidor: 5.7.34
-- Versión de PHP: 8.0.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `tesicnor_peliculas`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `peliculas`
--

CREATE TABLE `peliculas` (
  `Titulo` varchar(255) NOT NULL,
  `Year` int(4) NOT NULL,
  `type` varchar(10) NOT NULL,
  `imdbID` varchar(10) NOT NULL,
  `Poster` varchar(500) NOT NULL,
  `valoracion` int(1) DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `peliculas`
--

INSERT INTO `peliculas` (`Titulo`, `Year`, `type`, `imdbID`, `Poster`, `valoracion`) VALUES
('Lara Croft: Tomb Raider', 2001, 'movie', 'tt0146316', 'https://m.media-amazon.com/images/M/MV5BNzMzODVjMWUtYmIxZS00NDlkLTlmNTktNjI5NTdhZjUzYzY1XkEyXkFqcGdeQXVyMTQxNzMzNDI@._V1_SX300.jpg', 0),
('Tomb Raider', 1996, 'game', 'tt0190838', 'https://m.media-amazon.com/images/M/MV5BNjVjMzI0NWYtYTY0YS00ZjI4LTkxMDQtYmE2ODIwNjI3Mzc1XkEyXkFqcGdeQXVyNTAyODkwOQ@@._V1_SX300.jpg', 0),
('Tomb Raider II Starring Lara Croft', 1997, 'game', 'tt0190839', 'https://m.media-amazon.com/images/M/MV5BZmY0MjAyNzQtYWUxZC00YTJiLTlmZTMtYzgxNDA1MjliYzhkXkEyXkFqcGdeQXVyNTAyODkwOQ@@._V1_SX300.jpg', 0),
('Harry Potter and the Sorcerer\'s Stone', 2001, 'movie', 'tt0241527', 'https://m.media-amazon.com/images/M/MV5BMzkyZGFlOWQtZjFlMi00N2YwLWE2OWQtYTgxY2NkNmM1NjMwXkEyXkFqcGdeQXVyNjY1NTM1MzA@._V1_SX300.jpg', 0),
('Harry Potter and the Chamber of Secrets', 2002, 'movie', 'tt0295297', 'https://m.media-amazon.com/images/M/MV5BMjE0YjUzNDUtMjc5OS00MTU3LTgxMmUtODhkOThkMzdjNWI4XkEyXkFqcGdeQXVyMTA3MzQ4MTc0._V1_SX300.jpg', 0),
('Harry Potter and the Prisoner of Azkaban', 2004, 'movie', 'tt0304141', 'https://m.media-amazon.com/images/M/MV5BMTY4NTIwODg0N15BMl5BanBnXkFtZTcwOTc0MjEzMw@@._V1_SX300.jpg', 0),
('Lara Croft Tomb Raider: The Cradle of Life', 2003, 'movie', 'tt0325703', 'https://m.media-amazon.com/images/M/MV5BYzYxOTgxYjAtNGI3MS00NDJkLTkyZWItZGM5MzRhOGYwYjlmL2ltYWdlXkEyXkFqcGdeQXVyMTQxNzMzNDI@._V1_SX300.jpg', 0),
('Harry Potter and the Goblet of Fire', 2005, 'movie', 'tt0330373', 'https://m.media-amazon.com/images/M/MV5BMTI1NDMyMjExOF5BMl5BanBnXkFtZTcwOTc4MjQzMQ@@._V1_SX300.jpg', 0),
('Harry Potter and the Order of the Phoenix', 2007, 'movie', 'tt0373889', 'https://m.media-amazon.com/images/M/MV5BMTM0NTczMTUzOV5BMl5BanBnXkFtZTYwMzIxNTg3._V1_SX300.jpg', 0),
('Harry Potter and the Half-Blood Prince', 2009, 'movie', 'tt0417741', 'https://m.media-amazon.com/images/M/MV5BNzU3NDg4NTAyNV5BMl5BanBnXkFtZTcwOTg2ODg1Mg@@._V1_SX300.jpg', 5),
('Harry Potter and the Deathly Hallows: Part 1', 2010, 'movie', 'tt0926084', 'https://m.media-amazon.com/images/M/MV5BMTQ2OTE1Mjk0N15BMl5BanBnXkFtZTcwODE3MDAwNA@@._V1_SX300.jpg', 0),
('Lara Croft Tomb Raider: Anniversary', 2007, 'game', 'tt0942894', 'https://m.media-amazon.com/images/M/MV5BY2FhMjFhZGMtMTY5NS00MjgzLWJmNDQtYTk0MTk4ODZlYmE0XkEyXkFqcGdeQXVyOTQxNzM2MjY@._V1_SX300.jpg', 0),
('Tomb Raider: Underworld', 2008, 'game', 'tt0972844', 'https://m.media-amazon.com/images/M/MV5BNzRlZWUxOGYtNzA4NC00NThjLThiOGEtOTdkNDg0NWRhMzIyXkEyXkFqcGdeQXVyMjYwNDA2MDE@._V1_SX300.jpg', 0),
('Harry Potter and the Deathly Hallows: Part 2', 2011, 'movie', 'tt1201607', 'https://m.media-amazon.com/images/M/MV5BMGVmMWNiMDktYjQ0Mi00MWIxLTk0N2UtN2ZlYTdkN2IzNDNlXkEyXkFqcGdeQXVyODE5NzE3OTE@._V1_SX300.jpg', 0),
('Tomb Raider', 2018, 'movie', 'tt1365519', 'https://m.media-amazon.com/images/M/MV5BOTY4NDcyZGQtYmVlNy00ODgwLTljYTMtYzQ2OTE3NDhjODMwXkEyXkFqcGdeQXVyNzYzODM3Mzg@._V1_SX300.jpg', 0),
('Harry Potter 20th Anniversary: Return to Hogwarts', 2022, 'movie', 'tt16116174', 'https://m.media-amazon.com/images/M/MV5BNTZkNWEyZTgtYzJlOS00OWNiLTgwZjMtZGU5NTRhNDNjOTRhXkEyXkFqcGdeQXVyNjk1Njg5NTA@._V1_SX300.jpg', 0),
('Harry Potter and the Forbidden Journey', 2010, 'movie', 'tt1756545', 'https://m.media-amazon.com/images/M/MV5BNDM0YzMyNGUtMTU1Yy00OTE2LWE5NzYtZDZhMTBmN2RkNjg3XkEyXkFqcGdeQXVyMzU5NjU1MDA@._V1_SX300.jpg', 0),
('Tomb Raider', 2013, 'game', 'tt1797530', 'https://m.media-amazon.com/images/M/MV5BODMzM2EyYmUtYzEyYS00NmVmLThlMGQtMDdlNzZiYTI4YmRjXkEyXkFqcGdeQXVyNjUxNDQwMzA@._V1_SX300.jpg', 0),
('Rise of the Tomb Raider', 2015, 'game', 'tt3791072', 'https://m.media-amazon.com/images/M/MV5BN2U3MDcyYmUtNmMyYS00ZDU2LWFhZmMtMDAzYjRiZmQwYWE4XkEyXkFqcGdeQXVyOTQxNzM2MjY@._V1_SX300.jpg', 0),
('Shadow of the Tomb Raider', 2018, 'game', 'tt8339682', 'https://m.media-amazon.com/images/M/MV5BZDFlYWFiMzMtNjc3NC00ZTgyLWFhMjQtZTNmNmU5MWU1NGVlXkEyXkFqcGdeQXVyMzY0MTE3NzU@._V1_SX300.jpg', 0);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `peliculas`
--
ALTER TABLE `peliculas`
  ADD PRIMARY KEY (`imdbID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
