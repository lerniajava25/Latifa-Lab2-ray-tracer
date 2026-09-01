package org.example.math;

public class Ray {
    private Vector3 start;
    private Vector3 direction;

    //Konstruktor
    public Ray(Vector3 start, Vector3 direction) {
        this.start = start;
        this.direction = direction.normalize();
    }

    public Vector3 getStart() {
        return start;
    }

    public Vector3 getDirection() {
        return direction;
    }

   }
