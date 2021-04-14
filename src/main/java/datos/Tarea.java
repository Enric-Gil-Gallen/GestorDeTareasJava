package datos;

import java.util.LinkedList;

public class Tarea {
    String titulo; // Tiene que ser unico, es el ID
    String descripcion;
    LinkedList<Persona> personas;
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
        this.personas = personas;
        this.responsable_Tarea = responsable_Tarea;
        this.prioridad = prioridad;
        this.fecha_Creacion = fecha_Creacion;
        this.fecha_Finalizacion = fecha_Finalizacion;
        this.tarea_Finalizada = tarea_Finalizada;
        this.resultado_Esperado = resultado_Esperado;
        this.etiquetas = etiquetas;
    }

    // Geters
    public String getTitulo() {
        return titulo;
    }

    public Boolean getTarea_Finalizada() {
        return tarea_Finalizada;
    }

    public LinkedList<Persona> getPersonas() {
        return personas;
    }

    public Resultado getResultado_Esperado() {
        return resultado_Esperado;
    }

    // Seters
    public void setTarea_Finalizada(Boolean tarea_Finalizada) {
        this.tarea_Finalizada = tarea_Finalizada;
    }

    // Otros metodos
    public void marcarTareaFinalizada(){
        if (!getTarea_Finalizada()){
            setTarea_Finalizada(true);
        }
    }

    public String getPersonasYResponsable(){
        if (personas.isEmpty()){
            return "La tarea no tiene ninguna persona registrada";
        }
        else {
            StringBuilder sb = new StringBuilder();
            sb.append("Personas en el proyecto:");
            if (responsable_Tarea != null && responsable_Tarea.getNombre().equals("")){
                sb.append("- No exite persona responsable");
            }
            sb.append("\n");
            for (Persona persona : personas){
                if (responsable_Tarea != null && responsable_Tarea.getNombre().equals(persona.getNombre())){
                    sb.append("\t - Persona Responsable: ");
                    sb.append(persona.getNombre());
                    sb.append("\n");
                }
                sb.append("\t - ");
                sb.append(persona.getNombre());
                sb.append("\n");
            }
            return sb.toString();
        }
    }

    public boolean personaExistePorEmail(String email){
        if (!personas.isEmpty()){
            for (Persona persona : personas){
                if (persona.getEmail().equals(email)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean añadirPersona(Persona persona){
        if (!personaExistePorEmail(persona.getEmail())){
            personas.add(persona);
            return true;
        }
        else {
            return false;
        }
    }

    public Persona cojerPersonaPorEmail(String email){
        for (Persona persona : personas){
            if (persona.getEmail().equals(email)){
                return persona;
            }
        }
        return null;
    }

    public boolean esLaPersonaResponsableEmail(String email){
        if (responsable_Tarea != null && cojerPersonaPorEmail(email).getEmail().equals(responsable_Tarea.getEmail())){
            return true;
        }
        return false;
    }

    public boolean eliminarPersona(String email){
        boolean personaResponsable = false;
        if (esLaPersonaResponsableEmail(email)){
            responsable_Tarea = null;
            personaResponsable = true;
        }
        personas.remove(cojerPersonaPorEmail(email));
        return personaResponsable;
    }
}

