package br.senai.controller;

import br.senai.DAO.AulaDAO;
import br.senai.model.Aula;
import br.senai.view.CadastroAlunoUI;
import br.senai.view.ConsultaAulaUI;
import br.senai.view.FormPrincipal;
import java.util.ArrayList;

public class AulaController {

    private static AulaController instanciaRep;
    CadastroAlunoUI alunoView;
    ConsultaAulaUI consultaAula;
//    AulaDAO aulaDAO;
//    Aula aulaInsert;
//    Professor prof;

    public static AulaController obterInstancia() {
        if (instanciaRep == null) {
            instanciaRep = new AulaController();
        }
        return instanciaRep;
    }

    public void inserir(Aula aula) throws Exception {
        if (aula.getDiaSemana() == 0) {
            throw new Exception("Dia da semana invalido!");
        }
        if (aula.gethInicio() == null) {
            throw new Exception("Hora Inicio Invalido!");
        }
        if (aula.gethFim() == null) {
            throw new Exception("Hora Fim Invalida!");
        }
        if (aula.getProfessor() == null) {
            throw new Exception("Selecione um Professor");
        }
        if (aula.getNumeroAlunos() < 10) {
            throw new Exception("Precisa de no mínimo 10 alunos");
        }

        long diferencaTempo = ((aula.gethFim().getTime() - aula.gethInicio().getTime()) / (Tempo.MINUTE_IN_MILLIS.getValue()));
        if (diferencaTempo < 30) {
            throw new Exception("Tempo minimo de aula é de 30 minutos. \n Favor ajustar.");
        }

        if (!AulaDAO.obterInstancia().ValidaHorarioAulas(aula)) {
            throw new Exception("Professor " + aula.getProfessor().getDscNome() + ", já possiu uma aula cadastrada nesse dia e horário.");
        }
        AulaDAO.obterInstancia().insertAula(aula);
    }

    public void buscaAulas(CadastroAlunoUI cadAluno) {
        alunoView = cadAluno;
        consultaAula = new ConsultaAulaUI(true);
        consultaAula.setVisible(true);
        FormPrincipal.getPainelPrincipal().add(consultaAula);
    }

    public void preencheFormAluno(Aula aula) {
        alunoView.recebeAula(aula);
    }

    public ArrayList<Aula> listarTodos() {
       return AulaDAO.obterInstancia().listarTodos();
    }

    public enum Tempo {

        SECOND_IN_MILLIS(1000),
        MINUTE_IN_MILLIS(60000),
        HOUR_IN_MILLIS(3600000),
        DAY_IN_MILLIS(86400000),
        WEEK_IN_MILLIS(604800000);

        private int unit;

        Tempo(int unit) {
            this.unit = unit;
        }

        public int getValue() {
            return unit;
        }
    }

}
