package datos.resultados;

public class Pagina_web {
    Enum tipo;
    Enum lenguaje_web;
    Enum back;

    public Pagina_web(Enum tipo, Enum lenguaje_web, Enum back) {
        this.tipo = tipo;
        this.lenguaje_web = lenguaje_web;
        this.back = back;
    }
}
