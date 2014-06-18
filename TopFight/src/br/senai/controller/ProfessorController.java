package br.senai.controller;

import br.senai.DAO.ProfessorDAO;
import br.senai.model.Professor;
import br.senai.view.CadastroAulaUI;
import br.senai.view.ConsultaProfessorUI;
import br.senai.view.FormPrincipal;
import java.util.ArrayList;

public class ProfessorController {

    private static ProfessorController instanciaRep;
    ProfessorDAO profDAO;
    CadastroAulaUI cadastroAulaUI;
    ConsultaProfessorUI consultaProfessorUI;

    public static ProfessorController obterInstancia() {
        if (instanciaRep == null) {
            instanciaRep = new ProfessorController();
        }
        return instanciaRep;
    }
    public void buscaProfessor(CadastroAulaUI cA){
        cadastroAulaUI = cA;
        consultaProfessorUI = new ConsultaProfessorUI(true);
        consultaProfessorUI.setVisible(true);
        FormPrincipal.getPainelPrincipal().add(consultaProfessorUI);
    }
    public void preencheFormAula(Professor prof){
        cadastroAulaUI.recebeProfessor(prof);
    }

    public void inserir(Professor professor) throws Exception {
        if (professor.getDscNome().isEmpty()) {
            throw new Exception("Nome do Aluno inválido");
        }
        if (professor.getDscCPF().isEmpty()) {
            throw new Exception("CPF inválido");
        }
        if (professor.getSexo() != 1 || professor.getSexo() != 2) {
            throw new Exception("Sexo inválido");
        }
        if (professor.getDtDataNasc() == null) {
            throw new Exception("Data inválida");
        }
        if (professor.getNunNumero() == null) {
            throw new Exception("Telefone inválido");
        }
        if (professor.getDscEmail().isEmpty()) {
            throw new Exception("E-mail inválido");
        }
        // falta o if de status e de aula 

        ProfessorDAO.obterInstancia().inserir(professor);
    }

    public ArrayList<Professor> listarTodos() {
        return ProfessorDAO.obterInstancia().listarTodos();
    }

    public void alterar(Professor professor) throws Exception {
        if (professor == null) {
            throw new Exception("Selecione um cliente.");
        }
        if (professor.getDscNome().isEmpty()) {
            throw new Exception("Preencha o nome do Aluno");
        }
        if (professor.getDscCPF().isEmpty()) {
            throw new Exception("Preencha o CPF do cliente.");
        }
        ProfessorDAO.obterInstancia().alterar(professor);
    }

    public ArrayList<Professor> getProfPesquisa(String coluna, String paramentro, Integer status) {
        profDAO = new ProfessorDAO();
        if (status == 1) {
            return profDAO.listarPesquisaAtivos(coluna, paramentro, status);
        } else {
            return profDAO.listarPesquisa(coluna, paramentro);
        }

    }
}
