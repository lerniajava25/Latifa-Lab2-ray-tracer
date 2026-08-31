package org.example;

import java.util.ArrayList;
import java.util.List;

public class Scene {

    List<Shape> shapes = new ArrayList<>();

    public Scene (){
        shapes.add(new Sphere());
        shapes.add(new Sphere());
    }
}
