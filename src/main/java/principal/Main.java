/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package principal;

import dao.ClienteDAO;
import controlador.ClienteControlador;
import controlador.LoginControlador;
import dao.UsuarioDAO;
import vista.FrmLogin;
import vista.FrmRegistroCliente;

/**
 *
 * @author Nubia
 */
public class Main {
    
    public static void main(String[] args) {
       FrmLogin loginVista = new FrmLogin();
        UsuarioDAO usuarioDao = new UsuarioDAO();
        LoginControlador loginCtrl = new LoginControlador(loginVista, usuarioDao);
        
        loginVista.setVisible(true);
    }
}