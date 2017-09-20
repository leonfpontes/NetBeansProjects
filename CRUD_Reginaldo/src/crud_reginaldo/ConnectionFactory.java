
package crud_reginaldo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    
    public static Connection getConnection(){
        Connection connection = null;          //atributo do tipo Connection
        try{
            Class.forName("com.mysql.jdbc.Driver");
            //Class.forName("mysql-connector-java-5.1.44-bin.jar");
            connection = DriverManager.getConnection("jdbc:mysql://localhost/crud_reginaldo","root","123456");
            return connection;
        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
}