package db;
import java.sql.*;


public class DB {
    private static Connection conn;
    public static String url = "jdbc:mysql://localhost:3306/cursejdbc";
    public static String user= "Developer";
    public static String password= "91879163";


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
            throw  new DbException(e.getMessage());
        }
    }
    public static void closeConnection(){
        if (conn != null){
            try{
                conn.close();
            }
            catch (SQLException e){
                throw  new DbException(e.getMessage());

            }
        }
    }
    public static void closeStatement(Statement st) {
        try{
            if (st != null){
                st.close();
            }
        }
        catch (SQLException e){
            System.out.println("ERROR");
        }
    }
    public static void closeResultSet(ResultSet rs) {
        try{
            if (rs != null){
                rs.close();
            }
        }
        catch (SQLException e){
            System.out.println("ERROR");
        }
    }


}
