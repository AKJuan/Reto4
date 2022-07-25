
package Interface;

import Modelo.*;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

public class Menu extends javax.swing.JFrame {
    
    Conexion con= new Conexion();
    Connection cn;
    Statement st;
    ResultSet rs;
    DefaultTableModel contenidoTabla;
    
    
    public void listaEmpleados(){
        String nombre= txtBuscarEmpleado.getText();
        if(nombre.isEmpty()){
            
            String queryConsulta= "SELECT * FROM empleaados";
        
            try{
                cn = con.getConnection();
                //Creamos el queryConsulta
                st = cn.createStatement();
                // Ejecutamos el query que contiene la variable queryConsulta
                rs = st.executeQuery(queryConsulta);
                // Creamos un objeto que almacena todos los registros de empleados
                // que existen en la base de datos
                Object[] empleados = new Object[6];
                contenidoTabla =(DefaultTableModel)tblEmpleados.getModel();
                // Mientras el resultado del queryConsulta encuentre registros en la
                // base de datos se ingresa al while
                while(rs.next()){
                    empleados[0] = rs.getInt("idempleado");
                    empleados[1] = rs.getString("nombre");
                    empleados[2] = rs.getString("apelldio");
                    empleados[3] = rs.getString("tipodocumento");
                    empleados[4] = rs.getString("documento");
                    empleados[5] = rs.getString("correo");
                    contenidoTabla.addRow(empleados);
                    System.out.println(rs.getInt("idempleado") + " " 
                            + rs.getString("nombre") + " " + rs.getString("apelldio"));
                }
                tblEmpleados.setModel(contenidoTabla);
            }catch(SQLException e){
                System.out.println("Error JAJJAJA!");
            }
        }else{
            String query="SELECT * FROM `empleaados` WHERE nombre LIKE '%"+nombre+"%' OR apelldio LIKE '%"+nombre+"%';";
            try{
                cn = con.getConnection();
                //Creamos el queryConsulta
                st = cn.createStatement();
                // Ejecutamos el query que contiene la variable queryConsulta
                rs = st.executeQuery(query);
                // Creamos un objeto que almacena todos los registros de empleados
                // que existen en la base de datos
                Object[] empleados = new Object[6];
                contenidoTabla =(DefaultTableModel)tblEmpleados.getModel();
                // Mientras el resultado del queryConsulta encuentre registros en la
                // base de datos se ingresa al while
                while(rs.next()){
                    empleados[0] = rs.getInt("idempleado");
                    empleados[1] = rs.getString("nombre");
                    empleados[2] = rs.getString("apelldio");
                    empleados[3] = rs.getString("tipodocumento");
                    empleados[4] = rs.getString("documento");
                    empleados[5] = rs.getString("correo");
                    contenidoTabla.addRow(empleados);
                    System.out.println(rs.getInt("idempleado") + " " 
                            + rs.getString("nombre") + " " + rs.getString("apelldio"));
                }
                tblEmpleados.setModel(contenidoTabla);
            }catch(SQLException e){
                System.out.println("Error JAJJAJA!");
            }
        }
        
        

    }
    
    public void borrarDatosTabla() {
        for (int i = 0; i < tblEmpleados.getRowCount(); i++) {
            //Eliminamos todos los registros de empleados que tiene la tabla
            contenidoTabla.removeRow(i);
            i = i-1;
        }
    }

    public Menu() {
        initComponents();
        this.setLocationRelativeTo(this);
        listaEmpleados();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblEmpleados = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btnUserform = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtBuscarEmpleado = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));

        tblEmpleados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombres", "Apellidos", "Tipo documento", "Documento", "Correo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblEmpleados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblEmpleadosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblEmpleados);

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Usuario\\Documents\\NetBeansProjects\\Reto\\src\\main\\java\\Assets\\logo.png")); // NOI18N

        btnUserform.setIcon(new javax.swing.ImageIcon("C:\\Users\\Usuario\\Documents\\NetBeansProjects\\Reto\\src\\main\\java\\Assets\\avatar (1).png")); // NOI18N
        btnUserform.setText("Crear");
        btnUserform.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUserformActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Arial", 1, 22)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Lista de Empleados");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Buscar");

        txtBuscarEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarEmpleadoActionPerformed(evt);
            }
        });

        btnSearch.setIcon(new javax.swing.ImageIcon("C:\\Users\\Usuario\\Documents\\NetBeansProjects\\Reto\\src\\main\\java\\Assets\\showUser.png")); // NOI18N
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(133, 133, 133)
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addGap(79, 79, 79)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtBuscarEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnSearch)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnUserform))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addGap(44, 44, 44)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 689, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtBuscarEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnUserform, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
                .addGap(17, 17, 17))
        );

        jTabbedPane1.addTab("Home", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnUserformActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUserformActionPerformed
        // TODO add your handling code here:
        borrarDatosTabla();
        listaEmpleados();
        UserForm userform=new UserForm();
        userform.setVisible(true);     
    }//GEN-LAST:event_btnUserformActionPerformed

    private void tblEmpleadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblEmpleadosMouseClicked
        int numerorow = tblEmpleados.getSelectedRow();
        System.out.println(numerorow);
        

            int idempleado = Integer.parseInt(tblEmpleados.getValueAt(numerorow,0).toString());
            String nombreempleado = tblEmpleados.getValueAt(numerorow,1).toString();
            String apellidos = tblEmpleados.getValueAt(numerorow,2).toString();
            String tipodocumento = tblEmpleados.getValueAt(numerorow,3).toString();
            String documento = tblEmpleados.getValueAt(numerorow,4).toString();
            String correo = tblEmpleados.getValueAt(numerorow,5).toString();
        
        System.out.println("Id: "+idempleado+" Nombre: "+nombreempleado+" Apellidos: "+apellidos+" T.Documento: "+tipodocumento+" Documento: "+documento+" Cooreo:"+correo);
        ShowUserForm showuserform = new ShowUserForm();
        showuserform.recibeDatos(idempleado, nombreempleado, apellidos, tipodocumento, documento, correo);
        showuserform.setVisible(true);
        borrarDatosTabla();
        listaEmpleados();
        
    }//GEN-LAST:event_tblEmpleadosMouseClicked

    private void txtBuscarEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarEmpleadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarEmpleadoActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        borrarDatosTabla();
        listaEmpleados();
    }//GEN-LAST:event_btnSearchActionPerformed

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
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnUserform;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tblEmpleados;
    private javax.swing.JTextField txtBuscarEmpleado;
    // End of variables declaration//GEN-END:variables
}
