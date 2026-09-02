package org.example;

import org.example.shapes.Shape;

import java.util.ArrayList;
import java.util.List;

public class Scene {

    private final List<Shape> shapes = new ArrayList<>();

    public void addShape(Shape shape) {
        shapes.add(shape);
    }

    public List<Shape> getShapes() {
        return shapes;
    }
}
