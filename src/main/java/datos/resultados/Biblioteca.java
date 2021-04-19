package datos.resultados;

import datos.Resultado;

import java.io.Serializable;

public class Biblioteca extends Resultado implements Serializable {
    private int num_lineas;
    private int num_modulos;

    public Biblioteca(int id, double horas_totolal, Enum tipo_Int_Ext, String lenguaje, String nombre, int num_lineas, int num_modulos) {
        super(id, horas_totolal, tipo_Int_Ext, lenguaje, "Biblioteca");
        this.num_lineas = num_lineas;
        this.num_modulos = num_modulos;
    }

    @Override
    public String getResultadoyInformacion() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.getResultadoyInformacion());
        sb.append("\t"+" - Numero de lineas: " + num_lineas);
        sb.append("\n");
        sb.append("\t"+" - Numero de modulos: " + num_modulos);
        sb.append("\n");

        return sb.toString();
    }

}
