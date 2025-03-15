import java.util.*;
class operations{
 Scanner scan = new Scanner(System.in);
  //System.out.println("Enter the size of a stack: ");
  int size = scan.nextInt();
  int[] stack = new int[size];
  int i, element;
  int top = -1;
  
  void push(){
    if(top == size -1){
     System.out.println("stack is full");
     }
     else{
     System.out.println("Enter the element of a stack");
      element = scan.nextInt();
      top++;
      stack[top] = element;
      }
    }
  
  void pop(){
    if(top == -1){
     System.out.println("stack is empty");
     }
    else{
     element = stack[top]; 
     top--;
     System.out.println("The poped element is: " +element);
     }
    }
    
  void display(){
   if(top == -1 ){
     System.out.println("stack is empty");
     }
    else{
      System.out.println("The elements are: ");
      for(int i =top; i >= 0; i--){
       System.out.println(stack[i]);
       top--;
      }
    }
  }
}
  
 class Stack{
  public static void main(String[] ar){
   Scanner sc = new Scanner(System.in);
     operations obj = new operations();
     
     
    int choice;
     while(true){
     System.out.println("1.Push");
     System.out.println("3.display");
     System.out.println("2.pop");
     System.out.println("Enter the option");
     choice = sc.nextInt();
     
     switch(choice){
     case 1:
      obj.push();
      break;
     case 2:
      obj.display();
      break;
    case 3:
     obj.pop();
     break;
    case 4:System.exit(0);
    }
    }
    }
  }
