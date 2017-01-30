-- MySQL dump 10.13  Distrib 5.6.22, for osx10.8 (x86_64)
--
-- Host: 127.0.0.1    Database: opengest
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
-- Table structure for table `auth_authorities`
--

DROP TABLE IF EXISTS `auth_authorities`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `auth_authorities` (
  `role_desc` varchar(45) NOT NULL,
  `role_name` varchar(45) NOT NULL,
  `version` int(11) DEFAULT NULL,
  `function_desc` varchar(255) DEFAULT NULL,
  `id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`role_name`),
  UNIQUE KEY `IDX_ROLENAME` (`role_name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `auth_authorities`
--

LOCK TABLES `auth_authorities` WRITE;
/*!40000 ALTER TABLE `auth_authorities` DISABLE KEYS */;
INSERT INTO `auth_authorities` VALUES ('Ruolo per amministrazione CRM','ROLE_ADMIN',NULL,NULL,NULL),('Ruolo accesso clienti','ROLE_CUSTOMER',NULL,NULL,NULL),('Ruolo accesso amministrativi','ROLE_OPERATOR',NULL,NULL,NULL);
/*!40000 ALTER TABLE `auth_authorities` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `auth_group_authorities`
--

DROP TABLE IF EXISTS `auth_group_authorities`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `auth_group_authorities` (
  `group_id` bigint(11) NOT NULL DEFAULT '0',
  `authority` varchar(45) NOT NULL,
  KEY `FK771BA1611C704C6C` (`authority`),
  KEY `FK_AUTH` (`authority`),
  KEY `FK771BA16186665666` (`group_id`),
  CONSTRAINT `FK771BA1611C704C6C` FOREIGN KEY (`authority`) REFERENCES `auth_authorities` (`role_name`) ON DELETE CASCADE ON UPDATE NO ACTION,
  CONSTRAINT `FK_ghfeoauknp3xv8y7grl1ov7bi` FOREIGN KEY (`group_id`) REFERENCES `auth_groups` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `auth_group_authorities`
--

LOCK TABLES `auth_group_authorities` WRITE;
/*!40000 ALTER TABLE `auth_group_authorities` DISABLE KEYS */;
INSERT INTO `auth_group_authorities` VALUES (3,'ROLE_ADMIN'),(4,'ROLE_OPERATOR'),(3,'ROLE_CUSTOMER'),(3,'ROLE_OPERATOR');
/*!40000 ALTER TABLE `auth_group_authorities` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `auth_group_members`
--

DROP TABLE IF EXISTS `auth_group_members`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `auth_group_members` (
  `username` varchar(45) NOT NULL,
  `group_id` bigint(10) NOT NULL,
  `id_utente` bigint(20) NOT NULL,
  KEY `FK3B9C7759AA46D2B7` (`group_id`),
  KEY `FK_USER_idx` (`username`),
  CONSTRAINT `FK_st8w36hp4rvc427y24yb37sm2` FOREIGN KEY (`group_id`) REFERENCES `auth_groups` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `auth_group_members`
--

LOCK TABLES `auth_group_members` WRITE;
/*!40000 ALTER TABLE `auth_group_members` DISABLE KEYS */;
INSERT INTO `auth_group_members` VALUES ('giontellar',2,0),('giontellar',3,0),('giontellar',4,0),('operator1',4,0);
/*!40000 ALTER TABLE `auth_group_members` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `auth_groups`
--

DROP TABLE IF EXISTS `auth_groups`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `auth_groups` (
  `id` bigint(10) NOT NULL,
  `description` varchar(45) DEFAULT NULL,
  `group_name` varchar(45) DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `IDX_GROUPNAME` (`group_name`),
  UNIQUE KEY `UK_97m2i8eyt2btjs9l9rdu1cjn` (`group_name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `auth_groups`
--

LOCK TABLES `auth_groups` WRITE;
/*!40000 ALTER TABLE `auth_groups` DISABLE KEYS */;
INSERT INTO `auth_groups` VALUES (2,'Superuser','SUPERUSER',NULL),(3,'Admin','ADMIN',NULL),(4,'Operator','OPERATOR',NULL);
/*!40000 ALTER TABLE `auth_groups` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `authorities`
--

DROP TABLE IF EXISTS `authorities`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `authorities` (
  `role_name` varchar(255) NOT NULL,
  `role_desc` varchar(255) DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  PRIMARY KEY (`role_name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `authorities`
--

LOCK TABLES `authorities` WRITE;
/*!40000 ALTER TABLE `authorities` DISABLE KEYS */;
/*!40000 ALTER TABLE `authorities` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `clienti`
--

DROP TABLE IF EXISTS `clienti`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `clienti` (
  `id_cliente` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `codice` varchar(45) NOT NULL,
  `rag_soc` varchar(45) NOT NULL,
  `piva` varchar(11) NOT NULL,
  `version` int(11) DEFAULT '0',
  PRIMARY KEY (`id_cliente`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clienti`
--

LOCK TABLES `clienti` WRITE;
/*!40000 ALTER TABLE `clienti` DISABLE KEYS */;
INSERT INTO `clienti` VALUES (1,'OPGCL1','Zucchetti srl','12325456325',0),(6,'CLI006','Cliente molto importsnte','12325456325',0),(7,'OPGCL1','Zucchetti srl','12325456325',0),(8,'OPGCL1','Zucchetti srl','12325456325',0),(9,'OPGCL1_Sun Nov 27 23:20:13 CET 2016','Zucchetti srl','12325456325',0),(10,'OPGCL1_Sun Nov 27 23:21:59 CET 2016','Zucchetti srl','12325456325',0),(11,'OPGCL1_Sun Nov 27 23:25:26 CET 2016','Zucchetti srl','12325456325',0),(14,'OPGCL1_Sun Nov 27 23:39:11 CET 2016','Zucchetti srl','12325456325',0),(15,'OPGCL1_Sun Nov 27 23:43:26 CET 2016','Zucchetti srl','12325456325',0),(16,'OPGCL1_Sun Nov 27 23:46:06 CET 2016','Zucchetti srl','12325456325',0),(18,'OPGCL1_Sun Nov 27 23:51:46 CET 2016','Zucchetti srl','12325456325',0),(19,'OPGCL1_Sun Nov 27 23:53:41 CET 2016','Zucchetti srl','12325456325',0),(20,'OPGCL1_Mon Nov 28 00:02:35 CET 2016','Zucchetti srl','12325456325',0),(21,'OPGCL1_Mon Nov 28 00:04:47 CET 2016','Zucchetti srl','12325456325',0),(22,'OPGCL1_Mon Nov 28 00:10:24 CET 2016','Zucchetti srl','12325456325',0),(25,'OPGL2','Customer molto importante	','12325456325',0),(26,'OPGL2','Customer molto importante	','12325456325',0),(27,'OPGL2','Customer molto importante	','12325456325',0),(28,'OPGL2','Customer molto importante	','12325456325',0),(29,'OPGL2','Customer molto importante	','12325456325',0),(30,'OPGL2','Customer molto importante	','12325456325',0);
/*!40000 ALTER TABLE `clienti` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `company`
--

DROP TABLE IF EXISTS `company`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `company` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `extended_desc` varchar(255) DEFAULT NULL,
  `id_company` int(11) DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `company`
--

LOCK TABLES `company` WRITE;
/*!40000 ALTER TABLE `company` DISABLE KEYS */;
INSERT INTO `company` VALUES (1,'Apple','',1,0),(2,'AMAZON','Cliente molto importante',1,0);
/*!40000 ALTER TABLE `company` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer_contract`
--

DROP TABLE IF EXISTS `customer_contract`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customer_contract` (
  `id_contract` int(11) NOT NULL,
  `date_start` datetime NOT NULL,
  `protocol` varchar(45) NOT NULL,
  `amount` decimal(10,0) DEFAULT NULL,
  `date_end` datetime DEFAULT NULL,
  `notes` varchar(250) DEFAULT NULL,
  PRIMARY KEY (`id_contract`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer_contract`
--

LOCK TABLES `customer_contract` WRITE;
/*!40000 ALTER TABLE `customer_contract` DISABLE KEYS */;
INSERT INTO `customer_contract` VALUES (7,'2016-11-27 00:00:00','CC02',NULL,'2016-03-06 00:00:00','Contratto per la consulenza Java'),(8,'2016-11-27 00:00:00','CC02',NULL,'2016-03-06 00:00:00','Contratto per la consulenza Java'),(9,'2016-11-27 00:00:00','CC03',NULL,'2016-03-06 00:00:00','Contratto per la consulenza Java'),(10,'2016-11-27 00:00:00','CC04',NULL,'2016-03-06 00:00:00','Contratto per la consulenza Java'),(11,'2016-11-27 00:00:00','CC05',NULL,'2016-03-06 00:00:00','Contratto per la consulenza Java'),(12,'2015-06-15 00:00:00','CC01',NULL,'2015-09-23 00:00:00','Contratto per la consulenza Java'),(14,'2016-11-27 00:00:00','CC0_Sun Nov 27 23:39:00 CET 2016',NULL,'2016-03-06 00:00:00','Contratto per la consulenza Java'),(15,'2016-11-27 00:00:00','CC0_Sun Nov 27 23:43:19 CET 2016',NULL,'2016-03-06 00:00:00','Contratto per la consulenza Java'),(16,'2016-11-27 00:00:00','CC0_Sun Nov 27 23:45:59 CET 2016',NULL,'2016-03-06 00:00:00','Contratto per la consulenza Java'),(17,'2016-11-27 00:00:00','CC0_Sun Nov 27 23:48:07 CET 2016',NULL,'2016-03-06 00:00:00','Contratto per la consulenza Java'),(18,'2016-11-27 00:00:00','CC0_Sun Nov 27 23:51:39 CET 2016',NULL,'2016-03-06 00:00:00','Contratto per la consulenza Java'),(19,'2016-11-27 00:00:00','CC0_Sun Nov 27 23:53:33 CET 2016',NULL,'2016-03-06 00:00:00','Contratto per la consulenza Java'),(20,'2016-11-28 00:00:00','CC0_Mon Nov 28 00:02:28 CET 2016',NULL,'2016-03-07 00:00:00','Contratto per la consulenza Java'),(21,'2016-11-28 00:00:00','CC0_Mon Nov 28 00:04:41 CET 2016',NULL,'2016-03-07 00:00:00','Contratto per la consulenza Java'),(22,'2016-11-28 00:00:00','CC0_Mon Nov 28 00:10:16 CET 2016',NULL,'2016-03-07 00:00:00','Contratto per la consulenza Java');
/*!40000 ALTER TABLE `customer_contract` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ordini`
--

DROP TABLE IF EXISTS `ordini`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ordini` (
  `id_ordine` int(11) NOT NULL AUTO_INCREMENT,
  `ammontare` decimal(10,0) NOT NULL,
  `data_ordine` date NOT NULL,
  `quantita` int(11) NOT NULL,
  `version` int(11) DEFAULT NULL,
  `id_cliente` int(11) DEFAULT NULL,
  `id_prodotto` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_ordine`),
  KEY `FK_224luhb15rnatst1id7b2nwgt` (`id_prodotto`),
  CONSTRAINT `FK_224luhb15rnatst1id7b2nwgt` FOREIGN KEY (`id_prodotto`) REFERENCES `prodotti` (`id_prodotto`)
) ENGINE=InnoDB AUTO_INCREMENT=2851 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ordini`
--

LOCK TABLES `ordini` WRITE;
/*!40000 ALTER TABLE `ordini` DISABLE KEYS */;
INSERT INTO `ordini` VALUES (1,10,'2016-12-18',1,0,1,1),(2,10,'2016-12-18',1,0,1,1),(3,10,'2016-12-18',1,0,1,1),(4,10,'2016-12-18',1,0,1,1),(5,10,'2016-12-18',1,0,1,1),(6,10,'2016-12-18',1,0,1,1),(7,10,'2016-12-18',1,0,1,1),(8,10,'2016-12-18',1,0,1,1),(9,10,'2016-12-18',1,0,1,1),(10,10,'2016-12-18',1,0,1,1);
/*!40000 ALTER TABLE `ordini` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `prodotti`
--

DROP TABLE IF EXISTS `prodotti`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `prodotti` (
  `id_prodotto` int(11) NOT NULL AUTO_INCREMENT,
  `codice` varchar(45) NOT NULL,
  `descrizione` varchar(100) NOT NULL,
  `prezzo` decimal(10,0) NOT NULL,
  `version` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_prodotto`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `prodotti`
--

LOCK TABLES `prodotti` WRITE;
/*!40000 ALTER TABLE `prodotti` DISABLE KEYS */;
INSERT INTO `prodotti` VALUES (1,'PRD_001','Prodotto molto bello',1000,50);
/*!40000 ALTER TABLE `prodotti` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `prodotti_ordini`
--

DROP TABLE IF EXISTS `prodotti_ordini`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `prodotti_ordini` (
  `prodotti_id_prodotto` int(11) NOT NULL,
  `ordinis_id_ordine` int(11) NOT NULL,
  PRIMARY KEY (`prodotti_id_prodotto`,`ordinis_id_ordine`),
  UNIQUE KEY `UK_qio40xf6heeuwuwcks0s0wix0` (`ordinis_id_ordine`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `prodotti_ordini`
--

LOCK TABLES `prodotti_ordini` WRITE;
/*!40000 ALTER TABLE `prodotti_ordini` DISABLE KEYS */;
/*!40000 ALTER TABLE `prodotti_ordini` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `province`
--

DROP TABLE IF EXISTS `province`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `province` (
  `id_provincia` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `codice` varchar(45) NOT NULL,
  `nome_citta` varchar(45) NOT NULL DEFAULT '',
  `id_regione` int(10) unsigned NOT NULL DEFAULT '0',
  `department_id_regione` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_provincia`),
  KEY `fk_regione` (`id_regione`),
  CONSTRAINT `fk_regione` FOREIGN KEY (`id_regione`) REFERENCES `regioni` (`id_regione`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=126 DEFAULT CHARSET=latin1 COMMENT='Tabella contenente i nomi delle città.';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `province`
--

LOCK TABLES `province` WRITE;
/*!40000 ALTER TABLE `province` DISABLE KEYS */;
INSERT INTO `province` VALUES (2,'AQ','Aquila',22,NULL),(3,'CH','Chieti',22,NULL),(4,'PE','Pescara',22,NULL),(5,'TE','Teramo',22,NULL),(6,'MT','Matera',23,NULL),(7,'PZ','Potenza',23,NULL),(8,'CZ','Catanzaro',24,NULL),(9,'CS','Cosenza',24,NULL),(10,'KR','Crotone',24,NULL),(11,'RC','Reggio',24,NULL),(12,'VV','Vibo',24,NULL),(13,'AV','Avellino',25,NULL),(14,'BN','Benevento',25,NULL),(15,'CE','Caserta',25,NULL),(16,'NA','Napoli',25,NULL),(17,'SA','Salerno',25,NULL),(18,'BO','Bologna',26,NULL),(19,'FE','Ferrara',26,NULL),(20,'FC','Forlì-Cesena',26,NULL),(21,'MO','Modena',26,NULL),(22,'PR','Parma',26,NULL),(23,'PC','Piacenza',26,NULL),(24,'RA','Ravenna',26,NULL),(25,'RE','Reggio Emilia',26,NULL),(26,'RN','Rimini',26,NULL),(27,'GO','Gorizia',27,NULL),(28,'PN','Pordenone',27,NULL),(29,'TS','Trieste',27,NULL),(30,'UD','Udine',27,NULL),(31,'FR','Frosinone',28,NULL),(32,'LT','Latina',28,NULL),(33,'RI','Rieti',28,NULL),(34,'RM','Roma',28,NULL),(35,'VT','Viterbo',28,NULL),(36,'GE','Genova',29,NULL),(37,'IM','Imperia',29,NULL),(38,'SP','Provincia della Spezia',29,NULL),(39,'SV','Savona',29,NULL),(40,'BG','Bergamo',30,NULL),(41,'BS','Brescia',30,NULL),(42,'CO','Como',30,NULL),(43,'CR','Cremona',30,NULL),(44,'LC','Lecco',30,NULL),(45,'LO','Lodi',30,NULL),(46,'MN','Mantova',30,NULL),(47,'MI','Milano',30,NULL),(48,'MB','Monza e della Brianza',30,NULL),(49,'PV','Pavia',30,NULL),(50,'SO','Sondrio',30,NULL),(51,'VA','Varese',30,NULL),(52,'AN','Ancona',31,NULL),(53,'AP','Ascoli',31,NULL),(54,'FM','Fermo ',31,NULL),(55,'MC','Macerata',31,NULL),(56,'PU','Pesaro e Urbino',31,NULL),(57,'CB','Campobasso',32,NULL),(58,'IS','Iserni',32,NULL),(59,'AL','Alessandria',33,NULL),(60,'AT','Asti',33,NULL),(61,'BI','Biella',33,NULL),(62,'CN','Cuneo',33,NULL),(63,'NO','Novara',33,NULL),(64,'TO','Torino',33,NULL),(65,'VB','Provincia',33,NULL),(66,'VC','Vercelli',33,NULL),(67,'BA','Bari',34,NULL),(68,'BT','Barletta-Andria-Trani',34,NULL),(69,'BR','Brindisi',34,NULL),(70,'FG','Foggia',34,NULL),(71,'LE','Lecce',34,NULL),(72,'TA','Taranto',34,NULL),(73,'CA','Cagliari',35,NULL),(74,'CI','Carbonia-Iglesias',35,NULL),(75,'VS','Provincia del Medio Campidano',35,NULL),(76,'NU','Nuoro',35,NULL),(77,'OG','Provincia dell\'Ogliastra',35,NULL),(78,'OT','Olbia-Tempio',35,NULL),(79,'OR','Oristano',35,NULL),(80,'SS','Sassari',35,NULL),(81,'AG','Agrigento',36,NULL),(82,'CL','Caltanissetta',36,NULL),(83,'CT','Catania',36,NULL),(84,'EN','Enna',36,NULL),(85,'ME','Messina',36,NULL),(86,'PA','Palermo',36,NULL),(87,'RG','Ragusa',36,NULL),(88,'SR','Siracusa',36,NULL),(89,'TP','Trapani',36,NULL),(90,'AR','Arezzo',37,NULL),(91,'FI','Firenze',37,NULL),(92,'GR','Grosseto',37,NULL),(93,'LI','Livorno',37,NULL),(94,'LU','Lucca',37,NULL),(95,'MS','Massa-Carrara',37,NULL),(96,'PI','Pisa',37,NULL),(97,'PT','Pistoia',37,NULL),(98,'PO','Prato',37,NULL),(99,'SI','Siena',37,NULL),(100,'BZ','Bolzano',38,NULL),(101,'TN','Trento',38,NULL),(102,'PG','Perugia',39,NULL),(103,'TR','Terni',39,NULL),(104,'BL','Belluno',41,NULL),(105,'PD','Padova',41,NULL),(106,'RO','Rovigo',41,NULL),(107,'TV','Treviso',41,NULL),(108,'VE','Venezia',41,NULL),(109,'VR','Verona',41,NULL),(110,'VI','Vicenza',41,NULL),(124,'99','AAAAAA',75,NULL),(125,'99','AAAAAA',76,NULL);
/*!40000 ALTER TABLE `province` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `regioni`
--

DROP TABLE IF EXISTS `regioni`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `regioni` (
  `id_regione` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `codice` varchar(45) NOT NULL,
  PRIMARY KEY (`id_regione`)
) ENGINE=InnoDB AUTO_INCREMENT=77 DEFAULT CHARSET=latin1 COMMENT='Tabella contenente i nomi delle regioni';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `regioni`
--

LOCK TABLES `regioni` WRITE;
/*!40000 ALTER TABLE `regioni` DISABLE KEYS */;
INSERT INTO `regioni` VALUES (22,'Abruzzo'),(23,'Basilicata'),(24,'Calabria'),(25,'Campania'),(26,'Emilia-Romagna'),(27,'Friuli-Venezia Giulia'),(28,'Lazio'),(29,'Liguria'),(30,'Lombardia'),(31,'Marche'),(32,'Molise'),(33,'Piemonte'),(34,'Puglia'),(35,'Sardegna'),(36,'Sicilia'),(37,'Toscana'),(38,'Trentino-Alto Adige'),(39,'Umbria'),(40,'Valle D\'Aosta'),(41,'Veneto'),(75,'99'),(76,'99');
/*!40000 ALTER TABLE `regioni` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `regioni_province`
--

DROP TABLE IF EXISTS `regioni_province`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `regioni_province` (
  `regioni_id_regione` int(11) NOT NULL,
  `districts_id_provincia` int(11) NOT NULL,
  PRIMARY KEY (`regioni_id_regione`,`districts_id_provincia`),
  UNIQUE KEY `UK_8b5yei2grf48px3eoh514wg6d` (`districts_id_provincia`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `regioni_province`
--

LOCK TABLES `regioni_province` WRITE;
/*!40000 ALTER TABLE `regioni_province` DISABLE KEYS */;
/*!40000 ALTER TABLE `regioni_province` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `utenti`
--

DROP TABLE IF EXISTS `utenti`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `utenti` (
  `id_utente` bigint(10) unsigned NOT NULL,
  `username` varchar(45) NOT NULL DEFAULT '',
  `password` varchar(100) NOT NULL DEFAULT '',
  `nome` varchar(45) NOT NULL DEFAULT '',
  `cognome` varchar(45) NOT NULL DEFAULT '',
  `citta` varchar(45) DEFAULT NULL,
  `via` varchar(100) DEFAULT NULL,
  `numero` varchar(45) DEFAULT NULL,
  `nazione` varchar(45) DEFAULT NULL,
  `codice_postale` int(10) unsigned DEFAULT '0',
  `email` varchar(45) NOT NULL,
  `role` varchar(30) DEFAULT NULL,
  `version` int(11) DEFAULT '0',
  `language` varchar(5) DEFAULT NULL,
  `last_update_time` datetime DEFAULT NULL,
  `codfisc` varchar(16) DEFAULT NULL,
  `enabled` bit(1) DEFAULT NULL,
  `company` bigint(20) DEFAULT NULL,
  `id_regione` int(11) DEFAULT NULL,
  `id_provincia` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_utente`),
  UNIQUE KEY `UK_tn8mwk6h2wn28yyj7fco65gls` (`username`),
  KEY `FK_9t66s4cs5l7xgoyxl8gjhh3v9` (`company`),
  CONSTRAINT `FK_9t66s4cs5l7xgoyxl8gjhh3v9` FOREIGN KEY (`company`) REFERENCES `company` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Tabella di registrazione degli utenti.';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `utenti`
--

LOCK TABLES `utenti` WRITE;
/*!40000 ALTER TABLE `utenti` DISABLE KEYS */;
INSERT INTO `utenti` VALUES (1,'giontellar','fbed99222dd7674c86ca6386527af08e8aa41a6d5b2317720e1514c0ac11c6f5','Roberto','Pippo','Bologna','Indipendenza','11','Italia',40123,'pippo@me.com','A',49,'en',NULL,NULL,'',1,NULL,NULL),(6,'operator1','fbed99222dd7674c86ca6386527af08e8aa41a6d5b2317720e1514c0ac11c6f5','Mario','Rossi','Bologna','Indipendenza','11','Italia',40123,'pippo@me.com','A',8,'it',NULL,NULL,'',1,NULL,NULL);
/*!40000 ALTER TABLE `utenti` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-12-19  8:56:03
