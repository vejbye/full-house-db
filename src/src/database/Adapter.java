package src.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Lenovo
 */
public class Adapter {
    
    private static String user;
    private static String db;
    private static String password;
    private static String host;
    private static Connection conn;
    
    /**
     * Creates new form dbconnect
     * @param user
     * @param db
     * @param password
     * @param host
     */
    public Adapter(String user, String db, String password, String host) {
        Adapter.host = host;
        Adapter.db = db;
        Adapter.user = user;
        Adapter.password = password;
        
        init();
    }
    
    private void init(){
        try{
            String driver = "com.mysql.jdbc.Driver";
            Class.forName(driver);}
        catch (Exception e){

        }    
    }
    
    public Connection getConnection() throws SQLException
    {
        if (conn==null) {
            init();
            conn=createConnection();
        }

        return conn;

    }

    private Connection createConnection() throws SQLException
    {
        String connectionString = "jdbc:mysql://" + Adapter.host + "/" + Adapter.db + "?" +
                "user=" + Adapter.user + "&password=" + Adapter.password;

        return DriverManager.getConnection(connectionString);
    }
}