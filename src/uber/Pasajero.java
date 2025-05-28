package uber;
import java.util.ArrayList;

public class Pasajero {
    private String nombre;
    private ArrayList<Direccion> direcciones;
    private MetodoPago metodoDePago;

    public Pasajero(String nombre, MetodoPago metodoPago) {
        this.nombre = nombre;
        this.direcciones = new ArrayList<Direccion>();
        this.metodoDePago = metodoPago;
    }

    public Pasajero(String nombre) {
        this.nombre = nombre;
        this.direcciones = new ArrayList<Direccion>();
        this.metodoDePago = MetodoPago.EFECTIVO;
    }

    public String getNombre() {
        return nombre;
    }

    public ArrayList<Direccion> getDirecciones() {
        return direcciones;
    }

    public void addDireccion(Direccion direccion) {
        this.direcciones.add(direccion);
    }

    public void removeDireccion(Direccion direccion) {
        this.direcciones.remove(direccion);
    }

    public Direccion getDireccion(int index) {
        return this.direcciones.get(index);
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public MetodoPago getMetodoDePago() {
        return metodoDePago;
    }

    public void setMetodoDePago(MetodoPago metodoDePago) {
        this.metodoDePago = metodoDePago;
    }
}
