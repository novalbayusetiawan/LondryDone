-- phpMyAdmin SQL Dump
-- version 4.4.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Jun 09, 2016 at 07:26 AM
-- Server version: 5.6.26
-- PHP Version: 5.5.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_laundry`
--

-- --------------------------------------------------------

--
-- Table structure for table `barang`
--

CREATE TABLE IF NOT EXISTS `barang` (
  `id_barang` int(5) NOT NULL,
  `nama_barang` varchar(25) NOT NULL,
  `harga_barang` int(10) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `barang`
--

INSERT INTO `barang` (`id_barang`, `nama_barang`, `harga_barang`) VALUES
(1, 'Pakaian', 5000),
(2, 'Selimut', 25000),
(3, 'Bed Cover', 30000),
(5, 'Ambal', 45000),
(6, 'Spring Bed', 50000);

-- --------------------------------------------------------

--
-- Table structure for table `item`
--

CREATE TABLE IF NOT EXISTS `item` (
  `id_item` int(5) NOT NULL,
  `id_barang` int(5) NOT NULL,
  `id_layanan` int(5) NOT NULL,
  `id_transaksi` int(5) NOT NULL,
  `Harga` float NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `item`
--

INSERT INTO `item` (`id_item`, `id_barang`, `id_layanan`, `id_transaksi`, `Harga`) VALUES
(21, 5, 3, 13, 90000),
(22, 2, 3, 13, 50000),
(27, 6, 2, 16, 121500),
(28, 1, 1, 17, 25000),
(29, 3, 1, 17, 270000);

-- --------------------------------------------------------

--
-- Table structure for table `konsumen`
--

CREATE TABLE IF NOT EXISTS `konsumen` (
  `id_konsumen` int(5) NOT NULL,
  `nama` varchar(25) NOT NULL,
  `telepon` varchar(25) NOT NULL,
  `jalan` varchar(50) NOT NULL,
  `kecamatan` varchar(50) NOT NULL,
  `kota` varchar(50) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `konsumen`
--

INSERT INTO `konsumen` (`id_konsumen`, `nama`, `telepon`, `jalan`, `kecamatan`, `kota`) VALUES
(4, 'vinda nur vadilla', '085815820915', 'jalan perjuangan', 'samarinda', 'samarinda'),
(8, 'askdjalkj', '123123', 'jlkajsdlkasjldk', 'jlkjaklsjdlksaj', 'kjlkajs'),
(10, 'Artita', '0821212121', 'Revolusi', 'Sungai Kunjang', 'Samarinda'),
(12, 'Noval Bayu Setiawan', '00000001', 'Cendana', 'Sungai Kunjang', 'Samarinda'),
(14, 'Josh Dun', '09898987', 'Suryanata', 'Teluk Lerong', 'michigan'),
(16, 'Angelina Jolie', '085290190', 'Bengkuring', 'Sempaja', 'Samarinda'),
(17, 'Jah Rakal', '08111011', 'Dota', 'Dota Residance', 'Warcraft'),
(18, 'Jackson Mikel', '-', 'Seoul', 'Seoul', 'Korengan'),
(19, 'Prano', '123123102', 'Gunung', 'Sempaja', 'Samarinda'),
(20, 'Jim', '092221', 'jalan', 'Keca', 'Samarinda'),
(21, 'Vinda Nur Vadilla', '00821213', 'pada sayur', 'bengkuring', 'Samarinda'),
(22, 'Lewandowsky', '0822011121', 'Gajah mada', 'Samarinda kota', 'samarinda'),
(23, 'Edy Budiman', '0822211922', 'Gelatik', 'Samarinda', 'Samarinda');

-- --------------------------------------------------------

--
-- Table structure for table `layanan`
--

CREATE TABLE IF NOT EXISTS `layanan` (
  `id_layanan` int(5) NOT NULL,
  `nama_layanan` varchar(25) NOT NULL,
  `harga_layanan` float NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `layanan`
--

INSERT INTO `layanan` (`id_layanan`, `nama_layanan`, `harga_layanan`) VALUES
(1, 'Cuci Kering', 1),
(2, 'Cuci Setrika', 1.5),
(3, 'Cuci Express', 2);

-- --------------------------------------------------------

--
-- Table structure for table `operator`
--

CREATE TABLE IF NOT EXISTS `operator` (
  `id_operator` int(5) NOT NULL,
  `username` varchar(10) NOT NULL,
  `password` varchar(10) NOT NULL,
  `fullname` varchar(20) NOT NULL,
  `level` int(4) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `operator`
--

INSERT INTO `operator` (`id_operator`, `username`, `password`, `fullname`, `level`) VALUES
(1, 'admin', 'admin123', 'Administrator', 1),
(3, 'vinda', 'vinda', 'vinda nv', 0),
(7, 'vinda', 'vinda', 'vinda nv', 2),
(8, 'yasmin', 'yasmin123', 'yasmine', 2),
(9, 'asdar', 'asdar', 'asdar', 2),
(10, 'iinnur123', 'iinnur123', 'Iin Nurkarima', 2);

-- --------------------------------------------------------

--
-- Table structure for table `transaksi`
--

CREATE TABLE IF NOT EXISTS `transaksi` (
  `id_konsumen` int(5) NOT NULL,
  `id_transaksi` int(5) NOT NULL,
  `tanggal_masuk` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `tanggal_keluar` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `status` varchar(15) NOT NULL,
  `id_operator` int(5) NOT NULL,
  `harga_transaksi` float NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `transaksi`
--

INSERT INTO `transaksi` (`id_konsumen`, `id_transaksi`, `tanggal_masuk`, `tanggal_keluar`, `status`, `id_operator`, `harga_transaksi`) VALUES
(14, 11, '2016-05-28 08:03:07', '2016-05-31 08:02:22', 'Sudah diambil', 1, 6750),
(16, 13, '2016-05-29 09:34:50', '2016-05-30 09:34:05', 'Sudah diambil', 3, 140000),
(19, 16, '2016-05-30 04:16:03', '2016-05-31 04:09:24', 'Sudah diambil', 1, 121500),
(23, 17, '2016-06-09 05:21:47', '2016-06-10 05:15:28', 'Sudah diambil', 9, 445000);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `barang`
--
ALTER TABLE `barang`
  ADD PRIMARY KEY (`id_barang`),
  ADD KEY `id_barang` (`id_barang`);

--
-- Indexes for table `item`
--
ALTER TABLE `item`
  ADD PRIMARY KEY (`id_item`),
  ADD KEY `id_barang` (`id_barang`),
  ADD KEY `id_layanan` (`id_layanan`),
  ADD KEY `id_konsumen` (`id_transaksi`),
  ADD KEY `id_transaksi` (`id_transaksi`);

--
-- Indexes for table `konsumen`
--
ALTER TABLE `konsumen`
  ADD PRIMARY KEY (`id_konsumen`);

--
-- Indexes for table `layanan`
--
ALTER TABLE `layanan`
  ADD PRIMARY KEY (`id_layanan`),
  ADD KEY `id_layanan` (`id_layanan`);

--
-- Indexes for table `operator`
--
ALTER TABLE `operator`
  ADD PRIMARY KEY (`id_operator`),
  ADD KEY `id_operator` (`id_operator`);

--
-- Indexes for table `transaksi`
--
ALTER TABLE `transaksi`
  ADD PRIMARY KEY (`id_transaksi`),
  ADD KEY `id_transaksi` (`id_transaksi`),
  ADD KEY `id_operator` (`id_operator`),
  ADD KEY `id_konsumen` (`id_konsumen`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `barang`
--
ALTER TABLE `barang`
  MODIFY `id_barang` int(5) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT for table `item`
--
ALTER TABLE `item`
  MODIFY `id_item` int(5) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=30;
--
-- AUTO_INCREMENT for table `konsumen`
--
ALTER TABLE `konsumen`
  MODIFY `id_konsumen` int(5) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=24;
--
-- AUTO_INCREMENT for table `layanan`
--
ALTER TABLE `layanan`
  MODIFY `id_layanan` int(5) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `operator`
--
ALTER TABLE `operator`
  MODIFY `id_operator` int(5) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=11;
--
-- AUTO_INCREMENT for table `transaksi`
--
ALTER TABLE `transaksi`
  MODIFY `id_transaksi` int(5) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=18;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `item`
--
ALTER TABLE `item`
  ADD CONSTRAINT `item_ibfk_1` FOREIGN KEY (`id_barang`) REFERENCES `barang` (`id_barang`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `item_ibfk_2` FOREIGN KEY (`id_layanan`) REFERENCES `layanan` (`id_layanan`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `item_ibfk_3` FOREIGN KEY (`id_transaksi`) REFERENCES `transaksi` (`id_transaksi`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `transaksi`
--
ALTER TABLE `transaksi`
  ADD CONSTRAINT `transaksi_ibfk_1` FOREIGN KEY (`id_konsumen`) REFERENCES `konsumen` (`id_konsumen`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `transaksi_ibfk_2` FOREIGN KEY (`id_operator`) REFERENCES `operator` (`id_operator`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
