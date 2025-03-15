import java.util.*;
public class merge {
    public static void merged(int a[],int b[],int c[]) {
        int i=0;
        int j=0;
        int k=0;
        while (i<4 && j<3) {
            if(a[i]<b[j]){
                c[k]=a[i];
                i++;
                k++;
            }
            else{
                c[k]=b[j];
                j++;
                k++;

            }
            
        }
        while (i<4) {
            c[k]=a[i];
            i++;
            k++;
            
        }
        while (j<3) {
            c[k]=b[j];
            j++;
            k++;
            
        }
        System.out.println("sorted arry");
            for(int i=0;i<k;i++){
            System.out.print(c[i]+"");
        }
        

        
    }
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        int a[]=new int[4];
        int b[]=new int[3];
        int c[]=new int[7];
        
        
        System.out.println("enter the array a:");
        for(int i=0;i<4;i++){
            a[i]=scan.nextInt();
        }
        System.out.println("enter the array b:");
        for(int j=0;j<3;j++){
            b[j]=scan.nextInt();
        }
        merged(a, b,c);
        
            
        
        
    }
}
