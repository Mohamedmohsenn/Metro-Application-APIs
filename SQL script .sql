CREATE DATABASE  IF NOT EXISTS `metro_app` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `metro_app`;
-- MySQL dump 10.13  Distrib 8.0.25, for Win64 (x86_64)
--
-- Host: azure-metro-app.mysql.database.azure.com    Database: metro_app
-- ------------------------------------------------------
-- Server version	5.6.47.0

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
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `password` varchar(100) NOT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
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
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `price` int(11) NOT NULL,
  `maximum_trips` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `basic_ticket`
--

LOCK TABLES `basic_ticket` WRITE;
/*!40000 ALTER TABLE `basic_ticket` DISABLE KEYS */;
INSERT INTO `basic_ticket` VALUES (2,7,13),(3,10,36),(9,5,9);
/*!40000 ALTER TABLE `basic_ticket` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `line`
--

DROP TABLE IF EXISTS `line`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `line` (
  `id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
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
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `full_name` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `phone` varchar(45) NOT NULL,
  `national_id` varchar(45) NOT NULL,
  `country` varchar(45) NOT NULL,
  `city` varchar(45) NOT NULL,
  `source` varchar(45) NOT NULL,
  `target` varchar(45) NOT NULL,
  `subscription_id` int(11) NOT NULL,
  `trips_num` int(11) DEFAULT NULL,
  `start_date` datetime NOT NULL,
  `end_date` datetime NOT NULL,
  `period` int(11) DEFAULT NULL,
  `in_use` tinyint(4) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `user_id_idx` (`user_id`),
  KEY `subscription_id` (`subscription_id`),
  CONSTRAINT `normalsubscription_ibfk_1` FOREIGN KEY (`subscription_id`) REFERENCES `subscription` (`subscription_id`),
  CONSTRAINT `user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `normalsubscription`
--

LOCK TABLES `normalsubscription` WRITE;
/*!40000 ALTER TABLE `normalsubscription` DISABLE KEYS */;
INSERT INTO `normalsubscription` VALUES (15,10,'mohamed mohsen','mohsen@gmail','1354653','3135153','Egypt','giza','Helwan','Maadi',4,60,'2021-07-22 00:00:00','2021-08-22 00:00:00',1,0),(16,18,'Walter','Walter@gmail.com','01135546846','251648489489','Egypt','Giza','Al-Ahram','Helwan',16,175,'2021-07-25 00:00:00','2021-10-25 00:00:00',3,0),(17,19,'Ahmed','Ahmed@gmail.com','012367485859','2099908990','Egypt','giza','Abbassia','Al-Shohadaa',4,59,'2021-07-26 00:00:00','2021-08-26 00:00:00',1,0),(18,22,'Ahmed Ibrahim','ahibrahim.ai7@gmail.com','011565676666','56678658t','Egypy','Giza','Sakiat Mekky','Dokki',1,60,'2021-07-26 00:00:00','2021-08-26 00:00:00',1,0),(19,22,'Ahmed Ibrahim','ahibrahim.ai7@gmail.com','011565676666','56678658t','Egypy','Giza','Sakiat Mekky','Dokki',1,60,'2021-07-26 00:00:00','2021-08-26 00:00:00',1,0);
/*!40000 ALTER TABLE `normalsubscription` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `station`
--

DROP TABLE IF EXISTS `station`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `station` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `latitude` double NOT NULL,
  `longitude` double NOT NULL,
  `region` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=69 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `station`
--

LOCK TABLES `station` WRITE;
/*!40000 ALTER TABLE `station` DISABLE KEYS */;
INSERT INTO `station` VALUES (1,'El-Mounib',29.981093,31.212331,3),(2,'Sakiat Mekky',29.99589,31.208661,3),(3,'Omm El-Masryeen',30.005803,31.208185,3),(4,'Giza',30.010842,31.207198,3),(5,'Faisal',30.01724,31.203938,3),(6,'Cairo University',30.027162,31.200546,3),(7,'El Bohoth',30.035885,31.197756,3),(8,'Dokki',30.038595,31.212761,3),(9,'Opera',30.041948,31.224991,1),(10,'Sadat',30.044254,31.235571,1),(11,'Mohamed Naguib',30.045461,31.244173,1),(12,'Attaba',30.05256,31.246792,1),(13,'Al-Shohadaa',30.061252,31.24611,1),(14,'Masarra',30.070893,31.245095,6),(15,'Road El-Farag',30.080983,31.247276,6),(16,'St. Teresa',30.088025,31.245485,6),(17,'Khalafawy',30.097702,31.24545,6),(18,'Mezallat',30.103854,31.245819,6),(19,'Kolleyyet El-Zeraa',30.11244,31.248759,6),(20,'Shubra El-Kheima',30.126369,31.240731,6),(21,'Bab El Shaaria',30.05312,31.255283,4),(22,'El Geish',30.061776,31.266909,4),(23,'Abdou Pasha',30.064769,31.274784,4),(24,'Abbassia',30.072213,31.283775,4),(25,'Fair Zone',30.0733,31.300968,4),(26,'Stadium',30.073165,31.317274,4),(27,'Koleyet El-Banat ',30.083862,31.329023,4),(28,'Al-Ahram',30.091713,31.326316,4),(29,'Haroun',30.101378,31.332967,10),(30,'Heliopolis Square',30.107832,31.338986,10),(31,'Alf Maskan',30.118676,31.33985,10),(32,'Nadi El-Shams',30.118652,31.33987,10),(33,'El-Nozha',30.127951,31.360689,10),(34,'Hesham Barakat',30.130868,31.37311,10),(35,'Qobaa',30.134803,31.384025,10),(36,'El-Marg',30.157278,31.336695,8),(37,'Ezbet El-Nakhl',30.139872,31.324072,8),(38,'Ain Shams',30.131072,31.31897,8),(39,'El-Matareyya',30.121421,31.31355,8),(40,'Helmeyet El-Zaitoun',30.114212,31.314044,8),(41,'Hadayeq El-Zaitoun',30.105889,31.310484,8),(42,'Saray El-Qobba',30.097649,31.304557,5),(43,'Hammamat El-Qobba',30.091236,31.29891,5),(44,'Kobri El-Qobba',30.087198,31.294106,5),(45,'Manshiet El-Sadr',30.081982,31.287538,5),(46,'El-Demerdash',30.076779,31.277269,5),(47,'Ghamra',30.069027,31.264616,5),(48,'Orabi',30.056689,31.242048,1),(49,'Nasser',30.053411,31.238852,1),(50,'Saad Zaghloul',30.036498,31.240376,1),(51,'Al-Sayeda Zeinab',30.029123,31.237154,2),(52,'El-Malek El-Saleh',30.017678,31.231167,2),(53,'Mar Girgis',30.006104,31.229581,2),(54,'El-Zahraa\'',29.995482,31.231171,2),(55,'Dar El-Salam',29.982064,31.242177,2),(56,'Hadayek El-Maadi',29.970239,31.250513,7),(57,'Maadi',29.959918,31.257118,7),(58,'Sakanat El-Maadi',29.953299,31.26295,7),(59,'Tora El-Balad',29.94676,31.272968,7),(60,'Kozzika',29.936266,31.281833,7),(61,'Tora El-Asmant',29.925965,31.28754,7),(62,'El-Maasara',29.906062,31.29949,9),(63,'Hadayek Helwan',29.897128,31.303932,9),(64,'Wadi Hof',29.879082,31.313591,9),(65,'Helwan University',29.869453,31.320069,9),(66,'Ain Helwan',29.862568,31.325496,9),(67,'Helwan',29.848981,31.334146,9);
/*!40000 ALTER TABLE `station` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `station_line`
--

DROP TABLE IF EXISTS `station_line`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `station_line` (
  `station_id` int(11) NOT NULL,
  `line_id` int(11) NOT NULL,
  PRIMARY KEY (`station_id`,`line_id`),
  KEY `fk_line_id_idx` (`line_id`),
  CONSTRAINT `fk_line_id` FOREIGN KEY (`line_id`) REFERENCES `line` (`id`),
  CONSTRAINT `fk_station_id` FOREIGN KEY (`station_id`) REFERENCES `station` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
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
  `station_id` int(11) NOT NULL,
  `after_id` int(11) NOT NULL,
  PRIMARY KEY (`station_id`,`after_id`),
  KEY `fk_station_id_1_idx` (`station_id`),
  KEY `fk_station_id_2_idx` (`after_id`),
  CONSTRAINT `fk_station_id_1` FOREIGN KEY (`station_id`) REFERENCES `station` (`id`),
  CONSTRAINT `fk_station_id_2` FOREIGN KEY (`after_id`) REFERENCES `station` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
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
  `amount` bigint(20) DEFAULT NULL,
  `amount_captured` bigint(20) DEFAULT NULL,
  `amount_refunded` bigint(20) DEFAULT NULL,
  `application_fee_amount` bigint(20) DEFAULT NULL,
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
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
  `subscription_id` int(11) NOT NULL AUTO_INCREMENT,
  `trips_num` int(11) DEFAULT NULL,
  `region_num` int(11) DEFAULT NULL,
  `months_num` int(11) DEFAULT NULL,
  `price` int(11) NOT NULL,
  PRIMARY KEY (`subscription_id`),
  UNIQUE KEY `records_UNIQUE` (`trips_num`,`region_num`,`months_num`,`price`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subscription`
--

LOCK TABLES `subscription` WRITE;
/*!40000 ALTER TABLE `subscription` DISABLE KEYS */;
INSERT INTO `subscription` VALUES (1,60,1,1,185),(4,60,2,1,230),(7,60,3,1,270),(11,60,4,1,270),(12,60,5,1,360),(13,60,6,1,360),(2,180,1,3,500),(5,180,2,3,630),(14,180,3,3,760),(15,180,4,3,760),(16,180,5,3,1000),(17,180,6,3,1000),(18,730,1,12,2760),(3,730,2,12,2760),(20,730,3,12,2760),(19,730,4,12,2760),(6,730,5,12,3465),(21,730,6,12,3465);
/*!40000 ALTER TABLE `subscription` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ticket`
--

DROP TABLE IF EXISTS `ticket`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ticket` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `price` int(11) NOT NULL,
  `maximum_trips` int(11) NOT NULL,
  `source_station` varchar(45) DEFAULT NULL,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_userID_idx` (`user_id`),
  CONSTRAINT `fk_user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ticket`
--

LOCK TABLES `ticket` WRITE;
/*!40000 ALTER TABLE `ticket` DISABLE KEYS */;
INSERT INTO `ticket` VALUES (5,7,16,'Sadat',10),(6,5,9,'Sadat',10),(8,10,36,'Giza',10),(9,5,9,'Giza',10),(10,2,5,NULL,18),(11,5,9,NULL,18),(12,7,13,NULL,18),(13,10,36,NULL,18),(14,10,36,NULL,9),(15,10,36,NULL,10),(16,5,9,'moneb',19);
/*!40000 ALTER TABLE `ticket` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
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
  UNIQUE KEY `stripe_id_UNIQUE` (`stripe_id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (9,'Ahmed','Ahmed Ibrahim','Ahmed@gmail.com','$2a$10$soOgAzKo0YPziSHQKYNFDudzS.n5oInnNgC8kb4tZLrWbWjyC3/Am','011595858','1999-07-02',900,'user','cus_JqrwgqkQYJpLWq'),(10,'Mohsen','Mohamed Mohsen','Mohsen@gmail.com','$2a$10$jFpoZOhZpbBnXDOZwPC4ROJVv3DVe/MlIPE/HbhgLUeixKUce2xFK','01151825393','1999-02-02',2041,'user','cus_JqrzkDdu1rl4Zd'),(12,'MBakr','Muhammad Bakr','mbakr7757@gmail.com','$2a$10$HGiAOyCxw/ci3uY20d1kUuIyD/afbo.a81x.f8w0F/twbDG.YBsKu','01151825393','1999-06-09',0,'user','cus_Juikzhi2ZeiYhY'),(18,'Walter','Walter White','Walter@gmail.com','$2a$10$C5l5AK6YrTPCkksyqd1/c.xcHjwFRDreenbFc8jcBYjqM1G.OOcge','0116646464','2008-07-09',619776,'user','cus_Jv5RU9B50XNKnl'),(19,'Sameh10','Mohamed Sameh','mosameh@gmail.com','$2a$10$57ZpbDhxhgQBWyScBhEnb.vsbUXTUl6jdP421MAUe3o5iFcbG7gRm','01116898357','1999-11-29',303,'user','cus_JvEnASzSTvG1gs'),(20,'Ahibrahim4','Ahmed t','Ahibrahim@gmail.com','$2a$10$X0OOChHFuXQnFP8OQz9ve.T11hIoMdlSJ1lYJ6dMkJr20suPSsnxC','0114232','1998-07-10',0,'user','cus_JvFBOv9dv03Dzv'),(21,'Pinkman','Jesse','jesse@gmail.com','$2a$10$gHd6cn2YluHFj9tFoeyPP.r2L7tEhiqHF1ybNAGEq5SwMsfmLGp0C','9999','2021-07-26',0,'user','cus_JvFYTOFmZiJggn'),(22,'Ahibrahim.ai7','Ahmed Ibrahim','Ahmed7777@gmail.com','$2a$10$7U/SwDseAIcJd9kGlfk9w.V0R3.dDH3I7vLLfDyaR2if.QI.6qnkm','0114642845','1999-02-05',1810,'user','cus_JvJ0MRJJeMeCDD');
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

-- Dump completed on 2021-07-30 12:43:48
