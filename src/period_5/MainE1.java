package period_5;

import java.util.Random;
import java.util.Scanner;

public class MainE1 {

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Enter an integer number: ");
        long num;
        int n;

        try {
            num = getInput();
            n = parseInt(num);

            System.out.println("Value: " + getRandomInt(n));

        } catch (InvalidNumberException e) {
            System.out.println(e.getMessage());
        }
    }

    public static long getInput() throws InvalidNumberException {
        long num;

        String str = sc.next();

        try {
            num = Long.parseLong(str);
        } catch (NumberFormatException e) {
            throw new InvalidNumberException("Input is not an integer number");
        }

        return num;
    }

    public static int parseInt(long n) throws InvalidNumberException {
        try {
            return Math.toIntExact(n);
        } catch (ArithmeticException e) {
            throw new InvalidNumberException("Number is larger than int type limit value");
        }
    }

    public static int getRandomInt(int n){
        int k = 0;

        if (n <= 0){
            n = 1;
        }

        while (n-- > 0){
            Random rnd = new Random();
            k = rnd.nextInt();
        }

        return k;
    }
}
