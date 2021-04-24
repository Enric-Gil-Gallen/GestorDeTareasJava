package datos.facturacion_Tipos;

import datos.Facturacion;

public class ConsumoInterno implements Facturacion {
    @Override
    public String getNombre() {
        return "Consumo Interno";
    }

    @Override
    public int calcularFacturacion(double coste) {
        return (int) (coste*1.2);
    }
}
