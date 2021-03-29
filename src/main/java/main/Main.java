package main;

import datos.*;
import datos.enums.Estado;
import datos.enums.Interno_Externo;
import datos.enums.Menu;
import datos.resultados.Biblioteca;
import datos.resultados.Documento;
import datos.resultados.Pagina_web;
import datos.resultados.Programa;

import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    // Patrón para validar el email
    static Pattern pattern = Pattern
            .compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                    + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

    public static void main(String[] args) {
        Scanner scaner = new Scanner(System.in);
        int opcion, opcino_prioridad;
        boolean activo = true;
        System.out.println("Bienvenido al gestor que tareas");
        System.out.println("¿ Cual va a ser el nombre del proyecto ?");
        Proyecto proyecto = new Proyecto(pedirDato("Nombre del proyecto", scaner));

        //Menu infinito hasta que se pulse la tecla 7
        boolean salir = true;
        while (salir) {
            opcion = pedirNumero(scaner, Menu.getMenu());
            switch (opcion) {
                case 1:
                    System.out.println("¿ Cual va a ser el nombre del nuevo proyecto ?");
                    proyecto = new Proyecto(pedirDato("Nombre del proyecto", scaner));
                    break;

                case 2:
                    activo = true;
                    while (activo) {
                        String num = pedirDato(" ¿Que quieres hacer ?\n" +
                                "\t1 - Introducir persona\n" +
                                "\tCualquier otra tecla - Finalizar", scaner);
                        try {
                            if (Integer.parseInt(num) == 1) {
                                proyecto.añadirPersonas(añadirPersona(scaner, proyecto));
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
                    boolean hayPersonas2 = false;
                    while (activo) {
                        String num = pedirDato(" ¿Que quieres hacer ?\n" +
                                "\t1 - Introducir tarea \n" +
                                "\tCualquier otra tecla - Finalizar", scaner);
                        try {
                            if (Integer.parseInt(num) == 1) {
                                // Hay que comprobar que el nombre no este repetido
                                boolean bucle_activo = true;
                                String titulo = "";

                                // TITULO
                                while (bucle_activo) {
                                    titulo = pedirDato("Titulo", scaner);
                                    bucle_activo = false;

                                    if (proyecto.getTareas().size() != 0) {
                                        for (int i = 0; i < proyecto.getTareas().size(); i++) {
                                            if (proyecto.getTareas().get(i).getTitulo().equals(titulo) && proyecto.getTareas().get(i).getTitulo() != "") {
                                                bucle_activo = true;
                                            }
                                        }

                                        if (bucle_activo) {
                                            System.out.println("Este titulo ya esta registrado, porfavor pruebe otro.\n\n");
                                        }

                                    } else {
                                        bucle_activo = false;
                                    }
                                }

                                // PERSONAS
                                LinkedList<Persona> personas_tarea = new LinkedList<>();
                                bucle_activo = true;
                                while (bucle_activo) {
                                    String nombre = pedirDato("Dime el nombre de algun integrante\n" +
                                            "\t Escriba 1 para salir: ", scaner);

                                    if (!nombre.equals("1")) {
                                        if (proyecto.getPersonas().size() != 0) {
                                            for (int i = 0; i < proyecto.getPersonas().size(); i++) {
                                                if (nombre.equals(proyecto.getPersonas().get(i).getNombre())) {
                                                    System.out.println("El usuario es valido\n");
                                                    hayPersonas = true;
                                                    hayPersonas2 = true;
                                                    personas_tarea.add(proyecto.getPersonas().get(i));
                                                    break;
                                                }
                                            }
                                            if (!hayPersonas2) {
                                                System.out.println("Esa persona no esta registrada \n" +
                                                        "Pruebe otra vez\n");
                                            }
                                            hayPersonas2 = false;
                                        } else {
                                            System.out.println("No hay ninguna persona registrada en el Proyecto");
                                            bucle_activo = false;
                                        }
                                    } else {
                                        bucle_activo = false;
                                    }

                                }

                                // DESCRIPCION
                                String descripcion = pedirDato("Descricion", scaner);

                                // RESPONSABLE DE LA TAREA
                                Persona persona_responsable = null;
                                if (hayPersonas) {
                                    persona_responsable = new Persona("", null, null);
                                    bucle_activo = true;
                                    while (bucle_activo) {
                                        System.out.println("Dime el nombre de la persona responsable: ");
                                        String nombre = scaner.nextLine();

                                        if (personas_tarea.size() != 0) {
                                            for (int i = 0; i < personas_tarea.size(); i++) {
                                                if (nombre.equals(personas_tarea.get(i).getNombre())) {
                                                    System.out.println("El usuario es valido\n");
                                                    bucle_activo = false;
                                                    persona_responsable = personas_tarea.get(i);
                                                    hayPersonas2 = true;
                                                    break;
                                                }
                                            }
                                            if (!hayPersonas2) {
                                                System.out.println("Esa persona no esta registrada en las persona incritas en la tarea \n" +
                                                        "Pruebe otra vez\n");
                                            }
                                            hayPersonas2 = false;
                                        } else {
                                            System.out.println("No hay ninguna persona registrada en el Proyecto");
                                            bucle_activo = false;
                                        }
                                    }
                                } else {
                                    System.out.println("Si la tarea no tiene gente asignada no puede tener ningun responsable ");
                                }

                                // PRIORIDAD
                                int prioridad = pedirNumeroEnRango(1, 5, scaner, "Indica la prioridad del 1 al 5, siendo 5 la mas alta\nPrioridad:");

                                // FECHA CREACION
                                System.out.println("Introducir la fecha de creacion: ");
                                Fecha fechaCreacion = pedirFecha(scaner);

                                // FECHA FINALIZACION
                                Fecha fechaFinalizacion = null;
                                if (pedirNumeroEnRango(1, 2, scaner, "¿ Quires añadir fecha de finlización ?\n\t1 - Si\n\t2 - No") == 1) {
                                    bucle_activo = true;
                                    while (bucle_activo) {
                                        fechaFinalizacion = pedirFecha(scaner);
                                        if (fechaCreacion.comparadorFechas(fechaCreacion, fechaFinalizacion)) {
                                            bucle_activo = false;
                                        } else {
                                            System.out.println("La fecha de finalizacion no puede ser mas antigua que la fecha de antigua \n Porfavor vuelva a introducirla: ");
                                        }
                                    }
                                }

                                // TAREA FINALIZADA
                                boolean tareaFinalizada = true;
                                int tareaFin = pedirNumeroEnRango(1, 2, scaner, "Indica si la tarea esta finalizada \n\t1 - Si\n\t2 - No");
                                if (tareaFin == 2) {
                                    tareaFinalizada = false;
                                }

                                // RESULTADO ESPERADO
                                Resultado resultado = null;
                                String lenguaje;
                                int numModulos;
                                int numLineas;
                                opcion = pedirNumeroEnRango(1, 4, scaner, "¿ Que tipo de resultado se espera ? \n\t1 - Biblioteca\n\t2 - Documento\n\t3 - Paguina Web\n\t4 - Programa");
                                int id = proyecto.getTareas().size() + 1;
                                double horasTotal = pedirNumero(scaner, "Horas en total: ");
                                int opcionResultado = pedirNumeroEnRango(1, 2, scaner, "¿ Como es el resultado ? \n\t1 - Interno\n\t2 - Externo\n\t");
                                Interno_Externo d = null;
                                switch (opcionResultado) {
                                    case (1):
                                        d = Interno_Externo.INTERNO;
                                        break;

                                    case (2):
                                        d = Interno_Externo.EXTERNO;
                                        break;
                                }

                                switch (opcion) {
                                    // Biblioteca y Programa
                                    case (1):           // Documento
                                    case (2):
                                    case (4):

                                        numModulos = pedirNumero(scaner, "Numero de modulos: ");
                                        lenguaje = pedirDato("Idioma", scaner);

                                        if (opcion == 1) {
                                            numLineas = pedirNumero(scaner, "Numero de lineas: ");
                                            resultado = new Documento(id, horasTotal, d, lenguaje, "", numLineas, numModulos);

                                        } else {
                                            numLineas = pedirNumero(scaner, "Numero de paginas: ");
                                            if (opcion == 2) {
                                                resultado = new Biblioteca(id, horasTotal, d, lenguaje, "", numLineas, numModulos);
                                            } else {
                                                resultado = new Programa(id, horasTotal, d, lenguaje, "", numLineas, numModulos);
                                            }
                                        }

                                        break;

                                    // Paguna Web
                                    case (3):
                                        lenguaje = pedirDato("Lenguage de progamacion", scaner);
                                        String tipoBack = pedirDato("Tipo de Back utilizado", scaner);
                                        int opcionEstado = pedirNumeroEnRango(1, 2, scaner, "¿ Como es el resultado ? \n\t1 - Estatica\n\t2 - Dinamica\n\t");
                                        Estado t = null;
                                        switch (opcionResultado) {
                                            case (1):
                                                t = Estado.ESTATICA;
                                                break;

                                            case (2):
                                                t = Estado.DINAMICA;
                                                break;
                                        }
                                        resultado = new Pagina_web(id, horasTotal, d, lenguaje, "", t, tipoBack);
                                        break;
                                }

                                // ETIQUETAS
                                LinkedList<String> etiquetas = new LinkedList<>();
                                bucle_activo = true;
                                String etiqueta;
                                while (bucle_activo) {
                                    if (pedirNumeroEnRango(1, 2, scaner, "¿ Quires añadir una etiqueta ?\n\t1 - Si\n\t2 - No") == 1) {
                                        if (etiquetas.isEmpty()) {
                                            etiqueta = pedirDato("Nombre de la Etiqueta", scaner);
                                            for (int i = 0; i < etiquetas.size(); i++) {
                                                if (etiquetas.get(i).equals(etiqueta)) {
                                                    System.out.println("Las etiquetas no pueden estar repetidas \n");
                                                }
                                            }
                                        } else {
                                            pedirDato("Nombre de la Etiqueta", scaner);
                                        }
                                    } else {
                                        bucle_activo = false;
                                    }
                                }

                                // AÑADIR LAS TAREAS
                                Tarea tarea = new Tarea(titulo, descripcion, personas_tarea, persona_responsable, prioridad, fechaCreacion, fechaFinalizacion, tareaFinalizada, resultado, etiquetas);
                                proyecto.añadirTarea(tarea);

                                // AÑADIR LA TAREA A LAS PERSINAS REGISTRADAS
                                if (!personas_tarea.isEmpty()){
                                    for (Persona persona : personas_tarea){
                                        persona.cargarTarea(tarea);
                                    }
                                }

                            } else {
                                break;
                            }
                        } catch (NumberFormatException e) {
                            break;
                        }
                    }
                    break;

                case 4:
                    try {
                        proyecto.buscarTareaPorTitulo(pedirDato("Nombre de la tarea", scaner)).marcarTareaFinalizada();
                    } catch (NullPointerException e) {
                        System.out.println("No se pueden introducir: titulo erróneo");
                    }
                    break;

                case 5:

                    if (proyecto.getTareas().isEmpty()) {
                        System.out.println("No hay ninguna tarea creada");
                    } else {
                        String tareaNombre = pedirDato("Introduce el titulo de la tarea", scaner);

                        Tarea tarea = proyecto.buscarTareaPorTitulo(tareaNombre);
                        while (tarea == null) {
                            tareaNombre = pedirDato("Introduce el titulo de la tarea", scaner);
                            tarea = proyecto.buscarTareaPorTitulo(tareaNombre);
                        }

                        int opcionEstado = pedirNumeroEnRango(1, 2, scaner, "¿ Que quieres hacer ? \n\t1 - Introducir persona\n\t2 - Eliminar persona\n\t");
                        switch (opcionEstado) {
                            case (1):
                                Persona persona = añadirPersona(scaner, proyecto);
                                tarea.añadirPersona(persona);
                                break;
                            case (2):
                                System.out.println("Dime el email de la persona que desea eliminar: ");
                                String email = pedirDato("\tEmail", scaner);
                                if (tarea.personaExistePorEmail(email)) {
                                    tarea.eliminarPersona(email);
                                }
                                break;
                        }

                    }

                    break;

                case 6:
                    proyecto.personasDelProyecto();
                    break;

                case 7:
                    System.out.println(proyecto.tareasDelProyecto());
                    break;

                case 8:
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

    // Pedir un dato numerico
    public static int pedirNumero(Scanner scaner, String palabra) {
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
        String resul = "";
        while (resul == ""){
            System.out.println(nombreDato + ": ");
            resul = scaner.nextLine();
            if (resul==""){
                System.out.println("No puedes introducir el campo vacio\n");
            }
        }
        return resul;
    }

    // Dice si un numero esta en un rango correcto
    public static boolean rangoCorrecto(int minimo, int maximo, int num) {
        return minimo <= num && maximo >= num;
    }

    // Pide un numero en un rango correcto
    public static int pedirNumeroEnRango(int minimo, int maximo, Scanner scaner, String mensaje) {
        boolean bucle_activo = true;
        while (bucle_activo) {
            int opcino_prioridad = pedirNumero(scaner, mensaje);
            if (rangoCorrecto(minimo, maximo, opcino_prioridad)) {
                bucle_activo = false;
                return opcino_prioridad;
            }
        }
        return 0;
    }

    public static Fecha pedirFecha(Scanner scaner) {
        int dia = pedirNumeroEnRango(1, 30, scaner, "Dia: (Del 1 al 30)");
        int mes = pedirNumeroEnRango(1, 12, scaner, "Dia: (Del 1 al 12)");
        int año = pedirNumeroEnRango(2021, 2100, scaner, "Dia: (Del 2021 al 2100)");
        return new Fecha(dia, mes, año);
    }

    // Añadir una persona
    public static Persona añadirPersona(Scanner scaner, Proyecto proyecto) {
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
        return new Persona(pedirDato("Nombre", scaner), email);
    }


}

