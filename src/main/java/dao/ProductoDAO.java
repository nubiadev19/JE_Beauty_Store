package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import modelo.Producto;

/**
 *
 * @author Nubia
 */
public class ProductoDAO {
    
    public boolean registrarProducto(Producto producto) {
        // Ajustado a tu BD real: solo nombre, stock y precio
        String sql = "INSERT INTO productos (nombre, stock, precio) VALUES (?, ?, ?)";
        
        try (Connection con = Conexion.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {
            
            // Inyectamos los datos que sí existen en tu tabla de MySQL
            ps.setString(1, producto.getNombre()); 
            ps.setInt(2, producto.getStock());
            ps.setDouble(3, producto.getPrecio());
            
            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0;
            
        } catch (SQLException e) {
            System.err.println("Error al registrar producto: " + e.getMessage());
            return false;
        }
    }
}