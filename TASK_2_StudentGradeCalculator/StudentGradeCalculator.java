import java.util.Scanner;
public class StudentGradeCalculator{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of subjects: ");
        int Subjects_number = sc.nextInt();

        int tot_Marks = 0;
        int[] Marks = new int[Subjects_number];
        for (int i = 0; i < Subjects_number; i++) {
            System.out.printf("Enter the marks obtained (out of 100)in subject %d : ", i + 1);
            Marks[i] = sc.nextInt(); 
            tot_Marks += Marks[i];
        }
        double avg_Percentage = calc_Avg_Percentage(tot_Marks, Subjects_number);
        String grade = calc_Grade(avg_Percentage);
        System.out.printf("Total Marks: %d%n", tot_Marks);
        System.out.printf("Average Percentage: %.2f%%%n", avg_Percentage);
        System.out.printf("GRADE: %s%n", grade);

        sc.close();
    }

    private static double calc_Avg_Percentage(int tot_Marks, int Subjects_number) {
        return (double) tot_Marks / Subjects_number;
    }

    private static String calc_Grade(double avg_Percentage) {
        if (avg_Percentage >= 95) {
            return "A+";
        } else if (avg_Percentage >= 85) {
            return "A";
        } else if (avg_Percentage >= 75) {
            return "B+";
        } else if (avg_Percentage >= 65) {
            return "B";
		}else if (avg_Percentage >= 55) {
            return "C";
        } else {
            return "F";
        }
    }
}