package main;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Bienvedo al gestor que tareas");
        System.out.println("Eliga una opción introduciendo el numero");
        Scanner in = new Scanner(System.in);
        int num  = 0;
        System.out.println(
                "1 -Iniciar un  nuevo proyecto y darle nombre\n" +
                        "2 -Dar de alta a las personas que trabajan en el proyecto\n" +
                        "3 -Dar de alta las tareas con sus datos\n" +
                        "4 -Marcar una tarea como finalizada\n" +
                        "5 -Introducir o eliminar una persona de una tarea\n" +
                        "6 -Listar las personas asignadas a un proyecto\n" +
                        "7 -Listar las tareas de un proyecto:"
        );
        System.out.println(
                "8 -Titulo de la Tarea\n" +
                        "9 -Las personas asignadas a la tarea\n" +
                        "10 -Tarea finalizada o no\n" +
                        "11 -Resultado de la tarea");

        boolean f = true;
        while (f){
            num = leer(in);
            if (num >= 1 && num <= 11){
                f =false;
            }
            else {
                System.out.println("El numero deve estar entre 1 y 11");
            }
        }
        in.close();

        switch (num) {

            case 1:
                System.out.println("Soy el 1 ---------------");
                break;

            case 2:
                // Declaraciones
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
}
