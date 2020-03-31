package data;

import java.util.ArrayList;
import java.util.List;

public class AlmacenData {
    List<Almacen> listaAlmacenes = new ArrayList<Almacen>();

    public List<Almacen> list() {
        return listaAlmacenes;
    }

    public void create(Almacen d) {
        listaAlmacenes.add(d);
        
    }

    public void delete(Almacen d) {
        listaAlmacenes.remove(d);
    }

    public void delete(int codigo) {
        boolean existe= false;
        for (Almacen d : listaAlmacenes) {
            System.out.println("Deleted:"+d.getCodigo() + "\t" + d.getProducto());
            if (codigo == d.getCodigo()) {
                try {
                    listaAlmacenes.remove(d);
                    //listaContactos.update();

                } catch (java.util.ConcurrentModificationException e2) {
                    
                    System.out.println("Almacen si exist Producto e2="+e2);
                }
                
                
                existe= true;
            }
        }
        if(!existe) {
            System.out.println("Almacen no existe Producto");
        }
    }

}