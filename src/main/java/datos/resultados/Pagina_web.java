package datos.resultados;

import datos.Resultado;

public class Pagina_web extends Resultado {
    Enum estado;
    String back_tipo;

    public Pagina_web(int id, double horas_totolal, Enum tipo_Int_Ext, String lenguaje, String nombre, Enum estado, String back_tipo) {
        super(id, horas_totolal, tipo_Int_Ext, lenguaje, "Pagina Web");
        this.estado = estado;
        this.back_tipo = back_tipo;
    }

    @Override
    public String getResultadoyInformacion() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.getResultadoyInformacion());
        sb.append("\t"+" - Estado: " + estado.toString());
        sb.append("\n");
        sb.append("\t"+" - Backend utilizado: " + back_tipo);
        sb.append("\n");

        return sb.toString();
    }
}
