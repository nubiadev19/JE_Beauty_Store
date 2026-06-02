/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import modelo.Producto;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Nubia
 */
public class ProductoDAOTest {
    
    public ProductoDAOTest() {
    }

    @Test
    public void testRegistrarProducto() {
        System.out.println("Ejecutando prueba unitaria: registrarProducto");
        
        // 1. Instanciamos un producto usando tu constructor completo:
        // Producto(codProducto, nombre, stock, precio, descripcion)
        Producto productoPrueba = new Producto(0, "Tinte Rubio Cenizo", 15, 25000.0, "Tinte de alta duración para salón");
        
        // 2. Instanciamos el DAO
        ProductoDAO dao = new ProductoDAO();
        
        // 3. Ejecutamos y validamos con la aserción de JUnit 5
        boolean resultado = dao.registrarProducto(productoPrueba);
        
        assertTrue(resultado, "El producto debería guardarse correctamente en la tabla 'productos'.");
    }
}