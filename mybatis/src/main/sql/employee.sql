CREATE TABLE `employee`
(
    `id`        int(10) unsigned NOT NULL AUTO_INCREMENT,
    `user_name` varchar(32) DEFAULT '',
    `age`       int(10)     DEFAULT '0',
    `sex`       int(2)      DEFAULT '0',
    `birthday`  date        DEFAULT NULL,
    `created`   datetime    DEFAULT NULL,
    `updated`   datetime    DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 0
  DEFAULT CHARSET = utf8