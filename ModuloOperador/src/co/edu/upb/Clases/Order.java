package co.edu.upb.Clases;

import co.edu.upb.Clases.Product;
import co.edu.upb.Estructuras.ListaEnlazadaDoble.LinkedList;
import java.io.Serializable;

public class Order implements Serializable{
    public LinkedList<Product> listaProductos = new LinkedList<>();
    public String nombres;
    public String apellidos;
    public int tipoCliente;
    /*  0-> Comun
        1-> Premium
    */
    public String direccion;
    public int valorTotal;  
    /*  información de cliente:
	>Nombres
	>Apellidos
	>Tipo de cliente (?)
	>Dirección (Calle/Carrera/Avenida, Número, Casa, Barrio, Municipio)
	>Los 10 pedidos mas frecuentes ordenados por cantidad
    */
    public Order(){
        valorTotal = 0;
    }
    public Order(String nombres, String apellidos, int tipoCliente, String direccion, int valorTotal) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.tipoCliente = tipoCliente;
        this.direccion = direccion;
        this.valorTotal = valorTotal;
    }

    public String getNombres() {
        return nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public int getTipoCliente() {
        return tipoCliente;
    }

    public String getDireccion() {
        return direccion;
    }

    public int getValorTotal() {
        return valorTotal;
    }
    
    public void addProducto(Product newProduct){
        listaProductos.add(newProduct);
        valorTotal += newProduct.precio;
    }
    
    public void removeProduct(Product producto){
        if (listaProductos.remove(producto)){
            valorTotal -= producto.precio;
        }
    }
    
    public int getTotalCompra(){
        return valorTotal;
    }
    
    public void imprimir(){
        listaProductos.imprimir();
    }    
    
    @Override
    public String toString(){
        return "-" + nombres + ",  $" + valorTotal;
    }
   
}
