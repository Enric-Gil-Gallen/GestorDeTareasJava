package main;

import datos.*;
import datos.enums.menu;
import datos.resultados.Biblioteca;

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
        int opcion, opcino_prioridad;
        boolean activo = true;
        System.out.println("Bienvedo al gestor que tareas");
        System.out.println("Eliga una opción introduciendo el numero \n");

        //Menu infinito hasta que se pulse la tecla 7
        boolean salir = true;
        while (salir) {
            opcion = numero_correcto(scaner, menu.getMenu());
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
                    boolean hayPersonas = false;
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
                                                    hayPersonas = true;
                                                    personas_tarea.add(proyecto.getPersonas().get(i));
                                                    break;
                                                }
                                            }
                                            bucle_activo = false;
                                            System.out.println("Esa persona no esta registrada \n" +
                                                    "Pruebe otra vez\n");
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

                                // DESCRIPCION
                                String descripcion = pedirDato("Descricion",scaner);

                                // RESPONSABLE DE LA TAREA
                                Persona persona_responsable = null;
                                if (hayPersonas) {
                                    persona_responsable = new Persona(null, null, null);
                                    bucle_activo = true;
                                    while (bucle_activo) {
                                        System.out.println("Dime el nombre de la persona responsable: ");
                                        String nombre = scaner.nextLine();

                                        if (personas_tarea.size() != 0) {
                                            for (int i = 0; i < personas_tarea.size(); i++) {
                                                if (nombre.equals(personas_tarea.get(i).getNombre())) {
                                                    System.out.println("El usuario es valido");
                                                    bucle_activo = false;
                                                    persona_responsable = personas_tarea.get(i);
                                                    break;
                                                }
                                            }

                                            System.out.println("Esa persona no esta registrada en las persona incritas en la tarea \n" +
                                                    "Pruebe otra vez");
                                        } else {
                                            System.out.println("No hay ninguna persona registrada en el Proyecto");
                                            bucle_activo = false;
                                        }
                                    }
                                }
                                else {
                                    System.out.println("Si la tarea no tiene gente asignada no puede tener ningun responsable ");
                                }

                                // PRIORIDAD
                                int prioridad = pedirNumero(1,5,scaner,"Indica la prioridad del 1 al 5, siendo 5 la mas alta\nPrioridad:\n");

                                // FECHA CREACION
                                System.out.println("Introducir la fecha de creacion: " );
                                Fecha fechaCreacion = pedirFecha(scaner);

                                // FECHA FINALIZACION
                                Fecha fechaFinalizacion = null;
                                if (pedirNumero(1,2,scaner, "¿ Quires añadir fecha de finlización ?\n\t1 - Si\n\t2 - No") == 1){
                                    bucle_activo = true;
                                    while (bucle_activo){
                                        fechaFinalizacion = pedirFecha(scaner);
                                        if (fechaCreacion.comparadorFechas(fechaCreacion, fechaFinalizacion)){
                                            bucle_activo = false;
                                        }
                                        else {
                                            System.out.println("La fecha de finalizacion no puede ser mas antigua que la fecha de antigua");
                                        }
                                    }
                                }

                                // TAREA FINALIZADA
                                boolean tareaFinalizada = true;
                                int tareaFin = pedirNumero(1,2,scaner,"Indica si la tarea esta finalizada \n\t1 - Si\n\t2 - No");
                                if (tareaFin == 2){
                                    tareaFinalizada = false;
                                }

                                // RESULTADO ESPERADO
                                Resultado resultado;
                                switch (pedirNumero(1,4,scaner,"¿ Que tipo de resultado se espera ? \n\t1 - Biblioteca\n\t2 - Documento\n\t3 - Paguina Web\n\t4 - Programa")){
                                    case (1):

//                                        resultado = new Biblioteca()
                                        break;
                                    case (2):

                                        break;
                                    case (3):

                                        break;
                                    case (4):

                                        break;
                                    default:

                                        break;
                                }

                                // ETIQUETAS

                                // AÑADIR LAS TAREAS
//                    Tarea tarea = new Tarea(titulo, descripcion,personas_tarea,persona_responsable, prioridad, fechaCreacion, fechaFinalizacion, tareaFinalizada, );
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

    public static int numero_correcto(Scanner scaner, String palabra) {
        // Llamadas en Enum --> menu
        System.out.println(palabra);
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

    public static boolean rangoCorrecto(int minimo, int maximo, int num){
        return minimo <= num && maximo >= num;
    }

    public static int pedirNumero(int minimo, int maximo, Scanner scaner, String mensaje){
        boolean bucle_activo = true;
        while (bucle_activo){
            int opcino_prioridad = numero_correcto(scaner, mensaje);
            if (rangoCorrecto(minimo, maximo, opcino_prioridad)){
                bucle_activo = false;
                return opcino_prioridad;
            }
        }
        return 0;
    }

    public static Fecha pedirFecha(Scanner scaner){
        int dia = pedirNumero(1,30, scaner, "Dia: (Del 1 al 30)");
        int mes = pedirNumero(1,12, scaner, "Dia: (Del 1 al 12)");
        int año = pedirNumero(2021,2100, scaner, "Dia: (Del 2021 al 2100)");
        return  new Fecha(dia,mes,año);
    }
}

