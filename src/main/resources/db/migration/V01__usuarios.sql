CREATE TABLE usuarios (
	id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	nome VARCHAR(50) NOT NULL,
	email VARCHAR(50) NOT NULL,
	senha VARCHAR(150) NOT NULL,
    administrador smallint default 0,
	ativo smallint default 1,
	data_hora_criacao datetime default CURRENT_TIMESTAMP,
	data_hora_atualizacao datetime default CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE permissoes (
	id BIGINT(20) PRIMARY KEY,
	descricao VARCHAR(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE usuario_permissao (
	id_usuario BIGINT(20),
	id_permissao BIGINT(20),
	PRIMARY KEY(id_usuario, id_permissao),
	FOREIGN KEY(id_usuario) references usuarios(id),
	FOREIGN KEY(id_permissao) references permissoes(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO usuarios (nome, email, senha, administrador) values ('Admin', 'admin@teste.com', '$2a$10$u9ARMvP3vT.zP7D5IBv6FOVHaWOtdyHh.w7FYLWalctVLp5uD9Gv2',1);
INSERT INTO usuarios (nome, email, senha) values ('Eduardo Felipe Senkovski', 'eduardo@teste.com', '$2a$10$u9ARMvP3vT.zP7D5IBv6FOVHaWOtdyHh.w7FYLWalctVLp5uD9Gv2');
INSERT INTO usuarios (nome, email, senha) values ('Mobile', 'mobile@teste.com', '$2a$10$u9ARMvP3vT.zP7D5IBv6FOVHaWOtdyHh.w7FYLWalctVLp5uD9Gv2');

INSERT INTO permissoes (id, descricao) values (1,'ROLE_LISTAR_USUARIOS');
INSERT INTO permissoes (id, descricao) values (2,'ROLE_CADASTRAR_USUARIOS');
INSERT INTO permissoes (id, descricao) values (3,'ROLE_LISTAR_EMPRESAS');
INSERT INTO permissoes (id, descricao) values (4,'ROLE_CADASTRAR_EMPRESAS');
INSERT INTO permissoes (id, descricao) values (5,'ROLE_LISTAR_CAIXAS');
INSERT INTO permissoes (id, descricao) values (6,'ROLE_CADASTRAR_CAIXAS');
INSERT INTO permissoes (id, descricao) values (7,'ROLE_LISTAR_MOVIMENTACOES');
INSERT INTO permissoes (id, descricao) values (8,'ROLE_CADASTRAR_MOVIMENTACOES');
INSERT INTO permissoes (id, descricao) values (9,'ROLE_CADASTRAR_PESSOAS');
INSERT INTO permissoes (id, descricao) values (10,'ROLE_LISTAR_PESSOAS');
INSERT INTO permissoes (id, descricao) values (11,'ROLE_CADASTRAR_TIPO_PESSOAS');
INSERT INTO permissoes (id, descricao) values (12,'ROLE_LISTAR_TIPO_PESSOAS');

INSERT INTO usuario_permissao(id_usuario, id_permissao) values (1,1);
INSERT INTO usuario_permissao(id_usuario, id_permissao) values (1,2);
INSERT INTO usuario_permissao(id_usuario, id_permissao) values (1,3);
INSERT INTO usuario_permissao(id_usuario, id_permissao) values (1,4);
INSERT INTO usuario_permissao(id_usuario, id_permissao) values (1,5);
INSERT INTO usuario_permissao(id_usuario, id_permissao) values (1,6);
INSERT INTO usuario_permissao(id_usuario, id_permissao) values (1,7);
INSERT INTO usuario_permissao(id_usuario, id_permissao) values (1,8);
INSERT INTO usuario_permissao(id_usuario, id_permissao) values (1,9);
INSERT INTO usuario_permissao(id_usuario, id_permissao) values (1,10);
INSERT INTO usuario_permissao(id_usuario, id_permissao) values (1,11);
INSERT INTO usuario_permissao(id_usuario, id_permissao) values (1,12);