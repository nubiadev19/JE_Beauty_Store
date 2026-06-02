/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import dao.Conexion;
import java.sql.Connection;
/**
 *
 * @author Nubia
 */
public class JEBeautyStore {
   
    public static void main(String[] args) {
        System.out.println("Iniciando el sistema de JE Beauty Store...");
        
        // Ejecutamos la prueba de conexión
        Connection con = Conexion.conectar();
        
        if (con != null) {
            System.out.println("¡Todo listo! La base de datos y Java se entienden a la perfección.");
        } else {
            System.out.println("Revisa que XAMPP esté encendido y el nombre de la BD sea correcto.");
        }
    }
}
