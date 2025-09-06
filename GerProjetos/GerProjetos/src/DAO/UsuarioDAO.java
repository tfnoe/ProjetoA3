
package DAO;

import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import DTO.UsuarioDTO;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

public class UsuarioDAO {
    
    Connection banco;
    
    public ResultSet autenticacaoUsuario (UsuarioDTO objusuarioDTO){
       banco = new ConexaoDAO().conectaBD();
       
        try {
            
            String sql = "select * from tbl_usuario where nm_usuario = ? and senha_usuario = ?";
            PreparedStatement pstm = banco.prepareStatement(sql);
            pstm.setString (1, objusuarioDTO.getNm_usuario());
            pstm.setString (2,objusuarioDTO.getSenha_usuario());
            
            ResultSet rs = pstm.executeQuery();
            return rs;
            
            
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null,"UsuarioDAO"+ erro);
            return null;
        }
       
       
       
    }
    
}
