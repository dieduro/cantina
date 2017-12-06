-- MySQL dump 10.13  Distrib 5.7.17, for macos10.12 (x86_64)
--
-- Host: 127.0.0.1    Database: cantina_db
-- ------------------------------------------------------
-- Server version	5.6.35

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `articulos`
--

DROP TABLE IF EXISTS `articulos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `articulos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  `desripcion` text NOT NULL,
  `cantidad` int(11) NOT NULL,
  `precio` decimal(10,0) NOT NULL,
  `rubro_id` int(11) DEFAULT NULL,
  `activo` tinyint(4) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `rubro_id` (`rubro_id`),
  CONSTRAINT `articulos_ibfk_1` FOREIGN KEY (`rubro_id`) REFERENCES `rubros` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `articulos`
--

LOCK TABLES `articulos` WRITE;
/*!40000 ALTER TABLE `articulos` DISABLE KEYS */;
INSERT INTO `articulos` VALUES (1,'Yerba','Yerba Rosamonte 1kg',50,60,1,1),(2,'Soda','Ives 1lt',200,20,1,1),(3,'Azucar','Ledesma 3kg',30,55,1,1),(4,'FIdeos','Matarazzo 1kg',50,80,1,1),(5,'Hardy','Protéica',150,120,1,1),(6,'Chocotorta','porcion de chocotorta',45,45,3,1),(7,'Yerba','El alba 500gr',40,65,1,1),(8,'Miel','Las Araucarias',40,80,1,1),(9,'Pastafrola','porción de Membrillo',30,30,3,1),(10,'Cerveza','Brahma 1lt',50,70,2,1),(11,'Lemon Pie','porcion',50,45,3,1),(12,'Snack','lays, cheetos, 3d 120gr',70,25,1,1);
/*!40000 ALTER TABLE `articulos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rubros`
--

DROP TABLE IF EXISTS `rubros`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rubros` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  `activo` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rubros`
--

LOCK TABLES `rubros` WRITE;
/*!40000 ALTER TABLE `rubros` DISABLE KEYS */;
INSERT INTO `rubros` VALUES (1,'Almacen',1),(2,'Bebidas',1),(3,'Comida',1),(4,'Ferreteria',NULL);
/*!40000 ALTER TABLE `rubros` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tareas`
--

DROP TABLE IF EXISTS `tareas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tareas` (
  `id_tarea` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `titulo` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `descripcion` varchar(255) COLLATE utf8_spanish_ci NOT NULL,
  `nivel_de_prioridad` tinyint(1) NOT NULL,
  PRIMARY KEY (`id_tarea`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tareas`
--

LOCK TABLES `tareas` WRITE;
/*!40000 ALTER TABLE `tareas` DISABLE KEYS */;
/*!40000 ALTER TABLE `tareas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nick` varchar(100) COLLATE utf8_spanish_ci NOT NULL,
  `password` varchar(100) COLLATE utf8_spanish_ci NOT NULL,
  `activo` int(11) DEFAULT NULL,
  `tipo_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `tipo_id` (`tipo_id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'paco','paco',1,1),(2,'usuario','usuario',1,2);
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarioTipo`
--

DROP TABLE IF EXISTS `usuarioTipo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuarioTipo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tipo` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarioTipo`
--

LOCK TABLES `usuarioTipo` WRITE;
/*!40000 ALTER TABLE `usuarioTipo` DISABLE KEYS */;
INSERT INTO `usuarioTipo` VALUES (1,'administrador'),(2,'usuario');
/*!40000 ALTER TABLE `usuarioTipo` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-12-06 16:44:15
