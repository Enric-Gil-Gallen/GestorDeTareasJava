package datos;

import java.util.LinkedList;
import java.util.List;

public class Persona {
    String nombre;
    String email;
    LinkedList lista;

    public Persona(String nombre, String email, LinkedList lista) {
        this.nombre = nombre;
        this.email = email;
        this.lista = lista;
    }
}
