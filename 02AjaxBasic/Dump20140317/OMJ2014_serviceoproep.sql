CREATE DATABASE  IF NOT EXISTS `OMJ2014` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `OMJ2014`;
-- MySQL dump 10.13  Distrib 5.5.35, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: OMJ2014
-- ------------------------------------------------------
-- Server version	5.5.35-0ubuntu0.13.10.2

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
-- Table structure for table `serviceoproep`
--

DROP TABLE IF EXISTS `serviceoproep`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `serviceoproep` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `K_id` int(11) NOT NULL,
  `KorteOmschrijving` varchar(100) DEFAULT NULL,
  `Omschrijving` varchar(500) NOT NULL,
  `Geopend` date NOT NULL,
  `Afgesloten` date DEFAULT NULL,
  `M_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_serviceoproep_klant_idx` (`K_id`),
  KEY `fk_serviceoproep_medewerker` (`M_id`),
  CONSTRAINT `fk_serviceoproep_medewerker` FOREIGN KEY (`M_id`) REFERENCES `medewerker` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_serviceoproep_klant` FOREIGN KEY (`K_id`) REFERENCES `klant` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `serviceoproep`
--

LOCK TABLES `serviceoproep` WRITE;
/*!40000 ALTER TABLE `serviceoproep` DISABLE KEYS */;
INSERT INTO `serviceoproep` VALUES (2,39,'test','test','2014-03-16',NULL,2),(3,39,'test','test','2014-03-16',NULL,4);
/*!40000 ALTER TABLE `serviceoproep` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-03-17 10:38:19
