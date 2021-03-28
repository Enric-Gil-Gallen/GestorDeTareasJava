package datos.resultados;

import datos.Resultado;

public class Biblioteca extends Resultado {
    int num_lineas;
    int num_modulos;

    public Biblioteca(int id, double horas_totolal, Enum tipo_Int_Ext, String lenguaje, int num_lineas, int num_modulos) {
        super(id, horas_totolal, tipo_Int_Ext, lenguaje);
        this.num_lineas = num_lineas;
        this.num_modulos = num_modulos;
    }

    public int getNum_lineas() {
        return num_lineas;
    }

    public int getNum_modulos() {
        return num_modulos;
    }
}
