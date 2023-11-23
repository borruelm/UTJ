-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: db
-- Tiempo de generación: 24-11-2023 a las 15:02:49
-- Versión del servidor: 8.2.0
-- Versión de PHP: 8.2.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `utjmovil`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Calendario`
--

CREATE TABLE `Calendario` (
  `idCalendario` int NOT NULL,
  `fecha` date DEFAULT NULL,
  `diaSolicitado` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `documento`
--

CREATE TABLE `documento` (
  `idDocumento` int NOT NULL,
  `nombreDocumento` varchar(100) DEFAULT NULL,
  `archivo` mediumblob,
  `idPermiso` int DEFAULT NULL,
  `fechaSubida` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `estado`
--

CREATE TABLE `estado` (
  `idEstado` int NOT NULL,
  `nombreEstado` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `estado`
--

INSERT INTO `estado` (`idEstado`, `nombreEstado`) VALUES
(1, 'Pendiente'),
(2, 'Aprobado'),
(3, 'Rechazado');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `notificacion`
--

CREATE TABLE `notificacion` (
  `idNotificacion` int NOT NULL,
  `nombre` varchar(100) DEFAULT NULL,
  `mensaje` text,
  `fechaHora` datetime DEFAULT NULL,
  `idUsuario` int DEFAULT NULL,
  `usuario_idUsuario` int NOT NULL,
  `estado_idEstado` int NOT NULL DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `permiso`
--

CREATE TABLE `permiso` (
  `idPermiso` int NOT NULL,
  `tipo` varchar(100) DEFAULT NULL,
  `fechaSolicitud` date DEFAULT NULL,
  `diaSolicitado` date DEFAULT NULL,
  `estado` int DEFAULT '0',
  `idDocumento` int DEFAULT NULL,
  `Calendario_idCalendario` int NOT NULL,
  `notificacion_idNotificacion` int NOT NULL,
  `usuario_idUsuario` int NOT NULL,
  `documento_idDocumento1` int NOT NULL,
  `rol_idRol` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `rol`
--

CREATE TABLE `rol` (
  `idRol` int NOT NULL,
  `nombreRol` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `rol`
--

INSERT INTO `rol` (`idRol`, `nombreRol`) VALUES
(1, 'Admin'),
(2, 'Docente');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_permiso`
--

CREATE TABLE `tipo_permiso` (
  `idTipoPermiso` int NOT NULL,
  `nombre` varchar(255) NOT NULL,
  `maximoUsoAnual` int DEFAULT NULL,
  `periodoRestriccionMeses` int DEFAULT NULL,
  `restriccionAntiguedadAnios` int DEFAULT NULL,
  `maximoUsoMensual` int DEFAULT NULL,
  `usoUnico` tinyint(1) DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `tipo_permiso`
--

INSERT INTO `tipo_permiso` (`idTipoPermiso`, `nombre`, `maximoUsoAnual`, `periodoRestriccionMeses`, `restriccionAntiguedadAnios`, `maximoUsoMensual`, `usoUnico`) VALUES
(1, 'Cumpleaños', NULL, NULL, NULL, NULL, 0),
(2, 'Matrimonio', 1, NULL, NULL, NULL, 1),
(3, 'Hospitalización primer grado', NULL, NULL, NULL, NULL, 0),
(4, 'Permiso de 2 horas', NULL, NULL, NULL, 2, 0),
(5, 'Fallecimiento', NULL, NULL, NULL, NULL, 0),
(6, '3er día económico', NULL, 4, NULL, NULL, 0),
(7, 'Nacimiento', NULL, NULL, NULL, NULL, 0),
(8, '5to día económico', NULL, 4, 10, NULL, 0),
(9, '4to Día económico', NULL, 4, NULL, NULL, 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `idUsuario` int NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `correoElectronico` varchar(100) DEFAULT NULL,
  `contrasena` varchar(255) DEFAULT NULL,
  `rol` int NOT NULL,
  `telefono` varchar(20) DEFAULT NULL,
  `tiempoServicio` int DEFAULT NULL,
  `direccion` text,
  `foto` mediumblob
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`idUsuario`, `nombre`, `correoElectronico`, `contrasena`, `rol`, `telefono`, `tiempoServicio`, `direccion`, `foto`) VALUES
(1, 'Martin B', 'sample@email.com', 'utj.2023$', 1, '333333', 2, 'Av siempre viva', NULL),
(2, 'Miguel A. Ornelas', 'sample@gmail.com', 'utj.2023$', 2, '3344', 1, 'Calle de la amargura', NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario_seq`
--

CREATE TABLE `usuario_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `usuario_seq`
--

INSERT INTO `usuario_seq` (`next_val`) VALUES
(1);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `Calendario`
--
ALTER TABLE `Calendario`
  ADD PRIMARY KEY (`idCalendario`);

--
-- Indices de la tabla `documento`
--
ALTER TABLE `documento`
  ADD PRIMARY KEY (`idDocumento`);

--
-- Indices de la tabla `estado`
--
ALTER TABLE `estado`
  ADD PRIMARY KEY (`idEstado`);

--
-- Indices de la tabla `notificacion`
--
ALTER TABLE `notificacion`
  ADD PRIMARY KEY (`idNotificacion`),
  ADD KEY `fk_notificacion_usuario1_idx` (`usuario_idUsuario`),
  ADD KEY `fk_notificacion_estado1_idx` (`estado_idEstado`);

--
-- Indices de la tabla `permiso`
--
ALTER TABLE `permiso`
  ADD KEY `fk_permiso_Calendario_idx` (`Calendario_idCalendario`),
  ADD KEY `fk_permiso_notificacion1_idx` (`notificacion_idNotificacion`),
  ADD KEY `fk_permiso_usuario1_idx` (`usuario_idUsuario`),
  ADD KEY `fk_permiso_documento2_idx` (`documento_idDocumento1`),
  ADD KEY `fk_permiso_rol1_idx` (`rol_idRol`);

--
-- Indices de la tabla `rol`
--
ALTER TABLE `rol`
  ADD PRIMARY KEY (`idRol`);

--
-- Indices de la tabla `tipo_permiso`
--
ALTER TABLE `tipo_permiso`
  ADD PRIMARY KEY (`idTipoPermiso`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`idUsuario`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `estado`
--
ALTER TABLE `estado`
  MODIFY `idEstado` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `tipo_permiso`
--
ALTER TABLE `tipo_permiso`
  MODIFY `idTipoPermiso` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `notificacion`
--
ALTER TABLE `notificacion`
  ADD CONSTRAINT `fk_notificacion_estado1` FOREIGN KEY (`estado_idEstado`) REFERENCES `estado` (`idEstado`),
  ADD CONSTRAINT `fk_notificacion_usuario1` FOREIGN KEY (`usuario_idUsuario`) REFERENCES `usuario` (`idUsuario`);

--
-- Filtros para la tabla `permiso`
--
ALTER TABLE `permiso`
  ADD CONSTRAINT `fk_permiso_Calendario` FOREIGN KEY (`Calendario_idCalendario`) REFERENCES `Calendario` (`idCalendario`),
  ADD CONSTRAINT `fk_permiso_documento2` FOREIGN KEY (`documento_idDocumento1`) REFERENCES `documento` (`idDocumento`),
  ADD CONSTRAINT `fk_permiso_notificacion1` FOREIGN KEY (`notificacion_idNotificacion`) REFERENCES `notificacion` (`idNotificacion`),
  ADD CONSTRAINT `fk_permiso_rol1` FOREIGN KEY (`rol_idRol`) REFERENCES `rol` (`idRol`),
  ADD CONSTRAINT `fk_permiso_usuario1` FOREIGN KEY (`usuario_idUsuario`) REFERENCES `usuario` (`idUsuario`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
