package uber;
import java.util.ArrayList;

public class Viaje {
    private ArrayList<Pasajero> pasajeros;
    private Chofer chofer;
    private EnumViaje tipoDeViaje;
    private final Pago pago;
    private float calificacion;
    private EstadoViaje estadoViaje;
    private String mensajeEstado;

    public Viaje(ArrayList<Pasajero> pasajeros, Chofer chofer, EnumViaje tipoDeViaje) {
        this.pasajeros = pasajeros;
        this.chofer = chofer;
        this.chofer.historial.addViaje(this);
        this.tipoDeViaje = tipoDeViaje;
        this.pago = this.setPago();
        this.calificacion = (float) 0.0;
        this.estadoViaje = EstadoViaje.PENDIENTE_ACEPTAR_CHOFER;
        this.mensajeEstado = this.generateMessage();
    }

    public Viaje (ArrayList<Pasajero> pasajeros, EnumViaje tipoDeViaje) {
        // Sobrecarga del Constructor sin chofer
        this.pasajeros = pasajeros;
        this.chofer = null;
        this.tipoDeViaje = tipoDeViaje;
        this.pago = this.setPago();
        this.calificacion = (float) 0.0;
        this.estadoViaje = EstadoViaje.SIN_ASIGNAR;
        this.mensajeEstado = this.generateMessage();
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
        if (this.chofer == null){
            this.chofer = chofer;
            this.chofer.historial.addViaje(this);
        } else {
            System.out.println("El viaje ya tiene un chofer, y no se puede cambiar una vez definido.");
        }

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
        MetodoPago metodo = getPasajero(0).getMetodoDePago();   // First Pasajero on the list will be the one that defines payment.
        float monto = (float) 0.0;  // TODO: monto should be defined via another function according to the Viaje's data.

        return new Pago(metodo, monto);
    }

    public float getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(float calificacion) {
        this.calificacion = calificacion;
    }

    /**
     * Cancela el viaje y modifica el estado del viaje seg n qui n lo cancela.
     * 
     * @param canceladoPor puede ser "pasajero", "chofer" o "sistema", según quién
     *            lo cancela. Si no se especifica, se cancela por el sistema.
     */
    public void cancelarViaje(String canceladoPor) {
        if (canceladoPor.equals("pasajero")) {
            this.estadoViaje = EstadoViaje.CANCELADO_PASAJERO;
        } else if (canceladoPor.equals("chofer")) {
            this.estadoViaje = EstadoViaje.CANCELADO_CHOFER;
        } else {
            this.estadoViaje = EstadoViaje.CANCELADO_SISTEMA;
        }
        this.mensajeEstado = generateMessage();
        this.pago.setEstadoPago(EstadoPago.CANCELADO);
        this.calificacion = null;   // Deberíamos hacer la calificación inválida si el viaje fue cancelado?
    }
    
    /**
     * Cancela el viaje y modifica el estado del viaje según quién lo cancela.
     * Incluye una especificación adicional sobre el motivo de la cancelación.
     * 
     * @param canceladoPor puede ser "pasajero", "chofer" o "sistema", según quién
     *            lo cancela. Si no se especifica, se cancela por el sistema.
     * @param motivo mensaje adicional que se incluye en el estado del viaje.
     *            El mensaje ya incluye quién lo canceló, esto es específicamente
     *            el texto a agregar al final sobre el motivo o razón.
     */
    public void cancelarViaje(String canceladoPor, String motivo) {
        if (canceladoPor.equals("pasajero")) {
            this.estadoViaje = EstadoViaje.CANCELADO_PASAJERO;
        } else if (canceladoPor.equals("chofer")) {
            this.estadoViaje = EstadoViaje.CANCELADO_CHOFER;
        } else {
            this.estadoViaje = EstadoViaje.CANCELADO_SISTEMA;
        }
        this.mensajeEstado = generateMessage() + " " + motivo;
        this.pago.setEstadoPago(EstadoPago.CANCELADO);
    }

    public String seguimientoViaje() {
        // TODO: implement the tracking correctly according to its state and other data.
        // NOTE: Consider turning this into a .toString if generateMessage gives all the public data,
        // otherwise, consider this tracking as only possible while the viaje is in progress,
        // .toString should be used when the viaje is finished and give all the data from the class.
        return this.mensajeEstado;
    }

    private void generateMessage() {
        String msg = "";

        msg += "Viaje de tipo " + this.tipoDeViaje + ". ";

        msg += "Pasajeros: ";
        for (int i = 0; i < this.pasajeros.size(); i++) {
            if (i == this.pasajeros.size() - 1) {
                msg += this.pasajeros.get(i).getNombre() + ". ";
            } else {
                msg += this.pasajeros.get(i).getNombre() + ", ";
            }
        }

        if (this.chofer == null) {
            msg += "Sin chofer asignado. ";
        } else {
            msg += "Chofer: " + this.chofer.getNombre() + ". ";
        }

        if this.estadoViaje.equals(EstadoViaje.SIN_ASIGNAR) {
            msg += "Viaje sin asignar. ";
        } else if this.estadoViaje.equals(EstadoViaje.PENDIENTE_ACEPTAR_CHOFER) {
            msg += "Viaje pendiente de aceptar por chofer. ";
        } else if this.estadoViaje.equals(EstadoViaje.ACEPTADO) {
            msg += "Viaje aceptado. ";
        } else if this.estadoViaje.equals(EstadoViaje.EN_CURSO) {
            msg += "Viaje en curso. ";
        } else if this.estadoViaje.equals(EstadoViaje.FINALIZADO) {
            msg += "Viaje finalizado. ";
        } else if this.estadoViaje.equals(EstadoViaje.CANCELADO_PASAJERO) {
            msg += "Viaje cancelado por pasajero. ";
        } else if this.estadoViaje.equals(EstadoViaje.CANCELADO_CHOFER) {
            msg += "Viaje cancelado por chofer. ";
        } else if this.estadoViaje.equals(EstadoViaje.CANCELADO_SISTEMA) {
            msg += "Viaje cancelado por el sistema. ";
        }

        this.mensajeEstado = msg;
    }
}
