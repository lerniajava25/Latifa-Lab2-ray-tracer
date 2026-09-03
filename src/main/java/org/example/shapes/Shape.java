package org.example.shapes;

import org.example.math.Ray;
import org.example.Color;

public interface Shape {
    Hit hit(Ray ray);
    Color color();

    record Hit(boolean hit) {
    }



}
