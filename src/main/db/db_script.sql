-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: mydb
-- ------------------------------------------------------
-- Server version	5.7.15-log

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
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (2);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `passenger`
--

DROP TABLE IF EXISTS `passenger`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `passenger` (
  `idPassenger` int(11) NOT NULL AUTO_INCREMENT,
  `birth` date DEFAULT NULL,
  `firstName` varchar(255) NOT NULL,
  `lastName` varchar(255) NOT NULL,
  PRIMARY KEY (`idPassenger`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `passenger`
--

LOCK TABLES `passenger` WRITE;
/*!40000 ALTER TABLE `passenger` DISABLE KEYS */;
INSERT INTO `passenger` VALUES (1,'1995-11-24','Ариф','Балаев'),(2,'1995-03-08','Дарья','Филиппова'),(3,'1995-09-06','Вячеслав','Беляков'),(4,'1984-05-13','Николай','Дроздов');
/*!40000 ALTER TABLE `passenger` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `route`
--

DROP TABLE IF EXISTS `route`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `route` (
  `idRoute` int(11) NOT NULL AUTO_INCREMENT,
  `route_name` varchar(45) NOT NULL,
  `start_station` int(11) NOT NULL,
  `finish_station` int(11) NOT NULL,
  `train` int(11) NOT NULL,
  `start_date` datetime NOT NULL,
  PRIMARY KEY (`idRoute`),
  KEY `start_station_idx` (`start_station`),
  KEY `finish_station_idx` (`finish_station`),
  KEY `train_idx` (`train`),
  CONSTRAINT `FK6gtb12rdd17ogf8f62mnwmqk2` FOREIGN KEY (`train`) REFERENCES `train` (`idTrain`),
  CONSTRAINT `FKdhr1ole97v6omfdvd497dq5mt` FOREIGN KEY (`finish_station`) REFERENCES `station` (`idStation`),
  CONSTRAINT `FKeih3mrryi1jdgck9ldlphxgb7` FOREIGN KEY (`start_station`) REFERENCES `station` (`idStation`),
  CONSTRAINT `finish_station` FOREIGN KEY (`finish_station`) REFERENCES `station` (`idStation`) ON UPDATE CASCADE,
  CONSTRAINT `start_station` FOREIGN KEY (`start_station`) REFERENCES `station` (`idStation`) ON UPDATE CASCADE,
  CONSTRAINT `train` FOREIGN KEY (`train`) REFERENCES `train` (`idTrain`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `route`
--

LOCK TABLES `route` WRITE;
/*!40000 ALTER TABLE `route` DISABLE KEYS */;
INSERT INTO `route` VALUES (1,'411',2,4,1,'2016-10-15 10:41:55'),(2,'412',4,2,2,'2016-10-16 08:42:34'),(3,'413',2,5,3,'2016-10-17 06:48:13'),(4,'414',1,2,4,'2016-10-20 14:52:34');
/*!40000 ALTER TABLE `route` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `route_timetables`
--

DROP TABLE IF EXISTS `route_timetables`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `route_timetables` (
  `route_id` int(11) NOT NULL,
  `timetable_id` int(11) NOT NULL,
  `numer_line` int(11) NOT NULL,
  PRIMARY KEY (`route_id`,`timetable_id`),
  KEY `FKex8uec06253wj0niqfjmelnx2` (`timetable_id`),
  CONSTRAINT `FKex8uec06253wj0niqfjmelnx2` FOREIGN KEY (`timetable_id`) REFERENCES `timetable` (`idLine`),
  CONSTRAINT `FKmr8cth1fhbex8v2ikuijqn9ns` FOREIGN KEY (`route_id`) REFERENCES `route` (`idRoute`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `route_timetables`
--

LOCK TABLES `route_timetables` WRITE;
/*!40000 ALTER TABLE `route_timetables` DISABLE KEYS */;
INSERT INTO `route_timetables` VALUES (1,1,1),(1,2,2),(1,3,3),(2,4,1),(2,5,2),(2,6,3),(2,7,4),(3,3,2),(3,8,1),(3,9,3),(4,10,1),(4,11,2),(4,12,3);
/*!40000 ALTER TABLE `route_timetables` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `station`
--

DROP TABLE IF EXISTS `station`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `station` (
  `idStation` int(11) NOT NULL AUTO_INCREMENT,
  `stationName` varchar(45) NOT NULL,
  PRIMARY KEY (`idStation`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `station`
--

LOCK TABLES `station` WRITE;
/*!40000 ALTER TABLE `station` DISABLE KEYS */;
INSERT INTO `station` VALUES (1,'Грузино'),(2,'Мга'),(3,'Павловск'),(4,'Сестрорецк'),(5,'Пупышево');
/*!40000 ALTER TABLE `station` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ticket`
--

DROP TABLE IF EXISTS `ticket`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ticket` (
  `idTicket` int(11) NOT NULL AUTO_INCREMENT,
  `arrival_date` datetime DEFAULT NULL,
  `departure_date` datetime DEFAULT NULL,
  `Price` decimal(19,4) DEFAULT NULL,
  `arrival_station` int(11) DEFAULT NULL,
  `departure_station` int(11) DEFAULT NULL,
  `ticket_passenger` int(11) DEFAULT NULL,
  `ticket_train` int(11) DEFAULT NULL,
  PRIMARY KEY (`idTicket`),
  KEY `FK6fbmg3daq1ul23a6r98gf8t40` (`arrival_station`),
  KEY `FK6hed7rkyvoem6qtlinwovdgwb` (`departure_station`),
  KEY `FKfkfxmpn23cs5ye1cby2mxjrvi` (`ticket_passenger`),
  KEY `FKijch8p916w7y2l81dvg6lm3rr` (`ticket_train`),
  CONSTRAINT `FK6fbmg3daq1ul23a6r98gf8t40` FOREIGN KEY (`arrival_station`) REFERENCES `station` (`idStation`),
  CONSTRAINT `FK6hed7rkyvoem6qtlinwovdgwb` FOREIGN KEY (`departure_station`) REFERENCES `station` (`idStation`),
  CONSTRAINT `FKfkfxmpn23cs5ye1cby2mxjrvi` FOREIGN KEY (`ticket_passenger`) REFERENCES `passenger` (`idPassenger`),
  CONSTRAINT `FKijch8p916w7y2l81dvg6lm3rr` FOREIGN KEY (`ticket_train`) REFERENCES `train` (`idTrain`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ticket`
--

LOCK TABLES `ticket` WRITE;
/*!40000 ALTER TABLE `ticket` DISABLE KEYS */;
/*!40000 ALTER TABLE `ticket` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `timetable`
--

DROP TABLE IF EXISTS `timetable`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `timetable` (
  `idLine` int(11) NOT NULL AUTO_INCREMENT,
  `distance` double DEFAULT NULL,
  `station_arrival` int(11) DEFAULT NULL,
  `station_departure` int(11) DEFAULT NULL,
  `travelTime` time DEFAULT NULL,
  PRIMARY KEY (`idLine`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `timetable`
--

LOCK TABLES `timetable` WRITE;
/*!40000 ALTER TABLE `timetable` DISABLE KEYS */;
INSERT INTO `timetable` VALUES (1,60,1,2,'01:00:00'),(2,120,3,1,'02:00:00'),(3,60,4,3,'01:00:00'),(4,60,3,4,'01:00:00'),(5,180,5,3,'03:00:00'),(6,60,1,5,'01:00:00'),(7,60,2,1,'01:00:00'),(8,60,3,2,'01:00:00'),(9,60,5,4,'01:00:00'),(10,60,5,1,'01:00:00'),(11,60,4,5,'01:00:00'),(12,120,2,4,'02:00:00');
/*!40000 ALTER TABLE `timetable` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `train`
--

DROP TABLE IF EXISTS `train`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `train` (
  `idTrain` int(11) NOT NULL AUTO_INCREMENT,
  `seats` int(11) NOT NULL,
  PRIMARY KEY (`idTrain`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `train`
--

LOCK TABLES `train` WRITE;
/*!40000 ALTER TABLE `train` DISABLE KEYS */;
INSERT INTO `train` VALUES (1,10),(2,12),(3,11),(4,13);
/*!40000 ALTER TABLE `train` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `idUser` int(11) NOT NULL AUTO_INCREMENT,
  `login` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `role` varchar(255) NOT NULL,
  `fio` varchar(45) NOT NULL,
  PRIMARY KEY (`idUser`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'admin','qwe','ADMIN','Arif Balaev');
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

-- Dump completed on 2016-10-03  0:02:32
