package br.com.eduardo.jobapi.repository;

import br.com.eduardo.jobapi.model.Pessoa;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

}
