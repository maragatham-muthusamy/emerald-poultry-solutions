DROP SCHEMA eps;

CREATE DATABASE IF NOT EXISTS eps;

USE eps;

CREATE TABLE IF NOT EXISTS `Users` (
  `userid` int NOT NULL,
  `firstname` varchar(50) NOT NULL,
  `lastname` varchar(50) NOT NULL,
  `email` varchar(100) NOT NULL,
  `password` varchar(50) NOT NULL,
  `phone` varchar(15) NOT NULL,
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS `Items` (
  `itemid` int NOT NULL,
  `itemname` varchar(50) NOT NULL,
  PRIMARY KEY (`itemid`)
) ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS `Stock` (
  `itemid` int NOT NULL,
  `availqty` int NOT NULL,
  `pricebought` double NOT NULL,
  `saleprice` double NOT NULL,
  PRIMARY KEY (`itemid`),
  CONSTRAINT `fk_Items` FOREIGN KEY (`itemid`) REFERENCES `Items` (`itemid`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS `Status` (
  `statusid` int NOT NULL,
  `desc` varchar(50) NOT NULL,
  PRIMARY KEY(`statusid`)
) ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS `Purchase` (
  `pid` int NOT NULL,
  `userid` int NOT NULL,
  `itemid` int NOT NULL,
  `quantity` int NOT NULL,
  `price` double NOT NULL,
  `pdate` date NOT NULL,
  `status` int NOT NULL,
  PRIMARY KEY (`pid`),
  KEY `fk_Items_idx` (`itemid`),
  CONSTRAINT `fk_PurchaseItems` FOREIGN KEY (`itemid`) REFERENCES `Items` (`itemid`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_PurchaseUser` FOREIGN KEY (`userid`) REFERENCES `Users` (`userid`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Status` FOREIGN KEY (`status`) REFERENCES `Status` (`statusid`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS `ContactUs` (
  `id` int NOT NULL,
  `firstname` varchar(50) NOT NULL,
  `lastname` varchar(50) NOT NULL,
  `email` varchar(100) NOT NULL,
  `phone` varchar(15) NOT NULL,
  `message` varchar(500) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB;

