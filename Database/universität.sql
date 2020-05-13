-- phpMyAdmin SQL Dump
-- version 4.6.6
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Erstellungszeit: 14. Jan 2019 um 23:13
-- Server-Version: 5.7.17-log
-- PHP-Version: 5.6.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Datenbank: `universität`
--

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `course`
--

CREATE TABLE `course` (
  `id_course` int(11) NOT NULL,
  `name_course` varchar(80) NOT NULL,
  `hour` float NOT NULL,
  `name_doctor` varchar(80) NOT NULL,
  `salary_one_hour` float NOT NULL,
  `semester` int(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Daten für Tabelle `course`
--

INSERT INTO `course` (`id_course`, `name_course`, `hour`, `name_doctor`, `salary_one_hour`, `semester`) VALUES
(123, 'Java Grundlagen', 3, 'Abdul Basset Al-Masri', 25, 1),
(125, 'C', 3, 'Ahmed Mahmoud', 25, 1),
(1456, 'Java Advanced', 3, 'Mohamed Shawwa', 30, 2),
(1489, 'CSS', 3, 'Ahmed Yasser', 25, 2),
(4567, 'PHP', 2, 'Kamal Kamal', 23, 1),
(7896, 'android', 5, 'Khaled Al Mughair', 14, 2),
(9875, 'Wordpress', 3, 'Rami Najjar', 25, 2),
(14456, 'HTML', 3, 'Sawsan Abdo', 15, 1);

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `doctor`
--

CREATE TABLE `doctor` (
  `id_doctor` int(11) NOT NULL,
  `name_doctor` varchar(80) NOT NULL,
  `password` varchar(80) NOT NULL,
  `mobile` varchar(80) NOT NULL,
  `address` varchar(80) NOT NULL,
  `gender` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Daten für Tabelle `doctor`
--

INSERT INTO `doctor` (`id_doctor`, `name_doctor`, `password`, `mobile`, `address`, `gender`) VALUES
(2011, 'Sawsan Abdo', '123456', '05786418984', 'Haifa', 'Weiblich'),
(2012, 'Ahmed Yasser', '123456', '05754987637', 'Jerusalem', 'Männlich'),
(2013, 'Abdul Basset Al-Masri', '123456', '05989767987', 'Maghazi', 'Männlich'),
(2014, 'Mohamed Shawwa', '123456', '05992242342', 'Gaza', 'Männlich'),
(2015, 'Ahmed Mahmoud', '123456', '05992540454', 'Rafah', 'Männlich'),
(2016, 'Kamal Kamal', '123456', '05654789932', 'Bethlehem', 'Männlich'),
(2017, 'Rami Najjar', '123456', '05252452546', 'Ramallah', 'Männlich'),
(2018, 'Iyad Al-Bayouk', '123456', '05780589898', 'Deir Al-Balah', 'Männlich'),
(2019, 'Khaled Al Mughair', '123456', '05987456321', 'Ramla', 'Männlich');

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `register_student_course`
--

CREATE TABLE `register_student_course` (
  `id_student` int(11) NOT NULL,
  `id_course` int(11) NOT NULL,
  `name_course` varchar(80) NOT NULL,
  `hour` float NOT NULL,
  `name_doctor` varchar(80) NOT NULL,
  `mark1` float NOT NULL,
  `mark2` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Daten für Tabelle `register_student_course`
--

INSERT INTO `register_student_course` (`id_student`, `id_course`, `name_course`, `hour`, `name_doctor`, `mark1`, `mark2`) VALUES
(2016, 125, 'C', 3, 'Ahmed Mahmoud', 0, 0),
(2018, 123, 'Java Grundlagen', 3, 'Abdul Basset Al-Masri', 0, 0),
(2018, 125, 'C', 3, 'Ahmed Mahmoud', 0, 0),
(2016, 123, 'Java Grundlagen', 3, 'Abdul Basset Al-Masri', 0, 0),
(2017, 14456, 'HTML', 3, 'Sawsan Abdo', 0, 0),
(2018, 4567, 'PHP', 2, 'Kamal Kamal', 0, 0),
(2016, 4567, 'PHP', 2, 'Kamal Kamal', 0, 0),
(2016, 14456, 'HTML', 3, 'Sawsan Abdo', 0, 0);

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `semester`
--

CREATE TABLE `semester` (
  `first` varchar(1) NOT NULL,
  `second` varchar(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Daten für Tabelle `semester`
--

INSERT INTO `semester` (`first`, `second`) VALUES
('1', '0');

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `student`
--

CREATE TABLE `student` (
  `id_student` int(11) NOT NULL,
  `name_student` varchar(80) NOT NULL,
  `password` varchar(80) NOT NULL,
  `mobile` varchar(80) NOT NULL,
  `gender` varchar(10) NOT NULL,
  `avg` float NOT NULL,
  `required_amount` float NOT NULL,
  `amount_paid` float NOT NULL,
  `rest_of_the_fees` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Daten für Tabelle `student`
--

INSERT INTO `student` (`id_student`, `name_student`, `password`, `mobile`, `gender`, `avg`, `required_amount`, `amount_paid`, `rest_of_the_fees`) VALUES
(2014, 'Khaled', '123456', '0599898787', 'Männlich', 0, 0, 0, 0),
(2016, 'Hanan', '123456', '0559885544', 'Weiblich', 0, 241, 0, 241),
(2017, 'Mahmoud Shawwa', '123456', '0559544656', 'Männlich', 0, 45, 0, 45),
(2018, 'Ahmed Khalil', '123456', '0559254554', 'Männlich', 0, 196, 0, 196);

--
-- Indizes der exportierten Tabellen
--

--
-- Indizes für die Tabelle `course`
--
ALTER TABLE `course`
  ADD PRIMARY KEY (`id_course`);

--
-- Indizes für die Tabelle `doctor`
--
ALTER TABLE `doctor`
  ADD PRIMARY KEY (`id_doctor`);

--
-- Indizes für die Tabelle `student`
--
ALTER TABLE `student`
  ADD PRIMARY KEY (`id_student`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
