-- MySQL dump 10.13  Distrib 8.0.12, for Win64 (x86_64)
--
-- Host: localhost    Database: library
-- ------------------------------------------------------
-- Server version	8.0.12

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
-- Table structure for table `addbook`
--

DROP TABLE IF EXISTS `addbook`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `addbook` (
  `bookid` int(11) NOT NULL,
  `bookname` varchar(45) DEFAULT NULL,
  `author` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`bookid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `addbook`
--

LOCK TABLES `addbook` WRITE;
/*!40000 ALTER TABLE `addbook` DISABLE KEYS */;
INSERT INTO `addbook` VALUES (1000,'DS','Rajesh Shukla'),(1001,'java','Mohan Das'),(5645,'c++','Dr. Das');
/*!40000 ALTER TABLE `addbook` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `admin` (
  `idadmin` int(10) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) DEFAULT NULL,
  `password` varchar(45) NOT NULL,
  `contact` varchar(45) DEFAULT NULL,
  `address` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idadmin`),
  UNIQUE KEY `username_UNIQUE` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` VALUES (1,'dhee','123','9752715248','Bhopal'),(2,'abc','1234','asdfghgf','sdfg'),(13,'deepak','123','882493595','bhopal'),(14,'Vashu','12345','987576754','bhopal');
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `essued`
--

DROP TABLE IF EXISTS `essued`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `essued` (
  `bookid` int(11) NOT NULL,
  `bookname` varchar(45) DEFAULT NULL,
  `author` varchar(45) DEFAULT NULL,
  `Essued_date` date DEFAULT NULL,
  PRIMARY KEY (`bookid`),
  UNIQUE KEY `bookid_UNIQUE` (`bookid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `essued`
--

LOCK TABLES `essued` WRITE;
/*!40000 ALTER TABLE `essued` DISABLE KEYS */;
INSERT INTO `essued` VALUES (1111,'java','Rk Jain','2019-02-18'),(1115,'java','M Preasad','2019-02-17'),(1118,'java','maha','2019-02-17'),(1123,'sql','games','2019-02-17'),(1134,'c','mohit','2018-12-12'),(1137,'java','Rakesh','2019-02-16'),(1158,'c++','D.K. Jain','2019-01-11'),(1233,'c','Dr. Deshmukh','2017-12-23'),(1234,'.net','Mohit','2019-02-16'),(1245,'c++','PS','2019-02-16'),(1324,'c','R.P. Singh','2019-02-17'),(1326,'.net','rohit','2019-02-17'),(1435,'python','Ram','2019-02-16'),(2123,'.net','Goyal','2019-02-16'),(3423,'python','R.K Jain','2019-02-17');
/*!40000 ALTER TABLE `essued` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `librarian`
--

DROP TABLE IF EXISTS `librarian`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `librarian` (
  `idlibrarian` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `contact` varchar(45) DEFAULT NULL,
  `address` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idlibrarian`),
  UNIQUE KEY `username_UNIQUE` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `librarian`
--

LOCK TABLES `librarian` WRITE;
/*!40000 ALTER TABLE `librarian` DISABLE KEYS */;
INSERT INTO `librarian` VALUES (1,'abhi','123','9754348448','bhopal'),(11,'Gaurav','12345','8679565454','sehore');
/*!40000 ALTER TABLE `librarian` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-02-20 20:44:48
