-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 02, 2024 at 04:54 PM
-- Server version: 10.4.27-MariaDB
-- PHP Version: 8.1.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `penjualan`
--

-- --------------------------------------------------------

--
-- Table structure for table `tbl_barang`
--

CREATE TABLE `tbl_barang` (
  `nama_barang` varchar(255) DEFAULT NULL,
  `harga_beli` int(11) DEFAULT NULL,
  `harga_jual` int(11) DEFAULT NULL,
  `tanggal_masuk` date DEFAULT NULL,
  `jumlah_barang` varchar(100) DEFAULT NULL,
  `kd_barang` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tbl_barang`
--

INSERT INTO `tbl_barang` (`nama_barang`, `harga_beli`, `harga_jual`, `tanggal_masuk`, `jumlah_barang`, `kd_barang`) VALUES
('indomie', 3000, 10000, '2024-06-26', '0', 'B0001'),
('yakul', 1000, 4000, '2024-06-26', '7', 'B0002'),
('power f', 3000, 4000, '2024-06-26', '0', 'B0003'),
('sarimi', 3000, 5000, '2024-07-02', '20', 'B0004');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_hitung_jual`
--

CREATE TABLE `tbl_hitung_jual` (
  `id_hitung` int(11) NOT NULL,
  `kd_barang` varchar(11) DEFAULT NULL,
  `nama_barang` varchar(11) DEFAULT NULL,
  `hsatuan` int(11) DEFAULT NULL,
  `jumlah_jual` int(11) DEFAULT NULL,
  `harga` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Triggers `tbl_hitung_jual`
--
DELIMITER $$
CREATE TRIGGER `tr_batal` AFTER DELETE ON `tbl_hitung_jual` FOR EACH ROW BEGIN UPDATE tbl_barang set jumlah_barang=jumlah_barang+old.jumlah_jual where kd_barang=old.kd_barang; END
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `tr_jual` AFTER INSERT ON `tbl_hitung_jual` FOR EACH ROW BEGIN
UPDATE tbl_barang set jumlah_barang=jumlah_barang - new.jumlah_jual 
WHERE kd_barang=new.kd_barang;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `tbl_login`
--

CREATE TABLE `tbl_login` (
  `username` varchar(255) NOT NULL,
  `password` varchar(100) NOT NULL,
  `jenis_kelamin` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `no_telp` int(100) NOT NULL,
  `agama` varchar(100) NOT NULL,
  `alamat` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tbl_login`
--

INSERT INTO `tbl_login` (`username`, `password`, `jenis_kelamin`, `email`, `no_telp`, `agama`, `alamat`) VALUES
('a', 'a', 'Laki-laki', 'a', 1, 'Islam', 'a'),
('ajriuserman', 'aka12345', 'laki-laki', 'ajrishiddik@gmail.com', 893213890, 'islam', 'hergamana'),
('sumiati', '1232', 'Perempuan', 'sumiati123', 892131234, 'Islam', 'sersan');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_penjualan`
--

CREATE TABLE `tbl_penjualan` (
  `nofaktur` varchar(11) NOT NULL,
  `kd_barang` varchar(11) NOT NULL,
  `nama_barang` varchar(50) NOT NULL,
  `hsatuan` int(11) NOT NULL,
  `jumlah_jual` int(11) NOT NULL,
  `harga` int(11) NOT NULL,
  `bayar` int(11) NOT NULL,
  `kembalian` int(11) NOT NULL,
  `tanggal` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tbl_penjualan`
--

INSERT INTO `tbl_penjualan` (`nofaktur`, `kd_barang`, `nama_barang`, `hsatuan`, `jumlah_jual`, `harga`, `bayar`, `kembalian`, `tanggal`) VALUES
('F0001', 'B0001', 'indomie', 10000, 20, 200000, 300000, 24000, '2024-07-02'),
('F0002', 'B0002', 'yakul', 4000, 3, 12000, 20000, 4000, '2024-07-02'),
('F0003', 'B0002', 'yakul', 4000, 20, 80000, 100000, 20000, '2024-07-02');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tbl_barang`
--
ALTER TABLE `tbl_barang`
  ADD PRIMARY KEY (`kd_barang`);

--
-- Indexes for table `tbl_hitung_jual`
--
ALTER TABLE `tbl_hitung_jual`
  ADD PRIMARY KEY (`id_hitung`);

--
-- Indexes for table `tbl_login`
--
ALTER TABLE `tbl_login`
  ADD PRIMARY KEY (`username`);

--
-- Indexes for table `tbl_penjualan`
--
ALTER TABLE `tbl_penjualan`
  ADD PRIMARY KEY (`nofaktur`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tbl_hitung_jual`
--
ALTER TABLE `tbl_hitung_jual`
  MODIFY `id_hitung` int(11) NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
