import java.security.*;

public abstract class Drug {
    private String size;

    Drug() { 
        randomSize();
    }

    Drug(String size) {
        this.size = size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getSize() {
        return this.size;
    }

    public void randomSize() {
        SecureRandom random = new SecureRandom();
        int number = random.nextInt(10);

        if(number < 1) {
            setSize("Large");
        }
        else if(0 < number && number < 3) {
            setSize("Medium");
        }
        else if(2 < number && number < 7) {
            setSize("Small");
        }
        else{
            setSize("None");
        }
    }
}