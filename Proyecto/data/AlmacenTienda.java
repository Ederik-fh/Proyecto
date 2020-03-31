package data;
/**
 * Stock
 */
public class AlmacenTienda {

    private int codigo;
    private String producto;
    private String cantidad;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
		this.cantidad = cantidad;
	}
}