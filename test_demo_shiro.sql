-- --------------------------------------------------------
-- 主机:                           127.0.0.1
-- 服务器版本:                        5.7.24-log - MySQL Community Server (GPL)
-- 服务器操作系统:                      Win32
-- HeidiSQL 版本:                  9.5.0.5196
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- 导出 test_demo_shiro 的数据库结构
CREATE DATABASE IF NOT EXISTS `test_demo_shiro` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;
USE `test_demo_shiro`;

-- 导出  表 test_demo_shiro.permission 结构
CREATE TABLE IF NOT EXISTS `permission` (
  `permission_id` int(11) NOT NULL AUTO_INCREMENT,
  `url` varchar(50) DEFAULT NULL,
  `perms` varchar(50) DEFAULT NULL,
  `permission` varchar(50) NOT NULL,
  `resource_type` int(11) NOT NULL COMMENT '0 菜单   1 按钮',
  `parent_id` int(11) NOT NULL,
  PRIMARY KEY (`permission_id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb4;

-- 正在导出表  test_demo_shiro.permission 的数据：~10 rows (大约)
/*!40000 ALTER TABLE `permission` DISABLE KEYS */;
INSERT INTO `permission` (`permission_id`, `url`, `perms`, `permission`, `resource_type`, `parent_id`) VALUES
	(1, '/userPage', 'user:list', '用户管理', 0, 10),
	(2, '/rolePage', 'role:list', '角色管理', 0, 10),
	(3, '/permissionPage', 'permission:list', '权限管理', 0, 10),
	(4, NULL, 'user:add', '添加用户', 1, 1),
	(5, NULL, 'user:delete', '删除用户', 1, 1),
	(6, NULL, 'role:add', '添加角色', 1, 2),
	(7, NULL, 'permission:add', '添加权限', 1, 3),
	(8, NULL, 'user:update', '更新用户', 1, 1),
	(10, NULL, NULL, '系统管理', 0, 0),
	(20, NULL, NULL, '其他管理', 0, 0),
	(21, NULL, 'role:update', '更新角色', 1, 2),
	(22, NULL, 'role:delete', '删除角色', 1, 2),
	(23, NULL, 'permission:update', '更新权限', 1, 3),
	(24, NULL, 'permission:delete', '删除权限', 1, 3);
/*!40000 ALTER TABLE `permission` ENABLE KEYS */;

-- 导出  表 test_demo_shiro.role 结构
CREATE TABLE IF NOT EXISTS `role` (
  `role_id` int(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(50) NOT NULL,
  `description` varchar(50) NOT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4;

-- 正在导出表  test_demo_shiro.role 的数据：~3 rows (大约)
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` (`role_id`, `role_name`, `description`) VALUES
	(1, 'root', '超级管理'),
	(2, 'admin', '普通管理'),
	(8, 'tests', 'tests');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;

-- 导出  表 test_demo_shiro.role_permission 结构
CREATE TABLE IF NOT EXISTS `role_permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) NOT NULL,
  `permission_id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=utf8mb4;

-- 正在导出表  test_demo_shiro.role_permission 的数据：~14 rows (大约)
/*!40000 ALTER TABLE `role_permission` DISABLE KEYS */;
INSERT INTO `role_permission` (`id`, `role_id`, `permission_id`) VALUES
	(1, 1, 1),
	(2, 1, 2),
	(3, 1, 3),
	(4, 1, 4),
	(5, 1, 5),
	(6, 1, 6),
	(7, 1, 7),
	(8, 1, 10),
	(9, 2, 1),
	(10, 1, 20),
	(11, 1, 8),
	(12, 1, 21),
	(13, 1, 22),
	(14, 8, 10),
	(46, 1, 23),
	(47, 1, 24);
/*!40000 ALTER TABLE `role_permission` ENABLE KEYS */;

-- 导出  表 test_demo_shiro.user 结构
CREATE TABLE IF NOT EXISTS `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `name` varchar(50) DEFAULT NULL COMMENT '昵称或者真实姓名',
  `password` varchar(50) NOT NULL,
  `status` int(11) NOT NULL COMMENT '用户状态 1启动  0 禁用',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4;

-- 正在导出表  test_demo_shiro.user 的数据：~4 rows (大约)
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`user_id`, `username`, `name`, `password`, `status`) VALUES
	(1, 'root', '超级管理', '63a9f0ea7bb98050796b649e85481845', 1),
	(2, 'admin', '普通管理', '21232f297a57a5a743894a0e4a801fc3', 0),
	(20, 'test', NULL, 'e10adc3949ba59abbe56e057f20f883e', 1),
	(23, 'whh', NULL, '123456', 1);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;

-- 导出  表 test_demo_shiro.user_role 结构
CREATE TABLE IF NOT EXISTS `user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4;

-- 正在导出表  test_demo_shiro.user_role 的数据：~6 rows (大约)
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
INSERT INTO `user_role` (`id`, `user_id`, `role_id`) VALUES
	(1, 1, 1),
	(2, 2, 2),
	(3, 1, 2),
	(12, 20, 1),
	(16, 23, 1),
	(17, 23, 2);
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
