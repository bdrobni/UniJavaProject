-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 20, 2024 at 01:00 AM
-- Server version: 10.4.25-MariaDB
-- PHP Version: 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `hotel`
--

-- --------------------------------------------------------

--
-- Table structure for table `hotel`
--

CREATE TABLE `hotel` (
  `ID` int(11) NOT NULL,
  `Naziv` varchar(20) NOT NULL,
  `Lokacija` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `hotel`
--

INSERT INTO `hotel` (`ID`, `Naziv`, `Lokacija`) VALUES
(1, 'Test Hotel', 'Beograd'),
(8, 'Test 2', 'Atina'),
(10, 'Test 3', 'Pariz');

-- --------------------------------------------------------

--
-- Table structure for table `korisnik`
--

CREATE TABLE `korisnik` (
  `IdKorisnika` int(11) NOT NULL,
  `Ime` varchar(20) NOT NULL,
  `Prezime` varchar(20) NOT NULL,
  `Password` varchar(20) NOT NULL,
  `TipKorisnika` varchar(1) NOT NULL,
  `Email` varchar(30) NOT NULL,
  `Bodovi` int(11) NOT NULL,
  `Menadzer` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `korisnik`
--

INSERT INTO `korisnik` (`IdKorisnika`, `Ime`, `Prezime`, `Password`, `TipKorisnika`, `Email`, `Bodovi`, `Menadzer`) VALUES
(1, 'Bojan', 'Drobni', '1234', 'A', 'bojan39618@its.edu.rs', 0, NULL),
(2, 'Marko', 'Markovic', '5678', 'M', 'mm@example.com', 0, 1),
(5, 'Petar', 'Petrovic', '9012', 'K', 'pp@example.com', 8, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `rezervacija`
--

CREATE TABLE `rezervacija` (
  `IdRez` int(11) NOT NULL,
  `SifraKorisnika` int(11) NOT NULL,
  `SifraSobe` int(11) NOT NULL,
  `DatumOd` varchar(12) NOT NULL,
  `DatumDo` varchar(12) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `rezervacija`
--

INSERT INTO `rezervacija` (`IdRez`, `SifraKorisnika`, `SifraSobe`, `DatumOd`, `DatumDo`) VALUES
(12, 5, 1, '1.1.2025', '12.1.2025');

-- --------------------------------------------------------

--
-- Table structure for table `soba`
--

CREATE TABLE `soba` (
  `IdSobe` int(11) NOT NULL,
  `IdTipa` int(11) NOT NULL,
  `BrojSobe` int(11) NOT NULL,
  `Cena` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `soba`
--

INSERT INTO `soba` (`IdSobe`, `IdTipa`, `BrojSobe`, `Cena`) VALUES
(1, 1, 111, 400),
(2, 2, 122, 500),
(3, 1, 211, 450);

-- --------------------------------------------------------

--
-- Table structure for table `tipsobe`
--

CREATE TABLE `tipsobe` (
  `IdTipa` int(11) NOT NULL,
  `NazivTipa` varchar(20) NOT NULL,
  `SifraHotela` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tipsobe`
--

INSERT INTO `tipsobe` (`IdTipa`, `NazivTipa`, `SifraHotela`) VALUES
(1, '1 krevet', 1),
(2, '2 kreveta', 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `hotel`
--
ALTER TABLE `hotel`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `korisnik`
--
ALTER TABLE `korisnik`
  ADD PRIMARY KEY (`IdKorisnika`);

--
-- Indexes for table `rezervacija`
--
ALTER TABLE `rezervacija`
  ADD PRIMARY KEY (`IdRez`);

--
-- Indexes for table `soba`
--
ALTER TABLE `soba`
  ADD PRIMARY KEY (`IdSobe`);

--
-- Indexes for table `tipsobe`
--
ALTER TABLE `tipsobe`
  ADD PRIMARY KEY (`IdTipa`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `hotel`
--
ALTER TABLE `hotel`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `korisnik`
--
ALTER TABLE `korisnik`
  MODIFY `IdKorisnika` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `rezervacija`
--
ALTER TABLE `rezervacija`
  MODIFY `IdRez` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT for table `soba`
--
ALTER TABLE `soba`
  MODIFY `IdSobe` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `tipsobe`
--
ALTER TABLE `tipsobe`
  MODIFY `IdTipa` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
