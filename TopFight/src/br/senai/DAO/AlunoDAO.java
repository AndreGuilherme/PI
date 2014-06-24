package br.senai.DAO;

import br.senai.model.Aluno;
import br.senai.model.AlunoAula;
import br.senai.model.Aula;
import br.senai.model.Professor;
import br.senai.util.ConexaoSingleton;
import br.senai.util.Utils;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class AlunoDAO {

    private ArrayList<Aluno> listaAluno;
    private static AlunoDAO instanciaRep;
    private ConexaoSingleton con;
    private Utils utils;

    /*SINGLETON*/
    public static AlunoDAO obterInstancia() {
        if (instanciaRep == null) {
            instanciaRep = new AlunoDAO();
        }
        return instanciaRep;
    }

    public AlunoDAO() {
        this.listaAluno = new ArrayList<>();
        con = new ConexaoSingleton();
    }

    public void inserirAula(AlunoAula alunoAula) {
        try {
            String queryPessoa = "INSERT INTO aulaaluno (id_Aluno, id_Aula) VALUES (?, ?);";
            PreparedStatement pst = con.getConnection().prepareStatement(queryPessoa);

            pst.setInt(1, alunoAula.getNumIdAluno());
            pst.setInt(2, alunoAula.getNumIdAula());
            pst.execute();
            con.closeConnection();
            pst.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void inserir(Aluno aluno) {
        try {
            utils = new Utils();
            SimpleDateFormat formatador = new SimpleDateFormat("yyyy-MM-dd");
            //Query para inserir Pessoa            
            String queryPessoa = "INSERT INTO pessoa (dsc_CPF, dsc_Nome, dt_DataNasc, dsc_Endereco, nun_Numero, \n"
                    + "dsc_Bairro, dsc_CEP, dsc_Complemento, Sexo, dsc_Email, dsc_Observacao, Status, dsc_Telefone) VALUES \n"
                    + "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
            //Query para inserir Aluno
            String queryAluno = "INSERT INTO aluno (id_Pessoa, Peso, Altura) VALUES ( ?, ?, ?);";

            //Execução Query Pessoa 
            PreparedStatement pstPessoa = con.getConnection().prepareStatement(queryPessoa);
            pstPessoa.setString(1, aluno.getDscCPF());
            pstPessoa.setString(2, aluno.getDscNome());
            pstPessoa.setString(3, formatador.format(aluno.getDtDataNasc()));
            pstPessoa.setString(4, aluno.getDscEndereco());
            pstPessoa.setString(5, aluno.getNunNumero().toString());
            pstPessoa.setString(6, aluno.getDscBairro());
            pstPessoa.setString(7, aluno.getDscCEP());
            pstPessoa.setString(8, aluno.getDscComplemento());
            pstPessoa.setString(9, aluno.getSexo().toString());
            pstPessoa.setString(10, aluno.getDscEmail());
            pstPessoa.setString(11, aluno.getDscObservacao());
            pstPessoa.setString(12, aluno.getStatus().toString());
            pstPessoa.setString(13, aluno.getTelefone().toString());
            pstPessoa.execute();
            //Inserindo o Id da Pessoa para o Aluno
            aluno.setNumIdPessoa(utils.codigoUltimoPessoa());
            //Execução Query Pessoa
            PreparedStatement pstAluno = con.getConnection().prepareStatement(queryAluno);
            pstAluno.setString(1, aluno.getNumIdPessoa().toString());
            pstAluno.setString(2, aluno.getPeso().toString());
            pstAluno.setString(3, aluno.getAltura().toString());
            pstAluno.execute();

            con.closeConnection();
            pstAluno.close();
            pstPessoa.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public int codigoUltimoAluno() {
        try {
            Statement executorSQL = con.getConnection().createStatement();
            String sql = "SELECT MAX(Id_Aluno) as Id_Aluno  FROM Aluno;";
            ResultSet resultado = executorSQL.executeQuery(sql);
            int id_pessoa = 0;
            while (resultado.next()) {
                id_pessoa = resultado.getInt("id_Aluno");
            }
            executorSQL.close();
            return id_pessoa;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao Localizar ultimo aluno");
            return 0;
        }
    }

    public ArrayList<Aluno> listarTodos() {
        this.listaAluno = new ArrayList<>();
        try {
            Statement st = con.getConnection().createStatement();
            String query = "SELECT p.*, a.id_Aluno, a.Peso, a.Altura FROM pessoa p \n"
                    + "JOIN aluno a ON\n"
                    + "a.id_Pessoa = p.id_Pessoa;";
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                Aluno a = new Aluno();
                a.setNumId(rs.getInt("id_Aluno"));
                a.setDscNome(rs.getString("dsc_Nome"));
                a.setDscCPF(rs.getString("dsc_CPF"));
                a.setDtDataNasc(rs.getDate("dt_DataNasc"));
                a.setDscEndereco(rs.getString("dsc_Endereco"));
                a.setNunNumero(rs.getInt("nun_Numero"));
                a.setDscBairro(rs.getString("dsc_Bairro"));
                a.setDscCEP(rs.getString("dsc_CEP"));
                a.setDscComplemento(rs.getString("dsc_Complemento"));
                a.setDscObservacao(rs.getString("dsc_Observacao"));
                a.setTelefone(rs.getString("dsc_Telefone"));
                a.setSexo(rs.getInt("Sexo"));
                a.setDscEmail(rs.getString("dsc_Email"));
                a.setStatus(rs.getInt("Status"));
                a.setPeso(rs.getDouble("Peso"));
                a.setAltura(rs.getDouble("Altura"));
                a.setNumIdPessoa(rs.getInt("id_Pessoa"));
                this.listaAluno.add(a);
            }
            rs.close();
            con.closeConnection();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return this.listaAluno;
    }

    public ArrayList<Aula> listarTodasAulasPorAluno(int idAluno) {
        ArrayList<Aula> listaAula = new ArrayList<Aula>();
        try {
            Statement st = con.getConnection().createStatement();
            String query = "SELECT * FROM aulaaluno al\n"
                    + "JOIN aula a ON\n"
                    + "a.id_Aula = al.id_Aula\n"
                    + "WHERE id_Aluno = "+ idAluno + ";";
            ResultSet rs = st.executeQuery(query);
              while (rs.next()) {
                Aula a = new Aula();
                a.setIdAula(rs.getInt("id_Aula"));
                a.sethInicio(rs.getTime("inicio"));
                a.sethFim(rs.getTime("fim"));
                a.setDiaSemana(rs.getInt("DiaSemana"));
                a.setStatus(rs.getInt("Status"));
                a.setNumeroAlunos(rs.getInt("numAlunos"));

                Professor prof = new Professor();
                Statement stm = con.getConnection().createStatement();
                String queryProf = "SELECT p.* , f.id_Professor "
                        + "FROM pessoa p \n"
                        + "JOIN professor f ON \n"
                        + "f.id_Pessoa = p.id_Pessoa "
                        + "WHERE f.Id_Professor =" + rs.getInt("Id_Professor") + ";";
                ResultSet rss = stm.executeQuery(queryProf);
                while (rss.next()) {
                    prof.setNumIdProfessor(rss.getInt("id_Professor"));
                    prof.setDscNome(rss.getString("dsc_Nome"));
                    prof.setDscCPF(rss.getString("dsc_CPF"));
                    prof.setDtDataNasc(rss.getDate("dt_DataNasc"));
                    prof.setDscEndereco(rss.getString("dsc_Endereco"));
                    prof.setNunNumero(rss.getInt("nun_Numero"));
                    prof.setDscBairro(rss.getString("dsc_Bairro"));
                    prof.setDscCEP(rss.getString("dsc_CEP"));
                    prof.setDscComplemento(rss.getString("dsc_Complemento"));
                    prof.setSexo(rss.getInt("Sexo"));
                    prof.setDscEmail(rss.getString("dsc_Email"));
                    prof.setDscObservacao(rss.getString("dsc_Observacao"));
                    prof.setStatus(rss.getInt("Status"));
                    prof.setTelefone(rss.getString("dsc_Telefone"));
                    prof.setNumIdPessoa(rss.getInt("id_Pessoa"));
                }
                a.setProfessor(prof);
                rss.close();
                listaAula.add(a);
            }
            rs.close();
            con.closeConnection();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listaAula;
    }

    public void alterar(Aluno aluno) {
        SimpleDateFormat formatador = new SimpleDateFormat("yyyy-MM-dd");
        try {
            String query = "update Pessoa AS p\n"
                    + " JOIN aluno AS a  \n"
                    + " ON p.id_Pessoa = a.id_Pessoa  \n"
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
                    + "p.dsc_Telefone = ?, \n"
                    + "a.Peso = ?, "
                    + "a.Altura = ? \n"
                    + "WHERE p.id_Pessoa = ?; ";
            PreparedStatement st = con.getConnection().prepareStatement(query);
            st.setString(1, aluno.getDscCPF());
            st.setString(2, aluno.getDscNome());
            st.setString(3, formatador.format(aluno.getDtDataNasc()));
            st.setString(4, aluno.getDscEndereco());
            st.setString(5, aluno.getNunNumero().toString());
            st.setString(6, aluno.getDscBairro());
            st.setString(7, aluno.getDscCEP());
            st.setString(8, aluno.getDscComplemento());
            st.setString(9, aluno.getSexo().toString());
            st.setString(10, aluno.getDscEmail());
            st.setString(11, aluno.getDscObservacao());
            st.setString(12, aluno.getStatus().toString());
            st.setString(13, aluno.getTelefone());
            st.setString(14, aluno.getPeso().toString());
            st.setString(15, aluno.getAltura().toString());
            st.setString(16, aluno.getNumIdPessoa().toString());
            //st.setInt(3, aluno.getId());
            st.executeUpdate();
            st.close();
            con.closeConnection();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public ArrayList<Aluno> listarPesquisaAtivos(String coluna, String paramentro, Integer status) {
        try {
            this.listaAluno = new ArrayList<>();
            Statement execSql = con.getConnection().createStatement();
            String sql = "select * from Pessoa AS p \n"
                    + " JOIN Aluno AS a \n"
                    + " ON p.Id_Pessoa = a.Id_pessoa \n"
                    + " where " + coluna + " like '%" + paramentro + "%' \n"
                    + " AND Status = " + status + ";";
            ResultSet rs = execSql.executeQuery(sql);
            while (rs.next()) {
                Aluno a = new Aluno();
                a.setNumId(rs.getInt("id_Aluno"));
                a.setDscNome(rs.getString("dsc_Nome"));
                a.setDscCPF(rs.getString("dsc_CPF"));
                a.setDtDataNasc(rs.getDate("dt_DataNasc"));
                a.setDscEndereco(rs.getString("dsc_Endereco"));
                a.setNunNumero(rs.getInt("nun_Numero"));
                a.setDscBairro(rs.getString("dsc_Bairro"));
                a.setDscCEP(rs.getString("dsc_CEP"));
                a.setDscComplemento(rs.getString("dsc_Complemento"));
                a.setDscObservacao(rs.getString("dsc_Observacao"));
                a.setTelefone(rs.getString("dsc_Telefone"));
                a.setSexo(rs.getInt("Sexo"));
                a.setDscEmail(rs.getString("dsc_Email"));
                a.setStatus(rs.getInt("Status"));
                a.setPeso(rs.getDouble("Peso"));
                a.setAltura(rs.getDouble("Altura"));
                a.setNumIdPessoa(rs.getInt("id_Pessoa"));
                this.listaAluno.add(a);
            }
            rs.close();
            con.closeConnection();
        } catch (SQLException e) {
            System.out.println("Erro na Pesquisa de Professores: " + e.getMessage());
        }
        return this.listaAluno;
    }

    public ArrayList<Aluno> listarPesquisa(String coluna, String paramentro) {
        try {
            this.listaAluno = new ArrayList<>();
            Statement execSql = con.getConnection().createStatement();
            String sql = "select * from Pessoa AS p \n"
                    + " JOIN Aluno AS a \n"
                    + " ON p.Id_Pessoa = a.Id_pessoa \n"
                    + " where " + coluna + " like '%" + paramentro + "%';";
            ResultSet rs = execSql.executeQuery(sql);
            while (rs.next()) {
                Aluno a = new Aluno();
                a.setNumId(rs.getInt("id_Aluno"));
                a.setDscNome(rs.getString("dsc_Nome"));
                a.setDscCPF(rs.getString("dsc_CPF"));
                a.setDtDataNasc(rs.getDate("dt_DataNasc"));
                a.setDscEndereco(rs.getString("dsc_Endereco"));
                a.setNunNumero(rs.getInt("nun_Numero"));
                a.setDscBairro(rs.getString("dsc_Bairro"));
                a.setDscCEP(rs.getString("dsc_CEP"));
                a.setDscComplemento(rs.getString("dsc_Complemento"));
                a.setDscObservacao(rs.getString("dsc_Observacao"));
                a.setTelefone(rs.getString("dsc_Telefone"));
                a.setSexo(rs.getInt("Sexo"));
                a.setDscEmail(rs.getString("dsc_Email"));
                a.setStatus(rs.getInt("Status"));
                a.setPeso(rs.getDouble("Peso"));
                a.setAltura(rs.getDouble("Altura"));
                a.setNumIdPessoa(rs.getInt("id_Pessoa"));
                this.listaAluno.add(a);
            }
            rs.close();
            con.closeConnection();
        } catch (SQLException e) {
            System.out.println("Erro na Pesquisa de Professores: " + e.getMessage());
        }
        return this.listaAluno;
    }

    public void deletarAula(int aluno) {
        try {
            String queryPessoa = "DELETE FROM aulaaluno WHERE id_Aluno = ?;";
            PreparedStatement pst = con.getConnection().prepareStatement(queryPessoa);
            pst.setInt(1, aluno);
            pst.executeUpdate();
            con.closeConnection();
            pst.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}

//
//    public void remover(Cliente cliente) throws Exception {
//        try {
//            String query = "DELETE FROM CLIENTE WHERE id = ?";
//            PreparedStatement st = con.getConnection().prepareStatement(query);
//            st.setInt(1, cliente.getId());
//            st.executeUpdate();
//
//            con.closeConnection();
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
//    }
//
//    public Integer verificaExistencia(Cliente cliente) {
//        for (int i = 0; i < this.listaAluno.size(); i++) {
//            if (this.listaAluno.get(i).equals(cliente)) {
//                return i;
//            }
//        }
//        return null;
//    }

