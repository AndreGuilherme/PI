package br.senai.controller;

import br.senai.DAO.AulaDAO;
import br.senai.model.Professor;
import br.senai.view.CadastroAulaUI;
import java.sql.Time;
import java.text.ParseException;

public class AulaController {

    CadastroAulaUI aulaView;
    AulaDAO aulaDAO;
    br.senai.model.Aula aulaInsert;
    Professor prof;

    public void Salvar() throws ParseException {

        int dia = aulaView.getDiaSemana();
        Time hsInicio = aulaView.getHoraInicio();
        Time hsFinal = aulaView.getHoraFinal();
        int qntAlunos = aulaView.getQntAlunos();
        int isActive = aulaView.getIsActive();
        int idProf = 1;

        aulaInsert.setDiaSemana(dia);
        aulaInsert.sethInicio(hsInicio);
        aulaInsert.sethFim(hsFinal);
        aulaInsert.setNumeroAlunos(qntAlunos);
        aulaInsert.setStatus(isActive);
        aulaInsert.setProfessor(prof);

        aulaDAO.Inserir(aulaInsert);
    }

    private void validateAula() throws ParseException {

    }
}
