/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programa;
import java.awt.Component;
import java.awt.List;
import static java.lang.Integer.parseInt;
import javax.swing.DefaultListModel;
import java.sql.*;
import java.util.ArrayList;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author PC1
 */


public class frmlistararticulos extends javax.swing.JInternalFrame {

    
    /**
     * Creates new form frmlistararticulos
     */
    public frmlistararticulos() {
            
            initComponents();
           
            capaEdit.setVisible(false);
            llenarTabla();
        
       
    }
    public void llenarTabla(){
         try {
            Statement st = cn.createStatement();
            DefaultTableModel modeloTabla = new DefaultTableModel();
            //creando encabea de Tabla
            modeloTabla.setColumnIdentifiers(new Object[]{"ID","Nombre","Descripcion","Rubro","Cantidad","Precio"});
            
            tablaArticulos.setModel(modeloTabla);
            
            //Consultando a la DB para llenar de DATA los campos de la TABLA
            String sql2 = "SELECT a.id, a.nombre, a.desripcion, r.nombre, a.cantidad, a.precio FROM articulos a JOIN rubros r on a.rubro_id=r.id WHERE a.activo = '1'";
            ResultSet rsTabla = st.executeQuery(sql2);
            
            while (rsTabla.next()) {
               
                modeloTabla.addRow(new Object[]{rsTabla.getString("a.id"),rsTabla.getString("a.nombre"), rsTabla.getString("a.desripcion"), 
                    rsTabla.getString("r.nombre"), rsTabla.getString("a.cantidad"), rsTabla.getString("a.precio")});
            } 
            
            
        } catch (SQLException ex) {
            Logger.getLogger(frmlistararticulos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    DefaultComboBoxModel rubrosModel = new DefaultComboBoxModel();

    public int getRubro_id(String rubro) {
        int rubro_id = 0;   
        try {
            String selectId = "SELECT id FROM rubros WHERE nombre = '"+rubro+"';";
            Statement state = cn.createStatement();
            ResultSet rs1 = state.executeQuery(selectId);
            
            if (rs1.next()) {
               rubro_id = rs1.getInt(1);
            } else {
                
                System.out.println("NO SE ENCONTRO RUBRO");
            }
            
            
            } catch (SQLException ex) {
            Logger.getLogger(frmlistararticulos.class.getName()).log(Level.SEVERE, null, ex);
            }   
        
         return rubro_id;  
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        tablaArticulos = new javax.swing.JTable();
        btnNuevoArt = new javax.swing.JButton();
        btn_editArt = new javax.swing.JButton();
        txt_id = new javax.swing.JTextField();
        capaEdit = new javax.swing.JLayeredPane();
        rubrosComboBox = new javax.swing.JComboBox<>();
        btn_update = new javax.swing.JButton();
        lbl_rubro1 = new javax.swing.JLabel();
        lbl_descrip1 = new javax.swing.JLabel();
        txt_descripcion = new javax.swing.JTextField();
        txt_cantidad = new javax.swing.JTextField();
        txt_precio = new javax.swing.JTextField();
        lbl_cantidad1 = new javax.swing.JLabel();
        lbl_nombre1 = new javax.swing.JLabel();
        lbl_precio1 = new javax.swing.JLabel();
        txt_nombre = new javax.swing.JTextField();
        btn_exit = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        tablaArticulos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tablaArticulos);

        btnNuevoArt.setText("Nuevo Artículo");
        btnNuevoArt.setAlignmentY(0.0F);
        btnNuevoArt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoArtActionPerformed(evt);
            }
        });

        btn_editArt.setText("Editar Artículo");
        btn_editArt.setAlignmentY(0.0F);
        btn_editArt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editArtActionPerformed(evt);
            }
        });

        rubrosComboBox.setModel(rubrosModel);
        rubrosComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rubrosComboBoxActionPerformed(evt);
            }
        });

        btn_update.setText("Actualizar");
        btn_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_updateActionPerformed(evt);
            }
        });

        lbl_rubro1.setText("Rubro");

        lbl_descrip1.setText("Descripción");

        txt_precio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_precioActionPerformed(evt);
            }
        });

        lbl_cantidad1.setText("Cantidad");

        lbl_nombre1.setText("Nombre");

        lbl_precio1.setText("Precio");

        capaEdit.setLayer(rubrosComboBox, javax.swing.JLayeredPane.DEFAULT_LAYER);
        capaEdit.setLayer(btn_update, javax.swing.JLayeredPane.DEFAULT_LAYER);
        capaEdit.setLayer(lbl_rubro1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        capaEdit.setLayer(lbl_descrip1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        capaEdit.setLayer(txt_descripcion, javax.swing.JLayeredPane.DEFAULT_LAYER);
        capaEdit.setLayer(txt_cantidad, javax.swing.JLayeredPane.DEFAULT_LAYER);
        capaEdit.setLayer(txt_precio, javax.swing.JLayeredPane.DEFAULT_LAYER);
        capaEdit.setLayer(lbl_cantidad1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        capaEdit.setLayer(lbl_nombre1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        capaEdit.setLayer(lbl_precio1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        capaEdit.setLayer(txt_nombre, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout capaEditLayout = new javax.swing.GroupLayout(capaEdit);
        capaEdit.setLayout(capaEditLayout);
        capaEditLayout.setHorizontalGroup(
            capaEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(capaEditLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(capaEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(capaEditLayout.createSequentialGroup()
                        .addComponent(lbl_nombre1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(138, 138, 138)
                        .addComponent(lbl_descrip1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(capaEditLayout.createSequentialGroup()
                        .addGroup(capaEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(capaEditLayout.createSequentialGroup()
                                .addComponent(txt_cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txt_precio, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(capaEditLayout.createSequentialGroup()
                                .addComponent(lbl_cantidad1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lbl_precio1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btn_update))
                        .addGap(58, 58, 58)
                        .addGroup(capaEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(rubrosComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbl_rubro1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(capaEditLayout.createSequentialGroup()
                        .addComponent(txt_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)
                        .addComponent(txt_descripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(96, Short.MAX_VALUE))
        );
        capaEditLayout.setVerticalGroup(
            capaEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(capaEditLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(capaEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(capaEditLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(lbl_nombre1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(53, 53, 53))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, capaEditLayout.createSequentialGroup()
                        .addComponent(lbl_descrip1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(capaEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_descripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addGroup(capaEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lbl_cantidad1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbl_precio1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbl_rubro1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(capaEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_precio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rubrosComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(btn_update)))
                .addContainerGap(57, Short.MAX_VALUE))
        );

        btn_exit.setText("Cerrar");
        btn_exit.setAlignmentY(0.0F);
        btn_exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_exitActionPerformed(evt);
            }
        });

        jMenu1.setText("Archivo");

        jMenuItem1.setText("Salir");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(btnNuevoArt)
                                .addComponent(btn_editArt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btn_exit))
                        .addGap(50, 50, 50)
                        .addComponent(capaEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 644, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 884, Short.MAX_VALUE)
                .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(320, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(btn_editArt, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(btnNuevoArt)
                        .addGap(18, 18, 18)
                        .addComponent(btn_exit))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(capaEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(601, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void btnNuevoArtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoArtActionPerformed
        
        nuevoArticulo nArt = new nuevoArticulo();
        
        nArt.setVisible(true);
        nArt.show();
        
    }//GEN-LAST:event_btnNuevoArtActionPerformed

    private void btn_editArtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editArtActionPerformed
        // TODO add your handling code here:
        capaEdit.setVisible(true);
  
    
        int row = tablaArticulos.getSelectedRow();
        if(row>=0){
            String id = tablaArticulos.getValueAt(row, 0).toString();
            txt_id.setText(id);
            String nombre = tablaArticulos.getValueAt(row, 1).toString();
            txt_nombre.setText(nombre);
            String descripcion = tablaArticulos.getValueAt(row, 2).toString();
            txt_descripcion.setText(descripcion);
            String cantidad = tablaArticulos.getValueAt(row, 4).toString();
            txt_cantidad.setText(cantidad);
            String precio = tablaArticulos.getValueAt(row, 5).toString();
            txt_precio.setText(precio);
            String categoria = tablaArticulos.getValueAt(row,3).toString();
            
             try {
            String sql="Select * from rubros r";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            rubrosModel.addElement(categoria);
            rubrosComboBox.setModel(rubrosModel);
            
            while (rs.next()){
              String cat = rs.getString("r.nombre"); 
              if (!cat.equals(categoria)){
                rubrosModel.addElement(cat);
                rubrosComboBox.setModel(rubrosModel); 
              }
               
            }
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(frmlistararticulos.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        }
    }//GEN-LAST:event_btn_editArtActionPerformed

    private void rubrosComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rubrosComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rubrosComboBoxActionPerformed

    private void btn_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updateActionPerformed
        // TODO add your handling code here:
          String rubro = rubrosModel.getSelectedItem().toString();
            
            /* ASIGNO A VARIABLE LOS VALORES ACTUALIZADOS */
            int rubro_id = this.getRubro_id(rubro);
            int id =parseInt(txt_id.getText());
            String nombre = txt_nombre.getText();
            String descrip = txt_descripcion.getText();
            int cantidad = parseInt(txt_cantidad.getText());
            int precio = parseInt(txt_precio.getText());
            
            try {
            
                String sql="UPDATE `articulos` SET "
                        + "nombre = '"+nombre+"',"
                        + "desripcion = '"+descrip+"',"
                        + "cantidad = '"+cantidad+"',"
                        + "precio = '"+precio+"',"
                        + "rubro_id = '"+rubro_id+"'"
                        + "WHERE id = '"+id+"';";
                
                //UPDATE `articulos` SET `nombre`='test2',`desripcion`='test2',`cantidad`=999,`precio`=888,`rubro_id`=3,`activo`=1 WHERE id = 5;
                Statement st = cn.prepareStatement(sql);
                int filasModificadas = st.executeUpdate(sql);
                System.out.println(filasModificadas);
            } catch (SQLException ex) {
                Logger.getLogger(frmlistararticulos.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "No pudimos editar el artículo.");
            }
            JOptionPane.showMessageDialog(null, "Información de #articulo actualizada.");
            llenarTabla();
            capaEdit.setVisible(false);
          
    }//GEN-LAST:event_btn_updateActionPerformed

    private void txt_precioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_precioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_precioActionPerformed

    private void btn_exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_exitActionPerformed
        this.setVisible(false);        // TODO add your handling code here:
    }//GEN-LAST:event_btn_exitActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNuevoArt;
    private javax.swing.JButton btn_editArt;
    private javax.swing.JButton btn_exit;
    private javax.swing.JButton btn_update;
    private javax.swing.JLayeredPane capaEdit;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbl_cantidad1;
    private javax.swing.JLabel lbl_descrip1;
    private javax.swing.JLabel lbl_nombre1;
    private javax.swing.JLabel lbl_precio1;
    private javax.swing.JLabel lbl_rubro1;
    private javax.swing.JComboBox<String> rubrosComboBox;
    private javax.swing.JTable tablaArticulos;
    private javax.swing.JTextField txt_cantidad;
    private javax.swing.JTextField txt_descripcion;
    private javax.swing.JTextField txt_id;
    private javax.swing.JTextField txt_nombre;
    private javax.swing.JTextField txt_precio;
    // End of variables declaration//GEN-END:variables
    
    conectar cc = new conectar();
    Connection cn = cc.conexion();


}
