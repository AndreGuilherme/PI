package br.senai.DAO;

import br.senai.model.Aula;
import br.senai.model.Professor;
import br.senai.util.ConexaoSingleton;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class AulaDAO {

    private ArrayList<Aula> listaAluno;
    private static AulaDAO instanciaRep;
    private ConexaoSingleton con;
    private Professor professor;

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

    public boolean insertAula(Aula aula) {
        Aula aulaInsert = (Aula) aula;

        try {
            String sql = "INSERT INTO aula (id_Professor, inicio, fim, DiaSemana, Status, numAlunos) VALUES "
                    + "(?, ?, ?, ?, ?, ?);";
            PreparedStatement stmt = con.getConnection().prepareStatement(sql);
            stmt.setInt(1, aulaInsert.getProfessor().getNumIdProfessor());
            stmt.setTime(2, aulaInsert.gethInicio());
            stmt.setTime(3, aulaInsert.gethFim());
            stmt.setInt(4, aulaInsert.getDiaSemana());
            stmt.setInt(5, aulaInsert.getStatus());
            stmt.setInt(6, aulaInsert.getNumeroAlunos());
            stmt.execute();
            stmt.close();
            return true;
        } catch (SQLException e) {
            System.out.println("Erro no insere Pessoa: " + e.toString());
            JOptionPane.showMessageDialog(null, "CPF ou CNPJ ja existe na base, consulte o cliente!", "Erro", JOptionPane.INFORMATION_MESSAGE);
            return false;

        }
    }

    public boolean ValidaHorarioAulas(Time hInicio, Time hFim, Integer numIdProfessor, int diaSemana) {
        try {
            Statement st = ConexaoSingleton.getConnection().createStatement();
            String sql = "select * from Aula AS a \n"
                    + " JOIN Professor p "
                    + "ON a.Id_Professor = p.Id_Professor \n"
                    + "where ((" + "'" + hInicio + "'" + " BETWEEN inicio AND fim) OR (" + "'" + hFim + "'" + " BETWEEN inicio AND fim))\n"
                    + "AND a.id_Professor = " + numIdProfessor + " \n"
                    + "AND DiaSemana = " + diaSemana + ";";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Aula aula = new Aula();
                Professor prof = new Professor();
                Statement execProf = con.getConnection().createStatement();
                String sqlProf = "select * from Professor where id_Professor = " + rs.getInt("id_Professor") + ";";
                ResultSet resultProf = execProf.executeQuery(sqlProf);
                while (resultProf.next()) {
                    prof.setNumIdProfessor(rs.getInt("id_Professor"));
                    prof.setNumIdPessoa(rs.getInt("id_Pessoa"));
                }
                aula.setProfessor(prof);
                aula.sethInicio(rs.getTime("inicio"));
                aula.sethFim(rs.getTime("fim"));
                aula.setDiaSemana(rs.getInt("DiaSemana"));
                aula.setStatus(rs.getInt("status"));
                aula.setNumeroAlunos(rs.getInt("numAlunos"));

                return false;
            }
            st.close();
            return true;
        } catch (SQLException e) {
            System.out.println("Erro ao validar horas: " + e.toString());
            return false;
        }
    }
}
