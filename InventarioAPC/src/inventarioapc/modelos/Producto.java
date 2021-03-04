package inventarioapc.modelos;

/**
 * 
 * @author Nicolas Soler & Danny Ochoa
 */
public class Producto {
    
    private int codigoProducto;
    private String nombre;
    private int stockLocal;
    private int stockBodega;
    private double precioVenta;
    private double precioCompra;
    private double utilidad;
    private int codigoMarca;
    private int codigoCategoria; 

    public Producto() {
    }
    
    public String toString(){
        return ""+codigoCategoria+"\n"+nombre+"\n"+stockLocal+"\n"+stockBodega+"\n"+precioVenta+"\n"+precioCompra+"\n"+utilidad+"\n"+codigoMarca+"\n"+codigoCategoria;
    }

    public int getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(int codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getStockLocal() {
        return stockLocal;
    }

    public void setStockLocal(int stockLocal) {
        this.stockLocal = stockLocal;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public double getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(double precioCompra) {
        this.precioCompra = precioCompra;
    }

    public double getUtilidad() {
        return utilidad;
    }

    public void setUtilidad(double utilidad) {
        this.utilidad = utilidad;
    }

    public int getCodigoMarca() {
        return codigoMarca;
    }

    public void setCodigoMarca(int codigoMarca) {
        this.codigoMarca = codigoMarca;
    }

    public int getCodigoCategoria() {
        return codigoCategoria;
    }

    public void setCodigoCategoria(int codigoCategoria) {
        this.codigoCategoria = codigoCategoria;
    }

    public int getStockBodega() {
        return stockBodega;
    }

    public void setStockBodega(int stockBodega) {
        this.stockBodega = stockBodega;
    }
    
    
    
}
