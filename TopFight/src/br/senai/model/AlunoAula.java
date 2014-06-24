package br.senai.model;

public class AlunoAula {

    private Integer numIdAluno;
    private Integer numIdAula;

    public AlunoAula(Integer numIdAluno, Integer numIdAula) {
        this.numIdAluno = numIdAluno;
        this.numIdAula = numIdAula;
    }
    
    public Integer getNumIdAluno() {
        return numIdAluno;
    }

    public void setNumIdAluno(Integer numIdAluno) {
        this.numIdAluno = numIdAluno;
    }

    public Integer getNumIdAula() {
        return numIdAula;
    }

    public void setNumIdAula(Integer numIdAula) {
        this.numIdAula = numIdAula;
    }
}
