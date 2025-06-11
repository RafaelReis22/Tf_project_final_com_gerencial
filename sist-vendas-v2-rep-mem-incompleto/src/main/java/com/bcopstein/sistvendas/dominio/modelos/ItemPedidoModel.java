package com.bcopstein.sistvendas.dominio.modelos;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class ItemPedidoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "produto_id")
    private ProdutoModel produto;
    
    private int quantidade;

    @ManyToOne
    @JoinColumn(name = "orcamento_id")
    @JsonBackReference
    private OrcamentoModel orcamento;

   
    protected ItemPedidoModel() {}
    
    public ItemPedidoModel(ProdutoModel produto, int quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
    }

    

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public ProdutoModel getProduto() {
        return produto;
    }

    public void setProduto(ProdutoModel produto) {
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public OrcamentoModel getOrcamento() {
        return orcamento;
    }

    public void setOrcamento(OrcamentoModel orcamento) {
        this.orcamento = orcamento;
    }

    @Override
    public String toString() {
        return "ItemPedido [id=" + id + ", produto=" + (produto != null ? produto.getId() : null) + ", quantidade=" + quantidade + ", orcamentoId=" + (orcamento != null ? orcamento.getId() : null) + "]";
    }
}
