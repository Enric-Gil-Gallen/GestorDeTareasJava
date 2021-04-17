package datos;

public abstract class Resultado {
    private int id;
    private double horas_totolal;
    private Enum tipo_Int_Ext;
    private String lenguaje;
    private String tipoResultado;

    public Resultado(int id, double horas_totolal, Enum tipo_Int_Ext, String lenguaje, String nombre) {
        this.id = id;
        this.horas_totolal = horas_totolal;
        this.tipo_Int_Ext = tipo_Int_Ext;
        this.lenguaje = lenguaje;
        this.tipoResultado = nombre;
    }

    public int getId() {
        return id;
    }

    public String getResultadoyInformacion(){
        StringBuilder sb = new StringBuilder();
        sb.append("Tipo: "+ tipoResultado);
        sb.append("\n");
        sb.append("\t"+" - Id: " + id);
        sb.append("\n");
        sb.append("\t"+" - Tipo: " + tipo_Int_Ext.toString());
        sb.append("\n");
        sb.append("\t"+" - Lenguaje: " + lenguaje);
        sb.append("\n");
        return sb.toString();
    }

    public String ponerDatosEnLinea(){
        StringBuilder linea = new StringBuilder();
        linea.append(id);
        linea.append("#");
        linea.append(horas_totolal);
        linea.append("#");
        linea.append(tipo_Int_Ext.toString());
        linea.append("#");
        linea.append(lenguaje);
        linea.append("#");
        linea.append(tipoResultado);
        linea.append("#");
        return linea.toString();
    }
}
