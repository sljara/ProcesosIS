package proyec_prog_avanzada;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class pedidos extends javax.swing.JFrame {
    Connection conexion = null;
    PreparedStatement sentencia = null; 
    ResultSet resultado = null;
    String usr = "root";
    String pwd = "";
    String driver = "com.mysql.jdbc.Driver";
    String url = "jdbc:mysql://localhost/programacion";
    
    String codigo_producto;
    String producto;
    int cantidad_prod;
    double valorUnit;
    double totalProducto;    
    
    public pedidos() {
        initComponents();
        this.setTitle("Pedidos");
        this.setLocationRelativeTo(null);
        Date fecha = new Date();
        SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yyyy");
        jblFecha.setText(""+sd.format(fecha));  
        txtNombres.setEditable(false);
        txtApellidos.setEditable(false);
        txtDireccion.setEditable(false);
        txtTelefono.setEditable(false);
        jcbZona.setEditable(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpFactura = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtNombres = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtCedula = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        btnBuscarCliente = new javax.swing.JButton();
        jblFecha = new javax.swing.JLabel();
        jblNumFac = new javax.swing.JLabel();
        btnRegistrar = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        txtApellidos = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jcbZona = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        txt_Fecha_Entrega = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaProductos = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        txt_total = new javax.swing.JTextField();
        btnAgregar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        btn_Registrar_pedido = new javax.swing.JButton();
        btnImprimir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jpFactura.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "DATOS DEL CLIENTE", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("NOMBRES : ");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("CEDULA / RUC :");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("DIRECCIÓN :");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("FECHA EMISION: ");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("PEDIDO Nº : ");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("TELÉFONO: ");

        btnBuscarCliente.setText("Buscar");
        btnBuscarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarClienteActionPerformed(evt);
            }
        });

        jblFecha.setText("jLabel11");

        jblNumFac.setText("001");

        btnRegistrar.setText("Registrar Cliente");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("ZONA:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("APELLIDOS:");

        jcbZona.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Norte", "Sur", "Este", "Oeste", "Centro" }));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("FECHA ENTREGA:");

        txt_Fecha_Entrega.setText("__/__/____");

        javax.swing.GroupLayout jpFacturaLayout = new javax.swing.GroupLayout(jpFactura);
        jpFactura.setLayout(jpFacturaLayout);
        jpFacturaLayout.setHorizontalGroup(
            jpFacturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpFacturaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpFacturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpFacturaLayout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnBuscarCliente)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRegistrar)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jpFacturaLayout.createSequentialGroup()
                        .addGroup(jpFacturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jpFacturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtApellidos)
                            .addComponent(txtNombres, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtDireccion, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(40, 40, 40)
                        .addGroup(jpFacturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jpFacturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtTelefono)
                            .addComponent(jcbZona, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())
                    .addGroup(jpFacturaLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(jblNumFac)
                        .addGap(37, 37, 37)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jblFecha)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_Fecha_Entrega, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jpFacturaLayout.setVerticalGroup(
            jpFacturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpFacturaLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jpFacturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4)
                    .addComponent(jblFecha)
                    .addComponent(jblNumFac)
                    .addComponent(jLabel8)
                    .addComponent(txt_Fecha_Entrega, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jpFacturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpFacturaLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(jpFacturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpFacturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnBuscarCliente)
                        .addComponent(btnRegistrar)))
                .addGap(18, 18, 18)
                .addGroup(jpFacturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel6)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jpFacturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jcbZona, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jpFacturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "DATOS DEL PEDIDO", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        TablaProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Producto", "Cantidad", "P. Unitario", "P. Total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Double.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(TablaProductos);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("Total a Pagar :");

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        jButton2.setText("Cancelar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        btn_Registrar_pedido.setText("Registrar");
        btn_Registrar_pedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Registrar_pedidoActionPerformed(evt);
            }
        });

        btnImprimir.setText("Imprimir");
        btnImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel10)
                        .addGap(18, 18, 18)
                        .addComponent(txt_total, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 561, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAgregar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(117, 117, 117)
                .addComponent(btn_Registrar_pedido)
                .addGap(18, 18, 18)
                .addComponent(btnImprimir)
                .addGap(18, 18, 18)
                .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(325, 325, 325))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(btnAgregar)
                        .addGap(4, 4, 4)
                        .addComponent(btnEliminar))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_total, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))))
                .addGap(38, 38, 38)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_Registrar_pedido)
                    .addComponent(jButton2)
                    .addComponent(btnImprimir))
                .addContainerGap(43, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpFactura, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jpFactura, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarClienteActionPerformed
        //System.out.println(txtCedula.getText());
        String op;
        try {
            String sql = "select nombres, apellidos,direccion,telefono,zona from cliente where cedula = '"+txtCedula.getText()+"'";
            sentencia = conexion.prepareStatement(sql);
            resultado = sentencia.executeQuery();
            if (resultado.next()){
                txtNombres.setText(resultado.getString("nombres")+" "+resultado.getString("apellidos"));
                txtDireccion.setText(resultado.getString("direccion"));
                txtTelefono.setText(resultado.getString("telefono"));  
                jcbZona.setSelectedItem(resultado.getString("zona"));              
            }else{
                op=JOptionPane.showInputDialog("El cliente no esta registado. Desea registrarlos\nSI\nNO");
                if(op.equals("SI")||op.equals("si")){
                    habilitarGuardar();
                }
            }

        } catch (Exception e) {
        }        

    }//GEN-LAST:event_btnBuscarClienteActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        if(txtCedula.getText().equals("")&&
           txtNombres.getText().equals("")&&
           txtApellidos.getText().equals("")&&
           txtDireccion.getText().equals("")&&
           txtTelefono.getText().equals("")){
            
            JOptionPane.showMessageDialog(null, "No se ingresaron datos");
            
        }else{
            try {

                Class.forName(driver);
                conexion = DriverManager.getConnection(url, usr, pwd);   
                String sql = "INSERT INTO cliente VALUES ('"+txtCedula.getText()+"',"
                        + "                                '"+txtNombres.getText()+"',"
                        + "                                '"+txtApellidos.getText()+"',"
                        + "                                '"+txtDireccion.getText()+"',"
                        + "                                '"+txtTelefono.getText()+"',"
                        + "                                '"+jcbZona.getSelectedItem().toString()+"')";

                sentencia = conexion.prepareStatement(sql);
                int result = sentencia.executeUpdate();

                if (result == 1){
                    JOptionPane.showMessageDialog(null,"Se ha registrado los datos con exito");
                }else{
                    JOptionPane.showMessageDialog(null,"No se han ingreado datos");
                }   
            }catch(Exception e) {
                    System.out.println(e);
            }             
        } 
        
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        administrador ventana = new administrador();
        ventana.setVisible(true);
        this.setVisible(false);

    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        agregarProducto();
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int fila = TablaProductos.getSelectedRow();
        int id = Integer.parseInt(String.valueOf(TablaProductos.getValueAt(fila, 0)));                    
        eliminarProducto(id);   
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        jblNumFac.setText(generarPedido());
        
    }//GEN-LAST:event_formWindowOpened
//
    private void btn_Registrar_pedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Registrar_pedidoActionPerformed
        
        String fecha = txt_Fecha_Entrega.getText();
        String id_busca;
        DefaultTableModel productosFila = (DefaultTableModel) TablaProductos.getModel();
        productosFila = (DefaultTableModel) TablaProductos.getModel();          
        
//        System.out.println(fecha);
//        System.out.println(jblFecha.getText());
        try {
            Class.forName(driver);
            conexion = DriverManager.getConnection(url, usr, pwd);             
           
            int numFil=TablaProductos.getRowCount();
            boolean esVerdad=true;
            
            Statement sentenciaExistencia = conexion.createStatement();
            ResultSet resultadoExistencia;
            
            System.out.println("El numero de filas es: "+numFil);
            for (int i = 0; i < numFil; i++) 
            {
                String producto = new String(TablaProductos.getValueAt(i, 1).toString());
                sentenciaExistencia.executeQuery("select existencias from existencias where producto='"+producto+"'");
                resultadoExistencia = sentenciaExistencia.getResultSet();
                resultadoExistencia.first();
                
                int cantidad_Producto = Integer.parseInt(TablaProductos.getValueAt(i, 2).toString());
                
                if(resultadoExistencia.getInt("existencias")<cantidad_Producto){
                    esVerdad=false;
                    JOptionPane.showMessageDialog(null,"La cantidad de "+TablaProductos.getValueAt(i,2).toString()
                            +", ingresada para el Articulo "+TablaProductos.getValueAt(i,1).toString()
                            +" supera su existencia actual que solo llega a "+resultadoExistencia.getString("stock")
                            +"!","Stock insuficiente",2);
                }
            }
            
            if(esVerdad=true){
                Statement sentenciaActualizar = conexion.createStatement();
                Statement sentenciaActPedido = conexion.createStatement();
                sentenciaActualizar.executeUpdate("INSERT INTO pedido "
                        + "(pedido_id,cliente,fecha_pedido,fecha_entrega) values('"+jblNumFac.getText()+"','"+txtNombres.getText()+"','"+jblFecha.getText()+"','"+txt_Fecha_Entrega.getText()+"')");
                
                for (int j = 0; j < numFil; j++) 
                {
                    
                    System.out.println(TablaProductos.getValueAt(j, 1));
                    System.out.println(TablaProductos.getValueAt(j, 2));
                    System.out.println(TablaProductos.getValueAt(j, 4));
                    System.out.println(txt_total.getText());
                    
                    double total=0;
                    DecimalFormat df = new DecimalFormat("#.##");
                    df.format(total);
                    total = total+Double.parseDouble(String.valueOf(TablaProductos.getValueAt(j, 4)));
                    
                    sentenciaActPedido.executeUpdate("INSERT INTO detalle_pedido VALUES(null,"+jblNumFac.getText()+",'"+TablaProductos.getValueAt(j, 1) +"',"+TablaProductos.getValueAt(j, 2) +","+TablaProductos.getValueAt(j, 4)+","+total+",'Pedido')");
                    sentenciaActPedido.executeUpdate("update existencias "
                            + "set existencias = existencias -"
                            +TablaProductos.getValueAt(j, 2)+" "
                            + "where producto = '"+TablaProductos.getValueAt(j, 1)+"'");
                }
            }
            
            
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    
                   
    }//GEN-LAST:event_btn_Registrar_pedidoActionPerformed

    private void btnImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirActionPerformed
       
    }//GEN-LAST:event_btnImprimirActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new pedidos().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TablaProductos;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnBuscarCliente;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnImprimir;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JButton btn_Registrar_pedido;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jblFecha;
    private javax.swing.JLabel jblNumFac;
    private javax.swing.JComboBox jcbZona;
    private javax.swing.JPanel jpFactura;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtNombres;
    private javax.swing.JTextField txtTelefono;
    private javax.swing.JTextField txt_Fecha_Entrega;
    private javax.swing.JTextField txt_total;
    // End of variables declaration//GEN-END:variables

    private String generarPedido() {
        String pedido="";
        String sqlPedido;
        String cadena=null;
        DecimalFormat df = new DecimalFormat("0000");
        int nro;
        
        
        try {
            Class.forName(driver);
            conexion = DriverManager.getConnection(url, usr, pwd);
            sqlPedido = "select max(pedido_id) from pedido";
            Statement st = conexion.createStatement();
            resultado = st.executeQuery(sqlPedido);
            
            if(resultado.next()){
                cadena=resultado.getString("max(pedido_id)");
                nro = Integer.parseInt(cadena)+1;
                pedido = df.format(nro);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(pedidos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(pedidos.class.getName()).log(Level.SEVERE, null, ex);
        }        
        return pedido;        
    }

    private void habilitarGuardar() {
        txtNombres.setEditable(true);
        txtApellidos.setEditable(true);
        txtDireccion.setEditable(true);
        txtTelefono.setEditable(true);
        jcbZona.setEditable(true);                
    }

    void agregarProducto() {
        int cantidad=0;
        String fecha;
        DefaultTableModel productosFila = (DefaultTableModel) TablaProductos.getModel();
        productosFila = (DefaultTableModel) TablaProductos.getModel(); 
        
        try {
            Class.forName(driver);
            conexion = DriverManager.getConnection(url, usr, pwd); 
            
            producto = JOptionPane.showInputDialog("Ingrese el nombre del producto");            
            cantidad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad"));
            
            String sql = "select id_producto,nombre_producto,precio_producto "
                    + "   from productos where nombre_producto = '"+producto+"'";
            
            Object arrProducto []= new Object[5];
            ArrayList productos = new ArrayList();
            

            Statement st = conexion.createStatement();
            resultado = st.executeQuery(sql);
            
            while (resultado.next()) { 
//                System.out.println(resultado.getString("nombre_producto"));
                codigo_producto = resultado.getString("id_producto");
                producto = resultado.getString("nombre_producto");
                cantidad_prod = cantidad;
                valorUnit = Double.parseDouble(String.valueOf(resultado.getString("precio_producto")));
                        
                arrProducto[0]=codigo_producto;
                arrProducto[1]=producto;
                arrProducto[2]=cantidad_prod;
                arrProducto[3]=valorUnit;
                arrProducto[4]= total(cantidad_prod,valorUnit);
                
                productosFila.addRow(arrProducto);
            }
            TablaProductos.setModel(productosFila);
            totalPedido();
            
        } catch (SQLException ex) {
            Logger.getLogger(pedidos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(pedidos.class.getName()).log(Level.SEVERE, null, ex);
        }                         
    }

    private Object total(int cantidad_prod, double valorUnit) {
        totalProducto = cantidad_prod*valorUnit;
        return totalProducto;
    }

    private void totalPedido() {
        double suma = 0;
                
        DecimalFormat dt = new DecimalFormat("#.##");
        for (int i = 0; i < TablaProductos.getRowCount(); i++) {
            suma = suma + Double.parseDouble(String.valueOf(TablaProductos.getValueAt(i, 4)));            
        }
        
        txt_total.setText(dt.format(suma));
    }

    private void eliminarProducto(int id) {
        DefaultTableModel productosFila = (DefaultTableModel) TablaProductos.getModel();
        productosFila = (DefaultTableModel) TablaProductos.getModel();
        
        productosFila.removeRow(TablaProductos.getRowCount()-1);
        
        txt_total.setText("");
        
    }
}
