CREATE TABLE `t_ys_firuits_mall_member` (
  `id` int(16) NOT NULL AUTO_INCREMENT,
  `name` varchar(16) NOT NULL,
  `mobile` varchar(11) NOT NULL COMMENT '手机号码',
  `password` varchar(64) NOT NULL,
  `restaurant` varchar(32) DEFAULT NULL,
  `telephone` varchar(13) NOT NULL,
  `province` varchar(8) NOT NULL,
  `city` varchar(8) NOT NULL,
  `detailAddress` varchar(32) NOT NULL,
  `createTime` timestamp NULL DEFAULT NULL,
  `updateTime` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

CREATE TABLE `t_ys_firuits_scroll_image` (
  `id` int(16) NOT NULL AUTO_INCREMENT,
  `name` varchar(16) NOT NULL,
  `imageHref` varchar(32) NOT NULL COMMENT '图片地址',
  `imageUrl` varchar(32) NOT NULL COMMENT '跳转地址',
  `sort` tinyint(1) NOT NULL ,
  `description` varchar(64),
  `createTime` timestamp NULL DEFAULT NULL,
  `updateTime` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `t_ys_firuits_category`;
CREATE TABLE `t_ys_firuits_category` (
  `id` int(16) NOT NULL AUTO_INCREMENT COMMENT '分类id',
  `name` varchar(64) DEFAULT NULL COMMENT '分类名称' ,
  `remark` varchar(100) DEFAULT NULL COMMENT '备注',
  `description` varchar(64),
  `sort` tinyint(1) COMMENT '排序',
  `imagePath` varchar(64) DEFAULT NULL COMMENT '路径',
  `createTime` timestamp null DEFAULT NULL COMMENT '创健日期',
  `updateTime` timestamp null DEFAULT NULL COMMENT '修改日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

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
  `sales` int(16) DEFAULT NULL COMMENT '销量',
  `description` varchar(128) DEFAULT NULL COMMENT '描述',
  `brandId` int(11) NOT NULL COMMENT '对应品牌id',
  `launcTime` timestamp NULL DEFAULT NULL COMMENT '创健日期',
  `imagePath` varchar(64) DEFAULT NULL COMMENT '路径',
  `createTime` timestamp NULL DEFAULT NULL COMMENT '创健日期',
  `updateTime` timestamp NULL DEFAULT NULL COMMENT '修改日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `t_ys_firuits_brand`;
CREATE TABLE `t_ys_firuits_brand` (
  `id` int(16) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) DEFAULT NULL,
  `description` varchar(64) DEFAULT NULL,
  `createTime` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `updateTime` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `t_ys_firuits_cart`;
CREATE TABLE `t_ys_firuits_cart` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '购物车id', 
  `memberId` int(11) NOT NULL COMMENT '用户id',
  `totalItemCount` int(3) NOT NULL COMMENT '总的条目数',
  `totalItemNo` int(3) NOT NULL COMMENT '总的产品数',
  `totalPrice` decimal(8,2) NOT NULL COMMENT '商品总价',
  `createTime` timestamp NULL DEFAULT NULL COMMENT '创健日期',
  `updateTime` timestamp NULL DEFAULT NULL COMMENT '修改日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `t_ys_firuits_cart_item`;
CREATE TABLE `t_ys_firuits_cart_item` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '购物车条目id', 
  `cartId` int(11) NOT NULL COMMENT '用户id',
  `goodsId` int(11) NULL COMMENT '商品id',
  `goodsPrice` double(8,2)  NOT NULL COMMENT '商品价格',
  `goodsCount` int(3) default 0 NOT NULL COMMENT '商品数目',
  `createTime` timestamp NULL DEFAULT NULL COMMENT '创健日期',
  `updateTime` timestamp NULL DEFAULT NULL COMMENT '修改日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `t_ys_firuits_member_fav`;
CREATE TABLE `t_ys_firuits_member_fav` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '购物车条目id', 
  `goodsId` int(11) NULL COMMENT '商品id',
  `memberId` int(11) NULL COMMENT '用户id',
  `status` tinyint(1) NOT NULL DEFAULT '0' COMMENT '0表示未清空,1表示清空',
  `createTime` timestamp NULL DEFAULT NULL COMMENT '创健日期',
  `updateTime` timestamp NULL DEFAULT NULL COMMENT '修改日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
