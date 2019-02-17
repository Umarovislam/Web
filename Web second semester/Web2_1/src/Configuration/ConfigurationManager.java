package Configuration;

import java.util.ResourceBundle;

public class ConfigurationManager {
        public static final ConfigurationManager INSTANCE = new ConfigurationManager();

        ResourceBundle resource = ResourceBundle.getBundle("database");
        String driverName = resource.getString("driver");
        String URL = resource.getString("url");
        String login = resource.getString("login");
        String password = resource.getString("password");

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
            return driverName;
        }

        /**
         * set driver
         * @param driverName driver
         */
        public void setDriverName(String driverName) {
            this.driverName = driverName;
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
