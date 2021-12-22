-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 22 Des 2021 pada 16.37
-- Versi server: 10.4.20-MariaDB
-- Versi PHP: 8.0.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `pbo2021_3`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `gudangsepatu`
--

CREATE TABLE `gudangsepatu` (
  `id` int(11) NOT NULL,
  `nama` varchar(50) NOT NULL,
  `stock` int(11) NOT NULL DEFAULT 0,
  `size` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `gudangsepatu`
--

INSERT INTO `gudangsepatu` (`id`, `nama`, `stock`, `size`) VALUES
(6, 'sepatu1', 12, 39),
(9, 'Adidas', 50, 42),
(10, 'sepatu3', 14, 14);

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `gudangsepatu`
--
ALTER TABLE `gudangsepatu`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `gudangsepatu`
--
ALTER TABLE `gudangsepatu`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
