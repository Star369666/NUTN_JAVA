public class input {
    private String name;
    private double weight;
    private double height;
    private int age = 1;
    private int gender;

    input() {}

    input(String nam, double wei, double hei, int ag, int gen) {
        name = nam;
        weight = wei;
        height = hei;
        age = ag;
        gender = gen;
    }

    public void setName(String in) {
        name = in;
    }

    public void setWeight(double in) {
        weight = in;
    }

    public void setHeight(double in) {
        height = in;
    }

    public void setAge(int in) {
        age = in;
    }

    public void setGender(int in) {
        gender = in;
    }

    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }

    public double getHeight() {
        return height;
    }

    public int getAge() {
        return age;
    }

    public int getGender() {
        return gender;
    }
}