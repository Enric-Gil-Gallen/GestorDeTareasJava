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

    //Método que devuelve las personas implicadas en el proyecto
    public String personasDelProyecto(Proyecto proyecto){
        LinkedList<Persona> personasLista = proyecto.getPersonas();
        String personas = "";
        int size = personasLista.size();

        for (int i = 0; i < size; i++){
            if (i < (size-1)){
                personas += personasLista.get(i) + ", ";
            } else if (i ==(size-1)) {
                personas += personasLista.get(i);
            }
        }
        return personas;
    }

    //Método para listar las tareas de un proyecto dado
    public String tareasDelProyecto (Proyecto proyecto){
        String tareasDelProyecto = "";
        int cantidadTareas = proyecto.getTareas().size();

        for (int i = 0; i < cantidadTareas; i++){
            String tituloTarea = proyecto.getTareas().get(i).getTitulo();
            String personasAsignadas = "";
            int personasCantidad = proyecto.getTareas().get(i).getPersonas().size();
            for (int j = 0; j < personasCantidad; j++){
                if (i < (personasCantidad-1)){
                    personasAsignadas += proyecto.getTareas().get(i).getPersonas().get(j) + ", ";
                } else if (i ==(personasCantidad-1)) {
                    personasAsignadas += proyecto.getTareas().get(i).getPersonas().get(j);
                }
            }
            String finalizada = "";
            String resultadoTarea = "";
            if(getTareas().get(i).getTarea_Finalizada() == true){
                finalizada = "Tarea finalizada";
                resultadoTarea += getTareas().get(i).getResultado_Esperado().toString();
            } else {
                finalizada = "Tarea no finalizada";
                resultadoTarea = "No hay resultado disponible: Tarea no finalizada";
            }
            tareasDelProyecto += String.format("Tarea %d: %s, personas: %s, estado: %s, resultado: %s\n",
                    tituloTarea, personasAsignadas, finalizada, resultadoTarea);
        }
        return tareasDelProyecto;
    }
}


