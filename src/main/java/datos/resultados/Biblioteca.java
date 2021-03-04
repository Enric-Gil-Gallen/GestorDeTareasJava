package datos.resultados;

public class Biblioteca {
    Enum lenguaje;
    int num_lineas;
    int num_modulos;

    public Biblioteca(Enum lenguaje, int num_lineas, int num_modulos) {
        this.lenguaje = lenguaje;
        this.num_lineas = num_lineas;
        this.num_modulos = num_modulos;
    }
}
