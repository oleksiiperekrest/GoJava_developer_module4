USE module4_http;

CREATE TABLE IF NOT EXISTS `manufacturers` (
  `id`   BINARY(16)   NOT NULL,
  `name` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

CREATE TABLE `products` (
  `id`              BINARY(16)     NOT NULL,
  `name`            VARCHAR(255)   NOT NULL,
  `price`           DECIMAL(13, 2) NOT NULL,
  `manufacturer_id` BINARY(16)     NOT NULL,
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;