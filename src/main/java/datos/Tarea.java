package datos;

import java.util.LinkedList;
import java.util.Scanner;

public class Tarea {
    String titulo; // Tiene que ser unico, es el ID
    String descripcion;
    LinkedList<Persona> Personas;
    Persona responsable_Tarea;
    int prioridad;
    String fecha_Creacion;
    String fecha_Finalizacion;
    Boolean tarea_Finalizada;
    Resultado resultado_Esperado;
    LinkedList etiquetas;

    public Tarea(String titulo, String descripcion, LinkedList<Persona> personas, Persona responsable_Tarea, int prioridad, String fecha_Creacion, String fecha_Finalizacion, Boolean tarea_Finalizada, Resultado resultado_Esperado, LinkedList etiquetas) {
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

    public String getFecha_Creacion() {
        return fecha_Creacion;
    }

    public String getFecha_Finalizacion() {
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

    public void añadirTareas(Proyecto proyecto){
        boolean activo = true;
        while (activo){
            Scanner scaner = new Scanner(System.in);
            System.out.println(" ¿Que quieres hacer ?\n" +
                    "\t1 - Introducir tarea \n" +
                    "\tCualquier otra tecla - Finalizar" );
            String num = scaner.nextLine();
            try{
                if (Integer.parseInt(num) == 1){
                    // Hay que comprobar que el nombre no este repetido
                    boolean bucle_activo = true;
                    String titulo = "";

                    while (bucle_activo){
                        System.out.println("Titulo: " );
                        titulo = scaner.nextLine();
                        bucle_activo = false;

                        if (proyecto.getTareas().size() != 0){
                            for (int i = 0; i < proyecto.getTareas().size(); i++){
                                if (proyecto.getTareas().get(i).getTitulo().equals(titulo) && proyecto.getTareas().get(i).getTitulo() != "" ){
                                    bucle_activo = true;
                                }
                            }

                            if (bucle_activo){
                                System.out.println("Este titulo ya esta registrado, porfavor pruebe otro.\n\n");
                            }

                        }
                        else {
                            bucle_activo = false;
                        }
                    }

                    // DESCRICION
                    System.out.println("Descripción: " );
                    String descricion = scaner.nextLine();

                    // PERSONAS
                    LinkedList<Persona> personas_tarea = new LinkedList<>();
                    bucle_activo = true;
                    while (bucle_activo){
                        System.out.println("Dime el nombre de algun integrante: " );
                        System.out.println("\t Escriba 1 para salir: " );
                        String nombre = scaner.nextLine();

                        if (!nombre.equals("1")){
                            if (proyecto.getPersonas().size() != 0){
                                for (int i = 0; i < proyecto.getPersonas().size(); i++){
                                    if (nombre.equals(proyecto.getPersonas().get(i).getNombre())){
                                        System.out.println("El usuario es valido");
                                        bucle_activo = false;
                                        personas_tarea.add(proyecto.getPersonas().get(i));
                                        break;
                                    }
                                }

                                System.out.println("Esa persona no esta registrada \n" +
                                        "Pruebe otra vez");
                            }
                            else {
                                System.out.println("No hay ninguna persona registrada en el Proyecto");
                                bucle_activo = false;
                            }
                        }
                        else {
                            bucle_activo = false;
                        }

                    }


                    // RESPONSABLE DE LA TAREA
                    Persona persona_responsable = new Persona(null,null,null);
                    bucle_activo = true;
                    while (bucle_activo){
                        System.out.println("Dime el nombre de la persona responsable: " );
                        String nombre = scaner.nextLine();

                        if (personas_tarea.size() != 0){
                            for (int i = 0; i < personas_tarea.size(); i++){
                                if (nombre.equals(personas_tarea.get(i).getNombre())){
                                    System.out.println("El usuario es valido");
                                    bucle_activo = false;
                                    persona_responsable = personas_tarea.get(i);
                                    break;
                                }
                            }

                            System.out.println("Esa persona no esta registrada en las persona incritas en la tarea \n" +
                                    "Pruebe otra vez");
                        }
                        else {
                            System.out.println("No hay ninguna persona registrada en el Proyecto");
                            bucle_activo = false;
                        }

                    }

                    // PRIORIDAD
                    System.out.println("Nombre: " );
                    String nombre = scaner.nextLine();

                    // FECHA CREACION
                    System.out.println("Nombre: " );
//                    String nombre = scaner.nextLine();
//
//                    // FECHA FINALIZACION
//                    System.out.println("Nombre: " );
//                    String nombre = scaner.nextLine();
//
//                    // TAREA FINALIZADA
//                    System.out.println("Nombre: " );
//                    String nombre = scaner.nextLine();
//
//                    // RESULTADO ESPERADO
//                    System.out.println("Nombre: " );
//                    String nombre = scaner.nextLine();
//
//                    // ETIQUETAS
//
//                    // AÑADIR LAS TAREAS
//                    Tarea tarea = new Tarea(titulo,descripcion,personas_tarea,persona_responsable, );
//                    proyecto.getTareas().add(tarea);


                }
                else {
                    activo = false;
                    scaner.close();
                    break;
                }
            }
            catch (NumberFormatException e){
                activo = false;
                scaner.close();
                break;
            }
        }
    }
}
