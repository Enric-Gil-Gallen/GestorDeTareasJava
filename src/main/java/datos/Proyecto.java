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
    public void añadirPersonas(Scanner scaner){
        boolean activo = true;
        while (activo){
            String num = pedirDato(" ¿Que quieres hacer ?\n" +
                    "\t1 - Introducir persona\n" +
                    "\tCualquier otra tecla - Finalizar", scaner);
            try{
                if (Integer.parseInt(num) == 1){
                    // Hay que comprobar que el nombre no este repetido
                    boolean nombre_no_repe = true;
                    String email = "";
                    while (nombre_no_repe){
                        email = pedirDato("Email", scaner);
                        nombre_no_repe = false;

                        if (personas.size() != 0){
                            for (int i = 0; i < personas.size(); i++){
                                if (personas.get(i).getEmail().equals(email) && personas.get(i).getEmail() != "" ){
                                    nombre_no_repe = true;
                                }
                            }

                            if (nombre_no_repe){
                                System.out.println("Este email ya esta registrado, porfavor pruebe otro.\n");
                            }

                        }
                        else {
                            nombre_no_repe = false;
                        }
                    }

                    Persona persona = new Persona(pedirDato("Nombre", scaner),email);
                    personas.add(persona);
                }
                else {
                    break;
                }
            }
            catch (NumberFormatException e){
                break;
            }
        }
    }

    public void añadirTareas(Proyecto proyecto, Scanner scaner){
        boolean activo = true;
        while (activo){
            String num = pedirDato(" ¿Que quieres hacer ?\n" +
                    "\t1 - Introducir tarea \n" +
                    "\tCualquier otra tecla - Finalizar" , scaner);
            try{
                if (Integer.parseInt(num) == 1){
                    // Hay que comprobar que el nombre no este repetido
                    boolean bucle_activo = true;
                    String titulo = "";

                    // TITULO
                    while (bucle_activo){
                        titulo = pedirDato("Titulo", scaner);
                        bucle_activo = false;

                        if (tareas.size() != 0){
                            for (int i = 0; i < tareas.size(); i++){
                                if (tareas.get(i).getTitulo().equals(titulo) && tareas.get(i).getTitulo() != "" ){
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

                    // PERSONAS
                    LinkedList<Persona> personas_tarea = new LinkedList<>();
                    bucle_activo = true;
                    while (bucle_activo){
                        String nombre = pedirDato("Dime el nombre de algun integrante: \n" +
                                "\t Escriba 1 para salir: ", scaner);

                        if (!nombre.equals("1")){
                            if (personas.size() != 0){
                                for (int i = 0; i < personas.size(); i++){
                                    if (nombre.equals(personas.get(i).getNombre())){
                                        System.out.println("El usuario es valido");
                                        bucle_activo = false;
                                        personas_tarea.add(personas.get(i));
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

//
//                    // FECHA CREACION
//                    System.out.println("Nombre: " );
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

                    // ETIQUETAS

                    // AÑADIR LAS TAREAS
//                    Tarea tarea = new Tarea(titulo,pedirDato("Descricion",scaner),personas_tarea,persona_responsable, null, null, null);
//                    proyecto.getTareas().add(tarea);
                }
                else {
                    break;
                }
            }
            catch (NumberFormatException e){
                break;
            }
        }
    }
}
