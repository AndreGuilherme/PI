package br.senai.controller;

import br.senai.DAO.ProfessorDAO;
import br.senai.model.Professor;
import br.senai.model.RelatorioProfAula;
import br.senai.util.Utils;
import br.senai.view.CadastroAulaUI;
import br.senai.view.ConsultaProfessorUI;
import br.senai.view.FormPrincipal;
import java.text.ParseException;
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

    public void buscaProfessor(CadastroAulaUI cA) {
        cadastroAulaUI = cA;
        consultaProfessorUI = new ConsultaProfessorUI(true);
        consultaProfessorUI.setVisible(true);
        FormPrincipal.getPainelPrincipal().add(consultaProfessorUI);
    }

    public void preencheFormAula(Professor prof) {
        cadastroAulaUI.recebeProfessor(prof);
    }

    public void inserir(Professor professor) throws Exception {
        if (professor.getDscNome().isEmpty() || professor.getDscNome() == null) {
            throw new Exception("Nome do Professor inválido");
        }
        professor.setDscCPF(professor.getDscCPF().replace("-", "").replace(".", "").replace("_", ""));
        if (professor.getDscCPF().isEmpty() || professor.getDscCPF().equals("") || !Utils.validarCPF(professor.getDscCPF())) {
            throw new Exception("CPF inválido");
        }
        if (professor.getDtDataNasc() == null) {
            throw new Exception("Data inválida");
        }

        if (professor.getDscEndereco().isEmpty()) {
            throw new Exception("Campo Endereço inválido");
        }
        if (professor.getNunNumero() == null) {
            throw new Exception("Campo número inválido");
        }
        if (professor.getDscComplemento().isEmpty()) {
            throw new Exception("Campo complemento inválido");
        }
        if (professor.getDscBairro().isEmpty()) {
            throw new Exception("Campo Bairro inválido");
        }

        professor.setTelefone(professor.getTelefone().replace("(", "").replace(")", "").replace("-", "").replace("_", "").replace(" ", ""));

        if (professor.getTelefone().isEmpty() || professor.getTelefone().equals("")) {
            throw new Exception("Telefone inválido");
        }
        // falta o if de status e de aula 

        ProfessorDAO.obterInstancia().inserir(professor);
    }

    public ArrayList<Professor> listarTodos() {
        return ProfessorDAO.obterInstancia().listarTodos();
    }

    public void alterar(Professor professor) throws Exception {
        if (professor.getDscNome().isEmpty() || professor.getDscNome() == null) {
            throw new Exception("Nome do Professor inválido");
        }
        professor.setDscCPF(professor.getDscCPF().replace("-", "").replace(".", "").replace("_", ""));
        if (professor.getDscCPF().isEmpty() || professor.getDscCPF().equals("") || !Utils.validarCPF(professor.getDscCPF())) {
            throw new Exception("CPF inválido");
        }
        if (professor.getDtDataNasc() == null) {
            throw new Exception("Data inválida");
        }
        if (professor.getDscEndereco().isEmpty()) {
            throw new Exception("Campo Endereço inválido");
        }
        if (professor.getNunNumero() == null) {
            throw new Exception("Campo número inválido");
        }
        if (professor.getDscComplemento().isEmpty()) {
            throw new Exception("Campo complemento inválido");
        }
        if (professor.getDscBairro().isEmpty()) {
            throw new Exception("Campo Bairro inválido");
        }
        professor.setTelefone(professor.getTelefone().replace("(", "").replace(")", "").replace("-", "").replace("_", "").replace(" ", ""));

        if (professor.getTelefone().isEmpty() || professor.getTelefone().equals("")) {
            throw new Exception("Telefone inválido");
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

    public ArrayList<RelatorioProfAula> listarRelatorioAula(String profName, String horaInicial, String horaFinal) throws ParseException {
        return ProfessorDAO.obterInstancia().listarRelatorioAula(profName, horaInicial , horaFinal);
        
    }
}
