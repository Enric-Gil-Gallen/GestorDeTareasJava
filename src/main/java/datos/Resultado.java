package datos;

public abstract class Resultado {
    int id;
    double horas_totolal;
    Enum tipo_Int_Ext;
    String lenguaje;

    public Resultado(int id, double horas_totolal, Enum tipo_Int_Ext, String lenguaje) {
        this.id = id;
        this.horas_totolal = horas_totolal;
        this.tipo_Int_Ext = tipo_Int_Ext;
        this.lenguaje = lenguaje;
    }

}
