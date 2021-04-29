package datos.facturacion_Tipos;

import datos.Facturacion;

import java.io.Serializable;

public class Normal implements Facturacion, Serializable {
    @Override
    public String getNombre() {
        return "Normal";
    }

    @Override
    public double calcularFacturacion(double coste, double añadido) {
        return coste *1.21;
    }
}
