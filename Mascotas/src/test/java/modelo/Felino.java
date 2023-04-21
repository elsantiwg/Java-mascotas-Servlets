package controlador;

public class Felino extends Mascota {
    private boolean libreToxoplasmosis;

    public Felino(String nombre, String raza, String color, int edad, boolean libreToxoplasmosis) {
        super(nombre, raza, color, edad);
        this.libreToxoplasmosis = libreToxoplasmosis;
    }
    
    public boolean isLibreToxoplasmosis() {
        return libreToxoplasmosis;
    }

    public void setLibreToxoplasmosis(boolean libreToxoplasmosis) {
        this.libreToxoplasmosis = libreToxoplasmosis;
    }
}