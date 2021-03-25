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

    public boolean numeroEnRango(int num, int inicio,int limite_incluido){
        return (inicio <= num && num >= limite_incluido);
    }

    public int perdirNumero(String descricion, Scanner scanner){
        return Integer.parseInt(pedirDato(descricion, scanner));
    }

    // Metodos Meni
    public void añadirPersonas(Persona persona){
            personas.add(persona);
    }

    public void añadirTareas(Tarea tarea){
        tareas.add(tarea);
    }
}
