import java.awt.*;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.event.*;
import javax.swing.table.*;

import data.Almacen;
import data.AlmacenData;
import data.AlmacenTienda;
import data.AlmacenTiendaData;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class CompletarPrdtos extends JFrame {

    private static final long serialVersionUID = 1L;
    
    int almacenCodigo = 0;
    AlmacenData almacenData = new AlmacenData();
    String[] almacenColumns = { "Codigo", "Producto","Tipop"};
    String[][] almacenMatriz = new String[0][almacenColumns.length];
    DefaultTableModel model = new DefaultTableModel(almacenMatriz, almacenColumns);
    JTable almacenTable = new JTable(model);
    JScrollPane almacenSP = new JScrollPane();

    int almacentiendaCodigo = 0;
    AlmacenTiendaData almacentiendaData = new AlmacenTiendaData();
    String[] almacentiendaColumns = { "Codigo","Producto","Cantidad"};
    String[][] almacentiendaMatriz = new String[0][almacentiendaColumns.length];
    DefaultTableModel model2 = new DefaultTableModel(almacentiendaMatriz, almacentiendaColumns);
    JTable almacentiendaTable = new JTable(model2);
    JScrollPane almacentiendaSP = new JScrollPane();

    public CompletarPrdtos() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        JMenuBar mb = new JMenuBar();
        JMenu m1 = new JMenu("Consultar");
        JMenu m2 = new JMenu("AYUDA");
        mb.add(m1);
        mb.add(m2);
        JMenuItem m11 = new JMenuItem("Almacen");
        JMenuItem m12 = new JMenuItem("AlmacenTie");
        JMenuItem m19 = new JMenuItem("Salir");

        JPanel almacenPanel = new JPanel();
        almacenPanel.setLayout(new BoxLayout(almacenPanel, BoxLayout.Y_AXIS));
        JLabel almacenLblNombre = new JLabel("Ingrese El Producto:");
        JTextField almacenTxtNombre = new JTextField();

        JLabel almacenLblDocumento = new JLabel("Ingrese El Tipo de Producto:");
        JTextField almacenTxtDocumento = new JTextField();

        JButton btnadd = new JButton("Agregar");
        JButton button;
        button = new JButton("Remove");
        almacenSP.setViewportView(almacenTable);
        almacenPanel.add(almacenLblNombre);
        almacenPanel.add(almacenTxtNombre);
        almacenPanel.add(almacenLblDocumento);
        almacenPanel.add(almacenTxtDocumento);
        almacenPanel.add(btnadd);
        almacenPanel.add(button);
        almacenPanel.add(almacenSP);

        btnadd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                almacenCodigo++;
                Almacen d = new Almacen();
                d.setCodigo(almacenCodigo);
                d.setProducto(almacenTxtNombre.getText());
                almacenData.create(d);
                d.setTipop(almacenTxtDocumento.getText());
                
                List<Almacen> miLista = almacenData.list();
                almacenMatriz = new String[miLista.size()][almacenColumns.length];
                for (int i = 0; i < miLista.size(); i++) {
                    almacenMatriz[i][0] = miLista.get(i).getCodigo() + "";
                    almacenMatriz[i][1] = miLista.get(i).getProducto() + "";
                    almacenMatriz[i][2] = miLista.get(i).getTipop() + "";
                }
                model = new DefaultTableModel(almacenMatriz, almacenColumns);
                almacenTable = new JTable(model);
                almacenSP.setViewportView(almacenTable);
             }
        });

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (almacenTable.getSelectedRow() != -1) {
                    String ids = null;
                    int[] row = almacenTable.getSelectedRows();
                    ids = (String) almacenTable.getValueAt(row[0], 0);
                    System.out.println("Table element selected es: " + ids);
                    int id = Integer.parseInt(ids);
                    almacenTxtNombre.setText(" " + id);
                    
                    model.removeRow(almacenTable.getSelectedRow());
                    try {
                        almacenData.delete(id);
                    } catch (java.util.ConcurrentModificationException e2) {
                        System.out.println("almacen si exist e2="+e2);
                    }
                }
            }
        });

        JPanel almacentiendaPanel = new JPanel();

        almacentiendaPanel.setLayout(new BoxLayout(almacentiendaPanel, BoxLayout.Y_AXIS));

        JLabel almacentiendaLblProducto = new JLabel("Ingrese El Producto:");
        JTextField almacentiendaTxtProducto = new JTextField();

        JLabel almacentiendaLblPrecio = new JLabel("Ingrese La Cantidad:");
        JTextField almacentiendaTxtPrecio = new JTextField();

        JButton btnadd2 = new JButton("Agregar");
        JButton button2;
        button2 = new JButton("Remove");
        almacentiendaSP.setViewportView(almacentiendaTable);
        almacentiendaPanel.add(almacentiendaLblProducto);
        almacentiendaPanel.add(almacentiendaTxtProducto);
        almacentiendaPanel.add(almacentiendaLblPrecio);
        almacentiendaPanel.add(almacentiendaTxtPrecio);
        almacentiendaPanel.add(btnadd2);
        almacentiendaPanel.add(button2);
        almacentiendaPanel.add(almacentiendaSP);

        btnadd2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                almacentiendaCodigo++;
                AlmacenTienda d = new AlmacenTienda();
                d.setCodigo(almacentiendaCodigo);
                d.setProducto(almacentiendaTxtProducto.getText());
                almacentiendaData.create(d);
                d.setCantidad(almacentiendaTxtPrecio.getText());  

                List<AlmacenTienda> miLista = almacentiendaData.list();
                almacentiendaMatriz = new String[miLista.size()][almacentiendaColumns.length];
                for (int i = 0; i < miLista.size(); i++) {
                    almacentiendaMatriz[i][0] = miLista.get(i).getCodigo() + "";
                    almacentiendaMatriz[i][1] = miLista.get(i).getProducto() + "";
                    almacentiendaMatriz[i][2] = miLista.get(i).getCantidad() + "";
                }
                model2 = new DefaultTableModel(almacentiendaMatriz, almacentiendaColumns);
                almacentiendaTable = new JTable(model2);
                almacentiendaSP.setViewportView(almacentiendaTable);
            }
        });

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (almacentiendaTable.getSelectedRow() != -1) {
                    String ids = null;
                    int[] row = almacentiendaTable.getSelectedRows();
                    ids = (String) almacentiendaTable.getValueAt(row[0], 0);
                    System.out.println("Table element selected es: " + ids);
                    int id = Integer.parseInt(ids);
                    almacentiendaTxtProducto.setText(" " + id);
                    
                    model2.removeRow(almacentiendaTable.getSelectedRow());
                    try {
                        almacentiendaData.delete(id);
                    } catch (java.util.ConcurrentModificationException e2) {
                        System.out.println("almacen si exist e2="+e2);
                    }
                }
            }
        });
        m11.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                System.out.println("Ir a almacen");
                JOptionPane.showMessageDialog(null, almacenPanel, "Almacenes", JOptionPane.PLAIN_MESSAGE);
            }
        });
        m12.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                System.out.println("Ir a AlmacenTienda");
                JOptionPane.showMessageDialog(null, almacentiendaPanel, "AlmacenTiendas", JOptionPane.PLAIN_MESSAGE);
            }
        });
        m19.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                System.exit(0);
            }
        });

        m1.add(m11);
        m1.add(m12);
        m1.add(m19);

        JPanel footPanel = new JPanel();
        JLabel footLblCopy = new JLabel("c(2020) POO");
        footPanel.add(footLblCopy);

        add(BorderLayout.NORTH, mb);
        add(BorderLayout.SOUTH, footPanel);
    }

    public static void main(String args[]) {
        CompletarPrdtos ex = new CompletarPrdtos();
        ex.setVisible(true);
    }

}