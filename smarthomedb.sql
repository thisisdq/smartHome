-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th2 16, 2024 lúc 03:07 PM
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
  `DEVICE_TYPE_ID` int(30) DEFAULT NULL,
  `DEVICE_VALUE` float DEFAULT NULL,
  `is_Running` int(11) NOT NULL DEFAULT 0,
  `ROOM_ID` int(10) DEFAULT NULL,
  `DEVICE_PORT` varchar(10) DEFAULT NULL,
  `USER_ACCOUNT_ID` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `devices`
--

INSERT INTO `devices` (`DEVICE_ID`, `DEVICE_NAME`, `DEVICE_STATUS`, `DEVICE_TYPE_ID`, `DEVICE_VALUE`, `is_Running`, `ROOM_ID`, `DEVICE_PORT`, `USER_ACCOUNT_ID`) VALUES
(1, 'Đèn bếp', 'D0', 11, NULL, 1, 1, 'D0', 2),
(2, 'Máy đun nước', 'D1', 1, NULL, 1, 1, 'D1', 2),
(3, 'Đèn báo cháy', 'D3', 1, NULL, 1, 1, NULL, 2),
(4, 'Đèn Phòng Lớn', 'D4', 1, NULL, 0, 2, 'D4', 2),
(5, 'Đèn Phòng Nhỏ', 'D5', 1, NULL, 0, 3, 'D5', 2),
(6, 'Đèn Phòng Khách', 'D6', 1, NULL, 1, 4, 'D6', 2),
(7, 'TV', 'D7', 7, NULL, 0, 4, 'D7', 2),
(8, 'Điều hoà PNL', 'D8', 4, NULL, 0, 2, 'D8', 2),
(9, 'TV', 'Đang tắt', 7, NULL, 0, 7, NULL, 2),
(10, 'Điều hoà', 'Đang tắt', 4, 0, 0, 7, NULL, 2),
(11, 'Đèn ban công', 'Đang tắt', 1, NULL, 0, 8, NULL, 2),
(12, 'Nhiệt độ trong bếp', '', 5, 28.7, 1, 1, NULL, 2),
(13, 'Độ ẩm trong bếp', '', 6, 71, 1, 1, NULL, 2),
(14, 'Điều hoà P101', 'Đang tắt', 4, 18, 0, 2, NULL, 2),
(15, 'Điều hoà P102', 'Đang tắt', 4, 20, 0, NULL, NULL, NULL),
(16, 'Điều hoà P103', 'Đang tắt', 4, 16, 0, NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `devices_type`
--

CREATE TABLE `devices_type` (
  `DEVICE_TYPE_ID` int(10) NOT NULL,
  `DEVICE_TYPE` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `devices_type`
--

INSERT INTO `devices_type` (`DEVICE_TYPE_ID`, `DEVICE_TYPE`) VALUES
(1, 'LED'),
(2, 'DYNAMIC_LED'),
(3, 'DYNAMIC_CONTROLLER'),
(4, 'AIR_CONDITIONAL'),
(5, 'TEMPERATURE'),
(6, 'HUMIDITY'),
(7, 'TV'),
(8, 'CAMERA'),
(9, 'SPEAKER'),
(10, 'FAN'),
(11, 'COFFEE');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `devices_type_seq`
--

CREATE TABLE `devices_type_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `devices_type_seq`
--

INSERT INTO `devices_type_seq` (`next_val`) VALUES
(1);

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
(1, 'Floor 1', 1),
(2, 'Tầng 2 - Nhà ở', NULL);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `houses`
--

CREATE TABLE `houses` (
  `HOUSE_ID` int(10) NOT NULL,
  `USER_ID` int(11) DEFAULT NULL,
  `ADDRESS` varchar(100) DEFAULT NULL,
  `HOUSE_TITLE` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `HOUSE_ACTIVE` int(10) DEFAULT NULL,
  `HOUSE_TEMPERATURE` float DEFAULT NULL,
  `HOUSE_HUMIDITY` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `houses`
--

INSERT INTO `houses` (`HOUSE_ID`, `USER_ID`, `ADDRESS`, `HOUSE_TITLE`, `HOUSE_ACTIVE`, `HOUSE_TEMPERATURE`, `HOUSE_HUMIDITY`) VALUES
(1, 2, 'ĐHBKHN - 1 Đại Cồ Việt', 'IOT-Smart Home', 1, 37, 75);

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
(1, 'Nhà bếp', 1),
(2, 'Phòng ngủ lớn', 1),
(3, 'Phòng ngủ nhỏ', 1),
(4, 'Phòng khách', 1),
(5, 'Phòng ngủ 1', NULL),
(6, 'Phòng ngủ 2', NULL),
(7, 'Phòng khách', NULL),
(8, 'Ban công', NULL);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `user_account`
--

CREATE TABLE `user_account` (
  `USER_ACCOUNT_ID` int(11) NOT NULL,
  `USERNAME` varchar(50) NOT NULL,
  `PASSWORD` varchar(50) NOT NULL,
  `FULLNAME` varchar(50) DEFAULT 'User Account',
  `access_token` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `user_account`
--

INSERT INTO `user_account` (`USER_ACCOUNT_ID`, `USERNAME`, `PASSWORD`, `FULLNAME`, `access_token`) VALUES
(1, 'admin5', 'admin5', 'Admin', NULL),
(2, 'danhquy2502', '12345678', 'Danh Quý', NULL),
(4, 'createUsername', 'password', 'User Full Name', NULL);

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
  ADD UNIQUE KEY `DEVICE_PORT` (`DEVICE_PORT`,`USER_ACCOUNT_ID`),
  ADD KEY `device_room_fk` (`ROOM_ID`),
  ADD KEY `device_type_fk` (`DEVICE_TYPE_ID`),
  ADD KEY `userAccountID_fk` (`USER_ACCOUNT_ID`);

--
-- Chỉ mục cho bảng `devices_type`
--
ALTER TABLE `devices_type`
  ADD PRIMARY KEY (`DEVICE_TYPE_ID`);

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
  ADD PRIMARY KEY (`ROOM_ID`),
  ADD KEY `room_floor_fk` (`FlOOR_ID`);

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
  MODIFY `DEVICE_ID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- AUTO_INCREMENT cho bảng `devices_type`
--
ALTER TABLE `devices_type`
  MODIFY `DEVICE_TYPE_ID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

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
  ADD CONSTRAINT `device_room_fk` FOREIGN KEY (`ROOM_ID`) REFERENCES `rooms` (`ROOM_ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `device_type_fk` FOREIGN KEY (`DEVICE_TYPE_ID`) REFERENCES `devices_type` (`DEVICE_TYPE_ID`),
  ADD CONSTRAINT `userAccountID_fk` FOREIGN KEY (`USER_ACCOUNT_ID`) REFERENCES `user_account` (`USER_ACCOUNT_ID`);

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

--
-- Các ràng buộc cho bảng `rooms`
--
ALTER TABLE `rooms`
  ADD CONSTRAINT `room_floor_fk` FOREIGN KEY (`FlOOR_ID`) REFERENCES `floors` (`FLOOR_ID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
