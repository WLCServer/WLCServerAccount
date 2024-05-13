CREATE TABLE IF NOT EXISTS `warning` (
  `wid` int NOT NULL AUTO_INCREMENT,
  `name` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `uuid` char(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `warning` json DEFAULT NULL,
  PRIMARY KEY (`wid`),
  CONSTRAINT `warning` FOREIGN KEY (`wid`) REFERENCES `account` (`wid`)
) ENGINE=InnoDB AUTO_INCREMENT=800000 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
