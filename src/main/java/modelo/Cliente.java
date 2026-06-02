/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Nubia
 */
public class Cliente extends Usuario {
 
       public Cliente(){ //se llama al constructor vacio de usuario
        super();
    }

       
       //se llama al constructor completo
    public Cliente(int idUsuario, String nombre, String direccion, String telefono, String contrasena, String rol) {
        super(idUsuario, nombre, direccion, telefono, contrasena, rol);
    }
       
       
}
