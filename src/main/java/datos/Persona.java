package datos;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Persona {
    private String nombre;
    private String email;
    private LinkedList<Tarea> tareas_lista;

    public Persona(String nombre, String email, LinkedList<Tarea> tareas_lista) {
        this.nombre = nombre;
        this.email = email; // No puede estar repetido, es el ID
        this.tareas_lista = tareas_lista;
    }

    public Persona(String nombre, String email) {
        this.nombre = nombre;
        this.email = email;
        this.tareas_lista = new LinkedList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    public LinkedList<Tarea> getTareas_lista() {
        return tareas_lista;
    }

    public void cargarTarea(Tarea tarea){
        if(!tareas_lista.contains(tarea)){
            tareas_lista.add(tarea);
        }
    }

    public String ponerDatosEnLinea(){
        StringBuilder linea = new StringBuilder();
        linea.append(nombre);
        linea.append("#");
        linea.append(email);
        linea.append("#");
        StringBuilder nombreTareas = new StringBuilder();
        for (int i = 0; i < tareas_lista.size(); i++){
            nombreTareas.append(tareas_lista.get(i).getTitulo()).append("&");
        }
        linea.append(nombreTareas);
        return linea.toString();
    }

}
