package datos;

import junit.framework.TestCase;

import java.util.LinkedList;

public class ProyectoTest extends TestCase {

    public void testMarcarComoFinalizado() {
        // Creacion de los datos necesarios
        Proyecto proyecto = new Proyecto("Ejemplo");
        Tarea tarea = new Tarea("Ejemplo", "descripcion", null, null, 1, null, null, false, null, null);

        // Añadir la tarea con el valor false
        proyecto.añadirTarea(tarea);

        // Marcar como finalizada
        proyecto.getTareas().get(0).marcarTareaFinalizada();

        // Comoprobacion
        assertTrue(proyecto.getTareas().get(0).getTarea_Finalizada());
    }

    public void testListasDevueltasListasVacias(){
        Proyecto proyecto = new Proyecto("Ejemplo");
        Boolean flag = false;
        if (proyecto.getPersonas().size() == 0 && proyecto.getTareas().size() == 0 && proyecto.getResultados().size() == 0){
            flag = true;
        } else {
            flag = false;
        }
        assertTrue(flag);
    }



}