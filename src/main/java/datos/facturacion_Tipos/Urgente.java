package datos.facturacion_Tipos;

import datos.Facturacion;

public class Urgente implements Facturacion {
    @Override
    public String getNombre() {
        return "Urgente";
    }

    @Override
    public int calcularFacturacion(double coste) {
        return (int) (coste*1.8);
    }
}
