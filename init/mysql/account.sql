CREATE TABLE IF NOT EXISTS `account` (
  `wid` int NOT NULL AUTO_INCREMENT,
  `name` varchar(16) NOT NULL,
  `uuid` char(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `gender` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `qq` varchar(15) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `phone` char(11) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `register_ip` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `register_time` datetime NOT NULL,
  `lastlogin_time` datetime NOT NULL,
  `lastlogout_time` datetime DEFAULT NULL,
  PRIMARY KEY (`wid`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=800000 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
