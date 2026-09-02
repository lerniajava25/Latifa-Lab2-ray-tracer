package org.example.shapes;
import org.example.math.Ray;
import org.example.math.Vector3;

public class Sphere implements Shape {
    private Vector3 center;
    private double radius;

    public Sphere(Vector3 center, double radius) {
        this.center = center;
        this.radius = radius;
    }


//Att testa med en ray som ska träffa.
//Att testa med en ray som inte ska träffa.

    //Att implementera träfflogiken i Sphere.hit()

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
          return new Hit(false);
      }
      //Att räkna ut var på rayen skärningspunkterna ligger
      var sqrtDiscriminant = Math.sqrt(discriminant);
      var t0 = (-b - sqrtDiscriminant) / (2 * a);
      var t1 = (-b + sqrtDiscriminant) / (2 * a);
      //Kontroll av om träffen ligger bakom rayen
      return new Hit(t0 >= 0 || t1 >= 0);
  }

  }
