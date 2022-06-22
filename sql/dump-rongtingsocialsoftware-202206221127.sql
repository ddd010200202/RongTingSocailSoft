-- MySQL dump 10.13  Distrib 5.5.62, for Win64 (AMD64)
--
-- Host: localhost    Database: rongtingsocialsoftware
-- ------------------------------------------------------
-- Server version	5.5.5-10.4.22-MariaDB

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
-- Table structure for table `urser_photo`
--

DROP TABLE IF EXISTS `urser_photo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `urser_photo` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `PHOTO_ID` varchar(100) NOT NULL DEFAULT concat('P',date_format(curdate(),'%Y%m'),'_',replace(uuid(),'-','')),
  `ALBUM_ID` varchar(100) NOT NULL,
  `USER_ID` varchar(100) NOT NULL,
  `PHOTO_NAME` varchar(100) NOT NULL,
  `PHOTO_DESC` varchar(200) NOT NULL,
  `CREATE_ID` varchar(100) NOT NULL,
  `CREATE_TIME` datetime NOT NULL DEFAULT sysdate(),
  `REVISE_ID` varchar(100) NOT NULL,
  `REVISE_TIME` datetime DEFAULT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `PHOTO_ID` (`PHOTO_ID`),
  KEY `USER_ID` (`USER_ID`),
  KEY `ALBUM_ID` (`ALBUM_ID`),
  CONSTRAINT `urser_photo_ibfk_1` FOREIGN KEY (`USER_ID`) REFERENCES `user_info` (`USER_ID`),
  CONSTRAINT `urser_photo_ibfk_2` FOREIGN KEY (`ALBUM_ID`) REFERENCES `user_album` (`ALBUM_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `urser_photo`
--

LOCK TABLES `urser_photo` WRITE;
/*!40000 ALTER TABLE `urser_photo` DISABLE KEYS */;
/*!40000 ALTER TABLE `urser_photo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_album`
--

DROP TABLE IF EXISTS `user_album`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_album` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `ALBUM_ID` varchar(100) NOT NULL DEFAULT concat('A',date_format(curdate(),'%Y%m'),'_',replace(uuid(),'-','')),
  `USER_ID` varchar(100) NOT NULL,
  `ALBUM_NAME` varchar(100) NOT NULL,
  `ALBUM_CATEGORY` enum('life','work','food','interest') NOT NULL,
  `ALBUM_STATUS` enum('1','2') NOT NULL,
  `CREATE_ID` varchar(100) NOT NULL,
  `CREATE_TIME` datetime NOT NULL DEFAULT sysdate(),
  `REVISE_ID` varchar(100) NOT NULL,
  `REVISE_TIME` datetime DEFAULT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `ALBUM_ID` (`ALBUM_ID`),
  KEY `USER_ID` (`USER_ID`),
  CONSTRAINT `user_album_ibfk_1` FOREIGN KEY (`USER_ID`) REFERENCES `user_info` (`USER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_album`
--

LOCK TABLES `user_album` WRITE;
/*!40000 ALTER TABLE `user_album` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_album` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_friend`
--

DROP TABLE IF EXISTS `user_friend`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_friend` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `RELATIONSHIP_ID` varchar(100) NOT NULL DEFAULT concat('RE',date_format(curdate(),'%Y%m'),'_',replace(uuid(),'-','')),
  `USER_ID` varchar(100) NOT NULL,
  `FRIEND_ID` varchar(100) NOT NULL,
  `FRIEND_PHOTO` varchar(200) NOT NULL,
  `FRIEND_POSTID` varchar(100) NOT NULL,
  `FRIEND_ALBUMID` varchar(100) NOT NULL,
  `CREATE_ID` varchar(100) NOT NULL,
  `CREATE_TIME` datetime NOT NULL DEFAULT sysdate(),
  `REVISE_ID` varchar(100) NOT NULL,
  `REVISE_TIME` datetime DEFAULT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `RELATIONSHIP_ID` (`RELATIONSHIP_ID`),
  KEY `USER_ID` (`USER_ID`),
  KEY `FRIEND_ID` (`FRIEND_ID`),
  KEY `FRIEND_ALBUMID` (`FRIEND_ALBUMID`),
  CONSTRAINT `user_friend_ibfk_1` FOREIGN KEY (`USER_ID`) REFERENCES `user_info` (`USER_ID`),
  CONSTRAINT `user_friend_ibfk_2` FOREIGN KEY (`FRIEND_ID`) REFERENCES `user_info` (`USER_ID`),
  CONSTRAINT `user_friend_ibfk_3` FOREIGN KEY (`FRIEND_ALBUMID`) REFERENCES `user_album` (`ALBUM_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_friend`
--

LOCK TABLES `user_friend` WRITE;
/*!40000 ALTER TABLE `user_friend` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_friend` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_info`
--

DROP TABLE IF EXISTS `user_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_info` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `USER_ID` varchar(100) NOT NULL,
  `USER_NAME` varchar(100) NOT NULL,
  `GENDER` enum('M','F','X') NOT NULL,
  `USER_MAIL` varchar(200) NOT NULL,
  `USER_TOKEN` varchar(2000) DEFAULT 'replace(uuid(),''-'','''')',
  `USER_ADDRESS` varchar(300) NOT NULL,
  `USER_BIRTHDAY` date NOT NULL,
  `USER_PHONE` varchar(100) NOT NULL,
  `PHOTO_STICKERS` varchar(300) NOT NULL,
  `USER_STATUS` enum('1','2') NOT NULL,
  `CREATE_ID` varchar(100) NOT NULL,
  `CREATE_TIME` datetime NOT NULL DEFAULT sysdate(),
  `REVISE_ID` varchar(100) NOT NULL,
  `REVISE_TIME` datetime DEFAULT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `USER_ID` (`USER_ID`),
  UNIQUE KEY `USER_MAIL` (`USER_MAIL`),
  CONSTRAINT `CHK_USER_PHONE` CHECK (`USER_PHONE` regexp '[^0-9]' = 0),
  CONSTRAINT `CHK_USER_MAIL` CHECK (`USER_MAIL` regexp '[a-zA-Z0-9_-]+@([a-zA-Z0-9_-]+.)+(com|org|edu)' = 1)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_info`
--

LOCK TABLES `user_info` WRITE;
/*!40000 ALTER TABLE `user_info` DISABLE KEYS */;
INSERT INTO `user_info` VALUES (1,'123','123','X','m123456@gmail.com','123','123','2022-01-01','0963123456','123','1','','2022-06-22 01:20:14','',NULL);
/*!40000 ALTER TABLE `user_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_post`
--

DROP TABLE IF EXISTS `user_post`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_post` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `POST_ID` varchar(100) NOT NULL DEFAULT concat('PO',date_format(curdate(),'%Y%m'),'_',replace(uuid(),'-','')),
  `USER_ID` varchar(100) NOT NULL,
  `POST_PHOTO` varchar(200) NOT NULL,
  `POST_DESC` varchar(200) NOT NULL,
  `POST_STATUS` enum('1','2') NOT NULL,
  `CREATE_ID` varchar(100) NOT NULL,
  `CREATE_TIME` datetime NOT NULL DEFAULT sysdate(),
  `REVISE_ID` varchar(100) NOT NULL,
  `REVISE_TIME` datetime DEFAULT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `POST_ID` (`POST_ID`),
  KEY `USER_ID` (`USER_ID`),
  CONSTRAINT `user_post_ibfk_1` FOREIGN KEY (`USER_ID`) REFERENCES `user_info` (`USER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_post`
--

LOCK TABLES `user_post` WRITE;
/*!40000 ALTER TABLE `user_post` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_post` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'rongtingsocialsoftware'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-06-22 11:27:01
