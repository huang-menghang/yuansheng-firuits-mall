
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


#    角色表
DROP TABLE IF EXISTS `t_ys_firuits_roles`;
CREATE TABLE `t_ys_firuits_roles` (
  `id` int(8) NOT NULL AUTO_INCREMENT COMMENT '角色编号',
  `roleName` varchar(20) DEFAULT NULL COMMENT '角色名称',
  `roleDescription` varchar(200) DEFAULT NULL COMMENT '角色描述',
  `createTime` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `updateTime` timestamp NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 CHECKSUM=1;


#    权限表
DROP TABLE IF EXISTS `t_ys_firuits_permission`;
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#    角色权限对应表
DROP TABLE IF EXISTS `t_ys_firuits_role_permission`;
CREATE TABLE `t_ys_firuits_role_permission` (
  `id` int(8) NOT NULL AUTO_INCREMENT,
  `roleId` int(8) DEFAULT NULL COMMENT '角色编号',
  `permissionId` int(8) DEFAULT NULL COMMENT '权限编号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#    品牌列表
DROP TABLE IF EXISTS `t_ys_firuits_brand`;
CREATE TABLE `t_ys_firuits_brand` (
  `id` int(16) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) DEFAULT NULL COMMENT '品牌名称',
  `description` varchar(120) DEFAULT NULL COMMENT '品牌描述',
  `createTime` timestamp NULL DEFAULT NULL,
  `updateTime` timestamp NULL DEFAULT NULL,
  `status` tinyint(1) NOT NULL DEFAULT '0' COMMENT '品牌状态(0,上架 1,下架)',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#    商品列表
DROP TABLE IF EXISTS `t_ys_firuits_goods`;
CREATE TABLE `t_ys_firuits_goods` (
  `id` int(16) NOT NULL AUTO_INCREMENT COMMENT '产品id',
  `name` varchar(64) DEFAULT NULL COMMENT '分类名称',
  `price` decimal(8,2) DEFAULT NULL COMMENT '产品价格',
  `discoutPrice` decimal(8,2) DEFAULT NULL COMMENT '产品价格',
  `packet` int(1) DEFAULT NULL COMMENT '包装类型',
  `standrds` varchar(32) DEFAULT NULL COMMENT '规格',
  `weight` double(8,2) DEFAULT NULL COMMENT '重量',
  `storage` double(8,2) DEFAULT NULL COMMENT '保质期',
  `sort` tinyint(1) DEFAULT NULL COMMENT '排序',
  `sales` int(16) DEFAULT '0' COMMENT '销量',
  `description` varchar(128) DEFAULT NULL COMMENT '描述',
  `brandId` int(16) NOT NULL COMMENT '对应品牌id',
  `status` tinyint(1) DEFAULT '0' COMMENT '0 表示上架，1 表示下架',
  `launcTime` timestamp NULL DEFAULT NULL COMMENT '创健日期',
  `imagePath` varchar(64) DEFAULT NULL COMMENT '路径',
  `createTime` timestamp NULL DEFAULT NULL COMMENT '创健日期',
  `updateTime` timestamp NULL DEFAULT NULL COMMENT '修改日期',
  `categoryId` int(16) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#    系统日志
DROP TABLE IF EXISTS `t_ys_firuits_systemaccesslog`;
CREATE TABLE `t_ys_firuits_systemaccesslog` (
  `id` int(255) NOT NULL AUTO_INCREMENT,
  `location` varchar(255) NOT NULL,
  `date` varchar(255) NOT NULL,
  `logger` varchar(255) NOT NULL,
  `level` varchar(20) NOT NULL,
  `message` varchar(2000) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;


#    错误日志
DROP TABLE IF EXISTS `t_ys_systemerrorlog`;
CREATE TABLE `t_ys_systemerrorlog` (
  `id` int(32) NOT NULL AUTO_INCREMENT,
  `ip` varchar(32) NOT NULL,
  `osAndbroswer` varchar(256) NOT NULL,
  `requestUrl` varchar(64) NOT NULL,
  `requestMethod` varchar(16) NOT NULL,
  `requestParmater` varchar(1024) NOT NULL,
  `exceptionMessage` varchar(1024) NOT NULL,
  `createTime` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `updateTime` timestamp NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
