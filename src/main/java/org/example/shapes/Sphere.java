package org.example.shapes;
import org.example.math.Ray;
import org.example.math.Vector3;

public class Sphere implements Shape {
    private Vector3 center;
    private double radius;

    public Sphere(Vector3 center, double radius) {
        this.center = center;
        this.radius = radius;
    }


    @Override
    public double hit(Ray ray) {
        return 0;
    }



}
