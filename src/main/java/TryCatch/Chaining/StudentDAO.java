package TryCatch.Chaining;
import java.sql.*;

import java.sql.SQLException;

public class StudentDAO {
    public void list() throws DAOExeption{
        try {
            DatabaseUtils.executeQuery("SELECT");
        } catch (SQLException ex){
            throw new DAOExeption("error quering database", ex);
        }
    }


}
