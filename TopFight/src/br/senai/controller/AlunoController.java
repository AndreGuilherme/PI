package br.senai.controller;

import br.senai.DAO.AlunoDAO;
import br.senai.model.Aluno;
import br.senai.util.Utils;
import java.util.ArrayList;

public class AlunoController {

    private static AlunoController instanciaRep;
    private AlunoDAO alunoDAO;

    public static AlunoController obterInstancia() {
        if (instanciaRep == null) {
            instanciaRep = new AlunoController();
        }
        return instanciaRep;
    }

    public void inserir(Aluno aluno) throws Exception {
        if (aluno.getDscNome().isEmpty() || aluno.getDscNome() == null) {
            throw new Exception("Nome do Aluno inválido");
        }
        aluno.setDscCPF(aluno.getDscCPF().replace("-", ""));
        aluno.setDscCPF(aluno.getDscCPF().replace(".", ""));
        aluno.setDscCPF(aluno.getDscCPF().replace("_", ""));
        if (aluno.getDscCPF().isEmpty() || aluno.getDscCPF().equals("") || !Utils.validarCPF(aluno.getDscCPF())) {
            throw new Exception("CPF inválido");
        }

        if (aluno.getDtDataNasc() == null) {
            throw new Exception("Data inválida");
        }

        try {
            aluno.setPeso(Double.parseDouble(aluno.getPeso().toString()));
        } catch (Exception e) {
            throw new Exception("Peso inválido");
        }

        try {
            aluno.setAltura(Double.parseDouble(aluno.getAltura().toString()));
        } catch (Exception e) {
            throw new Exception("Altura inválida");
        }

//        try {
//            aluno.setNunNumero(Integer.parseInt(aluno.getNunNumero().toString()));
//        } catch (Exception e) {
//            throw new Exception("Número invalido");
//        }
        aluno.setTelefone(aluno.getTelefone().replace("(", "").replace(")", "").replace("-", "").replace("_", "").replace(" ", ""));

        if (aluno.getTelefone().isEmpty() || aluno.getTelefone().equals("")) {
            throw new Exception("Telefone inválido");
        }
        alunoDAO = new AlunoDAO();
        alunoDAO.inserir(aluno);
    }

    public void alterar(Aluno aluno) throws Exception {
        if (aluno.getDscNome().isEmpty()) {
            throw new Exception("Nome do Aluno inválido");
        }

        aluno.setDscCPF(aluno.getDscCPF().replace("-", ""));
        aluno.setDscCPF(aluno.getDscCPF().replace(".", ""));
        if (aluno.getDscCPF().isEmpty() || aluno.getDscCPF().equals("")) {
            throw new Exception("CPF inválido");
        }

        if (aluno.getNunNumero() == null || aluno.getNunNumero() == 0) {
            throw new Exception("Número invalido");
        }
        if (aluno.getSexo() != 1 && aluno.getSexo() != 2) {
            throw new Exception("Sexo inválido");
        }
        if (aluno.getDtDataNasc() == null) {
            throw new Exception("Data inválida");
        }
        if (aluno.getPeso() == null) {
            throw new Exception("Peso inválido");
        }
        if (aluno.getAltura() == null) {
            throw new Exception("Altura inválida");
        }

        //AlunoDAO.obterInstancia().alterar(aluno);
    }

    public Aluno obterAluno(int id) throws Exception {
        return AlunoDAO.obterInstancia().obtemAluno(id);
    }

    public ArrayList<Aluno> listarTodos() {
        return AlunoDAO.obterInstancia().listarTodos();
    }
}
