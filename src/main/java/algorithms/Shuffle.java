package algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Shuffle {

    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        if(args.length > 0) {
            // lista de argumentos
            for (String a : args)
                list.add( a );

            System.out.println( list );

            Collections.shuffle(list, new Random());
            System.out.println( list );

        }
    }
}
