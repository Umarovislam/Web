package DAO;

import Connection.Connections;

public class Dao {
    protected Connections con;

    public Dao() throws Exception{
        try {
            con = new Connections();
        }
        catch (Exception e){
            throw new DaoException("JDBC Connector error",e);
        }
    }
    public Connections getConnection(){
        return con;
    }
}
