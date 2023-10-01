/**
 * laboratorio5
 */
public class laboratorio5 {

    public static void main(String[] args) {
        Soldado[][] ejercito = new Soldado[10][10];
        generarSoldados(ejercito);
        mostrarTablero(ejercito);

        System.out.println("Soldado con mayor vida: " + mayorVidaSoldado(ejercito).getNombre());
        System.out.println("Promedio de nivel de vida: " + promedioDeVida(ejercito));
        System.out.println("El nivel de vida del ejercito es: " + nivelDeVidaEjercito(ejercito));
        System.out.println("Ordenamiento Burbuja:");
        ordenamientoBurbujaVida(ejercito);
        System.out.println("Ordenamiento Seleccion");
        ordenamientoSeleccionVida(ejercito);
    }
    public static void ordenamientoBurbujaVida(Soldado[][] ejercito) {
        int filas = ejercito.length;
        int columnas = ejercito[0].length;
        for (int fila = 0; fila < filas; fila++) {
            for (int columna = 0; columna < columnas - 1; columna++) {
                if (ejercito[fila][columna].getNivelDeVida() < ejercito[fila][columna + 1].getNivelDeVida()) {
                    Soldado aux = ejercito[fila][columna];
                    ejercito[fila][columna] = ejercito[fila][columna + 1];
                    ejercito[fila][columna + 1] = aux;
                }
            }
        }
    }
    public static void ordenamientoSeleccionVida(Soldado[][] ejercito) {
        int filas = ejercito.length;
        int columnas = ejercito[0].length;  
        for (int fila = 0; fila < filas; fila++) {
            for (int columna = 0; columna < columnas - 1; columna++) {
                int indiceMaxVida = columna;
                for (int i = columna + 1; i < columnas; i++) {
                    if (ejercito[fila][i].getNivelDeVida() > ejercito[fila][indiceMaxVida].getNivelDeVida()) {
                        indiceMaxVida = i;
                    }
                }
                Soldado aux = ejercito[fila][columna];
                ejercito[fila][columna] = ejercito[fila][indiceMaxVida];
                ejercito[fila][indiceMaxVida] = aux;
            }
        }
    }
    
    
    
    public static int nivelDeVidaEjercito(Soldado[][] ejercito) {
        int var = 0;
        for (int i = 0; i < ejercito.length; i++) {
            for (int j = 0; j < ejercito[i].length; j++) {
                if(ejercito[i][j] != null){
                    var += ejercito[i][j].getNivelDeVida();
                }
            }
        }
        return var;
    }
    public static double promedioDeVida(Soldado[][] ejercito) {   
        int var = 0;
        double sum = 0;
        for (int i = 0; i < ejercito.length; i++) {
            for (int j = 0; j < ejercito[i].length; j++) {
                if(ejercito[i][j] != null){
                    var++;
                    sum += ejercito[i][j].getNivelDeVida();
                }
            }
        }   
        double promedio = sum / var;
        return promedio;
    }
    public static Soldado mayorVidaSoldado(Soldado[][] ejercito) {
        Soldado aux = new Soldado();
        for (int i = 0; i < ejercito.length; i++) {
            for (int j = 0; j < ejercito[i].length; j++) {
                if (ejercito[i][j] != null) {
                    if (ejercito[i][j].getNivelDeVida() > aux.getNivelDeVida()) {
                        aux = ejercito[i][j];
                    }
                }
            }
        }
        return aux;
    }
    public static void generarSoldados(Soldado[][] ejercito) {
        int nroSoldados = (int)(Math.random()*10 + 1);
        for (int i = 0; i < nroSoldados; i++) {
            String nombre = "Soldado" + (i + 1); 
            int fila = (int)(Math.random()*10);
            int columna = (int)(Math.random()*10);
            int nivelDeVida = (int)(Math.random()*5 + 1);
            Soldado aux = new Soldado(nombre, nivelDeVida, fila, columna);
            if (!coincidencias(ejercito, aux)) {
                ejercito[fila][columna] = aux;
                System.out.println(aux);
            }else {
                i--;
            }
        }
    }
    public static boolean coincidencias(Soldado[][] ejercito, Soldado soldado) {
        for (int i = 0; i < ejercito.length; i++) {
            for (int j = 0; j < ejercito[i].length; j++) {
                if (ejercito[i][j] != null) {
                    if (ejercito[i][j].getFila() == soldado.getFila() && 
                    ejercito[i][j].getColumna() == soldado.getColumna()) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public static void mostrarTablero(Soldado[][] ejercito) {
        System.out.print("\t");
        for (int i = 0; i < ejercito.length; i++) {
            System.out.print("   " + (char)(65 + i) + "  ");
        }
        System.out.println("\n\t.___________________________________________________________.");
        for (int i = 0; i < ejercito.length; i++) {
            System.out.print("   " + (i + 1) + "\t|");
            for (int j = 0; j < ejercito[i].length; j++) {
                if(ejercito[i][j] != null){
                    System.out.print("_x___|");   
                }else {
                    System.out.print("_____|");
                }
            }
            System.out.println();
        }
/*
        for (int i = 0; i < ejercito.length; i++) {
            for (int j = 0; j < ejercito[i].length; j++) {
                if (ejercito[i][j] != null) {
                    System.out.println(ejercito[i][j]);
                }
            }
        }*/
    }
}