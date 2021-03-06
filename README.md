<h1 align="center">Bar Restaurant Management  </h1>

# Table of contents

1. [Project Details](#ProjDetails)

2. [Overview](#OverView)

3.  [Technologies](#Tech)

    3.1 [Xampp](#Xampp)

    3.2 [MySQL](#MySQL)

    3.3 [Php](#Php)

    3.4 [Javascript/Ajax](#JSA)

    3.5 [TCPDF](#TCPDF)

    3.6 [Excel](#Excel)

    3.7 [Chart](#Chart)
    
    3.8 [Docker](#Docker)
4. [Cloning](#clone)
 
# Project Details <a name="ProjDetails"></a>

| Project Details   |     |
| --- | --- |
| **Course** | Phát triển phần mềm phân tán  |
| **Module** |  Applied Project |
| **git** | [https://github.com/letiencao/RestaurantManagement] |
| **Students** | Group 5 |
| **Project Title** | Bar Restaurant Management |

# Overview <a name="OverView"></a>
- Thiết kế được một hệ thống để thực hiện các tính năng cơ bản của một ứng dụng quản lý nhà hàng:

        + Xác thực người dùng

        + Quản lý thông tin người dùng

        + Đặt bàn

        + Order món

        + Thanh toán

        + …


- Cùng với đó áp dụng các công cụ khác nhau để hỗ trợ phát triển cũng như tạo điều kiện để tìm hiểu cách áp dụng chúng trong môi trường phát triển phần mềm:

        + Docker, docker-compose: tự động hóa việc triển khai, tích hợp

        + Swagger, postman: Định nghĩa các Restful API

# Technologies <a name="Tech"></a>

## Xampp <a name="Xampp"></a>
 - Xampp là chương trình tạo máy chủ Web (Web Server) được tích hợp sẵn Apache, PHP, MySQL, FTP Server, Mail Server và các công cụ như phpMyAdmin. Không như Appserv, Xampp có chương trình quản lý khá tiện lợi, cho phép chủ động bật tắt hoặc khởi động lại các dịch vụ máy chủ bất kỳ lúc nào.

 - Apache 2.2.14 (IPv6 enabled) + OpenSSL 0.9.8l

 - MySQL 8.0.1

 - PHP 8.1.1

 - phpMyAdmin 4.9.0

 - Perl 5.16.3
 
 ![Xampp](https://github.com/letiencao/RestaurantManagement/blob/main/xampp.png)


## MySQL <a name="MySQL"></a>

- MySQL is free and open-source software that acts as a relational database based of off the Structured Query Language - SQL, reasons to use MySQL include Secure Money Transactions, On-Demand Scalability, High Availability, Rock-Solid Reliability and Quick-Start Capability.

![MySQL](https://github.com/letiencao/RestaurantManagement/blob/main/mysql.png)

## Php <a name="Php"></a>

- PHP là một ngôn ngữ kịch bản phía máy chủ. được sử dụng để phát triển các trang web Tĩnh hoặc trang web Động hoặc các ứng dụng Web. PHP là viết tắt của Hypertext Pre-processor, trước đó là viết tắt của Personal Home Pages. Các tập lệnh PHP chỉ có thể được thông dịch trên một máy chủ đã cài đặt PHP.

![Php](https://github.com/letiencao/RestaurantManagement/blob/main/php.png)

## Javascript/Ajax <a name="JSA"></a>

- JavaScript (JS) is a lightweight, interpreted, or just-in-time compiled programming language with first-class functions. While it is most well-known as the scripting language for Web pages while AJAX = Asynchronous JavaScript and XML. AJAX is a technique for creating fast and dynamic web pages. AJAX allows web pages to be updated asynchronously by exchanging small amounts of data with the server behind the scenes. This means that it is possible to update parts of a web page, without reloading the whole page.

![JS/Ajax](https://github.com/letiencao/RestaurantManagement/blob/main/js.png)

## TCPDF <a name="TCPDF"></a>

- You can use TCPDF to generate myriad 1-D and 2-D barcode formats, and it supports all of the usual PDF features like bookmarks, document links, compression, annotations, document encryption, and digital signatures.

![TCPDF](https://github.com/letiencao/RestaurantManagement/blob/main/tcpdf.png)

## Excel <a name="Excel"></a>

- Microsoft Excel is a spreadsheet program. That means it's used to create grids of text, numbers and formulas specifying calculations. That's extremely valuable for many businesses, which use it to record expenditures and income, plan budgets, chart data and succinctly present fiscal results.

![Excel](https://github.com/letiencao/RestaurantManagement/blob/main/excel.png)

## Charts/Graphs <a name="Chart"></a>

- The charts were created using Morris.js and Chart.js plugins.
Morris.js lets the user create aesthetic charts in next to no time, it is made very simple using the public api for each chart, We decided to go with this as it was shown as a chart in the AdminLTE dashboard that looked exactly what we were looking for. We used Morris.js to create line and bar charts.

 - Chart.js like Morris.js, Chart.js is a free open-source JavaScript library for data visualization, Chart.js was also found on the dashboard we decided to go with this plugin as it's beautifully constructed charts such as their animated pie chart is what struck out to us. 
 
 ![Chart](https://github.com/letiencao/RestaurantManagement/blob/main/chartjs.jpg)
 
## Docker <a name="Docker"></a>

-  Docker là một công cụ hỗ trợ xây dựng và triển khai các ứng dụng trên nền tảng các các containers.

- Container được coi như một tiến trình trong Linux được cấu hình (CPU, RAM, threads, network,...), đây cũng là một môi trường dùng để đóng gói ứng dụng và các thành phần liên quan giúp người phát triển có thể dễ dàng triển khai thông qua các image.

- Container image là các file nén (tar) được sắp xếp theo mô hình layer kèm với các metadata. Kiến trúc mỗi một layer là một file nén hỗ trợ cho việc tái sử dụng các layer này để xây dựng image một cách nhanh chóng và tốn ít tài nguyên hơn.
 
# Cloning/Running the application <a name="clone"></a>
Vào Link dưới đây rồi clone project về:
```
git clone https://github.com/letiencao/RestaurantManagement
```
Tải và cài đặt Xampp local server.

**Link:** https://www.apachefriends.org/index.html

Clone project vào trong folder htdocs của xampp.

Vào link sau để lấy database và import vào phpmyadmin cảu mình:

**Link:** https://github.com/letiencao/RestaurantManagement/blob/main/restaurantpos5.sql

Chạy project với localhost:RestaurantManagement-main

Điền Tài Khoản : trung

Mật Khẩu : 123456
