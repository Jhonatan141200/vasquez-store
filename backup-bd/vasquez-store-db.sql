CREATE DATABASE  IF NOT EXISTS `store_db` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `store_db`;
-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: store_db
-- ------------------------------------------------------
-- Server version	8.0.35

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
-- Table structure for table `categorias`
--

DROP TABLE IF EXISTS `categorias`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `categorias` (
  `id_categoria` int NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(45) NOT NULL,
  `estado` tinyint(1) NOT NULL,
  PRIMARY KEY (`id_categoria`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categorias`
--

LOCK TABLES `categorias` WRITE;
/*!40000 ALTER TABLE `categorias` DISABLE KEYS */;
INSERT INTO `categorias` VALUES (1,'Frutas y verduras',1),(2,'Pastelería',1),(3,'Carnes y pescados',1),(4,'Lácteos y Huevos',1),(5,'Bebidas',1),(6,'Licores',1),(7,'Cuidado personal',1),(8,'Despensa',1);
/*!40000 ALTER TABLE `categorias` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `clientes`
--

DROP TABLE IF EXISTS `clientes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `clientes` (
  `id` varchar(20) NOT NULL,
  `nombre` varchar(40) DEFAULT NULL,
  `apellidos` varchar(100) DEFAULT NULL,
  `celular` varchar(20) DEFAULT NULL,
  `direccion` varchar(80) DEFAULT NULL,
  `correo_electronico` varchar(70) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clientes`
--

LOCK TABLES `clientes` WRITE;
/*!40000 ALTER TABLE `clientes` DISABLE KEYS */;
INSERT INTO `clientes` VALUES ('2552243','Galileo','Galilei','3462257293','Cl 1 # 11 - 11','gali@leo.com'),('4546221','Johannes','Kepler','3104583224','Cl 3 # 33 - 33','kepler@me.com'),('75073058','Jhonatan','Vasquez Reyna','958637004','CPM Cambio Puente Mz V1 Lt 6','jhona141200@gmail.com'),('983824','Nicolás','Copernico','3019392466','Cl 2 # 22 - 22','nico@cope.com');
/*!40000 ALTER TABLE `clientes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `compras`
--

DROP TABLE IF EXISTS `compras`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `compras` (
  `id_compra` int NOT NULL AUTO_INCREMENT,
  `id_cliente` varchar(20) NOT NULL,
  `fecha` timestamp NULL DEFAULT NULL,
  `medio_pago` char(1) DEFAULT NULL,
  `comentario` varchar(300) DEFAULT NULL,
  `estado` char(1) DEFAULT NULL,
  PRIMARY KEY (`id_compra`),
  KEY `fk_COMPRAS_CLIENTES1` (`id_cliente`),
  CONSTRAINT `fk_COMPRAS_CLIENTES1` FOREIGN KEY (`id_cliente`) REFERENCES `clientes` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `compras`
--

LOCK TABLES `compras` WRITE;
/*!40000 ALTER TABLE `compras` DISABLE KEYS */;
INSERT INTO `compras` VALUES (1,'4546221','1992-08-10 22:30:00','E','','P'),(3,'75073058','2021-10-22 03:14:42','E','Compra con descuentos exclusivos','P'),(6,'75073058','2021-10-22 03:14:42','E','Compra con descuentos exclusivos','P'),(7,'75073058','2021-10-22 03:14:42','E','Compra con descuentos exclusivos','P'),(8,'75073058','2021-10-22 03:14:42','E','Compra con descuentos exclusivos','P'),(9,'75073058','2021-10-22 03:14:42','E','Compra con descuentos exclusivos','P'),(10,'75073058','2021-10-22 03:14:42','E','Compra con descuentos exclusivos','P'),(11,'75073058','2021-10-22 03:14:42','E','Compra con descuentos exclusivos','P'),(12,'75073058','2021-10-22 03:14:42','E','Compra con descuentos exclusivos','P'),(13,'75073058','2021-10-22 03:14:42','E','Compra con descuentos exclusivos','P');
/*!40000 ALTER TABLE `compras` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `compras_productos`
--

DROP TABLE IF EXISTS `compras_productos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `compras_productos` (
  `id_compra` int NOT NULL,
  `id_producto` int NOT NULL,
  `cantidad` int DEFAULT NULL,
  `total` decimal(16,2) DEFAULT NULL,
  `estado` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id_compra`,`id_producto`),
  KEY `fk_COMPRAS_PRODUCTOS_PRODUCTOS1` (`id_producto`),
  CONSTRAINT `fk_COMPRAS_PRODUCTOS_COMPRAS1` FOREIGN KEY (`id_compra`) REFERENCES `compras` (`id_compra`),
  CONSTRAINT `fk_COMPRAS_PRODUCTOS_PRODUCTOS1` FOREIGN KEY (`id_producto`) REFERENCES `productos` (`id_producto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `compras_productos`
--

LOCK TABLES `compras_productos` WRITE;
/*!40000 ALTER TABLE `compras_productos` DISABLE KEYS */;
INSERT INTO `compras_productos` VALUES (1,1,10,3000.00,1),(1,24,1,4000.00,1),(1,27,1,9000.00,1),(1,36,1,40000.00,1),(1,49,2,16400.00,1),(3,1,2,600.00,1),(3,4,1,2500.00,1),(6,1,2,600.00,1),(6,4,1,2500.00,1),(7,1,2,600.00,1),(7,4,1,2500.00,1),(8,1,2,600.00,1),(8,4,1,2500.00,1),(9,1,96,600.00,1),(9,4,6,2500.00,1),(10,1,100,600.00,1),(10,4,10,2500.00,1),(11,1,100,600.00,1),(11,4,10,2500.00,1),(12,1,100,600.00,1),(12,4,10,2500.00,1),(13,1,100,600.00,1),(13,4,10,2500.00,1);
/*!40000 ALTER TABLE `compras_productos` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `actualizar_stock` AFTER INSERT ON `compras_productos` FOR EACH ROW BEGIN
    UPDATE productos
    SET cantidad_stock = cantidad_stock - NEW.cantidad
    WHERE id_producto = NEW.id_producto;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `productos`
--

DROP TABLE IF EXISTS `productos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `productos` (
  `id_producto` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  `id_categoria` int NOT NULL,
  `codigo_barras` varchar(150) DEFAULT NULL,
  `precio_venta` decimal(16,2) DEFAULT NULL,
  `cantidad_stock` int NOT NULL,
  `estado` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id_producto`),
  KEY `fk_PRODUCTOS_CATEGORIAS` (`id_categoria`),
  CONSTRAINT `fk_PRODUCTOS_CATEGORIAS` FOREIGN KEY (`id_categoria`) REFERENCES `categorias` (`id_categoria`)
) ENGINE=InnoDB AUTO_INCREMENT=53 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productos`
--

LOCK TABLES `productos` WRITE;
/*!40000 ALTER TABLE `productos` DISABLE KEYS */;
INSERT INTO `productos` VALUES (1,'Guayaba Feijoa',1,'7029 A42 23',300.00,0,1),(2,'Mango',1,'0316 R56 01',2100.00,250,1),(3,'Manzana',1,'7923 T23 19',700.00,130,1),(4,'Aguacate',1,'9322 Q33 02',2500.00,50,1),(5,'Lechuga',1,'9742 S22 21',4000.00,86,1),(6,'Tomate',1,'0483 R00 97',290.00,430,1),(7,'Pera',1,'9999 X10 01',750.00,210,1),(8,'Apio',1,'3390 F29 45',150.00,115,1),(9,'Papaya',1,'5291 J34 32',4500.00,73,1),(10,'Limón',1,'7886 N18 32',350.00,425,1),(11,'Brownie',2,'6683 H15 20',2500.00,80,1),(12,'Pan tajado',2,'5745 F05 47',4500.00,120,1),(13,'Torta',2,'3831 D97 99',10000.00,35,1),(14,'Tortilla',2,'4335 Z33 84',6400.00,87,1),(15,'Tostadas',2,'6584 M19 25',4000.00,45,1),(16,'Chocorramo',2,'4487 S00 97',2000.00,105,1),(17,'Salmón',3,'4546 A00 01',28000.00,55,1),(18,'Punta de anca',3,'3678 E57 22',12000.00,32,1),(19,'Posta',3,'8893 O01 03',7800.00,40,1),(20,'Costilla de cerdo',3,'4534 Q12 88',8600.00,70,1),(21,'Tilapia',3,'5684 R53 02',17000.00,60,1),(22,'Merluza',3,'3523 R04 00',23000.00,45,1),(23,'Leche de vaca',4,'2323 T56 33',2500.00,500,1),(24,'Queso',4,'7786 K19 56',4000.00,300,1),(25,'Huevos de gallina feliz',4,'3478 M74 01',400.00,1000,1),(26,'Clara de huevo',4,'7932 R31 46',3200.00,200,1),(27,'Suero costeño',4,'5463 W23 33',9000.00,110,1),(28,'Agua',5,'8965 I32 11',2000.00,600,1),(29,'Jugo de naranja',5,'7445 T87 44',7400.00,200,1),(30,'Gaseosa Colombiana',5,'3434 R34 63',3100.00,175,1),(31,'Jugo de Lulo',5,'9753 W33 19',8250.00,630,1),(32,'Tea',5,'9836 F35 69',1900.00,450,1),(33,'Cerveza',6,'3432 G67 21',2100.00,800,1),(34,'Tequila',6,'9529 E45 98',65000.00,764,1),(35,'Ron',6,'1947 R07 53',55000.00,240,1),(36,'Aguardiente Antioqueño',6,'3160 A54 94',40000.00,480,1),(37,'Vino',6,'7891 W46 95',82000.00,560,1),(38,'Crema dental',7,'6310 C99 73',7500.00,200,1),(39,'Jabón de manos',7,'9371 J14 75',4900.00,90,1),(40,'Enjuague bucal',7,'1942 T68 01',12000.00,105,1),(41,'Shampoo',7,'6789 W01 23',9300.00,200,1),(42,'Desodorante',7,'7333 S21 36',6900.00,85,1),(43,'Arroz',8,'4676 I83 00',3500.00,600,1),(44,'Lentejas',8,'7333 S21 36',3000.00,560,1),(45,'Harina',8,'7333 S21 36',1800.00,300,1),(46,'Sal',8,'7333 S21 36',1400.00,500,1),(47,'Aceite',8,'7333 S21 36',6500.00,135,1),(48,'Cereal',8,'4673 K53 98',7000.00,75,1),(49,'Frijol',8,'2745 F40 45',8200.00,270,1),(50,'Café',8,'6351 R33 92',7200.00,400,1),(52,'Sandía',1,NULL,12.00,14,1);
/*!40000 ALTER TABLE `productos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'store_db'
--

--
-- Dumping routines for database 'store_db'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-07-21 16:10:12
