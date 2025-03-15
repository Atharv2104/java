import java.util.Scanner;

abstract class Shape {
    protected double dim1, dim2;

    public Shape(double dim1, double dim2) {
        this.dim1 = dim1;
        this.dim2 = dim2;
    }

    public abstract double area();
}

class Rectangle extends Shape {
    public Rectangle(double length, double width) {
        super(length, width);
    }

    @Override
    public double area() {
        return dim1 * dim2;
    }
}

class Triangle extends Shape {
    public Triangle(double base, double height) {
        super(base, height);
    }

    @Override
    public double area() {
        return 0.5 * dim1 * dim2;
    }
}

public class Abstract {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter dimensions for Rectangle:");
        System.out.print("Length: ");
        double length = scanner.nextDouble();
        System.out.print("Width: ");
        double width = scanner.nextDouble();
        Rectangle rectangle = new Rectangle(length, width);

        System.out.println("\nEnter dimensions for Triangle:");
        System.out.print("Base: ");
        double base = scanner.nextDouble();
        System.out.print("Height: ");
        double height = scanner.nextDouble();
        Triangle triangle = new Triangle(base, height);

        System.out.println("\nArea of Rectangle: " + rectangle.area());
        System.out.println("Area of Triangle: " + triangle.area());

        scanner.close();
    }
}

