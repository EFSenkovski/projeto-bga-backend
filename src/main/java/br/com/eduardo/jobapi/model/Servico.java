package br.com.eduardo.jobapi.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
@Getter
@Setter
@Entity
@Table(name = "servicos")
public class Servico {
   
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private long id; 

   private String descricao;

   @Column(name = "data_inicio")
   private LocalDate dataInicio;

   @Column(name = "data_final")
   private LocalDate dataFinal;

   @Column(name = "n_processo")
   private String nProcesso;
   
   @NotNull
   @ManyToOne
   @JoinColumn(name = "id_pessoa")     
   private Pessoa pessoa;

   @Column(name = "data_hora_criacao")
   private LocalDateTime dataHoraCriacao;

   @Column(name = "data_hora_atualizacao")
   private LocalDateTime dataHoraAtualizacao;

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (id ^ (id >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Servico other = (Servico) obj;
        if (id != other.id)
            return false;
        return true;
    }

    

   
}
