package datos.facturacion_Tipos;

import datos.Facturacion;

import java.io.Serializable;
import java.util.Scanner;

public class Descuento implements Facturacion, Serializable {
    @Override
    public String getNombre() {
        return "Descuento";
    }

    @Override
    public double calcularFacturacion(double coste, double añadido) {
        return coste * (añadido/100) *1.21;
    }

}
