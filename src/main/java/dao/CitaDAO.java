/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Date;
import java.sql.Time;
import modelo.Cita;

/**
 *
 * @author Nubia
 */
public class CitaDAO {
    
    public boolean registrarCita(Cita cita) {
        // Estrictamente alineado a las columnas de tu phpMyAdmin: id_cliente, id_servicio, fecha, hora, estado
        String sql = "INSERT INTO citas (id_cliente, id_servicio, fecha, hora, estado) VALUES (?, ?, ?, ?, ?)";
        
        try (Connection con = Conexion.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {
            
            // 1. Amarrar las llaves foráneas desde los objetos internos de Cita
            ps.setInt(1, cita.getClienta().getIdUsuario());
            ps.setInt(2, cita.getServicio().getIdServicio());
            
            // 2. Convertir LocalDate y LocalTime de Java a formatos nativos de MySQL (Date y Time)
            ps.setDate(3, Date.valueOf(cita.getFecha()));
            ps.setTime(4, Time.valueOf(cita.getHora()));
            
            // 3. Estado inicial de la cita
            ps.setString(5, cita.getEstado());
            
            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0;
            
        } catch (SQLException e) {
            System.err.println("Error al registrar la cita en la BD: " + e.getMessage());
            return false;
        }
    }
}
