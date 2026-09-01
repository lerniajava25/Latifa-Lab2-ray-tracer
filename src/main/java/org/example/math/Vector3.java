package org.example.math;
//Med record blir värdena är i praktiken oföränderliga (immutable) efter att objektet skapats
public record Vector3(double x, double y, double z) {


    public Vector3 add(Vector3 other) {
        return new Vector3(
                this.x + other.x,
                this.y + other.y,
                this.z + other.z
        );
    }
        public Vector3 subtract (Vector3 other){
            return new Vector3(
                    this.x - other.x,
                    this.y - other.y,
                    this.z - other.z
            );
        }
        public double dot (Vector3 other){
            return this.x * other.x
                    + this.y * other.y
                    + this.z * other.z;
        }

        public Vector3 crossProduct (Vector3 other){
            return new Vector3(
                    this.y * other.z - this.z * other.y,
                    this.z * other.x - this.x * other.z,
                    this.x * other.y - this.y * other.x
            );
        }
        public double length () {

            return Math.sqrt(x * x + y * y + z * z);
        }

        public Vector3 normalize () {
            double length = length();

            if (length == 0) {
                return new Vector3(0, 0, 0);
            }

            return new Vector3(
                    x / length,
                    y / length,
                    z / length
            );
        }
    }
