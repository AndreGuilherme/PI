package br.senai.controller;

import br.senai.view.Aula;
import java.text.ParseException;
import java.util.Date;

public class AulaController {

    public void Salvar(Aula aulaView) throws ParseException {
        int dia = aulaView.getDiaSemana();
        Date hrInicio = aulaView.getHoraInicio();
        Date hrFinal = aulaView.getHoraFinal();
    }
}
