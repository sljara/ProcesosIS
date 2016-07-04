/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
//commit
package proyec_prog_avanzada;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;


public class act_productos extends javax.swing.JFrame {
    Connection cn;
    PreparedStatement ps;
    ResultSet rs;
    ResultSetMetaData rsm;
    DefaultTableModel dtm;
    ArrayList<Object[]> datos = new ArrayList<Object[]>();
    
    String usr = "root";
    String pwd = "";
    String driver = "com.mysql.jdbc.Driver";
    String url = "jdbc:mysql://localhost/programacion";
    public act_productos() {
        initComponents();
        this.setTitle("Actualizar productos");
        this.setLocationRelativeTo(null);
//        JScrollPane sp = new JScrollPane(jTable1,
//           JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
//           JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
//        this.getContentPane().add(sp);        
    }//commit


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        productos = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnEliminar = new javax.swing.JButton();
        btnAtras = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        productos.setBorder(javax.swing.BorderFactory.createTitledBorder("Productos"));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Descripcion", "Stk minimo", "Stk maximo", "Precio"
            }
        ));
        jTable1.setColumnSelectionAllowed(true);
        jTable1.setPreferredSize(new java.awt.Dimension(350, 70));
        jScrollPane1.setViewportView(jTable1);
        jTable1.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnAtras.setText("Atras");
        btnAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtrasActionPerformed(evt);
            }
        });

        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout productosLayout = new javax.swing.GroupLayout(productos);
        productos.setLayout(productosLayout);
        productosLayout.setHorizontalGroup(
            productosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, productosLayout.createSequentialGroup()
                .addGap(91, 91, 91)
                .addComponent(btnActualizar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnEliminar)
                .addGap(18, 18, 18)
                .addComponent(btnAtras)
                .addGap(94, 94, 94))
            .addGroup(productosLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        productosLayout.setVerticalGroup(
            productosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(productosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
                .addGap(37, 37, 37)
                .addGroup(productosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEliminar)
                    .addComponent(btnAtras)
                    .addComponent(btnActualizar))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(productos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(productos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtrasActionPerformed
        productos ventana = new productos();
        ventana.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnAtrasActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        presentarDatos();
    }//GEN-LAST:event_formWindowOpened

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int fila = jTable1.getSelectedRow();
        int id = Integer.parseInt(String.valueOf(jTable1.getValueAt(fila, 0)));               
        conectar();        
        eliminarProducto(id);    
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        int fila = jTable1.getSelectedRow();
        int id = Integer.parseInt(String.valueOf(jTable1.getValueAt(fila, 0)));
        
        System.out.println("La fila a actualizar es: "+fila);
        System.out.println("El id del producto a eliminar es: "+id);        
        
        conectar();        
        actualizar(fila,id);   
        
    }//GEN-LAST:event_btnActualizarActionPerformed


    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new act_productos().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnAtras;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JPanel productos;
    // End of variables declaration//GEN-END:variables

    private void eliminarProducto(int id) {
        String sql=null;
        
        sql = "delete from productos where id = "+id; 
        
        try {
            
            ps = cn.prepareStatement(sql);                       
            int result = ps.executeUpdate();
            
            if (ps.executeUpdate()==0){
                JOptionPane.showMessageDialog(null,"Se ha eliminado los datos con exito");
            }else{
                JOptionPane.showMessageDialog(null,"No se han podido eliminar los datos");
            }   
            
            act_productos ventana = new act_productos();
            ventana.setVisible(true);
            this.setVisible(false);
            
            ps.close();
        }catch(Exception e) {
                System.out.println("Error al guardar los datos"+e);
        }        
    }
    
    private void presentarDatos(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            cn=DriverManager.getConnection("jdbc:mysql://localhost/programacion","root","");
            ps = cn.prepareStatement("select * from productos");
            rs = ps.executeQuery();
            rsm = rs.getMetaData();
            
            while (rs.next()) {                
                Object[] rows = new Object[rsm.getColumnCount()];
                for (int i = 0; i < rows.length; i++) {
                    rows[i]=rs.getObject(i+1);                    
                }
                datos.add(rows);
            }
            dtm = (DefaultTableModel) this.jTable1.getModel();
            for (int i = 0; i < datos.size(); i++) {
                dtm.addRow(datos.get(i));           
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e.getMessage());
        }        
    }

    private void conectar() {
        try {
            Class.forName(driver);
            cn = DriverManager.getConnection(url, usr, pwd);            
        }
        catch(Exception e) {
            e.getMessage();
        } 
    }

    private void actualizar(int fila,int id) {
        String sql = null ;
        
        int opcion = Integer.parseInt(JOptionPane.showInputDialog("Ingrese una opion: "
                + "\n1.-Cambiar nombre\n2.-Cambiar stk minimo\n3.-Cambiar stk maximo\n4.- Cambiar precio"));

        
        try {
            
        switch (opcion) {
            case 1:   
                String nombre = JOptionPane.showInputDialog("Ingrese el nuevo nombre: ");
                sql = "update productos set producto="+nombre+" where id_producto = "+id; 
                break;
            case 2:
                String stk_minimo = JOptionPane.showInputDialog("Ingrese la nueva cantidad: ");
                sql = "update productos set stk_minimo="+stk_minimo+" where id_producto = "+id;                        
                break;
            case 3:
                String stk_maximo = JOptionPane.showInputDialog("Ingrese la nueva cantidad: ");
                sql = "update productos set stk_maximo="+stk_maximo+" where id_producto = "+id;                                        
                break;
            case 4:
                String precio = JOptionPane.showInputDialog("Ingrese el nuevo precio: ");
                sql = "update productos set precio="+precio+" where id_producto = "+id; 
                break;                
        }
        
            ps = cn.prepareStatement(sql);                       
            int result = ps.executeUpdate();
            
            if (ps.executeUpdate()==1){
                JOptionPane.showMessageDialog(null,"Se ha registrado los datos con exito");
            }else{
                JOptionPane.showMessageDialog(null,"No se han ingreado datos");
            }   
            
            act_productos ventana = new act_productos();
            ventana.setVisible(true);            
            this.setVisible(false);
            
            ps.close();
            
        }catch(Exception e) {
                System.out.println("Error al guardar los datos"+e);
        }                
    }
    
}
