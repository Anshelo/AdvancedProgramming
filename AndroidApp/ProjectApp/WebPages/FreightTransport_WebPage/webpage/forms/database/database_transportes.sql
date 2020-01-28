/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50505
Source Host           : localhost:3306
Source Database       : database_transportes

Target Server Type    : MYSQL
Target Server Version : 50505
File Encoding         : 65001

Date: 2019-12-01 18:52:59
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for cliente
-- ----------------------------
DROP TABLE IF EXISTS `cliente`;
CREATE TABLE `cliente` (
  `ci` varchar(10) NOT NULL,
  `ruc` varchar(15) DEFAULT NULL,
  `nombre` varchar(72) NOT NULL,
  `direccion` varchar(128) NOT NULL,
  `telfconvencional` varchar(10) DEFAULT NULL,
  `telfcelular` varchar(10) DEFAULT NULL,
  `correo` varchar(64) DEFAULT '',
  PRIMARY KEY (`ci`),
  KEY `ci` (`ci`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of cliente
-- ----------------------------
INSERT INTO `cliente` VALUES ('1714298823', '1714298823001', 'Juan Perez ', 'Sangolqui', '023456897', '0998263636', 'juan@hotmail.com');
INSERT INTO `cliente` VALUES ('1714578899', '1714578899001', 'Patricia Pradas', 'La kennedy', '024637867', '0987654676', 'patricia@hotmail.com');
INSERT INTO `cliente` VALUES ('1726416065', '1726416065001', 'Luis Almeida', 'La armenia', '025678654', '0987656765', 'luis@hotmail.com');
INSERT INTO `cliente` VALUES ('1726416066', '1714879977001', 'Angel Garcia', 'Los pinos', '023467856', '098756789', 'angel@hotmail.com');
INSERT INTO `cliente` VALUES ('1726416173', '1726416173001', 'Dennise Sandoval', 'Carapungo', '023463859', '0979296608', 'dasandoval3@espe.edu.ec');

-- ----------------------------
-- Table structure for detalleguia
-- ----------------------------
DROP TABLE IF EXISTS `detalleguia`;
CREATE TABLE `detalleguia` (
  `idguia` varchar(10) DEFAULT NULL,
  `codproducto` varchar(10) DEFAULT NULL,
  `cantidad` int(11) DEFAULT NULL,
  KEY `idguia` (`idguia`),
  KEY `codproducto` (`codproducto`),
  CONSTRAINT `codproducto` FOREIGN KEY (`codproducto`) REFERENCES `producto` (`codigoprod`),
  CONSTRAINT `idguia` FOREIGN KEY (`idguia`) REFERENCES `guia` (`idguia`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of detalleguia
-- ----------------------------

-- ----------------------------
-- Table structure for guia
-- ----------------------------
DROP TABLE IF EXISTS `guia`;
CREATE TABLE `guia` (
  `idguia` varchar(8) NOT NULL,
  `fechaenvio` date NOT NULL,
  `fecha_entrega` date NOT NULL,
  `cantidad` int(11) NOT NULL,
  `total` double NOT NULL,
  `ci_cliente` varchar(10) NOT NULL DEFAULT '',
  `ci_transportista` varchar(10) NOT NULL DEFAULT '',
  `cod_zona` varchar(8) NOT NULL DEFAULT '',
  PRIMARY KEY (`idguia`),
  KEY `cicliente` (`ci_cliente`),
  KEY `citransp` (`ci_transportista`),
  KEY `codzona` (`cod_zona`),
  CONSTRAINT `cicliente` FOREIGN KEY (`ci_cliente`) REFERENCES `cliente` (`ci`),
  CONSTRAINT `citransp` FOREIGN KEY (`ci_transportista`) REFERENCES `transportista` (`ci`),
  CONSTRAINT `codzona` FOREIGN KEY (`cod_zona`) REFERENCES `zona` (`codigozona`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of guia
-- ----------------------------
INSERT INTO `guia` VALUES ('1', '2019-09-09', '2019-09-26', '3', '22.5', '1714298823', '1726415672', '3');
INSERT INTO `guia` VALUES ('2', '2019-11-05', '2019-11-13', '7', '89', '1714298823', '1714298876', '3');
INSERT INTO `guia` VALUES ('3', '1997-09-30', '1997-10-06', '6', '66.66', '1726416065', '1754565455', '1');
INSERT INTO `guia` VALUES ('4', '1997-09-30', '1997-10-06', '6', '66.66', '1726416065', '1754565455', '2');

-- ----------------------------
-- Table structure for producto
-- ----------------------------
DROP TABLE IF EXISTS `producto`;
CREATE TABLE `producto` (
  `codigoprod` varchar(8) NOT NULL DEFAULT '',
  `nombreprod` varchar(52) NOT NULL,
  `descripcion` varchar(72) NOT NULL DEFAULT '',
  `peso` double DEFAULT NULL,
  `sensibilidad` varchar(16) NOT NULL,
  `valorunit` double DEFAULT NULL,
  PRIMARY KEY (`codigoprod`),
  KEY `codigoprod` (`codigoprod`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of producto
-- ----------------------------
INSERT INTO `producto` VALUES ('01', 'Refrigeradora', 'Pesado', '20', 'Fragil', '44.5');
INSERT INTO `producto` VALUES ('02', 'Refrigeradora', 'Pesado', '20', 'Fragil', '44.5');
INSERT INTO `producto` VALUES ('03', 'Cocina', 'Pesado', '15', 'Fragil', '34.5');
INSERT INTO `producto` VALUES ('04', 'Microondas', 'Pesado', '8', 'Fragil', '20.5');
INSERT INTO `producto` VALUES ('05', 'Comedor', 'Pesado', '100', 'Fragil', '204.5');
INSERT INTO `producto` VALUES ('09', 'Mesa', 'Pesado', '45', 'No Fragil', '90');
INSERT INTO `producto` VALUES ('10', 'Mesa', 'Pesado', '45', 'No Fragil', '90');
INSERT INTO `producto` VALUES ('11', 'Mesa', 'Pesado', '45', 'No Fragil', '90');

-- ----------------------------
-- Table structure for transportista
-- ----------------------------
DROP TABLE IF EXISTS `transportista`;
CREATE TABLE `transportista` (
  `codigotransp` int(10) NOT NULL,
  `ci` varchar(10) NOT NULL,
  `birthdate` date DEFAULT NULL,
  `nombre` varchar(72) NOT NULL,
  `direccion` varchar(128) NOT NULL,
  `telfconvencional` varchar(10) DEFAULT NULL,
  `telfcelular` varchar(10) DEFAULT NULL,
  `correo` varchar(64) DEFAULT '',
  `placaCamion` varchar(8) NOT NULL,
  `tipoCamion` varchar(16) NOT NULL,
  PRIMARY KEY (`ci`),
  KEY `codigotransp` (`codigotransp`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of transportista
-- ----------------------------
INSERT INTO `transportista` VALUES ('0', '', null, '', '', null, null, '', '', '');
INSERT INTO `transportista` VALUES ('1', '1714298876', '1985-07-17', 'Alvaro Paez', 'Sangolqui', '023456784', '0995857701', 'alvaro@hotmail.com', 'PBK-3453', 'Trailer');
INSERT INTO `transportista` VALUES ('2', '1726415672', '1994-06-20', 'Vinicio Gomez', 'La vicentina', '027865487', '0976564483', 'vinicio@hotmail.com', 'PCK-9867', 'Articulado');
INSERT INTO `transportista` VALUES ('3', '1754565455', '1994-04-06', 'Carlos Salazar', 'Sangolqui', '024637437', '0987656766', 'carlos@hotmail.com', 'PKO-9865', 'Rigido');

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(16) NOT NULL,
  `password` varchar(60) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of users
-- ----------------------------

-- ----------------------------
-- Table structure for zona
-- ----------------------------
DROP TABLE IF EXISTS `zona`;
CREATE TABLE `zona` (
  `codigozona` varchar(8) NOT NULL DEFAULT '',
  `nombrezona` varchar(52) NOT NULL,
  PRIMARY KEY (`codigozona`),
  KEY `codigozona` (`codigozona`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of zona
-- ----------------------------
INSERT INTO `zona` VALUES ('1', 'Quito');
INSERT INTO `zona` VALUES ('2 ', 'Cuenca');
INSERT INTO `zona` VALUES ('3 ', 'Guayaquil');
INSERT INTO `zona` VALUES ('4', 'Ambato');
INSERT INTO `zona` VALUES ('5 ', 'Manta');
