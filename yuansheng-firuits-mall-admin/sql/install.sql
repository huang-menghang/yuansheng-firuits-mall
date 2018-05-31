
#  分类列表--- 分类图片表格
DROP TABLE IF EXISTS `t_ys_firuits_category`;
CREATE TABLE `t_ys_firuits_category` (
  `id` int(4) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) DEFAULT NULL,
  `imageUrl` varchar(64) DEFAULT NULL,
  `remark` varchar(32) DEFAULT NULL,
  `sort` int(4) DEFAULT NULL,
  `status` tinyint(1) NOT NULL DEFAULT '1' COMMENT '0为使用状态，1为下架状态',
  `description` varchar(64) DEFAULT NULL,
  `parentId` int(4) DEFAULT NULL,
  `level` int(4) DEFAULT NULL,
  `createTime` timestamp NULL DEFAULT NULL,
  `updateTime` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

#    轮播图管理----轮播图表格
DROP TABLE IF EXISTS `t_ys_firuits_scroll_image`;
CREATE TABLE `t_ys_firuits_scroll_image` (
  `id` int(4) NOT NULL AUTO_INCREMENT,
  `name` varchar(16) DEFAULT NULL,
  `imageHref` varchar(64) DEFAULT NULL,
  `imageUrl` varchar(64) DEFAULT NULL,
  `sort` int(4) DEFAULT '1',
  `status` tinyint(1) DEFAULT '0' COMMENT '0表示使用中，1表示暂不使用',
  `description` varchar(64) DEFAULT NULL,
  `createTime` timestamp NULL DEFAULT NULL,
  `updateTime` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;


#    角色表
CREATE TABLE `t_ys_firuits_role_permission` (
  `id` int(8) NOT NULL AUTO_INCREMENT,
  `roleId` int(8) DEFAULT NULL COMMENT '角色编号',
  `permissionId` int(8) DEFAULT NULL COMMENT '权限编号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;


#    权限表
CREATE TABLE `t_ys_firuits_permission` (
  `status` tinyint(1) NOT NULL DEFAULT '0',
  `permissionUrl` varchar(64) DEFAULT NULL,
  `permissionHref` varchar(64) DEFAULT NULL,
  `id` int(8) NOT NULL AUTO_INCREMENT COMMENT '权限编码',
  `permissionName` varchar(50) DEFAULT NULL COMMENT '权限名称',
  `permissionLevel` int(8) DEFAULT NULL COMMENT '权限等级',
  `permissionDescription` varchar(50) DEFAULT NULL COMMENT '权限描述',
  `createTime` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `updateTime` timestamp NULL DEFAULT NULL COMMENT '更新时间',
  `parentId` int(8) DEFAULT '-1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

#    角色权限对应表
CREATE TABLE `t_ys_firuits_role_permission` (
  `id` int(8) NOT NULL AUTO_INCREMENT,
  `roleId` int(8) DEFAULT NULL COMMENT '角色编号',
  `permissionId` int(8) DEFAULT NULL COMMENT '权限编号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

