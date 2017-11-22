
use cantina_db;
SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";




CREATE TABLE `rubros` (
  `id` int(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `nombre` varchar(50) NOT NULL

) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `articulos` (
  `id` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `desripcion` text NOT NULL,
  `cantidad` int(11) NOT NULL,
  `precio` decimal(10,0) NOT NULL,
  `rubro_id` int(11) DEFAULT NULL,
  `activo` tinyint(4) NOT NULL,
  FOREIGN KEY (`rubro_id`) REFERENCES `rubros`(`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `rubros`(`nombre`) VALUES
('Almacen'),
('Bebidas'),
('Comida');

INSERT INTO `articulos` (`id`, `nombre`, `desripcion`, `cantidad`, `precio`, `rubro_id`, `activo`) VALUES
(1, 'Yerba', 'Yerba Rosamonte 1kg', 50, '60', 1, 1),
(2, 'Yerba', 'Yerba Rosamonte 1/2 kg', 50, '45', 1, 1),
(3, 'Azucar', 'Azucar ledesma 1kg', 50, '30', 1, 1),
(4, 'Cafe', 'Cafe La Morenita 1kg', 50, '80', 1, 1);


CREATE TABLE `tareas` (
  `id_tarea` int(10) UNSIGNED NOT NULL,
  `titulo` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `descripcion` varchar(255) COLLATE utf8_spanish_ci NOT NULL,
  `nivel_de_prioridad` tinyint(1) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;


CREATE TABLE `usuario` (
  `id` int(11) NOT NULL,
  `nick` varchar(100) COLLATE utf8_spanish_ci NOT NULL,
  `password` varchar(100) COLLATE utf8_spanish_ci NOT NULL,
  `tipo` varchar(100) COLLATE utf8_spanish_ci NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;


INSERT INTO `usuario` (`id`, `nick`, `password`, `tipo`) VALUES
(1, 'paco', 'paco', 'administrador'),
(2, 'usuario', 'usuario', 'usuario');

ALTER TABLE `articulos`
  ADD PRIMARY KEY (`id`);


ALTER TABLE `tareas`
  ADD PRIMARY KEY (`id_tarea`);


ALTER TABLE `usuario`
  ADD PRIMARY KEY (`id`);


ALTER TABLE `articulos`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

ALTER TABLE `tareas`
  MODIFY `id_tarea` int(10) UNSIGNED NOT NULL AUTO_INCREMENT;

ALTER TABLE `usuario`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
