/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import modelo.Cita;
import modelo.Cliente;
import modelo.Servicio;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * @author Nubia
 */
public class CitaDAOTest {
    
    public CitaDAOTest() {
    }

    @Test
    public void testRegistrarCita() {
        System.out.println("Ejecutando prueba unitaria: registrarCita");
        
        int idClienteValido = 0;
        int idServicioValido = 0;
        
        try (Connection con = Conexion.conectar();
             Statement st = con.createStatement()) {
            
            // 1. Obtener un cliente real de la base de datos
            try (ResultSet rsCliente = st.executeQuery("SELECT id_usuario FROM clientes LIMIT 1")) {
                if (rsCliente.next()) {
                    idClienteValido = rsCliente.getInt(1);
                } else {
                    fail("Debe existir al menos un cliente en la BD para correr este test.");
                }
            }
            
            // 2. Asegurar que exista un servicio en phpMyAdmin para no romper la FK
            st.executeUpdate("INSERT INTO servicios (nombre, precio_estimado, tiempo_estimado) VALUES ('Corte y Cepillado', 35000.00, 45)", Statement.RETURN_GENERATED_KEYS);
            try (ResultSet rsServicio = st.getGeneratedKeys()) {
                if (rsServicio.next()) {
                    idServicioValido = rsServicio.getInt(1);
                }
            }
            
        } catch (SQLException e) {
            fail("Falló la configuración de llaves foráneas del test: " + e.getMessage());
        }
        
        // 3. Construir los objetos de prueba con datos reales existentes
        Cliente cliente = new Cliente();
        cliente.setIdUsuario(idClienteValido);
        
        Servicio servicio = new Servicio();
        servicio.setIdServicio(idServicioValido);
        
        // Cita programada para hoy a las 4:00 PM
        Cita nuevaCita = new Cita(0, cliente, servicio, LocalDate.now(), LocalTime.of(16, 0), "Asignada");
        
        // 4. Ejecutar el DAO y comprobar con JUnit 5
        CitaDAO dao = new CitaDAO();
        boolean resultado = dao.registrarCita(nuevaCita);
        
        assertTrue(resultado, "La cita debería quedar agendada y guardada correctamente en MySQL.");
    }
}