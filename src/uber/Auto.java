package uber;

public class Auto {
    private final String MARCA;
    private final String MODELO;
    private final String PATENTE;
    private String color;
    
    public Auto(String marca, String modelo, String patente, String color) {
        this.MARCA = marca;
        this.MODELO = modelo;
        this.PATENTE = patente;
        this.color = color;
    }
    
    public String getMarca() {
        return MARCA;
    }

    public String getModelo() {
        return MODELO;
    }

    public String getPatente() {
        return PATENTE;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
