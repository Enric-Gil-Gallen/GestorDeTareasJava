package datos;

import datos.Persona;
import datos.Resultado;
import datos.Tarea;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Proyecto implements Serializable{
    // Para guardar la informacion de momento usaremos LinkedList de la 3 clases principales
    private LinkedList<Persona> personas = new LinkedList();
    private LinkedList<Tarea> tareas = new LinkedList();
    private LinkedList<Resultado> resultados = new LinkedList();
    private String nombre;

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

    public void añadirResultado(Resultado resultado){
        resultados.add(resultado);
    }
    public Tarea buscarTareaPorTitulo(String titulo){
        for (Tarea tarea: tareas){
            if (tarea.getTitulo().equals(titulo)){
                return tarea;
            }
        }
        return null;
    }

    public LinkedList<Resultado> getResultados() {
        return resultados;
    }

    public String getNombre() {
        return nombre;
    }

    //Método que devuelve las personas implicadas en el proyecto
    public String personasDelProyecto(){
        StringBuilder sb = new StringBuilder();
        if (personas.isEmpty()){
            sb.append("No hay ninguna persona registrada el en proyecto");
        }
        else {
            sb.append("Los integrantes del proyecto son:\n");
            for (Persona persona: personas){
                sb.append("\t -Nombre: "+persona.getNombre()+"\n");
                sb.append("\t -Email: "+persona.getEmail() + "\n \n");
            }
        }
        return sb.toString();
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

    //Método para personas que no tienen ninguna tarea asignada
    public String personasSinTareas(){
        if (personas.isEmpty()){
            return "No hay personas en el proyecto actual";
        } else {
            String personasSinTareasAsignadas = "";
            for (Persona persona : personas){
                if (persona.getPersonaSinTareas() == true){
                    personasSinTareasAsignadas += " " + persona.getNombre() + ",";
                }
            }
            return personasSinTareasAsignadas;
        }
    }

    //Método para tareas que no tienen ninguna persona asignada
    public String tareasSinAsignar(){
        if (tareas.isEmpty()){
            return "No hay tareas en el proyecto actual";
        } else {
            String tareasNoAsignadas = "";
            for (Tarea tarea : tareas){
                if (tarea.getTareaSinPersonas() == true){
                    tareasNoAsignadas += " " + tarea.getTitulo() + ",";
                }
            }
            return tareasNoAsignadas;
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

    public void setPersonas(LinkedList<Persona> personas) {
        this.personas = personas;
    }

    public void setTareas(LinkedList<Tarea> tareas) {
        this.tareas = tareas;
    }

    public void setResultados(LinkedList<Resultado> resultados) {
        this.resultados = resultados;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}


