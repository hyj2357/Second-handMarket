-- MySQL dump 10.13  Distrib 5.5.40, for osx10.6 (i386)
--
-- Host: localhost    Database: secondhandmarket
-- ------------------------------------------------------
-- Server version	5.5.40

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
-- Table structure for table `Customer`
--

DROP TABLE IF EXISTS `Customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Customer` (
  `cid` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(10) DEFAULT NULL,
  `password` varchar(32) DEFAULT NULL,
  `province` varchar(3) DEFAULT NULL,
  `city` varchar(10) DEFAULT NULL,
  `area` varchar(32) DEFAULT NULL,
  `school` varchar(32) DEFAULT NULL,
  `phonenumber` varchar(11) DEFAULT NULL,
  `isAdmin` int(11) DEFAULT NULL,
  `authority` int(11) DEFAULT NULL,
  PRIMARY KEY (`cid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Customer`
--

LOCK TABLES `Customer` WRITE;
/*!40000 ALTER TABLE `Customer` DISABLE KEYS */;
/*!40000 ALTER TABLE `Customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `buyerRecord`
--

DROP TABLE IF EXISTS `buyerRecord`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `buyerRecord` (
  `bid` int(11) NOT NULL AUTO_INCREMENT,
  `hasPay` int(11) DEFAULT NULL,
  `price` float DEFAULT NULL,
  `gid` int(11) DEFAULT NULL,
  `buyerId` int(11) DEFAULT NULL,
  `salerId` int(11) DEFAULT NULL,
  PRIMARY KEY (`bid`),
  KEY `FKD57E07E457C8DBC5` (`buyerId`),
  KEY `FKD57E07E4B83AAD1D` (`salerId`),
  KEY `FKD57E07E4F201D2D8` (`gid`),
  CONSTRAINT `FKD57E07E4F201D2D8` FOREIGN KEY (`gid`) REFERENCES `good` (`gid`),
  CONSTRAINT `FKD57E07E457C8DBC5` FOREIGN KEY (`buyerId`) REFERENCES `Customer` (`cid`),
  CONSTRAINT `FKD57E07E4B83AAD1D` FOREIGN KEY (`salerId`) REFERENCES `Customer` (`cid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `buyerRecord`
--

LOCK TABLES `buyerRecord` WRITE;
/*!40000 ALTER TABLE `buyerRecord` DISABLE KEYS */;
/*!40000 ALTER TABLE `buyerRecord` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `collection`
--

DROP TABLE IF EXISTS `collection`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `collection` (
  `cid` int(11) NOT NULL,
  `gid` int(11) NOT NULL,
  PRIMARY KEY (`cid`,`gid`),
  KEY `FK9835AE9EF201D2D8` (`gid`),
  KEY `FK9835AE9E4927EE75` (`cid`),
  CONSTRAINT `FK9835AE9E4927EE75` FOREIGN KEY (`cid`) REFERENCES `Customer` (`cid`),
  CONSTRAINT `FK9835AE9EF201D2D8` FOREIGN KEY (`gid`) REFERENCES `good` (`gid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `collection`
--

LOCK TABLES `collection` WRITE;
/*!40000 ALTER TABLE `collection` DISABLE KEYS */;
/*!40000 ALTER TABLE `collection` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `evaluation`
--

DROP TABLE IF EXISTS `evaluation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `evaluation` (
  `eid` int(11) NOT NULL AUTO_INCREMENT,
  `content` varchar(100) DEFAULT NULL,
  `cid` int(11) DEFAULT NULL,
  `gid` int(11) DEFAULT NULL,
  PRIMARY KEY (`eid`),
  KEY `FK332C073CF201D2D8` (`gid`),
  KEY `FK332C073C4927EE75` (`cid`),
  CONSTRAINT `FK332C073C4927EE75` FOREIGN KEY (`cid`) REFERENCES `Customer` (`cid`),
  CONSTRAINT `FK332C073CF201D2D8` FOREIGN KEY (`gid`) REFERENCES `good` (`gid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `evaluation`
--

LOCK TABLES `evaluation` WRITE;
/*!40000 ALTER TABLE `evaluation` DISABLE KEYS */;
/*!40000 ALTER TABLE `evaluation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `good`
--

DROP TABLE IF EXISTS `good`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `good` (
  `gid` int(11) NOT NULL AUTO_INCREMENT,
  `price` float DEFAULT NULL,
  `intro` varchar(100) DEFAULT NULL,
  `isOnline` int(11) DEFAULT NULL,
  `category` varchar(32) DEFAULT NULL,
  `posterId` int(11) DEFAULT NULL,
  PRIMARY KEY (`gid`),
  KEY `FK3080BD764D58DF` (`posterId`),
  CONSTRAINT `FK3080BD764D58DF` FOREIGN KEY (`posterId`) REFERENCES `Customer` (`cid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `good`
--

LOCK TABLES `good` WRITE;
/*!40000 ALTER TABLE `good` DISABLE KEYS */;
/*!40000 ALTER TABLE `good` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `message`
--

DROP TABLE IF EXISTS `message`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `message` (
  `mid` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(10) DEFAULT NULL,
  `content` varchar(100) DEFAULT NULL,
  `isFromToSA` int(11) DEFAULT NULL,
  `mstime` datetime DEFAULT NULL,
  `sender` int(11) DEFAULT NULL,
  `receiver` int(11) DEFAULT NULL,
  PRIMARY KEY (`mid`),
  KEY `FK38EB0007132687EC` (`sender`),
  KEY `FK38EB000718F257A6` (`receiver`),
  CONSTRAINT `FK38EB000718F257A6` FOREIGN KEY (`receiver`) REFERENCES `Customer` (`cid`),
  CONSTRAINT `FK38EB0007132687EC` FOREIGN KEY (`sender`) REFERENCES `Customer` (`cid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `message`
--

LOCK TABLES `message` WRITE;
/*!40000 ALTER TABLE `message` DISABLE KEYS */;
/*!40000 ALTER TABLE `message` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `morder`
--

DROP TABLE IF EXISTS `morder`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `morder` (
  `oid` int(11) NOT NULL AUTO_INCREMENT,
  `hasPay` int(11) DEFAULT NULL,
  `price` float DEFAULT NULL,
  `gid` int(11) DEFAULT NULL,
  `buyerId` int(11) DEFAULT NULL,
  `salerId` int(11) DEFAULT NULL,
  PRIMARY KEY (`oid`),
  KEY `FKC051C30157C8DBC5` (`buyerId`),
  KEY `FKC051C301B83AAD1D` (`salerId`),
  KEY `FKC051C301F201D2D8` (`gid`),
  CONSTRAINT `FKC051C301F201D2D8` FOREIGN KEY (`gid`) REFERENCES `good` (`gid`),
  CONSTRAINT `FKC051C30157C8DBC5` FOREIGN KEY (`buyerId`) REFERENCES `Customer` (`cid`),
  CONSTRAINT `FKC051C301B83AAD1D` FOREIGN KEY (`salerId`) REFERENCES `Customer` (`cid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `morder`
--

LOCK TABLES `morder` WRITE;
/*!40000 ALTER TABLE `morder` DISABLE KEYS */;
/*!40000 ALTER TABLE `morder` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `superAdmin`
--

DROP TABLE IF EXISTS `superAdmin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `superAdmin` (
  `said` int(11) NOT NULL AUTO_INCREMENT,
  `sname` varchar(10) DEFAULT NULL,
  `password` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`said`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `superAdmin`
--

LOCK TABLES `superAdmin` WRITE;
/*!40000 ALTER TABLE `superAdmin` DISABLE KEYS */;
/*!40000 ALTER TABLE `superAdmin` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-07-29 18:12:31
