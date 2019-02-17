--
-- Table structure for table `estoque`
--

DROP TABLE IF EXISTS `estoque`;
CREATE TABLE `estoque` (
  `filme_id` bigint(20) NOT NULL,
  `locados` int(11) NOT NULL,
  `quantidade` int(11) NOT NULL,
  PRIMARY KEY (`filme_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Table structure for table `filme`
--

DROP TABLE IF EXISTS `filme`;
CREATE TABLE `filme` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `diretor` varchar(255) NOT NULL,
  `titulo` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Table structure for table `locacao`
--

DROP TABLE IF EXISTS `locacao`;
CREATE TABLE `locacao` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `data_devolucao` datetime DEFAULT NULL,
  `data_locacao` datetime NOT NULL,
  `previsao_devolucao` datetime NOT NULL,
  `filme_id` bigint(20) DEFAULT NULL,
  `usuario_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK4ilvguhqre01t27h32n44a0iy` (`filme_id`),
  KEY `FKkktfq622phc5otk6901ju9eqk` (`usuario_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
CREATE TABLE `usuario` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) NOT NULL,
  `nome` varchar(255) NOT NULL,
  `senha` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_5171l57faosmj8myawaucatdw` (`email`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;