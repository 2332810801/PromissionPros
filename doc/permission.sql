/*
 Navicat Premium Data Transfer

 Source Server         : 本地mysql3306
 Source Server Type    : MySQL
 Source Server Version : 80016
 Source Host           : localhost:3306
 Source Schema         : permission

 Target Server Type    : MySQL
 Target Server Version : 80016
 File Encoding         : 65001

 Date: 24/07/2020 17:42:47
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for department
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department`  (
  `id` bigint(20) NOT NULL,
  `name` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '部门名称 ',
  `sn` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '部门编号',
  `manager_id` bigint(20) NULL DEFAULT NULL,
  `parent_id` bigint(20) NULL DEFAULT NULL,
  `state` tinyint(1) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `manager_id`(`manager_id`) USING BTREE,
  INDEX `parent_id`(`parent_id`) USING BTREE,
  CONSTRAINT `department_ibfk_1` FOREIGN KEY (`manager_id`) REFERENCES `employee` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `department_ibfk_2` FOREIGN KEY (`parent_id`) REFERENCES `department` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of department
-- ----------------------------
INSERT INTO `department` VALUES (1, '技术部', NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for employee
-- ----------------------------
DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `realname` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `tel` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `email` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `inputtime` timestamp(0) NULL DEFAULT NULL,
  `state` tinyint(1) NULL DEFAULT NULL,
  `admin` tinyint(1) NULL DEFAULT NULL,
  `dep_id` bigint(20) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `dep_id`(`dep_id`) USING BTREE,
  CONSTRAINT `employee_ibfk_1` FOREIGN KEY (`dep_id`) REFERENCES `department` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 20 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of employee
-- ----------------------------
INSERT INTO `employee` VALUES (17, 'system', 'be600598bc05b3d0b097f2d397f366e5', NULL, '123', '123456@qq.com', '2020-07-24 00:00:00', 1, 1, 1);
INSERT INTO `employee` VALUES (18, 'admin', '2fe79843293c57e17c0e070d28322bdc', NULL, '123', '123456@qq.com', '2020-07-24 00:00:00', 1, 1, 1);
INSERT INTO `employee` VALUES (19, 'use', '2fe79843293c57e17c0e070d28322bdc', NULL, '11111', '123456@qq.com', '2020-07-24 00:00:00', 1, 0, 1);

-- ----------------------------
-- Table structure for employee_role_rel
-- ----------------------------
DROP TABLE IF EXISTS `employee_role_rel`;
CREATE TABLE `employee_role_rel`  (
  `eid` bigint(20) NOT NULL,
  `rid` bigint(20) NOT NULL,
  PRIMARY KEY (`eid`, `rid`) USING BTREE,
  INDEX `rid`(`rid`) USING BTREE,
  CONSTRAINT `employee_role_rel_ibfk_1` FOREIGN KEY (`eid`) REFERENCES `employee` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `employee_role_rel_ibfk_2` FOREIGN KEY (`rid`) REFERENCES `role` (`rid`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of employee_role_rel
-- ----------------------------
INSERT INTO `employee_role_rel` VALUES (18, 2);
INSERT INTO `employee_role_rel` VALUES (17, 5);
INSERT INTO `employee_role_rel` VALUES (18, 5);
INSERT INTO `employee_role_rel` VALUES (18, 7);
INSERT INTO `employee_role_rel` VALUES (19, 7);

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `text` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `url` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `parent_id` bigint(20) NULL DEFAULT NULL,
  `permission_id` bigint(20) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `parent_id`(`parent_id`) USING BTREE,
  INDEX `permisssion_id`(`permission_id`) USING BTREE,
  CONSTRAINT `menu_ibfk_1` FOREIGN KEY (`parent_id`) REFERENCES `menu` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `menu_ibfk_2` FOREIGN KEY (`permission_id`) REFERENCES `permission` (`pid`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO `menu` VALUES (1, '系统管理', '', NULL, 8);
INSERT INTO `menu` VALUES (2, '员工管理', '/employee', 1, 4);
INSERT INTO `menu` VALUES (3, '权限管理', '/role', 1, 6);
INSERT INTO `menu` VALUES (4, '菜单管理', '/menu', 1, 5);
INSERT INTO `menu` VALUES (8, '部门管理', '/departmentList', 1, 7);

-- ----------------------------
-- Table structure for permission
-- ----------------------------
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission`  (
  `pid` bigint(20) NOT NULL,
  `pname` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '权限名称',
  `presources` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`pid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of permission
-- ----------------------------
INSERT INTO `permission` VALUES (1, '员工添加', 'employee:add');
INSERT INTO `permission` VALUES (2, '员工删除', 'employee:delete');
INSERT INTO `permission` VALUES (3, '员工编辑', 'employee:edit');
INSERT INTO `permission` VALUES (4, '员工管理', 'employee:index');
INSERT INTO `permission` VALUES (5, '菜单管理', 'menu:index');
INSERT INTO `permission` VALUES (6, '权限管理', 'permission:index');
INSERT INTO `permission` VALUES (7, '部门管理', 'department:index');
INSERT INTO `permission` VALUES (8, '系统管理', 'system:index');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
  `rid` bigint(20) NOT NULL AUTO_INCREMENT,
  `rnum` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `rname` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色名称',
  PRIMARY KEY (`rid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES (2, 'system', '超级管理员');
INSERT INTO `role` VALUES (5, 'manager', '经理');
INSERT INTO `role` VALUES (7, 'hr', '人事');

-- ----------------------------
-- Table structure for role_permission_rel
-- ----------------------------
DROP TABLE IF EXISTS `role_permission_rel`;
CREATE TABLE `role_permission_rel`  (
  `rid` bigint(20) NOT NULL,
  `pid` bigint(20) NOT NULL,
  PRIMARY KEY (`rid`, `pid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role_permission_rel
-- ----------------------------
INSERT INTO `role_permission_rel` VALUES (2, 1);
INSERT INTO `role_permission_rel` VALUES (2, 2);
INSERT INTO `role_permission_rel` VALUES (2, 3);
INSERT INTO `role_permission_rel` VALUES (2, 4);
INSERT INTO `role_permission_rel` VALUES (7, 4);
INSERT INTO `role_permission_rel` VALUES (7, 8);

-- ----------------------------
-- Table structure for systemlog
-- ----------------------------
DROP TABLE IF EXISTS `systemlog`;
CREATE TABLE `systemlog`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `optime` datetime(0) NULL DEFAULT NULL,
  `ip` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `function` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `params` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
