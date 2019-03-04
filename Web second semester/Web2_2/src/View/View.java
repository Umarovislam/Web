package View;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class View {
    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
        Properties props = new Properties();
        FileInputStream in = new FileInputStream("D:\\3 course\\Web\\Web second semester\\Web2_1\\src\\database.properties");
        props.load(in);
        in.close();

        String driver = props.getProperty("driver");
        if (driver != null) {
            Class.forName(driver) ;
        }

        String url = props.getProperty("url");
        String username = props.getProperty("login");
        String password = props.getProperty("password");

        Connection con = DriverManager.getConnection(url, username, password);

    }
}
