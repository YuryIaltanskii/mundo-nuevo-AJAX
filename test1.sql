CREATE DATABASE test1;
GRANT USAGE ON *.* TO test1@localhost IDENTIFIED BY 'test1';
GRANT ALL PRIVILEGES ON test1.* TO test1@localhost ;
USE test1;

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;


CREATE TABLE `comment` (
  `id` int(11) NOT NULL,
  `content` varchar(255) DEFAULT NULL,
  `USER_USERID` int(11) DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  `POST_ID` int(11) DEFAULT NULL,
  `USER_ID` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


INSERT INTO `comment` (`id`, `content`, `USER_USERID`, `date`, `POST_ID`, `USER_ID`) VALUES
(4701, 'Comment', NULL, '2017-11-27 19:39:55', 4451, 4552);


CREATE TABLE `image` (
  `id` int(11) NOT NULL,
  `path` varchar(255) DEFAULT NULL,
  `size` bigint(20) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `USER_ID` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


INSERT INTO `image` (`id`, `path`, `size`, `type`, `USER_ID`) VALUES
(1701, '7czpzz50r7', 31036, 'image/jpeg', NULL),
(1751, 'a2s0nogpxm', 129091, 'image/png', NULL),
(1801, '4gbm2dl27y', 129091, 'image/png', NULL),
(1802, 'lc3z4e6p9y', 129091, 'image/png', NULL),
(1803, 'ph8gcf8o8k', 31036, 'image/jpeg', NULL),
(1901, 'ep1ybjqwh3', 31036, 'image/jpeg', NULL),
(2001, '6f5qb3b90n', 150680, 'image/png', NULL),
(2101, 'plms7x0p4w', 137828, 'image/png', NULL),
(2201, 'jzcjbrly6i', 479522, 'image/png', NULL),
(2202, 'i0krljyx1s', 479522, 'image/png', NULL),
(2301, '1rke8t2qd4', 30866, 'image/jpeg', NULL),
(2302, 's9owhpch3y', 30866, 'image/jpeg', NULL),
(2401, '42xzxwkc31', 89088, 'image/png', NULL),
(2402, 'ytatlw6h5z', 89088, 'image/png', NULL),
(2403, 'eopya53rwb', 89088, 'image/png', NULL),
(2601, 'w3pnr57n5g', 129091, 'image/png', NULL),
(2701, 'igj09nsbim', 31036, 'image/jpeg', NULL),
(2851, '0stcm5oxfb', 3050, 'image/jpeg', NULL),
(2901, 'd6jkw592cy', 3050, 'image/jpeg', NULL),
(3001, 'ew2mwnya43', 3050, 'image/jpeg', NULL),
(3051, 'q51gzdqrg4', 3050, 'image/jpeg', NULL),
(3101, 'xzs5g7pjj9', 3050, 'image/jpeg', NULL),
(3151, 'k49x2ngnyl', 129091, 'image/png', NULL),
(3351, '4j53mki862', 129091, 'image/png', NULL),
(3501, '987bomnm3g', 3050, 'image/jpeg', NULL),
(3601, 'fibnyllomp', 3050, 'image/jpeg', NULL),
(3701, 'l72zn406sb', 3050, 'image/jpeg', NULL),
(3751, 'lebrcxgrt2', 3050, 'image/jpeg', NULL),
(4001, 'tr32dmaooo', 3050, 'image/jpeg', NULL),
(4301, 'jef72psozs', 19922, 'image/png', NULL),
(4351, '4baojj7rqx', 19922, 'image/png', NULL),
(4501, '06lezm4jxb', 11507, 'image/jpeg', NULL),
(4502, 'pigjsorrao', 11507, 'image/jpeg', NULL),
(4601, '7aao6ogwsx', 75990, 'image/png', NULL);


CREATE TABLE `openjpa_sequence_table` (
  `ID` tinyint(4) NOT NULL,
  `SEQUENCE_VALUE` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


INSERT INTO `openjpa_sequence_table` (`ID`, `SEQUENCE_VALUE`) VALUES
(0, 4751);


CREATE TABLE `post` (
  `id` int(11) NOT NULL,
  `content` varchar(255) DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  `USER_ID` int(11) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `USER_USERID` int(11) DEFAULT NULL,
  `IMAGE_ID` int(11) DEFAULT NULL,
  `USERIMAGE_ID` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `post` (`id`, `content`, `date`, `USER_ID`, `title`, `USER_USERID`, `IMAGE_ID`, `USERIMAGE_ID`) VALUES
(4451, 'Victor´s post', '2017-11-27 19:32:26', 4401, NULL, NULL, NULL, NULL),
(4651, 'TEST', '2017-11-27 19:39:45', 4552, NULL, NULL, 4601, NULL);

CREATE TABLE `upload_image` (
  `Image_id` int(11) NOT NULL,
  `IMAGE` longblob,
  `Image_name` varchar(50) DEFAULT NULL,
  `image_length` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `userid` int(11) DEFAULT NULL,
  `userpic` int(11) DEFAULT NULL,
  `USERPIC_ID` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `user` (`id`, `email`, `name`, `password`, `userid`, `userpic`, `USERPIC_ID`) VALUES
(3901, 'yury@test.com', 'Yury', 'password', NULL, 1, NULL),
(4101, 'test@test.com', 'Test', 'password', NULL, 3, NULL),
(4401, 'victor@test.com', 'Victor', 'password', NULL, NULL, 4351),
(4552, 'usera@test.com', 'User A', 'password', NULL, NULL, 4502);

CREATE TABLE `user_post` (
  `USER_ID` int(11) DEFAULT NULL,
  `POSTS_ID` int(11) DEFAULT NULL,
  `USER_USERID` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

ALTER TABLE `comment`
  ADD PRIMARY KEY (`id`);


ALTER TABLE `image`
  ADD PRIMARY KEY (`id`);

ALTER TABLE `openjpa_sequence_table`
  ADD PRIMARY KEY (`ID`);

ALTER TABLE `post`
  ADD PRIMARY KEY (`id`),
  ADD KEY `I_POST_USER` (`USER_ID`);


ALTER TABLE `upload_image`
  ADD PRIMARY KEY (`Image_id`);


ALTER TABLE `user`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `U_USER_EMAIL` (`email`),
  ADD UNIQUE KEY `U_USER_NAME` (`name`);

ALTER TABLE `user_post`
  ADD KEY `I_USR_PST_ELEMENT` (`POSTS_ID`),
  ADD KEY `I_USR_PST_USER_ID` (`USER_ID`);


ALTER TABLE `upload_image`
  MODIFY `Image_id` int(11) NOT NULL AUTO_INCREMENT;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
