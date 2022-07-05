package br.com.eduardo.jobapi.controller;

import br.com.eduardo.jobapi.event.RecursoCriadoEvent;
import br.com.eduardo.jobapi.model.TipoPessoa;
import br.com.eduardo.jobapi.repository.TipoPessoaRepository;
import br.com.eduardo.jobapi.service.TipoPessoaService;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.access.prepost.PreAuthorize;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tipo_pessoas")
public class TipoPessoaController {

    @Autowired
    private ApplicationEventPublisher publisher;

    @Autowired
    private TipoPessoaRepository tipoPessoaRepository;

    @Autowired
    private TipoPessoaService tipoPessoaService;

    @GetMapping
    @PreAuthorize("hasAuthority('ROLE_LISTAR_TIPO_PESSOAS') and hasAuthority('SCOPE_read')")
    public List<TipoPessoa> listarTodos(){
        return tipoPessoaRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoPessoa> buscarPeloId(@PathVariable Long id){
        Optional<TipoPessoa> pessoaRecuperado = tipoPessoaRepository.findById(id);
        return pessoaRecuperado.isPresent() ?
                ResponseEntity.ok(pessoaRecuperado.get()) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<TipoPessoa> criar(@Valid @RequestBody TipoPessoa tipoPessoa, HttpServletResponse response){
        TipoPessoa tipoPessoaSalva = tipoPessoaService.salvar(tipoPessoa);
        publisher.publishEvent(new RecursoCriadoEvent(this, response, tipoPessoaSalva.getId()));
        return ResponseEntity.status(HttpStatus.CREATED).body(tipoPessoaSalva);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TipoPessoa> atualizar(@PathVariable Long id, @Valid @RequestBody TipoPessoa tipoPessoa){
        TipoPessoa pessoaSalva = tipoPessoaService.atualizar(id, tipoPessoa);
        return ResponseEntity.ok(pessoaSalva);
    }

}
