package util;

import java.util.Random;

public class Biblioteca {
    private static double total = 0;
	public void imprime() {
		System.out.println("estou imprimindo");
	}
	
	public int retornaInteiro() {
		Random rand = new Random();
		return rand.nextInt(1000);
	}
	
	public String cobrar(double total) {
		Biblioteca.total = total;
                System.out.println("Valor a ser pago pelo cliente: R$" + total);
		return "" ;
	}
	
	public String realizarPagamento(double valorPago) {
		if(Biblioteca.total == 0) {
                    System.out.println("executar cobrança primeiro");
			return "executar cobrança primeiro";
		}
		else if(Biblioteca.total <= valorPago) {
                    System.out.println("Troco: R$" + (valorPago - Biblioteca.total));
			return "Troco: R$" + (valorPago - Biblioteca.total);
		}
		else {
                        System.out.println("O valor pago está incorreto. O Valor total é R$:"+ Biblioteca.total + 
					" e o valor pago é R$:" + valorPago);
			return "O valor pago está incorreto. O Valor total é R$:"+ Biblioteca.total + 
					" e o valor pago é R$:" + valorPago;
		}
	}
}
