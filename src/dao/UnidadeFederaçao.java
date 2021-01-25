/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

/**
 *
 * @author Leonardo
 */
public class UnidadeFederaçao {
    private int idunidade_federacao;
    private String nome;
    private String sigla;

    public int getIdunidade_federacao() {
        return idunidade_federacao;
    }

    public void setIdunidade_federacao(int idunidade_federacao) {
        this.idunidade_federacao = idunidade_federacao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }
    
}
