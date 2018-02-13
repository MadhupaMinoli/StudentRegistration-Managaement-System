-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               5.7.20-0ubuntu0.17.04.1 - (Ubuntu)
-- Server OS:                    Linux
-- HeidiSQL Version:             9.4.0.5125
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Dumping structure for table StudentRegistration.Course
CREATE TABLE IF NOT EXISTS `Course` (
  `courseId` int(11) NOT NULL AUTO_INCREMENT,
  `courseName` varchar(255) DEFAULT NULL,
  `duration` varchar(255) DEFAULT NULL,
  `fee` double NOT NULL,
  PRIMARY KEY (`courseId`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

-- Dumping data for table StudentRegistration.Course: ~4 rows (approximately)
/*!40000 ALTER TABLE `Course` DISABLE KEYS */;
INSERT INTO `Course` (`courseId`, `courseName`, `duration`, `fee`) VALUES
	(1, 'Civil', '1 year', 500000),
	(2, 'Electrical', '1 Year', 100000),
	(3, 'Mechanical', '2 years', 450000),
	(5, 'ckutukt', 'hghjguk', 1534354),
	(6, 'reter', 'retre', 1213212);
/*!40000 ALTER TABLE `Course` ENABLE KEYS */;

-- Dumping structure for table StudentRegistration.PaymentPlan
CREATE TABLE IF NOT EXISTS `PaymentPlan` (
  `planId` int(11) NOT NULL AUTO_INCREMENT,
  `period` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`planId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- Dumping data for table StudentRegistration.PaymentPlan: ~2 rows (approximately)
/*!40000 ALTER TABLE `PaymentPlan` DISABLE KEYS */;
INSERT INTO `PaymentPlan` (`planId`, `period`) VALUES
	(1, '3 Months'),
	(2, '6 Months'),
	(3, '12 Months');
/*!40000 ALTER TABLE `PaymentPlan` ENABLE KEYS */;

-- Dumping structure for table StudentRegistration.Payments
CREATE TABLE IF NOT EXISTS `Payments` (
  `paymentId` int(11) NOT NULL AUTO_INCREMENT,
  `amount` double NOT NULL,
  `paidDate` varchar(255) DEFAULT NULL,
  `registration_course_courseId` int(11) DEFAULT NULL,
  `registration_student_studentId` int(11) DEFAULT NULL,
  PRIMARY KEY (`paymentId`),
  KEY `FK_73mc8g1hxlyjgs9v9qobxay3h` (`registration_course_courseId`,`registration_student_studentId`),
  CONSTRAINT `FK_73mc8g1hxlyjgs9v9qobxay3h` FOREIGN KEY (`registration_course_courseId`, `registration_student_studentId`) REFERENCES `Registration` (`course_courseId`, `student_studentId`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;

-- Dumping data for table StudentRegistration.Payments: ~5 rows (approximately)
/*!40000 ALTER TABLE `Payments` DISABLE KEYS */;
INSERT INTO `Payments` (`paymentId`, `amount`, `paidDate`, `registration_course_courseId`, `registration_student_studentId`) VALUES
	(1, 50000, '1/16/2018', 2, 2),
	(2, 12500, '1/16/2018', 1, 1),
	(3, 50000, '1/16/2018', 2, 2),
	(7, 450000, '1/9/2018', 3, 3),
	(10, 606606, '1/24/2018', 6, 6),
	(13, 125000, '1/9/2018', NULL, NULL);
/*!40000 ALTER TABLE `Payments` ENABLE KEYS */;

-- Dumping structure for table StudentRegistration.Registration
CREATE TABLE IF NOT EXISTS `Registration` (
  `registeredDate` varchar(255) DEFAULT NULL,
  `course_courseId` int(11) NOT NULL,
  `student_studentId` int(11) NOT NULL,
  `paymentPlan_planId` int(11) DEFAULT NULL,
  PRIMARY KEY (`course_courseId`,`student_studentId`),
  KEY `FK_a3tt0uvc1y4170v6cxmd4id1d` (`paymentPlan_planId`),
  KEY `FK_96hiwnegg65kab1vuighlfsfb` (`student_studentId`),
  CONSTRAINT `FK_96hiwnegg65kab1vuighlfsfb` FOREIGN KEY (`student_studentId`) REFERENCES `Student` (`studentId`),
  CONSTRAINT `FK_a3tt0uvc1y4170v6cxmd4id1d` FOREIGN KEY (`paymentPlan_planId`) REFERENCES `PaymentPlan` (`planId`),
  CONSTRAINT `FK_ig0nedftxt4ebsyu9k6l1fptg` FOREIGN KEY (`course_courseId`) REFERENCES `Course` (`courseId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table StudentRegistration.Registration: ~7 rows (approximately)
/*!40000 ALTER TABLE `Registration` DISABLE KEYS */;
INSERT INTO `Registration` (`registeredDate`, `course_courseId`, `student_studentId`, `paymentPlan_planId`) VALUES
	('1/2/2018', 1, 1, 1),
	('1/17/2018', 1, 6, 1),
	('1/10/2018', 2, 1, 2),
	('1/25/2018', 2, 2, 2),
	('2/1/2018', 3, 3, 3),
	('1/18/2018', 3, 6, 2),
	('1/9/2018', 6, 6, 2);
/*!40000 ALTER TABLE `Registration` ENABLE KEYS */;

-- Dumping structure for table StudentRegistration.Student
CREATE TABLE IF NOT EXISTS `Student` (
  `studentId` int(11) NOT NULL AUTO_INCREMENT,
  `dateOfBirth` varchar(255) DEFAULT NULL,
  `studentName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`studentId`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

-- Dumping data for table StudentRegistration.Student: ~4 rows (approximately)
/*!40000 ALTER TABLE `Student` DISABLE KEYS */;
INSERT INTO `Student` (`studentId`, `dateOfBirth`, `studentName`) VALUES
	(1, '29/07/1995', 'Madhupa'),
	(2, '1/1/1994', 'Akila'),
	(3, '7/2/1998', 'Kavini'),
	(5, 'ctcktku', 'sa'),
	(6, 'trytreeeeeeeeee', 'rteer');
/*!40000 ALTER TABLE `Student` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
