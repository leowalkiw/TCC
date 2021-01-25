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
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Leo
 */
public class UsuarioDAO {

    public boolean validaUsuario(String usuario, String senha) {
        Statement comando = null;
        Connection con = null;
        ResultSet rs = null;

        try {
            con = new Conexao().getConexao();
            String sql = "select idusuario from usuario where login = '" + usuario + "' and senha = '" + senha + "'";

            comando = con.createStatement();
            rs = comando.executeQuery(sql);
            if (rs.next()) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean excluirUsuario(int idusuario) {
        Connection con = null;
        PreparedStatement comando = null;
        try {
            con = new Conexao().getConexao();
            String sql = "delete from usuario where idusuario = ?";
            comando = con.prepareStatement(sql);
            comando.setInt(1, idusuario);

            comando.execute();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean alteraUsuario(Usuario us) {
        Connection con = null;
        PreparedStatement comando = null;
        try {
            con = new Conexao().getConexao();
            String sql = "update usuario set nome = ?, cpf = ?, login = ?, senha = ? where idusuario = ?";
            comando = con.prepareStatement(sql);
            comando.setString(1, us.getNome());
            comando.setString(2, us.getCpf());
            comando.setString(3, us.getLogin());
            comando.setString(4, us.getSenha());
            comando.setInt(5, us.getIdusuario());

            comando.execute();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean insereUsuario(Usuario us) {
        Connection con = null;
        PreparedStatement comando = null;
        try {
            con = new Conexao().getConexao();
            String sql = "insert into usuario (nome,cpf,login,senha) values (?,?,?,?)";
            comando = con.prepareStatement(sql);
            comando.setString(1, us.getNome());
            comando.setString(2, us.getCpf());
            comando.setString(3, us.getLogin());
            comando.setString(4, us.getSenha());

            comando.execute();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Usuario> listarUsuario(String valor) {
        List<Usuario> lista = null;
        ResultSet resultado = null;
        PreparedStatement comando = null;
        Connection con = null;
        try {
            con = new Conexao().getConexao();
            String sql = "SELECT * FROM usuario WHERE nome LIKE ?";
            comando = con.prepareStatement(sql);
            comando.setString(1, "%" + valor + "%");

            resultado = comando.executeQuery();
            lista = new ArrayList<Usuario>();
            while (resultado.next()) {
                Usuario us = new Usuario();
                us.setIdusuario(resultado.getInt("idusuario"));
                us.setNome(resultado.getString("nome"));
                us.setCpf(resultado.getString("cpf"));

                lista.add(us);
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
