-- MySQL dump 10.13  Distrib 8.0.27, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: bd_movie
-- ------------------------------------------------------
-- Server version	8.0.27

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
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (17);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `movie`
--

DROP TABLE IF EXISTS `movie`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `movie` (
  `id` int NOT NULL,
  `classified` varchar(255) DEFAULT NULL,
  `director` varchar(255) DEFAULT NULL,
  `duration` double DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `plot` varchar(1000) DEFAULT NULL,
  `poster` varchar(255) DEFAULT NULL,
  `rate` int DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `year` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movie`
--

LOCK TABLES `movie` WRITE;
/*!40000 ALTER TABLE `movie` DISABLE KEYS */;
INSERT INTO `movie` VALUES (13,'R','Zack Snyder',117,'Acción, Aventura, Bélica','Adaptación del cómic de Frank Miller (autor del cómic \'Sin City\') sobre la famosa batalla de las Termópilas (480 a.C.). El objetivo de Jerjes, emperador de Persia, era la conquista de Grecia, lo que desencadenó las Guerras Médicas. Dada la gravedad de la situación, el rey Leónidas de Esparta (Gerard Butler) y 300 espartanos se enfrentaron a un ejército persa que era inmensamente superior.','https://www.themoviedb.org/t/p/w600_and_h900_bestv2/7r7SSO2DjWG1mz73ulhKB6flv2R.jpg',72,'300',2007),(14,'PG_13','Jon Watts',148,'Acción, Aventura, Ciencia ficción','Por primera vez en la historia cinematográfica de Spider-Man, nuestro héroe, vecino y amigo es desenmascarado, y por tanto, ya no es capaz de separar su vida normal de los enormes riesgos que conlleva ser un superhéroe. Cuando pide ayuda al Doctor Strange, los riesgos pasan a ser aún más peligrosos, obligándole a descubrir lo que realmente significa ser él.','https://www.themoviedb.org/t/p/w600_and_h900_bestv2/memAp4wemvpYYpO38TLfgsJHBLF.jpg',86,'Spider-Man: No Way Home',2021),(15,'R','Francis Ford Coppola',175,'Drama, Crimen','Don Vito Corleone, conocido dentro de los círculos del hampa como \'El Padrino\', es el patriarca de una de las cinco familias que ejercen el mando de la Cosa Nostra en Nueva York en los años ccuarenta. Don Corleone tiene cuatro hijos: una chica, Connie, y tres varones; Sonny, Michael y Fredo. Cuando el Padrino reclina intervenir en el negocio de estupefacientes, empieza una cruenta lucha de violentos episodios entre las distintas familias del crimen organizado.','https://www.themoviedb.org/t/p/w600_and_h900_bestv2/wLXd1Cd0XW7DhXayfC0Ok5ago9r.jpg',87,'El padrino',1972),(16,'R','Sergio Leone',161,'Western','Durante la Guerra de Secesión, tres cazadores de recompensas se lanzan a la búsqueda de un tesoro que ninguno de los tres truhanes puede localizar sin la ayuda de los otros dos. Tuco sabe que el tesoro se encuentra en un cementerio, mientras que Joe conoce el nombre inscrito en la tumba que lo esconde. Mientras tanto, Sentenza no duda en matar a mujeres y niños para conseguir su meta. De esta forma, los tres hombres colaboran en apariencia, pero al final intentarán eliminarse mutuamente.','https://www.themoviedb.org/t/p/w600_and_h900_bestv2/vd9uj5KLlOrJnvNH03exLDlMAE0.jpg',85,'El bueno, el feo y el malo',1966);
/*!40000 ALTER TABLE `movie` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-12-21 13:54:23
