/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 *
 * @author sebastian
 */
public class vistaRegistro extends javax.swing.JFrame {

    /**
     * Creates new form vistaRegistro
     */
    public vistaRegistro() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        GrupBtnsPP = new javax.swing.ButtonGroup();
        GrupBtnsPS = new javax.swing.ButtonGroup();
        GrupBtnsCarrera = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        fieldUsuario = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        fieldPass = new javax.swing.JTextField();
        btnRegistrar = new javax.swing.JButton();
        botonAtras = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        textPP = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        textPS = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        radioGuerreroPP = new javax.swing.JRadioButton();
        radioArqueroPP = new javax.swing.JRadioButton();
        radioGuerreroPS = new javax.swing.JRadioButton();
        radioArqueroPS = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        radioCivil = new javax.swing.JRadioButton();
        radioEjecu = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel6.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 102, 0));
        jLabel6.setText("REGISTRO");

        jLabel2.setText("Ingrese usuario:");

        fieldUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldUsuarioActionPerformed(evt);
            }
        });

        jLabel3.setText("Ingrese contraseña:");

        btnRegistrar.setText("Registrarse");

        botonAtras.setText("Atras");

        jLabel5.setText("<html>Ingrese nombre <br>Personaje Principal:");

        textPP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textPPActionPerformed(evt);
            }
        });

        jLabel7.setText("<html>Eliga rol para su <br> Personaje Amigo:");

        jLabel9.setText("<html><center>Eliga un rol para su <br><center>Personaje Principal:");

        jLabel8.setText("<html>Ingrese nombre <br>Personaje Amigo:");

        GrupBtnsPP.add(radioGuerreroPP);
        radioGuerreroPP.setText("Guerrero");

        GrupBtnsPP.add(radioArqueroPP);
        radioArqueroPP.setText("Arquero");

        GrupBtnsPS.add(radioGuerreroPS);
        radioGuerreroPS.setText("Guerrero");
        radioGuerreroPS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioGuerreroPSActionPerformed(evt);
            }
        });

        GrupBtnsPS.add(radioArqueroPS);
        radioArqueroPS.setText("Arquero");
        radioArqueroPS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioArqueroPSActionPerformed(evt);
            }
        });

        jLabel1.setText("Carrera A elegir:");

        GrupBtnsCarrera.add(radioCivil);
        radioCivil.setText("Ingenieria Civil Informatica");
        radioCivil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioCivilActionPerformed(evt);
            }
        });

        GrupBtnsCarrera.add(radioEjecu);
        radioEjecu.setText("Ingeniería de Ejecución en Computación e Informática");
        radioEjecu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioEjecuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addComponent(btnRegistrar)
                        .addGap(256, 256, 256)
                        .addComponent(botonAtras))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(fieldUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
                            .addComponent(fieldPass))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(9, 9, 9)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(radioGuerreroPP)
                                    .addComponent(textPP, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(radioArqueroPP)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(6, 6, 6)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(radioGuerreroPS)
                                            .addComponent(radioArqueroPS)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(textPS, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel1))))))
                .addContainerGap(152, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(211, 211, 211))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(radioEjecu)
                            .addComponent(radioCivil, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(textPP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fieldUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(radioGuerreroPP)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(radioArqueroPP)))
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(fieldPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(textPS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(radioGuerreroPS)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(radioArqueroPS)))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(radioCivil, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(radioEjecu)
                .addGap(54, 54, 54)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnRegistrar)
                    .addComponent(botonAtras))
                .addContainerGap(44, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(28, 28, 28))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(23, 23, 23))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void fieldUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldUsuarioActionPerformed

    private void textPPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textPPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textPPActionPerformed

    private void radioGuerreroPSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioGuerreroPSActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radioGuerreroPSActionPerformed

    private void radioArqueroPSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioArqueroPSActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radioArqueroPSActionPerformed

    private void radioEjecuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioEjecuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radioEjecuActionPerformed

    private void radioCivilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioCivilActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radioCivilActionPerformed

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup GrupBtnsCarrera;
    private javax.swing.ButtonGroup GrupBtnsPP;
    private javax.swing.ButtonGroup GrupBtnsPS;
    private javax.swing.JButton botonAtras;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JTextField fieldPass;
    private javax.swing.JTextField fieldUsuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton radioArqueroPP;
    private javax.swing.JRadioButton radioArqueroPS;
    private javax.swing.JRadioButton radioCivil;
    private javax.swing.JRadioButton radioEjecu;
    private javax.swing.JRadioButton radioGuerreroPP;
    private javax.swing.JRadioButton radioGuerreroPS;
    private javax.swing.JTextField textPP;
    private javax.swing.JTextField textPS;
    // End of variables declaration//GEN-END:variables

    public JButton getRegistrar(){
      return this.btnRegistrar;
    }
    public JButton getBotonAtras(){
      return this.botonAtras;
    }

    public JTextField getFieldUsuario() {
        return fieldUsuario;
    }
    public JTextField getFieldPass() {
        return fieldPass;
    }
    
    public JTextField getTextPP() {
        return textPP;
    }

    public JTextField getTextPS() {
        return textPS;
    }

    public JRadioButton getRadioArqueroPP() {
        return radioArqueroPP;
    }

    public JRadioButton getRadioArqueroPS() {
        return radioArqueroPS;
    }

    public JRadioButton getRadioCivil() {
        return radioCivil;
    }

    public JRadioButton getRadioEjecu() {
        return radioEjecu;
    }

    public JRadioButton getRadioGuerreroPP() {
        return radioGuerreroPP;
    }

    public JRadioButton getRadioGuerreroPS() {
        return radioGuerreroPS;
    }

    public ButtonGroup getGrupBtnsCarrera() {
        return GrupBtnsCarrera;
    }

    public ButtonGroup getGrupBtnsPP() {
        return GrupBtnsPP;
    }

    public ButtonGroup getGrupBtnsPS() {
        return GrupBtnsPS;
    }

    
    
    
    public void ActionListener(ActionListener al){
        this.botonAtras.addActionListener(al);
        this.btnRegistrar.addActionListener(al);
    }  
}
