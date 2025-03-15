    
import java.util.*;
public class multimatrix {
       
    
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
            System.out.println("multiplication of  matrix:");
            for(int i=0;i<2;i++){
                for(int j=0;j<2;j++){
                    c[i][j]=a[i][0]*b[0][j]+a[i][1]*b[1][j];
                    System.out.print(c[i][j]+"\t");

                }
                System.out.println();

                
            }

        }
    }
