/**
 * CantidadRequerida
 */
public class Venta extends StockTienda {

    private int precio;
    private String datospersonales;

    public Venta(int codigo,String producto,String cantidad, int precio,String datospersonales){
        super(codigo,producto,cantidad);
        this.precio = precio;
        this.datospersonales = datospersonales;

    }
    public void mostrarDatos(){
        System.out.println("Codigo: "+getCodigo()+
        "\nProducto: "+getProducto()+
        "\nCantidad: "+getCantidad()+
        "\nprecio: "+getPrecio()+
        "\ndatospersonales: "+getdatospersonales);


    }


}