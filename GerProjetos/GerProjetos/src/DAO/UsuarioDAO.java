
package DAO;

import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import DTO.UsuarioDTO;
import View.FRM_Usuario;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class UsuarioDAO {
    
    Connection banco;
    PreparedStatement pstm;
        /**
     * Autentica um usuário no banco de dados.
     * @param login O login do usuário.
     * @param senha A senha do usuário.
     * @return Um objeto UsuarioDTO com os dados do usuário se a autenticação for bem-sucedida, caso contrário, retorna null.
     */
    //int iduser;
    
        public UsuarioDTO autenticar(String login, String senha) {

        // Ajuste o SQL para os nomes da sua tabela e colunas
        String sql = "SELECT id_usuario, nm_usuario, tp_acesso FROM tbl_usuario WHERE user_name = ? AND senha_usuario = ?";

        try (Connection conexao = new ConexaoDAO().conectaBD(); // Sua classe de conexão
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            // Define os parâmetros da query
            stmt.setString(1, login);
            stmt.setString(2, senha); // Veja a nota de segurança abaixo!

            // Executa a consulta
            try (ResultSet rs = stmt.executeQuery()) {
                
                // Verifica se encontrou um resultado
                if (rs.next()) {
                    // Se encontrou, cria um objeto UsuarioDTO para guardar os dados
                    UsuarioDTO usuario = new UsuarioDTO();
                    
                    // Popula o objeto com os dados retornados do banco
                    usuario.setId_usuario(rs.getInt("id_usuario"));
                    usuario.setNm_usuario(rs.getString("nm_usuario"));
                    usuario.setTp_acesso(rs.getString("tp_acesso"));
                    //usuario.set(login); // Podemos preencher o login também

                    // Retorna o objeto completo com os dados do usuário
                    return usuario;
                }
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "UsuarioDAO - Erro ao autenticar: " + e.getMessage());
            e.printStackTrace();
        }

        // Se o 'if (rs.next())' for falso (não encontrou usuário) ou se deu erro, retorna null
        return null;
    }

    
    
    public ResultSet autenticacaoUsuario (UsuarioDTO objusuarioDTO){
       banco = new ConexaoDAO().conectaBD();
       
        try {
            
            String sql = "select * from tbl_usuario where user_name = ? and senha_usuario = ? and status_usuario = 'A'";
            pstm = banco.prepareStatement(sql);
            pstm.setString (1, objusuarioDTO.getNm_usuario());
            pstm.setString (2,objusuarioDTO.getSenha_usuario());
            
            ResultSet rs = pstm.executeQuery();
            return rs;
            
            
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null,"UsuarioDAO - AutenticaUsuário"+ erro);
            return null;
        }
    }
    
    public void inserirUsuario (UsuarioDTO objusuarioDTO){  
        banco = new ConexaoDAO().conectaBD();
       
        try {
            
            String sql = "insert into tbl_usuario (id_usuario,nm_usuario,senha_usuario,tp_acesso) values (?,?,?,?);";
            pstm = banco.prepareStatement(sql);
            pstm.setInt (1, objusuarioDTO.getId_usuario());
            pstm.setString (2, objusuarioDTO.getNm_usuario());
            pstm.setString (3, objusuarioDTO.getSenha_usuario());
            pstm.setString (4, objusuarioDTO.getTp_acesso());
            pstm.execute();
            pstm.close();
            
            JOptionPane.showMessageDialog(null, "Usuário Cadastrado com Sucesso");
            //ResultSet rs = pstm.executeQuery();
         
            
            
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null,"UsuarioDAO - CadastroUsuario"+ erro);
        }       
       
    }
}
