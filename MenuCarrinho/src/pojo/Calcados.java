package pojo;

import java.util.Observable;

public class Calcados extends Observable{
    private String codigo;
    private String tipo;
    private String marca;
    private String tamanho;
    private int quantidade;
    private double preco;
    private String atualiza;

    public Calcados(String atualiza) {
        this.atualiza = atualiza;
    }

    public Calcados() {
       return;
    }

    public String getAtualiza() {
        return atualiza;
    }

    public void setAtualiza(String atualiza) {
        this.atualiza = atualiza;
        setChanged();
        notifyObservers();
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    
}
