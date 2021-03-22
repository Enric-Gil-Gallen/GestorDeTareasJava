package datos.enums;

public enum menu {
    NUEVO_PROYECTO_CON_NOMBRE("Iniciar un  nuevo proyecto y darle nombre"),
    PERSONAS_EN_PROYECTO("Dar de alta a las personas que trabajan en el proyecto"),
    TAREAS_CON_DATOS("Dar de alta las tareas con sus datos"),
    FINALIZAR_TAREAS("Marcar una tarea como finalizada"),
    INTRODUCIR_O_ELIMINAR_PERSONA_TAREA("Introducir o eliminar una persona de una tarea"),
    LISTAR_PERSONAS_PROYECTO("Listar las personas asignadas a un proyecto");



    private String descripcion;

    menu(String descripcion){
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public static menu getOpcion(int posicion){
        return values() [posicion];
    }

    public static String getMenu() {
        StringBuilder sb = new StringBuilder();
        for (menu opcion: menu.values()){
            sb.append(opcion.ordinal() + 1);
            sb.append(".- ");
            sb.append(opcion.getDescripcion());
            sb.append("\n");
        }
        return sb.toString();
    }
//
//            "6 -Listar las personas asignadas a un proyecto\n" +
//            "7 -Listar las tareas de un proyecto:"
//            );
//
//
//                "8 -Titulo de la Tarea\n" +
//                "9 -Las personas asignadas a la tarea\n" +
//                "10 -Tarea finalizada o no\n" +
//                "11 -Resultado de la tarea");
}
