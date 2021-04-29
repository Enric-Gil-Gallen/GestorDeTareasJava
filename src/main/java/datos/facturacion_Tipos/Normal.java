package datos.facturacion_Tipos;

import datos.Facturacion;

public class Normal implements Facturacion {
    @Override
    public String getNombre() {
        return "Normal";
    }

    @Override
    public double calcularFacturacion(double coste, double añadido) {
        return coste *1.21;
    }
}
