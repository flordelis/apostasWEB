--DROP TABLE /*IF EXISTS*/ "aposta";
--DROP TABLE /*IF EXISTS*/ "partida";
--DROP TABLE /*IF EXISTS*/ "perfil";
--DROP TABLE --IF EXISTS-- "conta";
--DROP TABLE /*IF EXISTS*/ "usuario";
--DROP TABLE /*IF EXISTS*/ "nacao";
--DROP TABLE /*IF EXISTS*/ "sede";



-- tabela "nacao"

		
CREATE TABLE "nacao" (
  "id" SMALLINT GENERATED ALWAYS AS IDENTITY,
  "nome" VARCHAR(20) NOT NULL,
  --"sigla" VARCHAR(3) NOT NULL,
  "grupo" CHAR(1) NOT NULL,
  PRIMARY KEY ("id")
);
-- ---
-- Table "sede"
--
-- ---

CREATE TABLE "sede"(
 "id" SMALLINT GENERATED ALWAYS AS IDENTITY,
 "nome" VARCHAR(15) NOT NULL,
PRIMARY KEY("id")
);


-- ---
-- Table "partida"
-- 
-- ---

		
CREATE TABLE "partida" (
  "id" INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY,
  "fase" CHAR(2) NOT NULL,
  "id_sede" SMALLINT NOT NULL,
  "data_horario" TIMESTAMP NOT NULL,
  "id_nacao" SMALLINT NOT NULL ,
  "id_adversaria" SMALLINT NOT NULl,
  "placar1" INTEGER DEFAULT NULL,
  "placar2" INTEGER DEFAULT NULL,
  PRIMARY KEY ("id")
);

-- ---
-- Table "usuario"
-- 
-- ---
--DROP TABLE /*IF EXISTS*/ "usuario";
		
CREATE TABLE "usuario" (
  "id" INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY,
  "login" VARCHAR(50) NOT NULL,
  "senha" VARCHAR(85) NOT NULL,
  "papel" CHAR(1) NOT NULL DEFAULT 'U',
  --"id_conta" INTEGER  DEFAULT NULL,
  "id_perfil" INTEGER UNIQUE DEFAULT NULL,
  PRIMARY KEY ("id")
);

-- Table "perfil"
-- 
-- ---

--DROP TABLE /*IF EXISTS*/ "perfil";
		
CREATE TABLE "perfil" (
  "id" INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY,
  --"id_user" INTEGER NOT NULL,
  "nome" VARCHAR(40)  NOT NULL,
  "credito" DOUBLE NOT NULL DEFAULT 10,
  "datacriacao" DATE NOT NULL DEFAULT CURRENT_DATE,
  --"num_acerto" INTEGER DEFAULT NULL,
  PRIMARY KEY ("id")
 );


-- ---
-- Table "conta"
-- 
	
--CREATE TABLE "conta" (
  --"id" INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY,
  --"credito" DOUBLE DEFAULT 10.0,
  --"datacriacao" DATE NOT NULL,
  --PRIMARY KEY ("id")
----);




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


-- ---
-- Foreign Keys 
-- ---

ALTER TABLE "partida" ADD FOREIGN KEY ("id_nacao") REFERENCES "nacao" ("id");
ALTER TABLE "partida" ADD FOREIGN KEY ("id_adversaria") REFERENCES "nacao" ("id");
ALTER TABLE "partida" ADD FOREIGN KEY ("id_sede") REFERENCES "sede" ("id");
--ALTER TABLE "usuario" ADD FOREIGN KEY (id_conta) REFERENCES "conta" ("id");
ALTER TABLE "usuario" ADD FOREIGN KEY ("id_perfil") REFERENCES "perfil" ("id");
ALTER TABLE "aposta" ADD FOREIGN KEY ("id_perfil") REFERENCES "perfil" ("id");
ALTER TABLE "aposta" ADD FOREIGN KEY ("id_partida") REFERENCES "partida" ("id");
