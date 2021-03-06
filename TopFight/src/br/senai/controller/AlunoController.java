package br.senai.controller;

import br.senai.DAO.AlunoDAO;
import br.senai.model.Aluno;
import br.senai.model.AlunoAula;
import br.senai.model.Aula;
import br.senai.util.Utils;
import java.util.ArrayList;

public class AlunoController {

    private static AlunoController instanciaRep;

    public static AlunoController obterInstancia() {
        if (instanciaRep == null) {
            instanciaRep = new AlunoController();
        }
        return instanciaRep;
    }

    public void inserir(Aluno aluno, ArrayList<Aula> al) throws Exception {
        if (aluno.getDscNome().isEmpty() || aluno.getDscNome() == null) {
            throw new Exception("Nome do Aluno inválido");
        }
        aluno.setDscCPF(aluno.getDscCPF().replace("-", "").replace(".", "").replace("_", ""));
        if (aluno.getDscCPF().isEmpty() || aluno.getDscCPF().equals("") || !Utils.validarCPF(aluno.getDscCPF())) {
            throw new Exception("CPF inválido");
        }

        if (aluno.getDtDataNasc() == null) {
            throw new Exception("Data inválida");
        }
        if (aluno.getDscEndereco().isEmpty()) {
            throw new Exception("Campo Endereço inválido");
        }
        if (aluno.getNunNumero() == null) {
            throw new Exception("Campo número inválido");
        }
        if (aluno.getDscComplemento().isEmpty()) {
            throw new Exception("Campo complemento inválido");
        }
        if (aluno.getDscBairro().isEmpty()) {
            throw new Exception("Campo Bairro inválido");
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

        aluno.setTelefone(aluno.getTelefone().replace("(", "").replace(")", "").replace("-", "").replace("_", "").replace(" ", ""));

        if (aluno.getTelefone().isEmpty() || aluno.getTelefone().equals("")) {
            throw new Exception("Telefone inválido");
        }

        AlunoDAO.obterInstancia().inserir(aluno);
        inserirAulas(al, codigoUltimoAluno(), false);

    }

    public int codigoUltimoAluno() {
        return AlunoDAO.obterInstancia().codigoUltimoAluno();
    }

    public void alterar(Aluno aluno, ArrayList<Aula> al) throws Exception {
        if (aluno.getDscNome().isEmpty() || aluno.getDscNome() == null) {
            throw new Exception("Nome do Aluno inválido");
        }
        aluno.setDscCPF(aluno.getDscCPF().replace("-", "").replace(".", "").replace("_", ""));
        if (aluno.getDscCPF().isEmpty() || aluno.getDscCPF().equals("") || !Utils.validarCPF(aluno.getDscCPF())) {
            throw new Exception("CPF inválido");
        }

        if (aluno.getDtDataNasc() == null) {
            throw new Exception("Data inválida");
        }
        if (aluno.getDscEndereco().isEmpty()) {
            throw new Exception("Campo Endereço inválido");
        }
        if (aluno.getNunNumero() == null) {
            throw new Exception("Campo número inválido");
        }
        if (aluno.getDscComplemento().isEmpty()) {
            throw new Exception("Campo complemento inválido");
        }
        if (aluno.getDscBairro().isEmpty()) {
            throw new Exception("Campo Bairro inválido");
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
        aluno.setTelefone(aluno.getTelefone().replace("(", "").replace(")", "").replace("-", "").replace("_", "").replace(" ", ""));

        if (aluno.getTelefone().isEmpty() || aluno.getTelefone().equals("")) {
            throw new Exception("Telefone inválido");
        }

        AlunoDAO.obterInstancia().alterar(aluno);
        inserirAulas(al, aluno.getId(), true);
    }

    public ArrayList<Aula> listarTodasAulasPorAluno(int idAluno) {
        return AlunoDAO.obterInstancia().listarTodasAulasPorAluno(idAluno);
    }

    public ArrayList<Aluno> listarTodos() {
        return AlunoDAO.obterInstancia().listarTodos();
    }

    public ArrayList<Aluno> getAlunoPesquisa(String coluna, String paramentro, Integer status) {
        if (status == 1) {
            return AlunoDAO.obterInstancia().listarPesquisaAtivos(coluna, paramentro, status);
        } else {
            return AlunoDAO.obterInstancia().listarPesquisa(coluna, paramentro);
        }
    }

    public void inserirAulas(ArrayList<Aula> aulas, int idAluno, boolean alterar) throws Exception {
        if (alterar) {
            AlunoDAO.obterInstancia().deletarAula(idAluno);
        }
        for (Aula al : aulas) {
            AlunoAula alunoAula = new AlunoAula(idAluno, al.getIdAula());
            AlunoDAO.obterInstancia().inserirAula(alunoAula);
        }
    }

}
