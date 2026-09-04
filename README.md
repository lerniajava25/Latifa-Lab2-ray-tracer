

Ray Tracer 

En enkel ray tracer i Java som renderar geometriska former till en PPM-bild. 
Projektet innehåller för närvarande stöd för Sphere och Triangle.

Lägga till en ny Shape 

Följ dessa steg för att lägga till en ny geometrisk form:
1.	Skapa en ny klass i paketet ”org.example.shapes”.
2.	Låt klassen implementera Shape (t.ex. public class Dinshape implements Shape {})
3.	Implementera metoden hit(Ray ray), för att beräkna om och var en ray träffar formen.
4.	Implementera metoden color() för att ange formens färg.
5.	Skapa formen i Main Class och lägg till den i scenen med: 
scene.addShape(shape);
tex. För form ”Plane” skulle det kunna bli:  var plane = new Plane(...);		scene.addShape(plane);
