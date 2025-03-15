
import java.util.*;
public class matrix {
       
    
        public static void main(String[] args) {
            Scanner scan=new Scanner(System.in);
            int a[][]=new int[2][2];
            int b[][]=new int[2][2];
            int c[][]=new int[2][2];
            System.out.println("enter the 1st 2*2 matrix:");
            for(int i=0;i<2;i++){
                for(int j=0;j<2;j++){
                    a[i][j]=scan.nextInt();
                }
                System.out.println(" ");
            }
            System.out.println("enter the 2nd 2*2 matrix:");
            for(int i=0;i<2;i++){
                for(int j=0;j<2;j++){
                    b[i][j]=scan.nextInt();
                }
                System.out.println(" ");
            }
            System.out.println("Addition of  matrix:");
            for(int i=0;i<2;i++){
                for(int j=0;j<2;j++){
                    c[i][j]=a[i][j]+b[i][j];
                    System.out.print(c[i][j]+"\t");

                }
                System.out.println();

                
            }

        }
    }