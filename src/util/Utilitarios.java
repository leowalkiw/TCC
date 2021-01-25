/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author Leo
 */
public class Utilitarios {
    
    public static void limpaCampos(JPanel painel) {
        for (int i = 0; i < painel.getComponentCount(); i++) {
            if (painel.getComponent(i) instanceof JTextField) {
                ((JTextField)painel.getComponent(i)).setText(null);
            }
        }
    }
    
    public static void habilitaDesabilita(JPanel painel, 
            boolean ativo) {
        for (int i = 0; i < painel.getComponentCount(); i++) {
            if (painel.getComponent(i) instanceof JTextField) {
                painel.getComponent(i).setEnabled(ativo);
            }
        }
    }
     public static void anterior(JTable tabela){
        if (tabela.getSelectedRow() != -1){
            int ant = tabela.getSelectedRow() - 1;
            tabela.getSelectionModel().setSelectionInterval(ant, ant);
        }
    }
    
    public static void proximo(JTable tabela){
        if (tabela.getSelectedRow() != -1){
            int prox = tabela.getSelectedRow() + 1;
            tabela.getSelectionModel().setSelectionInterval(prox, prox);
        }
    }
    
    public static void primeiro(JTable tabela){
        if(tabela.getRowCount() != -1){
            tabela.getSelectionModel().setSelectionInterval(0, 0);
        }        
    }
    
    public static void ultimo(JTable tabela){
        if(tabela.getRowCount() != -1){
            int ultimo = tabela.getRowCount() - 1;
            tabela.getSelectionModel().setSelectionInterval(ultimo, ultimo);
        }
    }
}






