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
    public Color hit(Ray ray) {

        var closestT = Double.POSITIVE_INFINITY;
        Color closestColor = null;
        for (Shape shape : shapes) {
            var hit = shape.hit(ray);

            if (hit.hit() && hit.t() < closestT) {
                closestT = hit.t();
                closestColor = shape.color();
            }
        }
        return closestColor;
    }
}
