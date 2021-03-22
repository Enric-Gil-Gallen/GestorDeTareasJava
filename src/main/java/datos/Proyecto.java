package datos;

import datos.Persona;
import datos.Resultado;
import datos.Tarea;

import java.util.LinkedList;
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

    public void añadirPersonas(){
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

                        if (personas.size() != 0){
                            for (int i = 0; i < personas.size(); i++){
                                System.out.println(personas.get(i).getEmail() + "   ssssssssssssss");
                                if (personas.get(i).getEmail().equals(email) && personas.get(i).getEmail() != "" ){
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
                    personas.add(persona);
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
