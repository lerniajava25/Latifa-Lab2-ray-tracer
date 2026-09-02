package org.example.shapes;
import org.example.math.Ray;

public class Triangle implements Shape {

   @Override
    public Hit hit(Ray ray) {
        return new Hit(false);
    }
}
