
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
