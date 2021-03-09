package period_4;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<ComplexNumber> list = new ArrayList<>();

        list.add(new ComplexNumber());
        list.add(new ComplexNumber(1, 2));
        list.add(new ComplexNumber(3, -4));
        list.add(new ComplexNumber(0, 3));
        list.add(new ComplexNumber(-1, 0));

        System.out.println("\nDãy số phức");
        for (var item : list) {
            System.out.print(item + "     ");
        }
        System.out.println();

        ///////////////////////////////////////////////

        ComplexNumber sum = new ComplexNumber(0, 0);

        for (var item : list) {
            sum = sum.add(item);
        }

        ComplexNumber avg = sum.divide(list.size());

        System.out.println("\nTrung bình cộng các số phức là: " + avg);

        ///////////////////////////////////////////////

        list.sort((ComplexNumber n1, ComplexNumber n2) ->
                Double.compare(n1.module(), n2.module())
        );

        System.out.println("\nSố phức có module lớn nhất là: " + list.get(list.size() - 1));

        ///////////////////////////////////////////////

        int count = 0;
        for (var item : list) {
            if (item.isRealNumber()) {
                count++;
            }
        }

        System.out.printf("\nDãy số có %d số thực\n", count);
    }
}
