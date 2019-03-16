package com.locadora.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

@Entity
public class Locacao {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @ManyToOne
    private Usuario usuario;
    
    @ManyToOne
    private Filme filme;
    
    @Transient
    public static String DATA_PATERN = "yyyy-MM-dd HH:mm";

    @Column(nullable = false, name = "data_locacao")
    private String dataLocacao;

    @Column(nullable = false, name = "previsao_devolucao")
    private String previsaoDevolucao;

    @Column(nullable = true, name = "data_devolucao")
    private String dataDevolucao;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Filme getFilme() {
        return filme;
    }

    public void setFilme(Filme filme) {
        this.filme = filme;
    }

    public String getDataLocacao() {
        return dataLocacao;
    }

    public void setDataLocacao(String dataLocacao) {
        this.dataLocacao = dataLocacao;
    }

    public String getPrevisaoDevolucao() {
        return previsaoDevolucao;
    }

    public void setPrevisaoDevolucao(String previsaoDevolucao) {
        this.previsaoDevolucao = previsaoDevolucao;
    }

    public String getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(String dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + (int) (this.id ^ (this.id >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Locacao other = (Locacao) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Locacao{" + "id=" + id + ", usuario=" + usuario + ", filme=" 
                + filme + ", dataLocacao=" + dataLocacao 
                + ", previsaoDevolucao=" + previsaoDevolucao 
                + ", dataDevolucao=" + dataDevolucao + '}';
    }
}