package br.senai.controller;

import br.senai.DAO.AulaDAO;
import br.senai.model.Aula;
import br.senai.model.Professor;
import br.senai.view.CadastroAulaUI;
import java.sql.Time;
import javax.swing.JOptionPane;

public class AulaController {

    CadastroAulaUI aulaView;
    AulaDAO aulaDAO;
    Aula aulaInsert;
    Professor prof;

    public boolean Salvar(Aula aula) {
        aulaDAO = new AulaDAO();
        return aulaDAO.insertAula(aula);
    }

    public boolean ValidaInsert(Aula aula) {
        aulaDAO = new AulaDAO();
        Time hrInicio = aula.gethInicio();
        Time hrFinal = aula.gethFim();
        int idProfessor = aula.getProfessor().getNumIdProfessor();
        int diaSemana = aula.getDiaSemana();

        if (aulaDAO.ValidaHorarioAulas(hrInicio, hrFinal, idProfessor, diaSemana)) {
            System.out.println("Pode ser inserido");
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "ERRO!\n"
                    + "Professor já tem aula nesse dia e hora.", "Informação", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }

    }
}
