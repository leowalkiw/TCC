/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

/**
 *
 * @author Leo
 */
public class Problema {
    private int idproblema;
    private int idproblemaatual;
    private String latitude;
    private String longitude;
    private int idprimeiraconsulta;

    public int getIdprimeiraconsulta() {
        return idprimeiraconsulta;
    }

    public void setIdprimeiraconsulta(int idprimeiraconsulta) {
        this.idprimeiraconsulta = idprimeiraconsulta;
    }
    
    public int getIdproblema() {
        return idproblema;
    }

    public void setIdproblema(int idproblema) {
        this.idproblema = idproblema;
    }

    public int getIdproblemaatual() {
        return idproblemaatual;
    }

    public void setIdproblemaatual(int idproblemaatual) {
        this.idproblemaatual = idproblemaatual;
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

    
    
    
}
