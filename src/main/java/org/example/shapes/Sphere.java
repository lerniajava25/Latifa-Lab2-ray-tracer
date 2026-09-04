package org.example.shapes;
import org.example.math.Ray;
import org.example.math.Vector3;
import org.example.Color;

public class Sphere implements Shape {
    private Vector3 center;
    private double radius;
    private final Color color;

    public Sphere(Vector3 center, double radius, Color color) {
        this.center = center;
        this.radius = radius;
        this.color = color;
    }

    @Override
    public Color color() {
        return color;
    }

  @Override
  public Hit hit(Ray ray) {
      //Var ligger rayens startpunkt i förhållande till sfärens center
      var oc = ray.origin().subtract(center);
      // Beräknar om rayen skär sfären
      // a = rayens riktning
      var a = ray.direction().dot(ray.direction());
      var b = 2.0 * oc.dot(ray.direction());
      var c = oc.dot(oc) - radius * radius;

      // Diskriminanten avgör om rayen träffar sfären
      var discriminant = b * b - 4 * a * c;
      // Ingen giltig ray riktning eller ingen skärning
      if (a == 0.0 || discriminant < 0) {
          return new Hit(false, Double.POSITIVE_INFINITY);
      }
      //Att räkna ut var på rayen skärningspunkterna ligger
      var sqrtDiscriminant = Math.sqrt(discriminant);
      var t0 = (-b - sqrtDiscriminant) / (2 * a);
      var t1 = (-b + sqrtDiscriminant) / (2 * a);
      // Väljer den närmaste giltiga träffen framför rayens startpunkt
      var t = Math.min(t0, t1);

      if (t < 0) {
          t = Math.max(t0, t1);
      }

      if (t < 0) {
          return new Hit(false, Double.POSITIVE_INFINITY);
      }

      return new Hit(true, t);
  }

  }
