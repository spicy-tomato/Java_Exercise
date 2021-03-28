package period_5;

import java.util.Scanner;

public class MainE2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a string: ");
        String str = sc.nextLine();

        int num;

        try {
            num = countNumber(str);
            System.out.printf("true, %d number(s)", num);

        } catch (NumberFormatException e){
            System.out.println("false");
        }
    }

    public static int countNumber(String str) throws NumberFormatException {
        str = str.trim();
        while (str.contains("  ")) {
            str = str.replace("  ", " ");
        }

        int res = 0;

        String[] stringList = str.split(" ");
        for (var s : stringList) {
            double d = Double.parseDouble(s);
            res++;
        }

        return res;
    }
}
