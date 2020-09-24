-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:7733
-- Generation Time: Sep 24, 2020 at 04:04 AM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.4.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `admin_kanban`
--

-- --------------------------------------------------------

--
-- Table structure for table `columna`
--

CREATE TABLE `columna` (
  `id_columna` int(11) NOT NULL,
  `nombre_columna` varchar(100) NOT NULL,
  `posicion` int(11) NOT NULL,
  `descripcion` varchar(500) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `columna`
--

INSERT INTO `columna` (`id_columna`, `nombre_columna`, `posicion`, `descripcion`) VALUES
(1, 'BACKLOG', 0, 'Columna inicial para poner todas las tareas que van surgiendo'),
(2, 'TESTING', 10, 'Cuando la tarea se terminó pero está en fase de prueba por si se le encuentran errores'),
(3, 'EN PROGRESO', 5, 'Se comenzó la tarea pero sigue en desarrollo.'),
(4, 'TERMINADA', 100, 'Se terminó la tarea, se puede mezclar la rama al dev.');

-- --------------------------------------------------------

--
-- Table structure for table `prioridad`
--

CREATE TABLE `prioridad` (
  `id_prioridad` int(11) NOT NULL,
  `nombre_prioridad` varchar(100) NOT NULL,
  `valor_comparable` int(11) NOT NULL,
  `color` int(11) NOT NULL,
  `descripcion` varchar(500) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `prioridad`
--

INSERT INTO `prioridad` (`id_prioridad`, `nombre_prioridad`, `valor_comparable`, `color`, `descripcion`) VALUES
(1, 'NADA', 0, -11751600, 'No tiene prioridad, se puede o no hacer, da igual'),
(2, 'BAJA', 1, -256, 'Prioridad muy baja, despreciable, no afecta si se hace o no'),
(3, 'MEDIA', 2, -689152, 'Hay que hacerla, pero no apura mucho'),
(4, 'ALTA', 4, -4056997, 'Hay que hacerla urgente'),
(5, 'URGENTE', 5, -2818048, 'Era para ayer, desastre en el sistema'),
(6, 'CATASTROFE', 6, -16777216, 'Se jodió el sistema'),
(7, 'otra', 2, -16718337, '');

-- --------------------------------------------------------

--
-- Table structure for table `proyecto`
--

CREATE TABLE `proyecto` (
  `id_proyecto` int(11) NOT NULL,
  `nombre_proyecto` varchar(100) NOT NULL,
  `fecha_inicio` date NOT NULL,
  `descripcion` varchar(500) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `proyecto`
--

INSERT INTO `proyecto` (`id_proyecto`, `nombre_proyecto`, `fecha_inicio`, `descripcion`) VALUES
(3, 'Material - Swing', '2020-09-23', 'Framework visual para clientes desktop.\n\nUbicación: E:\\Trabajos\\Projects\\GIT Projects Gradle\\MaterialSwing'),
(4, 'Material - Chart', '2020-09-23', 'Utilidades para el trabajo con gráficos.\n\nUbicación: E:\\Trabajos\\Projects\\GIT Projects Gradle\\Material\\Chart'),
(5, 'Material - Derivable Icons', '2020-09-23', 'Utilidades para el trabajo con Iconos.\n\nUbicación: E:\\Trabajos\\Projects\\GIT Projects Gradle\\Material\\Derivable Icons'),
(6, 'Material - Model', '2020-09-23', 'Framework para clientes desktop en el trabajo con CRUD.\n\nUbicación: E:\\Trabajos\\Projects\\GIT Projects Gradle\\Material\\Model'),
(7, 'Material - Notifications', '2020-09-23', 'Framework para el trabajo con notificaciones en clientes desktop.\n\nUbicación: E:\\Trabajos\\Projects\\GIT Projects Gradle\\Material\\Notifications'),
(8, 'Material - Standars', '2020-09-23', 'Estándares de Material Design.\n\nUbicación: E:\\Trabajos\\Projects\\GIT Projects Gradle\\Material\\Standards'),
(9, 'Material - SwingPrepared', '2020-09-23', 'Utilidades para el trabajo con componentes swing que se reutilizan y se generalizan aquí.\n\nUbicación: E:\\Trabajos\\Projects\\GIT Projects Gradle\\Material\\SwingPrepared'),
(10, 'SIGECON - Contabilidad', '2020-09-23', 'Módulo de contabilidad empresarial.\n\nUbicación: E:\\Trabajos\\Projects\\GIT Projects Gradle\\Modulos Gestion\\Contabilidad Empresarial'),
(11, 'SIGECON - Gastos', '2020-09-23', 'Módulo de gastos administrativos.\n\nUbicación: E:\\Trabajos\\Projects\\GIT Projects Gradle\\Modulos Gestion\\Gastos Administrativos'),
(12, 'SIGECON - Nómina', '2020-09-23', 'Módulo de nómina\n\nUbicación: E:\\Trabajos\\Projects\\GIT Projects Gradle\\Modulos Gestion\\Nomina'),
(13, 'ADMIN - Kanban', '2020-09-23', 'Módulo de Kanban\n\nUbicación: E:\\Trabajos\\Projects\\GIT Projects Gradle\\Modulos Admin\\Kanban');

-- --------------------------------------------------------

--
-- Table structure for table `tarea`
--

CREATE TABLE `tarea` (
  `id_tarea` int(11) NOT NULL,
  `nombre_tarea` varchar(100) NOT NULL,
  `codigo_tarea` varchar(10) NOT NULL,
  `puntos` int(11) NOT NULL,
  `descripcion` varchar(500) NOT NULL,
  `prioridad_fk` int(11) NOT NULL,
  `proyecto_fk` int(11) NOT NULL,
  `columna_fk` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `columna`
--
ALTER TABLE `columna`
  ADD PRIMARY KEY (`id_columna`),
  ADD UNIQUE KEY `nombre_columna` (`nombre_columna`),
  ADD UNIQUE KEY `UNIQUE_Columna_posicion` (`nombre_columna`,`posicion`);

--
-- Indexes for table `prioridad`
--
ALTER TABLE `prioridad`
  ADD PRIMARY KEY (`id_prioridad`),
  ADD UNIQUE KEY `nombre_prioridad` (`nombre_prioridad`);

--
-- Indexes for table `proyecto`
--
ALTER TABLE `proyecto`
  ADD PRIMARY KEY (`id_proyecto`),
  ADD UNIQUE KEY `nombre_proyecto` (`nombre_proyecto`);

--
-- Indexes for table `tarea`
--
ALTER TABLE `tarea`
  ADD PRIMARY KEY (`id_tarea`),
  ADD UNIQUE KEY `codigo_tarea` (`codigo_tarea`),
  ADD KEY `FK_tarea_prioridad` (`prioridad_fk`),
  ADD KEY `FK_tarea_proyecto` (`proyecto_fk`),
  ADD KEY `FK_tarea_columna` (`columna_fk`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `columna`
--
ALTER TABLE `columna`
  MODIFY `id_columna` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `prioridad`
--
ALTER TABLE `prioridad`
  MODIFY `id_prioridad` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `proyecto`
--
ALTER TABLE `proyecto`
  MODIFY `id_proyecto` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT for table `tarea`
--
ALTER TABLE `tarea`
  MODIFY `id_tarea` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `tarea`
--
ALTER TABLE `tarea`
  ADD CONSTRAINT `FK_tarea_columna` FOREIGN KEY (`columna_fk`) REFERENCES `columna` (`id_columna`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_tarea_prioridad` FOREIGN KEY (`prioridad_fk`) REFERENCES `prioridad` (`id_prioridad`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_tarea_proyecto` FOREIGN KEY (`proyecto_fk`) REFERENCES `proyecto` (`id_proyecto`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
