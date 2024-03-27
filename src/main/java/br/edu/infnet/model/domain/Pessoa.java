package br.edu.infnet.model.domain;

import java.util.Date;

public class Pessoa {
    private int pessoaId;
    private String nome;
    private String ultimoNome;
    private Date dataNascimento;
    private String CPF;

    @Override
    public String toString() {
        return "Pessoa: Id - " + pessoaId + ", " + nome + " " + ultimoNome
                + ", Data de Nascimento - " + dataNascimento.toLocaleString() +", CPF - " + CPF;
    }

    public Pessoa() {

    }

    public Pessoa(String nome, String ultimoNome, Date dataNascimento, String CPF) {
        this.nome = nome;
        this.ultimoNome = ultimoNome;
        this.dataNascimento = dataNascimento;
        this.CPF = CPF;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUltimoNome() {
        return ultimoNome;
    }

    public void setUltimoNome(String ultimoNome) {
        this.ultimoNome = ultimoNome;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public int getPessoaId() {
        return pessoaId;
    }

    public void setPessoaId(int pessoaId) {
        this.pessoaId = pessoaId;
    }
}
