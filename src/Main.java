import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        DecimalFormat df2 = new DecimalFormat("#.##");
        int courses;
        String[] courseCredits;
        String[] courseGrade;
        double cgpa = 0;
        double totalCredit = 0;
        double creditTimesGrade = 0;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of courses you are offering:");
        courses = scanner.nextInt();

        scanner.nextLine();
        System.out.println("Enter your course credits (space out the values):");
        courseCredits = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        System.out.println("Enter your grades matching the course credits (space out the letters):");
        courseGrade = scanner.nextLine().split(" ");

        int[] courseGradeValue = new int[courses];

        //Value for each grade
        for (int i = 0; i < courses; i++) {
            switch (courseGrade[i]) {
                case "A" -> courseGradeValue[i] = 5;
                case "B" -> courseGradeValue[i] = 4;
                case "C" -> courseGradeValue[i] = 3;
                case "D" -> courseGradeValue[i] = 2;
                case "E" -> courseGradeValue[i] = 1;
                case "F" -> courseGradeValue[i] = 0;
            }
        }

        for (int i = 0; i < courses; i++) {
            creditTimesGrade += (Double.parseDouble(courseCredits[i]) * courseGradeValue[i]);
            totalCredit += Double.parseDouble(courseCredits[i]);
            cgpa = creditTimesGrade/totalCredit;
        }
        System.out.println();
        System.out.println("Your CGPA is :");
        System.out.println(df2.format(cgpa));
    }
}
