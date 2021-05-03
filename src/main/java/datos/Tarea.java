package datos;

import datos.metodosGenericos.tieneClave;
import datos.metodosGenericos.tieneLista;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedList;

public class Tarea implements Serializable, tieneClave, tieneLista{
    private String titulo; // Tiene que ser unico, es el ID
    private String descripcion;
    private LinkedList<Persona> personas;
    private Persona responsable_Tarea;
    private int prioridad; // Entre 1: muy baja, y 5: muy alta
    private Date fecha_Creacion;
    private Date fecha_Finalizacion;
    private Boolean tarea_Finalizada;
    private Resultado resultado_Esperado;
    private LinkedList<String> etiquetas;
    private double coste;
    private Facturacion facturacion;
    private double valor;

    public Tarea(String titulo, String descripcion, LinkedList<Persona> personas, Persona responsable_Tarea, int prioridad, Date fecha_Creacion, Date fecha_Finalizacion, Boolean tarea_Finalizada, Resultado resultado_Esperado, LinkedList<String> etiquetas, double coste, Facturacion facturacion, double valor) {
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
        this.coste = coste;
        this.facturacion = facturacion;
        this.valor = valor;
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

    public void setValor(double valor) {
        this.valor = valor;
    }

    public void setFacturacion(Facturacion facturacion) {
        this.facturacion = facturacion;
    }

    // Otros metodos
    public void marcarTareaFinalizada(){
        if (!getTarea_Finalizada()){
            setTarea_Finalizada(true);
        }
    }

    public String getPersonasYResponsable(){
        if ( personas == null||personas.isEmpty()){
            return "La tarea no tiene ninguna persona registrada";
        }
        else {
            StringBuilder sb = new StringBuilder();
            sb.append("Personas en la tarea:");
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

    public boolean getTareaSinPersonas(){
        if (personas.isEmpty()){
            return true;
        } else {
            return false;
        }
    }

    public Facturacion getFacturacion() {
        return facturacion;
    }

    public double cojerFacturacion(){
        return facturacion.calcularFacturacion(coste, valor);
    }

    @Override
    public String getClave() {
        return titulo;
    }

    @Override
    public LinkedList getLista() {
        return personas;
    }
}

