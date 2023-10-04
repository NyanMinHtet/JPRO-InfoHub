-- MySQL dump 10.13  Distrib 8.0.33, for Win64 (x86_64)
--
-- Host: localhost    Database: jpro_infohub
-- ------------------------------------------------------
-- Server version	8.0.33

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
-- Table structure for table `account`
--

DROP TABLE IF EXISTS `account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `account` (
  `User_Id` int NOT NULL AUTO_INCREMENT,
  `User_Name` varchar(50) DEFAULT NULL,
  `Password` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`User_Id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account`
--

LOCK TABLES `account` WRITE;
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
INSERT INTO `account` VALUES (1,'Admin123','admin'),(2,'Hmue Hmue','@%08');
/*!40000 ALTER TABLE `account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `address`
--

DROP TABLE IF EXISTS `address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `address` (
  `Aid` int NOT NULL AUTO_INCREMENT,
  `Std_id` int DEFAULT NULL,
  `Region` varchar(30) DEFAULT NULL,
  `City` varchar(50) DEFAULT NULL,
  `Township` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`Aid`),
  KEY `Std_id` (`Std_id`),
  CONSTRAINT `address_ibfk_1` FOREIGN KEY (`Std_id`) REFERENCES `student` (`Std_id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `address`
--

LOCK TABLES `address` WRITE;
/*!40000 ALTER TABLE `address` DISABLE KEYS */;
INSERT INTO `address` VALUES (1,1,'Yangon','Yangon','Laekuu'),(2,2,'Yangon','Yangon','Insein'),(3,3,'Yangon','Yangon','Insein'),(4,4,'Yangon','Yangon','Dala'),(5,5,'Yangon','Yangon','Insein'),(6,6,'Yangon','Yangon','North Dagon'),(7,7,'Yangon','Yangon','Dagon'),(8,8,'Mandalay','Nay Pyi Taw','Laeway'),(9,9,'Yangon','Yangon','North Dagon'),(10,10,'Yangon','Yangon','Thanlyin'),(11,11,'Yangon','Yangon','Thanlyin'),(12,12,'Yangon','Yangon','South Dagon'),(13,13,'Yangon','Yangon','Insein'),(14,14,'Yangon','Yangon','Thanlyin'),(15,15,'Yangon','Yangon','Insein'),(16,16,'Sagaing','Monywa','Monywa'),(17,17,'Yangon','Yangon','Hlaing'),(18,18,'Rakhine','Ann','Ann'),(19,19,'Irrawaddy','Ye Kyi','Athoke'),(20,20,'Yangon','Yangon','Dala'),(21,21,'Yangon','Yangon','East Dagon'),(22,22,'Bago','Pyay','Pyay');
/*!40000 ALTER TABLE `address` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `batch`
--

DROP TABLE IF EXISTS `batch`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `batch` (
  `Batch_id` int NOT NULL AUTO_INCREMENT,
  `Batch_Name` varchar(30) DEFAULT NULL,
  `Course_id` int DEFAULT NULL,
  `Start_date` date DEFAULT NULL,
  `Description` varchar(300) DEFAULT NULL,
  PRIMARY KEY (`Batch_id`),
  KEY `Course_id` (`Course_id`),
  CONSTRAINT `batch_ibfk_1` FOREIGN KEY (`Course_id`) REFERENCES `course` (`Course_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `batch`
--

LOCK TABLES `batch` WRITE;
/*!40000 ALTER TABLE `batch` DISABLE KEYS */;
INSERT INTO `batch` VALUES (2,'IT-Batch0',1,'2023-07-01','This is for all batches.'),(3,'IT-Batch1',1,'2022-06-02','IT Professional First Batch of JPro'),(4,'IT-Batch2',1,'2022-07-04','- IT Professional Second Batch of JPro'),(5,'IT-Batch3',1,'2022-12-01','- IT Professional Third Batch of JPro'),(6,'IT-Batch4',1,'2023-02-07','- IT Professional Fouth Batch of JPro'),(7,'IT-Batch5',1,'2023-04-03','- IT Professional Fifth Batch of JPro'),(8,'IT-Batch6',1,'2023-10-02','- IT Professional Sixth Batch of JPro');
/*!40000 ALTER TABLE `batch` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `batch_member`
--

DROP TABLE IF EXISTS `batch_member`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `batch_member` (
  `Bm_id` int NOT NULL AUTO_INCREMENT,
  `Batch_id` int DEFAULT NULL,
  `Std_id` int DEFAULT NULL,
  `Join_date` date DEFAULT NULL,
  PRIMARY KEY (`Bm_id`),
  KEY `Std_id` (`Std_id`),
  KEY `Batch_id` (`Batch_id`),
  CONSTRAINT `batch_member_ibfk_1` FOREIGN KEY (`Std_id`) REFERENCES `student` (`Std_id`),
  CONSTRAINT `batch_member_ibfk_2` FOREIGN KEY (`Batch_id`) REFERENCES `batch` (`Batch_id`),
  CONSTRAINT `batch_member_ibfk_3` FOREIGN KEY (`Batch_id`) REFERENCES `batch` (`Batch_id`)
) ENGINE=InnoDB AUTO_INCREMENT=61 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `batch_member`
--

LOCK TABLES `batch_member` WRITE;
/*!40000 ALTER TABLE `batch_member` DISABLE KEYS */;
INSERT INTO `batch_member` VALUES (2,3,1,'2022-06-02'),(3,3,2,'2022-06-02'),(4,3,3,'2022-06-02'),(5,3,4,'2022-06-02'),(6,3,5,'2022-06-02'),(7,3,6,'2022-06-02'),(8,3,7,'2022-06-02'),(9,3,8,'2022-06-02'),(10,3,9,'2022-06-02'),(11,3,10,'2022-06-02'),(12,3,11,'2022-06-02'),(13,3,12,'2022-06-02'),(14,3,13,'2022-06-02'),(15,3,14,'2022-06-02'),(16,3,15,'2022-06-02'),(17,3,16,'2022-06-02'),(18,4,17,'2022-07-04'),(19,4,18,'2022-07-04'),(20,4,19,'2022-07-04'),(21,4,20,'2022-07-04'),(22,4,21,'2022-07-04'),(23,4,22,'2022-07-04');
/*!40000 ALTER TABLE `batch_member` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `batch_teacher`
--

DROP TABLE IF EXISTS `batch_teacher`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `batch_teacher` (
  `Bt_id` int NOT NULL AUTO_INCREMENT,
  `Batch_id` int DEFAULT NULL,
  `Tid` int DEFAULT NULL,
  `subid` int DEFAULT NULL,
  PRIMARY KEY (`Bt_id`),
  KEY `Batch_id` (`Batch_id`),
  KEY `Tid` (`Tid`),
  KEY `subid` (`subid`),
  CONSTRAINT `batch_teacher_ibfk_1` FOREIGN KEY (`Batch_id`) REFERENCES `batch` (`Batch_id`),
  CONSTRAINT `batch_teacher_ibfk_2` FOREIGN KEY (`Tid`) REFERENCES `teacher` (`Tid`),
  CONSTRAINT `batch_teacher_ibfk_3` FOREIGN KEY (`subid`) REFERENCES `subject` (`subid`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `batch_teacher`
--

LOCK TABLES `batch_teacher` WRITE;
/*!40000 ALTER TABLE `batch_teacher` DISABLE KEYS */;
INSERT INTO `batch_teacher` VALUES (1,3,2,1),(2,3,3,2),(3,3,1,3),(4,3,4,3),(5,3,3,4),(6,3,1,5),(7,3,2,6),(8,3,3,7),(9,3,1,8),(10,3,4,8),(11,3,4,9),(12,3,1,11),(13,3,7,13),(14,3,7,14),(15,3,7,15),(16,3,10,16),(17,3,10,17),(18,3,10,18),(19,3,11,19),(20,3,11,20),(21,3,11,21),(22,4,2,1),(23,4,3,2),(24,4,1,3),(25,4,4,3),(26,4,3,4),(27,4,1,5),(28,4,2,6),(29,4,3,7),(30,4,1,8),(31,4,4,8),(32,4,4,9),(33,4,1,11),(34,4,7,13),(35,4,7,14),(36,4,7,15),(37,4,10,16),(38,4,10,17),(39,4,10,18),(40,4,11,19),(41,4,11,20),(42,4,11,21);
/*!40000 ALTER TABLE `batch_teacher` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `course`
--

DROP TABLE IF EXISTS `course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `course` (
  `Course_id` int NOT NULL AUTO_INCREMENT,
  `Course_no` varchar(30) DEFAULT NULL,
  `Course_name` varchar(100) DEFAULT NULL,
  `Course_desc` varchar(300) DEFAULT NULL,
  `Duration` varchar(20) DEFAULT NULL,
  `Fees` int DEFAULT NULL,
  PRIMARY KEY (`Course_id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course`
--

LOCK TABLES `course` WRITE;
/*!40000 ALTER TABLE `course` DISABLE KEYS */;
INSERT INTO `course` VALUES (1,'IT-Course1','IT Professional Course','- ITPEC Exam Preparation Course (IP, FE\nLevel)\n- Database Programming\n- Java Programming\n- Web Programming and Applicatons (HTML, CSS, Java script, PHP)','1year 6 months',3900000),(2,'IT-Course2','Online IP Exam Preparation','- ITPEC Exam Preparation Course (IP Level)\r ','4 months',400000),(3,'IT-Course3','IT Professional Course  IT Only','-ITPEC Exam Preparation (IT only) ','1year 3months',2500000),(4,'IT-Course4','Online FE Exam Preparation','-ITPEC Exam Preparation(FE only) ','4 months',600000),(5,'JP-Course1','Japanese OQ Practice','-JLPT Old question exam preparation','2 months',150000),(6,'JP-Course2','Online Japanese Basic-I Class (N5 Level- 4 Skills)','- Hiragana\n- Katakana\n- Basic Kaiwa &  Boupou Practice','4 months',150000),(7,'JP-Course3','Online Japanese Speaking  Class  (N3 Level-4 Skills)','- N3 level Hiragana \n- N3 level Katakana \n- Inter levle Kaiwa & Boupou Practice','4 months',250000),(8,'JP-Course4','Japanese Speaking Class (Pre- Inter)','- N-4 Level  Kaiwa & Boupou Practice','4 months',150000),(9,'JP-Course5','Japanese Speaking Class (Inter)','-N-3 Level Kaiwa &  Boupou Practice','4 months',200000),(10,'JP-Course6','Japanese Basic-I Class  (N5 Level- 4 Skills)','- Hiragana \n- Katakana \n- Basic Kaiwa Boupou Practice\n- Old Question Exam preparation','4 months',180000),(11,'JP-Course7','Japanese Basic-II Class (N4 Level- 4 Skills)','- Hiragana \n- Katakana \n- Basic Kaiwa Boupou Practice\n- Old Question Exam Preparation','4 months',200000),(12,'JP-Course8','Japanese Intermediate Class ( N3 Level - 4 Skills Course )','- Hiragana \n- Katakana \n- Basic Kaiwa Boupou Practice\n- Old Question Exam Practice','4 months',240000),(13,'JP-Course9','Japanese Advance Class (N2 Level - 4 Skills Course)','- Hiragana \n- Katakana \n- Basic Kaiwa Boupou Practice\n- Old Question Exam Practice','4 months',280000),(14,'JP-Course10','Japanese Language School Class','Japanese Basic I , II, Inter, Advance level\n- Hiragana \n- Katakana \n- Basic Kaiwa Boupou Practice\n- Old Question Exam Practice','16 months',850000);
/*!40000 ALTER TABLE `course` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `payment`
--

DROP TABLE IF EXISTS `payment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `payment` (
  `Pay_id` int NOT NULL AUTO_INCREMENT,
  `Bm_id` int DEFAULT NULL,
  `Payment_date` date DEFAULT NULL,
  `Amount` varchar(20) DEFAULT NULL,
  `Discount` varchar(20) DEFAULT NULL,
  `Payment_method` varchar(30) DEFAULT NULL,
  `Payperson_info` varchar(30) DEFAULT NULL,
  `Payment_desc` varchar(50) DEFAULT NULL,
  `Remark` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`Pay_id`),
  KEY `Bm_id` (`Bm_id`),
  CONSTRAINT `payment_ibfk_1` FOREIGN KEY (`Bm_id`) REFERENCES `batch_member` (`Bm_id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `payment`
--

LOCK TABLES `payment` WRITE;
/*!40000 ALTER TABLE `payment` DISABLE KEYS */;
INSERT INTO `payment` VALUES (4,2,'2022-06-28','3000000','900000','Cash','','','First Student of JPRO'),(5,3,'2022-07-04','3200000','700000','Cash','','','Discount Student'),(6,4,'2022-07-15','3200000','700000','KBZ Pay','Pyae Sone Kyaw','','Discount Student'),(7,5,'2022-07-08','3900000','0','Cash',NULL,NULL,NULL),(8,6,'2022-07-02','3900000','0','Cash',NULL,NULL,NULL),(9,7,'2022-07-15','3000000','900000','Cash',NULL,NULL,'Discount Student'),(10,8,'2022-07-01','0','3900000',NULL,NULL,NULL,'Scholarship Student'),(11,9,'2022-07-14','3900000','0','KBZ Pay','U Win Naing Moe','School Payment',NULL),(12,10,'2022-07-08','3900000','0','Cash',NULL,NULL,NULL),(13,11,'2022-07-15','3200000','700000','Cash',NULL,NULL,'Discount Student'),(14,12,'2022-07-15','3200000','700000','Cash',NULL,NULL,'Discount Student'),(15,13,'2022-07-01','3200000','700000','Cash',NULL,NULL,'Discount Student'),(16,14,'2022-07-08','3200000','700000','Cash',NULL,NULL,'Discount Student'),(17,15,'2022-07-18','3900000','0','AGD Bank','U Paye Soe','School Payment',NULL),(18,16,'2022-07-20','3900000','0','KBZ Bank','Daw Aye Aye Kyu','School Payment',NULL),(19,17,'2022-07-21','3900000','0','KBZ Bank','Daw Saw Yu Khine','School Payment',NULL),(20,18,'2022-08-03','3900000','0','Cash',NULL,NULL,NULL),(21,19,'2022-08-14','3900000','0','KBZ Bank','Daw Aye Aye Thein','School Payment',NULL),(22,20,'2022-08-07','3900000','0','Cash',NULL,NULL,NULL),(23,21,'2022-08-05','3900000','0','Cash',NULL,NULL,NULL),(24,22,'2022-08-05','3900000','0','KBZ Bank','U Thein Naing','School Payment',NULL),(25,23,'2022-08-12','3200000','700000','KBZ Bank','U Soe Naing Oo','School Payment','Discount Student');
/*!40000 ALTER TABLE `payment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `qualification`
--

DROP TABLE IF EXISTS `qualification`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `qualification` (
  `Qid` int NOT NULL AUTO_INCREMENT,
  `Std_id` int DEFAULT NULL,
  `Dname` varchar(50) DEFAULT NULL,
  `Field_name` varchar(300) DEFAULT NULL,
  `Org_name` varchar(100) DEFAULT NULL,
  `Type` varchar(30) DEFAULT NULL,
  `From_date` date DEFAULT NULL,
  `To_date` date DEFAULT NULL,
  PRIMARY KEY (`Qid`),
  KEY `Std_id` (`Std_id`),
  CONSTRAINT `qualification_ibfk_1` FOREIGN KEY (`Std_id`) REFERENCES `student` (`Std_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `qualification`
--

LOCK TABLES `qualification` WRITE;
/*!40000 ALTER TABLE `qualification` DISABLE KEYS */;
INSERT INTO `qualification` VALUES (1,1,'B.A(English)','English ','Dagon University','Degree','2020-07-26','2023-07-23'),(2,2,'B.Tech.Ec','Electrical Engineering','Government of Technical Institute','Degree','2018-06-01','2020-04-02'),(3,3,'Btech EC','Electronic Communication','TU(Mawlamyine)','Degree','2016-07-20','2018-08-17'),(4,4,'BA(English)','English','West Yangon University','Degree','2016-07-08','2021-07-23'),(5,4,'Cicso Networking','Networking','Cicso','Certificate','2022-07-08','2023-07-21'),(6,5,'B.Sc(Computer)','Programming','KMD Computer Training','Degree','2022-08-07','2023-07-23');
/*!40000 ALTER TABLE `qualification` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `relationship`
--

DROP TABLE IF EXISTS `relationship`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `relationship` (
  `rRid` int NOT NULL AUTO_INCREMENT,
  `Std_id` int DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `phno` varchar(20) DEFAULT NULL,
  `occupation` varchar(100) DEFAULT NULL,
  `rs_type` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`rRid`),
  KEY `Std_id` (`Std_id`),
  CONSTRAINT `relationship_ibfk_1` FOREIGN KEY (`Std_id`) REFERENCES `student` (`Std_id`)
) ENGINE=InnoDB AUTO_INCREMENT=54 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `relationship`
--

LOCK TABLES `relationship` WRITE;
/*!40000 ALTER TABLE `relationship` DISABLE KEYS */;
INSERT INTO `relationship` VALUES (1,1,'U Soe Naing','09967385872','Carry Driver','Father'),(2,1,'Daw Phyu Phyu Aye','           -','       Death','Mother'),(3,2,'U Myo Swe','09254515651','         -','Father'),(4,2,'Daw Aye Aye Kyi','09254515651','Monthingar Shop','Mother'),(5,3,'U Than Kyaw Htay','09425154496','Poe Poe grocery store','Father'),(6,3,'Daw Myint Myint Shwe','09425154496','Poe Poe grocery store','Mother'),(7,4,'U Aung Moe Win','09784869930','Grocery store','Father'),(8,4,'Daw Than Than Soe','09784869930','Grocery store','Mother'),(9,5,'U Min Lwin','09954700741','Moe Goke Reasturant','Father'),(10,5,'Daw Win Mar Cho','09954700741','Moe Goke Reasturant','Mother'),(11,6,'U Aung Kyaw Oo','09440061757','Agent of Worth Service Co.,Ltd.','Father'),(12,6,'Daw Soe Soe Khine','09440061757','House Wife','Father'),(13,7,'U Kyaw Myo Naing','09952607724','Church staff','Father'),(14,7,'Daw Pathi Phaw','09952607724','Church staff','Mother'),(15,8,'U Win Naing Moe','09671206608','Driver','Father'),(16,8,'Daw Khin Than Aye','09671206608','Grocery store','Mother'),(17,9,'U Myo Min Thaung','        -','         Death','Father'),(18,9,'Daw Mi Mi Aung','09777717082','Taxi Owner','Mother'),(19,10,'U Myin Shwe','097999435023','U Lay Gyi Construction','Father'),(20,10,'Daw Yi Yi Win','09972473376','House Wife','Mother'),(21,11,'U Myin Shwe','097999435023','U Lay Gyi Construction','Father'),(22,11,'Daw Yi Yi Win','09972473376','House Wife','Mother'),(23,12,'U Theinga Aung','         -','Seaman','Father'),(24,12,'Daw Thida Htut','09771363151','House Wife','Mother'),(25,13,'U Kyaw Soe Win','09970254538','Driver','Father'),(26,13,'Daw Hnin Hnin Ei','09970254538','Garment','Mother'),(27,14,'U Paye Soe','09799438945','Staff','Father'),(28,14,'Daw Win Mar Kyaing','09254528607','Staff','Mother'),(29,15,'U Htun Htun Aung','0943163780','Car trade','Father'),(30,15,'Daw Aye Aye Kyu','09973631936','House Wife','Mother'),(31,16,'U Thein Zaw Win','09761712452','Golden business','Father'),(32,16,'Daw Saw Yu Khine','09761712452','House Wife','Mother'),(33,17,'U Nay Win Aung','09971415765','Landscaping Designer','Father'),(34,17,'Daw Tin Myo Kyi','09971415765','House Wife','Mother'),(35,18,'U Maung Win Shwe','09893961024','Aquaculture trading','Father'),(36,18,'Daw Aye Aye Thein','09893961024','House Wife','Mother'),(37,19,'U Aye Naing','09965531955','Bicycle Trading','Father'),(38,19,'Daw Phyu Sin Htun','09422445757','House Wife','Mother'),(39,20,'U Aung Lwin','09774979847','Bank Staff','Father'),(40,20,'Daw Khaing Soe Thet','09986852107','House Wife','Mother'),(41,21,'U Thein Naing','09772283994','Trade in rice oil','Father'),(42,21,'Daw Htet Htet Linn','09772283994','House Wife','Mother'),(43,22,'U Soe Naing Oo','09768249739','Grocery store/flower shop','Father'),(44,22,'Daw Aye Cho Hnin','09958349189','Grocery store/flower shop','Mother');
/*!40000 ALTER TABLE `relationship` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student` (
  `Std_id` int NOT NULL AUTO_INCREMENT,
  `std_no` varchar(20) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `DoB` date DEFAULT NULL,
  `Email` varchar(50) DEFAULT NULL,
  `Ph_no` varchar(20) DEFAULT NULL,
  `Gender` varchar(20) DEFAULT NULL,
  `Religion` varchar(40) DEFAULT NULL,
  `NRC` varchar(20) DEFAULT NULL,
  `Nationality` varchar(15) DEFAULT NULL,
  `Telegram` varchar(20) DEFAULT NULL,
  `Photo` varchar(300) DEFAULT NULL,
  PRIMARY KEY (`Std_id`)
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` VALUES (1,'IT-Std0001','Htet Wai Yan Zaw','2023-06-22','htetwaiyanzaw@gmail.com','09987362431','Male','Buddish','12/LAKUMA(N)023298','Myanmar','09987362431','C:\\Users\\Thet Mhue Aung\\OneDrive\\Documents\\NetBeansProjects\\Pj_info\\src\\StdImg\\26e75f8d2723100eeb13aaf3be154717.jpg'),(2,'IT-Std0002','Swan Htet Ye Nyi','2003-11-18','swamnyi@gmail.com','09485127563','Male','Buddish','12/KAPATA(N)154756','Myanmar','09485127563','D:\\JPRO\\JPRO Trip\\JPRO Trip\\IMG_0721.JPG'),(3,'IT-Std0003','Pyae Sone Kyaw Win','1998-05-28','runisn2016@gmail.com','09974471857','Male','Buddish','12/AhSaNa(N)234792','Myanmar','09968585851','C:\\Users\\MSI\\Documents\\temp20.png'),(4,'IT-Std0004','Pyae Phyo Hein','2008-07-18','geervin233@gmail.com','09968557447','Male','Buddish','12/DaLaNa(N)188261','Myanmar','09985569321','C:\\Users\\MSI\\Pictures\\Saved Pictures\\719805-4-4EEI3.png'),(5,'IT-Std0005','Tharaphee Htun','2002-06-18','tharaphee@gmail.com','09875421984','Female','Buddish','12/AhSaNa(N)264454','Myanmar','09875421984','C:\\Users\\Thet Mhue Aung\\OneDrive\\Documents\\NetBeansProjects\\Pj_info\\src\\StdImg\\719805-4-4EEI3.png'),(6,'IT-Std0006','Nyan Min Htet','2004-08-21','shotoaqua@gmail.com','09873657421','Male','Buddish','12/DaGaMa(N)057990','Myanmar','09873657421','C:\\Users\\MSI\\Pictures\\Saved Pictures\\719805-4-4EEI3.png'),(7,'IT-Std0007','Thi Htoo Naing','2004-10-23','samuascotth@gmail.com','09876643254','Male','Christian','9/PaOuLa(N)071965','Myanmar','09876643254','C:\\Users\\Thet Mhue Aung\\OneDrive\\Documents\\NetBeansProjects\\Pj_info\\src\\StdImg\\719805-4-4EEI3.png'),(8,'IT-Std0008','Aung Phone Naing','2006-03-17','aungphonenaing@gmail.com','09985476347','Male','Buddish','9/LaWaNa(N)272121','Myanmar','09985476347','C:\\Users\\MSI\\Pictures\\Saved Pictures\\719805-4-4EEI3.png'),(9,'IT-Std0009','Aung Min Khant','2001-03-13','aungminkhant@gmail.com','09834756342','Male','Buddish','12/DaGaMa(N)035553','Myanmar','09834756342','C:\\Users\\MSI\\Pictures\\Saved Pictures\\719805-4-4EEI3.png'),(10,'IT-Std0010','Htet Shwe Yi Win','2003-05-27','htetshweyiwin@gmail.com','09267846384','Female','Buddish','7/TaNgaNa(N)254948','Myanmar','09267846384','C:\\Users\\MSI\\Pictures\\Saved Pictures\\719805-4-4EEI3.png'),(11,'IT-Std0011','Win Min Nyi Nyi','2000-08-21','winminnyinyi@gmail.com','09987654387','Male','Buddish','7/TaNgaNa(N)195988','Myanmar','09987654387','C:\\Users\\MSI\\Pictures\\Saved Pictures\\719805-4-4EEI3.png'),(12,'IT-Std0012','Thet Mhue Aung','2002-08-25','thethmueaung.mr@gmail.com','09987207169','Male','Buddish','12/DaGata(N)094950','Myanmar','09987207269','C:\\Users\\MSI\\Pictures\\Saved Pictures\\719805-4-4EEI3.png'),(13,'IT-Std0013','Nyo Htet Win','2002-05-18','nyohtet@gmail.com','09972345763','Male','Buddish','12/AhSaNa(N)245653','Myanmar','09972345763','C:\\Users\\MSI\\Pictures\\Saved Pictures\\719805-4-4EEI3.png'),(14,'IT-Std0014','Swan Yi Htet','2003-07-21','swanyi@gmail.com','09263478654','Male','Buddish','12/ThaLaNa(N)143425','Myanmar','09263478654','C:\\Users\\MSI\\Pictures\\Saved Pictures\\719805-4-4EEI3.png'),(15,'IT-Std0015','Lin Aung Myat','2005-08-28','linaungmyat@gmail.com','09987653436','Male','Buddish','12/AhSaNa(N)263417','Myanmar','09987653436','C:\\Users\\MSI\\Pictures\\Saved Pictures\\719805-4-4EEI3.png'),(16,'IT-Std0016','Khaing Su Yin','2002-01-23','khaingsu@gmail.com','09748736485','Female','Buddish','5/MaYaNa(N)315489','Myanmar','09748736485','C:\\Users\\MSI\\Pictures\\Saved Pictures\\719805-4-4EEI3.png'),(17,'IT-Std0017','Kaung Si THu','2000-09-28','kaungsithu@gmail.com','09982374651','Male','Buddish','12/LaMaNa(N)157488','Myanmar','09982374651','C:\\Users\\MSI\\Pictures\\Saved Pictures\\719805-4-4EEI3.png'),(18,'IT-Std0018','Aye Aye Win','2000-11-23','ayewin@gmail.com','09893961024','Female','Buddish','11/AhMaNa(N)090156','Myanmar','09893961024','C:\\Users\\MSI\\Pictures\\Saved Pictures\\719805-4-4EEI3.png'),(19,'IT-Std0019','Pyae Pyae Phyoe Thaw','1999-06-28','pyaepyaephyoethaw@gmail.com','09875647832','Female','Buddish','14/YaKaNa(N)186350','Myanmar','09875647832','C:\\Users\\MSI\\Pictures\\Saved Pictures\\719805-4-4EEI3.png'),(20,'IT-Std0020','Banyar Min Thant','2004-09-07','minthant@gmail.com','09987654356','Male','Buddish','12/DaLaNa(N)094833','Myanmar','09987654356','C:\\Users\\MSI\\Pictures\\Saved Pictures\\719805-4-4EEI3.png'),(21,'IT-Std0021','Bhone Htet Naing','2004-11-18','davidjohnsanchit@gmail.com','09267846374','Male','Buddish','7/ThaNaPa(N)158054','Myanmar','09267846374','C:\\Users\\MSI\\Pictures\\Saved Pictures\\719805-4-4EEI3.png'),(22,'IT-Std0022','Su Pyae Soe Naing','2002-03-17','supyae@gmail.com','09785647387','Female','Buddish','7/PaTaNa(N)167528','Myanmar','09785647387','C:\\Users\\MSI\\Pictures\\Saved Pictures\\719805-4-4EEI3.png');
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subject`
--

DROP TABLE IF EXISTS `subject`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `subject` (
  `subid` int NOT NULL AUTO_INCREMENT,
  `Course_id` int DEFAULT NULL,
  `subject_Name` varchar(255) DEFAULT NULL,
  `Ref_Book` varchar(300) DEFAULT NULL,
  `Desc_Book` varchar(300) DEFAULT NULL,
  `Sub_No` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`subid`),
  KEY `Course_id` (`Course_id`),
  CONSTRAINT `subject_ibfk_1` FOREIGN KEY (`Course_id`) REFERENCES `course` (`Course_id`)
) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subject`
--

LOCK TABLES `subject` WRITE;
/*!40000 ALTER TABLE `subject` DISABLE KEYS */;
INSERT INTO `subject` VALUES (1,1,'IT Strategy','Information-Technology Promotion Agency,Japan','ITPEC Course IP Exam Text Book','ITP-Sub01'),(2,1,'IT Management','Information-Technology Promotion Agency,Japan','ITPEC Course IP Exam Text Book','ITP-Sub02'),(3,1,'IT Technology','Information-Technology Promotion Agency,Japan','ITPEC Course IP Exam Text Book','ITP-Sub03'),(4,1,'MySQL','Electrical FE Textbook & Full Exam','Required Database knowledge','ITP-Sub04'),(5,1,'Java Programming','javatpoint book,  The Complete Reference','Java Basic and Advance ','ITP-Sub05'),(6,1,'IT Strategy','Information-Technology Promotion Agency,Japan','ITPEC Course FE Vol 1. Exam Text Book','ITP-Sub06'),(7,1,'IT Management','Information-Technology Promotion Agency,Japan','ITPEC Course FE Vol 1. Exam Text Book','ITP-Sub07'),(8,1,'IT Technology','Information-Technology Promotion Agency,Japan','ITPEC Course FE Vol 2. Exam Text Book','ITP-Sub08'),(9,1,'Networking','Electrical FE Textbook & Full Exam','Required networking knowledge','ITP-Sub09'),(10,1,'Power BI','Microsoft Office 365 Courses','Office 365','ITP-Sub10'),(11,1,'Web Development','HTML CSS Java Script','JavaTpoint Book','ITP-Sub11'),(12,1,'Phython','Phyton Basic to Advance','','ITP-Sub12'),(13,1,'Interchange Fifth Edition Student\'s Book','www.irLanguage.com','interchange student\'s book','ITP-Sub13'),(14,1,'Interchange Fifth Edition Work\'s Book ','www.irLanguage.com','interchange work\'s book','ITP-Sub14'),(15,1,'English for Information Technology','Book by David Hill','Vocational English Course Book','ITP-Sub15'),(16,1,'Japanese Basic I Vocabluary','Kirari Nihongo  N5','N5 Level Japanese Vocabulary','ITP-Sub16'),(17,1,'Japanese Basic II Vocabulary','Kirari Nihongo  N4','N4 Level Japanese Vocabulary','ITP-Sub17'),(18,1,'Japanese Intermediate Vocabulary','Kirari Nihongo  N3','N3 Level Japanese Vocabulary','ITP-Sub18'),(19,1,'Japanese Basic I Reading','10 Minutes Daily Reading Comprehension Starting from Beginner Level 120','N5 Level Japanese Reading','ITP-Sub19'),(20,1,'Japanese Basic II Reading','Enjoy the Story! Beginner Level Japanese Reading Comprehension','N4 Level Japanese Reading','ITP-Sub20'),(21,1,'Japanese Intermediate Reading','DOKKAI WO HAJIMERU ANATA E','N3 Level Japanese Reading','ITP-Sub21');
/*!40000 ALTER TABLE `subject` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teacher`
--

DROP TABLE IF EXISTS `teacher`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `teacher` (
  `Tid` int NOT NULL AUTO_INCREMENT,
  `Name` varchar(50) DEFAULT NULL,
  `DoB` date DEFAULT NULL,
  `Ph_no` varchar(20) DEFAULT NULL,
  `Edu_back` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`Tid`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teacher`
--

LOCK TABLES `teacher` WRITE;
/*!40000 ALTER TABLE `teacher` DISABLE KEYS */;
INSERT INTO `teacher` VALUES (1,'Daw Hnin Yu Wai','1990-05-28','09-798884598','- M.C.Sc from University of Computer Studies, Yangon in year 2014 with Distinction\n- B.C.Sc (Hons) in 2010 with first class\n- B.C.Sc in 2009 with credit'),(2,'Daw Moh Moh Khaing','1985-10-14','09-260718559','- PhD-IT(Informatiion Technology), University of Technology, Yatanapon Cyber City (2010-2014)\n- M.C.Sc (Computer Science), University of Computer Studies Yangon (2006-2009)\n- B.C.Sc (Honours), University of Computer Studies Yangon (2003-2006)'),(3,'Daw Khaing','1983-08-16','09-432075354','- M.C.Sc from University of Computer Studies Yangon,U.C.S.Y(1993-1995) \n- B.Com (Hons),YUOE(1984-1986)'),(4,'Dr. Daw Nyein Myint Myint Aung','1984-08-06','09-772678340','PhD-IT(Information Technology), University of Technology, Yatanarpon Cyber City(2014)\nM.C.Sc(Computer Sciences), University of Computer Studies Yangon(2009)\nB.C.Sc(Honours) (Computer Sciences), University of Computer Studies Yangon(2005)'),(5,'Dr. Daw Moh Moh Zan','1985-05-02','09-43033652','PhD.IT(Information Technology), Yatanapon Cyber City (2014)\nM.C.Sc(Computer Sciences) at University of Computer Studies Yangon(2009)\nB.C.Sc (Honours) (Computer Sciences) at University of Computer Studies Yangon(2005)'),(6,'Daw Ei Ei Khin Myint','1983-01-02','09-5363706','B.C.Sc(Honour) (Computer Sciences) at University of Computer Studies Yangon(2003-2006)'),(7,'Tr. Khin Myat Noe','2023-07-07','09-978490999','Professional Diploma in Grammar Certification Bridge TEFL(online), \nColorado State University, USA (March 2009)\nDiploma in Eng(Yangon University of Foreign Language) , May(2007)\nBachelor of Engineering (Information Technology) at May (2006)\nTechnology(Information Technology), March(2005)\nDiploma in Information Technology at Technology University Mawbi\n'),(8,'Tr. San San Myint','1985-05-10','09-973831545','B.Sc Botany (1992-1997) at Yangon University\nFundamentals of Communicative Language Teaching (2010), at British Coucil Mynamar'),(9,'Sensei Nilar Myint','1993-10-16','09-964203737','BA Japanese at Yangon University of Foreign Language\nABE Level 6 at PS Business School'),(10,'Sensei Phone Myat Naing','1999-10-29','09-796304611','Pyin Nyar Nandaw High School(2015-2016)\nUniversity of Medicine (Third MBBS)\nJapanese NAT Level 2 (JLPT N2 equivalent)'),(11,'Sensei Zar Zar Kyaw','2002-06-16','09-762196297','JLPT N2 passed\nDiploma in Sales and Marketing Management(NMA)\nSecond Year at Yadanabon University'),(12,'Sensei Wut Yee Soe','1994-04-21','09-977991021','BA Japanese at Human Academy Japanese Language School');
/*!40000 ALTER TABLE `teacher` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-07-09 17:29:48
