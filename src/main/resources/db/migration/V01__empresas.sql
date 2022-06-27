CREATE TABLE empresas (
	id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	razaosocial VARCHAR(255) NOT NULL,
	nomefantasia VARCHAR(255),
	cnpj varchar(50) NOT NULL,
	ie varchar(50),	
    uf varchar(2),
    cidade varchar(100),
	data_hora_criacao datetime default CURRENT_TIMESTAMP,
	data_hora_atualizacao datetime default CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


INSERT INTO empresas(razaosocial, nomefantasia, cnpj, ie, uf, cidade)  values ('Razão Social Teste', 'Empresa Teste', '23.918.488/0001-36','338.933.586.780', 'PR', 'Dois Vizinhos');