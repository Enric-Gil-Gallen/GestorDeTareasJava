package datos.facturacion_Tipos;

import datos.Facturacion;

public class Normal implements Facturacion {
    @Override
    public String getNombre() {
        return "Normal";
    }

    @Override
    public int calcularFacturacion(double coste) {
        return (int) (coste*1.1);
    }
}
