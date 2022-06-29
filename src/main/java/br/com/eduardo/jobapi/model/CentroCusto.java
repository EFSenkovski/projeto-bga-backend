package br.com.eduardo.jobapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "centros_custo")
public class CentroCusto {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    private String descricao;

    @Column(name = "tipo_entrada_saida")
    private String tipoEntradaSaida;

    private String tags;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTipoEntradaSaida() {
        return tipoEntradaSaida;
    }

    public void setTipoEntradaSaida(String tipoEntradaSaida) {
        this.tipoEntradaSaida = tipoEntradaSaida;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

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
        CentroCusto other = (CentroCusto) obj;
        if (id != other.id)
            return false;
        return true;
    }
    
    
}
