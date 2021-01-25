/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
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
 * @author Leo
 */
public class ProblemaDAO {
    
    public List<Problema> PrimeiraConsultaProblema() {
        List<Problema> lista = null;
        ResultSet resultado = null;
        PreparedStatement comando = null;
        Connection con = null;
        try {
            con = new Conexao().getConexao();
            String sql = "SELECT MAX(idproblema) AS idprimeiraconsulta FROM problema";
            comando = con.prepareStatement(sql);
            
            
            resultado = comando.executeQuery();
            lista = new ArrayList<Problema>();
            while (resultado.next()) {
                Problema pb = new Problema();
                pb.setIdprimeiraconsulta(resultado.getInt("idprimeiraconsulta"));
                
              
                lista.add(pb);
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
    } // fim codigo problema
    
    
    public List<Problema> CodigoProblemaAtual() {
        List<Problema> lista = null;
        ResultSet resultado = null;
        PreparedStatement comando = null;
        Connection con = null;
        try {
            con = new Conexao().getConexao();
            String sql = "SELECT MAX(idproblema) AS idproblemaatual FROM problema";
            comando = con.prepareStatement(sql);
            
            
            resultado = comando.executeQuery();
            lista = new ArrayList<Problema>();
            while (resultado.next()) {
                Problema pb = new Problema();
                pb.setIdproblemaatual(resultado.getInt("idproblemaatual"));
                
              
                lista.add(pb);
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
    } // fim codigo problema
    
     public List<Problema> listarProblema() {
        List<Problema> lista = null;
        ResultSet resultado = null;
        PreparedStatement comando = null;
        Connection con = null;
        try {
            con = new Conexao().getConexao();
            String sql = "SELECT * FROM problema ORDER BY idproblema DESC";
            comando = con.prepareStatement(sql);
            
            
            resultado = comando.executeQuery();
            lista = new ArrayList<Problema>();
            while (resultado.next()) {
               Problema pb = new Problema();
                pb.setIdproblema(resultado.getInt("idproblema"));
                pb.setLatitude(resultado.getString("latitude"));
              pb.setLongitude(resultado.getString("longitude"));
              
                lista.add(pb);
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
