import edu.duke.*;
import org.apache.commons.csv.*;
public class Main {
    public static void main(String[] args) {

        BabyBirths babyBirths= new BabyBirths ();

       // babyBirths.printNames ();
       // babyBirths.testTotalBirths ();
        System.out.println (babyBirths.getRank (1880,"Lula","F"));


    }
}
