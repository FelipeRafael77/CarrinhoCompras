package util;

public class Facade {
    public String cobrar(double total){
        return new Biblioteca().cobrar(total);
    }
    
    public String realizarPagamento(double valorPago){
        return new Biblioteca().realizarPagamento(valorPago);
    }
}
