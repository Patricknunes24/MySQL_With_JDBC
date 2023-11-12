package db;
import java.sql.*;


public class DB {
    private static Connection conn;
    public static String url = "jdbc:mysql://localhost:3306/cursejdbc";
    public static String user= "Developer";
    public static String password= "91879163";

    // ABRE A CONEXAO COM BANCO DE DADOS
    public static Connection getConnection(){
        try {
            if (conn == null) {
                conn = DriverManager.getConnection(url, user, password);
                return conn;
            }
            else {
                return null;

            }
        }
        catch (SQLException e){
            throw new DbException(e.getMessage());
        }
    }
    // FECHA A CONEXÃO COM BANCO DE DADOS MYSQL
    public static void closeConnection(){
        if (conn != null){
            try{
                conn.close();
            }
            catch (SQLException e){
                throw new DbException(e.getMessage());

            }
        }
    }


}
