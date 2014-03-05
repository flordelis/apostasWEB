



-- ---
-- Globals
-- ---

-- SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
-- SET FOREIGN_KEY_CHECKS=0;




-- ---
-- Table 'nacao'
-- 
-- ---

DROP TABLE IF EXISTS `nacao`;
		
CREATE TABLE `nacao` (
  `id` INTEGER NULL AUTO_INCREMENT DEFAULT NULL,
  `nome` VARCHAR(20) NULL DEFAULT NULL,
  `sigla` VARCHAR(3) NULL DEFAULT NULL,
  `grupo` CHAR(1) NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
);


-- ---
-- Table 'partida'
-- 
-- ---

DROP TABLE IF EXISTS `partida`;
		
CREATE TABLE `partida` (
  `id` INTEGER NOT NULL AUTO_INCREMENT,
  `id_nacao` INTEGER NOT NULL,
  `id_adversario` INTEGER NOT NULL,
  `data` DATE NOT NULL,
  `placar1` INTEGER NULL DEFAULT NULL,
  `placar2` INTEGER NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
);


-- ---
-- Table 'perfil'
-- 
-- ---

DROP TABLE IF EXISTS `perfil`;
		
CREATE TABLE `perfil` (
  `id` INTEGER NULL AUTO_INCREMENT DEFAULT NULL,
  `nome` VARCHAR NULL DEFAULT NULL,
  `id_usuario` INTEGER NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
);


-- ---
-- Table 'conta'
-- 
-- ---
DROP TABLE IF EXISTS `conta`;
		
CREATE TABLE `conta` (
  `id` INTEGER NOT NULL AUTO_INCREMENT,
  `credito` DOUBLE NULL DEFAULT 10.0,
  `datacriacao` DATE NOT NULL,
  PRIMARY KEY (`id`)
);


-- ---
-- Table 'usuario'
-- 
-- ---
DROP TABLE IF EXISTS `usuario`;
		
CREATE TABLE `usuario` (
  `id` INTEGER NOT NULL AUTO_INCREMENT,
  `login` VARCHAR(20) NOT NULL,
  `senha` VARCHAR(85) NOT NULL,
  `papel` INTEGER NOT NULL DEFAULT 'USERS',
  `id_conta` INTEGER NULL DEFAULT NULL,
  `id_perfil` INTEGER NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
);


-- ---
-- Table 'aposta'
-- 
-- ---

DROP TABLE IF EXISTS `aposta`;
		
CREATE TABLE `aposta` (
  `id` INTEGER NULL AUTO_INCREMENT DEFAULT NULL,
  `id_conta` INTEGER NULL DEFAULT NULL,
  `id_partida` INTEGER NULL DEFAULT NULL,
  `palpite1` INTEGER NULL DEFAULT NULL,
  `palpite2` INTEGER NULL DEFAULT NULL,
  `status` VARCHAR(8) NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
);


-- ---
-- Foreign Keys 
-- ---

ALTER TABLE `partida` ADD FOREIGN KEY (id_nacao) REFERENCES `nacao` (`id`);
ALTER TABLE `partida` ADD FOREIGN KEY (id_adversario) REFERENCES `nacao` (`id`);
ALTER TABLE `usuario` ADD FOREIGN KEY (id_conta) REFERENCES `conta` (`id`);
ALTER TABLE `usuario` ADD FOREIGN KEY (id_perfil) REFERENCES `perfil` (`id`);
ALTER TABLE `aposta` ADD FOREIGN KEY (id_conta) REFERENCES `conta` (`id`);
ALTER TABLE `aposta` ADD FOREIGN KEY (id_partida) REFERENCES `partida` (`id`);

-- ---
-- Table Properties
-- ---

-- ALTER TABLE `partida` ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
-- ALTER TABLE `usuario` ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
-- ALTER TABLE `conta` ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
-- ALTER TABLE `nacao` ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
-- ALTER TABLE `aposta` ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
-- ALTER TABLE `perfil` ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ---
-- Test Data
-- ---

-- INSERT INTO `partida` (`id`,`id_nacao`,`id_adversario`,`data`,`placar1`,`placar2`) VALUES
-- ('','','','','','');
-- INSERT INTO `usuario` (`id`,`login`,`senha`,`papel`,`id_conta`,`id_perfil`) VALUES
-- ('','','','','','');
-- INSERT INTO `conta` (`id`,`credito`,`data`,`id_usuario`) VALUES
-- ('','','','');
-- INSERT INTO `nacao` (`id`,`nome`,`sigla`,`grupo`) VALUES
-- ('','','','');
-- INSERT INTO `aposta` (`id`,`id_conta`,`id_partida`,`palpite1`,`palpite2`,`status`) VALUES
-- ('','','','','','');
-- INSERT INTO `perfil` (`id`,`nome`,`id_usuario`) VALUES
-- ('','','');

