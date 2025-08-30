package com.school.sptech;

public class Biblioteca {
    private String nome;
    private Double multaDiaria;
    private Integer qtdLivros;
    private Boolean ativa;

    public Biblioteca(String nome, Double multaDiaria) {
        this.nome = nome;
        this.multaDiaria = multaDiaria;
        qtdLivros = 0;
        ativa = true;
    }

    public void registrarLivro(Integer quantidade) {
        if (quantidade != null && quantidade > 0 && ativa) {
            qtdLivros += quantidade;
        }
    }

    public Integer emprestar(Integer quantidade) {
        if (quantidade != null && ativa && quantidade > 0 && quantidade <= qtdLivros) {
            qtdLivros -= quantidade;
            return quantidade;
        }
        return null;
    }

    public Integer devolver(Integer quantidade) {
        if (quantidade != null && ativa && quantidade > 0) {
            qtdLivros += quantidade;
            return quantidade;
        }
        return null;
    }

    public Integer desativar() {
        if (ativa == false) {
            return null;
        } else {
            Integer qtdAnterior = qtdLivros;
            ativa = false;
            qtdLivros = 0;
            return qtdAnterior;
        }
    }

    public void transferir(Biblioteca destino, Integer quantidade) {
        if (ativa && destino.ativa && quantidade > 0 && quantidade <= qtdLivros) {
            destino.qtdLivros += quantidade;
            qtdLivros -= quantidade;
        }
    }

    public Boolean reajustarMulta(Double percentual) {
        if (percentual != null && percentual > 0) {
            multaDiaria = multaDiaria * (1 + percentual);
            return true;
        } else {
            return false;
        }
    }

    public String getNome() {
        return nome;
    }
    public Double getMultaDiaria() {
        return multaDiaria;
    }
    public Integer getQtdLivros() {
        return qtdLivros;
    }
    public Boolean getAtiva() {
        return ativa;
    }
}
