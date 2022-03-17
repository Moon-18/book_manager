/*
 Navicat Premium Data Transfer

 Source Server         : 如月十八
 Source Server Type    : MySQL
 Source Server Version : 80023
 Source Host           : localhost:3306
 Source Schema         : book_manager

 Target Server Type    : MySQL
 Target Server Version : 80023
 File Encoding         : 65001

 Date: 17/03/2022 16:22:30
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for book
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book`  (
  `ID` bigint(0) NOT NULL COMMENT '主键',
  `NAME` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '名称',
  `WRITER` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '作者',
  `CREATE_TIME` date NULL DEFAULT NULL COMMENT '入馆日期',
  `KIND` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '图书种类，科教文卫体与其他',
  `COMMENT` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `ALLOW` int(0) NOT NULL COMMENT '是否允许外借，0否，1是',
  `CUR_NUM` int(0) NOT NULL COMMENT '当前在馆数量',
  `SUM_NUM` int(0) NOT NULL COMMENT '图书全部数量',
  PRIMARY KEY (`ID`) USING BTREE,
  UNIQUE INDEX `NAME`(`NAME`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES (1489485982758727681, '红楼梦', '[清] 曹雪芹', '2022-02-01', '文化', '都云作者痴，谁解其中味？', 1, 19, 20);
INSERT INTO `book` VALUES (1489486411462606850, '活着', '余华', '2022-02-02', '文化', '生的苦难与伟大', 1, 15, 15);
INSERT INTO `book` VALUES (1489486579633254401, '1984', '[英] 乔治·奥威尔 刘绍铭\n', '2022-02-03', '文化', '栗树荫下，我出卖你，你出卖我\n', 1, 9, 10);
INSERT INTO `book` VALUES (1489486901239980033, '百年孤独', '[哥伦比亚] 加西亚·马尔克斯', '2022-02-04', '文化', '魔幻现实主义文学代表作\n', 1, 5, 5);
INSERT INTO `book` VALUES (1489488782225956865, '飘', '[美国] 玛格丽特·米切尔', '2022-02-05', '文化', '革命时期的爱情，随风而逝\n', 1, 3, 3);
INSERT INTO `book` VALUES (1489488928158273537, '三体', '刘慈欣\n', '2022-02-05', '文化', '地球往事三部曲\n', 0, 8, 8);
INSERT INTO `book` VALUES (1489489151349862402, '三国演义', '[明] 罗贯中\n', '2022-02-06', '文化', '是非成败转头空\n', 1, 29, 30);
INSERT INTO `book` VALUES (1489489239165915137, '动物农场', '[英] 乔治·奥威尔荣如德\n', '2022-02-07', '文化', '太阳底下并无新事\n', 1, 10, 10);
INSERT INTO `book` VALUES (1489489328064294913, '房思琪的初恋乐园', '林奕含\n', '2022-02-08', '文化', '向死而生的文学绝唱\n', 1, 15, 15);
INSERT INTO `book` VALUES (1489489688744960002, '人类简史', '[以色列] 尤瓦尔·赫拉利', '2022-02-09', '卫生', '跟着人类一同走过十万年\n', 0, 22, 22);
INSERT INTO `book` VALUES (1489489818785255426, '中国历代政治得失', '钱穆\n', '2022-02-10', '文化', '一部简明的“中国政治制度史”\n', 1, 12, 12);
INSERT INTO `book` VALUES (1504368338653011969, '算法竞赛入门经典', '刘汝佳', '2022-03-17', '教育', '程序设计思维与实践', 0, 15, 15);

-- ----------------------------
-- Table structure for inf
-- ----------------------------
DROP TABLE IF EXISTS `inf`;
CREATE TABLE `inf`  (
  `ID` bigint(0) NOT NULL COMMENT 'ID',
  `BOOK_ID` bigint(0) NOT NULL COMMENT '对应图书id',
  `READER_ID` bigint(0) NOT NULL COMMENT '对应读者id',
  `STATE` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '这一条借阅信息的状态，正常还是异常，字符串类型的，标明状态',
  `IN_DATE` date NULL DEFAULT NULL COMMENT '还书时间，允许为空，表示未还',
  `OUT_DATE` date NULL DEFAULT NULL COMMENT '借出时间',
  `MESSAGE` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '借阅信息管理' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of inf
-- ----------------------------
INSERT INTO `inf` VALUES (1491354585875369985, 1489485982758727681, 1489590815759024129, '归还', '2022-02-09', '2022-02-09', '');
INSERT INTO `inf` VALUES (1491354756369633281, 1489486579633254401, 1489590815759024129, '归还', '2022-02-09', '2022-02-09', '');
INSERT INTO `inf` VALUES (1491361969800867842, 1489486579633254401, 1489590815759024129, '归还', '2022-02-09', '2022-02-09', '');
INSERT INTO `inf` VALUES (1491364342027902977, 1489489151349862402, 1489590815759024129, '归还', '2022-02-09', '2022-02-09', '');
INSERT INTO `inf` VALUES (1491368867744833537, 1489489239165915137, 1489590815759024129, '异常', '2022-02-09', '2022-02-09', '图书损坏');
INSERT INTO `inf` VALUES (1491399135037878274, 1489485982758727681, 1489591032785006593, '借出', NULL, '2022-02-09', '');
INSERT INTO `inf` VALUES (1491399549183455234, 1489486579633254401, 1489591032785006593, '借出', NULL, '2022-02-09', '');
INSERT INTO `inf` VALUES (1491399691773014018, 1489489151349862402, 1489591128557740033, '借出', NULL, '2022-02-09', '');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `ID` bigint(0) NOT NULL,
  `NAME` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `ACCOUNT` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `TYPE` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `PASSWORD` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  PRIMARY KEY (`ID`) USING BTREE,
  UNIQUE INDEX `ACCOUNT_UNIQUE`(`ACCOUNT`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '图书馆的管理员列表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1489590815759024129, '张三', 'user1@sina.com', 'user', '123456');
INSERT INTO `user` VALUES (1489591032785006593, '李四', 'user2@sina.com', 'user', '123456');
INSERT INTO `user` VALUES (1489591128557740033, '王五', 'user3@sina.com', 'user', '123456');
INSERT INTO `user` VALUES (1489591182639042561, '赵六', 'user4@sina.com', 'user', '123456');
INSERT INTO `user` VALUES (1489591545182081026, '管理员', '1911834200@qq.com', 'admin', '123456');
INSERT INTO `user` VALUES (1489779459614576641, '测试修改功能', 'user4@email.com', 'user', '123456');
INSERT INTO `user` VALUES (1490849929793400833, '123', '123@hello.com', 'user', '1234567');
INSERT INTO `user` VALUES (1490863341789343745, '一位普通的读者', '1911834200@sina.com', 'user', '123456');
INSERT INTO `user` VALUES (1491025476720787457, '321', '321@qq.com', 'user', '654321');

SET FOREIGN_KEY_CHECKS = 1;
