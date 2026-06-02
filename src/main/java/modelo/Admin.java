/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Nubia
 */
public class Admin extends Usuario {
    
 public Admin(){
     super();
 }

    public Admin(int idUsuario, String nombre, String direccion, String telefono, String contrasena, String rol) {
        super(idUsuario, nombre, direccion, telefono, contrasena, rol);
    }
  
 
}
