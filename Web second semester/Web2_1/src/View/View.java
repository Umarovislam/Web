package View;

import Connection.Connections;

public class View {

    public static void main(String[] args) throws Exception {
        Connections cn = new Connections();
        System.out.println(cn.getConnections());
    }
}
