package br.com.eduardo.jobapi.repository;

import br.com.eduardo.jobapi.model.TipoPessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface TipoPessoaRepository extends JpaRepository<TipoPessoa, Long> {

}