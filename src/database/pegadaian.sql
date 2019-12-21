-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 21, 2019 at 08:15 AM
-- Server version: 10.1.28-MariaDB
-- PHP Version: 7.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `pegadaian`
--

-- --------------------------------------------------------

--
-- Table structure for table `barang`
--

CREATE TABLE `barang` (
  `Kode_barang` int(11) NOT NULL,
  `Nama_barang` varchar(45) DEFAULT NULL,
  `Type` varchar(45) DEFAULT NULL,
  `Warna` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `barang`
--

INSERT INTO `barang` (`Kode_barang`, `Nama_barang`, `Type`, `Warna`) VALUES
(11, 'laptop', 'elektronik', 'hitam'),
(13, 'dia', 'aku', 'suka'),
(14, 'aku', 'suka', 'dia'),
(15, 'hp', 'samsung', 'merah');

-- --------------------------------------------------------

--
-- Table structure for table `gadai`
--

CREATE TABLE `gadai` (
  `No_gadai` int(11) NOT NULL,
  `Tgl_gadai` date DEFAULT NULL,
  `Jatuh_tempo` date DEFAULT NULL,
  `Jumlah_pinjaman` double DEFAULT NULL,
  `Terbilang` varchar(45) DEFAULT NULL,
  `Tgl_tebusan` date DEFAULT NULL,
  `Jumlah_tebusan` double DEFAULT NULL,
  `Denda` double DEFAULT NULL,
  `Total_tebusan` double DEFAULT NULL,
  `Keterangan` varchar(45) DEFAULT NULL,
  `Barang_Kode_barang` int(11) NOT NULL,
  `Petugas_Nip` int(11) NOT NULL,
  `Nasabah_Ktp` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `gadai`
--

INSERT INTO `gadai` (`No_gadai`, `Tgl_gadai`, `Jatuh_tempo`, `Jumlah_pinjaman`, `Terbilang`, `Tgl_tebusan`, `Jumlah_tebusan`, `Denda`, `Total_tebusan`, `Keterangan`, `Barang_Kode_barang`, `Petugas_Nip`, `Nasabah_Ktp`) VALUES
(1, '2019-12-21', '2019-12-31', 12000000, '', '2019-12-31', 13205000, 0, 13205000, 'Sudah Ditebus', 11, 11, 1),
(2, '2019-12-21', '2019-12-26', 500000, '', '0001-01-01', 550000, 0, 550000, 'Belum Ditebus', 13, 11, 2);

-- --------------------------------------------------------

--
-- Table structure for table `nasabah`
--

CREATE TABLE `nasabah` (
  `Ktp` int(16) NOT NULL,
  `Nama` varchar(45) DEFAULT NULL,
  `Alamat` varchar(45) DEFAULT NULL,
  `Hp` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `nasabah`
--

INSERT INTO `nasabah` (`Ktp`, `Nama`, `Alamat`, `Hp`) VALUES
(1, 'Jaya', 'sumbawa', '082340245475'),
(2, 'muhammad', 'ada', '3'),
(123, 'jaya', 'karawang', '88');

-- --------------------------------------------------------

--
-- Table structure for table `petugas`
--

CREATE TABLE `petugas` (
  `Nip` int(11) NOT NULL,
  `Nama` varchar(45) DEFAULT NULL,
  `alamat` varchar(45) DEFAULT NULL,
  `username` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `level` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `petugas`
--

INSERT INTO `petugas` (`Nip`, `Nama`, `alamat`, `username`, `password`, `level`) VALUES
(7, 'ahmad', 'sumbawa', '1', '1', 'Admin'),
(10, 'anda', 'ada', '1', '1', 'Kasir'),
(11, 'Nurlana Sanjaya', 'Karawang', 'sanjaya', 'admin', 'Admin'),
(12, 'admin', 'admin', 'admin', 'admin', 'Admin'),
(13, 'jaya', 'jaya', 'jaya', 'jaya', 'Admin');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `barang`
--
ALTER TABLE `barang`
  ADD PRIMARY KEY (`Kode_barang`);

--
-- Indexes for table `gadai`
--
ALTER TABLE `gadai`
  ADD PRIMARY KEY (`No_gadai`),
  ADD KEY `fk_Gadai_Barang1_idx` (`Barang_Kode_barang`),
  ADD KEY `fk_Gadai_Petugas1_idx` (`Petugas_Nip`),
  ADD KEY `fk_Gadai_Nasabah1_idx` (`Nasabah_Ktp`);

--
-- Indexes for table `nasabah`
--
ALTER TABLE `nasabah`
  ADD PRIMARY KEY (`Ktp`);

--
-- Indexes for table `petugas`
--
ALTER TABLE `petugas`
  ADD PRIMARY KEY (`Nip`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `barang`
--
ALTER TABLE `barang`
  MODIFY `Kode_barang` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT for table `gadai`
--
ALTER TABLE `gadai`
  MODIFY `No_gadai` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `nasabah`
--
ALTER TABLE `nasabah`
  MODIFY `Ktp` int(16) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1235;

--
-- AUTO_INCREMENT for table `petugas`
--
ALTER TABLE `petugas`
  MODIFY `Nip` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `gadai`
--
ALTER TABLE `gadai`
  ADD CONSTRAINT `fk_Gadai_Barang1` FOREIGN KEY (`Barang_Kode_barang`) REFERENCES `barang` (`Kode_barang`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Gadai_Nasabah1` FOREIGN KEY (`Nasabah_Ktp`) REFERENCES `nasabah` (`Ktp`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Gadai_Petugas1` FOREIGN KEY (`Petugas_Nip`) REFERENCES `petugas` (`Nip`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
