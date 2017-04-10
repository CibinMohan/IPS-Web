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

INSERT INTO `court_info` VALUES (2,'cout','court','1478523690','aneesh.think@gmail.com','dfvhdhfgb');


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
INSERT INTO `login_info` VALUES ('manu','12345','police');
INSERT INTO `login_info` VALUES ('cout','54321','court');


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

INSERT INTO `police_info` VALUES (33,'manu','manu','aneesh.think@gmail.com','1478523690','hdgfhjdhjfhdehgdfghlrfkl ');


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
