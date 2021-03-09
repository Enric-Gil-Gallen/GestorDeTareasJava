package datos.resultados;

import datos.Resultado;

public class Biblioteca extends Resultado {
    Enum lenguaje;
    int num_lineas;
    int num_modulos;

    public Biblioteca(int id, double horas_totola, Enum tipo_Int_Ext, String lenguaje, Enum lenguaje1, int num_lineas, int num_modulos) {
        super(id, horas_totola, tipo_Int_Ext, lenguaje);
        this.lenguaje = lenguaje1;
        this.num_lineas = num_lineas;
        this.num_modulos = num_modulos;
    }
}
