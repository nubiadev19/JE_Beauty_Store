/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Nubia
 */
public class Conexion {
    
    private static final String URL= "jdbc:mysql://localhost:3306/beautyStore";
    private static final String USUARIO="admin";
    private static final String CONTRASENA= "admin123";
    
    //metodo para conectar a la base de datos
    public static Connection conectar(){
        Connection conexion=null;
        
        try{
            conexion = DriverManager.getConnection(URL, USUARIO, CONTRASENA);
            System.out.println("conexion exitosa");
        }catch (SQLException e){
            System.out.println("error de conexion, yaper" + e.getMessage());
        }
        return conexion;
    }
    
}
