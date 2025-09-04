package model;

import service.RegrasDeNegocio;

public class Conta {

    private String nome;
    private String sobrenome;
    private String nomeConta;
    private String tipoConta;
    private String numeroConta;
    private String numeroAgencia;
    private double saldo;
    private double valor;

    public Conta(){};

    public Conta(String nome, String sobrenome, String tipoConta,String numeroConta, String numeroAgencia, double saldo) {
        this.nome = nome;
        this.tipoConta = tipoConta;
        this.numeroConta = numeroConta;
        this.numeroAgencia = numeroAgencia;
        this.saldo = saldo;
    }

    public void setNome(String nome){
        this.nome = nome;
    }
    public String getNome() {
        return nome;
    }
    public void setSobrenome(String sobrenome){
        this.sobrenome = sobrenome;
    }
    public String getSobrenome() {
        return sobrenome;
    }
    public void setNomeConta(String nomeConta){
        this.nomeConta = nomeConta;
    }
    public String getNomeConta(){
        return nomeConta;
    }
    public void settipoConta(String tipoConta){
        this.tipoConta = tipoConta;
    }
    public String gettipoConta() {
        return tipoConta;
    }
    public String getnumeroConta() {
        return numeroConta;
    }
    public void setnumeroConta(String numeroConta) {
        this.numeroConta = numeroConta;
    }
    public String getnumeroAgencia() {
        return numeroAgencia;
    }
    public void setnumeroAgencia(String numeroAgencia) {
        this.numeroAgencia = numeroAgencia;
    }
    public double getSaldo() {
        return saldo;
    }
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void depositar(double valor) {
        if(valor <= 0) {
            System.out.println("O valor para depósito não pode ser negativo ou menor que 0");
        }
        else {
            saldo += valor;
            System.out.println("Depósito de " + RegrasDeNegocio.formatarValor(valor) + " efetuado com sucesso");
            System.out.println("Saldo atual " + RegrasDeNegocio.formatarValor(getSaldo()));
        }

    }

    public void sacar(double valor) {
        if(valor > saldo) {
            System.out.println("Saldo insuficente em sua conta");
        }
        else {
            saldo -= valor;
            System.out.println("Saque de " + RegrasDeNegocio.formatarValor(valor) + " foi efetuado com sucesso");
            System.out.println("Saldo atual " + RegrasDeNegocio.formatarValor(getSaldo()));
        }

    }


    }


