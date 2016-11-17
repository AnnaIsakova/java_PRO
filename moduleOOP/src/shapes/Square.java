package shapes;

/**
 * Created by Ootka on 18-Nov-16.
 */
public class Square extends Shape{
    private double side;

    Square(double side){
        super("Квадрат");
        this.side = side;
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    @Override
    public void setSquare() {
        square = this.side * this.side;
    }
}
