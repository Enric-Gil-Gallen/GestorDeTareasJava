package datos.resultados;

import datos.Resultado;

public class Pagina_web extends Resultado {
    Enum estado;
    String back_tipo;

    public Pagina_web(int id, double horas_totola, Enum tipo_Int_Ext, String lenguaje, Enum estado, String back_tipo) {
        super(id, horas_totola, tipo_Int_Ext, lenguaje);
        this.estado = estado;
        this.back_tipo = back_tipo;
    }
}
