-- MySQL dump 10.13  Distrib 5.7.19, for Win64 (x86_64)
--
-- Host: localhost    Database: intelligentdorm
-- ------------------------------------------------------
-- Server version	5.7.19-log

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
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `admin` (
  `admin_id` int(11) NOT NULL AUTO_INCREMENT,
  `admin_username` varchar(45) DEFAULT 'moyu',
  `admin_password` varchar(45) DEFAULT '1234',
  `admin_name` varchar(45) DEFAULT 'bob',
  `admin_sex` varchar(45) DEFAULT '男',
  `admin_tel` varchar(45) DEFAULT '未知',
  PRIMARY KEY (`admin_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` VALUES (1,'moyu','1234','nice','男','未知'),(2,'好的','1234','bob','男','未知');
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `building`
--

DROP TABLE IF EXISTS `building`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `building` (
  `building_id` int(11) NOT NULL AUTO_INCREMENT,
  `building_name` varchar(45) DEFAULT '未填写名称',
  `building_introduction` varchar(45) DEFAULT '暂无介绍',
  PRIMARY KEY (`building_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `building`
--

LOCK TABLES `building` WRITE;
/*!40000 ALTER TABLE `building` DISABLE KEYS */;
INSERT INTO `building` VALUES (1,'nice','暂无介绍'),(2,'\'厚德\'','暂无介绍'),(3,'asdf','暂无介绍'),(4,'hlsjdfl','暂无介绍'),(5,'werfds','暂无介绍');
/*!40000 ALTER TABLE `building` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `domitory`
--

DROP TABLE IF EXISTS `domitory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `domitory` (
  `domitory_id` int(11) NOT NULL AUTO_INCREMENT,
  `domitory_buildingid` int(11) NOT NULL,
  `domitory_name` varchar(45) DEFAULT '未命名',
  `domitory_type` varchar(45) DEFAULT '未知',
  `domitory_number` varchar(100) DEFAULT '未排序',
  `domitory_tel` varchar(45) DEFAULT '暂无',
  PRIMARY KEY (`domitory_id`),
  KEY `buildingid_idx` (`domitory_buildingid`),
  CONSTRAINT `buildingid` FOREIGN KEY (`domitory_buildingid`) REFERENCES `building` (`building_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `domitory`
--

LOCK TABLES `domitory` WRITE;
/*!40000 ALTER TABLE `domitory` DISABLE KEYS */;
INSERT INTO `domitory` VALUES (1,1,'知己公寓','未知','未排序','暂无'),(2,1,'未命名','未知','未排序','暂无'),(3,1,'未命名','未知','未排序','暂无'),(4,1,'五四','厉害','123','75997'),(5,2,'234','玩儿','662','65465');
/*!40000 ALTER TABLE `domitory` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `maintain`
--

DROP TABLE IF EXISTS `maintain`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `maintain` (
  `maintain_id` int(11) NOT NULL AUTO_INCREMENT,
  `domitory_id` int(11) NOT NULL,
  `maintain_time` varchar(45) NOT NULL,
  `status` varchar(45) DEFAULT '未解决',
  PRIMARY KEY (`maintain_id`),
  KEY `fk_dom_id_idx` (`domitory_id`),
  CONSTRAINT `fk_dom_id` FOREIGN KEY (`domitory_id`) REFERENCES `domitory` (`domitory_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `maintain`
--

LOCK TABLES `maintain` WRITE;
/*!40000 ALTER TABLE `maintain` DISABLE KEYS */;
INSERT INTO `maintain` VALUES (2,1,'sadf','未解决');
/*!40000 ALTER TABLE `maintain` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `out`
--

DROP TABLE IF EXISTS `out`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `out` (
  `out_id` int(11) NOT NULL AUTO_INCREMENT,
  `out_studentid` varchar(45) NOT NULL,
  `out_date` varchar(45) NOT NULL,
  `out_remark` varchar(45) DEFAULT '暂无',
  PRIMARY KEY (`out_id`),
  KEY `fk_studentid_idx` (`out_studentid`),
  CONSTRAINT `fk_studentid` FOREIGN KEY (`out_studentid`) REFERENCES `student` (`student_username`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `out`
--

LOCK TABLES `out` WRITE;
/*!40000 ALTER TABLE `out` DISABLE KEYS */;
INSERT INTO `out` VALUES (3,'12385231','Sat Mar 17 2018 12:05:59 GMT+0800','可以'),(4,'152100666','Thu Mar 15 2018 11:01:14 GMT+0800','还行'),(6,'152100666','Sat Mar 17 2018 11:20:49 GMT+0800','批准'),(7,'123456','Sat Mar 17 2018 11:45:04 GMT+0800','还来'),(8,'123456','2018-06-19','不错'),(9,'123456','Thu Mar 08 2018 12:44:24 GMT+0800','梵蒂冈和豆腐干'),(10,'123456','Thu Mar 01 2018 12:51:41 GMT+0800','批准'),(12,'123456','Fri Mar 16 2018 15:59:42 GMT+0800','ad');
/*!40000 ALTER TABLE `out` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `power`
--

DROP TABLE IF EXISTS `power`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `power` (
  `power_id` int(11) NOT NULL AUTO_INCREMENT,
  `totalconsumption` double DEFAULT '0',
  `subsidyconsumption` double DEFAULT '0',
  `payconsumption` double DEFAULT '0',
  `freeconsumption` double DEFAULT '0',
  `price` double DEFAULT '0',
  `power_building_id` int(11) NOT NULL,
  PRIMARY KEY (`power_id`),
  KEY `pk_power_buildingid_idx` (`power_building_id`),
  CONSTRAINT `fk_pbuildingid` FOREIGN KEY (`power_building_id`) REFERENCES `building` (`building_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `power`
--

LOCK TABLES `power` WRITE;
/*!40000 ALTER TABLE `power` DISABLE KEYS */;
INSERT INTO `power` VALUES (2,0,1,0,0,0,1);
/*!40000 ALTER TABLE `power` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student` (
  `student_username` varchar(70) NOT NULL DEFAULT '1',
  `student_domitoryid` int(11) NOT NULL,
  `student_password` varchar(45) DEFAULT '123456',
  `student_name` varchar(45) DEFAULT '未知名字',
  `student_sex` varchar(45) DEFAULT '男',
  `student_class` varchar(45) DEFAULT '未知班级',
  `student_state` varchar(45) DEFAULT '正常',
  PRIMARY KEY (`student_username`),
  KEY `fk_domitoryid_idx` (`student_domitoryid`),
  CONSTRAINT `fk_domitoryid` FOREIGN KEY (`student_domitoryid`) REFERENCES `domitory` (`domitory_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` VALUES ('123456',1,'564','大师傅','男','546','发的'),('12385231',1,'231654','我饿','男','上的','大师傅'),('152100666',1,'123456','墨雨','男','未知班级','未知状态'),('15478553',1,'1321','热天','男','564','132');
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-03-17 13:14:54
