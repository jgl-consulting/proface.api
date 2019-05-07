-- MySQL dump 10.13  Distrib 8.0.11, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: proface
-- ------------------------------------------------------
-- Server version	8.0.11

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
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
 SET character_set_client = utf8mb4 ;
CREATE TABLE `bank` (
  `id` int(2) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `account_number_mask` varchar(20) DEFAULT NULL,
  `country_id` int(3) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_bank_country` (`country_id`),
  CONSTRAINT `fk_bank_country` FOREIGN KEY (`country_id`) REFERENCES `country` (`id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
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
 SET character_set_client = utf8mb4 ;
CREATE TABLE `country` (
  `id` int(3) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `iso` char(2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=231 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
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
 SET character_set_client = utf8mb4 ;
CREATE TABLE `product` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `native_id` varchar(20) NOT NULL,
  `name` varchar(255) NOT NULL,
  `description` varchar(300) DEFAULT NULL,
  `sale_price` double DEFAULT NULL,
  `product_line_id` int(2) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_product_product_line` (`product_line_id`),
  CONSTRAINT `fk_product_product_line` FOREIGN KEY (`product_line_id`) REFERENCES `product_line` (`id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (1,'1','Producto de Prueba 1','',0,NULL);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_line`
--

DROP TABLE IF EXISTS `product_line`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `product_line` (
  `id` int(2) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
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
 SET character_set_client = utf8mb4 ;
CREATE TABLE `purchase_cost` (
  `id` int(7) NOT NULL AUTO_INCREMENT,
  `description` varchar(300) NOT NULL,
  `total_cost` double DEFAULT '0',
  `purchase_id` int(6) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `purchase_id` (`purchase_id`),
  CONSTRAINT `purchase_cost_ibfk_1` FOREIGN KEY (`purchase_id`) REFERENCES `purchase_order` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
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
 SET character_set_client = utf8mb4 ;
CREATE TABLE `purchase_detail` (
  `purchase_id` int(6) NOT NULL,
  `product_id` int(5) NOT NULL,
  `native_id` varchar(20) DEFAULT NULL,
  `quantity` int(4) NOT NULL DEFAULT '1',
  `unit_price` double DEFAULT '0',
  `purchase_price` double DEFAULT NULL,
  `disscount` double DEFAULT '0',
  `final_price` double DEFAULT '0',
  PRIMARY KEY (`purchase_id`,`product_id`),
  KEY `product_id` (`product_id`),
  CONSTRAINT `purchase_detail_ibfk_2` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `purchase_detail_ibfk_3` FOREIGN KEY (`purchase_id`) REFERENCES `purchase_order` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
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
 SET character_set_client = utf8mb4 ;
CREATE TABLE `purchase_invoice` (
  `id` int(7) NOT NULL AUTO_INCREMENT,
  `native_id` varchar(20) NOT NULL,
  `description` varchar(300) DEFAULT NULL,
  `emission_date` date NOT NULL,
  `total_price` double DEFAULT '0',
  `purchase_id` int(6) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `purchase_id` (`purchase_id`),
  CONSTRAINT `purchase_invoice_ibfk_1` FOREIGN KEY (`purchase_id`) REFERENCES `purchase_order` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
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
 SET character_set_client = utf8mb4 ;
CREATE TABLE `purchase_order` (
  `id` int(6) NOT NULL AUTO_INCREMENT,
  `native_id` varchar(20) NOT NULL,
  `creation_date` date NOT NULL,
  `quotation_date` date DEFAULT NULL,
  `reception_date` date DEFAULT NULL,
  `status_id` int(1) NOT NULL,
  `supplier_id` int(3) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `supplier_id` (`supplier_id`),
  KEY `status_id` (`status_id`),
  CONSTRAINT `purchase_order_ibfk_1` FOREIGN KEY (`supplier_id`) REFERENCES `supplier` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `purchase_order_ibfk_2` FOREIGN KEY (`status_id`) REFERENCES `purchase_status` (`id`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
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
 SET character_set_client = utf8mb4 ;
CREATE TABLE `purchase_status` (
  `id` int(1) NOT NULL AUTO_INCREMENT,
  `native_id` varchar(2) NOT NULL,
  `description` varchar(100) NOT NULL,
  `color` char(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `purchase_status`
--

LOCK TABLES `purchase_status` WRITE;
/*!40000 ALTER TABLE `purchase_status` DISABLE KEYS */;
/*!40000 ALTER TABLE `purchase_status` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `region`
--

DROP TABLE IF EXISTS `region`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `region` (
  `id` int(4) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `code` varchar(10) DEFAULT NULL,
  `country_id` int(3) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_region_country` (`country_id`),
  CONSTRAINT `fk_region_country` FOREIGN KEY (`country_id`) REFERENCES `country` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3889 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `region`
--

LOCK TABLES `region` WRITE;
/*!40000 ALTER TABLE `region` DISABLE KEYS */;
INSERT INTO `region` VALUES (3541,'Mykolayivs\'ka Oblast\'','16',212),(3542,'Ternopil\'s\'ka Oblast\'','22',212),(3543,'Zhytomyrs\'ka Oblast\'','27',212),(3544,'Chernivets\'ka Oblast\'','03',212),(3545,'Luhans\'ka Oblast\'','14',212),(3546,'Sevastopol\'','20',212),(3547,'Kirovohrads\'ka Oblast\'','10',212),(3548,'Ivano-Frankivs\'ka Oblast\'','06',212),(3549,'Zaporiz\'ka Oblast\'','26',212),(3550,'Volyns\'ka Oblast\'','24',212),(3551,'','00',212),(3552,'Nebbi','58',213),(3553,'Katakwi','69',213),(3554,'Lira','47',213),(3555,'Apac','26',213),(3556,'Kaberamaido','80',213),(3557,'Arua','77',213),(3558,'Soroti','95',213),(3559,'Tororo','76',213),(3560,'Gulu','30',213),(3561,'Pallisa','60',213),(3562,'Pader','92',213),(3563,'Kumi','46',213),(3564,'Adjumani','65',213),(3565,'Kotido','45',213),(3566,'Kitgum','84',213),(3567,'Masindi','50',213),(3568,'Mbarara','52',213),(3569,'','34',213),(3570,'Bundibugyo','28',213),(3571,'Nakapiripirit','91',213),(3572,'Moroto','88',213),(3573,'Moyo','72',213),(3574,'Mbale','87',213),(3575,'Yumbe','97',213),(3576,'Kapchorwa','39',213),(3577,'Nakasongola','73',213),(3578,'Mubende','56',213),(3579,'Kisoro','43',213),(3580,'Iganga','78',213),(3581,'Kayunga','83',213),(3582,'Mukono','90',213),(3583,'Mpigi','89',213),(3584,'Kamuli','38',213),(3585,'Luwero','70',213),(3586,'Masaka','71',213),(3587,'Rakai','61',213),(3588,'Kalangala','36',213),(3589,'Kibale','41',213),(3590,'Bugiri','66',213),(3591,'Wakiso','96',213),(3592,'Kiboga','42',213),(3593,'Kampala','37',213),(3594,'Mayuge','86',213),(3595,'Kyenjojo','85',213),(3596,'Rukungiri','93',213),(3597,'Bushenyi','29',213),(3598,'Hoima','31',213),(3599,'Kamwenge','81',213),(3600,'Kabarole','79',213),(3601,'Sironko','94',213),(3602,'Kasese','40',213),(3603,'Sembabule','74',213),(3604,'','62',213),(3605,'Jinja','33',213),(3606,'Busia','67',213),(3607,'Ntungamo','59',213),(3608,'Kanungu','82',213),(3609,'','35',213),(3610,'Alabama','AL',230),(3611,'Alaska','AK',230),(3612,'American Samoa','AS',230),(3613,'Arizona','AZ',230),(3614,'Arkansas','AR',230),(3615,'California','CA',230),(3616,'Colorado','CO',230),(3617,'Connecticut','CT',230),(3618,'Delaware','DE',230),(3619,'District of Columbia','DC',230),(3620,'Florida','FL',230),(3621,'Georgia','GA',230),(3622,'Guam','GU',230),(3623,'Hawaii','HI',230),(3624,'Idaho','ID',230),(3625,'Illinois','IL',230),(3626,'Indiana','IN',230),(3627,'Iowa','IA',230),(3628,'Kansas','KS',230),(3629,'Kentucky','KY',230),(3630,'Louisiana','LA',230),(3631,'Maine','ME',230),(3632,'Marshall Islands','MH',230),(3633,'Maryland','MD',230),(3634,'Massachusetts','MA',230),(3635,'Michigan','MI',230),(3636,'Federated States of Micronesia','FM',230),(3637,'Minnesota','MN',230),(3638,'Mississippi','MS',230),(3639,'Missouri','MO',230),(3640,'Montana','MT',230),(3641,'Nebraska','NE',230),(3642,'Nevada','NV',230),(3643,'New Hampshire','NH',230),(3644,'New Jersey','NJ',230),(3645,'New Mexico','NM',230),(3646,'New York','NY',230),(3647,'North Carolina','NC',230),(3648,'North Dakota','ND',230),(3649,'Northern Mariana Islands','MP',230),(3650,'Ohio','OH',230),(3651,'Oklahoma','OK',230),(3652,'Oregon','OR',230),(3653,'Palau','PW',230),(3654,'Pennsylvania','PA',230),(3655,'Puerto Rico','PR',230),(3656,'Rhode Island','RI',230),(3657,'South Carolina','SC',230),(3658,'South Dakota','SD',230),(3659,'Tennessee','TN',230),(3660,'Texas','TX',230),(3661,'Utah','UT',230),(3662,'Vermont','VT',230),(3663,'Virgin Islands','VI',230),(3664,'Virginia','VA',230),(3665,'Washington','WA',230),(3666,'West Virginia','WV',230),(3667,'Wisconsin','WI',230),(3668,'Wyoming','WY',230),(3669,'Rocha','14',214),(3670,'Florida','07',214),(3671,'Montevideo','10',214),(3672,'Rivera','13',214),(3673,'Cerro Largo','03',214),(3674,'Tacuarembo','18',214),(3675,'Lavalleja','08',214),(3676,'Treinta y Tres','19',214),(3677,'Soriano','17',214),(3678,'Durazno','05',214),(3679,'Canelones','02',214),(3680,'Flores','06',214),(3681,'Maldonado','09',214),(3682,'Salto','15',214),(3683,'Rio Negro','12',214),(3684,'Artigas','01',214),(3685,'Paysandu','11',214),(3686,'Colonia','04',214),(3687,'San Jose','16',214),(3688,'Khorazm','05',215),(3689,'Qashqadaryo','08',215),(3690,'Samarqand','10',215),(3691,'Andijon','01',215),(3692,'Jizzax','15',215),(3693,'Toshkent','14',215),(3694,'Surkhondaryo','12',215),(3695,'Qoraqalpoghiston','09',215),(3696,'Nawoiy','07',215),(3697,'','16',215),(3698,'Namangan','06',215),(3699,'Farghona','03',215),(3700,'Bukhoro','02',215),(3701,'Toshkent','13',215),(3702,'','00',215),(3703,'Charlotte','01',216),(3704,'Saint George','04',216),(3705,'Grenadines','06',216),(3706,'Saint Patrick','05',216),(3707,'Saint Andrew','02',216),(3708,'Saint David','03',216),(3709,'Falcon','11',217),(3710,'Apure','03',217),(3711,'Bolivar','06',217),(3712,'Tachira','20',217),(3713,'Miranda','15',217),(3714,'Guarico','12',217),(3715,'Anzoategui','02',217),(3716,'Nueva Esparta','17',217),(3717,'Portuguesa','18',217),(3718,'Sucre','19',217),(3719,'Barinas','05',217),(3720,'Lara','13',217),(3721,'Zulia','23',217),(3722,'Merida','14',217),(3723,'Carabobo','07',217),(3724,'Cojedes','08',217),(3725,'Aragua','04',217),(3726,'Yaracuy','22',217),(3727,'Amazonas','01',217),(3728,'Monagas','16',217),(3729,'Trujillo','21',217),(3730,'Vargas','26',217),(3731,'','99',217),(3732,'Delta Amacuro','09',217),(3733,'Distrito Federal','25',217),(3734,'Dependencias Federales','24',217),(3735,'','00',218),(3736,'','00',219),(3737,'','36',220),(3738,'','29',220),(3739,'','04',220),(3740,'','22',220),(3741,'','07',220),(3742,'Thanh Hoa','34',220),(3743,'','11',220),(3744,'','15',220),(3745,'Quang Nam','84',220),(3746,'Son La','32',220),(3747,'','06',220),(3748,'','19',220),(3749,'','38',220),(3750,'','26',220),(3751,'Tay Ninh','33',220),(3752,'','27',220),(3753,'Thai Binh','35',220),(3754,'Kien Giang','21',220),(3755,'Dong Thap','09',220),(3756,'','10',220),(3757,'','31',220),(3758,'','41',220),(3759,'','28',220),(3760,'','12',220),(3761,'Soc Trang','65',220),(3762,'','16',220),(3763,'','14',220),(3764,'Ben Tre','03',220),(3765,'Ho Chi Minh','20',220),(3766,'Tra Vinh','67',220),(3767,'Hai Phong','13',220),(3768,'Cao Bang','05',220),(3769,'An Giang','01',220),(3770,'','02',220),(3771,'','40',220),(3772,'Nghe An','58',220),(3773,'Gia Lai','49',220),(3774,'Lam Dong','23',220),(3775,'Binh Dinh','46',220),(3776,'Binh Phuoc','76',220),(3777,'Lang Son','39',220),(3778,'Tien Giang','37',220),(3779,'Long An','24',220),(3780,'Ninh Thuan','60',220),(3781,'Quang Ninh','30',220),(3782,'Bac Lieu','73',220),(3783,'Ca Mau','77',220),(3784,'','25',220),(3785,'','48',220),(3786,'Binh Duong','75',220),(3787,'Binh Thuan','47',220),(3788,'Vinh Long','69',220),(3789,'Dong Nai','43',220),(3790,'','17',220),(3791,'Bac Kan','72',220),(3792,'Bac Giang','71',220),(3793,'Thua Thien-Hue','66',220),(3794,'Bac Ninh','74',220),(3795,'Ha Giang','50',220),(3796,'Tuyen Quang','68',220),(3797,'Thai Nguyen','85',220),(3798,'Da Nang','78',220),(3799,'Khanh Hoa','54',220),(3800,'Ba Ria-Vung Tau','45',220),(3801,'Quang Ngai','63',220),(3802,'','56',220),(3803,'Ha Nam','80',220),(3804,'Phu Yen','61',220),(3805,'Quang Binh','62',220),(3806,'Phu Tho','83',220),(3807,'Quang Tri','64',220),(3808,'Ha Tinh','52',220),(3809,'Kon Tum','55',220),(3810,'','51',220),(3811,'Yen Bai','70',220),(3812,'Ninh Binh','59',220),(3813,'Nam Dinh','82',220),(3814,'Hai Duong','79',220),(3815,'Ha Noi','44',220),(3816,'Hoa Binh','53',220),(3817,'Hung Yen','81',220),(3818,'Vinh Phuc','86',220),(3819,'Sanma','13',221),(3820,'Aoba','06',221),(3821,'Shepherd','14',221),(3822,'Malakula','10',221),(3823,'Pentecote','12',221),(3824,'Torba','07',221),(3825,'Efate','08',221),(3826,'Tafea','15',221),(3827,'Ambrym','05',221),(3828,'Epi','09',221),(3829,'Paama','11',221),(3830,'','00',222),(3831,'','00',223),(3832,'Lahij','06',224),(3833,'Sa\'dah','15',224),(3834,'Al Hudaydah','08',224),(3835,'Ma\'rib','14',224),(3836,'Al Bayda\'','07',224),(3837,'Dhamar','11',224),(3838,'San\'a\'','16',224),(3839,'Al Mahrah','03',224),(3840,'Hadramawt','04',224),(3841,'Taizz','17',224),(3842,'Hajjah','12',224),(3843,'Abyan','01',224),(3844,'Ibb','13',224),(3845,'Adan','02',224),(3846,'Al Mahwit','10',224),(3847,'Al Jawf','09',224),(3848,'','00',224),(3849,'','00',225),(3850,'Western Cape','11',226),(3851,'Eastern Cape','05',226),(3852,'Mpumalanga','07',226),(3853,'Free State','03',226),(3854,'North-West','10',226),(3855,'Limpopo','09',226),(3856,'KwaZulu-Natal','02',226),(3857,'North-Western Province','01',226),(3858,'Gauteng','06',226),(3859,'Northern Cape','08',226),(3860,'','04',226),(3861,'Southern','07',227),(3862,'North-Western','06',227),(3863,'Northern','05',227),(3864,'Western','01',227),(3865,'Eastern','03',227),(3866,'Copperbelt','08',227),(3867,'Luapula','04',227),(3868,'Central','02',227),(3869,'Lusaka','09',227),(3870,'','02',228),(3871,'','09',228),(3872,'','00',228),(3873,'','11',228),(3874,'','07',228),(3875,'','10',228),(3876,'','01',228),(3877,'','03',228),(3878,'','05',228),(3879,'','12',228),(3880,'','08',228),(3881,'','04',228),(3882,'','06',228),(3883,'Matabeleland North','06',229),(3884,'Mashonaland East','04',229),(3885,'Mashonaland Central','03',229),(3886,'Matabeleland South','07',229),(3887,'','00',229),(3888,'Masvingo','08',229);
/*!40000 ALTER TABLE `region` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
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
 SET character_set_client = utf8mb4 ;
CREATE TABLE `supplier` (
  `id` int(3) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `native_id` varchar(20) NOT NULL,
  `type_id` int(2) NOT NULL,
  `country_id` int(3) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_supplier_supplier_type` (`type_id`),
  KEY `fk_supplier_country` (`country_id`),
  CONSTRAINT `fk_supplier_country` FOREIGN KEY (`country_id`) REFERENCES `country` (`id`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `fk_supplier_supplier_type` FOREIGN KEY (`type_id`) REFERENCES `supplier_type` (`id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `supplier`
--

LOCK TABLES `supplier` WRITE;
/*!40000 ALTER TABLE `supplier` DISABLE KEYS */;
INSERT INTO `supplier` VALUES (8,'Proveedor de Prueba 1','P. Sherman, St. Walaby 43, Sydney','PP01',4,12),(9,'Proveedor de Prueba 2','Av. Pacífico 180, San Miguel','PP02',5,15),(10,'Proveedor de Prueba 3','Av. Peru 123, San Martín de Porres','PP03',5,27),(15,'Proveedor de Prueba 4','Av. Peru 123, San Martín de Porres','PP04',5,27),(16,'Proveedor de Prueba 5','Av. Siempre Viva 1234, Springfield','PP05',5,213),(19,'Proveedor de Prueba 6','Av. Prueba 1234, Shelbyville','PP06',5,103);
/*!40000 ALTER TABLE `supplier` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `supplier_account`
--

DROP TABLE IF EXISTS `supplier_account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `supplier_account` (
  `id` int(3) NOT NULL AUTO_INCREMENT,
  `supplier_id` int(3) NOT NULL,
  `number` varchar(20) NOT NULL,
  `cci` char(20) DEFAULT NULL,
  `description` varchar(45) DEFAULT NULL,
  `currency` char(3) DEFAULT NULL,
  `bank_id` int(2) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_supplier_account_supplier_idx` (`supplier_id`),
  KEY `fk_supplier_account_bank` (`bank_id`),
  CONSTRAINT `fk_supplier_account_bank` FOREIGN KEY (`bank_id`) REFERENCES `bank` (`id`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `fk_supplier_account_supplier` FOREIGN KEY (`supplier_id`) REFERENCES `supplier` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `supplier_account`
--

LOCK TABLES `supplier_account` WRITE;
/*!40000 ALTER TABLE `supplier_account` DISABLE KEYS */;
INSERT INTO `supplier_account` VALUES (2,15,'12345678','12345678910',NULL,NULL,1),(3,16,'12345678','12345678910',NULL,NULL,1),(4,19,'12345678','12345678910',NULL,NULL,1);
/*!40000 ALTER TABLE `supplier_account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `supplier_contact`
--

DROP TABLE IF EXISTS `supplier_contact`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `supplier_contact` (
  `id` int(4) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(100) NOT NULL,
  `last_name` varchar(100) DEFAULT NULL,
  `phone` char(12) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `supplier_id` int(3) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_contact_supplier` (`supplier_id`),
  CONSTRAINT `fk_contact_supplier` FOREIGN KEY (`supplier_id`) REFERENCES `supplier` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `supplier_contact`
--

LOCK TABLES `supplier_contact` WRITE;
/*!40000 ALTER TABLE `supplier_contact` DISABLE KEYS */;
INSERT INTO `supplier_contact` VALUES (2,'Joe','Doe','944971879','joe.doe@supplier1.com',8),(3,'Luis','Chavez','912732812','lrchavez24@prueba.com',15),(4,'Homero','Simpson','912732812','homer@prueba.com',16),(5,'Lisa','Simpson','912732812','lisa@prueba.com',19);
/*!40000 ALTER TABLE `supplier_contact` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `supplier_type`
--

DROP TABLE IF EXISTS `supplier_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `supplier_type` (
  `id` int(2) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
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
 SET character_set_client = utf8mb4 ;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(255) NOT NULL,
  `last_name` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
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
 SET character_set_client = utf8mb4 ;
CREATE TABLE `user_role` (
  `user_id` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`),
  KEY `fk_user_role_role` (`role_id`),
  CONSTRAINT `fk_user_role_role` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`),
  CONSTRAINT `fk_user_role_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_role`
--

LOCK TABLES `user_role` WRITE;
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
INSERT INTO `user_role` VALUES (1,1),(2,1),(3,1);
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-05-07  8:16:38
