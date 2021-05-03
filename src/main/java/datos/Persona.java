package datos;

import datos.metodosGenericos.tieneClave;
import datos.metodosGenericos.tieneLista;

import java.io.Serializable;
import java.util.LinkedList;

public class Persona implements Serializable, tieneClave, tieneLista {
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

    public void cargarTarea(Tarea tarea){
        if(!tareas_lista.contains(tarea)){
            tareas_lista.add(tarea);
        }
    }

    @Override
    public String getClave() {
        return email;
    }

    @Override
    public LinkedList getLista() {
        return tareas_lista;
    }
}
