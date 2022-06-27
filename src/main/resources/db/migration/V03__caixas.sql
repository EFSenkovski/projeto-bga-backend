CREATE TABLE caixas (
	id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
    id_empresa BIGINT(20) NOT NULL,
    descricao varchar(100),
    valor_atual decimal(15,6),
    data_ultima_movimentacao datetime,
    data_hora_criacao datetime DEFAULT CURRENT_TIMESTAMP,
	data_hora_atualizacao datetime DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY(id_empresa) references empresas(id)

) ENGINE=InnoDB DEFAULT CHARSET=utf8;