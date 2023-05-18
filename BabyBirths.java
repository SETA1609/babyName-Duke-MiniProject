import edu.duke.FileResource;
import org.apache.commons.csv.*;


public class BabyBirths {

    public void printNames(){
        FileResource fr = new FileResource ();

        for (CSVRecord record: fr.getCSVParser (false)) {

            int numberOfBabies= Integer.parseInt (record.get (2));
            if (numberOfBabies>=100){
                System.out.println ("Name:"+ record.get (0)+
                        " Gender: "+record.get (1)+
                        " Num Born: "+ numberOfBabies
                );
            }

        }
    }

    public void totalBirth(FileResource fr){

        int total=0;

        for (CSVRecord record: fr.getCSVParser (false)) {

            int numberOfBabies= Integer.parseInt (record.get (2));

            total+=numberOfBabies;

        }

        System.out.println ("Total babies born: "+total);

    }

    public void testTotalBirths(){

        FileResource fr = new FileResource ();

        totalBirth (fr);

    }

}
