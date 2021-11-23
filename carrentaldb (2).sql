-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Nov 22, 2021 at 10:44 AM
-- Server version: 8.0.21
-- PHP Version: 7.3.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `carrentaldb`
--

-- --------------------------------------------------------

--
-- Table structure for table `car`
--

DROP TABLE IF EXISTS `car`;
CREATE TABLE IF NOT EXISTS `car` (
  `ID` varchar(10) NOT NULL,
  `Name` varchar(20) NOT NULL,
  `Model` int NOT NULL,
  `isAvailable` tinyint NOT NULL,
  `Credit` double NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data for table `car`
--

INSERT INTO `car` (`ID`, `Name`, `Model`, `isAvailable`, `Credit`) VALUES
('C01', 'Toyota Camry', 2018, 1, 100),
('C02', 'GMC Yukon', 2017, 1, 150);

-- --------------------------------------------------------

--
-- Table structure for table `reservation`
--

DROP TABLE IF EXISTS `reservation`;
CREATE TABLE IF NOT EXISTS `reservation` (
  `ID` varchar(10) NOT NULL,
  `CustomerID` varchar(10) NOT NULL,
  `CarID` varchar(10) NOT NULL,
  `FromDate` date NOT NULL,
  `ToDate` date NOT NULL,
  `ReturnDate` date DEFAULT NULL,
  `Status` varchar(10) NOT NULL,
  `Cost` double NOT NULL,
  `Penalty` double NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `CustomerID` (`CustomerID`),
  KEY `CarID` (`CarID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data for table `reservation`
--

INSERT INTO `reservation` (`ID`, `CustomerID`, `CarID`, `FromDate`, `ToDate`, `ReturnDate`, `Status`, `Cost`, `Penalty`) VALUES
('R01', 'UC1', 'C01', '2021-11-19', '2021-11-22', '0000-00-00', 'ACTIVATED', 400, 0),
('R03', 'UC1', 'C01', '2021-11-14', '2021-11-18', NULL, 'Handover', 400, 0),
('R21', 'UC1', 'C01', '2021-11-25', '2021-11-26', NULL, 'Handover', 100, 0);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `ID` varchar(10) NOT NULL,
  `Name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `Email` varchar(20) NOT NULL,
  `Password` varchar(10) NOT NULL,
  `Credit` double NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`ID`, `Name`, `Email`, `Password`, `Credit`) VALUES
('UC1', 'Khaled Ahm', 'khaled@gmail.com', 'abc123', 1350),
('UA1', 'Mohammed A', 'mohammeda@crs.com', 'moh1234', 0);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
