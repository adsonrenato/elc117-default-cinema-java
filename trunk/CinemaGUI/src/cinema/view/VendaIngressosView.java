/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cinema.view;

import cinema.controller.IngressosController;
import cinema.model.Cinema;
import cinema.model.Sessao;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
/**
 *
 * @author Felipe
 */
public class VendaIngressosView extends javax.swing.JFrame {
    
    private IngressosController controller;
    private Cinema model;
    
    /**
     * Creates new form VendaIngressosView
     */
    public VendaIngressosView() {
        initComponents();
        model = new Cinema();
        controller = new IngressosController(this, model);
    }
    
    public VendaIngressosView(Cinema model) {
        initComponents();
        if(model != null) this.model = model;
        else this.model = new Cinema();
        controller = new IngressosController(this, this.model);
    }
    
    public void updateFrame() {
        comboFilme.removeAllItems();
        comboSala.removeAllItems();
        comboHorario.removeAllItems();
        comboData.removeAllItems();
        controller.updateFrame();
    }
    
    
    public JComboBox getComboFilme() {
        return comboFilme;
    }
    
    public JComboBox getComboHorario() {
        return comboHorario;
    }
    
    public JComboBox getComboSala() {
        return comboSala;
    }

    public JComboBox getComboData() {
        return comboData;
    }

    public JTextField getTextVendidos() {
        return textVendidos;
    }
    
    public JButton getButtonRelatorio() {
        return buttonRelatorio;
    }
    
    public JButton getButtonVenda() {
        return buttonVenda;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonBanner = new javax.swing.JButton();
        comboHorario = new javax.swing.JComboBox();
        comboFilme = new javax.swing.JComboBox();
        labelVenda = new javax.swing.JLabel();
        labelSala = new javax.swing.JLabel();
        labelHorario = new javax.swing.JLabel();
        labelIngressos = new javax.swing.JLabel();
        textVendidos = new javax.swing.JTextField();
        labelFilme = new javax.swing.JLabel();
        comboSala = new javax.swing.JComboBox();
        labelData = new javax.swing.JLabel();
        buttonVenda = new javax.swing.JButton();
        buttonSessao = new javax.swing.JButton();
        buttonRelatorio = new javax.swing.JButton();
        comboData = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        buttonBanner.setText("banner");

        labelVenda.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelVenda.setText("Venda de Ingressos:");

        labelSala.setText("Sala:");

        labelHorario.setText("Horário:");

        labelIngressos.setText("Nº de Ingressos:");

        labelFilme.setText("Filme:");

        labelData.setText("Data:");

        buttonVenda.setText("Processar Venda");

        buttonSessao.setText("Adicionar Sessão");
        buttonSessao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSessaoActionPerformed(evt);
            }
        });

        buttonRelatorio.setText("Emitir Relatório");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelData)
                            .addComponent(labelFilme))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(comboData, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(labelSala)
                                .addGap(18, 18, 18)
                                .addComponent(comboSala, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(comboFilme, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(125, 125, 125)
                        .addComponent(labelVenda))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(labelIngressos)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textVendidos, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labelHorario)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(comboHorario, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(buttonSessao)
                                .addGap(18, 18, 18)
                                .addComponent(buttonRelatorio)))
                        .addGap(18, 18, 18)
                        .addComponent(buttonVenda)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(buttonBanner, javax.swing.GroupLayout.PREFERRED_SIZE, 441, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(buttonBanner, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelVenda)
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelData)
                    .addComponent(comboData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelSala)
                    .addComponent(comboSala, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelFilme)
                    .addComponent(comboFilme, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelIngressos)
                    .addComponent(textVendidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonVenda)
                    .addComponent(labelHorario)
                    .addComponent(comboHorario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonSessao)
                    .addComponent(buttonRelatorio))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonSessaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSessaoActionPerformed
        controller.openSessoes();
    }//GEN-LAST:event_buttonSessaoActionPerformed

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
            java.util.logging.Logger.getLogger(VendaIngressosView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VendaIngressosView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VendaIngressosView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VendaIngressosView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VendaIngressosView().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonBanner;
    private javax.swing.JButton buttonRelatorio;
    private javax.swing.JButton buttonSessao;
    private javax.swing.JButton buttonVenda;
    private javax.swing.JComboBox comboData;
    private javax.swing.JComboBox comboFilme;
    private javax.swing.JComboBox comboHorario;
    private javax.swing.JComboBox comboSala;
    private javax.swing.JLabel labelData;
    private javax.swing.JLabel labelFilme;
    private javax.swing.JLabel labelHorario;
    private javax.swing.JLabel labelIngressos;
    private javax.swing.JLabel labelSala;
    private javax.swing.JLabel labelVenda;
    private javax.swing.JTextField textVendidos;
    // End of variables declaration//GEN-END:variables
}
