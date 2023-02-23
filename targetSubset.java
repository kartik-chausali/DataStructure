// "static void main" must be defined in a public class.
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i = 0 ; i<n; i++){
            arr[i] = sc.nextInt();
        }
        int tar = sc.nextInt();
       
      targetSubset(arr, 0, "", 0, tar);
    }
    
    public static void targetSubset(int arr[], int i, String subset, int sumofset, int tar){
       
         if(i == arr.length){
             if(sumofset == tar){
                 System.out.println(subset);
                 return;
             }
             return;
         }
        
       
           targetSubset(arr, i+1,subset +arr[i] +"," ,arr[i]+sumofset, tar);
        targetSubset(arr, i+1, subset, sumofset, tar);
           
       
    }
    
}