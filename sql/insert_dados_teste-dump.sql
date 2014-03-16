INSERT INTO usuario (login, senha, permissao) VALUES
('lisy', '1234cp0', 'ROLE_USER');

INSERT INTO perfil (usuario_id, nome, dt_cadastro) VALUES
(2, 'helis','2014-03-03');

INSERT INTO aposta (perfil_id, partida_id, palpiteA, palpiteB, dt_cadastro) VALUES
(1, 26, 3, 2, '2014-03-06');
