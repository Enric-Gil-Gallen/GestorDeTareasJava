package datos;

import datos.Persona;
import datos.Resultado;
import datos.Tarea;

import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Proyecto {
    // Para guardar la informacion de momento usaremos LinkedList de la 3 clases principales
    LinkedList<Persona> personas = new LinkedList();
    LinkedList<Tarea> tareas = new LinkedList();
    LinkedList<Resultado> resultados = new LinkedList();
    String nombre;

    public Proyecto(String nombre) {
        this.nombre = nombre;
    }

    public LinkedList<Persona> getPersonas() {
        return personas;
    }

    public LinkedList<Tarea> getTareas() {
        return tareas;
    }

    public LinkedList<Resultado> getResultados() {
        return resultados;
    }

// Metodo que pide por pantalla
public String pedirDato(String nombreDato, Scanner scaner){
    System.out.println(nombreDato+": " );
    String resul  = scaner.nextLine();
    return resul;
}

    // Metodos usados por el menu "principalmente"
    public void añadirPersonas(Persona persona){
            personas.add(persona);
    }

    public void añadirTarea(Tarea tarea){
        tareas.add(tarea);
    }

    public Tarea buscarTareaPorTitulo(String titulo){
        for (int i = 0; i < tareas.size(); i++){
            if (tareas.get(i).getTitulo().equals(titulo)){
                return tareas.get(i);
            }
        }
        System.out.println("La tarea no se encuentra disponible");
        return null;
    }
}
