package datos;

import java.util.LinkedList;
import java.util.List;

public class Persona {
    String nombre;
    String email;
    LinkedList<String> tareas_lista;

    public Persona(String nombre, String email, LinkedList<String> tareas_lista) {
        this.nombre = nombre;
        this.email = email;
        this.tareas_lista = tareas_lista;
    }
}
