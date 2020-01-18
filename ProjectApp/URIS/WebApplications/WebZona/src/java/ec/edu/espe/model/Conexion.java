/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Mateo
 */
public class Conexion {
     String bd="prograavanzada";
    String login="root";
    String passw="";
    String url = "jdbc:mysql://localhost:3306/prograavanzada?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    
    Connection objConex=null;
    
    public Conexion (){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            objConex = DriverManager.getConnection(url,login,passw);
            if(objConex!=null)
                System.out.println("Conexion a BD ok");
        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
        } catch (SQLException o){
            System.out.println(o);
        }
    }
 

    public Connection obtenerConexion()
    {
        return objConex;
    }
}
