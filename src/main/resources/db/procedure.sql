--cadastrar jogador
CREATE PROCEDURE sp_cadJogador (
	nome varchar(100),
	pernaBoa varchar(10),
	posicao varchar(50),
	altura decimal(5,2),
	peso decimal(5,2),
	contr date,
	nac varchar(50),
	dataNasc date
)
LANGUAGE plpgsql
AS $$ BEGIN
	INSERT INTO JOGADOR (nome, pernaBoa, posicao, altura, peso, contrato, nacionalidade, dataNascimento) VALUES
	(nome, pernaBoa, posicao, altura, peso, contr, nac, dataNasc);
END $$;

DROP PROCEDURE sp_cadJogador

CALL sp_cadJogador ('Kaká', 'esquerda', 'atacante', 1.80, 78.00, '2025-8-25', 'Brasileiro', '1995-6-20')

--cadastrar Partida
CREATE PROCEDURE sp_cadPartida (
	DATA date,
	hora time,
	timeAdv varchar(100),
	LOCAL varchar(100)
)
LANGUAGE plpgsql
AS $$ BEGIN
	insert into partida(data, hora, timeAdversario, local) values
	(data, hora, timeAdv, local);
END $$;

CALL sp_cadPartida('2024-10-4', '17:30:00', 'Douglinha Vigilante da Justiça', 'Campo Verde do Norte')

SELECT * FROM v_partida

--cadastrar PartidaJogadores
CREATE PROCEDURE sp_cadPartidaJogadores (
	partidaId int,
	jogadorId int,
	gols int
)
LANGUAGE plpgsql
AS $$ BEGIN
	insert into PartidaJogadores (partidaId, jogadorId, gols) VALUES
	(partidaId, jogadorId, gols);
END $$;

SELECT * FROM v_PartidaJogadores


--cadastrar usuario
CREATE PROCEDURE sp_cadUsuario(
	nome varchar(100),
	email varchar(100),
	senha varchar(100)
)
LANGUAGE plpgsql
AS $$ BEGIN
	insert into usuario (nome, email, senha) values
	(nome, email, senha);
END $$;

CALL sp_cadUsuario('Lawrence', 'lawrence@gmail.com', 'l2w')
CALL sp_cadUsuario('Maria', 'maria99@gmail.com', 'm@r1a')

--cadastrar admin
CREATE PROCEDURE sp_admin(
	userId int
)
LANGUAGE plpgsql
AS $$ BEGIN
	insert into usuarioAdmin values (userId);
END $$;

CALL sp_admin(4)


--cadastrar usuarioComum
CREATE PROCEDURE sp_comum(
	userId int
)
LANGUAGE plpgsql
AS $$ BEGIN
	insert into usuarioComum values (userId);
END $$;

CALL sp_admin(6)


