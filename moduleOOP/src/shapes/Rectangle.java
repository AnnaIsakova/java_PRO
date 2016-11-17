package shapes;

/**
 * Created by Ootka on 18-Nov-16.
 */
public class Rectangle extends Shape{
    private double height;
    private double width;

    Rectangle(double height, double width){
        super("Прямоугольник");
        this.height = height;
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    @Override
    protected void setSquare() {
        square = this.height * this.width;
    }
}
