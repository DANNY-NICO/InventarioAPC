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
    int code;
    boolean primer;
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
        code = 0;
        primer = true;
        
        cargarTabla();
        listar();
    } 
    
    void listar() {
        while(modelo.getRowCount() > 0){
            System.out.println(0+"//"+modelo.getRowCount());
            modelo.removeRow(0);
            System.out.println(0+"**"+modelo.getRowCount());
        }
        
        
        String sql = "SELECT * FROM primera_entrega.tbproducto";
        try {
            conn = Conexion.coneBd();
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            String[]datos = new String[6];
            
            
            while (rs.next()) {
                datos[0] = rs.getString(1); //CODIGO
                datos[1] = rs.getString(2); //NOMBRE
                datos[2] = rs.getString(3); //STOCK LOCAL
                datos[3] = rs.getString(4); //STOCK BODEBA
                datos[4] = rs.getString(5); //COMPRA
                datos[5] = rs.getString(6); //VENTA
                
                modelo.addRow(datos);
            }
            if(primer){
                code = Integer.parseInt(datos[0])+1;
                primer = false;
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }
    
    
    public void crearProducto() {
        try {
        conn = Conexion.coneBd();   
        ps = conn.prepareStatement("INSERT INTO tbproducto(cod_pro, nom_pro, stk_pro, stk_pro_bod, com_pro, ven_proi) VALUES(?,?,?,?,?,?) ");
        ps.setInt(1, code);
        code +=1;
        ps.setString(2, crearProducto.getNombreTxt().getText());
        ps.setInt(3, convertirStringInt(crearProducto.getLocalStock().getValue()+""));
        ps.setInt(4, convertirStringInt(crearProducto.getBodegaStock().getValue()+""));
        ps.setDouble(5, convertirStringDouble(crearProducto.getPrecioCompra().getText()+""));
        ps.setDouble(6, convertirStringDouble(crearProducto.getPrecioVenta().getText()+""));
        
        int res = ps.executeUpdate();
        
        if (res > 0) {
            listar();
            JOptionPane.showMessageDialog(null, "Producto guardado");
        } else {
            JOptionPane.showMessageDialog(null, "Error al guardar producto");
        }
        conn.close();
        } catch(Exception e) {
            System.err.println(e);
        }
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
        modelo.addColumn("Stock local");
        modelo.addColumn("Stock bodega");
        modelo.addColumn("P. Venta");
        modelo.addColumn("P. Compra");
        
        listar();
        
        inventario.getTable().setModel(modelo);
        adminitrador.getTabla().setModel(modelo);
    }
    
    public void eliminarFila() throws SQLException{
        int i = inventario.getTable().getSelectedRow();
        Object seleccion = inventario.getTable().getValueAt(i, 0);
        int valor = Integer.parseInt(seleccion.toString());
        
        if(i>=0){
            try {
            String sql = "DELETE FROM primera_entrega.tbproducto WHERE cod_pro = ?";
            conn = Conexion.coneBd();
            PreparedStatement st = conn.prepareCall(sql);
            st.setInt(1, valor);
            st.executeUpdate();
                System.out.println(st);
            modelo.removeRow(i);
            } catch (SQLException e) {
                System.err.print(e); 
            }
        }else {
            JOptionPane.showMessageDialog(null, "Seleccione fila");
        }
    }
    
}