package sets;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class FindDupsTS {
    public static void main(String[] args) {

        String words[] = {"EL", "CABALLO", "CORRE", "POR", "EL", "CAMPO"};

        Set<String> s1 = new HashSet<String>();

        for (String a : words) {
            s1.add(a);
        }

        System.out.println( s1.size() + " distinct words: " + s1);

        //Set<String> s2 = new TreeSet<String>();
        s1 = new TreeSet<String>();

        // otra forma de agregar las palabras
        s1.addAll( Arrays.asList( words ) );

        System.out.println(s1.size() + " distinct words: " + s1);

    }
}
