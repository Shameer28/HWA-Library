create schema if not exists testdb;

use testdb;

 
drop table if exists Book;
drop table if exists Library;


CREATE TABLE IF NOT EXISTS `Book`(
`bookid` int NOT NULL AUTO_INCREMENT,
  `author` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `library_libid` int DEFAULT NULL,
  PRIMARY KEY (`bookid`));

CREATE TABLE IF NOT EXISTS `Library` (
  `libID` INT NOT NULL auto_increment,
  `name` VARCHAR(255),
   PRIMARY KEY (`libID`));


