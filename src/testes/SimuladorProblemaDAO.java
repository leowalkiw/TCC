/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testes;

import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author Leo
 */
public class SimuladorProblemaDAO {
    
    public boolean insereSimuladorProblema(SimuladorProblema spb) {
        Connection con = null;
        PreparedStatement comando = null;
        try {
            con = new Conexao().getConexao();
            String sql = "insert into problema (latitude, longitude) values (?,?)";
            comando = con.prepareStatement(sql);
            comando.setString(1, spb.getLatitude());
            comando.setString(2, spb.getLongitude());
      
            
            comando.execute();
            return true;
        
            
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
}
