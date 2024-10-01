import java.util.Scanner;

public class AnalizadorTexto {
    public static void main(String[] args) {
        //utilizamos try para el uso de scanner
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Ingrese un texto para analizar:");
            String texto = scanner.nextLine().toLowerCase();
            //variable para cantidad de letras en el vocabulario 
            int letrasAbecedario = 26;
            //cambiamos algunas variables para que sean mas claras
            int[] frecuenciaLetras = new int[letrasAbecedario];
            int totalLetras = 0;
            int totalPalabras = 0;
            int totalVocales = 0;
            //creo variables para las letras usadas y el espacio.
            char letra_a = 'a';
            char letra_e = 'e';
            char letra_o = 'o';
            char letra_i = 'i';
            char letra_u = 'u';
            char letra_z = 'z';
            char espacio = ' ';
            //reemplazo variables creadas en el codigo
            for (int i = 0; i < texto.length(); i++) {
                char c = texto.charAt(i);
                if (c >= letra_a && c <= letra_z) {
                    frecuenciaLetras[c - letra_a]++;
                    totalLetras++;
                    if (c == letra_a || c == letra_e || c == letra_i || c == letra_o || c == letra_u) {
                        totalVocales++;
                    }
                } else if (c == espacio && i > 0 && texto.charAt(i - 1) != espacio) {
                    totalPalabras++;
                }
            }
            totalPalabras++; // Contar la última palabra
            
            System.out.println("Análisis del texto:");
            System.out.println("Total de letras: " + totalLetras);
            System.out.println("Total de palabras: " + totalPalabras);
            System.out.println("Total de vocales: " + totalVocales);
            System.out.println("Frecuencia de letras:");
            for (int i = 0; i < 26; i++) {
                if (frecuenciaLetras[i] > 0) {
                    System.out.println((char) (i + letra_a) + ": " + frecuenciaLetras[i]);
                }
            }
        }
    }
}

