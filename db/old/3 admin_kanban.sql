-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:7733
-- Generation Time: Sep 30, 2020 at 05:50 AM
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
  `columna_fk` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tarea`
--

INSERT INTO `tarea` (`id_tarea`, `nombre_tarea`, `codigo_tarea`, `puntos`, `descripcion`, `prioridad_fk`, `proyecto_fk`, `columna_fk`) VALUES
(14, 'Proyecto: +Fields', 'KAN - 1', 3, 'Agregar a la clase proyecto:\n	- La url de github del pull y push\n	- La ubicación del proyecto\n	- Prioridad del Proyecto', 2, 13, 4),
(16, 'Popup: Close popup', 'MOD - 1', 3, 'Que al seleccionar un elemento del popupICBS se cierre', 2, 6, 1),
(17, 'ToolTip multiple lines', 'SWiNG-1', 1, 'Hacer que el tool tip sangen en multiples lineas.\n	- Sacarlo por el AOP', 2, 3, 4),
(18, 'ALL', 'SWiNG-0', 100, '- _MaterialButtonDouble: sin estandar de clase generica abstracta\n- _MaterialButtonHiperlink: sin estandar de clase generica abstracta\n- _MaterialButtonIconTranspRotate: setIconRotate no sale en la definicion x defecto\n- _MaterialIconButtonRound: tiene el atributo circle sin ser estandar\n- panelAvatar y curves: sin estandar\n- _PanelGradient: color primario y secundario sin definicion en superclase\n- _PanelGradientTranslucid: trans sin definicion\n- dashboard completo, example\n- glasspane completo, example\n- login completo, example\n- spinner completo, example\n- searchField example\n- spinner\n- _MaterialTextArea estandar en superclase\n- task pane, table by page bien\n- Toggle icons en input view, segun standar del htlm', 2, 3, 1),
(19, 'All: Iconos', 'KAN-2', 3, '', 1, 13, 4),
(20, '+PDF', 'EXP - 1', 5, '', 3, 27, 1),
(22, '+HTML', 'EXP - 2', 5, '', 3, 27, 1),
(23, '+ Visual', 'LIC - 1', 5, '', 2, 29, 1),
(24, '+Tec', 'TEC - 1', 1, 'Agregar el resto de las tecnologias como:\n	- Gradle\n	- Material design\n	- Stack\n	- Kanban\n	- ...', 2, 32, 1),
(25, '+Visual', 'PERS - 1', 5, 'Agregar una interfaz visual a la personalizacion para no tener que cambiar las cosas directo en el fichero', 2, 31, 1),
(26, '+Temas', 'PERS - 2', 5, 'Crear un sistema de temas. Basicamente predefinir colores y eso', 2, 31, 1),
(27, 'Detail View: Autoincremental', 'MOD - 2', 2, '', 2, 6, 1),
(28, 'Puntos por combo box', 'KAN - 3', 2, 'Cambiar el text field de la tarea Input por un combo box', 2, 13, 4),
(29, 'Input view: visual', 'MOD - 3', 5, 'Cambiar la visual del Input view por la del video, minuto: 7:30', 2, 6, 1),
(30, 'Notificacion Copido', 'SWiNG - 3', 3, 'Mostrar la notificacion de que se copio, agregar al servicio de notificacioens el text vacio', 2, 3, 4),
(32, 'Copy last 10', 'SWiNG - 5', 3, 'Hacer que el clipboard guarde las ultimas 10 copias y despues con algo parecido al control+d las pegue', 1, 3, 1),
(33, '+Proy Admin', 'GEN - 1', 5, 'Crear un proyecto como el de TestingModulosGestion para las otras cosas que no se estan probando como kanban, para siempre tenerlo abierto.\nAgregarle que se minimize para el tray icon', 3, 35, 4),
(34, '+ System Tray', 'SWiNG - 6', 3, 'Crear el sistema para manejar el System tray', 2, 3, 4),
(35, 'DragDrop Tarea', 'KAN - 4', 3, 'Hacer que las tareas se muevan entre columnas por un drag and drop o unos botones pertinentes', 2, 13, 4),
(36, 'GitHub proyectos', 'GEN - 2', 8, 'Corregir bien TODOS los proyectos contra GitHub\n	- CORREGIR TODOS LOS NOMBRES\n	- Subir lo que falten y actualizarlos todos', 4, 35, 1),
(37, '+Modulo Woocomerce', 'Woo - 1', 8, 'Hacer modulo para integrarse a woocomerce.\n	- Necesario Internet', 5, 35, 1),
(38, '*CleanDragDropDetail', 'CONT - 1', 3, 'Cambiar todos los detail por el del drag drop con export y demas', 3, 10, 1),
(39, '*CleanDragDropDetail', 'GSTO - 1', 3, 'Revisar a ver si falta alguno por migrar', 3, 11, 1),
(40, '*ClenaDragDropDetal', 'NOM - 1', 3, 'Cambiar todos los detail por el del drag drop con export y demas', 3, 12, 1),
(41, 'Spring', 'SPRiNG - 0', 21, 'APRENDER SPRING:\n	Necesario:\n		- Internet', 4, 35, 1),
(42, 'Wrong ICBSPopup', 'MOD - 4', 2, 'Ponerle la funcionalidad del wrong al ICBS Popup para si no hay nada seleccionado x ejemplo', 2, 6, 1),
(43, '+Jpanel DragDrop', 'DnD - 1', 3, 'Terminar el sistema de drag drop', 2, 3, 1),
(44, 'PropertyReflection', 'I+D - 1', 8, 'Definir bien e implementar el sistema de setteo de propiedades via string.\nPasarle propiedades por el setName(\"back: white\") y que coja los setters', 1, 3, 1),
(45, 'SetEnable false', 'SWiNG', 2, 'En el icbs x ejemplo el setEnabled(false) no corrige colores', 2, 3, 1),
(46, '+Server Estable', 'GEN - 3', 2, 'Crear un xampp oficial para correr kanban, contabilidad y demas permanentemente', 4, 35, 1),
(47, 'PrioridadesICBS', 'KAN - 5', 3, 'Hacer que el boton de prioridades muestre el numero de la prioridad como un icono y el texto redondeado a 3o4 char', 2, 13, 4),
(48, 'Columna: +Posicion', 'KAN - 6', 2, 'Agregar al input y al detal de columna el campo prioridad', 2, 13, 4),
(49, 'Codigo auto', 'KAN - 8', 3, 'Hacer que el codigo se genera automatico al crear una nueva tarea', 2, 13, 1),
(50, 'Tarea: +TAGS', 'KAN - 7', 5, 'Hacer el sistema de tags para las tareas', 2, 13, 1),
(51, 'TEST', 'T - 1', 1, 'TEST', 7, 37, 1),
(52, 'ToolBar en el modelInput', 'MOD - 5', 1, 'Agregar una barra al estilo toolbar para agregar botones que se necesiten, como abrir carpeta para el editar y asi.\nValorar bien si es necesaria ya que eso se puede hacer en el detail', 2, 6, 1),
(53, '+DnD', 'EXP - 3', 2, 'Agregar al boton de crear del detail el drag and drop con los formatos que los lea e inserte', 2, 27, 1),
(55, 'TableByPage', 'SWiNG - 7', 2, 'Corregir el table by page.\n	- Que cuando se haga el update inicial ponga bien la cantidad por pagina, ahora inicialmente los pone todos.\n	- Que cuando se haga el update respete la pagina por la que estaba, que no vire al principio', 2, 3, 1),
(56, '+Almacén', 'MODULO - 1', 5, 'Crear el modulo almacen', 3, 35, 1),
(57, '+Ficha costo', 'MODULO - 2', 5, 'Crear el modulo de ficha de costo del servicio', 3, 35, 1),
(58, '+Servicio', 'MODULO - 3', 5, 'Crear modulo de servicios', 3, 35, 1),
(59, '+ONAT', 'MODULO - 4', 8, 'Crear el modulo de la onat, con exportacion de la declaracion jurada y demás', 3, 35, 1),
(60, '+Empresa-Ctto', 'MODULO - 5', 3, 'Crear el modulo de empresa y contratos', 3, 35, 1),
(62, '+Contratos Externos', 'MODULO - 6', 5, 'Crear el modulo para gestionar los servicios que se contratan externos, asi como arrendamientos y valores fijos mensuales.\nIncluye asi el sistema para repetir gastos eventualmente', 3, 35, 1),
(63, '+SEGURIDAD', 'MODULO - 8', 3, 'Modulo de seguridad, esperar a ver lo de Spring', 2, 35, 1),
(64, '/ login en modulo', 'SWiNG - 8', 3, 'Separar el login en un modulo aparte', 2, 3, 1),
(65, 'Cuenta: +PropChange update', 'CONT - 2', 5, 'Migrar la visual de cuenta detal, bancaria y contable para que se actualize cuando se actualize una cuenta', 3, 10, 4),
(66, 'Cuenta Bancaria: Edit', 'CTA - 1', 3, 'Error cuando se edita la cuenta de mlc, como si se editara el saldo ', 4, 10, 4),
(67, 'Liquidaciones(NO deja)', 'LIQ - 1', 5, 'No deja liquidar', 4, 10, 1),
(68, 'AOP cuentas', 'CTAS - 1', 2, 'AOP para cuentas para que coja el tooltip multi line', 2, 10, 1),
(69, '+#', 'SWiNG - 9', 5, 'Agregar icono de hashtag', 4, 3, 1),
(70, 'ICBS select SIZE', 'MOD - 6', 5, 'Cuando se selecciona algo en el ICBS combobox aunmenta el tamaño del componente', 4, 6, 1),
(71, '+Tareas Gradle', 'GRADLE - 1', 5, 'Aprender a hacer tareas para gradle para que haga el release del proyecto automatico', 1, 35, 3),
(72, '+Release', 'REL - 1', 3, 'Crear el modulo de release por las tareas del gradle', 2, 35, 3);

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
  MODIFY `id_proyecto` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=38;

--
-- AUTO_INCREMENT for table `tarea`
--
ALTER TABLE `tarea`
  MODIFY `id_tarea` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=73;

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
