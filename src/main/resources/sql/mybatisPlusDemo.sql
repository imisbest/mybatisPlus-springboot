/*
SQLyog Community v13.1.6 (64 bit)
MySQL - 5.6.49-log : Database - mybatisPlusDemo
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE
DATABASE /*!32312 IF NOT EXISTS*/`mybatisPlusDemo` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE
`mybatisPlusDemo`;

/*Table structure for table `CollarLeash` */

DROP TABLE IF EXISTS `CollarLeash`;

CREATE TABLE `CollarLeash`
(
    `id`  varchar(32) NOT NULL DEFAULT '' COMMENT '狗链狗项圈',
    `cid` varchar(32)          DEFAULT NULL COMMENT '狗项圈id',
    `lid` varchar(32)          DEFAULT NULL COMMENT '狗链id',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `CollarLeash` */


/*Table structure for table `DogCollar` */

DROP TABLE IF EXISTS `DogCollar`;

CREATE TABLE `DogCollar`
(
    `id`    varchar(32) NOT NULL DEFAULT '' COMMENT '狗项圈',
    `modle` varchar(128)         DEFAULT NULL COMMENT '型号',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `DogCollar` */

/*Table structure for table `DogLeash` */

DROP TABLE IF EXISTS `DogLeash`;

CREATE TABLE `DogLeash`
(
    `id`      varchar(32) NOT NULL DEFAULT '' COMMENT 'uuid',
    `color`   varchar(64)          DEFAULT NULL COMMENT '颜色',
    `variety` varchar(64)          DEFAULT NULL COMMENT '品牌',
    `dogId`   varchar(32)          DEFAULT NULL COMMENT 'dog_id',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `DogLeash` */

/*Table structure for table `dog` */

DROP TABLE IF EXISTS `dog`;

CREATE TABLE `dog`
(
    `id`   varchar(32) NOT NULL DEFAULT '' COMMENT 'uuid',
    `name` varchar(64)          DEFAULT NULL COMMENT '姓名',
    `age`  int(2) DEFAULT NULL COMMENT '年龄',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `dog` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
