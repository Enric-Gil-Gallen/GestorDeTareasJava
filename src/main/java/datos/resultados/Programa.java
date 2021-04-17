package datos.resultados;

import datos.Resultado;

public class Programa extends Resultado {
    private int num_lineas;
    private int num_modulos;

    public Programa(int id, double horas_totolal, Enum tipo_Int_Ext, String lenguaje, String nombre, int num_lineas, int num_modulos) {
        super(id, horas_totolal, tipo_Int_Ext, lenguaje, "Progama");
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
    @Override
    public String ponerDatosEnLinea() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.ponerDatosEnLinea());
        sb.append(num_lineas);
        sb.append("#");
        sb.append(num_modulos);
        return sb.toString();
    }
}
