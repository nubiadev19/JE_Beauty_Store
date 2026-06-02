package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import modelo.Cliente;

/**
 *
 * @author Nubia
 */
public class ClienteDAO {
    
    public boolean registrarCliente(Cliente cliente) {
        // 1. Consulta para calcular el siguiente ID disponible de forma manual
        String sqlMaxId = "SELECT IFNULL(MAX(id_usuario), 0) + 1 FROM usuarios";
        String sqlUsuario = "INSERT INTO usuarios (id_usuario, nombres, direccion, telefono, contrasena, rol) VALUES (?, ?, ?, ?, ?, ?)";
        String sqlCliente = "INSERT INTO clientes (id_usuario) VALUES (?)";
        
        Connection con = null;
        PreparedStatement psMaxId = null;
        PreparedStatement psUsuario = null;
        PreparedStatement psCliente = null;
        ResultSet rs = null;
        
        try {
            con = Conexion.conectar();
            con.setAutoCommit(false); // Iniciamos transacción
            
            // PASO 1: Averiguar cuál es el próximo ID vacío
            psMaxId = con.prepareStatement(sqlMaxId);
            rs = psMaxId.executeQuery();
            int idAAsignar = 1;
            if (rs.next()) {
                idAAsignar = rs.getInt(1);
            }
            
            // PASO 2: Insertar en usuarios enviando explícitamente el ID calculado
            psUsuario = con.prepareStatement(sqlUsuario);
            psUsuario.setInt(1, idAAsignar);
            psUsuario.setString(2, cliente.getNombre());
            psUsuario.setString(3, cliente.getDireccion());
            psUsuario.setString(4, cliente.getTelefono());
            psUsuario.setString(5, cliente.getContrasena());
            psUsuario.setString(6, "Cliente");
            psUsuario.executeUpdate();
            
            // PASO 3: Insertar en clientes usando el mismo ID
            psCliente = con.prepareStatement(sqlCliente);
            psCliente.setInt(1, idAAsignar);
            psCliente.executeUpdate();
            
            con.commit(); // Guardamos todo
            return true;
            
        } catch (SQLException e) {
            System.err.println("Error al registrar cliente: " + e.getMessage());
            if (con != null) {
                try {
                    con.rollback(); // Cancelamos todo si algo falla
                } catch (SQLException ex) {
                    System.err.println("Error en rollback: " + ex.getMessage());
                }
            }
            return false;
        } finally {
            // Cerramos todos los flujos de datos de forma limpia
            try {
                if (rs != null) rs.close();
                if (psMaxId != null) psMaxId.close();
                if (psUsuario != null) psUsuario.close();
                if (psCliente != null) psCliente.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                System.err.println("Error al cerrar recursos: " + e.getMessage());
            }
        }
    }
}