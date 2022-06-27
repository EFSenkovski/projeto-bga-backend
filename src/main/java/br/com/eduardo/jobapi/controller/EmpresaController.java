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
import br.com.eduardo.jobapi.model.Empresa;
import br.com.eduardo.jobapi.repository.EmpresaRepository;
import br.com.eduardo.jobapi.service.EmpresaService;

@RestController
@RequestMapping("/empresas")
public class EmpresaController {
    
    @Autowired
    private EmpresaRepository empresaRepository;

    @Autowired
    private EmpresaService empresaService;

    @Autowired
    private ApplicationEventPublisher publisher;

    @GetMapping
    @PreAuthorize("hasAuthority('ROLE_LISTAR_USUARIOS') and hasAuthority('SCOPE_read')")
    public List<Empresa> listarTodas(){
        return empresaRepository.findAll();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('ROLE_LISTAR_USUARIOS') and hasAuthority('SCOPE_read')")
    public ResponseEntity<Empresa> buscarPeloId(@PathVariable Long id){
        Optional<Empresa> empresaRecuperada = empresaRepository.findById(id);
        return empresaRecuperada.isPresent() ?
            ResponseEntity.ok(empresaRecuperada.get()) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Empresa> criar(@Valid @RequestBody Empresa empresa, HttpServletResponse response){
        Empresa empresaSalva = empresaService.salvar(empresa);        
        publisher.publishEvent(new RecursoCriadoEvent(this, response, empresaSalva.getId()));
        return ResponseEntity.status(HttpStatus.CREATED).body(empresaSalva);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Empresa> atualizar(@PathVariable Long id, @Valid @RequestBody Empresa empresa){
        Empresa empresaSalva = empresaService.atualizar(id, empresa);
        return ResponseEntity.ok(empresaSalva);
    }

}
