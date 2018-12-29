/*
Navicat MySQL Data Transfer

Source Server         : 腾讯云MySQL
Source Server Version : 50723
Source Host           : 139.199.66.197:3306
Source Database       : machineroomsystem

Target Server Type    : MYSQL
Target Server Version : 50723
File Encoding         : 65001

Date: 2018-12-29 21:48:01
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for administrator
-- ----------------------------
DROP TABLE IF EXISTS `administrator`;
CREATE TABLE `administrator` (
  `admin_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '管理员ID',
  `admin_password` varchar(50) NOT NULL COMMENT '管理员密码',
  `admin_name` varchar(50) NOT NULL COMMENT '管理员姓名',
  `admin_phone` char(11) NOT NULL COMMENT '管理员电话',
  `role_id` int(2) NOT NULL COMMENT '管理员权限',
  `admin_email` varchar(255) NOT NULL COMMENT '管理员邮箱',
  PRIMARY KEY (`admin_id`),
  KEY `admin_permission_FROM_role_id` (`role_id`) USING BTREE,
  CONSTRAINT `administrator_ibfk_1` FOREIGN KEY (`role_id`) REFERENCES `role` (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of administrator
-- ----------------------------
INSERT INTO `administrator` VALUES ('1', 'test123456', '张三', '13283497594', '1', 'test@gmail.com');
INSERT INTO `administrator` VALUES ('2', 'R+wt15HjHi7yB2yvZO2bPQ==', '李四', '13841547255', '0', 'lisi@163.com');
INSERT INTO `administrator` VALUES ('4', 'BXzelf1HHIpduwTQDVRvXw==', '李四', '13842512341', '1', 'lisi@ooutlook.com');
INSERT INTO `administrator` VALUES ('5', 'R+wt15HjHi7yB2yvZO2bPQ==', '王五', '13643265439', '1', 'test@gmail.com');
INSERT INTO `administrator` VALUES ('6', 'R+wt15HjHi7yB2yvZO2bPQ==', '王八蛋', '14325784513', '0', 'qwer@baidu.com');
INSERT INTO `administrator` VALUES ('7', '6Afx/PgtEy+bsBjKZzihnw==', '李白', '12345678901', '0', 'qwer@er.com');
INSERT INTO `administrator` VALUES ('8', '6Afx/PgtEy+bsBjKZzihnw==', '杜甫', '12345678901', '1', 'asdf@qq.com');
INSERT INTO `administrator` VALUES ('9', '6Afx/PgtEy+bsBjKZzihnw==', '白居易', '12345432109', '0', 'fghj@ol.cn');
INSERT INTO `administrator` VALUES ('10', 'JfnnlDI7RTiF9RgfG2JNCw==', '锄禾', '12345698741', '1', 'fdsp@ert.cn');
INSERT INTO `administrator` VALUES ('11', 'JfnnlDI7RTiF9RgfG2JNCw==', '当午', '13687496258', '1', 'test@gmail.com');
INSERT INTO `administrator` VALUES ('12', 'BErHEVOXQrUiuSaX26vc6g==', '孔子', '12346587946', '0', 'zxc@qwer.com');
INSERT INTO `administrator` VALUES ('13', '6Afx/PgtEy+bsBjKZzihnw==', '刘备', '13854682364', '0', 'bnms@qwe.com');

-- ----------------------------
-- Table structure for building
-- ----------------------------
DROP TABLE IF EXISTS `building`;
CREATE TABLE `building` (
  `building_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '实训楼ID',
  `building_name` varchar(50) NOT NULL COMMENT '实训楼名称',
  PRIMARY KEY (`building_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of building
-- ----------------------------
INSERT INTO `building` VALUES ('1', '实训楼A');
INSERT INTO `building` VALUES ('2', '实训楼B');
INSERT INTO `building` VALUES ('3', '实训楼C');

-- ----------------------------
-- Table structure for class
-- ----------------------------
DROP TABLE IF EXISTS `class`;
CREATE TABLE `class` (
  `class_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '实训室ID',
  `class_name` varchar(50) NOT NULL COMMENT '实训室名称',
  `building_id` int(11) NOT NULL COMMENT '所属实训楼',
  `computer_total` int(3) NOT NULL COMMENT '电脑总数',
  `computer_enable` int(3) NOT NULL COMMENT '可用电脑总数',
  `computer_disable` int(3) NOT NULL COMMENT '不可用电脑总数',
  PRIMARY KEY (`class_id`),
  KEY `classes_building_id_FROM_building_building_id` (`building_id`) USING BTREE,
  CONSTRAINT `class_ibfk_1` FOREIGN KEY (`building_id`) REFERENCES `building` (`building_id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of class
-- ----------------------------
INSERT INTO `class` VALUES ('1', 'B301', '2', '60', '55', '5');
INSERT INTO `class` VALUES ('2', 'B401', '2', '60', '48', '12');
INSERT INTO `class` VALUES ('3', 'A201', '1', '50', '49', '1');
INSERT INTO `class` VALUES ('4', 'C201', '3', '49', '33', '16');
INSERT INTO `class` VALUES ('5', 'A203', '1', '55', '46', '9');
INSERT INTO `class` VALUES ('7', 'A303', '1', '60', '35', '25');
INSERT INTO `class` VALUES ('8', 'C401', '3', '60', '47', '13');
INSERT INTO `class` VALUES ('11', 'A310', '1', '30', '18', '12');
INSERT INTO `class` VALUES ('12', 'B606', '2', '70', '54', '16');
INSERT INTO `class` VALUES ('13', 'A505', '1', '45', '36', '9');
INSERT INTO `class` VALUES ('14', 'A603', '1', '50', '36', '14');
INSERT INTO `class` VALUES ('15', 'A303', '1', '60', '49', '11');
INSERT INTO `class` VALUES ('16', 'B404', '2', '80', '64', '16');

-- ----------------------------
-- Table structure for complete_order
-- ----------------------------
DROP TABLE IF EXISTS `complete_order`;
CREATE TABLE `complete_order` (
  `order_id` int(11) NOT NULL COMMENT '完成工单ID',
  `problem` text NOT NULL COMMENT '工单问题',
  `remark` text NOT NULL COMMENT '记录',
  `admin_id` int(11) NOT NULL COMMENT '管理员ID',
  `complete_time` datetime NOT NULL COMMENT '完成时间',
  `image_path` varchar(255) DEFAULT NULL COMMENT '故障图片',
  `class_id` int(11) NOT NULL,
  `building_id` int(11) NOT NULL,
  `computer_number` int(11) NOT NULL,
  PRIMARY KEY (`order_id`),
  KEY `complete_orders_admin_id_FROM_admin_admin_id` (`admin_id`) USING BTREE,
  KEY `complete_orders_class_id_FROM_class_class_id` (`class_id`) USING BTREE,
  KEY `complete_orders_building_id_FROM_building_building_id` (`building_id`) USING BTREE,
  CONSTRAINT `complete_order_ibfk_1` FOREIGN KEY (`admin_id`) REFERENCES `administrator` (`admin_id`),
  CONSTRAINT `complete_order_ibfk_2` FOREIGN KEY (`building_id`) REFERENCES `building` (`building_id`),
  CONSTRAINT `complete_order_ibfk_3` FOREIGN KEY (`class_id`) REFERENCES `class` (`class_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of complete_order
-- ----------------------------
INSERT INTO `complete_order` VALUES ('16', '电脑死机', '水电费计算机佛钮司愤怒值山地车奴is的愤怒is大怒IC你就说答复你带你吃你吃大城市介电常数  及收入单机电风扇电风扇 水电费围绕输入法输入法输入法为人父而非而非', '4', '2018-12-10 18:22:01', '/2018-11-13/2018-11-13&20-55-40光头强527fc381-c2bc-4aff-8cb3-c1683e4a02bb.jpg', '7', '1', '12');
INSERT INTO `complete_order` VALUES ('22', '电脑很卡', '按时打多大大多啊啊啊打大大大法司法大哥哥啥的额放到乳房合法化德国人的风格的工单的郭德纲的现代感 地方', '4', '2018-12-10 17:22:25', '/2018-11-18/2018-11-18&16-15-40张正贤77851a01-c17c-42d1-92b7-51b108d2f8d9.jpg', '8', '3', '30');
INSERT INTO `complete_order` VALUES ('25', '电脑蓝屏阿森松岛213而我认为把握人生任务 水电费是否 是是', '让哥哥123213', '4', '2018-12-10 19:50:11', null, '3', '1', '12');
INSERT INTO `complete_order` VALUES ('29', '电脑彩虹屏', 'fsfsfs个人个人', '4', '2018-12-19 20:51:45', null, '3', '1', '12');
INSERT INTO `complete_order` VALUES ('38', '补衬托出da', 'bbibi不比一般s', '4', '2018-12-19 21:03:39', '/2018-12-19/2018-12-19&20-58-5219255f59-ed02-4852-8b78-54abc71aa342.jpg', '2', '2', '1');
INSERT INTO `complete_order` VALUES ('40', '电脑爆炸', 'ok啥来的', '4', '2018-12-26 17:24:40', '/2018-12-26/2018-12-26&17-08-5326c87967-74d8-4e64-a029-99aecf6bdc65.jpg', '4', '3', '1');
INSERT INTO `complete_order` VALUES ('43', '哈哈', '按时打多', '4', '2018-12-26 20:05:12', '/2018-12-26/2018-12-26&19-58-19eb1de39f-8998-4703-912a-71515cb88b94.jpg', '4', '3', '1');

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `order_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '工单ID',
  `problem` text NOT NULL COMMENT '工单问题',
  `computer_number` int(3) NOT NULL COMMENT '电脑序号',
  `class_id` int(11) NOT NULL COMMENT '所属教室ID',
  `building_id` int(11) NOT NULL COMMENT '所属实训楼ID',
  `status` int(1) NOT NULL COMMENT '状态',
  `submit_time` datetime NOT NULL COMMENT '提交时间',
  `images_path` varchar(255) DEFAULT NULL COMMENT '故障图片上传',
  `admin_id` int(2) DEFAULT NULL COMMENT '接手管理员ID',
  `user_name` varchar(50) NOT NULL COMMENT '报修人名称',
  `user_phone` char(11) NOT NULL COMMENT '报修人电话',
  `user_email` varchar(100) NOT NULL COMMENT '报修人邮箱',
  PRIMARY KEY (`order_id`),
  KEY `admin_class_id_FROM_classes_class_id` (`class_id`) USING BTREE,
  KEY `admin_building_id_FROM_building_building_id` (`building_id`) USING BTREE,
  CONSTRAINT `orders_ibfk_1` FOREIGN KEY (`building_id`) REFERENCES `building` (`building_id`),
  CONSTRAINT `orders_ibfk_2` FOREIGN KEY (`class_id`) REFERENCES `class` (`class_id`)
) ENGINE=InnoDB AUTO_INCREMENT=56 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES ('3', '显示屏出现问题速回复我回复is发hi古斯遇到过随公司部分渡口部分属于覅不是粉色衣服is工本费is预发布也许是有是打不死的VB四U盾VB是否VB术语一不是单身丢VB岁变速速度', '11', '4', '3', '1', '2018-10-29 21:12:34', null, '1', '杜甫', '13581432451', 'test@outlook.com');
INSERT INTO `orders` VALUES ('4', '显示屏出现问题', '11', '4', '3', '1', '2018-10-31 15:17:58', null, null, '杜甫', '13581432451', 'test@outlook.com');
INSERT INTO `orders` VALUES ('6', '电脑出现问题', '10', '4', '3', '1', '2018-11-12 22:17:54', null, '2', '王翠花', '15632587463', 'user@abc.com');
INSERT INTO `orders` VALUES ('26', '电脑绿屏', '12', '3', '1', '0', '2018-12-10 19:41:12', null, null, '李白', '13587946502', '123@456.com');
INSERT INTO `orders` VALUES ('27', '电脑红屏', '12', '3', '1', '0', '2018-12-10 19:41:12', null, null, '李白', '13587946502', '123@456.com');
INSERT INTO `orders` VALUES ('28', '电脑紫屏', '12', '3', '1', '0', '2018-12-10 19:41:12', null, null, '李白', '13587946502', '123@456.com');
INSERT INTO `orders` VALUES ('30', '电脑原谅屏', '12', '3', '1', '0', '2018-12-10 19:41:12', null, null, '李白', '13587946502', '123@456.com');
INSERT INTO `orders` VALUES ('31', '键盘不能使用', '12', '3', '1', '0', '2018-12-10 19:41:12', null, null, '李白', '13587946502', '123@456.com');
INSERT INTO `orders` VALUES ('32', '电脑不能开机 ', '1', '14', '1', '0', '2018-12-18 17:18:33', '/2018-12-18/2018-12-18&17-18-32王八蛋d1922f04-9c07-4fda-a42d-f2f59f0057eb.jpg', null, '王八蛋', '13425678413', 'qwer@126.com');
INSERT INTO `orders` VALUES ('33', '电脑不能开机', '1', '3', '1', '0', '2018-12-18 22:11:41', '/2018-12-18/2018-12-18&22-11-41熊大ce5609a0-c5f2-4dbf-a845-595270437d6b.jpg', null, '熊大', '13425678413', 'uangtouqiang@abc.com');
INSERT INTO `orders` VALUES ('34', 'qwe大苏打风纪扣', '1', '2', '2', '0', '2018-12-19 16:21:55', null, null, '王八蛋', '13290480981', 'asdfg@er.com');
INSERT INTO `orders` VALUES ('35', 'ofns史丹佛i首脑vnsd', '1', '2', '2', '0', '2018-12-19 16:26:57', null, null, '苟利', '13287650987', 'asdqwe@op.cn');
INSERT INTO `orders` VALUES ('36', 'dsf返抵石佛寺发送粉丝发', '1', '2', '2', '0', '2018-12-19 16:32:33', '/2018-12-19/2018-12-19&16-31-563499537a-6551-488e-a2e4-98ea88badfb0.jpg', null, '猪八戒', '14356789098', 'qwer@qw.cp');
INSERT INTO `orders` VALUES ('37', 'dasd是个人格人格杠', '1', '2', '2', '0', '2018-12-19 16:49:23', '/2018-12-19/2018-12-19&16-48-50256a76dd-536c-4717-a13c-d94fadea3d1a.jpg', null, '二万人', '13425678901', 'weq@qq.com');
INSERT INTO `orders` VALUES ('41', '测试', '1', '4', '3', '1', '2018-12-26 19:24:07', '/2018-12-26/2018-12-26&19-23-438c67527e-8dcb-4cbb-9f1e-f73a08d52d98.jpg', '4', '李似', '12369589761', '602048625@qq.com');
INSERT INTO `orders` VALUES ('42', '辣鸡维护员', '1', '4', '3', '1', '2018-12-26 19:27:29', '/2018-12-26/2018-12-26&19-27-00ab38f77f-e6d3-4e5f-8bb3-6f7b4eca0e14.jpg', '4', '张正贤', '11111111111', '78888888@qq.com');
INSERT INTO `orders` VALUES ('44', '哈哈啊哈还', '15', '4', '3', '0', '2018-12-26 20:27:59', '/2018-12-26/2018-12-26&20-27-22dc55ea9d-c705-4047-b167-3548f5c013a3.jpg', null, '阿猥', '40040004000', '940254992@qq.com');
INSERT INTO `orders` VALUES ('45', '哈哈哈哈哈', '8', '11', '1', '0', '2018-12-26 20:28:58', '/2018-12-26/2018-12-26&20-28-1083b44a39-b114-498e-933e-df2825b6cf49.jpg', null, '母鸡鸭', '12345678913', '534103817@qq.com');
INSERT INTO `orders` VALUES ('46', '电脑蓝屏', '4', '16', '2', '0', '2018-12-26 20:29:05', '/2018-12-26/2018-12-26&20-28-329dd4f203-5690-4c6d-bd4f-e4e7746fdebf.jpg', null, '李白', '12365897081', 'Choker@126.com');
INSERT INTO `orders` VALUES ('47', '测试', '1', '7', '1', '0', '2018-12-26 20:42:12', '/2018-12-26/2018-12-26&20-41-1252a10354-acd5-4449-9425-5435ded55c56.jpg', null, 'abc', '12345678901', '3047937681@qq.com');
INSERT INTO `orders` VALUES ('48', '蛤', '25', '2', '2', '0', '2018-12-26 20:44:58', '/2018-12-26/2018-12-26&20-43-58c94439cd-fa2b-4660-ab78-15a40d5b47a5.jpg', null, '6', '13376550917', '362562875@qq.com');
INSERT INTO `orders` VALUES ('49', '无', '25', '2', '2', '0', '2018-12-26 20:50:21', '', null, '11', '17324568522', '837766096@qq.com');
INSERT INTO `orders` VALUES ('50', '没问题', '8', '11', '1', '0', '2018-12-26 20:54:05', '/2018-12-26/2018-12-26&20-53-37493f7f52-9f89-4a8c-9b2b-25ea52b44ac2.jpg', null, 'yoyo', '18959266320', '1013202547@qq.com');
INSERT INTO `orders` VALUES ('51', '哼哼哼', '25', '2', '2', '0', '2018-12-26 21:00:45', '', null, '哼哼哼', '13422803572', '626989726@qq.com');
INSERT INTO `orders` VALUES ('52', 'cs测试', '10', '16', '2', '0', '2018-12-26 21:33:47', '/2018-12-26/2018-12-26&21-33-19763ecfa9-7ba0-4032-bb1b-88caaecb97e3.jpg', null, '吃的', '19805895698', 'test@163.com');
INSERT INTO `orders` VALUES ('53', '～', '15', '4', '3', '1', '2018-12-27 00:47:38', '/2018-12-27/2018-12-27&00-46-565f541ae2-94e7-4080-899b-28b442753147.jpg', '4', 'Mocha', '18814123215', '504263948@qq.com');
INSERT INTO `orders` VALUES ('54', '开不了机', '5', '5', '1', '0', '2018-12-29 21:02:32', '', null, '小刘', '18319787981', '2758015554@qq.com');
INSERT INTO `orders` VALUES ('55', '开', '5', '5', '1', '0', '2018-12-29 21:11:09', '', null, '小刘', '18319787981', '2503384157@qq');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `role_id` int(2) NOT NULL COMMENT '角色主键',
  `role_name` varchar(50) NOT NULL COMMENT '角色名称',
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('0', '普通管理员');
INSERT INTO `role` VALUES ('1', '超级管理员');
