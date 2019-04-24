
CREATE TABLE `location` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `expected_date` varchar(255) NOT NULL,
  `finish_date` varchar(255) DEFAULT NULL,
  `start_date` varchar(255) NOT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKeua4vn06qu0iq9d32qnmuhqkl` (`user_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;



CREATE TABLE `movie` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `director` varchar(255) NOT NULL,
  `stock` int(11) NOT NULL,
  `title` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;



CREATE TABLE `movie_location` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `quant` int(11) NOT NULL,
  `location_id` bigint(20) DEFAULT NULL,
  `movie_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK4q8njsgcd4ok1kqfn4w5fxd5k` (`location_id`),
  KEY `FKj7f58e3qo24ld56f7n7h1nm16` (`movie_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;



CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `pass` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_ob8kqyqqgmefl0aco34akdtpe` (`email`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;