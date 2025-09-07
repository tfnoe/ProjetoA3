package DAO;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
/**
 *
 * @author tf_noe
 */
public class ConexaoDAO {
    public Connection conectaBD (){
        Connection banco = null;
        
        try {
            String url = "jdbc:mysql://localhost:3306/gerprojetos?user=root&password=root1234";
            banco = DriverManager.getConnection(url);
               
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"ConexaoDAO" + e.getMessage());
        }
        
        return banco;
        
        
    }
}
