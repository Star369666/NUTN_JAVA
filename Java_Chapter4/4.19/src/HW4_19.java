import java.util.Random;

public class HW4_19 {
	public static void main(String args[]) {
		double[] value = {239.99, 129.75, 99.95, 350.89};
		Random random = new Random();
		int[] item_sold = new int[4];
		int i;
		double calculator, total = 200.0;
		
		for(i = 0; i < value.length; i++) {
			item_sold[i] = Math.abs(random.nextInt());
			calculator = item_sold[i]*value[i];
			System.out.print("Item1: " + item_sold[i] + " ,which has " + calculator + " unit value. Receiving " + 0.09*calculator + " unit value.\n");
			total += calculator*0.09;
		}
		System.out.print("The total value given to the salesperson for last week earning is " + total + ".\n");
		
	}
}
