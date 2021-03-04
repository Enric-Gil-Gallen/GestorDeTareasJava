package datos.resultados;

public class Programa {
    Enum lenguaje_info;
    int num_lineas;
    int num_modulos;

    public Programa(Enum lenguaje_info, int num_lineas, int num_modulos) {
        this.lenguaje_info = lenguaje_info;
        this.num_lineas = num_lineas;
        this.num_modulos = num_modulos;
    }
}
