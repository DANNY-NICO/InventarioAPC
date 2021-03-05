/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventarioapc.controladores;

//import config.Conexion;
import config.Conexion;
import java.sql.Connection;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import inventarioapc.modelos.Producto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author nicolas soler & danny ochoa
 * Clase encargada de realizar la consulta y carga a la base de datos con todo lo referente a los productos
 * 
 */
public class Productos {
    
    private inventarioapc.vistas.CrearProducto crearProducto;
    private inventarioapc.vistas.Inventario inventario;
    private inventarioapc.vistas.Administrador adminitrador;
    private DefaultTableModel modelo;
    Connection conn = null;
    Statement st;
    PreparedStatement ps;
    ResultSet rs;
    /**
     * Los parametros son las vistas especificas para el acceso a los campos que el usuario vera e interactuara con respecto a los productos
     * @param crearProducto
     * @param inventario 
     */
    public Productos(inventarioapc.vistas.CrearProducto crearProducto, inventarioapc.vistas.Inventario inventario, inventarioapc.vistas.Administrador adminitrador){
        this.crearProducto = crearProducto;
        this.inventario = inventario;
        this.adminitrador = adminitrador;
        inventario.setControlador(this);
        modelo = new DefaultTableModel();
        cargarTabla();
        listar();
    } 
    
    void listar() {
        String sql = "SELECT * FROM tbproducto";
        try {
            conn = Conexion.coneBd();
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            System.out.println(rs);
            String[]tbproducto = new String[5];
            System.out.print(rs.getArray(sql));
            
            while (rs.next()) {
                System.out.print(rs.getString(1));
  /*              tbproducto[0] = rs.getString(0);
                tbproducto[1] = rs.getString(1);
                tbproducto[2] = rs.getString(2);
                tbproducto[3] = rs.getString(3);
                tbproducto[4] = rs.getString(4);
                tbproducto[5] = rs.getString(5);
                System.out.println("Holi");
                modelo.addRow(tbproducto);
                */
            }
           System.out.print(tbproducto[0]);
        } catch (Exception e) {
            System.err.print(e);
        }
    }
    
    
    public void crearProducto() {
        try {
        conn = Conexion.coneBd();   
        ps = conn.prepareStatement("INSERT INTO tbproducto(cod_pro, nom_pro, stk_pro, stk_pro_bod, com_pro, ven_proi) VALUES(?,?,?,?,?,?) ");
        ps.setInt(1, 1);
        ps.setString(2, crearProducto.getNombreTxt().getText());
        ps.setInt(3, convertirStringInt(crearProducto.getLocalStock().getValue()+""));
        ps.setInt(4, convertirStringInt(crearProducto.getBodegaStock().getValue()+""));
        ps.setDouble(5, convertirStringDouble(crearProducto.getPrecioCompra().getText()+""));
        ps.setDouble(6, convertirStringDouble(crearProducto.getPrecioVenta().getText()+""));
        
        int res = ps.executeUpdate();
        
        if (res > 0) {
            JOptionPane.showMessageDialog(null, "Producto guardado");
        } else {
            JOptionPane.showMessageDialog(null, "Error al guardar producto");
        }
        conn.close();
        } catch(Exception e) {
            System.err.println(e);
        }
        
        
        /*
        Producto temporal = new Producto();
        temporal.setCodigoCategoria(convertirStringInt(crearProducto.getCategoria().getSelectedItem()+""));
        temporal.setCodigoMarca(convertirStringInt(crearProducto.getMarca().getSelectedItem()+""));
        temporal.setCodigoProducto(0);
        temporal.setPrecioCompra(convertirStringInt(crearProducto.getPrecioCompra().getText()));
        temporal.setPrecioVenta(convertirStringInt(crearProducto.getPrecioVenta().getText()));
        temporal.setStockLocal(convertirStringInt(crearProducto.getLocalStock().getValue()+""));
        temporal.setStockBodega(convertirStringInt(crearProducto.getBodegaStock().getValue()+""));
        temporal.setUtilidad(convertirStringInt(crearProducto.getPrecioVenta().getText()) - convertirStringInt(crearProducto.getPrecioCompra().getText()));
        temporal.setNombre(crearProducto.getNombreTxt().getText());
        
        agregarFila(temporal);
*/
    }
    
    public int convertirStringInt (String n){
        try {
            return Integer.parseInt(n);
        } catch (NumberFormatException e) {
            return 0;
        }
    }
    
    public double convertirStringDouble (String n) {
        try {
            return Double.parseDouble(n);
        } catch (NumberFormatException e) {
            return 0;
        }
    }
    
    public void agregarFila(Producto entrante){
        String info[] = new String[6];
        info[0]=""+entrante.getCodigoProducto();
        info[1]=""+entrante.getNombre();
        info[2]=""+entrante.getPrecioVenta();
        info[3]=""+entrante.getPrecioCompra();
        info[4]=""+entrante.getStockLocal();
        info[5]=""+entrante.getStockBodega();
        
        modelo.addRow(info);
        inventario.getTable().setModel(modelo);
    }
            
    public void cargarTabla(){
         
        
        
        modelo.addColumn("ID");
        modelo.addColumn("Nombre");
        modelo.addColumn("P. Venta");
        modelo.addColumn("P. Compra");
        modelo.addColumn("Stock local");
        modelo.addColumn("Stock bodega");
        
        String info[] = new String[6];
        info[0]="1";
        info[1]="prueba";
        info[2]="intento A";
        info[3]="intento B";
        info[4]="10";
        info[5]="10";
  
        
        modelo.addRow(info);
        
        inventario.getTable().setModel(modelo);
        adminitrador.getTabla().setModel(modelo);
    }
    
    public void eliminarFila(){
        int i = inventario.getTable().getSelectedRow();
        
        if(i>=0){
            modelo.removeRow(i);
        }else {
            JOptionPane.showMessageDialog(null, "Seleccione fila");
        }
    }
    
}