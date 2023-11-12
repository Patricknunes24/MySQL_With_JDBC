package aplication;
import db.DB;
import db.DbException;
import db.DbIntegrityException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Program {
    public static void main(String[] args) {
        Connection conn = null;
        Statement st = null;
        try {
            conn = DB.getConnection();
            conn.setAutoCommit(false);

            st= conn.createStatement();
            int x = st.executeUpdate("UPDATE seller SET BaseSalary = 2090 WHERE (DepartmentId =1 )");
            int i = 2;
         /* if (i < 3){
                throw new SQLException(" FAKE ERROR");
            } */
            int y = st.executeUpdate("UPDATE seller SET BaseSalary = 3090 WHERE (DepartmentId =2 )");

            conn.commit();
        }
        catch (SQLException e){
            try{
                conn.rollback();
                throw new DbException("ERROR- A TRANSAÇÃO NAO FOI CONCLUIDA"+e.getMessage());
            }catch (SQLException e1){
                throw new DbException("ERRO AO TENTAR VOLTAR A TRANSAÇÃO"+e1.getMessage());
            }
        }
        finally {
            DB.closeStatement(st);
            DB.closeConnection();
        }












    }
}
