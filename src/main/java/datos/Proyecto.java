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
        System.out.println("El titulo no pertenece a ninguna tarea");
        return null;
    }

    //Método que devuelve las personas implicadas en el proyecto
    public void personasDelProyecto(){
        if (personas.isEmpty()){
            System.out.println("No hay ninguna persona registrada el en proyecto");
        }
        else {
            System.out.println("Los integrantes del proyecto son:");
            for (int i = 0; i < personas.size(); i++){
                System.out.println("\t - "+personas.get(i).getNombre());
                System.out.println("\t \t - "+personas.get(i).getEmail());
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
            for (int i = 0; i < tareas.size(); i++){
                sb.append("Titulo: " +tareas.get(i).getTitulo());
                sb.append("\n");
                sb.append(tareas.get(i).getPersonasYResponsable());
                sb.append("\n");
                if (tareas.get(i).getTarea_Finalizada()){
                    sb.append("La tarea esta finalizada \n");
                }
                else {
                    sb.append("La tarea no esta finalizada \n");
                }
                sb.append(tareas.get(i).getResultado_Esperado().getResultadoyInformacion());
                sb.append("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<\n");
            }
            return sb.toString();
        }
    }
}


