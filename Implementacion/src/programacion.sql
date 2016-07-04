-- phpMyAdmin SQL Dump
-- version 3.5.2.2
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 06-07-2013 a las 19:41:05
-- Versión del servidor: 5.5.27
-- Versión de PHP: 5.4.7

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `programacion`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

CREATE TABLE IF NOT EXISTS `cliente` (
  `cedula` varchar(13) NOT NULL,
  `nombres` varchar(150) NOT NULL,
  `apellidos` varchar(150) NOT NULL,
  `direccion` varchar(150) NOT NULL,
  `telefono` varchar(10) NOT NULL,
  `zona` varchar(50) NOT NULL,
  PRIMARY KEY (`cedula`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`cedula`, `nombres`, `apellidos`, `direccion`, `telefono`, `zona`) VALUES
('1104109499', 'Marvin Rafael', 'Jimbo Jaramillo', 'Loja', '2573432', 'Norte'),
('1104897390', 'Miguel Eduardo ', 'Castillo Cevallos', 'Loja', '2580670', 'Centro'),
('1105133647', 'Franco David', 'Bustamante Jimenez', 'Loja', '2578435', 'Norte');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `despacho`
--

CREATE TABLE IF NOT EXISTS `despacho` (
  `id_despacho` int(11) NOT NULL AUTO_INCREMENT,
  `fecha_despacho` date NOT NULL,
  PRIMARY KEY (`id_despacho`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalle_pedido`
--

CREATE TABLE IF NOT EXISTS `detalle_pedido` (
  `id_detalle_pedido` int(11) NOT NULL AUTO_INCREMENT,
  `pedido_id` int(11) NOT NULL,
  `nombre_producto` varchar(100) NOT NULL,
  `cantidad_producto` int(5) NOT NULL,
  `precio_producto` double NOT NULL,
  `precio_total` double NOT NULL,
  `estado` enum('Pedido','Despachado','Cancelado') NOT NULL,
  PRIMARY KEY (`id_detalle_pedido`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `existencias`
--

CREATE TABLE IF NOT EXISTS `existencias` (
  `producto` varchar(100) NOT NULL,
  `existencias` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `existencias`
--

INSERT INTO `existencias` (`producto`, `existencias`) VALUES
('manjar de leche', 300),
('queso fresco', 300),
('Leche Pasteurizada', 300),
('Yogurt', 300),
('Crema de Leche', 300),
('Mantequilla', 300);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pedido`
--

CREATE TABLE IF NOT EXISTS `pedido` (
  `pedido_id` int(11) NOT NULL AUTO_INCREMENT,
  `cliente` varchar(100) NOT NULL,
  `fecha_pedido` date NOT NULL,
  `fecha_entrega` date NOT NULL,
  PRIMARY KEY (`pedido_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productos`
--

CREATE TABLE IF NOT EXISTS `productos` (
  `id_producto` int(11) NOT NULL AUTO_INCREMENT,
  `nombre_producto` varchar(100) NOT NULL,
  `stk_minimo` int(11) NOT NULL,
  `stk_maximo` int(11) NOT NULL,
  `precio_producto` float(10,2) NOT NULL,
  PRIMARY KEY (`id_producto`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=8 ;

--
-- Volcado de datos para la tabla `productos`
--

INSERT INTO `productos` (`id_producto`, `nombre_producto`, `stk_minimo`, `stk_maximo`, `precio_producto`) VALUES
(1, 'Leche Pasteurizada', 10, 300, 2.25),
(2, 'Yogurt', 10, 300, 1.25),
(3, 'queso fresco', 10, 300, 1.80),
(4, 'Crema de Leche', 10, 300, 2.15),
(5, 'Mantequilla', 10, 300, 1.25),
(6, 'manjar de leche', 10, 300, 1.25),
(7, 'leche', 20, 300, 1.00);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE IF NOT EXISTS `usuarios` (
  `cedula` varchar(13) NOT NULL,
  `nombres` varchar(150) NOT NULL,
  `apellidos` varchar(150) NOT NULL,
  `direccion` varchar(200) NOT NULL,
  `telefono` varchar(10) NOT NULL,
  `usuario` varchar(80) NOT NULL,
  `clave` varchar(80) NOT NULL,
  `tipo` enum('Administrador','Personal') NOT NULL,
  PRIMARY KEY (`cedula`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`cedula`, `nombres`, `apellidos`, `direccion`, `telefono`, `usuario`, `clave`, `tipo`) VALUES
('1104109499', 'Marvin Rafael', 'Jimbo Jaramillo', 'Loja', '2573432', 'mrjimbo', 'mrjimbo', 'Personal'),
('1104897390', 'Miguel Eduardo ', 'Castillo Cevallos', 'Loja', '2570622', 'cevallos25', 'cevallos2', 'Personal'),
('1104897396', 'administrador', 'administrador', 'Loja', '2580670', 'admin', 'admin', 'Administrador'),
('1105133647', 'Franco David', 'Bustamante Jimenez', 'Loja', '2578435', 'fdbustamante', 'fdbustamante', 'Personal');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
