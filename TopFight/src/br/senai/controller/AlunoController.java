package br.senai.controller;

import br.senai.model.Aluno;

public class AlunoController {

    private static AlunoController instanciaRep;

    public static AlunoController obterInstancia() {
        if (instanciaRep == null) {
            instanciaRep = new AlunoController();
        }
        return instanciaRep;
    }

    public void inserir(Aluno aluno) throws Exception {
        if (aluno.getDscNome().isEmpty()) {
            throw new Exception("Nome do Aluno inválido");
        }
        if(aluno.getDscCPF().isEmpty()){
            throw  new Exception ("CPF inválido");
        }
        if(aluno.getSexo() != 1 || aluno.getSexo() != 2){
            throw new Exception ("Sexo inválido");
        }
        if(aluno.getDtDataNasc() == null){
            throw new Exception ("Data inválida");
        }
        if(aluno.getPeso() == null){
            throw new Exception ("Peso inválido");
        }
        if(aluno.getAltura() == null){
            throw new Exception ("Altura inválida");
        }
    }
}
