package main;

import datos.Persona;
import datos.Proyecto;
import datos.Resultado;
import datos.enums.menu;

import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    // Para guardar la informacion de momento usaremos LinkedList de la 3 clases principales
    static LinkedList<Persona> personas = new LinkedList();
    static LinkedList<Proyecto> proyectos = new LinkedList();
    static LinkedList<Resultado> resultados = new LinkedList();

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
                Proyecto proyecto = new Proyecto(nombre_proyecto,null,null,null,0,null,null,null,null,null);
                proyectos.add(proyecto);
                break;

            case 2: // FALLO CON EL SCANNER
                System.out.println("¿ Cual es el nombre del proyecto ? \n " );
                String nombre = scaner.nextLine();  // FALLO CON EL SCANNER
                Proyecto actual = buscar_por_titulo(nombre);
                if (actual != null){
                    personas.addAll(actual.getPersonas());
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

    // Busacar proyecto por nombre
    public static Proyecto buscar_por_titulo(String titulo){
        if (!proyectos.isEmpty()){
            for (int i = 0; i < proyectos.size(); i++){
                if (proyectos.get(i).getTitulo().equals(titulo)){
                    return proyectos.get(i);
                }
            }
        }
        return null;
    }
}
