package br.senai.util;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoSingleton {

        private static java.sql.Connection con;
    
    public static java.sql.Connection getConnection(){
        try { 
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/topfight";
            con = DriverManager.getConnection(url,"root","");
            con.setAutoCommit(true);
            return con;
    } catch ( ClassNotFoundException e ){
        e.printStackTrace();
    }catch ( SQLException se ){
        se.printStackTrace();
    }
        return null;
}
    public static void closeConnection(){
        try{
            con.close();
        }catch ( SQLException ex){
            ex.printStackTrace();
        }
        
    }
}
