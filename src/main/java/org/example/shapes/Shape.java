package org.example.shapes;

import org.example.math.Ray;
import org.example.Color;

public interface Shape {
    Hit hit(Ray ray);
    Color color();

    // Hit innehåller även t, som anger avståndet längs rayen till träffen
    record Hit(boolean hit, double t) {
    }

}
