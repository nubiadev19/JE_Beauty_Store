/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Nubia
 */
public class Producto implements ProductoProtoTp {
    
    private int codProducto;
    private String nombre;
    private int stock;
    private double precio;
    private String descripcion;

    public Producto() {
    }

    public Producto(int codProducto, String nombre, int stock, double precio, String descripcion) {
        this.codProducto = codProducto;
        this.nombre = nombre;
        this.stock = stock;
        this.precio = precio;
        this.descripcion=descripcion;
        
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
//implementacion del patron prototype
    @Override
    public ProductoProtoTp clonar() {
        //retorna una nueva instancia con los mismso valores, clon
  return new Producto(this.codProducto,this.nombre, this.stock,this.precio, this.descripcion);
    }

    @Override
    public int getCodProducto() {
    return codProducto;
    }

    @Override
    public void setNombre(String nombre) {
        this.nombre=nombre;
    }

  
    
}
