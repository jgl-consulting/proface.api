-- MySQL dump 10.13  Distrib 5.7.26, for Linux (x86_64)
--
-- Host: db4free.net    Database: proface
-- ------------------------------------------------------
-- Server version	8.0.16

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
-- Table structure for table `bank`
--

DROP TABLE IF EXISTS `bank`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bank` (
  `id` int(2) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `account_number_mask` varchar(20) DEFAULT NULL,
  `country_id` int(3) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_bank_country` (`country_id`),
  CONSTRAINT `fk_bank_country` FOREIGN KEY (`country_id`) REFERENCES `country` (`id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bank`
--

LOCK TABLES `bank` WRITE;
/*!40000 ALTER TABLE `bank` DISABLE KEYS */;
INSERT INTO `bank` VALUES (1,'Banco de Crédito del Perú','1234',161);
/*!40000 ALTER TABLE `bank` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `country`
--

DROP TABLE IF EXISTS `country`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `country` (
  `id` int(3) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `iso` char(2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=231 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `country`
--

LOCK TABLES `country` WRITE;
/*!40000 ALTER TABLE `country` DISABLE KEYS */;
INSERT INTO `country` VALUES (1,'Andorra','AD'),(2,'United Arab Emirates','AE'),(3,'Afghanistan','AF'),(4,'Antigua and Barbuda','AG'),(5,'Anguilla','AI'),(6,'Albania','AL'),(7,'Armenia','AM'),(8,'Netherlands Antilles','AN'),(9,'Angola','AO'),(10,'Argentina','AR'),(11,'Austria','AT'),(12,'Australia','AU'),(13,'Aruba','AW'),(14,'Azerbaijan','AZ'),(15,'Bosnia and Herzegovina','BA'),(16,'Barbados','BB'),(17,'Bangladesh','BD'),(18,'Belgium','BE'),(19,'Burkina Faso','BF'),(20,'Bulgaria','BG'),(21,'Bahrain','BH'),(22,'Burundi','BI'),(23,'Benin','BJ'),(24,'Bermuda','BM'),(25,'Brunei Darussalam','BN'),(26,'Bolivia','BO'),(27,'Brazil','BR'),(28,'Bahamas','BS'),(29,'Bhutan','BT'),(30,'Botswana','BW'),(31,'Belarus','BY'),(32,'Belize','BZ'),(33,'Canada','CA'),(34,'Cocos (Keeling) Islands','CC'),(35,'Democratic Republic of the Congo','CD'),(36,'Central African Republic','CF'),(37,'Congo','CG'),(38,'Switzerland','CH'),(39,'Cote D\'Ivoire (Ivory Coast)','CI'),(40,'Cook Islands','CK'),(41,'Chile','CL'),(42,'Cameroon','CM'),(43,'China','CN'),(44,'Colombia','CO'),(45,'Costa Rica','CR'),(46,'Cuba','CU'),(47,'Cape Verde','CV'),(48,'Christmas Island','CX'),(49,'Cyprus','CY'),(50,'Czech Republic','CZ'),(51,'Germany','DE'),(52,'Djibouti','DJ'),(53,'Denmark','DK'),(54,'Dominica','DM'),(55,'Dominican Republic','DO'),(56,'Algeria','DZ'),(57,'Ecuador','EC'),(58,'Estonia','EE'),(59,'Egypt','EG'),(60,'Western Sahara','EH'),(61,'Eritrea','ER'),(62,'Spain','ES'),(63,'Ethiopia','ET'),(64,'Finland','FI'),(65,'Fiji','FJ'),(66,'Falkland Islands (Malvinas)','FK'),(67,'Federated States of Micronesia','FM'),(68,'Faroe Islands','FO'),(69,'France','FR'),(70,'Gabon','GA'),(71,'Great Britain (UK)','GB'),(72,'Grenada','GD'),(73,'Georgia','GE'),(74,'French Guiana','GF'),(75,'NULL','GG'),(76,'Ghana','GH'),(77,'Gibraltar','GI'),(78,'Greenland','GL'),(79,'Gambia','GM'),(80,'Guinea','GN'),(81,'Guadeloupe','GP'),(82,'Equatorial Guinea','GQ'),(83,'Greece','GR'),(84,'S. Georgia and S. Sandwich Islands','GS'),(85,'Guatemala','GT'),(86,'Guinea-Bissau','GW'),(87,'Guyana','GY'),(88,'Hong Kong','HK'),(89,'Honduras','HN'),(90,'Croatia (Hrvatska)','HR'),(91,'Haiti','HT'),(92,'Hungary','HU'),(93,'Indonesia','ID'),(94,'Ireland','IE'),(95,'Israel','IL'),(96,'India','IN'),(97,'Iraq','IQ'),(98,'Iran','IR'),(99,'Iceland','IS'),(100,'Italy','IT'),(101,'Jamaica','JM'),(102,'Jordan','JO'),(103,'Japan','JP'),(104,'Kenya','KE'),(105,'Kyrgyzstan','KG'),(106,'Cambodia','KH'),(107,'Kiribati','KI'),(108,'Comoros','KM'),(109,'Saint Kitts and Nevis','KN'),(110,'Korea (North)','KP'),(111,'Korea (South)','KR'),(112,'Kuwait','KW'),(113,'Cayman Islands','KY'),(114,'Kazakhstan','KZ'),(115,'Laos','LA'),(116,'Lebanon','LB'),(117,'Saint Lucia','LC'),(118,'Liechtenstein','LI'),(119,'Sri Lanka','LK'),(120,'Liberia','LR'),(121,'Lesotho','LS'),(122,'Lithuania','LT'),(123,'Luxembourg','LU'),(124,'Latvia','LV'),(125,'Libya','LY'),(126,'Morocco','MA'),(127,'Monaco','MC'),(128,'Moldova','MD'),(129,'Madagascar','MG'),(130,'Marshall Islands','MH'),(131,'Macedonia','MK'),(132,'Mali','ML'),(133,'Myanmar','MM'),(134,'Mongolia','MN'),(135,'Macao','MO'),(136,'Northern Mariana Islands','MP'),(137,'Martinique','MQ'),(138,'Mauritania','MR'),(139,'Montserrat','MS'),(140,'Malta','MT'),(141,'Mauritius','MU'),(142,'Maldives','MV'),(143,'Malawi','MW'),(144,'Mexico','MX'),(145,'Malaysia','MY'),(146,'Mozambique','MZ'),(147,'Namibia','NA'),(148,'New Caledonia','NC'),(149,'Niger','NE'),(150,'Norfolk Island','NF'),(151,'Nigeria','NG'),(152,'Nicaragua','NI'),(153,'Netherlands','NL'),(154,'Norway','NO'),(155,'Nepal','NP'),(156,'Nauru','NR'),(157,'Niue','NU'),(158,'New Zealand (Aotearoa)','NZ'),(159,'Oman','OM'),(160,'Panama','PA'),(161,'Peru','PE'),(162,'French Polynesia','PF'),(163,'Papua New Guinea','PG'),(164,'Philippines','PH'),(165,'Pakistan','PK'),(166,'Poland','PL'),(167,'Saint Pierre and Miquelon','PM'),(168,'Pitcairn','PN'),(169,'Palestinian Territory','PS'),(170,'Portugal','PT'),(171,'Palau','PW'),(172,'Paraguay','PY'),(173,'Qatar','QA'),(174,'Reunion','RE'),(175,'Romania','RO'),(176,'Russian Federation','RU'),(177,'Rwanda','RW'),(178,'Saudi Arabia','SA'),(179,'Solomon Islands','SB'),(180,'Seychelles','SC'),(181,'Sudan','SD'),(182,'Sweden','SE'),(183,'Singapore','SG'),(184,'Saint Helena','SH'),(185,'Slovenia','SI'),(186,'Svalbard and Jan Mayen','SJ'),(187,'Slovakia','SK'),(188,'Sierra Leone','SL'),(189,'San Marino','SM'),(190,'Senegal','SN'),(191,'Somalia','SO'),(192,'Suriname','SR'),(193,'Sao Tome and Principe','ST'),(194,'El Salvador','SV'),(195,'Syria','SY'),(196,'Swaziland','SZ'),(197,'Turks and Caicos Islands','TC'),(198,'Chad','TD'),(199,'French Southern Territories','TF'),(200,'Togo','TG'),(201,'Thailand','TH'),(202,'Tajikistan','TJ'),(203,'Tokelau','TK'),(204,'Turkmenistan','TM'),(205,'Tunisia','TN'),(206,'Tonga','TO'),(207,'Turkey','TR'),(208,'Trinidad and Tobago','TT'),(209,'Tuvalu','TV'),(210,'Taiwan','TW'),(211,'Tanzania','TZ'),(212,'Ukraine','UA'),(213,'Uganda','UG'),(214,'Uruguay','UY'),(215,'Uzbekistan','UZ'),(216,'Saint Vincent and the Grenadines','VC'),(217,'Venezuela','VE'),(218,'Virgin Islands (British)','VG'),(219,'Virgin Islands (U.S.)','VI'),(220,'Viet Nam','VN'),(221,'Vanuatu','VU'),(222,'Wallis and Futuna','WF'),(223,'Samoa','WS'),(224,'Yemen','YE'),(225,'Mayotte','YT'),(226,'South Africa','ZA'),(227,'Zambia','ZM'),(228,'Zaire (former)','ZR'),(229,'Zimbabwe','ZW'),(230,'United States of America','US');
/*!40000 ALTER TABLE `country` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `product` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `native_id` varchar(20) NOT NULL,
  `name` varchar(255) NOT NULL,
  `description` varchar(300) DEFAULT NULL,
  `sale_price` double NOT NULL,
  `product_line_id` int(2) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `native_id_UNIQUE` (`native_id`),
  KEY `fk_product_product_line` (`product_line_id`),
  CONSTRAINT `fk_product_product_line` FOREIGN KEY (`product_line_id`) REFERENCES `product_line` (`id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (1,'1','Producto de Prueba 1','Este producto no cambiará',0,1),(2,'2','Producto de Prueba 2','',40,1);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_line`
--

DROP TABLE IF EXISTS `product_line`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `product_line` (
  `id` int(2) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_line`
--

LOCK TABLES `product_line` WRITE;
/*!40000 ALTER TABLE `product_line` DISABLE KEYS */;
INSERT INTO `product_line` VALUES (1,'Material'),(2,'Equipo');
/*!40000 ALTER TABLE `product_line` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `purchase_cost`
--

DROP TABLE IF EXISTS `purchase_cost`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `purchase_cost` (
  `id` int(7) NOT NULL AUTO_INCREMENT,
  `description` varchar(300) NOT NULL,
  `total_cost` double DEFAULT '0',
  `purchase_id` int(6) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `purchase_id` (`purchase_id`),
  CONSTRAINT `purchase_cost_ibfk_1` FOREIGN KEY (`purchase_id`) REFERENCES `purchase_order` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `purchase_cost`
--

LOCK TABLES `purchase_cost` WRITE;
/*!40000 ALTER TABLE `purchase_cost` DISABLE KEYS */;
/*!40000 ALTER TABLE `purchase_cost` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `purchase_detail`
--

DROP TABLE IF EXISTS `purchase_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `purchase_detail` (
  `purchase_id` int(6) NOT NULL,
  `product_id` int(5) NOT NULL,
  `native_id` varchar(20) DEFAULT NULL,
  `quantity` int(4) NOT NULL DEFAULT '1',
  `unit_price` double DEFAULT '0',
  `purchase_price` double DEFAULT NULL,
  `disscount` double DEFAULT '0',
  `final_price` double DEFAULT '0',
  `status_id` int(2) DEFAULT NULL,
  PRIMARY KEY (`purchase_id`,`product_id`),
  KEY `product_id` (`product_id`),
  KEY `status_id` (`status_id`),
  CONSTRAINT `purchase_detail_ibfk_2` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `purchase_detail_ibfk_3` FOREIGN KEY (`purchase_id`) REFERENCES `purchase_order` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `purchase_detail_ibfk_4` FOREIGN KEY (`status_id`) REFERENCES `reception_status` (`id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `purchase_detail`
--

LOCK TABLES `purchase_detail` WRITE;
/*!40000 ALTER TABLE `purchase_detail` DISABLE KEYS */;
/*!40000 ALTER TABLE `purchase_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `purchase_invoice`
--

DROP TABLE IF EXISTS `purchase_invoice`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `purchase_invoice` (
  `id` int(7) NOT NULL AUTO_INCREMENT,
  `native_id` varchar(20) NOT NULL,
  `description` varchar(300) DEFAULT NULL,
  `emission_date` date NOT NULL,
  `total_price` double DEFAULT '0',
  `purchase_id` int(6) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `native_id_UNIQUE` (`native_id`),
  KEY `purchase_id` (`purchase_id`),
  CONSTRAINT `purchase_invoice_ibfk_1` FOREIGN KEY (`purchase_id`) REFERENCES `purchase_order` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `purchase_invoice`
--

LOCK TABLES `purchase_invoice` WRITE;
/*!40000 ALTER TABLE `purchase_invoice` DISABLE KEYS */;
/*!40000 ALTER TABLE `purchase_invoice` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `purchase_order`
--

DROP TABLE IF EXISTS `purchase_order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `purchase_order` (
  `id` int(6) NOT NULL AUTO_INCREMENT,
  `native_id` varchar(20) NOT NULL,
  `creation_date` date NOT NULL,
  `quotation_date` date DEFAULT NULL,
  `billing_date` date DEFAULT NULL,
  `reception_date` date DEFAULT NULL,
  `status_id` int(1) NOT NULL,
  `supplier_id` int(3) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `native_id_UNIQUE` (`native_id`),
  KEY `supplier_id` (`supplier_id`),
  KEY `status_id` (`status_id`),
  CONSTRAINT `purchase_order_ibfk_1` FOREIGN KEY (`supplier_id`) REFERENCES `supplier` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `purchase_order_ibfk_2` FOREIGN KEY (`status_id`) REFERENCES `purchase_status` (`id`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `purchase_order`
--

LOCK TABLES `purchase_order` WRITE;
/*!40000 ALTER TABLE `purchase_order` DISABLE KEYS */;
/*!40000 ALTER TABLE `purchase_order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `purchase_status`
--

DROP TABLE IF EXISTS `purchase_status`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `purchase_status` (
  `id` int(1) NOT NULL AUTO_INCREMENT,
  `native_id` varchar(2) NOT NULL,
  `description` varchar(100) NOT NULL,
  `color` char(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `purchase_status`
--

LOCK TABLES `purchase_status` WRITE;
/*!40000 ALTER TABLE `purchase_status` DISABLE KEYS */;
INSERT INTO `purchase_status` VALUES (1,'E','Emitido','1'),(2,'C','Cancelado','2'),(4,'P','Presupuestado','3'),(8,'F','Facturado','4'),(9,'R','Recibido','5'),(10,'T','Terminado','6');
/*!40000 ALTER TABLE `purchase_status` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reception_status`
--

DROP TABLE IF EXISTS `reception_status`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `reception_status` (
  `id` int(2) NOT NULL,
  `native_id` varchar(2) NOT NULL,
  `description` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reception_status`
--

LOCK TABLES `reception_status` WRITE;
/*!40000 ALTER TABLE `reception_status` DISABLE KEYS */;
INSERT INTO `reception_status` VALUES (1,'C','Completo'),(2,'I','Incompleto');
/*!40000 ALTER TABLE `reception_status` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'Usuario administrador','ADMIN'),(2,'Usuario de compras','COMPRAS'),(3,'Usuario de ventas','VENTAS'),(4,'Usuario de almacen','ALMACEN');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `supplier`
--

DROP TABLE IF EXISTS `supplier`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `supplier` (
  `id` int(3) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `native_id` varchar(20) NOT NULL,
  `type_id` int(2) NOT NULL,
  `country_id` int(3) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `native_id_UNIQUE` (`native_id`),
  KEY `fk_supplier_supplier_type` (`type_id`),
  KEY `fk_supplier_country` (`country_id`),
  CONSTRAINT `fk_supplier_country` FOREIGN KEY (`country_id`) REFERENCES `country` (`id`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `fk_supplier_supplier_type` FOREIGN KEY (`type_id`) REFERENCES `supplier_type` (`id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `supplier`
--

LOCK TABLES `supplier` WRITE;
/*!40000 ALTER TABLE `supplier` DISABLE KEYS */;
INSERT INTO `supplier` VALUES (8,'Proveedor de Prueba 1','P. Sherman, St. Walaby 43, Sydney','PP01',4,12),(9,'Proveedor de Prueba 2','Av. Pacífico 180, San Miguel','PP02',5,15),(10,'Proveedor de Prueba 3','Av. Peru 123, San Martín de Porres','PP03',5,27),(15,'Proveedor de Prueba 4','Av. Peru 123, San Martín de Porres','PP04',5,27),(16,'Proveedor de Prueba 5','Av. Siempre Viva 1234, Springfield','PP05',5,213),(19,'Proveedor de Prueba 6','Av. Prueba 1234, Shelbyville','PP06',5,103),(24,'American Airlines','Av. Pasita 123','12093812903',5,230),(25,'United Airlines','asdksjsakldjsa','12093812905',4,230);
/*!40000 ALTER TABLE `supplier` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `supplier_account`
--

DROP TABLE IF EXISTS `supplier_account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `supplier_account` (
  `id` int(3) NOT NULL AUTO_INCREMENT,
  `supplier_id` int(3) NOT NULL,
  `number` varchar(20) NOT NULL,
  `cci` char(20) DEFAULT NULL,
  `description` varchar(45) DEFAULT NULL,
  `currency` char(3) DEFAULT NULL,
  `bank_id` int(2) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `number_UNIQUE` (`number`),
  UNIQUE KEY `cci_UNIQUE` (`cci`),
  KEY `fk_supplier_account_supplier_idx` (`supplier_id`),
  KEY `fk_supplier_account_bank` (`bank_id`),
  CONSTRAINT `fk_supplier_account_bank` FOREIGN KEY (`bank_id`) REFERENCES `bank` (`id`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `fk_supplier_account_supplier` FOREIGN KEY (`supplier_id`) REFERENCES `supplier` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `supplier_account`
--

LOCK TABLES `supplier_account` WRITE;
/*!40000 ALTER TABLE `supplier_account` DISABLE KEYS */;
INSERT INTO `supplier_account` VALUES (2,15,'12345671','12345678910',NULL,'$',1),(3,16,'12345672','12345678911',NULL,'$',1),(4,19,'12345673','12345678912',NULL,'$',1);
/*!40000 ALTER TABLE `supplier_account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `supplier_contact`
--

DROP TABLE IF EXISTS `supplier_contact`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `supplier_contact` (
  `id` int(4) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(100) NOT NULL,
  `last_name` varchar(100) DEFAULT NULL,
  `phone` varchar(12) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `supplier_id` int(3) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_contact_supplier` (`supplier_id`),
  CONSTRAINT `fk_contact_supplier` FOREIGN KEY (`supplier_id`) REFERENCES `supplier` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `supplier_contact`
--

LOCK TABLES `supplier_contact` WRITE;
/*!40000 ALTER TABLE `supplier_contact` DISABLE KEYS */;
INSERT INTO `supplier_contact` VALUES (2,'Joe','Doe','944971879','joe.doe@supplier1.com',8),(3,'Luis','Chavez','912732812','lrchavez24@prueba.com',15),(4,'Homero','Simpson','912732812','homer@prueba.com',16),(5,'Lisa','Simpson','912732812','lisa@prueba.com',19),(10,'Luis','Pozos','989283432','lpozos@aa.com',24),(11,'Luis','Perez','989283432','lperez@united.com',25);
/*!40000 ALTER TABLE `supplier_contact` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `supplier_type`
--

DROP TABLE IF EXISTS `supplier_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `supplier_type` (
  `id` int(2) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `supplier_type`
--

LOCK TABLES `supplier_type` WRITE;
/*!40000 ALTER TABLE `supplier_type` DISABLE KEYS */;
INSERT INTO `supplier_type` VALUES (4,'Nacional'),(5,'Internacional');
/*!40000 ALTER TABLE `supplier_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(255) NOT NULL,
  `last_name` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'Luis','Chavez','$2a$10$NaKbXN3dJtDw9xsCtcOC2.Cy2XhfRRaVeXh8VvD5Zj1oEPfiwqYDC','luis.chavez','luchor13@gmail.com'),(2,'Jose','Bustamante','$2a$10$T7JgrX2dpqENPtOW5r3iweQJdx93.SQ6zvX5XuB2EnmGqAJMG2Z7.','jose.bustamante','jose.bustamante9@unmsm.edu.pe'),(3,'Yudely','Palpan','$2a$10$9Xe8nkSUnjOgO.7HnkeUI.sfAr0lXdCtFlYVPSe.CzEpZS.Ecv7vG','yudely.palpan','yudely.palpan@unmsm.edu.pe');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_role`
--

DROP TABLE IF EXISTS `user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_role` (
  `user_id` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`),
  KEY `fk_user_role_role` (`role_id`),
  CONSTRAINT `fk_user_role_role` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`),
  CONSTRAINT `fk_user_role_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_role`
--

LOCK TABLES `user_role` WRITE;
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
INSERT INTO `user_role` VALUES (1,1),(2,1),(3,1);
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'proface'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-05-12  1:44:53
