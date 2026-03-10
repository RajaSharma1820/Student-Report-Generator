// Student Report Generator

import java.util.Scanner;

public class StudentReportGenerator {

    // Method to calculate grade
    public static String getGrade(int marks) {
        if (marks >= 90) return "O";
        else if (marks >= 80) return "A+";
        else if (marks >= 70) return "A";
        else if (marks >= 60) return "B+";
        else if (marks >= 50) return "B";
        else return "F";
    }

    // Method to calculate grade point
    public static int getGradePoint(int marks) {
        if (marks >= 90) return 10;
        else if (marks >= 80) return 9;
        else if (marks >= 70) return 8;
        else if (marks >= 60) return 7;
        else if (marks >= 50) return 6;
        else return 0;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] subjects = {"Mathematics", "Java", "Emerging Tech", "HTML"};
        int[] marks = new int[4];

        System.out.println("===== STUDENT REPORT GENERATOR =====");

        // Student Details
        System.out.print("Enter Student Name: ");
        String name = sc.nextLine();

        int roll;
        do {
            System.out.print("Enter Roll Number: ");
            roll = sc.nextInt();
            if (roll < 1)
                System.out.println("Invalid Roll Number. Try again.");
        } while (roll < 1);

        int semester;
        do {
            System.out.print("Enter Semester (1-8): ");
            semester = sc.nextInt();
            if (semester < 1 || semester > 8)
                System.out.println("Invalid Semester. Enter between 1 and 8.");
        } while (semester < 1 || semester > 8);

        // Marks Input
        for (int i = 0; i < subjects.length; i++) {
            do {
                System.out.print("Enter marks in " + subjects[i] + ": ");
                marks[i] = sc.nextInt();
                if (marks[i] < 0 || marks[i] > 100)
                    System.out.println("Invalid Marks. Enter between 0 and 100.");
            } while (marks[i] < 0 || marks[i] > 100);
        }

        // Calculations
        int total = 0;
        int totalGradePoints = 0;
        int credit = 3;

        for (int i = 0; i < marks.length; i++) {
            total += marks[i];
            totalGradePoints += getGradePoint(marks[i]) * credit;
        }

        double percentage = total / 4.0;
        double sgpa = totalGradePoints / (double)(subjects.length * credit);

        // Report Output
        System.out.println("\n=========== STUDENT REPORT CARD ===========");
        System.out.println("Name      : " + name);
        System.out.println("Roll No   : " + roll);
        System.out.println("Semester  : " + semester);

        System.out.println("\n--------------------------------------------");
        System.out.println("Subject\t\tMarks\tGrade\tGrade Point");
        System.out.println("--------------------------------------------");

        for (int i = 0; i < subjects.length; i++) {
            System.out.println(subjects[i] + "\t" +
                    marks[i] + "\t" +
                    getGrade(marks[i]) + "\t" +
                    getGradePoint(marks[i]));
        }

        System.out.println("--------------------------------------------");
        System.out.println("Total Marks : " + total);
        System.out.println("Percentage  : " + percentage + "%");
        System.out.println("SGPA        : " + String.format("%.2f", sgpa));
        System.out.println("--------------------------------------------");

        sc.close();
    }
}