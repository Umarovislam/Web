package Connection;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.ResourceBundle;

public class Connections {
    private Connection con;
    public Connection getConnections() throws JDBCConnectionException, SQLException {
        try {
            ResourceBundle resource = ResourceBundle.getBundle("database.properties");
            String url = resource.getString("url");
            String driver = resource.getString("driver");
            String user = resource.getString("login");
            String pass = resource.getString("password");

            Class.forName(driver).newInstance();
        }
        catch (ClassNotFoundException e){
            throw new JDBCConnectionException("Driver not loaded");
        }
        catch (InstantiationException e){
            e.printStackTrace();
        }
        catch (IllegalAccessException e){
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return DriverManager.getConnection(url,user,pass);
    }

}
