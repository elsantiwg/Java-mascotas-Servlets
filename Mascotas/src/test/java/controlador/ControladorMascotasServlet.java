package controlador;

import controlador.Canino;
import controlador.ControlMascotas;
import controlador.Felino;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ControladorMascotasServlet extends HttpServlet {
    private ControlMascotas controlMascotas;

    public void init() {
        controlMascotas = new ControlMascotas();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        if (accion != null) {
            if (accion.equals("agregarMascota")) {
                String tipo = request.getParameter("tipo");
                String nombre = request.getParameter("nombre");
                String raza = request.getParameter("raza");
                String color = request.getParameter("color");
                int edad = Integer.parseInt(request.getParameter("edad"));
                if (tipo.equals("canino")) {
                    int nivelEntrenamiento = Integer.parseInt(request.getParameter("nivelEntrenamiento"));
                    Canino canino = new Canino(nombre, raza, color, edad, nivelEntrenamiento);
                    controlMascotas.agregarMascota(canino);
                } else if (tipo.equals("felino")) {
                    boolean libreToxoplasmosis = Boolean.parseBoolean(request.getParameter("libreToxoplasmosis"));
                    Felino felino = new Felino(nombre, raza, color, edad, libreToxoplasmosis);
                    controlMascotas.agregarMascota(felino);
                }
            } else if (accion.equals("consultarMascotasDisponibles")) {
                request.setAttribute("mascotas", controlMascotas.consultarMascotasDisponibles());
                request.getRequestDispatcher("/mascotasDisponibles.jsp").forward(request, response);
            } else if (accion.equals("retirarMascota")) {
                int indice = Integer.parseInt(request.getParameter("indice"));
                controlMascotas.retirarMascota(indice);
            }
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}