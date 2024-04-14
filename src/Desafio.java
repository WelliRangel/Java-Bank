package formata.dados;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class Desafio {
    public static void main(String[] args) {
        Locale localeBR = new Locale("pt", "BR");
        NumberFormat dinheiro = NumberFormat.getCurrencyInstance(localeBR);
        Scanner input = new Scanner(System.in);

        String nome = "Wellington Rangel";
        String tipoConta = "Corrente";
        double saldo = 2500.00;
        String menu = """
                Operações
                                
                1- Consultar saldos
                2- Receber valor
                3- Transferir valor
                4- Sair
                                
                Digite a opção desejada:
                """;

        System.out.println("*************************************************************");
        System.out.println("\nNome do cliente: " + nome);
        System.out.println("Tipo conta: " + tipoConta);
        System.out.println("Saldo inicial: " + dinheiro.format(saldo));
        System.out.println("\n*************************************************************");
        System.out.println(menu);
        byte opcao = input.nextByte();

        while (opcao != 4) {
            if(opcao > 4 || opcao < 1) {
                System.out.println("\nXXXXXXXXXXXXXXXXXXXXXXXX");
                System.out.println("XXX Opção inválida XXXX");
                System.out.println("XXXXXXXXXXXXXXXXXXXXXXXX");
                System.out.println("\n" + menu);
                opcao = input.nextByte();
            }
            switch (opcao) {
                case 1:
                    System.out.println("\n***************************");
                    System.out.println("* Saldo atual:" + dinheiro.format(saldo) + " *");
                    System.out.println("***************************");
                    System.out.println(menu);
                    opcao = input.nextByte();
                    break;

                case 2:
                    System.out.println("Digite o valor que deseja depositar:");
                    double valorDeposito = input.nextDouble();
                    if (valorDeposito < 0) {
                        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                        System.out.println("Não é possivel depositar um valor negativo!");
                        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                        System.out.println(menu);
                        opcao = input.nextByte();
                        break;
                    } else if (valorDeposito < 0.01) {
                        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                        System.out.println("O valor minimo para depositar é de " + dinheiro.format(0.01));
                        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                        System.out.println(menu);
                        opcao = input.nextByte();
                        break;

                    }
                    saldo += valorDeposito;
                    System.out.println("*************************************************************");
                    System.out.println("O valor de: " + dinheiro.format(valorDeposito) + " foi depositado em sua conta.");
                    System.out.println("*************************************************************");
                    System.out.println(menu);
                    opcao = input.nextByte();
                    break;

                case 3:
                    System.out.println("Digite o valor que deseja transferir:");
                    double valorTransferencia = input.nextDouble();
                    if(valorTransferencia > saldo) {
                        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                        System.out.println("Saldo insuficiente");
                        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                        System.out.println(menu);
                        opcao = input.nextByte();
                        break;
                    }
                    saldo -= valorTransferencia;
                    System.out.println("*************************************************************");
                    System.out.println("O valor de: " + dinheiro.format(valorTransferencia) + " foi transferido da sua conta");
                    System.out.println("*************************************************************");
                    System.out.println(menu);
                    opcao = input.nextByte();
                    break;

                case 4:
                    break;
            }
        }
    }
}
