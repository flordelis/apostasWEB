SET AUTOCOMMIT=0;
START TRANSACTION;


--
-- Banco de Dados: `bolaobd`
--
DROP DATABASE IF EXISTS `bolaobd`;
CREATE DATABASE `bolaobd` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE bolaobd;


-- --------------------------------------------------------

--
-- Estrutura da tabela `aposta`
--

CREATE TABLE IF NOT EXISTS `aposta` (
  `perfil_id` int(11) NOT NULL,
  `partida_id` int(11) NOT NULL,
  `palpite1` smallint(2) NOT NULL CHECK `palpite1` BETWEEN 1 AND 15,
  `palpite2` smallint(2) NOT NULL CHECK `palpite2` BETWEEN 1 AND 15,
  `status` varchar(8) DEFAULT NULL,
  `dataCriacao` date NOT NULL,
 PRIMARY KEY(`perfil_id`, `partida_id`)
);



INSERT INTO `aposta` (`perfil_id`, `partida_id`, `palpite1`, `palpite2`, `status`, `dataCriacao`) VALUES
(1, 54, 3, 2, NULL, '2014-03-06');





-- --------------------------------------------------------

--
-- Estrutura da tabela `aposta`
--

CREATE TABLE IF NOT EXISTS `aposta` (
  `perfil_id` int(11) NOT NULL,
  `partida_id` int(11) NOT NULL,
  `palpite1` smallint(2) NOT NULL CHECK `palpite1` BETWEEN 1 AND 15,
  `palpite2` smallint(2) NOT NULL CHECK `palpite2` BETWEEN 1 AND 15,
  `status` varchar(8) DEFAULT NULL,
  `dataCriacao` date NOT NULL,
  PRIMARY KEY (`perfil_id`, `partida_id`)
);


-- INSERT INTO `aposta` (`perfil_id`, `partida_id`, `palpite1`, `palpite2`, -- `status`, `dataCriacao`) VALUES
-- (2, 234, 3, 2, NULL, '2014-03-06');

-- --------------------------------------------------------

--
-- Estrutura da tabela `nacao`
--

CREATE TABLE IF NOT EXISTS `nacao` (
  `id` smallint(6) NOT NULL AUTO_INCREMENT,
  `nome` varchar(20) NOT NULL,
  `grupo` char(1) NOT NULL,
  PRIMARY KEY (`id`)
);

--
-- Extraindo dados da tabela `nacao`
--

INSERT INTO `nacao` (`id`, `nome`, `grupo`) VALUES
(1, 'Brasil', 'A'),
(2, 'Croácia', 'A'),
(3, 'México', 'A'),
(4, 'Camarões', 'A'),
(5, 'Espanha', 'B'),
(6, 'Holanda', 'B'),
(7, 'Chile', 'B'),
(8, 'Austrália', 'B'),
(9, 'Colômbia', 'C'),
(10, 'Grécia', 'C'),
(11, 'Costa do Marfim', 'C'),
(12, 'Japão', 'C'),
(13, 'Uruguai', 'D'),
(14, 'Costa Rica', 'D'),
(15, 'Inglaterra', 'D'),
(16, 'Itália', 'D'),
(17, 'Suíça', 'E'),
(18, 'Equador', 'E'),
(19, 'França', 'E'),
(20, 'Honduras', 'E'),
(21, 'Argentina', 'F'),
(22, 'Bosnia-Herzegovina', 'F'),
(23, 'Irã', 'F'),
(24, 'Nigéria', 'F'),
(25, 'Alemanha', 'G'),
(26, 'Portugal', 'G'),
(27, 'Gana', 'G'),
(28, 'Estados Unidos', 'G'),
(29, 'Bélgica', 'H'),
(30, 'Argélia', 'H'),
(31, 'Rússia', 'H'),
(32, 'Coreia do Sul', 'H');

REATE TABLE IF NOT EXISTS `partida` (
  `id` int(23) NOT NULL AUTO_INCREMENT,
  `fase` char(2) NOT NULL,
  `data` date NOT NULL,
  `horario` time NOT NULL,
  `sede_id` smallint(6) NOT NULL,
  `nacao_id` smallint(6) NOT NULL,
  `nacao_id1` smallint(6) NOT NULL,
  `placar1` smallint(2) DEFAULT NULL CHECK `palpite` BETWEEN 1 AND 15,
  `placar2` smallint(2) DEFAULT NULL CHECK `palpite` BETWEEN 1 AND 15,
  PRIMARY KEY (`id`)
);


--

INSERT INTO `partida` (`id`, `fase`, `data`, `horario`, `sede_id`, `nacao_id`, `nacao_id1`, `placar1`, `placar2`) VALUES
(50, 'GR', '2014-06-12', '17:00:00', 12, 1, 2, NULL, NULL),
(51, 'GR', '2014-06-17', '16:00:00', 4, 1, 3, NULL, NULL),
(52, 'GR', '2014-06-23', '17:00:00', 2, 4, 1, NULL, NULL),
(53, 'GR', '2014-06-13', '13:00:00', 6, 3, 4, NULL, NULL),
(54, 'GR', '2014-06-18', '18:00:00', 5, 4, 2, NULL, NULL),
(55, 'GR', '2014-06-23', '17:00:00', 8, 2, 3, NULL, NULL),
(56, 'GR', '2014-06-13', '16:00:00', 10, 5, 6, NULL, NULL),
(57, 'GR', '2014-06-18', '16:00:00', 9, 5, 7, NULL, NULL),
(58, 'GR', '2014-06-23', '13:00:00', 11, 8, 5, NULL, NULL),
(59, 'GR', '2014-06-13', '18:00:00', 3, 7, 8, NULL, NULL),
(60, 'GR', '2014-06-18', '13:00:00', 7, 8, 6, NULL, NULL),
(61, 'GR', '2014-06-23', '13:00:00', 12, 6, 7, NULL, NULL),
(62, 'GR', '2014-06-14', '13:00:00', 1, 9, 10, NULL, NULL),
(63, 'GR', '2014-06-19', '13:00:00', 2, 9, 11, NULL, NULL),
(64, 'GR', '2014-06-24', '16:00:00', 3, 12, 9, NULL, NULL),
(65, 'GR', '2014-06-14', '22:00:00', 8, 11, 12, NULL, NULL),
(66, 'GR', '2014-06-19', '19:00:00', 6, 12, 10, NULL, NULL),
(67, 'GR', '2014-06-24', '17:00:00', 4, 10, 11, NULL, NULL),
(68, 'GR', '2014-06-14', '16:00:00', 4, 13, 14, NULL, NULL),
(69, 'GR', '2014-06-19', '16:00:00', 12, 13, 15, NULL, NULL),
(70, 'GR', '2014-06-24', '13:00:00', 6, 16, 13, NULL, NULL),
(71, 'GR', '2014-06-14', '18:00:00', 5, 15, 16, NULL, NULL),
(72, 'GR', '2014-06-20', '13:00:00', 8, 16, 14, NULL, NULL),
(73, 'GR', '2014-06-24', '13:00:00', 1, 14, 15, NULL, NULL),
(74, 'GR', '2014-06-15', '13:00:00', 2, 17, 18, NULL, NULL),
(75, 'GR', '2014-06-20', '16:00:00', 10, 17, 19, NULL, NULL),
(76, 'GR', '2014-06-25', '16:00:00', 5, 20, 17, NULL, NULL),
(77, 'GR', '2014-06-15', '16:00:00', 7, 19, 20, NULL, NULL),
(78, 'GR', '2014-06-20', '19:00:00', 11, 20, 18, NULL, NULL),
(79, 'GR', '2014-06-25', '17:00:00', 9, 18, 19, NULL, NULL),
(80, 'GR', '2014-06-15', '19:00:00', 1, 21, 22, NULL, NULL),
(81, 'GR', '2014-06-21', '13:00:00', 9, 21, 23, NULL, NULL),
(82, 'GR', '2014-06-25', '13:00:00', 12, 24, 21, NULL, NULL),
(83, 'GR', '2014-06-16', '16:00:00', 3, 23, 24, NULL, NULL),
(84, 'GR', '2014-06-21', '18:00:00', 7, 24, 22, NULL, NULL),
(85, 'GR', '2014-06-25', '13:00:00', 11, 22, 23, NULL, NULL),
(86, 'GR', '2014-06-16', '13:00:00', 10, 25, 26, NULL, NULL),
(87, 'GR', '2014-06-21', '16:00:00', 4, 25, 27, NULL, NULL),
(88, 'GR', '2014-06-26', '13:00:00', 8, 28, 25, NULL, NULL),
(89, 'GR', '2014-06-16', '19:00:00', 6, 27, 28, NULL, NULL),
(90, 'GR', '2014-06-22', '18:00:00', 5, 28, 26, NULL, NULL),
(91, 'GR', '2014-06-26', '13:00:00', 2, 26, 27, NULL, NULL),
(92, 'GR', '2014-06-17', '13:00:00', 1, 29, 30, NULL, NULL),
(93, 'GR', '2014-06-22', '13:00:00', 9, 29, 31, NULL, NULL),
(94, 'GR', '2014-06-26', '17:00:00', 12, 32, 29, NULL, NULL),
(95, 'GR', '2014-06-17', '18:00:00', 3, 31, 32, NULL, NULL),
(96, 'GR', '2014-06-22', '16:00:00', 7, 32, 30, NULL, NULL),
(97, 'GR', '2014-06-26', '17:00:00', 11, 30, 31, NULL, NULL);

-- --------------------------------------------------------

--
-- Estrutura da tabela `perfil`
--

CREATE TABLE IF NOT EXISTS `perfil` (
  `id` int(23) NOT NULL AUTO_INCREMENT,
  `usuario_id` int(11) NOT NULL,
  `nome` varchar(40) NOT NULL,
  `ativo` tinyint(1) NOT NULL,
  `credito` double NOT NULL DEFAULT '10',
  `datacriacao` date NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `usuario_id` (`usuario_id`)
);



INSERT INTO `perfil` (`id`, `usuario_id`, `nome`, `ativo`, `credito`, `datacriacao`) VALUES
(1, 0, 'jef', 0, 10, '2014-03-03');

-- --------------------------------------------------------

--
-- Estrutura da tabela `sede`
--

CREATE TABLE IF NOT EXISTS `sede` (
  `id` smallint(6) NOT NULL AUTO_INCREMENT,
  `nome` varchar(15) NOT NULL,
  PRIMARY KEY (`id`)
);

--
-- Extraindo dados da tabela `sede`
--

INSERT INTO `sede` (`id`, `nome`) VALUES
(1, 'Belo Horizonte'),
(2, 'Brasília'),
(3, 'Cuiabá'),
(4, 'Fortaleza'),
(5, 'Manaus'),
(6, 'Natal'),
(7, 'Porto Alegre'),
(8, 'Recife'),
(9, 'Rio de Janeiro'),
(10, 'Salvador'),
(11, 'Curitiba'),
(12, 'São Paulo');

-- --------------------------------------------------------


-- ---
-- Table "partida"
-- 
-- ---

		
CREATE TABLE "partida" (
  "id" INTEGER NOT NULL AUTO_INCREMENTO,
  "fase" CHAR(2) NOT NULL,
  "sede_id" SMALLINT NOT NULL,
  "data" DATE NOT NULL,
  "horario" TIME NOT NULL,
  "nacaoid" SMALLINT NOT NULL ,
  "nacaoid1" SMALLINT NOT NULl,
  "placar1" SMALLINT DEFAULT NULL,
  "placar2" SMALLINT DEFAULT NULL,
  PRIMARY KEY ("id")
);

-- ---
-- Table "usuario"
-- 
-- ---
--DROP TABLE /*IF EXISTS*/ "usuario";
		
CREATE TABLE "usuario" (
  "id" INTEGER NOT NULL AUTO_INCREMENTO,
  "login" VARCHAR(50) NOT NULL,
  "senha" VARCHAR(85) NOT NULL,
  "papel" VARCHAR(45) NOT NULL,
  PRIMARY KEY ("id")
);

-- Table "perfil"
-- 
-- ---

--DROP TABLE /*IF EXISTS*/ "perfil";
		
CREATE TABLE "perfil" (
  "id" INTEGER NOT NULL  AUTO_INCREMENTO,
  "usuario_id" INTEGER NOT NULL,
  "nome" VARCHAR(40)  NOT NULL,
  "credito" DOUBLE NOT NULL DEFAULT 10,
  "dt_cadastro" DATE NOT NULL,
  "num_acerto" INTEGER DEFAULT NULL,
  PRIMARY KEY ("id")
 );






-- ---
-- Table "aposta"
-- 
		
CREATE TABLE "aposta" (
  "id" INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY,
  --"id_conta" INTEGER DEFAULT NULL,
  "id_perfil" INTEGER NOT NULL,
  "id_partida" INTEGER NOT NULL,
  "palpite1" INTEGER NOT NULL,
  "palpite2" INTEGER NOT NULL,
  "status" VARCHAR(8) NOT NULL,
   "data" DATE DEFAULT CURRENT_DATE,
  PRIMARY KEY ("id")
);



