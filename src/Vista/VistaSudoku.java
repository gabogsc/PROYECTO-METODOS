/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JPanel;


/**
 *
 * @author Carlos
 */
public class VistaSudoku extends javax.swing.JFrame {



    /**
     * Creates new form VistaSudoku
     */
    public VistaSudoku() {
        initComponents();
        setLocationRelativeTo(null);
    }
    
    /*Atributos
    */
    private JButton[][] tableroVista =new JButton[9][9];

    public JButton[][] getTableroVista() {
        return tableroVista;
    }
    
    public void activarBotonesTablero(boolean bool){
        for(int i=0;i<9;i++)
            for(int j=0;j<9;j++){
                tableroVista[i][j].setEnabled(bool);
            }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelTablero = new javax.swing.JPanel();
        btn1 = new javax.swing.JButton();
        btn2 = new javax.swing.JButton();
        btn3 = new javax.swing.JButton();
        btn4 = new javax.swing.JButton();
        btn5 = new javax.swing.JButton();
        btn6 = new javax.swing.JButton();
        btn7 = new javax.swing.JButton();
        btn8 = new javax.swing.JButton();
        btn9 = new javax.swing.JButton();
        btnTerminar = new javax.swing.JButton();
        btnRegresarDificultades = new javax.swing.JButton();
        btnVaciar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 204, 204));

        panelTablero.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        panelTablero.setPreferredSize(new java.awt.Dimension(400, 400));

        javax.swing.GroupLayout panelTableroLayout = new javax.swing.GroupLayout(panelTablero);
        panelTablero.setLayout(panelTableroLayout);
        panelTableroLayout.setHorizontalGroup(
            panelTableroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );
        panelTableroLayout.setVerticalGroup(
            panelTableroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );

        btn1.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 24)); // NOI18N
        btn1.setText("1");
        btn1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn1ActionPerformed(evt);
            }
        });

        btn2.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 24)); // NOI18N
        btn2.setText("2");
        btn2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btn3.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 24)); // NOI18N
        btn3.setText("3");
        btn3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btn4.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 24)); // NOI18N
        btn4.setText("4");
        btn4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btn5.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 24)); // NOI18N
        btn5.setText("5");
        btn5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btn6.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 24)); // NOI18N
        btn6.setText("6");
        btn6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btn7.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 24)); // NOI18N
        btn7.setText("7");
        btn7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btn8.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 24)); // NOI18N
        btn8.setText("8");
        btn8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btn9.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 24)); // NOI18N
        btn9.setText("9");
        btn9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btnTerminar.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 36)); // NOI18N
        btnTerminar.setText("Terminar");
        btnTerminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnTerminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTerminarActionPerformed(evt);
            }
        });

        btnRegresarDificultades.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 24)); // NOI18N
        btnRegresarDificultades.setText("Regresar");
        btnRegresarDificultades.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btnVaciar.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 24)); // NOI18N
        btnVaciar.setText("Vaciar");
        btnVaciar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(156, 156, 156)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn9, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnVaciar, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panelTablero, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(169, 169, 169)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnTerminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnRegresarDificultades, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(57, 57, 57))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelTablero, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnRegresarDificultades, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(217, 217, 217)
                        .addComponent(btnTerminar, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnVaciar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btn1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btn2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(48, Short.MAX_VALUE))
        );

        panelTablero.setLayout(new GridLayout(9,9));
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                tableroVista[i][j]=new JButton();
                panelTablero.add(tableroVista[i][j]);
            }
        }

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn1ActionPerformed

    private void btnTerminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTerminarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnTerminarActionPerformed

    //Metodos
    
    /* Añadir listeners a cada boton de la pantalla de la vista del tablero
    sudoku, que corresponden a cada casilla de este ultimo
    */
    public void setListener(ActionListener aL){
        btn1.addActionListener(aL);
        btn2.addActionListener(aL);
        btn3.addActionListener(aL);
        btn4.addActionListener(aL);
        btn5.addActionListener(aL);
        btn6.addActionListener(aL);
        btn7.addActionListener(aL);
        btn8.addActionListener(aL);
        btn9.addActionListener(aL);
        btnTerminar.addActionListener(aL);
        btnVaciar.addActionListener(aL);
        btnRegresarDificultades.addActionListener(aL);
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                tableroVista[i][j].addActionListener(aL);
            }
        }
  }
  
    public JPanel getPanel() {
        return panelTablero;
    }
    
    public void hablitarBtnTerminar(){
        btnTerminar.setEnabled(true);
    }
    
    public void deshabilitarBtnTerminar(){
        btnTerminar.setEnabled(false);
    }
    
    /* Cambiar el valor de la casilla
    */
    public void setButtonText(int valor, int i, int j){
        tableroVista[i][j].setText("" + valor);
    }

    public JButton getBtnTerminar() {
        return btnTerminar;
    }
    
    public JButton getBtnVaciar(){
        return btnVaciar;
    }
    
    public JButton getBtnRegresarNiveles(){
        return btnRegresarDificultades;
    }
    
    /* Metodos relacionados con los botones de la parte inferior de la vista
    */
    
    //Deshablitiar opciones
    
    public void DeshablitarBtn1(){
        btn1.setEnabled(false);
    }
    public void DeshablitarBtn2(){
        btn2.setEnabled(false);
    }
    public void DeshablitarBtn3(){
        btn3.setEnabled(false);
    }
    public void DeshablitarBtn4(){
        btn4.setEnabled(false);
    }
    public void DeshablitarBtn5(){
        btn5.setEnabled(false);
    }
    public void DeshablitarBtn6(){
        btn6.setEnabled(false);
    }
    public void DeshablitarBtn7(){
        btn7.setEnabled(false);
    }
    public void DeshablitarBtn8(){
        btn8.setEnabled(false);
    }
    public void DeshablitarBtn9(){
        btn9.setEnabled(false);
    }
    
    //Hablitiar opciones
    public void habilitarOpciones(){
        btn1.setEnabled(true);
        btn2.setEnabled(true);
        btn3.setEnabled(true);
        btn4.setEnabled(true);
        btn5.setEnabled(true);
        btn6.setEnabled(true);
        btn7.setEnabled(true);
        btn8.setEnabled(true);
        btn9.setEnabled(true);
    }
    
    //Metodo para obtener los botones pares
    
    public ArrayList<JButton> getBtnPares(){
        ArrayList<JButton> btnPares = new ArrayList<>();
        btnPares.add(btn2);
        btnPares.add(btn4);
        btnPares.add(btn6);
        btnPares.add(btn8);
        
        return btnPares;
    }
    
    //Metodo para obtener los botones imppares
    
    public ArrayList<JButton> getBtnImpares(){
        ArrayList<JButton> btnImpares = new ArrayList<>();
        btnImpares.add(btn1);
        btnImpares.add(btn3);
        btnImpares.add(btn5);
        btnImpares.add(btn7);
        btnImpares.add(btn9);
        
        return btnImpares;
    }
           
    
   


    
    


    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn1;
    private javax.swing.JButton btn2;
    private javax.swing.JButton btn3;
    private javax.swing.JButton btn4;
    private javax.swing.JButton btn5;
    private javax.swing.JButton btn6;
    private javax.swing.JButton btn7;
    private javax.swing.JButton btn8;
    private javax.swing.JButton btn9;
    private javax.swing.JButton btnRegresarDificultades;
    private javax.swing.JButton btnTerminar;
    private javax.swing.JButton btnVaciar;
    private javax.swing.JPanel panelTablero;
    // End of variables declaration//GEN-END:variables

   
   

   

    
    

        
        
   
    
}
