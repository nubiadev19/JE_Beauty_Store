/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import modelo.Cliente;
import modelo.Pedido;
import modelo.PedidoBuilder;
import modelo.PedidoBuilderConcreto;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Nubia
 */
public class PedidoDAOTest {
    
    public PedidoDAOTest() {
    }

    @Test
    public void testRegistrarPedidoConBuilder() {
        System.out.println("Ejecutando prueba unitaria: registrarPedido (Integrando el Builder)");
        
        int idClienteValido = 0;
        
        // 1. Buscamos dinámicamente un ID real en la tabla clientes para no adivinar números
        try (Connection con = Conexion.conectar();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery("SELECT id_usuario FROM clientes ORDER BY id_usuario DESC LIMIT 1")) {
            
            if (rs.next()) {
                // Si encontró un cliente en phpMyAdmin, tomamos su ID
                idClienteValido = rs.getInt(1);
            } else {
                // Si la tabla está vacía, registramos un cliente de prueba primero para solucionar la llave foránea
                System.out.println("La tabla clientes estaba vacía. Creando cliente de prueba...");
                Cliente clienteAux = new Cliente(0, "Cliente Temporal", "Lorica Centro", "3000000000", "123", "Cliente");
                ClienteDAO clienteDao = new ClienteDAO();
                clienteDao.registrarCliente(clienteAux);
                
                // Consultamos el ID que se le acaba de asignar
                try (ResultSet rs2 = st.executeQuery("SELECT id_usuario FROM clientes ORDER BY id_usuario DESC LIMIT 1")) {
                    if (rs2.next()) {
                        idClienteValido = rs2.getInt(1);
                    }
                }
            }
        } catch (SQLException e) {
            fail("Falló la preparación de la prueba por error de base de datos: " + e.getMessage());
        }
        
        // 2. Ahora que tenemos la certeza absoluta de que el ID existe en la BD, armamos el pedido
        Cliente clienteExistente = new Cliente();
        clienteExistente.setIdUsuario(idClienteValido); 
        
        // 3. ¡Poder del Patrón Builder! Construimos el pedido de forma fluida
        PedidoBuilder builder = new PedidoBuilderConcreto();
        builder.setCliente(clienteExistente);
        builder.establecerFechaLimite(2); // Los 2 días hábiles solicitados
        
        Pedido pedidoGenerado = builder.build();
        
        // 4. Pasamos el pedido al DAO y validamos
        PedidoDAO dao = new PedidoDAO();
        boolean resultado = dao.registrarPedido(pedidoGenerado);
        
        assertTrue(resultado, "El pedido generado por el Builder debería guardarse perfectamente en la BD.");
    }
}