package datos;

import datos.metodosGenericos.tieneClave;

import java.io.Serializable;

public abstract class Resultado implements Serializable, tieneClave {
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


    @Override
    public String getClave() {
        return id+"";
    }
}
