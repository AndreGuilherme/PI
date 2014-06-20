package br.senai.controller;

import br.senai.DAO.AulaDAO;
import br.senai.model.Aula;

public class AulaController {

    private static AulaController instanciaRep;
//    CadastroAulaUI aulaView;
//    AulaDAO aulaDAO;
//    Aula aulaInsert;
//    Professor prof;

    public static AulaController obterInstancia() {
        if (instanciaRep == null) {
            instanciaRep = new AulaController();
        }
        return instanciaRep;
    }

//    public boolean Salvar(Aula aula) {
//        aulaDAO = new AulaDAO();
//        return aulaDAO.insertAula(aula);
//    }

//    public boolean ValidaInsert(Aula aula) {
//        aulaDAO = new AulaDAO();
//        Time hrInicio = aula.gethInicio();
//        Time hrFinal = aula.gethFim();
//        int idProfessor = aula.getProfessor().getNumIdProfessor();
//        int diaSemana = aula.getDiaSemana();
//
//        if (aulaDAO.ValidaHorarioAulas(hrInicio, hrFinal, idProfessor, diaSemana)) {
//            System.out.println("Pode ser inserido");
//            return true;
//        } else {
//            JOptionPane.showMessageDialog(null, "ERRO!\n"
//                    + "Professor já tem aula nesse dia e hora.", "Informação", JOptionPane.INFORMATION_MESSAGE);
//            return false;
//        }
//
//    }

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
            throw new Exception("A aula precisa ter pelo menos 30 minutos");
        }
        
        if(!AulaDAO.obterInstancia().ValidaHorarioAulas(aula)){
            throw new Exception("Ja existe aula com esse professor cadastrada nesse horario");
        }
        AulaDAO.obterInstancia().insertAula(aula);
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
