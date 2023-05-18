import edu.duke.FileResource;
import org.apache.commons.csv.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;


public class BabyBirths {

    public void printNames() {
        FileResource fr = new FileResource ();

        for (CSVRecord record : fr.getCSVParser (false)) {

            int numberOfBabies = Integer.parseInt (record.get (2));
            if (numberOfBabies >= 100) {
                System.out.println ("Name:" + record.get (0) +
                        " Gender: " + record.get (1) +
                        " Num Born: " + numberOfBabies
                );
            }

        }
    }

    /**
     * DONE Modify the method totalBirths (shown in the video for this project) to also print the number of girls names ,
     * the number of boys names and the total names in the file.
     */

    public void totalBirth(FileResource fr) {

        int total = 0;
        int totalM = 0;
        int totalF = 0;

        for (CSVRecord record : fr.getCSVParser (false)) {

            int numberOfBabies = Integer.parseInt (record.get (2));

            total += numberOfBabies;

            if (record.get (1).equals ("M")) {
                totalM += numberOfBabies;
            } else {
                totalF += numberOfBabies;
            }
        }

        System.out.println ("Total babies born: " + total);
        System.out.println ("Total boys: " + totalM);
        System.out.println ("Total girls: " + totalF);

    }

    public void testTotalBirths() {

        FileResource fr = new FileResource ();

        totalBirth (fr);

    }


    /**
     * TODO
     * Write the method named getRank that has three parameters: an integer named year, a string named name,
     * and a string named gender (F for female and M for male).
     * This method returns the rank of the name in the file for the given gender,
     * where rank 1 is the name with the largest number of births. If the name is not in the file, then -1 is returned.
     * For example, in the file "yob2012short.csv", given the name Mason, the year 2012 and the gender ‘M’,
     * the number returned is 2, as Mason is the boys name with the second highest number of births.
     * Given the name Mason, the year 2012 and the gender ‘F’,
     * the number returned is -1 as Mason does not appear with an F in that file.
     */

    public int getRank(int year, String name, String gender) {
        int rank = 1;
        FileResource fr = new FileResource ("C:\\Users\\SebastianTamayoPache\\Desktop\\selbsstudy\\BabyName\\us_babynames (1)\\us_babynames_by_year\\yob" + year + ".csv");

        HashMap<String, Integer> babyRecord = new HashMap<> ();
        List<Baby> babyRanking = new ArrayList<> ();

        for (CSVRecord record : fr.getCSVParser (false)) {

            if (record.get (1).equals (gender)) {
                String nameTmp = record.get (0);
                int numberOfBabies = Integer.parseInt (record.get (2));
                String genderTmp = record.get (1);
                Baby baby = new Baby (nameTmp, numberOfBabies, genderTmp);
                babyRanking.add (baby);
            }

        }
        BirthComparator birthComparator = new BirthComparator ();
        babyRanking.sort (birthComparator);

        for (Baby baby:babyRanking) {
            babyRecord.put (baby.name, rank);
            rank++;
        }

        return babyRecord.getOrDefault (name, -1);

    }


}
