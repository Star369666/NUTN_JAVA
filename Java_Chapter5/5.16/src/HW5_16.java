import java.io.*;
import java.util.*;

public class HW5_16 {
	public static void main(String args[]) throws Exception {
		File file = new File("input.txt");
		Scanner input = new Scanner(file);
		try {
			int len = 5, i = 0, j;
			int[] bar_number = new int[len];
			
			while(input.hasNext() == true) {
				bar_number[i] = input.nextInt();
				i++;
			}
			for(i = 0; i < len; i++) {
				System.out.print("Line" + (i+1) + ": ");
				for(j = 0; j < bar_number[i]; j++) {
					System.out.print("*");
				}
				System.out.print("\n"); 
			}
		}
		finally {
			input.close();
		}
	}
}