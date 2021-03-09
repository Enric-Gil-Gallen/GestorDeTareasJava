package datos.resultados;

import datos.Resultado;

public class Programa extends Resultado {
    int num_lineas;
    int num_modulos;

    public Programa(int id, double horas_totola, Enum tipo_Int_Ext, String lenguaje, int num_lineas, int num_modulos) {
        super(id, horas_totola, tipo_Int_Ext, lenguaje);
        this.num_lineas = num_lineas;
        this.num_modulos = num_modulos;
    }
}
