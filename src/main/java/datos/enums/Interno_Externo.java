package datos.enums;

import java.io.Serializable;

public enum Interno_Externo implements Serializable {
    INTERNO("Interno"),
    EXTERNO("Externo");

    String tipo;

    Interno_Externo(String tipo) {
        this.tipo = tipo;
    }

}
