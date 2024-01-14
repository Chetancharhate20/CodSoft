package internship;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GradeCalculatorBufferedReader {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Enter the number of subjects: ");
        int numberOfSubjects = Integer.parseInt(reader.readLine());
        int totalMarks = 0;
        for (int i = 1; i <= numberOfSubjects; i++) {
            System.out.print("Enter marks for Subject " + i + " (out of 100): ");
            int subjectMarks = Integer.parseInt(reader.readLine());


            if (subjectMarks < 0 || subjectMarks > 100) {
                System.out.println("Invalid marks. Marks should be between 0 and 100.");
                i--; // Retry for the same subject
                continue;
            }

            totalMarks += subjectMarks;
        }


        double averagePercentage = (double) totalMarks / numberOfSubjects;

        // we are assigning grade here to student
        char grade = calculateGrade(averagePercentage);

        // Display Results: Show the total marks, average percentage, and the corresponding grade to the user
        System.out.println("\nResults:");
        System.out.println("Total Marks: " + totalMarks);
        System.out.printf("Average Percentage: %.2f%%\n", averagePercentage);
        System.out.println("Grade: " + grade);

        reader.close();
    }

    // Grade are calculating here.
    private static char calculateGrade(double averagePercentage) {
        if (averagePercentage >= 90) {
            return 'A';
        } else if (averagePercentage >= 80) {
            return 'B';
        } else if (averagePercentage >= 70) {
            return 'C';
        } else if (averagePercentage >= 60) {
            return 'D';
        } else {
            return 'F';
        }
    }
}

