package org.example;

import java.util.ArrayList;
import java.util.List;

public class Scene {

    List<Shape> shapes = new ArrayList<>();

    //Konstruktor
    public Scene (){

        shapes.add(new Sphere(
                new Vector3D(0, 0, 5),
                1
        ));
        shapes.add(new Triangle());
    }


}
