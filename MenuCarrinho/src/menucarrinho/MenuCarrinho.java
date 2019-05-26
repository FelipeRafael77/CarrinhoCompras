package menucarrinho;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;
import pojo.Calcados;
import util.Biblioteca;

// ---------------- MENU PRINCIPAL -----------------------
public class MenuCarrinho implements Observer{

    public static int opcao;

    public static ArrayList<Calcados> lista = new ArrayList();

    public static void menu() {

        System.out.println("\tCompras");
        System.out.println("1. Calçados Disponíveis");
        System.out.println("2. Comprar Produto");
        System.out.println("3. Consultar carrinho");
        System.out.println("4. Consultar o valor total");
        System.out.println("5. Pagamento");
        System.out.println("6. Remover item do carrinho");
        System.out.println("7. Sair");
        System.out.println("Opcao:");

    }
// ---------------------- METODO DE COMPRA ------------------------------------

    public static void compraProduto() {
        do {
            Calcados calc = new Calcados();
            Biblioteca fac = new Biblioteca();
            Scanner entrada = new Scanner(System.in);
            System.out.println("\nCompra de itens");
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
            int quantidade = Integer.parseInt(entrada.nextLine());
            calc.setQuantidade(quantidade);
            System.out.println("Valor unitário: ");
            double preco = Double.parseDouble(entrada.nextLine());
            calc.setPreco(preco);
            lista.add(calc);

// verificação de repetição de compra
            System.out.println("Deseja realizar mais uma compra? Digite 1 para SIM e 2 para NÃO");
            opcao = entrada.nextInt();

        } while (opcao == 2);
    }
  
    public static void pesquisarItens(){
        
    }
    
// ------------------------ METODO DE CONSULTA ---------------------------------
    
    public static void consultaCarrinho() {

        for (int x = 0; x < lista.size(); x++) {
            Calcados calc = lista.get(x);
            System.out.println("\nItens no carrinho");
            System.out.println("\nCodigo: " + calc.getCodigo());
            System.out.println("Tipo: " + calc.getTipo());
            System.out.println("Marca: " + calc.getMarca());
            System.out.println("Tamanho: " + calc.getTamanho());
            System.out.println("Quantidade: " + calc.getQuantidade());
            System.out.println("Valor unitário: " + calc.getPreco());
            System.out.println("-----------------------------------");
        }
    }

//----------------------- METODO REMOVER DO CARRINHO ---------------------------
    public static void removerItem() {

        for (int x = 0; x < lista.size(); x++) {
            Calcados calc = lista.get(x);
            System.out.println("\nCodigo: " + calc.getCodigo());
            System.out.println("Tipo: " + calc.getTipo());
            System.out.println("Marca: " + calc.getMarca());
            System.out.println("--------------------------");
        }
        System.out.println("Digite o ID do item que deseja remover: ");
        Scanner remover = new Scanner(System.in);
        int item = Integer.parseInt(remover.nextLine());
        System.out.println(item);
        for (int i = 0; i < lista.size(); i++) {
            Calcados calc = lista.get(i);
            if (Integer.parseInt(calc.getCodigo()) == item) {
                
                lista.remove(calc);
                break;
            }
        }
    }
// ------------------------METODO DE CALCULAR O VALOR TOTAL --------------------
    //Calcula o valor unitário * a quantidade.

    public static void valorTotal() {
        Biblioteca facade = new Biblioteca();
        double total = 0.0;
        for (Calcados calcado : lista) {
            total += calcado.getPreco() * calcado.getQuantidade();
        }
        facade.cobrar(total);
    }

//----------------------------------- METODO PAGAMENTO -------------------------   
    public static void pagar() {
        double valorPago = 0.0;
        Scanner pagar = new Scanner(System.in);
        Biblioteca facade = new Biblioteca();

        System.out.println("Quanto voce deseja pagar?");
        valorPago = pagar.nextDouble();
        facade.realizarPagamento(valorPago);
    }
// ------------------------- METODO SAIR ----------------------------------------    

    public static void saidaCarrinho() {
        System.out.println("Menu finalizado!");
        System.exit(0);
    }
// ------------------------- CASE ----------------------------------------------

    public static void main(String[] args) {
        int opcao;
        Scanner entrada = new Scanner(System.in);
        Calcados observable = new Calcados(null);
        MenuCarrinho observer = new MenuCarrinho();
        observable.addObserver(observer);
        observable.setAtualizaCarrinho("Bright and sunny...Let's play cricket!! "); //vê o que você entende que poosa ser colocado aqui.
        observable.setAtualizaCarrinho("Raining Heavily!..Let's have hot Pakodas!!");// e aqui também.

        do {
            menu();
            opcao = entrada.nextInt();

            switch (opcao) {
                case 1:
                    
                    break;
                case 2:
                    compraProduto();
                    break;
                case 3:
                    consultaCarrinho();
                    break;
                case 4:
                    valorTotal();
                    break;
                case 5:
                    pagar();
                    break;
                case 6:
                    removerItem();
                    break;
                case 7:
                    saidaCarrinho();
                    break;
                
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }

    @Override
    public void update(Observable o, Object arg) { 
        atualizaCarrinho = (Calcados) o;
        System.out.println("O produto inserido/excluído foi: " + atualizaCarrinho.getAtualizaCarrinho());
    }
}
