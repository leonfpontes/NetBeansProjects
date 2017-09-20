package crud_reginaldo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Frame extends javax.swing.JFrame {

    private Connection con = ConnectionFactory.getConnection();

    public Frame() {
        initComponents();
    }
    //MÉTODO QUE VERIFICA CAMPOS EM BRANCO
    public boolean verificaCampos(){
        if(dfNome.getText().equals(""))
            return true;
        else if (dfEndereco.getText().equals(""))
            return true;
        else if (dfTelefone.getText().equals(""))
            return true;
        else
            return false;
    }
    //MÉTODO PARA CADASTRAR AGENDA
    public void limpar(){
        dfCodigo.setText("");
        dfNome.setText("");
        dfEndereco.setText("");
        dfTelefone.setText("");
        dfCodigo.setEditable(true);
    }
    //MÉTODO PARA CADASTRAR AGENDA
    public void cadastrar(){
        //boolean teste = verificaCampos();
        String sql = "INSERT INTO AGENDA (ID, NOME, ENDERECO, TELEFONE)"
                + "VALUES (NULL, ?, ?, ?)";

        try (PreparedStatement preparestatement = con.prepareStatement(sql)){
            preparestatement.setString(1, dfNome.getText()); //substitui o ? pelo dado do usuario
            preparestatement.setString(2, dfEndereco.getText()); 
            preparestatement.setString(3, dfTelefone.getText()); //TODO CRIAR CAMPO PARA CÓDIGO DA PESSOA

            preparestatement.execute();
            JOptionPane.showMessageDialog(null, "Informação inserida com sucesso!");
            preparestatement.close();
            buscarID(Integer.parseInt(dfCodigo.getText()));
        }catch (SQLException e){
            e.printStackTrace();
        }
        
    }
    //MÉTODO PARA CADASTRAR AGENDA
    public void alterar(){
        String sql = "UPDATE AGENDA "
            + "SET NOME = ?, ENDERECO = ?,  TELEFONE = ? "
            + "WHERE ID = ?";

        try (PreparedStatement preparestatement = con.prepareStatement(sql)){
            preparestatement.setString(1, dfNome.getText());
            preparestatement.setString(2, dfEndereco.getText()); 
            preparestatement.setString(3, dfTelefone.getText());
            preparestatement.setString(4, dfCodigo.getText());

            preparestatement.execute();
            JOptionPane.showMessageDialog(null, "Informação alterada com sucesso!");
            preparestatement.close();
            buscar();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    //MÉTODO PARA CADASTRAR AGENDA
    public void deletar(){
        String sql = "DELETE FROM AGENDA WHERE ID = ?";

        try (PreparedStatement preparestatement = con.prepareStatement(sql)){
            preparestatement.setString(1, dfCodigo.getText());
            
            preparestatement.execute();
            JOptionPane.showMessageDialog(null, "Informação deletada com sucesso!");
            preparestatement.close();
            limpar();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    //MÉTODO PARA BUSCAR OS DADOS DA AGENDA POR TELEFONE
    public void buscarTelefone(String pnTelefone){
        
        String sql = "SELECT ID, NOME, ENDERECO, TELEFONE "
                + "FROM AGENDA WHERE TELEFONE LIKE '%?%' LIMIT 1";
        try (PreparedStatement preparestatement = con.prepareStatement(sql)){

            preparestatement.setString(1, pnTelefone); 

            ResultSet rs = preparestatement.executeQuery();
            rs.next();

            dfCodigo.setText(rs.getString("id"));
            dfNome.setText(rs.getString("nome"));
            dfEndereco.setText(rs.getString("endereco"));
            dfTelefone.setText(rs.getString("telefone"));

            preparestatement.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    //MÉTODO PARA BUSCAR OS DADOS DA AGENDA POR ENDEREÇO
    public void buscarEndereco(String pnEndereco){
        
        String sql = "SELECT ID, NOME, ENDERECO, TELEFONE "
                + "FROM AGENDA WHERE ENDERECO LIKE '%?%' LIMIT 1";
        try (PreparedStatement preparestatement = con.prepareStatement(sql)){

            preparestatement.setString(1, pnEndereco); 

            ResultSet rs = preparestatement.executeQuery();
            rs.next();

            dfCodigo.setText(rs.getString("id"));
            dfNome.setText(rs.getString("nome"));
            dfEndereco.setText(rs.getString("endereco"));
            dfTelefone.setText(rs.getString("telefone"));

            preparestatement.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    //MÉTODO PARA BUSCAR OS DADOS DA AGENDA POR NOME
    public void buscarNome(String pnNome){
        
        String sql = "top(1)SELECT ID, NOME, ENDERECO, TELEFONE "
                + "FROM AGENDA WHERE NOME LIKE '%?%' LIMIT 1";
        try (PreparedStatement preparestatement = con.prepareStatement(sql)){

            preparestatement.setString(1, pnNome); 

            ResultSet rs = preparestatement.executeQuery();
            rs.next();

            dfCodigo.setText(rs.getString("id"));
            dfNome.setText(rs.getString("nome"));
            dfEndereco.setText(rs.getString("endereco"));
            dfTelefone.setText(rs.getString("telefone"));

            preparestatement.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    //MÉTODO PARA BUSCAR OS DADOS DA AGENDA POR ID
    public void buscarID(int pnID){

        String sql = "SELECT ID, NOME, ENDERECO, TELEFONE "
                + "FROM AGENDA WHERE ID = ?";
        try (PreparedStatement preparestatement = con.prepareStatement(sql)){

            preparestatement.setInt(1, pnID); 

            ResultSet rs = preparestatement.executeQuery();
            rs.next();

            dfNome.setText(rs.getString("nome"));
            dfEndereco.setText(rs.getString("endereco"));
            dfTelefone.setText(rs.getString("telefone"));

            preparestatement.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    //MÉTODO QUE TRATA O CRITÉRIO DE BUSCA
    public void buscar(){
        if (dfCodigo.getText() != "") {
            buscarID(Integer.parseInt(dfCodigo.getText()));
        } else if (dfNome.getText() != ""){
            buscarNome(dfNome.getText());
        } else if (dfEndereco.getText() != ""){
            buscarEndereco(dfEndereco.getText());
        } else if (dfTelefone.getText() != ""){
            buscarTelefone(dfTelefone.getText());
        } else {
            JOptionPane.showMessageDialog(null, "Por favor, informar algo para pesquisar!");
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

        dfNome = new javax.swing.JTextField();
        dfCodigo = new javax.swing.JTextField();
        dfTelefone = new javax.swing.JTextField();
        dfEndereco = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnInsert = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnSelect = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setName("Agenda"); // NOI18N

        dfCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dfCodigoActionPerformed(evt);
            }
        });

        jLabel1.setText("Código:");

        jLabel2.setText("Nome:");

        jLabel3.setText("Telefone:");

        jLabel4.setText("Endereço:");

        btnInsert.setText("Insert");
        btnInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnSelect.setText("Select");
        btnSelect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelectActionPerformed(evt);
            }
        });

        btnLimpar.setText("Limpar");
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(93, 93, 93)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnInsert)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDelete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnUpdate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSelect)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnLimpar))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(dfTelefone, javax.swing.GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE)
                        .addComponent(dfEndereco)
                        .addComponent(dfNome)
                        .addComponent(dfCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(62, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dfCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dfEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dfTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnInsert)
                    .addComponent(btnDelete)
                    .addComponent(btnUpdate)
                    .addComponent(btnSelect)
                    .addComponent(btnLimpar))
                .addContainerGap(45, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void dfCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dfCodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dfCodigoActionPerformed

    private void btnInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertActionPerformed
        cadastrar();
        dfCodigo.setEditable(false);
    }//GEN-LAST:event_btnInsertActionPerformed

    private void btnSelectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelectActionPerformed
        //buscar();
        buscarID(Integer.parseInt(dfCodigo.getText()));
        dfCodigo.setEditable(false);
    }//GEN-LAST:event_btnSelectActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        deletar();
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        alterar();
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        limpar();
    }//GEN-LAST:event_btnLimparActionPerformed

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
            java.util.logging.Logger.getLogger(Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnInsert;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnSelect;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JTextField dfCodigo;
    private javax.swing.JTextField dfEndereco;
    private javax.swing.JTextField dfNome;
    private javax.swing.JTextField dfTelefone;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    // End of variables declaration//GEN-END:variables
}
