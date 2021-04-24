package datos;

import datos.facturacion_Tipos.Normal;
import datos.facturacion_Tipos.Urgente;
import junit.framework.TestCase;

public class TareaTest extends TestCase {

    public void testCambioDeFacturacion(){
        // Creacion de los datos necesarios
        Proyecto proyecto = new Proyecto("Ejemplo");
        Tarea tarea = new Tarea("Ejemplo", "descripcion", null, null, 1, null, null, false, null, null, 100,new Normal());
        assertEquals(110, tarea.getFacturacion().calcularFacturacion(tarea.getCoste()));
        tarea.setFacturacion(new Urgente());
        assertEquals(180, tarea.getFacturacion().calcularFacturacion(tarea.getCoste()));

    }

}