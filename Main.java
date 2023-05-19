import edu.duke.*;
import org.apache.commons.csv.*;

public class Main {
    public static void main(String[] args) {

        BabyBirths babyBirths = new BabyBirths ();


        // babyBirths.printNames ();
      //  babyBirths.testTotalBirths ();
      //  babyBirths.testTotalBirths ();
       // System.out.println (babyBirths.getRank (1960, "Emily", "F"));
       // System.out.println (babyBirths.getRank (1971, "Frank", "M"));
        // System.out.println (babyBirths.getRank (1882,"Lula","F"));
       // System.out.println (babyBirths.getName (1980, 350 , "F"));
       // System.out.println (babyBirths.getName (1982, 450, "M"));
       // babyBirths.whatIsNameInYear ("Susan", 1972, 2014, "F");
       // babyBirths.whatIsNameInYear ("Owen", 1974, 2014, "M");
         System.out.println (babyBirths.yearOfHighestRank ("Genevieve","F"));
         System.out.println (babyBirths.yearOfHighestRank ("Mich","M"));

       //    System.out.println (babyBirths.getAverageRank ("Susan","F"));
        // System.out.println (babyBirths.getAverageRank ("Robert","M"));

        //  babyBirths.getTotalBirthsRankedHigher (1990,"Lula","F");
        //  System.out.println (babyBirths.getTotalBirthsRankedHigher (1990,"Emily","F"));
        //  System.out.println (babyBirths.getTotalBirthsRankedHigher (1990,"Drew","M"));


    }
}
