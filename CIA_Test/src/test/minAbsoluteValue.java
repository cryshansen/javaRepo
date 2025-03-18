package test;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class minAbsoluteValue {

	 static void minimumBribes(int[] q) {
	        int solve = 0;
	        int bribes = 0;
	       
	        boolean chaotic = false;
	        //assuming its in sort order
	        for(int i=0; i < q.length; i++){  
	           if((i+1) < q.length) {

	            solve = q[i] - q[i+1];
	           
	            if(solve ==1) bribes++;
	            if(solve ==2) bribes+=2;
	            if(solve > 2)chaotic = true;

	           }


	         }
	        if(chaotic){
	            System.out.println("Too chaotic");
	        }else{
	            System.out.println(bribes);
	        }
	    }

	 static int hourglassSum(int[][] arr) {
	        int len = arr.length;
	        int highest =0;
	        
	        for(int i=0;i<len;i++){
	            for(int j=0;j<len;j++){
	                if(((j+2) < len) && ((i+2) < len)){
	                    int totalR1 = arr[i][j] + arr[i][j+1] + arr[i][j+2];
	                    int totalR2 =  arr[i+1][j+1];
	                    int totalR3 = arr[i+2][j] + arr[i+2][j+1] + arr[i+2][j+2];
	                    int summer = totalR1 + totalR2 + totalR3;
	                    
	                    if(highest <= summer){
	                        highest = summer;
	                    }
	                }
	                
	            }
	        }
	        return highest;
	    }





    // Complete the minimumAbsoluteDifference function below.
    static int minimumAbsoluteDifference(int[] arr) {
    	//1 sort array
        Arrays.sort(arr);
        //get length of array
        int n= arr.length;
        System.out.println(n);
        int sum = 0;
        sum += Math.abs(arr[0] - arr[1]);
        //get last and second last comparision
        sum += Math.abs(arr[n-1] - arr[n-2]);
        for(int i=1;i<n-1;i++){
            System.out.println(Math.min(Math.abs(arr[i] - arr[i-1]),Math.abs(arr[i] - arr[i+1])));
            sum += Math.min(Math.abs(arr[i] - arr[i-1]),Math.abs(arr[i] - arr[i+1]));
        }
       return sum;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
       // BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

//        int n = scanner.nextInt();
//        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//
//        int[] arr = new int[n];
//
//        String[] arrItems = scanner.nextLine().split(" ");
//        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//
//        for (int i = 0; i < n; i++) {
//            int arrItem = Integer.parseInt(arrItems[i]);
//            arr[i] = arrItem;
//        }

    	
    	int[] arr1 = {3 ,-7 ,0};
    	int[] arr2 = {1, -3,71, 68, 17};
    	int[] arr3 = {-59, -36 ,-13 ,1 ,-53, -92, -2 ,-96, -54, 75};
    	
        int result = minimumAbsoluteDifference(arr1);
        int result2 = minimumAbsoluteDifference(arr2);
        int result3 = minimumAbsoluteDifference(arr3);
        System.out.println(result + " : "  + result2 + " : "  + result3);
//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//
//        bufferedWriter.close();

        scanner.close();
    }
    
    import java.io.*;
    import java.util.*;

    public class Solution {
        private static final Scanner scanner = new Scanner(System.in);
        public static void main(String[] args) {
            /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */

            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
           
            int[] c2Sort = new int[n];

            String[] cItems = scanner.nextLine().split(" ");
            //Arrays.sort(cItems);
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            int m = cItems.length;
            double mean = 0; double median=0;
            double total=0;
            int mode=0, meanRange =0;
            
            
            for (int i = 0; i < cItems.length; i++) {
                int cItem = Integer.parseInt(cItems[i]);
                c2Sort[i] = cItem;
                total = cItem + total;
                if(i == 0){mode = cItem;}
                if(cItem<mode){ mode = cItem;}
            }
      
            scanner.close();
            
            
            mean = total/n;
            Arrays.sort(c2Sort);

            //if odd array list say 7 answer would be three and two so must compare for that by add 1 to it for proper range of median? 
            if((n%2)==0){ meanRange = n/2;
            }else {meanRange = n/2+1;}
            median = ((double)(c2Sort[meanRange-1] + c2Sort[meanRange]))/2;

               
            System.out.println(mean);
            System.out.println(median);
            System.out.println(mode); 


        }
    } 
    
    
    
    
    
    
    
    
}
