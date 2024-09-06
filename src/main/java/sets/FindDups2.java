package sets;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FindDups2 {
    public static void main(String[] args) {

        String words[] = {"EL", "CABALLO", "CORRE", "POR", "EL", "CAMPO" };

        String stopwords[] = {"EL", "POR" };

        Set<String> uniques = new HashSet<>();
        Set<String> dups    = new HashSet<String>();

        Set<String> stops = new  HashSet<String>( Arrays.asList(stopwords) );

        for (String a : words)
            // add regresa false si esta duplicado

            if( !stops.contains(a) ) {
                if ( !uniques.add(a) )
                    dups.add(a);
            }

        System.out.println("Unique words:    " + uniques);
        System.out.println("Duplicate words: " + dups);

        // Remover palabras duplicadas (diferencia de conjuntos).
        uniques.removeAll(  dups );

        System.out.println("Unique words:    " + uniques);
        System.out.println("Duplicate words: " + dups);
    }
}
