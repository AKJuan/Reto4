
package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    Connection connection;
    String driver="com.mysql.cj.jdbc.Driver";
    String cadenaConexion="jdbc:mysql://localhost:3306/reto1_db";
    String usuario="root";
    String contraseña="";

    public Conexion() {
        try{
            Class.forName(driver);
            connection= DriverManager.getConnection(cadenaConexion, usuario, contraseña);
            if (connection != null){
            System.out.println("Conexion mela Pana!.");}
        }catch(ClassNotFoundException | SQLException e){
            System.out.println("Pailas no hay conexion");
        }
    }
    
    public Connection getConnection(){
        return connection;
    }
    
}
