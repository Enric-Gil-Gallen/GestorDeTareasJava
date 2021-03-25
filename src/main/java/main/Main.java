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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    static Proyecto proyecto = new Proyecto("ejem");

    // Patrón para validar el email
    static Pattern pattern = Pattern
            .compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                    + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

    public static void main(String[] args) {
        Scanner scaner = new Scanner(System.in);
        int opcion;
        boolean activo = true;
        System.out.println("Bienvedo al gestor que tareas");
        System.out.println("Eliga una opción introduciendo el numero \n");

        //Menu infinito hasta que se pulse la tecla 7
        boolean salir = true;
        while (salir) {
            opcion = numero_correcto(scaner);
            switch (opcion) {
                case 1:
                    System.out.println("¿ Cual va a ser el nombre del proyecto ?");
                    scaner = new Scanner(System.in);
                    String nombre_proyecto = scaner.nextLine();
                    proyecto = new Proyecto(nombre_proyecto);
                    break;

                case 2:
                    activo = true;
                    while (activo) {
                        String num = pedirDato(" ¿Que quieres hacer ?\n" +
                                "\t1 - Introducir persona\n" +
                                "\tCualquier otra tecla - Finalizar", scaner);
                        try {
                            if (Integer.parseInt(num) == 1) {
                                // Hay que comprobar que el nombre no este repetido
                                boolean nombre_no_repe = true;
                                String email = "";
                                while (nombre_no_repe) {
                                    email = pedirDato("Email", scaner);
                                    nombre_no_repe = false;
                                    Matcher mather = pattern.matcher(email);

                                    if (mather.find()) {
                                        if (proyecto.getPersonas().size() != 0) {
                                            for (int i = 0; i < proyecto.getPersonas().size(); i++) {
                                                if (proyecto.getPersonas().get(i).getEmail().equals(email) && proyecto.getPersonas().get(i).getEmail() != "") {
                                                    nombre_no_repe = true;
                                                }
                                            }

                                            if (nombre_no_repe) {
                                                System.out.println("Este email ya esta registrado, porfavor pruebe otro.\n");
                                            }

                                        } else {
                                            nombre_no_repe = false;
                                        }
                                    } else {
                                        System.out.println("El formato del email no es valido, prueba otra vez: \n");
                                        nombre_no_repe = true;
                                    }

                                }

                                Persona persona = new Persona(pedirDato("Nombre", scaner), email);
                                proyecto.añadirPersonas(persona);
                            } else {
                                break;
                            }
                        } catch (NumberFormatException e) {
                            break;
                        }
                    }
                    break;

                case 3:
                    activo = true;
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

                                // PERSONAS
                                LinkedList<Persona> personas_tarea = new LinkedList<>();
                                bucle_activo = true;
                                while (bucle_activo){
                                    String nombre = pedirDato("Dime el nombre de algun integrante: \n" +
                                            "\t Escriba 1 para salir: ", scaner);

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
//                    proyecto.añadirTarea(tarea);
                            }
                            else {
                                break;
                            }
                        }
                        catch (NumberFormatException e){
                            break;
                        }
                    }
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

                default:
                    System.out.println("El numero no esta dentro del rango correcto prueba, otra vez por favor:\n");
                    break;
            }
            System.out.println("----------------------------------------------------------------------------------\n");
        }

        System.out.println("Gracias por su uso");

    }

    // METODOS PARA EL FUNCIONAMIENTO DEL MENU
    public static int leer(Scanner in) {
        while (true) {
            try {
                return in.nextInt();
            } catch (InputMismatchException e) {
                in.nextLine(); // Es necesario porque sino a el programa no le da tiempo a leer es "nextDouble"
                System.out.println("La entrada no es un numero, prueba otra vez por favor:\n");
            }
        }
    }

    public static int numero_correcto(Scanner scaner) {
        // Llamadas en Enum --> menu
        System.out.println(menu.getMenu());
        scaner = new Scanner(System.in);
        int opcion = 0;

        // Comprobar que el numero sea el indicado
        opcion = leer(scaner); // Comprobamos que sea un numero lo que nos pasan

        return opcion;
    }

    // Metodo que pide por pantalla
    public static String pedirDato(String nombreDato, Scanner scaner) {
        System.out.println(nombreDato + ": ");
        String resul = scaner.nextLine();
        return resul;
    }
}

