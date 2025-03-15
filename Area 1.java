import java.util.*;
class Area{
  float length = 0;
  float width = 0;
  Scanner sc = new Scanner(System.in);
  void setDim(){
  System.out.println("Enter the length of rectangle: ");
  length = sc.nextFloat();
  System.out.println("Enter the width of rectangle: ");
  width = sc.nextFloat();
  }
  void getArea(){
   float area = length * width;
   System.out.println("The area of rectangle is: " +area);
   }
   
  public static void main(String[] ar){
    Area a = new Area();
    a.setDim();
    a.getArea();
  }
  }
