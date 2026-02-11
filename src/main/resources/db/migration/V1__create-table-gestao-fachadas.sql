CREATE TABLE clientes (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    telefone VARCHAR(20) UNIQUE NOT NULL,
    empresa VARCHAR(150) NOT NULL,
    endereco VARCHAR(255) NOT NULL
);

CREATE TABLE projetofachada (
    id SERIAL PRIMARY KEY,
    nome_projeto VARCHAR(150) NOT NULL,
    tipo_fachada VARCHAR(200) NOT NULL,
    data_inicio DATE NOT NULL,
    cliente_id INT NOT NULL,

    foreign key (cliente_id) references clientes (id)
);

