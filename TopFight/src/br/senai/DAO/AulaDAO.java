
package br.senai.DAO;

import br.senai.model.Aula;
import br.senai.util.ConexaoSingleton;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class AulaDAO {
    private ArrayList<Aula> listaAluno;
    private static AulaDAO instanciaRep;
    private ConexaoSingleton con;

    public static AulaDAO obterInstancia() {
        if (instanciaRep == null) {
            instanciaRep = new AulaDAO();
        }
        return instanciaRep;
    }

    public AulaDAO() {
        this.listaAluno = new ArrayList<>();
        con = new ConexaoSingleton();
    }

    public void Inserir(br.senai.model.Aula aulaInsert) {
        try {
            //SimpleDateFormat formatador = new SimpleDateFormat("yyyy-MM-dd");
            //Query para inserir Pessoa
            String queryAula = "INSERT INTO `topfight`.`aula`\n"
                    + "(id_Professor, inicio, fim, DiaSemana, Status, numAlunos)\n"
                    + "VALUES \n"
                    + "(?, ?, ?, ?, ?, ?);";
            //Execução Query Pessoa 
            PreparedStatement pstAula = con.getConnection().prepareStatement(queryAula);
            pstAula.setInt(1, aulaInsert.getProfessor().getNumIdProfessor());
            pstAula.setTime(2, aulaInsert.gethInicio());
            pstAula.setTime(3, aulaInsert.gethFim());
            pstAula.setInt(4, aulaInsert.getDiaSemana());
            pstAula.setInt(5, aulaInsert.getStatus());
            pstAula.setInt(6, aulaInsert.getNumeroAlunos());
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
