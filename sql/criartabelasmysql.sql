
		
CREATE TABLE nacao (
  id SMALLINT AUTO_INCREMENT,
  nome VARCHAR(20) NOT NULL,
  grupo CHAR(1) NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE sede(
 id SMALLINT AUTO_INCREMENT,
 nome VARCHAR(15) NOT NULL,
PRIMARY KEY(id)
);

		
CREATE TABLE partida (
  id INTEGER NOT NULL AUTO_INCREMENT,
  fase CHAR(2) NOT NULL,
  id_sede SMALLINT NOT NULL,
  data_realizacao DATE NOT NULL,
  horario TIME NOT NULL,
  id_nacao SMALLINT NOT NULL ,
  id_adversaria SMALLINT NOT NULl,
  placar1 INTEGER DEFAULT NULL,
  placar2 INTEGER DEFAULT NULL,
  PRIMARY KEY (id)
);

		
CREATE TABLE usuario (
  id INTEGER NOT NULL AUTO_INCREMENT,
  login VARCHAR(50) NOT NULL,
  senha VARCHAR(85) NOT NULL,
  papel CHAR(1) NOT NULL DEFAULT 'U',
  id_perfil INTEGER UNIQUE DEFAULT NULL,
  PRIMARY KEY (id)
);


CREATE TABLE perfil (
  id INTEGER NOT NULL AUTO_INCREMENT,
  nome VARCHAR(40)  NOT NULL,
  credito DOUBLE NOT NULL DEFAULT 10,
  datacriacao DATE NOT NULL DEFAULT CURRENT_DATE,
  PRIMARY KEY (id)
 );


CREATE TABLE aposta (
  id INTEGER NOT NULL AUTO_INCREMENT,
  id_perfil INTEGER NOT NULL,
  id_partida INTEGER NOT NULL,
  palpite1 INTEGER NOT NULL,
  palpite2 INTEGER NOT NULL,
  status VARCHAR(8) NULL,
  data_criacao DATE NOT NULL,
  PRIMARY KEY (id)
);



ALTER TABLE partida ADD FOREIGN KEY (id_nacao) REFERENCES nacao (id);
ALTER TABLE partida ADD FOREIGN KEY (id_adversaria) REFERENCES nacao (id);
ALTER TABLE partida ADD FOREIGN KEY (id_sede) REFERENCES sede (id);
ALTER TABLE usuario ADD FOREIGN KEY (id_perfil) REFERENCES perfil (id);
ALTER TABLE aposta ADD FOREIGN KEY (id_perfil) REFERENCES perfil (id);
ALTER TABLE aposta ADD FOREIGN KEY (id_partida) REFERENCES partida (id);
