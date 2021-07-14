-- MySQL dump 10.13  Distrib 8.0.25, for Win64 (x86_64)
--
-- Host: localhost    Database: metro_app
-- ------------------------------------------------------
-- Server version	8.0.25

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
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=70 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `station`
--

LOCK TABLES `station` WRITE;
/*!40000 ALTER TABLE `station` DISABLE KEYS */;
INSERT INTO `station` VALUES (1,'moneb',29.98109309298193,31.21233061709853),(2,'sakyet meky',29.995890494742405,31.208660612727254),(3,'om elmasryeen',30.005802536425108,31.20818457049328),(4,'giza',30.01084170020563,31.207198385837035),(5,'faisal',30.01724019639334,31.20393798901821),(6,'gamet el kahera',30.02716229311841,31.20054572631451),(7,'bohos',30.035884500122123,31.197755956848162),(8,'sadat',30.044254166833316,31.23557105461699),(9,'mohamed nageb',30.04546088975674,31.244173026314918),(10,'attaba',30.052559572058463,31.24679226864329),(11,'shohada',30.0612517058977,31.24610957114708),(12,'rod el farag',30.080983459101496,31.247275726315976),(13,'sant treza',30.088024925887158,31.245484511968787),(14,'khalafawy',30.097701536184275,31.245449573536334),(15,'mazallat',30.10385408067541,31.245819455152372),(16,'kolyt el zeraa',30.11244007895492,31.2487589242472),(17,'shobra el khema',30.126369460411908,31.240731281851094),(18,'bab el shareya',30.053120471951143,31.25528303398445),(19,'elgesh',30.061775901720186,31.266908885483765),(20,'abdo basha',30.064768945615942,31.274784129653227),(21,'abasya',30.072213370620275,31.28377466687735),(22,'ard el maared',30.073300393447447,31.30096818795872),(23,'stad el kahera',30.073164878902908,31.317274063048057),(24,'kolyt el banat',30.083862280836758,31.32902327885962),(25,'elahram',30.09171265724782,31.32631575629407),(26,'haron el rashed',30.101378447184498,31.332967084901757),(27,'heliopolis',30.10783171006869,31.33898553693009),(28,'alf maskan',30.118675998859498,31.339849829218057),(29,'nady el shams',30.118651550742324,31.33987008133739),(30,'el nozha',30.127950614439293,31.360689230325953),(31,'hesham barakat',30.13086779148849,31.373110486371704),(32,'marg',30.157278365146386,31.336694644909585),(33,'ezbt elnakhl',30.139872127977718,31.32407207506738),(34,'ain shams',30.131071650763033,31.31897030180762),(35,'al matareya',30.12142054981096,31.31354985722528),(36,'helmyt elzayton',30.114212407291372,31.31404404683178),(37,'hadayek el zayton',30.105889166913514,31.31048351450316),(38,'sray el koba',30.097649372887698,31.304556529476805),(39,'hamamat el koba',30.091236217450007,31.29890986214482),(40,'kobry el koba',30.087197988850882,31.294105790395392),(41,'manshiet el sadr',30.081981895032676,31.287538429091704),(42,'eldemerdash',30.076778992768332,31.277269212317936),(43,'ghamra',30.069027439567193,31.264615881827),(44,'ahmed oraby',30.05668886922058,31.24204822420959),(45,'gamal abdelnaser',30.05341113431184,31.238852368573973),(46,'sad zaghloul',30.036497605320168,31.24037559341199),(47,'elsayeda zaynab',30.02912252031076,31.23715449746652),(48,'elmalek el saleh',30.017677591324084,31.231167048106634),(49,'mar girgis',30.00610443489707,31.229581003563432),(50,'zahraa masr el kadima',29.995481719090524,31.231171285164883),(51,'dar el salam',29.98206443310469,31.242177399751785),(52,'hadayek el maadi',29.97023869709702,31.25051267856607),(53,'maadi',29.959917836345756,31.25711767082125),(54,'sakanat el maadi',29.953298759041086,31.262950115680972),(55,'tora el balad',29.94676046546416,31.272968070785),(56,'kozzika',29.93626623839101,31.281832697333478),(57,'tora el asmant',29.925964672555377,31.287540114662633),(58,'el maasara',29.906062394638237,31.299490374943503),(59,'hadayek helwan',29.897128186365965,31.30393221200776),(60,'wadi-hof',29.879082088125163,31.313591334777936),(61,'gamet helwan',29.86945333073545,31.320069426759034),(62,'ain helwan',29.862567929493235,31.32549592063716),(63,'dokky',30.038595463899835,31.21276100853596),(64,'opera',30.041948142608952,31.224990989838254),(65,'msara',30.070893488382577,31.245094979790103),(66,'helwan',29.848980953544377,31.33414613935252),(67,'qebaa',30.134802827914225,31.384025430248332);
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
INSERT INTO `station_line` VALUES (8,1),(11,1),(32,1),(33,1),(34,1),(35,1),(36,1),(37,1),(38,1),(39,1),(40,1),(41,1),(42,1),(43,1),(44,1),(45,1),(46,1),(47,1),(48,1),(49,1),(50,1),(51,1),(52,1),(53,1),(54,1),(55,1),(56,1),(57,1),(58,1),(59,1),(60,1),(61,1),(62,1),(66,1),(1,2),(2,2),(3,2),(4,2),(5,2),(6,2),(7,2),(8,2),(9,2),(10,2),(11,2),(12,2),(13,2),(14,2),(15,2),(16,2),(17,2),(63,2),(64,2),(65,2),(10,3),(18,3),(19,3),(20,3),(21,3),(22,3),(23,3),(24,3),(25,3),(26,3),(27,3),(28,3),(29,3),(30,3),(31,3),(67,3);
/*!40000 ALTER TABLE `station_line` ENABLE KEYS */;
UNLOCK TABLES;

--
<<<<<<< Updated upstream:SQL script.sql
=======
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
>>>>>>> Stashed changes:Data Base Script.sql
-- Table structure for table `ticket`
--

DROP TABLE IF EXISTS `ticket`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ticket` (
  `id` int NOT NULL AUTO_INCREMENT,
  `price` int NOT NULL,
  `maximum_trips` int NOT NULL,
  `valid` tinyint NOT NULL,
  `user_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_userID_idx` (`user_id`),
  CONSTRAINT `fk_user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
<<<<<<< Updated upstream:SQL script.sql
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
=======
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
>>>>>>> Stashed changes:Data Base Script.sql
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ticket`
--

LOCK TABLES `ticket` WRITE;
/*!40000 ALTER TABLE `ticket` DISABLE KEYS */;
<<<<<<< Updated upstream:SQL script.sql
INSERT INTO `ticket` VALUES (1,5,9,1,1);
=======
INSERT INTO `ticket` VALUES (3,5,9,1,9);
>>>>>>> Stashed changes:Data Base Script.sql
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
<<<<<<< Updated upstream:SQL script.sql
  `user_name` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `phone_number` varchar(45) DEFAULT NULL,
  `date_of_birth` date DEFAULT NULL,
  `balance` int DEFAULT '0',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
=======
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
>>>>>>> Stashed changes:Data Base Script.sql
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
<<<<<<< Updated upstream:SQL script.sql
INSERT INTO `user` VALUES (1,'mohsen','midomohsen11@gmail.com','1234',NULL,NULL,0),(2,'bakr','mbakr@gmail.com','1234',NULL,NULL,5),(3,'mido','msameh@gmail.com','1234',NULL,NULL,0),(4,'sameh','msameh99@gmail.com','1234',NULL,NULL,0);
=======
INSERT INTO `user` VALUES (9,'Ahmed','Ahmed Ibrahim','Ahmed@gmail.com','$2a$10$soOgAzKo0YPziSHQKYNFDudzS.n5oInnNgC8kb4tZLrWbWjyC3/Am','0115','1999-02-02',57,'user','cus_JqrwgqkQYJpLWq'),(10,'Mohsen','Mohamed Mohsen','Mohsen@gmail.com','$2a$10$jFpoZOhZpbBnXDOZwPC4ROJVv3DVe/MlIPE/HbhgLUeixKUce2xFK','0113','1999-02-04',0,'user','cus_JqrzkDdu1rl4Zd');
>>>>>>> Stashed changes:Data Base Script.sql
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

<<<<<<< Updated upstream:SQL script.sql
-- Dump completed on 2021-07-11 21:39:08
=======
-- Dump completed on 2021-07-14 18:08:28
>>>>>>> Stashed changes:Data Base Script.sql
