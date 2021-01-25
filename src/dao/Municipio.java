/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

/**
 *
 * @author Leonardo
 */
public class Municipio {
    private int idmunicipio;

    public int getIdmunicipio() {
        return idmunicipio;
    }

    public void setIdmunicipio(int idmunicipio) {
        this.idmunicipio = idmunicipio;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public int getIduf() {
        return iduf;
    }

    public void setIduf(int iduf) {
        this.iduf = iduf;
    }
    private String nome;
    private String uf;
    private int iduf;
   
    
}
