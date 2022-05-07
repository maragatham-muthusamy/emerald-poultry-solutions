DROP SCHEMA eps;

CREATE DATABASE IF NOT EXISTS eps;

USE eps;

CREATE TABLE IF NOT EXISTS `Users` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `username` varchar(100) NOT NULL UNIQUE,
  `email` varchar(100) NOT NULL UNIQUE,
  `firstname` varchar(50) NOT NULL,
  `lastname` varchar(50) NOT NULL,
  `phone` varchar(15) NOT NULL,
  `password` varchar(200) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS `Roles` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `role` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS `Production` (
  `id` int NOT NULL AUTO_INCREMENT,
  `userid` BIGINT NOT NULL,
  `item` VARCHAR(20) NOT NULL,
  `quantity` int NOT NULL,
  `price` double NOT NULL,
  `date` date NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_PurchaseUser` FOREIGN KEY (`userid`) REFERENCES `Users` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
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

