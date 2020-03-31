package herencia;

public class Producto extends Almacen {

    private String IdProducto;

    
    public Producto (String tipoproducto, String nombreproducto, int cantidad) {

        super(tipoproducto, nombreproducto, cantidad);

        IdProducto = "Unknown";   } 

    

    public void setIdProducto (String IdProducto) { this.IdProducto = IdProducto;   }

    public String getIdProducto () { return IdProducto;   }

    public void mostrarTipoProductoNombreProductoYCantidad() {

       

        System.out.println ("Producto de Tipo: " + getTipoProducto() + " " +  getNombreProducto() +

         " con Id de producto: " + getIdProducto() ); }

} 