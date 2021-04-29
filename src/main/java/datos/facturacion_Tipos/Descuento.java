package datos.facturacion_Tipos;

import datos.Facturacion;

import java.util.Scanner;

public class Descuento implements Facturacion {
    @Override
    public String getNombre() {
        return "Descuento";
    }

    @Override
    public double calcularFacturacion(double coste, double añadido) {
        return coste * (añadido/100) *1.21;
    }

}
