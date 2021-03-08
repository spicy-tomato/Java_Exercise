package period_3;

import java.util.ArrayList;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) {
        ArrayList<Shape> list = new ArrayList<>();

        list.add(new Point(1, 2));
        list.add(new Circle(3, 4, 5));
        list.add(new Line(1, -1, 0));
        list.add(new Rectangle(-1, -2, 3, 5));

        System.out.println("Danh sách các hình vừa nhập:");
        for (var item : list){
            System.out.println(item);
        }

        ///////////////////////////////////////////////

        double sumArea = 0;
        for (var item : list){
            sumArea += item.area();
        }
        System.out.println("\nTổng diện tích các hình là: " + sumArea);

        ///////////////////////////////////////////////

        double sumPerimeter = 0;
        for (var item : list){
            sumPerimeter += item.perimeter();
        }
        System.out.println("Tổng chu vi các hình là: " + sumPerimeter);

        ///////////////////////////////////////////////

        list.sort(Comparator.comparingDouble(Shape::area));

        System.out.println("\nHình có diện tích nhỏ nhất là: " + list.get(0));

        ///////////////////////////////////////////////

        list.sort(Comparator.comparingDouble(Shape::perimeter));

        System.out.println("Hình có chu vi nhỏ nhất là: " + list.get(0));

        ///////////////////////////////////////////////

        double ratio = 2;

        for (var item : list){
            item.zoom(ratio);
        }

        System.out.println("\nSau khi phóng to tất cả các hình với tỉ lệ "+ ratio);

        for (var item : list){
            System.out.println(item);
        }
    }
}
