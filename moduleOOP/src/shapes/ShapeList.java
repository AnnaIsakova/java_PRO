package shapes;


/**
 * Created by Ootka on 18-Nov-16.
 */
public class ShapeList {
    protected Shape[] shapes = new Shape[5];
    protected int length = shapes.length;
    protected int p = 0;

    public void addShape(Shape shape){
        try {
            this.shapes[p++] = shape;
        } catch (IndexOutOfBoundsException e){
            System.out.println("List is just for 5 shapes.");
        }
    }

    public Shape getShape(int index){
        try {
            return shapes[index];
        } catch (IndexOutOfBoundsException e){
            System.out.println("No such index in the list.");
        }
        return null;
    }


}
