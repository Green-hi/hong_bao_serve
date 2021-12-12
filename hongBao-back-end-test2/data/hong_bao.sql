/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 80025
 Source Host           : localhost:3306
 Source Schema         : hong_bao

 Target Server Type    : MySQL
 Target Server Version : 80025
 File Encoding         : 65001

 Date: 30/11/2021 21:49:44
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin_base
-- ----------------------------
DROP TABLE IF EXISTS `admin_base`;
CREATE TABLE `admin_base`  (
  `id` int UNSIGNED NOT NULL AUTO_INCREMENT,
  `aid` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '管理员账号',
  `admin_name` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '管理员昵称',
  `password` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '管理员密码',
  `create_time` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `update_time` datetime NULL DEFAULT NULL,
  `share_one` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `share_two` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `share_three` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `share_four` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `UK_aid`(`aid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin_base
-- ----------------------------
INSERT INTO `admin_base` VALUES (1, '1', 'admin1', '123456', '2021-11-14 15:49:24', '2021-11-30 21:44:00', NULL, NULL, NULL, NULL);
INSERT INTO `admin_base` VALUES (2, '2', 'admin2', '666', '2021-11-15 15:41:07', '2021-11-15 15:41:07', NULL, NULL, NULL, NULL);
INSERT INTO `admin_base` VALUES (3, '3', 'admin3', '666', '2021-11-15 17:03:52', '2021-11-15 17:03:52', NULL, NULL, NULL, NULL);
INSERT INTO `admin_base` VALUES (6, '4', 'admin4', '666', '2021-11-15 21:49:31', '2021-11-15 21:49:31', NULL, NULL, NULL, NULL);
INSERT INTO `admin_base` VALUES (7, '5', 'admin5', '666', '2021-11-29 15:17:14', '2021-11-29 15:17:14', NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for friendship
-- ----------------------------
DROP TABLE IF EXISTS `friendship`;
CREATE TABLE `friendship`  (
  `id` bigint UNSIGNED NOT NULL AUTO_INCREMENT,
  `user_id` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `friend_id` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `friend_name` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '好友备注',
  `friend_type` int NULL DEFAULT 0 COMMENT '好友类型',
  `friend_group` int NULL DEFAULT 0 COMMENT '好友分组',
  `create_time` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `update_time` datetime NULL DEFAULT NULL,
  `share_one` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `share_two` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `share_three` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `share_four` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FK_user_id`(`user_id`) USING BTREE,
  INDEX `FK_friend_id`(`friend_id`) USING BTREE,
  CONSTRAINT `FK_friend_id` FOREIGN KEY (`friend_id`) REFERENCES `user_base` (`uid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_user_id` FOREIGN KEY (`user_id`) REFERENCES `user_base` (`uid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of friendship
-- ----------------------------
INSERT INTO `friendship` VALUES (2, '8', '4', '支书', 0, 0, '0000-00-00 00:00:00', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `friendship` VALUES (7, '3', '4', '小弟', 1, 1, '2021-11-30 21:44:17', '2021-11-30 21:44:20', NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for group_message
-- ----------------------------
DROP TABLE IF EXISTS `group_message`;
CREATE TABLE `group_message`  (
  `id` bigint UNSIGNED NOT NULL AUTO_INCREMENT,
  `from_uid` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '发送者ID',
  `group_id` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '群组ID',
  `content` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '消息内容',
  `type` int NULL DEFAULT 0 COMMENT '消息类型',
  `from_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '发送者群昵称',
  `create_time` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `update_time` datetime NULL DEFAULT NULL,
  `share_one` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `share_two` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `share_three` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `share_four` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FK_from_uid`(`from_uid`) USING BTREE,
  CONSTRAINT `FK_from_uid` FOREIGN KEY (`from_uid`) REFERENCES `user_base` (`uid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of group_message
-- ----------------------------
INSERT INTO `group_message` VALUES (3, '3', '1', '五虎上将，参见！', 1, '大哥', '2021-11-29 20:41:55', '2021-11-29 20:41:55', NULL, NULL, NULL, NULL);
INSERT INTO `group_message` VALUES (4, '3', '1', '五虎上将，参见！', 1, '大哥', '2021-11-29 21:09:56', '2021-11-29 21:09:56', NULL, NULL, NULL, NULL);
INSERT INTO `group_message` VALUES (5, '3', '1', '五虎上将，参见！', 1, '大哥', '2021-11-29 21:12:21', '2021-11-29 21:12:21', NULL, NULL, NULL, NULL);
INSERT INTO `group_message` VALUES (6, '3', '1', '五虎上将，参见！', 1, '大哥', '2021-11-29 22:22:20', '2021-11-29 22:22:20', NULL, NULL, NULL, NULL);
INSERT INTO `group_message` VALUES (7, '3', '1', '五虎上将，参见！', 1, '大哥', '2021-11-29 22:22:35', '2021-11-29 22:22:35', NULL, NULL, NULL, NULL);
INSERT INTO `group_message` VALUES (8, '3', '1', '五虎上将，参见！', 1, '大哥', '2021-11-29 22:23:13', '2021-11-29 22:23:13', NULL, NULL, NULL, NULL);
INSERT INTO `group_message` VALUES (9, '3', '1', '五虎上将，参见！', 1, '大哥', '2021-11-30 21:44:51', '2021-11-30 21:44:51', NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for party_branch
-- ----------------------------
DROP TABLE IF EXISTS `party_branch`;
CREATE TABLE `party_branch`  (
  `id` bigint UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '党支部ID',
  `branch_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '党支部名称',
  `create_time` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `update_time` datetime NULL DEFAULT NULL,
  `share_one` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备用',
  `share_two` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备用',
  `share_three` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备用',
  `share_four` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备用',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `UK_branch_name`(`branch_name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of party_branch
-- ----------------------------
INSERT INTO `party_branch` VALUES (1, '软工1901班党支部', '0000-00-00 00:00:00', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `party_branch` VALUES (2, '计科1901班党支部', '0000-00-00 00:00:00', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `party_branch` VALUES (3, '电信1901班党支部', '0000-00-00 00:00:00', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `party_branch` VALUES (5, '陕西师范大学汉语言文学院党支部', '2021-11-29 17:52:21', '2021-11-29 23:50:36', NULL, NULL, NULL, NULL);
INSERT INTO `party_branch` VALUES (8, '陕西师范大学计算机科学学院党支部', '2021-11-30 21:46:14', '2021-11-30 21:46:14', NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for party_dues_record
-- ----------------------------
DROP TABLE IF EXISTS `party_dues_record`;
CREATE TABLE `party_dues_record`  (
  `id` bigint UNSIGNED NOT NULL AUTO_INCREMENT,
  `mid` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '党员编号',
  `month` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '缴费月份（xx-xx）',
  `amount` int UNSIGNED NULL DEFAULT NULL COMMENT '缴费金额',
  `pay_way` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '未知' COMMENT '缴费方式',
  `create_time` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `update_time` datetime NULL DEFAULT NULL,
  `share_one` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `share_two` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `share_three` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `share_four` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FK_mid_pd`(`mid`) USING BTREE,
  CONSTRAINT `FK_mid_pd` FOREIGN KEY (`mid`) REFERENCES `party_member_info` (`mid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of party_dues_record
-- ----------------------------
INSERT INTO `party_dues_record` VALUES (3, '33', '21-11', 30, '微信支付', '2021-11-29 18:27:52', '2021-11-29 18:27:52', NULL, NULL, NULL, NULL);
INSERT INTO `party_dues_record` VALUES (6, '02', '21-11', 30, '支付宝支付', '0000-00-00 00:00:00', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `party_dues_record` VALUES (7, '01', '21-11', 30, '现金支付', '2021-11-30 21:46:44', '2021-11-30 21:46:44', NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for party_member_info
-- ----------------------------
DROP TABLE IF EXISTS `party_member_info`;
CREATE TABLE `party_member_info`  (
  `id` bigint UNSIGNED NOT NULL AUTO_INCREMENT,
  `uid` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户ID',
  `mid` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '党员编号',
  `party_branch` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '所属党支部',
  `enter_date` date NULL DEFAULT NULL COMMENT '入党日期',
  `performance` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '优良' COMMENT '表现',
  `charge` int NULL DEFAULT 0 COMMENT '应交党费',
  `create_time` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `update_time` datetime NULL DEFAULT NULL,
  `share_one` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `share_two` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `share_three` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `share_four` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `UK_mid_pm`(`mid`) USING BTREE,
  INDEX `FK_uid_p`(`uid`) USING BTREE,
  INDEX `FK_party_branch`(`party_branch`) USING BTREE,
  CONSTRAINT `FK_party_branch` FOREIGN KEY (`party_branch`) REFERENCES `party_branch` (`branch_name`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_uid_p` FOREIGN KEY (`uid`) REFERENCES `user_base` (`uid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of party_member_info
-- ----------------------------
INSERT INTO `party_member_info` VALUES (1, '3', '33', '计科1901班党支部', '2021-11-17', '优良', 0, '0000-00-00 00:00:00', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `party_member_info` VALUES (3, '5', '01', '软工1901班党支部', '1923-07-01', '及格', 30, '2021-11-29 20:13:11', '2021-11-30 00:20:11', NULL, NULL, NULL, NULL);
INSERT INTO `party_member_info` VALUES (4, '44548', '02', '计科1901班党支部', '2020-05-22', '优良', 0, '0000-00-00 00:00:00', NULL, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for user_base
-- ----------------------------
DROP TABLE IF EXISTS `user_base`;
CREATE TABLE `user_base`  (
  `id` bigint UNSIGNED NOT NULL AUTO_INCREMENT,
  `uid` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户ID',
  `user_name` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户姓名',
  `password` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '账号密码',
  `user_age` int NULL DEFAULT NULL COMMENT '用户年龄',
  `user_sex` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '保密' COMMENT '用户性别',
  `user_phone` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '未知' COMMENT '用户手机号',
  `politics_status` int NULL DEFAULT 0 COMMENT '政治面貌（0群众1共产党员2共青团员）',
  `create_time` datetime NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP,
  `update_time` datetime NULL DEFAULT NULL,
  `share_one` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备用',
  `share_two` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备用',
  `share_three` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备用',
  `share_four` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备用',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `UK_uid`(`uid`) USING BTREE,
  UNIQUE INDEX `UK_gh4o0b6dwn4yexk0f96wjga26`(`user_phone`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_base
-- ----------------------------
INSERT INTO `user_base` VALUES (1, '3', '关羽', '123456', NULL, '未知', '5656566', 1, '0000-00-00 00:00:00', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `user_base` VALUES (2, '4', '张飞', '123456', NULL, '未知', '2323232', 2, '0000-00-00 00:00:00', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `user_base` VALUES (3, '5', '刘备', '123456', NULL, '未知', '666666', 1, '0000-00-00 00:00:00', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `user_base` VALUES (4, '8', '黄忠', '123456', NULL, '未知', '888888', 2, '0000-00-00 00:00:00', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `user_base` VALUES (8, '44548', '上官', '123456', 22, '女', '18136922104', 1, '2021-11-15 22:47:37', '2021-11-15 22:47:37', NULL, NULL, NULL, NULL);
INSERT INTO `user_base` VALUES (9, '54687', '苏烈', '123456', 32, '男', '15236552104', 2, '2021-11-29 15:18:44', '2021-11-15 23:06:08', NULL, NULL, NULL, NULL);
INSERT INTO `user_base` VALUES (11, '64979', '马超', '123456', 25, '女', '13425894759', 1, '2021-11-30 00:28:54', '2021-11-30 00:28:54', NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for user_extend
-- ----------------------------
DROP TABLE IF EXISTS `user_extend`;
CREATE TABLE `user_extend`  (
  `id` bigint UNSIGNED NOT NULL AUTO_INCREMENT,
  `uid` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户ID',
  `face` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '头像',
  `sign` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '个性签名',
  `birthday` date NULL DEFAULT NULL COMMENT '出生年日',
  `e_mail` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '未知' COMMENT '邮箱',
  `learn_progress` int NULL DEFAULT 0 COMMENT '学习进度',
  `create_time` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `update_time` datetime NULL DEFAULT NULL,
  `share_one` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `share_two` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `share_three` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `share_four` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FK_uid_extend`(`uid`) USING BTREE,
  INDEX `K_learn_progress`(`learn_progress`) USING BTREE,
  CONSTRAINT `FK_uid_extend` FOREIGN KEY (`uid`) REFERENCES `user_base` (`uid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_extend
-- ----------------------------
INSERT INTO `user_extend` VALUES (2, '3', '03.png', '屈辱，比失败更难忍受!', '0160-06-22', 'youbenshilaikanwo@foxmail.com', 1, '2021-11-29 15:45:17', '2021-11-29 15:45:17', NULL, NULL, NULL, NULL);
INSERT INTO `user_extend` VALUES (3, '4', '04.png', '邂逅，让我回忆起重要的事情。', '0155-08-22', 'rencehnlun@163.com', 2, '2021-11-29 15:58:24', '2021-11-29 15:58:24', NULL, NULL, NULL, NULL);
INSERT INTO `user_extend` VALUES (4, '5', '05.png', '出来混，重要的是讲义气。', '0145-09-12', 'taoyanbieli@foxmail.com', 1, '2021-11-29 16:01:21', '2021-11-30 00:29:38', NULL, NULL, NULL, NULL);
INSERT INTO `user_extend` VALUES (5, '44548', '08.png', '言为心声，字为心画。', '0111-03-02', 'zhengbuguozhaoxi@sina.com', 0, '0000-00-00 00:00:00', NULL, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for user_group
-- ----------------------------
DROP TABLE IF EXISTS `user_group`;
CREATE TABLE `user_group`  (
  `id` int UNSIGNED NOT NULL AUTO_INCREMENT,
  `group_id` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '群ID',
  `group_name` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '群名称',
  `admin_id` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '群主ID',
  `icon` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '群图标',
  `notice` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '群公告',
  `intro` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '群简介',
  `create_time` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `update_time` datetime NULL DEFAULT NULL,
  `share_one` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `share_two` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `share_three` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `share_four` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FK_admin_id`(`admin_id`) USING BTREE,
  CONSTRAINT `FK_admin_id` FOREIGN KEY (`admin_id`) REFERENCES `user_base` (`uid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_group
-- ----------------------------
INSERT INTO `user_group` VALUES (3, '33', NULL, NULL, 'e', 'e', 'e', '0000-00-00 00:00:00', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `user_group` VALUES (7, '001', '桃园结义交流群', '3', '016.png', '此群为桃园结义内部交流群，无关人士请勿加群！', '再见，桃园。', '2021-11-30 21:44:36', '2021-11-30 21:44:47', NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for youth_dues_record
-- ----------------------------
DROP TABLE IF EXISTS `youth_dues_record`;
CREATE TABLE `youth_dues_record`  (
  `id` bigint UNSIGNED NOT NULL AUTO_INCREMENT,
  `mid` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '团员编号',
  `month` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '缴费月份（xx-xx）',
  `amount` int UNSIGNED NULL DEFAULT NULL COMMENT '缴费金额',
  `pay_way` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '未知' COMMENT '缴费方式',
  `create_time` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `update_time` datetime NULL DEFAULT NULL,
  `share_one` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `share_two` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `share_three` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `share_four` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FK_mid_yd`(`mid`) USING BTREE,
  CONSTRAINT `FK_mid_yd` FOREIGN KEY (`mid`) REFERENCES `youth_member_info` (`mid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of youth_dues_record
-- ----------------------------
INSERT INTO `youth_dues_record` VALUES (6, '01', '21-11', 3, '支付宝支付', '2021-11-30 14:33:49', '2021-11-30 14:33:49', NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for youth_league_branch
-- ----------------------------
DROP TABLE IF EXISTS `youth_league_branch`;
CREATE TABLE `youth_league_branch`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '团支部ID',
  `branch_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '团支部名称',
  `create_time` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `update_time` datetime NULL DEFAULT NULL,
  `share_one` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备用',
  `share_two` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备用',
  `share_three` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备用',
  `share_four` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备用',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `UK_branch_name`(`branch_name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of youth_league_branch
-- ----------------------------
INSERT INTO `youth_league_branch` VALUES (1, '软工1901班团支部', '0000-00-00 00:00:00', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `youth_league_branch` VALUES (2, '计科1901班团支部', '0000-00-00 00:00:00', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `youth_league_branch` VALUES (3, '电信1902班团支部', '0000-00-00 00:00:00', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `youth_league_branch` VALUES (5, '陕西师范大学汉语言文学学院团支部', '2021-11-29 20:37:19', '2021-11-30 00:21:54', NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for youth_member_info
-- ----------------------------
DROP TABLE IF EXISTS `youth_member_info`;
CREATE TABLE `youth_member_info`  (
  `id` int UNSIGNED NOT NULL AUTO_INCREMENT,
  `uid` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户ID',
  `mid` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '团员编号',
  `youth_league_branch` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '所属团支部',
  `enter_date` date NULL DEFAULT NULL COMMENT '入团日期',
  `performance` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '表现',
  `charge` int NULL DEFAULT 0 COMMENT '应交团费',
  `create_time` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `update_time` datetime NULL DEFAULT NULL,
  `share_one` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `share_two` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `share_three` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `share_four` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `UK_mid_ym`(`mid`) USING BTREE,
  INDEX `FK_uid_y`(`uid`) USING BTREE,
  INDEX `FK_youth_branch`(`youth_league_branch`) USING BTREE,
  CONSTRAINT `FK_uid_y` FOREIGN KEY (`uid`) REFERENCES `user_base` (`uid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_youth_branch` FOREIGN KEY (`youth_league_branch`) REFERENCES `youth_league_branch` (`branch_name`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of youth_member_info
-- ----------------------------
INSERT INTO `youth_member_info` VALUES (3, '8', '01', '计科1901班团支部', '1989-07-01', '及格', 60, '2021-11-29 20:46:42', '2021-11-30 00:22:42', NULL, NULL, NULL, NULL);

SET FOREIGN_KEY_CHECKS = 1;
