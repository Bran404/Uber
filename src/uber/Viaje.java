package uber;

public class Viaje {
    private ArrayList<Pasajero> pasajeros;
    private Chofer chofer;
    private TipoDeViaje tipoDeViaje;
    private Pago pago;
    private float calificacion;

    public Viaje(ArrayList<Pasajero> pasajeros, Chofer chofer, TipoDeViaje tipoDeViaje, MetodoDePago metodoDePago) {
        this.pasajeros = pasajeros;
        this.chofer = chofer;
        this.tipoDeViaje = tipoDeViaje;
        this.pago = setPago(MetodoDePago);
        this.calificacion = 0.0;
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

    public TipoDeViaje getTipoDeViaje() {
        return tipoDeViaje;
    }

    public void setTipoDeViaje(TipoDeViaje tipoDeViaje) {
        this.tipoDeViaje = tipoDeViaje;
    }

    public Pago getPago() {
        return pago;
    }

    private void setPago() {
        // TODO: implement correctly the definition of the payment
        metodo = getPasajero(0).getMetodoDePago();
        monto = 0.0;
        this.pago = new Pago(metodo, monto);
    }

    public float getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(float calificacion) {
        this.calificacion = calificacion;
    }
}
