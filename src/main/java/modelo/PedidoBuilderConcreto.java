/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Nubia
 */
public class PedidoBuilderConcreto implements PedidoBuilder {
    
    private Pedido pedido;
    private Cliente cliente;
    private List<Producto> productosTemporales;
    
    public PedidoBuilderConcreto(){
        this.productosTemporales=new ArrayList<>();
        this.reset();
    }

    @Override
    public void reset() {
       this.pedido=new Pedido();
       this.productosTemporales.clear();
    }

    @Override
    public void setCliente(Cliente cliente) {
        this.cliente=cliente;
    }

    @Override
    public void agregarProducto(Producto producto) {
    this.productosTemporales.add( producto);
    }

    
    //sumando los precios de cada uno de los productos que componen el carrito
    @Override
    public void calcularTotal() {
    double total=0.0;
    for(Producto prod : productosTemporales){
       total += prod.getPrecio();
    }
     this.pedido.setPrecioTotal(total);
    }
    

    @Override
    public void establecerFechaLimite(int dias) {
       this.pedido.setDiasHabiles(dias);
       
       LocalDateTime ahora = LocalDateTime.now();
       this.pedido.setFechaCreacion(ahora);
       
       LocalDateTime limite = ahora.plusDays(dias);
       this.pedido.setFechaLimite(limite);
               
    }

    @Override
    public Pedido build() {
        this.pedido.setEstado("Pendiente");
        
        Pedido resultado = this.pedido;
        this.reset();
        
        return resultado;
    }
    
}
