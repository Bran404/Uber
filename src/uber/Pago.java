package uber;

public class Pago {
    private MetodoDePago metodoDePago;
    private EstadoPago estadoPago;
    private float monto;

    public Pago(MetodoDePago metodoDePago, float monto) {
        this.metodoDePago = metodoDePago;
        this.estadoPago = EstadoPago.PENDIENTE;
        this.monto = monto;
    }

    public MetodoDePago getMetodoDePago() {
        return metodoDePago;
    }

    public void setMetodoDePago(MetodoDePago metodoDePago) {
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
