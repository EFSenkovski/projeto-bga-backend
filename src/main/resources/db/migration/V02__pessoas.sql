CREATE TABLE tipos_pessoa (
	id smallint PRIMARY KEY AUTO_INCREMENT,
	descricao VARCHAR(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO tipos_pessoa (id,descricao) VALUES (1,'Cliente');
INSERT INTO tipos_pessoa (id,descricao) VALUES (2,'Associado');
INSERT INTO tipos_pessoa (id,descricao) VALUES (3,'Parceiro');
INSERT INTO tipos_pessoa (id,descricao) VALUES (4,'Advogado Parceiro');
INSERT INTO tipos_pessoa (id,descricao) VALUES  (5,'Sócio');

CREATE TABLE pessoas (
	id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	nome_razaosocial VARCHAR(100) NOT NULL,
    nome_fantasia VARCHAR(50),
    pessoa_fisica_juridica CHAR(1) NOT NULL DEFAULT 'F',
    cpf_cnpj varchar(50),
    rg_ie varchar(50),
	email VARCHAR(50),
    data_nascimento_fundacao datetime,
    endereco varchar(100),
    cidade varchar(50),
    cep varchar(20),
    uf varchar(2),
    telefone VARCHAR(50),
    celular VARCHAR(50),
    tipo_pessoa smallint,
    observacao varchar(255),
	data_hora_criacao datetime default CURRENT_TIMESTAMP,
	data_hora_atualizacao datetime default CURRENT_TIMESTAMP,
    FOREIGN KEY(tipo_pessoa) references tipos_pessoa(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE pessoas_comissoes (
    id_pessoa BIGINT(20),
    id_pessoa_comissao BIGINT(20),
    percentual_comissao decimal(15,6),
    PRIMARY KEY(id_pessoa, id_pessoa_comissao),
	FOREIGN KEY(id_pessoa) references pessoas(id),
	FOREIGN KEY(id_pessoa_comissao) references pessoas(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
