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
public class Conectar {
    Connection conect =null;
    
    public Connection conexion(){
        
        try{
            //Cargamos el driver
            Class.forName("com.mysql.jdbc.Driver");
            conect = DriverManager.getConnection("jdbc:mysql://localhost/cantina_db", "root", "root");
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Error de conexion"+ e);
        }
        return conect;
    } 
    
    
}
