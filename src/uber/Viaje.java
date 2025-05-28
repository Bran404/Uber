package uber;
import java.util.ArrayList;

public class Viaje {
    private ArrayList<Pasajero> pasajeros;
    private Chofer chofer;
    private EnumViaje tipoDeViaje;
    private Pago pago;
    private float calificacion;

    public Viaje(ArrayList<Pasajero> pasajeros, Chofer chofer, EnumViaje tipoDeViaje, MetodoPago metodoDePago) {
        this.pasajeros = pasajeros;
        this.chofer = chofer;
        this.tipoDeViaje = tipoDeViaje;
        this.pago = setPago();
        this.calificacion = (float) 0.0;
    }

    
    public ArrayList<Pasajero> getPasajeros() {
        return pasajeros;
    }

    private Pasajero getPasajero(int index) {
        return this.pasajeros.get(index);
    }

    public void addPasajero(Pasajero pasajero) {
        this.pasajeros.add(pasajero);
    }

    public void removePasajero(Pasajero pasajero) {
        this.pasajeros.remove(pasajero);
    }

    public Chofer getChofer() {
        return chofer;
    }

    public void setChofer(Chofer chofer) {
        this.chofer = chofer;
    }

    public EnumViaje getTipoDeViaje() {
        return tipoDeViaje;
    }

    public void setTipoDeViaje(EnumViaje tipoDeViaje) {
        this.tipoDeViaje = tipoDeViaje;
    }

    public Pago getPago() {
        return pago;
    }

    private Pago setPago() {
        // TODO: implement correctly the definition of the payment
        MetodoPago metodo = getPasajero(0).getMetodoDePago();
        float monto = (float) 0.0;
        this.pago = new Pago(metodo, monto);
        return this.pago;
    }

    public float getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(float calificacion) {
        this.calificacion = calificacion;
    }
}
