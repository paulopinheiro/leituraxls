package br.com.paulopinheiro.leituraxls.view;

import br.com.paulopinheiro.leituraxls.control.Resumo;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

public class Principal extends javax.swing.JFrame {
    private Resumo resumo;

    public Principal() {
        initComponents();
        outrasInicializacoes();
    }

    private void outrasInicializacoes() {
        listenerCampoArquivo();
        
    }

    private void listenerCampoArquivo() {
        jtfArquivo.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void changedUpdate(DocumentEvent e) {
                atualizaCampos();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                atualizaCampos();
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                atualizaCampos();
            }

            private void atualizaCampos() {
                if (jtfArquivo.getText().isEmpty()) {
                    jbtAnalisar.setEnabled(false);
                    jbtOtimizar.setEnabled(false);
                }
                else {
                    jbtAnalisar.setEnabled(true);
                    jbtOtimizar.setEnabled(true);
                }
            }
        });        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jfcArquivo = new javax.swing.JFileChooser();
        jbtArquivo = new javax.swing.JButton();
        jtfArquivo = new javax.swing.JTextField();
        jbtAnalisar = new javax.swing.JButton();
        panAnalise = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jtfQuantResumido = new javax.swing.JTextField();
        jtfQuantAtual = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jtfPercentualReducao = new javax.swing.JTextField();
        jbtOtimizar = new javax.swing.JButton();
        jbtLimpar = new javax.swing.JButton();

        jfcArquivo.setDialogTitle("Selecione o arquivo");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Resumo de formatos Excel");

        jbtArquivo.setText("Arquivo:");
        jbtArquivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtArquivoActionPerformed(evt);
            }
        });

        jbtAnalisar.setText("Analisar");
        jbtAnalisar.setEnabled(false);
        jbtAnalisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtAnalisarActionPerformed(evt);
            }
        });

        panAnalise.setBorder(javax.swing.BorderFactory.createTitledBorder("Análise"));

        jLabel1.setText("Quantidade estilos atual:");

        jLabel2.setText("Quantidade após resumo:");

        jtfQuantResumido.setHorizontalAlignment(javax.swing.JTextField.TRAILING);

        jtfQuantAtual.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        jtfQuantAtual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfQuantAtualActionPerformed(evt);
            }
        });

        jLabel3.setText("Percentual redução:");

        jtfPercentualReducao.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        jtfPercentualReducao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfPercentualReducaoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panAnaliseLayout = new javax.swing.GroupLayout(panAnalise);
        panAnalise.setLayout(panAnaliseLayout);
        panAnaliseLayout.setHorizontalGroup(
            panAnaliseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panAnaliseLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panAnaliseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panAnaliseLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jtfQuantAtual))
                    .addGroup(panAnaliseLayout.createSequentialGroup()
                        .addGroup(panAnaliseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panAnaliseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jtfQuantResumido, javax.swing.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
                            .addComponent(jtfPercentualReducao))))
                .addContainerGap(409, Short.MAX_VALUE))
        );
        panAnaliseLayout.setVerticalGroup(
            panAnaliseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panAnaliseLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panAnaliseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jtfQuantAtual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panAnaliseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jtfQuantResumido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panAnaliseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jtfPercentualReducao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        jbtOtimizar.setText("Otimizar");
        jbtOtimizar.setEnabled(false);
        jbtOtimizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtOtimizarActionPerformed(evt);
            }
        });

        jbtLimpar.setText("Limpar");
        jbtLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtLimparActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jbtArquivo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfArquivo))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jbtAnalisar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbtOtimizar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbtLimpar)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(panAnalise, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtArquivo)
                    .addComponent(jtfArquivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtAnalisar)
                    .addComponent(jbtOtimizar)
                    .addComponent(jbtLimpar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panAnalise, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtfQuantAtualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfQuantAtualActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfQuantAtualActionPerformed

    private void jbtArquivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtArquivoActionPerformed
        int returnVal = this.jfcArquivo.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            this.jtfArquivo.setText(this.jfcArquivo.getSelectedFile().getAbsolutePath());
        }
    }//GEN-LAST:event_jbtArquivoActionPerformed

    private void jbtAnalisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtAnalisarActionPerformed
        try {
            resumo = new Resumo(this.jtfArquivo.getText());
            this.jtfQuantAtual.setText(String.valueOf(resumo.quantEstilosExistentes()));
            this.jtfQuantResumido.setText(String.valueOf(resumo.quantEstilosResumidos()));
            this.jtfPercentualReducao.setText(String.valueOf(resumo.percentualReducao()));
        } catch (IOException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidFormatException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jbtAnalisarActionPerformed

    private void jtfPercentualReducaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfPercentualReducaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfPercentualReducaoActionPerformed

    private void jbtOtimizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtOtimizarActionPerformed
        try {
            resumo.otimizar();
        } catch (IOException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jbtOtimizarActionPerformed

    private void jbtLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtLimparActionPerformed
        this.jtfArquivo.setText("");
        this.jtfPercentualReducao.setText("");
        this.jtfQuantAtual.setText("");
        this.jtfQuantResumido.setText("");
    }//GEN-LAST:event_jbtLimparActionPerformed

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
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton jbtAnalisar;
    private javax.swing.JButton jbtArquivo;
    private javax.swing.JButton jbtLimpar;
    private javax.swing.JButton jbtOtimizar;
    private javax.swing.JFileChooser jfcArquivo;
    private javax.swing.JTextField jtfArquivo;
    private javax.swing.JTextField jtfPercentualReducao;
    private javax.swing.JTextField jtfQuantAtual;
    private javax.swing.JTextField jtfQuantResumido;
    private javax.swing.JPanel panAnalise;
    // End of variables declaration//GEN-END:variables
}
