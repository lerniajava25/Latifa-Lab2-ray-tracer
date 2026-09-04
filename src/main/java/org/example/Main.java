import org.example.Scene;
import org.example.math.Ray;
import org.example.math.Vector3;
import org.example.shapes.Sphere;
import org.example.shapes.Triangle;
import org.example.Color;
import java.io.PrintWriter;

    void main() throws Exception {

    //================================Scene================================
    var scene = new Scene();

    //=====================Bildinställningar=====================
   // Bildens storlek i pixlar
    var imageWidth = 400;
    var imageHeight = 400;
    var aspectRatio = (double) imageWidth / imageHeight;

    // Kamera, viewport och position
    var viewportHeight = 2.0;
    var viewportWidth = viewportHeight * aspectRatio;
    var cameraPosition = new Vector3(0, 0, 0);
    //Avståndet från kameran till viewporten
    var focalLength = 1.0;

    //  ingen träff får svart färg
    var backgroundColor = new Color(0, 0, 0);

//================================Sphere=================================
    // Exempel på sphere
        var sphere = new Sphere(
                new Vector3(-0.6, 0, 5),
                1,
                new Color(255, 0, 0)
        );

    scene.addShape(sphere);

//==============================Triangle=================================
    // Exempel på Triangel
    var triangle = new Triangle(
            new Vector3(0.8, 1, 5),    // p1
            new Vector3(-0.2, -1, 5),  // p2
            new Vector3(1.8, -1, 5),   // p3
            new Color(0, 0, 255)
    );
    scene.addShape(triangle);

    //=============================ppm-fil===================================================
        var writer = new PrintWriter("image.ppm");
    writer.println("P3");
    writer.println(imageWidth + " " + imageHeight);
    writer.println("255");

   //=============================Rendering logic============================================
    for (int y = 0; y < imageHeight; y++) {
        for (int x = 0; x < imageWidth; x++) {
            // Varje pixel får sin egen (x, y)-koordinat, viewport-position och riktning, och därefter skapas en ray
            // Omvandlar pixelkoordinaterna x och y till värden mellan 0.0 och 1.0
            var u = (double) x / (imageWidth - 1);
            var v = (double) y / (imageHeight - 1);

            // Omvandlar u till x-koordinat i viewporten
            var viewportX = (u - 0.5) * viewportWidth;
            var viewportY = (0.5 - v) * viewportHeight;

            // Skapar ray-riktningen från kameran genom pixelns punkt
            var direction = new Vector3(
                    viewportX,
                    viewportY,
                    focalLength // viewportens position framför kameran i z-led
                    ).normalize();

            // Skapar en ray från kameran mot pixeln
            var ray = new Ray(cameraPosition, direction);
            // Kontrollerar om pixelns ray träffar något objekt i scenen
            var hitColor = scene.hit(ray);

            // Väljer pixelns färg beroende på om rayen träffar ett objekt
            var pixelColor = hitColor != null ? hitColor : backgroundColor;

            writer.println(
                    pixelColor.red() + " " +
                            pixelColor.green() + " " +
                            pixelColor.blue()
            );
        }
    }

        writer.close();
}
