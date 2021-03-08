package period_1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        ArrayList<Fraction> list = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            int numerator = randomInt();
            int denominator = 0;
            while (denominator == 0){
                denominator = randomInt();
            }

            list.add(new Fraction(numerator, denominator).reduce());
        }

        //////////////////////////////////////

        System.out.println("Danh sách các phân số:");
        printList(list);

        Collections.sort(list);
        printList(list);
        System.out.println();

        //////////////////////////////////////

        Fraction sum = new Fraction(0, 1);
        for (var item : list){
            sum = sum.add(item);
        }

        System.out.println("Tổng các phân số là: " + sum);

        //////////////////////////////////////

        int countNotInteger = 0;
        for (var item : list){
            if (!item.isInteger()){
                countNotInteger++;
            }
        }

        System.out.println("Số các phân số không phải số nguyên là: " + countNotInteger);
    }

    public static int randomInt(){
        Random generator = new Random(System.nanoTime());
        return generator.nextInt()%51;
    }

    public static void printList(ArrayList<Fraction> list){
        for (var item : list){
            System.out.print(item + "\t");
        }
        System.out.println();
    }
}
