public class Cube2 {
    private Cube basicCube;
    private String color;

    // Three required constructors
    public Cube2() {
        this.basicCube = new Cube(1);
        this.color = "black";
    }

    public Cube2(int side) {
        this.basicCube = new Cube(side);
        this.color = "black";
    }

    public Cube2(int side, String color) {
        this.basicCube = new Cube(side);
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getSide() {
        return basicCube.getSide();
    }

    public void setSide(int side) {
        basicCube.setSide(side);
    }

    public int calculateSurfaceArea() {
        return basicCube.calculateSurfaceArea();
    }

    public int calculateVolume() {
        return basicCube.calculateVolume();
    }

    public boolean equals(Cube2 other) {
        if (other == null) return false;
        return this.getSide() == other.getSide() &&
                this.color.equals(other.color);
    }

    public String toString() {
        return "Cube{side=" + getSide() + ", color=\"" + getColor() + "\"}";
    }

    private boolean isPythagoreanTriple(int a, int b) {
        int pythagoras = a * a + b * b;
        int root = (int) Math.sqrt(pythagoras);
        return root * root == pythagoras;
    }

    private int calculateTotal(int side1, int side2) {
        int pythagoras = side1 * side1 + side2 * side2;
        return (int) Math.sqrt(pythagoras);
    }

    public Cube2 add(Cube2 other) {
        int side1 = this.getSide();
        int side2 = other.getSide();

        if (isPythagoreanTriple(side1, side2)) {
            int newSide = calculateTotal(side1, side2);
            return new Cube2(newSide, this.color);
        } else {
            throw new IllegalArgumentException(
                    "Side lengths " + side1 + " and " + side2 + " do not form a Pythagorean triple");
        }
    }

    public Cube2 minus(Cube2 other) {
        int side1 = this.getSide();
        int side2 = other.getSide();

        if (side1 <= side2) {
            throw new IllegalArgumentException(
                    "First cube must be larger than second cube for subtraction"
            );
        }

        int squareDifference = side1 * side1 - side2 * side2;
        if (squareDifference <= 0) {
            throw new IllegalArgumentException("Difference of squares must be positive");
        }

        int newSide = (int) Math.sqrt(squareDifference);
        if (newSide * newSide != squareDifference) {
            throw new IllegalArgumentException(
                    "Side lengths " + side1 + ", " + side2 + ", and " + newSide +
                            " do not form a Pythagorean triple"
            );
        }

        return new Cube2(newSide, this.color);
    }
}
