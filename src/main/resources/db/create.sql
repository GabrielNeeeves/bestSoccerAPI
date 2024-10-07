-- Criando a tabela Jogador 
CREATE TABLE JOGADOR (
	ID SERIAL PRIMARY KEY,
	NOME VARCHAR(100) NOT NULL,
	pernaBoa varchar(10) NOT NULL
	check(pernaBoa IN ('esquerda', 'direita')),
	posicao VARCHAR(50) NOT NULL,
	altura DECIMAL(5,2) NOT NULL,
	peso DECIMAL(5,2) NOT NULL, 
    contrato DATE NOT NULL, 
    nacionalidade VARCHAR(50) NOT NULL, 
    dataNascimento DATE NOT NULL 
);

SELECT * FROM JOGADOR

-- Criando a tabela Partida 
CREATE TABLE Partida ( 
    id serial PRIMARY KEY, 
    data DATE NOT NULL, 
    hora TIME NOT NULL, 
    timeAdversario VARCHAR(100) NOT NULL, 
    local VARCHAR(100) NOT NULL 
); 

-- Criando a tabela PartidaJogadores 
CREATE TABLE PartidaJogadores ( 
    partidaID INT NOT NULL, 
    jogadorID INT NOT NULL, 
    gols INT NOT NULL, 
    --PRIMARY KEY (partidaID, jogadorID), 
    FOREIGN KEY (partidaID) REFERENCES Partida(id) ON DELETE cascade, 
    FOREIGN KEY (jogadorID) REFERENCES Jogador(id) ON DELETE cascade 
); 

--Usuario
CREATE TABLE usuario (
  	id serial PRIMARY KEY,
  	nome varchar(100) NOT NULL,
  	email VARCHAR(100) NOT NULL UNIQUE,
    senha VARCHAR(100) NOT NULL
  );

  --UsuarioAdmin
  CREATE TABLE UsuarioAdmin (
      usuarioID serial PRIMARY KEY,
      FOREIGN KEY (usuarioID) REFERENCES Usuario(id) ON DELETE cascade
  );
 

-- Criando a tabela UsuarioComum 
CREATE TABLE UsuarioComum ( 
    usuarioID INT PRIMARY KEY, 
    FOREIGN KEY (usuarioID) REFERENCES Usuario(id) ON DELETE cascade
); 

