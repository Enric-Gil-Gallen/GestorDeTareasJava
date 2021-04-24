package datos.facturacion_Tipos;

import datos.Facturacion;

public class Descuento implements Facturacion {
    @Override
    public String getNombre() {
        return "Descuento";
    }

    @Override
    public int calcularFacturacion(double coste) {
        return (int) (coste*0.8);
    }
}
