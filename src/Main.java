import java.io.*;
import java.text.DecimalFormat;
import java.util.Arrays;
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
        BufferedWriter bufferedWriter;

        //Accept user input
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of courses you are offering:");
        courses = scanner.nextInt();

        scanner.nextLine();
        System.out.println("Enter your course credits (space out the values):");
        courseCredits = scanner.nextLine().split(" ");

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
                default -> System.out.println("Enter grade in capital letters");
            }
        }

        /*The numerator is calculated first
        * Then the denominator
        * They divide each other to produce the cgpa*/
        for (int i = 0; i < courses; i++) {
            creditTimesGrade += (Double.parseDouble(courseCredits[i]) * courseGradeValue[i]);
            totalCredit += Double.parseDouble(courseCredits[i]);
            cgpa = creditTimesGrade/totalCredit;
        }
        System.out.println();
        System.out.println("Your CGPA is :");
        //Cgpa formatted to 2 dp
        System.out.println(df2.format(cgpa));

        //Create a new file for the cgpa to hold the information
        try {
            File file = new File("cgpafile.txt");
            if (file.createNewFile()) {
                System.out.println("File created: " + file.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        //Check your User folder for the file
        try {
            String userHomeFolder = System.getProperty("user.home");
            File file = new File(userHomeFolder, "cgpafile.txt");
            bufferedWriter = new BufferedWriter(new FileWriter(file));
            bufferedWriter.write(Arrays.toString(courseCredits));
            bufferedWriter.newLine();
            bufferedWriter.write(Arrays.toString(courseGrade));
            bufferedWriter.newLine();
            bufferedWriter.write(String.valueOf(df2.format(cgpa)));
            bufferedWriter.close();
            System.out.println("Successfully wrote to the file");
        } catch (IOException e) {
            System.out.println("An error occurred");
            e.printStackTrace();
        }
    }
}
