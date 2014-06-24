package br.senai.DAO;

import br.senai.model.Aula;
import br.senai.model.Professor;
import br.senai.util.ConexaoSingleton;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class AulaDAO {

    private static AulaDAO instanciaRep;
    private ConexaoSingleton con;
    private ArrayList<Aula> listaAula;

    public static AulaDAO obterInstancia() {
        if (instanciaRep == null) {
            instanciaRep = new AulaDAO();
        }
        return instanciaRep;
    }

    public AulaDAO() {
        this.listaAula = new ArrayList<>();
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
            return false;

        }
    }

    public boolean ValidaHorarioAulas(Aula aula) {
        try {
            Statement st = ConexaoSingleton.getConnection().createStatement();
            String sql = "select * from Aula AS a \n"
                    + " JOIN Professor p "
                    + "ON a.Id_Professor = p.Id_Professor \n"
                    + "where ((" + "'" + aula.gethInicio() + "'" + " BETWEEN inicio AND fim) OR (" + "'" + aula.gethFim() + "'" + " BETWEEN inicio AND fim))\n"
                    + "AND a.id_Professor = " + aula.getProfessor().getNumIdProfessor() + " \n"
                    + "AND DiaSemana = " + aula.getDiaSemana() + "\n"
                    + "AND a.Status = 1;";
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                st.close();
                return false;
            }
            st.close();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    public ArrayList<Aula> listarTodos() {
        this.listaAula = new ArrayList<>();
        try {
            Statement st = con.getConnection().createStatement();
            String query = "select * from Aula AS a \n"
                    + "JOIN Professor p \n"
                    + "ON a.Id_Professor = p.Id_Professor;";
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

                    prof.setNumIdPessoa(rs.getInt("id_Pessoa"));
                }
                a.setProfessor(prof);
                rss.close();
                this.listaAula.add(a);
            }
            rs.close();

            con.closeConnection();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return this.listaAula;
    }

    public ArrayList<Aula> listarPesquisaProfDiaAtivos(String nomeProf, Integer day, Integer status) {
        this.listaAula = new ArrayList<>();
        try {
            Statement st = con.getConnection().createStatement();
            String query = "select * from Aula AS a \n"
                    + "LEFT JOIN Professor p \n"
                    + "ON a.Id_Professor = p.Id_Professor \n"
                    + "LEFT JOIN Pessoa pp\n"
                    + "ON pp.id_Pessoa = p.id_Pessoa\n"
                    + "where pp.dsc_Nome like '%" + nomeProf + "%'  \n"
                    + " AND DiaSemana = " + day + "\n"
                    + " AND a.Status = " + status + ";";

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

                    prof.setNumIdPessoa(rs.getInt("id_Pessoa"));
                }
                a.setProfessor(prof);
                rss.close();
                this.listaAula.add(a);
            }
            rs.close();

            con.closeConnection();
        } catch (SQLException e) {
            System.out.println("Erro na Pesquisa de Professores: " + e.getMessage());
        }
        return this.listaAula;
    }

    public ArrayList<Aula> listarPesquisaProfDia(String nomeProf, Integer day) {
        this.listaAula = new ArrayList<>();
        try {
            Statement st = con.getConnection().createStatement();
            String query = "select * from Aula AS a \n"
                    + "LEFT JOIN Professor p \n"
                    + "ON a.Id_Professor = p.Id_Professor \n"
                    + "LEFT JOIN Pessoa pp\n"
                    + "ON pp.id_Pessoa = p.id_Pessoa\n"
                    + "where pp.dsc_Nome like '%" + nomeProf + "%'  \n"
                    + " AND DiaSemana = " + day + "\n";
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

                    prof.setNumIdPessoa(rs.getInt("id_Pessoa"));
                }
                a.setProfessor(prof);
                rss.close();
                this.listaAula.add(a);
            }
            rs.close();

            con.closeConnection();
        } catch (SQLException e) {
            System.out.println("Erro na Pesquisa de Professores: " + e.getMessage());
        }
        return this.listaAula;
    }

    public ArrayList<Aula> listarPesquisaProfAtivos(String nomeProf, Integer day, Integer status) {
        this.listaAula = new ArrayList<>();
        try {
            Statement st = con.getConnection().createStatement();
            String query = "select * from Aula AS a \n"
                    + "LEFT JOIN Professor p \n"
                    + "ON a.Id_Professor = p.Id_Professor \n"
                    + "LEFT JOIN Pessoa pp\n"
                    + "ON pp.id_Pessoa = p.id_Pessoa\n"
                    + "where  pp.dsc_Nome like '%" + nomeProf + "%' \n"
                    + " AND a.Status = " + status + ";";
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

                    prof.setNumIdPessoa(rs.getInt("id_Pessoa"));
                }
                a.setProfessor(prof);
                rss.close();
                this.listaAula.add(a);
            }
            rs.close();

            con.closeConnection();
        } catch (SQLException e) {
            System.out.println("Erro na Pesquisa de Professores: " + e.getMessage());
        }
        return this.listaAula;
    }

    public ArrayList<Aula> listarPesquisaProfInativos(String nomeProf, Integer day) {
        this.listaAula = new ArrayList<>();
        try {
            Statement st = con.getConnection().createStatement();
            String query = "select * from Aula AS a \n"
                    + "LEFT JOIN Professor p \n"
                    + "ON a.Id_Professor = p.Id_Professor \n"
                    + "LEFT JOIN Pessoa pp\n"
                    + "ON pp.id_Pessoa = p.id_Pessoa\n"
                    + "where pp.dsc_Nome like '%" + nomeProf + "%'  \n";
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

                    prof.setNumIdPessoa(rs.getInt("id_Pessoa"));
                }
                a.setProfessor(prof);
                rss.close();
                this.listaAula.add(a);
            }
            rs.close();

            con.closeConnection();
        } catch (SQLException e) {
            System.out.println("Erro na Pesquisa de Professores: " + e.getMessage());
        }
        return this.listaAula;
    }

    public ArrayList<Aula> listarPesquisaDiaAtivos(Integer day, Integer status) {
        this.listaAula = new ArrayList<>();
        try {
            Statement st = con.getConnection().createStatement();
            String query = "select * from Aula AS a \n"
                    + "LEFT JOIN Professor p \n"
                    + "ON a.Id_Professor = p.Id_Professor \n"
                    + "LEFT JOIN Pessoa pp\n"
                    + "ON pp.id_Pessoa = p.id_Pessoa\n"
                    + "where "
                    + "DiaSemana = " + day + "\n"
                    + " AND a.Status = " + status + ";";
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

                    prof.setNumIdPessoa(rs.getInt("id_Pessoa"));
                }
                a.setProfessor(prof);
                rss.close();
                this.listaAula.add(a);
            }
            rs.close();

            con.closeConnection();
        } catch (SQLException e) {
            System.out.println("Erro na Pesquisa de Professores: " + e.getMessage());
        }
        return this.listaAula;
    }

    public ArrayList<Aula> listarPesquisaDiaInativos(Integer day, Integer status) {
        this.listaAula = new ArrayList<>();
        try {
            Statement st = con.getConnection().createStatement();
            String query = "select * from Aula AS a \n"
                    + "LEFT JOIN Professor p \n"
                    + "ON a.Id_Professor = p.Id_Professor \n"
                    + "LEFT JOIN Pessoa pp\n"
                    + "ON pp.id_Pessoa = p.id_Pessoa\n"
                    + "where "
                    + "DiaSemana = " + day + "\n";
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

                    prof.setNumIdPessoa(rs.getInt("id_Pessoa"));
                }
                a.setProfessor(prof);
                rss.close();
                this.listaAula.add(a);
            }
            rs.close();

            con.closeConnection();
        } catch (SQLException e) {
            System.out.println("Erro na Pesquisa de Professores: " + e.getMessage());
        }
        return this.listaAula;
    }

    public void alterar(Aula aula) {
        try {
            String query = "update Aula AS a \n"
                    + "SET \n"
                    + "id_Professor= ?, \n"
                    + "inicio = ?, \n"
                    + "fim = ?, \n"
                    + "DiaSemana = ?, \n"
                    + "Status = ?, \n"
                    + "numAlunos = ? \n"
                    + "WHERE id_aula = ?; ";
            PreparedStatement st = con.getConnection().prepareStatement(query);
            st.setInt(1, aula.getProfessor().getNumIdProfessor());
            st.setTime(2, aula.gethInicio());
            st.setTime(3, aula.gethFim());
            st.setInt(4, aula.getDiaSemana());
            st.setInt(5, aula.getStatus());
            st.setInt(6, aula.getNumeroAlunos());
            st.setInt(7, aula.getIdAula());

            st.executeUpdate();
            st.close();
            con.closeConnection();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

}
