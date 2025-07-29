import java.util.Locale;
import java.util.Scanner;

public class CalculadoraIMC {
    public static void main(String[] args) {

    try (Scanner scanner = new Scanner(System.in)) {
            scanner.useLocale(Locale.US);

            String nome;
            float peso = 0;
            float altura = 0;

        while(true) {

            System.out.println("Informe seu nome: ");
            nome = scanner.nextLine().trim();

            if(!nome.isEmpty() && nome.matches("[a-zA-ZáéíóúÁÉÍÓÚãõÃÕçÇ ]+")) {
                break;
            } else {
                System.out.println("Nome inválido. Digite apenas letras.");
            }
        }

        while(true) {

            System.out.println("Informe seu peso: ");
            try {
                peso = Float.parseFloat(scanner.nextLine());
                if (peso > 0) break;
                else System.out.println("Peso deve ser maior que zero.");
            } catch (NumberFormatException e ) {
                System.out.println("Peso inválido. Digite um número válido.");
            }
        }


        while(true) {
            System.out.println("Informe sua altura: ");
            try {
                altura = Float.parseFloat(scanner.nextLine());
                if (altura > 0) break;
                else System.out.println("Altura deve ser maior que zero.");
            } catch (NumberFormatException e) {
                System.out.println("Altura inválida. Digite um número válido.");
            }
        }
        calcular_IMC(nome, peso, altura);
    }

    }
    public static void  calcular_IMC(String nome, float peso,float altura) {
        float imc = peso / (altura * altura);
        String imcFormatado = String.format("%.2f", imc);

        if (imc < 18.5 ) {
            System.out.print("Olá " + nome + " você está abaixo do peso com base na tabela da OMS. Seu IMC é: " + imcFormatado);
        }
        else if (imc < 24.9 ) {
            System.out.print("Olá " + nome + " você está com peso normal com base na tabela da OMS. Seu IMC é:" + imcFormatado);
        }
        else if (imc < 29.9 ) {
            System.out.print("Olá " + nome + " você está com sobre peso com base na tabela da OMS. Seu IMC é:" + imcFormatado);
        }
        else if (imc < 34.9 ) {
            System.out.print("Olá " + nome + " você está com obesidade grau 1° com base na tabela da OMS. Seu IMC é:" + imcFormatado);
        }
        else if (imc < 39.9 ) {
            System.out.print("Olá " + nome + " você está com obesidade grau 2° com base na tabela da OMS. Seu IMC é:" + imcFormatado);
        }
        else {
            System.out.print("Olá " + nome + " você está com obesidade grau 3° com base na tabela da OMS. Seu IMC é:" + imcFormatado);
        }
    }

}
