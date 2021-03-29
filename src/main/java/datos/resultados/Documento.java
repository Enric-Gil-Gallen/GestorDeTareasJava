package datos.resultados;

import datos.Resultado;

public class Documento extends Resultado {
    int num_paguinas;
    int num_modulos;

    public Documento(int id, double horas_totolal, Enum tipo_Int_Ext, String lenguaje, String nombre, int num_paguinas, int num_modulos) {
        super(id, horas_totolal, tipo_Int_Ext, lenguaje, "Documento");
        this.num_paguinas = num_paguinas;
        this.num_modulos = num_modulos;
    }
    @Override
    public String getResultadoyInformacion() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.getResultadoyInformacion());
        sb.append("\t"+" - Numero de paguinas: " + num_paguinas);
        sb.append("\n");
        sb.append("\t"+" - Numero de modulos: " + num_modulos);
        sb.append("\n");

        return sb.toString();
    }
}
