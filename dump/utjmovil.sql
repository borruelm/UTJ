-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: db
-- Generation Time: Nov 22, 2023 at 03:16 AM
-- Server version: 8.2.0
-- PHP Version: 8.2.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `utjmovil`
--

-- --------------------------------------------------------

--
-- Table structure for table `Calendario`
--

CREATE TABLE `Calendario` (
  `idCalendario` int NOT NULL,
  `fecha` date DEFAULT NULL,
  `diaSolicitado` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `documento`
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
-- Table structure for table `estado`
--

CREATE TABLE `estado` (
  `idEstado` int NOT NULL,
  `nombreEstado` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `notificacion`
--

CREATE TABLE `notificacion` (
  `idNotificacion` int NOT NULL,
  `nombre` varchar(100) DEFAULT NULL,
  `mensaje` text,
  `fechaHora` varchar(45) DEFAULT NULL,
  `idUsuario` int DEFAULT NULL,
  `usuario_idUsuario` int NOT NULL,
  `estado_idEstado` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `permiso`
--

CREATE TABLE `permiso` (
  `idPermiso` int NOT NULL,
  `tipo` varchar(100) DEFAULT NULL,
  `fechaSolicitud` date DEFAULT NULL,
  `diaSolicitado` date DEFAULT NULL,
  `estado` int DEFAULT NULL,
  `idDocumento` int DEFAULT NULL,
  `Calendario_idCalendario` int NOT NULL,
  `notificacion_idNotificacion` int NOT NULL,
  `usuario_idUsuario` int NOT NULL,
  `documento_idDocumento1` int NOT NULL,
  `rol_idRol` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `rol`
--

CREATE TABLE `rol` (
  `idRol` int NOT NULL,
  `nombreRol` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `usuario`
--

CREATE TABLE `usuario` (
  `idUsuario` int NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `correoElectronico` varchar(100) DEFAULT NULL,
  `Contraseña` varchar(45) DEFAULT NULL,
  `rol` tinyint DEFAULT NULL,
  `telefono` int DEFAULT NULL,
  `tiempoServicio` int DEFAULT NULL,
  `direccion` text,
  `foto` mediumblob
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `Calendario`
--
ALTER TABLE `Calendario`
  ADD PRIMARY KEY (`idCalendario`);

--
-- Indexes for table `documento`
--
ALTER TABLE `documento`
  ADD PRIMARY KEY (`idDocumento`);

--
-- Indexes for table `estado`
--
ALTER TABLE `estado`
  ADD PRIMARY KEY (`idEstado`);

--
-- Indexes for table `notificacion`
--
ALTER TABLE `notificacion`
  ADD PRIMARY KEY (`idNotificacion`),
  ADD KEY `fk_notificacion_usuario1_idx` (`usuario_idUsuario`),
  ADD KEY `fk_notificacion_estado1_idx` (`estado_idEstado`);

--
-- Indexes for table `permiso`
--
ALTER TABLE `permiso`
  ADD KEY `fk_permiso_Calendario_idx` (`Calendario_idCalendario`),
  ADD KEY `fk_permiso_notificacion1_idx` (`notificacion_idNotificacion`),
  ADD KEY `fk_permiso_usuario1_idx` (`usuario_idUsuario`),
  ADD KEY `fk_permiso_documento2_idx` (`documento_idDocumento1`),
  ADD KEY `fk_permiso_rol1_idx` (`rol_idRol`);

--
-- Indexes for table `rol`
--
ALTER TABLE `rol`
  ADD PRIMARY KEY (`idRol`);

--
-- Indexes for table `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`idUsuario`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `notificacion`
--
ALTER TABLE `notificacion`
  ADD CONSTRAINT `fk_notificacion_estado1` FOREIGN KEY (`estado_idEstado`) REFERENCES `estado` (`idEstado`),
  ADD CONSTRAINT `fk_notificacion_usuario1` FOREIGN KEY (`usuario_idUsuario`) REFERENCES `usuario` (`idUsuario`);

--
-- Constraints for table `permiso`
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
