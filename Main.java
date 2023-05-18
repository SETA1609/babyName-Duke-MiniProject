import edu.duke.*;
import org.apache.commons.csv.*;
public class Main {
    public static void main(String[] args) {

        BabyBirths babyBirths= new BabyBirths ();


       // babyBirths.printNames ();
       // babyBirths.testTotalBirths ();
        System.out.println (babyBirths.getRank (1880,"Lula","F"));
        System.out.println (babyBirths.getRank (1881,"Lula","F"));
        System.out.println (babyBirths.getRank (1882,"Lula","F"));
        System.out.println (babyBirths.getName (1880,904,"F"));
        babyBirths.whatIsNameInYear ("Lula",1880,2000,"F");
        System.out.println (babyBirths.yearOfHighestRank ("Lula","F"));

    }
}
