-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 17, 2018 at 06:32 AM
-- Server version: 10.1.29-MariaDB
-- PHP Version: 7.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `programta`
--

-- --------------------------------------------------------

--
-- Table structure for table `daftar_kata`
--

CREATE TABLE `daftar_kata` (
  `nama_dokumen` varchar(50) NOT NULL,
  `kata` varchar(25) NOT NULL,
  `kategori` varchar(20) NOT NULL,
  `frek_kata` int(10) NOT NULL,
  `prob_pos` double NOT NULL,
  `prob_neg` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `daftar_kata`
--

INSERT INTO `daftar_kata` (`nama_dokumen`, `kata`, `kategori`, `frek_kata`, `prob_pos`, `prob_neg`) VALUES
('3 Nafas Likas.txt', 'separuh', 'Positif', 1, 1, 0),
('3 Nafas Likas.txt', 'nafas', 'Positif', 1, 1, 0),
('3 Nafas Likas.txt', 'likas', 'Positif', 2, 1, 0),
('3 Nafas Likas.txt', 'personal', 'Positif', 1, 1, 0),
('3 Nafas Likas.txt', 'narasinya', 'Positif', 1, 1, 0),
('3 Nafas Likas.txt', 'mengalir', 'Positif', 1, 1, 0),
('3 Nafas Likas.txt', 'balutan', 'Positif', 1, 1, 0),
('3 Nafas Likas.txt', 'visual', 'Positif', 2, 1, 0),
('3 Nafas Likas.txt', 'cantik', 'Positif', 1, 1, 0),
('3 Nafas Likas.txt', 'kamera', 'Positif', 1, 1, 0),
('3 Nafas Likas.txt', 'hani', 'Positif', 1, 1, 0),
('3 Nafas Likas.txt', 'pradigya', 'Positif', 1, 1, 0),
('3 Nafas Likas.txt', 'membawa', 'Positif', 1, 1, 0),
('3 Nafas Likas.txt', 'penonton', 'Positif', 1, 1, 0),
('3 Nafas Likas.txt', 'kesederhanaan', 'Positif', 1, 1, 0),
('3 Nafas Likas.txt', 'hidupnya', 'Positif', 1, 1, 0),
('3 Nafas Likas.txt', 'mengulik', 'Positif', 1, 1, 0),
('3 Nafas Likas.txt', 'pribadinya', 'Positif', 1, 1, 0),
('3 Nafas Likas.txt', 'cerdas', 'Positif', 1, 1, 0),
('3 Nafas Likas.txt', 'keras', 'Positif', 1, 1, 0),
('3 Nafas Likas.txt', 'halnya', 'Positif', 1, 1, 0),
('3 Nafas Likas.txt', 'mencoba', 'Positif', 1, 1, 0),
('3 Nafas Likas.txt', 'menembus', 'Positif', 1, 1, 0),
('3 Nafas Likas.txt', 'batasan', 'Positif', 1, 1, 0),
('3 Nafas Likas.txt', 'adat', 'Positif', 1, 1, 0),
('3 Nafas Likas.txt', 'budaya', 'Positif', 1, 1, 0),
('3 Nafas Likas.txt', 'patriarki', 'Positif', 1, 1, 0),
('terminal.txt', 'peristiwa', 'Negatif', 1, 0, 1),
('terminal.txt', 'disaksikan', 'Negatif', 1, 0, 1),
('terminal.txt', 'misterius', 'Negatif', 1, 0, 1),
('terminal.txt', 'ruang', 'Negatif', 1, 0, 1),
('terminal.txt', 'kontrol', 'Negatif', 1, 0, 1),
('terminal.txt', 'cctv', 'Negatif', 1, 0, 1),
('terminal.txt', 'mencoba', 'Negatif', 1, 0, 1),
('terminal.txt', 'mencerna', 'Negatif', 1, 0, 1),
('terminal.txt', 'hubungan', 'Negatif', 1, 0, 1),
('terminal.txt', 'narasi', 'Negatif', 1, 0, 1),
('terminal.txt', 'berjalan', 'Negatif', 1, 0, 1),
('terminal.txt', 'terpisah', 'Negatif', 1, 0, 1),
('terminal.txt', 'duluan', 'Negatif', 1, 0, 1),
('terminal.txt', 'sih', 'Negatif', 1, 0, 1),
('terminal.txt', 'benang', 'Negatif', 1, 0, 1),
('terminal.txt', 'merahnya', 'Negatif', 1, 0, 1),
('terminal.txt', 'karakter', 'Negatif', 2, 0, 1),
('terminal.txt', 'robbie', 'Negatif', 2, 0, 1),
('terminal.txt', 'hubungannya', 'Negatif', 1, 0, 1),
('terminal.txt', 'franklin', 'Negatif', 1, 0, 1),
('terminal.txt', 'tukang', 'Negatif', 2, 0, 1),
('terminal.txt', 'bersih', 'Negatif', 4, 0, 1),
('terminal.txt', 'diperankan', 'Negatif', 1, 0, 1),
('terminal.txt', 'wait', 'Negatif', 1, 0, 1),
('terminal.txt', 'for', 'Negatif', 1, 0, 1),
('terminal.txt', 'kaget', 'Negatif', 1, 0, 1),
('terminal.txt', 'mike', 'Negatif', 1, 0, 1),
('terminal.txt', 'myers', 'Negatif', 1, 0, 1),
('terminal.txt', 'hiatus', 'Negatif', 1, 0, 1),
('terminal.txt', 'dunia', 'Negatif', 1, 0, 1),
('terminal.txt', 'perfilman', 'Negatif', 1, 0, 1),
('terminal.txt', 'sayang', 'Negatif', 6, 0, 1),
('terminal.txt', 'sang', 'Negatif', 1, 0, 1),
('terminal.txt', 'austin', 'Negatif', 1, 0, 1),
('terminal.txt', 'powers', 'Negatif', 1, 0, 1),
('terminal.txt', 'film', 'Negatif', 1, 0, 1),
('terminal.txt', 'kesempatan', 'Negatif', 2, 0, 1),
('terminal.txt', 'bersenang', 'Negatif', 1, 0, 1),
('terminal.txt', 'senang', 'Negatif', 1, 0, 1),
('terminal.txt', 'perannya', 'Negatif', 1, 0, 1),
('terminal.txt', 'pramusaji', 'Negatif', 1, 0, 1),
('terminal.txt', 'seksi', 'Negatif', 1, 0, 1),
('terminal.txt', 'perawat', 'Negatif', 1, 0, 1),
('terminal.txt', 'penari', 'Negatif', 1, 0, 1),
('terminal.txt', 'striptis', 'Negatif', 1, 0, 1),
('terminal.txt', 'alasan', 'Negatif', 1, 0, 1),
('terminal.txt', 'menampilkan', 'Negatif', 1, 0, 1),
('terminal.txt', 'mimik', 'Negatif', 1, 0, 1),
('terminal.txt', 'wajah', 'Negatif', 1, 0, 1),
('terminal.txt', 'menggoda', 'Negatif', 1, 0, 1),
('terminal.txt', 'melontarkan', 'Negatif', 1, 0, 1),
('terminal.txt', 'komen', 'Negatif', 1, 0, 1),
('terminal.txt', 'menjurus', 'Negatif', 1, 0, 1),
('terminal.txt', 'mengejutkan', 'Negatif', 1, 0, 1),
('terminal.txt', 'orang', 'Negatif', 1, 0, 1),
('terminal.txt', 'menyadari', 'Negatif', 1, 0, 1),
('terminal.txt', 'wanita', 'Negatif', 1, 0, 1),
('terminal.txt', 'seseksi', 'Negatif', 1, 0, 1),
('terminal.txt', 'semenggoda', 'Negatif', 1, 0, 1),
('terminal.txt', 'sepercaya', 'Negatif', 2, 0, 1),
('terminal.txt', 'secerdik', 'Negatif', 1, 0, 1),
('terminal.txt', 'diduga', 'Negatif', 1, 0, 1),
('terminal.txt', 'maksud', 'Negatif', 1, 0, 1),
('terminal.txt', 'adjektiva', 'Negatif', 1, 0, 1),
('terminal.txt', 'kombinasi', 'Negatif', 1, 0, 1),
('terminal.txt', 'sifat', 'Negatif', 1, 0, 1),
('terminal.txt', 'mematikan', 'Negatif', 1, 0, 1),
('terminal.txt', 'ditulis', 'Negatif', 2, 0, 1),
('terminal.txt', 'digarap', 'Negatif', 2, 0, 1),
('terminal.txt', 'sutradara', 'Negatif', 1, 0, 1),
('terminal.txt', 'debutan', 'Negatif', 1, 0, 1),
('terminal.txt', 'vaugh', 'Negatif', 1, 0, 1),
('terminal.txt', 'stein', 'Negatif', 1, 0, 1),
('terminal.txt', 'estetika', 'Negatif', 1, 0, 1),
('terminal.txt', 'ala', 'Negatif', 1, 0, 1),
('terminal.txt', 'novel', 'Negatif', 1, 0, 1),
('terminal.txt', 'grafis', 'Negatif', 1, 0, 1),
('terminal.txt', 'miriplah', 'Negatif', 1, 0, 1),
('terminal.txt', 'diterapkan', 'Negatif', 1, 0, 1),
('terminal.txt', 'sin', 'Negatif', 2, 0, 1),
('terminal.txt', 'city', 'Negatif', 1, 0, 1),
('terminal.txt', 'filmnya', 'Negatif', 1, 0, 1),
('terminal.txt', 'nuansa', 'Negatif', 1, 0, 1),
('terminal.txt', 'teatrikal', 'Negatif', 1, 0, 1),
('terminal.txt', 'disyuting', 'Negatif', 1, 0, 1),
('terminal.txt', 'area', 'Negatif', 1, 0, 1),
('terminal.txt', 'soundstage', 'Negatif', 1, 0, 1),
('terminal.txt', 'warna', 'Negatif', 1, 0, 1),
('terminal.txt', 'lampu', 'Negatif', 1, 0, 1),
('terminal.txt', 'papan', 'Negatif', 1, 0, 1),
('terminal.txt', 'iklan', 'Negatif', 1, 0, 1),
('terminal.txt', 'neon', 'Negatif', 1, 0, 1),
('terminal.txt', 'mayoritas', 'Negatif', 2, 0, 1),
('terminal.txt', 'efek', 'Negatif', 1, 0, 1),
('terminal.txt', 'komputer', 'Negatif', 1, 0, 1),
('terminal.txt', 'menyerang', 'Negatif', 1, 0, 1);

-- --------------------------------------------------------

--
-- Table structure for table `dokumen`
--

CREATE TABLE `dokumen` (
  `id_dokumen` int(5) NOT NULL,
  `nama_dokumen` varchar(50) NOT NULL,
  `kategori` varchar(10) NOT NULL,
  `prob_positif` double NOT NULL,
  `prob_negatif` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `dokumen`
--

INSERT INTO `dokumen` (`id_dokumen`, `nama_dokumen`, `kategori`, `prob_positif`, `prob_negatif`) VALUES
(1, '3 Nafas Likas.txt', 'Positif', 1, 0),
(2, 'terminal.txt', 'Negatif', 0.5, 0.5);

-- --------------------------------------------------------

--
-- Table structure for table `hasil_klasifikasi`
--

CREATE TABLE `hasil_klasifikasi` (
  `id_dokumen` int(5) NOT NULL,
  `nama_dokumen` varchar(50) NOT NULL,
  `klasifikasi` varchar(10) NOT NULL,
  `prob_positif` double NOT NULL,
  `prob_negatif` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `kelompok_kata`
--

CREATE TABLE `kelompok_kata` (
  `kata` varchar(25) NOT NULL,
  `kelompok` varchar(10) NOT NULL,
  `jumlah` int(10) NOT NULL,
  `prob_positif` int(11) NOT NULL,
  `prob_negatif` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `kelompok_kata`
--

INSERT INTO `kelompok_kata` (`kata`, `kelompok`, `jumlah`, `prob_positif`, `prob_negatif`) VALUES
('separuh', 'Positif', 1, 0, 0),
('nafas', 'Positif', 1, 0, 0),
('likas', 'Positif', 2, 0, 0),
('personal', 'Positif', 1, 0, 0),
('narasinya', 'Positif', 1, 0, 0),
('mengalir', 'Positif', 1, 0, 0),
('balutan', 'Positif', 1, 0, 0),
('visual', 'Positif', 2, 0, 0),
('cantik', 'Positif', 1, 0, 0),
('kamera', 'Positif', 1, 0, 0),
('hani', 'Positif', 1, 0, 0),
('pradigya', 'Positif', 1, 0, 0),
('membawa', 'Positif', 1, 0, 0),
('penonton', 'Positif', 1, 0, 0),
('kesederhanaan', 'Positif', 1, 0, 0),
('hidupnya', 'Positif', 1, 0, 0),
('mengulik', 'Positif', 1, 0, 0),
('pribadinya', 'Positif', 1, 0, 0),
('cerdas', 'Positif', 1, 0, 0),
('keras', 'Positif', 1, 0, 0),
('halnya', 'Positif', 1, 0, 0),
('mencoba', 'Positif', 1, 0, 0),
('menembus', 'Positif', 1, 0, 0),
('batasan', 'Positif', 1, 0, 0),
('adat', 'Positif', 1, 0, 0),
('budaya', 'Positif', 1, 0, 0),
('patriarki', 'Positif', 1, 0, 0),
('peristiwa', 'Negatif', 1, 0, 0),
('disaksikan', 'Negatif', 1, 0, 0),
('misterius', 'Negatif', 1, 0, 0),
('ruang', 'Negatif', 1, 0, 0),
('kontrol', 'Negatif', 1, 0, 0),
('cctv', 'Negatif', 1, 0, 0),
('mencoba', 'Negatif', 1, 0, 0),
('mencerna', 'Negatif', 1, 0, 0),
('hubungan', 'Negatif', 1, 0, 0),
('narasi', 'Negatif', 1, 0, 0),
('berjalan', 'Negatif', 1, 0, 0),
('terpisah', 'Negatif', 1, 0, 0),
('duluan', 'Negatif', 1, 0, 0),
('sih', 'Negatif', 1, 0, 0),
('benang', 'Negatif', 1, 0, 0),
('merahnya', 'Negatif', 1, 0, 0),
('karakter', 'Negatif', 2, 0, 0),
('robbie', 'Negatif', 2, 0, 0),
('hubungannya', 'Negatif', 1, 0, 0),
('franklin', 'Negatif', 1, 0, 0),
('tukang', 'Negatif', 2, 0, 0),
('bersih', 'Negatif', 4, 0, 0),
('diperankan', 'Negatif', 1, 0, 0),
('wait', 'Negatif', 1, 0, 0),
('for', 'Negatif', 1, 0, 0),
('kaget', 'Negatif', 1, 0, 0),
('mike', 'Negatif', 1, 0, 0),
('myers', 'Negatif', 1, 0, 0),
('hiatus', 'Negatif', 1, 0, 0),
('dunia', 'Negatif', 1, 0, 0),
('perfilman', 'Negatif', 1, 0, 0),
('sayang', 'Negatif', 6, 0, 0),
('sang', 'Negatif', 1, 0, 0),
('austin', 'Negatif', 1, 0, 0),
('powers', 'Negatif', 1, 0, 0),
('film', 'Negatif', 1, 0, 0),
('kesempatan', 'Negatif', 2, 0, 0),
('bersenang', 'Negatif', 1, 0, 0),
('senang', 'Negatif', 1, 0, 0),
('perannya', 'Negatif', 1, 0, 0),
('pramusaji', 'Negatif', 1, 0, 0),
('seksi', 'Negatif', 1, 0, 0),
('perawat', 'Negatif', 1, 0, 0),
('penari', 'Negatif', 1, 0, 0),
('striptis', 'Negatif', 1, 0, 0),
('alasan', 'Negatif', 1, 0, 0),
('menampilkan', 'Negatif', 1, 0, 0),
('mimik', 'Negatif', 1, 0, 0),
('wajah', 'Negatif', 1, 0, 0),
('menggoda', 'Negatif', 1, 0, 0),
('melontarkan', 'Negatif', 1, 0, 0),
('komen', 'Negatif', 1, 0, 0),
('menjurus', 'Negatif', 1, 0, 0),
('mengejutkan', 'Negatif', 1, 0, 0),
('orang', 'Negatif', 1, 0, 0),
('menyadari', 'Negatif', 1, 0, 0),
('wanita', 'Negatif', 1, 0, 0),
('seseksi', 'Negatif', 1, 0, 0),
('semenggoda', 'Negatif', 1, 0, 0),
('sepercaya', 'Negatif', 2, 0, 0),
('secerdik', 'Negatif', 1, 0, 0),
('diduga', 'Negatif', 1, 0, 0),
('maksud', 'Negatif', 1, 0, 0),
('adjektiva', 'Negatif', 1, 0, 0),
('kombinasi', 'Negatif', 1, 0, 0),
('sifat', 'Negatif', 1, 0, 0),
('mematikan', 'Negatif', 1, 0, 0),
('ditulis', 'Negatif', 2, 0, 0),
('digarap', 'Negatif', 2, 0, 0),
('sutradara', 'Negatif', 1, 0, 0),
('debutan', 'Negatif', 1, 0, 0),
('vaugh', 'Negatif', 1, 0, 0),
('stein', 'Negatif', 1, 0, 0),
('estetika', 'Negatif', 1, 0, 0),
('ala', 'Negatif', 1, 0, 0),
('novel', 'Negatif', 1, 0, 0),
('grafis', 'Negatif', 1, 0, 0),
('miriplah', 'Negatif', 1, 0, 0),
('diterapkan', 'Negatif', 1, 0, 0),
('sin', 'Negatif', 2, 0, 0),
('city', 'Negatif', 1, 0, 0),
('filmnya', 'Negatif', 1, 0, 0),
('nuansa', 'Negatif', 1, 0, 0),
('teatrikal', 'Negatif', 1, 0, 0),
('disyuting', 'Negatif', 1, 0, 0),
('area', 'Negatif', 1, 0, 0),
('soundstage', 'Negatif', 1, 0, 0),
('warna', 'Negatif', 1, 0, 0),
('lampu', 'Negatif', 1, 0, 0),
('papan', 'Negatif', 1, 0, 0),
('iklan', 'Negatif', 1, 0, 0),
('neon', 'Negatif', 1, 0, 0),
('mayoritas', 'Negatif', 2, 0, 0),
('efek', 'Negatif', 1, 0, 0),
('komputer', 'Negatif', 1, 0, 0),
('menyerang', 'Negatif', 1, 0, 0);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `dokumen`
--
ALTER TABLE `dokumen`
  ADD PRIMARY KEY (`id_dokumen`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `dokumen`
--
ALTER TABLE `dokumen`
  MODIFY `id_dokumen` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
