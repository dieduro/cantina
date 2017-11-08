/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programa;

/**
 *
 * @author Usuario
 */
public class Usuario {
    
    public Usuario(){
        
    }
    
    
    private String user;
    private String pass;
    
    public void setuser(String us){
        this.user=us;
    }
    
    public void setpass(String pw){
        this.pass=pw;
    }
    
    public String getuser(){
        return this.user;
    }
    
    public String getpass(){
        return this.pass;
    }
}
