package com.example.aps;

public class ItemCompra {

    private String produto;
    private float valor;

    public ItemCompra(String produto, float  valor) {
        this.produto = produto;
        this.valor = valor;
    }

    public float getValor() {
        return valor;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }
}
