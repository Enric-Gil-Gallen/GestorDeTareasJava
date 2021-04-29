package datos;

import datos.facturacion_Tipos.Normal;
import datos.facturacion_Tipos.Urgente;
import junit.framework.TestCase;

public class TareaTest extends TestCase {

    public void testCambioDeFacturacion(){
        // Creacion de los datos necesarios
        Proyecto proyecto = new Proyecto("Ejemplo");
        Tarea tarea = new Tarea("Ejemplo", "descripcion", null, null, 1, null, null, false, null, null, 100,new Normal(), 1);

        assertEquals(121.0, tarea.cojerFacturacion());

        tarea.setFacturacion(new Urgente());
        tarea.setValor(20);
        assertEquals(145.2, tarea.cojerFacturacion());

        tarea.setFacturacion(new Urgente());
        tarea.setValor(50);
        assertEquals(181.5, tarea.cojerFacturacion());

    }

}