import java.util.Scanner;

public class HW3_14 {
	public static void main(String args[]) {
    	Scanner input = new Scanner(System.in);
        String[] input_display = {"hour", "minute", "second"};
        int[] timePart = new int[3];
        int i;

        for (i = 0; i < 3; i++) {
            System.out.print("Enter the " + input_display[i] + ": ");
            timePart[i] = input.nextInt();
            if(i == 3-1) {
            	input.close();
            }
        }

        Clock time = new Clock(timePart[0], timePart[1], timePart[2]);
        System.out.print("\nThe time is ");
        time.displayTime();
        System.out.print("\n\n");
    }
}