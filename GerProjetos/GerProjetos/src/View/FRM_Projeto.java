/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package View;

import DAO.ConexaoDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.List;
import java.text.SimpleDateFormat;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author tf_noe
 */
public class FRM_Projeto extends javax.swing.JDialog {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(FRM_Projeto.class.getName());

    /**
     * Creates new form FRM_Projeto
     */
    public FRM_Projeto(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        TableProjeto.setDefaultRenderer(java.util.Date.class, new DateRenderer());
        carregarDadosNaTabela();
        carregarComboGerentes();
    }
    
    public class DateRenderer extends DefaultTableCellRenderer {

    private static final long serialVersionUID = 1L;
    private final SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

    @Override
    public void setValue(Object value) {
        // Se o valor for uma data, formate-o. Se não, use o padrão.
        // O "setText" é necessário aqui para garantir que o valor seja exibido.
        if (value != null && value instanceof java.util.Date) {
            setText(formatter.format(value));
        } else {
            super.setValue(value);
        }
    }
}
    private void carregarComboGerentes() {
   cmb_gerente.removeAllItems(); // Limpa os itens antigos

    String sql = "SELECT nm_usuario FROM tbl_usuario WHERE tp_acesso = 'Gerente' ORDER BY nm_usuario";

    try (Connection conexao = new ConexaoDAO().conectaBD();
         PreparedStatement stmt = conexao.prepareStatement(sql);
         ResultSet rs = stmt.executeQuery()) {
            cmb_gerente.addItem("Todos");
        while (rs.next()) {
            String nomeGerente = rs.getString("nm_usuario");
            cmb_gerente.addItem(nomeGerente);
        }

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Erro ao carregar gerentes:\n" + e.getMessage(), "Erro de Banco de Dados", JOptionPane.ERROR_MESSAGE);
        e.printStackTrace();
    }
}
    private void carregarDadosNaTabela() {
    DefaultTableModel modelo = (DefaultTableModel) this.TableProjeto.getModel();
    modelo.setRowCount(0);

    // 1. Obter os valores dos filtros da interface
    String buscaprojeto = txt_buscaprojeto.getText();
    String statusFiltro = getStatusSelecionado();

    // 2. Construir a consulta SQL dinamicamente
    // Usamos 'WHERE 1=1' como um truque para facilitar a adição de cláusulas 'AND'
    StringBuilder sql = new StringBuilder("SELECT * FROM tbl_projeto WHERE 1=1");
    
    // Lista para guardar os valores dos parâmetros de forma segura
    List<Object> parametros = new ArrayList<>();

    // 3. Adicionar o filtro de NOME, se houver texto
    if (!buscaprojeto.trim().isEmpty()) {
        sql.append(" AND nm_projeto LIKE ?");
        parametros.add("%" + buscaprojeto + "%");
    }

    // 4. Adicionar o filtro de STATUS, se a opção selecionada não for "Todos"
    if (!statusFiltro.equals("Todos")) {
        sql.append(" AND status_projeto = ?");
        parametros.add(statusFiltro);
    }

    // Adicionar a ordenação no final da consulta
    sql.append(" ORDER BY id_projeto");

    try (Connection conexao = new ConexaoDAO().conectaBD();
         PreparedStatement stmt = conexao.prepareStatement(sql.toString())) {

        // 5. Definir os parâmetros na PreparedStatement
        // Este laço percorre a lista de parâmetros e os adiciona à consulta
        for (int i = 0; i < parametros.size(); i++) {
            // O primeiro parâmetro é o índice 1, o segundo é 2, e assim por diante
            stmt.setObject(i + 1, parametros.get(i));
        }

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
 try (ResultSet rs = stmt.executeQuery()) {
    while (rs.next()) {
        // Formatar as datas como ddMMyyyy
        String dataInicioFormatada = "";
        String dataFimFormatada = "";
        
        if (rs.getDate("dt_inicioprojeto") != null) {
            dataInicioFormatada = sdf.format(rs.getDate("dt_inicioprojeto"));
        }

        if (rs.getDate("dt_fimprojeto") != null) {
            dataFimFormatada = sdf.format(rs.getDate("dt_fimprojeto"));
        }

        modelo.addRow(new Object[]{
            rs.getInt("id_projeto"),
            rs.getString("nm_projeto"),
            dataInicioFormatada,
            dataFimFormatada,
            rs.getString("status_projeto"),
        });
    }
}
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Erro ao carregar dados do projeto:\n" + e.getMessage(), "Erro de Banco de Dados", JOptionPane.ERROR_MESSAGE);
        e.printStackTrace();
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jScrollPane2 = new javax.swing.JScrollPane();
        TableProjeto = new javax.swing.JTable();
        btn_novoprojeto = new javax.swing.JButton();
        btn_editarprojeto = new javax.swing.JButton();
        btn_excluirprojeto = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txt_buscaprojeto = new javax.swing.JTextField();
        cmb_gerente = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        rd_todos = new javax.swing.JRadioButton();
        rd_emandamento = new javax.swing.JRadioButton();
        rd_ematraso = new javax.swing.JRadioButton();
        rd_concluido = new javax.swing.JRadioButton();
        rd_planejado = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        TableProjeto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID Projeto", "Nome Projeto", "Data Início", "Data Fim", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(TableProjeto);
        if (TableProjeto.getColumnModel().getColumnCount() > 0) {
            TableProjeto.getColumnModel().getColumn(0).setResizable(false);
            TableProjeto.getColumnModel().getColumn(0).setPreferredWidth(30);
            TableProjeto.getColumnModel().getColumn(1).setResizable(false);
            TableProjeto.getColumnModel().getColumn(1).setPreferredWidth(300);
            TableProjeto.getColumnModel().getColumn(2).setResizable(false);
            TableProjeto.getColumnModel().getColumn(2).setPreferredWidth(50);
            TableProjeto.getColumnModel().getColumn(3).setResizable(false);
            TableProjeto.getColumnModel().getColumn(3).setPreferredWidth(50);
            TableProjeto.getColumnModel().getColumn(4).setResizable(false);
            TableProjeto.getColumnModel().getColumn(4).setPreferredWidth(50);
        }

        btn_novoprojeto.setText("Novo Projeto");
        btn_novoprojeto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_novoprojetoActionPerformed(evt);
            }
        });

        btn_editarprojeto.setText("Editar Projeto");
        btn_editarprojeto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editarprojetoActionPerformed(evt);
            }
        });

        btn_excluirprojeto.setText("Excluir Projeto");
        btn_excluirprojeto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_excluirprojetoActionPerformed(evt);
            }
        });

        jLabel1.setText("Buscar Projeto:");

        txt_buscaprojeto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_buscaprojetoKeyReleased(evt);
            }
        });

        cmb_gerente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel2.setText("Gerente:");

        buttonGroup1.add(rd_todos);
        rd_todos.setText("Todos");
        rd_todos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rd_todosActionPerformed(evt);
            }
        });

        buttonGroup1.add(rd_emandamento);
        rd_emandamento.setSelected(true);
        rd_emandamento.setText("Em Andamento");
        rd_emandamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rd_emandamentoActionPerformed(evt);
            }
        });

        buttonGroup1.add(rd_ematraso);
        rd_ematraso.setText("Em Atraso");
        rd_ematraso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rd_ematrasoActionPerformed(evt);
            }
        });

        buttonGroup1.add(rd_concluido);
        rd_concluido.setText("Concluido");
        rd_concluido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rd_concluidoActionPerformed(evt);
            }
        });

        buttonGroup1.add(rd_planejado);
        rd_planejado.setText("Planejado");
        rd_planejado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rd_planejadoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rd_emandamento)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rd_ematraso)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rd_planejado)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(rd_concluido)
                .addGap(18, 18, 18)
                .addComponent(rd_todos)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rd_todos)
                    .addComponent(rd_emandamento)
                    .addComponent(rd_ematraso)
                    .addComponent(rd_concluido)
                    .addComponent(rd_planejado))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_buscaprojeto, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmb_gerente, 0, 246, Short.MAX_VALUE))
                    .addComponent(jScrollPane2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_novoprojeto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_editarprojeto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_excluirprojeto)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txt_buscaprojeto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmb_gerente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_novoprojeto)
                    .addComponent(btn_editarprojeto)
                    .addComponent(btn_excluirprojeto))
                .addGap(46, 46, 46))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_editarprojetoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editarprojetoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_editarprojetoActionPerformed

    private void btn_novoprojetoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_novoprojetoActionPerformed
                FRM_CadProjeto cadprojeto = new FRM_CadProjeto(null, true);
                cadprojeto.setVisible(true);
                carregarDadosNaTabela();
    }//GEN-LAST:event_btn_novoprojetoActionPerformed

    private void txt_buscaprojetoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_buscaprojetoKeyReleased
        carregarDadosNaTabela();
    }//GEN-LAST:event_txt_buscaprojetoKeyReleased

    private String getStatusSelecionado() {
    if (rd_concluido.isSelected()) {
        return "Concluído";
    } else if (rd_emandamento.isSelected()) {
        return "Em Andamento";
    } else if (rd_ematraso.isSelected()) {
        return "Em Atraso";
    } else if (rd_planejado.isSelected()) {
        return "Planejado";
    } else if (rd_todos.isSelected()) {
        return "Todos";
    } else {
        return "Todos"; // O padrão é "Todos"
    }
    }
    private void rd_todosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rd_todosActionPerformed
        carregarDadosNaTabela();        // TODO add your handling code here:
    }//GEN-LAST:event_rd_todosActionPerformed

    private void rd_emandamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rd_emandamentoActionPerformed
        carregarDadosNaTabela();
    }//GEN-LAST:event_rd_emandamentoActionPerformed

    private void rd_ematrasoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rd_ematrasoActionPerformed
        carregarDadosNaTabela();        // TODO add your handling code here:
    }//GEN-LAST:event_rd_ematrasoActionPerformed

    private void rd_concluidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rd_concluidoActionPerformed
        carregarDadosNaTabela();        // TODO add your handling code here:
    }//GEN-LAST:event_rd_concluidoActionPerformed

    private void btn_excluirprojetoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_excluirprojetoActionPerformed
         // 1. Pegar a linha selecionada na tabela
        int linhaSelecionada = this.TableProjeto.getSelectedRow();

        // 2. Verificar se realmente há uma linha selecionada
        //if (linhaSelecionada == -1) {
        //    JOptionPane.showMessageDialog(this, "Por favor, selecione um projeto para deletar.");
        //    return; // Para a execução do método aqui
        //}
        // teste de inclusão de comentario 
        // 3. Pegar o ID do usuário da linha selecionada (assumindo que o ID está na primeira coluna, índice 0)
        // O .getValueAt() retorna um Object, então precisamos convertê-lo para String e depois para int.
        int idProjeto = (int) this.TableProjeto.getValueAt(linhaSelecionada, 0);

        // 4. Pedir confirmação ao usuário (boa prática)
        int confirmacao = JOptionPane.showConfirmDialog(this, "Tem certeza que deseja deletar o projeto selecionado?", "Confirmação de Exclusão", JOptionPane.YES_NO_OPTION);

        if (confirmacao == JOptionPane.YES_OPTION) {
            // Se o usuário clicou "Sim", prossiga com a exclusão
            String sql = "DELETE FROM tbl_projeto WHERE id_projeto = ?";

            try (Connection conexao = new ConexaoDAO().conectaBD(); PreparedStatement stmt = conexao.prepareStatement(sql)) {

                // 5. Substituir o '?' pelo ID do usuário
                stmt.setInt(1, idProjeto);

                // 6. Executar o comando de exclusão e verificar se alguma linha foi afetada
                int linhasAfetadas = stmt.executeUpdate();

                if (linhasAfetadas > 0) {
                    // Se a exclusão deu certo
                    JOptionPane.showMessageDialog(this, "Projeto deletado com sucesso!");

                    // 7. Atualizar a tabela para refletir a exclusão
                    this.carregarDadosNaTabela();
                } else {
                    // Se nenhum usuário com aquele ID foi encontrado
                    JOptionPane.showMessageDialog(this, "Erro: Projeto não encontrado no banco de dados.");
                }

            } catch (SQLException e) {
                // Em caso de erro de SQL
                JOptionPane.showMessageDialog(this, "Erro ao deletar projeto do banco de dados:\n" + e.getMessage());
            }
        }
    }//GEN-LAST:event_btn_excluirprojetoActionPerformed

    private void rd_planejadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rd_planejadoActionPerformed
            carregarDadosNaTabela();        // TODO add your handling code here:
    }//GEN-LAST:event_rd_planejadoActionPerformed

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

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                FRM_Projeto dialog = new FRM_Projeto(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TableProjeto;
    private javax.swing.JButton btn_editarprojeto;
    private javax.swing.JButton btn_excluirprojeto;
    private javax.swing.JButton btn_novoprojeto;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cmb_gerente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JRadioButton rd_concluido;
    private javax.swing.JRadioButton rd_emandamento;
    private javax.swing.JRadioButton rd_ematraso;
    private javax.swing.JRadioButton rd_planejado;
    private javax.swing.JRadioButton rd_todos;
    private javax.swing.JTextField txt_buscaprojeto;
    // End of variables declaration//GEN-END:variables
}
