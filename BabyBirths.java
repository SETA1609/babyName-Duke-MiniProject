import edu.duke.*;
import org.apache.commons.csv.*;

import java.io.File;
import java.util.*;


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
        int totalNamesF = 0;
        int totalNamesM = 0;
        int totalNames = 0;
        for (CSVRecord record : fr.getCSVParser (false)) {

            int numberOfBabies = Integer.parseInt (record.get (2));
            totalNames++;
            total += numberOfBabies;

            if (record.get (1).equals ("M")) {
                totalM += numberOfBabies;
                totalNamesM++;
            } else {
                totalF += numberOfBabies;
                totalNamesF++;
            }
        }

        System.out.println ("Total babies born: " + total + " with a number of names: " + totalNames);
        System.out.println ("Total boys: " + totalM + " with a number of names: " + totalNamesM);
        System.out.println ("Total girls: " + totalF + " with a number of names: " + totalNamesF);

    }

    public void testTotalBirths() {

        FileResource fr = new FileResource ();

        totalBirth (fr);

    }





    /**
     * DONE
     * Write the method named getRank that has three parameters: an integer named year, a string named name,
     * and a string named gender (F for female and M for male).
     * This method returns the rank of the name in the file for the given gender,
     * where rank 1 is the name with the largest number of births. If the name is not in the file, then -1 is returned.
     * For example, in the file "yob2012short.csv", given the name Mason, the year 2012 and the gender ‘M’,
     * the number returned is 2, as Mason is the boys name with the second-highest number of births.
     * Given the name Mason, the year 2012 and the gender ‘F’,
     * the number returned is -1 as Mason does not appear with an F in that file.
     */

    public int getRank(int year, String name, String gender) {
        FileResource fr = new FileResource ("C:\\Users\\SebastianTamayoPache\\Desktop\\selbsstudy\\BabyName\\us_babynames (1)\\us_babynames_by_year\\yob" + year + ".csv");
        int rank = 0;

        for (CSVRecord record : fr.getCSVParser(false)) {
            if (record.get(1).equals(gender)) {
                rank++;
                if (record.get(0).equals(name)) {
                    return rank;
                }
            }
        }

        return -1;
    }

    /**
     * DONE
     * Write the method named getName that has three parameters:
     * an integer named year, an integer named rank, and a string named gender (F for female and M for male).
     * This method returns the name of the person in the file at this rank, for the given gender,
     * where rank 1 is the name with the largest number of births.
     * If the rank does not exist in the file, then “NO NAME”  is returned.
     */



    public String getName(int year, int ranking, String gender) {
        FileResource fr = new FileResource ("C:\\Users\\SebastianTamayoPache\\Desktop\\selbsstudy\\BabyName\\us_babynames (1)\\us_babynames_by_year\\yob" + year + ".csv");
        int rank = 0;

        for (CSVRecord record : fr.getCSVParser(false)) {
            if (record.get(1).equals(gender)) {
                rank++;
                if (rank == ranking) {
                    return record.get(0);
                }
            }
        }

        return "No name";
    }


    /**
     * What would your name be if you were born in a different year?
     * Write the void method named whatIsNameInYear that has four parameters: a string name,
     * an integer named year representing the year that name was born,
     * an integer named newYear and a string named gender (F for female and M for male).
     * This method determines what name would have been named if they were born in a different year, based on the same popularity.
     * That is, you should determine the rank of name in the year they were born,
     * and then print the name born in newYear that is at the same rank and same gender. For example,
     * using the files "yob2012short.csv" and "yob2014short.csv",
     * notice that in 2012 Isabella is the third most popular girl's name.
     * If Isabella was born in 2014 instead, she would have been named Sophia,
     * the third most popular girl's name that year. The output might look like this:
     * Isabella born in 2012 would be Sophia if she was born in 2014.
     */

    public void whatIsNameInYear(String name, int year, int newYear, String gender) {

        int ranking = getRank (year, name, gender);
        String newName = getName (newYear, ranking, gender);

        System.out.println (name + " born in " + year + " would be " + newName + " if she was born in " + newYear);


    }

    /**
     * Write the method yearOfHighestRank that has two parameters: a string name, and a string named gender (F for female and M for male).
     * This method selects a range of files to process and returns an integer, the year with the highest rank for the name and gender.
     * If the name and gender are not in any of the selected files, it should return -1.
     * For example, calling yearOfHighestRank with name Mason and gender ‘M’ and selecting the three test files above results in returning the year 2012.
     * That is because Mason was ranked the  2nd most popular name in 2012, ranked 4th in 2013 and ranked 3rd in 2014. His highest ranking was in 2012.
     */

    public String yearFromFile(File f) {

        String stringYear = f.getName ();
        int startIndex = stringYear.indexOf ("yob") + 3;
        int endIndex = stringYear.indexOf (".csv");

        return stringYear.substring (startIndex, endIndex);
    }

    public int yearOfHighestRank(String name, String gender) {

        DirectoryResource dr = new DirectoryResource ();
        int year = -1;
        int highestRanking = -1;

        for (File f : dr.selectedFiles ()) {

            String stringYear = yearFromFile (f);
            int currentYear = Integer.parseInt (stringYear);
            int currentRanking = getRank (currentYear, name, gender);

            if (currentRanking == -1) {
                continue;
            }

            if (highestRanking == -1 || currentRanking < highestRanking) {
                highestRanking = currentRanking;
                year = currentYear;
            }
        }

        return year;
    }


    /**
     * Write the method getAverageRank that has two parameters: a string name,
     * and a string named gender (F for female and M for male).
     * This method selects a range of files to process and returns a double representing the average rank of the name and
     * gender over the selected files. It should return -1.0 if the name is not ranked in any of the selected files.
     * For example calling getAverageRank with name Mason and gender ‘M’ and selecting the three test files
     * above results in returning 3.0, as he is rank 2 in the year 2012, rank 4 in 2013 and rank 3 in 2014.
     * As another example,
     * calling   getAverageRank with name Jacob and gender ‘M’ and selecting the three test files above results in returning 2.66.
     */

    public double getAverageRank(String name, String gender) {

        DirectoryResource dr = new DirectoryResource ();
        double average = 0.0;
        int counter = 0;
        int total = 0;

        for (File f : dr.selectedFiles ()) {

            String stringYear = yearFromFile (f);
            int currentYear = Integer.parseInt (stringYear);
            int currentRanking = getRank (currentYear, name, gender);
            if (currentRanking == -1) {
                return -1.0;
            } else {
                counter++;
                total += currentRanking;
            }

        }

        average = (double) total / counter;

        return average;
    }


    /**
     * Write the method getTotalBirthsRankedHigher that has three parameters: an integer named year,
     * a string named name, and a string named gender (F for female and M for male).
     * This method returns an integer, the total number of births of those names with
     * the same gender and same year who are ranked higher than name. For example,
     * if getTotalBirthsRankedHigher accesses the "yob2012short.csv" file with name set to “Ethan”,
     * gender set to “M”, and year set to 2012,
     * then this method should return 15, since Jacob has 8 births and Mason has 7 births,
     * and those are the only two ranked higher than Ethan.
     */
//TODO in some cases the first place is not getting added to the total
    public Map<String, Integer> getRankMap(int year, String gender) {
        FileResource fr = new FileResource("C:\\Users\\SebastianTamayoPache\\Desktop\\selbsstudy\\BabyName\\us_babynames (1)\\us_babynames_by_year\\yob" + year + ".csv");
        HashMap<String, Integer> rankMap = new HashMap<> ();
        int rank = 0;

        for (CSVRecord record : fr.getCSVParser(false)) {
            if (record.get(1).equals(gender)) {
                rank++;
                String name = record.get(0);
                rankMap.put(name, rank);
            }
        }

        return rankMap;
    }

    public int getTotalBirthsRankedHigher(int year, String name, String gender) {
        FileResource fr = new FileResource ("C:\\Users\\SebastianTamayoPache\\Desktop\\selbsstudy\\BabyName\\us_babynames (1)\\us_babynames_by_year\\yob" + year + ".csv");
        int rank = getRankMap(year, gender).getOrDefault(name, -1);
        int total = 0;
        CSVParser parser = fr.getCSVParser ();

        for (CSVRecord current : parser) {
            if (current.get(1).equals(gender) && getRankMap(year, gender).getOrDefault(current.get(0), -1) < rank) {
                total += Integer.parseInt(current.get(2));
            }
        }

        return total;
    }


}
