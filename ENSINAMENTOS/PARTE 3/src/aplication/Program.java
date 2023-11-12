package aplication;
import db.DB;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Program {
    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Connection conn = null;
        PreparedStatement st =null;
        try {
            conn = DB.getConnection();
            st = conn.prepareStatement("INSERT INTO seller (Name, Email, BirthDate, BaseSalary, DepartmentId) VALUES (?,?,?,?,?)",PreparedStatement.RETURN_GENERATED_KEYS);
            st.setString(1,"carlos");
            st.setString(2,"carlos@gmail.com");
            st.setDate(3,new java.sql.Date(sdf.parse("24/11/1999").getTime()));
            st.setDouble(4,3000);
            st.setInt(5,1);

            //st = conn.prepareStatement("insert into Department (Name) values ('D1'),('D2')",PreparedStatement.RETURN_GENERATED_KEYS);
            int resul = st.executeUpdate();
            if (resul>0){
                System.out.println("Foram alterados "+resul+" linhas");
                ResultSet rs = st.getGeneratedKeys();
                while (rs.next()){
                    int id= rs.getInt(1);
                    System.out.println("id: "+id);
                }
            }
        }
        catch (ParseException e){
            e.printStackTrace();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        finally {
            DB.closeStatement(st);
            DB.closeConnection();
        }













    }
}
