-- MySQL dump 10.13  Distrib 8.0.25, for Win64 (x86_64)
--
-- Host: localhost    Database: mydb
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
-- Table structure for table `buslist`
--

DROP TABLE IF EXISTS `buslist`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `buslist` (
  `id` int NOT NULL,
  `start` varchar(10) DEFAULT NULL,
  `end` varchar(10) DEFAULT NULL,
  `starttime` varchar(10) DEFAULT NULL,
  `class` varchar(5) DEFAULT NULL,
  `seats` int DEFAULT NULL,
  `price` int DEFAULT NULL,
  `date` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `buslist`
--

LOCK TABLES `buslist` WRITE;
/*!40000 ALTER TABLE `buslist` DISABLE KEYS */;
INSERT INTO `buslist` VALUES (1,'인천','서울','08:00','우등',25,9400,'12-23'),(2,'인천','서울','09:00','우등',25,9400,'12-23'),(3,'인천','서울','10:00','우등',25,9400,'12-23'),(4,'인천','서울','11:00','우등',25,9400,'12-23'),(5,'인천','서울','12:00','우등',25,9400,'12-23'),(6,'인천','서울','13:00','우등',25,9400,'12-23'),(7,'인천','서울','14:00','우등',25,9400,'12-23'),(8,'인천','서울','15:00','우등',25,9400,'12-23'),(9,'인천','서울','16:00','우등',25,9400,'12-23'),(10,'인천','서울','17:00','우등',25,9400,'12-23'),(11,'인천','서울','18:00','우등',25,9400,'12-23'),(12,'군산','서울','08:00','우등',25,9400,'12-23'),(13,'군산','서울','09:00','우등',25,9400,'12-23'),(14,'군산','서울','10:00','우등',25,9400,'12-23'),(15,'군산','서울','11:00','우등',25,9400,'12-23'),(16,'군산','서울','12:00','우등',25,9400,'12-23'),(17,'군산','서울','13:00','우등',25,9400,'12-23'),(18,'군산','서울','14:00','우등',25,9400,'12-23'),(19,'군산','서울','15:00','우등',25,9400,'12-23'),(20,'군산','서울','16:00','우등',25,9400,'12-23'),(21,'군산','서울','17:00','우등',25,9400,'12-23'),(22,'군산','서울','18:00','우등',25,9400,'12-23');
/*!40000 ALTER TABLE `buslist` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-12-26 12:27:24
