package menucarrinho;

import java.util.ArrayList;
import java.util.Scanner;
import pojo.Calcados;



public class MenuCarrinho {
    public static int opcao;
    public static ArrayList<Calcados> lista = new ArrayList();
    public static void menu(){
        
        System.out.println("\tCompras");
        System.out.println("1. Comprar Produto");
        System.out.println("2. Consultar carrinho");
        System.out.println("3. Sair");
        System.out.println("Opcao:");
        
    }
    

    public static void compraProduto(){
        do{
            
        Calcados calc = new Calcados();
        Scanner entrada = new Scanner(System.in);
        System.out.println("Código: ");
        String codigo = entrada.nextLine();
        calc.setCodigo(codigo);
        System.out.println("Tipo: ");
        String tipo = entrada.nextLine();
        calc.setTipo(tipo);
        System.out.println("Marca: ");
        String marca = entrada.nextLine();
        calc.setMarca(marca);
        System.out.println("Tamanho: ");
        String tamanho = entrada.nextLine();
        calc.setTamanho(tamanho);
        System.out.println("Quantidade: ");
        String quantidade = entrada.nextLine();
        calc.setQuantidade(quantidade);
        lista.add(calc);                  
        
        // verificação de repetição de compra
        System.out.println("Deseja realizar mais uma compra? Digite 1 para SIM e 2 para NÃO");
        int opcao = entrada.nextInt();
        
    }while (opcao == 1);
} 
    
    public static void consultaCarrinho(){
        //Menu de inclusão de uma compra
        for (int x = 0; x < lista.size(); x++){
            Calcados calc = lista.get(x);
            System.out.println("\nConsulta do Carrinho");
            System.out.println("\nCodigo: " + calc.getCodigo());
            System.out.println("Tipo: " + calc.getTipo());
            System.out.println("Marca: " + calc.getMarca());
            System.out.println("Tamanho: " + calc.getTamanho());
            System.out.println("Quantidade: " + calc.getQuantidade());
        }
    }
    
    public static void saidaCarrinho(){
        System.out.println("Menu finalizado!");
        System.exit(0);
    }
    
    public static void main(String[] args) {
        int opcao;
        Scanner entrada = new Scanner(System.in);
        
        do{
            menu();
            opcao = entrada.nextInt();
            
            switch(opcao){
            case 1:
                compraProduto();
                break;
                
            case 2:
                consultaCarrinho();
                break;
            case 3:
                saidaCarrinho();
                break;
            
            default:
                System.out.println("Opção inválida!");
            }
        } while(opcao != 0);
    }
}
