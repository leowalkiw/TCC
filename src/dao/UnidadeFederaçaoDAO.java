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
public class UnidadeFederaçaoDAO {
     public boolean excluirUf(int idunidade_federaçao) {
        Connection con = null;
        PreparedStatement comando = null;
        try {
            con = new Conexao().getConexao();
            String sql = "delete from unidade_federacao where idestado = ?";
            comando = con.prepareStatement(sql);
            comando.setInt(1, idunidade_federaçao);
            
            comando.execute();
            return true;
        
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean alteraUf(UnidadeFederaçao uf) {
        Connection con = null;
        PreparedStatement comando = null;
        try {
            con = new Conexao().getConexao();
            String sql = "update unidade_federacao set nome = ?, sigla = ? where idestado = ?";
            comando = con.prepareStatement(sql);
            comando.setString(1, uf.getNome());
            comando.setString(2, uf.getSigla());
            comando.setInt(4, uf.getIdunidade_federacao());
            
            
            comando.execute();
            return true;
        
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean insereUf(UnidadeFederaçao uf) {
        Connection con = null;
        PreparedStatement comando = null;
        try {
            con = new Conexao().getConexao();
            String sql = "insert into unidade_federacao (nome,estado) values (?,?)";
            comando = con.prepareStatement(sql);
            comando.setString(1, uf.getNome());
            comando.setString(2,uf.getSigla());
            
      
            
            comando.execute();
            return true;
        
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
  public List<UnidadeFederaçao> listarUf() {
        List<UnidadeFederaçao> lista = null;
        ResultSet resultado = null;
        PreparedStatement comando = null;
        Connection con = null;
        try {
            con = new Conexao().getConexao();
            String sql = "SELECT * FROM unidade_federacao";
            comando = con.prepareStatement(sql);
            
            
            resultado = comando.executeQuery();
            lista = new ArrayList<UnidadeFederaçao>();
            while (resultado.next()) {
               UnidadeFederaçao uf = new UnidadeFederaçao();
                uf.setIdunidade_federacao(resultado.getInt("idestado"));
                uf.setNome(resultado.getString("nome"));
                uf.setSigla(resultado.getString("estado"));
              
                lista.add(uf);
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
