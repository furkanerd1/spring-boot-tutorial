DROP SCHEMA IF EXISTS `hb-01-one-to-one-uni`;

CREATE SCHEMA `hb-01-one-to-one-uni`;

USE `hb-01-one-to-one-uni`;

SET FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS `instructor_detail`;
CREATE TABLE `instructor_detail` (
                                     `id` INT NOT NULL AUTO_INCREMENT,
                                     `youtube_channel` VARCHAR(128) DEFAULT NULL,
                                     `hobby` VARCHAR(45) DEFAULT NULL,
                                     PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `instructor`;
CREATE TABLE `instructor` (
                              `id` INT NOT NULL AUTO_INCREMENT,
                              `first_name` VARCHAR(45) DEFAULT NULL,
                              `last_name` VARCHAR(45) DEFAULT NULL,
                              `email` VARCHAR(45) DEFAULT NULL,
                              `instructor_detail_id` INT DEFAULT NULL,
                              PRIMARY KEY (`id`),
                              KEY `FK_DETAIL_idx` (`instructor_detail_id`),
                              CONSTRAINT `FK_DETAIL` FOREIGN KEY (`instructor_detail_id`)
                                  REFERENCES `instructor_detail`(`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

SET FOREIGN_KEY_CHECKS = 1;
