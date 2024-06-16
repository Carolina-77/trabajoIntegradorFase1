package entities;

public class Producto {

    private int codigoProducto;
    private String nombreProducto;
    private String descripcion;
    private double precioVenta;
    private int stock;

    public Producto(int codigoProducto, String nombreProducto, String descripcion, double precioVenta, int stock) {
	this.codigoProducto = codigoProducto;
	this.nombreProducto = nombreProducto;
	this.descripcion = descripcion;
	this.precioVenta = precioVenta;
	this.stock = stock;
    }

    public Producto(String nombreProducto, String descripcion, double precioVenta, int stock) {
	this.nombreProducto = nombreProducto;
	this.descripcion = descripcion;
	this.precioVenta = precioVenta;
	this.stock = stock;
    }

    public Producto() {
    }

    public int getCodigoProducto() {
	return codigoProducto;
    }

    public String getNombreProducto() {
	return nombreProducto;
    }

    public String getDescripcion() {
	return descripcion;
    }

    public double getPrecioVenta() {
	return precioVenta;
    }

    public int getStock() {
	return stock;
    }

    public void setCodigoProducto(int codigoProducto) {
	this.codigoProducto = codigoProducto;
    }

    public void setNombreProducto(String nombreProducto) {
	this.nombreProducto = nombreProducto;
    }

    public void setDescripcion(String descripcion) {
	this.descripcion = descripcion;
    }

    public void setPrecioVenta(double precioVenta) {
	this.precioVenta = precioVenta;
    }

    public void setStock(int stock) {
	this.stock = stock;
    }

    @Override
    public String toString() {

	return "Producto{" + "codigoProducto=" + codigoProducto + ", nombreProducto='" + nombreProducto + '\''
		+ ", descripcion='" + descripcion + '\'' + ", precioVenta=" + precioVenta + ", stock=" + stock + '}';
    }

}
