USE module4_http;

CREATE TABLE IF NOT EXISTS `manufacturers` (
  `id` binary(16) NOT NULL,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `products` (
  `id` binary(16) NOT NULL,
  `name` varchar(255) NOT NULL,
  `price` decimal(13,2) NOT NULL,
  `manufacturer_id` binary(16) NOT NULL,
  CONSTRAINT fk_manufacturer FOREIGN KEY (manufacturer_id) REFERENCES manufacturers(id),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;