CREATE TABLE caixas (
	id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,   
    descricao varchar(100),
    valor_atual decimal(15,6),
    data_ultima_movimentacao datetime,
    data_hora_criacao datetime DEFAULT CURRENT_TIMESTAMP,
	data_hora_atualizacao datetime DEFAULT CURRENT_TIMESTAMP    

) ENGINE=InnoDB DEFAULT CHARSET=utf8;