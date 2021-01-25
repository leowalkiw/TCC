/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Leonardo
 */
public class BairroDAO {
     
    public boolean excluirBairro(int idbairro) {
        Connection con = null;
        PreparedStatement comando = null;
        try {
            con = new Conexao().getConexao();
            String sql = "delete from bairro where idbairro = ?";
            comando = con.prepareStatement(sql);
            comando.setInt(1, idbairro);
            
            comando.execute();
            return true;
        
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean alteraBairro(Bairro br) {
        Connection con = null;
        PreparedStatement comando = null;
        try {
            con = new Conexao().getConexao();
            String sql = "update bairro set nome = ? where idbairro = ?";
            comando = con.prepareStatement(sql);
            comando.setString(1, br.getNome());
            comando.setInt(2, br.getIdbairro());
            
            
            comando.execute();
            return true;
        
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean insereBairro(Bairro br) {
        Connection con = null;
        PreparedStatement comando = null;
        try {
            con = new Conexao().getConexao();
            String sql = "insert into bairro (nome) values (?)";
            comando = con.prepareStatement(sql);
            comando.setString(1, br.getNome());
      
            
            comando.execute();
            return true;
        
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
  public List<Bairro> listarBairro(String valor) {
        List<Bairro> lista = null;
        ResultSet resultado = null;
        PreparedStatement comando = null;
        Connection con = null;
        try {
            con = new Conexao().getConexao();
            String sql = "select * from bairro where nome like ?";
            comando = con.prepareStatement(sql);
            comando.setString(1, "%" + valor + "%");
            
            resultado = comando.executeQuery();
            lista = new ArrayList<Bairro>();
            while (resultado.next()) {
                Bairro br = new Bairro();
                br.setIdbairro(resultado.getInt("idbairro"));
                br.setNome(resultado.getString("nome"));
              
                lista.add(br);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultado != null) {
                    resultado.close();
                }
                
                if (con != null) {
                    con.close();
                }
                
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
        return lista;
    } // fim 
    
}
