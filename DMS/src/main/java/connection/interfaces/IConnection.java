package connection.interfaces;

import java.sql.Connection;
import java.sql.SQLException;

public interface IConnection {
    Connection openConnection();
    boolean closeConnection() throws SQLException;
}
