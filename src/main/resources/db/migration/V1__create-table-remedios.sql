CREATE TABLE remedios(
    id BIGINT NOT NULL auto_increment,
    nome VARCHAR(100) NOT NULL,
    lote VARCHAR(100) NOT NULL,
    via VARCHAR(100) NOT NULL,
    laboratorio VARCHAR(100) NOT NULL,
    quantidade INT NOT NULL,
    created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at DATETIME,
    validade DATETIME NOT NULL,

    PRIMARY KEY (id)
);