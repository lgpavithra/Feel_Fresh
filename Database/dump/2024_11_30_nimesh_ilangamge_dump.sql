-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               8.0.34 - MySQL Community Server - GPL
-- Server OS:                    Win64
-- HeidiSQL Version:             12.8.0.6908
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Dumping database structure for feelfresh_db
CREATE DATABASE IF NOT EXISTS `feelfresh_db` /*!40100 DEFAULT CHARACTER SET utf8mb3 */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `feelfresh_db`;

-- Dumping structure for table feelfresh_db.brand
CREATE TABLE IF NOT EXISTS `brand` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb3;

-- Dumping data for table feelfresh_db.brand: ~0 rows (approximately)
INSERT IGNORE INTO `brand` (`id`, `name`) VALUES
	(1, 'Maliban'),
	(2, 'Munchee'),
	(8, 'Elephand House'),
	(9, 'Abewela'),
	(10, 'Apple');

-- Dumping structure for table feelfresh_db.category
CREATE TABLE IF NOT EXISTS `category` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb3;

-- Dumping data for table feelfresh_db.category: ~0 rows (approximately)
INSERT IGNORE INTO `category` (`id`, `name`) VALUES
	(1, 'Biscuit'),
	(5, 'Soya meet'),
	(6, 'Ice cream');

-- Dumping structure for table feelfresh_db.category_has_brand
CREATE TABLE IF NOT EXISTS `category_has_brand` (
  `category_id` int NOT NULL,
  `brand_id` int NOT NULL,
  PRIMARY KEY (`category_id`,`brand_id`),
  KEY `fk_category_has_brand_brand1_idx` (`brand_id`),
  KEY `fk_category_has_brand_category1_idx` (`category_id`),
  CONSTRAINT `fk_category_has_brand_brand1` FOREIGN KEY (`brand_id`) REFERENCES `brand` (`id`),
  CONSTRAINT `fk_category_has_brand_category1` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- Dumping data for table feelfresh_db.category_has_brand: ~0 rows (approximately)
INSERT IGNORE INTO `category_has_brand` (`category_id`, `brand_id`) VALUES
	(1, 1),
	(1, 2);

-- Dumping structure for table feelfresh_db.company
CREATE TABLE IF NOT EXISTS `company` (
  `id` int NOT NULL AUTO_INCREMENT,
  `company_name` varchar(45) DEFAULT NULL,
  `hotline` varchar(12) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- Dumping data for table feelfresh_db.company: ~0 rows (approximately)

-- Dumping structure for table feelfresh_db.company_has_supplier
CREATE TABLE IF NOT EXISTS `company_has_supplier` (
  `id` int NOT NULL AUTO_INCREMENT,
  `company_id` int NOT NULL,
  `supplier_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_company_has_supplier_supplier1_idx` (`supplier_id`),
  KEY `fk_company_has_supplier_company1_idx` (`company_id`),
  CONSTRAINT `fk_company_has_supplier_company1` FOREIGN KEY (`company_id`) REFERENCES `company` (`id`),
  CONSTRAINT `fk_company_has_supplier_supplier1` FOREIGN KEY (`supplier_id`) REFERENCES `supplier` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- Dumping data for table feelfresh_db.company_has_supplier: ~0 rows (approximately)

-- Dumping structure for table feelfresh_db.customer
CREATE TABLE IF NOT EXISTS `customer` (
  `nic` varchar(14) NOT NULL,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `reg_date` date DEFAULT NULL,
  `avail_points` double DEFAULT NULL,
  `no` varchar(10) DEFAULT NULL,
  `line1` varchar(45) DEFAULT NULL,
  `line2` varchar(45) DEFAULT NULL,
  `status_id` int NOT NULL,
  PRIMARY KEY (`nic`),
  KEY `fk_customer_status1_idx` (`status_id`),
  CONSTRAINT `fk_customer_status1` FOREIGN KEY (`status_id`) REFERENCES `status` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- Dumping data for table feelfresh_db.customer: ~0 rows (approximately)
INSERT IGNORE INTO `customer` (`nic`, `first_name`, `last_name`, `email`, `reg_date`, `avail_points`, `no`, `line1`, `line2`, `status_id`) VALUES
	('200230252784', 'haritha', 'sadun mayakaduwa', 'sadun@gmail.com', '2024-11-30', 0, 'no 1524', 'pilana', 'galle', 1),
	('200303602528', 'piyal', 'nimsara', 'piyal@gmail.com', '2024-11-30', 0, '155', 'Megalle', 'galle', 1),
	('200404587892', 'pasan', 'nimsara', 'pasan@gmail.com', '2024-11-30', 0, 'NO 7854', 'Richmond Hill', 'Galle', 1),
	('200505987425', 'kasun', 'nimsara', 'kasun@gmail.com', '2024-11-30', 0, 'NO - 184', 'richmond Hill', 'galle', 1);

-- Dumping structure for table feelfresh_db.gender
CREATE TABLE IF NOT EXISTS `gender` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3;

-- Dumping data for table feelfresh_db.gender: ~0 rows (approximately)
INSERT IGNORE INTO `gender` (`id`, `name`) VALUES
	(1, 'Male'),
	(2, 'Female');

-- Dumping structure for table feelfresh_db.grn
CREATE TABLE IF NOT EXISTS `grn` (
  `grn_no` int NOT NULL AUTO_INCREMENT,
  `user_nic` varchar(16) NOT NULL,
  `supplier_id` int NOT NULL,
  `paid_amount` double DEFAULT NULL,
  `issued_date` datetime DEFAULT NULL,
  PRIMARY KEY (`grn_no`),
  KEY `fk_user_has_supplier_supplier1_idx` (`supplier_id`),
  KEY `fk_user_has_supplier_user1_idx` (`user_nic`),
  CONSTRAINT `fk_user_has_supplier_supplier1` FOREIGN KEY (`supplier_id`) REFERENCES `supplier` (`id`),
  CONSTRAINT `fk_user_has_supplier_user1` FOREIGN KEY (`user_nic`) REFERENCES `user` (`nic`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- Dumping data for table feelfresh_db.grn: ~0 rows (approximately)

-- Dumping structure for table feelfresh_db.grn_item
CREATE TABLE IF NOT EXISTS `grn_item` (
  `id` int NOT NULL AUTO_INCREMENT,
  `buying_price` double DEFAULT NULL,
  `qty` double DEFAULT NULL,
  `grn_grn_no` int NOT NULL,
  `stock_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_grn_item_grn1_idx` (`grn_grn_no`),
  KEY `fk_grn_item_stock1_idx` (`stock_id`),
  CONSTRAINT `fk_grn_item_grn1` FOREIGN KEY (`grn_grn_no`) REFERENCES `grn` (`grn_no`),
  CONSTRAINT `fk_grn_item_stock1` FOREIGN KEY (`stock_id`) REFERENCES `stock` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- Dumping data for table feelfresh_db.grn_item: ~0 rows (approximately)

-- Dumping structure for table feelfresh_db.invoice
CREATE TABLE IF NOT EXISTS `invoice` (
  `invoice_no` int NOT NULL AUTO_INCREMENT,
  `customer_nic` varchar(14) NOT NULL,
  `user_nic` varchar(16) NOT NULL,
  `issued_date` datetime DEFAULT NULL,
  `paid_amount` double DEFAULT NULL,
  PRIMARY KEY (`invoice_no`),
  KEY `fk_customer_has_user_user1_idx` (`user_nic`),
  KEY `fk_customer_has_user_customer1_idx` (`customer_nic`),
  CONSTRAINT `fk_customer_has_user_customer1` FOREIGN KEY (`customer_nic`) REFERENCES `customer` (`nic`),
  CONSTRAINT `fk_customer_has_user_user1` FOREIGN KEY (`user_nic`) REFERENCES `user` (`nic`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- Dumping data for table feelfresh_db.invoice: ~0 rows (approximately)

-- Dumping structure for table feelfresh_db.invoice_item
CREATE TABLE IF NOT EXISTS `invoice_item` (
  `id` int NOT NULL AUTO_INCREMENT,
  `qty` double DEFAULT NULL,
  `stock_id` int NOT NULL,
  `invoice_invoice_no` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_stock_has_invoice_invoice1_idx` (`invoice_invoice_no`),
  KEY `fk_stock_has_invoice_stock1_idx` (`stock_id`),
  CONSTRAINT `fk_stock_has_invoice_invoice1` FOREIGN KEY (`invoice_invoice_no`) REFERENCES `invoice` (`invoice_no`),
  CONSTRAINT `fk_stock_has_invoice_stock1` FOREIGN KEY (`stock_id`) REFERENCES `stock` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- Dumping data for table feelfresh_db.invoice_item: ~0 rows (approximately)

-- Dumping structure for table feelfresh_db.mobile
CREATE TABLE IF NOT EXISTS `mobile` (
  `id` int NOT NULL AUTO_INCREMENT,
  `number` varchar(12) DEFAULT NULL,
  `supplier_id` int NOT NULL,
  `user_nic` varchar(16) NOT NULL,
  `customer_nic` varchar(14) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_mobile_supplier1_idx` (`supplier_id`),
  KEY `fk_mobile_user1_idx` (`user_nic`),
  KEY `fk_mobile_customer1_idx` (`customer_nic`),
  CONSTRAINT `fk_mobile_customer1` FOREIGN KEY (`customer_nic`) REFERENCES `customer` (`nic`),
  CONSTRAINT `fk_mobile_supplier1` FOREIGN KEY (`supplier_id`) REFERENCES `supplier` (`id`),
  CONSTRAINT `fk_mobile_user1` FOREIGN KEY (`user_nic`) REFERENCES `user` (`nic`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- Dumping data for table feelfresh_db.mobile: ~0 rows (approximately)

-- Dumping structure for table feelfresh_db.product
CREATE TABLE IF NOT EXISTS `product` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `category_id` int NOT NULL,
  `brand_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_product_category_has_brand1_idx` (`category_id`,`brand_id`),
  CONSTRAINT `fk_product_category_has_brand1` FOREIGN KEY (`category_id`, `brand_id`) REFERENCES `category_has_brand` (`category_id`, `brand_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- Dumping data for table feelfresh_db.product: ~0 rows (approximately)

-- Dumping structure for table feelfresh_db.status
CREATE TABLE IF NOT EXISTS `status` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3;

-- Dumping data for table feelfresh_db.status: ~0 rows (approximately)
INSERT IGNORE INTO `status` (`id`, `name`) VALUES
	(1, 'Active'),
	(2, 'Inactive');

-- Dumping structure for table feelfresh_db.stock
CREATE TABLE IF NOT EXISTS `stock` (
  `id` int NOT NULL AUTO_INCREMENT,
  `exd` date DEFAULT NULL,
  `mfd` date DEFAULT NULL,
  `selling_prize` double DEFAULT NULL,
  `availi_qty` double DEFAULT NULL,
  `product_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_stock_product1_idx` (`product_id`),
  CONSTRAINT `fk_stock_product1` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- Dumping data for table feelfresh_db.stock: ~0 rows (approximately)

-- Dumping structure for table feelfresh_db.supplier
CREATE TABLE IF NOT EXISTS `supplier` (
  `id` int NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `reg_date` date DEFAULT NULL,
  `line1` varchar(45) DEFAULT NULL,
  `line2` varchar(45) DEFAULT NULL,
  `no` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- Dumping data for table feelfresh_db.supplier: ~0 rows (approximately)

-- Dumping structure for table feelfresh_db.user
CREATE TABLE IF NOT EXISTS `user` (
  `nic` varchar(16) NOT NULL,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `reg_date` date DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `no` varchar(10) DEFAULT NULL,
  `line1` varchar(45) DEFAULT NULL,
  `line2` varchar(45) DEFAULT NULL,
  `status_id` int NOT NULL,
  `user_type_id` int NOT NULL,
  `gender_id` int NOT NULL,
  PRIMARY KEY (`nic`),
  KEY `fk_user_status1_idx` (`status_id`),
  KEY `fk_user_user_type1_idx` (`user_type_id`),
  KEY `fk_user_gender1_idx` (`gender_id`),
  CONSTRAINT `fk_user_gender1` FOREIGN KEY (`gender_id`) REFERENCES `gender` (`id`),
  CONSTRAINT `fk_user_status1` FOREIGN KEY (`status_id`) REFERENCES `status` (`id`),
  CONSTRAINT `fk_user_user_type1` FOREIGN KEY (`user_type_id`) REFERENCES `user_type` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- Dumping data for table feelfresh_db.user: ~0 rows (approximately)
INSERT IGNORE INTO `user` (`nic`, `first_name`, `last_name`, `email`, `reg_date`, `password`, `no`, `line1`, `line2`, `status_id`, `user_type_id`, `gender_id`) VALUES
	('11112', 'Kasun', 'Kalhara', 'kasun@mail.com', '2024-11-14', '123456as', '0', 'sas', 'as', 1, 1, 1);

-- Dumping structure for table feelfresh_db.user_type
CREATE TABLE IF NOT EXISTS `user_type` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3;

-- Dumping data for table feelfresh_db.user_type: ~0 rows (approximately)
INSERT IGNORE INTO `user_type` (`id`, `name`) VALUES
	(1, 'Admin'),
	(2, 'Employee'),
	(3, 'Cashiyar');

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
