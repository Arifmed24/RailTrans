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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
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
  PRIMARY KEY (`idRoute`),
  KEY `train_idx` (`train`),
  KEY `start_station_idx` (`start_station`),
  KEY `finish_station_idx` (`finish_station`),
  CONSTRAINT `finish_station` FOREIGN KEY (`finish_station`) REFERENCES `station` (`idStation`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `start_station` FOREIGN KEY (`start_station`) REFERENCES `station` (`idStation`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `train` FOREIGN KEY (`train`) REFERENCES `train` (`idTrain`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `route`
--

LOCK TABLES `route` WRITE;
/*!40000 ALTER TABLE `route` DISABLE KEYS */;
INSERT INTO `route` VALUES (1,'411',2,4,1),(2,'412',4,2,2),(3,'413',2,5,3),(4,'414',1,2,4);
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
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `route_timetables`
--

LOCK TABLES `route_timetables` WRITE;
/*!40000 ALTER TABLE `route_timetables` DISABLE KEYS */;
INSERT INTO `route_timetables` VALUES (1,1,1,1,'2016-10-15 10:41:55','2016-10-15 11:45:55',0),(2,2,1,2,'2016-10-15 12:00:15','2016-10-15 14:10:20',0),(3,3,1,3,'2016-10-15 14:20:15','2016-10-15 15:22:15',0),(4,4,2,1,'2016-10-16 08:42:34','2016-10-16 09:45:42',0),(5,5,2,2,'2016-10-16 09:45:42','2016-10-16 12:50:03',0),(6,6,2,3,'2016-10-16 13:05:03','2016-10-16 14:20:03',0),(7,7,2,4,'2016-10-16 14:30:03','2016-10-16 15:20:03',0),(8,8,3,1,'2016-10-17 06:48:13','2016-10-17 07:50:46',0),(9,3,3,2,'2016-10-17 08:03:32','2016-10-17 09:10:08',0),(10,9,3,3,'2016-10-17 09:20:08','2016-10-17 10:15:08',0),(11,10,4,1,'2016-10-20 14:52:34','2016-10-20 16:00:00',0),(12,11,4,2,'2016-10-20 16:05:10','2016-10-20 17:12:10',0),(13,12,4,3,'2016-10-20 17:24:10','2016-10-20 19:37:10',0);
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
  `price` decimal(19,4) DEFAULT NULL,
  `arrival_station` int(11) DEFAULT NULL,
  `departure_station` int(11) DEFAULT NULL,
  `ticket_passenger` int(11) DEFAULT NULL,
  `ticket_train` int(11) DEFAULT NULL,
  PRIMARY KEY (`idTicket`),
  KEY `FK6fbmg3daq1ul23a6r98gf8t40` (`arrival_station`),
  KEY `FK6hed7rkyvoem6qtlinwovdgwb` (`departure_station`),
  KEY `FKfkfxmpn23cs5ye1cby2mxjrvi` (`ticket_passenger`),
  KEY `FKijch8p916w7y2l81dvg6lm3rr` (`ticket_train`),
  CONSTRAINT `FK6fbmg3daq1ul23a6r98gf8t40` FOREIGN KEY (`arrival_station`) REFERENCES `station` (`idStation`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `FK6hed7rkyvoem6qtlinwovdgwb` FOREIGN KEY (`departure_station`) REFERENCES `station` (`idStation`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `FKfkfxmpn23cs5ye1cby2mxjrvi` FOREIGN KEY (`ticket_passenger`) REFERENCES `passenger` (`idPassenger`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FKijch8p916w7y2l81dvg6lm3rr` FOREIGN KEY (`ticket_train`) REFERENCES `train` (`idTrain`) ON DELETE NO ACTION ON UPDATE CASCADE
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
  `station_departure` int(11) NOT NULL,
  `station_arrival` int(11) NOT NULL,
  `distance` double NOT NULL,
  PRIMARY KEY (`idLine`),
  KEY `station_departure_idx` (`station_departure`),
  KEY `station_arrival_idx` (`station_arrival`),
  CONSTRAINT `station_arrival` FOREIGN KEY (`station_arrival`) REFERENCES `station` (`idStation`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `station_departure` FOREIGN KEY (`station_departure`) REFERENCES `station` (`idStation`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;
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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'admin','qwe','ADMIN','Arif Balaev'),(2,'user','qwe','USER','Nikita Zaitcev');
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

-- Dump completed on 2016-10-05 22:11:03
