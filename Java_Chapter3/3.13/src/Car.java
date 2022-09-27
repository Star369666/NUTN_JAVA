public class Car {
    private String model;
    private String year;
    private double price;
    
    public Car() {}
    
    public Car(String model, String year, double price) {
        this.model = model;
        this.year = year;
        
        if(price > 0) {
            this.price = price;
        }
    }
    
    public void setModel(String model) {
        this.model = model;
    }
    
    public void setYear(String year) {
        this.year = year;
    }
    
    public void setPrice(double price) {
        if(price > 0) {
            this.price = price;
        }
    }
    
    public double getPrice() {
        return price;
    }
    
    public String getYear() {
        return year;
    }
    
    public String getModel() {
        return model;
    }
}