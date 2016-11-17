package shapes;

import java.util.Arrays;

/**
 * Created by Ootka on 18-Nov-16.
 */

//Построить иерархию классов «Фигуры» с учетом знаний о
//полиморфизме. У каждого класса фигуры должен быть
//метод подсчета площади. Создать список фигур. Вывести
//площади всех фигур на экран.
public class Main {
    public static void main(String[] args) {
        Shape circle = new Circle(4);
        Shape square = new Square(4);
        Shape rectangle = new Rectangle(5, 6);

        ShapeList list = new ShapeList();
        list.addShape(circle);
        list.addShape(square);
        list.addShape(rectangle);
        list.addShape(rectangle);
        list.addShape(rectangle);
        list.addShape(rectangle);
        list.addShape(rectangle);


        for (int i = 0; i < list.length; i++) {
            System.out.println("----------------------------------");
            System.out.println(list.getShape(i).getName() + " -> " + list.getShape(i).getSquare());
            if (list.getShape(i) instanceof Circle){
                System.out.println("Радиус = " + ((Circle) list.getShape(i)).getRadius());
            } else if (list.getShape(i) instanceof Square){
                System.out.println("Сторона = " + ((Square) list.getShape(i)).getSide());
            } else if (list.getShape(i) instanceof Rectangle){
                System.out.println("Высота = " + ((Rectangle) list.getShape(i)).getHeight() + "; ширина = " + ((Rectangle) list.getShape(i)).getWidth());
            }
        }
    }
}
