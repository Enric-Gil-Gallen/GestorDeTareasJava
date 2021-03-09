package datos.resultados.enums;

public enum estado {
    ESTATICA("Estatica"),
    DINAMICA("Dinamica");

    String tipo;

    estado(String tipo) {
        this.tipo = tipo;
    }
}
