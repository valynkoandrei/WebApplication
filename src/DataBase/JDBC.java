package DataBase;

import java.sql.*;

/**
 * Created by Андрей on 17.10.2016.
 */

public class JDBC {

    private final String URL = "jdbc:mysql://localhost:3306/test";
    private final String username = "root";
    private final String password = "root";
    private String key;

    private Connection connection;

    public JDBC(String key) throws SQLException {
            this.key=key;
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            connection=DriverManager.getConnection(URL, username, password);


    }

    public int findValue() throws SQLException {
        ResultSet resultSet= connection.createStatement().executeQuery("SELECT * from users where "+ "name="+"'"+key+"'");
        while (resultSet.next()){
            if(resultSet.getString("name").equals(key)) {return resultSet.getInt("id");}
        }

        return -1;
    }

}
