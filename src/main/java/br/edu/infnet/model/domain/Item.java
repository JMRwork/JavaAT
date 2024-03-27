package br.edu.infnet.model.domain;

public class Item {
    private int itemId;
    private String nome;
    private String descricao;
    private int quantidade;
    private double preco;

    public Item(String nome, String descricao, int quantidade, double preco) {
        this.nome = nome;
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.preco = preco;
    }

    public Item() {

    }

    @Override
    public String toString() {
        return "ItemId: " + itemId +
                ", " + nome  +
                ", " + descricao  +
                ", qty: " + quantidade +
                ", preco: " + preco;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) throws Exception {
        if(itemId > 0) {
            this.itemId = itemId;
        } else {
            throw new Exception("O id deve ser único e maior que zero.");
        }

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
}
