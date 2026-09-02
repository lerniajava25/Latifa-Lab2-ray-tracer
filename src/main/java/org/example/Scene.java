package org.example;
import org.example.math.Ray;
import org.example.shapes.Shape;
import java.util.ArrayList;
import java.util.List;


public class Scene {
    private final List<Shape> shapes = new ArrayList<>();

    public void addShape(Shape shape) {
        shapes.add(shape);
    }
    public List<Shape> getShapes() {
        return List.copyOf(shapes);
    }
    public boolean hit(Ray ray) {
        for (Shape shape : shapes) {
            var hit = shape.hit(ray);
            if (hit.hit()) {
                return true;
            }
        }
        return false;

    }
}
