package crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    
    public static Connection getConnection(){
        Connection connection = null;          //atributo do tipo Connection
        try{
            Class.forName("com.mysql.jdbc.Driver");
            String serverName = "localhost";    //caminho do servidor do BD
            String mydatabase ="mysql";        //nome do seu banco de dados
            String url = "jdbc:mysql://" + serverName + "/" + mydatabase;
            String username = "root";        //nome de um usuário de seu BD      
            String password = "123456";      //sua senha de acesso
            connection = DriverManager.getConnection(url, username, password);
            return connection;
        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
}
