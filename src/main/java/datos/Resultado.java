package datos;

public class Resultado {
    int id;
    double horas_totola;
    Enum tipo_Int_Ext;
    String lenguaje;

    public Resultado(int id, double horas_totola, Enum tipo_Int_Ext, String lenguaje) {
        this.id = id;
        this.horas_totola = horas_totola;
        this.tipo_Int_Ext = tipo_Int_Ext;
        this.lenguaje = lenguaje;
    }
}
