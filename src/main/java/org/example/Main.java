import org.example.math.Vector3;
import org.example.shapes.Shape;
import org.example.shapes.Sphere;
import org.example.shapes.Triangle;

import java.util.ArrayList;
import java.util.List;

void main() {

    List<Shape> shapes = new ArrayList<>();

    shapes.add(new Sphere(
            new Vector3(0, 0, 5),
            1
    ));

    shapes.add(new Triangle());
}
