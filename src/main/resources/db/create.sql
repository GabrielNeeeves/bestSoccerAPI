-- Criando a tabela Jogador
CREATE TABLE Jogador (
    Id SERIAL PRIMARY KEY,
    Nome VARCHAR(100) NOT NULL,
    pernaDominante VARCHAR(10) NOT NULL CHECK (pernaDominante IN ('esquerda', 'direita')),
    posicao VARCHAR(50) NOT NULL,
    altura DECIMAL(5,2) NOT NULL,
    peso DECIMAL(5,2) NOT NULL,
    contrato DATE NOT NULL,
    nacionalidade VARCHAR(50) NOT NULL,
    dataNascimento DATE NOT NULL,
    foto VARCHAR(255) NOT NULL DEFAULT 'image/jogadorDesconhecido.jpg'
);

-- Criando a tabela Partida 
CREATE TABLE Partida (
    id SERIAL PRIMARY KEY,
    data DATE NOT NULL,
    hora TIME NOT NULL,
    timeAdversario VARCHAR(100) NOT NULL,
    campeonato VARCHAR(50) NOT NULL,
    foto VARCHAR(255) NOT NULL
);

-- Criando a tabela PartidaJogadores
CREATE TABLE PartidaJogadores (
    partidaID INT NOT NULL,
    jogadorID INT NOT NULL,
    gols INT NOT NULL,
    assistencias INT NOT NULL,
    passes INT NOT NULL,
    finalizacoes INT NOT NULL,
    desarmes INT NOT NULL,
    faltas INT NOT NULL,
    FOREIGN KEY (partidaID) REFERENCES Partida(id) ON DELETE CASCADE,
    FOREIGN KEY (jogadorID) REFERENCES Jogador(id) ON DELETE CASCADE
);

-- Criando a tabela Usuario
CREATE TABLE Usuario (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    senha VARCHAR(100) NOT NULL
);

-- Tabela de Administrador
CREATE TABLE Administrador (
    id SERIAL PRIMARY KEY,
    status INT NOT NULL CHECK (status IN (1, 2, 3)),
    usuarioId INT,
    FOREIGN KEY (usuarioId) REFERENCES Usuario(id) ON DELETE CASCADE
);

-- Tabela de Técnico
CREATE TABLE Tecnico (
    id SERIAL PRIMARY KEY,
    contrato DATE NOT NULL,
    usuarioId INT,
    FOREIGN KEY (usuarioId) REFERENCES Usuario(id) ON DELETE CASCADE
);

-- Tabela EstatisticasJogador
CREATE TABLE EstatisticasJogador (
    Id SERIAL PRIMARY KEY,
    JogadorId INT NOT NULL,
    jogosDisputados INT DEFAULT 0,
    golsMarcados INT DEFAULT 0,
    assistencias INT DEFAULT 0,
    finalizacoes INT DEFAULT 0,
    passes INT DEFAULT 0,
    desarmes INT DEFAULT 0,
    faltasCometidas INT DEFAULT 0,
    cartoesAmarelos INT DEFAULT 0,
    cartoesVermelhos INT DEFAULT 0,
    FOREIGN KEY (JogadorId) REFERENCES Jogador(Id) ON DELETE CASCADE
);