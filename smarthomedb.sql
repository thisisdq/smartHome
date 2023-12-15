-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th12 15, 2023 lúc 10:42 AM
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

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `devices`
--

CREATE TABLE `devices` (
  `DEVICE_ID` int(10) NOT NULL,
  `DEVICE_NAME` varchar(50) DEFAULT NULL,
  `DEVICE_STATUS` varchar(50) DEFAULT NULL,
  `DEVICE_TYPE` varchar(50) DEFAULT NULL,
  `DEVICE_VALUE` int(11) DEFAULT NULL,
  `is_Running` int(11) DEFAULT 0,
  `ROOM_ID` int(10) DEFAULT NULL,
  `DEVICE_PORT` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `devices`
--

INSERT INTO `devices` (`DEVICE_ID`, `DEVICE_NAME`, `DEVICE_STATUS`, `DEVICE_TYPE`, `DEVICE_VALUE`, `is_Running`, `ROOM_ID`, `DEVICE_PORT`) VALUES
(1, 'Máy pha cafe', 'Đang tắt', NULL, 0, 0, 1, NULL),
(2, 'Máy đun nước', 'Đang tắt', NULL, 0, 0, 1, NULL),
(3, 'Đèn quầy', 'Đang tắt', NULL, 0, 0, 1, NULL),
(4, 'Đèn Phòng 101', 'Đang bật', NULL, 1, 1, 2, NULL),
(5, 'Đèn Phòng 102', 'Đang bật', NULL, 1, 1, 3, NULL),
(6, 'Đèn Phòng 103', 'Đang bật', NULL, 1, 1, 4, NULL),
(7, 'Đèn ngủ', 'Đang tắt', NULL, 0, 0, 5, NULL),
(8, 'Đèn ngủ', 'Đang tắt', NULL, 0, 0, 6, NULL),
(9, 'TV', 'Đang tắt', NULL, 0, 0, 7, NULL),
(10, 'Điều hoà', 'Đang tắt', NULL, 0, 0, 7, NULL),
(11, 'Đèn ban công', 'Đang tắt', NULL, 0, 0, 8, NULL),
(12, 'Nhiệt độ tại quầy', 'đang tắt', NULL, 0, 0, 1, NULL),
(13, 'Độ ẩm tại quầy', 'đang tắt', NULL, 0, 0, 1, NULL),
(14, 'Điều hoà P101', 'Đang tắt', NULL, 0, 0, 2, NULL),
(15, 'Điều hoà P102', 'Đang tắt', NULL, 0, 0, 3, NULL),
(16, 'Điều hoà P103', 'Đang tắt', NULL, 0, 0, 3, NULL);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `floors`
--

CREATE TABLE `floors` (
  `FLOOR_ID` int(10) NOT NULL,
  `FLOOR_NAME` varchar(50) DEFAULT NULL,
  `HOUSE_ID` int(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `floors`
--

INSERT INTO `floors` (`FLOOR_ID`, `FLOOR_NAME`, `HOUSE_ID`) VALUES
(1, 'Tầng 1 - Quán CAFE', 1),
(2, 'Tầng 2 - Nhà ở', 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `houses`
--

CREATE TABLE `houses` (
  `HOUSE_ID` int(10) NOT NULL,
  `USER_ID` int(11) DEFAULT NULL,
  `ADDRESS` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `houses`
--

INSERT INTO `houses` (`HOUSE_ID`, `USER_ID`, `ADDRESS`) VALUES
(1, 2, '1 Dai Co Viet');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `rooms`
--

CREATE TABLE `rooms` (
  `ROOM_ID` int(10) NOT NULL,
  `ROOM_NAME` varchar(50) DEFAULT NULL,
  `FlOOR_ID` int(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `rooms`
--

INSERT INTO `rooms` (`ROOM_ID`, `ROOM_NAME`, `FlOOR_ID`) VALUES
(1, 'Quầy pha Cafe', 1),
(2, 'Phòng 101', 1),
(3, 'Phòng 102', 1),
(4, 'Phòng 103', 1),
(5, 'Phòng ngủ 1', 2),
(6, 'Phòng ngủ 2', 2),
(7, 'Phòng khách', 2),
(8, 'Ban công', 2);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `user_account`
--

CREATE TABLE `user_account` (
  `USER_ACCOUNT_ID` int(11) NOT NULL,
  `USERNAME` varchar(50) NOT NULL,
  `PASSWORD` varchar(50) NOT NULL,
  `FULLNAME` varchar(50) DEFAULT 'User Account'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `user_account`
--

INSERT INTO `user_account` (`USER_ACCOUNT_ID`, `USERNAME`, `PASSWORD`, `FULLNAME`) VALUES
(1, 'admin', 'admin', 'Admin'),
(2, 'danhquy2502', '12345678', 'Danh Quý'),
(4, 'createUsername', 'password', 'User Full Name');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `user_account_seq`
--

CREATE TABLE `user_account_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

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
  ADD KEY `device_room_fk` (`ROOM_ID`);

--
-- Chỉ mục cho bảng `floors`
--
ALTER TABLE `floors`
  ADD PRIMARY KEY (`FLOOR_ID`),
  ADD KEY `floor_house_fk` (`HOUSE_ID`);

--
-- Chỉ mục cho bảng `houses`
--
ALTER TABLE `houses`
  ADD PRIMARY KEY (`HOUSE_ID`),
  ADD KEY `house_user_fk` (`USER_ID`);

--
-- Chỉ mục cho bảng `rooms`
--
ALTER TABLE `rooms`
  ADD PRIMARY KEY (`ROOM_ID`);

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
  MODIFY `DEVICE_ID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT cho bảng `floors`
--
ALTER TABLE `floors`
  MODIFY `FLOOR_ID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT cho bảng `houses`
--
ALTER TABLE `houses`
  MODIFY `HOUSE_ID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT cho bảng `rooms`
--
ALTER TABLE `rooms`
  MODIFY `ROOM_ID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

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
  ADD CONSTRAINT `device_room_fk` FOREIGN KEY (`ROOM_ID`) REFERENCES `rooms` (`ROOM_ID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Các ràng buộc cho bảng `floors`
--
ALTER TABLE `floors`
  ADD CONSTRAINT `floor_house_fk` FOREIGN KEY (`HOUSE_ID`) REFERENCES `houses` (`HOUSE_ID`);

--
-- Các ràng buộc cho bảng `houses`
--
ALTER TABLE `houses`
  ADD CONSTRAINT `house_user_fk` FOREIGN KEY (`USER_ID`) REFERENCES `user_account` (`USER_ACCOUNT_ID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
