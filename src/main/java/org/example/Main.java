import org.example.Scene;
import org.example.math.Ray;
import org.example.math.Vector3;
import org.example.shapes.Sphere;


void main() {

       var scene = new Scene();

        // Exempel på sphere
        var sphere = new Sphere(
                new Vector3(0, 0, 5),
                1
        );
        scene.addShape(sphere);
        // Första ray/första test => Ray rakt mot sfären=>True
        var ray1 = new Ray(
                new Vector3(0, 0, 0),  // origin
                new Vector3(0, 0,  1)   // direction
        );

    // Andra test: Ray som missar sfären => false
    var ray2 = new Ray(
            new Vector3(0, 0, 0),  // origin
            new Vector3(0, 1, 0)   // direction
    );

    // Tredje test: Ray träffar/tangerar sfären => true
    var ray3 = new Ray(
            new Vector3(1, 0, 0),  // origin
            new Vector3(0, 0, 1)   // direction
    );
    IO.println("Test 1: " + sphere.hit(ray1));
    IO.println("Test 2: " + sphere.hit(ray2));
    IO.println("Test 3: " + sphere.hit(ray3));
    }
