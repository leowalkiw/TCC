/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexao.Conexao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Leo
 */
public class SituacaoOcorrenciaDAO {
    
    public boolean insereSituacao_Ocorrencia(SituacaoOcorrencia sto) {
        Connection con = null;
        PreparedStatement comando = null;
        try {
            con = new Conexao().getConexao();
            String sql = "INSERT INTO situacao_ocorrencia(idocorrencia, datamodificacao, descricao) VALUES (?,?,?)";
            comando = con.prepareStatement(sql);
            comando.setInt(1, sto.getIdocorrencia());
            comando.setDate(2, (Date) sto.getDatamodificacao());
            comando.setString(3, sto.getDescricao());
            
      comando.execute();
            return true;
        
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public List<SituacaoOcorrencia> listarSituação(int idocorrencia) {
        List<SituacaoOcorrencia> lista = null;
        ResultSet resultado = null;
        PreparedStatement comando = null;
        Connection con = null;
        try {
            con = new Conexao().getConexao();
            String sql = "SELECT * FROM situacao_ocorrencia WHERE idocorrencia like ? ORDER BY idsituacao DESC";
            comando = con.prepareStatement(sql);
            comando.setInt(1, idocorrencia);
            
            resultado = comando.executeQuery();
            lista = new ArrayList<SituacaoOcorrencia>();
            while (resultado.next()) {
                SituacaoOcorrencia sto = new SituacaoOcorrencia();
                sto.setIdsituacao(resultado.getInt("idsituacao"));
                sto.setIdocorrencia(resultado.getInt("idocorrencia"));
                sto.setDatamodificacao(resultado.getDate("datamodificacao"));
                sto.setDescricao(resultado.getString("descricao"));
              
                lista.add(sto);
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
    
    public boolean excluirSituacao(int idsituacao) {
        Connection con = null;
        PreparedStatement comando = null;
        try {
            con = new Conexao().getConexao();
            String sql = "delete from situacao_ocorrencia where idsituacao = ?";
            comando = con.prepareStatement(sql);
            comando.setInt(1, idsituacao);
            
            comando.execute();
            return true;
        
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
