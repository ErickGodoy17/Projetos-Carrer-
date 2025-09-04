package service;
import java.text.DecimalFormat;

public class RegrasDeNegocio {

    public static boolean validarEntrada(String entrada) {
        String limpa = entrada.replace(",","");
        return limpa.matches("\\d+(\\.\\d+)?");
    }

    public static boolean validarOpcaoMenu(String entrada) {
        return entrada.matches("[1-3]");
    }

    public static double converterEntrada(String entrada) {
        entrada = entrada.replace(",","");
        return Double.parseDouble(entrada);
    }

    public static final DecimalFormat df = new DecimalFormat("#,##0.00");

    public static String formatarValor(double valor) {
        return "R$" + df.format(valor);
    }

    public static boolean validarAgencia(String agencia) {
        return agencia != null && agencia.matches("\\d{4}");
    }

    public static boolean validarConta(String conta) {
        return conta != null && conta.matches("\\d{6}");
    }

    public static String formatarNome(String nome) {
        String nomeFormatado = nome.toUpperCase();
        return nomeFormatado;
    }

    public static String formatarSobrenome(String nome) {
        String sobrenomeFormatado = nome.toUpperCase();
        return sobrenomeFormatado;
    }

    public static boolean validarNome (String nome) {
        return nome != null && nome.matches("[A-Za-zÀ-ÖØ-öø-ÿ ]+");
    }

    public static boolean validarSobrenome (String sobrenome) {
        return sobrenome != null && sobrenome.matches("[A-Za-zÀ-ÖØ-öø-ÿ ]+");
    }
}