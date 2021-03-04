package inventarioapc.modelos;

/**
 *
 * @author Nicolas Soler & Danny Ochoa
 */
public class Proveedor extends Persona{
    
    private int documento;
    private String empresa;
    private String contacto;
    private int precio;
    private String codigoProducto;

    public Proveedor() {
        super();
    }

    public long getDocumento() {
        return documento;
    }

    public void setDocumento(int documento) {
        this.documento = documento;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(String codigoProducto) {
        this.codigoProducto = codigoProducto;
    }
        
    
}
