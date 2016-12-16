/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.UIManager;

/**
 *
 * @author Gabriel
 */
public class VistaTablero extends javax.swing.JFrame {

   ///////atributos/////////////////////
    public JButton[][] matrizVista; //matriz de botones
    
 
////////Constructor////////////////    
    public VistaTablero() {
        try{
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        }
        catch(Exception e){
            e.printStackTrace();
        }
        initComponents();
        setLocationRelativeTo(null);
        crearEscenario();
        //this.setPreferredSize(new Dimension(800,700));
    }
     public JButton[][] getCoordenadas() {
        return matrizVista;
    }
     

    public void setCoordenadas(JButton[][] coordenadas) {
        this.matrizVista = coordenadas;
    }
    
    public JButton [][] crearEscenario(){
       jPanel1.setLayout(new GridLayout(25,25)); //se le da forma de matriz al panel 
       jPanel1.setPreferredSize(new Dimension(650, 650));
        matrizVista = new JButton[25][25]; //se crea un arreglo de arreglo de botones de 25x25
        for(int i = 0; i<25;i++){
            for(int j = 0; j<25; j++){
                matrizVista[i][j] = new JButton(); //Se instancian coordenadas
                matrizVista[i][j].setMargin(new Insets(2, 2, 2, 2));
                jPanel1.add(matrizVista[i][j]);
                //Se agregan botones al panel
                matrizVista[i][j].setPreferredSize(new Dimension(25, 25));
                
                //matrizVista[i][j].setBorder(null);
                //matrizVista[i][j].setOpaque(true);
                //matrizVista[i][j].setBorderPainted(false);
            }
        }
    return matrizVista;
    }
    
    
   
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnRegresarVT = new javax.swing.JButton();
        btnAtacar = new javax.swing.JButton();
        btnMover = new javax.swing.JButton();
        btnTerminar = new javax.swing.JButton();
        btnVerificarTerminar = new javax.swing.JButton();
        btnCancelarTerminar = new javax.swing.JButton();
        btnCancelarAtacar = new javax.swing.JButton();
        btnCancelarMover = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1000, 700));
        setResizable(false);
        getContentPane().setLayout(null);

        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 600, 600);

        btnRegresarVT.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 24)); // NOI18N
        btnRegresarVT.setText("Regresar");
        btnRegresarVT.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(102, 102, 255)));
        btnRegresarVT.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(btnRegresarVT);
        btnRegresarVT.setBounds(618, 6, 107, 36);

        btnAtacar.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 24)); // NOI18N
        btnAtacar.setText("Atacar");
        btnAtacar.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(102, 102, 255)));
        btnAtacar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(btnAtacar);
        btnAtacar.setBounds(618, 54, 368, 36);

        btnMover.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 24)); // NOI18N
        btnMover.setText("Mover");
        btnMover.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(102, 102, 255)));
        btnMover.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(btnMover);
        btnMover.setBounds(618, 144, 368, 36);

        btnTerminar.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 24)); // NOI18N
        btnTerminar.setText("Terminar Turno");
        btnTerminar.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(102, 102, 255)));
        btnTerminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(btnTerminar);
        btnTerminar.setBounds(618, 234, 368, 36);

        btnVerificarTerminar.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 24)); // NOI18N
        btnVerificarTerminar.setText("Aceptar");
        btnVerificarTerminar.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(102, 102, 255)));
        btnVerificarTerminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(btnVerificarTerminar);
        btnVerificarTerminar.setBounds(618, 276, 95, 36);

        btnCancelarTerminar.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 24)); // NOI18N
        btnCancelarTerminar.setText("Cancelar");
        btnCancelarTerminar.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(102, 102, 255)));
        btnCancelarTerminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(btnCancelarTerminar);
        btnCancelarTerminar.setBounds(880, 276, 106, 36);

        btnCancelarAtacar.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 24)); // NOI18N
        btnCancelarAtacar.setText("Cancelar Ataque");
        btnCancelarAtacar.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(102, 102, 255)));
        btnCancelarAtacar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(btnCancelarAtacar);
        btnCancelarAtacar.setBounds(618, 96, 368, 36);

        btnCancelarMover.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 24)); // NOI18N
        btnCancelarMover.setText("Cancelar Movimiento");
        btnCancelarMover.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(102, 102, 255)));
        btnCancelarMover.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(btnCancelarMover);
        btnCancelarMover.setBounds(618, 186, 368, 36);
        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(618, 485, 368, 209);

        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(780, 390, 45, 16);

        jLabel2.setText("jLabel2");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(780, 410, 45, 16);

        jLabel3.setText("jLabel3");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(780, 360, 45, 16);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtacar;
    private javax.swing.JButton btnCancelarAtacar;
    private javax.swing.JButton btnCancelarMover;
    private javax.swing.JButton btnCancelarTerminar;
    private javax.swing.JButton btnMover;
    private javax.swing.JButton btnRegresarVT;
    private javax.swing.JButton btnTerminar;
    private javax.swing.JButton btnVerificarTerminar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    public void agregarListener(ActionListener al){ //metodo que escucha botones
        
        btnRegresarVT.addActionListener(al);
        btnMover.addActionListener(al);
        btnCancelarMover.addActionListener(al);
        btnAtacar.addActionListener(al);
        btnCancelarAtacar.addActionListener(al);
        btnTerminar.addActionListener(al);
        btnVerificarTerminar.addActionListener(al);
        btnCancelarTerminar.addActionListener(al);
        
        
        
        
        
        for(int i= 0; i<25; i++){
            for(int j= 0; j<25;j++){
                matrizVista[i][j].setFocusPainted(true);
                matrizVista[i][j].addActionListener(al);
                //escucha a todos los botones de la matriz
                matrizVista[i][j].setOpaque(true);

            }
        }
    }
    
    
    
    public void agregarMouseListener(MouseListener m){ //metodo que escucha botones
        for(int i= 0; i<25; i++){
            for(int j= 0; j<25;j++){
                
                matrizVista[i][j].addMouseListener(m);
                
                

            }
        }
    }
    public JButton getBtnTerminar() {
        return this.btnTerminar;
    }
    
    public JButton getBtnCancelarTerminar(){
        return this.btnCancelarTerminar;
    }
    
    public JButton getBtnVerificarTerminar(){
        return this.btnVerificarTerminar;
    }

    public JButton getBtnRegresarVT() {
        return this.btnRegresarVT;
    }

    public JButton[][] getMatrizVista() {
        return this.matrizVista;
    }

    public JButton getBtnAtacar() {
        return this.btnAtacar;
    }
    
    public JButton getBtnCancelarAtacar(){
        return this.btnCancelarAtacar;
    }

    public JButton getBtnMover() {
        return this.btnMover;
    }
    
    public JButton getBtnCancelarMover(){
        return this.btnCancelarMover;
    }

    
   
    

    
  
    
    
    
    
    
}














