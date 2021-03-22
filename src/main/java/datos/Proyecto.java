package datos;

import java.util.LinkedList;

public class Proyecto {
    String titulo;
    String descripcion;
    LinkedList<Persona> Personas;
    Persona responsable_Tarea;
    int prioridad;
    String fecha_Creacion;
    String fecha_Finalizacion;
    Boolean tarea_Finalizada;
    Resultado resultado_Esperado;
    LinkedList etiquetas;

    public Proyecto(String titulo, String descripcion, LinkedList<Persona> personas, Persona responsable_Tarea, int prioridad, String fecha_Creacion, String fecha_Finalizacion, Boolean tarea_Finalizada, Resultado resultado_Esperado, LinkedList etiquetas) {
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

}
