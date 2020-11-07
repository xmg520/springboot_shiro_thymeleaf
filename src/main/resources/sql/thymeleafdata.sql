/*
Navicat MySQL Data Transfer

Source Server         : anjiesan
Source Server Version : 80021
Source Host           : 106.15.193.35:9527
Source Database       : thymeleafdata

Target Server Type    : MYSQL
Target Server Version : 80021
File Encoding         : 65001

Date: 2020-11-07 22:01:18
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(50) COLLATE utf8mb4_bin DEFAULT NULL,
  `password` varchar(50) COLLATE utf8mb4_bin DEFAULT NULL,
  `perms` varchar(100) COLLATE utf8mb4_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'root', 'root', 'user:svip,user:vip,user:comm');
INSERT INTO `user` VALUES ('2', 'vip', 'vip', 'user:vip,user:comm');
INSERT INTO `user` VALUES ('3', 'user', 'user', 'user:comm');

-- ----------------------------
-- Table structure for user_movie
-- ----------------------------
DROP TABLE IF EXISTS `user_movie`;
CREATE TABLE `user_movie` (
  `id` int NOT NULL AUTO_INCREMENT,
  `uid` int DEFAULT NULL,
  `mid` int DEFAULT NULL,
  `name` varchar(30) COLLATE utf8mb4_bin DEFAULT NULL,
  `url` varchar(200) COLLATE utf8mb4_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- ----------------------------
-- Records of user_movie
-- ----------------------------
INSERT INTO `user_movie` VALUES ('1', '1', '1', '一路向北', 'https://player.bilibili.com/player.html?aid=91871151&bvid=BV1p7411K7bP&cid=183293444&high_quality=1&page=2');
INSERT INTO `user_movie` VALUES ('2', '1', '2', '赌侠', 'https://player.bilibili.com/player.html?aid=56185989&bvid=BV1X4411g7in&cid=98207019&high_quality=1&page=1');
INSERT INTO `user_movie` VALUES ('3', '1', '3', '我的少女时代', 'https://player.bilibili.com/player.html?aid=753870665&bvid=BV1Yk4y1B7JG&cid=212676960&high_quality=1&page=1');
INSERT INTO `user_movie` VALUES ('4', '2', '1', '致敬英雄', 'https://player.bilibili.com/player.html?aid=885140661&bvid=BV1jK4y1E7sm&cid=253004969&high_quality=1&page=1');
INSERT INTO `user_movie` VALUES ('5', '2', '2', 'Springboot简单实现邮箱注册', 'https://player.bilibili.com/player.html?aid=96715178&bvid=BV1NE411F7ei&cid=165104877&high_quality=1&page=1');
INSERT INTO `user_movie` VALUES ('6', '2', '3', '国际歌', 'https://player.bilibili.com/player.html?aid=330156547&bvid=BV15A411j7Rm&cid=251444961&high_quality=1&page=1');
INSERT INTO `user_movie` VALUES ('7', '3', '1', '总书记系列讲话', 'https://player.bilibili.com/player.html?aid=585134780&bvid=BV1az4y1C7za&cid=252586416&high_quality=1&page=1');
INSERT INTO `user_movie` VALUES ('8', '3', '2', '品读关于苏格拉底的《申辩论》', 'https://player.bilibili.com/player.html?aid=372713851&bvid=BV1fZ4y1V7xg&cid=252556411&high_quality=1&page=1');
INSERT INTO `user_movie` VALUES ('9', '4', '1', '曹操', 'https://player.bilibili.com/player.html?aid=11976100&bvid=BV1ix411z77f&cid=19765226&high_quality=1&page=1');
INSERT INTO `user_movie` VALUES ('10', '4', '2', '中国近代史', 'https://player.bilibili.com/player.html?aid=56031367&bvid=BV114411G7Xh&cid=97939268&high_quality=1&page=1');
