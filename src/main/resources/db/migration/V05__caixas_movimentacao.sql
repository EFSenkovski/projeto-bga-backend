CREATE TABLE centros_custo (
	id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
    descricao varchar(100),
    tipo_entrada_saida CHAR(1) DEFAULT 'E',
    tags varchar(255)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE caixas_movimentacao (
	id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
    id_caixa BIGINT(20) NOT NULL,
    id_usuario BIGINT(20) NOT NULL, 
    id_centro_custo BIGINT(20) NOT NULL,     
    id_pessoa BIGINT(20),
    id_servico BIGINT(20),
    descricao varchar(100),
    valor decimal(15,6),    
    data_movimento datetime,
    FOREIGN KEY(id_caixa) references caixas(id),
    FOREIGN KEY(id_usuario) references usuarios(id),
    FOREIGN KEY(id_centro_custo) references centros_custo(id),   
    FOREIGN KEY(id_pessoa) references pessoas(id),
    FOREIGN KEY(id_servico) references servicos(id)        
) ENGINE=InnoDB DEFAULT CHARSET=utf8;