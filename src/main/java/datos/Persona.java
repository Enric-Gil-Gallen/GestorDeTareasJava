package datos;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Persona {
    String nombre;
    String email;
    LinkedList<String> tareas_lista;

    public Persona(String nombre, String email, LinkedList<String> tareas_lista) {
        this.nombre = nombre;
        this.email = email; // No puede estar repetido, es el ID
        this.tareas_lista = tareas_lista;
    }

    public Persona(String nombre, String email) {
        this.nombre = nombre;
        this.email = email;
        this.tareas_lista = new LinkedList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    public LinkedList<String> getTareas_lista() {
        return tareas_lista;
    }

    public void añadirPersonas(Proyecto proyecto){
        boolean activo = true;
        while (activo){
            Scanner scaner = new Scanner(System.in);
            System.out.println(" ¿Que quieres hacer ?\n" +
                    "\t1 - Introducir persona \n" +
                    "\tCualquier otra tecla - Finalizar" );
            String num = scaner.nextLine();
            try{
                if (Integer.parseInt(num) == 1){
                    // Hay que comprobar que el nombre no este repetido
                    boolean nombre_no_repe = true;
                    String email = "";

                    while (nombre_no_repe){
                        System.out.println("Email: " );
                        email = scaner.nextLine();
                        nombre_no_repe = false;

                        if (proyecto.getPersonas().size() != 0){
                            for (int i = 0; i < proyecto.getPersonas().size(); i++){
                                if (proyecto.getPersonas().get(i).getEmail().equals(email) && proyecto.getPersonas().get(i).getEmail() != "" ){
                                    nombre_no_repe = true;
                                }
                            }

                            if (nombre_no_repe){
                                System.out.println("Este email ya esta registrado, porfavor pruebe otro.\n\n");
                            }

                        }
                        else {
                            nombre_no_repe = false;
                        }
                    }

                    System.out.println("Nombre: " );
                    String nombre = scaner.nextLine();

                    Persona persona = new Persona(nombre,email);
                    proyecto.getPersonas().add(persona);
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
