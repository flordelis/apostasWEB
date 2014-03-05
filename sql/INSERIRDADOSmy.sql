 #Preenchendo a tabela nacoes---
 #-
  
  INSERT INTO `nacao` (`nome`,`grupo`) VALUES  ('Brasil','A');
  INSERT INTO `nacao` (`nome`,`grupo`) VALUES  ('Croácia','A');
  INSERT INTO `nacao` (`nome`,`grupo`) VALUES  ('México','A');
  INSERT INTO `nacao` (`nome`,`grupo`) VALUES  ('Camaroes','A');
  INSERT INTO `nacao` (`nome`,`grupo`) VALUES  ('Espanha','B');
  INSERT INTO `nacao` (`nome`,`grupo`) VALUES  ('Holanda','B');
  INSERT INTO `nacao` (`nome`,`grupo`) VALUES  ('Chile','B');
  INSERT INTO `nacao` (`nome`,`grupo`) VALUES  ('Austrália','B');
  INSERT INTO `nacao` (`nome`,`grupo`) VALUES  ('Colômbia','C');
  INSERT INTO `nacao` (`nome`,`grupo`) VALUES  ('Grécia','C');
  INSERT INTO `nacao` (`nome`,`grupo`) VALUES  ('Costa do Marfim','C');
  INSERT INTO `nacao` (`nome`,`grupo`) VALUES  ('Japão','C');
  INSERT INTO `nacao` (`nome`,`grupo`) VALUES  ('Uruguai','D');
  INSERT INTO `nacao` (`nome`,`grupo`) VALUES  ('Costa Rica','D');
  INSERT INTO `nacao` (`nome`,`grupo`) VALUES  ('Inglaterra','D');
  INSERT INTO `nacao` (`nome`,`grupo`) VALUES  ('Itália','D');
  INSERT INTO `nacao` (`nome`,`grupo`) VALUES  ('Suíça','E');
  INSERT INTO `nacao` (`nome`,`grupo`) VALUES  ('Equador','E');
  INSERT INTO `nacao` (`nome`,`grupo`) VALUES  ('França','E');
  INSERT INTO `nacao` (`nome`,`grupo`) VALUES  ('Honduras','E');
  INSERT INTO `nacao` (`nome`,`grupo`) VALUES  ('Argentina','F');
  INSERT INTO `nacao` (`nome`,`grupo`) VALUES  ('Bosnia-Herzegovina','F');
  INSERT INTO `nacao` (`nome`,`grupo`) VALUES  ('Irã','F');
  INSERT INTO `nacao` (`nome`,`grupo`) VALUES  ('Nigéria','F');
  INSERT INTO `nacao` (`nome`,`grupo`) VALUES  ('Alemanha','G');
  INSERT INTO `nacao` (`nome`,`grupo`) VALUES  ('Portugal','G');
  INSERT INTO `nacao` (`nome`,`grupo`) VALUES  ('Gana','G');
  INSERT INTO `nacao` (`nome`,`grupo`) VALUES  ('Estados Unidos','G');
  INSERT INTO `nacao` (`nome`,`grupo`) VALUES  ('Bélgica','H');
  INSERT INTO `nacao` (`nome`,`grupo`) VALUES  ('Argélia','H');
  INSERT INTO `nacao` (`nome`,`grupo`) VALUES  ('Rússia','H');
  INSERT INTO `nacao` (`nome`,`grupo`) VALUES  ('Coreia do Sul','H');



 #Preenchendo a tabela sede---
 #-
 
 INSERT INTO `sede` (`nome`) VALUES ('Belo Horizonte');
 INSERT INTO `sede` (`nome`) VALUES ('Brasília');
 INSERT INTO `sede` (`nome`) VALUES ('Cuiabá');
 INSERT INTO `sede` (`nome`) VALUES ('Fortaleza');
 INSERT INTO `sede` (`nome`) VALUES ('Manaus');
 INSERT INTO `sede` (`nome`) VALUES ('Natal');
 INSERT INTO `sede` (`nome`) VALUES ('Porto Alegre');
 INSERT INTO `sede` (`nome`) VALUES ('Recife');
 INSERT INTO `sede` (`nome`) VALUES ('Rio de Janeiro');
 INSERT INTO `sede` (`nome`) VALUES ('Salvador');
 INSERT INTO `sede` (`nome`) VALUES ('Curitiba');
 INSERT INTO `sede` (`nome`) VALUES ('São Paulo');
 
 
#
 #Preenchendo a tabela partidas---
 #-
  
# Fase Grupo -GR-
#-
#Grupo A
 INSERT INTO `partida` (`fase`,`sede_id`,`nacao_id`,`nacao_id1`,`data`) VALUES
 ('GR','12','1','2','2014-06-12 17:00:00');
 INSERT INTO `partida` (`fase`,`sede_id`,`nacao_id`,`nacao_id1`,`data`) VALUES
 ('GR','4','1','3','2014-06-17 16:00:00');
 INSERT INTO `partida` (`fase`,`sede_id`,`nacao_id`,`nacao_id1`,`data`) VALUES
 ('GR','2','4','1','2014-06-23 17:00:00');
 INSERT INTO `partida` (`fase`,`sede_id`,`nacao_id`,`nacao_id1`,`data`) VALUES
 ('GR','6','3','4','2014-06-13 13:00:00');
 INSERT INTO `partida` (`fase`,`sede_id`,`nacao_id`,`nacao_id1`,`data`) VALUES
 ('GR','5','4','2','2014-06-18 18:00:00');
 INSERT INTO `partida` (`fase`,`sede_id`,`nacao_id`,`nacao_id1`,`data`) VALUES
 ('GR','8','2','3','2014-06-23 17:00:00');
#-
#Grupo B
 INSERT INTO `partida` (`fase`,`sede_id`,`nacao_id`,`nacao_id1`,`data`) VALUES
 ('GR','10','5','6','2014-06-13 16:00:00');
 INSERT INTO `partida` (`fase`,`sede_id`,`nacao_id`,`nacao_id1`,`data`) VALUES
 ('GR','9','5','7','2014-06-18 16:00:00');
 INSERT INTO `partida` (`fase`,`sede_id`,`nacao_id`,`nacao_id1`,`data`) VALUES
 ('GR','11','8','5','2014-06-23 13:00:00');
 INSERT INTO `partida` (`fase`,`sede_id`,`nacao_id`,`nacao_id1`,`data`) VALUES
 ('GR','3','7','8','2014-06-13 18:00:00');
 INSERT INTO `partida` (`fase`,`sede_id`,`nacao_id`,`nacao_id1`,`data`) VALUES
 ('GR','7','8','6','2014-06-18 13:00:00');
 INSERT INTO `partida` (`fase`,`sede_id`,`nacao_id`,`nacao_id1`,`data`) VALUES
 ('GR','12','6','7','2014-06-23 13:00:00');
#-
#Grupo C
 INSERT INTO `partida` (`fase`,`sede_id`,`nacao_id`,`nacao_id1`,`data`) VALUES
 ('GR','1','9','10','2014-06-14 13:00:00');
 INSERT INTO `partida` (`fase`,`sede_id`,`nacao_id`,`nacao_id1`,`data`) VALUES
 ('GR','2','9','11','2014-06-19 13:00:00');
 INSERT INTO `partida` (`fase`,`sede_id`,`nacao_id`,`nacao_id1`,`data`) VALUES
 ('GR','3','12','9','2014-06-24 16:00:00');
 INSERT INTO `partida` (`fase`,`sede_id`,`nacao_id`,`nacao_id1`,`data`) VALUES
 ('GR','8','11','12','2014-06-14 22:00:00');
 INSERT INTO `partida` (`fase`,`sede_id`,`nacao_id`,`nacao_id1`,`data`) VALUES
 ('GR','6','12','10','2014-06-19 19:00:00');
 INSERT INTO `partida` (`fase`,`sede_id`,`nacao_id`,`nacao_id1`,`data`) VALUES
 ('GR','4','10','11','2014-06-24 17:00:00');
#-
#Grupo D
 INSERT INTO `partida` (`fase`,`sede_id`,`nacao_id`,`nacao_id1`,`data`) VALUES
 ('GR','4','13','14','2014-06-14 16:00:00');
 INSERT INTO `partida` (`fase`,`sede_id`,`nacao_id`,`nacao_id1`,`data`) VALUES
 ('GR','12','13','15','2014-06-19 16:00:00');
 INSERT INTO `partida` (`fase`,`sede_id`,`nacao_id`,`nacao_id1`,`data`) VALUES
 ('GR','6','16','13','2014-06-24 13:00:00');
 INSERT INTO `partida` (`fase`,`sede_id`,`nacao_id`,`nacao_id1`,`data`) VALUES
 ('GR','5','15','16','2014-06-14 18:00:00');
 INSERT INTO `partida` (`fase`,`sede_id`,`nacao_id`,`nacao_id1`,`data`) VALUES
 ('GR','8','16','14','2014-06-20 13:00:00');
 INSERT INTO `partida` (`fase`,`sede_id`,`nacao_id`,`nacao_id1`,`data`) VALUES
 ('GR','1','14','15','2014-06-24 13:00:00');
#-
#Grupo E
 INSERT INTO `partida` (`fase`,`sede_id`,`nacao_id`,`nacao_id1`,`data`) VALUES
 ('GR','2','17','18','2014-06-15 13:00:00');
 INSERT INTO `partida` (`fase`,`sede_id`,`nacao_id`,`nacao_id1`,`data`) VALUES
 ('GR','10','17','19','2014-06-20 16:00:00');
 INSERT INTO `partida` (`fase`,`sede_id`,`nacao_id`,`nacao_id1`,`data`) VALUES
 ('GR','5','20','17','2014-06-25 16:00:00');
 INSERT INTO `partida` (`fase`,`sede_id`,`nacao_id`,`nacao_id1`,`data`) VALUES
 ('GR','7','19','20','2014-06-15 16:00:00');
 INSERT INTO `partida` (`fase`,`sede_id`,`nacao_id`,`nacao_id1`,`data`) VALUES
 ('GR','11','20','18','2014-06-20 19:00:00');
 INSERT INTO `partida` (`fase`,`sede_id`,`nacao_id`,`nacao_id1`,`data`) VALUES
 ('GR','9','18','19','2014-06-25 17:00:00');
#-
#Grupo F
 INSERT INTO `partida` (`fase`,`sede_id`,`nacao_id`,`nacao_id1`,`data`) VALUES
 ('GR','1','21','22','2014-06-15 19:00:00');
 INSERT INTO `partida` (`fase`,`sede_id`,`nacao_id`,`nacao_id1`,`data`) VALUES
 ('GR','9','21','23','2014-06-21 13:00:00');
 INSERT INTO `partida` (`fase`,`sede_id`,`nacao_id`,`nacao_id1`,`data`) VALUES
 ('GR','12','24','21','2014-06-25 13:00:00');
 INSERT INTO `partida` (`fase`,`sede_id`,`nacao_id`,`nacao_id1`,`data`) VALUES
 ('GR','3','23','24','2014-06-16 16:00:00');
 INSERT INTO `partida` (`fase`,`sede_id`,`nacao_id`,`nacao_id1`,`data`) VALUES
 ('GR','7','24','22','2014-06-21 18:00:00');
 INSERT INTO `partida` (`fase`,`sede_id`,`nacao_id`,`nacao_id1`,`data`) VALUES
 ('GR','11','22','23','2014-06-25 13:00:00');
#-
#Grupo G
 INSERT INTO `partida` (`fase`,`sede_id`,`nacao_id`,`nacao_id1`,`data`) VALUES
 ('GR','10','25','26','2014-06-16 13:00:00');
 INSERT INTO `partida` (`fase`,`sede_id`,`nacao_id`,`nacao_id1`,`data`) VALUES
 ('GR','4','25','27','2014-06-21 16:00:00');
 INSERT INTO `partida` (`fase`,`sede_id`,`nacao_id`,`nacao_id1`,`data`) VALUES
 ('GR','8','28','25','2014-06-26 13:00:00');
 INSERT INTO `partida` (`fase`,`sede_id`,`nacao_id`,`nacao_id1`,`data`) VALUES
 ('GR','6','27','28','2014-06-16 19:00:00');
 INSERT INTO `partida` (`fase`,`sede_id`,`nacao_id`,`nacao_id1`,`data`) VALUES
 ('GR','5','28','26','2014-06-22 18:00:00');
 INSERT INTO `partida` (`fase`,`sede_id`,`nacao_id`,`nacao_id1`,`data`) VALUES
 ('GR','2','26','27','2014-06-26 13:00:00');
#-
#Grupo H
 INSERT INTO `partida` (`fase`,`sede_id`,`nacao_id`,`nacao_id1`,`data`) VALUES
 ('GR','1','29','30','2014-06-17 13:00:00');
 INSERT INTO `partida` (`fase`,`sede_id`,`nacao_id`,`nacao_id1`,`data`) VALUES
 ('GR','9','29','31','2014-06-22 13:00:00');
 INSERT INTO `partida` (`fase`,`sede_id`,`nacao_id`,`nacao_id1`,`data`) VALUES
 ('GR','12','32','29','2014-06-26 17:00:00');
 INSERT INTO `partida` (`fase`,`sede_id`,`nacao_id`,`nacao_id1`,`data`) VALUES
 ('GR','3','31','32','2014-06-17 18:00:00');
 INSERT INTO `partida` (`fase`,`sede_id`,`nacao_id`,`nacao_id1`,`data`) VALUES
 ('GR','7','32','30','2014-06-22 16:00:00');
 INSERT INTO `partida` (`fase`,`sede_id`,`nacao_id`,`nacao_id1`,`data`) VALUES
 ('GR','11','30','31','2014-06-26 17:00:00');
 
 
 
 
#######################
 
# Peenchimento 1 Adm
 
# INSERT INTO `usuario` (`login`,`senha`,`papel`) VALUES ();
 
   INSERT INTO `usuario` (`login`,`senha`,`papel`) VALUES ('croupier','1234cp0','A');
 
 
 
#####################################
 
#-Preenchimento teste
 
#INSERT INTO `perfil` (`nome`) VALUES();

#INSERT INTO `usuario` (`login`,`senha`,`perfil_id`) VALUES ();

#INSERT INTO `aposta` (`perfil_id`,`partida_id`,`palpite1`,`palpite2`) VALUES
#();

INSERT INTO `perfil` (`nome`) VALUES(`jef`);
 
INSERT INTO `usuario` (`login`,`senha`,`perfil_id`) VALUES ('lisy','1234cp0',1);

INSERT INTO `aposta` (`perfil_id`,`partida_id`,`palpite1`,`palpite2`) VALUES
(1,1,3, 4);
