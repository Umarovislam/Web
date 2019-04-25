
import Controller.Controller;

import java.io.IOException;
import java.sql.SQLException;

public class View {
    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
        Controller con = new Controller();
        String str1 = con.getCheck();
        String str = con.getNumList();
        String str2 = con.getReqList();
        System.out.println("-------------------- Free Numbers List --------------");
        System.out.println(str);
        System.out.println("--------------------- Not closed checks------------");
  //      System.out.println(str1);
        System.out.println("----------------- Request List -----------------");
        System.out.println(str2);
    }
}
     /*   Properties props = new Properties();
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
*/