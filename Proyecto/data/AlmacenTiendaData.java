package data;
/**
 * StockData
 */
import java.util.ArrayList;
import java.util.List;

/**
 * ContactoData DAO está el CRUD
 */
public class AlmacenTiendaData {
    List<AlmacenTienda> listaAlmacenTiendas = new ArrayList<AlmacenTienda>();

    public List<AlmacenTienda> list() {
        return listaAlmacenTiendas;
    }

    public void create(AlmacenTienda d) {
        listaAlmacenTiendas.add(d);
        // System.out.println(d.getNombre()+" is created!");
    }

    public void delete(AlmacenTienda d) {
        listaAlmacenTiendas.remove(d);
    }

    public void delete(int codigo) {
        boolean existe= false;
        for (AlmacenTienda d : listaAlmacenTiendas) {
            System.out.println("Deleted:"+d.getCodigo() + "\t" + d.getProducto());
            if (codigo == d.getCodigo()) {
                try {
                    listaAlmacenTiendas.remove(d);
                    //listaContactos.update();

                } catch (java.util.ConcurrentModificationException e2) {
                    
                    System.out.println("Almacen en tienda si exist e2="+e2);
                }
                
                
                existe= true;
            }
        }
        if(!existe) {
            System.out.println("Almacen en tienda no existe");
        }
    }

}