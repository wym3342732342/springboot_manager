/*
 Navicat MySQL Data Transfer

 Source Server         : docker
 Source Server Type    : MySQL
 Source Server Version : 50562
 Source Host           : localhost:33306
 Source Schema         : universal_manage

 Target Server Type    : MySQL
 Target Server Version : 50562
 File Encoding         : 65001

 Date: 29/12/2019 12:49:33
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for PDMAN_DB_VERSION
-- ----------------------------
DROP TABLE IF EXISTS `PDMAN_DB_VERSION`;
CREATE TABLE `PDMAN_DB_VERSION` (
  `DB_VERSION` varchar(256) DEFAULT NULL,
  `VERSION_DESC` varchar(1024) DEFAULT NULL,
  `CREATED_TIME` varchar(32) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for common_file
-- ----------------------------
DROP TABLE IF EXISTS `common_file`;
CREATE TABLE `common_file` (
  `id` varchar(64) NOT NULL COMMENT 'id',
  `resolve_id` varchar(64) DEFAULT NULL COMMENT '外键',
  `file_name` varchar(1024) NOT NULL COMMENT '文件名',
  `file_size` varchar(1024) NOT NULL COMMENT '文件大小',
  `file_path` varchar(3072) NOT NULL COMMENT '原始文件路径',
  `url` varchar(3072) DEFAULT NULL COMMENT '缩略图路径',
  `file_type` varchar(32) NOT NULL COMMENT '文件类型',
  `purpose_type` varchar(32) NOT NULL COMMENT '用途',
  `version` int(11) DEFAULT NULL COMMENT '乐观锁',
  `flag` varchar(1) NOT NULL DEFAULT '0' COMMENT '逻辑删除',
  `created_by` varchar(64) DEFAULT NULL COMMENT '创建人',
  `created_time` datetime DEFAULT NULL COMMENT '创建时间',
  `updated_by` varchar(64) DEFAULT NULL COMMENT '更新人',
  `updated_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='文件表 ';

-- ----------------------------
-- Records of common_file
-- ----------------------------
BEGIN;
INSERT INTO `common_file` VALUES ('1207130918263271425', NULL, 'image-20191126212758333.png', '100211', '/uploadFile/avatar/20191218105012/20191218105012.png', '/uploadFile/avatar/20191218105012/20191218105012.png', 'phone', 'avatar', NULL, '0', 'wang', '2019-12-18 10:50:12', 'wang', '2019-12-18 10:50:12');
INSERT INTO `common_file` VALUES ('1207131840389382145', NULL, 'image-20191126212251419.png', '293640', '/uploadFile/avatar/20191218105352/20191218105352.png', '/uploadFile/avatar/20191218105352/20191218105352.png', 'phone', 'avatar', NULL, '0', 'wang', '2019-12-18 10:53:52', 'wang', '2019-12-18 10:53:52');
INSERT INTO `common_file` VALUES ('1207142633520541698', NULL, 'image-20191126212758333.png', '100211', '/uploadFile/avatar/20191218113646/20191218113646.png', '/uploadFile/avatar/20191218113646/20191218113646.png', 'phone', 'avatar', NULL, '0', 'wang', '2019-12-18 11:36:46', 'wang', '2019-12-18 11:36:46');
INSERT INTO `common_file` VALUES ('1207143388444930049', NULL, 'image-20191126212733539.png', '147082', '/uploadFile/avatar/20191218113946/20191218113946.png', '/uploadFile/avatar/20191218113946/20191218113946.png', 'phone', 'avatar', NULL, '0', 'wang', '2019-12-18 11:39:46', 'wang', '2019-12-18 11:39:46');
INSERT INTO `common_file` VALUES ('1207144151229444098', NULL, 'image-20191127204226889.png', '179668', '/uploadFile/avatar/20191218114247/20191218114247.png', '/uploadFile/avatar/20191218114247/20191218114247.png', 'phone', 'avatar', NULL, '0', 'wang', '2019-12-18 11:42:47', 'wang', '2019-12-18 11:42:47');
INSERT INTO `common_file` VALUES ('1207147812663898114', NULL, 'image-20191126212816651.png', '133307', '/uploadFile/avatar/20191218115720/20191218115720.png', '/uploadFile/avatar/20191218115720/20191218115720.png', 'phone', 'avatar', NULL, '0', 'wang', '2019-12-18 11:57:20', 'wang', '2019-12-18 11:57:20');
INSERT INTO `common_file` VALUES ('1207167252742848514', NULL, 'image-20191127204129100.png', '280553', '/uploadFile/avatar/20191218131435/20191218131435.png', '/uploadFile/avatar/20191218131435/20191218131435.png', 'phone', 'avatar', NULL, '0', 'wang', '2019-12-18 13:14:35', 'wang', '2019-12-18 13:14:35');
INSERT INTO `common_file` VALUES ('1207167572231372802', NULL, 'image-20191127203518480.png', '205030', '/uploadFile/avatar/20191218131551/20191218131551.png', '/uploadFile/avatar/20191218131551/20191218131551.png', 'phone', 'avatar', NULL, '0', 'wang', '2019-12-18 13:15:51', 'wang', '2019-12-18 13:15:51');
INSERT INTO `common_file` VALUES ('1207168139561320450', NULL, 'image-20191127203518480.png', '205030', '/uploadFile/avatar/20191218131807/20191218131807.png', '/uploadFile/avatar/20191218131807/20191218131807.png', 'phone', 'avatar', NULL, '0', 'wang', '2019-12-18 13:18:07', 'wang', '2019-12-18 13:18:07');
INSERT INTO `common_file` VALUES ('1207168179210076161', NULL, 'image-20191127203518480.png', '205030', '/uploadFile/avatar/20191218131816/20191218131816.png', '/uploadFile/avatar/20191218131816/20191218131816.png', 'phone', 'avatar', NULL, '0', 'wang', '2019-12-18 13:18:16', 'wang', '2019-12-18 13:18:16');
INSERT INTO `common_file` VALUES ('1207170266757120002', NULL, 'image-20191127203838045.png', '187866', '/uploadFile/avatar/20191218132634/20191218132634.png', '/uploadFile/avatar/20191218132634/20191218132634.png', 'phone', 'avatar', NULL, '0', 'wang', '2019-12-18 13:26:34', 'wang', '2019-12-18 13:26:34');
INSERT INTO `common_file` VALUES ('1207171012512759810', NULL, 'image-20191127203518480.png', '205030', '/uploadFile/avatar/20191218132932/20191218132932.png', '/uploadFile/avatar/20191218132932/20191218132932.png', 'phone', 'avatar', NULL, '0', 'wang', '2019-12-18 13:29:32', 'wang', '2019-12-18 13:29:32');
INSERT INTO `common_file` VALUES ('1207171354646331394', NULL, 'image-20191127202613641.png', '261604', '/uploadFile/avatar/20191218133053/20191218133053.png', '/uploadFile/avatar/20191218133053/20191218133053.png', 'phone', 'avatar', NULL, '0', 'wang', '2019-12-18 13:30:53', 'wang', '2019-12-18 13:30:53');
INSERT INTO `common_file` VALUES ('1207174905518931969', NULL, 'image-20191127202208806.png', '213923', '/uploadFile/avatar/20191218134500/20191218134500.png', '/uploadFile/avatar/20191218134500/20191218134500.png', 'phone', 'avatar', NULL, '0', 'wang', '2019-12-18 13:45:00', 'wang', '2019-12-18 13:45:00');
INSERT INTO `common_file` VALUES ('1207174928382083074', NULL, 'image-20191126211618606.png', '317700', '/uploadFile/avatar/20191218134505/20191218134505.png', '/uploadFile/avatar/20191218134505/20191218134505.png', 'phone', 'avatar', NULL, '0', 'wang', '2019-12-18 13:45:05', 'wang', '2019-12-18 13:45:05');
INSERT INTO `common_file` VALUES ('1207191034433953793', NULL, 'image-20191126212251419.png', '293640', '/uploadFile/pictureswall/20191218144905/20191218144905.png', '/uploadFile/pictureswall/20191218144905/20191218144905.png', 'phone', 'pictureswall', NULL, '0', 'wang', '2019-12-18 14:49:05', 'wang', '2019-12-18 14:49:05');
INSERT INTO `common_file` VALUES ('1207197776345620482', NULL, 'image-20191127202208806.png', '213923', '/uploadFile/pictureswall/20191218151553/20191218151553.png', '/uploadFile/pictureswall/20191218151553/20191218151553.png', 'phone', 'pictureswall', NULL, '0', 'wang', '2019-12-18 15:15:53', 'wang', '2019-12-18 15:15:53');
INSERT INTO `common_file` VALUES ('1207197823485403137', NULL, 'image-20191127204226889.png', '179668', '/uploadFile/pictureswall/20191218151604/20191218151604.png', '/uploadFile/pictureswall/20191218151604/20191218151604.png', 'phone', 'pictureswall', NULL, '0', 'wang', '2019-12-18 15:16:04', 'wang', '2019-12-18 15:16:04');
INSERT INTO `common_file` VALUES ('1207198066184609794', NULL, 'image-20191127203838045.png', '187866', '/uploadFile/pictureswall/20191218151702/20191218151702.png', '/uploadFile/pictureswall/20191218151702/20191218151702.png', 'phone', 'pictureswall', NULL, '0', 'wang', '2019-12-18 15:17:02', 'wang', '2019-12-18 15:17:02');
INSERT INTO `common_file` VALUES ('1207198170010411009', NULL, 'image-20191126211618606.png', '317700', '/uploadFile/pictureswall/20191218151727/20191218151727.png', '/uploadFile/pictureswall/20191218151727/20191218151727.png', 'phone', 'pictureswall', NULL, '0', 'wang', '2019-12-18 15:17:27', 'wang', '2019-12-18 15:17:27');
INSERT INTO `common_file` VALUES ('1210926651009429505', NULL, '屏幕快照 2019-12-26 11.52.52.png', '164494', '/uploadFile/pictureswall/20191228221306/20191228221306.png', '/uploadFile/pictureswall/20191228221306/20191228221306.png', 'phone', 'pictureswall', NULL, '0', 'wang', '2019-12-28 22:13:06', 'wang', '2019-12-28 22:13:06');
COMMIT;

-- ----------------------------
-- Table structure for common_menu
-- ----------------------------
DROP TABLE IF EXISTS `common_menu`;
CREATE TABLE `common_menu` (
  `id` varchar(64) NOT NULL COMMENT 'id',
  `key` varchar(1024) DEFAULT NULL COMMENT '路由',
  `title` varchar(1024) DEFAULT NULL COMMENT '菜单名称',
  `icon` varchar(128) DEFAULT NULL COMMENT '菜单图标',
  `version` int(11) DEFAULT NULL COMMENT '乐观锁',
  `having_children` varchar(1) NOT NULL DEFAULT '0' COMMENT '是否有孩子 默认为否，对其新增孩子时改变',
  `having_click` varchar(32) DEFAULT NULL COMMENT '是否可点击',
  `auth_key` varchar(128) DEFAULT NULL COMMENT '权限key',
  `up_id` varchar(64) DEFAULT NULL COMMENT '上级id',
  `flag` varchar(1) NOT NULL DEFAULT '0' COMMENT '逻辑删除',
  `ascription` varchar(64) DEFAULT NULL COMMENT '归属id',
  `created_by` varchar(64) DEFAULT NULL COMMENT '创建人',
  `created_time` datetime DEFAULT NULL COMMENT '创建时间',
  `updated_by` varchar(64) DEFAULT NULL COMMENT '更新人',
  `updated_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='菜单表';

-- ----------------------------
-- Records of common_menu
-- ----------------------------
BEGIN;
INSERT INTO `common_menu` VALUES ('1205722455805038594', '/home', '首页', 'home', NULL, '0', NULL, NULL, '0', '0', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `common_menu` VALUES ('1205723820975456257', '/component', '自定义组件', 'appstore', NULL, '1', NULL, NULL, '0', '0', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `common_menu` VALUES ('1205724215646887938', '/ui', 'UI', 'home', NULL, '1', NULL, NULL, '0', '0', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `common_menu` VALUES ('1205724215835631618', '/form', '表单', 'bars', NULL, '1', NULL, NULL, '0', '0', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `common_menu` VALUES ('1205724215856603137', '/table', '表格', 'table', NULL, '1', NULL, NULL, '0', '0', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `common_menu` VALUES ('1205724215869186050', '/rich', '富文本', 'container', NULL, '0', NULL, NULL, '0', '0', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `common_menu` VALUES ('1205724215885963266', '/charts', '图标', 'layout', NULL, '1', NULL, NULL, '0', '0', NULL, 'king', '2019-12-14 13:57:20', 'king', '2019-12-14 13:57:20');
INSERT INTO `common_menu` VALUES ('1205724215915323394', '/user/management/permission', '菜单管理', 'menu', NULL, '0', NULL, NULL, '1206389142959267841', '0', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `common_menu` VALUES ('1205724890208423938', '/component/img', '滑动图片轮播图', 'yuque', NULL, '0', NULL, NULL, '1205723820975456257', '0', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `common_menu` VALUES ('1205724890384584705', '/component/list', '商品展示', 'yuque', NULL, '0', NULL, NULL, '1205723820975456257', '0', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `common_menu` VALUES ('1205725880311648258', '/ui/buttons', '按钮', NULL, NULL, '0', NULL, NULL, '1205724215646887938', '0', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `common_menu` VALUES ('1205725880533946370', '/ui/modals', '弹框', NULL, NULL, '0', NULL, NULL, '1205724215646887938', '0', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `common_menu` VALUES ('1205725880554917889', '/ui/loadings', '自定义组件', 'loading', NULL, '0', NULL, NULL, '1205724215646887938', '0', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `common_menu` VALUES ('1205725880575889409', '/ui/notification', '通知提醒', NULL, NULL, '0', NULL, NULL, '1205724215646887938', '0', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `common_menu` VALUES ('1205725880601055234', '/ui/messages', '全局Message', NULL, NULL, '0', NULL, NULL, '1205724215646887938', '0', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `common_menu` VALUES ('1205725880626221058', '/ui/tabs', 'Tab页签', NULL, NULL, '0', NULL, NULL, '1205724215646887938', '0', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `common_menu` VALUES ('1205725880651386882', '/ui/gallery', '图片画廊', NULL, NULL, '0', NULL, NULL, '1205724215646887938', '0', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `common_menu` VALUES ('1205725880676552706', '/ui/carousel', '轮播图', NULL, NULL, '0', NULL, NULL, '1205724215646887938', '0', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `common_menu` VALUES ('1205726901222014978', '/form/login', '登录', NULL, NULL, '0', NULL, NULL, '1205724215835631618', '0', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `common_menu` VALUES ('1205726901423341569', '/form/reg', '注册', NULL, NULL, '0', NULL, NULL, '1205724215835631618', '0', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `common_menu` VALUES ('1205727164347490305', '/table/basic', '基础表格', NULL, NULL, '0', NULL, NULL, '1205724215856603137', '0', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `common_menu` VALUES ('1205727164540428290', '/table/high', '高级表格', NULL, NULL, '0', NULL, NULL, '1205724215856603137', '0', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `common_menu` VALUES ('1205727743232757761', '/charts/bar', '柱形图', NULL, NULL, '0', NULL, NULL, '1205724215885963266', '0', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `common_menu` VALUES ('1205728457472413698', '/charts/pie', '饼图', NULL, NULL, '0', NULL, NULL, '1205724215885963266', '0', NULL, 'king', '2019-12-14 13:57:20', 'king', '2019-12-14 13:57:20');
INSERT INTO `common_menu` VALUES ('1205728686649151489', '/charts/line', '折线图', NULL, NULL, '0', NULL, NULL, '1205724215885963266', '0', NULL, 'king', '2019-12-14 13:58:14', 'king', '2019-12-14 13:58:14');
INSERT INTO `common_menu` VALUES ('1206389142959267841', '/user/management', '权限管理', 'coffee', NULL, '1', NULL, NULL, '0', '0', NULL, 'king', '2019-12-16 11:24:04', 'king', '2019-12-16 11:24:04');
INSERT INTO `common_menu` VALUES ('1206414662623068161', '/user/management/account', '账户管理', 'contacts', NULL, '0', NULL, NULL, '1206389142959267841', '0', NULL, 'king', '2019-12-16 11:24:04', 'king', '2019-12-16 11:24:04');
INSERT INTO `common_menu` VALUES ('1206549588848758785', '/component/upload', '上传组件', 'upload', NULL, '0', NULL, NULL, '1205723820975456257', '0', NULL, 'king', '2019-12-16 20:20:13', 'king', '2019-12-16 20:20:13');
INSERT INTO `common_menu` VALUES ('1207261362107514882', '/user/management/role', '角色管理', 'usergroup-add', NULL, '0', NULL, NULL, '1206389142959267841', '0', NULL, 'king', '2019-12-18 19:28:33', 'king', '2019-12-18 19:28:33');
INSERT INTO `common_menu` VALUES ('1207274356703023105', '/component/select', '选择器组件', 'check', NULL, '0', NULL, NULL, '1205723820975456257', '0', NULL, 'king', '2019-12-18 20:20:11', 'king', '2019-12-18 20:20:11');
COMMIT;

-- ----------------------------
-- Table structure for common_role
-- ----------------------------
DROP TABLE IF EXISTS `common_role`;
CREATE TABLE `common_role` (
  `id` varchar(64) NOT NULL COMMENT 'id',
  `role_name` varchar(128) NOT NULL COMMENT '角色名',
  `description` varchar(255) NOT NULL COMMENT '角色描述',
  `version` int(11) NOT NULL DEFAULT '0' COMMENT '乐观锁',
  `flag` varchar(1) NOT NULL DEFAULT '0' COMMENT '逻辑删除',
  `preset` varchar(1) NOT NULL DEFAULT '0',
  `created_by` varchar(64) DEFAULT NULL COMMENT '创建人',
  `created_time` datetime DEFAULT NULL COMMENT '创建时间',
  `updated_by` varchar(64) DEFAULT NULL COMMENT '更新人',
  `updated_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色表';

-- ----------------------------
-- Records of common_role
-- ----------------------------
BEGIN;
INSERT INTO `common_role` VALUES ('1207267224398102529', '系统管理员', '系统管理员，拥有一切权限.', 0, '0', '0', NULL, NULL, NULL, NULL);
INSERT INTO `common_role` VALUES ('1207267612161507330', '商品管理员', '拥有上架商品的权限.', 0, '0', '0', NULL, NULL, NULL, NULL);
INSERT INTO `common_role` VALUES ('1207271655885864961', '普通用户', '普通用户，不能管理，只能使用', 0, '0', '0', NULL, NULL, NULL, NULL);
INSERT INTO `common_role` VALUES ('1207271776203669506', '参观权限', '查询组件展示权限的内容', 0, '0', '0', NULL, NULL, NULL, NULL);
INSERT INTO `common_role` VALUES ('1207271813436506113', '测试角色', '1', 0, '1', '0', NULL, NULL, NULL, NULL);
INSERT INTO `common_role` VALUES ('1207271846038831106', '测试角色2', '2', 0, '0', '0', NULL, NULL, NULL, NULL);
INSERT INTO `common_role` VALUES ('1207271963609366529', '监管单位', '可以查看所有订购出售药品的记录', 0, '0', '0', NULL, NULL, NULL, NULL);
INSERT INTO `common_role` VALUES ('1210746470441463809', '药品出售单位', '可以出售药品在平台出售药品', 0, '0', '0', NULL, NULL, NULL, NULL);
INSERT INTO `common_role` VALUES ('1210746513571491842', '药品订购单位', '可以在此平台订购药品', 0, '0', '0', NULL, NULL, NULL, NULL);
INSERT INTO `common_role` VALUES ('1210746550632361985', '测试系统角色', '1', 0, '0', '0', NULL, NULL, NULL, NULL);
COMMIT;

-- ----------------------------
-- Table structure for common_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `common_role_menu`;
CREATE TABLE `common_role_menu` (
  `id` varchar(64) NOT NULL COMMENT 'id',
  `role_id` varchar(64) NOT NULL COMMENT '角色id',
  `menu_id` varchar(64) NOT NULL COMMENT '对应的表id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色权限表';

-- ----------------------------
-- Records of common_role_menu
-- ----------------------------
BEGIN;
INSERT INTO `common_role_menu` VALUES ('1211130377465344002', '1207271776203669506', '1205722455805038594');
INSERT INTO `common_role_menu` VALUES ('1211130377473732609', '1207271776203669506', '1205723820975456257');
INSERT INTO `common_role_menu` VALUES ('1211130377473732610', '1207271776203669506', '1205724215646887938');
INSERT INTO `common_role_menu` VALUES ('1211130377477926914', '1207271776203669506', '1205724890208423938');
INSERT INTO `common_role_menu` VALUES ('1211130377477926915', '1207271776203669506', '1205724890384584705');
INSERT INTO `common_role_menu` VALUES ('1211130377477926916', '1207271776203669506', '1206549588848758785');
INSERT INTO `common_role_menu` VALUES ('1211130377482121218', '1207271776203669506', '1207274356703023105');
INSERT INTO `common_role_menu` VALUES ('1211130377482121219', '1207271776203669506', '1205725880311648258');
INSERT INTO `common_role_menu` VALUES ('1211130377482121220', '1207271776203669506', '1205725880533946370');
INSERT INTO `common_role_menu` VALUES ('1211130377490509826', '1207271776203669506', '1205725880575889409');
INSERT INTO `common_role_menu` VALUES ('1211130377490509827', '1207271776203669506', '1205725880554917889');
INSERT INTO `common_role_menu` VALUES ('1211130377490509828', '1207271776203669506', '1205725880601055234');
INSERT INTO `common_role_menu` VALUES ('1211130377490509829', '1207271776203669506', '1205725880626221058');
INSERT INTO `common_role_menu` VALUES ('1211130377494704130', '1207271776203669506', '1205725880651386882');
INSERT INTO `common_role_menu` VALUES ('1211130377494704131', '1207271776203669506', '1205725880676552706');
INSERT INTO `common_role_menu` VALUES ('1211130377498898433', '1207271776203669506', '1205726901222014978');
INSERT INTO `common_role_menu` VALUES ('1211130377498898434', '1207271776203669506', '1205726901423341569');
INSERT INTO `common_role_menu` VALUES ('1211130377498898435', '1207271776203669506', '1205724215835631618');
INSERT INTO `common_role_menu` VALUES ('1211130377498898436', '1207271776203669506', '1205724215856603137');
INSERT INTO `common_role_menu` VALUES ('1211130377498898437', '1207271776203669506', '1205727164347490305');
INSERT INTO `common_role_menu` VALUES ('1211130377503092737', '1207271776203669506', '1205727164540428290');
INSERT INTO `common_role_menu` VALUES ('1211130377503092738', '1207271776203669506', '1206389142959267841');
INSERT INTO `common_role_menu` VALUES ('1211130377503092739', '1207271776203669506', '1205724215915323394');
INSERT INTO `common_role_menu` VALUES ('1211130377503092740', '1207271776203669506', '1206414662623068161');
INSERT INTO `common_role_menu` VALUES ('1211130377507287042', '1207271776203669506', '1207261362107514882');
COMMIT;

-- ----------------------------
-- Table structure for common_user
-- ----------------------------
DROP TABLE IF EXISTS `common_user`;
CREATE TABLE `common_user` (
  `id` varchar(64) NOT NULL COMMENT 'id',
  `user_name` varchar(32) DEFAULT NULL COMMENT '用户名',
  `pass_word` varchar(255) DEFAULT NULL COMMENT '密码',
  `salt_value` varchar(64) DEFAULT NULL COMMENT '盐值',
  `real_name` varchar(128) DEFAULT NULL COMMENT '真实姓名',
  `address` varchar(32) DEFAULT NULL COMMENT '住址',
  `identity` varchar(32) DEFAULT NULL COMMENT '身份',
  `version` int(11) DEFAULT NULL COMMENT '乐观锁',
  `flag` varchar(1) NOT NULL DEFAULT '0' COMMENT '逻辑删除',
  `created_by` varchar(64) DEFAULT NULL COMMENT '创建人',
  `created_time` datetime DEFAULT NULL COMMENT '创建时间',
  `updated_by` varchar(64) DEFAULT NULL COMMENT '更新人',
  `updated_time` datetime DEFAULT NULL COMMENT '更新时间',
  `preset` varchar(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Records of common_user
-- ----------------------------
BEGIN;
INSERT INTO `common_user` VALUES ('1206385415049269250', 'wanghaha', '$2a$10$htcpkNUbsFQW/y9l//26LeK2rETqDA7gdpYcZWY1to6R9u1VBjus.', 'f664d1f4f68344fc818d9e9c676ae549', 'admin', '天津市西青区天津工业大学', NULL, NULL, '0', 'king', '2019-12-16 09:27:51', 'king', '2019-12-21 20:23:28', '1');
INSERT INTO `common_user` VALUES ('1206480907175231490', 'RZ-ZX00005', '$2a$10$htcpkNUbsFQW/y9l//26LeK2rETqDA7gdpYcZWY1to6R9u1VBjus.', 'dda5400d9aa4444f98ed4a96d4911823', '张三', '天津市西青区天津工业大学', NULL, NULL, '0', 'king', '2019-12-16 15:47:18', 'king', '2019-12-21 20:23:42', '0');
INSERT INTO `common_user` VALUES ('1206481171294748674', 'wangyiming', '$2a$10$htcpkNUbsFQW/y9l//26LeK2rETqDA7gdpYcZWY1to6R9u1VBjus.', '3f6850c3d41b494c98a5a270af906728', '李四', '天津市西青区天津工业大学', NULL, NULL, '0', 'king', '2019-12-16 15:48:21', 'king', '2019-12-29 11:33:30', '0');
INSERT INTO `common_user` VALUES ('1206496217819369474', 'yiming', '$2a$10$htcpkNUbsFQW/y9l//26LeK2rETqDA7gdpYcZWY1to6R9u1VBjus.', 'ff6e76662d4f47afbce68cdd53c206c2', '王二', '天津市西青区天津工业大学', NULL, NULL, '0', 'king', '2019-12-16 16:48:08', 'king', '2019-12-21 20:23:58', '0');
INSERT INTO `common_user` VALUES ('121313135415049269250', 'xieyue', '$2a$10$htcpkNUbsFQW/y9l//26LeK2rETqDA7gdpYcZWY1to6R9u1VBjus.', '580f61dbe53343b69e26469c83e16b7b', '小红', '天津市西青区天津工业大学', NULL, NULL, '0', 'king', '2019-12-16 09:27:51', 'king', '2019-12-21 20:24:04', '0');
INSERT INTO `common_user` VALUES ('122112', 'yiming5', '$2a$10$htcpkNUbsFQW/y9l//26LeK2rETqDA7gdpYcZWY1to6R9u1VBjus.', '85f813292a6f4dcc8a1cbba3a56d33b9', '王一名', '天津市西青区天津工业大学', NULL, NULL, '1', 'king', '2019-12-16 09:27:51', 'king', '2019-12-16 17:16:58', '0');
INSERT INTO `common_user` VALUES ('122135415049269250', 'yiming4', '$2a$10$htcpkNUbsFQW/y9l//26LeK2rETqDA7gdpYcZWY1to6R9u1VBjus.', 'e9d52071987c40eb916c9ba85d811b2d', '小明', '天津市西青区天津工业大学', NULL, NULL, '0', 'king', '2019-12-16 09:27:51', 'king', '2019-12-28 10:23:30', '0');
INSERT INTO `common_user` VALUES ('1331314', 'yiming2', '$2a$10$htcpkNUbsFQW/y9l//26LeK2rETqDA7gdpYcZWY1to6R9u1VBjus.', 'ba56f0414e76477ab87d40bc4fdb1ddf', '二小', '天津市西青区天津工业大学', NULL, NULL, '0', 'king', '2019-12-16 09:27:51', 'king', '2019-12-28 10:23:46', '0');
INSERT INTO `common_user` VALUES ('142421', 'yiming1', '$2a$10$htcpkNUbsFQW/y9l//26LeK2rETqDA7gdpYcZWY1to6R9u1VBjus.', 'ae904f32eb404f28b53e780de16a341f', '王一名', '123', NULL, NULL, '1', 'king', '2019-12-16 09:27:51', 'king', '2019-12-16 17:17:22', '0');
INSERT INTO `common_user` VALUES ('21122121415049269250', 'yiming6', '$2a$10$htcpkNUbsFQW/y9l//26LeK2rETqDA7gdpYcZWY1to6R9u1VBjus.', 'f235079d81f74debbec0927430c6e73b', '牛郎', '天津', NULL, NULL, '0', 'king', '2019-12-16 09:27:51', 'king', '2019-12-28 10:23:53', '0');
COMMIT;

-- ----------------------------
-- Table structure for common_user_role
-- ----------------------------
DROP TABLE IF EXISTS `common_user_role`;
CREATE TABLE `common_user_role` (
  `id` varchar(64) NOT NULL COMMENT 'id',
  `user_id` varchar(64) NOT NULL COMMENT '用户表id',
  `role_id` varchar(64) NOT NULL COMMENT '角色表id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户角色表';

-- ----------------------------
-- Records of common_user_role
-- ----------------------------
BEGIN;
INSERT INTO `common_user_role` VALUES ('1208362345285832706', '1206385415049269250', '1207267224398102529');
INSERT INTO `common_user_role` VALUES ('1208362406061297666', '1206480907175231490', '1207271655885864961');
INSERT INTO `common_user_role` VALUES ('1208362406069686274', '1206480907175231490', '1207271776203669506');
INSERT INTO `common_user_role` VALUES ('1208362473065304065', '1206496217819369474', '1207271655885864961');
INSERT INTO `common_user_role` VALUES ('1208362497631342593', '121313135415049269250', '1207271655885864961');
INSERT INTO `common_user_role` VALUES ('1210748074188124162', '122135415049269250', '1210746470441463809');
INSERT INTO `common_user_role` VALUES ('1210748143016652802', '1331314', '1210746513571491842');
INSERT INTO `common_user_role` VALUES ('1210748172838154242', '21122121415049269250', '1210746550632361985');
INSERT INTO `common_user_role` VALUES ('1211128079410376705', '1206481171294748674', '1207271776203669506');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
