package br.com.eduardo.jobapi.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.eduardo.jobapi.event.RecursoCriadoEvent;
import br.com.eduardo.jobapi.model.CaixaMovimento;
import br.com.eduardo.jobapi.repository.CaixaMovimentoRepository;
import br.com.eduardo.jobapi.service.CaixaMovimentoService;

@RestController
@RequestMapping("/movimentacoes")
public class CaixaMovimentoController {
  
    @Autowired
    private CaixaMovimentoRepository caixaMovimentoRepository;

    @Autowired
    private CaixaMovimentoService caixaMovimentoService;

    @Autowired
    private ApplicationEventPublisher publisher;

    @GetMapping
    @PreAuthorize("hasAuthority('ROLE_LISTAR_CAIXAS') and hasAuthority('SCOPE_read')")
    public List<CaixaMovimento> listarTodos(){
        return caixaMovimentoRepository.findAll();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('ROLE_LISTAR_CAIXAS') and hasAuthority('SCOPE_read')")
	public ResponseEntity<CaixaMovimento> buscarPeloId(@PathVariable Long id){
		Optional<CaixaMovimento> caixaRecuperado = caixaMovimentoRepository.findById(id);
		return caixaRecuperado.isPresent() ?
				ResponseEntity.ok(caixaRecuperado.get()) : ResponseEntity.notFound().build();
	}
	

    @PostMapping
    public ResponseEntity<CaixaMovimento> criar(@Valid @RequestBody CaixaMovimento cm, HttpServletResponse response){
        CaixaMovimento cmSalvo = caixaMovimentoService.salvar(cm);        
        publisher.publishEvent(new RecursoCriadoEvent(this, response, cmSalvo.getId()));
        return ResponseEntity.status(HttpStatus.CREATED).body(cmSalvo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CaixaMovimento> atualizar(@PathVariable Long id, @Valid @RequestBody CaixaMovimento cm){
        CaixaMovimento cmSalvo = caixaMovimentoService.atualizar(id, cm);
        return ResponseEntity.ok(cmSalvo);
    }

}
