<<<<<<< HEAD
-- Procedure para cadastrar um Jogador
CREATE PROCEDURE sp_cadJogador(
    nome VARCHAR(100),
    pernaDominante VARCHAR(10),
    posicao VARCHAR(50),
    altura DECIMAL(5,2),
    peso DECIMAL(5,2),
    contrato DATE,
    nacionalidade VARCHAR(50),
    dataNascimento DATE,
    foto VARCHAR(255) DEFAULT 'image/jogadorDesconhecido.jpg' 
)
LANGUAGE plpgsql
AS $$
BEGIN
    INSERT INTO Jogador (Nome, pernaDominante, posicao, altura, peso, contrato, nacionalidade, dataNascimento, foto)
    VALUES (nome, pernaDominante, posicao, altura, peso, contrato, nacionalidade, dataNascimento, foto);
END;
$$;

-- Procedure para cadastrar uma Partida
CREATE PROCEDURE sp_cadPartida(
    data DATE,
    hora TIME,
    timeAdversario VARCHAR(100),
    campeonato VARCHAR(50),
    foto VARCHAR(255)
)
LANGUAGE plpgsql
AS $$
BEGIN
    INSERT INTO Partida (data, hora, timeAdversario, campeonato, foto)
    VALUES (data, hora, timeAdversario, campeonato, foto);
END;
$$;

-- Procedure para cadastrar dados de uma PartidaJogadores
CREATE PROCEDURE sp_cadPartidaJogador(
    partidaID INT,
    jogadorID INT,
    gols INT,
    assistencias INT,
    passes INT,
    finalizacoes INT,
    desarmes INT,
    faltas INT
)
LANGUAGE plpgsql
AS $$
BEGIN
    INSERT INTO PartidaJogadores (partidaID, jogadorID, gols, assistencias, passes, finalizacoes, desarmes, faltas)
    VALUES (partidaID, jogadorID, gols, assistencias, passes, finalizacoes, desarmes, faltas);
END;
$$;

-- Procedure para cadastrar um Usuario
CREATE PROCEDURE sp_cadUsuario(
    nome VARCHAR(100),
    email VARCHAR(100),
    senha VARCHAR(100)
)
LANGUAGE plpgsql
AS $$
BEGIN
    INSERT INTO Usuario (nome, email, senha)
    VALUES (nome, email, senha);
END;
$$;

-- Procedure para cadastrar um Administrador
CREATE PROCEDURE sp_cadAdmin(
    nome VARCHAR(100),
    email VARCHAR(100),
    senha VARCHAR(100),
    status INT
)
LANGUAGE plpgsql
AS $$
DECLARE
    pessoa_id INT;
BEGIN
    INSERT INTO Usuario (nome, email, senha)
    VALUES (nome, email, senha)
    RETURNING id INTO pessoa_id;

    INSERT INTO Administrador (usuarioId, status)
    VALUES (pessoa_id, status);
END;
$$;

-- Procedure para cadastrar um Tecnico
CREATE PROCEDURE sp_cadTecnico(
    nome VARCHAR(100),
    email VARCHAR(100),
    senha VARCHAR(100),
    contrato DATE
)
LANGUAGE plpgsql
AS $$
DECLARE
    pessoa_id INT;
BEGIN
    INSERT INTO Usuario (nome, email, senha)
    VALUES (nome, email, senha)
    RETURNING id INTO pessoa_id;

    INSERT INTO Tecnico (usuarioId, contrato)
    VALUES (pessoa_id, contrato);
END;
$$;

-- Procedure para cadastrar uma Estatística de Jogador
CREATE PROCEDURE sp_cadEstatisticaJogador(
    jogador_id INT, 
    jogos_disputados INT DEFAULT 0, 
    gols_marcados INT DEFAULT 0, 
    assistencias INT DEFAULT 0, 
    finalizacoes INT DEFAULT 0, 
    passes INT DEFAULT 0, 
    desarmes INT DEFAULT 0, 
    faltas_cometidas INT DEFAULT 0, 
    cartoes_amarelos INT DEFAULT 0, 
    cartoes_vermelhos INT DEFAULT 0
)
LANGUAGE plpgsql
AS $$
BEGIN
    INSERT INTO EstatisticasJogador (
        JogadorId, 
        jogosDisputados, 
        golsMarcados, 
        assistencias, 
        finalizacoes, 
        passes, 
        desarmes, 
        faltasCometidas, 
        cartoesAmarelos, 
        cartoesVermelhos
    )
    VALUES (
        jogador_id, 
        jogos_disputados, 
        gols_marcados, 
        assistencias, 
        finalizacoes, 
        passes, 
        desarmes, 
        faltas_cometidas, 
        cartoes_amarelos, 
        cartoes_vermelhos
    );
END;
$$;
=======
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
	userId bigint
)
LANGUAGE plpgsql
AS $$ BEGIN
	insert into usuarioComum (usuarioid) values (userId);
END $$;

DROP PROCEDURE sp_comum

CALL sp_admin(6)
CALL sp_comum(2)

SELECT * FROM v_usuariocomum vu
>>>>>>> 8d1a811845ebbdb5c87c677cfe98c927da441271
