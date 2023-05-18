public class Baby {

    String name="";
    int numberOfBirths=0;

    String gender="";

    public Baby(String name, int numberOfBirths, String gender) {
        this.name = name;
        this.numberOfBirths = numberOfBirths;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfBirths() {
        return numberOfBirths;
    }

    public void setNumberOfBirths(int numberOfBirths) {
        this.numberOfBirths = numberOfBirths;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
