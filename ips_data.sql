# MySQL-Front 3.2  (Build 8.0)

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES latin1 */;

# Host: localhost    Database: ips_data
# ------------------------------------------------------
# Server version 5.0.15-nt

DROP DATABASE IF EXISTS `ips_data`;
CREATE DATABASE `ips_data` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `ips_data`;

#
# Table structure for table case_details_info
#

CREATE TABLE `case_details_info` (
  `case_id` int(11) NOT NULL auto_increment,
  `police_id` int(11) NOT NULL default '0',
  `name` varchar(50) NOT NULL,
  `suspect_adhaar_no` varchar(50) NOT NULL,
  `suspect_phone` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `address` varchar(50) NOT NULL,
  `vehicle_no` varchar(50) NOT NULL,
  `case_camands` blob NOT NULL,
  `Case_type` varchar(50) NOT NULL,
  `time` varchar(50) NOT NULL,
  `dates` date NOT NULL,
  `location` varchar(50) NOT NULL,
  `victim_adhaar_no` varchar(50) NOT NULL,
  `case_status` varchar(50) NOT NULL,
  PRIMARY KEY  (`case_id`),
  KEY `police_id` (`police_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Dumping data for table case_details_info
#

INSERT INTO `case_details_info` VALUES (40,21,'binu','123456789','860642063','binu.think@gmail.com','devalokam','kl1','drunken drive','thasneem','12:52:54','2013-10-29','9.9671981,76.2949322','987654321','case');
INSERT INTO `case_details_info` VALUES (41,21,'dvcf','123456789012','9855','hcff','vcfhh','cdggg','fbcx','tiji','12:57:51','2013-10-29','9.9671981,76.2949322','654866','case');
INSERT INTO `case_details_info` VALUES (42,21,'chinnu','987654321098','9895033318','niby.think@gmail.com','kachumavu','kl8','think','manoj','01:07:27','2013-10-29','9.972757678740981,76.30122698843479','123123123123','case');
INSERT INTO `case_details_info` VALUES (43,21,'123456','111111111111','9895033318','12344.think@gmail.com','bulgan','kl8','god','anil','01:19:44','2013-10-29','9.9671998,76.2949327','123456789012','case');


#
# Table structure for table case_file_info
#

CREATE TABLE `case_file_info` (
  `case_file_id` int(11) NOT NULL auto_increment,
  `case_id` int(11) NOT NULL default '0',
  `case_file` blob NOT NULL,
  PRIMARY KEY  (`case_file_id`),
  KEY `case_id` (`case_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Dumping data for table case_file_info
#

INSERT INTO `case_file_info` VALUES (29,40,'[B@1bdf003');
INSERT INTO `case_file_info` VALUES (30,40,'[B@fa8cd6');
INSERT INTO `case_file_info` VALUES (31,41,'[B@2cd837');
INSERT INTO `case_file_info` VALUES (32,41,'[B@10d3025');
INSERT INTO `case_file_info` VALUES (33,42,'[B@36e58');
INSERT INTO `case_file_info` VALUES (34,42,'[B@53464');
INSERT INTO `case_file_info` VALUES (35,43,'[B@9ab129');


#
# Table structure for table case_penalty_info
#

CREATE TABLE `case_penalty_info` (
  `penalty_id` int(11) NOT NULL auto_increment,
  `case_id` int(11) NOT NULL default '0',
  `penaity_amt` varchar(50) NOT NULL,
  `penalty_status` varchar(50) NOT NULL,
  `last_date` varchar(50) NOT NULL,
  PRIMARY KEY  (`penalty_id`),
  KEY `case_id` (`case_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Dumping data for table case_penalty_info
#



#
# Table structure for table court_info
#

CREATE TABLE `court_info` (
  `court_id` int(11) NOT NULL auto_increment,
  `username` varchar(50) NOT NULL,
  `court_name` varchar(50) NOT NULL,
  `phone` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `address` varchar(50) NOT NULL,
  PRIMARY KEY  (`court_id`),
  KEY `username` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Dumping data for table court_info
#

INSERT INTO `court_info` VALUES (5,'12','rar','fs','fsa',' s');


#
# Table structure for table login_info
#

CREATE TABLE `login_info` (
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `type` varchar(50) NOT NULL,
  KEY `username` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Dumping data for table login_info
#

INSERT INTO `login_info` VALUES ('admin','admin','admin');
INSERT INTO `login_info` VALUES ('12','12','court');
INSERT INTO `login_info` VALUES ('1','1','police');


#
# Table structure for table lost_vehicle_info
#

CREATE TABLE `lost_vehicle_info` (
  `id` int(11) NOT NULL auto_increment,
  `vehicle_no` varchar(50) NOT NULL,
  `owner_name` varchar(50) NOT NULL,
  `email` varchar(100) NOT NULL,
  `phone` varchar(50) NOT NULL,
  `case_date` varchar(50) NOT NULL,
  `time` varchar(50) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Dumping data for table lost_vehicle_info
#

INSERT INTO `lost_vehicle_info` VALUES (1,'10','hnkl','nkjln','nkl','24/10/2013','03:21:17');
INSERT INTO `lost_vehicle_info` VALUES (2,'manu','manu','fbjk','hj','24/10/2013','03:29:27');


#
# Table structure for table police_info
#

CREATE TABLE `police_info` (
  `police_id` int(11) NOT NULL auto_increment,
  `username` varchar(50) NOT NULL,
  `name` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `phone` varchar(50) NOT NULL,
  `address` varchar(50) NOT NULL,
  PRIMARY KEY  (`police_id`),
  KEY `username` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Dumping data for table police_info
#

INSERT INTO `police_info` VALUES (21,'1','binu','binu.think@gmail.com','8606420637',' address of binu');


#
#  Foreign keys for table case_details_info
#

ALTER TABLE `case_details_info`
  ADD FOREIGN KEY (`police_id`) REFERENCES `police_info` (`police_id`) ON DELETE CASCADE ON UPDATE CASCADE;

#
#  Foreign keys for table case_file_info
#

ALTER TABLE `case_file_info`
  ADD FOREIGN KEY (`case_id`) REFERENCES `case_details_info` (`case_id`) ON DELETE CASCADE ON UPDATE CASCADE;

#
#  Foreign keys for table case_penalty_info
#

ALTER TABLE `case_penalty_info`
  ADD FOREIGN KEY (`case_id`) REFERENCES `case_details_info` (`case_id`) ON DELETE CASCADE ON UPDATE CASCADE;

#
#  Foreign keys for table court_info
#

ALTER TABLE `court_info`
  ADD FOREIGN KEY (`username`) REFERENCES `login_info` (`username`) ON DELETE CASCADE ON UPDATE CASCADE;

#
#  Foreign keys for table police_info
#

ALTER TABLE `police_info`
  ADD FOREIGN KEY (`username`) REFERENCES `login_info` (`username`) ON DELETE CASCADE ON UPDATE CASCADE;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
