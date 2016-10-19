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
-- Table structure for table `booked_timetables`
--

DROP TABLE IF EXISTS `booked_timetables`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `booked_timetables` (
  `booked_id` int(11) NOT NULL AUTO_INCREMENT,
  `ticket_id` int(11) NOT NULL,
  `event_id` int(11) NOT NULL,
  PRIMARY KEY (`booked_id`),
  KEY `ticket_id_idx` (`ticket_id`),
  KEY `event_id_idx` (`event_id`),
  CONSTRAINT `event_id` FOREIGN KEY (`event_id`) REFERENCES `route_timetables` (`id_event`) ON UPDATE CASCADE,
  CONSTRAINT `ticket_id` FOREIGN KEY (`ticket_id`) REFERENCES `ticket` (`idTicket`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `booked_timetables`
--

LOCK TABLES `booked_timetables` WRITE;
/*!40000 ALTER TABLE `booked_timetables` DISABLE KEYS */;
INSERT INTO `booked_timetables` VALUES (27,34,19),(28,34,18),(29,35,8),(30,36,8),(31,37,9),(32,38,13),(33,39,10),(34,40,10),(35,41,10),(36,42,10),(37,43,5),(38,43,6),(39,44,6),(40,44,5),(41,45,6),(42,45,5),(43,46,6),(44,46,5),(45,47,6),(46,47,5);
/*!40000 ALTER TABLE `booked_timetables` ENABLE KEYS */;
UNLOCK TABLES;

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
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `passenger`
--

LOCK TABLES `passenger` WRITE;
/*!40000 ALTER TABLE `passenger` DISABLE KEYS */;
INSERT INTO `passenger` VALUES (1,'1995-11-24','Arif','Balaev'),(2,'1995-03-08','Daria','Filippova'),(3,'1995-09-06','Vyacheslav','Belyakov'),(4,'1984-05-13','Nikolay','Drozdov'),(5,'1986-06-21','Oleg','Smirnov'),(6,'1989-03-26','Tatiana','Titova'),(7,'1988-07-12','Yulia','Makarenko'),(8,'1995-04-12','Nikita','Zaitcev'),(9,'1980-01-23','Kiril','Buta'),(10,'1990-11-15','Sergey','Yakimov'),(11,'1993-10-20','Natalia','Malunova'),(12,'1996-08-21','Boris','Puzakov'),(14,'1994-03-23','Aleksey','Tsoi'),(17,'1988-11-22','Igor','Kot'),(18,'1992-05-21','Maria','Kot'),(19,'1999-04-28','Irina','Kot'),(20,'1997-09-20','Anatolyi','Pes'),(21,'2005-01-15','Genadyi','Pes');
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
  `train` int(11) NOT NULL,
  `start_station` int(11) NOT NULL,
  `finish_station` int(11) NOT NULL,
  PRIMARY KEY (`idRoute`),
  KEY `train_idx` (`train`),
  KEY `start_station_idx` (`start_station`),
  KEY `finish_station_idx` (`finish_station`),
  CONSTRAINT `finish_station` FOREIGN KEY (`finish_station`) REFERENCES `station` (`idStation`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `start_station` FOREIGN KEY (`start_station`) REFERENCES `station` (`idStation`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `train` FOREIGN KEY (`train`) REFERENCES `train` (`idTrain`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `route`
--

LOCK TABLES `route` WRITE;
/*!40000 ALTER TABLE `route` DISABLE KEYS */;
INSERT INTO `route` VALUES (1,'411',1,2,4),(2,'412',2,4,2),(3,'413',3,2,5),(4,'414',4,1,2);
/*!40000 ALTER TABLE `route` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `route_timetables`
--

DROP TABLE IF EXISTS `route_timetables`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `route_timetables` (
  `id_event` int(11) NOT NULL AUTO_INCREMENT,
  `line` int(11) NOT NULL,
  `route_id` int(11) NOT NULL,
  `number_in_route` int(11) NOT NULL,
  `date_departure` datetime NOT NULL,
  `date_arrival` datetime NOT NULL,
  `free_seats` int(11) NOT NULL,
  PRIMARY KEY (`id_event`),
  KEY `line_idx` (`line`),
  KEY `route_id_idx` (`route_id`),
  CONSTRAINT `line` FOREIGN KEY (`line`) REFERENCES `timetable` (`idLine`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `route_id` FOREIGN KEY (`route_id`) REFERENCES `route` (`idRoute`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `route_timetables`
--

LOCK TABLES `route_timetables` WRITE;
/*!40000 ALTER TABLE `route_timetables` DISABLE KEYS */;
INSERT INTO `route_timetables` VALUES (1,1,1,1,'2016-10-15 10:41:55','2016-10-15 11:45:55',10),(2,2,1,2,'2016-10-15 12:00:15','2016-10-15 14:10:20',10),(3,3,1,3,'2016-10-15 14:20:15','2016-10-15 15:22:15',10),(4,4,2,1,'2016-10-16 08:42:34','2016-10-16 09:45:42',10),(5,5,2,2,'2016-10-16 09:45:42','2016-10-16 12:50:03',10),(6,6,2,3,'2016-10-16 13:05:03','2016-10-16 14:20:03',10),(7,7,2,4,'2016-10-16 14:30:03','2016-10-16 15:20:03',10),(8,8,3,1,'2016-10-17 06:48:13','2016-10-17 07:50:46',11),(9,3,3,2,'2016-10-17 08:03:32','2016-10-17 09:10:08',11),(10,9,3,3,'2016-10-17 09:20:08','2016-10-17 10:15:08',7),(11,10,4,1,'2016-10-20 14:52:34','2016-10-20 16:00:00',13),(12,11,4,2,'2016-10-20 16:05:10','2016-10-20 17:12:10',13),(13,12,4,3,'2016-10-20 17:24:10','2016-10-20 19:37:10',12),(14,1,1,1,'2016-10-22 10:41:55','2016-10-22 11:45:55',10),(15,2,1,2,'2016-10-22 12:00:15','2016-10-22 14:10:20',10),(16,3,1,3,'2016-10-22 14:20:15','2016-10-22 15:22:15',10),(17,4,2,1,'2016-10-23 08:42:34','2016-10-23 09:45:42',12),(18,5,2,2,'2016-10-23 09:45:42','2016-10-23 12:50:03',11),(19,6,2,3,'2016-10-23 13:05:03','2016-10-23 14:20:03',11),(20,7,2,4,'2016-10-23 14:30:03','2016-10-23 15:20:03',12);
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
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `station`
--

LOCK TABLES `station` WRITE;
/*!40000 ALTER TABLE `station` DISABLE KEYS */;
INSERT INTO `station` VALUES (1,'Gruzino'),(2,'Mga'),(3,'Pavlovsk'),(4,'Sestroretsk'),(5,'Pupuishevo'),(10,'Vaskilovo');
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
  `arrival_date` datetime NOT NULL,
  `departure_date` datetime NOT NULL,
  `price` decimal(19,4) DEFAULT NULL,
  `arrival_station` int(11) NOT NULL,
  `departure_station` int(11) NOT NULL,
  `ticket_passenger` int(11) NOT NULL,
  `ticket_train` int(11) NOT NULL,
  PRIMARY KEY (`idTicket`),
  KEY `FK6fbmg3daq1ul23a6r98gf8t40` (`arrival_station`),
  KEY `FK6hed7rkyvoem6qtlinwovdgwb` (`departure_station`),
  KEY `FKfkfxmpn23cs5ye1cby2mxjrvi` (`ticket_passenger`),
  KEY `FKijch8p916w7y2l81dvg6lm3rr` (`ticket_train`),
  CONSTRAINT `FK6fbmg3daq1ul23a6r98gf8t40` FOREIGN KEY (`arrival_station`) REFERENCES `station` (`idStation`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `FK6hed7rkyvoem6qtlinwovdgwb` FOREIGN KEY (`departure_station`) REFERENCES `station` (`idStation`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `FKfkfxmpn23cs5ye1cby2mxjrvi` FOREIGN KEY (`ticket_passenger`) REFERENCES `passenger` (`idPassenger`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FKijch8p916w7y2l81dvg6lm3rr` FOREIGN KEY (`ticket_train`) REFERENCES `train` (`idTrain`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ticket`
--

LOCK TABLES `ticket` WRITE;
/*!40000 ALTER TABLE `ticket` DISABLE KEYS */;
INSERT INTO `ticket` VALUES (34,'2016-10-23 14:20:03','2016-10-23 09:45:42',960.0000,1,3,8,2),(35,'2016-10-17 07:50:46','2016-10-17 06:48:13',240.0000,3,2,1,3),(36,'2016-10-17 07:50:46','2016-10-17 06:48:13',240.0000,3,2,2,3),(37,'2016-10-17 09:10:08','2016-10-17 08:03:32',240.0000,4,3,3,3),(38,'2016-10-20 19:37:10','2016-10-20 17:24:10',480.0000,2,4,4,4),(39,'2016-10-17 10:15:08','2016-10-17 09:20:08',240.0000,5,4,5,3),(40,'2016-10-17 10:15:08','2016-10-17 09:20:08',240.0000,5,4,10,3),(41,'2016-10-17 10:15:08','2016-10-17 09:20:08',240.0000,5,4,11,3),(42,'2016-10-17 10:15:08','2016-10-17 09:20:08',240.0000,5,4,9,3),(43,'2016-10-23 14:20:03','2016-10-23 09:45:42',960.0000,1,3,17,2),(44,'2016-10-23 14:20:03','2016-10-23 09:45:42',960.0000,1,3,18,2),(45,'2016-10-23 14:20:03','2016-10-23 09:45:42',960.0000,1,3,19,2),(46,'2016-10-23 14:20:03','2016-10-23 09:45:42',960.0000,1,3,20,2),(47,'2016-10-23 14:20:03','2016-10-23 09:45:42',960.0000,1,3,21,2);
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
  `station_departure` int(11) NOT NULL,
  `station_arrival` int(11) NOT NULL,
  `distance` double NOT NULL,
  PRIMARY KEY (`idLine`),
  KEY `station_departure_idx` (`station_departure`),
  KEY `station_arrival_idx` (`station_arrival`),
  CONSTRAINT `station_arrival` FOREIGN KEY (`station_arrival`) REFERENCES `station` (`idStation`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `station_departure` FOREIGN KEY (`station_departure`) REFERENCES `station` (`idStation`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `timetable`
--

LOCK TABLES `timetable` WRITE;
/*!40000 ALTER TABLE `timetable` DISABLE KEYS */;
INSERT INTO `timetable` VALUES (1,2,1,60),(2,1,3,120),(3,3,4,60),(4,4,3,60),(5,3,5,180),(6,5,1,60),(7,1,2,60),(8,2,3,60),(9,4,5,60),(10,1,5,60),(11,5,4,60),(12,4,2,120);
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
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `train`
--

LOCK TABLES `train` WRITE;
/*!40000 ALTER TABLE `train` DISABLE KEYS */;
INSERT INTO `train` VALUES (1,10),(2,12),(3,11),(4,13),(5,20),(10,6),(11,15),(12,15);
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
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'admin','qwe','ADMIN','Arif Balaev'),(2,'user','qwe','USER','Nikita Zaitcev'),(3,'mozg','qwe','USER','Ivan Mozgov'),(4,'zaitcev','qwe','USER','Oleg Petrov'),(5,'gliullin','qwerty','USER','Grigorii Liullin');
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

-- Dump completed on 2016-10-18  8:20:29
