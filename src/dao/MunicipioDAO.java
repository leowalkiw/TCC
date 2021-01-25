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
public class MunicipioDAO {
      
  public List<Municipio> listarMunicipio(int IdUFSelecionada) {
        List<Municipio> lista = null;
        ResultSet resultado = null;
        PreparedStatement comando = null;
        Connection con = null;
        try {
            con = new Conexao().getConexao();
            String sql = "SELECT mnc.idcidade,mnc.nome,mnc.idestado, uf.nome AS uf FROM municipio mnc  LEFT OUTER JOIN unidade_federacao uf ON mnc.idestado = uf.idestado WHERE mnc.idestado = ?";
           
            
            comando = con.prepareStatement(sql);
            comando.setInt(1, IdUFSelecionada);
           
            
            resultado = comando.executeQuery();
            lista = new ArrayList<Municipio>();
            while (resultado.next()) {  
                Municipio mn = new Municipio();
                mn.setIdmunicipio(resultado.getInt("idcidade"));
                mn.setNome(resultado.getString("nome"));
                mn.setIduf(resultado.getInt("idestado"));
                mn.setUf(resultado.getString("uf"));
              
                lista.add(mn);
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
    } // fim listarMunicipio
}
