/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Nubia
 */
public class UsuarioDAO {
    
    // Método que verifica las credenciales y devuelve el rol (Cliente/Dueña) o null si es incorrecto
    public String validarIngreso(String telefono, String contrasena) {
        // Buscamos coincidencia exacta de teléfono y clave
        String sql = "SELECT rol FROM usuarios WHERE telefono = ? AND contrasena = ?";
        
        try (Connection con = Conexion.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {
            
            ps.setString(1, telefono);
            ps.setString(2, contrasena);
            
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getString("rol"); // Retorna "Cliente" o el rol guardado en la BD
                }
            }
        } catch (SQLException e) {
            System.err.println("Error en la validación de usuario: " + e.getMessage());
        }
        return null; // Si no coincide nada, devuelve nulo
    }
}