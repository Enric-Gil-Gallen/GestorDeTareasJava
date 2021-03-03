package datos;

public class Resultado {
    int id;
    double horas_totola;
    boolean tipo;
    // Interno == true
    // Externo == false

    public Resultado(int id, double horas_totola, boolean tipo) {
        this.id = id;
        this.horas_totola = horas_totola;
        this.tipo = tipo;
    }
}
