import java.util.Scanner;
import java.util.Locale;

public class SistemaMercado {

    public static void limpartela() {
        for(int i = 0; i < 50; i++) {
            System.out.println();
        }
    }

    public static void titulo (String titulo) {
        System.out.println("====================");
        System.out.println(titulo);
        System.out.println("====================");
    }

    public static void menuPrincipal() {
        System.out.println("1 - Cadastrar Produto");
        System.out.println("2 - Iniciar venda");
        System.out.println("3 - Adicionar item");
        System.out.println("4 - Finalizar compra");
        System.out.println("5 - Ver estoque");
        System.out.println("6 - Ver carrinho");
        System.out.println("0 - Sair");
    }

    public static void verCarrinho(
            int[] carrinhoCodigo,
            int[] carrinhoQuantidade,
            int quantidadeItensCarrinho,
            int[] codigo,
            String[] nome,
            double[] preco) {

        if(quantidadeItensCarrinho == 0) {
            System.out.println("Carrinho vazio.");
            return;
        }

        System.out.println("===== CARRINHO =====");

        double total = 0;

        for(int i = 0; i < quantidadeItensCarrinho; i++) {

            for(int j = 0; j < codigo.length; j++) {

                if(codigo[j] == carrinhoCodigo[i]) {

                    double subtotal =
                            preco[j] * carrinhoQuantidade[i];

                    total += subtotal;

                    System.out.printf(
                            "%s | Qtd: %d | Subtotal: R$ %.2f%n",
                            nome[j],
                            carrinhoQuantidade[i],
                            subtotal
                    );

                    break;
                }
            }
        }

        System.out.println("----------------------");
        System.out.printf("TOTAL PARCIAL: R$ %.2f%n", total);
    }

    public static void main(String[] args) {

        Locale.setDefault(new Locale("pt", "BR"));
        Scanner scanner = new Scanner(System.in);

        int[] codigo = new int[100];
        String[] nome = new String[100];
        double[] preco = new double[100];
        int[] estoque = new int[100];

        int[] carrinhoCodigo = new int[100];
        int[] carrinhoQuantidade = new int[100];

        int quantidadeItensCarrinho = 0;
        boolean vendaAtiva = false; // condição de estado

        int opcao;


        do{
            //limpartela();
            titulo("SISTEMA DE MERCADO");

            System.out.println();

            menuPrincipal();

            System.out.println();

            System.out.print("Digite a opção: ");
            opcao = scanner.nextInt();

            scanner.nextLine();

            switch (opcao) {
                case 1:

                    limpartela();
                    titulo("CADASTRAR PRODUTO");

                    System.out.print("Digite o código: ");
                    int novoCodigo = scanner.nextInt();
                    scanner.nextLine();

                    boolean codigoExiste = false;

                    for(int i = 0; i < codigo.length; i++) {
                        if(codigo[i] == novoCodigo) {
                            codigoExiste = true;
                            break;
                        }
                    }

                    if(codigoExiste) {
                        System.out.println("Já existe um produto com esse código!");
                        break;
                    }

                    for(int indice = 0; indice < codigo.length; indice++) {

                        if(codigo[indice] == 0) {

                            codigo[indice] = novoCodigo;

                            System.out.print("Digite o nome: ");
                            nome[indice] = scanner.nextLine();

                            System.out.print("Digite o preço: ");
                            preco[indice] = scanner.nextDouble();

                            System.out.print("Digite a quantidade em estoque: ");
                            estoque[indice] = scanner.nextInt();

                            System.out.println("Produto cadastrado com sucesso!");

                            break;
                        }
                    }

                    break;
                case 2:

                    if(vendaAtiva){
                        System.out.println("Já existe uma venda em andamento.");
                        break;
                    }

                    quantidadeItensCarrinho = 0;
                    vendaAtiva = true;

                    System.out.println("Venda iniciada com sucesso!");

                    break;
                case 3: // adicionar item

                    if(!vendaAtiva){
                        System.out.println("Inicie uma venda primeiro.");
                        break;
                    }

                    boolean produtoEncontrado = false;

                    System.out.println("Digite o código do produto: ");
                    int codigoProduto = scanner.nextInt();

                    scanner.nextLine();

                    for(int indice = 0; indice < nome.length; indice++){

                        if(nome[indice] != null && codigoProduto == codigo[indice]) {

                            produtoEncontrado = true;

                            System.out.println("nome: " +  nome[indice]);
                            System.out.println("Estoque: " + estoque[indice]);
                            System.out.printf("Preço: R$ %.2f%n", preco[indice]);

                            if(estoque[indice] == 0){
                                System.out.println("Produto sem estoque.");
                                break;
                            }

                            System.out.println("Digite a quantidade: ");
                            int quantidadeCompra = scanner.nextInt();

                            scanner.nextLine();

                            if(quantidadeCompra <= 0){
                                System.out.println("Quantidade inválida.");
                                break;
                            }

                            if(quantidadeCompra > estoque[indice]) {

                                System.out.println("Estoque insuficiente!");

                            } else {

                                carrinhoCodigo[quantidadeItensCarrinho] = codigo[indice];
                                carrinhoQuantidade[quantidadeItensCarrinho] = quantidadeCompra;

                                quantidadeItensCarrinho++;

                                System.out.println("Item adicionado ao carrinho!");

                                break;
                            }
                        }
                    }

                    if(!produtoEncontrado){
                        System.out.println("Produto não encontrado.");
                    }

                    break;
                case 4:

                    if(!vendaAtiva){
                        System.out.println("Nenhuma venda iniciada.");
                        break;
                    }

                    if(quantidadeItensCarrinho == 0){
                        System.out.println("Carrinho vazio.");
                        break;
                    }

                    double total = 0;

                    System.out.println("===== ITENS DA COMPRA =====");

                    for(int i = 0; i < quantidadeItensCarrinho; i++){

                        int codigoCarrinho = carrinhoCodigo[i];
                        int quantidadeComprada = carrinhoQuantidade[i];

                        for(int indice = 0; indice < codigo.length; indice++){

                            if(codigo[indice] == codigoCarrinho){

                                double subtotal = preco[indice] * quantidadeComprada;

                                System.out.printf("%s | Qtd: %d | Subtotal: R$ %.2f%n", nome[indice], quantidadeComprada, subtotal);

                                total += subtotal;

                                break;
                            }
                        }
                    }

                    System.out.println("----------------------");
                    System.out.printf("Total da compra: R$ %.2f%n", total);

                    System.out.print("Valor pago: R$ ");
                    double valorPago = scanner.nextDouble();
                    scanner.nextLine();

                    if(valorPago < total){
                        System.out.println("Valor insuficiente.");
                        break;
                    }

                    double troco = valorPago - total;

                    // CUPOM FISCAL
                    System.out.println("\n===== CUPOM FISCAL =====");

                    for(int i = 0; i < quantidadeItensCarrinho; i++) {

                        for(int j = 0; j < codigo.length; j++) {

                            if(codigo[j] == carrinhoCodigo[i]) {

                                double subtotal =
                                        preco[j] * carrinhoQuantidade[i];

                                System.out.printf("%s | Qtd: %d | Subtotal: R$ %.2f%n", nome[j], carrinhoQuantidade[i], subtotal);

                                break;
                            }
                        }
                    }

                    System.out.println("----------------------");
                    System.out.printf("TOTAL: R$ %.2f%n", total);
                    System.out.printf("PAGO : R$ %.2f%n", valorPago);
                    System.out.printf("TROCO: R$ %.2f%n", troco);
                    System.out.println("======================");

                    // Atualiza estoque
                    for(int i = 0; i < quantidadeItensCarrinho; i++){

                        int codigoCarrinho = carrinhoCodigo[i];
                        int quantidadeComprada = carrinhoQuantidade[i];

                        for(int j = 0; j < codigo.length; j++){

                            if(codigo[j] == codigoCarrinho){

                                estoque[j] -= quantidadeComprada;

                                break;
                            }
                        }
                    }

                    System.out.println("Pagamento realizado com sucesso!");

                    vendaAtiva = false;
                    quantidadeItensCarrinho = 0;

                    break;

                case 5: // ver estoque
                    limpartela();
                    titulo("VERIFICAR ESTOQUE");

                    System.out.println();

                    boolean temProduto = false;

                    for(int indice = 0; indice < codigo.length; indice++) {

                        if(codigo[indice] != 0) {

                            temProduto = true;

                            System.out.println("Código: " + codigo[indice]);
                            System.out.println("Nome: " + nome[indice]);
                            System.out.printf("Preço: R$ %.2f%n", preco[indice]);
                            System.out.println("Estoque: " + estoque[indice]);
                            System.out.println("---------------------");

                        }
                    }

                    if(!temProduto){
                        System.out.println("Não existe produto cadastrado");
                    }

                    break;
                case 6:

                    verCarrinho(carrinhoCodigo, carrinhoQuantidade, quantidadeItensCarrinho, codigo, nome, preco);

                    break;
                case 0:
                    System.out.println("Sistema encerrado.");
                break;

            }

        }while(opcao != 0);

        scanner.close();

    }
}
