package shapes;

/**
 * Created by Ootka on 18-Nov-16.
 */
public class Circle extends Shape {
    private double radius;

    Circle(double radius){
        super("Круг");
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    protected void setSquare() {
        square = Math.PI * Math.pow(this.radius, 2);
    }
}
