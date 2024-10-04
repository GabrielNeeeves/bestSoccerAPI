--view jogadores
CREATE VIEW v_jogador
AS
	SELECT j.*
	FROM jogador j
	
	
--view partida
CREATE VIEW v_partida
AS
	SELECT p.*
	FROM partida p
	
	
--view PartidaJogadores
CREATE VIEW v_PartidaJogadores
AS
	SELECT pj.*
	FROM PartidaJogadores pj
	
	
--view UsuarioAdmin
CREATE VIEW v_usuarioAdmin
AS
	SELECT u.id, u.nome, u.email, u.senha
	FROM usuario u
	INNER JOIN UsuarioAdmin uadmin ON u.id = uadmin.usuarioID
	
--view UsuarioComum
CREATE VIEW v_usuarioComum
AS
	SELECT u.id, u.nome, u.email, u.senha
	FROM usuario u
	INNER JOIN usuarioComum ucomum ON u.id = ucomum.usuarioID
	
	
	
	
	