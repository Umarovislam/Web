package Configuration;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;
import java.util.ResourceBundle;

public class ConfigurationManager {
        public static final ConfigurationManager INSTANCE = new ConfigurationManager();

        String driver ;//= resource.getString("driver");
        String URL ;//= resource.getString("url");
        String login;//= resource.getString("login");
        String password;// = resource.getString("password");

        public void initCon()throws IOException, ClassNotFoundException, SQLException{
            Properties props = new Properties();
            FileInputStream in = new FileInputStream("D:\\3 course\\Web\\Web second semester\\Web2_1\\src\\database.properties");
            props.load(in);
            in.close();

            driver = props.getProperty("driver");
            if (driver != null) {
                Class.forName(driver) ;
            }

            URL = props.getProperty("url");
            login = props.getProperty("login");
            password = props.getProperty("password");
        }



        /**
         * get instance
         * @return instance
         */
        public static ConfigurationManager getINSTANCE() {
            return INSTANCE;
        }

        /**
         * get driver
         * @return driver
         */
        public String getDriverName() {
            return driver;
        }

        /**
         * set driver
         * @param driverName driver
         */
        public void setDriverName(String driverName) {
            this.driver = driverName;
        }

        /**
         * get url
         * @return url
         */
        public String getURL() {
            return URL;
        }

        /**
         * set url
         * @param URL url
         */
        public void setURL(String URL) {
            this.URL = URL;
        }

        /**
         * get login
         * @return login
         */
        public String getLogin() {
            return login;
        }

        /**
         * set login
         * @param login login
         */
        public void setLogin(String login) {
            this.login = login;
        }

        /**
         * get password
         * @return password
         */
        public String getPassword() {
            return password;
        }

        /**
         * set password
         * @param password password
         */
        public void setPassword(String password) {
            this.password = password;
        }

}
