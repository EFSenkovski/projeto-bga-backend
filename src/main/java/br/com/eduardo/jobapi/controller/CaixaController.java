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
import br.com.eduardo.jobapi.model.Caixa;
import br.com.eduardo.jobapi.repository.CaixaRepository;
import br.com.eduardo.jobapi.service.CaixaService;

@RestController
@RequestMapping("/caixas")
public class CaixaController {
    
    @Autowired
    private CaixaRepository caixaRepository;

    @Autowired
    private CaixaService caixaService;

    @Autowired
    private ApplicationEventPublisher publisher;

    @GetMapping
    @PreAuthorize("hasAuthority('ROLE_LISTAR_CAIXAS') and hasAuthority('SCOPE_read')")
    public List<Caixa> listarTodos(){
        return caixaRepository.findAll();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('ROLE_LISTAR_CAIXAS') and hasAuthority('SCOPE_read')")
	public ResponseEntity<Caixa> buscarPeloId(@PathVariable Long id){
		Optional<Caixa> caixaRecuperado = caixaRepository.findById(id);
		return caixaRecuperado.isPresent() ?
				ResponseEntity.ok(caixaRecuperado.get()) : ResponseEntity.notFound().build();
	}
	

    @PostMapping
    public ResponseEntity<Caixa> criar(@Valid @RequestBody Caixa caixa, HttpServletResponse response){
        Caixa caixaSalvo = caixaService.salvar(caixa);        
        publisher.publishEvent(new RecursoCriadoEvent(this, response, caixaSalvo.getId()));
        return ResponseEntity.status(HttpStatus.CREATED).body(caixaSalvo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Caixa> atualizar(@PathVariable Long id, @Valid @RequestBody Caixa caixa){
        Caixa caixaSalvo = caixaService.atualizar(id, caixa);
        return ResponseEntity.ok(caixaSalvo);   
    }
}
