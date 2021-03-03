package datos;

import java.util.List;

public class Persona {
    String nombre;
    String email;
    List lista;

    public Persona(String nombre, String email, List lista) {
        this.nombre = nombre;
        this.email = email;
        this.lista = lista;
    }
}
