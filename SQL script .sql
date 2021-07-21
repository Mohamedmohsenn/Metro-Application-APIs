-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: localhost    Database: metro_app
-- ------------------------------------------------------
-- Server version	8.0.22

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `admin` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `password` varchar(100) NOT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` VALUES (1,'sameh','sameh@gmail.com','$2a$10$o8H1HZJhateTLms7BzMdhuawcAF1w0dfefHWQ6m9qcwFAHO1dRv/2',NULL),(2,'bakr','bakr@gmail.com','$2a$10$o8H1HZJhateTLms7BzMdhuawcAF1w0dfefHWQ6m9qcwFAHO1dRv/2',NULL);
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `basic_ticket`
--

DROP TABLE IF EXISTS `basic_ticket`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `basic_ticket` (
  `id` int NOT NULL AUTO_INCREMENT,
  `price` int NOT NULL,
  `maximum_trips` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `basic_ticket`
--

LOCK TABLES `basic_ticket` WRITE;
/*!40000 ALTER TABLE `basic_ticket` DISABLE KEYS */;
INSERT INTO `basic_ticket` VALUES (1,5,9),(2,7,16),(7,10,36);
/*!40000 ALTER TABLE `basic_ticket` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `line`
--

DROP TABLE IF EXISTS `line`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `line` (
  `id` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `line`
--

LOCK TABLES `line` WRITE;
/*!40000 ALTER TABLE `line` DISABLE KEYS */;
INSERT INTO `line` VALUES (1),(2),(3);
/*!40000 ALTER TABLE `line` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `normalsubscription`
--

DROP TABLE IF EXISTS `normalsubscription`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `normalsubscription` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NOT NULL,
  `full_name` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `phone` varchar(45) NOT NULL,
  `national_id` varchar(45) NOT NULL,
  `country` varchar(45) NOT NULL,
  `city` varchar(45) NOT NULL,
  `source` varchar(45) NOT NULL,
  `target` varchar(45) NOT NULL,
  `subscription_id` int NOT NULL,
  `trips_num` int DEFAULT NULL,
  `start_date` datetime NOT NULL,
  `end_date` datetime NOT NULL,
  `period` int DEFAULT NULL,
  `in_use` tinyint NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `user_id_idx` (`user_id`),
  KEY `subscription_id` (`subscription_id`),
  CONSTRAINT `normalsubscription_ibfk_1` FOREIGN KEY (`subscription_id`) REFERENCES `subscription` (`subscription_id`),
  CONSTRAINT `user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `normalsubscription`
--

LOCK TABLES `normalsubscription` WRITE;
/*!40000 ALTER TABLE `normalsubscription` DISABLE KEYS */;
INSERT INTO `normalsubscription` VALUES (15,10,'mohamed mohsen','mohsen@gmail','1354653','3135153','Egypt','giza','moneb','opera',7,119,'2021-07-17 22:00:00','2021-10-17 22:00:00',3,0);
/*!40000 ALTER TABLE `normalsubscription` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `station`
--

DROP TABLE IF EXISTS `station`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `station` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `latitude` double NOT NULL,
  `longitude` double NOT NULL,
  `region` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=172 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `station`
--

LOCK TABLES `station` WRITE;
/*!40000 ALTER TABLE `station` DISABLE KEYS */;
INSERT INTO `station` VALUES (1,'El-Mounib',29.98109309298193,31.21233061709853,3),(2,'Sakiat Mekky',29.995890494742405,31.208660612727254,3),(3,'Omm El-Masryeen',30.005802536425108,31.20818457049328,3),(4,'Giza',30.01084170020563,31.207198385837035,3),(5,'Faisal',30.01724019639334,31.20393798901821,3),(6,'Cairo University',30.02716229311841,31.20054572631451,3),(7,'El Bohoth',30.035884500122123,31.197755956848162,3),(8,'Dokki',30.038595463899835,31.21276100853596,3),(9,'Opera',30.041948142608952,31.224990989838254,1),(10,'Sadat',30.044254166833316,31.23557105461699,1),(11,'Mohamed Naguib',30.04546088975674,31.244173026314918,1),(12,'Attaba',30.052559572058463,31.24679226864329,1),(13,'Al-Shohadaa',30.0612517058977,31.24610957114708,1),(14,'Masarra',30.070893488382577,31.245094979790103,6),(15,'Road El-Farag',30.080983459101496,31.247275726315976,6),(16,'St. Teresa',30.088024925887158,31.245484511968787,6),(17,'Khalafawy',30.097701536184275,31.245449573536334,6),(18,'Mezallat',30.10385408067541,31.245819455152372,6),(19,'Kolleyyet El-Zeraa',30.11244007895492,31.2487589242472,6),(20,'Shubra El-Kheima',30.126369460411908,31.240731281851094,6),(21,'Bab El Shaaria',30.053120471951143,31.25528303398445,4),(22,'El Geish',30.061775901720186,31.266908885483765,4),(23,'Abdou Pasha',30.064768945615942,31.274784129653227,4),(24,'Abbassia',30.072213370620275,31.28377466687735,4),(25,'Fair Zone',30.073300393447447,31.30096818795872,4),(26,'Stadium',30.073164878902908,31.317274063048057,4),(27,'Koleyet El-Banat ',30.083862280836758,31.32902327885962,4),(28,'Al-Ahram',30.09171265724782,31.32631575629407,4),(29,'Haroun',30.101378447184498,31.332967084901757,10),(30,'Heliopolis Square',30.10783171006869,31.33898553693009,10),(31,'Alf Maskan',30.118675998859498,31.339849829218057,10),(32,'Nadi El-Shams',30.118651550742324,31.33987008133739,10),(33,'El-Nozha',30.127950614439293,31.360689230325953,10),(34,'Hesham Barakat',30.13086779148849,31.373110486371704,10),(35,'Qobaa',30.134802827914225,31.384025430248332,10),(36,'El-Marg',30.157278365146386,31.336694644909585,8),(37,'Ezbet El-Nakhl',30.139872127977718,31.32407207506738,8),(38,'Ain Shams',30.131071650763033,31.31897030180762,8),(39,'El-Matareyya',30.12142054981096,31.31354985722528,8),(40,'Helmeyet El-Zaitoun',30.114212407291372,31.31404404683178,8),(41,'Hadayeq El-Zaitoun',30.105889166913514,31.31048351450316,8),(42,'Saray El-Qobba',30.097649372887698,31.304556529476805,5),(43,'Hammamat El-Qobba',30.091236217450007,31.29890986214482,5),(44,'Kobri El-Qobba',30.087197988850882,31.294105790395392,5),(45,'Manshiet El-Sadr',30.081981895032676,31.287538429091704,5),(46,'El-Demerdash',30.076778992768332,31.277269212317936,5),(47,'Ghamra',30.069027439567193,31.264615881827,5),(48,'Orabi',30.05668886922058,31.24204822420959,1),(49,'Nasser',30.05341113431184,31.238852368573973,1),(50,'Saad Zaghloul',30.036497605320168,31.24037559341199,1),(51,'Al-Sayeda Zeinab',30.02912252031076,31.23715449746652,2),(52,'El-Malek El-Saleh',30.017677591324084,31.231167048106634,2),(53,'Mar Girgis',30.00610443489707,31.229581003563432,2),(54,'El-Zahraa\'',29.995481719090524,31.231171285164883,2),(55,'Dar El-Salam',29.98206443310469,31.242177399751785,2),(56,'Hadayek El-Maadi',29.97023869709702,31.25051267856607,7),(57,'Maadi',29.959917836345756,31.25711767082125,7),(58,'Sakanat El-Maadi',29.953298759041086,31.262950115680972,7),(59,'Tora El-Balad',29.94676046546416,31.272968070785,7),(60,'Kozzika',29.93626623839101,31.281832697333478,7),(61,'Tora El-Asmant',29.925964672555377,31.287540114662633,7),(62,'El-Maasara',29.906062394638237,31.299490374943503,9),(63,'Hadayek Helwan',29.897128186365965,31.30393221200776,9),(64,'Wadi Hof',29.879082088125163,31.313591334777936,9),(65,'Helwan University',29.86945333073545,31.320069426759034,9),(66,'Ain Helwan',29.862567929493235,31.32549592063716,9),(67,'Helwan',29.848980953544377,31.33414613935252,9);
/*!40000 ALTER TABLE `station` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `station_line`
--

DROP TABLE IF EXISTS `station_line`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `station_line` (
  `station_id` int NOT NULL,
  `line_id` int NOT NULL,
  PRIMARY KEY (`station_id`,`line_id`),
  KEY `fk_line_id_idx` (`line_id`),
  CONSTRAINT `fk_line_id` FOREIGN KEY (`line_id`) REFERENCES `line` (`id`),
  CONSTRAINT `fk_station_id` FOREIGN KEY (`station_id`) REFERENCES `station` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `station_line`
--

LOCK TABLES `station_line` WRITE;
/*!40000 ALTER TABLE `station_line` DISABLE KEYS */;
INSERT INTO `station_line` VALUES (10,1),(13,1),(36,1),(37,1),(38,1),(39,1),(40,1),(41,1),(42,1),(43,1),(44,1),(45,1),(46,1),(47,1),(48,1),(49,1),(50,1),(51,1),(52,1),(53,1),(54,1),(55,1),(56,1),(57,1),(58,1),(59,1),(60,1),(61,1),(62,1),(63,1),(64,1),(65,1),(66,1),(67,1),(1,2),(2,2),(3,2),(4,2),(5,2),(6,2),(7,2),(8,2),(9,2),(10,2),(11,2),(12,2),(13,2),(14,2),(15,2),(16,2),(17,2),(18,2),(19,2),(20,2),(12,3),(21,3),(22,3),(23,3),(24,3),(25,3),(26,3),(27,3),(28,3),(29,3),(30,3),(31,3),(32,3),(33,3),(34,3),(35,3);
/*!40000 ALTER TABLE `station_line` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `station_link`
--

DROP TABLE IF EXISTS `station_link`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `station_link` (
  `station_id` int NOT NULL,
  `after_id` int NOT NULL,
  PRIMARY KEY (`station_id`,`after_id`),
  KEY `fk_station_id_1_idx` (`station_id`),
  KEY `fk_station_id_2_idx` (`after_id`),
  CONSTRAINT `fk_station_id_1` FOREIGN KEY (`station_id`) REFERENCES `station` (`id`),
  CONSTRAINT `fk_station_id_2` FOREIGN KEY (`after_id`) REFERENCES `station` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `station_link`
--

LOCK TABLES `station_link` WRITE;
/*!40000 ALTER TABLE `station_link` DISABLE KEYS */;
INSERT INTO `station_link` VALUES (1,2),(2,3),(3,4),(4,5),(5,6),(6,7),(7,8),(8,9),(9,10),(10,11),(10,50),(11,12),(12,13),(12,21),(13,14),(13,48),(14,15),(15,16),(16,17),(17,18),(18,19),(19,20),(21,22),(22,23),(23,24),(24,25),(25,26),(26,27),(27,28),(28,29),(29,30),(30,31),(31,32),(32,33),(33,34),(34,35),(36,37),(37,38),(38,39),(39,40),(40,41),(41,42),(42,43),(43,44),(44,45),(45,46),(46,47),(47,13),(48,49),(49,10),(50,51),(51,52),(52,53),(53,54),(54,55),(55,56),(56,57),(57,58),(58,59),(59,60),(60,61),(61,62),(62,63),(63,64),(64,65),(65,66),(66,67);
/*!40000 ALTER TABLE `station_link` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stripe_charge`
--

DROP TABLE IF EXISTS `stripe_charge`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `stripe_charge` (
  `id` varchar(255) NOT NULL,
  `amount` bigint DEFAULT NULL,
  `amount_captured` bigint DEFAULT NULL,
  `amount_refunded` bigint DEFAULT NULL,
  `application_fee_amount` bigint DEFAULT NULL,
  `authorization_code` varchar(255) DEFAULT NULL,
  `calculated_statement_descriptor` varchar(255) DEFAULT NULL,
  `captured` bit(1) DEFAULT NULL,
  `created` bit(1) DEFAULT NULL,
  `currency` varchar(255) DEFAULT NULL,
  `customer_id` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `disputed` bit(1) DEFAULT NULL,
  `failure_code` varchar(255) DEFAULT NULL,
  `failure_message` varchar(255) DEFAULT NULL,
  `livemode` bit(1) DEFAULT NULL,
  `object` varchar(255) DEFAULT NULL,
  `paid` bit(1) DEFAULT NULL,
  `payment_method_id` varchar(255) DEFAULT NULL,
  `receipt_number` varchar(255) DEFAULT NULL,
  `receipt_url` varchar(255) DEFAULT NULL,
  `refunded` bit(1) DEFAULT NULL,
  `statement_descriptor` varchar(255) DEFAULT NULL,
  `statement_descriptor_suffix` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stripe_charge`
--

LOCK TABLES `stripe_charge` WRITE;
/*!40000 ALTER TABLE `stripe_charge` DISABLE KEYS */;
/*!40000 ALTER TABLE `stripe_charge` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subscription`
--

DROP TABLE IF EXISTS `subscription`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `subscription` (
  `subscription_id` int NOT NULL AUTO_INCREMENT,
  `trips_num` int DEFAULT NULL,
  `region_num` int DEFAULT NULL,
  `months_num` int DEFAULT NULL,
  `price` int NOT NULL,
  PRIMARY KEY (`subscription_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subscription`
--

LOCK TABLES `subscription` WRITE;
/*!40000 ALTER TABLE `subscription` DISABLE KEYS */;
INSERT INTO `subscription` VALUES (1,120,1,1,250),(2,120,1,3,380),(3,120,1,12,480),(4,120,2,1,120),(5,120,2,3,180),(6,120,2,12,250),(7,120,3,1,300);
/*!40000 ALTER TABLE `subscription` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ticket`
--

DROP TABLE IF EXISTS `ticket`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ticket` (
  `id` int NOT NULL AUTO_INCREMENT,
  `price` int NOT NULL,
  `maximum_trips` int NOT NULL,
  `source_station` varchar(45) DEFAULT NULL,
  `user_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_userID_idx` (`user_id`),
  CONSTRAINT `fk_user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ticket`
--

LOCK TABLES `ticket` WRITE;
/*!40000 ALTER TABLE `ticket` DISABLE KEYS */;
INSERT INTO `ticket` VALUES (1,5,9,'',1);
/*!40000 ALTER TABLE `ticket` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `user_id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `fullname` varchar(255) DEFAULT NULL,
  `email` varchar(45) NOT NULL,
  `password` varchar(100) NOT NULL,
  `phone_number` varchar(45) DEFAULT NULL,
  `date_of_birth` date DEFAULT NULL,
  `balance` double DEFAULT '0',
  `role` varchar(45) NOT NULL DEFAULT 'user',
  `stripe_id` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `username_UNIQUE` (`username`),
  UNIQUE KEY `email_UNIQUE` (`email`),
  UNIQUE KEY `phone_number_UNIQUE` (`phone_number`),
  UNIQUE KEY `stripe_id_UNIQUE` (`stripe_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (9,'Ahmed','Ahmed Ibrahim','Ahmed@gmail.com','$2a$10$soOgAzKo0YPziSHQKYNFDudzS.n5oInnNgC8kb4tZLrWbWjyC3/Am','0115','1999-01-31',94,'user','cus_JqrwgqkQYJpLWq'),(10,'Mohsen','Mohamed Mohsen','Mohsen@gmail.com','$2a$10$jFpoZOhZpbBnXDOZwPC4ROJVv3DVe/MlIPE/HbhgLUeixKUce2xFK','0113','1999-02-02',20,'user','cus_JqrzkDdu1rl4Zd');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-07-21 19:57:13
