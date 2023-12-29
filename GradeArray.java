
/**
 * Write a description of class GradeArray here.
 *
 * @Ahmed Al-qtaabi
 * @version 12/3/23
 */
import java.util.Scanner;

public class GradeArray {
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the grade average program.");
        System.out.println("Enter -1 after the last grade.");

        final int MAX_SIZE = 100;
        int[] grades = new int[MAX_SIZE];
        int gradeCount = 0;
        int inputGrade;
        
        // Input loop
        while (true) {
            System.out.print("Grade " + (gradeCount + 1) + ": ");
            inputGrade = scanner.nextInt();
            
            if (inputGrade < 0) {
                break;
            }
            
            grades[gradeCount] = inputGrade;
            gradeCount++;
        }
        
        // Calculate overall average
        double sum = 0;
        for (int i = 0; i < gradeCount; i++) {
            sum += grades[i];
        }
        double average = sum / gradeCount;
        
        // Calculate below average and above average averages
        int belowCount = 0;
        int aboveCount = 0;
        double belowSum = 0;
        double aboveSum = 0;
        
        for (int i = 0; i < gradeCount; i++) {
            if (grades[i] < average) {
                belowSum += grades[i];
                belowCount++;
            } else if (grades[i] > average) {
                aboveSum += grades[i];
                aboveCount++;
            }
        }
        
        double lowAverage = belowSum / belowCount;
        double highAverage = aboveSum / aboveCount;
        
        // Output results
        System.out.println(gradeCount + " grades.  Average Grade: " + average);
        System.out.println(belowCount + " below average grades. Low  Average: " + lowAverage);
        System.out.println(aboveCount + " above average grades. High Average: " + highAverage);
        System.out.println("High - Low: " + (highAverage - lowAverage));
        
        scanner.close();
    }
}