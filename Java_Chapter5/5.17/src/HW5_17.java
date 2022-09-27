import java.util.Scanner;

public class HW5_17 {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		try {
			int len = 5, i;
			String[] name = new String[len];
			Character[] grade = new Character[len];
			int[] count = {0,0,0,0};
			Character[] grade_display = {'A', 'B', 'C', 'D'};
			for(i = 0; i < len; i++) {
				System.out.print("Enter the " + (i+1) + "th student's name and grade in order(Distinguishing them by using blank): ");
				name[i] = input.next();
				grade[i] = input.next().charAt(0);

				switch(grade[i]) {
					case 'A':
						count[0] += 1;
						break;
					case 'B':
						count[1] += 1;
						break;
					case 'C':
						count[2] += 1;
						break;
					case 'D':
						count[3] += 1;
						break;
				}
			}
			System.out.print("\nThe grade stastistics as following:\n");
			for(i = 0; i < 4; i++) {
				System.out.print(grade_display[i] + ": " + count[i] + "person(s).\n");
			}
			System.out.print("\n");
		}
		finally {
			input.close();
		}
	}
}
