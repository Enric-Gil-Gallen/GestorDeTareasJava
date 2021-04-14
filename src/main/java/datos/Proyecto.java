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

    // Metodos usados por el menu "principalmente"
    public void añadirPersonas(Persona persona){
            personas.add(persona);
    }

    public void añadirTarea(Tarea tarea){
        tareas.add(tarea);
    }

    public Tarea buscarTareaPorTitulo(String titulo){
        for (Tarea tarea: tareas){
            if (tarea.getTitulo().equals(titulo)){
                return tarea;
            }
        }
        return null;
    }

    //Método que devuelve las personas implicadas en el proyecto
    public void personasDelProyecto(){
        if (personas.isEmpty()){
            System.out.println("No hay ninguna persona registrada el en proyecto");
        }
        else {
            System.out.println("Los integrantes del proyecto son:");
            for (Persona persona: personas){
                System.out.println("\t - "+persona.getNombre());
                System.out.println("\t \t - "+persona.getEmail());
            }
        }
    }

    //Método para listar las tareas de un proyecto dado
    public String tareasDelProyecto (){
        if (tareas.isEmpty()){
            return  "No hay ninguna tarea registrada el en proyecto";
        }
        else {
            StringBuilder sb = new StringBuilder();
            sb.append("\n");
            for (Tarea tarea: tareas){
                sb.append("Titulo: " +tarea.getTitulo());
                sb.append("\n");
                sb.append(tarea.getPersonasYResponsable());
                sb.append("\n");
                if (tarea.getTarea_Finalizada()){
                    sb.append("La tarea esta finalizada \n");
                }
                else {
                    sb.append("La tarea no esta finalizada \n");
                }
                sb.append(tarea.getResultado_Esperado().getResultadoyInformacion());
                sb.append("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<\n");
            }
            return sb.toString();
        }
    }

    public void eliminarPersona(Persona persona){
        personas.remove(persona);
    }

    public Persona buscarPersonaEmail(String email){
        Persona resul = null;
        for (Persona persona : personas){
            if (persona.getEmail().equals(email)){
                return persona;
            }
        }
        return resul;
    }
}


