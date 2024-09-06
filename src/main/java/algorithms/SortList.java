package algorithms;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SortList {

    public static void main(String[] args) {

        String[] palabras = {"xyz","uno","de","Sonora","bbb","cuatros","cccc",
                            "once","Universidad","z","aa", "yy","xxx"};

        List<String> l1 = Arrays.asList( palabras );

        System.out.println("Ordenación alfabetica");
        Collections.sort(l1);
        //l1.sort();
        //l1.sort( new StringComparator() );
        System.out.println(l1);


        System.out.println("\nOrdenación longitud de cadena");
        List<String> l2 = Arrays.asList( palabras );
        Collections.sort( l2, new LengthComparator() );
        System.out.println(l2);
    }
}
