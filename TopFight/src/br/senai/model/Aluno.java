package br.senai.model;

public class Aluno extends Pessoa {

    private Integer numId;
    private Double peso;
    private Double altura;

    public Aluno() {
    }

    public Integer getId() {
        return numId;
    }

    public void setNumId(Integer numId) {
        this.numId = numId;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Double getAltura() {
        return altura;
    }

    public void setAltura(Double altura) {
        this.altura = altura;
    }

}
