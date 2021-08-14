-- phpMyAdmin SQL Dump
-- version 5.0.3
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost:3306
-- Tiempo de generación: 19-06-2021 a las 03:29:58
-- Versión del servidor: 10.4.14-MariaDB
-- Versión de PHP: 7.4.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `lina`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `categoria_producto`
--

CREATE TABLE `categoria_producto` (
  `id_categoria` int(11) UNSIGNED NOT NULL,
  `nombre_categoria` varchar(20) NOT NULL,
  `descripcion_categoria` mediumtext NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `categoria_producto`
--

INSERT INTO `categoria_producto` (`id_categoria`, `nombre_categoria`, `descripcion_categoria`) VALUES
(1, 'Gwen', 'Gwen'),
(2, 'Hass', 'Hass'),
(3, 'Criollo', 'Criollo'),
(4, 'Bacon', 'Bacon'),
(5, 'Choquette', 'Choquette');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalle_pedido`
--

CREATE TABLE `detalle_pedido` (
  `id_detalle` int(11) UNSIGNED NOT NULL,
  `id_pedido` int(11) UNSIGNED NOT NULL,
  `id_producto` int(11) UNSIGNED NOT NULL,
  `estado_pedido` varchar(20) NOT NULL,
  `cantidad_pedido` double NOT NULL,
  `cantidad` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `detalle_pedido`
--

INSERT INTO `detalle_pedido` (`id_detalle`, `id_pedido`, `id_producto`, `estado_pedido`, `cantidad_pedido`, `cantidad`) VALUES
(1, 12, 3, '', 68000, 2),
(2, 12, 5, '', 5000, 1),
(3, 13, 3, '', 68000, 2),
(4, 13, 5, '', 5000, 1),
(5, 14, 3, '', 68000, 2),
(6, 14, 5, '', 5000, 1),
(7, 15, 3, '', 68000, 2),
(8, 15, 5, '', 5000, 1),
(9, 16, 3, '', 34000, 1),
(10, 17, 5, '', 10000, 2),
(11, 18, 3, '', 34000, 1),
(12, 18, 4, '', 10500, 3),
(13, 18, 5, '', 10000, 2),
(14, 19, 3, '', 34000, 1),
(15, 19, 4, '', 10500, 3),
(16, 19, 5, '', 10000, 2),
(17, 20, 7, '', 30000, 6),
(18, 21, 3, '', 136000, 4),
(19, 21, 4, '', 7000, 2),
(20, 21, 5, '', 10000, 2),
(21, 21, 6, '', 3600, 1),
(22, 22, 3, '', 136000, 4),
(23, 22, 4, '', 7000, 2),
(24, 21, 7, '', 5000, 1),
(25, 21, 8, '', 60000, 1),
(26, 22, 5, '', 10000, 2),
(27, 22, 6, '', 3600, 1),
(28, 22, 7, '', 5000, 1),
(29, 22, 8, '', 60000, 1),
(30, 23, 3, '', 136000, 4),
(31, 23, 4, '', 7000, 2),
(32, 23, 5, '', 10000, 2),
(33, 23, 6, '', 3600, 1),
(34, 23, 7, '', 5000, 1),
(35, 23, 8, '', 60000, 1),
(36, 24, 3, '', 136000, 4),
(37, 24, 4, '', 7000, 2),
(38, 24, 5, '', 10000, 2),
(39, 24, 6, '', 3600, 1),
(40, 24, 7, '', 5000, 1),
(41, 24, 8, '', 60000, 1),
(42, 25, 3, '', 136000, 4),
(43, 25, 4, '', 7000, 2),
(44, 25, 5, '', 10000, 2),
(45, 25, 6, '', 3600, 1),
(46, 25, 7, '', 5000, 1),
(47, 25, 8, '', 60000, 1),
(48, 26, 3, '', 136000, 4),
(49, 26, 4, '', 7000, 2),
(50, 26, 5, '', 10000, 2),
(51, 26, 6, '', 3600, 1),
(52, 26, 7, '', 5000, 1),
(53, 26, 8, '', 60000, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `muestreo_calidad`
--

CREATE TABLE `muestreo_calidad` (
  `id_muestreo` int(11) UNSIGNED NOT NULL,
  `fecha_muestreo` date NOT NULL,
  `variedad_muestreo` varchar(20) NOT NULL,
  `cantidad_muestreo` int(11) NOT NULL,
  `peso_promedio` double NOT NULL,
  `temperatura_primedio` double NOT NULL,
  `masa_seca` double NOT NULL,
  `observaciones` varchar(1000) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `muestreo_calidad`
--

INSERT INTO `muestreo_calidad` (`id_muestreo`, `fecha_muestreo`, `variedad_muestreo`, `cantidad_muestreo`, `peso_promedio`, `temperatura_primedio`, `masa_seca`, `observaciones`) VALUES
(1, '2021-05-22', '2', 1, 7, 7, 5, '');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pedido`
--

CREATE TABLE `pedido` (
  `id_pedido` int(11) UNSIGNED NOT NULL,
  `id_usuario` int(11) UNSIGNED NOT NULL,
  `fecha_pedido` date NOT NULL,
  `fecha_entrega` date NOT NULL,
  `forma_envio` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `pedido`
--

INSERT INTO `pedido` (`id_pedido`, `id_usuario`, `fecha_pedido`, `fecha_entrega`, `forma_envio`) VALUES
(1, 9, '2021-05-12', '2021-05-20', 'carro'),
(2, 4, '2021-05-10', '2021-05-12', 'tren'),
(3, 4, '2021-05-20', '2021-05-20', 'contraenrega3'),
(4, 4, '2021-05-12', '2021-05-20', 'contraenrega4'),
(5, 4, '2021-05-20', '2021-05-27', 'contraenrega6'),
(6, 4, '2021-05-22', '2021-05-25', 'contraenrega2'),
(7, 5, '2021-05-05', '2021-05-10', 'carretera'),
(8, 8, '2021-05-04', '2021-05-27', 'carretera'),
(9, 4, '2021-05-25', '2021-06-02', 'maritima'),
(10, 6, '2021-05-04', '2021-05-18', 'barco'),
(11, 7, '2021-05-03', '2021-05-26', 'avion'),
(12, 5, '2021-05-30', '2021-05-18', 'Envio Express'),
(13, 5, '2021-05-30', '2021-05-18', 'Envio Express'),
(14, 5, '2021-05-30', '2021-05-18', 'Envio Express'),
(15, 5, '2021-05-30', '2021-05-18', 'Envio Express'),
(16, 4, '2021-05-30', '2021-05-31', 'Recoge en Tienda'),
(17, 5, '2021-05-30', '2021-05-31', 'Envio Express'),
(18, 4, '2021-05-30', '2021-05-31', 'Envio Express'),
(19, 4, '2021-05-30', '2021-05-31', 'Envio Express'),
(20, 4, '2021-06-04', '2021-06-08', 'Express'),
(21, 4, '2021-06-04', '2021-06-07', 'Envio Normal'),
(22, 4, '2021-06-04', '2021-06-07', 'Envio Normal'),
(23, 4, '2021-06-04', '2021-06-07', 'Envio Normal'),
(24, 4, '2021-06-04', '2021-06-07', 'Envio Normal'),
(25, 4, '2021-06-04', '2021-06-07', 'Envio Normal'),
(26, 4, '2021-06-04', '2021-06-07', 'Envio Normal');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `planta_linado`
--

CREATE TABLE `planta_linado` (
  `id_planta` int(11) UNSIGNED NOT NULL,
  `fecha_ingreso` date NOT NULL,
  `fecha_salida` date NOT NULL,
  `numero_operarios` int(11) NOT NULL,
  `cantidad_empacada` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `planta_linado`
--

INSERT INTO `planta_linado` (`id_planta`, `fecha_ingreso`, `fecha_salida`, `numero_operarios`, `cantidad_empacada`) VALUES
(1, '2021-05-22', '2021-05-23', 2, 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `producto`
--

CREATE TABLE `producto` (
  `id_producto` int(11) UNSIGNED NOT NULL,
  `id_tipo_producto` int(11) UNSIGNED NOT NULL,
  `id_categoria` int(11) UNSIGNED NOT NULL,
  `nombre_producto` varchar(20) DEFAULT NULL,
  `id_planta` int(11) UNSIGNED NOT NULL,
  `peso` varchar(45) DEFAULT NULL,
  `url_imagen` varchar(1000) DEFAULT NULL,
  `productocol` varchar(45) DEFAULT NULL,
  `id_muestreo` int(11) UNSIGNED NOT NULL,
  `unidades_existentes` int(11) NOT NULL DEFAULT 0,
  `precio` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `producto`
--

INSERT INTO `producto` (`id_producto`, `id_tipo_producto`, `id_categoria`, `nombre_producto`, `id_planta`, `peso`, `url_imagen`, `productocol`, `id_muestreo`, `unidades_existentes`, `precio`) VALUES
(3, 1, 1, 'semillas', 1, '3', 'a', '3', 1, 4, 34000),
(4, 1, 1, 'aguacate', 1, '3', '', '3', 1, 6, 3500),
(5, 1, 1, 'manzanas', 1, '3', '', '3', 1, 2, 5000),
(6, 3, 1, 'aguacate', 1, '1kg', 'a', 'verde', 1, 30, 3600),
(7, 4, 3, 'criollo', 1, '2kg', 'a', 'cafe', 1, 20, 5000),
(8, 1, 1, 'aguacate', 1, '1kg', '', '3', 1, 4, 60000);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_documento`
--

CREATE TABLE `tipo_documento` (
  `id_tipo_documento` int(11) UNSIGNED NOT NULL,
  `nombre_documento` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `tipo_documento`
--

INSERT INTO `tipo_documento` (`id_tipo_documento`, `nombre_documento`) VALUES
(1, 'Cedula de Ciudadania'),
(2, 'Cedula Extranjero'),
(3, 'Tarjeta de Identidad');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_producto`
--

CREATE TABLE `tipo_producto` (
  `id_tipo_producto` int(11) UNSIGNED NOT NULL,
  `nombre_tipo` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `tipo_producto`
--

INSERT INTO `tipo_producto` (`id_tipo_producto`, `nombre_tipo`) VALUES
(1, 'Firme'),
(2, 'Ruptura'),
(3, 'Maduro'),
(4, 'Sobremaduro');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_usuario`
--

CREATE TABLE `tipo_usuario` (
  `id_tipo_usuario` int(11) UNSIGNED NOT NULL,
  `nombre_usuario` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `tipo_usuario`
--

INSERT INTO `tipo_usuario` (`id_tipo_usuario`, `nombre_usuario`) VALUES
(1, 'Administrador'),
(2, 'Empleado');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `id_usuario` int(11) UNSIGNED NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `documento` varchar(30) NOT NULL,
  `correo` varchar(100) NOT NULL,
  `direccion` varchar(100) NOT NULL,
  `clave` varchar(200) NOT NULL,
  `telefono_fijo` varchar(20) DEFAULT NULL,
  `telefono_movil` varchar(20) DEFAULT NULL,
  `id_tipo_usuario` int(11) UNSIGNED NOT NULL,
  `id_tipo_documento` int(11) UNSIGNED NOT NULL,
  `id_estado` int(11) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`id_usuario`, `nombre`, `documento`, `correo`, `direccion`, `clave`, `telefono_fijo`, `telefono_movil`, `id_tipo_usuario`, `id_tipo_documento`, `id_estado`) VALUES
(4, 'nidiah', '233633', 'nidiaes@hotmail.com', '855220', '77f37055a6349b3770b1ee2f8c1f95f0de40a8ecaa931c6fe4e35768cda62205', NULL, '85552', 2, 1, 0),
(5, 'santy', '8523', 'sany@gmail.com', '97857', '0b592c692713048fb10a6bce270a9e83557d469c7d9c8e4766a6356ea5f89452', NULL, '85552', 2, 1, 0),
(6, 'andrea', '2555', 'andrea@gmaicom', '789895', '770c3cbf77615a1d94f88d0f9ed148823de46e4518a3f290fec2859e85b501ef', NULL, '7859', 2, 1, 0),
(7, 'Jose', '12356', 'jose@hotmail.com', '1235', 'a13df1211cf4c38cdb7a165c67f8e5ab6fded2982c2cb1f55d4cefef880183d5', NULL, '5258', 2, 1, 0),
(8, 'Nidia Herrera', '65412347', 'nidiaesm@hotmail.com', 'carrera 71-5', '41b8f299497b80edcfb541dc9685d723f43a5e27fa3fcd389b835a9f34a63af2', NULL, '3128962517', 2, 1, 0),
(9, 'Nidia Herrera', '65412347', 'nherrer54@gmail.com', 'carrera 71-5', '3b814105f5ff114e33df9cce7444ba7788b060e39619bed61c8b8b10b1c0f588', NULL, '3128962517', 2, 1, 0),
(10, 'Jose Dominguez', '123456788', 'josedominguez.121398@gmail.com', 'carrera 71-5', 'd3bcfb928bb9e48b36901392e9c48d1022feebb4ad4058543330a5659980160a', '3124569874', '3124658782', 1, 1, 1);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `categoria_producto`
--
ALTER TABLE `categoria_producto`
  ADD PRIMARY KEY (`id_categoria`);

--
-- Indices de la tabla `detalle_pedido`
--
ALTER TABLE `detalle_pedido`
  ADD PRIMARY KEY (`id_detalle`),
  ADD KEY `detalle_pedido_ibfk_1` (`id_pedido`),
  ADD KEY `detalle_pedido_ibfk_2` (`id_producto`);

--
-- Indices de la tabla `muestreo_calidad`
--
ALTER TABLE `muestreo_calidad`
  ADD PRIMARY KEY (`id_muestreo`);

--
-- Indices de la tabla `pedido`
--
ALTER TABLE `pedido`
  ADD PRIMARY KEY (`id_pedido`),
  ADD KEY `pedido_ibfk_1` (`id_usuario`);

--
-- Indices de la tabla `planta_linado`
--
ALTER TABLE `planta_linado`
  ADD PRIMARY KEY (`id_planta`);

--
-- Indices de la tabla `producto`
--
ALTER TABLE `producto`
  ADD PRIMARY KEY (`id_producto`),
  ADD KEY `producto_ibfk_1` (`id_tipo_producto`),
  ADD KEY `producto_ibfk_2` (`id_categoria`),
  ADD KEY `fk_producto_planta_linado1` (`id_planta`),
  ADD KEY `fk_producto_muestreo_calidad1` (`id_muestreo`);

--
-- Indices de la tabla `tipo_documento`
--
ALTER TABLE `tipo_documento`
  ADD PRIMARY KEY (`id_tipo_documento`);

--
-- Indices de la tabla `tipo_producto`
--
ALTER TABLE `tipo_producto`
  ADD PRIMARY KEY (`id_tipo_producto`);

--
-- Indices de la tabla `tipo_usuario`
--
ALTER TABLE `tipo_usuario`
  ADD PRIMARY KEY (`id_tipo_usuario`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`id_usuario`),
  ADD KEY `fk_usuario_cargo1` (`id_tipo_usuario`),
  ADD KEY `fk_usuario_tipo_documento1` (`id_tipo_documento`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `categoria_producto`
--
ALTER TABLE `categoria_producto`
  MODIFY `id_categoria` int(11) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT de la tabla `detalle_pedido`
--
ALTER TABLE `detalle_pedido`
  MODIFY `id_detalle` int(11) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=54;

--
-- AUTO_INCREMENT de la tabla `muestreo_calidad`
--
ALTER TABLE `muestreo_calidad`
  MODIFY `id_muestreo` int(11) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `pedido`
--
ALTER TABLE `pedido`
  MODIFY `id_pedido` int(11) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=27;

--
-- AUTO_INCREMENT de la tabla `planta_linado`
--
ALTER TABLE `planta_linado`
  MODIFY `id_planta` int(11) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `producto`
--
ALTER TABLE `producto`
  MODIFY `id_producto` int(11) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT de la tabla `tipo_documento`
--
ALTER TABLE `tipo_documento`
  MODIFY `id_tipo_documento` int(11) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `tipo_producto`
--
ALTER TABLE `tipo_producto`
  MODIFY `id_tipo_producto` int(11) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de la tabla `tipo_usuario`
--
ALTER TABLE `tipo_usuario`
  MODIFY `id_tipo_usuario` int(11) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `id_usuario` int(11) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `detalle_pedido`
--
ALTER TABLE `detalle_pedido`
  ADD CONSTRAINT `detalle_pedido_ibfk_1` FOREIGN KEY (`id_pedido`) REFERENCES `pedido` (`id_pedido`),
  ADD CONSTRAINT `detalle_pedido_ibfk_2` FOREIGN KEY (`id_producto`) REFERENCES `producto` (`id_producto`);

--
-- Filtros para la tabla `pedido`
--
ALTER TABLE `pedido`
  ADD CONSTRAINT `pedido_ibfk_1` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`);

--
-- Filtros para la tabla `producto`
--
ALTER TABLE `producto`
  ADD CONSTRAINT `fk_producto_muestreo_calidad1` FOREIGN KEY (`id_muestreo`) REFERENCES `muestreo_calidad` (`id_muestreo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_producto_planta_linado1` FOREIGN KEY (`id_planta`) REFERENCES `planta_linado` (`id_planta`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `producto_ibfk_1` FOREIGN KEY (`id_tipo_producto`) REFERENCES `tipo_producto` (`id_tipo_producto`),
  ADD CONSTRAINT `producto_ibfk_2` FOREIGN KEY (`id_categoria`) REFERENCES `categoria_producto` (`id_categoria`);

--
-- Filtros para la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD CONSTRAINT `fk_usuario_cargo1` FOREIGN KEY (`id_tipo_usuario`) REFERENCES `tipo_usuario` (`id_tipo_usuario`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_usuario_tipo_documento1` FOREIGN KEY (`id_tipo_documento`) REFERENCES `tipo_documento` (`id_tipo_documento`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
