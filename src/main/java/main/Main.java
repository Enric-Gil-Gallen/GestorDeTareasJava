package main;

import datos.*;
import datos.enums.Estado;
import datos.enums.Interno_Externo;
import datos.enums.Menu;
import datos.resultados.Biblioteca;
import datos.resultados.Documento;
import datos.resultados.Pagina_web;
import datos.resultados.Programa;

import java.io.*;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main implements Serializable{

    // Patrón para validar el email
    static Pattern pattern = Pattern
            .compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                    + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

    // Variables para el funcionamiento
    static Scanner scaner = new Scanner(System.in);
    static boolean activo = true;
    static int opcion;
    static String ruta = "src/main/java/main/ficheros/proyecto.bin";
    static Proyecto proyecto = null;

    public static void main(String[] args) {
        System.out.println("\nBienvenido al gestor que tareas");
        if (existeProyectoAnterir(ruta)){
            System.out.println("Se ha cargado un Proyecto Anterior\n");
            cargarProyecto();
        }
        else {
            System.out.println("No habia ningun proyecto guardado con anterioridad");
            proyecto = new Proyecto(pedirDato("Nombre Proyecto"));
        }

        //Menu infinito hasta que se pulse la tecla 7
        boolean salir = true;
        while (salir) {
            opcion = pedirNumero(Menu.getMenu());
            switch (opcion) {
                case 1:
                    nuevoProyecto();
                    break;

                case 2:
                    añadirPersonaPrincipal();
                    break;

                case 3:
                    añadirTarea();
                    break;

                case 4:
                    marcarTareaComoCompletada();
                    break;

                case 5:
                    introducirEliminarPersonaTarea();
                    break;

                case 6:
                    System.out.println(proyecto.personasDelProyecto());
                    break;

                case 7:
                    System.out.println(proyecto.tareasDelProyecto());
                    break;

                case 8:

                    break;

                case 9:

                    break;

                case 10:
                    scaner.close();
                    salir = false;
                    guardarProyecto();
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
    public static int comprobarQueEsUnNumero() {
        while (true) {
            try {
                return scaner.nextInt();
            } catch (InputMismatchException e) {
                scaner.nextLine(); // Es necesario porque sino a el programa no le da tiempo a leer es "nextDouble"
                System.out.println("La entrada no es un numero, prueba otra vez por favor:\n");
            }
        }
    }

    // Pedir un dato numerico
    public static int pedirNumero(String palabra) {
        // Llamadas en Enum --> menu
        System.out.println(palabra);
        scaner = new Scanner(System.in);
        int opcion = 0;

        // Comprobar que el numero sea el indicado
        opcion = comprobarQueEsUnNumero(); // Comprobamos que sea un numero lo que nos pasan

        return opcion;
    }

    // Metodo que pide por pantalla
    public static String pedirDato(String nombreDato) {
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
        if (minimo <= num && maximo >= num){
            return true;
        }
        System.out.println("El numero no esta dentro del rango esperado \n" +
                "Por favor vuelva a intentarlo");
        return false;
    }

    // Pide un numero en un rango correcto
    public static int pedirNumeroEnRango(int minimo, int maximo , String mensaje) {
        while (true) {
            int opcino_prioridad = pedirNumero( mensaje);
            if (rangoCorrecto(minimo, maximo, opcino_prioridad)) {
                return opcino_prioridad;
            }
        }
    }

    public static Date pedirFecha() {
        int dia = pedirNumeroEnRango(1, 30, "Dia: (Del 1 al 30)");
        int mes = pedirNumeroEnRango(1, 12, "Dia: (Del 1 al 12)");
        int año = pedirNumeroEnRango(2021, 2100, "Dia: (Del 2021 al 2100)");
        Date fecha = new Date(año-1900, mes-1, dia);
//        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
//        String fechaFormateada = sdf.format(fecha);
//        System.out.println("Fecha" + fecha.toString());
//        System.out.println("Fecha formateada: " + fechaFormateada);
        return fecha;
    }

    // Añadir una persona
    public static Persona añadirPersona(Proyecto proyecto) {
        // Hay que comprobar que el nombre no este repetido
        boolean nombre_no_repe = true;
        String email = "";
        while (nombre_no_repe) {
            email = pedirDato("Email");
            nombre_no_repe = false;
            Matcher mather = pattern.matcher(email);

            if (mather.find()) {
                if (proyecto.getPersonas().size() != 0) {
                    for (Persona persona: proyecto.getPersonas()){
                        if (persona.getEmail().equals(email) && persona.getEmail() != "") {
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
        return new Persona(pedirDato("Nombre"), email);
    }

    // Metodos Añadir tarea
    public static String tareaTitulo(){
        // Hay que comprobar que el nombre no este repetido
        boolean bucle_activo = true;
        String titulo = "";

        // TITULO
        while (bucle_activo) {
            titulo = pedirDato("Titulo");
            bucle_activo = false;

            if (proyecto.getTareas().size() != 0) {
                for (Tarea tarea : proyecto.getTareas()){
                    if (tarea.getTitulo().equals(titulo) && tarea.getTitulo() != "") {
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
        return titulo;
    }

    public static LinkedList<Persona> tareaPersonas(){
        if (proyecto.getPersonas().isEmpty()){
            System.out.println("Si no hay personas en el proyecto no puedes asignar personas en una tarea");
        }
        else {
            LinkedList<Persona> personas_tarea = new LinkedList<>();
            boolean  hayPersonas = false;
            boolean bucle_activo = true;
            while (bucle_activo) {
                String nombre = pedirDato("Dime el nombre de algun integrante\n" +
                        "\t Escriba 1 para salir: ");

                if (!nombre.equals("1")) {
                    if (proyecto.getPersonas().size() != 0) {
                        for (Persona persona: proyecto.getPersonas()){
                            if (nombre.equals(persona.getNombre())) {
                                System.out.println("El usuario es valido\n");
                                hayPersonas = true;
                                personas_tarea.add(persona);
                                break;
                            }
                        }
                        if (!hayPersonas) {
                            System.out.println("Esa persona no esta registrada \n" +
                                    "Pruebe otra vez\n");
                        }
                        hayPersonas = false;
                    } else {
                        System.out.println("No hay ninguna persona registrada en el Proyecto");
                        bucle_activo = false;
                    }
                } else {
                    bucle_activo = false;
                }

            }
            return personas_tarea;
        }
        return null;
    }

    public static Persona tareaResponsables(LinkedList<Persona> personas_tarea){
        Persona persona_responsable = null;
        if (personas_tarea != null && !personas_tarea.isEmpty()){
            boolean bucle_activo = true;
            boolean hayPersonas = false;
            while (bucle_activo) {
                System.out.println("Dime el nombre de la persona responsable: ");
                String nombre = scaner.nextLine();

                if (personas_tarea.size() != 0) {
                    for (Persona persona: personas_tarea){
                        if (nombre.equals(persona.getNombre())) {
                            System.out.println("El usuario es valido\n");
                            bucle_activo = false;
                            persona_responsable = persona;
                            hayPersonas = true;
                            break;
                        }
                    }
                    if (!hayPersonas) {
                        System.out.println("Esa persona no esta registrada en las persona incritas en la tarea \n" +
                                "Pruebe otra vez\n");
                    }
                    hayPersonas = false;
                } else {
                    System.out.println("No hay ninguna persona registrada en el Proyecto");
                    bucle_activo = false;
                }
            }
        }
        else {
            System.out.println("Si la tarea no tiene gente asignada no puede tener ningun responsable ");
        }
        return persona_responsable;
    }

    public static Resultado tareaResultadoEsperado(){
        Resultado resultado = null;
        String lenguaje;
        int numModulos;
        int numLineas;
        opcion = pedirNumeroEnRango(1, 4, "¿ Que tipo de resultado se espera ? \n\t1 - Biblioteca\n\t2 - Documento\n\t3 - Paguina Web\n\t4 - Programa");
        int id = proyecto.getTareas().size() + 1;
        double horasTotal = pedirNumero("Horas en total: ");
        int opcionResultado = pedirNumeroEnRango(1, 2, "¿ Como es el resultado ? \n\t1 - Interno\n\t2 - Externo\n\t");
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

                numModulos = pedirNumero("Numero de modulos: ");
                lenguaje = pedirDato("Idioma");

                if (opcion == 1) {
                    numLineas = pedirNumero("Numero de lineas: ");
                    resultado = new Documento(id, horasTotal, d, lenguaje, "", numLineas, numModulos);

                } else {
                    numLineas = pedirNumero("Numero de paginas: ");
                    if (opcion == 2) {
                        resultado = new Biblioteca(id, horasTotal, d, lenguaje, "", numLineas, numModulos);
                    } else {
                        resultado = new Programa(id, horasTotal, d, lenguaje, "", numLineas, numModulos);
                    }
                }

                break;

            // Paguna Web
            case (3):
                lenguaje = pedirDato("Lenguage de progamacion");
                String tipoBack = pedirDato("Tipo de Back utilizado");
                int opcionEstado = pedirNumeroEnRango(1, 2, "¿ Como es el resultado ? \n\t1 - Estatica\n\t2 - Dinamica\n\t");
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
        return resultado;
    }

    public static LinkedList<String>  tareaEtiquetas(){
        LinkedList<String> etiquetas = new LinkedList<>();
        String etiqueta;
        Boolean etiquetasRepetida;
        while (true) {
            if (pedirNumeroEnRango(1, 2, "¿ Quires añadir una etiqueta ?\n\t1 - Si\n\t2 - No") == 1) {
                    etiqueta = pedirDato("Nombre de la Etiqueta");
                    etiquetasRepetida = false;
                    for (String etique: etiquetas){
                        if (etique.equals(etiqueta)) {
                            System.out.println("Las etiquetas no pueden estar repetidas \n");
                            etiquetasRepetida = true;
                        }
                    }
                    if (!etiquetasRepetida){
                        etiquetas.add(etiqueta);
                    }
                }
                else {
                    return etiquetas;
                }
        }
    }

    public static boolean comparadorFechas(Date fechaCreacion, Date fechaFinalizacion){
        if(fechaCreacion.compareTo(fechaFinalizacion) <= 0){
            return true;
        }
        return false;
    }

    public static boolean existeProyectoAnterir(String ruta){
        File archiv = new File("src/main/java/main/ficheros/proyecto.bin");
        if (archiv.exists()){
            return true;
        }
        return false;
    }

    // METODOS POR CADA OPCION DEL MANU

    // Opcion 0 -- Cargar Proyecto
    public static void cargarProyecto(){
        try {
            ObjectInputStream fichero = new ObjectInputStream(new FileInputStream(ruta));
            proyecto = (Proyecto)fichero.readObject();
            fichero.close();

        }
        catch (IOException e){
            System.out.println("No existe el fichero: " + ruta);
        }
        catch (ClassNotFoundException e){
            System.out.println("No se ha podido cargar el proyecto");
            proyecto = new Proyecto(pedirDato("Nombre Proyecto"));
        }

    }

    // Opción 1 -- Nuevo proyecto
    public static void nuevoProyecto(){
        System.out.println("¿ Cual va a ser el nombre del nuevo proyecto ?");
        proyecto =  new Proyecto(pedirDato("Nombre del proyecto"));
    }

    // Opcion 2 -- Intruducir persona
    public static void añadirPersonaPrincipal(){
        boolean activo = true;
        while (activo) {
            String num = pedirDato(" ¿Que quieres hacer ?\n" +
                    "\t1 - Introducir persona\n" +
                    "\tCualquier otra tecla - Finalizar");
            try {
                if (Integer.parseInt(num) == 1) {
                    proyecto.añadirPersonas(añadirPersona(proyecto));
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                break;
            }
        }
    }

    // Opcion 3 -- Añadir Tarea
    public static void añadirTarea(){
        while (activo) {
            String num = pedirDato(" ¿Que quieres hacer ?\n" +
                    "\t1 - Introducir tarea \n" +
                    "\tCualquier otra tecla - Finalizar");
            try {
                if (Integer.parseInt(num) == 1) {
                    // TITULO
                    String titulo =  tareaTitulo();

                    // PERSONAS
                    LinkedList<Persona> personas_tarea =  tareaPersonas();

                    // RESPONSABLE DE LA TAREA
                    Persona persona_responsable =  tareaResponsables(personas_tarea);

                    // DESCRIPCION
                    String descripcion = pedirDato("Descricion");

                    // PRIORIDAD
                    int prioridad = pedirNumeroEnRango(1, 5, "Indica la prioridad del 1 al 5, siendo 5 la mas alta\nPrioridad:");

                    // FECHA CREACION
                    System.out.println("Introducir la fecha de creacion: ");
                    Date fechaCreacion = pedirFecha();

                    // FECHA FINALIZACION
                    Date fechaFinalizacion = null;
                    if (pedirNumeroEnRango(1, 2, "¿ Quires añadir fecha de finlización ?\n\t1 - Si\n\t2 - No") == 1) {
                        boolean bucle_activo = true;
                        while (bucle_activo) {
                            fechaFinalizacion = pedirFecha();
                            if (comparadorFechas(fechaCreacion, fechaFinalizacion)) {
                                bucle_activo = false;
                            } else {
                                System.out.println("La fecha de finalizacion no puede ser mas antigua que la fecha de antigua \n Porfavor vuelva a introducirla: ");
                            }
                        }
                    }

                    // TAREA FINALIZADA
                    boolean tareaFinalizada = true;
                    int tareaFin = pedirNumeroEnRango(1, 2, "Indica si la tarea esta finalizada \n\t1 - Si\n\t2 - No");
                    if (tareaFin == 2) tareaFinalizada = false;

                    // RESULTADO ESPERADO
                    Resultado resultado = tareaResultadoEsperado();

                    // ETIQUETAS
                    LinkedList<String> etiquetas =  tareaEtiquetas();

                    // AÑADIR LAS TAREAS
                    Tarea tarea = new Tarea(titulo, descripcion, personas_tarea, persona_responsable, prioridad, fechaCreacion, fechaFinalizacion, tareaFinalizada, resultado, etiquetas);
                    proyecto.añadirTarea(tarea);

                    // AÑADIR EL RESULTADO A TODOS LOS RESULTADOS
                    proyecto.añadirResultado(resultado);

                    // AÑADIR LA TAREA A LAS PERSONAS REGISTRADAS
                    if (personas_tarea != null && !personas_tarea.isEmpty()){
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
    }

    // Opcion 4 -- Marcar una tarea como finalizada
    public static void marcarTareaComoCompletada(){
        try {
            proyecto.buscarTareaPorTitulo(pedirDato("Nombre de la tarea")).marcarTareaFinalizada();
        } catch (NullPointerException e) {
            System.out.println("No se pueden introducir/eliminar: El titulo erróneo");
        }
    }

    // Opcion 5 -- Introducir Persona como completada
    public static void introducirEliminarPersonaTarea(){

        if (proyecto.getTareas().isEmpty()) {
            System.out.println("No hay ninguna tarea creada");
        } else {
            String tareaNombre = pedirDato("Introduce el titulo de la tarea");

            Tarea tarea = proyecto.buscarTareaPorTitulo(tareaNombre);
            while (tarea == null) {
                System.out.println("El titulo no pertenece a ninguna tarea");
                tareaNombre = pedirDato("Introduce el titulo de la tarea");
                tarea = proyecto.buscarTareaPorTitulo(tareaNombre);
            }

            int opcionEstado = pedirNumeroEnRango(1, 2, "¿ Que quieres hacer ? \n\t1 - Introducir persona\n\t2 - Eliminar persona\n\t");
            switch (opcionEstado) {
                case (1):
                    if (!proyecto.getPersonas().isEmpty()){
                        Persona persona = proyecto.buscarPersonaEmail(pedirDato("Email"));
                        persona.cargarTarea(tarea);
                        if(!tarea.añadirPersona(persona)){
                            System.out.println("La persona ya esta el la tarea");
                        }

                    }
                    else {
                        System.out.println("No se puede añadir la persona");
                        System.out.println("Primero tiene que declarar la persona en el proyecto");
                    }
                    break;
                case (2):
                    if(!tarea.getPersonas().isEmpty()){
                        System.out.println("Dime el email de la persona que desea eliminar: ");
                        String email = pedirDato("\tEmail");
                        if (tarea.personaExistePorEmail(email)) {
                            if (!tarea.eliminarPersona(email)){
                                System.out.println("La persona responsable tambien a sido eliminada");
                            }
                        }
                    }
                    else {
                        System.out.println("No hay ningua persona asirganada a esta tarea");
                    }

                    break;
            }

        }

    }

    //Opcion 8 -- Listar personas que no son responsables de ninguna tarea

    //Opcion 9 -- Obtener un listado de tareas que no tienen ninguna persona asignada

    // Opcion 10 -- Salir
    public static void guardarProyecto(){
        try{
            BufferedWriter bw = new BufferedWriter(new FileWriter(ruta));
            bw.write("");
            bw.close();

            ObjectOutputStream fichero = new ObjectOutputStream(new FileOutputStream(ruta));
            fichero.writeObject(proyecto);
            fichero.close();
        }catch (Exception e){
            System.out.println("El fichero no existe");
        }
    }
}

