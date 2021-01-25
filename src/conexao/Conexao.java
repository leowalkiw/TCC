/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Leo
 */
public class Conexao {
    public Connection getConexao(){
        
      String caminho = "jdbc:mysql://localhost:3306/tcc";   
       String usuario = "root";
       String senha = "";
      
    
        try {
                
            return DriverManager.getConnection(caminho, usuario, senha);
             // return DriverManager.getConnection(connectionUrl);
        } catch (SQLException ex) {
           ex.printStackTrace();
           return null;
        }
    }
    
}
