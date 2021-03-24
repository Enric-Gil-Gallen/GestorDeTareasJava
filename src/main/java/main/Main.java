package main;

import datos.Persona;
import datos.Proyecto;
import datos.Tarea;
import datos.Resultado;
import datos.enums.menu;

import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {
    static Proyecto proyecto = new Proyecto("ejem");

    public static void main(String[] args) {
        Scanner scaner = null;
        int opcion;
        System.out.println("Bienvedo al gestor que tareas");
        System.out.println("Eliga una opción introduciendo el numero \n");

        //Menu infinito hasta que se pulse la tecla 7
        boolean salir = true;
        while (salir){
            opcion = numero_correcto(scaner);
            switch (opcion+1) {

                case 1:
                    System.out.println("¿ Cual va a ser el nombre del proyecto ?" );
                    scaner = new Scanner(System.in);
                    String nombre_proyecto = scaner.nextLine();
                    proyecto = new Proyecto(nombre_proyecto);
                    break;

                case 2:
                    proyecto.añadirPersonas(scaner);
                    break;

                case 3:
//                    tarea.añadirTareas(proyecto);
                    break;

                case 4:
                    // Declaraciones
                    break;

                case 5:
                    // Declaraciones
                    break;

                case 6:
                    // Declaraciones
                    break;

                case 7:
                    scaner.close();
                    salir = false;
                    break;
            }
            System.out.println("----------------------------------------------------------------------------------------------------------------------------\n");
        }

        System.out.println("Gracias por su uso");

    }

    public static int leer(Scanner in){
        while (true){
            try {
                return in.nextInt();
            }catch (InputMismatchException e){
                in.nextLine(); // Es necesario porque sino a el programa no le da tiempo a leer es "nextDouble"
                System.out.println("El numero no es correcto prueba, otra vez por favor:\n");
            }
        }
    }

    public static int numero_correcto(Scanner scaner){
        // Llamadas en Enum --> menu
        System.out.println(menu.getMenu());
        scaner = new Scanner(System.in);
        int opcion = 0;

        // Comprobar que el numero sea el indicado
        boolean numero_correcto = true;

        while (numero_correcto){
            opcion = leer(scaner); // Comprobamos que sea un numero lo que nos pasan

            if (opcion >= 1 && opcion <= menu.values().length){
                menu opcionMenu = menu.getOpcion(opcion-1);

                // Necesario para poder usar el swicht
                opcion  = opcionMenu.ordinal();

                numero_correcto = false;

            }
            else {
                System.out.println("La opción: " + opcion + " no existe, prueve otra vez. \n" +
                        "Recuerde numero debe estar entre 1 y " + menu.values().length + ":\n");
            }
        }
        return opcion;
    }
}
