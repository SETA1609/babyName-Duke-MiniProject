import edu.duke.FileResource;
import org.apache.commons.csv.*;


public class BabyBirths {

    public void printNames(){
        FileResource fr = new FileResource ();

        for (CSVRecord record: fr.getCSVParser (false)) {
            System.out.println ("Name:"+ record.get (0)+
                    " Gender: "+record.get (1)+
                    " Num Born: "+ record.get (2)
                    );
        }
    }
}
