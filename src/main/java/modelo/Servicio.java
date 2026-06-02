/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Nubia
 */
public class Servicio {
    
    private int idServicio;
    private String nombre;
    private double precioEstimado;
    private int tiempoEstimado;
    
    public Servicio(){
        
    }

    public Servicio(int idServicio, String nombre, double precioEstimado, int tiempoEstimado) {
        this.idServicio = idServicio;
        this.nombre = nombre;
        this.precioEstimado = precioEstimado;
        this.tiempoEstimado = tiempoEstimado;
    }

    public int getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(int idServicio) {
        this.idServicio = idServicio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecioEstimado() {
        return precioEstimado;
    }

    public void setPrecioEstimado(double precioEstimado) {
        this.precioEstimado = precioEstimado;
    }

    public int getTiempoEstimado() {
        return tiempoEstimado;
    }

    public void setTiempoEstimado(int tiempoEstimado) {
        this.tiempoEstimado = tiempoEstimado;
    }
    
    
    
}
