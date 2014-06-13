package br.senai.controller;

import br.senai.view.CadastroAulaUI;
import java.text.ParseException;
import java.util.Date;

public class AulaController {

    public void Salvar(CadastroAulaUI aulaView) throws ParseException {
        int dia = aulaView.getDiaSemana();
        Date hrInicio = aulaView.getHoraInicio();
        Date hrFinal = aulaView.getHoraFinal();
    }
}
