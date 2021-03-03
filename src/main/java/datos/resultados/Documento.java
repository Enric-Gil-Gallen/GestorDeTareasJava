package datos.resultados;

import datos.Resultado;

public class Documento extends Resultado {
    Enum tipo;
    int num_paguinas;
    int num_modulos;

    public Documento(int id, double horas_totola, boolean tipo, Enum tipo1, int num_paguinas, int num_modulos) {
        super(id, horas_totola, tipo);
        this.tipo = tipo1;
        this.num_paguinas = num_paguinas;
        this.num_modulos = num_modulos;
    }
}
