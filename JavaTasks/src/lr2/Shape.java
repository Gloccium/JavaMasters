package lr2;

abstract class Shape {
    public abstract double calculateArea();
    public abstract double calculatePerimeter();
}

class CircleClass extends Shape {
    private double radius;

    public CircleClass(double radius) {
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }

    public double getRadius() {
        return radius;
    }
}

class SquareClass extends Shape {
    private double side;

    public SquareClass(double side) {
        this.side = side;
    }

    @Override
    public double calculateArea() {
        return side * side;
    }

    @Override
    public double calculatePerimeter() {
        return 4 * side;
    }

    public double getSide() {
        return side;
    }
}

class TriangleClass extends Shape {
    private double sideA;
    private double sideB;
    private double sideC;

    public TriangleClass(double sideA, double sideB, double sideC) {
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    @Override
    public double calculateArea() {
        double s = (sideA + sideB + sideC) / 2;
        return Math.sqrt(s * (s - sideA) * (s - sideB) * (s - sideC));
    }

    @Override
    public double calculatePerimeter() {
        return sideA + sideB + sideC;
    }

    public double getSideA() {
        return sideA;
    }

    public double getSideB() {
        return sideB;
    }

    public double getSideC() {
        return sideC;
    }

    public static void main(String[] args) {
        CircleClass circle = new CircleClass(5);
        System.out.println("Круг:");
        System.out.println("Площадь: " + circle.calculateArea());
        System.out.println("Периметр: " + circle.calculatePerimeter());

        SquareClass square = new SquareClass(4);
        System.out.println("Квадрат:");
        System.out.println("Площадь: " + square.calculateArea());
        System.out.println("Периметр: " + square.calculatePerimeter());

        TriangleClass triangle = new TriangleClass(3, 4, 5);
        System.out.println("Треугольник:");
        System.out.println("Площадь: " + triangle.calculateArea());
        System.out.println("Периметр: " + triangle.calculatePerimeter());
    }
}
