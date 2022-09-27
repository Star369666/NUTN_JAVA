import java.util.*;

public class HW4_19 {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		double[] value = {239.99, 129.75, 99.95, 350.89};
		int i, item_number = 4;
		int[] item_sold = new int[item_number];
		double calculator, total = 200.0;
		
		try {
			for(i = 0; i < item_number; i++) {
				System.out.printf("Enter the %dth items's quantity: ", (i+1));
				item_sold[i] = input.nextInt();
				while(item_sold[i] < 0) {
					System.out.printf("The quantity can't lower than zero, enter it again: ");
					item_sold[i] = input.nextInt();
				}
				calculator = item_sold[i]*value[i];
				System.out.printf("Item%d: %d are sold, which has %.2f unit value. Receiving %.2f unit value.\n", (i+1), item_sold[i], calculator, 0.09*calculator);
				total += calculator*0.09;
			}
			System.out.printf("The total value given to the salesperson for last week earning is %.2f.\n", total);
		}
		finally {
			input.close();
		}
	}
}
