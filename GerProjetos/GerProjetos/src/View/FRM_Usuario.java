/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import DAO.ConexaoDAO;
import java.util.logging.Logger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author tf_noe
 */
public class FRM_Usuario extends javax.swing.JDialog {

    
    private static final Logger logger = Logger.getLogger(FRM_Usuario.class.getName());
    
    public FRM_Usuario(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        carregarDadosNaTabela();

    }

    private void carregarDadosNaTabela() {
    DefaultTableModel modelo = (DefaultTableModel) this.tabelaUsuarios.getModel();
    String buscausuario = txt_buscausuario.getText();
    modelo.setRowCount(0);

    
    String sql;

    if (buscausuario.trim().isEmpty()) {
        // Caso o campo de busca esteja vazio, seleciona todos os usuários.
        sql = "SELECT id_usuario, nm_usuario, tp_acesso FROM tbl_usuario ORDER BY nm_usuario";
    } else {
        // Caso haja texto na busca, prepara a consulta com o filtro.
        sql = "SELECT id_usuario, nm_usuario, tp_acesso FROM tbl_usuario WHERE nm_usuario LIKE ? ORDER BY nm_usuario";
    }

    try (Connection conexao = new ConexaoDAO().conectaBD();
         PreparedStatement stmt = conexao.prepareStatement(sql)) {

        
        if (!buscausuario.trim().isEmpty()) {
            
            stmt.setString(1, "%" + buscausuario + "%");
        }
        
        // Usar um segundo try-with-resources para o ResultSet garante que ele também seja fechado.
        try (ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                modelo.addRow(new Object[]{
                    rs.getInt("id_usuario"),
                    rs.getString("nm_usuario"),
                    rs.getString("tp_acesso")
                });
            }
        }
    } catch (SQLException e) {
        // MELHORIA: Exibe o erro em uma janela para o usuário, além de logar no console.
        JOptionPane.showMessageDialog(this, "Erro ao carregar dados dos usuários:\n" + e.getMessage(), "Erro de Banco de Dados", JOptionPane.ERROR_MESSAGE);
        e.printStackTrace(); // Imprime o rastreamento completo do erro no console para depuração.
    }
}
    
    @SuppressWarnings("unchecked")
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaUsuarios = new javax.swing.JTable();
        Btn_editar = new javax.swing.JButton();
        Btn_deletar = new javax.swing.JButton();
        Btn_novo = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txt_buscausuario = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Usuário");

        tabelaUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Código", "Nome", "Tipo de Acesso"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaUsuariosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaUsuarios);

        Btn_editar.setText("Editar");
        Btn_editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_editarActionPerformed(evt);
            }
        });

        Btn_deletar.setText("Deletar");
        Btn_deletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_deletarActionPerformed(evt);
            }
        });

        Btn_novo.setText("Novo");
        Btn_novo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_novoActionPerformed(evt);
            }
        });

        jLabel1.setText("Usuário:");

        txt_buscausuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_buscausuarioActionPerformed(evt);
            }
        });
        txt_buscausuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_buscausuarioKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Btn_novo, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Btn_editar, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Btn_deletar, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txt_buscausuario))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(txt_buscausuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Btn_novo)
                    .addComponent(Btn_editar)
                    .addComponent(Btn_deletar))
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Btn_editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_editarActionPerformed
        int linhaSelecionada = this.tabelaUsuarios.getSelectedRow();
        
        // 3. Obter os dados da linha selecionada
        int id = (int) this.tabelaUsuarios.getValueAt(linhaSelecionada, 0); // Coluna do ID
        String nome = (String) this.tabelaUsuarios.getValueAt(linhaSelecionada, 1); // Coluna do Nome
        String tp_acesso = (String) this.tabelaUsuarios.getValueAt(linhaSelecionada, 2); // Coluna do E-mail

        // 4. Abrir a tela de edição, passando os dados para ela
        // O 'this' se refere à janela principal (FRM_Usuario), e 'true' torna a janela de edição "modal"
        FRM_EditaUsuario telaEdicao = new FRM_EditaUsuario(null, true);
        
        // 5. Enviar os dados do usuário para a tela de edição
        telaEdicao.receberDados(id, nome, tp_acesso);
        
        // 6. Tornar a tela de edição visível
        telaEdicao.setVisible(true);
        
        // 7. (Opcional, mas recomendado) Atualizar a tabela principal após a edição
        // Este código só será executado DEPOIS que a janela de edição for fechada
        carregarDadosNaTabela();
    }//GEN-LAST:event_Btn_editarActionPerformed

    private void Btn_novoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_novoActionPerformed
        FRM_CadUsuario telaDeCadastro = new FRM_CadUsuario(null, true);        
        telaDeCadastro.setVisible(true);  
        carregarDadosNaTabela();// TODO add your handling code here:
    }//GEN-LAST:event_Btn_novoActionPerformed

    private void Btn_deletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_deletarActionPerformed

        // 1. Pegar a linha selecionada na tabela
        int linhaSelecionada = this.tabelaUsuarios.getSelectedRow();

        // 2. Verificar se realmente há uma linha selecionada
        if (linhaSelecionada == -1) {
            JOptionPane.showMessageDialog(this, "Por favor, selecione um usuário para deletar.");
            return; // Para a execução do método aqui
        }

        // 3. Pegar o ID do usuário da linha selecionada (assumindo que o ID está na primeira coluna, índice 0)
        // O .getValueAt() retorna um Object, então precisamos convertê-lo para String e depois para int.
        int idUsuario = (int) this.tabelaUsuarios.getValueAt(linhaSelecionada, 0);

        // 4. Pedir confirmação ao usuário (boa prática)
        int confirmacao = JOptionPane.showConfirmDialog(this, "Tem certeza que deseja deletar o usuário selecionado?", "Confirmação de Exclusão", JOptionPane.YES_NO_OPTION);

        if (confirmacao == JOptionPane.YES_OPTION) {
            // Se o usuário clicou "Sim", prossiga com a exclusão
            String sql = "DELETE FROM tbl_usuario WHERE id_usuario = ?";

            try (Connection conexao = new ConexaoDAO().conectaBD(); PreparedStatement stmt = conexao.prepareStatement(sql)) {

                // 5. Substituir o '?' pelo ID do usuário
                stmt.setInt(1, idUsuario);

                // 6. Executar o comando de exclusão e verificar se alguma linha foi afetada
                int linhasAfetadas = stmt.executeUpdate();

                if (linhasAfetadas > 0) {
                    // Se a exclusão deu certo
                    JOptionPane.showMessageDialog(this, "Usuário deletado com sucesso!");

                    // 7. Atualizar a tabela para refletir a exclusão
                    this.carregarDadosNaTabela();
                } else {
                    // Se nenhum usuário com aquele ID foi encontrado
                    JOptionPane.showMessageDialog(this, "Erro: Usuário não encontrado no banco de dados.");
                }

            } catch (SQLException e) {
                // Em caso de erro de SQL
                JOptionPane.showMessageDialog(this, "Erro ao deletar usuário do banco de dados:\n" + e.getMessage());
            }
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_Btn_deletarActionPerformed

    private void tabelaUsuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaUsuariosMouseClicked
        // 1. Verificar se foi um duplo-clique
    if (evt.getClickCount() == 2) {
        
        // 2. Pegar a linha selecionada
        int linhaSelecionada = this.tabelaUsuarios.getSelectedRow();
        
        // 3. Obter os dados da linha selecionada
        int id = (int) this.tabelaUsuarios.getValueAt(linhaSelecionada, 0); // Coluna do ID
        String nome = (String) this.tabelaUsuarios.getValueAt(linhaSelecionada, 1); // Coluna do Nome
        String tp_acesso = (String) this.tabelaUsuarios.getValueAt(linhaSelecionada, 2); // Coluna do E-mail

        // 4. Abrir a tela de edição, passando os dados para ela
        // O 'this' se refere à janela principal (FRM_Usuario), e 'true' torna a janela de edição "modal"
        FRM_EditaUsuario telaEdicao = new FRM_EditaUsuario(null, true);
        
        // 5. Enviar os dados do usuário para a tela de edição
        telaEdicao.receberDados(id, nome, tp_acesso);
        
        // 6. Tornar a tela de edição visível
        telaEdicao.setVisible(true);
        
        // 7. (Opcional, mas recomendado) Atualizar a tabela principal após a edição
        // Este código só será executado DEPOIS que a janela de edição for fechada
        carregarDadosNaTabela();
    }
    }//GEN-LAST:event_tabelaUsuariosMouseClicked

    private void txt_buscausuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_buscausuarioActionPerformed
        
    }//GEN-LAST:event_txt_buscausuarioActionPerformed

    private void txt_buscausuarioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_buscausuarioKeyReleased
        carregarDadosNaTabela();
    }//GEN-LAST:event_txt_buscausuarioKeyReleased

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
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
            java.awt.EventQueue.invokeLater(() -> {
            FRM_Usuario dialog = new FRM_Usuario(new javax.swing.JFrame(), true);
            dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
            });
            dialog.setVisible(true);
                });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Btn_deletar;
    private javax.swing.JButton Btn_editar;
    private javax.swing.JButton Btn_novo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelaUsuarios;
    private javax.swing.JTextField txt_buscausuario;
    // End of variables declaration//GEN-END:variables
}
