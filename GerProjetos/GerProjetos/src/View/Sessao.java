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
    private static int idUsuario;
    private static String nomeUsuario;
    private static String tpAcesso;

    public static int getIdUsuario() {
        return idUsuario;
    }

    public static void setIdUsuario(int idUsuario) {
        Sessao.idUsuario = idUsuario;
    }

    public static String getNomeUsuario() {
        return nomeUsuario;
    }

    public static void setNomeUsuario(String nomeUsuario) {
        Sessao.nomeUsuario = nomeUsuario;
    }

    public static String getTpAcesso() {
        return tpAcesso;
    }

    public static void setTpAcesso(String tpAcesso) {
        Sessao.tpAcesso = tpAcesso;
    }

    public static void limpar() {
        idUsuario = 0;
        nomeUsuario = null;
        tpAcesso = null;
    }
}

