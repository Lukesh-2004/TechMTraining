package Week1.enumProgramDayChecker;

import java.util.Scanner;

public class DayChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a day of the week: ");
        String userInput = scanner.next();
        scanner.close();

        DaysOfWeek day = DaysOfWeek.valueOf(userInput);
        printDay(day);
    }
    //Switchcase to Check whether the given day is a holiday or not
    public static void printDay(DaysOfWeek day) {
        switch (day) {
            case SATURDAY:
            case SUNDAY:
                System.out.println(Print.HOLIDAY);
                break;
            default:
                System.out.println(Print.NOT_HOLIDAY);
                break;
        }
    }

}
