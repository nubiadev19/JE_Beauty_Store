/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * @author Nubia
 */
public class Cita {
    
    private int idCita;
    private Cliente clienta;
    private Servicio servicio;
    private LocalDate fecha;
    private LocalTime hora;
    private String estado;

    public Cita() {
    }

    public Cita(int idCita, Cliente clienta, Servicio servicio, LocalDate fecha, LocalTime hora, String estado) {
        this.idCita = idCita;
        this.clienta = clienta;
        this.servicio = servicio;
        this.fecha = fecha;
        this.hora = hora;
        this.estado = estado;
    }

    public int getIdCita() {
        return idCita;
    }

    public void setIdCita(int idCita) {
        this.idCita = idCita;
    }

    public Cliente getClienta() {
        return clienta;
    }

    public void setClienta(Cliente clienta) {
        this.clienta = clienta;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    public void agregarPedido(){
        
    }
    
    public void modificarPedido(){
        
    }
    
    public void eliminarPedido(){
        
    }
    
    public void mostrarPedido(){
        
    }
}
