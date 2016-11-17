package shapes;

/**
 * Created by Ootka on 18-Nov-16.
 */
public abstract class Shape {

    private String name;
    protected double square;

    Shape(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    protected abstract void setSquare();

    public double getSquare(){
        setSquare();
        return square;
    }
}
