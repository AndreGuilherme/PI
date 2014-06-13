package br.senai.DAO;

import br.senai.model.Aluno;
import br.senai.util.ConexaoSingleton;
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

    public void inserir(Aluno aluno) {
        try {
            SimpleDateFormat formatador = new SimpleDateFormat("yyyy-MM-dd");
            //Query para inserir Pessoa
            String queryPessoa = "INSERT INTO pessoa (dsc_CPF, dsc_Nome, dt_DataNasc, dsc_Endereco, nun_Numero, \n"
                    + "dsc_Bairro, dsc_CEP, dsc_Complemento, Sexo, dsc_Email, dsc_Observacao, Status) VALUES \n"
                    + "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
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
            pstPessoa.execute();
            //Inserindo o Id da Pessoa para o Aluno
            aluno.setNumIdPessoa(codigoUltimoPessoa());
            //Execução Query Pessoa
            PreparedStatement pstAluno = con.getConnection().prepareStatement(queryAluno);
            pstAluno.setString(1, aluno.getNumIdPessoa().toString());
            pstAluno.setString(2, aluno.getAltura().toString());
            pstAluno.setString(3, aluno.getPeso().toString());
            pstAluno.execute();
            con.closeConnection();
            pstAluno.close();
            pstPessoa.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public int codigoUltimoPessoa() {
        try {
            Statement executorSQL = con.getConnection().createStatement();
            String sql = "SELECT * FROM pessoa where id_pessoa in (select Max(id_pessoa) from pessoa);";
            ResultSet resultado = executorSQL.executeQuery(sql);
            int id_pessoa = 0;
            while (resultado.next()) {
                id_pessoa = resultado.getInt("id_pessoa");
            }
            executorSQL.close();
            return id_pessoa;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao Localizar ultima pessoa");
            return 0;
        }
    }
    
    public Aluno obtemAluno(int id) {
        try {
            Statement executorSQL = con.getConnection().createStatement();
            String sql = "SELECT * FROM aluno where id_aluno = "+id +";";
            ResultSet rs = executorSQL.executeQuery(sql);
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
                a.setSexo(rs.getInt("Sexo"));
                a.setDscEmail(rs.getString("dsc_Email"));
                a.setStatus(rs.getInt("Status"));
                a.setPeso(rs.getDouble("Peso"));
                a.setAltura(rs.getDouble("Altura"));
                a.setNumIdPessoa(rs.getInt("id_Pessoa"));
                return a;
            }
            executorSQL.close();
            return null; 
        } catch (Exception e) {
            return null;
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
//
//    public void alterar(Cliente cliente) {
//        try {
//            String query = "update cliente set nome = ?, cpf = ? where id = ?";
//            PreparedStatement st = con.getConnection().prepareStatement(query);
//            st.setString(1, cliente.getNome());
//            st.setString(2, cliente.getCpf());
//            st.setInt(3, cliente.getId());
//            st.executeUpdate();
//
//            con.closeConnection();
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
//    }
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
}
