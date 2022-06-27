CREATE TABLE caixas_movimentacao (
	id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
    id_caixa BIGINT(20) NOT NULL,
    id_usuario BIGINT(20) NOT NULL, 
    descricao varchar(100),
    valor decimal(15,6),
    tipo_movimento varchar(1),
    data_movimento datetime,
    FOREIGN KEY(id_caixa) references caixas(id),
    FOREIGN KEY(id_usuario) references usuarios(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;