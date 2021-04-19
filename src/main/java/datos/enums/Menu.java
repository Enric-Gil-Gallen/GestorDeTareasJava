package datos.enums;

import java.io.Serializable;

public enum Menu implements Serializable {
    NUEVO_PROYECTO_CON_NOMBRE("Iniciar un nuevo proyecto y dale nombre"),
    PERSONAS_EN_PROYECTO("Dar de alta a las personas que trabajan en el proyecto"),
    TAREAS_CON_DATOS("Dar de alta las tareas con sus datos"),
    FINALIZAR_TAREAS("Marcar una tarea como finalizada"),
    INTRODUCIR_O_ELIMINAR_PERSONA_TAREA("Introducir o eliminar una persona de una tarea"),
    LISTAR_PERSONAS_PROYECTO("Listar las personas asignadas a un proyecto"),
    LISTAR_TAREAS_PROYECTO("Listar las tareas de un proyecto"),
    LISTAR_PERSONAS_NO_RESPONSABLES("Listar las personas que no son responsables de ninguna tarea"),
    LISTAR_TAREAS_SIN_PERSONAS("Listar las tareas que no tienen ninguna persona asignada"),
    SALIR("Salir");


    private String descripcion;

    Menu(String descripcion){
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public static Menu getOpcion(int posicion){
        return values() [posicion];
    }

    public static String getMenu() {
        StringBuilder sb = new StringBuilder();
        for (Menu opcion: Menu.values()){
            sb.append(opcion.ordinal() + 1);
            sb.append(".- ");
            sb.append(opcion.getDescripcion());
            sb.append("\n");
        }
        return sb.toString();
    }

}
