## tarefa / tarefas
	id
	descricao
	status (pendente, andamento, finalizado, impedido)
	responsavel
	dtinicio
	dtfinal
	horas_estimativa
	horas_utilizadas
	dtcriacao
	dtatualizacao
	usuario_relator
	tarefa_agendada
	
## tarefa_movimentacao /tarefas/:id/movimentacao
	id
	idtarefa
	dtHoramovimento
	usuario
	obs

## tarefa_movimentacao_horas /tarefas/:id_tarefa/movimentacao/:id/horas
	id
	idtarefa
	idmovimentacao
	horas
	
## tarefa_movimentacao_status /tarefas/:id_tarefa/movimentacao/:id/status
	id
	idtarefa
	idmovimentacao
	oldstatus
	newstatus
	
## tarefa_movimentacao_responsavel /tarefas/:id_tarefa/movimentacao/:id/responsavel
	id
	idtarefa
	idmovimentacao
	oldresponsavel
	newresponsavel
	
## tarefa_movimentacao_imagem /tarefas/:id_tarefa/movimentacao/:id/imagens
	id	
	idmovimentacao
	imagem
	
## tarefa_movimentacao_tipos /tarefas/:id_tarefa/movimentacao/:id/tipos
	id
	idmovimentacao
	idtipomovimentacao
	
## tipo_movimentacao /tipos_movimentacao
	id,
	descricao (criou, lancou horas, finalizou, mudou status, mudou estimativa, mudou responsavel, agendamento)
	
## usuario /usuarios
	id
	nome
	email
	senha
	
## usuario_imagem /usuarios/:id/imagem
	id
	idusuario
	imagem
	
## agenda /agenda
	id
	descricao
	responsavel
	horas_estimativa
	dtcriacao
	dtatualizacao
	usuario_relator

## agenda_data /agenda/:id/data
	id
	idagenda
	data