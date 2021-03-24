package datos;

import java.util.LinkedList;
import java.util.Scanner;

public class Tarea {
    String titulo; // Tiene que ser unico, es el ID
    String descripcion;
    LinkedList<Persona> Personas;
    Persona responsable_Tarea;
    int prioridad; // Entre 1: muy baja, y 5: muy alta
    Fecha fecha_Creacion;
    Fecha fecha_Finalizacion;
    Boolean tarea_Finalizada;
    Resultado resultado_Esperado;
    LinkedList etiquetas;

    public Tarea(String titulo, String descripcion, LinkedList<Persona> personas, Persona responsable_Tarea, int prioridad, Fecha fecha_Creacion, Fecha fecha_Finalizacion, Boolean tarea_Finalizada, Resultado resultado_Esperado, LinkedList etiquetas) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        Personas = personas;
        this.responsable_Tarea = responsable_Tarea;
        this.prioridad = prioridad;
        this.fecha_Creacion = fecha_Creacion;
        this.fecha_Finalizacion = fecha_Finalizacion;
        this.tarea_Finalizada = tarea_Finalizada;
        this.resultado_Esperado = resultado_Esperado;
        this.etiquetas = etiquetas;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public LinkedList<Persona> getPersonas() {
        return Personas;
    }

    public Persona getResponsable_Tarea() {
        return responsable_Tarea;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public Fecha getFecha_Creacion() {
        return fecha_Creacion;
    }

    public Fecha getFecha_Finalizacion() {
        return fecha_Finalizacion;
    }

    public Boolean getTarea_Finalizada() {
        return tarea_Finalizada;
    }

    public Resultado getResultado_Esperado() {
        return resultado_Esperado;
    }

    public LinkedList getEtiquetas() {
        return etiquetas;
    }
}

