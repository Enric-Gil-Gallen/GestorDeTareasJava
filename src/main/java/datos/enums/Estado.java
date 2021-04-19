package datos.enums;

import java.io.Serializable;

public enum Estado implements Serializable {
    ESTATICA("Estatica"),
    DINAMICA("Dinamica");

    String tipo;

    Estado(String tipo) {
        this.tipo = tipo;
    }
}
