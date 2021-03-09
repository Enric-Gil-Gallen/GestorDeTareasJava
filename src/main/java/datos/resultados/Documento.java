package datos.resultados;

import datos.Resultado;

public class Documento extends Resultado {
    int num_paguinas;
    int num_modulos;

    public Documento(int id, double horas_totola, Enum tipo_Int_Ext, String lenguaje, int num_paguinas, int num_modulos) {
        super(id, horas_totola, tipo_Int_Ext, lenguaje);
        this.num_paguinas = num_paguinas;
        this.num_modulos = num_modulos;
    }
}
