package DAO;

import Model.Number;
import Connection.JDBCConnectionException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BookedNumbers extends Dao{

    final private String req = "SELECT * FROM NUMBER as n WHERE n.free=?";

    public BookedNumbers() throws Exception {
        super();
    }
    public ArrayList<Number> getFreeNumbers() throws DaoException{
        Number number= null;
        ArrayList<Number>numbers = new ArrayList<>();
        Connection cn = null;
        PreparedStatement pstmt = null;
        try {
            cn = con.getConnections();
            pstmt = cn.prepareStatement(req);
            pstmt.setBoolean(1, true);
            ResultSet res = pstmt.executeQuery();
            while (res.next())
                numbers.add(new Number(res.getInt(1),res.getBoolean(2)));
        } catch (JDBCConnectionException e) {
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return numbers;
    }
}
