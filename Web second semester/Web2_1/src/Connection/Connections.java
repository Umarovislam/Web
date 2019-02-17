package Connection;


import Configuration.ConfigurationManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connections {
    private Connection con;
    public Connection getConnection() throws JDBCConnectionException {
        ConfigurationManager cfg = ConfigurationManager.getINSTANCE();
        try {
            Class.forName(cfg.getDriverName());
            con = DriverManager.getConnection(cfg.getURL(), cfg.getLogin(),
                    cfg.getPassword());
        } catch (ClassNotFoundException e) {
            throw new JDBCConnectionException("Can't load database driver.", e);
        } catch (SQLException e) {
            throw new JDBCConnectionException("Can't connect to database.", e);
        }
        if(con==null) {
            throw new JDBCConnectionException("Driver type is not correct in URL " +
                    cfg.getURL() + ".");
        }
        return con;

    }

}
