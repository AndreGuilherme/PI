package br.senai.model;

import java.sql.Time;

public class RelatorioProfAula {

    private String nomeProf;
    private Time hrInicio;
    private Time hrFinal;
    private int diaSemana;
    private int qntNumAluno;
    private int numAlunoAula;
    private int status;

    public String getNomeProf() {
        return nomeProf;
    }

    public void setNomeProf(String nomeProf) {
        this.nomeProf = nomeProf;
    }

    public Time getHrInicio() {
        return hrInicio;
    }

    public void setHrInicio(Time hrInicio) {
        this.hrInicio = hrInicio;
    }

    public Time getHrFinal() {
        return hrFinal;
    }

    public void setHrFinal(Time hrFinal) {
        this.hrFinal = hrFinal;
    }

    public int getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(int diaSemana) {
        this.diaSemana = diaSemana;
    }

    public int getQntNumAluno() {
        return qntNumAluno;
    }

    public void setQntNumAluno(int qntNumAluno) {
        this.qntNumAluno = qntNumAluno;
    }

    public int getNumAlunoAula() {
        return numAlunoAula;
    }

    public void setNumAlunoAula(int numAlunoAula) {
        this.numAlunoAula = numAlunoAula;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

}
