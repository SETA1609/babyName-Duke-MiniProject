import java.util.Comparator;

public class BirthComparator implements Comparator<Baby> {
    @Override
    public int compare(Baby o1, Baby o2) {
        return o1.getNumberOfBirths ()-o2.getNumberOfBirths ();
    }
}
