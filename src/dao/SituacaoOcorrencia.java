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
public class SituacaoOcorrencia {
    private int idsituacao;
    private int idocorrencia;
    private Date datamodificacao;
    private String descricao;

    public int getIdsituacao() {
        return idsituacao;
    }

    public void setIdsituacao(int idsituacao) {
        this.idsituacao = idsituacao;
    }

    public int getIdocorrencia() {
        return idocorrencia;
    }

    public void setIdocorrencia(int idocorrencia) {
        this.idocorrencia = idocorrencia;
    }

    public Date getDatamodificacao() {
        return datamodificacao;
    }

    public void setDatamodificacao(Date datamodificacao) {
        this.datamodificacao = datamodificacao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    
    
}
