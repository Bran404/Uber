package uber;

public class Pago {
    private MetodoPago metodoDePago;
    private EstadoPago estadoPago;
    private float monto;

    public Pago(MetodoPago metodoDePago, float monto) {
        this.metodoDePago = metodoDePago;
        this.estadoPago = EstadoPago.PENDIENTE;
        this.monto = monto;
    }

    public MetodoPago getMetodoDePago() {
        return metodoDePago;
    }

    public void setMetodoDePago(MetodoPago metodoDePago) {
        this.metodoDePago = metodoDePago;
    }

    public EstadoPago getEstadoPago() {
        return estadoPago;
    }

    public void setEstadoPago(EstadoPago estadoPago) {
        this.estadoPago = estadoPago;
    }

    public float getMonto() {
        return monto;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }
}
