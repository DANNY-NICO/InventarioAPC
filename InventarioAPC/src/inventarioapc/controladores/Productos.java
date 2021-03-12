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
import java.util.ArrayList;

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
    private inventarioapc.vistas.CajeroInicio cajero;
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
    public Productos(inventarioapc.vistas.CrearProducto crearProducto, inventarioapc.vistas.Inventario inventario, inventarioapc.vistas.Administrador adminitrador, inventarioapc.vistas.CajeroInicio cajero){
        this.crearProducto = crearProducto;
        this.inventario = inventario;
        this.adminitrador = adminitrador;
        this.cajero = cajero;
        inventario.setControlador(this);
        modelo = new DefaultTableModel();
        code = 0;
        primer = true;
        
        cargarTabla();
        listar();
        cargarCategoria();
        cargarMarca();
    } 
    
    void listar() {
        while(modelo.getRowCount() > 0){
            modelo.removeRow(0);
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
    
    public void cargarEditar(String[] lista){
        crearProducto.codigoEdit=lista[0];
        crearProducto.getNombreTxt().setText(lista[1]);
        crearProducto.getLocalStock().setValue(Integer.parseInt(lista[2]));
        crearProducto.getBodegaStock().setValue(Integer.parseInt(lista[3]));
        crearProducto.getPrecioCompra().setValue(Integer.parseInt(lista[4]));
        crearProducto.getPrecioVenta().setValue(Integer.parseInt(lista[5]));
        crearProducto.cambiarFocus(lista[6], lista[7]);
    }
    
    public String[] buscarProducto(String codigo){
        int i = Integer.parseInt(codigo);
         String sql = "SELECT * FROM primera_entrega.tbproducto";
        try{
            conn = Conexion.coneBd();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            String[] producto = new String[8];
            while(rs.next()){
                String code = rs.getString(1);
                if(code.equals(i+"")){
                    producto[0] = code;
                    producto[1] = rs.getString(2);
                    producto[2] = rs.getString(3);
                    producto[3] = rs.getString(4);
                    producto[4] = rs.getString(5);
                    producto[5] = rs.getString(6);
                    producto[6] = rs.getString(7);
                    producto[7] = rs.getString(8);
                }
            }
            
            
            
            return producto;
        }catch(Exception e){
            System.err.println(e);
        }
        return null;
    }
    
    public void crearCategoria(String nombre){
        try{
            conn = Conexion.coneBd();   
            ps = conn.prepareStatement("INSERT INTO tbcategoria(cod_cat, nom_cat) VALUES(?,?) ");
            crearProducto.setCategoriaCodMax();
            ps.setInt(1,crearProducto.getCategoriaCodMax());
            ps.setString(2, nombre);
            int res = ps.executeUpdate();
            if (res > 0) {
                cargarCategoria();
                JOptionPane.showMessageDialog(null, "Categoria guardada");
            } else {
                JOptionPane.showMessageDialog(null, "Error al guardar categoria");
            }
            
        }catch (Exception e){
            System.err.println(e);
        }
    }
    
    public void cargarCategoria(){
        ArrayList<String> categorias = new ArrayList<String>();
        categorias.add("-1");
        categorias.add("-Seleccione-");
        String sql = "SELECT * FROM primera_entrega.tbcategoria";
        try{
            conn = Conexion.coneBd();
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            
            while(rs.next()){
                categorias.add(rs.getString(1));    //COD_CAT
                categorias.add(rs.getString(2));    //NOM_CAT
            }
                                   
        }catch (Exception e){
            System.err.println(e);
        }
        crearProducto.cargarCategoria(categorias);
    }
    
    public void cargarMarca(){
        ArrayList<String> marcas = new ArrayList<String>();
        marcas.add("-1");
        marcas.add("-Seleccione-");
        String sql = "SELECT * FROM primera_entrega.tbmarca";
        try{
            conn = Conexion.coneBd();
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            
            while(rs.next()){
                marcas.add(rs.getString(1));    //COD_MAR
                marcas.add(rs.getString(2));    //NOM_MAR
            }
                                   
        }catch (Exception e){
            System.err.println(e);
        }
        crearProducto.cargarMarca(marcas);
    }
    
    public void crearMarca(String nombre){
        try{
            conn = Conexion.coneBd();   
            ps = conn.prepareStatement("INSERT INTO tbmarca (cod_mar, nom_mar) VALUES(?,?) ");
            crearProducto.setMarcaCodMax();
            ps.setInt(1,crearProducto.getMarcaCodMax());
            ps.setString(2, nombre);
            int res = ps.executeUpdate();
            if (res > 0) {
                cargarMarca();
                JOptionPane.showMessageDialog(null, "Marca guardada");
            } else {
                JOptionPane.showMessageDialog(null, "Error al guardar Marca");
            }
            
        }catch (Exception e){
            System.err.println(e);
        }
    }
    
    public void editarProducto(int marca, int categoria){
        try {
        conn = Conexion.coneBd();   
        ps = conn.prepareStatement("UPDATE tbproducto SET cod_pro=?, nom_pro=?, stk_pro=?, stk_pro_bod=?, com_pro=?, ven_pro=?,cod_mar_fk=?,cod_cat_fk=? WHERE cod_pro=? ");
        ps.setInt(1, Integer.parseInt(crearProducto.codigoEdit));
        code +=1;
        ps.setString(2, crearProducto.getNombreTxt().getText());
        ps.setInt(3, convertirStringInt(crearProducto.getLocalStock().getValue()+""));
        ps.setInt(4, convertirStringInt(crearProducto.getBodegaStock().getValue()+""));
        ps.setDouble(5, convertirStringDouble(crearProducto.getPrecioCompra().getValue()+""));
        ps.setDouble(6, convertirStringDouble(crearProducto.getPrecioVenta().getValue()+""));
        ps.setInt(7, marca);
        ps.setInt(8, categoria);
        ps.setInt(9, Integer.parseInt(crearProducto.codigoEdit));
        
        
        int res = ps.executeUpdate();
        
        if (res > 0) {
            listar();
            JOptionPane.showMessageDialog(null, "Producto actualizado");
        } else {
            JOptionPane.showMessageDialog(null, "Error al actualizar producto");
        }
        conn.close();
        } catch(Exception e) {
            System.err.println(e);
        }
    }
    
    public void crearProducto(int marca, int categoria) {
        try {
        conn = Conexion.coneBd();   
        ps = conn.prepareStatement("INSERT INTO tbproducto(cod_pro, nom_pro, stk_pro, stk_pro_bod, com_pro, ven_pro,cod_mar_fk,cod_cat_fk) VALUES(?,?,?,?,?,?,?,?) ");
        ps.setInt(1, code);
        code +=1;
        ps.setString(2, crearProducto.getNombreTxt().getText());
        ps.setInt(3, convertirStringInt(crearProducto.getLocalStock().getValue()+""));
        ps.setInt(4, convertirStringInt(crearProducto.getBodegaStock().getValue()+""));
        ps.setDouble(5, convertirStringDouble(crearProducto.getPrecioCompra().getValue()+""));
        ps.setDouble(6, convertirStringDouble(crearProducto.getPrecioVenta().getValue()+""));
        ps.setInt(7, marca);
        ps.setInt(8, categoria);
        
        
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

    public DefaultTableModel getModelo() {
        return modelo;
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
        cajero.getTable().setModel(modelo);
    }
    

    public void eliminarFila() {
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
            modelo.removeRow(i);
            } catch (SQLException e) {
                System.err.print(e); 
            }
        }else {
            JOptionPane.showMessageDialog(null, "Seleccione fila");
        }
    }
}