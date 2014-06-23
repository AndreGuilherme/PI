package br.senai.DAO;

import br.senai.util.ConexaoSingleton;
import br.senai.model.Professor;
import br.senai.util.Utils;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class ProfessorDAO {

    private ArrayList<Professor> listaProfessor;
    private static ProfessorDAO instanciaRep;
    private ConexaoSingleton con;
    private Utils utils;

    public static ProfessorDAO obterInstancia() {
        if (instanciaRep == null) {
            instanciaRep = new ProfessorDAO();
        }
        return instanciaRep;
    }

    public ProfessorDAO() {
        this.listaProfessor = new ArrayList<>();
        con = new ConexaoSingleton();
    }

    public void inserir(Professor professor) {
        try {
            utils = new Utils();
            SimpleDateFormat formatador = new SimpleDateFormat("yyyy-MM-dd");
            //Query para inserir Pessoa
            String queryPessoa = "INSERT INTO pessoa (dsc_CPF, dsc_Nome, dt_DataNasc, dsc_Endereco, nun_Numero, \n"
                    + "dsc_Bairro, dsc_CEP, dsc_Complemento, Sexo, dsc_Email, dsc_Observacao, Status, dsc_Telefone) VALUES \n"
                    + "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
            //Query para inserir Aluno
            String queryProfessor = "INSERT INTO professor (id_Pessoa) VALUES ( ? );";

            //Execução Query Pessoa 
            PreparedStatement pstPessoa = con.getConnection().prepareStatement(queryPessoa);
            pstPessoa.setString(1, professor.getDscCPF());
            pstPessoa.setString(2, professor.getDscNome());
            pstPessoa.setString(3, formatador.format(professor.getDtDataNasc()));
            pstPessoa.setString(4, professor.getDscEndereco());
            pstPessoa.setString(5, professor.getNunNumero().toString());
            pstPessoa.setString(6, professor.getDscBairro());
            pstPessoa.setString(7, professor.getDscCEP());
            pstPessoa.setString(8, professor.getDscComplemento());
            pstPessoa.setString(9, professor.getSexo().toString());
            pstPessoa.setString(10, professor.getDscEmail());
            pstPessoa.setString(11, professor.getDscObservacao());
            pstPessoa.setString(12, professor.getStatus().toString());
            pstPessoa.setString(13, professor.getTelefone());
            pstPessoa.execute();
            //Inserindo o Id da Pessoa para o Aluno
            professor.setNumIdPessoa(utils.codigoUltimoPessoa());
            //Execução Query Pessoa
            PreparedStatement pstProfessor = con.getConnection().prepareStatement(queryProfessor);
            pstProfessor.setString(1, professor.getNumIdPessoa().toString());

            pstProfessor.execute();
            con.closeConnection();
            pstProfessor.close();
            pstPessoa.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public ArrayList<Professor> listarTodos() {
        this.listaProfessor = new ArrayList<>();
        try {
            Statement st = con.getConnection().createStatement();
            String query = "SELECT p.* , f.id_Professor"
                    + " FROM pessoa p \n"
                    + "JOIN professor f ON\n"
                    + "f.id_Pessoa = p.id_Pessoa;";
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                Professor f = new Professor();
                f.setNumIdProfessor(rs.getInt("id_Professor"));
                f.setDscNome(rs.getString("dsc_Nome"));
                f.setDscCPF(rs.getString("dsc_CPF"));
                f.setDtDataNasc(rs.getDate("dt_DataNasc"));
                f.setDscEndereco(rs.getString("dsc_Endereco"));
                f.setNunNumero(rs.getInt("nun_Numero"));
                f.setDscBairro(rs.getString("dsc_Bairro"));
                f.setDscCEP(rs.getString("dsc_CEP"));
                f.setDscComplemento(rs.getString("dsc_Complemento"));
                f.setSexo(rs.getInt("Sexo"));
                f.setDscEmail(rs.getString("dsc_Email"));
                f.setDscObservacao(rs.getString("dsc_Observacao"));
                f.setStatus(rs.getInt("Status"));
                f.setTelefone(rs.getString("dsc_Telefone"));

                f.setNumIdPessoa(rs.getInt("id_Pessoa"));
                this.listaProfessor.add(f);
            }
            rs.close();
            con.closeConnection();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return this.listaProfessor;
    }

    public Professor obtemProfessor(int id) {
        try {
            Statement st = ConexaoSingleton.getConnection().createStatement();
            String sql = "SELECT * FROM Professor where id_Professor = " + id + ";";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Professor p = new Professor();
                p.setNumIdProfessor(rs.getInt("id_Professor"));
                p.setNumIdPessoa(rs.getInt("id_Pessoa"));
                return p;
            }
            st.close();
            return null;
        } catch (SQLException e) {
            return null;
        }
    }

    public void alterar(Professor professor) {
        try {
            SimpleDateFormat formatador = new SimpleDateFormat("yyyy-MM-dd");
            //Query para update pessoa;
            String queryPessoa = "UPDATE Pessoa AS p "
                    + "SET  \n"
                    + "p.dsc_CPF = ?, \n"
                    + "p.dsc_Nome = ?, \n"
                    + "p.dt_DataNasc = ?, \n"
                    + "p.dsc_Endereco = ?, \n"
                    + "p.nun_Numero = ?,  \n"
                    + "p.dsc_Bairro = ?, \n"
                    + "p.dsc_CEP = ?, \n"
                    + "p.dsc_Complemento = ?, \n"
                    + "p.sexo = ?, \n"
                    + "p.dsc_Email = ?, \n"
                    + "p.dsc_Observacao = ?,  \n"
                    + "p.Status = ?,\n"
                    + "p.dsc_Telefone = ? \n"
                    + "WHERE p.id_Pessoa = ?; ";

            //Execução Query Pessoa 
            PreparedStatement pstPessoa = con.getConnection().prepareStatement(queryPessoa);
            pstPessoa.setString(1, professor.getDscCPF());
            pstPessoa.setString(2, professor.getDscNome());
            pstPessoa.setString(3, formatador.format(professor.getDtDataNasc()));
            pstPessoa.setString(4, professor.getDscEndereco());
            pstPessoa.setString(5, professor.getNunNumero().toString());
            pstPessoa.setString(6, professor.getDscBairro());
            pstPessoa.setString(7, professor.getDscCEP());
            pstPessoa.setString(8, professor.getDscComplemento());
            pstPessoa.setString(9, professor.getSexo().toString());
            pstPessoa.setString(10, professor.getDscEmail());
            pstPessoa.setString(11, professor.getDscObservacao());
            pstPessoa.setString(12, professor.getStatus().toString());
            pstPessoa.setString(13, professor.getTelefone().toString());
            pstPessoa.setString(14, professor.getNumIdPessoa().toString());

            pstPessoa.executeUpdate();

            con.closeConnection();
            pstPessoa.close();
            con.closeConnection();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    public ArrayList<Professor> listarPesquisaAtivos(String coluna, String paramentro, Integer status) {
        try {
            this.listaProfessor = new ArrayList<>();
            Statement execSql = con.getConnection().createStatement();
            String sql = "select * from Pessoa AS p \n"
                    + " JOIN Professor AS pr \n"
                    + " ON p.Id_Pessoa = pr.Id_pessoa \n"
                    + " where " + coluna + " like '%" + paramentro + "%' \n"
                    + " AND Status = " + status + ";";
            ResultSet resultado = execSql.executeQuery(sql);
            while (resultado.next()) {
                Professor f = new Professor();
                f.setNumIdProfessor(resultado.getInt("id_Professor"));
                f.setDscNome(resultado.getString("dsc_Nome"));
                f.setDscCPF(resultado.getString("dsc_CPF"));
                f.setDtDataNasc(resultado.getDate("dt_DataNasc"));
                f.setDscEndereco(resultado.getString("dsc_Endereco"));
                f.setNunNumero(resultado.getInt("nun_Numero"));
                f.setDscBairro(resultado.getString("dsc_Bairro"));
                f.setDscCEP(resultado.getString("dsc_CEP"));
                f.setDscComplemento(resultado.getString("dsc_Complemento"));
                f.setSexo(resultado.getInt("Sexo"));
                f.setDscEmail(resultado.getString("dsc_Email"));
                f.setStatus(resultado.getInt("Status"));
                f.setDscObservacao(resultado.getString("dsc_Observacao"));
                f.setTelefone(resultado.getString("dsc_Telefone"));

                f.setNumIdPessoa(resultado.getInt("id_Pessoa"));
                this.listaProfessor.add(f);
            }
            resultado.close();
            con.closeConnection();
        } catch (SQLException e) {
            System.out.println("Erro na Pesquisa de Professores: " + e.getMessage());
        }
        return this.listaProfessor;
    }

    public ArrayList<Professor> listarPesquisa(String coluna, String paramentro) {
        try {
            this.listaProfessor = new ArrayList<>();
            Statement execSql = con.getConnection().createStatement();
            String sql = "select * from Pessoa AS p \n"
                    + " JOIN Professor AS pr \n"
                    + " ON p.Id_Pessoa = pr.Id_pessoa "
                    + " where " + coluna + " like '%" + paramentro + "%';";
            ResultSet resultado = execSql.executeQuery(sql);
            while (resultado.next()) {
                Professor f = new Professor();
                f.setNumIdProfessor(resultado.getInt("id_Professor"));
                f.setDscNome(resultado.getString("dsc_Nome"));
                f.setDscCPF(resultado.getString("dsc_CPF"));
                f.setDtDataNasc(resultado.getDate("dt_DataNasc"));
                f.setDscEndereco(resultado.getString("dsc_Endereco"));
                f.setNunNumero(resultado.getInt("nun_Numero"));
                f.setDscBairro(resultado.getString("dsc_Bairro"));
                f.setDscCEP(resultado.getString("dsc_CEP"));
                f.setDscComplemento(resultado.getString("dsc_Complemento"));
                f.setSexo(resultado.getInt("Sexo"));
                f.setDscEmail(resultado.getString("dsc_Email"));
                f.setStatus(resultado.getInt("Status"));
                f.setTelefone(resultado.getString("dsc_Telefone"));

                f.setNumIdPessoa(resultado.getInt("id_Pessoa"));
                this.listaProfessor.add(f);
            }
            resultado.close();
            con.closeConnection();
        } catch (SQLException e) {
            System.out.println("Erro na Pesquisa de Professores: " + e.getMessage());
        }
        return this.listaProfessor;
    }
}
