/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

/**
 *
 * @author tf_noe
 */
public class Sessao {

    // 1. A única instância da classe (privada e estática)
    private static Sessao instance;

    
    private int idUsuario;
    private String nomeUsuario;
    private String tpAcesso; 

    
    private Sessao() {
    }

    
    public static Sessao getInstance() {
        if (instance == null) {
            instance = new Sessao();
        }
        return instance;
    }

    

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getTpAcesso() {
        return tpAcesso;
    }

    public void setTpAcesso(String tpAcesso) {
        this.tpAcesso = tpAcesso;
    }
    
    
    public void limpar() {
        this.idUsuario = 0;
        this.nomeUsuario = null;
        this.tpAcesso = null;
    }
}

