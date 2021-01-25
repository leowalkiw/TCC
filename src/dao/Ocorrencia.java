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
public class Ocorrencia {
    private int idocorrencia;
    private Date dataocorrencia;
    private Date datafechamento;
    private int idequipamento;
    private String sitocorrencia;

    public String getSitocorrencia() {
        return sitocorrencia;
    }

    public void setSitocorrencia(String sitocorrencia) {
        this.sitocorrencia = sitocorrencia;
    }
    
   public int getIdocorrencia() {
        return idocorrencia;
    }

    public void setIdocorrencia(int idocorrencia) {
        this.idocorrencia = idocorrencia;
    }

    public Date getDataocorrencia() {
        return dataocorrencia;
    }

    public void setDataocorrencia(Date dataocorrencia) {
        this.dataocorrencia = dataocorrencia;
    }

    public Date getDatafechamento() {
        return datafechamento;
    }

    public void setDatafechamento(Date datafechamento) {
        this.datafechamento = datafechamento;
    }

    public int getIdequipamento() {
        return idequipamento;
    }

    public void setIdequipamento(int idequipamento) {
        this.idequipamento = idequipamento;
    }
    
    
    
}
