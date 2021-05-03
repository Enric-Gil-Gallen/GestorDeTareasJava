package datos;

import datos.metodosGenericos.tieneClave;
import datos.metodosGenericos.tieneLista;

import java.util.LinkedList;
import java.util.List;

public class utilidadesParaListas{

     public static <T extends tieneLista<E>, E> List<T> elemntosConListaVacia(LinkedList<T> list){
        List<T> sol = new LinkedList<>();
         for (T elem: list){
            if (elem.getLista().size()==0) sol.add(elem);
        }
         return sol;
    }

    public static <E extends tieneClave<E>> boolean puedeInsertar(E elemento, LinkedList<E> lista){
        for (E objeto:lista){
            if (objeto.getClave() == (elemento.getClave())) return false;
        }
        return true;
    }

}
