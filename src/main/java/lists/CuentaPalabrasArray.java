package lists;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CuentaPalabrasArray {
    public static void main(String[] args) {

        if (args.length == 0) {
            System.out.println("Falta el nombre de archivo");
            System.exit(0);
        }

        FileReader fi = null;
        try {
            fi = new FileReader(args[0]);
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
            System.exit(-1);
        }

        //Usar para leer linea x linea el archivo
        BufferedReader inputFile = new BufferedReader(fi);

        String textLine = null;

        int lineCount = 0;
        int wordCount = 0;
        int numberCount = 0;

        String delimiters = "\\s+|,\\s*|\\.\\s*|\\;\\s*|\\:\\s*|\\!\\s*|\\¡\\s*|\\¿\\s*|\\?\\s*|\\-\\s*"
                + "|\\[\\s*|\\]\\s*|\\(\\s*|\\)\\s*|\\\"\\s*|\\_\\s*|\\%\\s*|\\+\\s*|\\/\\s*|\\#\\s*|\\$\\s*";


        // Lista con todas las palabras diferentes
        ArrayList<String> list = new ArrayList<String>();

        // Tiempo inicial
        long startTime = System.currentTimeMillis();
        try {
            while ((textLine = inputFile.readLine()) != null) {
                lineCount++;

                if (textLine.trim().length() == 0) {
                    continue; // la linea esta vacia, continuar
                }

                // separar las palabras en cada linea
                String words[] = textLine.split( delimiters );

                wordCount += words.length;

                for (String theWord : words) {

                    theWord = theWord.toLowerCase().trim();

                    boolean isNumeric = true;

                    // verificar si el token es un numero
                    try {
                        Double num = Double.parseDouble(theWord);
                    } catch (NumberFormatException e) {
                        isNumeric = false;
                    }

                    // Si el token es un numero, pasar al siguiente
                    if (isNumeric) {
                        numberCount++;
                        continue;
                    }

                    // si la palabra no esta en la lista, agregar a la lista
                    if ( !list.contains(theWord) ) {
                        list.add(theWord);
                    }
                }
            }
            // Obtener tiempo de ejecución
            long tiempoEjecucion = System.currentTimeMillis() - startTime;
            inputFile.close();
            fi.close();

            System.out.printf("%2.3f  segundos, %,d lineas y %,d palabras\n",
                    tiempoEjecucion / 1000.00, lineCount, wordCount - numberCount);

            // Mostrar total de palabras diferentes
            System.out.printf("%,d palabras diferentes\n", list.size());

//            for (String word : list) {
//                System.out.println(word);
//            }

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }
}
