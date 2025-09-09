
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
