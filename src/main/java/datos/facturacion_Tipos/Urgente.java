package datos.facturacion_Tipos;

import datos.Facturacion;

public class Urgente implements Facturacion {
    @Override
    public String getNombre() {
        return "Urgente";
    }

    @Override
    public double calcularFacturacion(double coste, double añadido) {
        return ((coste * (añadido/100) + coste )*1.21);
    }
}
