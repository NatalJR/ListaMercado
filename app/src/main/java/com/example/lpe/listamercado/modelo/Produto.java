package com.example.lpe.listamercado.modelo;

/**
 * Created by natal on 28/11/16.
 */
public class Produto {
    private Long id;
    private String produto;
    private Integer quantidade;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return getId() + " - " + getProduto() + " - Qtd: "+ getQuantidade() ;
    }
}
