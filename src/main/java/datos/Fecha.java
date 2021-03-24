package datos;

public class Fecha {
    int dia;
    int mes;
    int año;

    public Fecha(int dia, int mes, int año) {
        this.dia = dia;
        this.mes = mes;
        this.año = año;
    }

    public int getDia() {
        return dia;
    }

    public int getMes() {
        return mes;
    }

    public int getAño() {
        return año;
    }

    // Este metodo devuelve true si la 1º fecha es mas antigua que la 2º.
    // En el caso de ser iguales devuelbe false
    public boolean comparadorFechas(Fecha antugua, Fecha nueva){
        if (nueva.getAño() <= antugua.getAño()){
            if (nueva.getMes() <= antugua.getMes()){
                if (nueva.getDia() <= antugua.getDia()){
                    return false;
                }
                else {
                    return true;
                }
            }
            else {
                return true;
            }
        }
        else {
            return true;
        }
    }
}
