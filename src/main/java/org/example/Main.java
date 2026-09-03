import org.example.Scene;
import org.example.math.Ray;
import org.example.math.Vector3;
import org.example.shapes.Sphere;
import org.example.shapes.Triangle;


void main() {

    //================================Scene================================
    var scene = new Scene();

    //=====================Bildinställningar=====================
    //Pixel storlek
    var imageWidth = 40;
    var imageHeight = 20;

    // Kamera, viewport och position
    var viewportWidth = 4.0;
    var viewportHeight = 2.0;
    var cameraPosition = new Vector3(0, 0, 0);
    //Avståndet från kameran till viewporten
    var focalLength = 1.0;

//================================Sphere=================================
    // Exempel på sphere
    var sphere = new Sphere(
            new Vector3(0, 0, 5),
            1
    );

    scene.addShape(sphere);

    // Första ray/första test => Ray rakt mot sfären=>True
    var ray1 = new Ray(
            new Vector3(0, 0, 0),  // origin
            new Vector3(0, 0, 1)   // direction
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

    // Fjärde test: Sfären ligger bakom rayen => false
    var ray4 = new Ray(
            new Vector3(0, 0, 10),  // origin
            new Vector3(0, 0, 1)    // direction
    );

//==============================Triangle=================================
    // Exempel på Triangel
    var triangle = new Triangle(
            new Vector3(0, 1, 5),    // p1
            new Vector3(-1, -1, 5),  // p2
            new Vector3(1, -1, 5)    // p3
    );
    scene.addShape(triangle);
    // Triangle test 1: Ray träffar triangeln => true
    var triangleRay1 = new Ray(
            new Vector3(0, 0, 0),
            new Vector3(0, 0, 1)
    );

    // Triangle test 2: Ray missar triangeln => false
    var triangleRay2 = new Ray(
            new Vector3(0, 0, 0),
            new Vector3(2, 0, 1)
    );

    // Triangle test 3: Triangeln ligger bakom rayen => false
    var triangleRay3 = new Ray(
            new Vector3(0, 0, 10),
            new Vector3(0, 0, 1)
    );


   //=============================Loop genom bildens pixlar/Rendering logic=================================
    for (int y = 0; y < imageHeight; y++) {
        for (int x = 0; x < imageWidth; x++) {
            // Varje pixel får sin egen (x, y)-koordinat, viewport-position och riktning, och därefter skapas en ray
            // Omvandlar pixelkoordinaterna x och y till värden mellan 0.0 och 1.0
            var u = (double) x / (imageWidth - 1);
            var v = (double) y / (imageHeight - 1);

            // Omvandlar u till x-koordinat i viewporten
            var viewportX = (u - 0.5) * viewportWidth;
            var viewportY = (0.5 - v) * viewportHeight;

            //Att skapa ray riktningen från kameran genom pixelns punkt
            var direction = new Vector3(
                    viewportX,
                    viewportY,
                    focalLength // viewportens position framför kameran i z-led
                    ).normalize();

            // Att skapar en ray från kameran mot pixeln
            var ray = new Ray(cameraPosition, direction);
            // Att kontrollerar om pixelns ray träffar något objekt i scenen
            var isHit = scene.hit(ray);

        }
    }
    //=============================Utskrivt_Sphere=================================
    IO.println("Test 1: " + sphere.hit(ray1));
    IO.println("Test 2: " + sphere.hit(ray2));
    IO.println("Test 3: " + sphere.hit(ray3));
    IO.println("Test 4: " + sphere.hit(ray4));

//=============================Utskrivt_Triangle=================================
    IO.println("Triangle test 1: " + triangle.hit(triangleRay1));
    IO.println("Triangle test 2: " + triangle.hit(triangleRay2));
    IO.println("Triangle test 3: " + triangle.hit(triangleRay3));

    //=============================Scene test=================================
    IO.println("Scene test: " + scene.hit(ray1));
}
