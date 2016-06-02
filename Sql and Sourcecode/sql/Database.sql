CREATE DATABASE  IF NOT EXISTS `restaurant_finder_database` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `restaurant_finder_database`;
-- MySQL dump 10.13  Distrib 5.6.24, for Win32 (x86)
--
-- Host: localhost    Database: restaurant_finder_database
-- ------------------------------------------------------
-- Server version	5.6.27-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Dumping data for table `customers`
--

INSERT INTO `customers` (`UserId`, `Firstname`, `Lname`, `email`) VALUES ('asina','Adrian','Sina','asina@hmail.com'),('chuckb','Chuck','Bass','chuckb@hmail.com'),('cmassina','Chris','Massina','cmass@mproj.com'),('ellew','Elle','Woods','elwoods@hmail.com'),('eval','Eva','Longaria','elong@gmail.com'),('hanmarin','Hanna','Marin','hmarin@hmail.com'),('joel','Joel','Martin','joemartin@hmail.com'),('joshel','Josh','Hazel','Jhazel@hmail.com'),('ksweet','Kaley','Sweet','kalsweet@hmail.com'),('matd','Matt','Damon','md@hmail.com'),('mkelly','Mindy','Kelly','mk@theoffice.com'),('noel','Noel','Khan','nkhan@hmail.com'),('rickmrin','Ricky','Marin','rickm@hmail.com'),('shelco','Shelly','Cooper','shelcoop@hmail.com'),('zaynm','Zayn','Malik','zmalik@hmail.com');

--
-- Dumping data for table `restauranthours`
--

INSERT INTO `restauranthours` (`idrestaurant`, `Weekhours`, `Saturday hours`, `Sunday hours`, `Intermediate Closed hours`, `Closed Days`) VALUES (984022,'11:00 AM – 9:00 PM','12:00 Noon – 10:00 PM','12:00 Noon –  9:00 PM',NULL,'Monday Closed'),(984023,'11:30 AM – 9:30 PM','11:30 AM – 10:30 PM','11:30 AM – 9:00 PM','2:00 PM - 5:00 PM',NULL),(984024,'9:00 AM - 8:00 PM','11:00 AM - 8:00 PM','11:00 AM - 8:00 PM',NULL,NULL),(984025,'11:00 AM – 9:00 PM','5:00 AM – 9:00 PM',NULL,NULL,'Sunday Closed'),(984026,'11:30 AM – 12:00 AM','11:30 AM – 12:00 AM','11:30 AM – 12:00 AM',NULL,NULL),(984061,'11:00 AM - 9:00 PM','12:00 Noon - 9:30 PM','12:00 Noon  - 9:00 PM','3:00 PM -5:00 PM',NULL),(984091,'11:00 AM - 9:00 PM','11:00 AM - 10:00 PM','12:00 AM - 9:00 PM',NULL,NULL),(984661,'11:00 AM - 10:00 PM','11:00 AM - 10:00 PM','12:00 Noon - 10:00 PM',NULL,NULL),(984991,'11:00 AM-9:30 PM','11:00 AM-9:30 PM','11:00 AM-9:30 PM',NULL,NULL),(984992,'11:00 AM-9:30 PM','11:00 AM-9:30 PM','12:00 Noon - 10:00 PM','3:00 PM -5:00 PM',NULL),(984993,'11:00 AM-9:30 PM','11:00 AM-9:30 PM','12:00 Noon - 10:00 PM',NULL,NULL),(984995,'11:00 AM-9:30 PM','11:00 AM-9:30 PM','11:00 AM-9:30 PM','3:00 PM -5:00 PM',NULL);

--
-- Dumping data for table `restaurants`
--

INSERT INTO `restaurants` (`id`, `r_name`, `cuisine`, `addr`, `zip`, `rating`, `r_range`) VALUES (91134,'Pizza','Italian','Broadway','98402',3.9,'low'),(123456,'Le Meridian','American','19th  Jefferson','98402',4.4,'low'),(123789,'Lemongrass','Thai','Pacific Ave','98402',4.9,'low'),(984021,'Pacific Grill','American','1502 Pacific Ave, Tacoma, WA','98402',4.4,'high'),(984022,'IndoChine Asian Dining Hall','Indonesian','1924 Pacific Ave, Tacoma, WA','98402',4.099999904632568,'High'),(984023,'The Old Spaghetti Factory','Italian','1735 Jefferson Ave, Tacoma, WA ','98402',3.9,'Med'),(984024,'Abella Pizzeria','Italian','1946 Pacific Ave, Tacoma, WA ','98402',4.199999809265137,'Low'),(984025,'Galanga Thai Cuisine','Thai','1129 Broadway, Tacoma, WA','98402',4.099999904632568,'Med'),(984026,'The Rock Wood Fired Kitchen','Italian','1920 Jefferson Ave, Tacoma, WA ','98402',4.1,'High'),(984061,'Gateway To India','Indian','2603 6th Ave, Tacoma, WA','98406',4.199999809265137,'High'),(984091,'Chili Thai Restaurant','Thai','3213 S 38th St, Tacoma, WA','98409',4.7,'High'),(984661,'India Mahal','Indian','1905 Bridgeport Way W #110, University Place','98466',4.000000003,'Med'),(984991,'Great India Cuisine','Indian',' 9518 Gravelly Lake Dr SW, Lakewood, WA','98499',3.8,'Med'),(984992,'Cham Garden Korean BBQ','Korean','10518 S Tacoma Way, Lakewood, WA','98499',4.6,'Med'),(984993,'Bubble Grill','American','Tacoma Ave','98499',4.3,'low'),(984995,'Swiss Pub','Swiss','19th Jefferson St','98402',4.4,'high'),(984996,'Teriyaki','Japanese','tacoma Ave','98499',4.9,'low'),(984997,'Bombay Garden','Indian','4th, Jackson','98499',3.2,'low'),(984998,'Panda Express','Thai','Tacoma Ave','98499',4.5,'high'),(984999,'Dawgden','American','19th commerce','98499',3.1,'low');

--
-- Dumping data for table `reviews`
--

INSERT INTO `reviews` (`UserId`, `RestaurantId`, `Reviewscol`) VALUES ('asina',984021,'Great Place, Great food'),('chuckb',984021,'A little lower to my tastes.'),('shelco',984021,'Rude Host. Food is great though'),('zaynm',984021,'Will never visit again.'),('shelco',984022,'Awesome food'),('zaynm',984022,'A little pricey, but worth it.'),('cmassina',984023,'You call it Italian. bad'),('cmassina',984024,'Simple and economic. Crowded sometimes'),('ellew',984025,'Tasty food, great price.'),('noel',984025,'Yummy Thai food. Quantity is good'),('hanmarin',984026,'Very Good Hospitality.'),('ksweet',984026,'Finger licking good food. Warm host'),('joel',984061,'Worth the wait and price'),('joshel',984061,'not good'),('ksweet',984061,'They did not play soft kitty. Food was okay.'),('matd',984061,'Nice'),('chuckb',984091,'good place to hangout'),('matd',984091,'Good. Will visit soon'),('mkelly',984091,'Yummy Indian Food'),('noel',984091,'Loved it');

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`userid`, `firstname`, `lastname`, `password`, `email`, `is_admin`) VALUES ('asina','Adrian','Sina','java','asina@hmail.com','false'),('chuckb','Chuck','Bass','java','chuckb@hmail.com','true'),('cmassina','Chris','Massina','lava','cmass@mproj.com','false'),('ellew','Elle','Woods','java','elwoods@hmail.com','true'),('eval','Eva','Longaria','lava','elong@gmail.com','false'),('hanmarin','Hanna','Marin','java','hmarin@hmail.com','false'),('joel','Joel','Martin','java','joemartin@hmail.com','true'),('joshel','Josh','Hazel','java','Jhazel@hmail.com','false'),('ksweet','Kaley','Sweet','java','kalsweet@hmail.com','true'),('matd','Matt','Damon','lava','md@hmail.com','false'),('mkelly','Mindy','Kelly','lava','mk@theoffice.com','true'),('noel','Noel','Khan','java','nkhan@hmail.com','false'),('rickmrin','Ricky','Marin','java','rickm@hmail.com','true'),('shelco','Shelly','Cooper','java','shelcoop@hmail.com','false'),('zaynm','Zayn','Malik','java','zmalik@hmail.com','true');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed
