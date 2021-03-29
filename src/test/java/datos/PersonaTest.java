package datos;

import junit.framework.TestCase;

import java.util.LinkedList;

public class PersonaTest extends TestCase {

    public void testPersonaDeAlta(){
        //Creación de los datos iniciales
        Proyecto proyecto = new Proyecto("Example");
        Persona persona = new Persona("Juan", "juan@example.com");

        //Añadimos la persona al proyecto
        proyecto.añadirPersonas(persona);

        //Comprobamos que esa persona está en la lista del proyecto
        assertTrue(proyecto.getPersonas().contains(persona));
    }

    public void testPersonaDeBaja(){
        //Creación de los datos iniciales
        Proyecto proyecto = new Proyecto("Example");
        Persona persona = new Persona("Pedro", "pedro@example.com");

        //Añadimos la persona al proyecto
        proyecto.añadirPersonas(persona);

        //Borramos a la persona del proyecto
        proyecto.eliminarPersona(persona); //Habría que añadir este método

        //Comprobamos que esa persona NO esta en la lista del proyecto
        assertFalse(proyecto.getPersonas().contains(persona));
    }
}