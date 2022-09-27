import java.util.Scanner;

public class HW3_13 {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        try {
	        Car CarApplication1 = new Car("A", "2", 10000);
	        Car CarApplication2 = new Car();
	        String[] carFeature = {"Model", "Year", "Price"};
	        String[] second_car_datas = new String[3];
	        double second_price;
	
	        for (int i = 0; i < 3; i++) {
	            System.out.print("Enter the " + carFeature[i] + ": ");
	            second_car_datas[i] = input.nextLine();
	        }
	        System.out.print("\n");
	        second_price = Double.parseDouble(second_car_datas[2]);
	
	        CarApplication2.setModel(second_car_datas[0]);
	        CarApplication2.setYear(second_car_datas[1]);
	        CarApplication2.setPrice(second_price);
	        System.out.printf("The first car:\nModel: %s\nYear: %s\nPirce: %.2f\n", CarApplication1.getModel(), CarApplication1.getYear(), CarApplication1.getPrice());
	        System.out.printf("The second car:\nModel: %s\nYear: %s\nPirce: %.2f\n", CarApplication2.getModel(), CarApplication2.getYear(), CarApplication2.getPrice());
	        System.out.printf("After the change:\n\n");
	        System.out.printf("The first car:\nModel: %s\nYear: %s\nPirce(5%% off): %.2f\n", CarApplication1.getModel(), CarApplication1.getYear(), CarApplication1.getPrice()*0.95);
	        System.out.printf("The second car:\nModel: %s\nYear: %s\nPirce(7%% off): %.2f\n", CarApplication2.getModel(), CarApplication2.getYear(), CarApplication2.getPrice()*0.93);
        }
        finally {
        	input.close();
        }
    }
}