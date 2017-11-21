/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programa;
import java.sql.*;
import javax.swing.*;
/**
 *
 * @author usuario
 */
public class conectar {
    Connection conect =null;
    
    public Connection conexion(){
        
        try{
            //Cargamos el driver
            Class.forName("com.mysql.jdbc.Driver");
            conect = DriverManager.getConnection("jdbc:mysql://localhost:8889/java_mysql", "root", "root");
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Eror de conexion"+ e);
        }
        return conect;
    } 
    
    
}
