public class Soldado {
    private String nombre;
    private int nivelDeVida;
    private int fila;
    private int columna;

    public Soldado(String nombre, int nivelDeVida, int fila, int columna){
        this.nombre = nombre;
        this.nivelDeVida = nivelDeVida;
        this.fila = fila;
        this.columna = columna;
    }
    public Soldado() {
        nombre = "";
        nivelDeVida = 0;
        fila = 0;
        columna = 0;
    }
    public String getNombre() {
        return nombre;
    }
    public int getNivelDeVida() {
        return nivelDeVida;
    }
    public int getColumna() {
        return columna;
    }
    public int getFila() {
        return fila;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setNivelDeVida(int nivelDeVida) {
        this.nivelDeVida = nivelDeVida;
    }
    public void setColumna(int columna) {
        this.columna = columna;
    }
    public void setFila(int fila) {
        this.fila = fila;
    }
    public String toString() {
        return getNombre() + "\t|fila " + getFila() + "\t|col " + getColumna() + "\t|nvida " + getNivelDeVida();  
    }
}