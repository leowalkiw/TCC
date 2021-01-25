/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.Date;

/**
 *
 * @author Leo
 */
public class Equipamento {
    
    private int idequipamento;
    private String descricao;
    private String modelo;
    private String marca;
    private Date datainstalacao;
    private Date dataretirada;
    private String latitude;
    private String longitude;
    private String municipio;
    private int idmunicipio;
    private String bairro;
    private int idbairro;
    private String endereco;

    public int getIdequipamento() {
        return idequipamento;
    }

    public void setIdequipamento(int idequipamento) {
        this.idequipamento = idequipamento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Date getDatainstalacao() {
        return datainstalacao;
    }

    public void setDatainstalacao(Date datainstalacao) {
        this.datainstalacao = datainstalacao;
    }

    public Date getDataretirada() {
        return dataretirada;
    }

    public void setDataretirada(Date dataretirada) {
        this.dataretirada = dataretirada;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public int getIdmunicipio() {
        return idmunicipio;
    }

    public void setIdmunicipio(int idmunicipio) {
        this.idmunicipio = idmunicipio;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public int getIdbairro() {
        return idbairro;
    }

    public void setIdbairro(int idbairro) {
        this.idbairro = idbairro;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    
    
    
    
}
