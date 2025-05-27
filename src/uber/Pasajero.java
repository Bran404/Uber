package uber;

public class Pasajero {
    private String nombre;
    private ArrayList<Direccion> direcciones;
    private MetodoDePago metodoDePago;

    public Pasajero(String nombre, MetodoDePago metodoDePago) {
        this.nombre = nombre;
        this.direcciones = new ArrayList<Direccion>();
        this.metodoDePago = metodoDePago;
    }

    public Pasajero(String nombre) {
        this.nombre = nombre;
        this.direcciones = new ArrayList<Direccion>();
        this.metodoDePago = MetodoDePago.EFECTIVO;
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

    public MetodoDePago getMetodoDePago() {
        return metodoDePago;
    }

    public void setMetodoDePago(MetodoDePago metodoDePago) {
        this.metodoDePago = metodoDePago;
    }
}
