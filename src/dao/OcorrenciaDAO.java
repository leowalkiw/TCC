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
public class OcorrenciaDAO {

    public int insereOcorrencia(Ocorrencia oc) {
        Connection con = null;
        PreparedStatement comando = null;
        try {
            con = new Conexao().getConexao();
            String sql = "INSERT INTO ocorrencia (dataocorrencia, situacao, datafechamento, idequipamento) VALUES (?,'A',?,?)";
            comando = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            comando.setDate(1, (Date) oc.getDataocorrencia());
            comando.setDate(2, (Date) oc.getDatafechamento());
            comando.setInt(3, oc.getIdequipamento());

            comando.execute();

            ResultSet chave = comando.getGeneratedKeys();//

            int id = - 1;//
            if (chave.next()) {
                id = chave.getInt(1);//
            }

            return id;

        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public List<Ocorrencia> listarOcorrencia() {
        List<Ocorrencia> lista = null;
        ResultSet resultado = null;
        PreparedStatement comando = null;
        Connection con = null;
        try {
            con = new Conexao().getConexao();
            String sql = "SELECT idocorrencia,dataocorrencia, datafechamento, idequipamento,\n"
                    + "CASE situacao \n"
                    + "WHEN 'A' THEN 'Em aberto'\n"
                    + "WHEN 'F' THEN 'Finalizada'\n"
                    + "WHEN 'R' THEN 'Efetuando Reparo'\n"
                    + "END AS situacao\n"
                    + "\n"
                    + "FROM ocorrencia";
            comando = con.prepareStatement(sql);

            resultado = comando.executeQuery();
            lista = new ArrayList<Ocorrencia>();
            while (resultado.next()) {
                Ocorrencia oc = new Ocorrencia();
                oc.setIdocorrencia(resultado.getInt("idocorrencia"));
                oc.setDataocorrencia(resultado.getDate("dataocorrencia"));
                oc.setDatafechamento(resultado.getDate("datafechamento"));
                oc.setIdequipamento(resultado.getInt("idequipamento"));
                oc.setSitocorrencia(resultado.getString("situacao"));

                lista.add(oc);
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
    } // fim lista normal

    public List<Ocorrencia> listarOcorrenciaAlterar(int idocorrenciaselecionada) {
        List<Ocorrencia> lista = null;
        ResultSet resultado = null;
        PreparedStatement comando = null;
        Connection con = null;
        try {
            con = new Conexao().getConexao();
            String sql = "SELECT idocorrencia,dataocorrencia, datafechamento, idequipamento,\n"
                    + "CASE situacao \n"
                    + "WHEN 'A' THEN 'Em aberto'\n"
                    + "WHEN 'F' THEN 'Finalizada'\n"
                    + "WHEN 'R' THEN 'Reparo'\n"
                    + "END AS situacao\n"
                    + "\n"
                    + "FROM ocorrencia WHERE idocorrencia = ?";
            comando = con.prepareStatement(sql);
            comando.setInt(1, idocorrenciaselecionada);

            resultado = comando.executeQuery();
            lista = new ArrayList<Ocorrencia>();
            while (resultado.next()) {
                Ocorrencia oc2 = new Ocorrencia();
                oc2.setIdocorrencia(resultado.getInt("idocorrencia"));
                oc2.setDataocorrencia(resultado.getDate("dataocorrencia"));
                oc2.setDatafechamento(resultado.getDate("datafechamento"));
                oc2.setIdequipamento(resultado.getInt("idequipamento"));
                oc2.setSitocorrencia(resultado.getString("situacao"));

                lista.add(oc2);
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
    } // pega idocorrencia selecionada

   public boolean alteraOcorrencia(Ocorrencia oc, int idocorrenciaselecionada, String situacao) {
        Connection con = null;
        PreparedStatement comando = null;
        try {
            con = new Conexao().getConexao();
            String sql = "UPDATE ocorrencia SET dataocorrencia = ?, datafechamento = ?, idequipamento = ?, situacao = ? WHERE idocorrencia = ?";

            comando = con.prepareStatement(sql);
            comando.setDate(1, (Date) oc.getDataocorrencia());
            comando.setDate(2, (Date) oc.getDatafechamento());
            comando.setInt(3, oc.getIdequipamento());
            comando.setString(4, situacao);
            comando.setInt(5, idocorrenciaselecionada);

           comando.execute();
            return true;
        
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
