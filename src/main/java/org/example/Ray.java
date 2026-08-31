package org.example;

public class Ray {
    private Vector3D start;
    private Vector3D direction;

    //Konstruktor
    public Ray(Vector3D start, Vector3D direction) {
        this.start = start;
        this.direction = direction.normalize();
    }

    public Vector3D getStart() {
        return start;
    }

    public Vector3D getDirection() {
        return direction;
    }

   }
