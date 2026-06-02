/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import modelo.Pedido;

/**
 *
 * @author Nubia
 */
public class PedidoDAO {
    
    public boolean registrarPedido(Pedido pedido) {
        // Mapeado exactamente a las columnas reales de tu tabla 'pedidos'
        String sql = "INSERT INTO pedidos (id_cliente, fecha_creacion, fecha_limite, estado) VALUES (?, ?, ?, ?)";
        
        try (Connection con = Conexion.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {
            
            // 1. Sacamos el ID del cliente que viene dentro del objeto Pedido
            ps.setInt(1, pedido.getCliente().getIdUsuario());
            
            // 2. Convertimos el LocalDateTime de Java a Timestamp de SQL para que MySQL lo entienda
            ps.setTimestamp(2, Timestamp.valueOf(pedido.getFechaCreacion()));
            ps.setTimestamp(3, Timestamp.valueOf(pedido.getFechaLimite()));
            
            // 3. El estado que el Builder define automáticamente como "Pendiente"
            ps.setString(4, pedido.getEstado());
            
            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0;
            
        } catch (SQLException e) {
            System.err.println("Error al registrar el pedido en la BD: " + e.getMessage());
            return false;
        }
    }
}