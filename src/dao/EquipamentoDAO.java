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
public class EquipamentoDAO {
    
    public boolean excluirEquipamento(int idequipamento) {
        Connection con = null;
        PreparedStatement comando = null;
        try {
            con = new Conexao().getConexao();
            String sql = "delete from equipamento where idequipamento = ?";
            comando = con.prepareStatement(sql);
            comando.setInt(1, idequipamento);
            
            comando.execute();
            return true;
        
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean alteraEquipamento(Equipamento eq) {
        Connection con = null;
        PreparedStatement comando = null;
        try {
            con = new Conexao().getConexao();
            String sql = "update equipamento set descricao = ?, modelo = ?, marca = ?, datainstalacao = ?, dataretirada = ?, latitude = ?, longitude = ?, idcidade = ?, idbairro = ?, endereco = ?  where idequipamento = ?";
            
            comando = con.prepareStatement(sql);
            comando.setString(1, eq.getDescricao());
            comando.setString(2, eq.getModelo());
            comando.setString(3, eq.getMarca());
            comando.setDate(4, (Date) eq.getDatainstalacao());
            comando.setDate(5, (Date) eq.getDataretirada());
            comando.setString(6, eq.getLatitude());
            comando.setString(7, eq.getLongitude());
            comando.setInt(8, eq.getIdmunicipio());
            comando.setInt(9, eq.getIdbairro());
            comando.setString(10,eq.getEndereco());
            comando.setInt(11, eq.getIdequipamento());
            
            
            
            comando.execute();
            return true;
        
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean insereEquipamento(Equipamento eq) {
        Connection con = null;
        PreparedStatement comando = null;
        try {
            con = new Conexao().getConexao();
            String sql = "INSERT INTO equipamento (descricao, modelo, marca, datainstalacao, dataretirada, latitude, longitude, idcidade, idbairro, endereco) VALUES (?,?,?,?,?,?,?,?,?,?)";
            comando = con.prepareStatement(sql);
            comando.setString(1, eq.getDescricao());
            comando.setString(2, eq.getModelo());
            comando.setString(3, eq.getMarca());
            comando.setDate(4, (Date) eq.getDatainstalacao());
            comando.setDate(5, (Date) eq.getDataretirada());
            comando.setString(6, eq.getLatitude());
            comando.setString(7, eq.getLongitude());
            comando.setInt(8, eq.getIdmunicipio());
            comando.setInt(9, eq.getIdbairro());
            comando.setString(10,eq.getEndereco());
            
      comando.execute();
            return true;
        
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
     public List<Equipamento> listarEquipamento() {
        List<Equipamento> lista = null;
        ResultSet resultado = null;
        PreparedStatement comando = null;
        Connection con = null;
        try {
            con = new Conexao().getConexao();
            String sql = "SELECT idequipamento, descricao, modelo, marca, datainstalacao, dataretirada, latitude, longitude, municipio.nome AS municipio, bairro.nome AS bairro, endereco FROM equipamento \n" +
"LEFT OUTER JOIN municipio ON equipamento.idcidade = municipio.idcidade\n" +
"LEFT OUTER JOIN bairro ON equipamento.idbairro = bairro.idbairro ORDER BY idequipamento DESC";
            comando = con.prepareStatement(sql);
            
            
            resultado = comando.executeQuery();
            lista = new ArrayList<Equipamento>();
            while (resultado.next()) {
                Equipamento eq = new Equipamento();
                eq.setIdequipamento(resultado.getInt("idequipamento"));
                eq.setDescricao(resultado.getString("descricao"));
                eq.setModelo(resultado.getString("modelo"));
                eq.setMarca(resultado.getString("marca"));
                eq.setDatainstalacao(resultado.getDate("datainstalacao"));
                eq.setDataretirada(resultado.getDate("dataretirada"));
                eq.setLatitude(resultado.getString("latitude"));
                eq.setLongitude(resultado.getString("longitude"));
                eq.setMunicipio(resultado.getString("municipio"));
                eq.setBairro(resultado.getString("bairro"));
                eq.setEndereco(resultado.getString("endereco"));
                
                
               
                
              
                lista.add(eq);
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
    } // fim listarCliente
    
     
     public List<Equipamento> listarEquipamentoProblema(String latitude, String longitude) {
        List<Equipamento> lista = null;
        ResultSet resultado = null;
        PreparedStatement comando = null;
        Connection con = null;
        try {
            con = new Conexao().getConexao();
            String sql = "SELECT idequipamento FROM equipamento WHERE latitude LIKE ? AND longitude LIKE ?";
            comando = con.prepareStatement(sql);
            comando.setString(1, "%" + latitude + "%");
            comando.setString(2, "%" + longitude + "%");
            
            
            resultado = comando.executeQuery();
            lista = new ArrayList<Equipamento>();
            while (resultado.next()) {
                Equipamento eqp = new Equipamento();
                eqp.setIdequipamento(resultado.getInt("idequipamento"));
               
              
                lista.add(eqp);
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
