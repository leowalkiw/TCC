/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import dao.Equipamento;
import dao.EquipamentoDAO;
import dao.Ocorrencia;
import dao.OcorrenciaDAO;
import dao.SituacaoOcorrencia;
import dao.SituacaoOcorrenciaDAO;
import java.awt.Dimension;
import java.io.IOException;
import java.net.URISyntaxException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import pesquisas.PesquisaProblema;

/**
 *
 * @author Leo
 */
public class JanelaOcorrenciaDados extends javax.swing.JDialog {

    private int idProblemaSelecionado;
    private int idOcorrenciaSelecionada;
    private List<Equipamento> lista;
    private List<Ocorrencia> listao;
    private List<SituacaoOcorrencia> listast;
    static int idEquipamentoP;
    private char operacao, operacaosituacao;
    private String situacao, situacaor;
    private boolean removendo = false;
    private DefaultTableModel modelo;

    public JanelaOcorrenciaDados(java.awt.Frame parent, boolean modal, char operacaoselecionada, int idocorrenciaselecionada) {

        initComponents();
        super(parent, modal);
        idOcorrenciaSelecionada = idocorrenciaselecionada;
        operacao = operacaoselecionada;

        modelo = (DefaultTableModel) tbAcompanha.getModel();
        tbAcompanha.setSelectionMode(
                ListSelectionModel.SINGLE_SELECTION);

        tbAcompanha.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent lse) {
                if (!lse.getValueIsAdjusting()) {
                    linhaSelecionada();
                }
            }

        });

        if (operacao == 'A') {
            carregaDadosOcorrencia();
            carregaDadosSituacao_Ocorrencia();
        }

    }

    public int getLinhaSelecionada() {
        return tbAcompanha.getSelectedRow();
    }

    public void linhaSelecionada() {
        if (!removendo) {

        }
    }

    public void carregaDadosOcorrencia() {
        OcorrenciaDAO dao = new OcorrenciaDAO();
        listao = dao.listarOcorrenciaAlterar(idOcorrenciaSelecionada);
        SimpleDateFormat in = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat out = new SimpleDateFormat("dd/MM/yyyy");
        String result, result2;

        for (Ocorrencia so : listao) {
            so.getDataocorrencia();
            so.getDatafechamento();
            so.getIdequipamento();
            situacaor = so.getSitocorrencia();
            String equipamento = String.valueOf(so.getIdequipamento());

            try {
                result = out.format(in.parse(so.getDataocorrencia().toString()));
                txtDataOcorrencia.setText(result);

                result2 = out.format(in.parse(so.getDatafechamento().toString()));
                txtDataFechamento.setText(result2);

                

            } catch (ParseException ex) {
                Logger.getLogger(JanelaOcorrenciaDados.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("Erro ao carregar datas");
            }
        }

        if (situacaor.equals("Reparo")) {
            rReparo.setSelected(true);
        } else if (situacaor.equals("Finalizada")) {
            rFinalizada.setSelected(true);
        }
    }

    public void carregaDadosSituacao_Ocorrencia() {
        SituacaoOcorrenciaDAO dao = new SituacaoOcorrenciaDAO();
        listast = dao.listarSituação(idOcorrenciaSelecionada);

        removendo = true;
        modelo.getDataVector().removeAllElements();

        for (SituacaoOcorrencia sto : listast) {
            modelo.addRow(new Object[]{
                sto.getDatamodificacao(),
                sto.getDescricao(),});
            sto.getIdsituacao();
        }

        removendo = false;

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtLongitude = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtLatitude = new javax.swing.JTextField();
        btnPesquisaProbolema = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txtDataOcorrencia = new javax.swing.JFormattedTextField();
        jLabel6 = new javax.swing.JLabel();
        txtDataFechamento = new javax.swing.JFormattedTextField();
        rReparo = new javax.swing.JRadioButton();
        rFinalizada = new javax.swing.JRadioButton();
        btnExibeLocal = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        txtDataAtend = new javax.swing.JFormattedTextField();
        jLabel8 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbAcompanha = new javax.swing.JTable();
        txtDescricao = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro e Acompanhamento de Ocorrencias");

        jButton1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Leo\\Documents\\NetBeansProjects\\TCC\\imagens\\salvar_icone.png")); // NOI18N
        jButton1.setText("Salvar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);

        jButton2.setIcon(new javax.swing.ImageIcon("C:\\Users\\Leo\\Documents\\NetBeansProjects\\TCC\\imagens\\cancelar_icone.png")); // NOI18N
        jButton2.setText("Cancelar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);

        jLabel1.setText("Problema");

        jLabel2.setText("Latitude");

        txtLongitude.setEditable(false);

        jLabel3.setText("Longitude");

        txtLatitude.setEditable(false);

        btnPesquisaProbolema.setText("Pesquisar");
        btnPesquisaProbolema.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisaProbolemaActionPerformed(evt);
            }
        });

        jLabel5.setText("Data Ocorrencia");

        try {
            txtDataOcorrencia.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel6.setText("Data Fechamento");

        try {
            txtDataFechamento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        buttonGroup1.add(rReparo);
        rReparo.setText("Em reparo");

        buttonGroup1.add(rFinalizada);
        rFinalizada.setText("Finalizada");

        btnExibeLocal.setIcon(new javax.swing.ImageIcon("C:\\Users\\Leo\\Documents\\NetBeansProjects\\TCC\\imagens\\maps_icone.png")); // NOI18N
        btnExibeLocal.setText("Exibir Localização");
        btnExibeLocal.setEnabled(false);
        btnExibeLocal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExibeLocalActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtLatitude, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtLongitude, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                                .addComponent(btnPesquisaProbolema))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDataOcorrencia, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(33, 33, 33)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(txtDataFechamento, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnExibeLocal)
                        .addGap(40, 40, 40))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(122, 122, 122)
                        .addComponent(rReparo)
                        .addGap(56, 56, 56)
                        .addComponent(rFinalizada)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtLongitude, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txtLatitude, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPesquisaProbolema))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDataFechamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDataOcorrencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rReparo)
                            .addComponent(rFinalizada)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnExibeLocal)
                        .addGap(76, 76, 76)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(75, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Dados", jPanel2);

        jLabel7.setText("Data Atendimento");

        try {
            txtDataAtend.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel8.setText("Descrição");

        jButton4.setIcon(new javax.swing.ImageIcon("C:\\Users\\Leo\\Documents\\NetBeansProjects\\TCC\\imagens\\salvar_icone.png")); // NOI18N
        jButton4.setText("Salvar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        tbAcompanha.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Data Atendimento", "Descrição"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tbAcompanha);

        jButton5.setIcon(new javax.swing.ImageIcon("C:\\Users\\Leo\\Documents\\NetBeansProjects\\TCC\\imagens\\excluir_icone.png")); // NOI18N
        jButton5.setText("Excluir");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 501, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtDataAtend, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtDescricao)))
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(163, 163, 163)
                .addComponent(jButton4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtDataAtend, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4)
                    .addComponent(jButton5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Acompanhamento", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPesquisaProbolemaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisaProbolemaActionPerformed
        PesquisaProblema pesquisap = new PesquisaProblema(null, true);
        pesquisap.setVisible(true);

        if (pesquisap.selecionou) {
            txtLatitude.setText(pesquisap.lista.get(
                    pesquisap.getLinhaSelecionada()).getLatitude());
            txtLongitude.
                    setText(pesquisap.lista.get(
                            pesquisap.getLinhaSelecionada()).getLongitude());
            idProblemaSelecionado
                    = pesquisap.lista.get(
                            pesquisap.getLinhaSelecionada()).getIdproblema();
            btnExibeLocal.setEnabled(true);
        }

        EquipamentoDAO eqdao = new EquipamentoDAO();
        lista = eqdao.listarEquipamentoProblema(txtLatitude.getText(), txtLongitude.getText());
        for (Equipamento equip : lista) {
            equip.getIdequipamento();
            idEquipamentoP = equip.getIdequipamento(); //retorna equipamento com mesmas coordenadas do problema

        };
      
       
    }//GEN-LAST:event_btnPesquisaProbolemaActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        String dataString = txtDataOcorrencia.getText();

        DateFormat ft = new SimpleDateFormat("dd/MM/yyyy");
        java.sql.Date dataocorrencia = null;
        try {
            dataocorrencia = new java.sql.Date(ft.parse(dataString).getTime());
        } catch (ParseException ex) {
            Logger.getLogger(JanelaEquipamento.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        String dataString2 = txtDataFechamento.getText();
        DateFormat ft2 = new SimpleDateFormat("dd/MM/yyyy");
        java.sql.Date datafechamento = null;
        try {
            datafechamento = new java.sql.Date(ft2.parse(dataString2).getTime());
        } catch (ParseException ex) {
            Logger.getLogger(JanelaEquipamento.class.getName()).log(Level.SEVERE, null, ex);
        }
        Ocorrencia oc = new Ocorrencia();
        oc.setDataocorrencia(dataocorrencia);
        oc.setDatafechamento(datafechamento);
       OcorrenciaDAO dao = new OcorrenciaDAO();
        switch (operacao) {
            case 'I':
                dao.insereOcorrencia(oc);
                JOptionPane.showMessageDialog(this, "Incluido com sucesso.");
                break;
            case 'A':
                if (rReparo.isSelected()) {
                    situacao = "R";
                } else if (rFinalizada.isSelected()) {
                    situacao = "F";
                }
                dao.alteraOcorrencia(oc, idOcorrenciaSelecionada, situacao);
                JOptionPane.showMessageDialog(this, "Alterado com sucesso.");
                break;

        }

    }//GEN-LAST:event_jButton1ActionPerformed


    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        String dataString = txtDataAtend.getText();
        DateFormat ft = new SimpleDateFormat("dd/MM/yyyy");
        java.sql.Date dataatendimento = null;
        try {
            dataatendimento = new java.sql.Date(ft.parse(dataString).getTime());
        } catch (ParseException ex) {
            Logger.getLogger(JanelaEquipamento.class.getName()).log(Level.SEVERE, null, ex);
        }

        SituacaoOcorrencia sto = new SituacaoOcorrencia();

        sto.setIdocorrencia(idOcorrenciaSelecionada);
        sto.setDatamodificacao(dataatendimento);
        sto.setDescricao(txtDescricao.getText());

        if (new SituacaoOcorrenciaDAO().insereSituacao_Ocorrencia(sto)) {
            ((DefaultTableModel) tbAcompanha.getModel()).addRow(new Object[]{
                dataatendimento,
                txtDescricao.getText(),});

            JOptionPane.showMessageDialog(this, "Sucesso");
        } else {
            JOptionPane.showMessageDialog(this, "Erro");
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        int idsituacao = listast.get(tbAcompanha.getSelectedRow()).getIdsituacao();
        new SituacaoOcorrenciaDAO().excluirSituacao(idsituacao);
        System.out.println("Id situacao" + idsituacao);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnExibeLocalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExibeLocalActionPerformed
        //AIzaSyBs8xS8mvbgQU0GMneqIIQbQH8KkNlh9oE - api google maps

        try {
            try {
                java.awt.Desktop.getDesktop().browse(new java.net.URI("http://localhost/TCC/index.php?latitude=" + txtLatitude.getText() + "&longitude=" + txtLongitude.getText() + ""));
            } catch (URISyntaxException ex) {
                // Logger.getLogger(MenuLinks.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (IOException ex) {
            // Logger.getLogger(MenuLinks.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnExibeLocalActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JanelaOcorrenciaDados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JanelaOcorrenciaDados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JanelaOcorrenciaDados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JanelaOcorrenciaDados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

                JanelaOcorrenciaDados dialog = new JanelaOcorrenciaDados(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setLocationRelativeTo(dialog);
                dialog.setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExibeLocal;
    private javax.swing.JButton btnPesquisaProbolema;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JRadioButton rFinalizada;
    private javax.swing.JRadioButton rReparo;
    private javax.swing.JTable tbAcompanha;
    private javax.swing.JFormattedTextField txtDataAtend;
    private javax.swing.JFormattedTextField txtDataFechamento;
    private javax.swing.JFormattedTextField txtDataOcorrencia;
    private javax.swing.JTextField txtDescricao;
    private javax.swing.JTextField txtLatitude;
    private javax.swing.JTextField txtLongitude;
    // End of variables declaration//GEN-END:variables
}
