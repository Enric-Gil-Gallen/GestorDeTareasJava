package datos;

import datos.interfaces.tieneClave;
import datos.interfaces.tieneLista;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class utilidadesParaListas{

     public static <T extends tieneLista<E>, E> List<T> elemntosConListaVacia(List<T> list){
        List<T> sol = new LinkedList<>();
         for (T elem: list){
            if (elem.getLista().size()==0) sol.add(elem);
        }
         return sol;
    }

    public static <E extends tieneClave<E>> boolean puedeInsertar(E elemento, List<E> lista){
        for (E objeto:lista){
            if (objeto.getClave().equals(elemento.getClave())) return false;
        }
        return true;
    }

}
