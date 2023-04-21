package controlador;

import java.util.ArrayList;

public class ControlMascotas {
    public ArrayList<Mascota> mascotas;

    public ControlMascotas() {
        mascotas = new ArrayList<Mascota>();
    }

    public void agregarMascota(Mascota mascota) {
        mascotas.add(mascota);
    }

    public ArrayList<Mascota> consultarMascotasDisponibles() {
        return mascotas;
    }

    public void retirarMascota(int indice) {
        if (indice >= 0 && indice < mascotas.size()) {
            mascotas.remove(indice);
        }
    }

    public double calcularEdadPromedio() {
        double sumaEdades = 0;
        for (Mascota mascota : mascotas) {
            sumaEdades += mascota.getEdad();
        }
        return sumaEdades / mascotas.size();
    }

    public int contarFelinos() {
        int contadorFelinos = 0;
        for (Mascota mascota : mascotas) {
            if (mascota instanceof Felino) {
                contadorFelinos++;
            }
        }
        return contadorFelinos;
    }

    public int contarCaninos() {
        int contadorCaninos = 0;
        for (Mascota mascota : mascotas) {
            if (mascota instanceof Canino) {
                contadorCaninos++;
            }
        }
        return contadorCaninos;
    }
}