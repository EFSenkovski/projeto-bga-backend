CREATE TABLE servicos (
	id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,   
    descricao varchar(255) not null,
    data_inicio datetime,
    data_final datetime,    
    n_processo varchar(100),
    id_pessoa BIGINT(20),
    data_hora_criacao datetime DEFAULT CURRENT_TIMESTAMP,
	data_hora_atualizacao datetime DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY(id_pessoa) references pessoas(id)

) ENGINE=InnoDB DEFAULT CHARSET=utf8;