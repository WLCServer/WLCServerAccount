CREATE TABLE IF NOT EXISTS `ban` (
  `wid` int NOT NULL AUTO_INCREMENT,
  `name` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `uuid` char(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `banned` tinyint(1) NOT NULL DEFAULT '0',
  `time` datetime DEFAULT NULL,
  `reason` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`wid`) USING BTREE,
  CONSTRAINT `ban` FOREIGN KEY (`wid`) REFERENCES `account` (`wid`)
) ENGINE=InnoDB AUTO_INCREMENT=800000 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
