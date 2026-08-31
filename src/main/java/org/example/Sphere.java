package org.example;

public class Sphere extends Shape {
    private Vector3D center;
    private double radius;

    public Sphere(Vector3D center, double radius) {
        this.center = center;
        this.radius = radius;
    }


    @Override
    double hit(Ray ray) {
        return 0;
    }


}
