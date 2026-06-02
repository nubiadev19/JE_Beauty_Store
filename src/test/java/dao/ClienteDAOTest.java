/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package dao;

import modelo.Cliente;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Nubia
 */
public class ClienteDAOTest {
    
    public ClienteDAOTest() {
    }

    @Test
    public void testRegistrarCliente() {
        System.out.println("Ejecutando prueba unitaria: registrarCliente");
        
        // 1. Creamos un objeto Cliente de prueba con el constructor de herencia
        Cliente clientePrueba = new Cliente(0, "Maria Camila", "Barrio Centro", "3101234567", "clave123", "Cliente");
        
        // 2. Instanciamos el DAO
        ClienteDAO dao = new ClienteDAO();
        
        // 3. Ejecutamos el método que queremos probar
        boolean resultado = dao.registrarCliente(clientePrueba);
        
        // 4. LA ASERCIÓN: JUnit verifica si el resultado fue 'true'
        assertTrue(resultado, "El cliente debería haberse registrado exitosamente en la base de datos.");
    }
}