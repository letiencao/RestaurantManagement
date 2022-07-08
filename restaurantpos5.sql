-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th7 07, 2022 lúc 05:24 PM
-- Phiên bản máy phục vụ: 10.4.24-MariaDB
-- Phiên bản PHP: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `restaurantpos5`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `categories`
--

CREATE TABLE `categories` (
  `id` int(11) NOT NULL,
  `Category` text CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `Vat` int(11) NOT NULL,
  `Tax` int(11) NOT NULL,
  `Date` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `categories`
--

INSERT INTO `categories` (`id`, `Category`, `Vat`, `Tax`, `Date`) VALUES
(1, 'Food', 5, 3, '2022-07-06 03:48:02'),
(2, 'Wine', 5, 2, '2022-07-06 03:46:29'),
(26, 'BEER', 5, 2, '2022-07-06 03:47:54'),
(27, 'Drink', 5, 2, '2022-07-06 14:41:19');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `customers`
--

CREATE TABLE `customers` (
  `id` int(11) NOT NULL,
  `name` text NOT NULL,
  `idNumber` bigint(20) NOT NULL,
  `address` text NOT NULL,
  `email` text NOT NULL,
  `mobile` text NOT NULL,
  `dob` date NOT NULL,
  `discount` int(11) NOT NULL,
  `purchases` int(11) NOT NULL,
  `lastPurchase` date NOT NULL,
  `registerDate` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `customers`
--

INSERT INTO `customers` (`id`, `name`, `idNumber`, `address`, `email`, `mobile`, `dob`, `discount`, `purchases`, `lastPurchase`, `registerDate`) VALUES
(1, 'Le Tien Cao', 333, 'Ha Dong', 'caole@gmail.com', '1234567890', '2020-01-01', 3, 0, '0000-00-00', '2020-03-10 02:55:32'),
(18, 'Luong Nguyen', 111, 'Ha Noi', 'LNguyen@gmail.com', '0867585858', '2002-02-02', 5, 8, '2022-07-06', '2020-05-11 21:38:59'),
(19, 'QTuan', 101, 'Ha Noi', 'quantuan@gmail.com', '0851528274', '1995-08-12', 1, 3, '0000-00-00', '2020-05-22 14:26:28'),
(20, 'KhangVu', 222, 'HaNoi', 'khangvu@gmail.com', '0234567892', '2000-11-01', 3, 0, '0000-00-00', '2022-07-06 03:35:28'),
(21, 'NgocHieu', 444, 'HaNoi', 'ngochieu@gmail.com', '0324567896', '2000-11-01', 4, 0, '0000-00-00', '2022-07-06 03:36:14');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `open_tables`
--

CREATE TABLE `open_tables` (
  `id` int(11) NOT NULL,
  `code` int(11) NOT NULL,
  `idSeller` int(11) NOT NULL,
  `tableNo` int(11) NOT NULL,
  `products` text CHARACTER SET utf16 NOT NULL,
  `netPrice` float NOT NULL,
  `date` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `products`
--

CREATE TABLE `products` (
  `id` int(11) NOT NULL,
  `idCategory` int(11) NOT NULL,
  `code` text NOT NULL,
  `product` text NOT NULL,
  `stock` int(11) NOT NULL,
  `buyingPrice` float NOT NULL,
  `sellingPrice` float NOT NULL,
  `sales` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `products`
--

INSERT INTO `products` (`id`, `idCategory`, `code`, `product`, `stock`, `buyingPrice`, `sellingPrice`, `sales`) VALUES
(81, 2, '218', 'Whisky', 100, 107000, 117700, 0),
(82, 2, '219', 'Brandy', 10, 107000, 112350, 0),
(83, 2, '219', 'Gin', 19, 119840, 115360, 4),
(84, 2, '221', 'Vodka', 30, 160500, 168525, 0),
(85, 1, '101', 'Pumpkin Soup', 19, 81000, 82620, 2),
(86, 1, '102', 'Mashed Potatoes', 12, 86400, 88128, 0),
(87, 1, '102', 'Spaghetti Bolognese', 21, 270000, 275400, 0),
(88, 26, '2601', 'Lager', 50, 81320, 82946.4, 0),
(89, 1, '103', 'Ceasar Salad', 49, 77760, 79315.2, 2),
(90, 2, '222', 'Rum', 49, 131610, 134242, 6),
(91, 2, '223', 'Tequila', 23, 128400, 130968, 0),
(92, 2, '224', 'Chivas', 0, 214000, 220420, 0),
(93, 1, '104', 'Foie gras', 0, 216000, 220420, 0);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `sales`
--

CREATE TABLE `sales` (
  `id` int(11) NOT NULL,
  `code` int(11) NOT NULL,
  `idSeller` int(11) NOT NULL,
  `tableNo` int(11) NOT NULL,
  `idCustomer` int(11) NOT NULL,
  `products` text NOT NULL,
  `netPrice` float NOT NULL,
  `discount` int(11) NOT NULL,
  `totalPrice` float NOT NULL,
  `paymentMethod` text NOT NULL,
  `saledate` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

--
-- Đang đổ dữ liệu cho bảng `sales`
--

INSERT INTO `sales` (`id`, `code`, `idSeller`, `tableNo`, `idCustomer`, `products`, `netPrice`, `discount`, `totalPrice`, `paymentMethod`, `saledate`) VALUES
(255, 10001, 43, 10, 111, '[{\"id\":\"89\",\"product\":\"Ceasar Salad\",\"category\":\"1\",\"quantity\":\"1\",\"stock\":\"49\",\"price\":\"79315.2\",\"totalPrice\":\"79315.2\"},{\"id\":\"83\",\"product\":\"Gin\",\"category\":\"2\",\"quantity\":\"1\",\"stock\":\"20\",\"price\":\"115360\",\"totalPrice\":\"115360\"},{\"id\":\"90\",\"product\":\"Rum\",\"category\":\"2\",\"quantity\":\"1\",\"stock\":\"51\",\"price\":\"134242\",\"totalPrice\":\"134242\"}]', 328917, 5, 312471, 'Card', '2022-07-06 15:10:36'),
(257, 10003, 41, 10, 111, '[{\"id\":\"90\",\"product\":\"Rum\",\"category\":\"2\",\"quantity\":\"2\",\"stock\":\"49\",\"price\":\"134242\",\"totalPrice\":\"268484\"},{\"id\":\"85\",\"product\":\"Pumpkin Soup\",\"category\":\"1\",\"quantity\":\"1\",\"stock\":\"19\",\"price\":\"82620\",\"totalPrice\":\"82620\"},{\"id\":\"83\",\"product\":\"Gin\",\"category\":\"2\",\"quantity\":\"1\",\"stock\":\"19\",\"price\":\"115360\",\"totalPrice\":\"115360\"}]', 466464, 5, 443141, 'Card', '2022-07-06 15:34:51');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `name` text CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `user` text CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `password` text CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `profile` text CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `status` int(1) NOT NULL,
  `lastLogin` datetime NOT NULL,
  `date` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

--
-- Đang đổ dữ liệu cho bảng `users`
--

INSERT INTO `users` (`id`, `name`, `user`, `password`, `profile`, `status`, `lastLogin`, `date`) VALUES
(41, 'staff1', 'staff', '$2a$07$asxx54ahjppf45sd87a5auy11QLpa3taRSiUSCzqaWHxjhmUKKSk6', 'staff', 1, '2022-07-06 16:33:44', '2022-07-06 15:33:44'),
(42, 'manager', 'manager', '$2a$07$asxx54ahjppf45sd87a5auFL5K1.Cmt9ZheoVVuudOi5BCi10qWly', 'manager', 1, '2022-07-06 16:36:14', '2022-07-06 15:36:14'),
(43, 'ngoctrung', 'trung', '$2a$07$asxx54ahjppf45sd87a5auFL5K1.Cmt9ZheoVVuudOi5BCi10qWly', 'administrator', 1, '2022-07-07 03:29:54', '2022-07-07 02:29:54');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `categories`
--
ALTER TABLE `categories`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `customers`
--
ALTER TABLE `customers`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `open_tables`
--
ALTER TABLE `open_tables`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `products`
--
ALTER TABLE `products`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `sales`
--
ALTER TABLE `sales`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `categories`
--
ALTER TABLE `categories`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=28;

--
-- AUTO_INCREMENT cho bảng `customers`
--
ALTER TABLE `customers`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- AUTO_INCREMENT cho bảng `open_tables`
--
ALTER TABLE `open_tables`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=28;

--
-- AUTO_INCREMENT cho bảng `products`
--
ALTER TABLE `products`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=94;

--
-- AUTO_INCREMENT cho bảng `sales`
--
ALTER TABLE `sales`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=258;

--
-- AUTO_INCREMENT cho bảng `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=44;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
