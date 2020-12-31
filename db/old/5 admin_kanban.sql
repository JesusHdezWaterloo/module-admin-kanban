-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:7733
-- Generation Time: Oct 10, 2020 at 05:13 AM
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
(7, 'TEST', 2, -16718337, '');

-- --------------------------------------------------------

--
-- Table structure for table `proyecto`
--

CREATE TABLE `proyecto` (
  `id_proyecto` int(11) NOT NULL,
  `nombre_proyecto` varchar(100) NOT NULL,
  `fecha_inicio` date NOT NULL,
  `kanban` tinyint(1) NOT NULL,
  `prioridad` int(11) NOT NULL,
  `url_local` varchar(500) NOT NULL,
  `url_repo_online` varchar(500) NOT NULL,
  `descripcion` varchar(500) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `proyecto`
--

INSERT INTO `proyecto` (`id_proyecto`, `nombre_proyecto`, `fecha_inicio`, `kanban`, `prioridad`, `url_local`, `url_repo_online`, `descripcion`) VALUES
(3, 'Material - Swing', '2020-09-23', 1, 10, 'E:\\Trabajos\\Projects\\GIT Projects Gradle\\MaterialSwing', 'https://github.com/JesusHdezWaterloo/MaterialSwing.git', 'Framework visual para clientes desktop.'),
(4, 'Material - Chart', '2020-09-23', 0, 3, 'E:\\Trabajos\\Projects\\GIT Projects Gradle\\Material\\Chart', 'https://github.com/JesusHdezWaterloo/material-chart.git', 'Utilidades para el trabajo con gráficos.'),
(5, 'Material - Derivable Icons', '2020-09-23', 0, 3, 'E:\\Trabajos\\Projects\\GIT Projects Gradle\\Material\\Derivable Icons', '2', 'Utilidades para el trabajo con Iconos.'),
(6, 'Material - Model', '2020-09-23', 1, 10, 'E:\\Trabajos\\Projects\\GIT Projects Gradle\\Material\\Model', 'https://github.com/JesusHdezWaterloo/Model.git', 'Framework para clientes desktop en el trabajo con CRUD.'),
(7, 'Material - Notifications', '2020-09-23', 0, 3, 'E:\\Trabajos\\Projects\\GIT Projects Gradle\\Material\\Notifications', '5', 'Framework para el trabajo con notificaciones en clientes desktop.'),
(8, 'Material - Standars', '2020-09-23', 0, 5, 'E:\\Trabajos\\Projects\\GIT Projects Gradle\\Material\\Standards', '6', 'Estándares de Material Design.'),
(9, 'Material - SwingPrepared', '2020-09-23', 0, 3, 'E:\\Trabajos\\Projects\\GIT Projects Gradle\\Material\\SwingPrepared', '7', 'Utilidades para el trabajo con componentes swing que se reutilizan y se generalizan aquí.'),
(10, 'SIGECON - Contabilidad', '2020-09-23', 1, 20, 'E:\\Trabajos\\Projects\\GIT Projects Gradle\\Modulos Gestion\\Contabilidad Empresarial', 'https://github.com/JesusHdezWaterloo/ContabilidadEmpresarial.git', 'Módulo de contabilidad empresarial.'),
(11, 'SIGECON - Gastos', '2020-09-23', 1, 20, 'E:\\Trabajos\\Projects\\GIT Projects Gradle\\Modulos Gestion\\Gastos Administrativos', 'https://github.com/JesusHdezWaterloo/GastosAdministrativos.git', 'Módulo de gastos administrativos.'),
(12, 'SIGECON - Nómina', '2020-09-23', 1, 20, 'E:\\Trabajos\\Projects\\GIT Projects Gradle\\Modulos Gestion\\Nomina', 'https://github.com/JesusHdezWaterloo/Nomina.git', 'Módulo de nómina.'),
(13, 'ADMIN - Kanban', '2020-09-23', 1, 50, 'E:\\Trabajos\\Projects\\GIT Projects Gradle\\Modulos Admin\\Kanban', 'https://github.com/JesusHdezWaterloo/Kanban.git', 'Módulo de Kanban'),
(18, 'Clean - Core', '2020-09-25', 0, 5, 'E:\\Trabajos\\Projects\\GIT Projects Gradle\\CleanCoreFull', 'https://github.com/JesusHdezWaterloo/CleanCoreFull.git', 'Framework core para clean'),
(19, 'Clean - Swing', '2020-09-25', 0, 5, 'E:\\Trabajos\\Projects\\GIT Projects Gradle\\CleanSwing', 'https://github.com/JesusHdezWaterloo/CleanSwing.git', ''),
(20, 'Example - AOP Guice', '2020-09-25', 0, 1, 'E:\\Trabajos\\Projects\\GIT Projects Gradle\\EXAMPLES\\AOPExample GUICE', 'https://github.com/JesusHdezWaterloo/AOPExampleGUICE.git', 'Ejemplo de como funciona la inyección de  dependencia y AOP en google GUICE'),
(21, 'Example - Clean', '2020-09-25', 0, 1, 'E:\\Trabajos\\Projects\\GIT Projects Gradle\\EXAMPLES\\CleanExample', '8', ''),
(22, 'Utils - Bug', '2020-09-25', 0, 2, 'E:\\Trabajos\\Projects\\GIT Projects Gradle\\Modulos Utils\\Bug', 'https://github.com/JesusHdezWaterloo/module-bug.git', 'Modulo de utils para reportar bugs'),
(23, 'Utils - Calc', '2020-09-25', 0, 2, 'E:\\Trabajos\\Projects\\GIT Projects Gradle\\Modulos Utils\\Calc', 'https://github.com/JesusHdezWaterloo/module-calc.git', ''),
(24, 'Utils - Company', '2020-09-25', 0, 2, 'E:\\Trabajos\\Projects\\GIT Projects Gradle\\Modulos Utils\\Company', 'https://github.com/JesusHdezWaterloo/module-company.git', 'Modulo util para configurar nombre del programa, icono, nombre de cliente...'),
(25, 'Utils - Console', '2020-09-25', 0, 2, 'E:\\Trabajos\\Projects\\GIT Projects Gradle\\Modulos Utils\\Console', 'https://github.com/JesusHdezWaterloo/module-console.git', ''),
(26, 'Utils - DefaultConfig', '2020-09-25', 0, 3, 'E:\\Trabajos\\Projects\\GIT Projects Gradle\\Modulos Utils\\DefaultConfiguration', '556', 'Configuracion por defecto. Incluye el tratamiento de excepciones básicas, notificaciones por defecto y cosas así.'),
(27, 'Utils - Export', '2020-09-25', 1, 10, 'E:\\Trabajos\\Projects\\GIT Projects Gradle\\Modulos Utils\\Export', 'https://github.com/JesusHdezWaterloo/module-export.git', ''),
(28, 'Utils - File', '2020-09-25', 0, 2, 'E:\\Trabajos\\Projects\\GIT Projects Gradle\\Modulos Utils\\Files', '10', 'Utilidades para el trabajo con Files. Incluye la Clase Openable, utilidades para borrar y asi'),
(29, 'Utils - Licence', '2020-09-25', 0, 5, 'E:\\Trabajos\\Projects\\GIT Projects Gradle\\Modulos Utils\\Licence', 'https://github.com/JesusHdezWaterloo/LicenceModule.git', ''),
(30, 'Utils - MySQL', '2020-09-25', 0, 3, 'E:\\Trabajos\\Projects\\GIT Projects Gradle\\Modulos Utils\\MySQL', 'https://github.com/JesusHdezWaterloo/module-mysql.git', 'Utilidades para Mysql, como iniciar el servicio, cerrarlo, salvar, ver si esta corriendo y asi'),
(31, 'Utils - Personalizacion', '2020-09-25', 0, 5, 'E:\\Trabajos\\Projects\\GIT Projects Gradle\\Modulos Utils\\Personalization', 'https://github.com/JesusHdezWaterloo/module-personalization.git', 'Propiedades por defecto para personalizacion. Se guarda en fichero los colores por defect, iconos, controladores para usar animaciones, beep, sombras y asi'),
(32, 'Utils - Tec', '2020-09-25', 0, 1, 'E:\\Trabajos\\Projects\\GIT Projects Gradle\\Modulos Utils\\Tec', 'https://github.com/JesusHdezWaterloo/module-tec.git', 'Iconos con las tecnologias que mas se usan'),
(33, 'General - Testing Modulos Gestion', '2020-09-25', 0, 10, 'E:\\Trabajos\\Projects\\GIT Projects Gradle\\TestingModulesGestion', '11', 'Para probar los modulos'),
(34, 'Utils - Core', '2020-09-25', 1, 10, 'E:\\Trabajos\\Projects\\GIT Projects Gradle\\Utils', 'https://github.com/JesusHdezWaterloo/Utils.git', 'Utilidades generales'),
(35, 'GENERAL', '2020-09-25', 1, 100, 'GENERAL sin URL local', 'GENERAL sin URL de repo online', 'Repo para TODAS las demas cosas que se pierden por ahi'),
(36, 'General - Admin', '2020-09-27', 0, 10, 'E:\\Trabajos\\Projects\\GIT Projects Gradle\\Admin', '125', 'Para correr permanentemente los modulos que ya se completaron y son necesarios tenerlos corriendo, como kanban'),
(37, 'TEST', '2020-09-28', 1, 5000, 'TEST sin ubicacion', 'TEST sin ubicacion', 'Proyecto de prueba');

-- --------------------------------------------------------

--
-- Table structure for table `tarea`
--

CREATE TABLE `tarea` (
  `id_tarea` int(11) NOT NULL,
  `nombre_tarea` varchar(100) NOT NULL,
  `codigo_tarea` varchar(10) NOT NULL,
  `puntos` int(11) NOT NULL,
  `descripcion` varchar(1000) NOT NULL,
  `prioridad_fk` int(11) NOT NULL,
  `proyecto_fk` int(11) NOT NULL,
  `columna_fk` int(11) NOT NULL,
  `last_change` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tarea`
--

INSERT INTO `tarea` (`id_tarea`, `nombre_tarea`, `codigo_tarea`, `puntos`, `descripcion`, `prioridad_fk`, `proyecto_fk`, `columna_fk`, `last_change`) VALUES
(1, 'test', 't-1', 3, 'test', 7, 37, 3, '2020-10-02'),
(2, '1', '1', 1, '123', 4, 37, 1, '2020-08-05');

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
  ADD UNIQUE KEY `nombre_proyecto` (`nombre_proyecto`),
  ADD UNIQUE KEY `UNIQUE_URL` (`url_local`),
  ADD UNIQUE KEY `UNIQUE_REPO` (`url_repo_online`);

--
-- Indexes for table `tarea`
--
ALTER TABLE `tarea`
  ADD PRIMARY KEY (`id_tarea`),
  ADD UNIQUE KEY `UNIQUE_COD_PROY` (`codigo_tarea`,`proyecto_fk`),
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
  MODIFY `id_proyecto` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=38;

--
-- AUTO_INCREMENT for table `tarea`
--
ALTER TABLE `tarea`
  MODIFY `id_tarea` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

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
