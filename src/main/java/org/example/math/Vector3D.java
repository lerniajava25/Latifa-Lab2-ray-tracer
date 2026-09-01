package org.example.math;

public class Vector3D {
    private double x;
    private double y;
    private double z;

    //Konstruktor
    public Vector3D(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    public Vector3D add(Vector3D other) {
        return new Vector3D(
                this.x + other.x,
                this.y + other.y,
                this.z + other.z
        );
    }
    public Vector3D subtract(Vector3D other) {
        return new Vector3D(
                this.x - other.x,
                this.y - other.y,
                this.z - other.z
        );
    }
    public double dot(Vector3D other) {
        return this.x * other.x
                + this.y * other.y
                + this.z * other.z;
    }
    public double length() {
        return Math.sqrt(x * x + y * y + z * z);
    }
    public Vector3D normalize() {
        double length = length();

        return new Vector3D(
                x / length,
                y / length,
                z / length
        );
    }
}
