
package br.senai.model;

import java.sql.Timestamp;

public class Aula {
    private Professor professor;
    private Timestamp hInicio;
    private Timestamp hFim;
    private int status;
    private int numeroAlunos;
    private int diaSemana;

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public Timestamp gethInicio() {
        return hInicio;
    }

    public void sethInicio(Timestamp hInicio) {
        this.hInicio = hInicio;
    }

    public Timestamp gethFim() {
        return hFim;
    }

    public void sethFim(Timestamp hFim) {
        this.hFim = hFim;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getNumeroAlunos() {
        return numeroAlunos;
    }

    public void setNumeroAlunos(int numeroAlunos) {
        this.numeroAlunos = numeroAlunos;
    }

    public int getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(int diaSemana) {
        this.diaSemana = diaSemana;
    }
}
