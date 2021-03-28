package datos.enums;

public enum Estado {
    ESTATICA("Estatica"),
    DINAMICA("Dinamica");

    String tipo;

    Estado(String tipo) {
        this.tipo = tipo;
    }
}
