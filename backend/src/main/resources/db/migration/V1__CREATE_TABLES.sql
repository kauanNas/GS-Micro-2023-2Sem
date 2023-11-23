CREATE TABLE objetivo (
    id bigint primary key auto_increment,
    brasil varchar(600),
    global varchar(600)
);

CREATE TABLE ods (
    id bigint primary key auto_increment,
    codigo varchar(255),
    id_objetivo bigint,
    FOREIGN KEY (id_objetivo) REFERENCES objetivo(id)
);

CREATE TABLE indicador (
    id bigint primary key auto_increment,
    ano varchar(255),
    codigo varchar(255),
    consumo double,
    descricao varchar(255),
    regiao varchar(255),
    id_ods bigint,
    FOREIGN KEY (id_ods) REFERENCES ods(id)
);