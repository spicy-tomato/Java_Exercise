package period_2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        ArrayList<Point> list2d = new ArrayList<>();
        ArrayList<Point> list3d = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            double x = randomInt();
            double y = randomInt();

            list2d.add(new Point2D(x, y));
        }

        list2d.add(new Point2D(-1, 1));
        list2d.add(new Point2D(1, -1));

        for (int i = 0; i < 3; i++) {
            double x = randomInt();
            double y = randomInt();
            double z = randomInt();

            list3d.add(new Point3D(x, y, z));
        }

        list3d.add(new Point3D(-1, 1, -2));
        list3d.add(new Point3D(1, -1, 2));

        System.out.println("Danh sách các điểm 2D:");
        printList(list2d);

        System.out.println("Danh sách các điểm 3D:");
        printList(list3d);

        ////////////////////////////////////////////

        double sum2d = 0;
        double sum3d = 0;

        for (int i = 1; i < list2d.size(); i++) {
            sum2d += list2d.get(i).distance(list2d.get(i - 1));
        }

        for (int i = 1; i < list2d.size(); i++) {
            sum3d += list3d.get(i).distance(list3d.get(i - 1));
        }

        System.out.printf("Tổng khoảng cách các điểm 2D: %.3f%n", sum2d);
        System.out.printf("Tổng khoảng cách các điểm 3D: %.3f%n", sum3d);

        ////////////////////////////////////////////

        HashMap<Point, Point> map2d = new HashMap<>();
        HashMap<Point, Point> map3d = new HashMap<>();

        for (Point item : list2d) {
            Point symmetry = item.getSymmetry();

            //  @formatter:off
            if (!map2d.containsKey(item) &&
                !map2d.containsValue(item) &&
                list2d.contains(symmetry)
            ) {
                //  @formatter:on
                map2d.put(item, symmetry);
            }

        }

        for (Point item : list3d) {
            Point symmetry = item.getSymmetry();

            // @formatter:off
            if (map2d.containsKey(item) &&
                !map3d.containsValue(item) &&
                list3d.contains(symmetry)
            ) {
                //  @formatter:on
                map3d.put(item, symmetry);
            }
        }

        if (!map2d.isEmpty()) {
            System.out.println("\nDanh sách cách điểm 2D đối xứng:");
            map2d.forEach((key, value) -> System.out.println("\t--> " + key + ", " + value));
        }

        if (!map3d.isEmpty()) {
            System.out.println("\nDanh sách cách điểm 3D đối xứng:");
            map3d.forEach((key, value) -> System.out.println("\t--> " + key + ", " + value));
        }
    }

    public static double randomInt() {
        Random generator = new Random(System.nanoTime());
        return generator.nextInt()%3;
    }

    public static void printList(ArrayList<Point> list) {
        for (var item : list) {
            System.out.println("\t" + item);
        }
        System.out.println();
    }
}
