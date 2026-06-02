/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import dao.UsuarioDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import vista.FrmLogin;

/**
 *
 * @author Nubia
 */
public class LoginControlador implements ActionListener {
    
    private final FrmLogin vista;
    private final UsuarioDAO dao;

    public LoginControlador(FrmLogin vista, UsuarioDAO dao) {
        this.vista = vista;
        this.dao = dao;
        
        this.vista.getBtnIngresar().addActionListener(this);
        this.vista.getBtnSalir().addActionListener(this);
        this.vista.setLocationRelativeTo(null); // Asegura centrado
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.getBtnIngresar()) {
            String telefono = vista.getTelefono();
            String contrasena = vista.getContrasena();
            
            if (telefono.isEmpty() || contrasena.isEmpty()) {
                JOptionPane.showMessageDialog(vista, "Ingrese sus credenciales completas.", "Campos Requeridos", JOptionPane.WARNING_MESSAGE);
                return;
            }
            
            // Validamos contra la base de datos
            String rolObtenido = dao.validarIngreso(telefono, contrasena);
            
            if (rolObtenido != null) {
                JOptionPane.showMessageDialog(vista, "¡Bienvenido! Rol detectado: " + rolObtenido, "Acceso Concedido", JOptionPane.INFORMATION_MESSAGE);
                vista.dispose();
                
                // Aquí abriremos el menú principal correspondiente en el siguiente paso
                
            } else {
                JOptionPane.showMessageDialog(vista, "Teléfono o contraseña incorrectos.", "Acceso Denegado", JOptionPane.ERROR_MESSAGE);
            }
        }
        
        if (e.getSource() == vista.getBtnSalir()) {
            System.exit(0); // Cierra la aplicación por completo
        }
    }
}