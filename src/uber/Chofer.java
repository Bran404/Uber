package uber;
import java.util.ArrayList;

public class Chofer {
    private final String ID_CHOFER;
    private ArrayList<Auto> autos;
    private String nombre;
    private boolean available;
    private ArrayList<ZonaDeTrabajo> zonasDeTrabajo;
    private Historial historial;
    private static String nextID = "0001";

    public Chofer(String nombre, Auto firstAuto, ZonaDeTrabajo firstZonaDeTrabajo) {
        this.ID_CHOFER = nextID;
        nextID = String.format("%04x", Integer.parseInt(nextID, 16) + 1);
        this.autos = new ArrayList<Auto>();
        this.autos.add(firstAuto);
        this.nombre = nombre;
        this.available = false;
        this.zonasDeTrabajo = new ArrayList<ZonaDeTrabajo>();
        this.zonasDeTrabajo.add(firstZonaDeTrabajo);
        this.historial = new Historial();
    }

    public String getId() {
        return ID_CHOFER;
    }

    public ArrayList<Auto> getAutos() {
        return autos;
    }

    public String getNombre() {
        return nombre;
    }

    public boolean isAvailable() {
        return available;
    }

    public ArrayList<ZonaDeTrabajo> getZonasDeTrabajo() {
        return zonasDeTrabajo;
    }

    public Historial getHistorial() {
        return historial;
    }

    public void addAuto(Auto auto) {
        autos.add(auto);
    }

    public void addZonaDeTrabajo(ZonaDeTrabajo zonaDeTrabajo) {
        zonasDeTrabajo.add(zonaDeTrabajo);
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}
