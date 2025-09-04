package app;
import java.util.ArrayList;
import java.util.Scanner;
import model.Conta;
import service.RegrasDeNegocio;

public class SimuladorBanco {
    public static void main(String[] args) {

        ArrayList<Conta> listaContas = new ArrayList<>();

        int contadorContas = 3;

        Conta conta1 = new Conta();
        conta1.setNome("Erick");
        conta1.setSobrenome("Henrique");
        conta1.settipoConta("Conta Corrente");
        conta1.setnumeroConta("270182");
        conta1.setnumeroAgencia("2205");
        conta1.setSaldo(10000);


        listaContas.add(conta1);

        Conta conta2 = new Conta();
        conta2.setNome("João");
        conta2.setSobrenome("Pedro");
        conta2.settipoConta("Conta Poupança");
        conta2.setnumeroConta("854231");
        conta2.setnumeroAgencia("7316");
        conta2.setSaldo(1500);


        listaContas.add(conta2);

        Conta conta3 = new Conta();
        conta3.setNome("Maria");
        conta3.setSobrenome("Alice");
        conta3.settipoConta("Conta Pagamento");
        conta3.setnumeroConta("334064");
        conta3.setnumeroAgencia("9901");
        conta3.setSaldo(2000);

        listaContas.add(conta3);

       // System.out.println(listaContas);

        int escolha;

        Scanner scanner = new Scanner(System.in);

        String entradaMenu;

        do {

            System.out.println("----- SIMULADOR DE BANCO -----");
            System.out.println("Escolha uma das opções abaixo:");
            System.out.println("1.Acessar conta");
            System.out.println("2.Criar conta");
            System.out.println("3.Sair");
            System.out.println();

            entradaMenu = scanner.next();

            while(!RegrasDeNegocio.validarOpcaoMenu(entradaMenu)) {
                System.out.println("Entrada inválida! digite apenas numeros.");
                entradaMenu = scanner.next();
            }

            escolha = Integer.parseInt(entradaMenu);

            switch (escolha) {
                case 1:

                Conta contaSelecionada = null;

                do{
                    System.out.println("Acessar conta");
                    System.out.println("Informe o numero da conta: ");

                    String numeroConta = scanner.next();
                    System.out.println();

                    while (!RegrasDeNegocio.validarConta(numeroConta)) {
                        System.out.println("Número de agência inválido! Deve conter 6 digítos. Tente novamente.");
                        numeroConta = scanner.next();
                        }

                    System.out.println("Informe o numero da agência: ");
                    String numeroAgencia = scanner.next();
                    System.out.println();

                    while (!RegrasDeNegocio.validarAgencia(numeroAgencia)) {
                            System.out.println("Número de agência inválido! Deve conter 4 digítos. Tente novamente.");
                            numeroAgencia = scanner.next();
                        }

                    for (Conta conta : listaContas) {
                        if (conta.getnumeroConta() .equals(numeroConta) && conta.getnumeroAgencia().equals(numeroAgencia)) {
                            contaSelecionada = conta;
                            break;
                        }
                    }
                    if(contaSelecionada == null){
                        System.out.println("Conta não encontrada, tente novamente.");
                        System.out.println();
                    }

                }while(contaSelecionada == null);

                // Conta encontrada prosseguir com operações
                System.out.println("Olá, " + RegrasDeNegocio.formatarNome(contaSelecionada.getNome() + " " + RegrasDeNegocio.formatarSobrenome(contaSelecionada.getSobrenome())));
                System.out.println("Tipo de conta:" + RegrasDeNegocio.formatarNome(contaSelecionada.gettipoConta()));
                System.out.println("Saldo em conta " + RegrasDeNegocio.formatarValor(contaSelecionada.getSaldo()));
                System.out.println("Número da conta: " + contaSelecionada.getnumeroConta());
                System.out.println("Número da Agencia: " + contaSelecionada.getnumeroAgencia());

                String entradaMenuSecundario;
                boolean sair = false;

                do {
                    System.out.println();
                    System.out.println("Escolha uma das opções abaixo:");
                    System.out.println("1.Depositar");
                    System.out.println("2.Sacar");
                    System.out.println("3.Sair");
                    entradaMenuSecundario = scanner.next();
                    System.out.println();

                    while(!RegrasDeNegocio.validarOpcaoMenu(entradaMenuSecundario)) {
                        System.out.println("Entrada inválida! digite apenas numeros.");
                        entradaMenuSecundario = scanner.next();
                    }

                    int opcao = Integer.parseInt(entradaMenuSecundario);

                    switch(opcao) {

                        case 1:
                            System.out.println("Informe o valor para depósito: ");
                            String valorDeposito = scanner.next();

                            while(!RegrasDeNegocio.validarEntrada(valorDeposito)) {
                                    System.out.println("Entrada inválida! Use o formato americano (ex: 30,000.50).");
                                    valorDeposito = scanner.next();
                                }

                            contaSelecionada.depositar(RegrasDeNegocio.converterEntrada(valorDeposito));
                            break;

                        case 2:
                            System.out.println("Informe o valor para saque: ");
                            String valorSacar = scanner.next();

                            while(!RegrasDeNegocio.validarEntrada(valorSacar)) {
                                    System.out.println("Entrada inválida! Use o formato americano (ex: 30,000.50).");
                                    valorSacar = scanner.next();
                                }

                            contaSelecionada.sacar(RegrasDeNegocio.converterEntrada(valorSacar));
                            break;

                        case 3:
                            sair = true;
                            break;

                        default:
                            System.out.println("Opção Inválida, Tente novamente.");
                            break;
                        }

                }while (sair == false);
                break;


                case 2:

                    boolean contaExiste;

                    do{
                        System.out.println("Criar conta");
                        System.out.println("Informe seu primeiro nome:");
                        String novoNome = scanner.next();

                        while(!RegrasDeNegocio.validarNome(novoNome)) {
                            System.out.println("Nome inválido! Digite apenas letras e espaço: ");
                            novoNome = scanner.next();
                        }

                        scanner.nextLine();
                        System.out.println("Informe seu Sobrenome:");
                        String novoSobrenome = scanner.nextLine().trim();

                        while(!RegrasDeNegocio.validarSobrenome(novoSobrenome)) {
                            System.out.println("Sobrenome inválido! Digite apenas letras e espaço: ");
                            novoSobrenome = scanner.next();
                        }

                        System.out.println("Digite o numero da conta (6 dígitos):");
                        String novoNumeroConta = scanner.next();

                        while (!RegrasDeNegocio.validarConta(novoNumeroConta)) {
                            System.out.println("Número de agência inválido! Deve conter 6 digítos. Tente novamente.");
                            novoNumeroConta = scanner.next();
                        }

                        System.out.println();
                        System.out.println("Digite o numero da agência (4 dígitos):");
                        String novoNumeroAgencia = scanner.next();

                        while (!RegrasDeNegocio.validarAgencia(novoNumeroAgencia)) {
                            System.out.println("Número de conta inválido! Deve conter 4 digítos. Tente novamente.");
                            novoNumeroAgencia = scanner.next();
                        }

                        System.out.println();

                        System.out.println("Informe o tipo de conta que você deseja criar (Corrente) (Pagamento) (Poupanca)");
                        String tipoConta = scanner.next();

                        while(!tipoConta.equalsIgnoreCase("Corrente") && !tipoConta.equalsIgnoreCase ("Pagamento") && !tipoConta.equalsIgnoreCase("Poupanca")) {
                            System.out.println("Entrada Inválida! Informe o tipo de conta que deseja criar (Corrente) (Pagamento) (Poupanca)");
                            tipoConta = scanner.next();
                        }

                        contaExiste = false;

                        for (Conta conta : listaContas) {
                            if(conta.getnumeroConta().equals(novoNumeroConta) && conta.getnumeroAgencia().equals(novoNumeroAgencia)) {
                            contaExiste = true;
                            break;
                            }
                        }

                        if (contaExiste){
                            System.out.println("Já existe uma conta com esses dados! Tente novamente.");

                        }else {
                            contadorContas++;
                            String nomeConta = String.format("Conta" + contadorContas);

                            Conta novaConta = new Conta();
                            novaConta.setNome(RegrasDeNegocio.formatarNome(novoNome));
                            novaConta.setSobrenome(RegrasDeNegocio.formatarSobrenome(novoSobrenome));
                            novaConta.settipoConta(RegrasDeNegocio.formatarNome(tipoConta));
                            novaConta.setNomeConta(nomeConta);
                            novaConta.setnumeroConta(novoNumeroConta);
                            novaConta.setnumeroAgencia(novoNumeroAgencia);

                            listaContas.add(novaConta);

                            System.out.println("Conta criada com sucesso");
                            System.out.println("Olá, " + novaConta.getNome() + " " + novaConta.getSobrenome());
                            System.out.println("CONTA " + novaConta.gettipoConta());
                            System.out.println("O número da sua conta é: " + novaConta.getnumeroConta());
                            System.out.println("O número da sua agência é: " + novaConta.getnumeroAgencia());
                            System.out.println("Seu saldo inicial é " +  RegrasDeNegocio.formatarValor(novaConta.getSaldo()));
                            System.out.println();
                            break;
                            }

                    }while (contaExiste == true);
                    break;

                case 3:
                    System.out.println("Saindo do programa");
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }

        } while (escolha != 3);
    }
}