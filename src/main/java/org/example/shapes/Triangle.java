package org.example.shapes;
import org.example.math.Ray;
import org.example.math.Vector3;
import org.example.Color;

public class Triangle implements Shape {
    private final Vector3 p1;
    private final Vector3 p2;
    private final Vector3 p3;
    private final Color color;

    public Triangle(Vector3 p1, Vector3 p2, Vector3 p3, Color color) {
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        this.color = color;
    }

    @Override
    public Color color() {
        return color;
    }

    @Override
    public Hit hit(Ray ray) {
        // Att skapa två vecktore från punkt p1
        var edge1 = p2.subtract(p1);
        var edge2 = p3.subtract(p1);
        // Vektor vinkelrät mot rayens riktning och edge2==> fås med av h(help variablen)
        var h = ray.direction().crossProduct(edge2);

        // Kontrollerar om rayen är parallell med triangelns plan
        var a = edge1.dot(h);

        var epsilon = 0.0000001;
        // Om a är nära 0 är rayen parallell och träffar inte triangeln
        if (Math.abs(a) < epsilon) {
            return new Hit(false);
        }
        var f = 1.0 / a;

        // Vektor från p1 till rayens startpunkt
        var s = ray.origin().subtract(p1);

        // Kontrollerar var träffen ligger längs triangelns ena sida
        var u = f * s.dot(h);

        if (u < 0.0 || u > 1.0) {
            return new Hit(false);
        }

        // Att kontrollera den andra riktningen inne i triangeln med ett värde v
        var q = s.crossProduct(edge1);

        var v = f * ray.direction().dot(q);

        if (v < 0.0 || u + v > 1.0) {
            return new Hit(false);
        }

        // Beräknar hur långt framför rayens startpunkt träffen ligger
        var t = f * edge2.dot(q);

        if (t < epsilon) {
            return new Hit(false);
        }

        return new Hit(true);
    }
}
