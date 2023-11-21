-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th10 21, 2023 lúc 06:23 PM
-- Phiên bản máy phục vụ: 10.4.28-MariaDB
-- Phiên bản PHP: 8.0.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `smarthomedb`
--
CREATE DATABASE IF NOT EXISTS `smarthomedb` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `smarthomedb`;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `devices`
--

CREATE TABLE `devices` (
  `DEVICE_ID` int(10) NOT NULL,
  `FLOOR_ID` int(11) DEFAULT NULL,
  `HOUSE_ID` int(11) DEFAULT NULL,
  `USER_ACCOUNT_ID` int(11) NOT NULL,
  `DEVICE_STATUS` int(5) DEFAULT NULL,
  `DEVICE_NAME` varchar(50) DEFAULT NULL,
  `DEVICE_TYPE` int(5) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- RELATIONSHIPS FOR TABLE `devices`:
--   `USER_ACCOUNT_ID`
--       `user_account` -> `USER_ACCOUNT_ID`
--

--
-- Đang đổ dữ liệu cho bảng `devices`
--

INSERT INTO `devices` (`DEVICE_ID`, `FLOOR_ID`, `HOUSE_ID`, `USER_ACCOUNT_ID`, `DEVICE_STATUS`, `DEVICE_NAME`, `DEVICE_TYPE`) VALUES
(1, 1, 1, 2, 0, 'Light-phong-khach', 0),
(2, 1, 1, 2, 0, 'quattang1', 1),
(3, 1, 1, 2, 0, 'ledtang1', 0);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `user_account`
--

CREATE TABLE `user_account` (
  `USER_ACCOUNT_ID` int(11) NOT NULL,
  `USERNAME` varchar(50) NOT NULL,
  `PASSWORD` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- RELATIONSHIPS FOR TABLE `user_account`:
--

--
-- Đang đổ dữ liệu cho bảng `user_account`
--

INSERT INTO `user_account` (`USER_ACCOUNT_ID`, `USERNAME`, `PASSWORD`) VALUES
(1, 'admin', 'admin'),
(2, 'danhquy2502', '12345678'),
(4, 'createUsername', 'password');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `user_account_seq`
--

CREATE TABLE `user_account_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- RELATIONSHIPS FOR TABLE `user_account_seq`:
--

--
-- Đang đổ dữ liệu cho bảng `user_account_seq`
--

INSERT INTO `user_account_seq` (`next_val`) VALUES
(1);

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `devices`
--
ALTER TABLE `devices`
  ADD PRIMARY KEY (`DEVICE_ID`),
  ADD KEY `devices_ibfk_1` (`USER_ACCOUNT_ID`);

--
-- Chỉ mục cho bảng `user_account`
--
ALTER TABLE `user_account`
  ADD PRIMARY KEY (`USER_ACCOUNT_ID`),
  ADD UNIQUE KEY `USERNAME` (`USERNAME`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `devices`
--
ALTER TABLE `devices`
  MODIFY `DEVICE_ID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT cho bảng `user_account`
--
ALTER TABLE `user_account`
  MODIFY `USER_ACCOUNT_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `devices`
--
ALTER TABLE `devices`
  ADD CONSTRAINT `devices_ibfk_1` FOREIGN KEY (`USER_ACCOUNT_ID`) REFERENCES `user_account` (`USER_ACCOUNT_ID`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
