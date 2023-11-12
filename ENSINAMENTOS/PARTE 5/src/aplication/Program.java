package aplication;
import db.DB;
import db.DbIntegrityException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Program {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement st = null;
        try {
            conn = DB.getConnection();
            st = conn.prepareStatement("DELETE FROM Department WHERE (id = ?)");
            st.setInt(1,10);
            int resul = st.executeUpdate();
            System.out.println(resul);
        }
        catch (SQLException e){
            throw new DbIntegrityException(e.getMessage());
        }
        finally {
            DB.closeStatement(st);
            DB.closeConnection();
        }












    }
}
