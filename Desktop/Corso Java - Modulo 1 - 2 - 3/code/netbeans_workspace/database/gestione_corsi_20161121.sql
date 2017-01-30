-- MySQL dump 10.13  Distrib 5.6.22, for osx10.8 (x86_64)
--
-- Host: 127.0.0.1    Database: gestione_corsi
-- ------------------------------------------------------
-- Server version	5.6.24

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
-- Table structure for table `corsi`
--

DROP TABLE IF EXISTS `corsi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `corsi` (
  `id_corso` int(11) NOT NULL AUTO_INCREMENT,
  `nome_corso` varchar(100) NOT NULL,
  `codice` varchar(20) NOT NULL,
  `note` int(11) DEFAULT NULL,
  `durata` int(11) NOT NULL,
  PRIMARY KEY (`id_corso`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `corsi`
--

LOCK TABLES `corsi` WRITE;
/*!40000 ALTER TABLE `corsi` DISABLE KEYS */;
INSERT INTO `corsi` VALUES (1,'Corso Java','CJ001',0,800),(2,'Taglio e cucito','TC002',0,500);
/*!40000 ALTER TABLE `corsi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `corsi_studenti`
--

DROP TABLE IF EXISTS `corsi_studenti`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `corsi_studenti` (
  `id_corso` int(11) NOT NULL,
  `id_studente` int(11) NOT NULL,
  UNIQUE KEY `idx_cs` (`id_corso`,`id_studente`),
  KEY `idx_corsi` (`id_corso`),
  KEY `idx_studenti` (`id_studente`),
  CONSTRAINT `fk_corso` FOREIGN KEY (`id_corso`) REFERENCES `corsi` (`id_corso`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_studente` FOREIGN KEY (`id_studente`) REFERENCES `partecipanti` (`id_studente`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `corsi_studenti`
--

LOCK TABLES `corsi_studenti` WRITE;
/*!40000 ALTER TABLE `corsi_studenti` DISABLE KEYS */;
/*!40000 ALTER TABLE `corsi_studenti` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `docenti`
--

DROP TABLE IF EXISTS `docenti`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `docenti` (
  `id_docente` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(50) NOT NULL,
  `cognome` varchar(50) NOT NULL,
  `cf` varchar(16) DEFAULT NULL,
  `qualifica` varchar(50) NOT NULL,
  PRIMARY KEY (`id_docente`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `docenti`
--

LOCK TABLES `docenti` WRITE;
/*!40000 ALTER TABLE `docenti` DISABLE KEYS */;
/*!40000 ALTER TABLE `docenti` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `docenti_corsi`
--

DROP TABLE IF EXISTS `docenti_corsi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `docenti_corsi` (
  `id_doc` int(11) NOT NULL,
  `id_corso` int(11) NOT NULL,
  UNIQUE KEY `idx_dc` (`id_doc`,`id_corso`),
  KEY `idx_corsi` (`id_corso`) USING BTREE,
  CONSTRAINT `fk_doc` FOREIGN KEY (`id_doc`) REFERENCES `docenti` (`id_docente`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_doccorso` FOREIGN KEY (`id_corso`) REFERENCES `corsi` (`id_corso`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `docenti_corsi`
--

LOCK TABLES `docenti_corsi` WRITE;
/*!40000 ALTER TABLE `docenti_corsi` DISABLE KEYS */;
/*!40000 ALTER TABLE `docenti_corsi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lezioni`
--

DROP TABLE IF EXISTS `lezioni`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `lezioni` (
  `id_lezione` int(11) NOT NULL AUTO_INCREMENT,
  `ore_totali` int(11) NOT NULL,
  `data` date NOT NULL,
  `argomento` varchar(100) DEFAULT NULL,
  `id_corso` int(11) NOT NULL,
  PRIMARY KEY (`id_lezione`),
  KEY `idx_corso` (`id_corso`),
  CONSTRAINT `fk_corsi` FOREIGN KEY (`id_corso`) REFERENCES `corsi` (`id_corso`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lezioni`
--

LOCK TABLES `lezioni` WRITE;
/*!40000 ALTER TABLE `lezioni` DISABLE KEYS */;
/*!40000 ALTER TABLE `lezioni` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `partecipanti`
--

DROP TABLE IF EXISTS `partecipanti`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `partecipanti` (
  `id_studente` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(50) NOT NULL,
  `cognome` varchar(50) NOT NULL,
  `cf` varchar(16) DEFAULT NULL,
  `provenienza` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_studente`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `partecipanti`
--

LOCK TABLES `partecipanti` WRITE;
/*!40000 ALTER TABLE `partecipanti` DISABLE KEYS */;
/*!40000 ALTER TABLE `partecipanti` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `presenze`
--

DROP TABLE IF EXISTS `presenze`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `presenze` (
  `id_lezione` int(11) NOT NULL,
  `id_studente` int(11) NOT NULL,
  `presenza` char(1) NOT NULL,
  KEY `idx_lezioni` (`id_lezione`),
  KEY `idx_studenti` (`id_studente`),
  CONSTRAINT `fk_lezioni` FOREIGN KEY (`id_lezione`) REFERENCES `lezioni` (`id_lezione`),
  CONSTRAINT `fk_studenti` FOREIGN KEY (`id_studente`) REFERENCES `partecipanti` (`id_studente`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `presenze`
--

LOCK TABLES `presenze` WRITE;
/*!40000 ALTER TABLE `presenze` DISABLE KEYS */;
/*!40000 ALTER TABLE `presenze` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-11-20 14:26:37
