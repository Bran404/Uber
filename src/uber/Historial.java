package uber;

public class Historial {
    private ArrayList<Viaje> viajes;

    public Historial() {
        this.viajes = new ArrayList<Viaje>();
    }

    public ArrayList<Viaje> getViajes() {
        return viajes;
    }

    public void Viaje getViaje(int index) {
        this.viajes.get(index);
    }

    public void addViaje(Viaje viaje) {
        this.viajes.add(viaje);
    }
}
