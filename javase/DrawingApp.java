public class DrawingApp {
    private Shape shape;

    public DrawingApp(Shape shape) {
        this.shape = shape;
    }

    public DrawingApp() {
        this.shape = null;
    }

    public Shape getShape(){
        return shape;
    }
    public void setShape(Shape shape){
        this.shape = shape;
    }

    public void drawShape(){
        shape.draw();
    }

    public static void main(String[] args) {
        factory factory = new factory();
        DrawingApp circle = new DrawingApp(factory.createShape("circle"));
        circle.drawShape();
    }
}
