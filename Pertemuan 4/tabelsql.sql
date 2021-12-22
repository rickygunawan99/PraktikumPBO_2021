-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 09 Des 2021 pada 09.06
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
-- Database: `tugasasistensi`
--
CREATE DATABASE IF NOT EXISTS `tugasasistensi` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `tugasasistensi`;

-- --------------------------------------------------------

--
-- Struktur dari tabel `admin`
--

CREATE TABLE `admin` (
  `id` int(11) NOT NULL,
  `nama` varchar(50) NOT NULL,
  `id_admin` varchar(50) NOT NULL,
  `no_telp` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `admin`
--

INSERT INTO `admin` (`id`, `nama`, `id_admin`, `no_telp`, `password`) VALUES
(1, 'admin1', '123', '1243', '132');

-- --------------------------------------------------------

--
-- Struktur dari tabel `datapembeli`
--

CREATE TABLE `datapembeli` (
  `id` int(11) NOT NULL,
  `nama` varchar(50) NOT NULL,
  `nama_akun` varchar(50) NOT NULL,
  `id_akun` varchar(50) NOT NULL,
  `notelp` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `datapembeli`
--

INSERT INTO `datapembeli` (`id`, `nama`, `nama_akun`, `id_akun`, `notelp`) VALUES
(1, 'a', '412', '222', '999'),
(2, 'test1', '-', '-', 'test1'),
(3, 'Ricky', '404notfound', '12398', '081259279'),
(4, 'Ricky', 'ce', '9881', '081299'),
(5, 'Bd', 'ca', '981', '0912'),
(6, 'l', '-', '9128', '123'),
(7, 'use', 'ui', '91283', '0192'),
(8, '-', '-', '-', '-'),
(9, 'fjfjfj', 'tdhgj', '5768', '977979');

-- --------------------------------------------------------

--
-- Struktur dari tabel `datatransaksi`
--

CREATE TABLE `datatransaksi` (
  `id` int(11) NOT NULL,
  `nama` varchar(50) NOT NULL,
  `notelp` varchar(50) NOT NULL,
  `voucher` varchar(50) NOT NULL,
  `nominal` varchar(50) NOT NULL,
  `harga` varchar(50) NOT NULL,
  `id_akun` varchar(50) NOT NULL,
  `nama_akun` varchar(50) NOT NULL,
  `total_bayar` varchar(50) NOT NULL,
  `kembalian` varchar(50) NOT NULL,
  `status` int(11) NOT NULL DEFAULT 0,
  `temp` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `datatransaksi`
--

INSERT INTO `datatransaksi` (`id`, `nama`, `notelp`, `voucher`, `nominal`, `harga`, `id_akun`, `nama_akun`, `total_bayar`, `kembalian`, `status`, `temp`) VALUES
(1, 'abc', '123', 'game1', '123', '2500', 'ss', 'nama1', '5000', '2500', 1, NULL),
(2, 'fff', '123', 'game2', '123', '4500', 'ss', 'nama2', '5000', '500', 0, NULL),
(3, 'test1', 'test1', 'DM3', '1', '600', '-', '-', '5000', '4400', 0, NULL),
(4, 'Ricky', '081259279', 'DM3', '2', '600', '12398', '404notfound', '1900', '700', 1, NULL),
(5, 'Ricky', '081299', 'DM', '2', '100', '9881', 'ce', '9000', '8800', 0, NULL),
(6, 'Bd', '0912', 'MobileLegend', '2', '250000', '981', 'ca', '1000000', '500000', 0, NULL),
(7, 'l', '123', 'MobileLegend', '3', '250000', '9128', '-', '800000', '50000', 0, NULL),
(8, 'use', '0192', 'MobileLegend', '3', '250000', '91283', 'ui', '800000', '50000', 1, NULL),
(9, '-', '-', 'DM', '1', '100', '-', '-', '500', '400', 1, NULL),
(10, 'fjfjfj', '977979', 'DM', '3', '200', '5768', 'tdhgj', '8000', '7400', 0, NULL);

-- --------------------------------------------------------

--
-- Struktur dari tabel `listproduk`
--

CREATE TABLE `listproduk` (
  `id` int(11) NOT NULL,
  `nama` varchar(50) NOT NULL,
  `kode` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `listproduk`
--

INSERT INTO `listproduk` (`id`, `nama`, `kode`) VALUES
(1, 'DM', 1),
(2, 'DM2', 2),
(3, 'DM3', 3);

-- --------------------------------------------------------

--
-- Struktur dari tabel `produk`
--

CREATE TABLE `produk` (
  `id` int(11) NOT NULL,
  `nama_produk` varchar(50) NOT NULL,
  `nominal` varchar(50) NOT NULL,
  `harga_produk` varchar(50) NOT NULL,
  `kode_produk` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `produk`
--

INSERT INTO `produk` (`id`, `nama_produk`, `nominal`, `harga_produk`, `kode_produk`) VALUES
(7, 'DM', '500', '100', 1),
(8, 'DM', '600', '200', 1),
(10, 'DM2', '300', '500', 2),
(11, 'DM3', '300', '500', 3),
(12, 'DM3', '500', '600', 3),
(13, 'DM3', '1000', '2500000', 3);

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`id`);

--
-- Indeks untuk tabel `datapembeli`
--
ALTER TABLE `datapembeli`
  ADD PRIMARY KEY (`id`);

--
-- Indeks untuk tabel `datatransaksi`
--
ALTER TABLE `datatransaksi`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_datatransaksi_admin` (`temp`) USING BTREE;

--
-- Indeks untuk tabel `listproduk`
--
ALTER TABLE `listproduk`
  ADD PRIMARY KEY (`id`);

--
-- Indeks untuk tabel `produk`
--
ALTER TABLE `produk`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `admin`
--
ALTER TABLE `admin`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT untuk tabel `datapembeli`
--
ALTER TABLE `datapembeli`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT untuk tabel `datatransaksi`
--
ALTER TABLE `datatransaksi`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT untuk tabel `listproduk`
--
ALTER TABLE `listproduk`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT untuk tabel `produk`
--
ALTER TABLE `produk`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- Ketidakleluasaan untuk tabel pelimpahan (Dumped Tables)
--

--
-- Ketidakleluasaan untuk tabel `datatransaksi`
--
ALTER TABLE `datatransaksi`
  ADD CONSTRAINT `FK_datatransaksi_admin` FOREIGN KEY (`temp`) REFERENCES `admin` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
