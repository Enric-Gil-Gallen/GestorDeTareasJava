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
        this.personas = new LinkedList<>();
        this.tareas = new LinkedList<>();;
        this.resultados = new LinkedList<>();;
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
            System.out.println(" ¿Que quieres hacer introducir  \n " +
                    "1 - Introducir persona" +
                    "2 - Finalizar" );
            if (scaner.equals(1)){

                // Hay que comprobar que el nombre no este repetido
                boolean nombre_no_repe = true;
                System.out.println("Email: " );
                String email = scaner.nextLine();  // FALLO CON EL SCANNER
                while (nombre_no_repe){
                    nombre_no_repe = false;
                    for (int i = 0; i < personas.size(); i++){
                        if (personas.get(i).getEmail().equals(email)){
                            nombre_no_repe = true;
                        }
                    }
                    if (nombre_no_repe == false){
                        System.out.println("Este email ya esta registrado, porfavor pruebe otro.");
                    }
                }

                System.out.println("Nombre: " );
                String nombre = scaner.nextLine();  // FALLO CON EL SCANNER

                Persona persona = new Persona(nombre,email);
                personas.add(persona);
            }
            else {
                activo = false;
            }
            scaner.close();
        }
    }
}
