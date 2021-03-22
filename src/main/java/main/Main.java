package main;

import datos.Persona;
import datos.Proyecto;
import datos.Tarea;
import datos.Resultado;
import datos.enums.menu;

import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {

    static Proyecto proyecto = new Proyecto("");

    public static void main(String[] args) {
        System.out.println("Bienvedo al gestor que tareas");
        System.out.println("Eliga una opción introduciendo el numero \n");

        // Llamadas en Enum --> menu
        System.out.println(menu.getMenu());
        Scanner scaner = new Scanner(System.in);
        int opcion = 0;

        // Comprobar que el numero sea el indicado
        boolean numero_correcto = true;

        while (numero_correcto){
            opcion = leer(scaner); // Comprobamos que sea un numero lo que nos pasan

            if (opcion >= 1 && opcion <= menu.values().length){
                menu opcionMenu = menu.getOpcion(opcion);

                // Necesario para poder usar el swicht
                opcion  = opcionMenu.ordinal();

                numero_correcto = false;

            }
            else {
                System.out.println("La opción: " + opcion + " no existe, prueve otra vez. \n" +
                        "Recuerde numero debe estar entre 1 y " + menu.values().length );
            }
        }



        switch (opcion) {

            case 1: // FALLO CON EL SCANNER
                System.out.println("¿ Cual va a ser el nombre del proyecto ? \n " );
                String nombre_proyecto = scaner.nextLine();  // FALLO CON EL SCANNER
                proyecto = new Proyecto(nombre_proyecto);
                break;

            case 2: // FALLO CON EL SCANNER
                boolean activo = true;
                while (activo){
                    System.out.println(" ¿Que quieres hacer introducir  \n " +
                            "1 - Introducir persona" +
                            "2 - Finalizar" );

                }
                System.out.println("  \n " );
                String nombre = scaner.nextLine();  // FALLO CON EL SCANNER
                Tarea actual = buscar_Proyecto_por_titulo(nombre);
                if (actual != null){
                    proyecto.getPersonas().addAll(actual.getPersonas());
                }
                else {
                    System.out.println("El titulo es incorrecto o la lista de proyectos esta vacia.");
                }
                break;

            case 3:
                // Declaraciones
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
                // Declaraciones
                break;

            case 8:
                // Declaraciones
                break;

            case 9:
                // Declaraciones
                break;

            case 10:
                // Declaraciones
                break;

            case 11:
                // Declaraciones
                break;
        }

        System.out.println("Gracias por su uso");

        // Cerar el Scaner
        scaner.close();
    }

    public static int leer(Scanner in){
        while (true){
            try {
                return in.nextInt();
            }catch (InputMismatchException e){
                in.nextLine(); // Es necesario porque sino a el programa no le da tiempo a leer es "nextDouble"
                System.out.println("El numero no es correcto prueba, otra vez por favor ");
            }
        }
    }

    //SE PUEDEN HACER GENERICOS LOS 2 METODOS DE BUSCAR ??????

    // Busacar tarea por titulo
    public static Tarea buscar_Proyecto_por_titulo(String titulo){
        if (!proyecto.getTareas().isEmpty()){
            for (int i = 0; i < proyecto.getTareas().size(); i++){
                if (proyecto.getTareas().get(i).getTitulo().equals(titulo)){
                    return proyecto.getTareas().get(i);
                }
            }
        }
        return null;
    }

    // Busacar persona por nombre
    public static Persona buscar_Persona_por_nobre(String nombre){
        if (!proyecto.getPersonas().isEmpty()){
            for (int i = 0; i < proyecto.getPersonas().size(); i++){
                if (proyecto.getPersonas().get(i).getNombre().equals(nombre)){
                    return proyecto.getPersonas().get(i);
                }
            }
        }
        return null;
    }
}
