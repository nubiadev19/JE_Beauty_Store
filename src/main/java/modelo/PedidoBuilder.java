/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package modelo;

/**
 *
 * @author Nubia
 */
public interface PedidoBuilder {
    
    public void reset();
    public void setCliente(Cliente cliente);
    public void agregarProducto(Producto producto);
    public void calcularTotal();
    public void establecerFechaLimite(int dias);
    public Pedido build();
    
}
