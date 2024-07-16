Create database astromonitor;

CREATE TABLE asteroids (
    id_asteroids INT AUTO_INCREMENT PRIMARY KEY,
    id_objeto_nasa VARCHAR(255) NOT NULL,
    nome_asteroid VARCHAR(255) NOT NULL,
    nasa_jpl_url VARCHAR(255),
    diameter_min_m FLOAT,
    diameter_max_m FLOAT,
    risco BOOLEAN,
    data_aproximacao DATE,
    velocidade FLOAT,
    distancia_da_terra FLOAT,
    orbitando VARCHAR(255),
    UNIQUE (id_objeto_nasa, data_aproximacao)
);

CREATE TABLE usuarios (
    id_usuario INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    login VARCHAR(255) NOT NULL UNIQUE,
    senha VARCHAR(255) NOT NULL,
    chave_api VARCHAR(255) NOT NULL,
    UNIQUE (login)
);

CREATE TABLE user_token (
    id_token INT AUTO_INCREMENT PRIMARY KEY,
    id_usuario INT NOT NULL,
    token VARCHAR(255) NOT NULL,
    data_insercao TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    data_validade TIMESTAMP,
    FOREIGN KEY (id_usuario) REFERENCES usuarios(id_usuario),
    unique (id_usuario)
);