package br.senai.model;

import java.sql.Time;

public class Aula {

    private int idAula;
    private Professor professor;
    private Time hInicio;
    private Time hFim;
    private int status;
    private int numeroAlunos;
    private int diaSemana;
    private int numMatricula;

    public int getIdAula() {
        return idAula;
    }

    public void setIdAula(int idAula) {
        this.idAula = idAula;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public Time gethInicio() {
        return hInicio;
    }

    public void sethInicio(Time hInicio) {
        this.hInicio = hInicio;
    }

    public Time gethFim() {
        return hFim;
    }

    public void sethFim(Time hFim) {
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

    public int getNumMatricula() {
        return numMatricula;
    }

    public void setNumMatricula(int numMatricula) {
        this.numMatricula = numMatricula;
    }
}
